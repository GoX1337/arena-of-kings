/*
 * Decompiled with CFR 0.152.
 */
import java.util.Set;

public class bit
extends bhv {
    protected final bhv var_bhv_a;
    protected final bio[] var_bio_arr_a;
    protected final bmo var_bmo_a;
    protected final bfw b;

    public bit(bhv bhv2, bfw bfw2, bio[] bioArray, bmo bmo2) {
        super(bhv2);
        this.var_bhv_a = bhv2;
        this.b = bfw2;
        this.var_bio_arr_a = bioArray;
        this.var_bmo_a = bmo2;
    }

    @Override
    public bfx<Object> a(but but2) {
        return this.var_bhv_a.a(but2);
    }

    @Override
    public bhv a(bjl bjl2) {
        return new bit(this.var_bhv_a.a(bjl2), this.b, this.var_bio_arr_a, this.var_bmo_a);
    }

    @Override
    public bhv a(Set<String> set, Set<String> set2) {
        return new bit(this.var_bhv_a.a(set, set2), this.b, this.var_bio_arr_a, this.var_bmo_a);
    }

    @Override
    public bhv a(boolean bl2) {
        return new bit(this.var_bhv_a.a(bl2), this.b, this.var_bio_arr_a, this.var_bmo_a);
    }

    @Override
    public bhv a(biv biv2) {
        return new bit(this.var_bhv_a.a(biv2), this.b, this.var_bio_arr_a, this.var_bmo_a);
    }

    @Override
    protected bhv bhv_a() {
        return this;
    }

    @Override
    public Boolean a(bfr bfr2) {
        return Boolean.FALSE;
    }

    protected final Object java_lang_Object_a(bfs bfs2, Object object) {
        try {
            return this.var_bmo_a.java_lang_reflect_Method_b().invoke(object, (Object[])null);
        }
        catch (Exception exception) {
            return this.java_lang_Object_a(exception, bfs2);
        }
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2) {
        if (!bdc2.boolean_c()) {
            return this.java_lang_Object_a(bfs2, this.f(bdc2, bfs2));
        }
        if (this.b == false) {
            return this.java_lang_Object_a(bfs2, this.d(bdc2, bfs2));
        }
        Object object = ((bir)((Object)this.var_bhv_a)).a(bfs2);
        bio[] bioArray = this.var_bio_arr_a;
        int n2 = 0;
        int n3 = bioArray.length;
        while (true) {
            if (bdc2.bdf_a() == bdf.var_bdf_e) {
                return this.java_lang_Object_a(bfs2, object);
            }
            if (n2 == n3) break;
            bio bio2 = bioArray[n2];
            if (bio2 != null) {
                try {
                    object = bio2.java_lang_Object_a(bdc2, bfs2, object);
                }
                catch (Exception exception) {
                    this.a(exception, object, bio2.java_lang_String_a(), bfs2);
                }
            } else {
                bdc2.bdc_a();
            }
            ++n2;
        }
        if (!this.c && bfs2.a(bfu.e)) {
            bfs2.a(this.a(), "Unexpected JSON values; expected at most %d properties (in JSON Array)", n3);
        }
        while (bdc2.bdf_a() != bdf.var_bdf_e) {
            bdc2.bdc_a();
        }
        return this.java_lang_Object_a(bfs2, object);
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, Object object) {
        return this.var_bhv_a.a(bdc2, bfs2, object);
    }

    @Override
    public Object b(bdc bdc2, bfs bfs2) {
        return this.f(bdc2, bfs2);
    }

    protected Object d(bdc bdc2, bfs bfs2) {
        if (this.var_bhv_a != false) {
            return this.l(bdc2, bfs2);
        }
        Object object = ((bir)((Object)this.var_bhv_a)).a(bfs2);
        if (this.var_bhv_a != null) {
            this.void_a(bfs2, object);
        }
        Class<?> clazz = this.d ? bfs2.a() : null;
        bio[] bioArray = this.var_bio_arr_a;
        int n2 = 0;
        int n3 = bioArray.length;
        while (true) {
            if (bdc2.bdf_a() == bdf.var_bdf_e) {
                return object;
            }
            if (n2 == n3) break;
            bio bio2 = bioArray[n2];
            ++n2;
            if (bio2 != null && (clazz == null || bio2.a(clazz))) {
                try {
                    bio2.java_lang_Object_a(bdc2, bfs2, object);
                }
                catch (Exception exception) {
                    this.a(exception, object, bio2.java_lang_String_a(), bfs2);
                }
                continue;
            }
            bdc2.bdc_a();
        }
        if (!this.c && bfs2.a(bfu.e)) {
            bfs2.a(this, bdf.var_bdf_e, "Unexpected JSON value(s); expected at most %d properties (in JSON Array)", n3);
        }
        while (bdc2.bdf_a() != bdf.var_bdf_e) {
            bdc2.bdc_a();
        }
        return object;
    }

    @Override
    protected final Object c(bdc bdc2, bfs bfs2) {
        bhv bhv2 = this.var_bhv_a;
        bjr bjr2 = ((bjo)((Object)bhv2)).a(bdc2, bfs2, (bjl)((Object)this.var_bhv_a));
        bio[] bioArray = this.var_bio_arr_a;
        int n2 = bioArray.length;
        Class<?> clazz = this.d ? bfs2.a() : null;
        int n3 = 0;
        Object object = null;
        while (bdc2.bdf_a() != bdf.var_bdf_e) {
            block19: {
                bio bio2;
                bio bio3 = bio2 = n3 < n2 ? bioArray[n3] : null;
                if (bio2 == null) {
                    bdc2.bdc_a();
                } else if (clazz != null && !bio2.a(clazz)) {
                    bdc2.bdc_a();
                } else if (object != null) {
                    try {
                        object = bio2.java_lang_Object_a(bdc2, bfs2, object);
                    }
                    catch (Exception exception) {
                        this.a(exception, object, bio2.java_lang_String_a(), bfs2);
                    }
                } else {
                    String string = bio2.java_lang_String_a();
                    bio bio4 = ((bjo)((Object)bhv2)).a(string);
                    if (!bjr2.a(string) || bio4 != null) {
                        if (bio4 != null) {
                            if (bjr2.boolean_a(bio4, bio4.java_lang_Object_a(bdc2, bfs2))) {
                                try {
                                    object = ((bjo)((Object)bhv2)).a(bfs2, bjr2);
                                }
                                catch (Exception exception) {
                                    this.a(exception, ((bfw)((Object)this.var_bhv_a)).a(), string, bfs2);
                                    break block19;
                                }
                                if (object.getClass() != ((bfw)((Object)this.var_bhv_a)).a()) {
                                    return bfs2.b((bfw)((Object)this.var_bhv_a), String.format("Cannot support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", buk.a((bfw)((Object)this.var_bhv_a)), object.getClass().getName()));
                                }
                            }
                        } else {
                            bjr2.void_a(bio2, bio2.java_lang_Object_a(bdc2, bfs2));
                        }
                    }
                }
            }
            ++n3;
        }
        if (object == null) {
            try {
                object = ((bjo)((Object)bhv2)).a(bfs2, bjr2);
            }
            catch (Exception exception) {
                return this.java_lang_Object_a(exception, bfs2);
            }
        }
        return object;
    }

    protected Object f(bdc bdc2, bfs bfs2) {
        String string = "Cannot deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array";
        return bfs2.a(this.bfw_a(bfs2), bdc2.bdf_c(), bdc2, string, new Object[]{((Class)((bfw)((Object)this.var_bhv_a)).a()).getName(), bdc2.bdf_c()});
    }
}

