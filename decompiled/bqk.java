/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.AnnotatedElement;

public class bqk {
    private static final Object b = Boolean.FALSE;
    protected final bgm var_bgm_a;
    protected final bfo var_bfo_a;
    protected final bfn var_bfn_a;
    protected Object var_java_lang_Object_a;
    protected final bbr.b var_bbr$b_a;
    protected final boolean var_boolean_a;

    public bqk(bgm bgm2, bfo bfo2) {
        this.var_bgm_a = bgm2;
        this.var_bfo_a = bfo2;
        bbr.b b2 = bbr.b.a(bfo2.a(bbr.b.bbr$b_a()), bgm2.a(bfo2.a(), bbr.b.bbr$b_a()));
        this.var_bbr$b_a = bbr.b.a(bgm2.bbr$b_a(), b2);
        this.var_boolean_a = b2.bbr$a_a() == bbr.a.e;
        this.var_bfn_a = this.var_bgm_a.bfn_a();
    }

    protected bqb a(bgo bgo2, bmx bmx2, bfw bfw2, bgb<?> bgb2, bog bog2, bog bog3, bmn bmn2, boolean bl2) {
        but but2;
        Object object;
        Class<?>[] classArray;
        Object object2;
        bfw bfw3;
        try {
            bfw3 = this.a(bmn2, bl2, bfw2);
        }
        catch (bfy bfy2) {
            if (bmx2 == null) {
                return (bqb)bgo2.b(bfw2, buk.java_lang_String_a(bfy2));
            }
            return (bqb)bgo2.a(this.var_bfo_a, bmx2, buk.java_lang_String_a(bfy2), new Object[0]);
        }
        if (bog3 != null) {
            if (bfw3 == null) {
                bfw3 = bfw2;
            }
            if ((object2 = bfw3.bfw_c()) == null) {
                bgo2.a(this.var_bfo_a, bmx2, "serialization type " + bfw3 + " has no content", new Object[0]);
            }
            bfw3 = bfw3.btp_b(bog3);
            object2 = bfw3.bfw_c();
        }
        object2 = null;
        boolean bl3 = false;
        bfw bfw4 = bfw3 == null ? bfw2 : bfw3;
        bmn bmn3 = bmx2.bmn_a();
        if (bmn3 == null) {
            return (bqb)bgo2.a(this.var_bfo_a, bmx2, "could not determine property type", new Object[0]);
        }
        AnnotatedElement annotatedElement = bmn3.java_lang_reflect_AnnotatedElement_a();
        bbr.b b2 = this.var_bgm_a.a((Class<?>)bfw4.a(), (Class<?>)annotatedElement, this.var_bbr$b_a);
        bbr.a a2 = (b2 = b2.a(bmx2.bbr$b_a())).bbr$a_a();
        if (a2 == bbr.a.g) {
            a2 = bbr.a.var_bbr$a_a;
        }
        switch (a2) {
            case e: {
                if (this.var_boolean_a && (classArray = this.a()) != null) {
                    if (bgo2.a(bgd.n)) {
                        bmn2.a(this.var_bgm_a.a(bgd.o));
                    }
                    try {
                        object2 = bmn2.b(classArray);
                    }
                    catch (Exception exception) {
                        this.a(exception, bmx2.java_lang_String_a(), classArray);
                    }
                } else {
                    object2 = buh.java_lang_Object_a(bfw4);
                    bl3 = true;
                }
                if (object2 == null) {
                    bl3 = true;
                    break;
                }
                if (!object2.getClass().isArray()) break;
                object2 = bue.a(object2);
                break;
            }
            case c: {
                bl3 = true;
                if (bfw4.a() == false) break;
                object2 = bqb.var_java_lang_Object_a;
                break;
            }
            case d: {
                bl3 = true;
                object2 = bqb.var_java_lang_Object_a;
                break;
            }
            case f: {
                object2 = bgo2.a(bmx2, b2.a());
                if (object2 == null) {
                    bl3 = true;
                    break;
                }
                bl3 = bgo2.boolean_a(object2);
                break;
            }
            case b: {
                bl3 = true;
            }
            default: {
                object = bgn.s;
                if (!bfw4.m() || this.var_bgm_a.a((bgn)object)) break;
                object2 = bqb.var_java_lang_Object_a;
            }
        }
        classArray = bmx2.java_lang_Class____arr_a();
        if (classArray == null) {
            classArray = this.var_bfo_a.java_lang_Class____arr_a();
        }
        object = this.a(bmx2, bmn2, this.var_bfo_a.bud_a(), bfw2, bgb2, bog2, bfw3, bl3, object2, classArray);
        Object object3 = this.var_bfn_a.java_lang_Object_e(bmn2);
        if (object3 != null) {
            ((bqb)object).b(bgo2.a((bmg)bmn2, object3));
        }
        if ((but2 = this.var_bfn_a.but_a(bmn2)) != null) {
            object = ((bqb)object).b(but2);
        }
        return object;
    }

    protected bqb a(bmx bmx2, bmn bmn2, bud bud2, bfw bfw2, bgb<?> bgb2, bog bog2, bfw bfw3, boolean bl2, Object object, Class<?>[] classArray) {
        return new bqb(bmx2, bmn2, bud2, bfw2, bgb2, bog2, bfw3, bl2, object, classArray);
    }

    protected bfw a(bmg bmg2, boolean bl2, bfw bfw2) {
        Object object;
        bfw bfw3 = this.var_bfn_a.a(this.var_bgm_a, bmg2, bfw2);
        if (bfw3 != bfw2) {
            Object t2;
            object = bfw3.a();
            if (!((Class)object).isAssignableFrom((Class<?>)(t2 = bfw2.a())) && !((Class)t2).isAssignableFrom((Class<?>)object)) {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + bmg2.java_lang_String_a() + "': class " + ((Class)object).getName() + " not a super-type of (declared) class " + ((Class)t2).getName());
            }
            bl2 = true;
            bfw2 = bfw3;
        }
        if ((object = this.var_bfn_a.bgu$b_a(bmg2)) != null && object != bgu.b.c) {
            boolean bl3 = bl2 = object == bgu.b.b;
        }
        if (bl2) {
            return bfw2.bfw_a();
        }
        return null;
    }

    protected Object a() {
        Object object = this.var_java_lang_Object_a;
        if (object == null) {
            object = this.var_bfo_a.a(this.var_bgm_a.c());
            if (object == null) {
                object = b;
            }
            this.var_java_lang_Object_a = object;
        }
        return object == b ? null : this.var_java_lang_Object_a;
    }

    protected Object a(Exception exception, String string, Object object) {
        Throwable throwable = exception;
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        buk.java_lang_Throwable_a(throwable);
        buk.java_lang_Throwable_b(throwable);
        throw new IllegalArgumentException("Failed to get property '" + string + "' of default " + object.getClass().getName() + " instance");
    }
}

