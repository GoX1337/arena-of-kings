/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.gameserver.data.updates;

import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.arenaofkings.packets.gameserver.data.updates.PlayerSnapshot;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class PlayerDeathUpdate
extends PlayerSnapshot {
    private int silverGain;
    private int expGain;
    private int aeGain;
    private boolean raf;
    private boolean member;

    @Override
    public void handle(String string, PlayerSnapshot playerSnapshot, Engine engine) {
        if (ay.ay_a().br_a(string) == null) {
            return;
        }
        if (!t.a(agd.class, engine)) {
            return;
        }
        ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_EffectManager_a().getEffects().clear();
        ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().az_a().void_d();
        ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().a(false);
        if (ay.ay_a().br_a(string) == ay.ay_a()) {
            ((agd)engine.axc_a()).void_a();
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().cr_a().h();
        } else {
            ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().a(PlayerAction.getAction(cw.c, ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().cr_a().com_arenaofkings_packets_gameserver_data_Direction_a()));
            if (!ay.ay_a().boolean_a(string)) {
                Object object;
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().b(new aib(engine, "**LETHALITY**", Color.ORANGE, true, ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), ay.ay_a().br_a(string).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 170.0f));
                if (ay.ay_a().gd_a().boolean_b()) {
                    return;
                }
                if (this.silverGain > 0) {
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().b(new aic(engine, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().aih_a().a(), (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() - 40, (int)ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 148, "+" + this.silverGain, Color.LIGHT_GRAY, true, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX() - 40.0f, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY() + 180.0f));
                    object = "";
                    object = this.raf ? "[LIGHT_GRAY]You claimed [RED]" + string + "[]'s Bounty of " + this.silverGain + " Silver.[]" : "[LIGHT_GRAY]You claimed [RED]" + string + "[]'s Bounty of " + this.silverGain + " Silver.[]";
                    ((agd)engine.axc_a()).agn_a().i_a().a((String)object);
                    int n2 = MathUtils.random(2);
                    if (n2 == 0) {
                        engine.var_baa_a.a(ajw.jU, 0.8f);
                    } else if (n2 == 1) {
                        engine.var_baa_a.a(ajw.jV, 0.8f);
                    } else if (n2 == 2) {
                        engine.var_baa_a.a(ajw.jW, 0.8f);
                    } else {
                        engine.var_baa_a.a(ajw.jU, 0.8f);
                    }
                }
                if (this.expGain > 0) {
                    System.out.println("RAF: " + this.raf);
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(engine, this.expGain, this.raf, this.member);
                    for (br br2 : ay.ay_a().gf_a().a().values()) {
                        if (br2 == ay.ay_a()) continue;
                        br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().h(this.expGain);
                    }
                }
                if (this.aeGain > 0) {
                    object = "[RARITY_EPIC]You gained " + this.aeGain + " Ability Essence.[]";
                    ay.ay_a().gd_a().e(this.aeGain);
                    ((agd)engine.axc_a()).agn_a().i_a().a((String)object);
                }
            }
        }
    }
}

