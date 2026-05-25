/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Color;

public class afx
extends axb {
    public afx(Engine engine, ayl ayl2) {
        super(engine, ayl2);
    }

    @Override
    public void show() {
        super.show();
        this.a = new afy(this.a, this.a);
        this.a.void_c();
    }

    @Override
    public void render(float f2) {
        System.out.println("Render");
        this.a.var_azi_a.begin();
        this.a.a("Preparing game files.", this.a.var_axy_c.a(), this.a.var_com_badlogic_gdx_graphics_g2d_BitmapFont_f.getColor(), this.a.var_axy_c.a(), Color.BLACK, 960.0f, 550.0f, 1, 1);
        this.a.a((int)(100.0f * this.a.var_com_badlogic_gdx_assets_AssetManager_a.getProgress()) + "%", this.a.var_axy_c.a(), this.a.var_com_badlogic_gdx_graphics_g2d_BitmapFont_f.getColor(), this.a.var_axy_c.a(), Color.BLACK, 960.0f, 530.0f, 1, 1);
        this.a.var_azi_a.end();
        this.a.var_com_badlogic_gdx_assets_AssetManager_a.update();
        if (this.a.var_com_badlogic_gdx_assets_AssetManager_a.isFinished()) {
            this.a.setScreen(new aes(this.a, this.a));
        }
    }
}

