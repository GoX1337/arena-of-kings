/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bjk
implements bil,
Serializable {
    protected final bgj var_bgj_a;
    protected final bfw var_bfw_a;

    protected bjk(bgj bgj2, bfw bfw2) {
        this.var_bgj_a = bgj2;
        this.var_bfw_a = bfw2;
    }

    public static bjk a(bfp bfp2) {
        return bjk.a(bfp2, bfp2.bfw_a());
    }

    public static bjk a(bfp bfp2, bfw bfw2) {
        return new bjk(bfp2.bgj_a(), bfw2);
    }

    public static bjk a(bfw bfw2) {
        return new bjk(null, bfw2);
    }

    @Override
    public Object a(bfs bfs2) {
        throw bls.a(bfs2, this.var_bgj_a, this.var_bfw_a);
    }
}

