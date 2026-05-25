/*
 * Decompiled with CFR 0.152.
 */
public abstract class bpc
extends bog {
    protected final boe var_boe_a;
    protected final bfp var_bfp_a;

    protected bpc(boe boe2, bfp bfp2) {
        this.var_boe_a = boe2;
        this.var_bfp_a = bfp2;
    }

    @Override
    public String java_lang_String_a() {
        return null;
    }

    @Override
    public beu a(bcy bcy2, beu beu2) {
        this.a(beu2);
        return bcy2.a(beu2);
    }

    @Override
    public beu b(bcy bcy2, beu beu2) {
        return bcy2.b(beu2);
    }

    protected void a(beu beu2) {
        Object object = beu2.b;
        if (object == null) {
            Object object2 = beu2.var_java_lang_Object_a;
            Object object3 = beu2.var_java_lang_Object_a;
            object = object3 == null ? this.java_lang_String_a(object2) : this.a(object2, (Class<?>)object3);
            beu2.b = object;
        }
    }

    protected String java_lang_String_a(Object object) {
        String string = this.var_boe_a.a(object);
        if (string == null) {
            this.void_a(object);
        }
        return string;
    }

    protected String a(Object object, Class<?> clazz) {
        String string = this.var_boe_a.a(object, clazz);
        if (string == null) {
            this.void_a(object);
        }
        return string;
    }

    protected void void_a(Object object) {
    }
}

