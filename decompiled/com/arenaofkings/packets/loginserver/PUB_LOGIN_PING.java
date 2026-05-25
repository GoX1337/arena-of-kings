/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_LOGIN_PING
extends PublicPacket {
    private String data = "data";

    @Override
    public void handle(Engine engine) {
        Engine.b("login ping");
        engine.var_z_a.org_java_websocket_client_WebSocketClient_a().sendPing();
    }
}

