/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_TOURNAMENT_ROUND_START
extends PublicPacket {
    private String msg;
    private int myTeamScore;
    private int enemyTeamScore;

    public PUB_TOURNAMENT_ROUND_START() {
    }

    public PUB_TOURNAMENT_ROUND_START(String string, int n2, int n3) {
        this.msg = string;
        this.myTeamScore = n2;
        this.enemyTeamScore = n3;
    }

    @Override
    public void handle(Engine engine) {
        Engine.b("RRR " + this.toString());
        ay.ay_a().gd_a().a(this.myTeamScore, this.enemyTeamScore);
        if (this.msg.contains("has been eliminated")) {
            ay.ay_a().gd_a().c(false);
        } else {
            ay.ay_a().gd_a().c(true);
        }
        if (t.a(we.class, engine)) {
            we we2 = (we)engine.axc_a();
            wg wg2 = we2.wh_a().wg_a();
            wg2.a(this.msg);
            we2.wh_a().f();
        } else if (t.a(agd.class, engine)) {
            ((agd)engine.axc_a()).agn_a().i_a().a(this.msg);
        }
    }

    public String toString() {
        return "PUB_TOURNAMENT_ROUND_START [msg=" + this.msg + ", myTeamScore=" + this.myTeamScore + ", enemyTeamScore=" + this.enemyTeamScore + "]";
    }
}

