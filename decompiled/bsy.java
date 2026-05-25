/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class bsy {
    protected static final HashMap<String, bgb<?>> a = new HashMap();

    public static bgb<?> a(Class<?> clazz) {
        return a.get(clazz.getName());
    }

    static {
        a.put(boolean[].class.getName(), new a());
        a.put(byte[].class.getName(), new brw());
        a.put(char[].class.getName(), new b());
        a.put(short[].class.getName(), new g());
        a.put(int[].class.getName(), new e());
        a.put(long[].class.getName(), new f());
        a.put(float[].class.getName(), new d());
        a.put(double[].class.getName(), new c());
    }

    @bgp
    public static class c
    extends brq<double[]> {
        private static final bfw a = btz.btz_a().a(Double.TYPE);

        public c() {
            super(double[].class);
        }

        protected c(c c2, bfp bfp2, Boolean bl2) {
            super(c2, bfp2, bl2);
        }

        @Override
        public bgb<?> a(bfp bfp2, Boolean bl2) {
            return new c(this, bfp2, bl2);
        }

        @Override
        public bqg<?> b(bog bog2) {
            return this;
        }

        @Override
        public boolean a(bgo bgo2, double[] dArray) {
            return dArray.length == 0;
        }

        @Override
        public boolean a(double[] dArray) {
            return dArray.length == 1;
        }

        @Override
        public final void a(double[] dArray, bcy bcy2, bgo bgo2) {
            int n2 = dArray.length;
            if (n2 == 1 && this.a(bgo2)) {
                this.b(dArray, bcy2, bgo2);
                return;
            }
            bcy2.a(dArray, 0, dArray.length);
        }

        @Override
        public void b(double[] dArray, bcy bcy2, bgo bgo2) {
            int n2 = dArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                bcy2.a(dArray[i2]);
            }
        }
    }

    @bgp
    public static class d
    extends h<float[]> {
        private static final bfw a = btz.btz_a().a(Float.TYPE);

        public d() {
            super(float[].class);
        }

        public d(d d2, bfp bfp2, Boolean bl2) {
            super(d2, bfp2, bl2);
        }

        @Override
        public bgb<?> a(bfp bfp2, Boolean bl2) {
            return new d(this, bfp2, bl2);
        }

        @Override
        public boolean a(bgo bgo2, float[] fArray) {
            return fArray.length == 0;
        }

        @Override
        public boolean a(float[] fArray) {
            return fArray.length == 1;
        }

        @Override
        public final void a(float[] fArray, bcy bcy2, bgo bgo2) {
            int n2 = fArray.length;
            if (n2 == 1 && this.a(bgo2)) {
                this.b(fArray, bcy2, bgo2);
                return;
            }
            bcy2.a(fArray, n2);
            this.b(fArray, bcy2, bgo2);
            bcy2.void_b();
        }

        @Override
        public void b(float[] fArray, bcy bcy2, bgo bgo2) {
            int n2 = fArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                bcy2.a(fArray[i2]);
            }
        }
    }

    @bgp
    public static class f
    extends h<long[]> {
        private static final bfw a = btz.btz_a().a(Long.TYPE);

        public f() {
            super(long[].class);
        }

        public f(f f2, bfp bfp2, Boolean bl2) {
            super(f2, bfp2, bl2);
        }

        @Override
        public bgb<?> a(bfp bfp2, Boolean bl2) {
            return new f(this, bfp2, bl2);
        }

        @Override
        public boolean a(bgo bgo2, long[] lArray) {
            return lArray.length == 0;
        }

        @Override
        public boolean a(long[] lArray) {
            return lArray.length == 1;
        }

        @Override
        public final void a(long[] lArray, bcy bcy2, bgo bgo2) {
            int n2 = lArray.length;
            if (n2 == 1 && this.a(bgo2)) {
                this.b(lArray, bcy2, bgo2);
                return;
            }
            bcy2.a(lArray, 0, lArray.length);
        }

        @Override
        public void b(long[] lArray, bcy bcy2, bgo bgo2) {
            int n2 = lArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                bcy2.b(lArray[i2]);
            }
        }
    }

    @bgp
    public static class e
    extends brq<int[]> {
        private static final bfw a = btz.btz_a().a(Integer.TYPE);

        public e() {
            super(int[].class);
        }

        protected e(e e2, bfp bfp2, Boolean bl2) {
            super(e2, bfp2, bl2);
        }

        @Override
        public bgb<?> a(bfp bfp2, Boolean bl2) {
            return new e(this, bfp2, bl2);
        }

        @Override
        public bqg<?> b(bog bog2) {
            return this;
        }

        @Override
        public boolean a(bgo bgo2, int[] nArray) {
            return nArray.length == 0;
        }

        @Override
        public boolean a(int[] nArray) {
            return nArray.length == 1;
        }

        @Override
        public final void a(int[] nArray, bcy bcy2, bgo bgo2) {
            int n2 = nArray.length;
            if (n2 == 1 && this.a(bgo2)) {
                this.b(nArray, bcy2, bgo2);
                return;
            }
            bcy2.a(nArray, 0, nArray.length);
        }

        @Override
        public void b(int[] nArray, bcy bcy2, bgo bgo2) {
            int n2 = nArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                bcy2.void_b(nArray[i2]);
            }
        }
    }

    @bgp
    public static class b
    extends bte<char[]> {
        public b() {
            super(char[].class);
        }

        @Override
        public boolean a(bgo bgo2, char[] cArray) {
            return cArray.length == 0;
        }

        @Override
        public void a(char[] cArray, bcy bcy2, bgo bgo2) {
            if (bgo2.a(bgn.n)) {
                bcy2.a(cArray, cArray.length);
                this.a(bcy2, cArray);
                bcy2.void_b();
            } else {
                bcy2.a(cArray, 0, cArray.length);
            }
        }

        @Override
        public void a(char[] cArray, bcy bcy2, bgo bgo2, bog bog2) {
            beu beu2;
            boolean bl2 = bgo2.a(bgn.n);
            if (bl2) {
                beu2 = bog2.a(bcy2, bog2.a(cArray, bdf.var_bdf_d));
                this.a(bcy2, cArray);
            } else {
                beu2 = bog2.a(bcy2, bog2.a(cArray, bdf.h));
                bcy2.a(cArray, 0, cArray.length);
            }
            bog2.b(bcy2, beu2);
        }

        private final void a(bcy bcy2, char[] cArray) {
            int n2 = cArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                bcy2.a(cArray, i2, 1);
            }
        }
    }

    @bgp
    public static class g
    extends h<short[]> {
        private static final bfw a = btz.btz_a().a(Short.TYPE);

        public g() {
            super(short[].class);
        }

        public g(g g2, bfp bfp2, Boolean bl2) {
            super(g2, bfp2, bl2);
        }

        @Override
        public bgb<?> a(bfp bfp2, Boolean bl2) {
            return new g(this, bfp2, bl2);
        }

        @Override
        public boolean a(bgo bgo2, short[] sArray) {
            return sArray.length == 0;
        }

        @Override
        public boolean a(short[] sArray) {
            return sArray.length == 1;
        }

        @Override
        public final void a(short[] sArray, bcy bcy2, bgo bgo2) {
            int n2 = sArray.length;
            if (n2 == 1 && this.a(bgo2)) {
                this.b(sArray, bcy2, bgo2);
                return;
            }
            bcy2.a(sArray, n2);
            this.b(sArray, bcy2, bgo2);
            bcy2.void_b();
        }

        @Override
        public void b(short[] sArray, bcy bcy2, bgo bgo2) {
            int n2 = sArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                bcy2.void_b(sArray[i2]);
            }
        }
    }

    @bgp
    public static class a
    extends brq<boolean[]> {
        private static final bfw a = btz.btz_a().a(Boolean.class);

        public a() {
            super(boolean[].class);
        }

        protected a(a a2, bfp bfp2, Boolean bl2) {
            super(a2, bfp2, bl2);
        }

        @Override
        public bgb<?> a(bfp bfp2, Boolean bl2) {
            return new a(this, bfp2, bl2);
        }

        @Override
        public bqg<?> b(bog bog2) {
            return this;
        }

        @Override
        public boolean a(bgo bgo2, boolean[] blArray) {
            return blArray.length == 0;
        }

        @Override
        public boolean a(boolean[] blArray) {
            return blArray.length == 1;
        }

        @Override
        public final void a(boolean[] blArray, bcy bcy2, bgo bgo2) {
            int n2 = blArray.length;
            if (n2 == 1 && this.a(bgo2)) {
                this.b(blArray, bcy2, bgo2);
                return;
            }
            bcy2.a(blArray, n2);
            this.b(blArray, bcy2, bgo2);
            bcy2.void_b();
        }

        @Override
        public void b(boolean[] blArray, bcy bcy2, bgo bgo2) {
            int n2 = blArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                bcy2.a(blArray[i2]);
            }
        }
    }

    protected static abstract class h<T>
    extends brq<T> {
        protected h(Class<T> clazz) {
            super(clazz);
        }

        protected h(h<T> h2, bfp bfp2, Boolean bl2) {
            super(h2, bfp2, bl2);
        }

        @Override
        public final bqg<?> b(bog bog2) {
            return this;
        }
    }
}

