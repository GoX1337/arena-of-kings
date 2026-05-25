/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class agv
implements axr {
    protected ayh var_ayh_a;
    protected double var_double_a;
    protected double b;

    public agv(TextureAtlas textureAtlas, String string) {
        this.var_ayh_a = new ayh(textureAtlas.createSprite(string), true);
    }

    public void a(double d2, double d3) {
        this.var_double_a = d2;
        this.b = d3;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a() != null && ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer() != null && (ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ahs_a().agv_a() == this || ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().com_arenaofkings_packets_gameserver_data_Target_a().getPlayer().com_arenaofkings_packets_gameserver_data_player_shared_SharedAccountData_a().getActive_character_entity().ahs_a().b() == this)) {
            TextureRegion textureRegion = new TextureRegion(this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a(), 0, 0, (int)(this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() * (float)(this.var_double_a / this.b)), (int)this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight());
            engine.var_azi_a.draw(textureRegion, this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX(), this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY());
        } else {
            TextureRegion textureRegion = new TextureRegion(this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a(), 0, 0, (int)(this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() * (float)(this.var_double_a / this.b)), (int)this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight());
            Sprite sprite = new Sprite(textureRegion);
            sprite.setAlpha(0.75f);
            sprite.setX(this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getX());
            sprite.setY(this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().getY());
            sprite.draw(engine.var_azi_a);
        }
    }

    public ayh ayh_a() {
        return this.var_ayh_a;
    }

    public double double_a() {
        return this.var_double_a;
    }

    public double b() {
        return this.b;
    }
}

