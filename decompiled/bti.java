/*
 * Decompiled with CFR 0.152.
 */
public abstract class bti
extends bte<Object> {
    public bti(Class<?> clazz) {
        super(clazz, false);
    }

    @Override
    public boolean a(bgo bgo2, Object object) {
        return this.a(object).isEmpty();
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2) {
        bcy2.b(this.a(object));
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a(object, bdf.h));
        this.a(object, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }

    public abstract String a(Object var1);
}

