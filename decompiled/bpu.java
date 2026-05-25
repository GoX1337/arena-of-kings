/*
 * Decompiled with CFR 0.152.
 */
public class bpu
extends bpw {
    protected final Object a;

    public bpu(Object object) {
        this.a = object;
    }

    @Override
    public bdf bdf_a() {
        return bdf.g;
    }

    @Override
    public final void a(bcy bcy2, bgo bgo2) {
        if (this.a == null) {
            bgo2.a(bcy2);
        } else if (this.a instanceof bga) {
            ((bga)this.a).a(bcy2, bgo2);
        } else {
            bgo2.a(this.a, bcy2);
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof bpu) {
            return this.a((bpu)object);
        }
        return false;
    }

    protected boolean a(bpu bpu2) {
        if (this.a == null) {
            return bpu2.a == null;
        }
        return this.a.equals(bpu2.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

