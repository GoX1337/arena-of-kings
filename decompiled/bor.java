/*
 * Decompiled with CFR 0.152.
 */
public class bor
extends bpc {
    public bor(boe boe2, bfp bfp2) {
        super(boe2, bfp2);
    }

    @Override
    public bor a(bfp bfp2) {
        return this.a == bfp2 ? this : new bor(this.a, bfp2);
    }

    @Override
    public bce.a bce$a_a() {
        return bce.a.b;
    }
}

