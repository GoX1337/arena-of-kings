/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.ScoreboardUpdate;
import com.arenaofkings.packets.misc.GameType;
import com.arenaofkings.packets.misc.PublicPacket;
import com.badlogic.gdx.utils.Array;

public class PUB_GAME_SCOREBOARD_UPDATE
extends PublicPacket {
    private Array<ScoreboardUpdate> scoreboardUpdates = new Array();

    @Override
    public void handle(Engine engine) {
        System.out.println("Sbupdate");
        Engine.a("scoreboard update! " + this.scoreboardUpdates.size);
        this.scoreboardUpdates.sort();
        if (t.a(agd.class, engine)) {
            ((agd)engine.axc_a()).var_ajt_a.a(engine, this.scoreboardUpdates);
            if (ay.ay_a().gd_a().com_arenaofkings_packets_misc_GameType_a() != GameType.TUTORIAL_DPS && ay.ay_a().gd_a().com_arenaofkings_packets_misc_GameType_a() != GameType.TUTORIAL_HEALER) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(engine, 200, false, false);
            }
        }
    }
}

