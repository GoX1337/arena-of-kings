/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.audio.Sound;

public class aiu
extends ail {
    public aiu(int n2) {
        super(n2);
    }

    @Override
    public boolean boolean_a(Engine engine) {
        if (ay.ay_a().gd_a().boolean_b()) {
            return true;
        }
        Engine.a("mouse: " + engine.var_com_badlogic_gdx_math_Vector3_b.x + "," + engine.var_com_badlogic_gdx_math_Vector3_b.y);
        if (ay.ay_a().gu_a().a(engine, 1, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_b())) {
            ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw.iU)).play(0.155f);
            ui ui2 = ay.ay_a().gu_a().ui_a(1);
            if (ui2.hf_a().azv_b().long_a() == 0L) {
                ui2.hd_a().a(30);
            }
            if (ui2.hf_a().uk_a() == uk.var_uk_a) {
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.RANGER) {
                    ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a())).play(0.115f);
                }
            } else if (ui2.hf_a().uk_a() == uk.d && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null) {
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

