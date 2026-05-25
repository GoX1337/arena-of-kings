/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.PUB_GAME_STATUS_UPDATE;
import com.arenaofkings.packets.gameserver.data.GameStatus;
import com.arenaofkings.packets.misc.PublicPacket;

public class PUB_RATING_CHANGE
extends PublicPacket {
    private int rating;
    private int soloRating;
    private int wins;
    private int losses;
    private int fame;
    private int fameForWin;
    private int silver;
    private int experience;
    private int ranked_wins;
    private int ranked_losses;
    private int ranked_solo_wins;
    private int ranked_solo_losses;
    private int display_rating;
    private int dailyGames;
    private int weeklyGames;
    private int arenaPoints;

    @Override
    public void handle(Engine engine) {
        if (ay.ay_a() == null) {
            engine.var_ag_a.g();
            engine.var_z_a.d();
        }
        if (ay.ay_a().gd_a() == null) {
            engine.var_ag_a.g();
            engine.var_z_a.d();
        }
        ay.ay_a().gd_a().c(this.wins);
        ay.ay_a().gd_a().b(this.losses);
        ay.ay_a().gd_a().d(this.fame);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().n(this.ranked_solo_wins);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().o(this.ranked_solo_losses);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().p(this.display_rating);
        if (this.silver >= 0) {
            ay.ay_a().gd_a().f(this.silver);
        }
        if (this.fameForWin > 0) {
            ay.ay_a().gd_a().h(this.fameForWin);
            if (t.a(agd.class, engine)) {
                ((agd)engine.axc_a()).a(0);
                ((agd)engine.axc_a()).azv_a().void_b();
                ((agd)engine.axc_a()).c(true);
            }
        } else {
            Engine.b("Fake update out");
            ay.ay_a().gd_a().h(0);
            PUB_GAME_STATUS_UPDATE pUB_GAME_STATUS_UPDATE = new PUB_GAME_STATUS_UPDATE();
            pUB_GAME_STATUS_UPDATE.setGameStatus(GameStatus.ENDED);
            pUB_GAME_STATUS_UPDATE.handle(engine);
        }
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().j(this.rating);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().k(this.soloRating);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().c(this.dailyGames);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().d(this.weeklyGames);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().m(this.ranked_wins);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().l(this.ranked_losses);
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().b(this.arenaPoints);
        System.out.println("The arena points are: " + this.arenaPoints);
    }
}

