/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_UNLOCK_REQUEST
extends PublicPacket {
    private String item;

    public PUB_UNLOCK_REQUEST() {
    }

    public PUB_UNLOCK_REQUEST(String string) {
        this.item = string;
    }

    @Override
    public void handle(Engine engine) {
    }
}

