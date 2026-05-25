/*
 * Decompiled with CFR 0.152.
 */
public class bst<T>
extends bte<T> {
    public bst(Class<?> clazz) {
        super(clazz, false);
    }

    @Override
    public void a(T t2, bcy bcy2, bgo bgo2) {
        bcy2.d(t2.toString());
    }

    @Override
    public void a(T t2, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a(t2, bdf.g));
        this.a(t2, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }
}

