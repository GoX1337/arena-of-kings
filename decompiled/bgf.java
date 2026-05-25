/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class bgf
extends bdg
implements Serializable {
    protected static final bfn var_bfn_a;
    protected static final bgz var_bgz_a;
    protected final bcw var_bcw_a;
    protected btz var_btz_a;
    protected bfv var_bfv_a;
    protected bob var_bob_a;
    protected final bhh var_bhh_a;
    protected final bhc var_bhc_a;
    protected bnr var_bnr_a;
    protected bgm var_bgm_a;
    protected bqi var_bqi_a;
    protected bqq var_bqq_a;
    protected bfr var_bfr_a;
    protected bif var_bif_a;
    protected final ConcurrentHashMap<bfw, bfx<Object>> cfr_renamed_11;

    public bgf() {
        this(null, null, null);
    }

    public bgf(bcw bcw2) {
        this(bcw2, null, null);
    }

    public bgf(bcw bcw2, bqi bqi2, bif bif2) {
        bnr bnr2;
        this.var_bfn_a = new ConcurrentHashMap(64, 0.6f, 2);
        if (bcw2 == null) {
            this.var_bcw_a = new bge(this);
        } else {
            this.var_bcw_a = bcw2;
            if (bcw2.bdg_a() == null) {
                this.var_bcw_a.a(this);
            }
        }
        this.var_bob_a = new bov();
        bvb bvb2 = new bvb();
        this.var_btz_a = btz.btz_a();
        this.var_bnr_a = bnr2 = new bnr(null);
        bgz bgz2 = var_bgz_a.a(this.bmy_a());
        this.var_bhh_a = new bhh();
        this.var_bhc_a = new bhc();
        this.var_bgm_a = new bgm(bgz2, this.var_bob_a, bnr2, bvb2, this.var_bhh_a);
        this.var_bfr_a = new bfr(bgz2, this.var_bob_a, bnr2, bvb2, this.var_bhh_a, this.var_bhc_a);
        boolean bl2 = this.var_bcw_a.boolean_a();
        if (bl2 ^ this.var_bgm_a.a(bgd.t)) {
            this.a(bgd.t, bl2);
        }
        this.var_bqi_a = bqi2 == null ? new bqi.a() : bqi2;
        this.var_bif_a = bif2 == null ? new bif.a(bhx.var_bhx_a) : bif2;
        this.var_bqq_a = bqe.a;
    }

    protected bmy bmy_a() {
        return new bmw();
    }

    protected bgg a(bfr bfr2, bfw bfw2, Object object, bct bct2, bfv bfv2) {
        return new bgg(this, bfr2, bfw2, object, bct2, bfv2);
    }

    protected bgh bgh_a(bgm bgm2) {
        return new bgh(this, bgm2);
    }

    protected bgh a(bgm bgm2, bfw bfw2, bdh bdh2) {
        return new bgh(this, bgm2, bfw2, bdh2);
    }

    public bgm bgm_a() {
        return this.var_bgm_a;
    }

    public bfr bfr_a() {
        return this.var_bfr_a;
    }

    public bgf a(bco bco2, bbe.b b2) {
        bnu<?> bnu2 = this.var_bhh_a.a();
        bnu2 = bnu2.a(bco2, b2);
        this.var_bhh_a.a(bnu2);
        return this;
    }

    @Override
    public bcw bcw_b() {
        return this.var_bcw_a;
    }

    @Override
    @Deprecated
    public bcw bcw_a() {
        return this.bcw_b();
    }

    public bgf a(bgd bgd2, boolean bl2) {
        this.var_bgm_a = bl2 ? (bgm)this.var_bgm_a.a(new bgd[]{bgd2}) : (bgm)this.var_bgm_a.b(bgd2);
        this.var_bfr_a = bl2 ? (bfr)this.var_bfr_a.a(new bgd[]{bgd2}) : (bfr)this.var_bfr_a.b(bgd2);
        return this;
    }

    @Override
    public void a(bcy bcy2, Object object) {
        this.a("g", (Object)bcy2);
        bgm bgm2 = this.bgm_a();
        if (bgm2.a(bgn.b) && bcy2.bdh_a() == null) {
            bcy2.a(bgm2.bdh_a());
        }
        if (bgm2.a(bgn.h) && object instanceof Closeable) {
            this.a(bcy2, object, bgm2);
        } else {
            this.bqi_a(bgm2).a(bcy2, object);
            if (bgm2.a(bgn.i)) {
                bcy2.flush();
            }
        }
    }

    public <T> T a(File file, Class<T> clazz) {
        this.a("src", (Object)file);
        return (T)this.java_lang_Object_a(this.var_bcw_a.a(file), this.var_btz_a.a((Type)clazz));
    }

    public bgh bgh_a() {
        return this.bgh_a(this.bgm_a());
    }

    public bgh bgh_b() {
        bgm bgm2 = this.bgm_a();
        return this.a(bgm2, null, bgm2.b());
    }

    public bgg a(Class<?> clazz) {
        return this.a(this.bfr_a(), this.var_btz_a.a((Type)clazz), null, null, this.var_bfv_a);
    }

    protected bqi bqi_a(bgm bgm2) {
        return this.var_bqi_a.a(bgm2, this.var_bqq_a);
    }

    private final void a(bcy bcy2, Object object, bgm bgm2) {
        Closeable closeable = (Closeable)object;
        try {
            this.bqi_a(bgm2).a(bcy2, object);
            if (bgm2.a(bgn.i)) {
                bcy2.flush();
            }
        }
        catch (Exception exception) {
            buk.a(null, closeable, exception);
            return;
        }
        closeable.close();
    }

    protected Object java_lang_Object_a(bdc bdc2, bfw bfw2) {
        try (bdc bdc3 = bdc2;){
            Object object;
            bfr bfr2 = this.bfr_a();
            bif bif2 = this.a(bdc3, bfr2);
            bdf bdf2 = this.bdf_a(bdc3, bfw2);
            if (bdf2 == bdf.m) {
                object = this.a(bif2, bfw2).a(bif2);
            } else if (bdf2 == bdf.var_bdf_e || bdf2 == bdf.var_bdf_c) {
                object = null;
            } else {
                object = bif2.a(bdc3, bfw2, this.a(bif2, bfw2), null);
                bif2.void_a();
            }
            if (bfr2.a(bfu.o)) {
                this.a(bdc3, bif2, bfw2);
            }
            Object object2 = object;
            return object2;
        }
    }

    protected bif a(bdc bdc2, bfr bfr2) {
        return this.var_bif_a.a(bfr2, bdc2, this.var_bfv_a);
    }

    protected bdf bdf_a(bdc bdc2, bfw bfw2) {
        this.var_bfr_a.a(bdc2);
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 == null && (bdf2 = bdc2.bdf_a()) == null) {
            throw blu.a(bdc2, bfw2, "No content to map due to end-of-input");
        }
        return bdf2;
    }

    protected final void a(bdc bdc2, bfs bfs2, bfw bfw2) {
        bdf bdf2 = bdc2.bdf_a();
        if (bdf2 != null) {
            Class<?> clazz = buk.a(bfw2);
            bfs2.a(clazz, bdc2, bdf2);
        }
    }

    protected bfx<Object> a(bfs bfs2, bfw bfw2) {
        bfx<Object> bfx2 = (bfx<Object>)((ConcurrentHashMap)((Object)this.var_bfn_a)).get(bfw2);
        if (bfx2 != null) {
            return bfx2;
        }
        bfx2 = bfs2.b(bfw2);
        if (bfx2 == null) {
            return (bfx)bfs2.b(bfw2, "Cannot find a deserializer for type " + bfw2);
        }
        ((ConcurrentHashMap)((Object)this.var_bfn_a)).put(bfw2, bfx2);
        return bfx2;
    }

    protected final void a(String string, Object object) {
        if (object == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", string));
        }
    }

    static {
        var_bfn_a = new bnc();
        var_bgz_a = new bgz(null, var_bfn_a, null, btz.btz_a(), null, bvd.var_bvd_a, null, Locale.getDefault(), null, bcr.a(), bot.a, new bnb.b());
    }
}

