/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.audio.Sound;

public class ajm
extends ail {
    public ajm(int n2) {
        super(n2);
    }

    @Override
    public boolean boolean_a(Engine engine) {
        if (ay.ay_a().gd_a().boolean_b()) {
            return true;
        }
        if (ay.ay_a().gu_a().a(engine, ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_b())) {
            ((Sound)((agd)engine.axc_a()).axm_a().com_badlogic_gdx_utils_Disposable_a(ajw.iU)).play(0.155f);
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().ajw_a() != null) {
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

