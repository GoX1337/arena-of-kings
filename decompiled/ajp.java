/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ajp {
    private ajw var_ajw_a;
    protected ayh var_ayh_a;

    public ajp(agp agp2, axm axm2, Engine engine) {
        if (agp2 == null) {
            Engine.b("DATA IS NULL");
        } else {
            Engine.b("case: " + (Object)((Object)agp2.com_arenaofkings_packets_misc_ArenaName_a()));
        }
        switch (agp2.com_arenaofkings_packets_misc_ArenaName_a()) {
            case DARK: {
                engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jF.a(), ajw.jF.a());
                this.var_ajw_a = ajw.jF;
                break;
            }
            case DESERT: {
                engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jG.a(), ajw.jG.a());
                this.var_ajw_a = ajw.jG;
                break;
            }
            case FOREST: {
                engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jD.a(), ajw.jD.a());
                this.var_ajw_a = ajw.jD;
                break;
            }
            case INDOOR: {
                engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jH.a(), ajw.jH.a());
                this.var_ajw_a = ajw.jH;
                break;
            }
            case SNOWY: {
                engine.var_com_badlogic_gdx_assets_AssetManager_a.load(ajw.jE.a(), ajw.jE.a());
                this.var_ajw_a = ajw.jE;
                break;
            }
        }
        engine.var_com_badlogic_gdx_assets_AssetManager_a.finishLoading();
        this.var_ayh_a = new ayh(new Sprite(engine.var_com_badlogic_gdx_assets_AssetManager_a.get(this.var_ajw_a.a(), Texture.class)), 0, 0, true);
    }

    public void a(float f2, Engine engine) {
        if (this.var_ayh_a == null) {
            Engine.b("img is null");
        }
        this.var_ayh_a.b(f2, engine);
    }
}

