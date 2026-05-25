/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;

public class PlayerMaxHealthUpdate
extends PlayerSnapshot {
    private int max_health;

    public PlayerMaxHealthUpdate() {
    }

    public PlayerMaxHealthUpdate(int n2) {
        this.max_health = n2;
    }

    public int getHealth() {
        return this.max_health;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        PlayerMaxHealthUpdate playerMaxHealthUpdate = (PlayerMaxHealthUpdate)playerSnapshot;
        if (ay.ay_a().br_a(string) == null) {
            return;
        }
        ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().b((double)playerMaxHealthUpdate.getHealth());
    }
}

