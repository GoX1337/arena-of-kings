/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_CHARACTER_CREATION_REQUEST
extends PublicPacket {
    private String character_class;
    private String character_name;

    public PUB_CHARACTER_CREATION_REQUEST(String string, String string2) {
        this.character_name = string;
        this.character_class = string2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

