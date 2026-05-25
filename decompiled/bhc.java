/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Map;

public class bhc
implements Serializable {
    private static final int var_int_a;
    protected bha var_bha_a;
    protected final bho var_bho_a;
    protected bho[] var_bho_arr_a;
    protected Map<Class<?>, bho> cfr_renamed_12;

    public bhc() {
        this(bha.b, new bho(), null, null);
    }

    protected bhc(bha bha2, bho bho2, bho[] bhoArray, Map<Class<?>, bho> map) {
        this.var_bho_a = bho2;
        this.var_bha_a = bha2;
        this.var_bho_arr_a = bhoArray;
        this.var_int_a = (int)map;
    }

    public bha a(bfr bfr2, btq btq2, Class<?> clazz, bhe bhe2) {
        boolean bl2;
        bha bha2;
        Object object;
        if (this.var_int_a != null && clazz != null && (object = (bho)this.var_int_a.get(clazz)) != null && (bha2 = object.a(bhe2)) != null) {
            return bha2;
        }
        if (this.var_bho_arr_a != null && btq2 != null && (object = this.var_bho_arr_a[btq2.ordinal()]) != null && (bha2 = object.a(bhe2)) != null) {
            return bha2;
        }
        object = this.var_bho_a.a(bhe2);
        if (object != null) {
            return object;
        }
        switch (bhe2) {
            case h: {
                return bfr2.a(bfu.u) ? bha.c : bha.var_bha_a;
            }
            case d: {
                if (btq2 != btq.f) break;
                return bfr2.a(bfu.v) ? bha.b : bha.var_bha_a;
            }
            case c: {
                if (btq2 != btq.i || !bfr2.a(bfu.g)) break;
                return bha.var_bha_a;
            }
        }
        boolean bl3 = bl2 = btq2 == btq.g || btq2 == btq.f || btq2 == btq.h || btq2 == btq.l;
        if (bl2 && !bfr2.a(bgd.B)) {
            return bha.var_bha_a;
        }
        if (bhe2 == bhe.j) {
            if (bl2 || bfr2.a(bfu.t)) {
                return bha.c;
            }
            if (btq2 == btq.m) {
                return bha.b;
            }
            return bha.var_bha_a;
        }
        return this.var_bha_a;
    }

    public bha a(bfr bfr2, btq btq2, Class<?> clazz, bha bha2) {
        bho bho2;
        Boolean bl2 = null;
        bha bha3 = null;
        if (this.var_int_a != null && clazz != null && (bho2 = (bho)this.var_int_a.get(clazz)) != null) {
            bl2 = bho2.a();
            bha3 = bho2.a(bhe.j);
        }
        if (this.var_bho_arr_a != null && btq2 != null && (bho2 = this.var_bho_arr_a[btq2.ordinal()]) != null) {
            if (bl2 == null) {
                bl2 = bho2.a();
            }
            if (bha3 == null) {
                bha3 = bho2.a(bhe.j);
            }
        }
        if (bl2 == null) {
            bl2 = this.var_bho_a.a();
        }
        if (bha3 == null) {
            bha3 = this.var_bho_a.a(bhe.j);
        }
        if (!Boolean.TRUE.equals(bl2)) {
            return bha2;
        }
        if (bha3 != null) {
            return bha3;
        }
        return bfr2.a(bfu.t) ? bha.c : bha.var_bha_a;
    }

    static {
        var_int_a = btq.values().length;
    }
}

