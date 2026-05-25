/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;

public class PlayerGCDReset
extends PlayerSnapshot {
    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        if (ay.ay_a().br_a(string) == null) {
            return;
        }
        if (string.equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a())) {
            ay.ay_a().gu_a().azv_a().d();
        }
    }
}

