/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;

public class PlayerForcedPositionUpdate
extends PlayerSnapshot {
    private float x;
    private float y;

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.a("forced update received ");
        if (string == null || ay.ay_a().br_a(string) == ay.ay_a()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().ar_a().void_a();
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().b(false);
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().void_a(this.x, this.y);
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().b(0.0f);
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().c(0.0f);
            Engine.a("Forced position update for ME  x: " + this.x + " y: " + this.y);
        } else {
            br br2 = ay.ay_a().br_a(string);
            if (br2 != null) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().ar_a().void_a();
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().void_a(this.x, this.y);
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().b(0.0f);
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().c(0.0f);
                Engine.a("Forced position update for username: " + string + " x: " + this.x + " y: " + this.y);
            }
        }
        Engine.a("forced update out");
    }
}

