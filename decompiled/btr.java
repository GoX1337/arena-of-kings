/*
 * Decompiled with CFR 0.152.
 */
public class btr
extends btx {
    protected final bfw a;
    protected final bfw b;

    protected btr(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, bfw bfw3, bfw bfw4, Object object, Object object2, boolean bl2) {
        super(clazz, bty2, bfw2, bfwArray, bfw3.hashCode() ^ bfw4.hashCode(), object, object2, bl2);
        this.a = bfw3;
        this.b = bfw4;
    }

    @Override
    public btr btr_a(bfw bfw2) {
        if (bfw2 == this.a) {
            return this;
        }
        return new btr((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, bfw2, this.b, this.a, this.b, (boolean)this.a);
    }

    @Override
    public bfw b(bfw bfw2) {
        if (this.b == bfw2) {
            return this;
        }
        return new btr((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a, bfw2, this.a, this.b, (boolean)this.a);
    }

    @Override
    public btr btr_a(Object object) {
        return new btr((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a, this.b, this.a, object, (boolean)this.a);
    }

    @Override
    public btr btr_b(Object object) {
        return new btr((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a, this.b.btp_a(object), this.a, this.b, (boolean)this.a);
    }

    @Override
    public btr btr_c(Object object) {
        return new btr((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a, this.b, object, this.b, (boolean)this.a);
    }

    @Override
    public btr d(Object object) {
        return new btr((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a, this.b.btp_c(object), this.a, this.b, (boolean)this.a);
    }

    @Override
    public bfw bfw_a(bfw bfw2) {
        bfw bfw3;
        bfw bfw4;
        bfw bfw5 = super.bfw_a(bfw2);
        bfw bfw6 = bfw2.bfw_b();
        if (bfw5 instanceof btr && bfw6 != null && (bfw4 = this.a.bfw_a(bfw6)) != this.a) {
            bfw5 = ((btr)bfw5).btr_a(bfw4);
        }
        if ((bfw4 = bfw2.bfw_c()) != null && (bfw3 = this.b.bfw_a(bfw4)) != this.b) {
            bfw5 = bfw5.b(bfw3);
        }
        return bfw5;
    }

    @Override
    public btr btr_a() {
        if (this.a != false) {
            return this;
        }
        return new btr((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a, this.b.bfw_a(), this.a, this.b, true);
    }

    @Override
    public bfw a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        return new btr(clazz, bty2, bfw2, bfwArray, this.a, this.b, this.a, this.b, (boolean)this.a);
    }

    @Override
    protected String java_lang_String_c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Class)((Object)this.a)).getName());
        if (this.a != null) {
            stringBuilder.append('<');
            stringBuilder.append((String)this.a.a());
            stringBuilder.append(',');
            stringBuilder.append((String)this.b.a());
            stringBuilder.append('>');
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean m() {
        return true;
    }

    @Override
    public boolean o() {
        return true;
    }

    @Override
    public bfw bfw_b() {
        return this.a;
    }

    @Override
    public bfw bfw_c() {
        return this.b;
    }

    @Override
    public boolean s() {
        return super.s() || this.b.s() || this.a.s();
    }

    @Override
    public StringBuilder b(StringBuilder stringBuilder) {
        return btr.a(this.a, stringBuilder, true);
    }

    @Override
    public StringBuilder a(StringBuilder stringBuilder) {
        btr.a(this.a, stringBuilder, false);
        stringBuilder.append('<');
        this.a.a(stringBuilder);
        this.b.a(stringBuilder);
        stringBuilder.append(">;");
        return stringBuilder;
    }

    public btr e(Object object) {
        return new btr((Class<?>)((Object)this.a), (bty)((Object)this.a), this.c, (bfw[])this.a, this.a.btp_c(object), this.b, this.a, this.b, (boolean)this.a);
    }

    @Override
    public String toString() {
        return String.format("[map-like type; class %s, %s -> %s]", ((Class)((Object)this.a)).getName(), this.a, this.b);
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
        btr btr2 = (btr)object;
        return this.a == btr2.a && this.a.equals(btr2.a) && this.b.equals(btr2.b);
    }
}

