/*
 * Decompiled with CFR 0.152.
 */
class bwh
extends bvx {
    private static int[][][] var_int_arr_arr_arr_a;
    static int[][] var_int_arr_arr_a;

    bwh() {
    }

    @Override
    Object a(bvz bvz2, bvj bvj2) {
        int n2;
        int n3 = 0;
        a a2 = new a(this);
        a2.var_int_a = bvj2.b(24);
        a2.var_int_b = bvj2.b(24);
        a2.var_int_c = bvj2.b(24) + 1;
        a2.var_int_d = bvj2.b(6) + 1;
        a2.e = bvj2.b(8);
        for (n2 = 0; n2 < a2.var_int_d; ++n2) {
            int n4 = bvj2.b(3);
            if (bvj2.b(1) != 0) {
                n4 |= bvj2.b(5) << 3;
            }
            a2.var_int_arr_a[n2] = n4;
            n3 += bwm.c(n4);
        }
        for (n2 = 0; n2 < n3; ++n2) {
            a2.var_int_arr_b[n2] = bvj2.b(8);
        }
        if (a2.e >= bvz2.l) {
            this.a(a2);
            return null;
        }
        for (n2 = 0; n2 < n3; ++n2) {
            if (a2.var_int_arr_b[n2] < bvz2.l) continue;
            this.a(a2);
            return null;
        }
        return a2;
    }

    @Override
    Object a(bvs bvs2, bwa bwa2, Object object) {
        int n2;
        int n3;
        int n4;
        int n5;
        a a2 = (a)object;
        b b2 = new b(this);
        int n6 = 0;
        int n7 = 0;
        b2.var_bwh$a_a = a2;
        b2.var_int_a = bwa2.d;
        b2.var_int_b = a2.var_int_d;
        b2.var_bvp_arr_a = bvs2.var_bvp_arr_a;
        b2.var_bvp_a = bvs2.var_bvp_arr_a[a2.e];
        int n8 = b2.var_bvp_a.var_int_a;
        b2.var_int_arr_arr_a = new int[b2.var_int_b][];
        for (n5 = 0; n5 < b2.var_int_b; ++n5) {
            n4 = a2.var_int_arr_a[n5];
            n3 = bwm.a(n4);
            if (n3 == 0) continue;
            if (n3 > n7) {
                n7 = n3;
            }
            b2.var_int_arr_arr_a[n5] = new int[n3];
            for (n2 = 0; n2 < n3; ++n2) {
                if ((n4 & 1 << n2) == 0) continue;
                b2.var_int_arr_arr_a[n5][n2] = a2.var_int_arr_b[n6++];
            }
        }
        b2.d = (int)Math.rint(Math.pow(b2.var_int_b, n8));
        b2.c = n7;
        b2.var_int_arr_arr_b = new int[b2.d][];
        for (n5 = 0; n5 < b2.d; ++n5) {
            n4 = n5;
            n3 = b2.d / b2.var_int_b;
            b2.var_int_arr_arr_b[n5] = new int[n8];
            for (n2 = 0; n2 < n8; ++n2) {
                int n9 = n4 / n3;
                n4 -= n9 * n3;
                n3 /= b2.var_int_b;
                b2.var_int_arr_arr_b[n5][n2] = n9;
            }
        }
        return b2;
    }

    @Override
    void a(Object object) {
    }

    static synchronized int a(bvo bvo2, Object object, float[][] fArray, int n2, int n3) {
        int n4;
        b b2 = (b)object;
        a a2 = b2.var_bwh$a_a;
        int n5 = a2.var_int_c;
        int n6 = b2.var_bvp_a.var_int_a;
        int n7 = a2.var_int_b - a2.var_int_a;
        int n8 = n7 / n5;
        int n9 = (n8 + n6 - 1) / n6;
        if (var_int_arr_arr_arr_a.length < n2) {
            var_int_arr_arr_arr_a = new int[n2][][];
        }
        for (n4 = 0; n4 < n2; ++n4) {
            if (var_int_arr_arr_arr_a[n4] != null && var_int_arr_arr_arr_a[n4].length >= n9) continue;
            bwh.var_int_arr_arr_arr_a[n4] = new int[n9][];
        }
        for (int i2 = 0; i2 < b2.c; ++i2) {
            int n10 = 0;
            int n11 = 0;
            while (n10 < n8) {
                int n12;
                if (i2 == 0) {
                    for (n4 = 0; n4 < n2; ++n4) {
                        n12 = b2.var_bvp_a.a(bvo2.var_bvj_a);
                        if (n12 == -1) {
                            return 0;
                        }
                        bwh.var_int_arr_arr_arr_a[n4][n11] = b2.var_int_arr_arr_b[n12];
                        if (var_int_arr_arr_arr_a[n4][n11] != null) continue;
                        return 0;
                    }
                }
                for (int i3 = 0; i3 < n6 && n10 < n8; ++i3, ++n10) {
                    for (n4 = 0; n4 < n2; ++n4) {
                        bvp bvp2;
                        n12 = a2.var_int_a + n10 * n5;
                        int n13 = var_int_arr_arr_arr_a[n4][n11][i3];
                        if ((a2.var_int_arr_a[n13] & 1 << i2) == 0 || (bvp2 = b2.var_bvp_arr_a[b2.var_int_arr_arr_a[n13][i2]]) == null || !(n3 == 0 ? bvp2.a(fArray[n4], n12, bvo2.var_bvj_a, n5) == -1 : n3 == 1 && bvp2.b(fArray[n4], n12, bvo2.var_bvj_a, n5) == -1)) continue;
                        return 0;
                    }
                }
                ++n11;
            }
        }
        return 0;
    }

    static synchronized int a(bvo bvo2, Object object, float[][] fArray, int n2) {
        b b2 = (b)object;
        a a2 = b2.var_bwh$a_a;
        int n3 = a2.var_int_c;
        int n4 = b2.var_bvp_a.var_int_a;
        int n5 = a2.var_int_b - a2.var_int_a;
        int n6 = n5 / n3;
        int n7 = (n6 + n4 - 1) / n4;
        if (var_int_arr_arr_a == null || var_int_arr_arr_a.length < n7) {
            var_int_arr_arr_a = new int[n7][];
        }
        for (int i2 = 0; i2 < b2.c; ++i2) {
            int n8 = 0;
            int n9 = 0;
            while (n8 < n6) {
                int n10;
                if (i2 == 0) {
                    n10 = b2.var_bvp_a.a(bvo2.var_bvj_a);
                    if (n10 == -1) {
                        return 0;
                    }
                    bwh.var_int_arr_arr_a[n9] = b2.var_int_arr_arr_b[n10];
                    if (var_int_arr_arr_a[n9] == null) {
                        return 0;
                    }
                }
                for (int i3 = 0; i3 < n4 && n8 < n6; ++i3, ++n8) {
                    bvp bvp2;
                    n10 = a2.var_int_a + n8 * n3;
                    int n11 = var_int_arr_arr_a[n9][i3];
                    if ((a2.var_int_arr_a[n11] & 1 << i2) == 0 || (bvp2 = b2.var_bvp_arr_a[b2.var_int_arr_arr_a[n11][i2]]) == null || bvp2.a(fArray, n10, n2, bvo2.var_bvj_a, n3) != -1) continue;
                    return 0;
                }
                ++n9;
            }
        }
        return 0;
    }

    @Override
    int a(bvo bvo2, Object object, float[][] fArray, int[] nArray, int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (nArray[i2] == 0) continue;
            fArray[n3++] = fArray[i2];
        }
        if (n3 != 0) {
            return bwh.a(bvo2, object, fArray, n3, 0);
        }
        return 0;
    }

    static {
        var_int_arr_arr_arr_a = new int[2][][];
        var_int_arr_arr_a = null;
    }

    class a {
        int var_int_a;
        int var_int_b;
        int var_int_c;
        int var_int_d;
        int e;
        int[] var_int_arr_a = new int[64];
        int[] var_int_arr_b = new int[256];
        float[] var_float_arr_a = new float[64];
        float[] var_float_arr_b = new float[64];
        int[] var_int_arr_c = new int[64];
        int[] var_int_arr_d = new int[64];
        final /* synthetic */ bwh var_bwh_a;

        a(bwh bwh2) {
            this.var_bwh_a = bwh2;
        }
    }

    class b {
        a var_bwh$a_a;
        int var_int_a;
        int var_int_b;
        int c;
        bvp[] var_bvp_arr_a;
        bvp var_bvp_a;
        int[][] var_int_arr_arr_a;
        int d;
        int[][] var_int_arr_arr_b;
        final /* synthetic */ bwh var_bwh_a;

        b(bwh bwh2) {
            this.var_bwh_a = bwh2;
        }
    }
}

