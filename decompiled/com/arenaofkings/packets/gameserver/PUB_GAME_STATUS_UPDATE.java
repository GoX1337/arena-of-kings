/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.GameStatus;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.ReadyStatus;
import java.util.ArrayList;

public class PUB_GAME_STATUS_UPDATE
extends PublicPacket {
    private GameStatus gameStatus;
    boolean rankedGame;

    public PUB_GAME_STATUS_UPDATE() {
        System.out.println("Made a fake status update");
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public void handle(Engine engine) {
        Engine.b("Game " + (Object)((Object)this.gameStatus));
        switch (this.gameStatus) {
            case ENDED: {
                Engine.a("Game has ended. Returning to Lobby");
                ay.ay_a().gf_a().a(1);
                engine.var_ag_a.a(false);
                ArrayList<String> arrayList = new ArrayList<String>();
                for (br object : ay.ay_a().gf_a().a().values()) {
                    object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(ReadyStatus.RED);
                    if (!object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a().contains(" Bot")) continue;
                    arrayList.add(object.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a());
                }
                for (br br2 : ay.ay_a().ge_a().a().values()) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(ReadyStatus.RED);
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().cy_a().a(false);
                }
                for (String string : arrayList) {
                    ay.ay_a().gf_a().b(engine, string);
                }
                if (ay.ay_a().gd_a() == null) {
                    return;
                }
                if (ay.ay_a().gd_a().boolean_b()) {
                    ay.ay_a().gf_a().a(engine, true);
                }
                ay.ay_a().gf_a().a(ay.ay_a());
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().void_c();
                ay.ay_a().gd_a().a(false);
                System.out.println("panel to open: " + ay.ay_a().gd_a().i());
                engine.a(xw.class, new xz(1, ay.ay_a().gd_a().i()));
                break;
            }
            case PAUSED: {
                break;
            }
        }
    }
}

