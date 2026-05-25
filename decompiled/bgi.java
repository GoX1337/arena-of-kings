/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bgi
implements Serializable {
    public static final bgi var_bgi_a;
    public static final bgi var_bgi_b;
    public static final bgi c;
    protected final Boolean var_java_lang_Boolean_a;
    protected final String var_java_lang_String_a;
    protected final Integer var_java_lang_Integer_a;
    protected final String var_java_lang_String_b;
    protected final transient a var_bgi$a_a;
    protected bcj var_bcj_a;
    protected bcj var_bcj_b;

    protected bgi(Boolean bl2, String string, Integer n2, String string2, a a2, bcj bcj2, bcj bcj3) {
        this.var_java_lang_Boolean_a = bl2;
        this.var_java_lang_String_a = string;
        this.var_java_lang_Integer_a = n2;
        this.var_java_lang_String_b = string2 == null || string2.isEmpty() ? null : string2;
        this.var_bgi$a_a = a2;
        this.var_bcj_a = bcj2;
        this.var_bcj_b = bcj3;
    }

    public static bgi a(Boolean bl2, String string, Integer n2, String string2) {
        if (string != null || n2 != null || string2 != null) {
            return new bgi(bl2, string, n2, string2, null, null, null);
        }
        if (bl2 == null) {
            return c;
        }
        return bl2 != false ? var_bgi_a : var_bgi_b;
    }

    public bgi a(String string) {
        return new bgi(this.var_java_lang_Boolean_a, string, this.var_java_lang_Integer_a, this.var_java_lang_String_b, this.var_bgi$a_a, this.var_bcj_a, this.var_bcj_b);
    }

    public bgi a(a a2) {
        return new bgi(this.var_java_lang_Boolean_a, this.var_java_lang_String_a, this.var_java_lang_Integer_a, this.var_java_lang_String_b, a2, this.var_bcj_a, this.var_bcj_b);
    }

    public bgi a(bcj bcj2, bcj bcj3) {
        return new bgi(this.var_java_lang_Boolean_a, this.var_java_lang_String_a, this.var_java_lang_Integer_a, this.var_java_lang_String_b, this.var_bgi$a_a, bcj2, bcj3);
    }

    public boolean boolean_a() {
        return this.var_java_lang_Boolean_a != null && this.var_java_lang_Boolean_a != false;
    }

    public Integer java_lang_Integer_a() {
        return this.var_java_lang_Integer_a;
    }

    public boolean boolean_b() {
        return this.var_java_lang_Integer_a != null;
    }

    public a bgi$a_a() {
        return this.var_bgi$a_a;
    }

    public bcj bcj_a() {
        return this.var_bcj_a;
    }

    public bcj bcj_b() {
        return this.var_bcj_b;
    }

    static {
        var_bgi_a = new bgi(Boolean.TRUE, null, null, null, null, null, null);
        var_bgi_b = new bgi(Boolean.FALSE, null, null, null, null, null, null);
        c = new bgi(null, null, null, null, null, null, null);
    }

    public static final class a {
        public final bmn var_bmn_a;
        public final boolean var_boolean_a;

        protected a(bmn bmn2, boolean bl2) {
            this.var_bmn_a = bmn2;
            this.var_boolean_a = bl2;
        }

        public static a a(bmn bmn2) {
            return new a(bmn2, true);
        }

        public static a b(bmn bmn2) {
            return new a(bmn2, false);
        }

        public static a c(bmn bmn2) {
            return new a(bmn2, false);
        }
    }
}

