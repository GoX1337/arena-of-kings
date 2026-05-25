/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public final class bgm
extends bhn<bgn, bgm>
implements Serializable {
    protected static final bdh var_bdh_a;
    private static final int g;
    protected final bqj var_bqj_a;
    protected final bdh var_bdh_b;
    protected final int var_int_a;
    protected final int var_int_b;
    protected final int c;
    protected final int d;
    protected final int e;

    public bgm(bgz bgz2, bob bob2, bnr bnr2, bvb bvb2, bhh bhh2) {
        super(bgz2, bob2, bnr2, bvb2, bhh2);
        this.var_int_a = g;
        this.var_bqj_a = null;
        this.var_bdh_b = var_bdh_a;
        this.var_int_b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    private bgm(bgm bgm2, int n2, int n3, int n4, int n5, int n6, int n7) {
        super(bgm2, n2);
        this.var_int_a = n3;
        this.var_bqj_a = bgm2.var_bqj_a;
        this.var_bdh_b = bgm2.var_bdh_b;
        this.var_int_b = n4;
        this.c = n5;
        this.d = n6;
        this.e = n7;
    }

    @Override
    protected final bgm a(int n2) {
        return new bgm(this, n2, this.var_int_a, this.var_int_b, this.c, this.d, this.e);
    }

    public bdh bdh_a() {
        bdh bdh2 = this.var_bdh_b;
        if (bdh2 instanceof bfa) {
            bdh2 = (bdh)((bfa)((Object)bdh2)).a();
        }
        return bdh2;
    }

    public void a(bcy bcy2) {
        bdh bdh2;
        if (bgn.b.a(this.var_int_a) && bcy2.bdh_a() == null && (bdh2 = this.bdh_a()) != null) {
            bcy2.a(bdh2);
        }
        boolean bl2 = bgn.u.a(this.var_int_a);
        int n2 = this.c;
        if (n2 != 0 || bl2) {
            int n3 = this.var_int_b;
            if (bl2) {
                int n4 = bcy.a.h.b();
                n3 |= n4;
                n2 |= n4;
            }
            bcy2.bcy_a(n3, n2);
        }
        if (this.e != 0) {
            bcy2.bcy_b(this.d, this.e);
        }
    }

    public final boolean a(bgn bgn2) {
        return (this.var_int_a & bgn2.int_a()) != 0;
    }

    public bqj bqj_a() {
        return this.var_bqj_a;
    }

    public bdh b() {
        return this.var_bdh_b;
    }

    public bfo a(bfw bfw2) {
        return this.bmy_a().a(this, bfw2, (bmy.a)this);
    }

    static {
        var_bdh_a = new bez();
        g = bgm.int_a(bgn.class);
    }
}

