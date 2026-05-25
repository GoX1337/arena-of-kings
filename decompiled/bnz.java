/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Objects;

public final class bnz
implements Serializable {
    protected final Class<?> var_java_lang_Class____a;
    protected final int var_int_a;
    protected String var_java_lang_String_a;

    public bnz(Class<?> clazz) {
        this(clazz, null);
    }

    public bnz(Class<?> clazz, String string) {
        this.var_java_lang_Class____a = clazz;
        this.var_int_a = clazz.getName().hashCode() + (string == null ? 0 : string.hashCode());
        this.a(string);
    }

    public Class<?> a() {
        return this.var_java_lang_Class____a;
    }

    public String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    public void a(String string) {
        this.var_java_lang_String_a = string == null || string.isEmpty() ? null : string;
    }

    public boolean boolean_a() {
        return this.var_java_lang_String_a != null;
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
        bnz bnz2 = (bnz)object;
        return this.var_java_lang_Class____a == bnz2.var_java_lang_Class____a && Objects.equals(this.var_java_lang_String_a, bnz2.var_java_lang_String_a);
    }

    public int hashCode() {
        return this.var_int_a;
    }

    public String toString() {
        return "[NamedType, class " + this.var_java_lang_Class____a.getName() + ", name: " + (this.var_java_lang_String_a == null ? "null" : "'" + this.var_java_lang_String_a + "'") + "]";
    }
}

