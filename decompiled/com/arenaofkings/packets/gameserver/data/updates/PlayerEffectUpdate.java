/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;

public class PlayerEffectUpdate
extends PlayerSnapshot {
    private EffectList effect;
    private float FIXED_DURATION_MILLISECONDS;
    private int stacks;

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.b("PlayerEffectUpdate.handle()");
        br br2 = ay.ay_a().br_a(string);
        if (br2 != null) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().updateEffectTimer(this.effect, this.FIXED_DURATION_MILLISECONDS, this.stacks);
        }
    }
}

