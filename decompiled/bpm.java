/*
 * Decompiled with CFR 0.152.
 */
public class bpm
extends bps {
    private static final bpm[] var_bpm_arr_a;
    protected final int var_int_a;

    public bpm(int n2) {
        this.var_int_a = n2;
    }

    public static bpm a(int n2) {
        if (n2 > 10 || n2 < -1) {
            return new bpm(n2);
        }
        return var_bpm_arr_a[n2 - -1];
    }

    @Override
    public bdf bdf_a() {
        return bdf.i;
    }

    @Override
    public double double_a() {
        return this.var_int_a;
    }

    @Override
    public final void a(bcy bcy2, bgo bgo2) {
        bcy2.void_b(this.var_int_a);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof bpm) {
            return ((bpm)object).var_int_a == this.var_int_a;
        }
        return false;
    }

    public int hashCode() {
        return this.var_int_a;
    }

    static {
        int n2 = 12;
        var_bpm_arr_a = new bpm[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            bpm.var_bpm_arr_a[i2] = new bpm(-1 + i2);
        }
    }
}

