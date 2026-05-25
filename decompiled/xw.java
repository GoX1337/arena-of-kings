/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;

public class xw
extends axb {
    private xy a;

    public xw(Engine engine, ayl ayl2) {
        super(engine, ayl2);
    }

    @Override
    public void show() {
        super.show();
        this.a = new xx((axm)((Object)this.a), (Engine)((Object)this.a));
        this.a = new xy((axm)((Object)this.a), (Engine)((Object)this.a));
    }

    @Override
    public void render(float f2) {
        ((Engine)((Object)this.a)).var_com_badlogic_gdx_assets_AssetManager_a.update();
        if (((Engine)((Object)this.a)).var_com_badlogic_gdx_assets_AssetManager_a.isFinished()) {
            ((Engine)((Object)this.a)).setScreen(new we((Engine)((Object)this.a), (ayl)((Object)this.a)));
        }
        ((Engine)((Object)this.a)).a(((Engine)((Object)this.a)).var_azi_a);
        ((Engine)((Object)this.a)).var_azi_a.begin();
        this.a.a(f2, (Engine)((Object)this.a));
        ((Engine)((Object)this.a)).var_azi_a.end();
    }
}

