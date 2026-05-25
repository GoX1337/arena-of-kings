/*
 * Decompiled with CFR 0.152.
 */
public class brd
extends bcl.c {
    protected final bqb a;

    public brd(bni bni2, bqb bqb2) {
        this(bni2.a(), bqb2);
    }

    protected brd(Class<?> clazz, bqb bqb2) {
        super(clazz);
        this.a = bqb2;
    }

    @Override
    public boolean a(bck<?> bck2) {
        brd brd2;
        if (bck2.getClass() == this.getClass() && (brd2 = (brd)bck2).a() == this.a) {
            return brd2.a == this.a;
        }
        return false;
    }

    @Override
    public Object java_lang_Object_a(Object object) {
        try {
            return this.a.a(object);
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            throw new IllegalStateException("Problem accessing property '" + this.a.java_lang_String_a() + "': " + exception.getMessage(), exception);
        }
    }

    @Override
    public bck<Object> a(Class<?> clazz) {
        return clazz == this.a ? this : new brd(clazz, this.a);
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
        return new bck.a(this.getClass(), (Class<?>)((Object)this.a), object);
    }
}

