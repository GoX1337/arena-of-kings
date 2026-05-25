/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class ajo
extends axb {
    private ajp var_ajp_a;
    private agp var_agp_a;
    private boolean var_boolean_a = false;

    public ajo(Engine engine, ayl ayl2) {
        super(engine, ayl2);
        this.var_agp_a = (agp)ayl2;
    }

    @Override
    public void show() {
        this.a((Engine)((Object)this.var_ajp_a));
    }

    private void a(Engine engine) {
        this.var_ajp_a = new ajp(this.var_agp_a, (axm)((Object)this.var_ajp_a), engine);
    }

    @Override
    public void render(float f2) {
        ((Engine)((Object)this.var_ajp_a)).var_com_badlogic_gdx_assets_AssetManager_a.update();
        if (((Engine)((Object)this.var_ajp_a)).var_com_badlogic_gdx_assets_AssetManager_a.isFinished()) {
            ((Engine)((Object)this.var_ajp_a)).setScreen(new agd((Engine)((Object)this.var_ajp_a), this.var_agp_a));
        }
        ((Engine)((Object)this.var_ajp_a)).a(((Engine)((Object)this.var_ajp_a)).var_azi_a);
        ((Engine)((Object)this.var_ajp_a)).var_azi_a.begin();
        this.var_ajp_a.a(f2, (Engine)((Object)this.var_ajp_a));
        ((Engine)((Object)this.var_ajp_a)).var_azi_a.end();
        Engine.b("LOADING SCREEN RENDER");
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

