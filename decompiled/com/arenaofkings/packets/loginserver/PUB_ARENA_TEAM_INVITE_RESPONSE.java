/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_ARENA_TEAM_INVITE_RESPONSE
extends PublicPacket {
    private boolean join;

    public PUB_ARENA_TEAM_INVITE_RESPONSE() {
    }

    public PUB_ARENA_TEAM_INVITE_RESPONSE(boolean bl2) {
        this.join = bl2;
    }

    @Override
    public void handle(Engine engine) {
    }
}

