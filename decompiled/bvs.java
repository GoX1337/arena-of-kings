/*
 * Decompiled with CFR 0.152.
 */
public class bvs {
    int var_int_a;
    bvz var_bvz_a;
    int var_int_b;
    float[][] var_float_arr_arr_a;
    int var_int_c;
    int var_int_d;
    int var_int_e;
    int var_int_f;
    int g;
    int h;
    int i;
    int j;
    long var_long_a;
    long var_long_b;
    long var_long_c;
    long var_long_d;
    long var_long_e;
    long var_long_f;
    float[][][][][] var_float_arr_arr_arr_arr_arr_a;
    Object[][] var_java_lang_Object_arr_arr_a = new Object[2][];
    bvp[] var_bvp_arr_a;
    Object[] var_java_lang_Object_arr_a;

    public bvs() {
        this.var_float_arr_arr_arr_arr_arr_a = new float[2][][][][];
        this.var_float_arr_arr_arr_arr_arr_a[0] = new float[2][][][];
        this.var_float_arr_arr_arr_arr_arr_a[0][0] = new float[2][][];
        this.var_float_arr_arr_arr_arr_arr_a[0][1] = new float[2][][];
        this.var_float_arr_arr_arr_arr_arr_a[0][0][0] = new float[2][];
        this.var_float_arr_arr_arr_arr_arr_a[0][0][1] = new float[2][];
        this.var_float_arr_arr_arr_arr_arr_a[0][1][0] = new float[2][];
        this.var_float_arr_arr_arr_arr_arr_a[0][1][1] = new float[2][];
        this.var_float_arr_arr_arr_arr_arr_a[1] = new float[2][][][];
        this.var_float_arr_arr_arr_arr_arr_a[1][0] = new float[2][][];
        this.var_float_arr_arr_arr_arr_arr_a[1][1] = new float[2][][];
        this.var_float_arr_arr_arr_arr_arr_a[1][0][0] = new float[2][];
        this.var_float_arr_arr_arr_arr_arr_a[1][0][1] = new float[2][];
        this.var_float_arr_arr_arr_arr_arr_a[1][1][0] = new float[2][];
        this.var_float_arr_arr_arr_arr_arr_a[1][1][1] = new float[2][];
    }

    static float[] a(int n2, int n3, int n4, int n5) {
        float[] fArray = new float[n3];
        switch (n2) {
            case 0: {
                float f2;
                int n6;
                int n7 = n3 / 4 - n4 / 2;
                int n8 = n3 - n3 / 4 - n5 / 2;
                for (n6 = 0; n6 < n4; ++n6) {
                    f2 = (float)(((double)n6 + 0.5) / (double)n4 * 3.1415927410125732 / 2.0);
                    f2 = (float)Math.sin(f2);
                    f2 *= f2;
                    f2 = (float)((double)f2 * 1.5707963705062866);
                    fArray[n6 + n7] = f2 = (float)Math.sin(f2);
                }
                for (n6 = n7 + n4; n6 < n8; ++n6) {
                    fArray[n6] = 1.0f;
                }
                for (n6 = 0; n6 < n5; ++n6) {
                    f2 = (float)(((double)(n5 - n6) - 0.5) / (double)n5 * 3.1415927410125732 / 2.0);
                    f2 = (float)Math.sin(f2);
                    f2 *= f2;
                    f2 = (float)((double)f2 * 1.5707963705062866);
                    fArray[n6 + n8] = f2 = (float)Math.sin(f2);
                }
                break;
            }
            default: {
                return null;
            }
        }
        return fArray;
    }

