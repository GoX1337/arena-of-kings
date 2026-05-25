/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class aic
extends aib {
    private ayh a;
    private float g;
    private float h;

    public aic(Engine engine, ayh ayh2, int n2, int n3, String string, Color color, boolean bl2, float f2, float f3) {
        super(engine, string, color, bl2, f2, f3);
        this.c = true;
        ((azv)((Object)this.a)).a(2000L);
        this.a = ayh2;
        ((GlyphLayout)((Object)this.a)).setText(((axy)((Object)this.a)).a(), string);
        this.g = (int)(f2 + ((GlyphLayout)((Object)this.a)).width + 20.0f);
        this.h = n3;
    }

    @Override
    public void b(float f2, Engine engine) {
        this.b += f2 * 20.0f;
        this.h += f2 * 20.0f;
        this.a.com_badlogic_gdx_graphics_g2d_Sprite_a().setY(this.h);
        super.b(f2, engine);
        if (this.a != null) {
            this.a.a(f2, engine.var_azi_a, (int)this.g, (int)this.h, ((Color)((Object)this.a)).a);
        }
    }
}

