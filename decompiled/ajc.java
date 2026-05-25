/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.Target;
import com.arenaofkings.packets.gameserver.requests.input.TargetRequest;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.audio.Sound;

public class ajc
extends ail {
    public ajc(int n2) {
        super(n2);
    }

    @Override
    public boolean boolean_a(Engine engine) {
        Object object;
        if (ay.ay_a().gd_a().boolean_b()) {
            return true;
        }
        System.out.println("Name");
        System.out.println(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName());
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName().equals("") && (object = aij.br_a()) != null) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().a(new Target(((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a()));
            engine.var_baa_a.a(ajw.kD, 0.165f);
            engine.var_ag_a.a(new TargetRequest(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a()));
            if (((agd)engine.axc_a()).boolean_b()) {
                ((agd)engine.axc_a()).g(true);
            }
            if (t.a(agd.class, engine)) {
                ((agd)engine.axc_a()).agn_a().agt_a().a().a(((br)object).com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a());
            }
        }
        Engine.a("mouse: " + engine.var_com_badlogic_gdx_math_Vector3_b.x + "," + engine.var_com_badlogic_gdx_math_Vector3_b.y);
        if (ay.ay_a().gu_a().a(engine, 0, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_b())) {
            ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw.iU)).play(0.155f);
            object = ay.ay_a().gu_a().ui_a(0);
            if (((ui)object).hf_a().azv_b().long_a() == 0L) {
                ((ui)object).hd_a().a(30);
            }
            if (((ui)object).hf_a().uk_a() == uk.var_uk_a) {
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.RANGER) {
                    ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a())).play(0.115f);
                }
            } else if (((ui)object).hf_a().uk_a() == uk.d && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null) {
                ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a())).play(0.115f);
            }
            return true;
        }
        ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw.iV)).play(0.125f);
        return false;
    }

    @Override
    public boolean b(Engine engine) {
        return false;
    }
}

