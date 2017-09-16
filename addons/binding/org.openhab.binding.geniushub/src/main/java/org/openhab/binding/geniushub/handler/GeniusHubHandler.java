/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.geniushub.handler;

import static org.openhab.binding.geniushub.GeniusHubBindingConstants.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.smarthome.config.core.status.ConfigStatusMessage;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.eclipse.smarthome.core.thing.binding.ConfigStatusBridgeHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.geniushub.client.Client;
import org.openhab.binding.geniushub.client.Zone;
import org.openhab.binding.geniushub.client.Zones;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link GeniusHubHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Garth Bushell - Initial contribution
 */
public class GeniusHubHandler extends ConfigStatusBridgeHandler {

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        super.dispose();
        refreshJob.cancel(true);
    }

    private final Logger logger = LoggerFactory.getLogger(GeniusHubHandler.class);

    private ScheduledFuture<?> refreshJob;

    Client client;

    public Client getClient() {
        return this.client;
    }

    public GeniusHubHandler(@NonNull Bridge thing) {
        super(thing);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        if (channelUID.getId().equals(CHANNEL_REFRESHINTERVAL)) {
            // TODO: handle command

            // Note: if communication with thing fails for some reason,
            // indicate that by setting the status with detail information
            // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
            // "Could not control device at IP address x.x.x.x");
        }
    }

    @Override
    public void initialize() {
        logger.debug("UserName:{}", this.getConfig().get(USER_NAME));
        logger.debug("Password:{}", this.getConfig().get(PASSWORD));
        logger.debug(this.getConfig().toString());
        client = new Client((String) this.getConfig().get(USER_NAME), (String) this.getConfig().get(PASSWORD));

        updateThings();

        refreshJob = scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                updateThings();
            }
        }, 59, 59, TimeUnit.SECONDS);

    }

    private void updateThings() {
        if (client.Auth()) {
            updateStatus(ThingStatus.ONLINE);
            Zones zones = this.getClient().getZones();
            for (Iterator<Zone> iterator = zones.getData().iterator(); iterator.hasNext();) {
                Zone zone = iterator.next();
                logger.debug(zone.getStrName());

                ThingUID bridgeUID = getThing().getUID();
                ThingUID thingUID = new ThingUID(THING_TYPE_GENIUSHUB_ZONE, bridgeUID, String.valueOf(zone.getIID()));

                GeniusHubZoneHandler zoneThing = (GeniusHubZoneHandler) this.getThingByUID(thingUID).getHandler();
                if (zoneThing != null) {
                    logger.debug("Updating zone {}", thingUID);
                    zoneThing.updateZone(zone);
                } else {
                    logger.debug("Can't find zone {} to update", thingUID);
                }
            }
        } else {
            logger.error("Failed to update things due to auth");
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
                    "Failed to update things due to auth");
        }

    }

    @Override
    public Collection<ConfigStatusMessage> getConfigStatus() {
        // The bridge IP address to be used for checks
        final String username = (String) getThing().getConfiguration().get(USER_NAME);
        Collection<ConfigStatusMessage> configStatusMessages;

        // Check whether an username is provided
        if (username == null || username.isEmpty()) {
            configStatusMessages = Collections.singletonList(ConfigStatusMessage.Builder.error(USER_NAME)
                    .withMessageKeySuffix("Username is not set").withArguments(USER_NAME).build());
        } else {
            configStatusMessages = Collections.emptyList();
        }

        return configStatusMessages;
    }
}
