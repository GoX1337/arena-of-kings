/*
 * Decompiled with CFR 0.152.
 */
class bvp {
    int var_int_a;
    int b;
    bwk var_bwk_a = new bwk();
    float[] var_float_arr_a;
    a var_bvp$a_a;
    private int[] var_int_arr_a = new int[15];

    bvp() {
    }

    synchronized int a(float[] fArray, int n2, bvj bvj2, int n3) {
        int n4;
        int n5 = n3 / this.var_int_a;
        if (this.var_int_arr_a.length < n5) {
            this.var_int_arr_a = new int[n5];
        }
        for (n4 = 0; n4 < n5; ++n4) {
            int n6 = this.a(bvj2);
            if (n6 == -1) {
                return -1;
            }
            this.var_int_arr_a[n4] = n6 * this.var_int_a;
        }
        n4 = 0;
        int n7 = 0;
        while (n4 < this.var_int_a) {
            for (int i2 = 0; i2 < n5; ++i2) {
                int n8 = n2 + n7 + i2;
                fArray[n8] = fArray[n8] + this.var_float_arr_a[this.var_int_arr_a[i2] + n4];
            }
            ++n4;
            n7 += n5;
        }
        return 0;
    }

    int b(float[] fArray, int n2, bvj bvj2, int n3) {
        if (this.var_int_a > 8) {
            int n4 = 0;
            while (n4 < n3) {
                int n5 = this.a(bvj2);
                if (n5 == -1) {
                    return -1;
                }
                int n6 = n5 * this.var_int_a;
                int n7 = 0;
                while (n7 < this.var_int_a) {
                    int n8 = n2 + n4++;
                    fArray[n8] = fArray[n8] + this.var_float_arr_a[n6 + n7++];
                }
            }
        } else {
            int n9 = 0;
            while (n9 < n3) {
                int n10 = this.a(bvj2);
                if (n10 == -1) {
                    return -1;
                }
                int n11 = n10 * this.var_int_a;
                int n12 = 0;
                switch (this.var_int_a) {
                    case 8: {
                        int n13 = n2 + n9++;
                        fArray[n13] = fArray[n13] + this.var_float_arr_a[n11 + n12++];
                    }
                    case 7: {
                        int n14 = n2 + n9++;
                        fArray[n14] = fArray[n14] + this.var_float_arr_a[n11 + n12++];
                    }
                    case 6: {
                        int n15 = n2 + n9++;
                        fArray[n15] = fArray[n15] + this.var_float_arr_a[n11 + n12++];
                    }
                    case 5: {
                        int n16 = n2 + n9++;
                        fArray[n16] = fArray[n16] + this.var_float_arr_a[n11 + n12++];
                    }
                    case 4: {
                        int n17 = n2 + n9++;
                        fArray[n17] = fArray[n17] + this.var_float_arr_a[n11 + n12++];
                    }
                    case 3: {
                        int n18 = n2 + n9++;
                        fArray[n18] = fArray[n18] + this.var_float_arr_a[n11 + n12++];
                    }
                    case 2: {
                        int n19 = n2 + n9++;
                        fArray[n19] = fArray[n19] + this.var_float_arr_a[n11 + n12++];
                    }
                    case 1: {
                        int n20 = n2 + n9++;
                        fArray[n20] = fArray[n20] + this.var_float_arr_a[n11 + n12++];
                    }
                }
            }
        }
        return 0;
    }

    int c(float[] fArray, int n2, bvj bvj2, int n3) {
        int n4 = 0;
        while (n4 < n3) {
            int n5 = this.a(bvj2);
            if (n5 == -1) {
                return -1;
            }
            int n6 = n5 * this.var_int_a;
            int n7 = 0;
            while (n7 < this.var_int_a) {
                fArray[n2 + n4++] = this.var_float_arr_a[n6 + n7++];
            }
        }
        return 0;
    }

    int a(float[][] fArray, int n2, int n3, bvj bvj2, int n4) {
        int n5 = 0;
        int n6 = n2 / n3;
        while (n6 < (n2 + n4) / n3) {
            int n7 = this.a(bvj2);
            if (n7 == -1) {
                return -1;
            }
            int n8 = n7 * this.var_int_a;
            for (int i2 = 0; i2 < this.var_int_a; ++i2) {
                float[] fArray2 = fArray[n5++];
                int n9 = n6++;
                fArray2[n9] = fArray2[n9] + this.var_float_arr_a[n8 + i2];
                if (n5 != n3) continue;
                n5 = 0;
            }
        }
        return 0;
    }

