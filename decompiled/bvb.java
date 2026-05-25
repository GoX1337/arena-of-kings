/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bvb
implements Serializable {
    protected transient buq<btm, bgj> a = new buq(20, 200);

    public bgj a(bfw bfw2, bhm<?> bhm2) {
        return this.a((Class<?>)bfw2.a(), bhm2);
    }

    public bgj a(Class<?> clazz, bhm<?> bhm2) {
        bmh bmh2;
        btm btm2 = new btm(clazz);
        bgj bgj2 = this.a.a(btm2);
        if (bgj2 != null) {
            return bgj2;
        }
        bfo bfo2 = bhm2.bfo_a(clazz);
        bfn bfn2 = bhm2.bfn_a();
        bgj2 = bfn2.bgj_a(bmh2 = bfo2.bmh_a());
        if (bgj2 == null || !bgj2.boolean_a()) {
            bgj2 = bgj.bgj_a(clazz.getSimpleName());
        }
        this.a.a(btm2, bgj2);
        return bgj2;
    }
}

