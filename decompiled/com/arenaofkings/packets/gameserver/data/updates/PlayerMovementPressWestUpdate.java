/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;

public class PlayerMovementPressWestUpdate
extends PlayerSnapshot {
    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.a("Press west");
        br br2 = ay.ay_a().br_a(string);
        if (br2 != ay.ay_a()) {
            ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().b(PlayerAction.RUN_WEST);
        } else {
            Engine.a("PacketWESTPRESS was for me : " + string);
        }
    }
}

