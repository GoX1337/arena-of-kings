/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class bpg
extends bpw {
    static final bpg var_bpg_a;
    protected final byte[] var_byte_arr_a;

    public bpg(byte[] byArray) {
        this.var_byte_arr_a = byArray;
    }

    public static bpg a(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        if (byArray.length == 0) {
            return var_bpg_a;
        }
        return new bpg(byArray);
    }

    @Override
    public bdf bdf_a() {
        return bdf.g;
    }

    @Override
    public final void a(bcy bcy2, bgo bgo2) {
        bcy2.a(bgo2.bgm_a().bcq_a(), this.var_byte_arr_a, 0, this.var_byte_arr_a.length);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof bpg)) {
            return false;
        }
        return Arrays.equals(((bpg)object).var_byte_arr_a, this.var_byte_arr_a);
    }

    public int hashCode() {
        return this.var_byte_arr_a == null ? -1 : this.var_byte_arr_a.length;
    }

    static {
        var_bpg_a = new bpg(new byte[0]);
    }
}

