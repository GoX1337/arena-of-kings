/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;

public class bpj
extends bps {
    public static final bpj var_bpj_a;
    private static final BigDecimal b;
    private static final BigDecimal c;
    private static final BigDecimal d;
    private static final BigDecimal e;
    protected final BigDecimal var_java_math_BigDecimal_a;

    public bpj(BigDecimal bigDecimal) {
        this.var_java_math_BigDecimal_a = bigDecimal;
    }

    public static bpj a(BigDecimal bigDecimal) {
        return new bpj(bigDecimal);
    }

    @Override
    public bdf bdf_a() {
        return bdf.j;
    }

    @Override
    public double double_a() {
        return this.var_java_math_BigDecimal_a.doubleValue();
    }

    @Override
    public final void a(bcy bcy2, bgo bgo2) {
        bcy2.void_a(this.var_java_math_BigDecimal_a);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof bpj) {
            return ((bpj)object).var_java_math_BigDecimal_a.compareTo(this.var_java_math_BigDecimal_a) == 0;
        }
        return false;
    }

    public int hashCode() {
        return Double.valueOf(this.double_a()).hashCode();
    }

    static {
        var_bpj_a = new bpj(BigDecimal.ZERO);
        b = BigDecimal.valueOf(Integer.MIN_VALUE);
        c = BigDecimal.valueOf(Integer.MAX_VALUE);
        d = BigDecimal.valueOf(Long.MIN_VALUE);
        e = BigDecimal.valueOf(Long.MAX_VALUE);
    }
}

