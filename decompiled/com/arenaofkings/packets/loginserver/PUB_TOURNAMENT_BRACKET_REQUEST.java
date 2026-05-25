/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_TOURNAMENT_BRACKET_REQUEST
extends PublicPacket {
    private int tournament_id;
    private String arena_team_name;

    public PUB_TOURNAMENT_BRACKET_REQUEST() {
    }

    public PUB_TOURNAMENT_BRACKET_REQUEST(int n2) {
        this.tournament_id = n2;
        this.arena_team_name = this.arena_team_name;
    }

    @Override
    public void handle(Engine engine) {
    }
}

