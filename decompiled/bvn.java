/*
 * Decompiled with CFR 0.152.
 */
public class bvn {
    public byte[] var_byte_arr_a;
    int var_int_a;
    int var_int_b;
    int c;
    int d;
    int e;
    int f;
    private bvl var_bvl_a = new bvl();
    private byte[] var_byte_arr_b = new byte[4];

    public int int_a() {
        this.var_byte_arr_a = null;
        return 0;
    }

    public int a(int n2) {
        if (this.c != 0) {
            this.var_int_b -= this.c;
            if (this.var_int_b > 0) {
                System.arraycopy(this.var_byte_arr_a, this.c, this.var_byte_arr_a, 0, this.var_int_b);
            }
            this.c = 0;
        }
        if (n2 > this.var_int_a - this.var_int_b) {
            int n3 = n2 + this.var_int_b + 4096;
            if (this.var_byte_arr_a != null) {
                byte[] byArray = new byte[n3];
                System.arraycopy(this.var_byte_arr_a, 0, byArray, 0, this.var_byte_arr_a.length);
                this.var_byte_arr_a = byArray;
            } else {
                this.var_byte_arr_a = new byte[n3];
            }
            this.var_int_a = n3;
        }
        return this.var_int_b;
    }

    public int b(int n2) {
        if (this.var_int_b + n2 > this.var_int_a) {
            return -1;
        }
        this.var_int_b += n2;
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int a(bvl bvl2) {
        int n2 = this.c;
        int n3 = this.var_int_b - this.c;
        if (this.e == 0) {
            if (n3 < 27) {
                return 0;
            }
            if (this.var_byte_arr_a[n2] != 79 || this.var_byte_arr_a[n2 + 1] != 103 || this.var_byte_arr_a[n2 + 2] != 103 || this.var_byte_arr_a[n2 + 3] != 83) {
                this.e = 0;
                this.f = 0;
                int n4 = 0;
                for (int i2 = 0; i2 < n3 - 1; ++i2) {
                    if (this.var_byte_arr_a[n2 + 1 + i2] != 79) continue;
                    n4 = n2 + 1 + i2;
                    break;
                }
                if (n4 == 0) {
                    n4 = this.var_int_b;
                }
                this.c = n4;
                return -(n4 - n2);
            }
            int n5 = (this.var_byte_arr_a[n2 + 26] & 0xFF) + 27;
            if (n3 < n5) {
                return 0;
            }
            for (int i3 = 0; i3 < (this.var_byte_arr_a[n2 + 26] & 0xFF); ++i3) {
                this.f += this.var_byte_arr_a[n2 + 27 + i3] & 0xFF;
            }
            this.e = n5;
        }
        if (this.f + this.e > n3) {
            return 0;
        }
        byte[] byArray = this.var_byte_arr_b;
        synchronized (this.var_byte_arr_b) {
            System.arraycopy(this.var_byte_arr_a, n2 + 22, this.var_byte_arr_b, 0, 4);
            this.var_byte_arr_a[n2 + 22] = 0;
            this.var_byte_arr_a[n2 + 23] = 0;
            this.var_byte_arr_a[n2 + 24] = 0;
            this.var_byte_arr_a[n2 + 25] = 0;
            bvl bvl3 = this.var_bvl_a;
            bvl3.var_byte_arr_a = this.var_byte_arr_a;
            bvl3.var_int_a = n2;
            bvl3.var_int_b = this.e;
            bvl3.var_byte_arr_b = this.var_byte_arr_a;
            bvl3.c = n2 + this.e;
            bvl3.d = this.f;
            bvl3.void_a();
            if (this.var_byte_arr_b[0] != this.var_byte_arr_a[n2 + 22] || this.var_byte_arr_b[1] != this.var_byte_arr_a[n2 + 23] || this.var_byte_arr_b[2] != this.var_byte_arr_a[n2 + 24] || this.var_byte_arr_b[3] != this.var_byte_arr_a[n2 + 25]) {
                System.arraycopy(this.var_byte_arr_b, 0, this.var_byte_arr_a, n2 + 22, 4);
                this.e = 0;
                this.f = 0;
                int n6 = 0;
                for (int i4 = 0; i4 < n3 - 1; ++i4) {
                    if (this.var_byte_arr_a[n2 + 1 + i4] != 79) continue;
                    n6 = n2 + 1 + i4;
                    break;
                }
                if (n6 == 0) {
                    n6 = this.var_int_b;
                }
                this.c = n6;
                // ** MonitorExit[var5_9] (shouldn't be in output)
                return -(n6 - n2);
            }
            // ** MonitorExit[var5_9] (shouldn't be in output)
            n2 = this.c;
            if (bvl2 != null) {
                bvl2.var_byte_arr_a = this.var_byte_arr_a;
                bvl2.var_int_a = n2;
                bvl2.var_int_b = this.e;
                bvl2.var_byte_arr_b = this.var_byte_arr_a;
                bvl2.c = n2 + this.e;
                bvl2.d = this.f;
            }
            this.d = 0;
            n3 = this.e + this.f;
            this.c += n3;
            this.e = 0;
            this.f = 0;
            return n3;
        }
    }

    public int b(bvl bvl2) {
        do {
            int n2;
            if ((n2 = this.a(bvl2)) > 0) {
                return 1;
            }
            if (n2 != 0) continue;
            return 0;
        } while (this.d != 0);
        this.d = 1;
        return -1;
    }

    public void void_a() {
    }
}

