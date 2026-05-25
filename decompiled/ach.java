/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ach
extends ze {
    private boolean b = false;

    public ach(Engine engine, axm axm2, Stage stage, boolean bl2) {
        super(engine, 15, axm2, stage, yo.b, bl2);
        this.f();
    }

    @Override
    public void g() {
        super.g();
        if (!this.b) {
            this.a(new aek(this.a, abi.O, abi.O.aer_a(), -87, -11, this.a, abe.var_abe_a, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.O, false, true)));
            this.a(new aek(this.a, abi.P, abi.P.aer_a(), -87, -11, this.a, abe.c, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.P, false, true)));
            this.a(new aek(this.a, abi.S, abi.S.aer_a(), -46, 24, this.a, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.S, false, true)));
            this.a(new aek(this.a, abi.T, abi.T.aer_a(), -20, 24, this.a, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.T, false, true)));
            this.a(new aek(this.a, abi.V, abi.V.aer_a(), -19, 27, this.a, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.V, false, true)));
            this.a(new aek(this.a, abi.R, abi.R.aer_a(), -30, 27, this.a, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.R, false, true)));
            this.a(new aek(this.a, abi.U, abi.U.aer_a(), -48, -44, this.a, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.U, false, true)));
            this.a(new aek(this.a, abi.X, abi.X.aer_a(), -27, -44, this.a, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.X, false, true)));
            this.a(new aek(this.a, abi.W, abi.W.aer_a(), -42, 17, this.a, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.W, false, true)));
            this.a(new aek(this.a, abi.N, abi.N.aer_a(), -40, -19, this.a, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.N, false, true)));
            this.a(new aek(this.a, abi.Q, abi.Q.aer_a(), -45, 26, this.a, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.Q, false, true)));
            this.a(new aek(this.a, abi.Y, abi.Y.aer_a(), -48, -19, this.a, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.Y, false, true)));
            this.a(new aek(this.a, abi.Z, abi.Z.aer_a(), -22, -24, this.a, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.Z, false, true)));
            this.a(new aek(this.a, abi.aa, abi.aa.aer_a(), 36, 17, this.a, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.aa, false, true)));
            this.a(new aek(this.a, abi.ab, abi.ab.aer_a(), -44, 46, this.a, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.ab, false, true)));
            this.a(new aek(this.a, abi.M, abi.M.aer_a(), -44, 46, this.a, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.M, false, true)));
            this.b = true;
            this.void_a();
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
            this.c(f2, engine);
        }
    }

    public void h() {
        this.b();
    }

    public void i() {
        this.c();
    }
}

