/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ayf
implements axr {
    protected Sprite var_com_badlogic_gdx_graphics_g2d_Sprite_b;
    protected Sprite var_com_badlogic_gdx_graphics_g2d_Sprite_c;
    protected boolean var_boolean_b;
    protected boolean var_boolean_c;
    protected boolean var_boolean_d;
    protected boolean e;
    protected boolean f = false;
    protected float a;
    protected float var_float_b;
    protected float var_float_c;
    protected float var_float_d;

    @Deprecated
    public ayf() {
    }

    public ayf(int n2, int n3, TextureAtlas textureAtlas, String string, String string2, boolean bl2) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_b = new Sprite(textureAtlas.createSprite(string));
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.setPosition(n2, n3);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_c = new Sprite(textureAtlas.createSprite(string2));
        float f2 = 0.0f;
        float f3 = 0.0f;
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_c.setPosition((float)n2 + f2, (float)n3 + f3);
        this.e = bl2;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.a(engine);
        this.e();
        if (this.var_boolean_c) {
            this.void_a();
        }
        if (this.var_boolean_d) {
            this.void_b();
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.e) {
            if (!this.var_boolean_b) {
                this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.draw(engine.var_azi_a);
            } else {
                this.var_com_badlogic_gdx_graphics_g2d_Sprite_c.draw(engine.var_azi_a);
            }
        }
    }

    public void a(float f2, Engine engine, int n2, int n3) {
        if (this.e) {
            float f3 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.getX();
            float f4 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.getY();
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.setPosition(n2, n3);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_c.setPosition(n2, n3);
            this.a(engine);
            if (!this.var_boolean_b) {
                this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.draw(engine.var_azi_a);
            } else {
                this.var_com_badlogic_gdx_graphics_g2d_Sprite_c.draw(engine.var_azi_a);
            }
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.setPosition(f3, f4);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_c.setPosition(f3, f4);
        }
    }

    public void b(float f2, Engine engine, int n2, int n3) {
        if (this.e) {
            float f3 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.getX();
            float f4 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.getY();
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.setPosition(n2, n3);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_c.setPosition(n2, n3);
            if (!this.var_boolean_b) {
                this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.draw(engine.var_azi_a);
            } else {
                this.var_com_badlogic_gdx_graphics_g2d_Sprite_c.draw(engine.var_azi_a);
            }
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.setPosition(f3, f4);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_c.setPosition(f3, f4);
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_c;
    }

    public boolean boolean_b() {
        return this.var_boolean_b;
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f = true;
        this.a = f2;
        this.var_float_c = f3;
        this.var_float_b = f4;
        this.var_float_d = f5;
        Engine.b("x1: " + f2 + " x2: " + f4 + " y1: " + f3 + " y2: " + f5);
    }

    public void a(Engine engine) {
        if (this.f) {
            if (engine.var_com_badlogic_gdx_math_Vector3_a.x >= this.a && engine.var_com_badlogic_gdx_math_Vector3_a.x <= this.var_float_b && engine.var_com_badlogic_gdx_math_Vector3_a.y >= this.var_float_c && engine.var_com_badlogic_gdx_math_Vector3_a.y <= this.var_float_d) {
                this.var_boolean_b = true;
                this.void_c();
            } else {
                this.var_boolean_b = false;
                this.d();
            }
        } else if (engine.var_com_badlogic_gdx_math_Vector3_a.x >= this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.getX() && engine.var_com_badlogic_gdx_math_Vector3_a.x <= this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.getX() + this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.getWidth() && engine.var_com_badlogic_gdx_math_Vector3_a.y >= this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.getY() && engine.var_com_badlogic_gdx_math_Vector3_a.y <= this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.getY() + this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.getHeight()) {
            this.var_boolean_b = true;
            this.void_c();
        } else {
            this.var_boolean_b = false;
            this.d();
        }
    }

    public void void_c() {
        this.var_boolean_b = true;
    }

    public void d() {
        this.var_boolean_b = false;
    }

    public void e() {
        this.var_boolean_c = Gdx.input.isButtonPressed(0) && Gdx.input.justTouched() && this.var_boolean_b;
        this.var_boolean_d = Gdx.input.isButtonPressed(1) && Gdx.input.justTouched() && this.var_boolean_b;
    }

    public void void_a() {
    }

    public void void_b() {
    }

    public void f() {
        this.e = !this.e;
    }

    public boolean boolean_c() {
        return this.e;
    }

    public void a(boolean bl2) {
        this.e = bl2;
    }

    public void b(boolean bl2) {
        this.var_boolean_b = bl2;
    }

    public void a(float f2, float f3) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_b.setPosition(f2, f3);
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_c.setPosition(f2, f3);
    }

    public Sprite com_badlogic_gdx_graphics_g2d_Sprite_a() {
        return this.var_com_badlogic_gdx_graphics_g2d_Sprite_c;
    }

    public Sprite com_badlogic_gdx_graphics_g2d_Sprite_b() {
        return this.var_com_badlogic_gdx_graphics_g2d_Sprite_b;
    }
}

