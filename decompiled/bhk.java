/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bhk
implements Serializable {
    protected static final bij[] var_bij_arr_a;
    protected static final bhy[] var_bhy_arr_a;
    protected static final bfm[] var_bfm_arr_a;
    protected static final bis[] var_bis_arr_a;
    protected static final bik[] var_bik_arr_a;
    protected final bij[] var_bij_arr_b;
    protected final bik[] var_bik_arr_b;
    protected final bhy[] var_bhy_arr_b;
    protected final bfm[] var_bfm_arr_b;
    protected final bis[] var_bis_arr_b;

    public bhk() {
        this(null, null, null, null, null);
    }

    protected bhk(bij[] bijArray, bik[] bikArray, bhy[] bhyArray, bfm[] bfmArray, bis[] bisArray) {
        this.var_bij_arr_b = bijArray == null ? var_bij_arr_a : bijArray;
        this.var_bik_arr_b = bikArray == null ? var_bik_arr_a : bikArray;
        this.var_bhy_arr_b = bhyArray == null ? var_bhy_arr_a : bhyArray;
        this.var_bfm_arr_b = bfmArray == null ? var_bfm_arr_a : bfmArray;
        this.var_bis_arr_b = bisArray == null ? var_bis_arr_a : bisArray;
    }

    public boolean a() {
        return this.var_bik_arr_b.length > 0;
    }

    public boolean b() {
        return this.var_bhy_arr_b.length > 0;
    }

    public boolean c() {
        return this.var_bfm_arr_b.length > 0;
    }

    public boolean d() {
        return this.var_bis_arr_b.length > 0;
    }

    public Iterable<bij> a() {
        return new bug<bij>(this.var_bij_arr_b);
    }

    public Iterable<bik> b() {
        return new bug<bik>(this.var_bik_arr_b);
    }

    public Iterable<bhy> c() {
        return new bug<bhy>(this.var_bhy_arr_b);
    }

    public Iterable<bfm> d() {
        return new bug<bfm>(this.var_bfm_arr_b);
    }

    public Iterable<bis> e() {
        return new bug<bis>(this.var_bis_arr_b);
    }

    static {
        var_bij_arr_a = new bij[0];
        var_bhy_arr_a = new bhy[0];
        var_bfm_arr_a = new bfm[0];
        var_bis_arr_a = new bis[0];
        var_bik_arr_a = new bik[]{new blf()};
    }
}

