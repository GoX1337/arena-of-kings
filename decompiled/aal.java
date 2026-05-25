/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntMap;
import java.util.ArrayList;
import java.util.List;

public class aal
extends InputAdapter {
    private final Engine var_com_arenaofkings_client_core_Engine_a;
    private final we var_we_a;
    public Array<aan> var_com_badlogic_gdx_utils_Array_aan__a;
    public IntMap<aam> var_com_badlogic_gdx_utils_IntMap_aam__a;
    private final int var_int_a = 51;
    Vector3 var_com_badlogic_gdx_math_Vector3_a;
    List<Integer> var_java_util_List_java_lang_Integer__a;

    public aal(Engine engine, we we2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_we_a = we2;
        this.a();
        this.var_com_badlogic_gdx_math_Vector3_a = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0.0f);
        this.var_com_arenaofkings_client_core_Engine_a = new ArrayList();
        this.var_com_arenaofkings_client_core_Engine_a.add(59);
        this.var_com_arenaofkings_client_core_Engine_a.add(60);
        this.var_com_arenaofkings_client_core_Engine_a.add(57);
        this.var_com_arenaofkings_client_core_Engine_a.add(58);
        this.var_com_arenaofkings_client_core_Engine_a.add(129);
        this.var_com_arenaofkings_client_core_Engine_a.add(130);
    }

    private void a() {
        this.var_com_arenaofkings_client_core_Engine_a = new Array(51);
        this.var_com_arenaofkings_client_core_Engine_a = new IntMap(51);
        this.a(new aao(66));
        this.a(new aap(30));
        this.a(new aap(37));
        this.a(new aaq(50));
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(new aav((Engine)((Object)this.var_we_a.var_com_badlogic_gdx_InputMultiplexer_a)));
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(new aas());
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(new aat());
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(new aau());
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(new aar());
        ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).add(new aaw());
    }

    private void a(aam aam2) {
        ((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).put(aam2.a(), aam2);
    }

    @Override
    public boolean keyDown(int n2) {
        if (!t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            return true;
        }
        if (this.var_com_arenaofkings_client_core_Engine_a.contains(n2)) {
            return false;
        }
        if (Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60) ? this.var_we_a.wh_a().aay_a().a().b(7000 + n2) : (Gdx.input.isKeyPressed(57) || Gdx.input.isKeyPressed(58) ? this.var_we_a.wh_a().aay_a().a().b(8000 + n2) : (Gdx.input.isKeyPressed(129) || Gdx.input.isKeyPressed(130) ? this.var_we_a.wh_a().aay_a().a().b(9000 + n2) : this.var_we_a.wh_a().aay_a().a().b(n2)))) {
            return true;
        }
        aam aam2 = (aam)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(n2);
        return aam2 != null && aam2.a(this.var_we_a);
    }

    @Override
    public boolean keyUp(int n2) {
        if (!t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            return true;
        }
        aam aam2 = (aam)((IntMap)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(n2);
        if (aam2 != null) {
            return aam2.b(this.var_we_a);
        }
        return false;
    }

    @Override
    public boolean keyTyped(char c2) {
        Engine.a("keyTyped: " + c2);
        return false;
    }

    @Override
    public boolean touchDown(int n2, int n3, int n4, int n5) {
        if (!t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            return true;
        }
        this.a(n2, n3);
        Engine.b("touchDown");
        if (this.var_we_a.wh_a().zi_a().aaf_a().aaa_a() != null) {
            Engine.b("Closing it");
            if (this.var_we_a.wh_a().zi_a().aaf_a().aaa_a().aab_a().boolean_a()) {
                this.var_we_a.wh_a().zi_a().aaf_a().aaa_a().a((float)n2, n3);
            }
        }
        if (n5 == 0 || n5 == 1) {
            for (int i2 = 0; i2 < ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size; ++i2) {
                aan aan2 = (aan)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(i2);
                if (!aan2.a(this.var_we_a, (int)this.var_com_badlogic_gdx_math_Vector3_a.x, (int)this.var_com_badlogic_gdx_math_Vector3_a.y, n4, n5)) continue;
                return true;
            }
        }
        return n5 > 1 && this.var_we_a.wh_a().aay_a().a().b(5000 + n5);
    }

    @Override
    public boolean touchUp(int n2, int n3, int n4, int n5) {
        if (!t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            return true;
        }
        this.a(n2, n3);
        if (this.var_we_a.wh_a().zi_a().aaf_a().aaa_a() != null && this.var_we_a.wh_a().zi_a().aaf_a().aaa_a().aab_a().boolean_a()) {
            this.var_we_a.wh_a().zi_a().aaf_a().aaa_a().void_a();
        }
        if (n5 == 0 || n5 == 1) {
            for (int i2 = 0; i2 < ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size; ++i2) {
                aan aan2 = (aan)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(i2);
                if (!aan2.b(this.var_we_a, (int)this.var_com_badlogic_gdx_math_Vector3_a.x, (int)this.var_com_badlogic_gdx_math_Vector3_a.y, n4, n5)) continue;
                return true;
            }
        }
        if (n5 == 0) {
            this.var_we_a.wh_a().a(null, 0, 0, null);
        }
        return false;
    }

    @Override
    public boolean touchDragged(int n2, int n3, int n4) {
        if (!t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            return true;
        }
        if (!Gdx.input.isButtonPressed(0)) {
            return false;
        }
        this.a(n2, n3);
        if (this.var_we_a.wh_a().zi_a().aaf_a().aaa_a() != null && this.var_we_a.wh_a().zi_a().aaf_a().aaa_a().aab_a().boolean_a()) {
            this.var_we_a.wh_a().zi_a().aaf_a().aaa_a().b((float)n2, n3);
        }
        for (int i2 = 0; i2 < ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size; ++i2) {
            aan aan2 = (aan)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(i2);
            if (!aan2.a(this.var_we_a, (int)this.var_com_badlogic_gdx_math_Vector3_a.x, (int)this.var_com_badlogic_gdx_math_Vector3_a.y, n4)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int n2, int n3) {
        this.a(n2, n3);
        return super.mouseMoved((int)this.var_com_badlogic_gdx_math_Vector3_a.x, (int)this.var_com_badlogic_gdx_math_Vector3_a.y);
    }

    @Override
    public boolean scrolled(float f2, float f3) {
        if (!t.a(we.class, this.var_com_arenaofkings_client_core_Engine_a)) {
            return true;
        }
        if (f3 > 0.0f ? this.var_we_a.wh_a().aay_a().a().b(6000) : f3 < 0.0f && this.var_we_a.wh_a().aay_a().a().b(6001)) {
            return true;
        }
        for (int i2 = 0; i2 < ((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).size; ++i2) {
            aan aan2 = (aan)((Array)((Object)this.var_com_arenaofkings_client_core_Engine_a)).get(i2);
            if (!aan2.a(this.var_we_a, f3)) continue;
            return true;
        }
        return false;
    }

    private void a(int n2, int n3) {
        this.var_com_badlogic_gdx_math_Vector3_a = this.var_we_a.wh_a().com_badlogic_gdx_scenes_scene2d_Stage_c().getCamera().unproject(new Vector3(n2, n3, 0.0f));
    }
}

