/*
 * Decompiled with CFR 0.152.
 */
@bgp
public class bsw
extends bte<bga> {
    public static final bsw a = new bsw();

    protected bsw() {
        super(bga.class);
    }

    @Override
    public boolean a(bgo bgo2, bga bga2) {
        if (bga2 instanceof bga.a) {
            return ((bga.a)bga2).a(bgo2);
        }
        return false;
    }

    @Override
    public void a(bga bga2, bcy bcy2, bgo bgo2) {
        bga2.a(bcy2, bgo2);
    }

    @Override
    public final void a(bga bga2, bcy bcy2, bgo bgo2, bog bog2) {
        bga2.a(bcy2, bgo2, bog2);
    }
}

