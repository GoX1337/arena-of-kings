/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates.spells.catalog;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Location;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;
import com.arenaofkings.packets.gameserver.data.updates.SpellName;
import com.arenaofkings.packets.gameserver.data.updates.spells.catalog.SpellClassification;
import com.arenaofkings.packets.loginserver.PUB_MISC_CRASH_REPORT;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.audio.Sound;

public class FixedCoordinateSpellFinish
extends SpellClassification {
    private float x;
    private float y;

    public FixedCoordinateSpellFinish() {
    }

    public FixedCoordinateSpellFinish(SpellName spellName, float f2, float f3) {
        super(spellName);
        this.x = f2;
        this.y = f3;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setX(float f2) {
        this.x = f2;
    }

    public void setY(float f2) {
        this.y = f2;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        if (t.a(agd.class, engine)) {
            Engine.a("new FixedCoordinateSpellFinish - " + (Object)((Object)this.spellName) + " for " + string + " x: " + this.x + " y: " + this.y);
            Engine.a("a");
            br br2 = ay.ay_a().br_a(string);
            Engine.a("b");
            ui ui2 = null;
            if (br2 == ay.ay_a()) {
                ui2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().b(this.spellName);
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
            Engine.a("c");
            if (ui2.a() == null) {
                ui2.a(new Location());
            } else {
                ui2.a().clear();
            }
            Engine.a("d");
            ui2.a().add(new Location(this.x, this.y));
            ui2.hf_a().com_arenaofkings_packets_gameserver_data_HitCircle_a().setPosition(this.x, this.y);
            Engine.a("e");
            if (ui2.hf_a().azv_b().boolean_a()) {
                ui2.hf_a().azv_b().void_b();
            }
            Engine.a("f");
            ui2.hf_a().azv_b().e();
            if (ui2.hf_a().azv_a().boolean_a()) {
                ui2.hf_a().azv_a().d();
            }
            ui2.hf_a().azv_a().void_a();
            Engine.a("g");
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().gz_a().a(SpellBarState.AVAILABLE);
            Engine.a("h");
            Engine.a("i");
            br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().b(false);
            Engine.a("j");
            if (ui2.hf_a().uk_a() == uk.var_uk_a) {
                if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b() != null && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() != CharacterClass.RANGER) {
                    ajw ajw2 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_b();
                    Sound sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw2);
                    if (sound == null) {
                        PUB_MISC_CRASH_REPORT pUB_MISC_CRASH_REPORT = new PUB_MISC_CRASH_REPORT("", "FixedCoordinateSpellFinish Unknown atk sound dependency for: " + (Object)((Object)ajw2) + " " + (Object)((Object)this.spellName));
                        engine.var_z_a.void_a(pUB_MISC_CRASH_REPORT);
                        return;
                    }
                    sound.stop();
                }
            } else if (ui2.hf_a().uk_a() == uk.d && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a() != null) {
                ajw ajw3 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ajw_a();
                Sound sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw3);
                if (sound == null) {
                    PUB_MISC_CRASH_REPORT pUB_MISC_CRASH_REPORT = new PUB_MISC_CRASH_REPORT("", "FixedCoordinateSpellFinish Unknown cast sound dependency for: " + (Object)((Object)ajw3) + " " + (Object)((Object)this.spellName));
                    engine.var_z_a.void_a(pUB_MISC_CRASH_REPORT);
                    return;
                }
                sound.stop();
            }
            Engine.a("spell spawned " + (Object)((Object)this.spellName));
            if (ay.ay_a() == br2) {
                ay.ay_a().gu_a().ui_a(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()).hf_a().azv_c().void_c();
            }
            Engine.a("k");
            ui2.hd_a().void_c();
            if (ui2.da_a() != null) {
                ui2.da_a().b(false);
            }
            if (!ui2.boolean_c() && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.OrbOfAbsolution && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.OrbOfReplenishment && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.OrbOfSmoke && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.OrbOfWisdom && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Meteor && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Rockslide && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.ToxicSpore && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Disenchant && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Blink && ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a() != SpellName.Teleport && ui2.da_a() != null) {
                ui2.da_a().a(engine.var_com_badlogic_gdx_graphics_Color_a);
            }
            ((agd)engine.axc_a()).hi_a().a(ui2);
            Engine.a("l");
        }
    }
}

