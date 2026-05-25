/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public final class btm
implements Serializable,
Comparable<btm> {
    private String var_java_lang_String_a;
    private Class<?> var_java_lang_Class____a;
    private int var_int_a;

    public btm() {
        this.var_java_lang_String_a = null;
        this.var_java_lang_String_a = null;
        this.var_int_a = 0;
    }

    public btm(Class<?> clazz) {
        this.var_java_lang_String_a = clazz;
        this.var_java_lang_String_a = clazz.getName();
        this.var_int_a = this.var_java_lang_String_a.hashCode();
    }

    public int a(btm btm2) {
        return this.var_java_lang_String_a.compareTo(btm2.var_java_lang_String_a);
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
        btm btm2 = (btm)object;
        return btm2.var_java_lang_String_a == this.var_java_lang_String_a;
    }

    public int hashCode() {
        return this.var_int_a;
    }

    public String toString() {
        return this.var_java_lang_String_a;
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.a((btm)object);
    }
}

