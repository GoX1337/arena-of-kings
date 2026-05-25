/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class vj
extends axc {
    public wa a;

    public vj(Engine engine, ayl ayl2) {
        super(engine, ayl2);
    }

    @Override
    public void show() {
        System.out.println("show");
        this.a = new wa(((Engine)((Object)this.a)).var_com_badlogic_gdx_assets_AssetManager_a);
        System.out.println("show2");
        this.a = new vl((axm)((Object)this.a), this.a, (wd)((Object)this.a), (Engine)((Object)this.a));
        this.void_a();
    }

    private void void_a() {
        ((Array)((Object)this.a)).add(this.a);
        ((Array)((Object)this.a)).add(((vl)((Object)this.a)).var_ayc_a);
        ((Array)((Object)this.a)).add(((vl)((Object)this.a)).var_ayf_a);
    }

    @Override
    public void render(float f2) {
        this.a(((Engine)((Object)this.a)).var_azi_a);
        Gdx.input.setInputProcessor(((aya)((Object)this.a)).com_badlogic_gdx_scenes_scene2d_Stage_c());
        ((Engine)((Object)this.a)).a(((Engine)((Object)this.a)).var_azi_a);
        ((Engine)((Object)this.a)).var_azi_a.c(f2, (Array<axr>)((Object)this.a));
        ((Engine)((Object)this.a)).var_azi_a.a(f2, (Array<axr>)((Object)this.a));
        this.a.a(f2, ((Engine)((Object)this.a)).var_azi_a);
        this.b(((Engine)((Object)this.a)).var_azi_a);
        ((Engine)((Object)this.a)).e();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void resize(int n2, int n3) {
        super.resize(n2, n3);
        ((aya)((Object)this.a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getViewport().update(n2, n3);
    }
}