    int a(bvj bvj2) {
        int n2 = 0;
        a a2 = this.var_bvp$a_a;
        int n3 = bvj2.int_a(a2.var_int_a);
        if (n3 >= 0) {
            n2 = a2.var_int_arr_a[n3];
            bvj2.void_a(a2.var_int_arr_b[n3]);
            if (n2 <= 0) {
                return -n2;
            }
        }
        do {
            switch (bvj2.int_a()) {
                case 0: {
                    n2 = a2.c[n2];
                    break;
                }
                case 1: {
                    n2 = a2.d[n2];
                    break;
                }
                default: {
                    return -1;
                }
            }
        } while (n2 > 0);
        return -n2;
    }

    void void_a() {
    }

    int a(bwk bwk2) {
        this.var_bwk_a = bwk2;
        this.b = bwk2.var_int_b;
        this.var_int_a = bwk2.var_int_a;
        this.var_float_arr_a = bwk2.float_arr_a();
        this.var_bvp$a_a = this.bvp$a_a();
        if (this.var_bvp$a_a == null) {
            this.void_a();
            return -1;
        }
        return 0;
    }

    static int[] a(int[] nArray, int n2) {
        int n3;
        int n4;
        int n5;
        int[] nArray2 = new int[33];
        int[] nArray3 = new int[n2];
        for (n5 = 0; n5 < n2; ++n5) {
            n4 = nArray[n5];
            if (n4 <= 0) continue;
            n3 = nArray2[n4];
            if (n4 < 32 && n3 >>> n4 != 0) {
                return null;
            }
            nArray3[n5] = n3;
            int n6 = n4;
            while (n6 > 0) {
                if ((nArray2[n6] & 1) != 0) {
                    if (n6 == 1) {
                        nArray2[1] = nArray2[1] + 1;
                        break;
                    }
                    nArray2[n6] = nArray2[n6 - 1] << 1;
                    break;
                }
                int n7 = n6--;
                nArray2[n7] = nArray2[n7] + 1;
            }
            for (n6 = n4 + 1; n6 < 33 && nArray2[n6] >>> 1 == n3; ++n6) {
                n3 = nArray2[n6];
                nArray2[n6] = nArray2[n6 - 1] << 1;
            }
        }
        for (n5 = 0; n5 < n2; ++n5) {
            n4 = 0;
            for (n3 = 0; n3 < nArray[n5]; ++n3) {
                n4 <<= 1;
                n4 |= nArray3[n5] >>> n3 & 1;
            }
            nArray3[n5] = n4;
        }
        return nArray3;
    }

    a bvp$a_a() {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6 = 0;
        a a2 = new a(this);
        a2.c = new int[this.b * 2];
        int[] nArray = a2.c;
        a2.d = new int[this.b * 2];
        int[] nArray2 = a2.d;
        int[] nArray3 = bvp.a(this.var_bwk_a.var_int_arr_a, this.var_bwk_a.var_int_b);
        if (nArray3 == null) {
            return null;
        }
        a2.var_int_b = this.b * 2;
        for (n5 = 0; n5 < this.b; ++n5) {
            if (this.var_bwk_a.var_int_arr_a[n5] <= 0) continue;
            n4 = 0;
            for (n3 = 0; n3 < this.var_bwk_a.var_int_arr_a[n5] - 1; ++n3) {
                n2 = nArray3[n5] >>> n3 & 1;
                if (n2 == 0) {
                    if (nArray[n4] == 0) {
                        nArray[n4] = ++n6;
                    }
                    n4 = nArray[n4];
                    continue;
                }
                if (nArray2[n4] == 0) {
                    nArray2[n4] = ++n6;
                }
                n4 = nArray2[n4];
            }
            if ((nArray3[n5] >>> n3 & 1) == 0) {
                nArray[n4] = -n5;
                continue;
            }
            nArray2[n4] = -n5;
        }
        a2.var_int_a = bwm.a(this.b) - 4;
        if (a2.var_int_a < 5) {
            a2.var_int_a = 5;
        }
        n5 = 1 << a2.var_int_a;
        a2.var_int_arr_a = new int[n5];
        a2.var_int_arr_b = new int[n5];
        for (n4 = 0; n4 < n5; ++n4) {
            n3 = 0;
            n2 = 0;
            for (n2 = 0; n2 < a2.var_int_a && (n3 > 0 || n2 == 0); ++n2) {
                n3 = (n4 & 1 << n2) != 0 ? nArray2[n3] : nArray[n3];
            }
            a2.var_int_arr_a[n4] = n3;
            a2.var_int_arr_b[n4] = n2;
        }
        return a2;
    }

    class a {
        int[] var_int_arr_a;
        int[] var_int_arr_b;
        int var_int_a;
        int[] c;
        int[] d;
        int var_int_b;
        final /* synthetic */ bvp var_bvp_a;

        a(bvp bvp2) {
            this.var_bvp_a = bvp2;
        }
    }
}

