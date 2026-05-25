/*
 * Decompiled with CFR 0.152.
 */
public class bol
extends bop {
    public bol(boe boe2, bfp bfp2, String string) {
        super(boe2, bfp2, string);
    }

    @Override
    public bol a(bfp bfp2) {
        return this.a == bfp2 ? this : new bol(this.a, bfp2, this.a);
    }

    @Override
    public bce.a bce$a_a() {
        return bce.a.e;
    }
}

