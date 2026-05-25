/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class acf
extends ze {
    private boolean b = false;

    public acf(Engine engine, axm axm2, Stage stage, boolean bl2) {
        super(engine, 4, axm2, stage, yo.b, bl2);
        this.f();
    }

    @Override
    public void g() {
        super.g();
        if (!this.b) {
            TextureAtlas textureAtlas = this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b);
            this.a(new acz(this.a, abi.ak, new ada(true), textureAtlas, abe.var_abe_a, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.ak, true, true), true));
            this.a(new acz(this.a, abi.al, new adb(true), textureAtlas, abe.c, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.al, true, true), true));
            this.a(new acz(this.a, abi.ap, new acv(), textureAtlas, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.ap, true, true), true));
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
        }
    }

    public void h() {
        this.b();
    }

    public void i() {
        this.c();
    }
}

