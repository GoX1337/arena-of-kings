/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_ARENA_TEAM_REMOVE
extends PublicPacket {
    private String arenaTeamName;

    public PUB_ARENA_TEAM_REMOVE() {
    }

    public PUB_ARENA_TEAM_REMOVE(String string) {
        this.arenaTeamName = string;
    }

    @Override
    public void handle(Engine engine) {
        if (this.arenaTeamName != null) {
            if (t.a(agd.class, engine)) {
                ((agd)engine.axc_a()).agn_a().i_a().a("You are no longer in Arena Team '" + this.arenaTeamName + "'.");
            } else if (t.a(we.class, engine)) {
                ((we)engine.axc_a()).wh_a().wg_a().a("You are no longer in Arena Team '" + this.arenaTeamName + "'.");
            }
            ay.ay_a().gd_a().a(this.arenaTeamName);
        }
    }
}

