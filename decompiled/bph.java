/*
 * Decompiled with CFR 0.152.
 */
public class bph
extends bpw {
    public static final bph var_bph_a;
    public static final bph b;
    private final boolean var_boolean_a;

    protected bph(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    public static bph bph_a() {
        return var_bph_a;
    }

    public static bph b() {
        return b;
    }

    @Override
    public bdf bdf_a() {
        return this.var_boolean_a ? bdf.k : bdf.l;
    }

    @Override
    public final void a(bcy bcy2, bgo bgo2) {
        bcy2.a(this.var_boolean_a);
    }

    public int hashCode() {
        return this.var_boolean_a ? 3 : 1;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof bph)) {
            return false;
        }
        return this.var_boolean_a == ((bph)object).var_boolean_a;
    }

    static {
        var_bph_a = new bph(true);
        b = new bph(false);
    }
}

