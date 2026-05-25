/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.spells.catalog;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.gameserver.data.updates.spells.catalog.SpellClassification;
import com.badlogic.gdx.audio.Sound;

public class FixedCoordinateSpellStart
extends SpellClassification {
    public FixedCoordinateSpellStart() {
    }

    public FixedCoordinateSpellStart(SpellName spellName) {
        super(spellName);
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.a("new FixedCoordinateSpellStart - " + (Object)((Object)this.spellName) + " for " + string);
        br br2 = ay.ay_a().br_a(string);
        uf uf2 = engine.var_hg_a.a(this.spellName, 0.0f, 0.0f);
        if (uf2 == null) {
            return;
        }
        if (uf2.hd_a() == null) {
            return;
        }
        uf2.hd_a().a(engine.axm_a());
        if (uf2.hf_a().azv_b().boolean_a() || uf2.hf_a().azv_b().boolean_b()) {
            uf2.hf_a().azv_b().void_c();
            uf2.hf_a().azv_b().a(false);
        }
        uf2.hf_a().azv_b().void_a();
        if (br2 == ay.ay_a() && !uf2.hf_a().boolean_d()) {
            ay.ay_a().gu_a().c();
        }
        if (uf2.hf_a().uk_a() == uk.var_uk_a) {
            if (br2 == ay.ay_a() && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b() != null) {
                ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b())).play(0.115f);
            }
        } else if (uf2.hf_a().uk_a() == uk.d && br2 == ay.ay_a() && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a() != null) {
            ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a())).play(0.115f);
        }
        uf2.a(br2);
        if (br2 != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a() != null) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(uf2);
            if (ay.ay_a() == br2) {
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a().add(uf2);
            }
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(SpellBarState.CASTING);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().b(true);
            Engine.a("spell spawned " + (Object)((Object)this.spellName));
        }
    }
}

