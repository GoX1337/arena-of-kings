/*
 * Decompiled with CFR 0.152.
 */
class bwk {
    int var_int_a;
    int var_int_b;
    int[] var_int_arr_a;
    int c;
    int d;
    int e;
    int f;
    int g;
    int[] var_int_arr_b;

    bwk() {
    }

    int a(bvj bvj2) {
        int n2;
        int n3;
        if (bvj2.b(24) != 5653314) {
            this.void_a();
            return -1;
        }
        this.var_int_a = bvj2.b(16);
        this.var_int_b = bvj2.b(24);
        if (this.var_int_b == -1) {
            this.void_a();
            return -1;
        }
        switch (bvj2.b(1)) {
            case 0: {
                this.var_int_arr_a = new int[this.var_int_b];
                if (bvj2.b(1) != 0) {
                    for (n3 = 0; n3 < this.var_int_b; ++n3) {
                        if (bvj2.b(1) != 0) {
                            n2 = bvj2.b(5);
                            if (n2 == -1) {
                                this.void_a();
                                return -1;
                            }
                            this.var_int_arr_a[n3] = n2 + 1;
                            continue;
                        }
                        this.var_int_arr_a[n3] = 0;
                    }
                } else {
                    for (n3 = 0; n3 < this.var_int_b; ++n3) {
                        n2 = bvj2.b(5);
                        if (n2 == -1) {
                            this.void_a();
                            return -1;
                        }
                        this.var_int_arr_a[n3] = n2 + 1;
                    }
                }
                break;
            }
            case 1: {
                n2 = bvj2.b(5) + 1;
                this.var_int_arr_a = new int[this.var_int_b];
                n3 = 0;
                while (n3 < this.var_int_b) {
                    int n4 = bvj2.b(bwm.a(this.var_int_b - n3));
                    if (n4 == -1) {
                        this.void_a();
                        return -1;
                    }
                    int n5 = 0;
                    while (n5 < n4) {
                        this.var_int_arr_a[n3] = n2;
                        ++n5;
                        ++n3;
                    }
                    ++n2;
                }
                break;
            }
            default: {
                return -1;
            }
        }
        this.c = bvj2.b(4);
        switch (this.c) {
            case 0: {
                break;
            }
            case 1: 
            case 2: {
                this.d = bvj2.b(32);
                this.e = bvj2.b(32);
                this.f = bvj2.b(4) + 1;
                this.g = bvj2.b(1);
                n2 = 0;
                switch (this.c) {
                    case 1: {
                        n2 = this.int_a();
                        break;
                    }
                    case 2: {
                        n2 = this.var_int_b * this.var_int_a;
                    }
                }
                this.var_int_arr_b = new int[n2];
                for (n3 = 0; n3 < n2; ++n3) {
                    this.var_int_arr_b[n3] = bvj2.b(this.f);
                }
                if (this.var_int_arr_b[n2 - 1] != -1) break;
                this.void_a();
                return -1;
            }
            default: {
                this.void_a();
                return -1;
            }
        }
        return 0;
    }

    private int int_a() {
        int n2 = (int)Math.floor(Math.pow(this.var_int_b, 1.0 / (double)this.var_int_a));
        while (true) {
            int n3 = 1;
            int n4 = 1;
            for (int i2 = 0; i2 < this.var_int_a; ++i2) {
                n3 *= n2;
                n4 *= n2 + 1;
            }
            if (n3 <= this.var_int_b && n4 > this.var_int_b) {
                return n2;
            }
            if (n3 > this.var_int_b) {
                --n2;
                continue;
            }
            ++n2;
        }
    }

    void void_a() {
    }

    float[] float_arr_a() {
        if (this.c == 1 || this.c == 2) {
            float f2 = bwk.a(this.d);
            float f3 = bwk.a(this.e);
            float[] fArray = new float[this.var_int_b * this.var_int_a];
            switch (this.c) {
                case 1: {
                    int n2 = this.int_a();
                    for (int i2 = 0; i2 < this.var_int_b; ++i2) {
                        float f4 = 0.0f;
                        int n3 = 1;
                        for (int i3 = 0; i3 < this.var_int_a; ++i3) {
                            int n4 = i2 / n3 % n2;
                            float f5 = this.var_int_arr_b[n4];
                            f5 = Math.abs(f5) * f3 + f2 + f4;
                            if (this.g != 0) {
                                f4 = f5;
                            }
                            fArray[i2 * this.var_int_a + i3] = f5;
                            n3 *= n2;
                        }
                    }
                    break;
                }
                case 2: {
                    for (int i4 = 0; i4 < this.var_int_b; ++i4) {
                        float f6 = 0.0f;
                        for (int i5 = 0; i5 < this.var_int_a; ++i5) {
                            float f7 = this.var_int_arr_b[i4 * this.var_int_a + i5];
                            f7 = Math.abs(f7) * f3 + f2 + f6;
                            if (this.g != 0) {
                                f6 = f7;
                            }
                            fArray[i4 * this.var_int_a + i5] = f7;
                        }
                    }
                    break;
                }
            }
            return fArray;
        }
        return null;
    }

    static float a(int n2) {
        float f2 = n2 & 0x1FFFFF;
        float f3 = (n2 & 0x7FE00000) >>> 21;
        if ((n2 & Integer.MIN_VALUE) != 0) {
            f2 = -f2;
        }
        return bwk.a(f2, (int)f3 - 20 - 768);
    }

    static float a(float f2, int n2) {
        return (float)((double)f2 * Math.pow(2.0, n2));
    }
}

