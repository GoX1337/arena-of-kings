/*
 * Decompiled with CFR 0.152.
 */
public final class biw {
    protected final bfn var_bfn_a;
    protected final bms var_bms_a;
    protected final int var_int_a;
    protected final a[] var_biw$a_arr_a;

    protected biw(bfn bfn2, bms bms2, a[] aArray, int n2) {
        this.var_bfn_a = bfn2;
        this.var_bms_a = bms2;
        this.var_biw$a_arr_a = aArray;
        this.var_int_a = n2;
    }

    public static biw a(bfn bfn2, bms bms2, bmx[] bmxArray) {
        int n2 = bms2.int_a();
        a[] aArray = new a[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            bmr bmr2 = bms2.bmr_a(i2);
            bba.a a2 = bfn2.bba$a_a(bmr2);
            aArray[i2] = new a(bmr2, bmxArray == null ? null : bmxArray[i2], a2);
        }
        return new biw(bfn2, bms2, aArray, n2);
    }

    public bms bms_a() {
        return this.var_bms_a;
    }

    public int int_a() {
        return this.var_int_a;
    }

    public bba.a bba$a_a(int n2) {
        return this.var_biw$a_arr_a[n2].var_bba$a_a;
    }

    public bmr bmr_a(int n2) {
        return this.var_biw$a_arr_a[n2].var_bmr_a;
    }

    public bmx bmx_a(int n2) {
        return this.var_biw$a_arr_a[n2].var_bmx_a;
    }

    public bgj bgj_a(int n2) {
        bmx bmx2 = this.var_biw$a_arr_a[n2].var_bmx_a;
        if (bmx2 != null) {
            return bmx2.bgj_a();
        }
        return null;
    }

    public bgj b(int n2) {
        bmx bmx2 = this.var_biw$a_arr_a[n2].var_bmx_a;
        if (bmx2 != null && bmx2.boolean_b()) {
            return bmx2.bgj_a();
        }
        return null;
    }

    public bgj c(int n2) {
        String string = this.var_bfn_a.java_lang_String_a(this.var_biw$a_arr_a[n2].var_bmr_a);
        if (string != null && !string.isEmpty()) {
            return bgj.bgj_a(string);
        }
        return null;
    }

    public int b() {
        int n2 = -1;
        for (int i2 = 0; i2 < this.var_int_a; ++i2) {
            if (this.var_biw$a_arr_a[i2].var_bba$a_a != null) continue;
            if (n2 >= 0) {
                return -1;
            }
            n2 = i2;
        }
        return n2;
    }

    public String toString() {
        return this.var_bms_a.toString();
    }

    public static final class a {
        public final bmr var_bmr_a;
        public final bmx var_bmx_a;
        public final bba.a var_bba$a_a;

        public a(bmr bmr2, bmx bmx2, bba.a a2) {
            this.var_bmr_a = bmr2;
            this.var_bmx_a = bmx2;
            this.var_bba$a_a = a2;
        }
    }
}

