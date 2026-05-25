/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

public class xy {
    private ajw var_ajw_a;
    protected ayh var_ayh_a;

    public xy(axm axm2, Engine engine) {
        int n2 = MathUtils.random(4);
        if (n2 == 0) {
            engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jF.a(), ajw.jF.a());
            this.var_ajw_a = ajw.jF;
        } else if (n2 == 1) {
            engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jG.a(), ajw.jG.a());
            this.var_ajw_a = ajw.jG;
        } else if (n2 == 2) {
            engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jD.a(), ajw.jD.a());
            this.var_ajw_a = ajw.jD;
        } else if (n2 == 3) {
            engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jH.a(), ajw.jH.a());
            this.var_ajw_a = ajw.jH;
        } else if (n2 == 4) {
            engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jE.a(), ajw.jE.a());
            this.var_ajw_a = ajw.jE;
        }
        engine.var_com_badlogic_gdx_assets_AssetManager_a.finishLoading();
        this.var_ayh_a = new ayh(new Sprite(engine.var_com_badlogic_gdx_assets_AssetManager_a.get(this.var_ajw_a.a(), Texture.class)), 0, 0, true);
    }

    public void a(float f2, Engine engine) {
        if (this.var_ayh_a == null) {
            Engine.b("img is null");
        } else {
            this.var_ayh_a.b(f2, engine);
        }
    }
}

