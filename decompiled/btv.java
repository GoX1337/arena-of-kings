/*
 * Decompiled with CFR 0.152.
 */
public class btv
extends btx {
    protected bfw a;

    public btv(Class<?> clazz, bty bty2) {
        super(clazz, bty2, null, null, 0, null, null, false);
    }

    public void void_a(bfw bfw2) {
        if (this.a != null) {
            throw new IllegalStateException("Trying to re-set self reference; old value = " + this.a + ", new = " + bfw2);
        }
        this.a = bfw2;
    }

    @Override
    public bfw bfw_e() {
        if (this.a != null) {
            return this.a.bfw_e();
        }
        return super.bfw_e();
    }

    public bfw bfw_f() {
        return this.a;
    }

    @Override
    public bty bty_a() {
        if (this.a != null) {
            return this.a.bty_a();
        }
        return super.bty_a();
    }

    @Override
    public StringBuilder a(StringBuilder stringBuilder) {
        if (this.a != null) {
            return this.a.b(stringBuilder);
        }
        return stringBuilder.append("?");
    }

    @Override
    public StringBuilder b(StringBuilder stringBuilder) {
        if (this.a != null) {
            return this.a.b(stringBuilder);
        }
        return stringBuilder;
    }

    @Override
    public bfw b(bfw bfw2) {
        return this;
    }

    @Override
    public bfw bfw_a(Object object) {
        return this;
    }

    @Override
    public bfw bfw_b(Object object) {
        return this;
    }

    @Override
    public bfw bfw_c(Object object) {
        return this;
    }

    @Override
    public bfw d(Object object) {
        return this;
    }

    @Override
    public bfw bfw_a() {
        return this;
    }

    @Override
    public bfw a(Class<?> clazz, bty bty2, bfw bfw2, bfw[] bfwArray) {
        return null;
    }

    @Override
    public boolean m() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(40).append("[recursive type; ");
        if (this.a == null) {
            stringBuilder.append("UNRESOLVED");
        } else {
            stringBuilder.append(((Class)this.a.a()).getName());
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
        if (object.getClass() == this.getClass()) {
            return false;
        }
        return false;
    }
}

