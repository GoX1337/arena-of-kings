/*
 * Decompiled with CFR 0.152.
 */
public abstract class bgb<T> {
    public bgb<T> a(but but2) {
        return this;
    }

    public abstract void a(T var1, bcy var2, bgo var3);

    public void a(T t2, bcy bcy2, bgo bgo2, bog bog2) {
        Class<Object> clazz = this.a();
        if (clazz == null) {
            clazz = t2.getClass();
        }
        bgo2.a(clazz, String.format("Type id handling not implemented for type %s (by serializer of type %s)", clazz.getName(), this.getClass().getName()));
    }

    public Class<T> a() {
        return null;
    }

    public boolean a(bgo bgo2, T t2) {
        return t2 == null;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public static abstract class a
    extends bgb<Object> {
    }
}

