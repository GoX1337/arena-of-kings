/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ArenaTeamData;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_ARENA_TEAM_CREATE
extends PublicPacket {
    private ArenaTeamData arenaTeamData;

    @Deprecated
    public PUB_ARENA_TEAM_CREATE() {
    }

    @Override
    public void handle(Engine engine) {
        if (this.arenaTeamData != null) {
            if (t.a(agd.class, engine)) {
                ((agd)engine.axc_a()).agn_a().i_a().a("You have joined " + this.arenaTeamData.name + ".");
            } else if (t.a(we.class, engine)) {
                ((we)engine.axc_a()).wh_a().wg_a().a("You have joined " + this.arenaTeamData.name + ".");
            }
            zg zg2 = new zg(this.arenaTeamData);
            ay.ay_a().gd_a().a(zg2);
            ((we)engine.axc_a()).wh_a().zi_a().zu_a().a(true);
        }
    }
}

