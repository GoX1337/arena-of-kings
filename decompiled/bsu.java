/*
 * Decompiled with CFR 0.152.
 */
public abstract class bsu<T>
extends bte<T>
implements bqh {
    public static final Object var_java_lang_Object_a;
    protected final bfw var_bfw_a;
    protected final bfp var_bfp_a;
    protected final bog var_bog_a;
    protected final bgb<Object> var_bgb_java_lang_Object__a;
    protected final but var_but_a;
    protected transient bre var_bre_a;
    protected final Object b;
    protected final boolean var_boolean_a;

    public bsu(btu btu2, boolean bl2, bog bog2, bgb<Object> bgb2) {
        super(btu2);
        this.var_bfw_a = btu2.bfw_d();
        this.var_bfp_a = null;
        this.var_bog_a = bog2;
        this.var_java_lang_Object_a = bgb2;
        this.var_but_a = null;
        this.b = null;
        this.var_boolean_a = false;
        this.var_bre_a = bre.a();
    }

    protected bsu(bsu<?> bsu2, bfp bfp2, bog bog2, bgb<?> bgb2, but but2, Object object, boolean bl2) {
        super(bsu2);
        this.var_bfw_a = bsu2.var_bfw_a;
        this.var_bre_a = bre.a();
        this.var_bfp_a = bfp2;
        this.var_bog_a = bog2;
        this.var_java_lang_Object_a = bgb2;
        this.var_but_a = but2;
        this.b = object;
        this.var_boolean_a = bl2;
    }

    @Override
    public bgb<T> a(but but2) {
        but but3;
        bgb bgb2 = this.var_java_lang_Object_a;
        if (bgb2 != null && (bgb2 = bgb2.a(but2)) == this.var_java_lang_Object_a) {
            return this;
        }
        but but4 = but3 = this.var_but_a == null ? but2 : but.a(but2, this.var_but_a);
        if (this.var_java_lang_Object_a == bgb2 && this.var_but_a == but3) {
            return this;
        }
        return this.a(this.var_bfp_a, this.var_bog_a, bgb2, but3);
    }

    protected abstract bsu<T> a(bfp var1, bog var2, bgb<?> var3, but var4);

    public abstract bsu<T> a(Object var1, boolean var2);

    protected abstract boolean boolean_a(T var1);

    protected abstract Object b(T var1);

    protected abstract Object java_lang_Object_a(T var1);

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        bbr.a a2;
        bbr.b b2;
        Object object;
        bog bog2 = this.var_bog_a;
        if (bog2 != null) {
            bog2 = bog2.a(bfp2);
        }
        if ((object = this.b(bgo2, bfp2)) == null) {
            object = this.var_java_lang_Object_a;
            if (object == null) {
                if (this.a(bgo2, bfp2, this.var_bfw_a)) {
                    object = this.a(bgo2, this.var_bfw_a, bfp2);
                }
            } else {
                object = bgo2.a((bgb<?>)object, bfp2);
            }
        }
        bsu<T> bsu2 = this.var_bfp_a == bfp2 && this.var_bog_a == bog2 && this.var_java_lang_Object_a == object ? this : this.a(bfp2, bog2, (bgb<?>)object, this.var_but_a);
        if (bfp2 != null && (b2 = bfp2.bbr$b_a(bgo2.bgm_a(), this.a())) != null && (a2 = b2.b()) != bbr.a.g) {
            boolean bl2;
            Object object2;
            switch (a2) {
                case e: {
                    object2 = buh.java_lang_Object_a(this.var_bfw_a);
                    bl2 = true;
                    if (object2 == null || !object2.getClass().isArray()) break;
                    object2 = bue.a(object2);
                    break;
                }
                case c: {
                    bl2 = true;
                    object2 = this.var_bfw_a.a() != false ? var_java_lang_Object_a : null;
                    break;
                }
                case d: {
                    bl2 = true;
                    object2 = var_java_lang_Object_a;
                    break;
                }
                case f: {
                    object2 = bgo2.a((bmx)null, b2.b());
                    if (object2 == null) {
                        bl2 = true;
                        break;
                    }
                    bl2 = bgo2.boolean_a(object2);
                    break;
                }
                case b: {
                    object2 = null;
                    bl2 = true;
                    break;
                }
                default: {
                    object2 = null;
                    bl2 = false;
                }
            }
            if (this.b != object2 || this.var_boolean_a != bl2) {
                bsu2 = bsu2.a(object2, bl2);
            }
        }
        return bsu2;
    }

    protected boolean a(bgo bgo2, bfp bfp2, bfw bfw2) {
        bmn bmn2;
        if (bfw2.p()) {
            return false;
        }
        if (bfw2.l()) {
            return true;
        }
        if (bfw2.q()) {
            return true;
        }
        bfn bfn2 = bgo2.bfn_a();
        if (bfn2 != null && bfp2 != null && (bmn2 = bfp2.bmn_a()) != null) {
            bgu.b b2 = bfn2.bgu$b_a((bmg)bfp2.bmn_a());
            if (b2 == bgu.b.b) {
                return true;
            }
            if (b2 == bgu.b.var_bgu$b_a) {
                return false;
            }
        }
        return bgo2.a(bgd.p);
    }

    @Override
    public boolean a(bgo bgo2, T t2) {
        if (!this.boolean_a(t2)) {
            return true;
        }
        Object object = this.b(t2);
        if (object == null) {
            return this.var_boolean_a;
        }
        if (this.b == null) {
            return false;
        }
        bgb<Object> bgb2 = this.var_java_lang_Object_a;
        if (bgb2 == null) {
            try {
                bgb2 = this.a(bgo2, object.getClass());
            }
            catch (bfy bfy2) {
                throw new bgl(bfy2);
            }
        }
        if (this.b == var_java_lang_Object_a) {
            return bgb2.a(bgo2, object);
        }
        return this.b.equals(object);
    }

    @Override
    public boolean b() {
        return this.var_but_a != null;
    }

    @Override
    public void a(T t2, bcy bcy2, bgo bgo2) {
        Object object = this.java_lang_Object_a(t2);
        if (object == null) {
            if (this.var_but_a == null) {
                bgo2.a(bcy2);
            }
            return;
        }
        bgb<Object> bgb2 = this.var_java_lang_Object_a;
        if (bgb2 == null) {
            bgb2 = this.a(bgo2, object.getClass());
        }
        if (this.var_bog_a != null) {
            bgb2.a(object, bcy2, bgo2, this.var_bog_a);
        } else {
            bgb2.a(object, bcy2, bgo2);
        }
    }

    @Override
    public void a(T t2, bcy bcy2, bgo bgo2, bog bog2) {
        Object object = this.java_lang_Object_a(t2);
        if (object == null) {
            if (this.var_but_a == null) {
                bgo2.a(bcy2);
            }
            return;
        }
        bgb<Object> bgb2 = this.var_java_lang_Object_a;
        if (bgb2 == null) {
            bgb2 = this.a(bgo2, object.getClass());
        }
        bgb2.a(object, bcy2, bgo2, bog2);
    }

    private final bgb<Object> a(bgo bgo2, Class<?> clazz) {
        bgb<Object> bgb2 = this.var_bre_a.a(clazz);
        if (bgb2 == null) {
            if (this.var_bfw_a.r()) {
                bfw bfw2 = bgo2.a(this.var_bfw_a, clazz);
                bgb2 = bgo2.b(bfw2, this.var_bfp_a);
            } else {
                bgb2 = bgo2.b(clazz, this.var_bfp_a);
            }
            if (this.var_but_a != null) {
                bgb2 = bgb2.a(this.var_but_a);
            }
            this.var_bre_a = this.var_bre_a.bre_a(clazz, bgb2);
        }
        return bgb2;
    }

    private final bgb<Object> a(bgo bgo2, bfw bfw2, bfp bfp2) {
        return bgo2.b(bfw2, bfp2);
    }

    static {
        var_java_lang_Object_a = bbr.a.d;
    }
}

