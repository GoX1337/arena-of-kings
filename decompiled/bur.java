/*
 * Decompiled with CFR 0.152.
 */
public final class bur<T> {
    private final T var_T_a;
    private bur<T> var_bur_T__a;

    public bur(T t2, bur<T> bur2) {
        this.var_T_a = t2;
        this.var_T_a = bur2;
    }

    public void a(bur<T> bur2) {
        if (this.var_T_a != null) {
            throw new IllegalStateException();
        }
        this.var_T_a = bur2;
    }

    public bur<T> a() {
        return this.var_T_a;
    }

    public T a() {
        return this.var_T_a;
    }
}

