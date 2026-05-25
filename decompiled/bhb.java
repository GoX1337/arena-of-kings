/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bhb
implements Serializable {
    private static final int var_int_a;
    protected Boolean var_java_lang_Boolean_a = false;
    protected final bha[] var_bha_arr_a = new bha[var_int_a];

    public bha a(bhe bhe2) {
        return this.var_bha_arr_a[bhe2.ordinal()];
    }

    public Boolean a() {
        return this.var_java_lang_Boolean_a;
    }

    static {
        var_int_a = bhe.values().length;
    }
}

