/*
 * Decompiled with CFR 0.152.
 */
final class bwo {
    private int var_int_a = 0;
    private int b = 0;
    private int c = 0;
    private final int[] var_int_arr_a = new int[32768];

    bwo() {
    }

    public int a() {
        return this.b;
    }

    public int int_a(int n2) {
        this.b += n2;
        int n3 = 0;
        int n4 = this.c;
        if (n4 + n2 < 32768) {
            while (n2-- > 0) {
                n3 <<= 1;
                n3 |= this.var_int_arr_a[n4++] != 0 ? 1 : 0;
            }
        } else {
            while (n2-- > 0) {
                n3 <<= 1;
                n3 |= this.var_int_arr_a[n4] != 0 ? 1 : 0;
                n4 = n4 + 1 & Short.MAX_VALUE;
            }
        }
        this.c = n4;
        return n3;
    }

    public int b() {
        ++this.b;
        int n2 = this.var_int_arr_a[this.c];
        this.c = this.c + 1 & Short.MAX_VALUE;
        return n2;
    }

    public void void_a(int n2) {
        int n3 = this.var_int_a;
        this.var_int_arr_a[n3++] = n2 & 0x80;
        this.var_int_arr_a[n3++] = n2 & 0x40;
        this.var_int_arr_a[n3++] = n2 & 0x20;
        this.var_int_arr_a[n3++] = n2 & 0x10;
        this.var_int_arr_a[n3++] = n2 & 8;
        this.var_int_arr_a[n3++] = n2 & 4;
        this.var_int_arr_a[n3++] = n2 & 2;
        this.var_int_arr_a[n3++] = n2 & 1;
        this.var_int_a = n3 == 32768 ? 0 : n3;
    }

    public void b(int n2) {
        this.b -= n2;
        this.c -= n2;
        if (this.c < 0) {
            this.c += 32768;
        }
    }

    public void c(int n2) {
        int n3 = n2 << 3;
        this.b -= n3;
        this.c -= n3;
        if (this.c < 0) {
            this.c += 32768;
        }
    }
}

