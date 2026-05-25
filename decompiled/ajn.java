/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.PlayerAction;
import com.badlogic.gdx.Gdx;

public class ajn
extends ail {
    public ajn(int n2) {
        super(n2);
    }

    @Override
    public boolean boolean_a(Engine engine) {
        if (t.a(agd.class, engine)) {
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_d()) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(PlayerAction.RUN_NORTH);
            }
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_e()) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(PlayerAction.RUN_SOUTH);
            }
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_c()) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(PlayerAction.RUN_EAST);
            }
            if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().boolean_f()) {
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().bb_a().d(PlayerAction.RUN_WEST);
            }
            if (!((agd)engine.axc_a()).agn_a().i_a().boolean_a()) {
                if (Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60)) {
                    ((agd)engine.axc_a()).agn_a().i_a().p();
                } else {
                    ((agd)engine.axc_a()).agn_a().i_a().q();
                }
            }
            ((agd)engine.axc_a()).agn_a().i_a().g();
            return false;
        }
        return false;
    }

    @Override
    public boolean b(Engine engine) {
        return false;
    }
}

