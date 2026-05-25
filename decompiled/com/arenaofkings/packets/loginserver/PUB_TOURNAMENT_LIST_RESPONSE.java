/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.TournamentData;
import java.util.ArrayList;

public class PUB_TOURNAMENT_LIST_RESPONSE
extends PublicPacket {
    private ArrayList<TournamentData> tournaments = new ArrayList();

    @Override
    public void handle(Engine engine) {
        Engine.b("PUB_TOURNAMENT_LIST_RESPONSE");
        for (TournamentData tournamentData : this.tournaments) {
            Engine.b("Tournament: " + tournamentData);
        }
        ay.ay_a().gd_a().a().clear();
        for (TournamentData tournamentData : this.tournaments) {
            ay.ay_a().gd_a().a().add(new zz(tournamentData));
        }
        ((we)engine.axc_a()).wh_a().zi_a().aaf_a().e();
    }
}

