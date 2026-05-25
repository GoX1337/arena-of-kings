/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class cg
implements axr {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private int var_int_a;
    private int var_int_b;
    private ayh h;
    private boolean var_boolean_b = false;
    ck var_ck_a;
    cm var_cm_a;
    co var_co_a;
    private da var_da_b = new da();
    ayh var_ayh_a;
    ayh var_ayh_b;
    ayh var_ayh_c;
    ayh d;
    ayh e;
    ayh f;
    ayh g;
    ayg var_ayg_a;
    da var_da_a;
    ayf var_ayf_a;
    ayg var_ayg_b;
    boolean var_boolean_a = false;
    private boolean var_boolean_c = false;

    public cg(Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_int_a = -15;
        this.var_int_b = 255;
        this.var_ayg_a = new ch(this, 475, 927, 503, 957);
        this.var_ayg_b = new ci(this, 42, 291, 154, 330, engine);
    }

    public void void_a() {
        this.var_ck_a = new ck(this.var_com_arenaofkings_client_core_Engine_a, this);
        this.var_cm_a = new cm(this.var_com_arenaofkings_client_core_Engine_a, this);
        this.var_co_a = new co(this.var_com_arenaofkings_client_core_Engine_a, this);
        this.a(this.var_cm_a);
    }

    public void a(cj cj2) {
        this.var_ck_a.a(false);
        this.var_cm_a.a(false);
        this.var_co_a.a(false);
        cj2.a(true);
    }

    public void void_b() {
        this.a(this.var_cm_a);
    }

    public void void_c() {
        this.a(this.var_co_a);
    }

    public void void_d() {
        this.var_cm_a.void_a();
        this.var_co_a.void_a();
    }

    private void i() {
        this.var_cm_a.b();
        this.var_co_a.b();
    }

    public void a(axm axm2) {
        if (!this.var_boolean_c) {
            this.void_a();
            this.var_boolean_c = true;
        }
        this.h = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "vendor_window", true);
        this.var_ayh_a = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "SilverCoinSmall", true);
        this.var_ayh_b = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "SilverCoin", true);
        this.var_ayh_b.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.25f);
        this.var_ayh_c = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "arena_points_small", true);
        this.d = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "arena_points_large", true);
        this.e = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "vendor_red_overlay", true);
        this.f = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i), "gold_star", true);
        this.f.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.2f);
        this.g = new ayh(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.i), "crown", true);
        abi abi2 = abi.Y;
        this.var_da_b = new da(abi2.getScreenDependency(), abi2.aer_a().java_lang_String_a(), abi2.aer_a().int_c(), 0.06666667f, abi2.aer_a().float_b(), Animation.PlayMode.LOOP, abi2.aer_a().d(), abi2.aer_a().e());
        this.var_da_b.d(-0.4f);
        this.var_da_b.a(axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jy));
        this.var_da_a = new da(ajw.jg, "GCD_Flash", 15, 45, 0.02f, 0.0f, Animation.PlayMode.LOOP, -65, -65);
        this.var_da_a.a(this.var_com_arenaofkings_client_core_Engine_a.axc_a().axm_a(), false, true);
        this.var_da_a.a(1550.0f, 415.0f);
        this.var_ayf_a = new ayf(this.var_int_a, this.var_int_b, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c), "store_icon_default", "store_icon_hovered", true);
        this.var_ayf_a.com_badlogic_gdx_graphics_g2d_Sprite_b().scale(-0.25f);
        this.var_ayf_a.com_badlogic_gdx_graphics_g2d_Sprite_a().scale(-0.25f);
        this.var_ayf_a.a(42.0f, 291.0f, 154.0f, 330.0f);
    }

    @Deprecated
    public void a(int n2) {
    }

    public void e() {
        if (!this.var_boolean_b) {
            this.var_boolean_b = true;
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jX);
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jY);
            this.i();
        }
    }

    public void f() {
        if (this.var_boolean_b) {
            this.var_boolean_b = false;
            this.var_com_arenaofkings_client_core_Engine_a.var_baa_a.a(ajw.jS);
        }
    }

    public boolean boolean_a() {
        return this.var_boolean_b;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        this.var_da_b.a(f2, engine);
        this.var_da_a.a(f2, engine);
        if (this.var_boolean_b) {
            this.h.b(f2, engine);
            this.var_ayg_b.b(engine);
            this.var_da_b.a(f2, engine, 25, 800);
            this.var_da_b.a(f2, engine, 210, 800);
            this.var_cm_a.a(f2);
            this.var_co_a.a(f2);
            engine.a("" + ay.ay_a().gd_a().int_a(), engine.var_axy_c.a(), Color.WHITE, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_a + 465), (float)(this.var_int_b + 59), 16, 1);
            this.var_ayh_b.b(f2, engine, this.var_int_a + 465, this.var_int_b + 29);
            this.var_ayf_a.a((float)(this.var_int_a + 50), this.var_int_b + 25);
            this.var_ayf_a.a(f2, engine);
            this.var_ayf_a.b(f2, engine);
            if (this.var_ayg_b.boolean_e()) {
                engine.a("[WHITE]Click to [RARITY_LEGENDARY]Buy Back[] your last sold item.\n[RED]WARNING: don't rely on this!\nItem restoration is very limited.[]", this.var_int_a + 35, this.var_int_a + 420, 300);
                engine.a("[WHITE]Click to [RARITY_LEGENDARY]Buy Back[] your last sold item.\n[RED]WARNING: don't rely on this!\nItem restoration is very limited.[]", this.var_int_a + 35, this.var_int_a + 420);
                this.var_ayf_a.b(true);
            } else {
                this.var_ayf_a.b(false);
            }
            engine.a("Buyback", engine.var_axy_c.a(), Color.RED, engine.var_axy_c.a(), Color.BLACK, (float)(this.var_int_a + 105), (float)(this.var_int_b + 59), 8, 1);
        }
    }

    public void c(float f2, Engine engine) {
        if (this.var_boolean_b && !this.var_ck_a.boolean_a()) {
            if (this.var_cm_a.boolean_a()) {
                this.var_cm_a.d();
            } else if (this.var_co_a.boolean_a()) {
                this.var_co_a.d();
            }
        }
    }

    public void a(Engine engine) {
        if (this.var_boolean_b && !this.var_ck_a.boolean_a()) {
            if (this.var_cm_a.boolean_a()) {
                this.var_cm_a.c();
            } else if (this.var_co_a.boolean_a()) {
                this.var_co_a.c();
            }
        }
    }

    public void g() {
        if (this.var_boolean_b) {
            this.var_ayg_a.b(this.var_com_arenaofkings_client_core_Engine_a);
        }
    }

    public ayh ayh_a() {
        return this.var_ayh_a;
    }

    public ayh ayh_b() {
        return this.f;
    }

    public ayh ayh_c() {
        return this.g;
    }

    public da da_a() {
        return this.var_da_b;
    }

    public da da_b() {
        return this.var_da_a;
    }

    public ayh ayh_d() {
        return this.var_ayh_c;
    }

    public boolean boolean_b() {
        return this.var_boolean_a;
    }

    public void h() {
        this.var_boolean_a = false;
    }

    static /* synthetic */ boolean a(cg cg2) {
        return cg2.var_boolean_b;
    }
}

