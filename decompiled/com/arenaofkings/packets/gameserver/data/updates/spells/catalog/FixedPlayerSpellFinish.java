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

public class FixedPlayerSpellFinish
extends SpellClassification {
    private String spawn_character_name;

    public String getSpawn_character_name() {
        return this.spawn_character_name;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.b("FixedPlayerSpellFinish in");
        if (t.a(agd.class, engine)) {
            Object object;
            Engine.a("new FixedPlayerSpellFinish - " + (Object)((Object)this.spellName) + " for " + string);
            br br2 = ay.ay_a().br_a(string);
            if (this.spellName == SpellName.Sheepify) {
                System.out.println("Spawn name: " + this.spawn_character_name);
                if (this.spawn_character_name != null && this.spawn_character_name.length() > 1) {
                    System.out.println("spawn1");
                    object = ay.ay_a().br_a(this.spawn_character_name);
                    if (object != null && ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() != null && ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() != null && br2 != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity() != null) {
                        System.out.println("spawn2");
                        ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().cy_a().a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().cy_a().d());
                        System.out.println("spawn3");
                    }
                }
            }
            object = null;
            if (br2 == ay.ay_a()) {
                object = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().b(this.spellName);
                if (object == null) {
                    return;
                }
                ((ui)object).a(1.2f);
            } else if (br2 != null) {
                object = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().ui_a();
            }
            if (object == null) {
                return;
            }
            if (ay.ay_a().boolean_a(br2)) {
                ((ui)object).a(true);
            } else {
                ((ui)object).a(false);
            }
            ((ui)object).a(this.ID);
            ((ui)object).a(ay.ay_a().br_a(this.spawn_character_name));
            if (((ui)object).br_a() == null) {
                if (((ui)object).a() == null) {
                    ((ui)object).a(new Location());
                }
                ((ui)object).hf_a().void_a();
                ((ui)object).hf_a().a(new Target(this.spawn_character_name, this.ID));
                ((ui)object).a().get(0).initHitCircle(engine);
                if (((ui)object).br_a() == null) {
                    if (((ui)object).da_a() != null) {
                        ((ui)object).da_a().a(((ui)object).a().get(0).getX(), ((ui)object).a().get(0).getY());
                    }
                } else if (((ui)object).da_a() != null) {
                    ((ui)object).da_a().a(((ui)object).br_a().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ((ui)object).br_a().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY());
                }
            } else {
                ((ui)object).hf_a().void_a();
                if (((ui)object).da_a() != null) {
                    ((ui)object).da_a().a(((ui)object).br_a().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ((ui)object).br_a().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY());
                }
            }
            if (((ui)object).hf_a().azv_b().boolean_a()) {
                ((ui)object).hf_a().azv_b().void_b();
            }
            ((ui)object).hf_a().azv_b().e();
            if (((ui)object).hf_a().azv_a().boolean_a()) {
                ((ui)object).hf_a().azv_a().d();
            }
            ((ui)object).hf_a().azv_a().void_a();
            if (ay.ay_a() == br2) {
                Engine.a("restarting it");
                ay.ay_a().gu_a().ui_a(((ui)object).hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()).hf_a().azv_c().void_c();
            }
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(SpellBarState.AVAILABLE);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().b(false);
            if (((ui)object).hf_a().uk_a() == uk.var_uk_a) {
                if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() != CharacterClass.RANGER) {
                    ajw ajw2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b();
                    Sound sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw2);
                    if (sound == null) {
                        PUB_MISC_CRASH_REPORT pUB_MISC_CRASH_REPORT = new PUB_MISC_CRASH_REPORT("", "FixedPlayerSpellFinish Unknown atk sound dependency for: " + (Object)((Object)ajw2) + " " + (Object)((Object)this.spellName));
                        engine.var_z_a.void_a(pUB_MISC_CRASH_REPORT);
                        return;
                    }
                    sound.stop();
                }
            } else if (((ui)object).hf_a().uk_a() == uk.d && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a() != null) {
                ajw ajw3 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a();
                Sound sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw3);
                if (sound == null) {
                    PUB_MISC_CRASH_REPORT pUB_MISC_CRASH_REPORT = new PUB_MISC_CRASH_REPORT("", "FixedPlayerSpellFinish Unknown cast sound dependency for: " + (Object)((Object)ajw3) + " " + (Object)((Object)this.spellName));
                    engine.var_z_a.void_a(pUB_MISC_CRASH_REPORT);
                    return;
                }
                sound.stop();
            }
            ((ui)object).hd_a().void_c();
            if (((ui)object).da_a() != null) {
                ((ui)object).da_a().b(false);
            }
            ((agd)engine.axc_a()).hi_a().a((ui)object);
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a((ui)object);
        }
        Engine.b("FixedPlayerSpellFinish out");
    }
}

