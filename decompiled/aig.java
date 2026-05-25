/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class aig
extends aid {
    private ayh a;
    private int b;
    private int c;

    public aig(Engine engine, ayh ayh2, int n2, int n3, String string, Color color, boolean bl2, float f2, float f3) {
        super(engine, string, color, bl2, f2, f3);
        this.a = ayh2;
        ((GlyphLayout)((Object)this.a)).setText(((axy)((Object)this.a)).a(), string);
        this.b = (int)((double)n2 + (double)((GlyphLayout)((Object)this.a)).width * 6.5 + 8.0);
        this.c = (int)((float)n3 - ((GlyphLayout)((Object)this.a)).height) - 18;
    }

    @Override
    public void b(float f2, Engine engine) {
        super.b(f2, engine);
        if (this.a != null) {
            this.a.a(f2, engine.var_azi_a, (int)this.a - 24, (int)this.b + 4, ((axy)((Object)this.a)).a().getColor().a);
        }
    }
}

