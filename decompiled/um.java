/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import java.util.Objects;

public class um
extends axc {
    public vg a;

    public um(Engine engine) {
        super(engine, null);
    }

    @Override
    public void show() {
        this.a = new vg(((Engine)((Object)this.a)).var_com_badlogic_gdx_assets_AssetManager_a);
        this.a = new up((axm)((Object)this.a), (Engine)((Object)this.a));
        this.b();
    }

    private void b() {
        ((Array)((Object)this.a)).add(this.a);
        ((Array)((Object)this.a)).add(((up)((Object)this.a)).var_ayh_a);
        ((Array)((Object)this.a)).add(((up)((Object)this.a)).var_ayc_a);
        ((Array)((Object)this.a)).add(((up)((Object)this.a)).var_ayf_a);
    }

    @Override
    public void render(float f2) {
        ((Engine)((Object)this.a)).var_azi_a.setColor(Color.WHITE);
        this.a(((Engine)((Object)this.a)).var_azi_a);
        Gdx.input.setInputProcessor(((aya)((Object)this.a)).com_badlogic_gdx_scenes_scene2d_Stage_c());
        ((Engine)((Object)this.a)).a(((Engine)((Object)this.a)).var_azi_a);
        ((Engine)((Object)this.a)).var_azi_a.c(f2, (Array<axr>)((Object)this.a));
        ((Engine)((Object)this.a)).var_azi_a.a(f2, (Array<axr>)((Object)this.a));
        this.a.a(f2, ((Engine)((Object)this.a)).var_azi_a);
        ((Engine)((Object)this.a)).l();
        ((Engine)((Object)this.a)).var_azi_a.begin();
        this.void_a();
        ((Engine)((Object)this.a)).var_azi_a.end();
        this.b(((Engine)((Object)this.a)).var_azi_a);
        ((Engine)((Object)this.a)).e();
    }

    public void void_a() {
        if (Gdx.graphics.getFramesPerSecond() >= 70) {
            ((Engine)((Object)this.a)).a("[WHITE]FPS:[] [GREEN]" + Gdx.graphics.getFramesPerSecond() + "[]", ((Engine)((Object)this.a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.a)).var_axy_c.a(), Color.BLACK, 10.0f, 70.0f, 8);
        } else if (Gdx.graphics.getFramesPerSecond() >= 50) {
            ((Engine)((Object)this.a)).a("[WHITE]FPS:[] [LIME]" + Gdx.graphics.getFramesPerSecond() + "[]", ((Engine)((Object)this.a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.a)).var_axy_c.a(), Color.BLACK, 10.0f, 70.0f, 8);
        } else if (Gdx.graphics.getFramesPerSecond() >= 40) {
            ((Engine)((Object)this.a)).a("[WHITE]FPS:[] [ORANGE]" + Gdx.graphics.getFramesPerSecond() + "[]", ((Engine)((Object)this.a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.a)).var_axy_c.a(), Color.BLACK, 10.0f, 70.0f, 8);
        } else {
            ((Engine)((Object)this.a)).a("[WHITE]FPS:[] [RED]" + Gdx.graphics.getFramesPerSecond() + " UNPLAYABLE![]", ((Engine)((Object)this.a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.a)).var_axy_c.a(), Color.BLACK, 10.0f, 70.0f, 8);
        }
        StringBuilder stringBuilder = new StringBuilder().append("[WHITE]Version:[] [RARITY_LEGENDARY]");
        Objects.requireNonNull(this.a);
        ((Engine)((Object)this.a)).a(stringBuilder.append("2.0.0.0").append("[]").toString(), ((Engine)((Object)this.a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.a)).var_axy_c.a(), Color.BLACK, 10.0f, 30.0f, 8);
        ((Engine)((Object)this.a)).var_axy_c.a().setColor(Color.WHITE);
        switch (((Engine)((Object)this.a)).var_z_a.w_a()) {
            case b: {
                ((Engine)((Object)this.a)).a("[WHITE]Server Status: [RED]Offline[]", ((Engine)((Object)this.a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.a)).var_axy_c.a(), Color.BLACK, 10.0f, 50.0f, 8);
                break;
            }
            case var_w_a: {
                ((Engine)((Object)this.a)).a("[WHITE]Server Status: [GREEN]Online[]", ((Engine)((Object)this.a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.a)).var_axy_c.a(), Color.BLACK, 10.0f, 50.0f, 8);
                break;
            }
            case c: {
                ((Engine)((Object)this.a)).a("[WHITE]Server Status: [YELLOW]Connecting[]", ((Engine)((Object)this.a)).var_axy_c.a(), Color.WHITE, ((Engine)((Object)this.a)).var_axy_c.a(), Color.BLACK, 10.0f, 50.0f, 8);
                break;
            }
        }
        ((Engine)((Object)this.a)).var_axy_c.a().draw(((Engine)((Object)this.a)).var_azi_a, ((Engine)((Object)this.a)).var_java_lang_String_f, 60.0f, 720.0f, 0, ((Engine)((Object)this.a)).var_java_lang_String_f.length(), 450.0f, 8, true);
    }

    @Override
    public void resize(int n2, int n3) {
        super.resize(n2, n3);
        ((aya)((Object)this.a)).com_badlogic_gdx_scenes_scene2d_Stage_c().getViewport().update(n2, n3);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

