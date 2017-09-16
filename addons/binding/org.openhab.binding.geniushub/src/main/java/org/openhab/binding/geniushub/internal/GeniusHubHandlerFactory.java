/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.geniushub.internal;

import static org.openhab.binding.geniushub.GeniusHubBindingConstants.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.smarthome.config.discovery.DiscoveryService;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory;
import org.openhab.binding.geniushub.discovery.GeniusHubRoomDiscovery;
import org.openhab.binding.geniushub.handler.GeniusHubHandler;
import org.openhab.binding.geniushub.handler.GeniusHubZoneHandler;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link GeniusHubHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Garth Bushell - Initial contribution
 */
@Component(service = ThingHandlerFactory.class, immediate = true, configurationPolicy = ConfigurationPolicy.OPTIONAL, name = "binding.geniushub")
public class GeniusHubHandlerFactory extends BaseThingHandlerFactory {

    private final Logger logger = LoggerFactory.getLogger(GeniusHubHandlerFactory.class);
    private Map<ThingUID, ServiceRegistration<?>> discoveryServiceRegs = new HashMap<>();

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        boolean ret = SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
        logger.debug("supportsThingType:{} = {}", thingTypeUID, ret);
        return ret;

    }

    @Override
    protected ThingHandler createHandler(Thing thing) {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(THING_TYPE_GENIUSHUB_BRIDGE)) {
            GeniusHubHandler bridge = new GeniusHubHandler((Bridge) thing);
            registerLightDiscoveryService(bridge);
            return bridge;
        } else if (thingTypeUID.equals(THING_TYPE_GENIUSHUB_ZONE)) {
            return new GeniusHubZoneHandler(thing);
        }

        return null;
    }

    private synchronized void registerLightDiscoveryService(GeniusHubHandler bridgeHandler) {
        GeniusHubRoomDiscovery discoveryService = new GeniusHubRoomDiscovery(bridgeHandler);
        this.discoveryServiceRegs.put(bridgeHandler.getThing().getUID(), bundleContext
                .registerService(DiscoveryService.class.getName(), discoveryService, new Hashtable<String, Object>()));
    }

    @Override
    protected synchronized void removeHandler(ThingHandler thingHandler) {
        if (thingHandler instanceof GeniusHubHandler) {
            ServiceRegistration<?> serviceReg = this.discoveryServiceRegs.get(thingHandler.getThing().getUID());
            if (serviceReg != null) {
                // remove discovery service, if bridge handler is removed
                GeniusHubRoomDiscovery service = (GeniusHubRoomDiscovery) bundleContext
                        .getService(serviceReg.getReference());
                // service.deactivate();
                serviceReg.unregister();
                discoveryServiceRegs.remove(thingHandler.getThing().getUID());
            }
        }
    }
}
