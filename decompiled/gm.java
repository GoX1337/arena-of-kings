/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class gm
implements axr {
    private final gl var_gl_a;
    private ayh var_ayh_a;
    private ayf var_ayf_a;
    private ayf b;

    public gm(Engine engine, TextureAtlas textureAtlas, gl gl2) {
        this.var_gl_a = gl2;
        this.var_ayh_a = new ayh(1575, 400, textureAtlas, "team_invite_frame", true);
        this.var_ayf_a = new gn(this, 1610, 415, textureAtlas, "accept_default", "accept_hovered", true, engine, gl2);
        this.b = new go(this, 1730, 415, textureAtlas, "decline_default", "decline_hovered", true, engine, gl2);
    }

    @Override
    public void a(float f2, Engine engine) {
        this.var_ayf_a.a(f2, engine);
        this.b.a(f2, engine);
    }

    @Override
    public void b(float f2, Engine engine) {
        this.a(f2, engine);
        this.var_ayh_a.b(f2, engine);
        this.var_ayf_a.b(f2, engine);
        this.b.b(f2, engine);
    }
}

