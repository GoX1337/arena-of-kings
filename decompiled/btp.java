/*
 * Decompiled with CFR 0.152.
 */
public final class btp
extends bto {
    private btp(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, bfw bfw3, Object object, Object object2, boolean bl2) {
        super(clazz, bty2, bfw2, bfwArray, bfw3, object, object2, bl2);
    }

    public static btp a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray, bfw bfw3) {
        return new btp(clazz, bty2, bfw2, bfwArray, bfw3, null, null, false);
    }

    @Override
    public bfw b(bfw bfw2) {
        if (this.a == bfw2) {
            return this;
        }
        return new btp(this.a, this.a, this.c, this.a, bfw2, this.a, this.b, this.a);
    }

    @Override
    public btp btp_a(Object object) {
        return new btp(this.a, this.a, this.c, this.a, this.a, this.a, object, this.a);
    }

    @Override
    public btp btp_b(Object object) {
        return new btp(this.a, this.a, this.c, this.a, this.a.btp_a(object), this.a, this.b, this.a);
    }

    @Override
    public btp btp_c(Object object) {
        return new btp(this.a, this.a, this.c, this.a, this.a, object, this.b, this.a);
    }

    @Override
    public btp d(Object object) {
        return new btp(this.a, this.a, this.c, this.a, this.a.btp_c(object), this.a, this.b, this.a);
    }

    @Override
    public btp btp_a() {
        if (this.a) {
            return this;
        }
        return new btp(this.a, this.a, this.c, this.a, this.a.bfw_a(), this.a, this.b, true);
    }

    @Override
    public bfw a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        return new btp(clazz, bty2, bfw2, bfwArray, this.a, this.a, this.b, this.a);
    }

    @Override
    public String toString() {
        return "[collection type; class " + this.a.getName() + ", contains " + this.a + "]";
    }
}

