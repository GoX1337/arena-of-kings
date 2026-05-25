/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_LOGIN_LOGIN_CHECK_USERNAME_VALID_RESPONSE
extends PublicPacket {
    private String username;
    private boolean valid;

    @Override
    public void handle(Engine engine) {
    }
}

