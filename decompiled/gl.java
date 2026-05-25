/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class gl
implements axr {
    private String var_java_lang_String_a = "";
    private azv var_azv_a = new azv(25000L, false);
    private gm var_gm_a;
    private boolean var_boolean_a = false;

    public gl(Engine engine, TextureAtlas textureAtlas) {
        this.var_gm_a = new gm(engine, textureAtlas, this);
    }

    public void a(String string) {
        this.var_java_lang_String_a = string;
        this.var_azv_a.d();
        this.var_azv_a.void_a();
    }

    public void a() {
        this.var_java_lang_String_a = "";
        this.var_azv_a.d();
    }

    @Override
    public void a(float f2, Engine engine) {
        if (this.var_java_lang_String_a != "" && this.var_azv_a.boolean_b()) {
            this.a();
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (this.var_java_lang_String_a != "" && !this.var_azv_a.boolean_b()) {
            this.var_gm_a.b(f2, engine);
            engine.var_com_badlogic_gdx_graphics_g2d_BitmapFont_g.draw((Batch)engine.var_azi_a, this.var_java_lang_String_a, 1675.0f, 475.0f);
        }
    }
}

