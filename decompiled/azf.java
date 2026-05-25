/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class azf
implements axr,
Comparable<azf> {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private ayh var_ayh_a;
    private ayh b;
    private abi var_abi_a;
    private int var_int_a;
    private boolean var_boolean_a = false;

    public azf(Engine engine, TextureAtlas textureAtlas, abi abi2, int n2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_ayh_a = new ayh(414, 673 - n2 * 24, textureAtlas, "mtx_textlabel", true);
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setColor(Color.GRAY);
        this.b = new azg(this, 683, 715, textureAtlas, "mtx_box", true, engine, abi2);
        this.var_abi_a = abi2;
        this.var_int_a = n2;
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayh_a.a(f2, engine);
        this.b.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(683.0f, 521 - this.var_int_a * 24);
        this.b.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.var_ayh_a.b(f2, engine);
        if (ay.ay_a().gd_a().a(this.var_abi_a)) {
            engine.a(abi.a(this.var_abi_a), engine.var_axy_c.a(), axe.x, engine.var_axy_c.a(), Color.BLACK, 428.0f, (float)(545 - this.var_int_a * 24), 8, 1);
        } else {
            engine.a(abi.a(this.var_abi_a), engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, 428.0f, (float)(545 - this.var_int_a * 24), 8, 1);
        }
        this.b.b(f2, engine);
    }

    public void a(int n2) {
        this.var_int_a = n2;
        this.var_ayh_a.com_badlogic_gdx_graphics_g2d_Sprite_a().setPosition(414.0f, 528 - n2 * 24);
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    public int int_a() {
        return this.var_int_a;
    }

    public abi abi_a() {
        return this.var_abi_a;
    }

    public int a(azf azf2) {
        return this.var_abi_a.name().compareTo(azf2.abi_a().name());
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.a((azf)object);
    }
}

