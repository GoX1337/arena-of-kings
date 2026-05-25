/*
 * Decompiled with CFR 0.152.
 */
public abstract class bog {
    public abstract bog a(bfp var1);

    public abstract bce.a bce$a_a();

    public abstract String java_lang_String_a();

    public beu a(Object object, bdf bdf2) {
        beu beu2 = new beu(object, bdf2);
        switch (this.bce$a_a()) {
            case e: {
                beu2.var_beu$a_a = beu.a.d;
                beu2.var_java_lang_String_a = this.java_lang_String_a();
                break;
            }
            case d: {
                beu2.var_beu$a_a = beu.a.e;
                beu2.var_java_lang_String_a = this.java_lang_String_a();
                break;
            }
            case var_bce$a_a: {
                beu2.var_beu$a_a = beu.a.c;
                beu2.var_java_lang_String_a = this.java_lang_String_a();
                break;
            }
            case c: {
                beu2.var_beu$a_a = beu.a.var_beu$a_a;
                break;
            }
            case b: {
                beu2.var_beu$a_a = beu.a.b;
                break;
            }
            default: {
                bfl.a();
            }
        }
        return beu2;
    }

    public beu a(Object object, bdf bdf2, Object object2) {
        beu beu2 = this.a(object, bdf2);
        beu2.b = object2;
        return beu2;
    }

    public beu a(Object object, Class<?> clazz, bdf bdf2) {
        beu beu2 = this.a(object, bdf2);
        beu2.var_java_lang_Object_a = clazz;
        return beu2;
    }

    public abstract beu a(bcy var1, beu var2);

    public abstract beu b(bcy var1, beu var2);
}

