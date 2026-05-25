/*
 * Decompiled with CFR 0.152.
 */
public class bvo {
    float[][] var_float_arr_arr_a = new float[0][];
    bvj var_bvj_a = new bvj();
    int var_int_a;
    int var_int_b;
    int c;
    int d;
    int e;
    int f;
    long var_long_a;
    long var_long_b;
    bvs var_bvs_a;
    int g;
    int h;
    int i;
    int j;

    public bvo(bvs bvs2) {
        this.var_bvs_a = bvs2;
        if (bvs2.var_int_a != 0) {
            this.var_bvj_a.void_a();
        }
    }

    public void a(bvs bvs2) {
        this.var_bvs_a = bvs2;
    }

    public int a() {
        if (this.var_bvs_a != null && this.var_bvs_a.var_int_a != 0) {
            this.var_bvj_a.b();
        }
        return 0;
    }

    public int a(bvk bvk2) {
        int n2;
        bvz bvz2 = this.var_bvs_a.var_bvz_a;
        this.var_bvj_a.a(bvk2.var_byte_arr_a, bvk2.var_int_a, bvk2.var_int_b);
        if (this.var_bvj_a.b(1) != 0) {
            return -1;
        }
        int n3 = this.var_bvj_a.b(this.var_bvs_a.var_int_b);
        if (n3 == -1) {
            return -1;
        }
        this.e = n3;
        this.var_int_b = bvz2.var_bwa_arr_a[this.e].a;
        if (this.var_int_b != 0) {
            this.var_int_a = this.var_bvj_a.b(1);
            this.c = this.var_bvj_a.b(1);
            if (this.c == -1) {
                return -1;
            }
        } else {
            this.var_int_a = 0;
            this.c = 0;
        }
        this.var_long_a = bvk2.var_long_a;
        this.var_long_b = bvk2.var_long_b - 3L;
        this.f = bvk2.d;
        this.d = bvz2.var_int_arr_a[this.var_int_b];
        if (this.var_float_arr_arr_a.length < bvz2.var_int_b) {
            this.var_float_arr_arr_a = new float[bvz2.var_int_b][];
        }
        for (n2 = 0; n2 < bvz2.var_int_b; ++n2) {
            if (this.var_float_arr_arr_a[n2] == null || this.var_float_arr_arr_a[n2].length < this.d) {
                this.var_float_arr_arr_a[n2] = new float[this.d];
                continue;
            }
            for (int i2 = 0; i2 < this.d; ++i2) {
                this.var_float_arr_arr_a[n2][i2] = 0.0f;
            }
        }
        n2 = bvz2.var_int_arr_b[bvz2.var_bwa_arr_a[this.e].d];
        return bvw.a[n2].a(this, this.var_bvs_a.var_java_lang_Object_arr_a[this.e]);
    }
}

