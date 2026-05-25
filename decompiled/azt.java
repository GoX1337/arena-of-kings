/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class azt
implements axr {
    protected String var_java_lang_String_a;
    protected BitmapFont var_com_badlogic_gdx_graphics_g2d_BitmapFont_a;
    protected int var_int_a;
    protected int var_int_b;
    protected boolean var_boolean_a = true;
    protected boolean var_boolean_b = false;

    public azt(String string, BitmapFont bitmapFont) {
        this.var_java_lang_String_a = string;
        this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a = bitmapFont;
        this.var_int_a = 0;
        this.var_int_b = 0;
    }

    public void a(Engine engine) {
        if (engine.var_com_badlogic_gdx_math_Vector3_a.x >= (float)(this.var_int_a - azu.a(engine, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a, this.var_java_lang_String_a) - 2) && engine.var_com_badlogic_gdx_math_Vector3_a.x <= (float)(this.var_int_a + (azu.a(engine, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a, this.var_java_lang_String_a) + 2)) && engine.var_com_badlogic_gdx_math_Vector3_a.y >= (float)(this.var_int_b - azu.b(engine, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a, this.var_java_lang_String_a) - 2) && engine.var_com_badlogic_gdx_math_Vector3_a.y <= (float)(this.var_int_b + (azu.b(engine, this.var_com_badlogic_gdx_graphics_g2d_BitmapFont_a, this.var_java_lang_String_a) + 2))) {
            this.var_boolean_b = true;
            this.void_a();
        } else {
            this.var_boolean_b = false;
            this.b();
        }
    }

    public void void_a() {
    }

    public void b() {
    }

    public boolean boolean_a() {
        return this.var_boolean_b;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.a(engine);
    }

    @Override
    public void b(float f2, Engine engine) {
    }

    public void a(int n2, int n3) {
        this.var_int_a = n2;
        this.var_int_b = n3;
    }

    public void a(String string) {
        this.var_java_lang_String_a = string;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }
}

