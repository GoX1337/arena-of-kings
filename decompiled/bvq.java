/*
 * Decompiled with CFR 0.152.
 */
public class bvq {
    private static byte[] b = "vorbis".getBytes();
    private static byte[] c = "Xiphophorus libVorbis I 20000508".getBytes();
    public byte[][] var_byte_arr_arr_a;
    public int[] var_int_arr_a;
    public int var_int_a;
    public byte[] var_byte_arr_a;

    public void a() {
        this.var_byte_arr_arr_a = null;
        this.var_int_a = 0;
        this.var_byte_arr_a = null;
    }

    int a(bvj bvj2) {
        int n2 = bvj2.b(32);
        if (n2 < 0) {
            this.b();
            return -1;
        }
        this.var_byte_arr_a = new byte[n2 + 1];
        bvj2.a(this.var_byte_arr_a, n2);
        this.var_int_a = bvj2.b(32);
        if (this.var_int_a < 0) {
            this.b();
            return -1;
        }
        this.var_byte_arr_arr_a = new byte[this.var_int_a + 1][];
        this.var_int_arr_a = new int[this.var_int_a + 1];
        for (int i2 = 0; i2 < this.var_int_a; ++i2) {
            int n3 = bvj2.b(32);
            if (n3 < 0) {
                this.b();
                return -1;
            }
            this.var_int_arr_a[i2] = n3;
            this.var_byte_arr_arr_a[i2] = new byte[n3 + 1];
            bvj2.a(this.var_byte_arr_arr_a[i2], n3);
        }
        if (bvj2.b(1) != 1) {
            this.b();
            return -1;
        }
        return 0;
    }

    void b() {
        for (int i2 = 0; i2 < this.var_int_a; ++i2) {
            this.var_byte_arr_arr_a[i2] = null;
        }
        this.var_byte_arr_arr_a = null;
        this.var_byte_arr_a = null;
    }

    public String toString() {
        String string = "Vendor: " + new String(this.var_byte_arr_a, 0, this.var_byte_arr_a.length - 1);
        for (int i2 = 0; i2 < this.var_int_a; ++i2) {
            string = string + "\nComment: " + new String(this.var_byte_arr_arr_a[i2], 0, this.var_byte_arr_arr_a[i2].length - 1);
        }
        string = string + "\n";
        return string;
    }
}

