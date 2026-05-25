/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;
import com.badlogic.gdx.audio.Sound;

public class PlayerInterrupted
extends PlayerSnapshot {
    private int spellSlot;
    private boolean resetCooldown;
    private int OVERRIDE_TIME_MILLISECONDS;
    private boolean self;

    public PlayerInterrupted() {
    }

    public PlayerInterrupted(int n2, boolean bl2, int n3) {
        this.spellSlot = n2;
        this.resetCooldown = bl2;
        this.OVERRIDE_TIME_MILLISECONDS = n3;
    }

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        if (ay.ay_a().br_a(string) == null) {
            return;
        }
        Engine.a("new interrupt incoming");
        if (string.equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a())) {
            Engine.a("interrupt for me.");
            Engine.a("resetting spell: " + (Object)((Object)ay.ay_a().gu_a().ui_a(this.spellSlot).hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a()));
            if (this.self) {
                ui ui2 = ay.ay_a().gu_a().ui_a(this.spellSlot);
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().b(ui2.hf_a().com_arenaofkings_packets_gameserver_data_updates_SpellName_a());
                ui2.hf_a().azv_c().d();
                ui2.hf_a().azv_b().d();
                ay.ay_a().gu_a().a((ui)null);
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().gu_a().a(SpellBarState.AVAILABLE);
                ay.ay_a().gu_a().void_b();
                return;
            }
            if (this.resetCooldown) {
                ay.ay_a().gu_a().ui_a(this.spellSlot).hf_a().azv_c().a(this.OVERRIDE_TIME_MILLISECONDS);
            } else {
                ay.ay_a().gu_a().ui_a(this.spellSlot).hf_a().azv_c().a(this.OVERRIDE_TIME_MILLISECONDS);
            }
            if (ay.ay_a().a(true)) {
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null) {
                    ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a())).stop();
                }
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b() != null) {
                    ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b())).stop();
                }
            }
            engine.var_baa_a.a(ajw.bD, 0.3f);
        }
    }
}

