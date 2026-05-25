/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class agw
implements axr {
    protected ayh var_ayh_a;
    protected ayh var_ayh_b;
    protected double var_double_a;
    protected double var_double_b;

    public agw(TextureAtlas textureAtlas, String string, String string2) {
        this.var_ayh_a = new ayh(textureAtlas.createSprite(string), true);
        this.var_ayh_b = new ayh(textureAtlas.createSprite(string2), true);
    }

    public void a(float f2, float f3) {
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f2, f3);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f2 + 4.0f, f3 + 1.0f);
    }

    public void b(float f2, float f3) {
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f2, f3);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f2, f3);
    }

    public void c(float f2, float f3) {
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f2, f3);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(f2, f3);
    }

    public void a(double d2, double d3) {
        this.var_double_a = d2;
        this.var_double_b = d3;
    }

    public void a(int n2, int n3, double d2, double d3) {
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2, n3);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2, n3);
        this.var_double_a = d2;
        this.var_double_b = d3;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        this.var_ayh_a.b(f2, engine);
        TextureRegion textureRegion = new TextureRegion(this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a(), 0, 0, (int)(this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() * (float)(this.var_double_a / this.var_double_b)), (int)this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight());
        engine.var_azi_a.draw(textureRegion, this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getX(), this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getY());
    }

    public void a(float f2, Engine engine, float f3) {
        this.a(f2, engine);
        this.var_ayh_a.a(f2, engine, f3);
        TextureRegion textureRegion = new TextureRegion(this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a(), 0, 0, (int)(this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() * (float)(this.var_double_a / this.var_double_b)), (int)this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight());
        engine.var_azi_a.draw(textureRegion, this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getX(), this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getY());
    }

    public void a(float f2, Engine engine, int n2, int n3, float f3) {
        this.a(f2, engine);
        this.var_ayh_a.a(f2, engine, n2, n3, f3);
        TextureRegion textureRegion = new TextureRegion(this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a(), 0, 0, (int)(this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() * (float)(this.var_double_a / this.var_double_b)), (int)this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight());
        engine.var_azi_a.draw(textureRegion, (float)n2, (float)n3);
    }

    public void a(float f2, Engine engine, int n2, int n3) {
        this.c(n2, n3);
        this.a(f2, engine);
        this.var_ayh_a.b(f2, engine);
        TextureRegion textureRegion = new TextureRegion(this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a(), 0, 0, (int)(this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getWidth() * (float)(this.var_double_a / this.var_double_b)), (int)this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getHeight());
        engine.var_azi_a.draw(textureRegion, this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getX(), this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().getY());
    }

    public ayh a() {
        return this.var_ayh_b;
    }
}

