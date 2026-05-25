/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class de {
    private HashMap<Class<? extends dc>, ArrayList<dc>> cfr_renamed_50 = new HashMap();
    private dd var_dd_a;

    public de() {
    }

    public de(dd dd2) {
        this.var_dd_a = dd2;
        this.a();
    }

    private void a() {
        this.cfr_renamed_50.put(dz.class, new ArrayList());
        this.cfr_renamed_50.put(eb.class, new ArrayList());
        this.cfr_renamed_50.put(ds.class, new ArrayList());
        this.cfr_renamed_50.put(di.class, new ArrayList());
        this.cfr_renamed_50.put(ee.class, new ArrayList());
        this.cfr_renamed_50.put(dj.class, new ArrayList());
        this.cfr_renamed_50.put(dv.class, new ArrayList());
        this.cfr_renamed_50.put(dn.class, new ArrayList());
        this.cfr_renamed_50.put(dp.class, new ArrayList());
        this.cfr_renamed_50.put(dw.class, new ArrayList());
        this.cfr_renamed_50.put(ea.class, new ArrayList());
        this.cfr_renamed_50.put(ec.class, new ArrayList());
        this.cfr_renamed_50.put(dm.class, new ArrayList());
        this.cfr_renamed_50.put(dl.class, new ArrayList());
        this.cfr_renamed_50.put(dk.class, new ArrayList());
        this.cfr_renamed_50.put(du.class, new ArrayList());
        this.cfr_renamed_50.put(dt.class, new ArrayList());
        this.cfr_renamed_50.put(_do.class, new ArrayList());
        this.cfr_renamed_50.put(ed.class, new ArrayList());
        this.cfr_renamed_50.put(dq.class, new ArrayList());
        this.cfr_renamed_50.put(dy.class, new ArrayList());
        this.cfr_renamed_50.put(dx.class, new ArrayList());
        this.cfr_renamed_50.put(dr.class, new ArrayList());
    }

    public double a(Class<? extends dc> clazz) {
        switch (this.var_dd_a) {
            case var_dd_a: {
                float f2 = 0.0f;
                for (dc dc2 : this.cfr_renamed_50.get(clazz)) {
                    f2 = (float)((double)f2 + dc2.double_b());
                }
                return f2;
            }
            case b: {
                float f3 = 1.0f;
                for (dc dc3 : this.cfr_renamed_50.get(clazz)) {
                    f3 = (float)((double)f3 * dc3.double_b());
                }
                return f3;
            }
        }
        System.out.println("PROBLEM");
        return 0.0;
    }
}

