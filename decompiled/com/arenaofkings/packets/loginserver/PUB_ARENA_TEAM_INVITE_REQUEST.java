/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_ARENA_TEAM_INVITE_REQUEST
extends PublicPacket {
    private String team_name;
    private String invite_name;

    public PUB_ARENA_TEAM_INVITE_REQUEST() {
    }

    public PUB_ARENA_TEAM_INVITE_REQUEST(String string, String string2) {
        this.team_name = string;
        this.invite_name = string2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

