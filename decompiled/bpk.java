/*
 * Decompiled with CFR 0.152.
 */
public class bpk
extends bps {
    protected final double a;

    public bpk(double d2) {
        this.a = d2;
    }

    public static bpk a(double d2) {
        return new bpk(d2);
    }

    @Override
    public bdf bdf_a() {
        return bdf.j;
    }

    @Override
    public double double_a() {
        return this.a;
    }

    @Override
    public final void a(bcy bcy2, bgo bgo2) {
        bcy2.a(this.a);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof bpk) {
            double d2 = ((bpk)object).a;
            return Double.compare(this.a, d2) == 0;
        }
        return false;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.a);
        return (int)l2 ^ (int)(l2 >> 32);
    }
}

