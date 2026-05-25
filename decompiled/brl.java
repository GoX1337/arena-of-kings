/*
 * Decompiled with CFR 0.152.
 */
public class brl
extends bte<Object> {
    public brl() {
        super(Object.class);
    }

    public brl(Class<?> clazz) {
        super(clazz, false);
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2) {
        if (bgo2.a(bgn.c)) {
            this.void_a(bgo2, object);
        }
        bcy2.b(object, 0);
        bcy2.void_d();
    }

    @Override
    public final void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        if (bgo2.a(bgn.c)) {
            this.void_a(bgo2, object);
        }
        beu beu2 = bog2.a(bcy2, bog2.a(object, bdf.var_bdf_b));
        bog2.b(bcy2, beu2);
    }

    @Override
    public boolean boolean_a(bgo bgo2, Object object) {
        return true;
    }

    protected void void_a(bgo bgo2, Object object) {
        bgo2.a(this.a(), String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", object.getClass().getName()));
    }
}

