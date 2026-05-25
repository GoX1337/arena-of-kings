/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Direction;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;

public class PlayerDirectionChange
extends PlayerSnapshot {
    private Direction direction;

    public PlayerDirectionChange() {
    }

    public PlayerDirectionChange(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.b("new PlayerDirectionChange: " + (Object)((Object)this.direction) + " " + string);
        if (!t.a(agd.class, engine)) {
            return;
        }
        br br2 = ay.ay_a().br_a(string);
        if (br2 == null || br2 == ay.ay_a()) {
            return;
        }
        if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) {
            return;
        }
        Engine.b("Checking if idle..");
        if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().boolean_a()) {
            Engine.b("Setting it to player");
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(PlayerAction.getAction(cw.d, this.direction));
        } else {
            Engine.b("currently: " + (Object)((Object)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_PlayerAction_a()) + " " + (Object)((Object)br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_Direction_a()));
        }
    }
}