    int a(bvz bvz2, boolean bl2) {
        int n2;
        this.var_bvz_a = bvz2;
        this.var_int_b = bwm.b(bvz2.g);
        this.var_java_lang_Object_arr_arr_a[0] = new Object[1];
        this.var_java_lang_Object_arr_arr_a[1] = new Object[1];
        this.var_java_lang_Object_arr_arr_a[0][0] = new bwf();
        this.var_java_lang_Object_arr_arr_a[1][0] = new bwf();
        ((bwf)this.var_java_lang_Object_arr_arr_a[0][0]).a(bvz2.var_int_arr_a[0]);
        ((bwf)this.var_java_lang_Object_arr_arr_a[1][0]).a(bvz2.var_int_arr_a[1]);
        this.var_float_arr_arr_arr_arr_arr_a[0][0][0] = new float[1][];
        this.var_float_arr_arr_arr_arr_arr_a[0][0][1] = this.var_float_arr_arr_arr_arr_arr_a[0][0][0];
        this.var_float_arr_arr_arr_arr_arr_a[0][1][0] = this.var_float_arr_arr_arr_arr_arr_a[0][0][0];
        this.var_float_arr_arr_arr_arr_arr_a[0][1][1] = this.var_float_arr_arr_arr_arr_arr_a[0][0][0];
        this.var_float_arr_arr_arr_arr_arr_a[1][0][0] = new float[1][];
        this.var_float_arr_arr_arr_arr_arr_a[1][0][1] = new float[1][];
        this.var_float_arr_arr_arr_arr_arr_a[1][1][0] = new float[1][];
        this.var_float_arr_arr_arr_arr_arr_a[1][1][1] = new float[1][];
        for (n2 = 0; n2 < 1; ++n2) {
            this.var_float_arr_arr_arr_arr_arr_a[0][0][0][n2] = bvs.a(n2, bvz2.var_int_arr_a[0], bvz2.var_int_arr_a[0] / 2, bvz2.var_int_arr_a[0] / 2);
            this.var_float_arr_arr_arr_arr_arr_a[1][0][0][n2] = bvs.a(n2, bvz2.var_int_arr_a[1], bvz2.var_int_arr_a[0] / 2, bvz2.var_int_arr_a[0] / 2);
            this.var_float_arr_arr_arr_arr_arr_a[1][0][1][n2] = bvs.a(n2, bvz2.var_int_arr_a[1], bvz2.var_int_arr_a[0] / 2, bvz2.var_int_arr_a[1] / 2);
            this.var_float_arr_arr_arr_arr_arr_a[1][1][0][n2] = bvs.a(n2, bvz2.var_int_arr_a[1], bvz2.var_int_arr_a[1] / 2, bvz2.var_int_arr_a[0] / 2);
            this.var_float_arr_arr_arr_arr_arr_a[1][1][1][n2] = bvs.a(n2, bvz2.var_int_arr_a[1], bvz2.var_int_arr_a[1] / 2, bvz2.var_int_arr_a[1] / 2);
        }
        this.var_bvp_arr_a = new bvp[bvz2.l];
        for (n2 = 0; n2 < bvz2.l; ++n2) {
            this.var_bvp_arr_a[n2] = new bvp();
            this.var_bvp_arr_a[n2].a(bvz2.var_bwk_arr_a[n2]);
        }
        this.var_int_c = 8192;
        this.var_float_arr_arr_a = new float[bvz2.var_int_b][];
        for (n2 = 0; n2 < bvz2.var_int_b; ++n2) {
            this.var_float_arr_arr_a[n2] = new float[this.var_int_c];
        }
        this.g = 0;
        this.h = 0;
        this.var_int_d = this.j = bvz2.var_int_arr_a[1] / 2;
        this.var_java_lang_Object_arr_a = new Object[bvz2.g];
        for (n2 = 0; n2 < bvz2.g; ++n2) {
            int n3 = bvz2.var_bwa_arr_a[n2].d;
            int n4 = bvz2.var_int_arr_b[n3];
            this.var_java_lang_Object_arr_a[n2] = bvw.a[n4].a(this, bvz2.var_bwa_arr_a[n2], bvz2.var_java_lang_Object_arr_a[n3]);
        }
        return 0;
    }

    public int a(bvz bvz2) {
        this.a(bvz2, false);
        this.var_int_e = this.j;
        this.j -= bvz2.var_int_arr_a[this.h] / 4 + bvz2.var_int_arr_a[this.g] / 4;
        this.var_long_a = -1L;
        this.var_long_b = -1L;
        return 0;
    }

