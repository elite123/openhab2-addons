/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.geniushub;

import java.util.Set;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

import com.google.common.collect.Sets;

/**
 * The {@link GeniusHubBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Garth Bushell - Initial contribution
 */
public class GeniusHubBindingConstants {

    public static final String GENIUSHUB_URL = "https://hub-server-1.heatgenius.co.uk";

    private static final String BINDING_ID = "geniushub";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_GENIUSHUB_BRIDGE = new ThingTypeUID(BINDING_ID, "hub");
    public static final ThingTypeUID THING_TYPE_GENIUSHUB_ZONE = new ThingTypeUID(BINDING_ID, "zone");

    // List of all Channel ids
    public static final String CHANNEL_TEMP = "temp";
    public static final String CHANNEL_SETTEMP = "settemp";
    public static final String CHANNEL_REFRESHINTERVAL = "RefreshInterval";

    // Bridge config properties
    public static final String USER_NAME = "username";
    public static final String PASSWORD = "password";

    // Zone config properties
    public static final String ZONE_NAME = "name";
    public static final String ZONE_ID = "id";

    public static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Sets.newHashSet(THING_TYPE_GENIUSHUB_BRIDGE,
            THING_TYPE_GENIUSHUB_ZONE);
}
