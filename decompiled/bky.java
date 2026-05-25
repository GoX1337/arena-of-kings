/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public abstract class bky<T>
extends blc<T>
implements bib {
    protected final Boolean var_java_lang_Boolean_a;
    private transient Object var_java_lang_Object_a;
    protected final bil var_bil_a;

    protected bky(Class<T> clazz) {
        super(clazz);
        this.var_java_lang_Boolean_a = null;
        this.var_bil_a = null;
    }

    protected bky(bky<?> bky2, bil bil2, Boolean bl2) {
        super(bky2.b);
        this.var_java_lang_Boolean_a = bl2;
        this.var_bil_a = bil2;
    }

    public static bfx<?> a(Class<?> clazz) {
        if (clazz == Integer.TYPE) {
            return f.a;
        }
        if (clazz == Long.TYPE) {
            return g.a;
        }
        if (clazz == Byte.TYPE) {
            return new b();
        }
        if (clazz == Short.TYPE) {
            return new h();
        }
        if (clazz == Float.TYPE) {
            return new e();
        }
        if (clazz == Double.TYPE) {
            return new d();
        }
        if (clazz == Boolean.TYPE) {
            return new a();
        }
        if (clazz == Character.TYPE) {
            return new c();
        }
        throw new IllegalStateException();
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        Boolean bl2 = this.a(bfs2, bfp2, this.b, bbk.a.var_bbk$a_a);
        bil bil2 = null;
        bfp bfp3 = this.a((T)bfs2, (T)bfp2);
        if (bfp3 == bcj.b) {
            bil2 = bjj.a();
        } else if (bfp3 == bcj.c) {
            bil2 = bfp2 == null ? bjk.a(bfs2.bfw_a(this.b.getComponentType())) : bjk.a(bfp2, bfp2.bfw_a().bfw_c());
        }
        if (Objects.equals(bl2, this.var_java_lang_Boolean_a) && bil2 == this.var_bil_a) {
            return this;
        }
        return this.a(bil2, bl2);
    }

    protected abstract T a(T var1, T var2);

    protected abstract T b(bdc var1, bfs var2);

    protected abstract bky<?> a(bil var1, Boolean var2);

    protected abstract T b();

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
        Object object = this.var_java_lang_Object_a;
        if (object == null) {
            this.var_java_lang_Object_a = object = this.b();
        }
        return object;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.b(bdc2, bfs2);
    }

    @Override
    public T a(bdc bdc2, bfs bfs2, T t2) {
        bfs bfs3 = this.a((T)bdc2, (T)bfs2);
        if (t2 == null) {
            return (T)bfs3;
        }
        int n2 = Array.getLength(t2);
        if (n2 == 0) {
            return (T)bfs3;
        }
        return (T)this.a(t2, bfs3);
    }

    protected T c(bdc bdc2, bfs bfs2) {
        boolean bl2;
        if (bdc2.boolean_a(bdf.h)) {
            return this.r(bdc2, bfs2);
        }
        boolean bl3 = bl2 = this.var_java_lang_Boolean_a == Boolean.TRUE || this.var_java_lang_Boolean_a == null && bfs2.a(bfu.q);
        if (bl2) {
            return this.b(bdc2, bfs2);
        }
        return (T)bfs2.a(this.b, bdc2);
    }

    @bgp
    static final class d
    extends bky<double[]> {
        public d() {
            super(double[].class);
        }

        protected d(d d2, bil bil2, Boolean bl2) {
            super(d2, bil2, bl2);
        }

        @Override
        protected bky<?> a(bil bil2, Boolean bl2) {
            return new d(this, bil2, bl2);
        }

        @Override
        protected double[] a() {
            return new double[0];
        }

        @Override
        public double[] a(bdc bdc2, bfs bfs2) {
            if (!bdc2.boolean_c()) {
                return (double[])this.c(bdc2, bfs2);
            }
            bue.c c2 = bfs2.bue_a().bue$c_a();
            double[] dArray = (double[])c2.a();
            int n2 = 0;
            try {
                bdf bdf2;
                while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                    if (bdf2 == bdf.m && this.a != null) {
                        this.a.a(bfs2);
                        continue;
                    }
                    bfs bfs3 = ((bky)this).a(bdc2, bfs2);
                    if (n2 >= dArray.length) {
                        dArray = c2.a(dArray, n2);
                        n2 = 0;
                    }
                    dArray[n2++] = (double)bfs3;
                }
            }
            catch (Exception exception) {
                throw bfy.a((Throwable)exception, (Object)dArray, c2.int_a() + n2);
            }
            return c2.b(dArray, n2);
        }

        @Override
        protected double[] b(bdc bdc2, bfs bfs2) {
            return new double[]{(double)((bky)this).a(bdc2, bfs2)};
        }

        @Override
        protected double[] a(double[] dArray, double[] dArray2) {
            int n2 = dArray.length;
            int n3 = dArray2.length;
            double[] dArray3 = Arrays.copyOf(dArray, n2 + n3);
            System.arraycopy(dArray2, 0, dArray3, n2, n3);
            return dArray3;
        }

        @Override
        protected /* synthetic */ Object b() {
            return this.a();
        }
    }

    @bgp
    static final class e
    extends bky<float[]> {
        public e() {
            super(float[].class);
        }

        protected e(e e2, bil bil2, Boolean bl2) {
            super(e2, bil2, bl2);
        }

        @Override
        protected bky<?> a(bil bil2, Boolean bl2) {
            return new e(this, bil2, bl2);
        }

        @Override
        protected float[] a() {
            return new float[0];
        }

        @Override
        public float[] a(bdc bdc2, bfs bfs2) {
            if (!bdc2.boolean_c()) {
                return (float[])this.c(bdc2, bfs2);
            }
            bue.d d2 = bfs2.bue_a().bue$d_a();
            float[] fArray = (float[])d2.a();
            int n2 = 0;
            try {
                bdf bdf2;
                while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                    if (bdf2 == bdf.m && this.a != null) {
                        this.a.a(bfs2);
                        continue;
                    }
                    bfs bfs3 = ((bky)this).a(bdc2, bfs2);
                    if (n2 >= fArray.length) {
                        fArray = d2.a(fArray, n2);
                        n2 = 0;
                    }
                    fArray[n2++] = (float)bfs3;
                }
            }
            catch (Exception exception) {
                throw bfy.a((Throwable)exception, (Object)fArray, d2.int_a() + n2);
            }
            return d2.b(fArray, n2);
        }

        @Override
        protected float[] b(bdc bdc2, bfs bfs2) {
            return new float[]{(float)((bky)this).a(bdc2, bfs2)};
        }

        @Override
        protected float[] a(float[] fArray, float[] fArray2) {
            int n2 = fArray.length;
            int n3 = fArray2.length;
            float[] fArray3 = Arrays.copyOf(fArray, n2 + n3);
            System.arraycopy(fArray2, 0, fArray3, n2, n3);
            return fArray3;
        }

        @Override
        protected /* synthetic */ Object b() {
            return this.a();
        }
    }

    @bgp
    static final class g
    extends bky<long[]> {
        public static final g a = new g();

        public g() {
            super(long[].class);
        }

        protected g(g g2, bil bil2, Boolean bl2) {
            super(g2, bil2, bl2);
        }

        @Override
        protected bky<?> a(bil bil2, Boolean bl2) {
            return new g(this, bil2, bl2);
        }

        @Override
        protected long[] a() {
            return new long[0];
        }

        @Override
        public long[] a(bdc bdc2, bfs bfs2) {
            if (!bdc2.boolean_c()) {
                return (long[])this.c(bdc2, bfs2);
            }
            bue.f f2 = bfs2.bue_a().bue$f_a();
            long[] lArray = (long[])f2.a();
            int n2 = 0;
            try {
                bdf bdf2;
                while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                    long l2;
                    if (bdf2 == bdf.i) {
                        l2 = bdc2.long_a();
                    } else if (bdf2 == bdf.m) {
                        if (this.a != null) {
                            this.a.a(bfs2);
                            continue;
                        }
                        this.void_b(bfs2);
                        l2 = 0L;
                    } else {
                        l2 = (long)((bky)this).a(bdc2, bfs2);
                    }
                    if (n2 >= lArray.length) {
                        lArray = f2.a(lArray, n2);
                        n2 = 0;
                    }
                    lArray[n2++] = l2;
                }
            }
            catch (Exception exception) {
                throw bfy.a((Throwable)exception, (Object)lArray, f2.int_a() + n2);
            }
            return f2.b(lArray, n2);
        }

        @Override
        protected long[] b(bdc bdc2, bfs bfs2) {
            return new long[]{(long)((bky)this).a(bdc2, bfs2)};
        }

        @Override
        protected long[] a(long[] lArray, long[] lArray2) {
            int n2 = lArray.length;
            int n3 = lArray2.length;
            long[] lArray3 = Arrays.copyOf(lArray, n2 + n3);
            System.arraycopy(lArray2, 0, lArray3, n2, n3);
            return lArray3;
        }

        @Override
        protected /* synthetic */ Object b() {
            return this.a();
        }
    }

    @bgp
    static final class f
    extends bky<int[]> {
        public static final f a = new f();

        public f() {
            super(int[].class);
        }

        protected f(f f2, bil bil2, Boolean bl2) {
            super(f2, bil2, bl2);
        }

        @Override
        protected bky<?> a(bil bil2, Boolean bl2) {
            return new f(this, bil2, bl2);
        }

        @Override
        protected int[] a() {
            return new int[0];
        }

        @Override
        public int[] a(bdc bdc2, bfs bfs2) {
            if (!bdc2.boolean_c()) {
                return (int[])this.c(bdc2, bfs2);
            }
            bue.e e2 = bfs2.bue_a().bue$e_a();
            int[] nArray = (int[])e2.a();
            int n2 = 0;
            try {
                bdf bdf2;
                while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                    Object object;
                    if (bdf2 == bdf.i) {
                        object = bdc2.int_e();
                    } else if (bdf2 == bdf.m) {
                        if (this.a != null) {
                            this.a.a(bfs2);
                            continue;
                        }
                        this.void_b(bfs2);
                        object = 0;
                    } else {
                        object = ((bky)this).a(bdc2, bfs2);
                    }
                    if (n2 >= nArray.length) {
                        nArray = e2.a(nArray, n2);
                        n2 = 0;
                    }
                    nArray[n2++] = object;
                }
            }
            catch (Exception exception) {
                throw bfy.a((Throwable)exception, (Object)nArray, e2.int_a() + n2);
            }
            return e2.b(nArray, n2);
        }

        @Override
        protected int[] b(bdc bdc2, bfs bfs2) {
            return new int[]{(int)((bky)this).a(bdc2, bfs2)};
        }

        @Override
        protected int[] a(int[] nArray, int[] nArray2) {
            int n2 = nArray.length;
            int n3 = nArray2.length;
            int[] nArray3 = Arrays.copyOf(nArray, n2 + n3);
            System.arraycopy(nArray2, 0, nArray3, n2, n3);
            return nArray3;
        }

        @Override
        protected /* synthetic */ Object b() {
            return this.a();
        }
    }

    @bgp
    static final class h
    extends bky<short[]> {
        public h() {
            super(short[].class);
        }

        protected h(h h2, bil bil2, Boolean bl2) {
            super(h2, bil2, bl2);
        }

        @Override
        protected bky<?> a(bil bil2, Boolean bl2) {
            return new h(this, bil2, bl2);
        }

        @Override
        protected short[] a() {
            return new short[0];
        }

        @Override
        public short[] a(bdc bdc2, bfs bfs2) {
            if (!bdc2.boolean_c()) {
                return (short[])this.c(bdc2, bfs2);
            }
            bue.g g2 = bfs2.bue_a().bue$g_a();
            short[] sArray = (short[])g2.a();
            int n2 = 0;
            try {
                bdf bdf2;
                while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                    Object object;
                    if (bdf2 == bdf.m) {
                        if (this.a != null) {
                            this.a.a(bfs2);
                            continue;
                        }
                        this.void_b(bfs2);
                        object = false;
                    } else {
                        object = ((bky)this).a(bdc2, bfs2);
                    }
                    if (n2 >= sArray.length) {
                        sArray = g2.a(sArray, n2);
                        n2 = 0;
                    }
                    sArray[n2++] = (short)object;
                }
            }
            catch (Exception exception) {
                throw bfy.a((Throwable)exception, (Object)sArray, g2.int_a() + n2);
            }
            return g2.b(sArray, n2);
        }

        @Override
        protected short[] b(bdc bdc2, bfs bfs2) {
            return new short[]{(short)((bky)this).a(bdc2, bfs2)};
        }

        @Override
        protected short[] a(short[] sArray, short[] sArray2) {
            int n2 = sArray.length;
            int n3 = sArray2.length;
            short[] sArray3 = Arrays.copyOf(sArray, n2 + n3);
            System.arraycopy(sArray2, 0, sArray3, n2, n3);
            return sArray3;
        }

        @Override
        protected /* synthetic */ Object b() {
            return this.a();
        }
    }

    @bgp
    static final class b
    extends bky<byte[]> {
        public b() {
            super(byte[].class);
        }

        protected b(b b2, bil bil2, Boolean bl2) {
            super(b2, bil2, bl2);
        }

        @Override
        protected bky<?> a(bil bil2, Boolean bl2) {
            return new b(this, bil2, bl2);
        }

        @Override
        protected byte[] byte_arr_a() {
            return new byte[0];
        }

        @Override
        public btq btq_a() {
            return btq.k;
        }

        @Override
        public byte[] a(bdc bdc2, bfs bfs2) {
            Object object;
            Object object2;
            bdf bdf2;
            block16: {
                bdf2 = bdc2.bdf_c();
                if (bdf2 == bdf.h) {
                    try {
                        return bdc2.byte_arr_a(bfs2.bcq_a());
                    }
                    catch (bdb bdb2) {
                        object2 = bdb2.a();
                        if (!((String)object2).contains("base64")) break block16;
                        return (byte[])bfs2.b(byte[].class, bdc2.java_lang_String_e(), (String)object2, new Object[0]);
                    }
                }
            }
            if (bdf2 == bdf.g) {
                object = bdc2.java_lang_Object_a();
                if (object == null) {
                    return null;
                }
                if (object instanceof byte[]) {
                    return (byte[])object;
                }
            }
            if (!bdc2.boolean_c()) {
                return (byte[])this.c(bdc2, bfs2);
            }
            object = bfs2.bue_a().bue$b_a();
            object2 = (byte[])((buz)object).a();
            int n2 = 0;
            try {
                while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                    Object object3;
                    if (bdf2 == bdf.i) {
                        object3 = bdc2.byte_a();
                    } else if (bdf2 == bdf.m) {
                        if (this.a != null) {
                            this.a.a(bfs2);
                            continue;
                        }
                        this.void_b(bfs2);
                        object3 = 0;
                    } else {
                        object3 = ((bky)this).a(bdc2, bfs2);
                    }
                    if (n2 >= ((Object)object2).length) {
                        object2 = (byte[])((buz)object).a(object2, n2);
                        n2 = 0;
                    }
                    object2[n2++] = object3;
                }
            }
            catch (Exception exception) {
                throw bfy.a((Throwable)exception, object2, ((buz)object).int_a() + n2);
            }
            return (byte[])((buz)object).b(object2, n2);
        }

        @Override
        protected byte[] b(bdc bdc2, bfs bfs2) {
            byte by2;
            bdf bdf2 = bdc2.bdf_c();
            if (bdf2 == bdf.i) {
                by2 = bdc2.byte_a();
            } else {
                if (bdf2 == bdf.m) {
                    if (this.a != null) {
                        this.a.a(bfs2);
                        return (byte[])this.b(bfs2);
                    }
                    this.void_b(bfs2);
                    return null;
                }
                Number number = (Number)bfs2.a(this.b.getComponentType(), bdc2);
                by2 = number.byteValue();
            }
            return new byte[]{by2};
        }

        @Override
        protected byte[] a(byte[] byArray, byte[] byArray2) {
            int n2 = byArray.length;
            int n3 = byArray2.length;
            byte[] byArray3 = Arrays.copyOf(byArray, n2 + n3);
            System.arraycopy(byArray2, 0, byArray3, n2, n3);
            return byArray3;
        }

        @Override
        protected /* synthetic */ Object b() {
            return this.byte_arr_a();
        }
    }

    @bgp
    static final class a
    extends bky<boolean[]> {
        public a() {
            super(boolean[].class);
        }

        protected a(a a2, bil bil2, Boolean bl2) {
            super(a2, bil2, bl2);
        }

        @Override
        protected bky<?> a(bil bil2, Boolean bl2) {
            return new a(this, bil2, bl2);
        }

        @Override
        protected boolean[] a() {
            return new boolean[0];
        }

        @Override
        public boolean[] a(bdc bdc2, bfs bfs2) {
            if (!bdc2.boolean_c()) {
                return (boolean[])this.c(bdc2, bfs2);
            }
            bue.a a2 = bfs2.bue_a().bue$a_a();
            boolean[] blArray = (boolean[])a2.a();
            int n2 = 0;
            try {
                bdf bdf2;
                while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                    Object object;
                    if (bdf2 == bdf.k) {
                        object = true;
                    } else if (bdf2 == bdf.l) {
                        object = false;
                    } else if (bdf2 == bdf.m) {
                        if (this.a != null) {
                            this.a.a(bfs2);
                            continue;
                        }
                        this.void_b(bfs2);
                        object = 0;
                    } else {
                        object = ((bky)this).a(bdc2, bfs2);
                    }
                    if (n2 >= blArray.length) {
                        blArray = a2.a(blArray, n2);
                        n2 = 0;
                    }
                    blArray[n2++] = object;
                }
            }
            catch (Exception exception) {
                throw bfy.a((Throwable)exception, (Object)blArray, a2.int_a() + n2);
            }
            return a2.b(blArray, n2);
        }

        @Override
        protected boolean[] b(bdc bdc2, bfs bfs2) {
            return new boolean[]{((bky)this).a(bdc2, bfs2)};
        }

        @Override
        protected boolean[] a(boolean[] blArray, boolean[] blArray2) {
            int n2 = blArray.length;
            int n3 = blArray2.length;
            boolean[] blArray3 = Arrays.copyOf(blArray, n2 + n3);
            System.arraycopy(blArray2, 0, blArray3, n2, n3);
            return blArray3;
        }

        @Override
        protected /* synthetic */ Object b() {
            return this.a();
        }
    }

    @bgp
    static final class c
    extends bky<char[]> {
        public c() {
            super(char[].class);
        }

        @Override
        protected bky<?> a(bil bil2, Boolean bl2) {
            return this;
        }

        @Override
        protected char[] a() {
            return new char[0];
        }

        @Override
        public char[] a(bdc bdc2, bfs bfs2) {
            if (bdc2.boolean_a(bdf.h)) {
                char[] cArray = bdc2.char_arr_a();
                int n2 = bdc2.int_d();
                int n3 = bdc2.int_c();
                char[] cArray2 = new char[n3];
                System.arraycopy(cArray, n2, cArray2, 0, n3);
                return cArray2;
            }
            if (bdc2.boolean_c()) {
                bdf bdf2;
                StringBuilder stringBuilder = new StringBuilder(64);
                while ((bdf2 = bdc2.bdf_a()) != bdf.var_bdf_e) {
                    String string;
                    if (bdf2 == bdf.h) {
                        string = bdc2.java_lang_String_e();
                    } else if (bdf2 == bdf.m) {
                        if (this.a != null) {
                            this.a.a(bfs2);
                            continue;
                        }
                        this.void_b(bfs2);
                        string = "\u0000";
                    } else {
                        CharSequence charSequence = (CharSequence)bfs2.a(Character.TYPE, bdc2);
                        string = charSequence.toString();
                    }
                    if (string.length() != 1) {
                        bfs2.a(this, "Cannot convert a JSON String of length %d into a char element of char array", string.length());
                    }
                    stringBuilder.append(string.charAt(0));
                }
                return stringBuilder.toString().toCharArray();
            }
            if (bdc2.boolean_a(bdf.g)) {
                Object object = bdc2.java_lang_Object_a();
                if (object == null) {
                    return null;
                }
                if (object instanceof char[]) {
                    return (char[])object;
                }
                if (object instanceof String) {
                    return ((String)object).toCharArray();
                }
                if (object instanceof byte[]) {
                    return bcr.a().a((byte[])object, false).toCharArray();
                }
            }
            return (char[])bfs2.a(this.b, bdc2);
        }

        @Override
        protected char[] b(bdc bdc2, bfs bfs2) {
            return (char[])bfs2.a(this.b, bdc2);
        }

        @Override
        protected char[] a(char[] cArray, char[] cArray2) {
            int n2 = cArray.length;
            int n3 = cArray2.length;
            char[] cArray3 = Arrays.copyOf(cArray, n2 + n3);
            System.arraycopy(cArray2, 0, cArray3, n2, n3);
            return cArray3;
        }

        @Override
        protected /* synthetic */ Object b() {
            return this.a();
        }
    }
}

