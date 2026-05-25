/*
 * Decompiled with CFR 0.152.
 */
class bwe
extends bvw {
    static int var_int_a;
    float[][] var_float_arr_arr_a = null;
    int[] var_int_arr_a = null;
    int[] b = null;
    Object[] var_java_lang_Object_arr_a = null;

    bwe() {
    }

    @Override
    void a(Object object) {
    }

    @Override
    Object a(bvs bvs2, bwa bwa2, Object object) {
        bvz bvz2 = bvs2.var_bvz_a;
        b b2 = new b(this);
        a a2 = b2.var_bwe$a_a = (a)object;
        b2.var_bwa_a = bwa2;
        b2.var_java_lang_Object_arr_a = new Object[a2.var_int_a];
        b2.b = new Object[a2.var_int_a];
        b2.c = new Object[a2.var_int_a];
        b2.var_bvy_arr_a = new bvy[a2.var_int_a];
        b2.var_bvv_arr_a = new bvv[a2.var_int_a];
        b2.var_bvx_arr_a = new bvx[a2.var_int_a];
        for (int i2 = 0; i2 < a2.var_int_a; ++i2) {
            int n2 = a2.var_int_arr_b[i2];
            int n3 = a2.c[i2];
            int n4 = a2.d[i2];
            b2.var_bvy_arr_a[i2] = bvy.a[bvz2.var_int_arr_c[n2]];
            b2.var_java_lang_Object_arr_a[i2] = b2.var_bvy_arr_a[i2].a(bvs2, bwa2, bvz2.var_java_lang_Object_arr_b[n2]);
            b2.var_bvv_arr_a[i2] = bvv.a[bvz2.var_int_arr_d[n3]];
            b2.b[i2] = b2.var_bvv_arr_a[i2].a(bvs2, bwa2, bvz2.var_java_lang_Object_arr_c[n3]);
            b2.var_bvx_arr_a[i2] = bvx.a[bvz2.var_int_arr_e[n4]];
            b2.c[i2] = b2.var_bvx_arr_a[i2].a(bvs2, bwa2, bvz2.var_java_lang_Object_arr_d[n4]);
        }
        if (bvz2.m == 0 || bvs2.var_int_a != 0) {
            // empty if block
        }
        b2.var_int_a = bvz2.var_int_b;
        return b2;
    }

    @Override
    Object a(bvz bvz2, bvj bvj2) {
        int n2;
        a a2 = new a(this);
        a2.var_int_a = bvj2.b(1) != 0 ? bvj2.b(4) + 1 : 1;
        if (bvj2.b(1) != 0) {
            a2.var_int_b = bvj2.b(8) + 1;
            for (n2 = 0; n2 < a2.var_int_b; ++n2) {
                int n3 = a2.f[n2] = bvj2.b(bwm.b(bvz2.var_int_b));
                int n4 = a2.g[n2] = bvj2.b(bwm.b(bvz2.var_int_b));
                if (n3 >= 0 && n4 >= 0 && n3 != n4 && n3 < bvz2.var_int_b && n4 < bvz2.var_int_b) continue;
                a2.a();
                return null;
            }
        }
        if (bvj2.b(2) > 0) {
            a2.a();
            return null;
        }
        if (a2.var_int_a > 1) {
            for (n2 = 0; n2 < bvz2.var_int_b; ++n2) {
                a2.var_int_arr_a[n2] = bvj2.b(4);
                if (a2.var_int_arr_a[n2] < a2.var_int_a) continue;
                a2.a();
                return null;
            }
        }
        for (n2 = 0; n2 < a2.var_int_a; ++n2) {
            a2.var_int_arr_b[n2] = bvj2.b(8);
            if (a2.var_int_arr_b[n2] >= bvz2.i) {
                a2.a();
                return null;
            }
            a2.c[n2] = bvj2.b(8);
            if (a2.c[n2] >= bvz2.j) {
                a2.a();
                return null;
            }
            a2.d[n2] = bvj2.b(8);
            if (a2.d[n2] < bvz2.k) continue;
            a2.a();
            return null;
        }
        return a2;
    }

    @Override
    synchronized int a(bvo bvo2, Object object) {
        int n2;
        int n3;
        int n4;
        bvs bvs2 = bvo2.var_bvs_a;
        bvz bvz2 = bvs2.var_bvz_a;
        b b2 = (b)object;
        a a2 = b2.var_bwe$a_a;
        bwa bwa2 = b2.var_bwa_a;
        int n5 = bvo2.d = bvz2.var_int_arr_a[bvo2.var_int_b];
        float[] fArray = bvs2.var_float_arr_arr_arr_arr_arr_a[bvo2.var_int_b][bvo2.var_int_a][bvo2.c][bwa2.b];
        if (this.var_float_arr_arr_a == null || this.var_float_arr_arr_a.length < bvz2.var_int_b) {
            this.var_float_arr_arr_a = new float[bvz2.var_int_b][];
            this.b = new int[bvz2.var_int_b];
            this.var_int_arr_a = new int[bvz2.var_int_b];
            this.var_java_lang_Object_arr_a = new Object[bvz2.var_int_b];
        }
        for (n4 = 0; n4 < bvz2.var_int_b; ++n4) {
            float[] fArray2 = bvo2.var_float_arr_arr_a[n4];
            n3 = a2.var_int_arr_a[n4];
            this.var_java_lang_Object_arr_a[n4] = b2.var_bvv_arr_a[n3].a(bvo2, b2.b[n3], this.var_java_lang_Object_arr_a[n4]);
            this.b[n4] = this.var_java_lang_Object_arr_a[n4] != null ? 1 : 0;
            for (n2 = 0; n2 < n5 / 2; ++n2) {
                fArray2[n2] = 0.0f;
            }
        }
        for (n4 = 0; n4 < a2.var_int_b; ++n4) {
            if (this.b[a2.f[n4]] == 0 && this.b[a2.g[n4]] == 0) continue;
            this.b[a2.f[n4]] = 1;
            this.b[a2.g[n4]] = 1;
        }
        for (n4 = 0; n4 < a2.var_int_a; ++n4) {
            int n6 = 0;
            for (n3 = 0; n3 < bvz2.var_int_b; ++n3) {
                if (a2.var_int_arr_a[n3] != n4) continue;
                this.var_int_arr_a[n6] = this.b[n3] != 0 ? 1 : 0;
                this.var_float_arr_arr_a[n6++] = bvo2.var_float_arr_arr_a[n3];
            }
            b2.var_bvx_arr_a[n4].a(bvo2, b2.c[n4], this.var_float_arr_arr_a, this.var_int_arr_a, n6);
        }
        for (n4 = a2.var_int_b - 1; n4 >= 0; --n4) {
            float[] fArray3 = bvo2.var_float_arr_arr_a[a2.f[n4]];
            float[] fArray4 = bvo2.var_float_arr_arr_a[a2.g[n4]];
            for (n2 = 0; n2 < n5 / 2; ++n2) {
                float f2 = fArray3[n2];
                float f3 = fArray4[n2];
                if (f2 > 0.0f) {
                    if (f3 > 0.0f) {
                        fArray3[n2] = f2;
                        fArray4[n2] = f2 - f3;
                        continue;
                    }
                    fArray4[n2] = f2;
                    fArray3[n2] = f2 + f3;
                    continue;
                }
                if (f3 > 0.0f) {
                    fArray3[n2] = f2;
                    fArray4[n2] = f2 + f3;
                    continue;
                }
                fArray4[n2] = f2;
                fArray3[n2] = f2 - f3;
            }
        }
        for (n4 = 0; n4 < bvz2.var_int_b; ++n4) {
            float[] fArray5 = bvo2.var_float_arr_arr_a[n4];
            int n7 = a2.var_int_arr_a[n4];
            b2.var_bvv_arr_a[n7].a(bvo2, b2.b[n7], this.var_java_lang_Object_arr_a[n4], fArray5);
        }
        for (n4 = 0; n4 < bvz2.var_int_b; ++n4) {
            float[] fArray6 = bvo2.var_float_arr_arr_a[n4];
            ((bwf)bvs2.var_java_lang_Object_arr_arr_a[bvo2.var_int_b][0]).a(fArray6, fArray6);
        }
        for (n4 = 0; n4 < bvz2.var_int_b; ++n4) {
            int n8;
            float[] fArray7 = bvo2.var_float_arr_arr_a[n4];
            if (this.b[n4] != 0) {
                for (n8 = 0; n8 < n5; ++n8) {
                    int n9 = n8;
                    fArray7[n9] = fArray7[n9] * fArray[n8];
                }
                continue;
            }
            for (n8 = 0; n8 < n5; ++n8) {
                fArray7[n8] = 0.0f;
            }
        }
        return 0;
    }

    static {
        var_int_a = 0;
    }

    class b {
        bwa var_bwa_a;
        a var_bwe$a_a;
        Object[] var_java_lang_Object_arr_a;
        Object[] b;
        Object[] c;
        bvy[] var_bvy_arr_a;
        bvv[] var_bvv_arr_a;
        bvx[] var_bvx_arr_a;
        int var_int_a;
        final /* synthetic */ bwe var_bwe_a;

        b(bwe bwe2) {
            this.var_bwe_a = bwe2;
        }
    }

    class a {
        int var_int_a;
        int[] var_int_arr_a = new int[256];
        int[] var_int_arr_b = new int[16];
        int[] c = new int[16];
        int[] d = new int[16];
        int[] e = new int[16];
        int var_int_b;
        int[] f = new int[256];
        int[] g = new int[256];
        final /* synthetic */ bwe var_bwe_a;

        a(bwe bwe2) {
            this.var_bwe_a = bwe2;
        }

        void a() {
            this.var_int_arr_a = null;
            this.var_int_arr_b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
        }
    }
}

