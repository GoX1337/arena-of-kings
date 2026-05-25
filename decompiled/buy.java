/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Array;
import java.util.List;

public final class buy {
    private bur<Object[]> var_bur_java_lang_Object_arr__a;
    private bur<Object[]> b;
    private int var_int_a;
    private Object[] var_java_lang_Object_arr_a;

    public Object[] java_lang_Object_arr_a() {
        this.void_a();
        if (this.var_java_lang_Object_arr_a == null) {
            this.var_java_lang_Object_arr_a = new Object[12];
            return this.var_java_lang_Object_arr_a;
        }
        return this.var_java_lang_Object_arr_a;
    }

    public Object[] a(Object[] objectArray, int n2) {
        this.void_a();
        if (this.var_java_lang_Object_arr_a == null || this.var_java_lang_Object_arr_a.length < n2) {
            this.var_java_lang_Object_arr_a = new Object[Math.max(12, n2)];
        }
        System.arraycopy(objectArray, 0, this.var_java_lang_Object_arr_a, 0, n2);
        return this.var_java_lang_Object_arr_a;
    }

    public Object[] a(Object[] objectArray) {
        bur<Object[]> bur2 = new bur<Object[]>(objectArray, null);
        if (this.var_bur_java_lang_Object_arr__a == null) {
            this.b = bur2;
            this.var_bur_java_lang_Object_arr__a = this.b;
        } else {
            this.b.a(bur2);
            this.b = bur2;
        }
        int n2 = objectArray.length;
        this.var_int_a += n2;
        if (n2 < 16384) {
            n2 += n2;
        } else if (n2 < 262144) {
            n2 += n2 >> 2;
        }
        return new Object[n2];
    }

    public Object[] b(Object[] objectArray, int n2) {
        int n3 = n2 + this.var_int_a;
        Object[] objectArray2 = new Object[n3];
        this.a(objectArray2, n3, objectArray, n2);
        this.void_a();
        return objectArray2;
    }

    public <T> T[] a(Object[] objectArray, int n2, Class<T> clazz) {
        int n3 = n2 + this.var_int_a;
        Object[] objectArray2 = (Object[])Array.newInstance(clazz, n3);
        this.a(objectArray2, n3, objectArray, n2);
        this.void_a();
        return objectArray2;
    }

    public void a(Object[] objectArray, int n2, List<Object> list) {
        for (Object[] objectArray2 = this.var_bur_java_lang_Object_arr__a; objectArray2 != null; objectArray2 = objectArray2.a()) {
            Object[] objectArray3 = objectArray2.a();
            int n3 = objectArray3.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                list.add(objectArray3[i2]);
            }
        }
        for (int i3 = 0; i3 < n2; ++i3) {
            list.add(objectArray[i3]);
        }
        this.void_a();
    }

    public int int_a() {
        return this.var_java_lang_Object_arr_a == null ? 0 : this.var_java_lang_Object_arr_a.length;
    }

    public int b() {
        return this.var_int_a;
    }

    protected void void_a() {
        if (this.b != null) {
            this.var_java_lang_Object_arr_a = this.b.a();
        }
        this.b = null;
        this.var_bur_java_lang_Object_arr__a = null;
        this.var_int_a = 0;
    }

    protected final void a(Object object, int n2, Object[] objectArray, int n3) {
        int n4 = 0;
        for (Object[] objectArray2 = this.var_bur_java_lang_Object_arr__a; objectArray2 != null; objectArray2 = objectArray2.a()) {
            Object[] objectArray3 = objectArray2.a();
            int n5 = objectArray3.length;
            System.arraycopy(objectArray3, 0, object, n4, n5);
            n4 += n5;
        }
        System.arraycopy(objectArray, 0, object, n4, n3);
        if ((n4 += n3) != n2) {
            throw new IllegalStateException("Should have gotten " + n2 + " entries, got " + n4);
        }
    }
}

