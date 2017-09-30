/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.minecraftvanilla;

import java.util.Set;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

import com.google.common.collect.Sets;

/**
 * The {@link MinecraftVanillaBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Garth Bushell - Initial contribution
 */
public class MinecraftVanillaBindingConstants {

    private static final String BINDING_ID = "minecraftvanilla";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_MINECRAFT_SERVER = new ThingTypeUID(BINDING_ID, "server");
    public static final ThingTypeUID THING_TYPE_MINECRAFT_PLAYER = new ThingTypeUID(BINDING_ID, "player");
    // List of all Channel ids
    public static final String CHANNEL_ONLINE = "online";

    // Bridge config properties
    public static final String CONFIG_SERVER_ADDRESS = "address";
    public static final String CONFIG_SERVER_PORT = "port";
    public static final String CONFIG_USERNAME = "username";
    public static final String CONFIG_PASSWORD = "password";

    public static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Sets.newHashSet(THING_TYPE_MINECRAFT_SERVER,
            THING_TYPE_MINECRAFT_PLAYER);
}
