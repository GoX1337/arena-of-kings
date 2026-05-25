/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class gg
implements axr {
    private String var_java_lang_String_a = "";
    private azv var_azv_a = new azv(25000L, false);
    private gh var_gh_a;
    private boolean var_boolean_a = false;

    public gg(Engine engine, TextureAtlas textureAtlas) {
        this.var_gh_a = new gh(engine, textureAtlas, this);
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
            this.var_gh_a.b(f2, engine);
            engine.a(this.var_java_lang_String_a, engine.var_axy_e.a(), Color.WHITE, engine.var_axy_e.a(), Color.BLACK, 1714.0f, 479.0f, 1, 1);
        }
    }
}

