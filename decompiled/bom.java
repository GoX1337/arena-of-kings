/*
 * Decompiled with CFR 0.152.
 */
public class bom
extends boi {
    public bom(bfw bfw2, boe boe2, String string, boolean bl2, bfw bfw3) {
        super(bfw2, boe2, string, bl2, bfw3);
    }

    public bom(bom bom2, bfp bfp2) {
        super(bom2, bfp2);
    }

    @Override
    public boc a(bfp bfp2) {
        if (bfp2 == this.a) {
            return this;
        }
        return new bom(this, bfp2);
    }

    @Override
    public bce.a bce$a_a() {
        return bce.a.d;
    }

    @Override
    protected boolean boolean_b() {
        return true;
    }
}

