/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Collection;

public final class bfr
extends bhn<bfu, bfr>
implements Serializable {
    private static final int g = bfr.int_a(bfu.class);
    protected final bur<big> var_bur_big__a;
    protected final bpo var_bpo_a;
    protected final bhc var_bhc_a;
    protected final bhi var_bhi_a;
    protected final int var_int_a;
    protected final int b;
    protected final int c;
    protected final int d;
    protected final int e;

    public bfr(bgz bgz2, bob bob2, bnr bnr2, bvb bvb2, bhh bhh2, bhc bhc2) {
        super(bgz2, bob2, bnr2, bvb2, bhh2);
        this.var_int_a = g;
        this.var_bur_big__a = null;
        this.var_bpo_a = bpo.var_bpo_a;
        this.var_bhi_a = null;
        this.var_bhc_a = bhc2;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    private bfr(bfr bfr2, int n2, int n3, int n4, int n5, int n6, int n7) {
        super(bfr2, n2);
        this.var_int_a = n3;
        this.var_bur_big__a = bfr2.var_bur_big__a;
        this.var_bpo_a = bfr2.var_bpo_a;
        this.var_bhc_a = bfr2.var_bhc_a;
        this.var_bhi_a = bfr2.var_bhi_a;
        this.b = n4;
        this.c = n5;
        this.d = n6;
        this.e = n7;
    }

    @Override
    protected final bfr a(int n2) {
        return new bfr(this, n2, this.var_int_a, this.b, this.c, this.d, this.e);
    }

    public bdc a(bdc bdc2) {
        if (this.c != 0) {
            bdc2.bdc_a(this.b, this.c);
        }
        if (this.e != 0) {
            bdc2.bdc_b(this.d, this.e);
        }
        return bdc2;
    }

    public boolean boolean_a() {
        if (this.var_bur_big__a != null) {
            return !((bgj)((Object)this.var_bur_big__a)).c();
        }
        return this.a(bfu.s);
    }

    public final boolean a(bfu bfu2) {
        return (this.var_int_a & bfu2.int_a()) != 0;
    }

    public final int int_a() {
        return this.var_int_a;
    }

    @Override
    public bur<big> a() {
        return this.var_bur_big__a;
    }

    public final bpo bpo_a() {
        return this.var_bpo_a;
    }

    public bhi bhi_a() {
        if (this.var_bhi_a == null) {
            return bhi.var_bhi_a;
        }
        return this.var_bhi_a;
    }

    public bfo bfo_a(bfw bfw2) {
        return this.bmy_a().bfo_b(this, bfw2, this);
    }

    public bfo b(bfw bfw2) {
        return this.bmy_a().bfo_a(this, bfw2, (bmy.a)this);
    }

    public bfo a(bfw bfw2, bfo bfo2) {
        return this.bmy_a().a(this, bfw2, this, bfo2);
    }

    public boc boc_a(bfw bfw2) {
        bfo bfo2 = this.bfo_a((Class<?>)bfw2.a());
        bmh bmh2 = bfo2.bmh_a();
        bof<?> bof2 = this.bfn_a().a(this, bmh2, bfw2);
        Collection<bnz> collection = null;
        if (bof2 == null) {
            bof2 = this.a(bfw2);
            if (bof2 == null) {
                return null;
            }
        } else {
            collection = this.bob_a().b(this, bmh2);
        }
        return bof2.a(this, bfw2, collection);
    }

    public bha a(btq btq2, Class<?> clazz, bhe bhe2) {
        return this.var_bhc_a.a(this, btq2, clazz, bhe2);
    }

    public bha a(btq btq2, Class<?> clazz, bha bha2) {
        return this.var_bhc_a.a(this, btq2, clazz, bha2);
    }
}

