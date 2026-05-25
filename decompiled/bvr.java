/*
 * Decompiled with CFR 0.152.
 */
class bvr {
    int var_int_a;
    float[] var_float_arr_a;
    int[] var_int_arr_a;
    static int[] var_int_arr_b;
    static float var_float_a;
    static float var_float_b;
    static float c;
    static float d;
    static float e;

    bvr() {
    }

    void a(int n2) {
        this.var_int_a = n2;
        this.var_float_arr_a = new float[3 * n2];
        this.var_int_arr_a = new int[32];
        bvr.a(n2, this.var_float_arr_a, this.var_int_arr_a);
    }

    /*
     * Enabled aggressive block sorting
     */
    static void a(int n2, float[] fArray, int n3, int[] nArray) {
        int n4 = 0;
        int n5 = -1;
        int n6 = n2;
        int n7 = 0;
        int n8 = 101;
        while (true) {
            switch (n8) {
                case 101: {
                    n4 = ++n5 < 4 ? var_int_arr_b[n5] : (n4 += 2);
                }
                case 104: {
                    int n9;
                    int n10 = n6 / n4;
                    int n11 = n6 - n4 * n10;
                    if (n11 != 0) {
                        n8 = 101;
                        break;
                    }
                    nArray[++n7 + 1] = n4;
                    n6 = n10;
                    if (n4 != 2) {
                        n8 = 107;
                        break;
                    }
                    if (n7 == 1) {
                        n8 = 107;
                        break;
                    }
                    for (n9 = 1; n9 < n7; ++n9) {
                        int n12 = n7 - n9 + 1;
                        nArray[n12 + 1] = nArray[n12];
                    }
                    nArray[2] = 2;
                }
                case 107: {
                    int n9;
                    if (n6 != 1) {
                        n8 = 104;
                        break;
                    }
                    nArray[0] = n2;
                    nArray[1] = n7;
                    float f2 = var_float_a / (float)n2;
                    int n13 = 0;
                    int n14 = n7 - 1;
                    int n15 = 1;
                    if (n14 == 0) {
                        return;
                    }
                    for (int i2 = 0; i2 < n14; ++i2) {
                        int n16 = nArray[i2 + 2];
                        int n17 = 0;
                        int n18 = n15 * n16;
                        int n19 = n2 / n18;
                        int n20 = n16 - 1;
                        for (n5 = 0; n5 < n20; n13 += n19, ++n5) {
                            n9 = n13;
                            float f3 = (float)(n17 += n15) * f2;
                            float f4 = 0.0f;
                            for (int i3 = 2; i3 < n19; i3 += 2) {
                                float f5 = (f4 += 1.0f) * f3;
                                fArray[n3 + n9++] = (float)Math.cos(f5);
                                fArray[n3 + n9++] = (float)Math.sin(f5);
                            }
                        }
                        n15 = n18;
                    }
                    return;
                }
            }
        }
    }

    static void a(int n2, float[] fArray, int[] nArray) {
        if (n2 == 1) {
            return;
        }
        bvr.a(n2, fArray, n2, nArray);
    }

    static {
        var_int_arr_b = new int[]{4, 2, 3, 5};
        var_float_a = (float)Math.PI * 2;
        var_float_b = 0.70710677f;
        c = 0.8660254f;
        d = -0.5f;
        e = 1.4142135f;
    }
}

