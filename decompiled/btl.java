/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Array;

public final class btl
extends btx {
    protected final bfw a;
    protected final Object c;

    protected btl(bfw bfw2, bty bty2, Object object, Object object2, Object object3, boolean bl2) {
        super(object.getClass(), bty2, null, null, bfw2.hashCode(), object2, object3, bl2);
        this.a = bfw2;
        this.c = object;
    }

    public static btl a(bfw bfw2, bty bty2) {
        return btl.a(bfw2, bty2, null, null);
    }

    public static btl a(bfw bfw2, bty bty2, Object object, Object object2) {
        Object object3 = Array.newInstance(bfw2.a(), 0);
        return new btl(bfw2, bty2, object3, object, object2, false);
    }

    @Override
    public bfw b(bfw bfw2) {
        Object object = Array.newInstance(bfw2.a(), 0);
        return new btl(bfw2, (bty)((Object)this.a), object, this.a, this.b, (boolean)this.a);
    }

    @Override
    public btl btl_a(Object object) {
        if (object == this.b) {
            return this;
        }
        return new btl(this.a, (bty)((Object)this.a), this.c, this.a, object, (boolean)this.a);
    }

    @Override
    public btl btl_b(Object object) {
        if (object == this.a.b()) {
            return this;
        }
        return new btl(this.a.btp_a(object), (bty)((Object)this.a), this.c, this.a, this.b, (boolean)this.a);
    }

    @Override
    public btl btl_c(Object object) {
        if (object == this.a) {
            return this;
        }
        return new btl(this.a, (bty)((Object)this.a), this.c, object, this.b, (boolean)this.a);
    }

    @Override
    public btl d(Object object) {
        if (object == this.a.a()) {
            return this;
        }
        return new btl(this.a.btp_c(object), (bty)((Object)this.a), this.c, this.a, this.b, (boolean)this.a);
    }

    @Override
    public btl btl_a() {
        if (this.a != false) {
            return this;
        }
        return new btl(this.a.bfw_a(), (bty)((Object)this.a), this.c, this.a, this.b, true);
    }

    @Override
    public bfw a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        return null;
    }

    @Override
    public boolean boolean_f() {
        return true;
    }

    @Override
    public boolean boolean_c() {
        return false;
    }

    @Override
    public boolean boolean_d() {
        return true;
    }

    @Override
    public boolean r() {
        return this.a.r();
    }

    @Override
    public boolean m() {
        return true;
    }

    @Override
    public bfw bfw_c() {
        return this.a;
    }

    @Override
    public boolean s() {
        return super.s() || this.a.s();
    }

    @Override
    public StringBuilder a(StringBuilder stringBuilder) {
        stringBuilder.append('[');
        return this.a.a(stringBuilder);
    }

    @Override
    public StringBuilder b(StringBuilder stringBuilder) {
        stringBuilder.append('[');
        return this.a.b(stringBuilder);
    }

    public Object[] java_lang_Object_arr_a() {
        return (Object[])this.c;
    }

    @Override
    public String toString() {
        return "[array type, component type: " + this.a + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        btl btl2 = (btl)object;
        return this.a.equals(btl2.a);
    }
}

