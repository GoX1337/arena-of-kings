/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Map;

public class bnr
implements bmy.a,
Serializable {
    protected final bmy.a var_bmy$a_a;
    protected Map<btm, Class<?>> cfr_renamed_34;

    public bnr(bmy.a a2) {
        this.var_bmy$a_a = a2;
    }

    @Override
    public Class<?> a(Class<?> clazz) {
        Class clazz2;
        Class clazz3 = clazz2 = this.var_bmy$a_a == null ? null : this.var_bmy$a_a.a(clazz);
        if (clazz2 == null && this.var_bmy$a_a != null) {
            clazz2 = (Class)this.var_bmy$a_a.get(new btm(clazz));
        }
        return clazz2;
    }

    public boolean a() {
        if (this.var_bmy$a_a == null) {
            if (this.var_bmy$a_a == null) {
                return false;
            }
            if (this.var_bmy$a_a instanceof bnr) {
                return ((bnr)this.var_bmy$a_a).a();
            }
        }
        return true;
    }
}

