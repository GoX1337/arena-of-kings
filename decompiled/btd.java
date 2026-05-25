/*
 * Decompiled with CFR 0.152.
 */
public abstract class btd<T>
extends bte<T> {
    protected btd(Class<T> clazz) {
        super(clazz);
    }

    protected btd(Class<?> clazz, boolean bl2) {
        super(clazz);
    }

    @Override
    public void a(T t2, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a(t2, bdf.h));
        this.a(t2, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }
}

