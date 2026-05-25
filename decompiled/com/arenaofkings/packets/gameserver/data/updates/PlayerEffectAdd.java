/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.EffectList;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.badlogic.gdx.audio.Sound;

public class PlayerEffectAdd
extends PlayerSnapshot {
    private EffectList effect;
    private float FIXED_DURATION_MILLISECONDS;
    private String actor_name;

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        Engine.b("PlayerEffectAdd in");
        if (ay.ay_a().br_a(string) == null || ay.ay_a().br_a(this.actor_name) == null) {
            return;
        }
        if (!ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) {
            return;
        }
        Engine.a("PlayerEffectAdd");
        Engine.a((Object)((Object)this.effect) + " " + this.FIXED_DURATION_MILLISECONDS + " start PlayerEffectAdd for username: " + string);
        if (ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a() != null) {
            if (engine.var_or_a == null || this.effect == null || ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().contains(this.effect)) {
                return;
            }
            engine.var_or_a.a(this.effect, (long)this.FIXED_DURATION_MILLISECONDS, string, this.actor_name);
            if (ay.ay_a().a(true)) {
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null) {
                    ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a())).stop();
                }
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b() != null) {
                    ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b())).stop();
                }
            }
        }
        Engine.a("end PlayerEffectAdd");
        Engine.b("PlayerEffectAdd out");
    }
}

