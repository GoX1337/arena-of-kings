/*
 * Decompiled with CFR 0.152.
 */
import java.util.EnumSet;

public class bse
extends brr<EnumSet<? extends Enum<?>>> {
    public bse(bfw bfw2) {
        super(EnumSet.class, bfw2, true, null, null);
    }

    public bse(bse bse2, bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        super(bse2, bfp2, bog2, bgb2, bl2);
    }

    public bse a(bog bog2) {
        return this;
    }

    public bse a(bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        return new bse(this, bfp2, bog2, bgb2, bl2);
    }

    @Override
    public boolean a(bgo bgo2, EnumSet<? extends Enum<?>> enumSet) {
        return enumSet.isEmpty();
    }

    @Override
    public boolean a(EnumSet<? extends Enum<?>> enumSet) {
        return enumSet.size() == 1;
    }

    @Override
    public final void a(EnumSet<? extends Enum<?>> enumSet, bcy bcy2, bgo bgo2) {
        int n2 = enumSet.size();
        if (n2 == 1 && (this.a == null && bgo2.a(bgn.t) || this.a == Boolean.TRUE)) {
            this.b(enumSet, bcy2, bgo2);
            return;
        }
        bcy2.a(enumSet, n2);
        this.b(enumSet, bcy2, bgo2);
        bcy2.void_b();
    }

    @Override
    public void b(EnumSet<? extends Enum<?>> enumSet, bcy bcy2, bgo bgo2) {
        bgb<Object> bgb2 = this.a;
        for (Enum enum_ : enumSet) {
            if (bgb2 == null) {
                bgb2 = bgo2.c(enum_.getDeclaringClass(), this.a);
            }
            bgb2.a(enum_, bcy2, bgo2);
        }
    }

    @Override
    public /* synthetic */ bqg b(bog bog2) {
        return this.a(bog2);
    }
}

