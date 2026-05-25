/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ayh
implements axr {
    protected Sprite var_com_badlogic_gdx_graphics_g2d_Sprite_a;
    protected boolean var_boolean_b = true;
    protected boolean var_boolean_c = false;
    protected boolean var_boolean_d = false;
    protected boolean var_boolean_e = false;
    protected boolean var_boolean_f = false;
    protected boolean var_boolean_g;
    protected boolean var_boolean_h;
    protected int var_int_e;
    protected int var_int_f;
    protected int var_int_g;
    protected int var_int_h;
    protected int var_int_i;
    protected int j;
    protected boolean var_boolean_i = false;
    protected float var_float_a;
    protected float var_float_b;
    protected float var_float_c;
    protected float var_float_d;
    protected int k;
    protected int l;

    @Deprecated
    public ayh() {
    }

    public ayh(int n2, int n3, TextureAtlas textureAtlas, String string) {
        if (textureAtlas != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = new Sprite(textureAtlas.createSprite(string));
        }
        if (this.var_com_badlogic_gdx_graphics_g2d_Sprite_a == null) {
            Engine.a("ImageGFX() Constructor failed to create object: " + string);
        } else {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
        }
        this.var_boolean_b = true;
    }

    public ayh(int n2, int n3, TextureAtlas textureAtlas, String string, float f2) {
        if (textureAtlas != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = new Sprite(textureAtlas.createSprite(string));
        }
        if (this.var_com_badlogic_gdx_graphics_g2d_Sprite_a == null) {
            Engine.a("ImageGFX() Constructor failed to create object: " + string);
        } else {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
        }
        this.var_boolean_b = true;
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setScale(f2);
    }

    public ayh(int n2, int n3, TextureAtlas textureAtlas, String string, boolean bl2) {
        if (textureAtlas != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = new Sprite(textureAtlas.createSprite(string));
        }
        if (this.var_com_badlogic_gdx_graphics_g2d_Sprite_a == null) {
            Engine.a("ImageGFX() Constructor failed to create object: " + string);
        } else {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
        }
        this.var_boolean_b = bl2;
    }

    public ayh(int n2, int n3, TextureAtlas textureAtlas, String string, int n4, boolean bl2) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = new Sprite(textureAtlas.createSprite(string, n4));
        if (this.var_com_badlogic_gdx_graphics_g2d_Sprite_a == null) {
            Engine.a("ImageGFX() Constructor failed to create object: " + string);
        } else {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
        }
        this.var_boolean_b = bl2;
    }

    public ayh(int n2, int n3, TextureAtlas textureAtlas, String string, boolean bl2, float f2, boolean bl3) {
        if (textureAtlas != null) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = new Sprite(textureAtlas.createSprite(string));
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setScale(f2);
        }
        if (this.var_com_badlogic_gdx_graphics_g2d_Sprite_a == null) {
            Engine.a("ImageGFX() Constructor failed to create object: " + string);
        } else {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
        }
        this.var_boolean_b = bl3;
    }

    public ayh(Sprite sprite) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = sprite;
    }

    public ayh(Sprite sprite, boolean bl2) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = sprite;
        this.var_boolean_b = bl2;
    }

    public ayh(Sprite sprite, int n2, int n3, boolean bl2) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = sprite;
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
        this.var_boolean_b = bl2;
    }

    public void a(int n2, int n3, Texture texture, boolean bl2) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = new Sprite(texture);
        if (this.var_com_badlogic_gdx_graphics_g2d_Sprite_a == null) {
            Engine.a("ImageGFX() Constructor failed to create object: ");
        } else {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
        }
        this.var_boolean_b = bl2;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.e();
        this.a(engine);
        this.f();
        if (this.var_boolean_f) {
            this.void_c();
        }
    }

    protected void e() {
        if (this.var_boolean_g && this.var_int_e++ >= this.var_int_f) {
            Engine.a("switching from: " + this.var_boolean_b + "to : " + this.var_boolean_h);
            this.var_boolean_b = this.var_boolean_h;
            this.var_boolean_g = false;
            this.var_int_e = 0;
        }
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.var_boolean_b) {
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX() + (float)this.var_int_i, this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY() + (float)this.j);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(engine.var_azi_a);
        }
    }

    public void a(float f2, Engine engine, float f3) {
        if (this.var_boolean_b) {
            float f4 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getColor().a;
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f3);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(engine.var_azi_a);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f4);
        }
    }

    public void b(float f2, Engine engine, int n2, int n3) {
        if (this.var_boolean_b) {
            float f3 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX();
            float f4 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY();
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(engine.var_azi_a);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3, f4);
        }
    }

    public void a(float f2, azi azi2, int n2, int n3, float f3) {
        if (this.var_boolean_b) {
            float f4 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX();
            float f5 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY();
            float f6 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getColor().a;
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f3);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f4, f5);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f6);
        }
    }

    public void a(float f2, azi azi2, float f3, float f4, float f5) {
        if (this.var_boolean_b) {
            float f6 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX();
            float f7 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY();
            float f8 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getColor().a;
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3, f4);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f5);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(azi2);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f6, f7);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f8);
        }
    }

    public void a(float f2, Engine engine, int n2, int n3, float f3) {
        if (this.var_boolean_b) {
            float f4 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX();
            float f5 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY();
            float f6 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getColor().a;
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f3);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(engine.var_azi_a);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f4, f5);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f6);
        }
    }

    public void a(Batch batch, int n2, int n3, float f2) {
        if (this.var_boolean_b) {
            float f3 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX();
            float f4 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY();
            float f5 = this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getColor().a;
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f2);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.draw(batch);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(f3, f4);
            this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setAlpha(f5);
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_e;
    }

    public void f() {
        this.var_boolean_f = Gdx.input.isButtonPressed(0) && Gdx.input.justTouched() && this.var_boolean_e;
    }

    public void a(Engine engine) {
        if (this.var_boolean_i) {
            if (engine.var_com_badlogic_gdx_math_Vector3_a.x >= this.var_float_a && engine.var_com_badlogic_gdx_math_Vector3_a.x <= this.var_float_b && engine.var_com_badlogic_gdx_math_Vector3_a.y >= this.var_float_c && engine.var_com_badlogic_gdx_math_Vector3_a.y <= this.var_float_d) {
                this.var_boolean_e = true;
                this.void_a();
            } else {
                this.var_boolean_e = false;
                this.void_b();
            }
        } else if (engine.var_com_badlogic_gdx_math_Vector3_a.x >= this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX() - (float)this.k && engine.var_com_badlogic_gdx_math_Vector3_a.x <= this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX() + this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getWidth() + (float)this.k && engine.var_com_badlogic_gdx_math_Vector3_a.y >= this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY() - (float)this.l && engine.var_com_badlogic_gdx_math_Vector3_a.y <= this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY() + this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getHeight() + (float)this.l) {
            this.var_boolean_e = true;
            this.void_a();
        } else {
            this.var_boolean_e = false;
            this.void_b();
        }
    }

    public void void_a() {
    }

    public void void_b() {
    }

    public void void_c() {
    }

    public void d() {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getTexture().dispose();
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a = null;
    }

    public boolean boolean_b() {
        return this.var_boolean_b;
    }

    public void a(boolean bl2) {
        this.var_boolean_g = false;
        this.var_boolean_b = bl2;
    }

    public void a(boolean bl2, int n2) {
        this.var_boolean_g = true;
        this.var_boolean_h = this.var_boolean_b;
        this.var_boolean_b = bl2;
        this.var_int_f = n2;
    }

    public void a(int n2) {
        this.var_int_i = n2;
    }

    public void b(int n2) {
        this.j = n2;
    }

    public void b(boolean bl2) {
        this.var_boolean_e = bl2;
    }

    public void a(int n2, int n3) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setPosition(n2, n3);
    }

    public void c(int n2) {
        this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.setY(n2);
    }

    public Sprite com_badlogic_gdx_graphics_g2d_Sprite_a() {
        return this.var_com_badlogic_gdx_graphics_g2d_Sprite_a;
    }

    public int int_b() {
        return (int)this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getX();
    }

    public int int_c() {
        return (int)this.var_com_badlogic_gdx_graphics_g2d_Sprite_a.getY();
    }

    public void g() {
        this.var_boolean_b = !this.var_boolean_b;
    }

    public void b(int n2, int n3) {
        this.k = n2;
        this.l = n3;
    }
}

