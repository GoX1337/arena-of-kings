/*
 * Decompiled with CFR 0.152.
 */
public class bvl {
    private static int[] var_int_arr_a;
    public byte[] var_byte_arr_a;
    public int var_int_a;
    public int var_int_b;
    public byte[] var_byte_arr_b;
    public int c;
    public int d;

    private static int a(int n2) {
        int n3 = n2 << 24;
        for (int i2 = 0; i2 < 8; ++i2) {
            if ((n3 & Integer.MIN_VALUE) != 0) {
                n3 = n3 << 1 ^ 0x4C11DB7;
                continue;
            }
            n3 <<= 1;
        }
        return n3 & 0xFFFFFFFF;
    }

    int int_a() {
        return this.var_byte_arr_a[this.var_int_a + 4] & 0xFF;
    }

    int b() {
        return this.var_byte_arr_a[this.var_int_a + 5] & 1;
    }

    public int c() {
        return this.var_byte_arr_a[this.var_int_a + 5] & 2;
    }

    public int d() {
        return this.var_byte_arr_a[this.var_int_a + 5] & 4;
    }

    public long long_a() {
        long l2 = this.var_byte_arr_a[this.var_int_a + 13] & 0xFF;
        l2 = l2 << 8 | (long)(this.var_byte_arr_a[this.var_int_a + 12] & 0xFF);
        l2 = l2 << 8 | (long)(this.var_byte_arr_a[this.var_int_a + 11] & 0xFF);
        l2 = l2 << 8 | (long)(this.var_byte_arr_a[this.var_int_a + 10] & 0xFF);
        l2 = l2 << 8 | (long)(this.var_byte_arr_a[this.var_int_a + 9] & 0xFF);
        l2 = l2 << 8 | (long)(this.var_byte_arr_a[this.var_int_a + 8] & 0xFF);
        l2 = l2 << 8 | (long)(this.var_byte_arr_a[this.var_int_a + 7] & 0xFF);
        l2 = l2 << 8 | (long)(this.var_byte_arr_a[this.var_int_a + 6] & 0xFF);
        return l2;
    }

    public int e() {
        return this.var_byte_arr_a[this.var_int_a + 14] & 0xFF | (this.var_byte_arr_a[this.var_int_a + 15] & 0xFF) << 8 | (this.var_byte_arr_a[this.var_int_a + 16] & 0xFF) << 16 | (this.var_byte_arr_a[this.var_int_a + 17] & 0xFF) << 24;
    }

    int f() {
        return this.var_byte_arr_a[this.var_int_a + 18] & 0xFF | (this.var_byte_arr_a[this.var_int_a + 19] & 0xFF) << 8 | (this.var_byte_arr_a[this.var_int_a + 20] & 0xFF) << 16 | (this.var_byte_arr_a[this.var_int_a + 21] & 0xFF) << 24;
    }

    void void_a() {
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < this.var_int_b; ++n2) {
            n3 = n3 << 8 ^ var_int_arr_a[n3 >>> 24 & 0xFF ^ this.var_byte_arr_a[this.var_int_a + n2] & 0xFF];
        }
        for (n2 = 0; n2 < this.d; ++n2) {
            n3 = n3 << 8 ^ var_int_arr_a[n3 >>> 24 & 0xFF ^ this.var_byte_arr_b[this.c + n2] & 0xFF];
        }
        this.var_byte_arr_a[this.var_int_a + 22] = (byte)n3;
        this.var_byte_arr_a[this.var_int_a + 23] = (byte)(n3 >>> 8);
        this.var_byte_arr_a[this.var_int_a + 24] = (byte)(n3 >>> 16);
        this.var_byte_arr_a[this.var_int_a + 25] = (byte)(n3 >>> 24);
    }

    static {
        var_int_arr_a = new int[256];
        for (int i2 = 0; i2 < var_int_arr_a.length; ++i2) {
            bvl.var_int_arr_a[i2] = bvl.a(i2);
        }
    }
}

