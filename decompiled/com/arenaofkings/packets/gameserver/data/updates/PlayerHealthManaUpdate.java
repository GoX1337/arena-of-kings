/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;

public class PlayerHealthManaUpdate
extends PlayerSnapshot {
    private int health;
    private int mana;

    public PlayerHealthManaUpdate() {
    }

    public PlayerHealthManaUpdate(int n2, int n3) {
        this.health = n2;
        this.mana = n3;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMana() {
        return this.mana;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        if (ay.ay_a().br_a(string) != null) {
            ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a((double)this.health);
            ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().setCurrentValue(this.mana);
            Engine.b("RS Update: " + string + " " + this.mana);
        }
    }
}

