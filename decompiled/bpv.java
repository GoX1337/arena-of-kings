/*
 * Decompiled with CFR 0.152.
 */
public class bpv
extends bpw {
    static final bpv var_bpv_a;
    protected final String var_java_lang_String_a;

    public bpv(String string) {
        this.var_java_lang_String_a = string;
    }

    public static bpv a(String string) {
        if (string == null) {
            return null;
        }
        if (string.isEmpty()) {
            return var_bpv_a;
        }
        return new bpv(string);
    }

    @Override
    public bdf bdf_a() {
        return bdf.h;
    }

    @Override
    public final void a(bcy bcy2, bgo bgo2) {
        if (this.var_java_lang_String_a == null) {
            bcy2.e();
        } else {
            bcy2.b(this.var_java_lang_String_a);
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof bpv) {
            return ((bpv)object).var_java_lang_String_a.equals(this.var_java_lang_String_a);
        }
        return false;
    }

    public int hashCode() {
        return this.var_java_lang_String_a.hashCode();
    }

    static {
        var_bpv_a = new bpv("");
    }
}

