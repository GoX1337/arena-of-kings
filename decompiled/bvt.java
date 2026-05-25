/*
 * Decompiled with CFR 0.152.
 */
class bvt
extends bvv {
    float[] a = null;

    bvt() {
    }

    @Override
    Object a(bvz bvz2, bvj bvj2) {
        a a2 = new a(this);
        a2.var_int_a = bvj2.b(8);
        a2.b = bvj2.b(16);
        a2.c = bvj2.b(16);
        a2.d = bvj2.b(6);
        a2.e = bvj2.b(8);
        a2.f = bvj2.b(4) + 1;
        if (a2.var_int_a < 1 || a2.b < 1 || a2.c < 1 || a2.f < 1) {
            return null;
        }
        for (int i2 = 0; i2 < a2.f; ++i2) {
            a2.var_int_arr_a[i2] = bvj2.b(8);
            if (a2.var_int_arr_a[i2] >= 0 && a2.var_int_arr_a[i2] < bvz2.l) continue;
            return null;
        }
        return a2;
    }

    @Override
    Object a(bvs bvs2, bwa bwa2, Object object) {
        bvz bvz2 = bvs2.var_bvz_a;
        a a2 = (a)object;
        b b2 = new b(this);
        b2.c = a2.var_int_a;
        b2.var_int_a = bvz2.var_int_arr_a[bwa2.a] / 2;
        b2.b = a2.c;
        b2.var_bvt$a_a = a2;
        b2.var_bwc_a.a(b2.b, b2.c);
        float f2 = (float)b2.b / bvt.a((float)((double)a2.b / 2.0));
        b2.var_int_arr_a = new int[b2.var_int_a];
        for (int i2 = 0; i2 < b2.var_int_a; ++i2) {
            int n2 = (int)Math.floor(bvt.a((float)((double)a2.b / 2.0 / (double)b2.var_int_a * (double)i2)) * f2);
            if (n2 >= b2.b) {
                n2 = b2.b;
            }
            b2.var_int_arr_a[i2] = n2;
        }
        return b2;
    }

    static float a(float f2) {
        return (float)(13.1 * Math.atan(7.4E-4 * (double)f2) + 2.24 * Math.atan((double)(f2 * f2) * 1.85E-8) + 1.0E-4 * (double)f2);
    }

    @Override
    void a(Object object) {
    }

    @Override
    Object a(bvo bvo2, Object object, Object object2) {
        int n2;
        b b2 = (b)object;
        a a2 = b2.var_bvt$a_a;
        float[] fArray = null;
        if (object2 instanceof float[]) {
            fArray = (float[])object2;
        }
        if ((n2 = bvo2.var_bvj_a.b(a2.d)) > 0) {
            int n3 = (1 << a2.d) - 1;
            float f2 = (float)n2 / (float)n3 * (float)a2.e;
            int n4 = bvo2.var_bvj_a.b(bwm.a(a2.f));
            if (n4 != -1 && n4 < a2.f) {
                int n5;
                bvp bvp2 = bvo2.var_bvs_a.var_bvp_arr_a[a2.var_int_arr_a[n4]];
                float f3 = 0.0f;
                if (fArray == null || fArray.length < b2.c + 1) {
                    fArray = new float[b2.c + 1];
                } else {
                    for (n5 = 0; n5 < fArray.length; ++n5) {
                        fArray[n5] = 0.0f;
                    }
                }
                for (n5 = 0; n5 < b2.c; n5 += bvp2.var_int_a) {
                    if (bvp2.c(fArray, n5, bvo2.var_bvj_a, bvp2.var_int_a) != -1) continue;
                    return null;
                }
                n5 = 0;
                while (n5 < b2.c) {
                    for (int i2 = 0; i2 < bvp2.var_int_a; ++i2) {
                        int n6 = n5++;
                        fArray[n6] = fArray[n6] + f3;
                    }
                    f3 = fArray[n5 - 1];
                }
                fArray[b2.c] = f2;
                return fArray;
            }
        }
        return null;
    }

    @Override
    int a(bvo bvo2, Object object, Object object2, float[] fArray) {
        b b2 = (b)object;
        a a2 = b2.var_bvt$a_a;
        if (object2 != null) {
            float[] fArray2 = (float[])object2;
            float f2 = fArray2[b2.c];
            bwd.a(fArray, b2.var_int_arr_a, b2.var_int_a, b2.b, fArray2, b2.c, f2, a2.e);
            return 1;
        }
        for (int i2 = 0; i2 < b2.var_int_a; ++i2) {
            fArray[i2] = 0.0f;
        }
        return 0;
    }

    class b {
        int var_int_a;
        int b;
        int c;
        int[] var_int_arr_a;
        a var_bvt$a_a;
        bwc var_bwc_a = new bwc();
        final /* synthetic */ bvt var_bvt_a;

        b(bvt bvt2) {
            this.var_bvt_a = bvt2;
        }
    }

    class a {
        int var_int_a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int[] var_int_arr_a = new int[16];
        final /* synthetic */ bvt var_bvt_a;

        a(bvt bvt2) {
            this.var_bvt_a = bvt2;
        }
    }
}

