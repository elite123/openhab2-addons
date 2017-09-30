/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.minecraftvanilla.internal;

import static org.openhab.binding.minecraftvanilla.MinecraftVanillaBindingConstants.*;

import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory;
import org.openhab.binding.minecraftvanilla.handler.MinecraftPlayer;
import org.openhab.binding.minecraftvanilla.handler.MinecraftVanillaHandler;
import org.osgi.service.component.annotations.Component;

/**
 * The {@link MinecraftVanillaHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Garth Bushell - Initial contribution
 */
@Component(service = ThingHandlerFactory.class, immediate = true, configurationPid = "binding.minecraftvanilla")
public class MinecraftVanillaHandlerFactory extends BaseThingHandlerFactory {

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(THING_TYPE_MINECRAFT_SERVER)) {
            return new MinecraftVanillaHandler((Bridge) thing);
        }

        if (thingTypeUID.equals(THING_TYPE_MINECRAFT_PLAYER)) {
            return new MinecraftPlayer(thing);
        }

        return null;
    }
}
