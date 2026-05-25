/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;

public class bpx {
    protected final bfp var_bfp_a;
    protected final bmn var_bmn_a;
    protected bgb<Object> var_bgb_java_lang_Object__a;
    protected bsl var_bsl_a;

    public bpx(bfp bfp2, bmn bmn2, bgb<?> bgb2) {
        this.var_bmn_a = bmn2;
        this.var_bfp_a = bfp2;
        this.var_bfp_a = bgb2;
        if (bgb2 instanceof bsl) {
            this.var_bsl_a = (bsl)bgb2;
        }
    }

    public void a(bgm bgm2) {
        this.var_bmn_a.a(bgm2.a(bgd.o));
    }

    public void a(Object object, bcy bcy2, bgo bgo2) {
        Object object2 = this.var_bmn_a.b(object);
        if (object2 == null) {
            return;
        }
        if (!(object2 instanceof Map)) {
            bgo2.b(this.var_bfp_a.bfw_a(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", this.var_bmn_a.java_lang_String_a(), object2.getClass().getName()));
        }
        if (this.var_bsl_a != null) {
            this.var_bsl_a.b((Map)object2, bcy2, bgo2);
            return;
        }
        ((bgb)((Object)this.var_bfp_a)).a(object2, bcy2, bgo2);
    }

    public void a(Object object, bcy bcy2, bgo bgo2, bqm bqm2) {
        Object object2 = this.var_bmn_a.b(object);
        if (object2 == null) {
            return;
        }
        if (!(object2 instanceof Map)) {
            bgo2.b(this.var_bfp_a.bfw_a(), String.format("Value returned by 'any-getter' (%s()) not java.util.Map but %s", this.var_bmn_a.java_lang_String_a(), object2.getClass().getName()));
        }
        if (this.var_bsl_a != null) {
            this.var_bsl_a.a(bgo2, bcy2, object, (Map)object2, bqm2, null);
            return;
        }
        ((bgb)((Object)this.var_bfp_a)).a(object2, bcy2, bgo2);
    }

    public void a(bgo bgo2) {
        if (this.var_bfp_a instanceof bqh) {
            bgb<?> bgb2 = bgo2.a((bgb<?>)((Object)this.var_bfp_a), this.var_bfp_a);
            this.var_bfp_a = bgb2;
            if (bgb2 instanceof bsl) {
                this.var_bsl_a = (bsl)bgb2;
            }
        }
    }
}

