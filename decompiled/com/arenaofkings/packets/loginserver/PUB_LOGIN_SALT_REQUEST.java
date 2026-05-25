/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_LOGIN_SALT_REQUEST
extends PublicPacket {
    public String username;
    public String version;

    public PUB_LOGIN_SALT_REQUEST(String string, String string2) {
        this.username = string;
        this.version = string2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

