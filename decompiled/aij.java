/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.requests.input.TargetRequest;

public class aij
extends ail {
    public aij(int n2) {
        super(n2);
    }

    @Override
    public boolean boolean_a(Engine engine) {
        if (ay.ay_a().gd_a().boolean_b()) {
            return true;
        }
        br br2 = aij.br_a();
        if (br2 != null) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(new Target(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a()));
            engine.var_baa_a.a(ajw.kD, 0.165f);
            engine.var_ag_a.a(new TargetRequest(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a()));
            if (((agd)engine.axc_a()).boolean_b()) {
                ((agd)engine.axc_a()).g(true);
            }
            if (t.a(agd.class, engine)) {
                ((agd)engine.axc_a()).agn_a().agt_a().a().a(br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a());
            }
            return true;
        }
        return false;
    }

    public static br br_a() {
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
            if (br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !br3.f() || !br3.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a() || !((d7 = (double)axp.float_a(d2, d3, d4 = (double)ay.ay_a().ge_a().a().a(i2).getValue().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getX(), d5 = (double)ay.ay_a().ge_a().a().a(i2).getValue().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_HitCircle_a().getY())) < d6 || br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !br2.f()) && br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) continue;
            br2 = ay.ay_a().ge_a().a().a(i2).getValue();
            d6 = d7;
        }
        if (br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !br2.f() || !br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_a()) {
            return null;
        }
        return br2;
    }

    @Override
    public boolean b(Engine engine) {
        return false;
    }
}

