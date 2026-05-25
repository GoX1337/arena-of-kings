/*
 * Decompiled with CFR 0.152.
 */
public final class bts
extends btr {
    private bts(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, bfw bfw3, bfw bfw4, Object object, Object object2, boolean bl2) {
        super(clazz, bty2, bfw2, bfwArray, bfw3, bfw4, object, object2, bl2);
    }

    public static bts a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, bfw bfw3, bfw bfw4) {
        return new bts(clazz, bty2, bfw2, bfwArray, bfw3, bfw4, null, null, false);
    }

    @Override
    public bts bts_a(Object object) {
        return new bts(this.a, this.a, this.c, this.a, this.a, this.b, this.a, object, this.a);
    }

    @Override
    public bts bts_b(Object object) {
        return new bts(this.a, this.a, this.c, this.a, this.a, this.b.btp_a(object), this.a, this.b, this.a);
    }

    @Override
    public bts bts_c(Object object) {
        return new bts(this.a, this.a, this.c, this.a, this.a, this.b, object, this.b, this.a);
    }

    @Override
    public bts d(Object object) {
        return new bts(this.a, this.a, this.c, this.a, this.a, this.b.btp_c(object), this.a, this.b, this.a);
    }

    @Override
    public bts bts_a() {
        if (this.a) {
            return this;
        }
        return new bts(this.a, this.a, this.c, this.a, this.a.bfw_a(), this.b.bfw_a(), this.a, this.b, true);
    }

    @Override
    public bfw b(bfw bfw2) {
        if (this.b == bfw2) {
            return this;
        }
        return new bts(this.a, this.a, this.c, this.a, this.a, bfw2, this.a, this.b, this.a);
    }

    @Override
    public bts bts_a(bfw bfw2) {
        if (bfw2 == this.a) {
            return this;
        }
        return new bts(this.a, this.a, this.c, this.a, bfw2, this.b, this.a, this.b, this.a);
    }

    @Override
    public bfw a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        return new bts(clazz, bty2, bfw2, bfwArray, this.a, this.b, this.a, this.b, this.a);
    }

    @Override
    public bts e(Object object) {
        return new bts(this.a, this.a, this.c, this.a, this.a.btp_c(object), this.b, this.a, this.b, this.a);
    }

    @Override
    public String toString() {
        return "[map type; class " + this.a.getName() + ", " + this.a + " -> " + this.b + "]";
    }
}

