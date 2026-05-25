/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class zi
extends yf {
    private ayf var_ayf_a;
    private ayf var_ayf_b;
    private ayf c;
    private ayf d;
    private ayf e;
    private zu var_zu_a;
    private zm var_zm_a;
    private zm var_zm_b;
    private azv var_azv_a;

    public zi(Engine engine, axm axm2, Stage stage) {
        super(402, 365, axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), "store_panel");
        TextureAtlas textureAtlas = axm2.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
        this.var_zu_a = new zu(engine, axm2, stage);
        this.var_zm_a = new aaf(engine, axm2, stage);
        Engine.b("load ladder subpanel in");
        this.var_zm_b = new zt(engine, axm2, stage);
        Engine.b("load ladder subpanel out");
        this.var_ayf_a = new zj(this, 413, 890, textureAtlas, "teams_button_default", "teams_button_hovered", true, engine);
        this.var_ayf_a.a(420.0f, 905.0f, 667.0f, 947.0f);
        this.var_ayf_b = new zk(this, 410, 830, textureAtlas, "tournaments_button_default", "tournaments_button_hovered", true, engine);
        this.var_ayf_b.a(417.0f, 844.0f, 667.0f, 886.0f);
        this.c = new zl(this, 410, 767, textureAtlas, "ladder_button_default", "ladder_button_hovered", true, engine);
        this.c.a(417.0f, 787.0f, 667.0f, 825.0f);
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (((ayh)((Object)this.var_ayf_a)).boolean_b()) {
            super.b(f2, engine);
            this.var_ayf_a.a(f2, engine);
            if (this.var_zu_a.var_ayh_a != false) {
                this.var_ayf_a.b(true);
            }
            this.var_ayf_a.b(f2, engine);
            this.var_ayf_b.a(f2, engine);
            if (this.var_zm_a.var_boolean_a) {
                this.var_ayf_b.b(true);
            }
            this.var_ayf_b.b(f2, engine);
            if (this.var_zm_b.var_boolean_a) {
                this.c.b(true);
            }
            this.c.b(f2, engine);
            this.var_zu_a.b(f2, engine);
            this.var_zm_a.b(f2, engine);
            this.var_zm_b.b(f2, engine);
        }
    }

    public void a(ayf ayf2) {
        this.d = ayf2;
        if (this.d == this.var_ayf_a) {
            this.var_zu_a.void_b();
        } else if (this.d == this.var_ayf_b) {
            this.var_zm_a.void_b();
        } else if (this.d == this.c) {
            this.var_zm_b.void_b();
        }
        if (this.d != this.var_ayf_a) {
            this.var_zu_a.void_c();
        }
        if (this.d != this.var_ayf_b) {
            this.var_zm_a.void_c();
        }
        if (this.d != this.c) {
            this.var_zm_b.void_c();
        }
    }

    @Override
    public void a(Stage stage) {
        super.a(stage);
        this.a(this.c);
        this.c.void_a();
    }

    public void c(Stage stage) {
        super.a(stage);
        this.a(this.var_ayf_b);
    }

    @Override
    public void b(Stage stage) {
        super.b(stage);
        this.var_zu_a.void_c();
        this.var_zm_a.void_c();
        this.var_zm_b.void_c();
    }

    public aaf aaf_a() {
        return (aaf)this.var_zm_a;
    }

    public zt zt_a() {
        return (zt)this.var_zm_b;
    }

    public zu zu_a() {
        return this.var_zu_a;
    }

    static /* synthetic */ ayf a(zi zi2, ayf ayf2) {
        zi2.e = ayf2;
        return zi2.e;
    }

    static /* synthetic */ ayf ayf_a(zi zi2) {
        return zi2.e;
    }

    static /* synthetic */ ayf b(zi zi2) {
        return zi2.c;
    }

    static /* synthetic */ azv azv_a(zi zi2) {
        return zi2.var_azv_a;
    }

    static /* synthetic */ azv a(zi zi2, azv azv2) {
        zi2.var_azv_a = azv2;
        return zi2.var_azv_a;
    }
}

