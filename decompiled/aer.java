/*
 * Decompiled with CFR 0.152.
 */
import com.badlogic.gdx.graphics.Color;

public class aer {
    protected String var_java_lang_String_a = "";
    protected int var_int_a;
    protected int var_int_b;
    protected int var_int_c;
    protected int d;
    protected int e;
    protected float var_float_a;
    protected float var_float_b;
    protected float var_float_c;
    protected yt var_yt_a;
    protected Color var_com_badlogic_gdx_graphics_Color_a = Color.WHITE;

    public aer(String string, int n2, float f2, float f3, int n3, int n4, yt yt2) {
        this.var_java_lang_String_a = string;
        this.var_int_a = n3;
        this.var_int_b = n4;
        this.e = n2;
        this.var_float_b = f3;
        this.var_float_a = f2;
        this.var_yt_a = yt2;
    }

    public void a(float f2) {
        this.var_float_c = f2;
    }

    public float float_a() {
        return this.var_float_c;
    }

    public void a(Color color) {
        this.var_com_badlogic_gdx_graphics_Color_a = color;
    }

    public void a(int n2) {
        this.var_int_c = n2;
    }

    public void b(int n2) {
        this.d = n2;
    }

    public int int_a() {
        return this.var_int_c;
    }

    public int int_b() {
        return this.d;
    }

    public Color com_badlogic_gdx_graphics_Color_a() {
        return this.var_com_badlogic_gdx_graphics_Color_a;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public int int_c() {
        return this.e;
    }

    public float float_b() {
        return this.var_float_b;
    }

    public float float_c() {
        return this.var_float_a;
    }

    public int d() {
        return this.var_int_a;
    }

    public int e() {
        return this.var_int_b;
    }

    public yt yt_a() {
        return this.var_yt_a;
    }
}

