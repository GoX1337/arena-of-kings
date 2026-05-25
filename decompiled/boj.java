/*
 * Decompiled with CFR 0.152.
 */
public class boj
extends bpc {
    public boj(boe boe2, bfp bfp2) {
        super(boe2, bfp2);
    }

    @Override
    public boj a(bfp bfp2) {
        return this.a == bfp2 ? this : new boj(this.a, bfp2);
    }

    @Override
    public bce.a bce$a_a() {
        return bce.a.c;
    }
}

