/*
 * Decompiled with CFR 0.152.
 */
public final class bfd<F extends bfc> {
    protected int a;

    protected bfd(int n2) {
        this.a = n2;
    }

    public static <F extends bfc> bfd<F> a(F[] FArray) {
        if (FArray.length > 31) {
            String string = FArray[0].getClass().getName();
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", string, FArray.length));
        }
        int n2 = 0;
        for (F f2 : FArray) {
            if (!f2.boolean_a()) continue;
            n2 |= f2.b();
        }
        return new bfd<F>(n2);
    }

    public bfd<F> a(F f2) {
        int n2 = this.a | f2.b();
        return n2 == this.a ? this : new bfd<F>(n2);
    }

    public boolean a(F f2) {
        return (f2.b() & this.a) != 0;
    }
}

