/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.IdentityHashMap;

public abstract class bte<T>
extends bgb<T>
implements Serializable {
    private static final Object var_java_lang_Object_a;
    protected final Class<T> var_java_lang_Class_T__a;

    protected bte(Class<T> clazz) {
        this.var_java_lang_Object_a = clazz;
    }

    protected bte(bfw bfw2) {
        this.var_java_lang_Object_a = bfw2.a();
    }

    protected bte(Class<?> clazz, boolean bl2) {
        this.var_java_lang_Object_a = clazz;
    }

    protected bte(bte<?> bte2) {
        this.var_java_lang_Object_a = bte2.var_java_lang_Object_a;
    }

    @Override
    public Class<T> a() {
        return this.var_java_lang_Object_a;
    }

    @Override
    public abstract void a(T var1, bcy var2, bgo var3);

    public void a(bgo bgo2, Throwable throwable, Object object, String string) {
        boolean bl2;
        while (throwable instanceof InvocationTargetException && throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        buk.java_lang_Throwable_a(throwable);
        boolean bl3 = bl2 = bgo2 == null || bgo2.a(bgn.e);
        if (throwable instanceof IOException) {
            if (!bl2 || !(throwable instanceof bfy)) {
                throw (IOException)throwable;
            }
        } else if (!bl2) {
            buk.java_lang_Throwable_b(throwable);
        }
        throw bfy.a(throwable, object, string);
    }

    public void a(bgo bgo2, Throwable throwable, Object object, int n2) {
        boolean bl2;
        while (throwable instanceof InvocationTargetException && throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        buk.java_lang_Throwable_a(throwable);
        boolean bl3 = bl2 = bgo2 == null || bgo2.a(bgn.e);
        if (throwable instanceof IOException) {
            if (!bl2 || !(throwable instanceof bfy)) {
                throw (IOException)throwable;
            }
        } else if (!bl2) {
            buk.java_lang_Throwable_b(throwable);
        }
        throw bfy.a(throwable, object, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected bgb<?> a(bgo bgo2, bfp bfp2, bgb<?> bgb2) {
        Object object;
        IdentityHashMap<bfp, Boolean> identityHashMap = (IdentityHashMap<bfp, Boolean>)bgo2.java_lang_Object_a(var_java_lang_Object_a);
        if (identityHashMap != null) {
            object = identityHashMap.get(bfp2);
            if (object != null) {
                return bgb2;
            }
        } else {
            identityHashMap = new IdentityHashMap<bfp, Boolean>();
            bgo2.a(var_java_lang_Object_a, identityHashMap);
        }
        identityHashMap.put(bfp2, Boolean.TRUE);
        try {
            object = this.b(bgo2, bfp2, bgb2);
            if (object != null) {
                bgb<?> bgb3 = bgo2.b((bgb<?>)object, bfp2);
                return bgb3;
            }
        }
        finally {
            identityHashMap.remove(bfp2);
        }
        return bgb2;
    }

    @Deprecated
    protected bgb<?> b(bgo bgo2, bfp bfp2, bgb<?> bgb2) {
        Object object;
        bmn bmn2;
        bfn bfn2 = bgo2.bfn_a();
        if (bte.a(bfn2, bfp2) && (bmn2 = bfp2.bmn_a()) != null && (object = bfn2.java_lang_Object_b(bmn2)) != null) {
            bum<Object, Object> bum2 = bgo2.a((bmg)bfp2.bmn_a(), object);
            bfw bfw2 = bum2.b(bgo2.btz_a());
            if (bgb2 == null && !bfw2.p()) {
                bgb2 = bgo2.a(bfw2);
            }
            return new bsz(bum2, bfw2, bgb2);
        }
        return bgb2;
    }

    protected bqm a(bgo bgo2, Object object, Object object2) {
        bqj bqj2 = bgo2.bqj_a();
        if (bqj2 == null) {
            bgo2.a(this.a(), "Cannot resolve PropertyFilter with id '" + object + "'; no FilterProvider configured");
        }
        return bqj2.a(object, object2);
    }

    protected bbk.d bbk$d_a(bgo bgo2, bfp bfp2, Class<?> clazz) {
        if (bfp2 != null) {
            return bfp2.bbk$d_a(bgo2.bgm_a(), clazz);
        }
        return bgo2.bbk$d_a(clazz);
    }

    protected Boolean a(bgo bgo2, bfp bfp2, Class<?> clazz, bbk.a a2) {
        bbk.d d2 = this.bbk$d_a(bgo2, bfp2, clazz);
        if (d2 != null) {
            return d2.a(a2);
        }
        return null;
    }

    protected bbr.b bbr$b_a(bgo bgo2, bfp bfp2, Class<?> clazz) {
        if (bfp2 != null) {
            return bfp2.bbr$b_a(bgo2.bgm_a(), clazz);
        }
        return bgo2.bbr$b_a(clazz);
    }

    protected bgb<?> b(bgo bgo2, bfp bfp2) {
        if (bfp2 != null) {
            Object object;
            bmn bmn2 = bfp2.bmn_a();
            bfn bfn2 = bgo2.bfn_a();
            if (bmn2 != null && (object = bfn2.java_lang_Object_d(bmn2)) != null) {
                return bgo2.a((bmg)bmn2, object);
            }
        }
        return null;
    }

    protected boolean a(bgb<?> bgb2) {
        return buk.boolean_a(bgb2);
    }

    protected static final boolean a(Object object, Object object2) {
        return object != null && object2 != null;
    }

    protected static final boolean b(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

    static {
        var_java_lang_Object_a = new Object();
    }
}

