/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class azk<T>
implements axr {
    public Array<T> var_com_badlogic_gdx_utils_Array_T__a;
    public ayh var_ayh_a;
    public ayh var_ayh_b;
    public ayh var_ayh_c;
    protected int var_int_a = 5;
    protected int var_int_b = 0;
    protected int var_int_c;
    protected float var_float_a;
    protected float var_float_b;
    protected float var_float_c;
    protected float d;
    protected float e;
    protected float f = 0.0f;
    protected float g = 0.0f;
    protected float h;
    protected float i;
    protected float j = 0.0f;
    protected float k;
    protected float l;

    public azk(TextureAtlas textureAtlas, String string, String string2, String string3, int n2, int n3) {
        this.var_ayh_a = new ayh(textureAtlas.createSprite(string));
        this.var_ayh_b = new ayh(textureAtlas.createSprite(string2));
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.2f);
        this.var_ayh_c = new ayh(textureAtlas.createSprite(string3));
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2, n3);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 350, n3);
        this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 346, n3 + 310);
        this.var_int_c = (int)this.var_ayh_c.com_badlogic_gdx_graphics_g2d_Sprite_a().getY();
        this.var_com_badlogic_gdx_utils_Array_T__a = new Array();
    }

    protected void a() {
        this.var_float_b = 0.0f;
        this.var_float_a = 1.0f / (float)(this.var_com_badlogic_gdx_utils_Array_T__a.size - 5);
        this.d = 0.0f;
        this.e = 280.0f;
        this.var_float_c = this.e * this.var_float_a;
        this.j = 0.0f;
        this.k = 280.0f;
        this.h = this.e * this.var_float_a;
        this.i = 0.0f;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayh_a.a(f2, engine);
        this.var_ayh_b.a(f2, engine);
        this.var_ayh_c.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.var_ayh_c.c((int)((float)this.var_int_c - (this.i + this.g + this.f) * this.k));
    }

    public void b() {
        int n2;
        this.g += this.f;
        this.f = 0.0f;
        this.var_int_b = n2 = (int)(this.l / this.var_float_a);
        this.var_int_a = this.var_int_b + 5;
        if (this.var_int_a >= this.var_com_badlogic_gdx_utils_Array_T__a.size) {
            this.var_int_a = this.var_com_badlogic_gdx_utils_Array_T__a.size - 1;
            this.var_int_b = this.var_int_a - 5;
            Engine.b("CORRECTED Top: " + this.var_int_b + " Buttom: " + this.var_int_a);
        } else {
            Engine.b("Top: " + this.var_int_b + " SIZE: " + this.var_com_badlogic_gdx_utils_Array_T__a.size + " Bottom: " + this.var_int_a);
        }
    }

    public void b(int n2) {
        int n3;
        if (this.i + (float)n2 / this.k + this.g > 0.0f && this.i + (float)n2 / this.k + this.g < 1.0f) {
            this.f = (float)n2 / this.k;
        }
        Engine.b("SLIDE percentScrolled: " + this.i + " %amount: " + (float)n2 / this.k + " slideTotal: " + this.g + " slideAmount: " + this.f);
        this.l = this.i + this.f + this.g;
        this.var_int_b = n3 = (int)(this.l / this.var_float_a);
        this.var_int_a = this.var_int_b + 5;
        if (this.var_int_a >= this.var_com_badlogic_gdx_utils_Array_T__a.size) {
            this.var_int_a = this.var_com_badlogic_gdx_utils_Array_T__a.size - 1;
            this.var_int_b = this.var_int_a - 5;
            Engine.b("CORRECTED Top: " + this.var_int_b + " Buttom: " + this.var_int_a);
        } else {
            Engine.b("Top: " + this.var_int_b + " SIZE: " + this.var_com_badlogic_gdx_utils_Array_T__a.size + " Bottom: " + this.var_int_a);
        }
        Engine.b("Slide out");
    }

    public void c() {
        if (this.var_int_a < this.var_com_badlogic_gdx_utils_Array_T__a.size - 1) {
            ++this.var_int_a;
            ++this.var_int_b;
        }
        if (this.var_int_a >= this.var_com_badlogic_gdx_utils_Array_T__a.size) {
            this.var_int_a = this.var_com_badlogic_gdx_utils_Array_T__a.size - 1;
            this.var_int_b = this.var_int_a - 5;
            Engine.b("CORRECTED Top: " + this.var_int_b + " Buttom: " + this.var_int_a);
        } else {
            Engine.b("Top: " + this.var_int_b + " SIZE: " + this.var_com_badlogic_gdx_utils_Array_T__a.size + " Bottom: " + this.var_int_a);
        }
        this.i += this.var_float_a;
        if (this.i + this.f + this.g + this.var_float_a > 1.0f) {
            this.i = 1.0f;
            this.f = 0.0f;
            this.g = 0.0f;
        }
        Engine.b("DOWN percentScrolled: " + this.i + " yPercentIncrement: " + this.var_float_a);
    }

    public void d() {
        if (this.var_int_b > 0) {
            --this.var_int_a;
            --this.var_int_b;
        }
        if (this.var_int_a >= this.var_com_badlogic_gdx_utils_Array_T__a.size) {
            this.var_int_a = this.var_com_badlogic_gdx_utils_Array_T__a.size - 1;
            this.var_int_b = this.var_int_a - 5;
            Engine.b("CORRECTED Top: " + this.var_int_b + " Buttom: " + this.var_int_a);
        } else {
            Engine.b("Top: " + this.var_int_b + " SIZE: " + this.var_com_badlogic_gdx_utils_Array_T__a.size + " Bottom: " + this.var_int_a);
        }
        this.i -= this.var_float_a;
        if (this.i + this.f + this.g - this.var_float_a < 0.0f) {
            this.i = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
        }
        Engine.b("UP percentScrolled: " + this.i + " yPercentIncrement: " + this.var_float_a);
    }
}

