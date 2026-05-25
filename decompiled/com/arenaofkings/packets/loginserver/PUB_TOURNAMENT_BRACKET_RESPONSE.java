/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.loginserver.TournamentMatchData;
import com.arenaofkings.packets.misc.PublicPacket;
import java.util.ArrayList;

public class PUB_TOURNAMENT_BRACKET_RESPONSE
extends PublicPacket {
    public int tournament_id;
    public int total_rounds;
    public ArrayList<TournamentMatchData> data = new ArrayList();

    @Override
    public void handle(Engine engine) {
        we we2 = (we)engine.axc_a();
        aaf aaf2 = we2.wh_a().zi_a().aaf_a();
        aab aab2 = aaf2.a(this.tournament_id);
        if (aab2 != null) {
            aab2.a(this.data);
        }
    }
}

