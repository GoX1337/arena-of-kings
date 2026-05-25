/*
 * Decompiled with CFR 0.152.
 */
@bgp
public final class btf
extends btd<Object> {
    public btf() {
        super(String.class, false);
    }

    @Override
    public boolean a(bgo bgo2, Object object) {
        String string = (String)object;
        return string.isEmpty();
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2) {
        bcy2.b((String)object);
    }

    @Override
    public final void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        bcy2.b((String)object);
    }
}

