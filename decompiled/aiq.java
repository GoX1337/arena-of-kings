/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.badlogic.gdx.audio.Sound;

public class aiq
extends ail {
    public aiq(int n2) {
        super(n2);
    }

    @Override
    public boolean boolean_a(Engine engine) {
        if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_e() && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_a() && !((agd)engine.axc_a()).agn_a().i_a().boolean_a()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().a(PlayerAction.RUN_SOUTH, false);
            if (ay.ay_a().gu_a().ui_a() != null && !ay.ay_a().gu_a().ui_a().boolean_a() && ay.ay_a().gu_a().ui_a().hf_a().uk_a() == uk.var_uk_a) {
                if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b() != null) {
                    Sound sound;
                    ajw ajw2 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_b();
                    if (((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw2) != null && (sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw2)) != null) {
                        sound.stop();
                    }
                }
            } else if (ay.ay_a().gu_a().ui_a() != null && !ay.ay_a().gu_a().ui_a().boolean_a() && ay.ay_a().gu_a().ui_a().hf_a().uk_a() == uk.d && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null) {
                Sound sound;
                ajw ajw3 = ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a();
                if (((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw3) != null && (sound = (Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw3)) != null) {
                    sound.stop();
                }
            }
            if (((agd)engine.axc_a()).boolean_b()) {
                ((agd)engine.axc_a()).f(true);
            }
        }
        ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().e(PlayerAction.RUN_SOUTH);
        if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().boolean_a()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().c(PlayerAction.RUN_SOUTH);
        }
        return true;
    }

    @Override
    public boolean b(Engine engine) {
        if (!((agd)engine.axc_a()).agn_a().i_a().boolean_a()) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().f(PlayerAction.RUN_SOUTH);
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(PlayerAction.RUN_SOUTH);
        }
        return true;
    }
}

