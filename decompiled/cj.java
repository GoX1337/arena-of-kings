/*
 * Decompiled with CFR 0.152.
 */
import com.arenaofkings.client.core.Engine;
import java.util.ArrayList;
import java.util.List;

public abstract class cj {
    protected final Engine var_com_arenaofkings_client_core_Engine_a = new ArrayList();
    protected final cg var_cg_a;
    protected ayf var_ayf_a;
    protected List<fm> var_java_util_List_fm__a;
    protected boolean var_boolean_a = false;

    public cj(Engine engine, cg cg2) {
        this.var_com_arenaofkings_client_core_Engine_a = engine;
        this.var_cg_a = cg2;
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    private void b(float f2) {
        this.var_ayf_a.a(f2, this.var_com_arenaofkings_client_core_Engine_a);
        if (this.var_boolean_a) {
            this.var_ayf_a.b(true);
        }
        this.var_ayf_a.b(f2, this.var_com_arenaofkings_client_core_Engine_a);
    }

    public void a(float f2) {
        this.b(f2);
    }
}

