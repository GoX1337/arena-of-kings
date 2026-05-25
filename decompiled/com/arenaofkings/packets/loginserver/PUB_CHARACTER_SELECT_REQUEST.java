/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_CHARACTER_SELECT_REQUEST
extends PublicPacket {
    private String character_name;

    public PUB_CHARACTER_SELECT_REQUEST() {
    }

    public PUB_CHARACTER_SELECT_REQUEST(String string) {
        this.character_name = string;
    }

    @Override
    public void handle(Engine engine) {
    }
}

