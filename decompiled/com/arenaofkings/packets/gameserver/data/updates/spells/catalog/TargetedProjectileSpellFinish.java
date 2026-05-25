/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.spells.catalog;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.gameserver.data.updates.spells.catalog.SpellClassification;
import com.arenaofkings.packets.loginserver.PUB_MISC_CRASH_REPORT;
import com.badlogic.gdx.audio.Sound;

public class TargetedProjectileSpellFinish
extends SpellClassification {
    private String spawn_character_name;

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        if (!t.a(agd.class, engine)) return;
        Engine.a("new TargetedProjectileSpellFinish - " + (Object)((Object)this.spellName) + " for " + string);
        Engine.a("1");
        br br2 = ay.ay_a().br_a(string);
        if (br2 == null) {
            Engine.a("Acting Player is null");
            return;
        }
        ui ui2 = null;
        if (br2 == ay.ay_a()) {
            ui2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().b(this.spellName);
            if (!(ui2 instanceof ul)) return;
            ((ul)ui2).b(true);
            ui2.a(1.15f);
        } else if (br2 != null) {
            ui2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a();
        }
        if (ui2 == null) {
            return;
        }
        if (ay.ay_a().boolean_a(br2)) {
            ui2.a(true);
        } else {
            ui2.a(false);
        }
        ui2.a(this.ID);
        ui2.a(ay.ay_a().br_a(this.spawn_character_name));
        Engine.a("2 .. " + this.spawn_character_name);
        Engine.a("location size: " + ui2.a().size());
        if (this.spawn_character_name != null || ui2.br_a() == null) {
            Engine.a("spawn_character_name=" + this.spawn_character_name);
            ui2.hf_a().void_a();
            ui2.hf_a().a(new Target(this.spawn_character_name, this.ID));
            Engine.a("initHitCircle()");
            ui2.hf_a().a().get(0).initHitCircle(engine);
            if (ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Charge && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Safeguard && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Bear_Charge && ui2.da_a() != null) {
                ui2.da_a().a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY());
            }
            if (!(ui2.hf_a() instanceof gw)) {
                Engine.b("Failed to create projectile spell: " + (Object)((Object)this.spellName));
                return;
            }
            ((gw)ui2.hf_a()).a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY());
        } else {
            Engine.a("Resolving locations ...");
            ui2.void_a();
            Engine.a("Locations resolved. Locations.size=" + ui2.hf_a().a().size());
        }
        Engine.a("3 " + this.spawn_character_name);
        if (ui2.hf_a().azv_b().boolean_a()) {
            ui2.hf_a().azv_b().void_b();
        }
        Engine.a("4");
        ui2.hf_a().azv_b().e();
        if (ui2.hf_a().azv_a().boolean_a()) {
            ui2.hf_a().azv_a().d();
        }
        ui2.hf_a().azv_a().void_a();
        Engine.a("my character name =" + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a() + " username=" + string);
        if (ay.ay_a() == br2) {
            Engine.a("restarting it");
            ay.ay_a().gu_a().ui_a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()).hf_a().azv_c().void_c();
        }
        Engine.a("5");
        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(SpellBarState.AVAILABLE);
        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().b(false);
        if (ui2.hf_a().uk_a() == uk.var_uk_a) {
            if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b() != null) {
                ajw ajw2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b();
                Sound sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw2);
                if (sound == null) {
                    PUB_MISC_CRASH_REPORT pUB_MISC_CRASH_REPORT = new PUB_MISC_CRASH_REPORT("", "TargetedProjectileSpellFinish Unknown atk sound dependency for: " + (Object)((Object)ajw2) + " " + (Object)((Object)this.spellName));
                    engine.var_z_a.void_a(pUB_MISC_CRASH_REPORT);
                    return;
                }
                sound.play(0.115f);
            }
        } else if (ui2.hf_a().uk_a() == uk.d && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a() != null) {
            ajw ajw3 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a();
            Sound sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw3);
            if (sound == null) {
                PUB_MISC_CRASH_REPORT pUB_MISC_CRASH_REPORT = new PUB_MISC_CRASH_REPORT("", "TargetedProjectileSpellFinish Unknown cast sound dependency for: " + (Object)((Object)ajw3) + " " + (Object)((Object)this.spellName));
                engine.var_z_a.void_a(pUB_MISC_CRASH_REPORT);
                return;
            }
            sound.stop();
        }
        Engine.a("6");
        ui2.hd_a().void_c();
        System.out.println("Let's load it");
        ui2.a(engine.axm_a());
        if (ui2.da_a() != null) {
            ui2.da_a().b(true);
        }
        Engine.a("7");
        if (ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Charge && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Safeguard && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Bear_Charge) {
            if (!ui2.boolean_c() && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() == SpellName.StreamOfLight && ui2.da_a() != null) {
                ui2.da_a().a(engine.var_com_badlogic_gdx_graphics_Color_a);
            }
            ((agd)engine.axc_a()).hi_a().a(ui2);
            return;
        }
        if (ui2.azo_a() == null) return;
        ui2.azo_a().a(engine.axc_a().axm_a());
        engine.var_baa_a.a(ui2.azo_a().ajw_a(), 0.7f);
    }
}

