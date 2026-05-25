/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class aci
extends ze {
    private boolean b = false;

    public aci(Engine engine, axm axm2, Stage stage, boolean bl2) {
        super(engine, 32, axm2, stage, yo.b, bl2);
        this.f();
    }

    @Override
    public void g() {
        super.g();
        if (!this.b) {
            this.b = true;
        }
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    @Override
    public void b(float f2, Engine engine) {
        if (this.a) {
            this.a(f2, engine);
            super.b(f2, engine);
            engine.a("Alternate Artwork for Spells\nis experimentally in development.\n\nIf we decide to add them, they will be found here.", engine.var_axy_f.a(), Colors.get("RARITY_RARE"), engine.var_axy_f.a(), Color.BLACK, 1080.0f, 750.0f, 1, 1);
            Engine.b("rendering");
        }
    }

    public void h() {
        this.c();
    }
}

