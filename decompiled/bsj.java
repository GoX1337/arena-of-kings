/*
 * Decompiled with CFR 0.152.
 */
@bgp
public class bsj
extends bte<Object>
implements bqh {
    protected final bmn var_bmn_a;
    protected final bog var_bog_a;
    protected final bgb<Object> var_bgb_java_lang_Object__a;
    protected final bfp var_bfp_a;
    protected final bfw var_bfw_a;
    protected final boolean var_boolean_a;
    protected transient bre var_bre_a;

    public bsj(bmn bmn2, bog bog2, bgb<?> bgb2) {
        super(bmn2.bfw_a());
        this.var_bmn_a = bmn2;
        this.var_bfw_a = bmn2.bfw_a();
        this.var_bog_a = bog2;
        this.var_bmn_a = bgb2;
        this.var_bfp_a = null;
        this.var_boolean_a = true;
        this.var_bre_a = bre.a();
    }

    public bsj(bsj bsj2, bfp bfp2, bog bog2, bgb<?> bgb2, boolean bl2) {
        super(bsj.a(bsj2.a()));
        this.var_bmn_a = bsj2.var_bmn_a;
        this.var_bfw_a = bsj2.var_bfw_a;
        this.var_bog_a = bog2;
        this.var_bmn_a = bgb2;
        this.var_bfp_a = bfp2;
        this.var_boolean_a = bl2;
        this.var_bre_a = bre.a();
    }

    private static final Class<Object> a(Class<?> clazz) {
        return clazz == null ? Object.class : clazz;
    }

    protected bsj a(bfp bfp2, bog bog2, bgb<?> bgb2, boolean bl2) {
        if (this.var_bfp_a == bfp2 && this.var_bog_a == bog2 && this.var_bmn_a == bgb2 && bl2 == this.var_boolean_a) {
            return this;
        }
        return new bsj(this, bfp2, bog2, bgb2, bl2);
    }

    @Override
    public boolean a(bgo bgo2, Object object) {
        Object object2 = this.var_bmn_a.b(object);
        if (object2 == null) {
            return true;
        }
        Object object3 = this.var_bmn_a;
        if (object3 == null) {
            try {
                object3 = this.a(bgo2, object2.getClass());
            }
            catch (bfy bfy2) {
                throw new bgl(bfy2);
            }
        }
        return ((bgb)object3).a(bgo2, object2);
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        bgb<Object> bgb2;
        bog bog2 = this.var_bog_a;
        if (bog2 != null) {
            bog2 = bog2.a(bfp2);
        }
        if ((bgb2 = this.var_bmn_a) == null) {
            if (bgo2.a(bgd.p) || this.var_bfw_a.l()) {
                bgb2 = bgo2.b(this.var_bfw_a, bfp2);
                boolean bl2 = this.a((Class<?>)this.var_bfw_a.a(), bgb2);
                return this.a(bfp2, bog2, bgb2, bl2);
            }
            if (bfp2 != this.var_bfp_a) {
                return this.a(bfp2, bog2, bgb2, this.var_boolean_a);
            }
        } else {
            bgb2 = bgo2.a(bgb2, bfp2);
            return this.a(bfp2, bog2, bgb2, this.var_boolean_a);
        }
        return this;
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2) {
        Object object2;
        try {
            object2 = this.var_bmn_a.b(object);
        }
        catch (Exception exception) {
            object2 = null;
            this.a(bgo2, (Throwable)exception, object, this.var_bmn_a.java_lang_String_a() + "()");
        }
        if (object2 == null) {
            bgo2.a(bcy2);
        } else {
            Object object3 = this.var_bmn_a;
            if (object3 == null) {
                object3 = this.a(bgo2, object2.getClass());
            }
            if (this.var_bog_a != null) {
                ((bgb)object3).a(object2, bcy2, bgo2, this.var_bog_a);
            } else {
                ((bgb)object3).a(object2, bcy2, bgo2);
            }
        }
    }

    @Override
    public void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
        Object object2;
        try {
            object2 = this.var_bmn_a.b(object);
        }
        catch (Exception exception) {
            object2 = null;
            this.a(bgo2, (Throwable)exception, object, this.var_bmn_a.java_lang_String_a() + "()");
        }
        if (object2 == null) {
            bgo2.a(bcy2);
            return;
        }
        Object object3 = this.var_bmn_a;
        if (object3 == null) {
            object3 = this.a(bgo2, object2.getClass());
        } else if (this.var_boolean_a) {
            beu beu2 = bog2.a(bcy2, bog2.a(object, bdf.h));
            ((bgb)object3).a(object2, bcy2, bgo2);
            bog2.b(bcy2, beu2);
            return;
        }
        a a2 = new a(bog2, object);
        ((bgb)object3).a(object2, bcy2, bgo2, a2);
    }

    protected boolean a(Class<?> clazz, bgb<?> bgb2) {
        if (clazz.isPrimitive() ? clazz != Integer.TYPE && clazz != Boolean.TYPE && clazz != Double.TYPE : clazz != String.class && clazz != Integer.class && clazz != Boolean.class && clazz != Double.class) {
            return false;
        }
        return this.a(bgb2);
    }

    protected bgb<Object> a(bgo bgo2, Class<?> clazz) {
        bgb<Object> bgb2 = this.var_bre_a.a(clazz);
        if (bgb2 == null) {
            if (this.var_bfw_a.r()) {
                bfw bfw2 = bgo2.a(this.var_bfw_a, clazz);
                bgb2 = bgo2.b(bfw2, this.var_bfp_a);
                bre.d d2 = this.var_bre_a.a(bfw2, bgb2);
                this.var_bre_a = d2.var_bre_a;
            } else {
                bgb2 = bgo2.b(clazz, this.var_bfp_a);
                bre.d d3 = this.var_bre_a.bre$d_a(clazz, bgb2);
                this.var_bre_a = d3.var_bre_a;
            }
        }
        return bgb2;
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this.var_bmn_a.b() + "#" + this.var_bmn_a.java_lang_String_a() + ")";
    }

    static class a
    extends bog {
        protected final bog var_bog_a;
        protected final Object var_java_lang_Object_a;

        public a(bog bog2, Object object) {
            this.var_bog_a = bog2;
            this.var_java_lang_Object_a = object;
        }

        @Override
        public bog a(bfp bfp2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public bce.a bce$a_a() {
            return this.var_bog_a.bce$a_a();
        }

        @Override
        public String java_lang_String_a() {
            return this.var_bog_a.java_lang_String_a();
        }

        @Override
        public beu a(bcy bcy2, beu beu2) {
            beu2.var_java_lang_Object_a = this.var_java_lang_Object_a;
            return this.var_bog_a.a(bcy2, beu2);
        }

        @Override
        public beu b(bcy bcy2, beu beu2) {
            return this.var_bog_a.b(bcy2, beu2);
        }
    }
}

