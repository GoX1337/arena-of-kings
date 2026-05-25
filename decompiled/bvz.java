/*
 * Decompiled with CFR 0.152.
 */
public class bvz {
    private static byte[] var_byte_arr_a;
    public int var_int_a;
    public int var_int_b;
    public int var_int_c;
    int var_int_d;
    int var_int_e;
    int f;
    int[] var_int_arr_a = new int[2];
    int g;
    int h;
    int i;
    int j;
    int k;
    int l;
    int m;
    bwa[] var_bwa_arr_a = null;
    int[] var_int_arr_b = null;
    Object[] var_java_lang_Object_arr_a = null;
    int[] var_int_arr_c = null;
    Object[] var_java_lang_Object_arr_b = null;
    int[] var_int_arr_d = null;
    Object[] var_java_lang_Object_arr_c = null;
    int[] var_int_arr_e = null;
    Object[] var_java_lang_Object_arr_d = null;
    bwk[] var_bwk_arr_a = null;
    bwg[] var_bwg_arr_a = new bwg[64];

    public void a() {
        this.var_int_c = 0;
    }

    public void b() {
        int n2;
        for (n2 = 0; n2 < this.g; ++n2) {
            this.var_bwa_arr_a[n2] = null;
        }
        this.var_bwa_arr_a = null;
        for (n2 = 0; n2 < this.h; ++n2) {
            bvw.a[this.var_int_arr_b[n2]].a(this.var_java_lang_Object_arr_a[n2]);
        }
        this.var_java_lang_Object_arr_a = null;
        for (n2 = 0; n2 < this.i; ++n2) {
            bvy.a[this.var_int_arr_c[n2]].a(this.var_java_lang_Object_arr_b[n2]);
        }
        this.var_java_lang_Object_arr_b = null;
        for (n2 = 0; n2 < this.j; ++n2) {
            bvv.a[this.var_int_arr_d[n2]].a(this.var_java_lang_Object_arr_c[n2]);
        }
        this.var_java_lang_Object_arr_c = null;
        for (n2 = 0; n2 < this.k; ++n2) {
            bvx.a[this.var_int_arr_e[n2]].a(this.var_java_lang_Object_arr_d[n2]);
        }
        this.var_java_lang_Object_arr_d = null;
        for (n2 = 0; n2 < this.l; ++n2) {
            if (this.var_bwk_arr_a[n2] == null) continue;
            this.var_bwk_arr_a[n2].void_a();
            this.var_bwk_arr_a[n2] = null;
        }
        this.var_bwk_arr_a = null;
        for (n2 = 0; n2 < this.m; ++n2) {
            this.var_bwg_arr_a[n2].a();
        }
    }

    int a(bvj bvj2) {
        this.var_int_a = bvj2.b(32);
        if (this.var_int_a != 0) {
            return -1;
        }
        this.var_int_b = bvj2.b(8);
        this.var_int_c = bvj2.b(32);
        this.var_int_d = bvj2.b(32);
        this.var_int_e = bvj2.b(32);
        this.f = bvj2.b(32);
        this.var_int_arr_a[0] = 1 << bvj2.b(4);
        this.var_int_arr_a[1] = 1 << bvj2.b(4);
        if (this.var_int_c < 1 || this.var_int_b < 1 || this.var_int_arr_a[0] < 8 || this.var_int_arr_a[1] < this.var_int_arr_a[0] || bvj2.b(1) != 1) {
            this.b();
            return -1;
        }
        return 0;
    }

