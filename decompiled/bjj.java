/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bjj
implements bil,
Serializable {
    private static final bjj var_bjj_a;
    private static final bjj b;
    protected final Object var_java_lang_Object_a;
    protected final buc var_buc_a;

    protected bjj(Object object) {
        this.var_java_lang_Object_a = object;
        this.var_buc_a = this.var_java_lang_Object_a == null ? buc.var_buc_a : buc.b;
    }

    public static bjj a() {
        return var_bjj_a;
    }

    public static bjj b() {
        return b;
    }

    public static bjj a(Object object) {
        if (object == null) {
            return b;
        }
        return new bjj(object);
    }

    public static boolean a(bil bil2) {
        return bil2 == var_bjj_a;
    }

    @Override
    public Object a(bfs bfs2) {
        return this.var_java_lang_Object_a;
    }

    static {
        var_bjj_a = new bjj(null);
        b = new bjj(null);
    }
}

