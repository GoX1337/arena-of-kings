/*
 * Decompiled with CFR 0.152.
 */
public class bww
implements bwt {
    protected bwp var_bwp_a;
    protected bwu var_bwu_a;
    protected bxb var_bxb_a;
    protected bxb var_bxb_b;
    protected bxa var_bxa_a;
    protected int var_int_a;
    protected int var_int_b;
    protected int c;
    protected a[] var_bww$a_arr_a;
    protected bwr var_bwr_a = new bwr();
    static final float[] var_float_arr_a;

    public void a(bwp bwp2, bwu bwu2, bxb bxb2, bxb bxb3, bxa bxa2, int n2) {
        this.var_bwp_a = bwp2;
        this.var_bwu_a = bwu2;
        this.var_bxb_a = bxb2;
        this.var_bxb_b = bxb3;
        this.var_bxa_a = bxa2;
        this.var_int_a = n2;
    }

    @Override
    public void void_a() {
        this.c = this.var_bwu_a.l();
        this.var_bww$a_arr_a = new a[32];
        this.var_int_b = this.var_bwu_a.f();
        this.b();
        this.c();
        this.d();
        if (this.var_bwr_a != null || this.var_bwu_a.boolean_b()) {
            this.e();
            this.f();
        }
    }

    protected void b() {
        if (this.var_int_b == 3) {
            for (int i2 = 0; i2 < this.c; ++i2) {
                this.var_bww$a_arr_a[i2] = new b(i2);
            }
        } else if (this.var_int_b == 1) {
            int n2;
            for (n2 = 0; n2 < this.var_bwu_a.m(); ++n2) {
                this.var_bww$a_arr_a[n2] = new d(n2);
            }
            while (n2 < this.c) {
                this.var_bww$a_arr_a[n2] = new c(n2);
                ++n2;
            }
        } else {
            for (int i3 = 0; i3 < this.c; ++i3) {
                this.var_bww$a_arr_a[i3] = new d(i3);
            }
        }
    }

    protected void c() {
        for (int i2 = 0; i2 < this.c; ++i2) {
            this.var_bww$a_arr_a[i2].a(this.var_bwp_a, this.var_bwu_a, this.var_bwr_a);
        }
    }

    protected void d() {
    }

    protected void e() {
        for (int i2 = 0; i2 < this.c; ++i2) {
            this.var_bww$a_arr_a[i2].a(this.var_bwp_a, this.var_bwu_a);
        }
    }

    protected void f() {
        boolean bl2 = false;
        boolean bl3 = false;
        int n2 = this.var_bwu_a.f();
        do {
            int n3;
            for (n3 = 0; n3 < this.c; ++n3) {
                bl2 = this.var_bww$a_arr_a[n3].a(this.var_bwp_a);
            }
            do {
                for (n3 = 0; n3 < this.c; ++n3) {
                    bl3 = this.var_bww$a_arr_a[n3].a(this.var_int_a, this.var_bxb_a, this.var_bxb_b);
                }
                this.var_bxb_a.a(this.var_bxa_a);
                if (this.var_int_a != 0 || n2 == 3) continue;
                this.var_bxb_b.a(this.var_bxa_a);
            } while (!bl3);
        } while (!bl2);
    }

    static {
        var_float_arr_a = new float[]{2.0f, 1.587401f, 1.2599211f, 1.0f, 0.7937005f, 0.62996054f, 0.5f, 0.39685026f, 0.31498027f, 0.25f, 0.19842513f, 0.15749013f, 0.125f, 0.099212565f, 0.07874507f, 0.0625f, 0.049606282f, 0.039372534f, 0.03125f, 0.024803141f, 0.019686267f, 0.015625f, 0.012401571f, 0.009843133f, 0.0078125f, 0.0062007853f, 0.0049215667f, 0.00390625f, 0.0031003926f, 0.0024607833f, 0.001953125f, 0.0015501963f, 0.0012303917f, 9.765625E-4f, 7.7509816E-4f, 6.1519584E-4f, 4.8828125E-4f, 3.8754908E-4f, 3.0759792E-4f, 2.4414062E-4f, 1.9377454E-4f, 1.5379896E-4f, 1.2207031E-4f, 9.688727E-5f, 7.689948E-5f, 6.1035156E-5f, 4.8443635E-5f, 3.844974E-5f, 3.0517578E-5f, 2.4221818E-5f, 1.922487E-5f, 1.5258789E-5f, 1.2110909E-5f, 9.612435E-6f, 7.6293945E-6f, 6.0554544E-6f, 4.8062175E-6f, 3.8146973E-6f, 3.0277272E-6f, 2.4031087E-6f, 1.9073486E-6f, 1.5138636E-6f, 1.2015544E-6f, 0.0f};
    }

    static class d
    extends b {
        protected int var_int_e;
        protected float var_float_e;
        protected int var_int_f;
        protected float var_float_f;
        protected float g;
        protected float h;

        public d(int n2) {
            super(n2);
        }

        @Override
        public void a(bwp bwp2, bwu bwu2, bwr bwr2) {
            this.c = bwp2.b(4);
            this.var_int_e = bwp2.b(4);
            if (bwr2 != null) {
                bwr2.a(this.c, 4);
                bwr2.a(this.var_int_e, 4);
            }
            if (this.c != 0) {
                this.d = this.c + 1;
                this.c = a[this.c];
                this.d = b[this.c];
            }
            if (this.var_int_e != 0) {
                this.var_int_f = this.var_int_e + 1;
                this.g = a[this.var_int_e];
                this.h = b[this.var_int_e];
            }
        }

        @Override
        public void a(bwp bwp2, bwu bwu2) {
            if (this.c != 0) {
                this.a = var_float_arr_a[bwp2.b(6)];
            }
            if (this.var_int_e != 0) {
                this.var_float_e = var_float_arr_a[bwp2.b(6)];
            }
        }

        @Override
        public boolean a(bwp bwp2) {
            boolean bl2 = super.a(bwp2);
            if (this.var_int_e != 0) {
                this.var_float_f = bwp2.b(this.var_int_f);
            }
            return bl2;
        }

        @Override
        public boolean a(int n2, bxb bxb2, bxb bxb3) {
            super.a(n2, bxb2, bxb3);
            if (this.var_int_e != 0 && n2 != 1) {
                float f2 = (this.var_float_f * this.g + this.h) * this.var_float_e;
                if (n2 == 0) {
                    bxb3.a(f2, this.a);
                } else {
                    bxb2.a(f2, this.a);
                }
            }
            return true;
        }
    }

    static class c
    extends b {
        protected float e;

        public c(int n2) {
            super(n2);
        }

        @Override
        public void a(bwp bwp2, bwu bwu2, bwr bwr2) {
            super.a(bwp2, bwu2, bwr2);
        }

        @Override
        public void a(bwp bwp2, bwu bwu2) {
            if (this.c != 0) {
                this.a = var_float_arr_a[bwp2.b(6)];
                this.e = var_float_arr_a[bwp2.b(6)];
            }
        }

        @Override
        public boolean a(bwp bwp2) {
            return super.a(bwp2);
        }

        @Override
        public boolean a(int n2, bxb bxb2, bxb bxb3) {
            if (this.c != 0) {
                this.b = this.b * this.c + this.d;
                if (n2 == 0) {
                    float f2 = this.b * this.a;
                    float f3 = this.b * this.e;
                    bxb2.a(f2, this.a);
                    bxb3.a(f3, this.a);
                } else if (n2 == 1) {
                    float f4 = this.b * this.a;
                    bxb2.a(f4, this.a);
                } else {
                    float f5 = this.b * this.e;
                    bxb2.a(f5, this.a);
                }
            }
            return true;
        }
    }

    static class b
    extends a {
        public static final float[] var_float_arr_a;
        public static final float[] var_float_arr_b;
        protected int var_int_a;
        protected int var_int_b;
        protected int var_int_c;
        protected float var_float_a;
        protected int var_int_d;
        protected float var_float_b;
        protected float var_float_c;
        protected float var_float_d;

        public b(int n2) {
            this.var_int_a = n2;
            this.var_int_b = 0;
        }

        @Override
        public void a(bwp bwp2, bwu bwu2, bwr bwr2) {
            this.var_int_c = bwp2.b(4);
            if (this.var_int_c == 15) {
                throw new bws(514, null);
            }
            if (bwr2 != null) {
                bwr2.a(this.var_int_c, 4);
            }
            if (this.var_int_c != 0) {
                this.var_int_d = this.var_int_c + 1;
                this.var_float_c = var_float_arr_a[this.var_int_c];
                this.var_float_d = var_float_arr_b[this.var_int_c];
            }
        }

        @Override
        public void a(bwp bwp2, bwu bwu2) {
            if (this.var_int_c != 0) {
                this.var_float_a = var_float_arr_a[bwp2.b(6)];
            }
        }

        @Override
        public boolean a(bwp bwp2) {
            if (this.var_int_c != 0) {
                this.var_float_b = bwp2.b(this.var_int_d);
            }
            if (++this.var_int_b == 12) {
                this.var_int_b = 0;
                return true;
            }
            return false;
        }

        @Override
        public boolean a(int n2, bxb bxb2, bxb bxb3) {
            if (this.var_int_c != 0 && n2 != 2) {
                float f2 = (this.var_float_b * this.var_float_c + this.var_float_d) * this.var_float_a;
                bxb2.a(f2, this.var_int_a);
            }
            return true;
        }

        static {
            var_float_arr_a = new float[]{0.0f, 0.6666667f, 0.2857143f, 0.13333334f, 0.06451613f, 0.031746034f, 0.015748031f, 0.007843138f, 0.0039138943f, 0.0019550342f, 9.770396E-4f, 4.884005E-4f, 2.4417043E-4f, 1.2207776E-4f, 6.103702E-5f};
            var_float_arr_b = new float[]{0.0f, -0.6666667f, -0.85714287f, -0.93333334f, -0.9677419f, -0.984127f, -0.992126f, -0.99607843f, -0.99804306f, -0.9990225f, -0.9995115f, -0.9997558f, -0.9998779f, -0.99993896f, -0.9999695f};
        }
    }

    static abstract class a {
        a() {
        }

        public abstract void a(bwp var1, bwu var2, bwr var3);

        public abstract void a(bwp var1, bwu var2);

        public abstract boolean a(bwp var1);

        public abstract boolean a(int var1, bxb var2, bxb var3);
    }
}

