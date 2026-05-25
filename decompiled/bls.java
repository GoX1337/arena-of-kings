/*
 * Decompiled with CFR 0.152.
 */
public class bls
extends blu {
    protected final bgj a;

    protected bls(bfs bfs2, String string, bgj bgj2) {
        super(bfs2.bdc_a(), string);
        this.a = bgj2;
    }

    public static bls a(bfs bfs2, bgj bgj2, bfw bfw2) {
        String string = String.format("Invalid `null` value encountered for property %s", buk.a((Object)bgj2, "<UNKNOWN>"));
        bls bls2 = new bls(bfs2, string, bgj2);
        if (bfw2 != null) {
            bls2.a(bfw2);
        }
        return bls2;
    }
}

