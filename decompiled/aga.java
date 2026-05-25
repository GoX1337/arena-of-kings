/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aga
implements axr {
    private List<fj> var_java_util_List_fj__a = new ArrayList<fj>();
    private Iterator<fj> var_java_util_Iterator_fj__a;

    public void a(Engine engine, fm fm2, String string, int n2, int n3, int n4) {
        fj fj2 = new fj(engine, fm2, string, n2, n3, n4);
        this.var_java_util_List_fj__a.add(fj2);
    }

    public fj a(Engine engine, int n2) {
        for (fj fj2 : this.var_java_util_List_fj__a) {
            if (fj2.int_a() != n2) continue;
            this.var_java_util_List_fj__a.remove();
            return fj2;
        }
        return null;
    }

    @Override
    public void a(float f2, Engine engine) {
    }

    public void a(float f2, Engine engine, Camera camera) {
        for (fj fj2 : this.var_java_util_List_fj__a) {
            fj2.b(f2, engine);
        }
        engine.var_azi_a.end();
        Gdx.gl.glEnable(3042);
        Gdx.gl.glBlendFunc(770, 771);
        engine.var_axf_a.begin();
        engine.var_axf_a.setProjectionMatrix(camera.combined);
        engine.var_axf_a.set(ShapeRenderer.ShapeType.Filled);
        for (fj fj2 : this.var_java_util_List_fj__a) {
            fj2.c(f2, engine);
        }
        engine.var_axf_a.setProjectionMatrix(engine.var_r_a.combined);
        engine.var_axf_a.end();
        Gdx.gl.glDisable(3042);
        engine.var_azi_a.begin();
        for (fj fj2 : this.var_java_util_List_fj__a) {
            fj2.d(f2, engine);
        }
    }

    @Override
    public void b(float f2, Engine engine) {
    }
}

