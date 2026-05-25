/*
 * Decompiled with CFR 0.152.
 */
public class bpr
extends bpw {
    public static final bpr a = new bpr();

    protected bpr() {
    }

    public static bpr bpr_a() {
        return a;
    }

    @Override
    public bdf bdf_a() {
        return bdf.m;
    }

    @Override
    public final void a(bcy bcy2, bgo bgo2) {
        bgo2.a(bcy2);
    }

    public boolean equals(Object object) {
        return object == this || object instanceof bpr;
    }

    public int hashCode() {
        return bpp.e.ordinal();
    }
}

