/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class gh
implements axr {
    private final gg var_gg_a;
    private ayh var_ayh_a;
    private ayf var_ayf_a;
    private ayf var_ayf_b;
    private azv var_azv_a = new azv(3000L, true);
    private da var_da_a;
    private da var_da_b;

    public gh(Engine engine, TextureAtlas textureAtlas, gg gg2) {
        this.var_gg_a = gg2;
        this.var_ayh_a = new ayh(1575, 400, textureAtlas, "party_invite_frame", true);
        this.var_ayf_a = new gi(this, 1610, 415, textureAtlas, "accept_default", "accept_hovered", true, engine, gg2);
        this.var_ayf_b = new gj(this, 1730, 415, textureAtlas, "decline_default", "decline_hovered", true, engine, gg2);
        this.var_da_a = new da(ajw.jg, "GCD_Flash", 0, 45, 0.02f, 0.0f, Animation.PlayMode.NORMAL, -65, -65);
        this.var_da_a.a(engine.axc_a().axm_a(), false, true);
        this.var_da_a.a(1550.0f, 415.0f);
        this.var_da_b = new da(ajw.jg, "GCD_Flash", 15, 45, 0.02f, 0.0f, Animation.PlayMode.LOOP, -65, -65);
        this.var_da_b.a(engine.axc_a().axm_a(), false, true);
        this.var_da_b.a(1550.0f, 415.0f);
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayf_a.a(f2, engine);
        this.var_ayf_b.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        if (this.var_da_b != null) {
            this.var_da_b.a(f2, engine);
            this.var_da_b.d(f2, 1694.0f, 553.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1744.0f, 553.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1794.0f, 553.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1844.0f, 553.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1894.0f, 553.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1944.0f, 553.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1694.0f, 488.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1744.0f, 488.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1794.0f, 488.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1844.0f, 488.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1894.0f, 488.0f, engine.var_azi_a);
            this.var_da_b.d(f2, 1944.0f, 488.0f, engine.var_azi_a);
            if (this.var_azv_a.boolean_b()) {
                this.var_azv_a.void_c();
                this.var_da_a.void_a();
            }
            if (!this.var_da_a.a().isAnimationFinished(this.var_da_a.float_a())) {
                this.var_da_a.d(f2, 1694.0f, 553.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1744.0f, 553.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1794.0f, 553.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1844.0f, 553.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1894.0f, 553.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1944.0f, 553.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1694.0f, 488.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1744.0f, 488.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1794.0f, 488.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1844.0f, 488.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1894.0f, 488.0f, engine.var_azi_a);
                this.var_da_a.d(f2, 1944.0f, 488.0f, engine.var_azi_a);
            }
            this.var_da_a.a(f2, engine);
        }
        this.var_ayh_a.b(f2, engine);
        this.var_ayf_a.b(f2, engine);
        this.var_ayf_b.b(f2, engine);
    }
}

