/*
 * Decompiled with CFR 0.152.
 */
public class bto
extends btx {
    protected final bfw a;

    protected bto(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, bfw bfw3, Object object, Object object2, boolean bl2) {
        super(clazz, bty2, bfw2, bfwArray, bfw3.hashCode(), object, object2, bl2);
        this.a = bfw3;
    }

    @Override
    public bfw b(bfw bfw2) {
        if (this.a == bfw2) {
            return this;
        }
        return new bto((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, bfw2, (Object)this.a, this.b, (boolean)this.a);
    }

    @Override
    public bto btp_a(Object object) {
        return new bto((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a, (Object)this.a, object, (boolean)this.a);
    }

    @Override
    public bto btp_b(Object object) {
        return new bto((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a.btp_a(object), (Object)this.a, this.b, (boolean)this.a);
    }

    @Override
    public bto btp_c(Object object) {
        return new bto((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a, object, this.b, (boolean)this.a);
    }

    @Override
    public bto d(Object object) {
        return new bto((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a.btp_c(object), (Object)this.a, this.b, (boolean)this.a);
    }

    @Override
    public bfw bfw_a(bfw bfw2) {
        bfw bfw3;
        bfw bfw4 = super.bfw_a(bfw2);
        bfw bfw5 = bfw2.bfw_c();
        if (bfw5 != null && (bfw3 = this.a.bfw_a(bfw5)) != this.a) {
            bfw4 = bfw4.b(bfw3);
        }
        return bfw4;
    }

    @Override
    public bto bto_a() {
        if (this.a != false) {
            return this;
        }
        return new bto((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a.bfw_a(), (Object)this.a, this.b, true);
    }

    @Override
    public bfw a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        return new bto(clazz, bty2, bfw2, bfwArray, this.a, (Object)this.a, this.b, (boolean)this.a);
    }

    @Override
    public boolean m() {
        return true;
    }

    @Override
    public boolean n() {
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
    public StringBuilder b(StringBuilder stringBuilder) {
        return bto.a(this.a, stringBuilder, true);
    }

    @Override
    public StringBuilder a(StringBuilder stringBuilder) {
        bto.a(this.a, stringBuilder, false);
        stringBuilder.append('<');
        this.a.a(stringBuilder);
        stringBuilder.append(">;");
        return stringBuilder;
    }

    @Override
    protected String java_lang_String_c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Class)((Object)this.a)).getName());
        if (this.a != null) {
            stringBuilder.append('<');
            stringBuilder.append((String)this.a.a());
            stringBuilder.append('>');
        }
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
        bto bto2 = (bto)object;
        return this.a == bto2.a && this.a.equals(bto2.a);
    }

    @Override
    public String toString() {
        return "[collection-like type; class " + ((Class)((Object)this.a)).getName() + ", contains " + this.a + "]";
    }
}

