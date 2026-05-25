/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.resources.Energy;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.misc.CharacterClass;

public class PlayerComboPointUpdate
extends PlayerSnapshot {
    private int combo_points;

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        PlayerComboPointUpdate playerComboPointUpdate = (PlayerComboPointUpdate)playerSnapshot;
        if (ay.ay_a().br_a(string) == null) {
            return;
        }
        if (ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.ASSASSIN) {
            ((Energy)ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a()).setCombo_points(this.combo_points);
        }
    }
}

