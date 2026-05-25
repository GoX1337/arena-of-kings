/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

public class bgh
implements Serializable {
    protected static final bdh var_bdh_a;
    protected final bgm var_bgm_a;
    protected final bqi var_bqi_a;
    protected final bqq var_bqq_a;
    protected final bcw var_bcw_a;
    protected final a var_bgh$a_a;
    protected final b var_bgh$b_a;

    protected bgh(bgf bgf2, bgm bgm2, bfw bfw2, bdh bdh2) {
        this.var_bgm_a = bgm2;
        this.var_bqi_a = bgf2.var_bqi_a;
        this.var_bqq_a = bgf2.var_bqq_a;
        this.var_bcw_a = bgf2.var_bcw_a;
        a a2 = this.var_bgh$a_a = bdh2 == null ? bgh$a.var_bgh$a_a : new a(bdh2, null, null, null);
        this.var_bgh$b_a = bfw2 == null ? b.var_bgh$b_a : (bfw2.boolean_a(Object.class) ? b.var_bgh$b_a.a(this, bfw2) : b.var_bgh$b_a.a(this, bfw2.bfw_a()));
    }

    protected bgh(bgf bgf2, bgm bgm2) {
        this.var_bgm_a = bgm2;
        this.var_bqi_a = bgf2.var_bqi_a;
        this.var_bqq_a = bgf2.var_bqq_a;
        this.var_bcw_a = bgf2.var_bcw_a;
        this.var_bgh$a_a = bgh$a.var_bgh$a_a;
        this.var_bgh$b_a = b.var_bgh$b_a;
    }

    protected bgh(bgh bgh2, bgm bgm2, a a2, b b2) {
        this.var_bgm_a = bgm2;
        this.var_bqi_a = bgh2.var_bqi_a;
        this.var_bqq_a = bgh2.var_bqq_a;
        this.var_bcw_a = bgh2.var_bcw_a;
        this.var_bgh$a_a = a2;
        this.var_bgh$b_a = b2;
    }

    protected bgh a(a a2, b b2) {
        if (this.var_bgh$a_a == a2 && this.var_bgh$b_a == b2) {
            return this;
        }
        return new bgh(this, this.var_bgm_a, a2, b2);
    }

    public bgh bgh_a() {
        return this.a(this.var_bgm_a.b());
    }

    public bgh a(bdh bdh2) {
        return this.a(this.var_bgh$a_a.a(bdh2), this.var_bgh$b_a);
    }

    public bcy a(Writer writer) {
        this.a("w", (Object)writer);
        return this.a(this.var_bcw_a.a(writer));
    }

    public bcy a(File file, bcv bcv2) {
        this.a("outputFile", (Object)file);
        return this.a(this.var_bcw_a.a(file, bcv2));
    }

    public boolean a(bgn bgn2) {
        return this.var_bgm_a.a(bgn2);
    }

    public void a(File file, Object object) {
        this.a(this.a(file, bcv.var_bcv_a), object);
    }

    public String a(Object object) {
        bed bed2 = new bed(this.var_bcw_a.bev_a());
        try {
            this.a(this.a(bed2), object);
        }
        catch (bdd bdd2) {
            throw bdd2;
        }
        catch (IOException iOException) {
            throw bfy.a(iOException);
        }
        return bed2.a();
    }

    protected bqi bqi_a() {
        return this.var_bqi_a.a(this.var_bgm_a, this.var_bqq_a);
    }

    protected final void a(bcy bcy2, Object object) {
        if (this.var_bgm_a.a(bgn.h) && object instanceof Closeable) {
            this.b(bcy2, object);
            return;
        }
        try {
            this.var_bgh$b_a.a(bcy2, object, this.bqi_a());
        }
        catch (Exception exception) {
            buk.a(bcy2, exception);
            return;
        }
        bcy2.close();
    }

    private final void b(bcy bcy2, Object object) {
        Closeable closeable = (Closeable)object;
        try {
            this.var_bgh$b_a.a(bcy2, object, this.bqi_a());
            Closeable closeable2 = closeable;
            closeable = null;
            closeable2.close();
        }
        catch (Exception exception) {
            buk.a(bcy2, closeable, exception);
            return;
        }
        bcy2.close();
    }

    protected final bcy a(bcy bcy2) {
        this.var_bgm_a.a(bcy2);
        this.var_bgh$a_a.a(bcy2);
        return bcy2;
    }

    protected final void a(String string, Object object) {
        if (object == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", string));
        }
    }

    static {
        var_bdh_a = new bfg();
    }

    public static final class b
    implements Serializable {
        public static final b var_bgh$b_a;
        private final bfw var_bfw_a;
        private final bgb<Object> var_bgb_java_lang_Object__a;
        private final bog var_bog_a;

        private b(bfw bfw2, bgb<Object> bgb2, bog bog2) {
            this.var_bfw_a = bfw2;
            this.var_bgh$b_a = bgb2;
            this.var_bog_a = bog2;
        }

        public b a(bgh bgh2, bfw bfw2) {
            if (bfw2 == null) {
                if (this.var_bfw_a == null || this.var_bgh$b_a == null) {
                    return this;
                }
                return new b(null, null, null);
            }
            if (bfw2.equals(this.var_bfw_a)) {
                return this;
            }
            if (bfw2.p()) {
                bog bog2;
                bqi bqi2 = bgh2.bqi_a();
                try {
                    bog2 = bqi2.a(bfw2);
                }
                catch (bfy bfy2) {
                    throw new bgl(bfy2);
                }
                return new b(null, null, bog2);
            }
            if (bgh2.a(bgn.x)) {
                bqi bqi3 = bgh2.bqi_a();
                try {
                    bgb<Object> bgb2 = bqi3.a(bfw2, true, null);
                    if (bgb2 instanceof brk) {
                        return new b(bfw2, null, ((brk)bgb2).a());
                    }
                    return new b(bfw2, bgb2, null);
                }
                catch (bfy bfy3) {
                    // empty catch block
                }
            }
            return new b(bfw2, null, this.var_bog_a);
        }

        public void a(bcy bcy2, Object object, bqi bqi2) {
            if (this.var_bog_a != null) {
                bqi2.a(bcy2, object, this.var_bfw_a, (bgb<Object>)((Object)this.var_bgh$b_a), this.var_bog_a);
            } else if (this.var_bgh$b_a != null) {
                bqi2.a(bcy2, object, this.var_bfw_a, (bgb<Object>)((Object)this.var_bgh$b_a));
            } else if (this.var_bfw_a != null) {
                bqi2.a(bcy2, object, this.var_bfw_a);
            } else {
                bqi2.a(bcy2, object);
            }
        }

        static {
            var_bgh$b_a = new b(null, null, null);
        }
    }

    public static final class a
    implements Serializable {
        public static final a var_bgh$a_a;
        public final bdh var_bdh_a;
        public final bct var_bct_a;
        public final bdu var_bdu_a;
        public final bdi var_bdi_a;

        public a(bdh bdh2, bct bct2, bdu bdu2, bdi bdi2) {
            this.var_bdh_a = bdh2;
            this.var_bct_a = bct2;
            this.var_bdu_a = bdu2;
            this.var_bdi_a = bdi2;
        }

        public a a(bdh bdh2) {
            if (bdh2 == null) {
                bdh2 = var_bdh_a;
            }
            return bdh2 == this.var_bdh_a ? this : new a(bdh2, this.var_bct_a, this.var_bdu_a, this.var_bdi_a);
        }

        public void a(bcy bcy2) {
            bdh bdh2 = this.var_bdh_a;
            if (this.var_bdh_a != null) {
                if (bdh2 == var_bdh_a) {
                    bcy2.a((bdh)null);
                } else {
                    if (bdh2 instanceof bfa) {
                        bdh2 = (bdh)((bfa)((Object)bdh2)).a();
                    }
                    bcy2.a(bdh2);
                }
            }
            if (this.var_bdu_a != null) {
                bcy2.a(this.var_bdu_a);
            }
            if (this.var_bct_a != null) {
                bcy2.a(this.var_bct_a);
            }
            if (this.var_bdi_a != null) {
                bcy2.bcy_a(this.var_bdi_a);
            }
        }

        static {
            var_bgh$a_a = new a(null, null, null, null);
        }
    }
}

