/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.util.EnumMap;

public class bkl
extends bkg<EnumMap<?, ?>>
implements bib,
bim {
    protected final Class<?> var_java_lang_Class____a;
    protected bgc var_bgc_a;
    protected bfx<Object> var_bfx_java_lang_Object__a;
    protected final boc var_boc_a;
    protected final bir var_bir_a;
    protected bfx<Object> b;
    protected bjo var_bjo_a;

    public bkl(bfw bfw2, bir bir2, bgc bgc2, bfx<?> bfx2, boc boc2, bil bil2) {
        super(bfw2, bil2, null);
        this.var_java_lang_Class____a = bfw2.bfw_b().a();
        this.var_bgc_a = bgc2;
        this.var_java_lang_Class____a = bfx2;
        this.var_boc_a = boc2;
        this.var_bir_a = bir2;
    }

    protected bkl(bkl bkl2, bgc bgc2, bfx<?> bfx2, boc boc2, bil bil2) {
        super(bkl2, bil2, (Boolean)((Object)bkl2.var_java_lang_Class____a));
        this.var_java_lang_Class____a = bkl2.var_java_lang_Class____a;
        this.var_bgc_a = bgc2;
        this.var_java_lang_Class____a = bfx2;
        this.var_boc_a = boc2;
        this.var_bir_a = bkl2.var_bir_a;
        this.b = bkl2.b;
        this.var_bjo_a = bkl2.var_bjo_a;
    }

    public bkl a(bgc bgc2, bfx<?> bfx2, boc boc2, bil bil2) {
        if (bgc2 == this.var_bgc_a && bil2 == this.var_java_lang_Class____a && bfx2 == this.var_java_lang_Class____a && boc2 == this.var_boc_a) {
            return this;
        }
        return new bkl(this, bgc2, bfx2, boc2, bil2);
    }

    @Override
    public void a(bfs bfs2) {
        if (this.var_bir_a != null) {
            if (this.var_bir_a.j()) {
                bfw bfw2 = this.var_bir_a.bfw_a(bfs2.bfr_a());
                if (bfw2 == null) {
                    bfs2.b((bfw)((Object)this.var_java_lang_Class____a), String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", this.var_java_lang_Class____a, this.var_bir_a.getClass().getName()));
                }
                this.b = this.a(bfs2, bfw2, null);
            } else if (this.var_bir_a.k()) {
                bfw bfw3 = this.var_bir_a.b(bfs2.bfr_a());
                if (bfw3 == null) {
                    bfs2.b((bfw)((Object)this.var_java_lang_Class____a), String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", this.var_java_lang_Class____a, this.var_bir_a.getClass().getName()));
                }
                this.b = this.a(bfs2, bfw3, null);
            } else if (this.var_bir_a.l()) {
                bio[] bioArray = this.var_bir_a.bio_arr_a(bfs2.bfr_a());
                this.var_bjo_a = bjo.a(bfs2, this.var_bir_a, bioArray, bfs2.a(bgd.v));
            }
        }
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        bgc bgc2 = this.var_bgc_a;
        if (bgc2 == null) {
            bgc2 = bfs2.a(((bfw)((Object)this.var_java_lang_Class____a)).bfw_b(), bfp2);
        }
        bfx<Object> bfx2 = this.var_java_lang_Class____a;
        bfw bfw2 = ((bfw)((Object)this.var_java_lang_Class____a)).bfw_c();
        bfx2 = bfx2 == null ? bfs2.a(bfw2, bfp2) : bfs2.b(bfx2, bfp2, bfw2);
        boc boc2 = this.var_boc_a;
        if (boc2 != null) {
            boc2 = boc2.a(bfp2);
        }
        return this.a(bgc2, bfx2, boc2, this.a(bfs2, bfp2, bfx2));
    }

    @Override
    public boolean boolean_a() {
        return this.var_java_lang_Class____a == null && this.var_bgc_a == null && this.var_boc_a == null;
    }

    @Override
    public btq btq_a() {
        return btq.c;
    }

    @Override
    public bfx<Object> a() {
        return this.var_java_lang_Class____a;
    }

    @Override
    public bir bir_a() {
        return this.var_bir_a;
    }

    @Override
    public Object b(bfs bfs2) {
        return this.a(bfs2);
    }

    @Override
    public EnumMap<?, ?> a(bdc bdc2, bfs bfs2) {
        if (this.var_bjo_a != null) {
            return this.b(bdc2, bfs2);
        }
        if (this.b != null) {
            return (EnumMap)this.var_bir_a.a(bfs2, this.b.a(bdc2, bfs2));
        }
        switch (bdc2.int_a()) {
            case 1: 
            case 2: 
            case 5: {
                return this.a(bdc2, bfs2, this.a(bfs2));
            }
            case 6: {
                return (EnumMap)this.r(bdc2, bfs2);
            }
            case 3: {
                return (EnumMap)this.e(bdc2, bfs2);
            }
        }
        return (EnumMap)bfs2.a(this.bfw_a(bfs2), bdc2);
    }

    @Override
    public EnumMap<?, ?> a(bdc bdc2, bfs bfs2, EnumMap enumMap) {
        Enum enum_;
        String string;
        bdc2.a(enumMap);
        Class<?> clazz = this.var_java_lang_Class____a;
        boc boc2 = this.var_boc_a;
        if (bdc2.boolean_d()) {
            string = bdc2.java_lang_String_a();
        } else {
            enum_ = bdc2.bdf_c();
            if (enum_ != bdf.f) {
                if (enum_ == bdf.var_bdf_c) {
                    return enumMap;
                }
                bfs2.a(this, bdf.f, null, new Object[0]);
            }
            string = bdc2.java_lang_String_d();
        }
        while (string != null) {
            block11: {
                enum_ = (Enum)this.var_bgc_a.a(string, bfs2);
                bdf bdf2 = bdc2.bdf_a();
                if (enum_ == null) {
                    if (!bfs2.a(bfu.x)) {
                        return (EnumMap)bfs2.b(this.var_java_lang_Class____a, string, "value not one of declared Enum instance names for %s", ((bfw)((Object)this.var_java_lang_Class____a)).bfw_b());
                    }
                    bdc2.bdc_a();
                } else {
                    Object object;
                    block12: {
                        try {
                            if (bdf2 == bdf.m) {
                                if (this.var_java_lang_Class____a != false) break block11;
                                object = this.var_java_lang_Class____a.a(bfs2);
                                break block12;
                            }
                            object = boc2 == null ? ((bfx)((Object)clazz)).a(bdc2, bfs2) : ((bfx)((Object)clazz)).a(bdc2, bfs2, boc2);
                        }
                        catch (Exception exception) {
                            return (EnumMap)this.a(bfs2, exception, enumMap, string);
                        }
                    }
                    enumMap.put(enum_, object);
                }
            }
            string = bdc2.java_lang_String_a();
        }
        return enumMap;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.java_lang_Object_a(bdc2, bfs2);
    }

    @Override
    protected EnumMap<?, ?> a(bfs bfs2) {
        if (this.var_bir_a == null) {
            return new EnumMap(this.var_java_lang_Class____a);
        }
        try {
            if (!this.var_bir_a.i()) {
                return (EnumMap)bfs2.a(this.a(), this.bir_a(), null, "no default constructor found", new Object[0]);
            }
            return (EnumMap)this.var_bir_a.a(bfs2);
        }
        catch (IOException iOException) {
            return (EnumMap)((Object)buk.a(bfs2, iOException));
        }
    }

    public EnumMap<?, ?> b(bdc bdc2, bfs bfs2) {
        bjo bjo2 = this.var_bjo_a;
        bjr bjr2 = bjo2.a(bdc2, bfs2, null);
        String string = bdc2.boolean_d() ? bdc2.java_lang_String_a() : (bdc2.boolean_a(bdf.f) ? bdc2.java_lang_String_d() : null);
        while (string != null) {
            block14: {
                Object object;
                bdf bdf2 = bdc2.bdf_a();
                bio bio2 = bjo2.a(string);
                if (bio2 != null) {
                    if (bjr2.boolean_a(bio2, bio2.java_lang_Object_a(bdc2, bfs2))) {
                        bdc2.bdf_a();
                        try {
                            object = (EnumMap)bjo2.a(bfs2, bjr2);
                        }
                        catch (Exception exception) {
                            return (EnumMap)this.a(bfs2, exception, ((bfw)((Object)this.var_java_lang_Class____a)).a(), string);
                        }
                        return this.a(bdc2, bfs2, (EnumMap)object);
                    }
                } else {
                    object = (Enum)this.var_bgc_a.a(string, bfs2);
                    if (object == null) {
                        if (!bfs2.a(bfu.x)) {
                            return (EnumMap)bfs2.b(this.var_java_lang_Class____a, string, "value not one of declared Enum instance names for %s", ((bfw)((Object)this.var_java_lang_Class____a)).bfw_b());
                        }
                        bdc2.bdf_a();
                        bdc2.bdc_a();
                    } else {
                        Object object2;
                        block15: {
                            try {
                                if (bdf2 == bdf.m) {
                                    if (this.var_java_lang_Class____a != false) break block14;
                                    object2 = this.var_java_lang_Class____a.a(bfs2);
                                    break block15;
                                }
                                object2 = this.var_boc_a == null ? ((bfx)((Object)this.var_java_lang_Class____a)).a(bdc2, bfs2) : ((bfx)((Object)this.var_java_lang_Class____a)).a(bdc2, bfs2, this.var_boc_a);
                            }
                            catch (Exception exception) {
                                this.a(bfs2, exception, ((bfw)((Object)this.var_java_lang_Class____a)).a(), string);
                                return null;
                            }
                        }
                        bjr2.a(object, object2);
                    }
                }
            }
            string = bdc2.java_lang_String_a();
        }
        try {
            return (EnumMap)bjo2.a(bfs2, bjr2);
        }
        catch (Exception exception) {
            this.a(bfs2, exception, ((bfw)((Object)this.var_java_lang_Class____a)).a(), string);
            return null;
        }
    }
}

