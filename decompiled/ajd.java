/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.requests.input.TargetRequest;

public class ajd
extends ail {
    public ajd(int n2) {
        super(n2);
    }

    public void a(Engine engine, br br2) {
        if (br2 == null) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().setIdentifyingName("");
            engine.var_ag_a.a(new TargetRequest(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a()));
            engine.var_baa_a.a(ajw.kE, 0.165f);
        } else {
            Target target = new Target(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a());
            engine.var_ag_a.a(new TargetRequest(target));
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(target);
            if (t.a(agd.class, engine)) {
                ((agd)engine.axc_a()).agn_a().agt_a().a().a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a());
            }
            engine.var_baa_a.a(ajw.kD, 0.165f);
        }
    }

    public br a(br br2) {
        double d2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
        double d3 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
        double d4 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
        double d5 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
        double d6 = axp.float_a(d2, d3, d4, d5);
        br br3 = null;
        double d7 = -1.0;
        double d8 = 0.0;
        for (int i2 = 0; i2 < ay.ay_a().ge_a().a().values().size(); ++i2) {
            br br4 = ay.ay_a().ge_a().a().a(i2);
            if (br4.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !br4.f() || br4 == br2 || !br4.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) continue;
            double d9 = br4.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
            double d10 = br4.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
            d8 = axp.float_a(d2, d3, d9, d10);
            if (d7 == -1.0) {
                d7 = d8;
            }
            if (!(d8 >= d6) || !(d8 <= d7)) continue;
            br3 = br4;
        }
        if (br3 == br2) {
            br3 = this.br_a();
        }
        return br3;
    }

    public br br_a() {
        br br2 = ay.ay_a().ge_a().a().a(0).getValue();
        double d2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
        double d3 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
        double d4 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX();
        double d5 = br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY();
        if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !br2.f()) {
            d4 = 9999.0;
            d5 = 9999.0;
        }
        double d6 = axp.float_a(d2, d3, d4, d5);
        for (int i2 = 1; i2 < ay.ay_a().ge_a().a().values().size(); ++i2) {
            double d7;
            br br3 = ay.ay_a().ge_a().a().a(i2).getValue();
            if (br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !br3.f() || !br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a() || !((d7 = (double)axp.float_a(d2, d3, d4 = (double)ay.ay_a().ge_a().a().a(i2).getValue().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), d5 = (double)ay.ay_a().ge_a().a().a(i2).getValue().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY())) < d6 || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !br3.f()) && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) continue;
            br2 = ay.ay_a().ge_a().a().a(i2).getValue();
            d6 = d7;
        }
        if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !br2.f() || !br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) {
            return null;
        }
        return br2;
    }

    public void void_a(Engine engine) {
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null || ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
            this.a(engine, this.br_a());
        } else if (!ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
            this.a(engine, this.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer()));
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() == null) {
            this.a(engine, this.br_a());
        }
    }

    @Override
    public boolean boolean_a(Engine engine) {
        if (ay.ay_a().gd_a().boolean_b()) {
            return true;
        }
        this.void_a(engine);
        if (((agd)engine.axc_a()).boolean_b()) {
            ((agd)engine.axc_a()).g(true);
        }
        return true;
    }

    @Override
    public boolean b(Engine engine) {
        return false;
    }
}

