/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;

public class CollisionEvent
extends PublicPacket {
    private String name;
    private float x;
    private float y;

    @Override
    public void handle(Engine engine) {
        Engine.a("CollisionEvent packet received.");
        br br2 = ay.ay_a().br_a(this.name);
        if (br2 != null) {
            if (br2 == ay.ay_a()) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().b(false);
            }
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().void_a(this.x, this.y);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().b(0.0f);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().c(0.0f);
        } else {
            Engine.a("CollisionEvent player is null.");
        }
    }
}

