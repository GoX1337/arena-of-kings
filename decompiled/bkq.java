/*
 * Decompiled with CFR 0.152.
 */
public class bkq
extends bir.a {
    public bkq() {
        super(bda.class);
    }

    @Override
    public boolean l() {
        return true;
    }

    @Override
    public bio[] bio_arr_a(bfr bfr2) {
        bfw bfw2 = bfr2.bfw_a(Integer.TYPE);
        bfw bfw3 = bfr2.bfw_a(Long.TYPE);
        return new bio[]{bkq.a("sourceRef", bfr2.bfw_a(Object.class), 0), bkq.a("byteOffset", bfw3, 1), bkq.a("charOffset", bfw3, 2), bkq.a("lineNr", bfw2, 3), bkq.a("columnNr", bfw2, 4)};
    }

    private static bid a(String string, bfw bfw2, int n2) {
        return bid.a(bgj.bgj_a(string), bfw2, null, null, null, null, n2, null, bgi.var_bgi_a);
    }

    @Override
    public Object a(bfs bfs2, Object[] objectArray) {
        return new bda(objectArray[0], bkq.long_a(objectArray[1]), bkq.long_a(objectArray[2]), bkq.int_a(objectArray[3]), bkq.int_a(objectArray[4]));
    }

    private static final long long_a(Object object) {
        return object == null ? 0L : ((Number)object).longValue();
    }

    private static final int int_a(Object object) {
        return object == null ? 0 : ((Number)object).intValue();
    }
}

