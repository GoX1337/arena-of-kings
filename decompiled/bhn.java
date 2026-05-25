/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public abstract class bhn<CFG extends bhf, T extends bhn<CFG, T>>
extends bhm<T>
implements Serializable {
    protected static final bhg var_bhg_a;
    private static final int var_int_a;
    private static final int b;
    protected final bnr var_bnr_a;
    protected final bob var_bob_a;
    protected final bgj var_bgj_a;
    protected final Class<?> var_java_lang_Class____a;
    protected final bhj var_bhj_a;
    protected final bvb var_bvb_a;
    protected final bhh var_bhh_a;

    protected bhn(bgz bgz2, bob bob2, bnr bnr2, bvb bvb2, bhh bhh2) {
        super(bgz2, var_int_a);
        this.var_bnr_a = bnr2;
        this.var_bob_a = bob2;
        this.var_bvb_a = bvb2;
        this.var_bgj_a = null;
        this.var_bhg_a = null;
        this.var_bhj_a = bhj.a();
        this.var_bhh_a = bhh2;
    }

    protected bhn(bhn<CFG, T> bhn2, int n2) {
        super(bhn2, n2);
        this.var_bnr_a = bhn2.var_bnr_a;
        this.var_bob_a = bhn2.var_bob_a;
        this.var_bvb_a = bhn2.var_bvb_a;
        this.var_bgj_a = bhn2.var_bgj_a;
        this.var_bhg_a = bhn2.var_bhg_a;
        this.var_bhj_a = bhn2.var_bhj_a;
        this.var_bhh_a = bhn2.var_bhh_a;
    }

    protected abstract T a(int var1);

    public final T a(bgd ... bgdArray) {
        int n2 = this.f;
        for (bgd bgd2 : bgdArray) {
            n2 |= bgd2.int_a();
        }
        if (n2 == this.f) {
            return (T)this;
        }
        return this.a(n2);
    }

    public final T b(bgd ... bgdArray) {
        int n2 = this.f;
        for (bgd bgd2 : bgdArray) {
            n2 &= ~bgd2.int_a();
        }
        if (n2 == this.f) {
            return (T)this;
        }
        return this.a(n2);
    }

    public final bob bob_a() {
        return this.var_bob_a;
    }

    public final bgj bgj_a() {
        return this.var_bgj_a;
    }

    public final Class<?> a() {
        return this.var_bhg_a;
    }

    public final bhj bhj_a() {
        return this.var_bhj_a;
    }

    @Override
    public final bhg bhg_a(Class<?> clazz) {
        bhg bhg2 = this.var_bhh_a.bhg_a(clazz);
        return bhg2 == null ? var_bhg_a : bhg2;
    }

    public final bbr.b bbr$b_a() {
        return this.var_bhh_a.bbr$b_a();
    }

    @Override
    public final bbr.b bbr$b_a(Class<?> clazz) {
        bbr.b b2 = this.bhg_a(clazz).bbr$b_a();
        bbr.b b3 = this.bbr$b_a();
        if (b3 == null) {
            return b2;
        }
        return b3.a(b2);
    }

    @Override
    public final bbr.b a(Class<?> clazz, Class<?> clazz2) {
        bbr.b b2 = this.bhg_a(clazz2).bbr$b_b();
        bbr.b b3 = this.bbr$b_a(clazz);
        if (b3 == null) {
            return b2;
        }
        return b3.a(b2);
    }

    @Override
    public final bbk.d bbk$d_a(Class<?> clazz) {
        return this.var_bhh_a.bbk$d_a(clazz);
    }

    public final bbp.a bbp$a_a(Class<?> clazz) {
        bbp.a a2;
        bhg bhg2 = this.var_bhh_a.bhg_a(clazz);
        if (bhg2 != null && (a2 = bhg2.bbp$a_a()) != null) {
            return a2;
        }
        return null;
    }

    public final bbp.a bbp$a_a(Class<?> clazz, bmh bmh2) {
        bfn bfn2 = this.bfn_a();
        bbp.a a2 = bfn2 == null ? null : bfn2.bbp$a_a(this, bmh2);
        bbp.a a3 = this.bbp$a_a(clazz);
        return bbp.a.bbp$a_a(a2, a3);
    }

    public final bbs.a bbs$a_a(Class<?> clazz, bmh bmh2) {
        bfn bfn2 = this.bfn_a();
        return bfn2 == null ? null : bfn2.bbs$a_a(this, bmh2);
    }

    public final bnu<?> a() {
        bnu<?> bnu2 = this.var_bhh_a.a();
        if ((this.f & b) != b) {
            if (!this.a(bgd.e)) {
                bnu2 = bnu2.e(bbe.b.e);
            }
            if (!this.a(bgd.f)) {
                bnu2 = bnu2.a(bbe.b.e);
            }
            if (!this.a(bgd.g)) {
                bnu2 = bnu2.b(bbe.b.e);
            }
            if (!this.a(bgd.h)) {
                bnu2 = bnu2.c(bbe.b.e);
            }
            if (!this.a(bgd.d)) {
                bnu2 = bnu2.d(bbe.b.e);
            }
        }
        return bnu2;
    }

    @Override
    public final bnu<?> a(Class<?> clazz, bmh bmh2) {
        bhg bhg2;
        bnu<?> bnu2 = this.a();
        bfn bfn2 = this.bfn_a();
        if (bfn2 != null) {
            bnu2 = bfn2.a(bmh2, bnu2);
        }
        if ((bhg2 = this.var_bhh_a.bhg_a(clazz)) != null) {
            bnu2 = bnu2.a(bhg2.bbe$a_a());
        }
        return bnu2;
    }

    @Override
    public final bcb.a bcb$a_a() {
        return this.var_bhh_a.bcb$a_a();
    }

    @Override
    public Boolean java_lang_Boolean_a() {
        return this.var_bhh_a.java_lang_Boolean_a();
    }

    public Boolean java_lang_Boolean_a(Class<?> clazz) {
        Boolean bl2;
        bhg bhg2 = this.var_bhh_a.bhg_a(clazz);
        if (bhg2 != null && (bl2 = bhg2.java_lang_Boolean_b()) != null) {
            return bl2;
        }
        return this.var_bhh_a.java_lang_Boolean_a();
    }

    public bgj a(bfw bfw2) {
        if (this.var_bgj_a != null) {
            return this.var_bgj_a;
        }
        return this.var_bvb_a.a(bfw2, this);
    }

    public bgj bgj_a(Class<?> clazz) {
        if (this.var_bgj_a != null) {
            return this.var_bgj_a;
        }
        return this.var_bvb_a.a(clazz, this);
    }

    @Override
    public final Class<?> a(Class<?> clazz) {
        return this.var_bnr_a.a(clazz);
    }

    static {
        var_bhg_a = bhg.bhg_a();
        var_int_a = bhn.int_a(bgd.class);
        b = bgd.e.int_a() | bgd.f.int_a() | bgd.g.int_a() | bgd.h.int_a() | bgd.d.int_a();
    }
}

