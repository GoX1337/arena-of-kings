/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class zm
implements axr {
    protected final Engine var_com_arenaofkings_client_core_Engine_a;
    protected final axm var_axm_a;
    protected final Stage var_com_badlogic_gdx_scenes_scene2d_Stage_a;
    public boolean var_boolean_a = false;

    public zm(Engine engine, axm axm2, Stage stage) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_axm_a = axm2;
        this.var_com_badlogic_gdx_scenes_scene2d_Stage_a = stage;
        this.void_a();
    }

    public abstract void void_a();

    public abstract void void_b();

    public abstract void void_c();

    public boolean boolean_a() {
        return this.var_boolean_a;
    }
}

