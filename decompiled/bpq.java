/*
 * Decompiled with CFR 0.152.
 */
public class bpq
extends bps {
    protected final long a;

    public bpq(long l2) {
        this.a = l2;
    }

    public static bpq a(long l2) {
        return new bpq(l2);
    }

    @Override
    public bdf bdf_a() {
        return bdf.i;
    }

    @Override
    public double double_a() {
        return this.a;
    }

    @Override
    public final void a(bcy bcy2, bgo bgo2) {
        bcy2.b(this.a);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof bpq) {
            return ((bpq)object).a == this.a;
        }
        return false;
    }

    public int hashCode() {
        return (int)this.a ^ (int)(this.a >> 32);
    }
}

