/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Objects;

@bgp
public class bss
extends brq<Object[]> {
    protected final boolean var_boolean_a;
    protected final bfw var_bfw_a;
    protected final bog var_bog_a;
    protected bgb<Object> var_bgb_java_lang_Object__a;
    protected bre var_bre_a;

    public bss(bfw bfw2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        super(Object[].class);
        this.var_bfw_a = bfw2;
        this.var_boolean_a = bl2;
        this.var_bog_a = bog2;
        this.var_bre_a = bre.a();
        this.var_boolean_a = bgb2;
    }

    public bss(bss bss2, bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        super(bss2, bfp2, bl2);
        this.var_bfw_a = bss2.var_bfw_a;
        this.var_bog_a = bog2;
        this.var_boolean_a = bss2.var_boolean_a;
        this.var_bre_a = bre.a();
        this.var_boolean_a = bgb2;
    }

    @Override
    public bgb<?> a(bfp bfp2, Boolean bl2) {
        return new bss(this, bfp2, this.var_bog_a, (bgb<?>)this.var_boolean_a, bl2);
    }

    @Override
    public bqg<?> b(bog bog2) {
        return new bss(this.var_bfw_a, this.var_boolean_a, bog2, (bgb<Object>)this.var_boolean_a);
    }

    public bss a(bfp bfp2, bog bog2, bgb<?> bgb2, Boolean bl2) {
        if (this.var_boolean_a == bfp2 && bgb2 == this.var_boolean_a && this.var_bog_a == bog2 && Objects.equals(this.var_boolean_a, bl2)) {
            return this;
        }
        return new bss(this, bfp2, bog2, bgb2, bl2);
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        Serializable serializable;
        bog bog2 = this.var_bog_a;
        if (bog2 != null) {
            bog2 = bog2.a(bfp2);
        }
        bgb<Object> bgb2 = null;
        Boolean bl2 = null;
        if (bfp2 != null) {
            Object object;
            serializable = bfp2.bmn_a();
            bfn bfn2 = bgo2.bfn_a();
            if (serializable != null && (object = bfn2.java_lang_Object_d((bmg)((Object)serializable))) != null) {
                bgb2 = bgo2.a((bmg)((Object)serializable), object);
            }
        }
        if ((serializable = this.bbk$d_a(bgo2, bfp2, this.a())) != null) {
            bl2 = ((bbk.d)serializable).a(bbk.a.f);
        }
        if (bgb2 == null) {
            bgb2 = (bgb<Object>)this.var_boolean_a;
        }
        if ((bgb2 = this.a(bgo2, bfp2, bgb2)) == null && this.var_bfw_a != null && this.var_boolean_a && !this.var_bfw_a.p()) {
            bgb2 = bgo2.c(this.var_bfw_a, bfp2);
        }
        return this.a(bfp2, bog2, bgb2, bl2);
    }

    @Override
    public boolean a(bgo bgo2, Object[] objectArray) {
        return objectArray.length == 0;
    }

    @Override
    public boolean a(Object[] objectArray) {
        return objectArray.length == 1;
    }

    @Override
    public final void a(Object[] objectArray, bcy bcy2, bgo bgo2) {
        int n2 = objectArray.length;
        if (n2 == 1 && (this.var_boolean_a == null && bgo2.a(bgn.t) || this.var_boolean_a == Boolean.TRUE)) {
            this.b(objectArray, bcy2, bgo2);
            return;
        }
        bcy2.a(objectArray, n2);
        this.b(objectArray, bcy2, bgo2);
        bcy2.void_b();
    }

    @Override
    public void b(Object[] objectArray, bcy bcy2, bgo bgo2) {
        int n2;
        int n3 = objectArray.length;
        if (n3 == 0) {
            return;
        }
        if (this.var_boolean_a != null) {
            this.a(objectArray, bcy2, bgo2, (bgb<Object>)this.var_boolean_a);
            return;
        }
        if (this.var_bog_a != null) {
            this.c(objectArray, bcy2, bgo2);
            return;
        }
        Object object = null;
        try {
            bre bre2 = this.var_bre_a;
            for (n2 = 0; n2 < n3; ++n2) {
                object = objectArray[n2];
                if (object == null) {
                    bgo2.a(bcy2);
                    continue;
                }
                Class<?> clazz = object.getClass();
                bgb<Object> bgb2 = bre2.a(clazz);
                if (bgb2 == null) {
                    bgb2 = this.var_bfw_a.r() ? this.a(bre2, bgo2.a(this.var_bfw_a, clazz), bgo2) : this.a(bre2, clazz, bgo2);
                }
                bgb2.a(object, bcy2, bgo2);
            }
        }
        catch (Exception exception) {
            this.a(bgo2, (Throwable)exception, object, n2);
        }
    }

    public void a(Object[] objectArray, bcy bcy2, bgo bgo2, bgb<Object> bgb2) {
        int n2;
        int n3 = objectArray.length;
        bog bog2 = this.var_bog_a;
        Object object = null;
        try {
            for (n2 = 0; n2 < n3; ++n2) {
                object = objectArray[n2];
                if (object == null) {
                    bgo2.a(bcy2);
                    continue;
                }
                if (bog2 == null) {
                    bgb2.a(object, bcy2, bgo2);
                    continue;
                }
                bgb2.a(object, bcy2, bgo2, bog2);
            }
        }
        catch (Exception exception) {
            this.a(bgo2, (Throwable)exception, object, n2);
        }
    }

    public void c(Object[] objectArray, bcy bcy2, bgo bgo2) {
        int n2;
        int n3 = objectArray.length;
        bog bog2 = this.var_bog_a;
        Object object = null;
        try {
            bre bre2 = this.var_bre_a;
            for (n2 = 0; n2 < n3; ++n2) {
                object = objectArray[n2];
                if (object == null) {
                    bgo2.a(bcy2);
                    continue;
                }
                Class<?> clazz = object.getClass();
                bgb<Object> bgb2 = bre2.a(clazz);
                if (bgb2 == null) {
                    bgb2 = this.a(bre2, clazz, bgo2);
                }
                bgb2.a(object, bcy2, bgo2, bog2);
            }
        }
        catch (Exception exception) {
            this.a(bgo2, (Throwable)exception, object, n2);
        }
    }

    protected final bgb<Object> a(bre bre2, Class<?> clazz, bgo bgo2) {
        bre.d d2 = bre2.b(clazz, bgo2, (bfp)this.var_boolean_a);
        if (bre2 != d2.var_bre_a) {
            this.var_bre_a = d2.var_bre_a;
        }
        return d2.var_bgb_java_lang_Object__a;
    }

    protected final bgb<Object> a(bre bre2, bfw bfw2, bgo bgo2) {
        bre.d d2 = bre2.b(bfw2, bgo2, (bfp)this.var_boolean_a);
        if (bre2 != d2.var_bre_a) {
            this.var_bre_a = d2.var_bre_a;
        }
        return d2.var_bgb_java_lang_Object__a;
    }
}

