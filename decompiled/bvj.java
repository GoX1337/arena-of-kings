/*
 * Decompiled with CFR 0.152.
 */
public class bvj {
    private static final int[] var_int_arr_a;
    int var_int_a = 0;
    byte[] var_byte_arr_a = null;
    int b = 0;
    int c = 0;
    int d = 0;

    public void void_a() {
        this.var_byte_arr_a = new byte[256];
        this.var_int_a = 0;
        this.var_byte_arr_a[0] = 0;
        this.d = 256;
    }

    public void a(byte[] byArray, int n2) {
        int n3 = 0;
        while (n2-- != 0) {
            byArray[n3++] = (byte)this.b(8);
        }
    }

    public void b() {
        this.var_byte_arr_a = null;
    }

    public void a(byte[] byArray, int n2, int n3) {
        this.var_int_a = n2;
        this.var_byte_arr_a = byArray;
        this.c = 0;
        this.b = 0;
        this.d = n3;
    }

    public int int_a(int n2) {
        int n3 = var_int_arr_a[n2];
        if (this.c + 4 >= this.d && this.c + ((n2 += this.b) - 1) / 8 >= this.d) {
            return -1;
        }
        int n4 = (this.var_byte_arr_a[this.var_int_a] & 0xFF) >>> this.b;
        if (n2 > 8) {
            n4 |= (this.var_byte_arr_a[this.var_int_a + 1] & 0xFF) << 8 - this.b;
            if (n2 > 16) {
                n4 |= (this.var_byte_arr_a[this.var_int_a + 2] & 0xFF) << 16 - this.b;
                if (n2 > 24) {
                    n4 |= (this.var_byte_arr_a[this.var_int_a + 3] & 0xFF) << 24 - this.b;
                    if (n2 > 32 && this.b != 0) {
                        n4 |= (this.var_byte_arr_a[this.var_int_a + 4] & 0xFF) << 32 - this.b;
                    }
                }
            }
        }
        return n3 & n4;
    }

    public void void_a(int n2) {
        this.var_int_a += (n2 += this.b) / 8;
        this.c += n2 / 8;
        this.b = n2 & 7;
    }

    public int b(int n2) {
        int n3;
        int n4 = var_int_arr_a[n2];
        n2 += this.b;
        if (this.c + 4 >= this.d) {
            n3 = -1;
            if (this.c + (n2 - 1) / 8 >= this.d) {
                this.var_int_a += n2 / 8;
                this.c += n2 / 8;
                this.b = n2 & 7;
                return n3;
            }
        }
        n3 = (this.var_byte_arr_a[this.var_int_a] & 0xFF) >>> this.b;
        if (n2 > 8) {
            n3 |= (this.var_byte_arr_a[this.var_int_a + 1] & 0xFF) << 8 - this.b;
            if (n2 > 16) {
                n3 |= (this.var_byte_arr_a[this.var_int_a + 2] & 0xFF) << 16 - this.b;
                if (n2 > 24) {
                    n3 |= (this.var_byte_arr_a[this.var_int_a + 3] & 0xFF) << 24 - this.b;
                    if (n2 > 32 && this.b != 0) {
                        n3 |= (this.var_byte_arr_a[this.var_int_a + 4] & 0xFF) << 32 - this.b;
                    }
                }
            }
        }
        this.var_int_a += n2 / 8;
        this.c += n2 / 8;
        this.b = n2 & 7;
        return n3 &= n4;
    }

    public int int_a() {
        if (this.c >= this.d) {
            int n2 = -1;
            ++this.b;
            if (this.b > 7) {
                this.b = 0;
                ++this.var_int_a;
                ++this.c;
            }
            return n2;
        }
        int n3 = this.var_byte_arr_a[this.var_int_a] >> this.b & 1;
        ++this.b;
        if (this.b > 7) {
            this.b = 0;
            ++this.var_int_a;
            ++this.c;
        }
        return n3;
    }

    static {
        var_int_arr_a = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, Short.MAX_VALUE, 65535, 131071, 262143, 524287, 1048575, 0x1FFFFF, 0x3FFFFF, 0x7FFFFF, 0xFFFFFF, 0x1FFFFFF, 0x3FFFFFF, 0x7FFFFFF, 0xFFFFFFF, 0x1FFFFFFF, 0x3FFFFFFF, Integer.MAX_VALUE, -1};
    }
}

