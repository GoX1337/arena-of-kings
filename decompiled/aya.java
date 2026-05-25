/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public abstract class aya
implements ayb {
    public final Engine var_com_arenaofkings_client_core_Engine_a;
    public Stage var_com_badlogic_gdx_scenes_scene2d_Stage_a;
    protected axm var_axm_a;

    public aya(axm axm2, Engine engine) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_axm_a = axm2;
        engine.var_com_badlogic_gdx_utils_viewport_Viewport_a = new StretchViewport(1920.0f, 1080.0f, engine.var_r_a);
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a = new Stage(engine.var_com_badlogic_gdx_utils_viewport_Viewport_a, engine.var_azi_a);
        Gdx.input.setInputProcessor(this.var_com_badlogic_gdx_scenes_scene2d_Stage_a);
        this.void_a();
    }

    public void void_b() {
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a.dispose();
    }

    public Stage com_badlogic_gdx_scenes_scene2d_Stage_c() {
        return this.var_com_badlogic_gdx_scenes_scene2d_Stage_a;
    }
}

