/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bgj
implements Serializable {
    public static final bgj var_bgj_a;
    public static final bgj var_bgj_b;
    protected final String var_java_lang_String_a;
    protected final String var_java_lang_String_b;
    protected bdi var_bdi_a;

    public bgj(String string) {
        this(string, null);
    }

    public bgj(String string, String string2) {
        this.var_java_lang_String_a = buk.a(string);
        this.var_java_lang_String_b = string2;
    }

    public static bgj bgj_a(String string) {
        if (string == null || string.isEmpty()) {
            return var_bgj_a;
        }
        return new bgj(bfb.var_bfb_a.a(string), null);
    }

    public static bgj a(String string, String string2) {
        if (string == null) {
            string = "";
        }
        if (string2 == null && string.isEmpty()) {
            return var_bgj_a;
        }
        return new bgj(bfb.var_bfb_a.a(string), string2);
    }

    public bgj bgj_a() {
        if (this.var_java_lang_String_a.isEmpty()) {
            return this;
        }
        String string = bfb.var_bfb_a.a(this.var_java_lang_String_a);
        if (string == this.var_java_lang_String_a) {
            return this;
        }
        return new bgj(string, this.var_java_lang_String_b);
    }

    public bgj b(String string) {
        if (string == null) {
            string = "";
        }
        if (string.equals(this.var_java_lang_String_a)) {
            return this;
        }
        return new bgj(string, this.var_java_lang_String_b);
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public bdi a(bhm<?> bhm2) {
        bdi bdi2 = this.var_bdi_a;
        if (bdi2 == null) {
            bdi2 = bhm2 == null ? new bee(this.var_java_lang_String_a) : bhm2.a(this.var_java_lang_String_a);
            this.var_bdi_a = bdi2;
        }
        return bdi2;
    }

    public boolean boolean_a() {
        return !this.var_java_lang_String_a.isEmpty();
    }

    public boolean boolean_a(String string) {
        return this.var_java_lang_String_a.equals(string);
    }

    public boolean b() {
        return this.var_java_lang_String_b != null;
    }

    public boolean c() {
        return this.var_java_lang_String_b == null && this.var_java_lang_String_a.isEmpty();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        bgj bgj2 = (bgj)object;
        if (this.var_java_lang_String_a == null ? bgj2.var_java_lang_String_a != null : !this.var_java_lang_String_a.equals(bgj2.var_java_lang_String_a)) {
            return false;
        }
        if (this.var_java_lang_String_b == null) {
            return null == bgj2.var_java_lang_String_b;
        }
        return this.var_java_lang_String_b.equals(bgj2.var_java_lang_String_b);
    }

    public int hashCode() {
        if (this.var_java_lang_String_b == null) {
            return this.var_java_lang_String_a.hashCode();
        }
        return this.var_java_lang_String_b.hashCode() ^ this.var_java_lang_String_a.hashCode();
    }

    public String toString() {
        if (this.var_java_lang_String_b == null) {
            return this.var_java_lang_String_a;
        }
        return "{" + this.var_java_lang_String_b + "}" + this.var_java_lang_String_a;
    }

    static {
        var_bgj_a = new bgj("", null);
        var_bgj_b = new bgj(new String(""), null);
    }
}

