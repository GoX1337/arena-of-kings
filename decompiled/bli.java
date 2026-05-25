/*
 * Decompiled with CFR 0.152.
 */
import java.util.Objects;

@bgp
public final class bli
extends blc<String[]>
implements bib {
    private static final String[] var_java_lang_String_arr_a;
    public static final bli var_bli_a;
    protected bfx<String> var_bfx_java_lang_String__a;
    protected final bil var_bil_a;
    protected final Boolean var_java_lang_Boolean_a;
    protected final boolean var_boolean_a;

    public bli() {
        this(null, null, null);
    }

    protected bli(bfx<?> bfx2, bil bil2, Boolean bl2) {
        super(String[].class);
        this.var_java_lang_String_arr_a = bfx2;
        this.var_bil_a = bil2;
        this.var_java_lang_Boolean_a = bl2;
        this.var_boolean_a = bjj.a(bil2);
    }

    @Override
    public btq btq_a() {
        return btq.var_btq_a;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return Boolean.TRUE;
    }

    @Override
    public buc buc_a() {
        return buc.b;
    }

    @Override
    public Object b(bfs bfs2) {
        return var_java_lang_String_arr_a;
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        Object object = this.var_java_lang_String_arr_a;
        object = this.a(bfs2, bfp2, (bfx<?>)object);
        bfw bfw2 = bfs2.bfw_a(String.class);
        object = object == null ? bfs2.a(bfw2, bfp2) : bfs2.b((bfx<?>)object, bfp2, bfw2);
        Boolean bl2 = this.a(bfs2, bfp2, String[].class, bbk.a.var_bbk$a_a);
        bil bil2 = this.a(bfs2, bfp2, (bfx<?>)object);
        if (object != null && this.a((bfx<?>)object)) {
            object = null;
        }
        if (this.var_java_lang_String_arr_a == object && Objects.equals(this.var_java_lang_Boolean_a, bl2) && this.var_bil_a == bil2) {
            return this;
        }
        return new bli((bfx<?>)object, bil2, bl2);
    }

    @Override
    public String[] a(bdc bdc2, bfs bfs2) {
        String[] stringArray;
        if (!bdc2.boolean_c()) {
            return this.b(bdc2, bfs2);
        }
        if (this.var_java_lang_String_arr_a != null) {
            return this.a(bdc2, bfs2, (String[])null);
        }
        buy buy2 = bfs2.buy_a();
        Object[] objectArray = buy2.java_lang_Object_arr_a();
        int n2 = 0;
        try {
            while (true) {
                if ((stringArray = bdc2.java_lang_String_b()) == null) {
                    bdf bdf2 = bdc2.bdf_c();
                    if (bdf2 == bdf.var_bdf_e) break;
                    if (bdf2 == bdf.m) {
                        if (this.var_boolean_a) continue;
                        stringArray = (String)this.var_bil_a.a(bfs2);
                    } else {
                        stringArray = this.a(bdc2, bfs2);
                    }
                }
                if (n2 >= objectArray.length) {
                    objectArray = buy2.a(objectArray);
                    n2 = 0;
                }
                objectArray[n2++] = stringArray;
            }
        }
        catch (Exception exception) {
            throw bfy.a((Throwable)exception, (Object)objectArray, buy2.b() + n2);
        }
        stringArray = buy2.a(objectArray, n2, String.class);
        bfs2.a(buy2);
        return stringArray;
    }

    @Override
    protected final String[] a(bdc bdc2, bfs bfs2, String[] stringArray) {
        String[] stringArray2;
        Object[] objectArray;
        int n2;
        buy buy2 = bfs2.buy_a();
        if (stringArray == null) {
            n2 = 0;
            objectArray = buy2.java_lang_Object_arr_a();
        } else {
            n2 = stringArray.length;
            objectArray = buy2.a(stringArray, n2);
        }
        String[] stringArray3 = this.var_java_lang_String_arr_a;
        try {
            while (true) {
                if (bdc2.java_lang_String_b() == null) {
                    bdf bdf2 = bdc2.bdf_c();
                    if (bdf2 == bdf.var_bdf_e) break;
                    if (bdf2 == bdf.m) {
                        if (this.var_boolean_a) continue;
                        stringArray2 = (String)this.var_bil_a.a(bfs2);
                    } else {
                        stringArray2 = (String)stringArray3.a(bdc2, bfs2);
                    }
                } else {
                    stringArray2 = (String[])stringArray3.a(bdc2, bfs2);
                }
                if (n2 >= objectArray.length) {
                    objectArray = buy2.a(objectArray);
                    n2 = 0;
                }
                objectArray[n2++] = stringArray2;
            }
        }
        catch (Exception exception) {
            throw bfy.a((Throwable)exception, String.class, n2);
        }
        stringArray2 = buy2.a(objectArray, n2, String.class);
        bfs2.a(buy2);
        return stringArray2;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.b(bdc2, bfs2);
    }

    public String[] b(bdc bdc2, bfs bfs2, String[] stringArray) {
        String[] stringArray2;
        if (!bdc2.boolean_c()) {
            String[] stringArray3 = this.b(bdc2, bfs2);
            if (stringArray3 == null) {
                return stringArray;
            }
            int n2 = stringArray.length;
            String[] stringArray4 = new String[n2 + stringArray3.length];
            System.arraycopy(stringArray, 0, stringArray4, 0, n2);
            System.arraycopy(stringArray3, 0, stringArray4, n2, stringArray3.length);
            return stringArray4;
        }
        if (this.var_java_lang_String_arr_a != null) {
            return this.a(bdc2, bfs2, stringArray);
        }
        buy buy2 = bfs2.buy_a();
        int n3 = stringArray.length;
        Object[] objectArray = buy2.a(stringArray, n3);
        try {
            while (true) {
                if ((stringArray2 = bdc2.java_lang_String_b()) == null) {
                    bdf bdf2 = bdc2.bdf_c();
                    if (bdf2 == bdf.var_bdf_e) break;
                    if (bdf2 == bdf.m) {
                        if (this.var_boolean_a) {
                            return var_java_lang_String_arr_a;
                        }
                        stringArray2 = (String)this.var_bil_a.a(bfs2);
                    } else {
                        stringArray2 = this.a(bdc2, bfs2);
                    }
                }
                if (n3 >= objectArray.length) {
                    objectArray = buy2.a(objectArray);
                    n3 = 0;
                }
                objectArray[n3++] = stringArray2;
            }
        }
        catch (Exception exception) {
            throw bfy.a((Throwable)exception, (Object)objectArray, buy2.b() + n3);
        }
        stringArray2 = buy2.a(objectArray, n3, String.class);
        bfs2.a(buy2);
        return stringArray2;
    }

    private final String[] b(bdc bdc2, bfs bfs2) {
        boolean bl2;
        boolean bl3 = bl2 = this.var_java_lang_Boolean_a == Boolean.TRUE || this.var_java_lang_Boolean_a == null && bfs2.a(bfu.q);
        if (bl2) {
            Object object = bdc2.boolean_a(bdf.m) ? (String)this.var_bil_a.a(bfs2) : this.a(bdc2, bfs2);
            return new String[]{object};
        }
        if (bdc2.boolean_a(bdf.h)) {
            return (String[])this.r(bdc2, bfs2);
        }
        return (String[])bfs2.a(this.b, bdc2);
    }

    @Override
    public /* synthetic */ Object a(bdc bdc2, bfs bfs2, Object object) {
        return this.b(bdc2, bfs2, (String[])object);
    }

    static {
        var_java_lang_String_arr_a = new String[0];
        var_bli_a = new bli();
    }
}

