/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class abs
extends ze {
    private ayh var_ayh_c;
    private ayf a;
    private ayf var_ayf_b;
    private ayf var_ayf_c;
    private ayh var_ayh_d;
    private ayf var_ayf_d;
    private ayf var_ayf_e;
    private ayf var_ayf_f;
    private ayh var_ayh_e;
    private ayh var_ayh_f;
    private ayh g;
    private boolean var_boolean_b = false;

    public abs(Engine engine, axm axm2, Stage stage, boolean bl2) {
        super(engine, 3, axm2, stage, yo.c, bl2);
        this.f();
    }

    @Override
    public void g() {
        super.g();
        if (!this.var_boolean_b) {
            TextureAtlas textureAtlas = ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b);
            TextureAtlas textureAtlas2 = ((axm)((Object)this.a)).com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.c);
            this.var_ayh_c = new ayh(684, 387, textureAtlas, "game_editions");
            this.g = new ayh(0, 0, textureAtlas, "checkmark_green");
            this.var_ayh_e = new ayh(1012, 882, textureAtlas, "upgrade_to_epic");
            this.var_ayh_f = new ayh(1289, 882, textureAtlas, "upgrade_to_legendary");
            this.var_ayh_d = new ayh(0, 0, textureAtlas, "game_upgrade_notice", true);
            this.var_ayf_d = new abt(this, 1024, 794, textureAtlas, "buy_button_standard_default", "buy_button_standard_hovered", true);
            this.var_ayf_e = new abu(this, 1301, 794, textureAtlas, "buy_button_legendary_upgrade_default", "buy_button_legendary_upgrade_hovered", true);
            this.var_ayf_f = new abv(this, 1301, 794, textureAtlas, "buy_button_epic_default", "buy_button_epic_hovered", true);
            this.a = new abw(this, 747, 794, textureAtlas, "buy_button_standard_default", "buy_button_standard_hovered", true);
            this.var_ayf_b = new abx(this, 1024, 794, textureAtlas, "buy_button_epic_default", "buy_button_epic_hovered", true);
            this.var_ayf_c = new aby(this, 1301, 794, textureAtlas, "buy_button_legendary_default", "buy_button_legendary_hovered", true);
            this.var_boolean_b = true;
        }
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.a != false) {
            this.a(f2, engine);
            this.var_ayh_c.b(f2, engine);
            if (!ay.ay_a().gd_a().a(abi.ar)) {
                this.a.a(f2, engine);
                this.a.b(f2, engine);
                this.var_ayf_b.a(f2, engine);
                this.var_ayf_b.b(f2, engine);
                this.var_ayf_c.a(f2, engine);
                this.var_ayf_c.b(f2, engine);
            } else if (ay.ay_a().gd_a().a(abi.at)) {
                this.g.b(f2, engine, 697, 915);
                this.g.b(f2, engine, 973, 915);
                this.g.b(f2, engine, 1249, 915);
            } else if (ay.ay_a().gd_a().a(abi.as)) {
                this.g.b(f2, engine, 697, 915);
                this.g.b(f2, engine, 973, 915);
                this.var_ayh_d.b(f2, engine, 987, 796);
                this.var_ayf_f.a(f2, engine);
                this.var_ayf_f.b(f2, engine);
                this.var_ayh_f.b(f2, engine);
            } else if (ay.ay_a().gd_a().a(abi.ar)) {
                this.g.b(f2, engine, 697, 915);
                this.var_ayh_d.b(f2, engine, 710, 796);
                this.var_ayf_d.a(f2, engine);
                this.var_ayf_d.b(f2, engine);
                this.var_ayf_e.a(f2, engine);
                this.var_ayf_e.b(f2, engine);
                this.var_ayh_e.b(f2, engine);
                this.var_ayh_f.b(f2, engine);
            }
        }
    }

    public void h() {
    }

    public void i() {
    }

    static /* synthetic */ Engine a(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine b(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine c(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine d(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine e(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine f(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine g(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine h(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine i(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine j(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine k(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine l(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine m(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine n(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine o(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine p(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine q(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine r(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine s(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine t(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine u(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine v(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine w(abs abs2) {
        return abs2.a;
    }

    static /* synthetic */ Engine x(abs abs2) {
        return abs2.a;
    }
}

