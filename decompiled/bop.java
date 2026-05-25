/*
 * Decompiled with CFR 0.152.
 */
public class bop
extends boj {
    protected final String a;

    public bop(boe boe2, bfp bfp2, String string) {
        super(boe2, bfp2);
        this.a = string;
    }

    @Override
    public bop a(bfp bfp2) {
        return this.a == bfp2 ? this : new bop((boe)((Object)this.a), bfp2, this.a);
    }

    @Override
    public String java_lang_String_a() {
        return this.a;
    }

    @Override
    public bce.a bce$a_a() {
        return bce.a.var_bce$a_a;
    }
}

