/*
 * Decompiled with CFR 0.152.
 */
public final class bwy
implements bwt {
    final double var_double_a = 1.3333333333333333;
    public int[] var_int_arr_a;
    private int var_int_a = 0;
    private int[] var_int_arr_h;
    private float[][][] var_float_arr_arr_arr_a;
    private float[][][] var_float_arr_arr_arr_b;
    private float[] var_float_arr_g;
    private float[][] var_float_arr_arr_c;
    private float[][] var_float_arr_arr_d;
    private int[] var_int_arr_i;
    private bwp var_bwp_a;
    private bwu var_bwu_a;
    private bxb var_bxb_a;
    private bxb var_bxb_b;
    private bxa var_bxa_a;
    private int var_int_b;
    private bwo var_bwo_a;
    private a var_bwy$a_a;
    private f[] var_bwy$f_arr_a;
    private f[] var_bwy$f_arr_b;
    private int var_int_c;
    private int var_int_d;
    private int var_int_e;
    private int var_int_f;
    private int var_int_g;
    private int var_int_h;
    private int var_int_i;
    private float[] var_float_arr_h = new float[32];
    private float[] var_float_arr_i = new float[32];
    private final int[] var_int_arr_j = new int[4];
    int[] var_int_arr_b = new int[]{0};
    int[] var_int_arr_c = new int[]{0};
    int[] var_int_arr_d = new int[]{0};
    int[] var_int_arr_e = new int[]{0};
    int[] var_int_arr_f = new int[576];
    float[] var_float_arr_a = new float[576];
    float[] var_float_arr_b = new float[18];
    float[] var_float_arr_c = new float[36];
    private int var_int_j = 0;
    private static final int[][] var_int_arr_arr_a;
    public static final int[] var_int_arr_g;
    private b[] var_bwy$b_arr_a;
    public static final float[] var_float_arr_d;
    public static final float[] var_float_arr_e;
    public static final float[][] var_float_arr_arr_a;
    public static final float[] var_float_arr_f;
    private static int[][] var_int_arr_arr_b;
    private static final float[] var_float_arr_j;
    private static final float[] k;
    public static final float[][] var_float_arr_arr_b;
    public c var_bwy$c_a;
    public static final int[][][] var_int_arr_arr_arr_a;

    public bwy(bwp bwp2, bwu bwu2, bxb bxb2, bxb bxb3, bxa bxa2, int n2) {
        bxc.a();
        this.var_int_arr_h = new int[580];
        this.var_float_arr_arr_arr_a = new float[2][32][18];
        this.var_float_arr_arr_arr_b = new float[2][32][18];
        this.var_float_arr_g = new float[576];
        this.var_float_arr_arr_c = new float[2][576];
        this.var_float_arr_arr_d = new float[2][576];
        this.var_int_arr_i = new int[2];
        this.var_bwy$f_arr_a = new f[2];
        this.var_bwy$f_arr_a[0] = new f();
        this.var_bwy$f_arr_a[1] = new f();
        this.var_bwy$f_arr_b = this.var_bwy$f_arr_a;
        this.var_bwy$b_arr_a = new b[9];
        int[] nArray = new int[]{0, 6, 12, 18, 24, 30, 36, 44, 54, 66, 80, 96, 116, 140, 168, 200, 238, 284, 336, 396, 464, 522, 576};
        int[] nArray2 = new int[]{0, 4, 8, 12, 18, 24, 32, 42, 56, 74, 100, 132, 174, 192};
        int[] nArray3 = new int[]{0, 6, 12, 18, 24, 30, 36, 44, 54, 66, 80, 96, 114, 136, 162, 194, 232, 278, 330, 394, 464, 540, 576};
        int[] nArray4 = new int[]{0, 4, 8, 12, 18, 26, 36, 48, 62, 80, 104, 136, 180, 192};
        int[] nArray5 = new int[]{0, 6, 12, 18, 24, 30, 36, 44, 54, 66, 80, 96, 116, 140, 168, 200, 238, 284, 336, 396, 464, 522, 576};
        int[] nArray6 = new int[]{0, 4, 8, 12, 18, 26, 36, 48, 62, 80, 104, 134, 174, 192};
        int[] nArray7 = new int[]{0, 4, 8, 12, 16, 20, 24, 30, 36, 44, 52, 62, 74, 90, 110, 134, 162, 196, 238, 288, 342, 418, 576};
        int[] nArray8 = new int[]{0, 4, 8, 12, 16, 22, 30, 40, 52, 66, 84, 106, 136, 192};
        int[] nArray9 = new int[]{0, 4, 8, 12, 16, 20, 24, 30, 36, 42, 50, 60, 72, 88, 106, 128, 156, 190, 230, 276, 330, 384, 576};
        int[] nArray10 = new int[]{0, 4, 8, 12, 16, 22, 28, 38, 50, 64, 80, 100, 126, 192};
        int[] nArray11 = new int[]{0, 4, 8, 12, 16, 20, 24, 30, 36, 44, 54, 66, 82, 102, 126, 156, 194, 240, 296, 364, 448, 550, 576};
        int[] nArray12 = new int[]{0, 4, 8, 12, 16, 22, 30, 42, 58, 78, 104, 138, 180, 192};
        int[] nArray13 = new int[]{0, 6, 12, 18, 24, 30, 36, 44, 54, 66, 80, 96, 116, 140, 168, 200, 238, 284, 336, 396, 464, 522, 576};
        int[] nArray14 = new int[]{0, 4, 8, 12, 18, 26, 36, 48, 62, 80, 104, 134, 174, 192};
        int[] nArray15 = new int[]{0, 6, 12, 18, 24, 30, 36, 44, 54, 66, 80, 96, 116, 140, 168, 200, 238, 284, 336, 396, 464, 522, 576};
        int[] nArray16 = new int[]{0, 4, 8, 12, 18, 26, 36, 48, 62, 80, 104, 134, 174, 192};
        int[] nArray17 = new int[]{0, 12, 24, 36, 48, 60, 72, 88, 108, 132, 160, 192, 232, 280, 336, 400, 476, 566, 568, 570, 572, 574, 576};
        int[] nArray18 = new int[]{0, 8, 16, 24, 36, 52, 72, 96, 124, 160, 162, 164, 166, 192};
        this.var_bwy$b_arr_a[0] = new b(nArray, nArray2);
        this.var_bwy$b_arr_a[1] = new b(nArray3, nArray4);
        this.var_bwy$b_arr_a[2] = new b(nArray5, nArray6);
        this.var_bwy$b_arr_a[3] = new b(nArray7, nArray8);
        this.var_bwy$b_arr_a[4] = new b(nArray9, nArray10);
        this.var_bwy$b_arr_a[5] = new b(nArray11, nArray12);
        this.var_bwy$b_arr_a[6] = new b(nArray13, nArray14);
        this.var_bwy$b_arr_a[7] = new b(nArray15, nArray16);
        this.var_bwy$b_arr_a[8] = new b(nArray17, nArray18);
        if (var_int_arr_arr_b == null) {
            var_int_arr_arr_b = new int[9][];
            for (int i2 = 0; i2 < 9; ++i2) {
                bwy.var_int_arr_arr_b[i2] = bwy.a(this.var_bwy$b_arr_a[i2].b);
            }
        }
        int[] nArray19 = new int[]{0, 6, 11, 16, 21};
        int[] nArray20 = new int[]{0, 6, 12};
        this.var_bwy$c_a = new c(this, nArray19, nArray20);
        this.var_int_arr_a = new int[54];
        this.var_bwp_a = bwp2;
        this.var_bwu_a = bwu2;
        this.var_bxb_a = bxb2;
        this.var_bxb_b = bxb3;
        this.var_bxa_a = bxa2;
        this.var_int_b = n2;
        this.var_int_d = 0;
        this.var_int_f = this.var_bwu_a.f() == 3 ? 1 : 2;
        this.var_int_c = this.var_bwu_a.int_a() == 1 ? 2 : 1;
        this.var_int_i = this.var_bwu_a.int_d() + (this.var_bwu_a.int_a() == 1 ? 3 : (this.var_bwu_a.int_a() == 2 ? 6 : 0));
        if (this.var_int_f == 2) {
            switch (this.var_int_b) {
                case 1: 
                case 3: {
                    this.var_int_h = 0;
                    this.var_int_g = 0;
                    break;
                }
                case 2: {
                    this.var_int_h = 1;
                    this.var_int_g = 1;
                    break;
                }
                default: {
                    this.var_int_g = 0;
                    this.var_int_h = 1;
                    break;
                }
            }
        } else {
            this.var_int_h = 0;
            this.var_int_g = 0;
        }
        for (int i3 = 0; i3 < 2; ++i3) {
            for (int i4 = 0; i4 < 576; ++i4) {
                this.var_float_arr_arr_c[i3][i4] = 0.0f;
            }
        }
        this.var_int_arr_i[1] = 576;
        this.var_int_arr_i[0] = 576;
        this.var_bwo_a = new bwo();
        this.var_bwy$a_a = new a();
    }

    @Override
    public void void_a() {
        this.b();
    }

    public void b() {
        int n2 = this.var_bwu_a.g();
        this.boolean_a();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.var_bwo_a.void_a(this.var_bwp_a.b(8));
        }
        int n3 = this.var_bwo_a.a() >>> 3;
        int n4 = this.var_bwo_a.a() & 7;
        if (n4 != 0) {
            this.var_bwo_a.int_a(8 - n4);
            ++n3;
        }
        int n5 = this.var_int_d - n3 - this.var_bwy$a_a.var_int_a;
        this.var_int_d += n2;
        if (n5 < 0) {
            return;
        }
        if (n3 > 4096) {
            this.var_int_d -= 4096;
            this.var_bwo_a.c(4096);
        }
        while (n5 > 0) {
            this.var_bwo_a.int_a(8);
            --n5;
        }
        for (int i3 = 0; i3 < this.var_int_c; ++i3) {
            int n6;
            for (n6 = 0; n6 < this.var_int_f; ++n6) {
                this.var_int_e = this.var_bwo_a.a();
                if (this.var_bwu_a.int_a() == 1) {
                    this.a(n6, i3);
                } else {
                    this.c(n6, i3);
                }
                this.d(n6, i3);
                this.a(this.var_float_arr_arr_arr_a[n6], n6, i3);
            }
            this.a(i3);
            if (this.var_int_b == 3 && this.var_int_f > 1) {
                this.c();
            }
            for (n6 = this.var_int_g; n6 <= this.var_int_h; ++n6) {
                int n7;
                int n8;
                int n9;
                this.b(this.var_float_arr_arr_arr_b[n6], n6, i3);
                this.e(n6, i3);
                this.f(n6, i3);
                for (n9 = 18; n9 < 576; n9 += 36) {
                    for (n8 = 1; n8 < 18; n8 += 2) {
                        this.var_float_arr_g[n9 + n8] = -this.var_float_arr_g[n9 + n8];
                    }
                }
                if (n6 == 0 || this.var_int_b == 2) {
                    for (n8 = 0; n8 < 18; ++n8) {
                        n7 = 0;
                        for (n9 = 0; n9 < 576; n9 += 18) {
                            this.var_float_arr_h[n7] = this.var_float_arr_g[n9 + n8];
                            ++n7;
                        }
                        this.var_bxb_a.a(this.var_float_arr_h);
                        this.var_bxb_a.a(this.var_bxa_a);
                    }
                    continue;
                }
                for (n8 = 0; n8 < 18; ++n8) {
                    n7 = 0;
                    for (n9 = 0; n9 < 576; n9 += 18) {
                        this.var_float_arr_i[n7] = this.var_float_arr_g[n9 + n8];
                        ++n7;
                    }
                    this.var_bxb_b.a(this.var_float_arr_i);
                    this.var_bxb_b.a(this.var_bxa_a);
                }
            }
        }
        ++this.var_int_j;
    }

    private boolean boolean_a() {
        if (this.var_bwu_a.int_a() == 1) {
            int n2;
            this.var_bwy$a_a.var_int_a = this.var_bwp_a.b(9);
            this.var_bwy$a_a.b = this.var_int_f == 1 ? this.var_bwp_a.b(5) : this.var_bwp_a.b(3);
            for (n2 = 0; n2 < this.var_int_f; ++n2) {
                this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_int_arr_a[0] = this.var_bwp_a.b(1);
                this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_int_arr_a[1] = this.var_bwp_a.b(1);
                this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_int_arr_a[2] = this.var_bwp_a.b(1);
                this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_int_arr_a[3] = this.var_bwp_a.b(1);
            }
            for (int i2 = 0; i2 < 2; ++i2) {
                for (n2 = 0; n2 < this.var_int_f; ++n2) {
                    this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].var_int_a = this.var_bwp_a.b(12);
                    this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].var_int_b = this.var_bwp_a.b(9);
                    this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].c = this.var_bwp_a.b(8);
                    this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].d = this.var_bwp_a.b(4);
                    this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].e = this.var_bwp_a.b(1);
                    if (this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].e != 0) {
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].f = this.var_bwp_a.b(2);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].g = this.var_bwp_a.b(1);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].var_int_arr_a[0] = this.var_bwp_a.b(5);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].var_int_arr_a[1] = this.var_bwp_a.b(5);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].var_int_arr_b[0] = this.var_bwp_a.b(3);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].var_int_arr_b[1] = this.var_bwp_a.b(3);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].var_int_arr_b[2] = this.var_bwp_a.b(3);
                        if (this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].f == 0) {
                            return false;
                        }
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].h = this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].f == 2 && this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].g == 0 ? 8 : 7;
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].i = 20 - this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].h;
                    } else {
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].var_int_arr_a[0] = this.var_bwp_a.b(5);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].var_int_arr_a[1] = this.var_bwp_a.b(5);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].var_int_arr_a[2] = this.var_bwp_a.b(5);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].h = this.var_bwp_a.b(4);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].i = this.var_bwp_a.b(3);
                        this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].f = 0;
                    }
                    this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].j = this.var_bwp_a.b(1);
                    this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].k = this.var_bwp_a.b(1);
                    this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[i2].l = this.var_bwp_a.b(1);
                }
            }
        } else {
            this.var_bwy$a_a.var_int_a = this.var_bwp_a.b(8);
            this.var_bwy$a_a.b = this.var_int_f == 1 ? this.var_bwp_a.b(1) : this.var_bwp_a.b(2);
            for (int i3 = 0; i3 < this.var_int_f; ++i3) {
                this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].var_int_a = this.var_bwp_a.b(12);
                this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].var_int_b = this.var_bwp_a.b(9);
                this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].c = this.var_bwp_a.b(8);
                this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].d = this.var_bwp_a.b(9);
                this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].e = this.var_bwp_a.b(1);
                if (this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].e != 0) {
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].f = this.var_bwp_a.b(2);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].g = this.var_bwp_a.b(1);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].var_int_arr_a[0] = this.var_bwp_a.b(5);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].var_int_arr_a[1] = this.var_bwp_a.b(5);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].var_int_arr_b[0] = this.var_bwp_a.b(3);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].var_int_arr_b[1] = this.var_bwp_a.b(3);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].var_int_arr_b[2] = this.var_bwp_a.b(3);
                    if (this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].f == 0) {
                        return false;
                    }
                    if (this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].f == 2 && this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].g == 0) {
                        this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].h = 8;
                    } else {
                        this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].h = 7;
                        this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].i = 20 - this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].h;
                    }
                } else {
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].var_int_arr_a[0] = this.var_bwp_a.b(5);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].var_int_arr_a[1] = this.var_bwp_a.b(5);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].var_int_arr_a[2] = this.var_bwp_a.b(5);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].h = this.var_bwp_a.b(4);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].i = this.var_bwp_a.b(3);
                    this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].f = 0;
                }
                this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].k = this.var_bwp_a.b(1);
                this.var_bwy$a_a.var_bwy$e_arr_a[i3].var_bwy$d_arr_a[0].l = this.var_bwp_a.b(1);
            }
        }
        return true;
    }

    private void a(int n2, int n3) {
        d d2 = this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3];
        int n4 = d2.d;
        int n5 = var_int_arr_arr_a[0][n4];
        int n6 = var_int_arr_arr_a[1][n4];
        if (d2.e != 0 && d2.f == 2) {
            if (d2.g != 0) {
                int n7;
                int n8;
                for (n8 = 0; n8 < 8; ++n8) {
                    this.var_bwy$f_arr_b[n2].var_int_arr_a[n8] = this.var_bwo_a.int_a(var_int_arr_arr_a[0][d2.d]);
                }
                for (n8 = 3; n8 < 6; ++n8) {
                    for (n7 = 0; n7 < 3; ++n7) {
                        this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[n7][n8] = this.var_bwo_a.int_a(var_int_arr_arr_a[0][d2.d]);
                    }
                }
                for (n8 = 6; n8 < 12; ++n8) {
                    for (n7 = 0; n7 < 3; ++n7) {
                        this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[n7][n8] = this.var_bwo_a.int_a(var_int_arr_arr_a[1][d2.d]);
                    }
                }
                n8 = 12;
                for (n7 = 0; n7 < 3; ++n7) {
                    this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[n7][n8] = 0;
                }
            } else {
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][0] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][0] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][0] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][1] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][1] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][1] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][2] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][2] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][2] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][3] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][3] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][3] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][4] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][4] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][4] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][5] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][5] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][5] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][6] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][6] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][6] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][7] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][7] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][7] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][8] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][8] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][8] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][9] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][9] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][9] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][10] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][10] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][10] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][11] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][11] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][11] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[0][12] = 0;
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[1][12] = 0;
                this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[2][12] = 0;
            }
        } else {
            if (this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_int_arr_a[0] == 0 || n3 == 0) {
                this.var_bwy$f_arr_b[n2].var_int_arr_a[0] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[1] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[2] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[3] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[4] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[5] = this.var_bwo_a.int_a(n5);
            }
            if (this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_int_arr_a[1] == 0 || n3 == 0) {
                this.var_bwy$f_arr_b[n2].var_int_arr_a[6] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[7] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[8] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[9] = this.var_bwo_a.int_a(n5);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[10] = this.var_bwo_a.int_a(n5);
            }
            if (this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_int_arr_a[2] == 0 || n3 == 0) {
                this.var_bwy$f_arr_b[n2].var_int_arr_a[11] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[12] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[13] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[14] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[15] = this.var_bwo_a.int_a(n6);
            }
            if (this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_int_arr_a[3] == 0 || n3 == 0) {
                this.var_bwy$f_arr_b[n2].var_int_arr_a[16] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[17] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[18] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[19] = this.var_bwo_a.int_a(n6);
                this.var_bwy$f_arr_b[n2].var_int_arr_a[20] = this.var_bwo_a.int_a(n6);
            }
            this.var_bwy$f_arr_b[n2].var_int_arr_a[21] = 0;
            this.var_bwy$f_arr_b[n2].var_int_arr_a[22] = 0;
        }
    }

    private void b(int n2, int n3) {
        int n4;
        int n5 = this.var_bwu_a.h();
        int n6 = 0;
        d d2 = this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3];
        int n7 = d2.d;
        int n8 = d2.f == 2 ? (d2.g == 0 ? 1 : (d2.g == 1 ? 2 : 0)) : 0;
        if (n5 != 1 && n5 != 3 || n2 != 1) {
            if (n7 < 400) {
                this.var_int_arr_j[0] = (n7 >>> 4) / 5;
                this.var_int_arr_j[1] = (n7 >>> 4) % 5;
                this.var_int_arr_j[2] = (n7 & 0xF) >>> 2;
                this.var_int_arr_j[3] = n7 & 3;
                this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].j = 0;
                n6 = 0;
            } else if (n7 < 500) {
                this.var_int_arr_j[0] = (n7 - 400 >>> 2) / 5;
                this.var_int_arr_j[1] = (n7 - 400 >>> 2) % 5;
                this.var_int_arr_j[2] = n7 - 400 & 3;
                this.var_int_arr_j[3] = 0;
                this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].j = 0;
                n6 = 1;
            } else if (n7 < 512) {
                this.var_int_arr_j[0] = (n7 - 500) / 3;
                this.var_int_arr_j[1] = (n7 - 500) % 3;
                this.var_int_arr_j[2] = 0;
                this.var_int_arr_j[3] = 0;
                this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].j = 1;
                n6 = 2;
            }
        }
        if ((n5 == 1 || n5 == 3) && n2 == 1) {
            int n9 = n7 >>> 1;
            if (n9 < 180) {
                this.var_int_arr_j[0] = n9 / 36;
                this.var_int_arr_j[1] = n9 % 36 / 6;
                this.var_int_arr_j[2] = n9 % 36 % 6;
                this.var_int_arr_j[3] = 0;
                this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].j = 0;
                n6 = 3;
            } else if (n9 < 244) {
                this.var_int_arr_j[0] = (n9 - 180 & 0x3F) >>> 4;
                this.var_int_arr_j[1] = (n9 - 180 & 0xF) >>> 2;
                this.var_int_arr_j[2] = n9 - 180 & 3;
                this.var_int_arr_j[3] = 0;
                this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].j = 0;
                n6 = 4;
            } else if (n9 < 255) {
                this.var_int_arr_j[0] = (n9 - 244) / 3;
                this.var_int_arr_j[1] = (n9 - 244) % 3;
                this.var_int_arr_j[2] = 0;
                this.var_int_arr_j[3] = 0;
                this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].j = 0;
                n6 = 5;
            }
        }
        for (n4 = 0; n4 < 45; ++n4) {
            this.var_int_arr_a[n4] = 0;
        }
        int n10 = 0;
        for (n4 = 0; n4 < 4; ++n4) {
            for (int i2 = 0; i2 < var_int_arr_arr_arr_a[n6][n8][n4]; ++i2) {
                this.var_int_arr_a[n10] = this.var_int_arr_j[n4] == 0 ? 0 : this.var_bwo_a.int_a(this.var_int_arr_j[n4]);
                ++n10;
            }
        }
    }

    private void c(int n2, int n3) {
        int n4 = 0;
        d d2 = this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3];
        this.b(n2, n3);
        if (d2.e != 0 && d2.f == 2) {
            if (d2.g != 0) {
                int n5;
                int n6;
                for (n6 = 0; n6 < 8; ++n6) {
                    this.var_bwy$f_arr_b[n2].var_int_arr_a[n6] = this.var_int_arr_a[n4];
                    ++n4;
                }
                for (n6 = 3; n6 < 12; ++n6) {
                    for (n5 = 0; n5 < 3; ++n5) {
                        this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[n5][n6] = this.var_int_arr_a[n4];
                        ++n4;
                    }
                }
                for (n5 = 0; n5 < 3; ++n5) {
                    this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[n5][12] = 0;
                }
            } else {
                int n7;
                for (int i2 = 0; i2 < 12; ++i2) {
                    for (n7 = 0; n7 < 3; ++n7) {
                        this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[n7][i2] = this.var_int_arr_a[n4];
                        ++n4;
                    }
                }
                for (n7 = 0; n7 < 3; ++n7) {
                    this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[n7][12] = 0;
                }
            }
        } else {
            for (int i3 = 0; i3 < 21; ++i3) {
                this.var_bwy$f_arr_b[n2].var_int_arr_a[i3] = this.var_int_arr_a[n4];
                ++n4;
            }
            this.var_bwy$f_arr_b[n2].var_int_arr_a[21] = 0;
            this.var_bwy$f_arr_b[n2].var_int_arr_a[22] = 0;
        }
    }

    private void d(int n2, int n3) {
        bxc bxc2;
        int n4;
        int n5;
        this.var_int_arr_b[0] = 0;
        this.var_int_arr_c[0] = 0;
        this.var_int_arr_d[0] = 0;
        this.var_int_arr_e[0] = 0;
        int n6 = this.var_int_e + this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].var_int_a;
        if (this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].e != 0 && this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].f == 2) {
            n5 = this.var_int_i == 8 ? 72 : 36;
            n4 = 576;
        } else {
            int n7 = this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].h + 1;
            int n8 = n7 + this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].i + 1;
            if (n8 > this.var_bwy$b_arr_a[this.var_int_i].a.length - 1) {
                n8 = this.var_bwy$b_arr_a[this.var_int_i].a.length - 1;
            }
            n5 = this.var_bwy$b_arr_a[this.var_int_i].a[n7];
            n4 = this.var_bwy$b_arr_a[this.var_int_i].a[n8];
        }
        int n9 = 0;
        for (int i2 = 0; i2 < this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].var_int_b << 1; i2 += 2) {
            bxc2 = i2 < n5 ? bxc.var_bxc_arr_a[this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].var_int_arr_a[0]] : (i2 < n4 ? bxc.var_bxc_arr_a[this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].var_int_arr_a[1]] : bxc.var_bxc_arr_a[this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].var_int_arr_a[2]]);
            bxc.a(bxc2, this.var_int_arr_b, this.var_int_arr_c, this.var_int_arr_d, this.var_int_arr_e, this.var_bwo_a);
            this.var_int_arr_h[n9++] = this.var_int_arr_b[0];
            this.var_int_arr_h[n9++] = this.var_int_arr_c[0];
            this.var_int_a = this.var_int_a + this.var_int_arr_b[0] + this.var_int_arr_c[0];
        }
        bxc2 = bxc.var_bxc_arr_a[this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3].l + 32];
        int n10 = this.var_bwo_a.a();
        while (n10 < n6 && n9 < 576) {
            bxc.a(bxc2, this.var_int_arr_b, this.var_int_arr_c, this.var_int_arr_d, this.var_int_arr_e, this.var_bwo_a);
            this.var_int_arr_h[n9++] = this.var_int_arr_d[0];
            this.var_int_arr_h[n9++] = this.var_int_arr_e[0];
            this.var_int_arr_h[n9++] = this.var_int_arr_b[0];
            this.var_int_arr_h[n9++] = this.var_int_arr_c[0];
            this.var_int_a = this.var_int_a + this.var_int_arr_d[0] + this.var_int_arr_e[0] + this.var_int_arr_b[0] + this.var_int_arr_c[0];
            n10 = this.var_bwo_a.a();
        }
        if (n10 > n6) {
            this.var_bwo_a.b(n10 - n6);
            n9 -= 4;
        }
        if ((n10 = this.var_bwo_a.a()) < n6) {
            this.var_bwo_a.int_a(n6 - n10);
        }
        this.var_int_arr_i[n2] = n9 < 576 ? n9 : 576;
        if (n9 < 0) {
            n9 = 0;
        }
        while (n9 < 576) {
            this.var_int_arr_h[n9] = 0;
            ++n9;
        }
    }

    private void a(int n2, int n3, int n4) {
        if (n2 == 0) {
            this.var_float_arr_arr_d[0][n4] = 1.0f;
            this.var_float_arr_arr_d[1][n4] = 1.0f;
        } else if ((n2 & 1) != 0) {
            this.var_float_arr_arr_d[0][n4] = var_float_arr_arr_a[n3][n2 + 1 >>> 1];
            this.var_float_arr_arr_d[1][n4] = 1.0f;
        } else {
            this.var_float_arr_arr_d[0][n4] = 1.0f;
            this.var_float_arr_arr_d[1][n4] = var_float_arr_arr_a[n3][n2 >>> 1];
        }
    }

    private void a(float[][] fArray, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        d d2 = this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3];
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        float[][] fArray2 = fArray;
        if (d2.e != 0 && d2.f == 2) {
            if (d2.g != 0) {
                n8 = this.var_bwy$b_arr_a[this.var_int_i].a[1];
            } else {
                n11 = this.var_bwy$b_arr_a[this.var_int_i].b[1];
                n8 = (n11 << 2) - n11;
                n10 = 0;
            }
        } else {
            n8 = this.var_bwy$b_arr_a[this.var_int_i].a[1];
        }
        float f2 = (float)Math.pow(2.0, 0.25 * ((double)d2.c - 210.0));
        for (n7 = 0; n7 < this.var_int_arr_i[n2]; ++n7) {
            n6 = n7 % 18;
            n5 = (n7 - n6) / 18;
            if (this.var_int_arr_h[n7] == 0) {
                fArray2[n5][n6] = 0.0f;
                continue;
            }
            n4 = this.var_int_arr_h[n7];
            if (n4 < var_float_arr_e.length) {
                if (this.var_int_arr_h[n7] > 0) {
                    fArray2[n5][n6] = f2 * var_float_arr_e[n4];
                    continue;
                }
                if (-n4 < var_float_arr_e.length) {
                    fArray2[n5][n6] = -f2 * var_float_arr_e[-n4];
                    continue;
                }
                fArray2[n5][n6] = -f2 * (float)Math.pow(-n4, 1.3333333333333333);
                continue;
            }
            fArray2[n5][n6] = this.var_int_arr_h[n7] > 0 ? f2 * (float)Math.pow(n4, 1.3333333333333333) : -f2 * (float)Math.pow(-n4, 1.3333333333333333);
        }
        for (n7 = 0; n7 < this.var_int_arr_i[n2]; ++n7) {
            n6 = n7 % 18;
            n5 = (n7 - n6) / 18;
            if (n12 == n8) {
                if (d2.e != 0 && d2.f == 2) {
                    if (d2.g != 0) {
                        if (n12 == this.var_bwy$b_arr_a[this.var_int_i].a[8]) {
                            n8 = this.var_bwy$b_arr_a[this.var_int_i].b[4];
                            n8 = (n8 << 2) - n8;
                            n9 = 3;
                            n11 = this.var_bwy$b_arr_a[this.var_int_i].b[4] - this.var_bwy$b_arr_a[this.var_int_i].b[3];
                            n10 = this.var_bwy$b_arr_a[this.var_int_i].b[3];
                            n10 = (n10 << 2) - n10;
                        } else if (n12 < this.var_bwy$b_arr_a[this.var_int_i].a[8]) {
                            n8 = this.var_bwy$b_arr_a[this.var_int_i].a[++n9 + 1];
                        } else {
                            n8 = this.var_bwy$b_arr_a[this.var_int_i].b[++n9 + 1];
                            n8 = (n8 << 2) - n8;
                            n10 = this.var_bwy$b_arr_a[this.var_int_i].b[n9];
                            n11 = this.var_bwy$b_arr_a[this.var_int_i].b[n9 + 1] - n10;
                            n10 = (n10 << 2) - n10;
                        }
                    } else {
                        n8 = this.var_bwy$b_arr_a[this.var_int_i].b[++n9 + 1];
                        n8 = (n8 << 2) - n8;
                        n10 = this.var_bwy$b_arr_a[this.var_int_i].b[n9];
                        n11 = this.var_bwy$b_arr_a[this.var_int_i].b[n9 + 1] - n10;
                        n10 = (n10 << 2) - n10;
                    }
                } else {
                    n8 = this.var_bwy$b_arr_a[this.var_int_i].a[++n9 + 1];
                }
            }
            if (d2.e != 0 && (d2.f == 2 && d2.g == 0 || d2.f == 2 && d2.g != 0 && n7 >= 36)) {
                int n13 = (n12 - n10) / n11;
                n4 = this.var_bwy$f_arr_b[n2].var_int_arr_arr_a[n13][n9] << d2.k;
                float[] fArray3 = fArray2[n5];
                int n14 = n6;
                fArray3[n14] = fArray3[n14] * var_float_arr_d[n4 += d2.var_int_arr_b[n13] << 2];
            } else {
                n4 = this.var_bwy$f_arr_b[n2].var_int_arr_a[n9];
                if (d2.j != 0) {
                    n4 += var_int_arr_g[n9];
                }
                float[] fArray4 = fArray2[n5];
                int n15 = n6;
                fArray4[n15] = fArray4[n15] * var_float_arr_d[n4 <<= d2.k];
            }
            ++n12;
        }
        for (n7 = this.var_int_arr_i[n2]; n7 < 576; ++n7) {
            n6 = n7 % 18;
            n5 = (n7 - n6) / 18;
            if (n6 < 0) {
                n6 = 0;
            }
            if (n5 < 0) {
                n5 = 0;
            }
            fArray2[n5][n6] = 0.0f;
        }
    }

    private void b(float[][] fArray, int n2, int n3) {
        d d2 = this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3];
        float[][] fArray2 = fArray;
        if (d2.e != 0 && d2.f == 2) {
            int n4;
            for (n4 = 0; n4 < 576; ++n4) {
                this.var_float_arr_g[n4] = 0.0f;
            }
            if (d2.g != 0) {
                int n5;
                int n6;
                for (n4 = 0; n4 < 36; ++n4) {
                    n6 = n4 % 18;
                    n5 = (n4 - n6) / 18;
                    this.var_float_arr_g[n4] = fArray2[n5][n6];
                }
                for (int i2 = 3; i2 < 13; ++i2) {
                    int n7 = this.var_bwy$b_arr_a[this.var_int_i].b[i2];
                    int n8 = this.var_bwy$b_arr_a[this.var_int_i].b[i2 + 1] - n7;
                    n6 = (n7 << 2) - n7;
                    int n9 = 0;
                    int n10 = 0;
                    while (n9 < n8) {
                        int n11 = n6 + n9;
                        int n12 = n6 + n10;
                        n5 = n11 % 18;
                        int n13 = (n11 - n5) / 18;
                        this.var_float_arr_g[n12] = fArray2[n13][n5];
                        n5 = (n11 += n8) % 18;
                        n13 = (n11 - n5) / 18;
                        this.var_float_arr_g[++n12] = fArray2[n13][n5];
                        n5 = (n11 += n8) % 18;
                        n13 = (n11 - n5) / 18;
                        this.var_float_arr_g[++n12] = fArray2[n13][n5];
                        ++n9;
                        n10 += 3;
                    }
                }
            } else {
                for (n4 = 0; n4 < 576; ++n4) {
                    int n14 = var_int_arr_arr_b[this.var_int_i][n4];
                    int n15 = n14 % 18;
                    int n16 = (n14 - n15) / 18;
                    this.var_float_arr_g[n4] = fArray2[n16][n15];
                }
            }
        } else {
            for (int i3 = 0; i3 < 576; ++i3) {
                int n17 = i3 % 18;
                int n18 = (i3 - n17) / 18;
                this.var_float_arr_g[i3] = fArray2[n18][n17];
            }
        }
    }

    private void a(int n2) {
        if (this.var_int_f == 1) {
            for (int i2 = 0; i2 < 32; ++i2) {
                for (int i3 = 0; i3 < 18; i3 += 3) {
                    this.var_float_arr_arr_arr_b[0][i2][i3] = this.var_float_arr_arr_arr_a[0][i2][i3];
                    this.var_float_arr_arr_arr_b[0][i2][i3 + 1] = this.var_float_arr_arr_arr_a[0][i2][i3 + 1];
                    this.var_float_arr_arr_arr_b[0][i2][i3 + 2] = this.var_float_arr_arr_arr_a[0][i2][i3 + 2];
                }
            }
        } else {
            int n3;
            int n4;
            int n5;
            d d2 = this.var_bwy$a_a.var_bwy$e_arr_a[0].var_bwy$d_arr_a[n2];
            int n6 = this.var_bwu_a.h();
            boolean bl2 = this.var_bwu_a.f() == 1 && (n6 & 2) != 0;
            boolean bl3 = this.var_bwu_a.f() == 1 && (n6 & 1) != 0;
            boolean bl4 = this.var_bwu_a.int_a() == 0 || this.var_bwu_a.int_a() == 2;
            int n7 = d2.d & 1;
            for (n5 = 0; n5 < 576; ++n5) {
                this.var_int_arr_f[n5] = 7;
                this.var_float_arr_a[n5] = 0.0f;
            }
            if (bl3) {
                int n8;
                if (d2.e != 0 && d2.f == 2) {
                    int n9;
                    int n10;
                    int n11;
                    int n12;
                    if (d2.g != 0) {
                        n12 = 0;
                        for (n11 = 0; n11 < 3; ++n11) {
                            int n13 = 2;
                            for (n8 = 12; n8 >= 3; --n8) {
                                n5 = this.var_bwy$b_arr_a[this.var_int_i].b[n8];
                                n10 = this.var_bwy$b_arr_a[this.var_int_i].b[n8 + 1] - n5;
                                n5 = (n5 << 2) - n5 + (n11 + 1) * n10 - 1;
                                while (n10 > 0) {
                                    if (this.var_float_arr_arr_arr_a[1][n5 / 18][n5 % 18] != 0.0f) {
                                        n13 = n8;
                                        n8 = -10;
                                        n10 = -10;
                                    }
                                    --n10;
                                    --n5;
                                }
                            }
                            n8 = n13 + 1;
                            if (n8 > n12) {
                                n12 = n8;
                            }
                            while (n8 < 12) {
                                n9 = this.var_bwy$b_arr_a[this.var_int_i].b[n8];
                                n5 = (n9 << 2) - n9 + n11 * n4;
                                for (n4 = this.var_bwy$b_arr_a[this.var_int_i].b[n8 + 1] - n9; n4 > 0; --n4) {
                                    this.var_int_arr_f[n5] = this.var_bwy$f_arr_b[1].var_int_arr_arr_a[n11][n8];
                                    if (this.var_int_arr_f[n5] != 7) {
                                        if (bl4) {
                                            this.a(this.var_int_arr_f[n5], n7, n5);
                                        } else {
                                            this.var_float_arr_a[n5] = var_float_arr_f[this.var_int_arr_f[n5]];
                                        }
                                    }
                                    ++n5;
                                }
                                ++n8;
                            }
                            n8 = this.var_bwy$b_arr_a[this.var_int_i].b[10];
                            n4 = this.var_bwy$b_arr_a[this.var_int_i].b[11] - n8;
                            n8 = (n8 << 2) - n8 + n11 * n4;
                            n9 = this.var_bwy$b_arr_a[this.var_int_i].b[11];
                            n5 = (n9 << 2) - n9 + n11 * n4;
                            for (n4 = this.var_bwy$b_arr_a[this.var_int_i].b[12] - n9; n4 > 0; --n4) {
                                this.var_int_arr_f[n5] = this.var_int_arr_f[n8];
                                if (bl4) {
                                    this.var_float_arr_arr_d[0][n5] = this.var_float_arr_arr_d[0][n8];
                                    this.var_float_arr_arr_d[1][n5] = this.var_float_arr_arr_d[1][n8];
                                } else {
                                    this.var_float_arr_a[n5] = this.var_float_arr_a[n8];
                                }
                                ++n5;
                            }
                        }
                        if (n12 <= 3) {
                            n5 = 2;
                            n3 = 17;
                            n4 = -1;
                            while (n5 >= 0) {
                                if (this.var_float_arr_arr_arr_a[1][n5][n3] != 0.0f) {
                                    n4 = (n5 << 4) + (n5 << 1) + n3;
                                    n5 = -1;
                                    continue;
                                }
                                if (--n3 >= 0) continue;
                                --n5;
                                n3 = 17;
                            }
                            n5 = 0;
                            while (this.var_bwy$b_arr_a[this.var_int_i].a[n5] <= n4) {
                                ++n5;
                            }
                            n8 = n5;
                            n5 = this.var_bwy$b_arr_a[this.var_int_i].a[n5];
                            while (n8 < 8) {
                                for (n4 = this.var_bwy$b_arr_a[this.var_int_i].a[n8 + 1] - this.var_bwy$b_arr_a[this.var_int_i].a[n8]; n4 > 0; --n4) {
                                    this.var_int_arr_f[n5] = this.var_bwy$f_arr_b[1].var_int_arr_a[n8];
                                    if (this.var_int_arr_f[n5] != 7) {
                                        if (bl4) {
                                            this.a(this.var_int_arr_f[n5], n7, n5);
                                        } else {
                                            this.var_float_arr_a[n5] = var_float_arr_f[this.var_int_arr_f[n5]];
                                        }
                                    }
                                    ++n5;
                                }
                                ++n8;
                            }
                        }
                    } else {
                        for (n12 = 0; n12 < 3; ++n12) {
                            n11 = -1;
                            for (n8 = 12; n8 >= 0; --n8) {
                                n9 = this.var_bwy$b_arr_a[this.var_int_i].b[n8];
                                n10 = this.var_bwy$b_arr_a[this.var_int_i].b[n8 + 1] - n9;
                                n5 = (n9 << 2) - n9 + (n12 + 1) * n10 - 1;
                                while (n10 > 0) {
                                    if (this.var_float_arr_arr_arr_a[1][n5 / 18][n5 % 18] != 0.0f) {
                                        n11 = n8;
                                        n8 = -10;
                                        n10 = -10;
                                    }
                                    --n10;
                                    --n5;
                                }
                            }
                            for (n8 = n11 + 1; n8 < 12; ++n8) {
                                n9 = this.var_bwy$b_arr_a[this.var_int_i].b[n8];
                                n5 = (n9 << 2) - n9 + n12 * n4;
                                for (n4 = this.var_bwy$b_arr_a[this.var_int_i].b[n8 + 1] - n9; n4 > 0; --n4) {
                                    this.var_int_arr_f[n5] = this.var_bwy$f_arr_b[1].var_int_arr_arr_a[n12][n8];
                                    if (this.var_int_arr_f[n5] != 7) {
                                        if (bl4) {
                                            this.a(this.var_int_arr_f[n5], n7, n5);
                                        } else {
                                            this.var_float_arr_a[n5] = var_float_arr_f[this.var_int_arr_f[n5]];
                                        }
                                    }
                                    ++n5;
                                }
                            }
                            n9 = this.var_bwy$b_arr_a[this.var_int_i].b[10];
                            int n14 = this.var_bwy$b_arr_a[this.var_int_i].b[11];
                            n4 = n14 - n9;
                            n8 = (n9 << 2) - n9 + n12 * n4;
                            n5 = (n14 << 2) - n14 + n12 * n4;
                            for (n4 = this.var_bwy$b_arr_a[this.var_int_i].b[12] - n14; n4 > 0; --n4) {
                                this.var_int_arr_f[n5] = this.var_int_arr_f[n8];
                                if (bl4) {
                                    this.var_float_arr_arr_d[0][n5] = this.var_float_arr_arr_d[0][n8];
                                    this.var_float_arr_arr_d[1][n5] = this.var_float_arr_arr_d[1][n8];
                                } else {
                                    this.var_float_arr_a[n5] = this.var_float_arr_a[n8];
                                }
                                ++n5;
                            }
                        }
                    }
                } else {
                    n5 = 31;
                    n3 = 17;
                    n4 = 0;
                    while (n5 >= 0) {
                        if (this.var_float_arr_arr_arr_a[1][n5][n3] != 0.0f) {
                            n4 = (n5 << 4) + (n5 << 1) + n3;
                            n5 = -1;
                            continue;
                        }
                        if (--n3 >= 0) continue;
                        --n5;
                        n3 = 17;
                    }
                    n5 = 0;
                    while (this.var_bwy$b_arr_a[this.var_int_i].a[n5] <= n4) {
                        ++n5;
                    }
                    n8 = n5;
                    n5 = this.var_bwy$b_arr_a[this.var_int_i].a[n5];
                    while (n8 < 21) {
                        for (n4 = this.var_bwy$b_arr_a[this.var_int_i].a[n8 + 1] - this.var_bwy$b_arr_a[this.var_int_i].a[n8]; n4 > 0; --n4) {
                            this.var_int_arr_f[n5] = this.var_bwy$f_arr_b[1].var_int_arr_a[n8];
                            if (this.var_int_arr_f[n5] != 7) {
                                if (bl4) {
                                    this.a(this.var_int_arr_f[n5], n7, n5);
                                } else {
                                    this.var_float_arr_a[n5] = var_float_arr_f[this.var_int_arr_f[n5]];
                                }
                            }
                            ++n5;
                        }
                        ++n8;
                    }
                    n8 = this.var_bwy$b_arr_a[this.var_int_i].a[20];
                    for (n4 = 576 - this.var_bwy$b_arr_a[this.var_int_i].a[21]; n4 > 0 && n5 < 576; ++n5, --n4) {
                        this.var_int_arr_f[n5] = this.var_int_arr_f[n8];
                        if (bl4) {
                            this.var_float_arr_arr_d[0][n5] = this.var_float_arr_arr_d[0][n8];
                            this.var_float_arr_arr_d[1][n5] = this.var_float_arr_arr_d[1][n8];
                            continue;
                        }
                        this.var_float_arr_a[n5] = this.var_float_arr_a[n8];
                    }
                }
            }
            n5 = 0;
            for (n4 = 0; n4 < 32; ++n4) {
                for (n3 = 0; n3 < 18; ++n3) {
                    if (this.var_int_arr_f[n5] == 7) {
                        if (bl2) {
                            this.var_float_arr_arr_arr_b[0][n4][n3] = (this.var_float_arr_arr_arr_a[0][n4][n3] + this.var_float_arr_arr_arr_a[1][n4][n3]) * 0.70710677f;
                            this.var_float_arr_arr_arr_b[1][n4][n3] = (this.var_float_arr_arr_arr_a[0][n4][n3] - this.var_float_arr_arr_arr_a[1][n4][n3]) * 0.70710677f;
                        } else {
                            this.var_float_arr_arr_arr_b[0][n4][n3] = this.var_float_arr_arr_arr_a[0][n4][n3];
                            this.var_float_arr_arr_arr_b[1][n4][n3] = this.var_float_arr_arr_arr_a[1][n4][n3];
                        }
                    } else if (bl3) {
                        if (bl4) {
                            this.var_float_arr_arr_arr_b[0][n4][n3] = this.var_float_arr_arr_arr_a[0][n4][n3] * this.var_float_arr_arr_d[0][n5];
                            this.var_float_arr_arr_arr_b[1][n4][n3] = this.var_float_arr_arr_arr_a[0][n4][n3] * this.var_float_arr_arr_d[1][n5];
                        } else {
                            this.var_float_arr_arr_arr_b[1][n4][n3] = this.var_float_arr_arr_arr_a[0][n4][n3] / (1.0f + this.var_float_arr_a[n5]);
                            this.var_float_arr_arr_arr_b[0][n4][n3] = this.var_float_arr_arr_arr_b[1][n4][n3] * this.var_float_arr_a[n5];
                        }
                    }
                    ++n5;
                }
            }
        }
    }

    private void e(int n2, int n3) {
        d d2 = this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3];
        if (d2.e != 0 && d2.f == 2 && d2.g == 0) {
            return;
        }
        int n4 = d2.e != 0 && d2.g != 0 && d2.f == 2 ? 18 : 558;
        for (int i2 = 0; i2 < n4; i2 += 18) {
            for (int i3 = 0; i3 < 8; ++i3) {
                int n5 = i2 + 17 - i3;
                int n6 = i2 + 18 + i3;
                float f2 = this.var_float_arr_g[n5];
                float f3 = this.var_float_arr_g[n6];
                this.var_float_arr_g[n5] = f2 * var_float_arr_j[i3] - f3 * k[i3];
                this.var_float_arr_g[n6] = f3 * var_float_arr_j[i3] + f2 * k[i3];
            }
        }
    }

    private void f(int n2, int n3) {
        d d2 = this.var_bwy$a_a.var_bwy$e_arr_a[n2].var_bwy$d_arr_a[n3];
        for (int i2 = 0; i2 < 576; i2 += 18) {
            int n4;
            int n5 = d2.e != 0 && d2.g != 0 && i2 < 36 ? 0 : d2.f;
            float[] fArray = this.var_float_arr_g;
            for (n4 = 0; n4 < 18; ++n4) {
                this.var_float_arr_b[n4] = fArray[n4 + i2];
            }
            this.a(this.var_float_arr_b, this.var_float_arr_c, n5);
            for (n4 = 0; n4 < 18; ++n4) {
                fArray[n4 + i2] = this.var_float_arr_b[n4];
            }
            float[][] fArray2 = this.var_float_arr_arr_c;
            fArray[0 + i2] = this.var_float_arr_c[0] + fArray2[n2][i2 + 0];
            fArray2[n2][i2 + 0] = this.var_float_arr_c[18];
            fArray[1 + i2] = this.var_float_arr_c[1] + fArray2[n2][i2 + 1];
            fArray2[n2][i2 + 1] = this.var_float_arr_c[19];
            fArray[2 + i2] = this.var_float_arr_c[2] + fArray2[n2][i2 + 2];
            fArray2[n2][i2 + 2] = this.var_float_arr_c[20];
            fArray[3 + i2] = this.var_float_arr_c[3] + fArray2[n2][i2 + 3];
            fArray2[n2][i2 + 3] = this.var_float_arr_c[21];
            fArray[4 + i2] = this.var_float_arr_c[4] + fArray2[n2][i2 + 4];
            fArray2[n2][i2 + 4] = this.var_float_arr_c[22];
            fArray[5 + i2] = this.var_float_arr_c[5] + fArray2[n2][i2 + 5];
            fArray2[n2][i2 + 5] = this.var_float_arr_c[23];
            fArray[6 + i2] = this.var_float_arr_c[6] + fArray2[n2][i2 + 6];
            fArray2[n2][i2 + 6] = this.var_float_arr_c[24];
            fArray[7 + i2] = this.var_float_arr_c[7] + fArray2[n2][i2 + 7];
            fArray2[n2][i2 + 7] = this.var_float_arr_c[25];
            fArray[8 + i2] = this.var_float_arr_c[8] + fArray2[n2][i2 + 8];
            fArray2[n2][i2 + 8] = this.var_float_arr_c[26];
            fArray[9 + i2] = this.var_float_arr_c[9] + fArray2[n2][i2 + 9];
            fArray2[n2][i2 + 9] = this.var_float_arr_c[27];
            fArray[10 + i2] = this.var_float_arr_c[10] + fArray2[n2][i2 + 10];
            fArray2[n2][i2 + 10] = this.var_float_arr_c[28];
            fArray[11 + i2] = this.var_float_arr_c[11] + fArray2[n2][i2 + 11];
            fArray2[n2][i2 + 11] = this.var_float_arr_c[29];
            fArray[12 + i2] = this.var_float_arr_c[12] + fArray2[n2][i2 + 12];
            fArray2[n2][i2 + 12] = this.var_float_arr_c[30];
            fArray[13 + i2] = this.var_float_arr_c[13] + fArray2[n2][i2 + 13];
            fArray2[n2][i2 + 13] = this.var_float_arr_c[31];
            fArray[14 + i2] = this.var_float_arr_c[14] + fArray2[n2][i2 + 14];
            fArray2[n2][i2 + 14] = this.var_float_arr_c[32];
            fArray[15 + i2] = this.var_float_arr_c[15] + fArray2[n2][i2 + 15];
            fArray2[n2][i2 + 15] = this.var_float_arr_c[33];
            fArray[16 + i2] = this.var_float_arr_c[16] + fArray2[n2][i2 + 16];
            fArray2[n2][i2 + 16] = this.var_float_arr_c[34];
            fArray[17 + i2] = this.var_float_arr_c[17] + fArray2[n2][i2 + 17];
            fArray2[n2][i2 + 17] = this.var_float_arr_c[35];
        }
    }

    private void c() {
        for (int i2 = 0; i2 < 18; ++i2) {
            for (int i3 = 0; i3 < 18; i3 += 3) {
                this.var_float_arr_arr_arr_b[0][i2][i3] = (this.var_float_arr_arr_arr_b[0][i2][i3] + this.var_float_arr_arr_arr_b[1][i2][i3]) * 0.5f;
                this.var_float_arr_arr_arr_b[0][i2][i3 + 1] = (this.var_float_arr_arr_arr_b[0][i2][i3 + 1] + this.var_float_arr_arr_arr_b[1][i2][i3 + 1]) * 0.5f;
                this.var_float_arr_arr_arr_b[0][i2][i3 + 2] = (this.var_float_arr_arr_arr_b[0][i2][i3 + 2] + this.var_float_arr_arr_arr_b[1][i2][i3 + 2]) * 0.5f;
            }
        }
    }

    public void a(float[] fArray, float[] fArray2, int n2) {
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        if (n2 == 2) {
            fArray2[0] = 0.0f;
            fArray2[1] = 0.0f;
            fArray2[2] = 0.0f;
            fArray2[3] = 0.0f;
            fArray2[4] = 0.0f;
            fArray2[5] = 0.0f;
            fArray2[6] = 0.0f;
            fArray2[7] = 0.0f;
            fArray2[8] = 0.0f;
            fArray2[9] = 0.0f;
            fArray2[10] = 0.0f;
            fArray2[11] = 0.0f;
            fArray2[12] = 0.0f;
            fArray2[13] = 0.0f;
            fArray2[14] = 0.0f;
            fArray2[15] = 0.0f;
            fArray2[16] = 0.0f;
            fArray2[17] = 0.0f;
            fArray2[18] = 0.0f;
            fArray2[19] = 0.0f;
            fArray2[20] = 0.0f;
            fArray2[21] = 0.0f;
            fArray2[22] = 0.0f;
            fArray2[23] = 0.0f;
            fArray2[24] = 0.0f;
            fArray2[25] = 0.0f;
            fArray2[26] = 0.0f;
            fArray2[27] = 0.0f;
            fArray2[28] = 0.0f;
            fArray2[29] = 0.0f;
            fArray2[30] = 0.0f;
            fArray2[31] = 0.0f;
            fArray2[32] = 0.0f;
            fArray2[33] = 0.0f;
            fArray2[34] = 0.0f;
            fArray2[35] = 0.0f;
            int n3 = 0;
            for (int i2 = 0; i2 < 3; ++i2) {
                int n4 = 15 + i2;
                fArray[n4] = fArray[n4] + fArray[12 + i2];
                int n5 = 12 + i2;
                fArray[n5] = fArray[n5] + fArray[9 + i2];
                int n6 = 9 + i2;
                fArray[n6] = fArray[n6] + fArray[6 + i2];
                int n7 = 6 + i2;
                fArray[n7] = fArray[n7] + fArray[3 + i2];
                int n8 = 3 + i2;
                fArray[n8] = fArray[n8] + fArray[0 + i2];
                int n9 = 15 + i2;
                fArray[n9] = fArray[n9] + fArray[9 + i2];
                int n10 = 9 + i2;
                fArray[n10] = fArray[n10] + fArray[3 + i2];
                float f20 = fArray[12 + i2] * 0.5f;
                float f21 = fArray[6 + i2] * 0.8660254f;
                float f22 = fArray[0 + i2] + f20;
                f18 = fArray[0 + i2] - fArray[12 + i2];
                f19 = f22 + f21;
                f17 = f22 - f21;
                f20 = fArray[15 + i2] * 0.5f;
                f21 = fArray[9 + i2] * 0.8660254f;
                f22 = fArray[3 + i2] + f20;
                f15 = fArray[3 + i2] - fArray[15 + i2];
                f14 = f22 + f21;
                f16 = f22 - f21;
                f16 *= 1.9318516f;
                float f23 = f19;
                f19 += (f14 *= 0.5176381f);
                f14 = f23 - f14;
                f23 = f18;
                f18 += (f15 *= 0.70710677f);
                f15 = f23 - f15;
                f23 = f17;
                f17 += f16;
                f16 = f23 - f16;
                f19 *= 0.5043145f;
                f18 *= 0.5411961f;
                f17 *= 0.6302362f;
                f16 *= 0.8213398f;
                f15 *= 1.306563f;
                f14 *= 3.830649f;
                f11 = -f19 * 0.7933533f;
                f10 = -f19 * 0.6087614f;
                f12 = -f18 * 0.9238795f;
                f9 = -f18 * 0.38268343f;
                f13 = -f17 * 0.9914449f;
                f8 = -f17 * 0.13052619f;
                f19 = f16;
                f18 = f15 * 0.38268343f;
                f17 = f14 * 0.6087614f;
                f16 = -f14 * 0.7933533f;
                f15 = -f15 * 0.9238795f;
                f14 = -f19 * 0.9914449f;
                int n11 = n3 + 6;
                fArray2[n11] = fArray2[n11] + (f19 *= 0.13052619f);
                int n12 = n3 + 7;
                fArray2[n12] = fArray2[n12] + f18;
                int n13 = n3 + 8;
                fArray2[n13] = fArray2[n13] + f17;
                int n14 = n3 + 9;
                fArray2[n14] = fArray2[n14] + f16;
                int n15 = n3 + 10;
                fArray2[n15] = fArray2[n15] + f15;
                int n16 = n3 + 11;
                fArray2[n16] = fArray2[n16] + f14;
                int n17 = n3 + 12;
                fArray2[n17] = fArray2[n17] + f13;
                int n18 = n3 + 13;
                fArray2[n18] = fArray2[n18] + f12;
                int n19 = n3 + 14;
                fArray2[n19] = fArray2[n19] + f11;
                int n20 = n3 + 15;
                fArray2[n20] = fArray2[n20] + f10;
                int n21 = n3 + 16;
                fArray2[n21] = fArray2[n21] + f9;
                int n22 = n3 + 17;
                fArray2[n22] = fArray2[n22] + f8;
                n3 += 6;
            }
        } else {
            fArray[17] = fArray[17] + fArray[16];
            fArray[16] = fArray[16] + fArray[15];
            fArray[15] = fArray[15] + fArray[14];
            fArray[14] = fArray[14] + fArray[13];
            fArray[13] = fArray[13] + fArray[12];
            fArray[12] = fArray[12] + fArray[11];
            fArray[11] = fArray[11] + fArray[10];
            fArray[10] = fArray[10] + fArray[9];
            fArray[9] = fArray[9] + fArray[8];
            fArray[8] = fArray[8] + fArray[7];
            fArray[7] = fArray[7] + fArray[6];
            fArray[6] = fArray[6] + fArray[5];
            fArray[5] = fArray[5] + fArray[4];
            fArray[4] = fArray[4] + fArray[3];
            fArray[3] = fArray[3] + fArray[2];
            fArray[2] = fArray[2] + fArray[1];
            fArray[1] = fArray[1] + fArray[0];
            fArray[17] = fArray[17] + fArray[15];
            fArray[15] = fArray[15] + fArray[13];
            fArray[13] = fArray[13] + fArray[11];
            fArray[11] = fArray[11] + fArray[9];
            fArray[9] = fArray[9] + fArray[7];
            fArray[7] = fArray[7] + fArray[5];
            fArray[5] = fArray[5] + fArray[3];
            fArray[3] = fArray[3] + fArray[1];
            float f24 = fArray[0] + fArray[0];
            float f25 = f24 + fArray[12];
            float f26 = f25 + fArray[4] * 1.8793852f + fArray[8] * 1.5320889f + fArray[16] * 0.34729636f;
            float f27 = f24 + fArray[4] - fArray[8] - fArray[12] - fArray[12] - fArray[16];
            float f28 = f25 - fArray[4] * 0.34729636f - fArray[8] * 1.8793852f + fArray[16] * 1.5320889f;
            float f29 = f25 - fArray[4] * 1.5320889f + fArray[8] * 0.34729636f - fArray[16] * 1.8793852f;
            float f30 = fArray[0] - fArray[4] + fArray[8] - fArray[12] + fArray[16];
            float f31 = fArray[6] * 1.7320508f;
            float f32 = fArray[2] * 1.9696155f + f31 + fArray[10] * 1.2855753f + fArray[14] * 0.6840403f;
            float f33 = (fArray[2] - fArray[10] - fArray[14]) * 1.7320508f;
            float f34 = fArray[2] * 1.2855753f - f31 - fArray[10] * 0.6840403f + fArray[14] * 1.9696155f;
            float f35 = fArray[2] * 0.6840403f - f31 + fArray[10] * 1.9696155f - fArray[14] * 1.2855753f;
            float f36 = fArray[1] + fArray[1];
            float f37 = f36 + fArray[13];
            float f38 = f37 + fArray[5] * 1.8793852f + fArray[9] * 1.5320889f + fArray[17] * 0.34729636f;
            float f39 = f36 + fArray[5] - fArray[9] - fArray[13] - fArray[13] - fArray[17];
            float f40 = f37 - fArray[5] * 0.34729636f - fArray[9] * 1.8793852f + fArray[17] * 1.5320889f;
            float f41 = f37 - fArray[5] * 1.5320889f + fArray[9] * 0.34729636f - fArray[17] * 1.8793852f;
            float f42 = (fArray[1] - fArray[5] + fArray[9] - fArray[13] + fArray[17]) * 0.70710677f;
            float f43 = fArray[7] * 1.7320508f;
            float f44 = fArray[3] * 1.9696155f + f43 + fArray[11] * 1.2855753f + fArray[15] * 0.6840403f;
            float f45 = (fArray[3] - fArray[11] - fArray[15]) * 1.7320508f;
            float f46 = fArray[3] * 1.2855753f - f43 - fArray[11] * 0.6840403f + fArray[15] * 1.9696155f;
            float f47 = fArray[3] * 0.6840403f - f43 + fArray[11] * 1.9696155f - fArray[15] * 1.2855753f;
            float f48 = f26 + f32;
            float f49 = (f38 + f44) * 0.5019099f;
            f19 = f48 + f49;
            f2 = f48 - f49;
            f48 = f27 + f33;
            f49 = (f39 + f45) * 0.5176381f;
            f18 = f48 + f49;
            f3 = f48 - f49;
            f48 = f28 + f34;
            f49 = (f40 + f46) * 0.55168897f;
            f17 = f48 + f49;
            f4 = f48 - f49;
            f48 = f29 + f35;
            f49 = (f41 + f47) * 0.61038727f;
            f16 = f48 + f49;
            f5 = f48 - f49;
            f15 = f30 + f42;
            f6 = f30 - f42;
            f48 = f29 - f35;
            f49 = (f41 - f47) * 0.8717234f;
            f14 = f48 + f49;
            f7 = f48 - f49;
            f48 = f28 - f34;
            f49 = (f40 - f46) * 1.1831008f;
            f13 = f48 + f49;
            f8 = f48 - f49;
            f48 = f27 - f33;
            f49 = (f39 - f45) * 1.9318516f;
            f12 = f48 + f49;
            f9 = f48 - f49;
            f48 = f26 - f32;
            f49 = (f38 - f44) * 5.7368565f;
            f11 = f48 + f49;
            f10 = f48 - f49;
            float[] fArray3 = var_float_arr_arr_b[n2];
            fArray2[0] = -f10 * fArray3[0];
            fArray2[1] = -f9 * fArray3[1];
            fArray2[2] = -f8 * fArray3[2];
            fArray2[3] = -f7 * fArray3[3];
            fArray2[4] = -f6 * fArray3[4];
            fArray2[5] = -f5 * fArray3[5];
            fArray2[6] = -f4 * fArray3[6];
            fArray2[7] = -f3 * fArray3[7];
            fArray2[8] = -f2 * fArray3[8];
            fArray2[9] = f2 * fArray3[9];
            fArray2[10] = f3 * fArray3[10];
            fArray2[11] = f4 * fArray3[11];
            fArray2[12] = f5 * fArray3[12];
            fArray2[13] = f6 * fArray3[13];
            fArray2[14] = f7 * fArray3[14];
            fArray2[15] = f8 * fArray3[15];
            fArray2[16] = f9 * fArray3[16];
            fArray2[17] = f10 * fArray3[17];
            fArray2[18] = f11 * fArray3[18];
            fArray2[19] = f12 * fArray3[19];
            fArray2[20] = f13 * fArray3[20];
            fArray2[21] = f14 * fArray3[21];
            fArray2[22] = f15 * fArray3[22];
            fArray2[23] = f16 * fArray3[23];
            fArray2[24] = f17 * fArray3[24];
            fArray2[25] = f18 * fArray3[25];
            fArray2[26] = f19 * fArray3[26];
            fArray2[27] = f19 * fArray3[27];
            fArray2[28] = f18 * fArray3[28];
            fArray2[29] = f17 * fArray3[29];
            fArray2[30] = f16 * fArray3[30];
            fArray2[31] = f15 * fArray3[31];
            fArray2[32] = f14 * fArray3[32];
            fArray2[33] = f13 * fArray3[33];
            fArray2[34] = f12 * fArray3[34];
            fArray2[35] = f11 * fArray3[35];
        }
    }

    private static float[] float_arr_a() {
        float[] fArray = new float[8192];
        double d2 = 1.3333333333333333;
        for (int i2 = 0; i2 < 8192; ++i2) {
            fArray[i2] = (float)Math.pow(i2, 1.3333333333333333);
        }
        return fArray;
    }

    static int[] a(int[] nArray) {
        int n2 = 0;
        int[] nArray2 = new int[576];
        for (int i2 = 0; i2 < 13; ++i2) {
            int n3 = nArray[i2];
            int n4 = nArray[i2 + 1];
            for (int i3 = 0; i3 < 3; ++i3) {
                for (int i4 = n3; i4 < n4; ++i4) {
                    nArray2[3 * i4 + i3] = n2++;
                }
            }
        }
        return nArray2;
    }

    static {
        var_int_arr_arr_a = new int[][]{{0, 0, 0, 0, 3, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4}, {0, 1, 2, 3, 0, 1, 2, 3, 1, 2, 3, 1, 2, 3, 2, 3}};
        var_int_arr_g = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 2, 0};
        var_float_arr_d = new float[]{1.0f, 0.70710677f, 0.5f, 0.35355338f, 0.25f, 0.17677669f, 0.125f, 0.088388346f, 0.0625f, 0.044194173f, 0.03125f, 0.022097087f, 0.015625f, 0.011048543f, 0.0078125f, 0.0055242716f, 0.00390625f, 0.0027621358f, 0.001953125f, 0.0013810679f, 9.765625E-4f, 6.9053395E-4f, 4.8828125E-4f, 3.4526698E-4f, 2.4414062E-4f, 1.7263349E-4f, 1.2207031E-4f, 8.6316744E-5f, 6.1035156E-5f, 4.3158372E-5f, 3.0517578E-5f, 2.1579186E-5f, 1.5258789E-5f, 1.0789593E-5f, 7.6293945E-6f, 5.3947965E-6f, 3.8146973E-6f, 2.6973983E-6f, 1.9073486E-6f, 1.3486991E-6f, 9.536743E-7f, 6.7434956E-7f, 4.7683716E-7f, 3.3717478E-7f, 2.3841858E-7f, 1.6858739E-7f, 1.1920929E-7f, 8.4293696E-8f, 5.9604645E-8f, 4.2146848E-8f, 2.9802322E-8f, 2.1073424E-8f, 1.4901161E-8f, 1.0536712E-8f, 7.450581E-9f, 5.268356E-9f, 3.7252903E-9f, 2.634178E-9f, 1.8626451E-9f, 1.317089E-9f, 9.313226E-10f, 6.585445E-10f, 4.656613E-10f, 3.2927225E-10f};
        var_float_arr_e = bwy.float_arr_a();
        var_float_arr_arr_a = new float[][]{{1.0f, 0.8408964f, 0.70710677f, 0.59460354f, 0.5f, 0.4204482f, 0.35355338f, 0.29730177f, 0.25f, 0.2102241f, 0.17677669f, 0.14865088f, 0.125f, 0.10511205f, 0.088388346f, 0.07432544f, 0.0625f, 0.052556027f, 0.044194173f, 0.03716272f, 0.03125f, 0.026278013f, 0.022097087f, 0.01858136f, 0.015625f, 0.013139007f, 0.011048543f, 0.00929068f, 0.0078125f, 0.0065695033f, 0.0055242716f, 0.00464534f}, {1.0f, 0.70710677f, 0.5f, 0.35355338f, 0.25f, 0.17677669f, 0.125f, 0.088388346f, 0.0625f, 0.044194173f, 0.03125f, 0.022097087f, 0.015625f, 0.011048543f, 0.0078125f, 0.0055242716f, 0.00390625f, 0.0027621358f, 0.001953125f, 0.0013810679f, 9.765625E-4f, 6.9053395E-4f, 4.8828125E-4f, 3.4526698E-4f, 2.4414062E-4f, 1.7263349E-4f, 1.2207031E-4f, 8.6316744E-5f, 6.1035156E-5f, 4.3158372E-5f, 3.0517578E-5f, 2.1579186E-5f}};
        var_float_arr_f = new float[]{0.0f, 0.2679492f, 0.57735026f, 1.0f, 1.7320508f, 3.732051f, 1.0E11f, -3.732051f, -1.7320508f, -1.0f, -0.57735026f, -0.2679492f, 0.0f, 0.2679492f, 0.57735026f, 1.0f};
        var_float_arr_j = new float[]{0.8574929f, 0.881742f, 0.94962865f, 0.9833146f, 0.9955178f, 0.9991606f, 0.9998992f, 0.99999315f};
        k = new float[]{-0.51449573f, -0.47173196f, -0.31337744f, -0.1819132f, -0.09457419f, -0.040965583f, -0.014198569f, -0.0036999746f};
        var_float_arr_arr_b = new float[][]{{-0.016141215f, -0.05360318f, -0.100707136f, -0.16280818f, -0.5f, -0.38388735f, -0.6206114f, -1.1659756f, -3.8720753f, -4.225629f, -1.519529f, -0.97416484f, -0.73744076f, -1.2071068f, -0.5163616f, -0.45426053f, -0.40715656f, -0.3696946f, -0.3387627f, -0.31242222f, -0.28939587f, -0.26880082f, -0.5f, -0.23251417f, -0.21596715f, -0.20004979f, -0.18449493f, -0.16905846f, -0.15350361f, -0.13758625f, -0.12103922f, -0.20710678f, -0.084752575f, -0.06415752f, -0.041131172f, -0.014790705f}, {-0.016141215f, -0.05360318f, -0.100707136f, -0.16280818f, -0.5f, -0.38388735f, -0.6206114f, -1.1659756f, -3.8720753f, -4.225629f, -1.519529f, -0.97416484f, -0.73744076f, -1.2071068f, -0.5163616f, -0.45426053f, -0.40715656f, -0.3696946f, -0.33908543f, -0.3151181f, -0.29642227f, -0.28184548f, -0.5411961f, -0.2621323f, -0.25387916f, -0.2329629f, -0.19852729f, -0.15233535f, -0.0964964f, -0.03342383f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, {-0.0483008f, -0.15715657f, -0.28325045f, -0.42953748f, -1.2071068f, -0.8242648f, -1.1451749f, -1.769529f, -4.5470223f, -3.489053f, -0.7329629f, -0.15076515f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -0.15076514f, -0.7329629f, -3.489053f, -4.5470223f, -1.769529f, -1.1451749f, -0.8313774f, -1.306563f, -0.54142016f, -0.46528974f, -0.4106699f, -0.3700468f, -0.3387627f, -0.31242222f, -0.28939587f, -0.26880082f, -0.5f, -0.23251417f, -0.21596715f, -0.20004979f, -0.18449493f, -0.16905846f, -0.15350361f, -0.13758625f, -0.12103922f, -0.20710678f, -0.084752575f, -0.06415752f, -0.041131172f, -0.014790705f}};
        var_int_arr_arr_arr_a = new int[][][]{new int[][]{{6, 5, 5, 5}, {9, 9, 9, 9}, {6, 9, 9, 9}}, new int[][]{{6, 5, 7, 3}, {9, 9, 12, 6}, {6, 9, 12, 6}}, new int[][]{{11, 10, 0, 0}, {18, 18, 0, 0}, {15, 18, 0, 0}}, new int[][]{{7, 7, 7, 0}, {12, 12, 12, 0}, {6, 15, 12, 0}}, new int[][]{{6, 6, 6, 3}, {12, 9, 9, 6}, {6, 12, 9, 6}}, new int[][]{{8, 8, 5, 0}, {15, 12, 9, 0}, {6, 18, 9, 0}}};
    }

    class c {
        public int[] var_int_arr_a;
        public int[] b;
        final /* synthetic */ bwy var_bwy_a;

        public c(bwy bwy2, int[] nArray, int[] nArray2) {
            this.var_bwy_a = bwy2;
            this.var_int_arr_a = nArray;
            this.b = nArray2;
        }
    }

    static class f {
        public int[] var_int_arr_a = new int[23];
        public int[][] var_int_arr_arr_a = new int[3][13];
    }

    static class a {
        public int var_int_a = 0;
        public int b = 0;
        public e[] var_bwy$e_arr_a = new e[2];

        public a() {
            this.var_bwy$e_arr_a[0] = new e();
            this.var_bwy$e_arr_a[1] = new e();
        }
    }

    static class e {
        public int[] var_int_arr_a = new int[4];
        public d[] var_bwy$d_arr_a = new d[2];

        public e() {
            this.var_bwy$d_arr_a[0] = new d();
            this.var_bwy$d_arr_a[1] = new d();
        }
    }

    static class d {
        public int var_int_a = 0;
        public int var_int_b = 0;
        public int c = 0;
        public int d = 0;
        public int e = 0;
        public int f = 0;
        public int g = 0;
        public int[] var_int_arr_a = new int[3];
        public int[] var_int_arr_b = new int[3];
        public int h = 0;
        public int i = 0;
        public int j = 0;
        public int k = 0;
        public int l = 0;
    }

    static class b {
        public int[] a;
        public int[] b;

        public b() {
            this.a = new int[23];
            this.b = new int[14];
        }

        public b(int[] nArray, int[] nArray2) {
            this.a = nArray;
            this.b = nArray2;
        }
    }
}

