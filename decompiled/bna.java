/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public abstract class bna
implements bfp,
Serializable {
    protected final bgi var_bgi_a;
    protected transient List<bgj> var_java_util_List_bgj__a;

    protected bna(bgi bgi2) {
        this.var_bgi_a = bgi2 == null ? bgi.c : bgi2;
    }

    protected bna(bna bna2) {
        this.var_bgi_a = bna2.var_bgi_a;
    }

    public boolean f() {
        return this.var_bgi_a.boolean_a();
    }

    @Override
    public bgi bgi_a() {
        return this.var_bgi_a;
    }

    @Override
    public bbk.d bbk$d_a(bhm<?> bhm2, Class<?> clazz) {
        bmn bmn2;
        bbk.d d2 = bhm2.bbk$d_a(clazz);
        Object object = null;
        bfn bfn2 = bhm2.bfn_a();
        if (bfn2 != null && (bmn2 = this.bmn_a()) != null) {
            object = bfn2.java_lang_Object_a((bmg)bmn2);
        }
        if (d2 == null) {
            return object == null ? var_bgi_a : object;
        }
        return object == null ? d2 : d2.a((bbk.d)object);
    }

    @Override
    public bbr.b bbr$b_a(bhm<?> bhm2, Class<?> clazz) {
        bfn bfn2 = bhm2.bfn_a();
        bmn bmn2 = this.bmn_a();
        if (bmn2 == null) {
            bbr.b b2 = bhm2.bbr$b_a(clazz);
            return b2;
        }
        bbr.b b3 = bhm2.a(clazz, (Class<?>)bmn2.java_lang_reflect_AnnotatedElement_a());
        if (bfn2 == null) {
            return b3;
        }
        Object object = bfn2.java_lang_Object_a((bmg)bmn2);
        if (b3 == null) {
            return object;
        }
        return b3.a((bbr.b)object);
    }

    public List<bgj> a(bhm<?> bhm2) {
        Object object = this.var_bgi_a;
        if (object == null) {
            bmn bmn2;
            bfn bfn2 = bhm2.bfn_a();
            if (bfn2 != null && (bmn2 = this.bmn_a()) != null) {
                object = bfn2.java_lang_Object_b((bmg)bmn2);
            }
            if (object == null) {
                object = Collections.emptyList();
            }
            this.var_bgi_a = object;
        }
        return object;
    }
}

