/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.sct;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.sct.SCT_Event;
import com.badlogic.gdx.graphics.Color;

public class SCT_PlayerHealthChange
extends SCT_Event {
    private int value;
    private boolean critical;

    public SCT_PlayerHealthChange() {
    }

    public SCT_PlayerHealthChange(int n2, boolean bl2) {
        this.value = n2;
        this.critical = bl2;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        br br2 = ay.ay_a().br_a(this.character_name);
        Engine.a("SCT_HealthChange: " + string + " " + this.value + " " + this.critical);
        if (br2 != null && this.critical) {
            if (br2 == ay.ay_a()) {
                if (this.value < 0) {
                    this.value *= -1;
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aif(engine, this.value, this.value + "!", Color.RED, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 206.0f, 2));
                } else if (this.value > 0) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aif(engine, this.value, this.value + "!", Color.GREEN, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 206.0f, 1));
                }
            } else if (this.value < 0) {
                this.value *= -1;
                if (this.value > 1250) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aif(engine, this.value, this.value + "!", Color.ORANGE, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 206.0f, 2));
                } else {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aif(engine, this.value, this.value + "!", Color.YELLOW, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 206.0f, 2));
                }
            } else if (this.value > 0) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aif(engine, this.value, this.value + "!", Color.GREEN, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 206.0f, 1));
            }
        } else if (br2 != null && !this.critical) {
            if (br2 == ay.ay_a()) {
                if (this.value < 0) {
                    this.value *= -1;
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aif(engine, this.value, String.valueOf(this.value), Color.RED, false, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() - 25.0f, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 206.0f, 2));
                } else if (this.value > 0) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aif(engine, this.value, String.valueOf(this.value), Color.GREEN, false, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() + 25.0f, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 206.0f, 1));
                }
            } else if (this.value < 0) {
                this.value *= -1;
                if (this.value > 800) {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aif(engine, this.value, String.valueOf(this.value), Color.YELLOW, true, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() - 25.0f, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 206.0f, 2));
                } else {
                    br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aif(engine, this.value, String.valueOf(this.value), Color.YELLOW, false, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() - 25.0f, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 206.0f, 2));
                }
            } else if (this.value > 0) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().aih_a().b(new aif(engine, this.value, String.valueOf(this.value), Color.GREEN, false, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() + 25.0f, br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 206.0f, 1));
            }
        }
    }
}

