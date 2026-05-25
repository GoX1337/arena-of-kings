/*
 * Decompiled with CFR 0.152.
 */
package com.arenaofkings.packets.loginserver;

import com.arenaofkings.client.chat.Chat;
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.PublicPacket;
import com.arenaofkings.packets.misc.ReadyStatus;

public class PUB_PARTY_PLAYER_LEAVE
extends PublicPacket {
    private String username;
    private int ordinal;

    public void setOrdinal(int n2) {
        this.ordinal = n2;
    }

    public void setUsername(String string) {
        this.username = string;
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public void handle(Engine engine) {
        if (ay.ay_a() == null) {
            return;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a() == null) {
            return;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity() == null) {
            return;
        }
        Engine.a("PUB_PARTY_PLAYER_LEAVE");
        for (int i2 = 0; i2 < ay.ay_a().gf_a().a().size(); ++i2) {
            Engine.b("PRE Player: " + ay.ay_a().gf_a().a().a(i2).getValue().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a() + " " + ay.ay_a().gf_a().a().a(i2).getValue().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h());
        }
        Engine.a("preparty: " + engine.var_u_a.toString());
        if (this.username.equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a())) {
            Engine.a("CLEAR CALLED");
            ay.ay_a().gf_a().a(engine, false);
            ay.ay_a().gf_a().a(ay.ay_a());
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().void_a(1);
        } else {
            if (t.a(agd.class, engine)) {
                ay.ay_a().gf_a().c(engine, this.username);
            } else {
                ay.ay_a().gf_a().b(engine, this.username);
            }
            if (ay.ay_a().br_a(this.username) != null) {
                ay.ay_a().br_a(this.username).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().d(true);
            }
            ay.ay_a().gf_a().a(engine, this.username);
            ay.ay_a().gd_a().ev_a().en_a().b(this.username);
        }
        ay.ay_a().gf_a().a(1);
        for (Object object : ay.ay_a().gf_a().a().values()) {
            ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().bd_a().a(ReadyStatus.RED);
        }
        if (ay.ay_a().gf_a().a().size() == 2) {
            for (Object object : ay.ay_a().gf_a().a().values()) {
                if (object == ay.ay_a()) {
                    ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().void_a(1);
                    continue;
                }
                ((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().void_a(2);
            }
        }
        if (t.a(we.class, engine)) {
            Object object;
            we we2 = (we)engine.axc_a();
            object = we2.wh_a().wg_a();
            ((Chat)object).a("[AOK_BLUE]" + this.username + " has left your party.", engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_b);
            engine.var_baa_a.a(ajw.kv, 0.5f);
            if (we2.wh_a().yg_a().boolean_c()) {
                we2.wh_a().yg_b().a(null, false, false);
            } else if (we2.wh_a().yg_a().boolean_d()) {
                we2.wh_a().yg_b().a(null, true, false);
            }
        }
        for (int i3 = 0; i3 < ay.ay_a().gf_a().a().size(); ++i3) {
            Engine.b("POST Player: " + ay.ay_a().gf_a().a().a(i3).getValue().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a() + " " + ay.ay_a().gf_a().a().a(i3).getValue().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().int_h());
        }
        Engine.a("postparty: " + engine.var_u_a.toString());
    }
}

