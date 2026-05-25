/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.updates.SpellBarState;
import com.arenaofkings.packets.gameserver.requests.input.TRINKET_REQUEST_0;
import com.arenaofkings.packets.misc.CharacterClass;
import com.badlogic.gdx.audio.Sound;

public class ajk
extends ail {
    public ajk(int n2) {
        super(n2);
    }

    @Override
    public boolean boolean_a(Engine engine) {
        if (ay.ay_a().gd_a().boolean_b()) {
            return true;
        }
        fu fu2 = ay.ay_a().gu_a().fu_a();
        if (fu2 != null && fu2.boolean_a() && ay.ay_a().gu_a().com_arenaofkings_packets_gameserver_data_updates_SpellBarState_a() != SpellBarState.CASTING && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_a() && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().double_a() > 0.0) {
            ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw.iU)).play(0.175f);
            if (fu2.hf_a().azv_b().long_a() == 0L) {
                fu2.hd_a().a(30);
            }
            if (fu2.hf_a().uk_a() == uk.var_uk_a) {
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_misc_CharacterClass_a() == CharacterClass.RANGER) {
                    ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a())).play(0.115f);
                }
            } else if (fu2.hf_a().uk_a() == uk.d && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null) {
                ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a())).play(0.115f);
            }
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_b()) {
                engine.var_ag_a.a(new TRINKET_REQUEST_0(true));
            } else {
                engine.var_ag_a.a(new TRINKET_REQUEST_0(false));
            }
            fu2.void_a();
            return true;
        }
        ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw.iV)).play(0.135f);
        return false;
    }

    @Override
    public boolean b(Engine engine) {
        return false;
    }
}