    int b(bvj bvj2) {
        int n2;
        this.l = bvj2.b(8) + 1;
        if (this.var_bwk_arr_a == null || this.var_bwk_arr_a.length != this.l) {
            this.var_bwk_arr_a = new bwk[this.l];
        }
        for (n2 = 0; n2 < this.l; ++n2) {
            this.var_bwk_arr_a[n2] = new bwk();
            if (this.var_bwk_arr_a[n2].a(bvj2) == 0) continue;
            this.b();
            return -1;
        }
        this.i = bvj2.b(6) + 1;
        if (this.var_int_arr_c == null || this.var_int_arr_c.length != this.i) {
            this.var_int_arr_c = new int[this.i];
        }
        if (this.var_java_lang_Object_arr_b == null || this.var_java_lang_Object_arr_b.length != this.i) {
            this.var_java_lang_Object_arr_b = new Object[this.i];
        }
        for (n2 = 0; n2 < this.i; ++n2) {
            this.var_int_arr_c[n2] = bvj2.b(16);
            if (this.var_int_arr_c[n2] < 0 || this.var_int_arr_c[n2] >= 1) {
                this.b();
                return -1;
            }
            this.var_java_lang_Object_arr_b[n2] = bvy.a[this.var_int_arr_c[n2]].a(this, bvj2);
            if (this.var_java_lang_Object_arr_b[n2] != null) continue;
            this.b();
            return -1;
        }
        this.j = bvj2.b(6) + 1;
        if (this.var_int_arr_d == null || this.var_int_arr_d.length != this.j) {
            this.var_int_arr_d = new int[this.j];
        }
        if (this.var_java_lang_Object_arr_c == null || this.var_java_lang_Object_arr_c.length != this.j) {
            this.var_java_lang_Object_arr_c = new Object[this.j];
        }
        for (n2 = 0; n2 < this.j; ++n2) {
            this.var_int_arr_d[n2] = bvj2.b(16);
            if (this.var_int_arr_d[n2] < 0 || this.var_int_arr_d[n2] >= 2) {
                this.b();
                return -1;
            }
            this.var_java_lang_Object_arr_c[n2] = bvv.a[this.var_int_arr_d[n2]].a(this, bvj2);
            if (this.var_java_lang_Object_arr_c[n2] != null) continue;
            this.b();
            return -1;
        }
        this.k = bvj2.b(6) + 1;
        if (this.var_int_arr_e == null || this.var_int_arr_e.length != this.k) {
            this.var_int_arr_e = new int[this.k];
        }
        if (this.var_java_lang_Object_arr_d == null || this.var_java_lang_Object_arr_d.length != this.k) {
            this.var_java_lang_Object_arr_d = new Object[this.k];
        }
        for (n2 = 0; n2 < this.k; ++n2) {
            this.var_int_arr_e[n2] = bvj2.b(16);
            if (this.var_int_arr_e[n2] < 0 || this.var_int_arr_e[n2] >= 3) {
                this.b();
                return -1;
            }
            this.var_java_lang_Object_arr_d[n2] = bvx.a[this.var_int_arr_e[n2]].a(this, bvj2);
            if (this.var_java_lang_Object_arr_d[n2] != null) continue;
            this.b();
            return -1;
        }
        this.h = bvj2.b(6) + 1;
        if (this.var_int_arr_b == null || this.var_int_arr_b.length != this.h) {
            this.var_int_arr_b = new int[this.h];
        }
        if (this.var_java_lang_Object_arr_a == null || this.var_java_lang_Object_arr_a.length != this.h) {
            this.var_java_lang_Object_arr_a = new Object[this.h];
        }
        for (n2 = 0; n2 < this.h; ++n2) {
            this.var_int_arr_b[n2] = bvj2.b(16);
            if (this.var_int_arr_b[n2] < 0 || this.var_int_arr_b[n2] >= 1) {
                this.b();
                return -1;
            }
            this.var_java_lang_Object_arr_a[n2] = bvw.a[this.var_int_arr_b[n2]].a(this, bvj2);
            if (this.var_java_lang_Object_arr_a[n2] != null) continue;
            this.b();
            return -1;
        }
        this.g = bvj2.b(6) + 1;
        if (this.var_bwa_arr_a == null || this.var_bwa_arr_a.length != this.g) {
            this.var_bwa_arr_a = new bwa[this.g];
        }
        for (n2 = 0; n2 < this.g; ++n2) {
            this.var_bwa_arr_a[n2] = new bwa();
            this.var_bwa_arr_a[n2].a = bvj2.b(1);
            this.var_bwa_arr_a[n2].b = bvj2.b(16);
            this.var_bwa_arr_a[n2].c = bvj2.b(16);
            this.var_bwa_arr_a[n2].d = bvj2.b(8);
            if (this.var_bwa_arr_a[n2].b < 1 && this.var_bwa_arr_a[n2].c < 1 && this.var_bwa_arr_a[n2].d < this.h) continue;
            this.b();
            return -1;
        }
        if (bvj2.b(1) != 1) {
            this.b();
            return -1;
        }
        return 0;
    }

    public int a(bvq bvq2, bvk bvk2) {
        bvj bvj2 = new bvj();
        if (bvk2 != null) {
            bvj2.a(bvk2.var_byte_arr_a, bvk2.var_int_a, bvk2.var_int_b);
            byte[] byArray = new byte[6];
            int n2 = bvj2.b(8);
            bvj2.a(byArray, 6);
            if (byArray[0] != 118 || byArray[1] != 111 || byArray[2] != 114 || byArray[3] != 98 || byArray[4] != 105 || byArray[5] != 115) {
                return -1;
            }
            switch (n2) {
                case 1: {
                    if (bvk2.c == 0) {
                        return -1;
                    }
                    if (this.var_int_c != 0) {
                        return -1;
                    }
                    return this.a(bvj2);
                }
                case 3: {
                    if (this.var_int_c == 0) {
                        return -1;
                    }
                    return bvq2.a(bvj2);
                }
                case 5: {
                    if (this.var_int_c == 0 || bvq2.var_byte_arr_a == null) {
                        return -1;
                    }
                    return this.b(bvj2);
                }
            }
        }
        return -1;
    }

    public String toString() {
        return "version:" + new Integer(this.var_int_a) + ", channels:" + new Integer(this.var_int_b) + ", rate:" + new Integer(this.var_int_c) + ", bitrate:" + new Integer(this.var_int_d) + "," + new Integer(this.var_int_e) + "," + new Integer(this.f);
    }

    static {
        var_byte_arr_a = "vorbis".getBytes();
    }
}

