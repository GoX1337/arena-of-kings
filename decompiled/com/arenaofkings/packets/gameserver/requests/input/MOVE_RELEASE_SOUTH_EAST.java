/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.requests.input;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.misc.PublicPacket;

public class MOVE_RELEASE_SOUTH_EAST
extends PublicPacket {
    private String character_name;

    @Override
    public void handle(Engine engine) {
        br br2 = ay.ay_a().br_a(this.character_name);
        if (br2 != null && ay.ay_a() != br2) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().d(PlayerAction.RUN_SOUTH_EAST);
        }
    }
}

