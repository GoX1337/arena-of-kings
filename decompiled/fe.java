/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class fe
implements axr {
    private ayh var_ayh_a;
    private ayh b;
    private int var_int_a = 0;
    private boolean var_boolean_a = false;

    public fe(TextureAtlas textureAtlas, String string, int n2, int n3) {
        this.var_ayh_a = new ayh(textureAtlas.createSprite(string));
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2, n3);
        this.b = new ayh(textureAtlas.createSprite("x_grayed"));
        this.b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(n2 + 190, n3 + 10);
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        en en2;
        int n2;
        for (n2 = 0; n2 < ay.ay_a().gd_a().ev_a().a().size; ++n2) {
            en2 = ay.ay_a().gd_a().ev_a().a().getValueAt(n2);
            if (en2 == null) {
                return;
            }
            en2.a(f2, engine, n2);
            if (!en2.boolean_a()) continue;
            for (int i2 = 0; i2 < en2.a().size; ++i2) {
                g g2 = en2.a().get(i2);
                for (int i3 = 0; i3 < g2.a().size(); ++i3) {
                    d d2 = g2.a().get(i3);
                    d2.remove();
                }
            }
            this.var_boolean_a = true;
            ay.ay_a().gd_a().ev_a().a().removeIndex(n2);
            break;
        }
        if (this.var_boolean_a) {
            for (n2 = 0; n2 < ay.ay_a().gd_a().ev_a().a().size; ++n2) {
                en2 = ay.ay_a().gd_a().ev_a().a().getValueAt(n2);
                if (en2 == null) {
                    return;
                }
                en2.a(n2++);
            }
            ay.ay_a().gd_a().ev_a().void_a();
            this.var_boolean_a = false;
        }
    }
}

