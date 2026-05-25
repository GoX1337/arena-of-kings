/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.spells.catalog;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Location;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.gameserver.data.updates.spells.catalog.SpellClassification;
import com.arenaofkings.packets.loginserver.PUB_MISC_CRASH_REPORT;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.audio.Sound;

public class DynamicPlayerSpellFinish
extends SpellClassification {
    private String spawn_character_name;

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        if (t.a(agd.class, engine)) {
            Engine.b("new DynamicPlayerSpellFinish - " + (Object)((Object)this.spellName) + " for " + string + " ID " + this.ID);
            br br2 = ay.ay_a().br_a(string);
            ui ui2 = null;
            if (br2 == ay.ay_a()) {
                ui2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().b(this.spellName);
                if (ui2 == null) {
                    return;
                }
                ui2.a(1.2f);
                if (this.spellName == SpellName.Meditate) {
                    ui2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().ui_b();
                    ui2.hf_a().azv_c().d();
                }
            } else if (br2 != null) {
                ui2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a();
                if (ui2 == null) {
                    return;
                }
                if (this.spellName == SpellName.Meditate) {
                    ui2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_b();
                    ui2.hf_a().azv_c().d();
                }
            }
            if (ui2 != null) {
                Engine.b("current spell isn't null: " + (Object)((Object)ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
                if (ay.ay_a().boolean_a(br2)) {
                    ui2.a(true);
                } else {
                    ui2.a(false);
                }
                ui2.a(this.ID);
                ui2.a(ay.ay_a().br_a(this.spawn_character_name));
                if (this.spawn_character_name != null) {
                    Engine.a("spawn_character_name=" + this.spawn_character_name);
                    if (ui2.a() == null) {
                        ui2.a(new Location());
                    }
                    ui2.hf_a().void_a();
                    ui2.hf_a().a(new Target(this.spawn_character_name, this.ID));
                    ui2.a().get(0).initHitCircle(engine);
                }
                ui2.void_a();
                Engine.a("3 " + this.spawn_character_name);
                if (ui2.hf_a().azv_b().boolean_a()) {
                    ui2.hf_a().azv_b().void_b();
                }
                ui2.hf_a().azv_b().e();
                if (ui2.hf_a().azv_a().boolean_a()) {
                    ui2.hf_a().azv_a().d();
                }
                ui2.hf_a().azv_a().void_a();
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a().equals(string)) {
                    if (this.spellName == SpellName.Meditate) {
                        ui2.hf_a().azv_c().void_c();
                    } else if (ay.ay_a().gu_a() != null && ui2 != null && ui2.hf_a() != null && ay.ay_a().gu_a().ui_a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()) != null) {
                        ay.ay_a().gu_a().ui_a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()).hf_a().azv_c().void_c();
                    }
                }
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(SpellBarState.AVAILABLE);
                br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().b(false);
                if (ui2.hf_a().uk_a() == uk.var_uk_a) {
                    if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() != CharacterClass.RANGER) {
                        ajw ajw2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b();
                        Sound sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw2);
                        if (sound == null) {
                            PUB_MISC_CRASH_REPORT pUB_MISC_CRASH_REPORT = new PUB_MISC_CRASH_REPORT("", "DynamicPlayerSpellFinish Unknown atk sound dependency for: " + (Object)((Object)ajw2) + " " + (Object)((Object)this.spellName));
                            engine.var_z_a.void_a(pUB_MISC_CRASH_REPORT);
                            return;
                        }
                        sound.stop();
                    }
                } else if (ui2.hf_a().uk_a() == uk.d && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a() != null) {
                    ajw ajw3 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a();
                    Sound sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw3);
                    if (sound == null) {
                        PUB_MISC_CRASH_REPORT pUB_MISC_CRASH_REPORT = new PUB_MISC_CRASH_REPORT("", "DynamicPlayerSpellFinish Unknown cast sound dependency for: " + (Object)((Object)ajw3) + " " + (Object)((Object)this.spellName));
                        engine.var_z_a.void_a(pUB_MISC_CRASH_REPORT);
                        return;
                    }
                    sound.stop();
                }
                ui2.hd_a().void_c();
                if (ui2.da_a() != null) {
                    ui2.da_a().b(false);
                }
                ((agd)engine.axc_a()).hi_a().a(ui2);
            } else {
                Engine.a("this spell is null");
            }
        }
    }
}

