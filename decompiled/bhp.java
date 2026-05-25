/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public final class bhp
implements Serializable {
    protected static final bqr[] var_bqr_arr_a;
    protected static final bqf[] var_bqf_arr_a;
    protected final bqr[] var_bqr_arr_b;
    protected final bqr[] c;
    protected final bqf[] var_bqf_arr_b;

    public bhp() {
        this(null, null, null);
    }

    protected bhp(bqr[] bqrArray, bqr[] bqrArray2, bqf[] bqfArray) {
        this.var_bqr_arr_b = bqrArray == null ? var_bqr_arr_a : bqrArray;
        this.c = bqrArray2 == null ? var_bqr_arr_a : bqrArray2;
        this.var_bqf_arr_b = bqfArray == null ? var_bqf_arr_a : bqfArray;
    }

    public boolean a() {
        return this.c.length > 0;
    }

    public boolean b() {
        return this.var_bqf_arr_b.length > 0;
    }

    public Iterable<bqr> a() {
        return new bug<bqr>(this.var_bqr_arr_b);
    }

    public Iterable<bqr> b() {
        return new bug<bqr>(this.c);
    }

    public Iterable<bqf> c() {
        return new bug<bqf>(this.var_bqf_arr_b);
    }

    static {
        var_bqr_arr_a = new bqr[0];
        var_bqf_arr_a = new bqf[0];
    }
}

