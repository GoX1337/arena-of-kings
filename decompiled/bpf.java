/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigInteger;

public class bpf
extends bps {
    private static final BigInteger b = BigInteger.valueOf(Integer.MIN_VALUE);
    private static final BigInteger c = BigInteger.valueOf(Integer.MAX_VALUE);
    private static final BigInteger d = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger e = BigInteger.valueOf(Long.MAX_VALUE);
    protected final BigInteger a;

    public bpf(BigInteger bigInteger) {
        this.a = bigInteger;
    }

    public static bpf a(BigInteger bigInteger) {
        return new bpf(bigInteger);
    }

    @Override
    public bdf bdf_a() {
        return bdf.i;
    }

    @Override
    public double double_a() {
        return this.a.doubleValue();
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
        if (!(object instanceof bpf)) {
            return false;
        }
        return ((bpf)object).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

