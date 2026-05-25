/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.requests.input.TargetRequest;

public class ajl
extends ail {
    public ajl(int n2) {
        super(n2);
    }

    @Override
    public boolean boolean_a(Engine engine) {
        if (t.a(agd.class, engine)) {
            System.out.println("c1");
            if (!((agd)engine.axc_a()).agn_a().i_a().boolean_b()) {
                ((agd)engine.axc_a()).agn_a().i_a().o();
            }
            System.out.println("ct in");
            if (ay.ay_a().gd_a().boolean_b()) {
                System.out.println("ct 2");
                if (((agd)engine.axc_a()).agn_a().i_a().boolean_b()) {
                    System.out.println("ct 3");
                    ((agd)engine.axc_a()).agn_a().void_c();
                }
                return true;
            }
            if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName().equals("")) {
                engine.var_baa_a.a(ajw.kE, 0.135f);
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().setIdentifyingName("");
                ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().setID(-1);
                engine.var_ag_a.a(new TargetRequest(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a()));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean b(Engine engine) {
        return false;
    }
}

