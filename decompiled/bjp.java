/*
 * Decompiled with CFR 0.152.
 */
public class bjp
extends bcl.c {
    public bjp(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public Object java_lang_Object_a(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public bck<Object> a(Class<?> clazz) {
        return clazz == this.a ? this : new bjp(clazz);
    }

    @Override
    public bck<Object> a(Object object) {
        return this;
    }

    @Override
    public bck.a bck$a_a(Object object) {
        if (object == null) {
            return null;
        }
        return new bck.a(this.getClass(), this.a, object);
    }
}

