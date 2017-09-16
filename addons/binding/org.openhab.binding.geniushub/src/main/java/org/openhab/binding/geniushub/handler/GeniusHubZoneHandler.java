package org.openhab.binding.geniushub.handler;

import static org.openhab.binding.geniushub.GeniusHubBindingConstants.*;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.smarthome.core.library.types.DecimalType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.geniushub.client.Zone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeniusHubZoneHandler extends BaseThingHandler {

    private final Logger logger = LoggerFactory.getLogger(GeniusHubZoneHandler.class);
    private Zone zone = null;

    public GeniusHubZoneHandler(@NonNull Thing thing) {
        super(thing);
    }

    @Override
    public void initialize() {
        updateStatus(ThingStatus.ONLINE);
    }

    @Override
    public void handleCommand(@NonNull ChannelUID channelUID, Command command) {
        if (channelUID.getId().equals(CHANNEL_TEMP)) {
            logger.debug("TEMP CHANNEL {} Recived msg:{}", channelUID, command);
        }
    }

    public void updateZone(Zone zone) {
        // FIXME:bleah

        if (this.zone != null) {
            logger.debug("updateZone:{}:{}:{}", this.zone.getFPV(), zone.getFPV(),
                    this.zone.getFPV().equals(zone.getFPV()));
        }
        if ((this.zone != null) && (!this.zone.getFPV().equals(zone.getFPV()))) {
            updateState(new ChannelUID(getThing().getUID(), CHANNEL_TEMP), new DecimalType(zone.getFPV()));
        }
        if ((this.zone != null) && (!this.zone.getFSP().equals(zone.getFSP()))) {
            updateState(new ChannelUID(getThing().getUID(), CHANNEL_SETTEMP), new DecimalType(zone.getFSP()));
        }
        this.zone = zone;
    }

}
