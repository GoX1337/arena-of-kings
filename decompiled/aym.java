/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class aym
implements axr {
    private ayh var_ayh_a;
    private ayh var_ayh_b;
    private abi var_abi_a;
    private int var_int_a;
    private boolean var_boolean_a = false;
    private Color var_com_badlogic_gdx_graphics_Color_a;
    private boolean var_boolean_b = true;

    public aym(Engine engine, TextureAtlas textureAtlas, abi abi2, int n2) {
        this.var_ayh_a = new ayh(414, 870 - n2 * 24, textureAtlas, "mtx_textlabel", true);
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.GRAY);
        this.var_ayh_b = new ayn(this, 683, 892, textureAtlas, "mtx_box", true, engine, n2);
        this.var_abi_a = abi2;
        this.var_int_a = n2;
        this.var_com_badlogic_gdx_graphics_Color_a = axe.x;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayh_a.a(f2, engine);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(683.0f, 863 - this.var_int_a * 24);
        this.var_ayh_b.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        this.var_ayh_a.b(f2, engine);
        if (ay.ay_a().gd_a().a(this.var_abi_a)) {
            engine.a(this.var_abi_a.getContent(), engine.var_axy_c.a(), this.var_com_badlogic_gdx_graphics_Color_a, engine.var_axy_c.a(), Color.BLACK, 428.0f, (float)(888 - this.var_int_a * 24), 8, 1);
        } else {
            engine.a(this.var_abi_a.getContent(), engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, 428.0f, (float)(888 - this.var_int_a * 24), 8, 1);
        }
        this.var_ayh_b.b(f2, engine);
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public int int_a() {
        return this.var_int_a;
    }

    public abi abi_a() {
        return this.var_abi_a;
    }

    static /* synthetic */ boolean a(aym aym2) {
        return aym2.var_boolean_a;
    }
}

