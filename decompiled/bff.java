/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class bff
extends bfe {
    protected final bdc[] var_bdc_arr_a;
    protected final boolean var_boolean_a;
    protected int var_int_b;
    protected boolean var_boolean_b;

    protected bff(boolean bl2, bdc[] bdcArray) {
        super(bdcArray[0]);
        this.var_boolean_a = bl2;
        this.var_boolean_b = bl2 && this.var_bdc_arr_a.boolean_b();
        this.var_bdc_arr_a = bdcArray;
        this.var_int_b = 1;
    }

    public static bff a(boolean bl2, bdc bdc2, bdc bdc3) {
        if (!(bdc2 instanceof bff) && !(bdc3 instanceof bff)) {
            return new bff(bl2, new bdc[]{bdc2, bdc3});
        }
        ArrayList<bdc> arrayList = new ArrayList<bdc>();
        if (bdc2 instanceof bff) {
            ((bff)bdc2).a(arrayList);
        } else {
            arrayList.add(bdc2);
        }
        if (bdc3 instanceof bff) {
            ((bff)bdc3).a(arrayList);
        } else {
            arrayList.add(bdc3);
        }
        return new bff(bl2, arrayList.toArray(new bdc[arrayList.size()]));
    }

    protected void a(List<bdc> list) {
        int n2 = this.var_bdc_arr_a.length;
        for (int i2 = this.var_int_b - 1; i2 < n2; ++i2) {
            bdc bdc2 = this.var_bdc_arr_a[i2];
            if (bdc2 instanceof bff) {
                ((bff)bdc2).a(list);
                continue;
            }
            list.add(bdc2);
        }
    }

    @Override
    public void close() {
        do {
            this.var_bdc_arr_a.close();
        } while (this.j());
    }

    @Override
    public bdf bdf_a() {
        if (this.var_bdc_arr_a == null) {
            return null;
        }
        if (this.var_boolean_b) {
            this.var_boolean_b = false;
            return this.var_bdc_arr_a.bdf_c();
        }
        bdf bdf2 = this.var_bdc_arr_a.bdf_a();
        if (bdf2 == null) {
            return this.bdf_e();
        }
        return bdf2;
    }

    @Override
    public bdc bdc_a() {
        if (this.var_bdc_arr_a.bdf_c() != bdf.var_bdf_b && this.var_bdc_arr_a.bdf_c() != bdf.var_bdf_d) {
            return this;
        }
        int n2 = 1;
        while (true) {
            bdf bdf2;
            if ((bdf2 = this.bdf_a()) == null) {
                return this;
            }
            if (bdf2.b()) {
                ++n2;
                continue;
            }
            if (bdf2.c() && --n2 == 0) break;
        }
        return this;
    }

    protected boolean j() {
        if (this.var_int_b < this.var_bdc_arr_a.length) {
            this.var_bdc_arr_a = this.var_bdc_arr_a[this.var_int_b++];
            return true;
        }
        return false;
    }

    protected bdf bdf_e() {
        while (this.var_int_b < this.var_bdc_arr_a.length) {
            this.var_bdc_arr_a = this.var_bdc_arr_a[this.var_int_b++];
            if (this.var_boolean_a && this.var_bdc_arr_a.boolean_b()) {
                return this.var_bdc_arr_a.bdf_d();
            }
            bdf bdf2 = this.var_bdc_arr_a.bdf_a();
            if (bdf2 == null) continue;
            return bdf2;
        }
        return null;
    }
}

