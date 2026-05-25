/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.arenaofkings.packets.misc.StoreItemContent;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class acg
extends ze {
    private boolean b = false;

    public acg(Engine engine, axm axm2, Stage stage, boolean bl2) {
        super(engine, 12, axm2, stage, yo.b, bl2);
        this.f();
    }

    @Override
    public void g() {
        super.g();
        if (!this.b) {
            TextureAtlas textureAtlas = this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.jl);
            this.a(new ads(this.a, (StoreItemContent)abi.J, new adi(), textureAtlas, abe.var_abe_a, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.J, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.K, new adj(), textureAtlas, abe.c, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.K, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.I, new adh(), textureAtlas, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.I, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.w, new add(), textureAtlas, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.w, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.x, new ade(), textureAtlas, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.x, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.y, new adk(), textureAtlas, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.y, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.z, new adl(), textureAtlas, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.z, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.A, new adm(), textureAtlas, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.A, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.B, new adn(), textureAtlas, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.B, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.C, new ado(), textureAtlas, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.C, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.D, new adp(), textureAtlas, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.D, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.E, new adq(), textureAtlas, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.E, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.F, new adr(), textureAtlas, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.F, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.G, new adf(), textureAtlas, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.G, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.H, new adg(), textureAtlas, abe.d, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.H, false, true)));
            this.a(new ads(this.a, (StoreItemContent)abi.I, new adh(), textureAtlas, abe.f, this, new azx(this.a, 0, 0, this.a.com_badlogic_gdx_graphics_g2d_TextureAtlas_a(ajw.b), abi.I, false, true)));
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

