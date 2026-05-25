/*
 * Decompiled with CFR 0.152.
 */
public abstract class bqg<T>
extends bte<T> {
    protected bqg(Class<T> clazz) {
        super(clazz);
    }

    protected bqg(bfw bfw2) {
        super(bfw2);
    }

    protected bqg(Class<?> clazz, boolean bl2) {
        super(clazz, bl2);
    }

    protected bqg(bqg<?> bqg2) {
        super(bqg2.a, false);
    }

    public bqg<?> a(bog bog2) {
        if (bog2 == null) {
            return this;
        }
        return this.b(bog2);
    }

    public abstract boolean a(T var1);

    protected abstract bqg<?> b(bog var1);
}

