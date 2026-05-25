/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;

public class PlayerMovementActionUpdate
extends PlayerSnapshot {
    private PlayerAction newAction;

    public PlayerMovementActionUpdate() {
    }

    public PlayerMovementActionUpdate(PlayerAction playerAction) {
        this.newAction = playerAction;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        br br2 = ay.ay_a().br_a(string);
        if (br2 != ay.ay_a() && this.newAction != null && br2 != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a() != null) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().b(this.newAction);
        }
    }
}

