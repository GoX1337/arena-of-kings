/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.requests.input.TargetRequest;

public class aii
extends ail {
    private boolean c = false;

    public aii(int n2) {
        super(n2);
    }

    @Override
    @Deprecated
    public boolean boolean_a(Engine engine) {
        if (ay.ay_a().gd_a().boolean_b()) {
            return true;
        }
        Engine.b("processPlay: " + this.c);
        if (this.c && t.a(agd.class, engine)) {
            Engine.b("processPlayeee targname: " + ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName());
            ((agd)engine.axc_a()).agn_a().i_a().n();
            ((agd)engine.axc_a()).agn_a().i_a().axh_a().setDisabled(true);
            Engine.b("set disabled");
        }
        if (!ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getIdentifyingName().equals("")) {
            engine.var_baa_a.a(ajw.kE, 0.135f);
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().setIdentifyingName("");
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().setID(-1);
            engine.var_ag_a.a(new TargetRequest(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a()));
            return true;
        }
        return false;
    }

    @Override
    public boolean b(Engine engine) {
        return false;
    }

    public void void_a() {
        this.c = true;
    }
}

