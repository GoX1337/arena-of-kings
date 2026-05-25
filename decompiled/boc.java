/*
 * Decompiled with CFR 0.152.
 */
public abstract class boc {
    public abstract boc a(bfp var1);

    public abstract bce.a bce$a_a();

    public abstract String java_lang_String_a();

    public abstract boe boe_a();

    public abstract Class<?> a();

    public boolean boolean_a() {
        return this.a() != null;
    }

    public abstract Object java_lang_Object_a(bdc var1, bfs var2);

    public abstract Object b(bdc var1, bfs var2);

    public abstract Object c(bdc var1, bfs var2);

    public abstract Object d(bdc var1, bfs var2);

    public static Object a(bdc bdc2, bfs bfs2, bfw bfw2) {
        return boc.a(bdc2, bfs2, bfw2.a());
    }

    public static Object a(bdc bdc2, bfs bfs2, Class<?> clazz) {
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == null) {
            return null;
        }
        switch (bdf2) {
            case h: {
                if (!clazz.isAssignableFrom(String.class)) break;
                return bdc2.java_lang_String_e();
            }
            case i: {
                if (!clazz.isAssignableFrom(Integer.class)) break;
                return bdc2.int_e();
            }
            case j: {
                if (!clazz.isAssignableFrom(Double.class)) break;
                return bdc2.double_a();
            }
            case k: {
                if (!clazz.isAssignableFrom(Boolean.class)) break;
                return Boolean.TRUE;
            }
            case l: {
                if (!clazz.isAssignableFrom(Boolean.class)) break;
                return Boolean.FALSE;
            }
        }
        return null;
    }
}

