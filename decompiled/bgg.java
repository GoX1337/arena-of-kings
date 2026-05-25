/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class bgg
extends bdg
implements Serializable {
    protected final bfr var_bfr_a;
    protected final bif var_bif_a;
    protected final bcw var_bcw_a;
    protected final boolean var_boolean_a;
    private final bds var_bds_a;
    protected final bfw var_bfw_a;
    protected final bfx<Object> var_bfx_java_lang_Object__a;
    protected final Object var_java_lang_Object_a;
    protected final bct var_bct_a;
    protected final bfv var_bfv_a;
    protected final bie var_bie_a;
    protected final ConcurrentHashMap<bfw, bfx<Object>> cfr_renamed_11;

    protected bgg(bgf bgf2, bfr bfr2, bfw bfw2, Object object, bct bct2, bfv bfv2) {
        this.var_bfr_a = bfr2;
        this.var_bif_a = bgf2.var_bif_a;
        this.var_bfr_a = bgf2.var_bfn_a;
        this.var_bcw_a = bgf2.var_bcw_a;
        this.var_bfw_a = bfw2;
        this.var_java_lang_Object_a = object;
        this.var_bct_a = bct2;
        this.var_bfv_a = bfv2;
        this.var_boolean_a = bfr2.boolean_a();
        this.var_bfr_a = this.a(bfw2);
        this.var_bie_a = null;
        this.var_bds_a = null;
    }

    @Override
    public bcw bcw_b() {
        return this.var_bcw_a;
    }

    @Override
    public void a(bcy bcy2, Object object) {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }

    protected bif bif_a() {
        return this.var_bif_a.a(this.var_bfr_a);
    }

    protected bfx<Object> a(bfw bfw2) {
        if (bfw2 == null || !this.var_bfr_a.a(bfu.B)) {
            return null;
        }
        bfx<Object> bfx2 = (bfx<Object>)((ConcurrentHashMap)((Object)this.var_bfr_a)).get(bfw2);
        if (bfx2 == null) {
            try {
                bif bif2 = this.bif_a();
                bfx2 = bif2.b(bfw2);
                if (bfx2 != null) {
                    ((ConcurrentHashMap)((Object)this.var_bfr_a)).put(bfw2, bfx2);
                }
                return bfx2;
            }
            catch (bdd bdd2) {
                // empty catch block
            }
        }
        return bfx2;
    }
}

