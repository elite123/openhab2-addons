/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.minecraftvanilla.handler;

import static org.openhab.binding.minecraftvanilla.MinecraftVanillaBindingConstants.*;

import java.net.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.smarthome.config.core.status.ConfigStatusMessage;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.binding.ConfigStatusBridgeHandler;
import org.eclipse.smarthome.core.types.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.steveice10.mc.protocol.MinecraftConstants;
import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.mc.protocol.data.SubProtocol;
import com.github.steveice10.mc.protocol.data.status.ServerStatusInfo;
import com.github.steveice10.mc.protocol.data.status.handler.ServerInfoHandler;
import com.github.steveice10.mc.protocol.data.status.handler.ServerPingTimeHandler;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;

/**
 * The {@link MinecraftVanillaHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Garth Bushell - Initial contribution
 */
public class MinecraftVanillaHandler extends ConfigStatusBridgeHandler {

    private final Logger logger = LoggerFactory.getLogger(MinecraftVanillaHandler.class);

    private ScheduledFuture<?> refreshJob;

    public MinecraftVanillaHandler(@NonNull Bridge thing) {
        super(thing);
    }

    @Override
    public void initialize() {
        logger.debug("Server:{}", this.getConfig().get(CONFIG_SERVER_ADDRESS));
        logger.debug("Port:{}", this.getConfig().get(CONFIG_SERVER_PORT));
        logger.debug(this.getConfig().toString());
        updatePlayers();
        refreshJob = scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                updatePlayers();
            }

        }, 59, 59, TimeUnit.SECONDS);

    }

    private void updatePlayers() {
        MinecraftProtocol protocol = new MinecraftProtocol(SubProtocol.STATUS);
        Client client = new Client((String) this.getConfig().get(CONFIG_SERVER_ADDRESS),
                Integer.parseInt(this.getConfig().get(CONFIG_SERVER_PORT).toString()), protocol,
                new TcpSessionFactory(Proxy.NO_PROXY));
        client.getSession().setFlag(MinecraftConstants.AUTH_PROXY_KEY, Proxy.NO_PROXY);
        client.getSession().setFlag(MinecraftConstants.SERVER_INFO_HANDLER_KEY, new ServerInfoHandler() {
            @Override
            public void handle(Session session, ServerStatusInfo info) {
                System.out.println("Version: " + info.getVersionInfo().getVersionName() + ", "
                        + info.getVersionInfo().getProtocolVersion());
                System.out.println("Player Count: " + info.getPlayerInfo().getOnlinePlayers() + " / "
                        + info.getPlayerInfo().getMaxPlayers());
                System.out.println("Players: " + Arrays.toString(info.getPlayerInfo().getPlayers()));
                System.out.println("Description: " + info.getDescription().getFullText());
                System.out.println("Icon: " + info.getIcon());
            }
        });

        client.getSession().setFlag(MinecraftConstants.SERVER_PING_TIME_HANDLER_KEY, new ServerPingTimeHandler() {
            @Override
            public void handle(Session session, long pingTime) {
                System.out.println("Server ping took " + pingTime + "ms");
            }
        });

        client.getSession().connect();
        while (client.getSession().isConnected()) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");
    }

    @Override
    public Collection<ConfigStatusMessage> getConfigStatus() {
        // The bridge IP address to be used for checks
        final String username = (String) getThing().getConfiguration().get(CONFIG_USERNAME);
        Collection<ConfigStatusMessage> configStatusMessages;

        // Check whether an username is provided
        if (username == null || username.isEmpty()) {
            configStatusMessages = Collections.singletonList(ConfigStatusMessage.Builder.error(CONFIG_USERNAME)
                    .withMessageKeySuffix("Username is not set").withArguments(CONFIG_USERNAME).build());
        } else {
            configStatusMessages = Collections.emptyList();
        }

        return configStatusMessages;
    }

    @Override
    public void handleCommand(@NonNull ChannelUID channelUID, Command command) {
        // TODO Auto-generated method stub

    }

}
