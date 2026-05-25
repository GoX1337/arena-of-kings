/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Array;

public final class bue {
    private a var_bue$a_a = null;
    private b var_bue$b_a = null;
    private g var_bue$g_a = null;
    private e var_bue$e_a = null;
    private f var_bue$f_a = null;
    private d var_bue$d_a = null;
    private c var_bue$c_a = null;

    public a bue$a_a() {
        if (this.var_bue$a_a == null) {
            this.var_bue$a_a = new a();
        }
        return this.var_bue$a_a;
    }

    public b bue$b_a() {
        if (this.var_bue$b_a == null) {
            this.var_bue$b_a = new b();
        }
        return this.var_bue$b_a;
    }

    public g bue$g_a() {
        if (this.var_bue$g_a == null) {
            this.var_bue$g_a = new g();
        }
        return this.var_bue$g_a;
    }

    public e bue$e_a() {
        if (this.var_bue$e_a == null) {
            this.var_bue$e_a = new e();
        }
        return this.var_bue$e_a;
    }

    public f bue$f_a() {
        if (this.var_bue$f_a == null) {
            this.var_bue$f_a = new f();
        }
        return this.var_bue$f_a;
    }

    public d bue$d_a() {
        if (this.var_bue$d_a == null) {
            this.var_bue$d_a = new d();
        }
        return this.var_bue$d_a;
    }

    public c bue$c_a() {
        if (this.var_bue$c_a == null) {
            this.var_bue$c_a = new c();
        }
        return this.var_bue$c_a;
    }

    public static Object a(Object object) {
        int n2 = Array.getLength(object);
        Class<?> clazz = object.getClass();
        return new buf(clazz, n2, object);
    }

    public static final class c
    extends buz<double[]> {
        @Override
        public final double[] a(int n2) {
            return new double[n2];
        }
    }

    public static final class d
    extends buz<float[]> {
        @Override
        public final float[] a(int n2) {
            return new float[n2];
        }
    }

    public static final class f
    extends buz<long[]> {
        @Override
        public final long[] a(int n2) {
            return new long[n2];
        }
    }

    public static final class e
    extends buz<int[]> {
        @Override
        public final int[] a(int n2) {
            return new int[n2];
        }
    }

    public static final class g
    extends buz<short[]> {
        @Override
        public final short[] a(int n2) {
            return new short[n2];
        }
    }

    public static final class b
    extends buz<byte[]> {
        @Override
        public final byte[] a(int n2) {
            return new byte[n2];
        }
    }

    public static final class a
    extends buz<boolean[]> {
        @Override
        public final boolean[] a(int n2) {
            return new boolean[n2];
        }
    }
}