    public int a(bvo bvo2) {
        int n2;
        int n3;
        int n4;
        if (this.j > this.var_bvz_a.var_int_arr_a[1] / 2 && this.var_int_e > 8192) {
            n4 = this.j - this.var_bvz_a.var_int_arr_a[1] / 2;
            n4 = this.var_int_e < n4 ? this.var_int_e : n4;
            this.var_int_d -= n4;
            this.j -= n4;
            this.var_int_e -= n4;
            if (n4 != 0) {
                for (n3 = 0; n3 < this.var_bvz_a.var_int_b; ++n3) {
                    System.arraycopy(this.var_float_arr_arr_a[n3], n4, this.var_float_arr_arr_a[n3], 0, this.var_int_d);
                }
            }
        }
        this.g = this.h;
        this.h = bvo2.var_int_b;
        this.i = -1;
        this.var_long_c += (long)bvo2.g;
        this.var_long_d += (long)bvo2.h;
        this.var_long_e += (long)bvo2.i;
        this.var_long_f += (long)bvo2.j;
        if (this.var_long_b + 1L != bvo2.var_long_b) {
            this.var_long_a = -1L;
        }
        this.var_long_b = bvo2.var_long_b;
        n4 = this.var_bvz_a.var_int_arr_a[this.h];
        n3 = this.j + this.var_bvz_a.var_int_arr_a[this.g] / 4 + n4 / 4;
        int n5 = n3 - n4 / 2;
        int n6 = n5 + n4;
        int n7 = 0;
        int n8 = 0;
        if (n6 > this.var_int_c) {
            this.var_int_c = n6 + this.var_bvz_a.var_int_arr_a[1];
            for (n2 = 0; n2 < this.var_bvz_a.var_int_b; ++n2) {
                float[] fArray = new float[this.var_int_c];
                System.arraycopy(this.var_float_arr_arr_a[n2], 0, fArray, 0, this.var_float_arr_arr_a[n2].length);
                this.var_float_arr_arr_a[n2] = fArray;
            }
        }
        switch (this.h) {
            case 0: {
                n7 = 0;
                n8 = this.var_bvz_a.var_int_arr_a[0] / 2;
                break;
            }
            case 1: {
                n7 = this.var_bvz_a.var_int_arr_a[1] / 4 - this.var_bvz_a.var_int_arr_a[this.g] / 4;
                n8 = n7 + this.var_bvz_a.var_int_arr_a[this.g] / 2;
            }
        }
        for (n2 = 0; n2 < this.var_bvz_a.var_int_b; ++n2) {
            int n9 = n5;
            int n10 = 0;
            for (n10 = n7; n10 < n8; ++n10) {
                float[] fArray = this.var_float_arr_arr_a[n2];
                int n11 = n9 + n10;
                fArray[n11] = fArray[n11] + bvo2.var_float_arr_arr_a[n2][n10];
            }
            while (n10 < n4) {
                this.var_float_arr_arr_a[n2][n9 + n10] = bvo2.var_float_arr_arr_a[n2][n10];
                ++n10;
            }
        }
        if (this.var_long_a == -1L) {
            this.var_long_a = bvo2.var_long_a;
        } else {
            this.var_long_a += (long)(n3 - this.j);
            if (bvo2.var_long_a != -1L && this.var_long_a != bvo2.var_long_a) {
                if (this.var_long_a > bvo2.var_long_a && bvo2.f != 0) {
                    n3 = (int)((long)n3 - (this.var_long_a - bvo2.var_long_a));
                }
                this.var_long_a = bvo2.var_long_a;
            }
        }
        this.j = n3;
        this.var_int_d = n6;
        if (bvo2.f != 0) {
            this.var_int_f = 1;
        }
        return 0;
    }

    public int a(float[][][] fArray, int[] nArray) {
        if (this.var_int_e < this.j) {
            if (fArray != null) {
                for (int i2 = 0; i2 < this.var_bvz_a.var_int_b; ++i2) {
                    nArray[i2] = this.var_int_e;
                }
                fArray[0] = this.var_float_arr_arr_a;
            }
            return this.j - this.var_int_e;
        }
        return 0;
    }

    public int a(int n2) {
        if (n2 != 0 && this.var_int_e + n2 > this.j) {
            return -1;
        }
        this.var_int_e += n2;
        return 0;
    }

    public void a() {
    }
}

