/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.spells.catalog;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;
import com.arenaofkings.packets.gameserver.data.updates.spells.catalog.SpellClassification;
import com.badlogic.gdx.audio.Sound;

public class TargetedProjectileSpellStart
extends SpellClassification {
    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.a("new TargetedProjectileSpellStart - " + (Object)((Object)this.spellName) + " for " + string);
        if (ay.ay_a().br_a(string) == null) {
            return;
        }
        ul ul2 = engine.var_hg_a.ul_a(this.spellName, string);
        br br2 = ay.ay_a().br_a(string);
        if (ul2 == null) {
            return;
        }
        if (ul2.hd_a() == null) {
            return;
        }
        ul2.hd_a().a(engine.axm_a());
        if (ul2.hf_a().azv_b().boolean_a() || ul2.hf_a().azv_b().boolean_b()) {
            ul2.hf_a().azv_b().void_c();
            ul2.hf_a().azv_b().a(false);
        }
        ul2.hf_a().azv_b().void_a();
        if (br2 == ay.ay_a() && !ul2.hf_a().boolean_d()) {
            ay.ay_a().gu_a().c();
        }
        if (ul2.hf_a().uk_a() != uk.var_uk_a && ul2.hf_a().uk_a() == uk.d && br2 == ay.ay_a() && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a() != null) {
            ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a())).play(0.115f);
        }
        ul2.a(br2);
        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(ul2);
        if (ay.ay_a() == br2) {
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a().add(ul2);
        }
        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(SpellBarState.CASTING);
        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().b(true);
        Engine.a("Set new spell: " + ul2.getClass().getSimpleName() + " for player: " + string);
    }
}

