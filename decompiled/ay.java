/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.player.me.MyAccountData;
import com.arenaofkings.packets.gameserver.data.player.shared.SharedAccountData;
import com.arenaofkings.packets.gameserver.requests.input.TargetRequest;

public class ay
extends br {
    private static final ay var_ay_a;
    private gd var_gd_a;
    private gf var_gf_a = new gf();
    private ge var_ge_a = new ge();
    private ef var_ef_a = new ef();

    private ay() {
    }

    public static ay ay_a() {
        return var_ay_a;
    }

    public gd gd_a() {
        return this.var_gd_a;
    }

    @Override
    public MyAccountData com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a() {
        return (MyAccountData)((Object)this.var_ay_a);
    }

    public gu gu_a() {
        return (gu)((SharedAccountData)((Object)this.var_ay_a)).getActive_character_entity().gz_a();
    }

    public gf gf_a() {
        return this.var_gf_a;
    }

    public ge ge_a() {
        return this.var_ge_a;
    }

    public void a(Engine engine, gd gd2, MyAccountData myAccountData) {
        this.var_gd_a = gd2;
        this.var_ay_a = myAccountData;
        if (!this.com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getCharacterEntities().isEmpty()) {
            this.var_gf_a.a(this);
        }
    }

    public br br_a(String string) {
        if (ay.ay_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity() != null && string.equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a())) {
            return ay.ay_a();
        }
        br br2 = (br)this.var_gf_a.a().get(string);
        if (br2 == null) {
            br2 = (br)this.var_ge_a.a().get(string);
        }
        return br2;
    }

    @Override
    public void a(float f2, Engine engine, ayh ayh2, ayh ayh3) {
        super.a(f2, engine, ayh2, ayh3);
    }

    @Override
    protected void a(float f2, Engine engine) {
        this.gu_a().boolean_a();
        super.a(f2, engine);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().boolean_b() && !ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().f() && !ay.ay_a().boolean_a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer())) {
            ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().setIdentifyingName("");
            engine.var_ag_a.a(new TargetRequest(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a()));
        }
    }

    public boolean boolean_a(br br2) {
        if (br2 == null) {
            return false;
        }
        for (br br3 : this.var_gf_a.a().values()) {
            if (br3 != br2) continue;
            return true;
        }
        return false;
    }

    public boolean boolean_a(String string) {
        if (string == null) {
            return false;
        }
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a().equals(string)) {
            return true;
        }
        for (br br2 : this.var_gf_a.a().values()) {
            if (!br2.com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().java_lang_String_a().equals(string)) continue;
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean boolean_a() {
        return false;
    }

    @Override
    public int int_a() {
        return this.var_gd_a.int_d();
    }

    @Override
    public void a(int n2) {
        if (ao.a(n2) != ao.a(this.var_gd_a.int_d())) {
            ((SharedAccountData)((Object)this.var_ay_a)).getActive_character_entity().bd_a().c(false);
        }
        this.var_gd_a.d(n2);
    }

    @Override
    public void void_a() {
        this.var_gd_a = null;
        this.var_ay_a = null;
        this.var_gf_a = new gf();
        this.var_ge_a = new ge();
        this.var_ef_a = new ef();
    }

    static {
        var_ay_a = new ay();
    }
}

