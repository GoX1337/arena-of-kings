/*
 * Decompiled with CFR 0.152.
 */
public class btw
extends btx {
    protected btw(Class<?> clazz) {
        this(clazz, bty.bty_a(), null, null);
    }

    protected btw(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        this(clazz, bty2, bfw2, bfwArray, null, null, false);
    }

    protected btw(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, Object object, Object object2, boolean bl2) {
        super(clazz, bty2, bfw2, bfwArray, 0, object, object2, bl2);
    }

    protected btw(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, int n2, Object object, Object object2, boolean bl2) {
        super(clazz, bty2, bfw2, bfwArray, n2, object, object2, bl2);
    }

    public static btw btw_a(Class<?> clazz) {
        return new btw(clazz, null, null, null, null, null, false);
    }

    @Override
    public bfw b(bfw bfw2) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    @Override
    public btw btw_c(Object object) {
        if (this.b == object) {
            return this;
        }
        return new btw(this.a, this.a, this.c, this.a, this.a, object, this.a);
    }

    @Override
    public bfw bfw_b(Object object) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    @Override
    public btw btw_b(Object object) {
        if (object == this.a) {
            return this;
        }
        return new btw(this.a, this.a, this.c, this.a, object, this.b, this.a);
    }

    @Override
    public btw btw_a(Object object) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenValueHandler()");
    }

    @Override
    public btw btw_a() {
        return this.a ? this : new btw(this.a, this.a, this.c, this.a, this.a, this.b, true);
    }

    @Override
    public bfw a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        return null;
    }

    @Override
    protected String java_lang_String_c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.getName());
        int n2 = this.a.int_a();
        if (n2 > 0) {
            stringBuilder.append('<');
            for (int i2 = 0; i2 < n2; ++i2) {
                bfw bfw2 = this.a(i2);
                if (i2 > 0) {
                    stringBuilder.append(',');
                }
                stringBuilder.append((String)bfw2.a());
            }
            stringBuilder.append('>');
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean m() {
        return false;
    }

    @Override
    public boolean boolean_b() {
        return false;
    }

    @Override
    public StringBuilder b(StringBuilder stringBuilder) {
        return btw.a(this.a, stringBuilder, true);
    }

    @Override
    public StringBuilder a(StringBuilder stringBuilder) {
        btw.a(this.a, stringBuilder, false);
        int n2 = this.a.int_a();
        if (n2 > 0) {
            stringBuilder.append('<');
            for (int i2 = 0; i2 < n2; ++i2) {
                stringBuilder = this.a(i2).a(stringBuilder);
            }
            stringBuilder.append('>');
        }
        stringBuilder.append(';');
        return stringBuilder;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("[simple type, class ").append(this.java_lang_String_c()).append(']');
        return stringBuilder.toString();
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
        btw btw2 = (btw)object;
        if (btw2.a != this.a) {
            return false;
        }
        bty bty2 = this.a;
        bty bty3 = btw2.a;
        return bty2.equals(bty3);
    }

    @Override
    public /* synthetic */ bfw d(Object object) {
        return this.btw_a(object);
    }

    @Override
    public /* synthetic */ bfw bfw_c(Object object) {
        return this.bfw_b(object);
    }

    @Override
    public /* synthetic */ bfw bfw_a(Object object) {
        return this.btw_c(object);
    }
}

