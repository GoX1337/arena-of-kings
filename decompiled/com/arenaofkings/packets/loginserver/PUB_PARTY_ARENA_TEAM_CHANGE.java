/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.ArenaTeamData;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_PARTY_ARENA_TEAM_CHANGE
extends PublicPacket {
    public ArenaTeamData arenaTeamData;

    @Override
    public void handle(Engine engine) {
        zg zg2 = null;
        for (zg zg3 : ay.ay_a().gd_a().a()) {
            if (!zg3.java_lang_String_a().equals(this.arenaTeamData.name)) continue;
            zg2 = zg3;
            break;
        }
        if (zg2 == null) {
            zg2 = new zg(this.arenaTeamData);
        }
        ay.ay_a().gd_a().b(zg2);
        if (t.a(we.class, engine)) {
            we we2 = (we)engine.axc_a();
            we2.wh_a().yg_b().a(zg2, true, false);
        }
    }
}

