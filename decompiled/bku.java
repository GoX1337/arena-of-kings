/*
 * Decompiled with CFR 0.152.
 */
public class bku
extends blc<Object> {
    public static final bku a = new bku();

    public bku() {
        super(Object.class);
    }

    @Override
    public Boolean a(bfr bfr2) {
        return Boolean.FALSE;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2) {
        if (bdc2.boolean_a(bdf.f)) {
            bdf bdf2;
            while ((bdf2 = bdc2.bdf_a()) != null && bdf2 != bdf.var_bdf_c) {
                bdc2.bdc_a();
            }
        } else {
            bdc2.bdc_a();
        }
        return null;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        switch (bdc2.int_a()) {
            case 1: 
            case 3: 
            case 5: {
                return boc2.d(bdc2, bfs2);
            }
        }
        return null;
    }
}

