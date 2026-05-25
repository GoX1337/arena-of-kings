/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_TOURNAMENT_TEAMS_REQUEST
extends PublicPacket {
    private int tournament_id;

    public PUB_TOURNAMENT_TEAMS_REQUEST() {
    }

    public PUB_TOURNAMENT_TEAMS_REQUEST(int n2) {
        this.tournament_id = n2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

