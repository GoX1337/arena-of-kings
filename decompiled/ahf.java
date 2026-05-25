/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ahf
extends agw {
    public ahf(TextureAtlas textureAtlas) {
        super(textureAtlas, "my_mana_vial_v2", "my_mana_bar_v2");
        this.b(775.0f, 7.0f);
        this.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
    }

    @Override
    public void a(float f2, Engine engine) {
        this.a(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getCurrentValue(), ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_resources_Resource_a().getMaxValue());
    }

    @Override
    public void b(float f2, Engine engine) {
        super.b(f2, engine);
        if (this.a / this.b <= (double)0.2f) {
            engine.a((int)this.a + " / " + (int)this.b, engine.var_axy_b.a(), Color.RED, engine.var_axy_b.a(), Color.BLACK, 960.0f, 20.0f, 1, 1);
        } else {
            engine.a((int)this.a + " / " + (int)this.b, engine.var_axy_b.a(), Color.WHITE, engine.var_axy_b.a(), Color.BLACK, 960.0f, 20.0f, 1, 1);
        }
    }
}

