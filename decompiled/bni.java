/*
 * Decompiled with CFR 0.152.
 */
public class bni {
    protected final bgj var_bgj_a;
    protected final Class<? extends bck<?>> var_java_lang_Class___extends_bck_____a;
    protected final Class<? extends bcm> b;
    protected final Class<?> c;
    protected final boolean var_boolean_a;
    private static final bni var_bni_a;

    public bni(bgj bgj2, Class<?> clazz, Class<? extends bck<?>> clazz2, Class<? extends bcm> clazz3) {
        this(bgj2, clazz, clazz2, false, clazz3);
    }

    protected bni(bgj bgj2, Class<?> clazz, Class<? extends bck<?>> clazz2, boolean bl2, Class<? extends bcm> clazz3) {
        this.var_bgj_a = bgj2;
        this.c = clazz;
        this.var_bgj_a = clazz2;
        this.var_boolean_a = bl2;
        if (clazz3 == null) {
            clazz3 = bcp.class;
        }
        this.b = clazz3;
    }

    public static bni bni_a() {
        return var_bni_a;
    }

    public bni a(boolean bl2) {
        if (this.var_boolean_a == bl2) {
            return this;
        }
        return new bni(this.var_bgj_a, this.c, (Class<? extends bck<?>>)((Object)this.var_bgj_a), bl2, this.b);
    }

    public bgj bgj_a() {
        return this.var_bgj_a;
    }

    public Class<?> a() {
        return this.c;
    }

    public Class<? extends bck<?>> b() {
        return this.var_bgj_a;
    }

    public Class<? extends bcm> c() {
        return this.b;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    public String toString() {
        return "ObjectIdInfo: propName=" + this.var_bgj_a + ", scope=" + buk.java_lang_String_b(this.c) + ", generatorType=" + buk.java_lang_String_b(this.var_bgj_a) + ", alwaysAsId=" + this.var_boolean_a;
    }

    static {
        var_bni_a = new bni(bgj.var_bgj_b, Object.class, null, false, null);
    }
}

