/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class bpo
implements Serializable {
    private final boolean var_boolean_a;
    private static final bpo b = new bpo(false);
    private static final bpo c = new bpo(true);
    public static final bpo var_bpo_a;

    public bpo(boolean bl2) {
        this.var_boolean_a = bl2;
    }

    protected bpo() {
        this(false);
    }

    public bph a(boolean bl2) {
        return bl2 ? bph.bph_a() : bph.b();
    }

    public bpr bpr_a() {
        return bpr.bpr_a();
    }

    public bps a(int n2) {
        return bpm.a(n2);
    }

    public bps a(long l2) {
        return bpq.a(l2);
    }

    public bpw a(BigInteger bigInteger) {
        if (bigInteger == null) {
            return this.bpr_a();
        }
        return bpf.a(bigInteger);
    }

    public bps a(float f2) {
        return bpl.a(f2);
    }

    public bps a(double d2) {
        return bpk.a(d2);
    }

    public bpw a(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return this.bpr_a();
        }
        if (this.var_boolean_a) {
            return bpj.a(bigDecimal);
        }
        return bigDecimal.compareTo(BigDecimal.ZERO) == 0 ? bpj.var_bpj_a : bpj.a(bigDecimal.stripTrailingZeros());
    }

    public bpv a(String string) {
        return bpv.a(string);
    }

    public bpg a(byte[] byArray) {
        return bpg.a(byArray);
    }

    public bpd bpd_a() {
        return new bpd(this);
    }

    public bpt bpt_a() {
        return new bpt(this);
    }

    public bpw a(Object object) {
        return new bpu(object);
    }

    public bpw a(bva bva2) {
        return new bpu(bva2);
    }

    static {
        var_bpo_a = b;
    }
}

