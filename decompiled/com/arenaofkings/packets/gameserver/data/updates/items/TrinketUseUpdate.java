/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.items;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Location;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.audio.Sound;

public class TrinketUseUpdate
extends PlayerSnapshot {
    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        br br2 = ay.ay_a().br_a(string);
        if (br2 == null) {
            return;
        }
        fu fu2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().fu_a();
        fu2.c();
        if (fu2.hf_a().uk_a() == uk.var_uk_a) {
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() != CharacterClass.RANGER) {
                ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b())).stop();
            }
        } else if (fu2.hf_a().uk_a() == uk.d && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a() != null) {
            ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a())).stop();
        }
        ui ui2 = new ue.a().a(fu2.hf_a(), fu2.hd_a(), fu2.da_a(), fu2.ajw_a()).ui_a();
        ui2.azo_a().a(2.0f);
        ui2.a(br2);
        if (string != null) {
            Engine.a("spawn_username=" + string);
            if (ui2.a() == null) {
                ui2.a(new Location());
            }
            ui2.hf_a().void_a();
            ui2.hf_a().a(new Target(string));
        }
        ui2.void_a();
        ((agd)engine.axc_a()).hi_a().a(ui2);
    }
}

