/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_ARENA_TEAM_UNLOCK_REQUEST
extends PublicPacket {
    private String item;
    private String name;
    private String tag;
    private String country;
    private String logo;

    public PUB_ARENA_TEAM_UNLOCK_REQUEST() {
    }

    public PUB_ARENA_TEAM_UNLOCK_REQUEST(String string, String string2, String string3, String string4, String string5) {
        this.item = string;
        this.name = string2;
        this.tag = string3;
        this.country = string4;
        this.logo = string5;
    }

    @Override
    public void handle(Engine engine) {
    }
}

