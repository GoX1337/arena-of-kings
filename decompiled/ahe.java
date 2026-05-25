/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ahe
extends agw {
    public ahe(TextureAtlas textureAtlas) {
        super(textureAtlas, "my_health_vial_v2", "my_health_bar_v2");
        this.b(775.0f, 28.0f);
        this.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().double_b());
    }

    @Override
    public void a(float f2, Engine engine) {
        this.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().double_a(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().double_b());
    }

    @Override
    public void b(float f2, Engine engine) {
        super.b(f2, engine);
        engine.a((int)this.a + " / " + (int)this.b, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 960.0f, 46.0f, 1, 1);
    }
}

