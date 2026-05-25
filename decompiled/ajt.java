/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.gameserver.data.ScoreboardUpdate;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class ajt
implements axr {
    private final TextureAtlas var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a = new Array();
    private final TextureAtlas var_com_badlogic_gdx_graphics_g2d_TextureAtlas_b;
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private ayh var_ayh_c;
    private boolean var_boolean_a;
    private Array<aju> var_com_badlogic_gdx_utils_Array_aju__a;
    private boolean var_boolean_b = false;
    private boolean var_boolean_c = false;
    private float var_float_a = 0.0f;
    private azv var_azv_a;

    public ajt(TextureAtlas textureAtlas, TextureAtlas textureAtlas2) {
        this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a = textureAtlas;
        this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_b = textureAtlas2;
        this.var_ayh_a = new ayh(375, 190, textureAtlas, "scoreboard_panel", true);
        this.var_ayh_b = new ayh(834, 816, textureAtlas, "victory_label", true);
        this.var_ayh_c = new ayh(834, 816, textureAtlas, "defeat_label", true);
        this.var_azv_a = new azv(1000L, false);
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_boolean_b && this.var_azv_a.boolean_b()) {
            aju aju2;
            System.out.println("Rendering scoreboard");
            this.var_float_a = this.var_float_a < 1.0f && this.var_float_a + f2 < 1.0f ? (this.var_float_a += f2) : 1.0f;
            this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_a);
            this.var_ayh_a.b(f2, engine);
            if (this.var_boolean_a) {
                this.var_ayh_b.b(f2, engine);
            } else {
                this.var_ayh_c.b(f2, engine);
            }
            Iterator iterator = ((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).iterator();
            while (iterator.hasNext()) {
                aju2 = (aju)iterator.next();
                aju2.a().com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_a);
                aju2.c(f2, engine);
            }
            iterator = ((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).iterator();
            while (iterator.hasNext()) {
                aju2 = (aju)iterator.next();
                aju2.a().com_badlogic_gdx_graphics_g2d_Sprite_a().setAlpha(this.var_float_a);
                aju2.b(f2, engine);
            }
        }
    }

    public void a(Engine engine, Array<ScoreboardUpdate> array) {
        for (int i2 = 0; i2 < array.size; ++i2) {
            ((Array)((Object)this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a)).add(new aju(engine, this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_a, this.var_com_badlogic_gdx_graphics_g2d_TextureAtlas_b, i2, array.get(i2)));
            if (!array.get(i2).getPlayer_name().equals(ay.ay_a().com_arenaofkings_packets_gameserver_data_player_me_MyAccountData_a().getActive_character_entity().java_lang_String_a())) continue;
            this.var_boolean_a = array.get((int)i2).victory;
        }
        ay.ay_a().gf_a().c();
        ay.ay_a().gf_a().d();
        this.var_boolean_c = true;
        this.var_boolean_b = true;
        this.b();
    }

    public void void_a() {
        this.var_boolean_b = !this.var_boolean_b;
    }

    public boolean boolean_a() {
        return this.var_boolean_c;
    }

    public void b() {
        this.var_azv_a.void_a();
    }
}

