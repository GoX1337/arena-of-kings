/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class aid
extends aie {
    protected GlyphLayout var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a;
    protected axy var_axy_a;
    protected Color var_com_badlogic_gdx_graphics_Color_a;
    protected Color b;
    protected Color var_com_badlogic_gdx_graphics_Color_c;
    protected float var_float_c;
    protected float d;
    protected float e = 0.0f;
    private float f = 0.0f;

    public aid(Engine engine, String string, Color color, boolean bl2, float f2, float f3) {
        this.var_axy_a = new axy(engine.x);
        this.var_com_badlogic_gdx_graphics_Color_c = this.var_axy_a.a().getColor();
        this.var_float_c = this.var_axy_a.a().getScaleX();
        this.d = this.var_axy_a.a().getScaleY();
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a = new GlyphLayout(this.var_axy_a.a(), string, Color.BLACK, 0.0f, 1, true);
        this.b = color;
        this.var_com_badlogic_gdx_graphics_Color_a = new Color(0.0f, 0.0f, 0.0f, 0.0f);
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a = string;
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a = (GlyphLayout)bl2;
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a = new azv(1000L, true);
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a = (GlyphLayout)f2;
        this.b = (Color)f3;
        this.b += 20.0f;
        this.var_com_badlogic_gdx_graphics_Color_a.set(0.0f, 0.0f, 0.0f, this.var_axy_a.a().getColor().a);
        this.b = (Color)false;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.e += f2;
        if (this.e >= 0.85f) {
            this.f += f2 * 6.65f;
            this.var_axy_a.a().getColor().set(this.var_axy_a.a().getColor().r, this.var_axy_a.a().getColor().g, this.var_axy_a.a().getColor().b, 1.0f - this.f);
            this.var_com_badlogic_gdx_graphics_Color_a.set(0.0f, 0.0f, 0.0f, this.var_axy_a.a().getColor().a);
        }
    }

    private void void_a() {
        this.var_com_badlogic_gdx_graphics_Color_c = this.var_axy_a.a().getColor();
        this.var_axy_a.a().setColor(this.b);
    }

    private void void_b() {
        this.var_axy_a.a().setColor(this.var_com_badlogic_gdx_graphics_Color_c);
        this.var_axy_a.a().getData().setScale(1.0f);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.void_a();
        this.a(f2, engine);
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(this.var_axy_a.a(), (CharSequence)((Object)this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a), this.var_com_badlogic_gdx_graphics_Color_a, 0.0f, 1, false);
        this.var_axy_a.a().draw((Batch)engine.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, (float)(this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a - 1.0f), (float)this.b);
        this.var_axy_a.a().draw((Batch)engine.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, (float)this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, (float)this.b);
        this.var_axy_a.a().draw((Batch)engine.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, (float)(this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a + 1.0f), (float)this.b);
        this.var_axy_a.a().draw((Batch)engine.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, (float)this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, (float)(this.b + 1.0f));
        this.var_axy_a.a().draw((Batch)engine.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, (float)this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, (float)(this.b - 1.0f));
        this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a.setText(this.var_axy_a.a(), (CharSequence)((Object)this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a), this.var_axy_a.a().getColor(), 0.0f, 1, false);
        this.var_axy_a.a().draw((Batch)engine.var_azi_a, this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, (float)this.var_com_badlogic_gdx_graphics_g2d_GlyphLayout_a, (float)this.b);
        this.void_b();
    }
}

