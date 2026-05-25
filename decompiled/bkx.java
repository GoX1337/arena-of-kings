/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Array;
import java.util.Objects;

@bgp
public class bkx
extends bkg<Object[]>
implements bib {
    protected final boolean b;
    protected final Class<?> var_java_lang_Class____a;
    protected bfx<Object> var_bfx_java_lang_Object__a;
    protected final boc var_boc_a;
    protected final Object[] var_java_lang_Object_arr_a;

    public bkx(bfw bfw2, bfx<Object> bfx2, boc boc2) {
        super(bfw2, null, null);
        btl btl2 = (btl)bfw2;
        this.var_java_lang_Class____a = btl2.bfw_c().a();
        this.b = this.var_java_lang_Class____a == Object.class;
        this.var_java_lang_Class____a = bfx2;
        this.var_boc_a = boc2;
        this.var_java_lang_Object_arr_a = btl2.java_lang_Object_arr_a();
    }

    protected bkx(bkx bkx2, bfx<Object> bfx2, boc boc2, bil bil2, Boolean bl2) {
        super(bkx2, bil2, bl2);
        this.var_java_lang_Class____a = bkx2.var_java_lang_Class____a;
        this.b = bkx2.b;
        this.var_java_lang_Object_arr_a = bkx2.var_java_lang_Object_arr_a;
        this.var_java_lang_Class____a = bfx2;
        this.var_boc_a = boc2;
    }

    public bkx a(boc boc2, bfx<?> bfx2, bil bil2, Boolean bl2) {
        if (Objects.equals(bl2, this.var_java_lang_Class____a) && bil2 == this.var_java_lang_Class____a && bfx2 == this.var_java_lang_Class____a && boc2 == this.var_boc_a) {
            return this;
        }
        return new bkx(this, bfx2, boc2, bil2, bl2);
    }

    @Override
    public boolean boolean_a() {
        return this.var_java_lang_Class____a == null && this.var_boc_a == null;
    }

    @Override
    public btq btq_a() {
        return btq.var_btq_a;
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        bfx<Object> bfx2 = this.var_java_lang_Class____a;
        Boolean bl2 = this.a(bfs2, bfp2, (Class<?>)((bfw)((Object)this.var_java_lang_Class____a)).a(), bbk.a.var_bbk$a_a);
        bfx2 = this.a(bfs2, bfp2, bfx2);
        bfw bfw2 = ((bfw)((Object)this.var_java_lang_Class____a)).bfw_c();
        bfx2 = bfx2 == null ? bfs2.a(bfw2, bfp2) : bfs2.b(bfx2, bfp2, bfw2);
        boc boc2 = this.var_boc_a;
        if (boc2 != null) {
            boc2 = boc2.a(bfp2);
        }
        bil bil2 = this.a(bfs2, bfp2, bfx2);
        return this.a(boc2, bfx2, bil2, bl2);
    }

    @Override
    public bfx<Object> a() {
        return this.var_java_lang_Class____a;
    }

    @Override
    public buc buc_a() {
        return buc.b;
    }

    @Override
    public Object b(bfs bfs2) {
        return this.var_java_lang_Object_arr_a;
    }

    @Override
    public Object[] java_lang_Object_arr_a(bdc bdc2, bfs bfs2) {
        Object object;
        if (!bdc2.boolean_c()) {
            return this.b(bdc2, bfs2);
        }
        buy buy2 = bfs2.buy_a();
        Object[] objectArray = buy2.java_lang_Object_arr_a();
        int n2 = 0;
        boc boc2 = this.var_boc_a;
        try {
            bdf bdf2;
            while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                if (bdf2 == bdf.m) {
                    if (this.var_java_lang_Class____a != false) continue;
                    object = this.var_java_lang_Class____a.a(bfs2);
                } else {
                    object = boc2 == null ? ((bfx)((Object)this.var_java_lang_Class____a)).a(bdc2, bfs2) : ((bfx)((Object)this.var_java_lang_Class____a)).a(bdc2, bfs2, boc2);
                }
                if (n2 >= objectArray.length) {
                    objectArray = buy2.a(objectArray);
                    n2 = 0;
                }
                objectArray[n2++] = object;
            }
        }
        catch (Exception exception) {
            throw bfy.a((Throwable)exception, (Object)objectArray, buy2.b() + n2);
        }
        object = this.b ? buy2.b(objectArray, n2) : buy2.a(objectArray, n2, this.var_java_lang_Class____a);
        bfs2.a(buy2);
        return object;
    }

    @Override
    public Object[] a(bdc bdc2, bfs bfs2, boc boc2) {
        return (Object[])boc2.b(bdc2, bfs2);
    }

    @Override
    public Object[] a(bdc bdc2, bfs bfs2, Object[] objectArray) {
        Object object;
        if (!bdc2.boolean_c()) {
            Object[] objectArray2 = this.b(bdc2, bfs2);
            if (objectArray2 == null) {
                return objectArray;
            }
            int n2 = objectArray.length;
            Object[] objectArray3 = new Object[n2 + objectArray2.length];
            System.arraycopy(objectArray, 0, objectArray3, 0, n2);
            System.arraycopy(objectArray2, 0, objectArray3, n2, objectArray2.length);
            return objectArray3;
        }
        buy buy2 = bfs2.buy_a();
        int n3 = objectArray.length;
        Object[] objectArray4 = buy2.a(objectArray, n3);
        boc boc2 = this.var_boc_a;
        try {
            bdf bdf2;
            while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                if (bdf2 == bdf.m) {
                    if (this.var_java_lang_Class____a != false) continue;
                    object = this.var_java_lang_Class____a.a(bfs2);
                } else {
                    object = boc2 == null ? ((bfx)((Object)this.var_java_lang_Class____a)).a(bdc2, bfs2) : ((bfx)((Object)this.var_java_lang_Class____a)).a(bdc2, bfs2, boc2);
                }
                if (n3 >= objectArray4.length) {
                    objectArray4 = buy2.a(objectArray4);
                    n3 = 0;
                }
                objectArray4[n3++] = object;
            }
        }
        catch (Exception exception) {
            throw bfy.a((Throwable)exception, (Object)objectArray4, buy2.b() + n3);
        }
        object = this.b ? buy2.b(objectArray4, n3) : buy2.a(objectArray4, n3, this.var_java_lang_Class____a);
        bfs2.a(buy2);
        return object;
    }

    @Override
    protected Byte[] java_lang_Byte_arr_a(bdc bdc2, bfs bfs2) {
        byte[] byArray = bdc2.byte_arr_a(bfs2.bcq_a());
        Byte[] byteArray = new Byte[byArray.length];
        int n2 = byArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            byteArray[i2] = byArray[i2];
        }
        return byteArray;
    }

    protected Object[] b(bdc bdc2, bfs bfs2) {
        Object object;
        boolean bl2;
        boolean bl3 = bl2 = this.var_java_lang_Class____a == Boolean.TRUE || this.var_java_lang_Class____a == null && bfs2.a(bfu.q);
        if (!bl2) {
            if (bdc2.boolean_a(bdf.h)) {
                if (this.var_java_lang_Class____a == Byte.class) {
                    return this.java_lang_Byte_arr_a(bdc2, bfs2);
                }
                return (Object[])this.r(bdc2, bfs2);
            }
            return (Object[])bfs2.a((bfw)((Object)this.var_java_lang_Class____a), bdc2);
        }
        if (bdc2.boolean_a(bdf.m)) {
            if (this.var_java_lang_Class____a != false) {
                return this.var_java_lang_Object_arr_a;
            }
            object = this.var_java_lang_Class____a.a(bfs2);
        } else {
            object = this.var_boc_a == null ? ((bfx)((Object)this.var_java_lang_Class____a)).a(bdc2, bfs2) : ((bfx)((Object)this.var_java_lang_Class____a)).a(bdc2, bfs2, this.var_boc_a);
        }
        Object[] objectArray = this.b ? new Object[1] : (Object[])Array.newInstance(this.var_java_lang_Class____a, 1);
        objectArray[0] = object;
        return objectArray;
    }
}

