/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Map;

@bgp
public class bra
extends bqg<Map.Entry<?, ?>>
implements bqh {
    public static final Object var_java_lang_Object_a;
    protected final bfp var_bfp_a;
    protected final boolean var_boolean_a;
    protected final bfw var_bfw_a;
    protected final bfw var_bfw_b;
    protected final bfw c;
    protected bgb<Object> var_bgb_java_lang_Object__a;
    protected bgb<Object> var_bgb_java_lang_Object__b;
    protected final bog var_bog_a;
    protected bre var_bre_a;
    protected final Object var_java_lang_Object_b;
    protected final boolean var_boolean_b;

    public bra(bfw bfw2, bfw bfw3, bfw bfw4, boolean bl2, bog bog2, bfp bfp2) {
        super(bfw2);
        this.var_bfw_a = bfw2;
        this.var_bfw_b = bfw3;
        this.c = bfw4;
        this.var_boolean_a = bl2;
        this.var_bog_a = bog2;
        this.var_bfp_a = bfp2;
        this.var_bre_a = bre.a();
        this.var_java_lang_Object_b = null;
        this.var_boolean_b = false;
    }

    protected bra(bra bra2, bfp bfp2, bog bog2, bgb<?> bgb2, bgb<?> bgb3, Object object, boolean bl2) {
        super(Map.class, false);
        this.var_bfw_a = bra2.var_bfw_a;
        this.var_bfw_b = bra2.var_bfw_b;
        this.c = bra2.c;
        this.var_boolean_a = bra2.var_boolean_a;
        this.var_bog_a = bra2.var_bog_a;
        this.var_java_lang_Object_a = bgb2;
        this.var_bfw_b = bgb3;
        this.var_bre_a = bre.a();
        this.var_bfp_a = bra2.var_bfp_a;
        this.var_java_lang_Object_b = object;
        this.var_boolean_b = bl2;
    }

    @Override
    public bqg<?> b(bog bog2) {
        return new bra(this, this.var_bfp_a, bog2, (bgb<?>)this.var_java_lang_Object_a, (bgb<?>)((Object)this.var_bfw_b), this.var_java_lang_Object_b, this.var_boolean_b);
    }

    public bra a(bfp bfp2, bgb<?> bgb2, bgb<?> bgb3, Object object, boolean bl2) {
        return new bra(this, bfp2, this.var_bog_a, bgb2, bgb3, object, bl2);
    }

    public bra a(Object object, boolean bl2) {
        if (this.var_java_lang_Object_b == object && this.var_boolean_b == bl2) {
            return this;
        }
        return new bra(this, this.var_bfp_a, this.var_bog_a, (bgb<?>)this.var_java_lang_Object_a, (bgb<?>)((Object)this.var_bfw_b), object, bl2);
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        bbr.a a2;
        Serializable serializable;
        Object object;
        bmn bmn2;
        bgb<Object> bgb2 = null;
        bgb<Object> bgb3 = null;
        bfn bfn2 = bgo2.bfn_a();
        bmn bmn3 = bmn2 = bfp2 == null ? null : bfp2.bmn_a();
        if (bmn2 != null && bfn2 != null) {
            object = bfn2.java_lang_Object_c((bmg)bmn2);
            if (object != null) {
                bgb3 = bgo2.a((bmg)bmn2, object);
            }
            if ((object = bfn2.java_lang_Object_d(bmn2)) != null) {
                bgb2 = bgo2.a((bmg)bmn2, object);
            }
        }
        if (bgb2 == null) {
            bgb2 = this.var_bfw_b;
        }
        if ((bgb2 = this.a(bgo2, bfp2, bgb2)) == null && this.var_boolean_a && !this.c.p()) {
            bgb2 = bgo2.c(this.c, bfp2);
        }
        if (bgb3 == null) {
            bgb3 = this.var_java_lang_Object_a;
        }
        bgb3 = bgb3 == null ? bgo2.d(this.var_bfw_b, bfp2) : bgo2.b(bgb3, bfp2);
        object = this.var_java_lang_Object_b;
        boolean bl2 = this.var_boolean_b;
        if (bfp2 != null && (serializable = bfp2.bbr$b_a(bgo2.bgm_a(), null)) != null && (a2 = ((bbr.b)serializable).b()) != bbr.a.g) {
            switch (a2) {
                case e: {
                    object = buh.java_lang_Object_a(this.c);
                    bl2 = true;
                    if (object == null || !object.getClass().isArray()) break;
                    object = bue.a(object);
                    break;
                }
                case c: {
                    bl2 = true;
                    object = this.c.a() != false ? var_java_lang_Object_a : null;
                    break;
                }
                case d: {
                    bl2 = true;
                    object = var_java_lang_Object_a;
                    break;
                }
                case f: {
                    object = bgo2.a((bmx)null, ((bbr.b)serializable).b());
                    if (object == null) {
                        bl2 = true;
                        break;
                    }
                    bl2 = bgo2.boolean_a(object);
                    break;
                }
                case b: {
                    object = null;
                    bl2 = true;
                    break;
                }
                default: {
                    object = null;
                    bl2 = false;
                }
            }
        }
        serializable = this.a(bfp2, bgb3, bgb2, object, bl2);
        return serializable;
    }

    public bfw a() {
        return this.c;
    }

    @Override
    public boolean a(Map.Entry<?, ?> entry) {
        return true;
    }

    @Override
    public boolean a(bgo bgo2, Map.Entry<?, ?> entry) {
        Class<?> clazz;
        Object obj = entry.getValue();
        if (obj == null) {
            return this.var_boolean_b;
        }
        if (this.var_java_lang_Object_b == null) {
            return false;
        }
        Object object = this.var_bfw_b;
        if (object == null && (object = this.var_bre_a.a(clazz = obj.getClass())) == null) {
            try {
                object = this.a(this.var_bre_a, clazz, bgo2);
            }
            catch (bfy bfy2) {
                return false;
            }
        }
        if (this.var_java_lang_Object_b == var_java_lang_Object_a) {
            return ((bgb)object).a(bgo2, obj);
        }
        return this.var_java_lang_Object_b.equals(obj);
    }

    @Override
    public void a(Map.Entry<?, ?> entry, bcy bcy2, bgo bgo2) {
        bcy2.c(entry);
        this.b(entry, bcy2, bgo2);
        bcy2.void_d();
    }

    @Override
    public void a(Map.Entry<?, ?> entry, bcy bcy2, bgo bgo2, bog bog2) {
        bcy2.a(entry);
        beu beu2 = bog2.a(bcy2, bog2.a(entry, bdf.var_bdf_b));
        this.b(entry, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }

    protected void b(Map.Entry<?, ?> entry, bcy bcy2, bgo bgo2) {
        Object object;
        bog bog2 = this.var_bog_a;
        Object obj = entry.getKey();
        bgb<Object> bgb2 = obj == null ? bgo2.e(this.var_bfw_b, this.var_bfp_a) : this.var_java_lang_Object_a;
        Object obj2 = entry.getValue();
        if (obj2 == null) {
            if (this.var_boolean_b) {
                return;
            }
            object = bgo2.a();
        } else {
            Class<?> clazz;
            object = this.var_bfw_b;
            if (object == null && (object = this.var_bre_a.a(clazz = obj2.getClass())) == null) {
                object = this.c.r() ? this.a(this.var_bre_a, bgo2.a(this.c, clazz), bgo2) : this.a(this.var_bre_a, clazz, bgo2);
            }
            if (this.var_java_lang_Object_b != null) {
                if (this.var_java_lang_Object_b == var_java_lang_Object_a && ((bgb)object).a(bgo2, obj2)) {
                    return;
                }
                if (this.var_java_lang_Object_b.equals(obj2)) {
                    return;
                }
            }
        }
        bgb2.a(obj, bcy2, bgo2);
        try {
            if (bog2 == null) {
                ((bgb)object).a(obj2, bcy2, bgo2);
            } else {
                ((bgb)object).a(obj2, bcy2, bgo2, bog2);
            }
        }
        catch (Exception exception) {
            String string = "" + obj;
            this.a(bgo2, (Throwable)exception, entry, string);
        }
    }

    protected final bgb<Object> a(bre bre2, Class<?> clazz, bgo bgo2) {
        bre.d d2 = bre2.b(clazz, bgo2, this.var_bfp_a);
        if (bre2 != d2.var_bre_a) {
            this.var_bre_a = d2.var_bre_a;
        }
        return d2.var_bgb_java_lang_Object__a;
    }

    protected final bgb<Object> a(bre bre2, bfw bfw2, bgo bgo2) {
        bre.d d2 = bre2.b(bfw2, bgo2, this.var_bfp_a);
        if (bre2 != d2.var_bre_a) {
            this.var_bre_a = d2.var_bre_a;
        }
        return d2.var_bgb_java_lang_Object__a;
    }

    static {
        var_java_lang_Object_a = bbr.a.d;
    }
}

