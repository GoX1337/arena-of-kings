/*
 * Decompiled with CFR 0.152.
 */
public class bon
extends bpc {
    protected final String a;

    public bon(boe boe2, bfp bfp2, String string) {
        super(boe2, bfp2);
        this.a = string;
    }

    @Override
    public bon a(bfp bfp2) {
        return this.a == bfp2 ? this : new bon((boe)((Object)this.a), bfp2, this.a);
    }

    @Override
    public String java_lang_String_a() {
        return this.a;
    }

    @Override
    public bce.a bce$a_a() {
        return bce.a.d;
    }
}

