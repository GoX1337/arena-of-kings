/*
 * Decompiled with CFR 0.152.
 */
public class btu
extends btw {
    protected final bfw a;
    protected final bfw b;

    protected btu(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, bfw bfw3, bfw bfw4, Object object, Object object2, boolean bl2) {
        super(clazz, bty2, bfw2, bfwArray, bfw3.hashCode(), object, object2, bl2);
        this.a = bfw3;
        this.b = bfw4 == null ? this : bfw4;
    }

    public static btu a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, bfw bfw3) {
        return new btu(clazz, bty2, bfw2, bfwArray, bfw3, null, null, null, false);
    }

    @Override
    public bfw b(bfw bfw2) {
        if (this.a == bfw2) {
            return this;
        }
        return new btu((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, bfw2, this.b, this.a, this.b, (boolean)this.a);
    }

    @Override
    public btu btu_a(Object object) {
        if (object == this.b) {
            return this;
        }
        return new btu((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a, this.b, this.a, object, (boolean)this.a);
    }

    @Override
    public btu btu_b(Object object) {
        if (object == this.a.b()) {
            return this;
        }
        return new btu((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a.btp_a(object), this.b, this.a, this.b, (boolean)this.a);
    }

    @Override
    public btu btu_c(Object object) {
        if (object == this.a) {
            return this;
        }
        return new btu((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a, this.b, object, this.b, (boolean)this.a);
    }

    @Override
    public btu d(Object object) {
        if (object == this.a.a()) {
            return this;
        }
        bfw bfw2 = this.a.btp_c(object);
        return new btu((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, bfw2, this.b, this.a, this.b, (boolean)this.a);
    }

    @Override
    public btu btu_a() {
        if (this.a != false) {
            return this;
        }
        return new btu((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a.bfw_a(), this.b, this.a, this.b, true);
    }

    @Override
    public bfw a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        return new btu(clazz, (bty)((Object)this.a), bfw2, bfwArray, this.a, this.b, this.a, this.b, (boolean)this.a);
    }

    @Override
    protected String java_lang_String_c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Class)((Object)this.a)).getName());
        stringBuilder.append('<');
        stringBuilder.append((String)this.a.a());
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    @Override
    public bfw bfw_c() {
        return this.a;
    }

    @Override
    public bfw bfw_d() {
        return this.a;
    }

    @Override
    public boolean boolean_b() {
        return true;
    }

    @Override
    public boolean boolean_a() {
        return true;
    }

    @Override
    public StringBuilder b(StringBuilder stringBuilder) {
        return btu.a(this.a, stringBuilder, true);
    }

    @Override
    public StringBuilder a(StringBuilder stringBuilder) {
        btu.a(this.a, stringBuilder, false);
        stringBuilder.append('<');
        stringBuilder = this.a.a(stringBuilder);
        stringBuilder.append(">;");
        return stringBuilder;
    }

    @Override
    public String toString() {
        return new StringBuilder(40).append("[reference type, class ").append(this.java_lang_String_c()).append('<').append(this.a).append('>').append(']').toString();
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
        btu btu2 = (btu)object;
        if (btu2.a != this.a) {
            return false;
        }
        return this.a.equals(btu2.a);
    }

    @Override
    public /* synthetic */ btw btw_a(Object object) {
        return this.d(object);
    }

    @Override
    public /* synthetic */ btw btw_b(Object object) {
        return this.btu_c(object);
    }

    @Override
    public /* synthetic */ btw btw_c(Object object) {
        return this.btu_a(object);
    }

    @Override
    public /* synthetic */ bet bet_a() {
        return this.bfw_d();
    }
}

