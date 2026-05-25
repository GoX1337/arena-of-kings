/*
 * Decompiled with CFR 0.152.
 */
public class bpl
extends bps {
    protected final float a;

    public bpl(float f2) {
        this.a = f2;
    }

    public static bpl a(float f2) {
        return new bpl(f2);
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
        if (object instanceof bpl) {
            float f2 = ((bpl)object).a;
            return Float.compare(this.a, f2) == 0;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.a);
    }
}

