/*
 * Decompiled with CFR 0.152.
 */
public class biq {
    private final Object var_java_lang_Object_a;
    private final bda var_bda_a;
    private final Class<?> var_java_lang_Class____a;

    public biq(Object object, Class<?> clazz, bda bda2) {
        this.var_java_lang_Object_a = object;
        this.var_java_lang_Object_a = clazz;
        this.var_bda_a = bda2;
    }

    public String toString() {
        return String.format("Object id [%s] (for %s) at %s", this.var_java_lang_Object_a, buk.java_lang_String_b(this.var_java_lang_Object_a), this.var_bda_a);
    }
}

