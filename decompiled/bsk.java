/*
 * Decompiled with CFR 0.152.
 */
public class bsk
extends bqn {
    private static final bfp var_bfp_b;
    protected final bog var_bog_a;
    protected final bfp var_bfp_a;
    protected Object var_java_lang_Object_a;
    protected Object var_java_lang_Object_b;
    protected bgb<Object> var_bgb_java_lang_Object__a;
    protected bgb<Object> var_bgb_java_lang_Object__b;

    public bsk(bog bog2, bfp bfp2) {
        super(bfp2 == null ? bgi.c : bfp2.bgi_a());
        this.var_bog_a = bog2;
        this.var_bfp_a = bfp2 == null ? var_bfp_b : bfp2;
    }

    public void a(Object object, Object object2, bgb<Object> bgb2, bgb<Object> bgb3) {
        this.var_java_lang_Object_a = object;
        this.var_java_lang_Object_b = object2;
        this.var_bog_a = bgb2;
        this.var_bfp_b = bgb3;
    }

    @Override
    public String java_lang_String_a() {
        if (this.var_java_lang_Object_a instanceof String) {
            return (String)this.var_java_lang_Object_a;
        }
        return String.valueOf(this.var_java_lang_Object_a);
    }

    @Override
    public bgj bgj_a() {
        return new bgj(this.java_lang_String_a());
    }

    @Override
    public void void_a(Object object, bcy bcy2, bgo bgo2) {
        ((bgb)((Object)this.var_bog_a)).a(this.var_java_lang_Object_a, bcy2, bgo2);
        if (this.var_bog_a == null) {
            ((bgb)((Object)this.var_bfp_b)).a(this.var_java_lang_Object_b, bcy2, bgo2);
        } else {
            ((bgb)((Object)this.var_bfp_b)).a(this.var_java_lang_Object_b, bcy2, bgo2, this.var_bog_a);
        }
    }

    @Override
    public void b(Object object, bcy bcy2, bgo bgo2) {
        if (!bcy2.boolean_d()) {
            bcy2.f(this.java_lang_String_a());
        }
    }

    @Override
    public bfw bfw_a() {
        return this.var_bfp_a.bfw_a();
    }

    @Override
    public bmn bmn_a() {
        return this.var_bfp_a.bmn_a();
    }

    static {
        var_bfp_b = new bfp.a();
    }
}

