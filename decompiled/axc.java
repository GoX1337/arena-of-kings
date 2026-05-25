/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Array;

public abstract class axc
implements Screen {
    public Engine var_com_arenaofkings_client_core_Engine_a;
    protected axm var_axm_a;
    protected boolean c = false;
    protected aya var_aya_a;
    protected Array<axr> var_com_badlogic_gdx_utils_Array_axr__a;
    protected boolean d = false;
    protected boolean e = false;
    protected ayl var_ayl_a;

    public axc(Engine engine, ayl ayl2) {
        System.out.println("AbstractScreen() in");
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        System.out.println("AbstractScreen() in 1");
        this.a(ayl2);
        System.out.println("AbstractScreen() in 2");
        this.var_com_arenaofkings_client_core_Engine_a = new Array();
        System.out.println("AbstractScreen() in 3");
        if (engine.var_azi_a.isDrawing()) {
            engine.var_azi_a.end();
        }
        System.out.println("AbstractScreen() in 4");
        this.var_ayl_a = ayl2;
        System.out.println("AbstractScreen() out");
    }

    private void a(ayl ayl2) {
        Engine.a("Creating dependency structure...");
        if (this.getClass() == aes.class || this.getClass() == afx.class) {
            this.var_axm_a = new aew(this.var_com_arenaofkings_client_core_Engine_a);
        } else if (this.getClass() == um.class || this.getClass() == vh.class) {
            this.var_axm_a = new uo(this.var_com_arenaofkings_client_core_Engine_a);
        } else if (this.getClass() == vj.class || this.getClass() == wb.class) {
            this.var_axm_a = new vk(this.var_com_arenaofkings_client_core_Engine_a, ayl2);
        } else if (this.getClass() == we.class || this.getClass() == xw.class) {
            this.var_axm_a = new wf(this.var_com_arenaofkings_client_core_Engine_a);
        } else if (this.getClass() == agd.class || this.getClass() == ajo.class) {
            this.var_axm_a = new agl(this.var_com_arenaofkings_client_core_Engine_a, ayl2);
        }
        Engine.a("Created dependency structure for '" + this.var_axm_a.getClass().getName() + "'");
    }

    public void a(azi azi2) {
        this.c = true;
    }

    public void b(azi azi2) {
        this.c = false;
    }

    @Override
    public void hide() {
        Engine.b("HIDE");
    }

    @Override
    public void pause() {
    }

    @Override
    public void resize(int n2, int n3) {
        Engine.a("Resize: " + n2 + " " + n3);
        this.var_com_arenaofkings_client_core_Engine_a.var_r_a.viewportWidth = n2;
        this.var_com_arenaofkings_client_core_Engine_a.var_r_a.viewportHeight = n3;
        this.var_com_arenaofkings_client_core_Engine_a.var_r_a.update();
    }

    @Override
    public void resume() {
        Engine.b("RESUME");
        Engine.a("resume called. updating asset manager. Loaded assets: " + this.var_com_arenaofkings_client_core_Engine_a.var_com_badlogic_gdx_assets_AssetManager_a.getLoadedAssets() + " Queued assets: " + this.var_com_arenaofkings_client_core_Engine_a.var_u_a.getQueuedAssets() + " Progress: " + this.var_com_arenaofkings_client_core_Engine_a.var_u_a.getProgress());
        this.var_com_arenaofkings_client_core_Engine_a.m();
    }

    @Override
    public void show() {
    }

    @Override
    public void dispose() {
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).clear();
        this.var_axm_a.a().clear();
        if (this.var_aya_a != null) {
            this.var_aya_a.void_b();
        }
    }

    public axm axm_a() {
        return this.var_axm_a;
    }

    public aya aya_a() {
        return this.var_aya_a;
    }

    public ayl ayl_a() {
        return this.var_ayl_a;
    }

    public boolean boolean_c() {
        return this.var_ayl_a != null;
    }
}

