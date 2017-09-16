package org.openhab.binding.geniushub.discovery;

import static org.openhab.binding.geniushub.GeniusHubBindingConstants.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.smarthome.config.discovery.AbstractDiscoveryService;
import org.eclipse.smarthome.config.discovery.DiscoveryResult;
import org.eclipse.smarthome.config.discovery.DiscoveryResultBuilder;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.openhab.binding.geniushub.client.Zone;
import org.openhab.binding.geniushub.client.Zones;
import org.openhab.binding.geniushub.handler.GeniusHubHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeniusHubRoomDiscovery extends AbstractDiscoveryService {

    private static final int TIMEOUT = 5;

    private Logger logger = LoggerFactory.getLogger(GeniusHubRoomDiscovery.class);

    GeniusHubHandler bridge;

    public GeniusHubRoomDiscovery(GeniusHubHandler bridge) {
        // Sort out background later
        super(SUPPORTED_THING_TYPES_UIDS, TIMEOUT, false);
        logger.debug("GeniusHubRoomDiscovery {}", bridge);
        this.bridge = bridge;
    }

    @Override
    protected void startScan() {
        // TODO Auto-generated method stub
        logger.debug("GeniusHubRoomDiscovery startscan {}", this.bridge);

        Zones zones = this.bridge.getClient().getZones();
        for (Iterator<Zone> iterator = zones.getData().iterator(); iterator.hasNext();) {
            Zone zone = iterator.next();
            // FIXME: CONSTANTS in CLIENT
            if (zone.getIType() == 3) { // ROOM
                logger.debug(zone.getStrName());

                ThingUID bridgeUID = bridge.getThing().getUID();
                ThingUID thingUID = new ThingUID(THING_TYPE_GENIUSHUB_ZONE, bridgeUID, String.valueOf(zone.getIID()));
                Map<String, Object> properties = new HashMap<>(2);
                properties.put(ZONE_ID, zone.getIID());
                properties.put(ZONE_NAME, zone.getStrName());
                DiscoveryResult discoveryResult = DiscoveryResultBuilder.create(thingUID).withProperties(properties)
                        .withBridge(bridgeUID).withLabel(zone.getStrName()).build();
                thingDiscovered(discoveryResult);
            }
        }
    }
}
