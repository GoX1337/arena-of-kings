/*
 * Decompiled with CFR 0.152.
 */
public class bvm {
    byte[] var_byte_arr_a;
    int var_int_a;
    int var_int_b;
    private int j;
    int[] var_int_arr_a;
    long[] var_long_arr_a;
    int c;
    int d;
    int e;
    int f;
    byte[] var_byte_arr_b = new byte[282];
    public int g;
    int h;
    int i;
    long var_long_a;

    public bvm() {
        this.a();
    }

    void a() {
        this.var_int_a = 16384;
        this.var_byte_arr_a = new byte[this.var_int_a];
        this.c = 1024;
        this.var_int_arr_a = new int[this.c];
        this.var_long_arr_a = new long[this.c];
    }

    public void a(int n2) {
        if (this.var_byte_arr_a == null) {
            this.a();
        } else {
            int n3;
            for (n3 = 0; n3 < this.var_byte_arr_a.length; ++n3) {
                this.var_byte_arr_a[n3] = 0;
            }
            for (n3 = 0; n3 < this.var_int_arr_a.length; ++n3) {
                this.var_int_arr_a[n3] = 0;
            }
            for (n3 = 0; n3 < this.var_long_arr_a.length; ++n3) {
                this.var_long_arr_a[n3] = 0L;
            }
        }
        this.h = n2;
    }

    public void b() {
        this.var_byte_arr_a = null;
        this.var_int_arr_a = null;
        this.var_long_arr_a = null;
    }

    void b(int n2) {
        if (this.var_int_a <= this.var_int_b + n2) {
            this.var_int_a += n2 + 1024;
            byte[] byArray = new byte[this.var_int_a];
            System.arraycopy(this.var_byte_arr_a, 0, byArray, 0, this.var_byte_arr_a.length);
            this.var_byte_arr_a = byArray;
        }
    }

    void c(int n2) {
        if (this.c <= this.d + n2) {
            this.c += n2 + 32;
            int[] nArray = new int[this.c];
            System.arraycopy(this.var_int_arr_a, 0, nArray, 0, this.var_int_arr_a.length);
            this.var_int_arr_a = nArray;
            long[] lArray = new long[this.c];
            System.arraycopy(this.var_long_arr_a, 0, lArray, 0, this.var_long_arr_a.length);
            this.var_long_arr_a = lArray;
        }
    }

    public int a(bvk bvk2) {
        int n2;
        if (this.e <= (n2 = this.f++)) {
            return 0;
        }
        if ((this.var_int_arr_a[n2] & 0x400) != 0) {
            ++this.var_long_a;
            return -1;
        }
        int n3 = this.var_int_arr_a[n2] & 0xFF;
        int n4 = 0;
        bvk2.var_byte_arr_a = this.var_byte_arr_a;
        bvk2.var_int_a = this.j;
        bvk2.d = this.var_int_arr_a[n2] & 0x200;
        bvk2.c = this.var_int_arr_a[n2] & 0x100;
        n4 += n3;
        while (n3 == 255) {
            int n5 = this.var_int_arr_a[++n2];
            n3 = n5 & 0xFF;
            if ((n5 & 0x200) != 0) {
                bvk2.d = 512;
            }
            n4 += n3;
        }
        bvk2.var_long_b = this.var_long_a++;
        bvk2.var_long_a = this.var_long_arr_a[n2];
        bvk2.var_int_b = n4;
        this.j += n4;
        this.f = n2 + 1;
        return 1;
    }

    public int a(bvl bvl2) {
        byte[] byArray = bvl2.var_byte_arr_a;
        int n2 = bvl2.var_int_a;
        byte[] byArray2 = bvl2.var_byte_arr_b;
        int n3 = bvl2.c;
        int n4 = bvl2.d;
        int n5 = 0;
        int n6 = bvl2.int_a();
        int n7 = bvl2.b();
        int n8 = bvl2.c();
        int n9 = bvl2.d();
        long l2 = bvl2.long_a();
        int n10 = bvl2.e();
        int n11 = bvl2.f();
        int n12 = byArray[n2 + 26] & 0xFF;
        int n13 = this.f;
        int n14 = this.j;
        if (n14 != 0) {
            this.var_int_b -= n14;
            if (this.var_int_b != 0) {
                System.arraycopy(this.var_byte_arr_a, n14, this.var_byte_arr_a, 0, this.var_int_b);
            }
            this.j = 0;
        }
        if (n13 != 0) {
            if (this.d - n13 != 0) {
                System.arraycopy(this.var_int_arr_a, n13, this.var_int_arr_a, 0, this.d - n13);
                System.arraycopy(this.var_long_arr_a, n13, this.var_long_arr_a, 0, this.d - n13);
            }
            this.d -= n13;
            this.e -= n13;
            this.f = 0;
        }
        if (n10 != this.h) {
            return -1;
        }
        if (n6 > 0) {
            return -1;
        }
        this.c(n12 + 1);
        if (n11 != this.i) {
            for (n13 = this.e; n13 < this.d; ++n13) {
                this.var_int_b -= this.var_int_arr_a[n13] & 0xFF;
            }
            this.d = this.e++;
            if (this.i != -1) {
                this.var_int_arr_a[this.d++] = 1024;
            }
            if (n7 != 0) {
                n8 = 0;
                while (n5 < n12) {
                    n14 = byArray[n2 + 27 + n5] & 0xFF;
                    n3 += n14;
                    n4 -= n14;
                    if (n14 < 255) {
                        ++n5;
                        break;
                    }
                    ++n5;
                }
            }
        }
        if (n4 != 0) {
            this.b(n4);
            System.arraycopy(byArray2, n3, this.var_byte_arr_a, this.var_int_b, n4);
            this.var_int_b += n4;
        }
        n13 = -1;
        while (n5 < n12) {
            this.var_int_arr_a[this.d] = n14 = byArray[n2 + 27 + n5] & 0xFF;
            this.var_long_arr_a[this.d] = -1L;
            if (n8 != 0) {
                int n15 = this.d;
                this.var_int_arr_a[n15] = this.var_int_arr_a[n15] | 0x100;
                n8 = 0;
            }
            if (n14 < 255) {
                n13 = this.d;
            }
            ++this.d;
            ++n5;
            if (n14 >= 255) continue;
            this.e = this.d;
        }
        if (n13 != -1) {
            this.var_long_arr_a[n13] = l2;
        }
        if (n9 != 0) {
            this.g = 1;
            if (this.d > 0) {
                int n16 = this.d - 1;
                this.var_int_arr_a[n16] = this.var_int_arr_a[n16] | 0x200;
            }
        }
        this.i = n11 + 1;
        return 0;
    }
}

