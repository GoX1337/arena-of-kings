/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.conveyed;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;

public class PlayerPositionUpdate
extends PlayerSnapshot {
    private float x;
    private float y;

    public PlayerPositionUpdate() {
    }

    public PlayerPositionUpdate(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.a("Player username: " + string + " PRE x: " + ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() + " y: " + ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + " isMoving: " + ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().boolean_b());
        br br2 = ay.ay_a().br_a(string);
        if (br2 != null) {
            if (t.a(agd.class, engine)) {
                ((agd)engine.axc_a()).void_b();
            }
            float f2 = this.x - br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
            float f3 = this.y - br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().b(f2);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().c(f3);
            if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().boolean_b()) {
                Engine.a("xDiff = " + f2 + " yDiff = " + f3);
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().void_a(this.x, this.y);
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().b(0.0f);
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().c(0.0f);
            }
            Engine.a("Player username: " + string + " POST x: " + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() + " y: " + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + " isMoving: " + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().boolean_b() + " offset: " + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().float_a() + "," + br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().float_b());
        }
    }
}

