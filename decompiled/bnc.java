/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class bnc
extends bfn
implements Serializable {
    private static final Class<? extends Annotation>[] var_java_lang_Class___extends_java_lang_annotation_Annotation__arr_a;
    private static final Class<? extends Annotation>[] b;
    private static final bma var_bma_a;
    protected transient buq<Class<?>, Boolean> cfr_renamed_30;
    protected boolean var_boolean_a;

    public bnc() {
        this.var_java_lang_Class___extends_java_lang_annotation_Annotation__arr_a = new buq(48, 48);
        this.var_boolean_a = true;
    }

    @Override
    public boolean a(Annotation annotation) {
        Class<? extends Annotation> clazz = annotation.annotationType();
        Boolean bl2 = (Boolean)this.var_java_lang_Class___extends_java_lang_annotation_Annotation__arr_a.a(clazz);
        if (bl2 == null) {
            bl2 = clazz.getAnnotation(baz.class) != null;
            this.var_java_lang_Class___extends_java_lang_annotation_Annotation__arr_a.b(clazz, bl2);
        }
        return bl2;
    }

    @Override
    public String[] a(Class<?> clazz, Enum<?>[] enumArray, String[] stringArray) {
        HashMap<String, String> hashMap = null;
        for (Field object : clazz.getDeclaredFields()) {
            String string;
            bbw bbw2;
            if (!object.isEnumConstant() || (bbw2 = object.getAnnotation(bbw.class)) == null || (string = bbw2.java_lang_String_a()).isEmpty()) continue;
            if (hashMap == null) {
                hashMap = new HashMap<String, String>();
            }
            hashMap.put(object.getName(), string);
        }
        if (hashMap != null) {
            int n2 = enumArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                String string = enumArray[i2].name();
                String string2 = (String)hashMap.get(string);
                if (string2 == null) continue;
                stringArray[i2] = string2;
            }
        }
        return stringArray;
    }

    @Override
    public void a(Class<?> clazz, Enum<?>[] enumArray, String[][] stringArray) {
        for (Field field : clazz.getDeclaredFields()) {
            String[] stringArray2;
            bbb bbb2;
            if (!field.isEnumConstant() || (bbb2 = field.getAnnotation(bbb.class)) == null || (stringArray2 = bbb2.a()).length == 0) continue;
            String string = field.getName();
            int n2 = enumArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!string.equals(enumArray[i2].name())) continue;
                stringArray[i2] = stringArray2;
            }
        }
    }

    @Override
    public Enum<?> a(Class<Enum<?>> clazz) {
        return buk.a(clazz, bbi.class);
    }

    @Override
    public bgj bgj_a(bmh bmh2) {
        bca bca2 = this.a((bmg)bmh2, bca.class);
        if (bca2 == null) {
            return null;
        }
        String string = bca2.b();
        if (string != null && string.isEmpty()) {
            string = null;
        }
        return bgj.a(bca2.a(), string);
    }

    @Override
    public Boolean java_lang_Boolean_a(bmh bmh2) {
        bbq bbq2 = this.a((bmg)bmh2, bbq.class);
        return bbq2 == null ? null : Boolean.valueOf(bbq2.a());
    }

    @Override
    public bbp.a bbp$a_a(bhm<?> bhm2, bmg bmg2) {
        bbp bbp2 = this.a(bmg2, bbp.class);
        if (bbp2 == null) {
            return bbp.a.bbp$a_a();
        }
        return bbp.a.a(bbp2);
    }

    @Override
    @Deprecated
    public bbp.a bbp$a_a(bmg bmg2) {
        return this.bbp$a_a(null, bmg2);
    }

    @Override
    public bbs.a bbs$a_a(bhm<?> bhm2, bmg bmg2) {
        bbs bbs2 = this.a(bmg2, bbs.class);
        if (bbs2 == null) {
            return bbs.a.a();
        }
        return bbs.a.a(bbs2);
    }

    @Override
    public Object java_lang_Object_a(bmg bmg2) {
        String string;
        bbj bbj2 = this.a(bmg2, bbj.class);
        if (bbj2 != null && !(string = bbj2.a()).isEmpty()) {
            return string;
        }
        return null;
    }

    @Override
    public Object java_lang_Object_a(bmh bmh2) {
        bgs bgs2 = this.a((bmg)bmh2, bgs.class);
        return bgs2 == null ? null : bgs2.a();
    }

    @Override
    public bnu<?> a(bmh bmh2, bnu<?> bnu2) {
        bbe bbe2 = this.a((bmg)bmh2, bbe.class);
        return bbe2 == null ? bnu2 : bnu2.a(bbe2);
    }

    @Override
    public String java_lang_String_a(bmn bmn2) {
        Object object = this.java_lang_Object_d(bmn2);
        return object == null ? null : ((bgj)object).java_lang_String_a();
    }

    @Override
    public List<bgj> b(bmg bmg2) {
        bbb bbb2 = this.a(bmg2, bbb.class);
        if (bbb2 == null) {
            return null;
        }
        String[] stringArray = bbb2.a();
        int n2 = stringArray.length;
        if (n2 == 0) {
            return Collections.emptyList();
        }
        ArrayList<bgj> arrayList = new ArrayList<bgj>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(bgj.bgj_a(stringArray[i2]));
        }
        return arrayList;
    }

    @Override
    public boolean boolean_a(bmn bmn2) {
        return this.boolean_b((bmg)bmn2);
    }

    @Override
    public Boolean java_lang_Boolean_b(bmn bmn2) {
        bbw bbw2 = this.a((bmg)bmn2, bbw.class);
        if (bbw2 != null) {
            return bbw2.boolean_a();
        }
        return null;
    }

    @Override
    public bbw.a bbw$a_a(bmg bmg2) {
        bbw bbw2 = this.a(bmg2, bbw.class);
        if (bbw2 != null) {
            return bbw2.bbw$a_a();
        }
        return null;
    }

    @Override
    public String java_lang_String_b(bmg bmg2) {
        bbx bbx2 = this.a(bmg2, bbx.class);
        return bbx2 == null ? null : bbx2.a();
    }

    @Override
    public Integer java_lang_Integer_a(bmg bmg2) {
        int n2;
        bbw bbw2 = this.a(bmg2, bbw.class);
        if (bbw2 != null && (n2 = bbw2.int_a()) != -1) {
            return n2;
        }
        return null;
    }

    @Override
    public String java_lang_String_a(bmg bmg2) {
        bbw bbw2 = this.a(bmg2, bbw.class);
        if (bbw2 == null) {
            return null;
        }
        String string = bbw2.c();
        return string.isEmpty() ? null : string;
    }

    @Override
    public bbk.d bbk$d_a(bmg bmg2) {
        bbk bbk2 = this.a(bmg2, bbk.class);
        return bbk2 == null ? null : bbk.d.a(bbk2);
    }

    @Override
    public bfn.a bfn$a_a(bmn bmn2) {
        bbu bbu2 = this.a((bmg)bmn2, bbu.class);
        if (bbu2 != null) {
            return bfn.a.a(bbu2.a());
        }
        bbg bbg2 = this.a((bmg)bmn2, bbg.class);
        if (bbg2 != null) {
            return bfn.a.b(bbg2.a());
        }
        return null;
    }

    @Override
    public but but_a(bmn bmn2) {
        bcg bcg2 = this.a((bmg)bmn2, bcg.class);
        if (bcg2 == null || !bcg2.boolean_a()) {
            return null;
        }
        String string = bcg2.java_lang_String_a();
        String string2 = bcg2.b();
        return but.a(string, string2);
    }

    @Override
    public bba.a bba$a_a(bmn bmn2) {
        bba bba2 = this.a((bmg)bmn2, bba.class);
        if (bba2 == null) {
            return null;
        }
        bba.a a2 = bba.a.a(bba2);
        if (!a2.boolean_a()) {
            bmo bmo2;
            String string = !(bmn2 instanceof bmo) ? ((Class)bmn2.java_lang_reflect_AnnotatedElement_a()).getName() : ((bmo2 = (bmo)bmn2).int_a() == 0 ? ((Class)bmn2.java_lang_reflect_AnnotatedElement_a()).getName() : bmo2.a(0).getName());
            a2 = a2.b(string);
        }
        return a2;
    }

    @Override
    @Deprecated
    public Object java_lang_Object_a(bmn bmn2) {
        bba.a a2 = this.bba$a_a(bmn2);
        return a2 == null ? null : a2.java_lang_Object_a();
    }

    @Override
    public Class<?>[] java_lang_Class____arr_a(bmg bmg2) {
        bci bci2 = this.a(bmg2, bci.class);
        return bci2 == null ? null : bci2.a();
    }

    @Override
    public bmo a(bhm<?> bhm2, bmo bmo2, bmo bmo3) {
        Class<?> clazz = bmo2.a(0);
        Class<?> clazz2 = bmo3.a(0);
        if (clazz.isPrimitive()) {
            if (!clazz2.isPrimitive()) {
                return bmo2;
            }
        } else if (clazz2.isPrimitive()) {
            return bmo3;
        }
        if (clazz == String.class) {
            if (clazz2 != String.class) {
                return bmo2;
            }
        } else if (clazz2 == String.class) {
            return bmo3;
        }
        return null;
    }

    @Override
    public bgj a(bhm<?> bhm2, bml bml2, bgj bgj2) {
        return null;
    }

    @Override
    public bof<?> a(bhm<?> bhm2, bmh bmh2, bfw bfw2) {
        return this.a(bhm2, (bmg)bmh2, bfw2);
    }

    @Override
    public bof<?> a(bhm<?> bhm2, bmn bmn2, bfw bfw2) {
        if (bfw2.m() || bfw2.a() != false) {
            return null;
        }
        return this.a(bhm2, (bmg)bmn2, bfw2);
    }

    @Override
    public bof<?> b(bhm<?> bhm2, bmn bmn2, bfw bfw2) {
        if (bfw2.bfw_c() == null) {
            throw new IllegalArgumentException("Must call method with a container or reference type (got " + bfw2 + ")");
        }
        return this.a(bhm2, (bmg)bmn2, bfw2);
    }

    @Override
    public List<bnz> a(bmg bmg2) {
        bcc bcc2 = this.a(bmg2, bcc.class);
        if (bcc2 == null) {
            return null;
        }
        bcc.a[] aArray = bcc2.a();
        ArrayList<bnz> arrayList = new ArrayList<bnz>(aArray.length);
        for (bcc.a a2 : aArray) {
            arrayList.add(new bnz(a2.a(), a2.java_lang_String_a()));
            for (String string : a2.java_lang_String_arr_a()) {
                arrayList.add(new bnz(a2.a(), string));
            }
        }
        return arrayList;
    }

    @Override
    public String java_lang_String_a(bmh bmh2) {
        bcf bcf2 = this.a((bmg)bmh2, bcf.class);
        return bcf2 == null ? null : bcf2.a();
    }

    @Override
    public Boolean java_lang_Boolean_a(bmn bmn2) {
        return this.a((bmg)bmn2, (Class<? extends Annotation>)bcd.class);
    }

    @Override
    public bni bni_a(bmg bmg2) {
        bbm bbm2 = this.a(bmg2, bbm.class);
        if (bbm2 == null || bbm2.a() == bcl.b.class) {
            return null;
        }
        bgj bgj2 = bgj.bgj_a(bbm2.a());
        return new bni(bgj2, bbm2.c(), bbm2.a(), bbm2.b());
    }

    @Override
    public bni a(bmg bmg2, bni bni2) {
        bbn bbn2 = this.a(bmg2, bbn.class);
        if (bbn2 == null) {
            return bni2;
        }
        if (bni2 == null) {
            bni2 = bni.bni_a();
        }
        return bni2.a(bbn2.a());
    }

    @Override
    public Object java_lang_Object_b(bmg bmg2) {
        Object object;
        bgu bgu2 = this.a(bmg2, bgu.class);
        if (bgu2 != null && (object = bgu2.a()) != bgb.a.class) {
            return object;
        }
        object = this.a(bmg2, bbz.class);
        if (object != null && object.a()) {
            AnnotatedElement annotatedElement = bmg2.java_lang_reflect_AnnotatedElement_a();
            return new bst((Class<?>)annotatedElement);
        }
        return null;
    }

    @Override
    public Object java_lang_Object_c(bmg bmg2) {
        Class<? extends bgb> clazz;
        bgu bgu2 = this.a(bmg2, bgu.class);
        if (bgu2 != null && (clazz = bgu2.c()) != bgb.a.class) {
            return clazz;
        }
        return null;
    }

    @Override
    public Object java_lang_Object_d(bmg bmg2) {
        Class<? extends bgb> clazz;
        bgu bgu2 = this.a(bmg2, bgu.class);
        if (bgu2 != null && (clazz = bgu2.b()) != bgb.a.class) {
            return clazz;
        }
        return null;
    }

    @Override
    public Object java_lang_Object_e(bmg bmg2) {
        Class<? extends bgb> clazz;
        bgu bgu2 = this.a(bmg2, bgu.class);
        if (bgu2 != null && (clazz = bgu2.d()) != bgb.a.class) {
            return clazz;
        }
        return null;
    }

    @Override
    public bbr.b bbr$b_a(bmg bmg2) {
        bbr.b b2;
        bbr bbr2 = this.a(bmg2, bbr.class);
        bbr.b b3 = b2 = bbr2 == null ? bbr.b.bbr$b_a() : bbr.b.a(bbr2);
        if (b2.bbr$a_a() == bbr.a.g) {
            b2 = this.a(bmg2, b2);
        }
        return b2;
    }

    private bbr.b a(bmg bmg2, bbr.b b2) {
        bgu bgu2 = this.a(bmg2, bgu.class);
        if (bgu2 != null) {
            switch (bgu2.bgu$a_a()) {
                case var_bgu$a_a: {
                    return b2.a(bbr.a.var_bbr$a_a);
                }
                case b: {
                    return b2.a(bbr.a.b);
                }
                case c: {
                    return b2.a(bbr.a.e);
                }
                case d: {
                    return b2.a(bbr.a.d);
                }
            }
        }
        return b2;
    }

    @Override
    public bgu.b bgu$b_a(bmg bmg2) {
        bgu bgu2 = this.a(bmg2, bgu.class);
        return bgu2 == null ? null : bgu2.bgu$b_a();
    }

    @Override
    public Object java_lang_Object_f(bmg bmg2) {
        bgu bgu2 = this.a(bmg2, bgu.class);
        return bgu2 == null ? null : this.a(bgu2.h(), bum.a.class);
    }

    @Override
    public Object java_lang_Object_b(bmn bmn2) {
        bgu bgu2 = this.a((bmg)bmn2, bgu.class);
        return bgu2 == null ? null : this.a(bgu2.i(), bum.a.class);
    }

    @Override
    public bfw a(bhm<?> bhm2, bmg bmg2, bfw bfw2) {
        Object t2;
        Class<?> clazz;
        bfw bfw3;
        bgu bgu2;
        btz btz2;
        bfw bfw4;
        block26: {
            Class<?> clazz2;
            bfw4 = bfw2;
            btz2 = bhm2.btz_a();
            bgu2 = this.a(bmg2, bgu.class);
            Class<?> clazz3 = clazz2 = bgu2 == null ? null : this.a(bgu2.e());
            if (clazz2 != null) {
                if (bfw4.boolean_a(clazz2)) {
                    bfw4 = bfw4.bfw_a();
                } else {
                    bfw3 = bfw4.a();
                    try {
                        if (clazz2.isAssignableFrom((Class<?>)((Object)bfw3))) {
                            bfw4 = btz2.b(bfw4, clazz2);
                            break block26;
                        }
                        if (((Class)((Object)bfw3)).isAssignableFrom(clazz2)) {
                            bfw4 = btz2.bfw_a(bfw4, clazz2);
                            break block26;
                        }
                        if (this.a((Class<?>)((Object)bfw3), clazz2)) {
                            bfw4 = bfw4.bfw_a();
                            break block26;
                        }
                        throw new bfy(null, String.format("Cannot refine serialization type %s into %s; types not related", bfw4, clazz2.getName()));
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        throw new bfy(null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", bfw4, clazz2.getName(), bmg2.java_lang_String_a(), illegalArgumentException.getMessage()), (Throwable)illegalArgumentException);
                    }
                }
            }
        }
        if (bfw4.o()) {
            bfw3 = bfw4.bfw_b();
            Class<?> clazz4 = clazz = bgu2 == null ? null : this.a(bgu2.f());
            if (clazz != null) {
                block27: {
                    if (bfw3.boolean_a(clazz)) {
                        bfw3 = bfw3.bfw_a();
                    } else {
                        t2 = bfw3.a();
                        try {
                            if (clazz.isAssignableFrom((Class<?>)t2)) {
                                bfw3 = btz2.b(bfw3, clazz);
                                break block27;
                            }
                            if (((Class)t2).isAssignableFrom(clazz)) {
                                bfw3 = btz2.bfw_a(bfw3, clazz);
                                break block27;
                            }
                            if (this.a((Class<?>)t2, clazz)) {
                                bfw3 = bfw3.bfw_a();
                                break block27;
                            }
                            throw new bfy(null, String.format("Cannot refine serialization key type %s into %s; types not related", bfw3, clazz.getName()));
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            throw new bfy(null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", bfw4, clazz.getName(), bmg2.java_lang_String_a(), illegalArgumentException.getMessage()), (Throwable)illegalArgumentException);
                        }
                    }
                }
                bfw4 = ((btr)bfw4).btr_a(bfw3);
            }
        }
        if ((bfw3 = bfw4.bfw_c()) != null) {
            Class<?> clazz5 = clazz = bgu2 == null ? null : this.a(bgu2.g());
            if (clazz != null) {
                block28: {
                    if (bfw3.boolean_a(clazz)) {
                        bfw3 = bfw3.bfw_a();
                    } else {
                        t2 = bfw3.a();
                        try {
                            if (clazz.isAssignableFrom((Class<?>)t2)) {
                                bfw3 = btz2.b(bfw3, clazz);
                                break block28;
                            }
                            if (((Class)t2).isAssignableFrom(clazz)) {
                                bfw3 = btz2.bfw_a(bfw3, clazz);
                                break block28;
                            }
                            if (this.a((Class<?>)t2, clazz)) {
                                bfw3 = bfw3.bfw_a();
                                break block28;
                            }
                            throw new bfy(null, String.format("Cannot refine serialization content type %s into %s; types not related", bfw3, clazz.getName()));
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            throw new bfy(null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", bfw4, clazz.getName(), bmg2.java_lang_String_a(), illegalArgumentException.getMessage()), (Throwable)illegalArgumentException);
                        }
                    }
                }
                bfw4 = bfw4.b(bfw3);
            }
        }
        return bfw4;
    }

    @Override
    public String[] java_lang_String_arr_a(bmh bmh2) {
        bby bby2 = this.a((bmg)bmh2, bby.class);
        return bby2 == null ? null : bby2.java_lang_String_arr_a();
    }

    @Override
    public Boolean java_lang_Boolean_a(bmg bmg2) {
        return this.java_lang_Object_f(bmg2);
    }

    @Override
    private final Boolean java_lang_Boolean_f(bmg bmg2) {
        bby bby2 = this.a(bmg2, bby.class);
        if (bby2 != null && bby2.boolean_a()) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override
    public void a(bhm<?> bhm2, bmh bmh2, List<bqb> list) {
        bgq bgq2 = this.a((bmg)bmh2, bgq.class);
        if (bgq2 == null) {
            return;
        }
        boolean bl2 = bgq2.boolean_a();
        bfw bfw2 = null;
        bgq.a[] aArray = bgq2.bgq$a_arr_a();
        int n2 = aArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (bfw2 == null) {
                bfw2 = bhm2.bfw_a(Object.class);
            }
            bqb bqb2 = this.a(aArray[i2], bhm2, bmh2, bfw2);
            if (bl2) {
                list.add(i2, bqb2);
                continue;
            }
            list.add(bqb2);
        }
        bgq.b[] bArray = bgq2.bgq$b_arr_a();
        int n3 = bArray.length;
        for (n2 = 0; n2 < n3; ++n2) {
            bqb bqb3 = this.a(bArray[n2], bhm2, bmh2);
            if (bl2) {
                list.add(n2, bqb3);
                continue;
            }
            list.add(bqb3);
        }
    }

    protected bqb a(bgq.a a2, bhm<?> bhm2, bmh bmh2, bfw bfw2) {
        bgi bgi2 = a2.boolean_a() ? bgi.var_bgi_a : bgi.var_bgi_b;
        String string = a2.java_lang_String_a();
        bgj bgj2 = this.a(a2.b(), a2.c());
        if (!bgj2.boolean_a()) {
            bgj2 = bgj.bgj_a(string);
        }
        bnt bnt2 = new bnt(bmh2, (Class<?>)bmh2.java_lang_reflect_AnnotatedElement_a(), string, bfw2);
        bvc bvc2 = bvc.a(bhm2, (bmn)bnt2, bgj2, bgi2, a2.bbr$a_a());
        return bqt.a(string, bvc2, bmh2.bud_a(), bfw2);
    }

    protected bqb a(bgq.b b2, bhm<?> bhm2, bmh bmh2) {
        bqs bqs2;
        bgi bgi2 = b2.boolean_a() ? bgi.var_bgi_a : bgi.var_bgi_b;
        bgj bgj2 = this.a(b2.java_lang_String_a(), b2.b());
        bfw bfw2 = bhm2.bfw_a(b2.b());
        bnt bnt2 = new bnt(bmh2, (Class<?>)bmh2.java_lang_reflect_AnnotatedElement_a(), bgj2.java_lang_String_a(), bfw2);
        bvc bvc2 = bvc.a(bhm2, (bmn)bnt2, bgj2, bgi2, b2.bbr$a_a());
        Class<? extends bqs> clazz = b2.a();
        bhl bhl2 = bhm2.bhl_a();
        bqs bqs3 = bqs2 = bhl2 == null ? null : bhl2.a(bhm2, clazz);
        if (bqs2 == null) {
            bqs2 = (bqs)buk.a(clazz, bhm2.c());
        }
        return bqs2.a(bhm2, bmh2, bvc2, bfw2);
    }

    @Override
    public bgj bgj_b(bmg bmg2) {
        Object object;
        boolean bl2 = false;
        bbl bbl2 = this.a(bmg2, bbl.class);
        if (bbl2 != null) {
            object = bbl2.a();
            if (!((String)object).isEmpty()) {
                return bgj.bgj_a((String)object);
            }
            bl2 = true;
        }
        if ((object = this.a(bmg2, bbw.class)) != null) {
            String string = object.b();
            if (string != null && string.isEmpty()) {
                string = null;
            }
            return bgj.a(object.java_lang_String_a(), string);
        }
        if (bl2 || this.a(bmg2, var_java_lang_Class___extends_java_lang_annotation_Annotation__arr_a)) {
            return bgj.var_bgj_a;
        }
        return null;
    }

    @Override
    public Boolean java_lang_Boolean_a(bhm<?> bhm2, bmg bmg2) {
        bbt bbt2 = this.a(bmg2, bbt.class);
        if (bbt2 == null) {
            return null;
        }
        return bbt2.a();
    }

    @Override
    public Boolean java_lang_Boolean_b(bmg bmg2) {
        bch bch2 = this.a(bmg2, bch.class);
        if (bch2 == null) {
            return null;
        }
        return bch2.a();
    }

    @Override
    public Boolean java_lang_Boolean_c(bmg bmg2) {
        bbc bbc2 = this.a(bmg2, bbc.class);
        if (bbc2 == null) {
            return null;
        }
        return bbc2.a();
    }

    @Override
    @Deprecated
    public boolean b(bmo bmo2) {
        return this.a((bmg)bmo2, (Class<? extends Annotation>)bbc.class);
    }

    @Override
    @Deprecated
    public boolean a(bmo bmo2) {
        bch bch2 = this.a((bmg)bmo2, bch.class);
        return bch2 != null && bch2.a();
    }

    @Override
    public Object g(bmg bmg2) {
        Class<? extends bfx> clazz;
        bgr bgr2 = this.a(bmg2, bgr.class);
        if (bgr2 != null && (clazz = bgr2.a()) != bfx.a.class) {
            return clazz;
        }
        return null;
    }

    @Override
    public Object h(bmg bmg2) {
        Class<? extends bgc> clazz;
        bgr bgr2 = this.a(bmg2, bgr.class);
        if (bgr2 != null && (clazz = bgr2.c()) != bgc.a.class) {
            return clazz;
        }
        return null;
    }

    @Override
    public Object i(bmg bmg2) {
        Class<? extends bfx> clazz;
        bgr bgr2 = this.a(bmg2, bgr.class);
        if (bgr2 != null && (clazz = bgr2.b()) != bfx.a.class) {
            return clazz;
        }
        return null;
    }

    @Override
    public Object j(bmg bmg2) {
        bgr bgr2 = this.a(bmg2, bgr.class);
        return bgr2 == null ? null : this.a(bgr2.e(), bum.a.class);
    }

    @Override
    public Object c(bmn bmn2) {
        bgr bgr2 = this.a((bmg)bmn2, bgr.class);
        return bgr2 == null ? null : this.a(bgr2.f(), bum.a.class);
    }

    @Override
    public bfw b(bhm<?> bhm2, bmg bmg2, bfw bfw2) {
        Class<?> clazz;
        bfw bfw3;
        Class<?> clazz2;
        bfw bfw4 = bfw2;
        btz btz2 = bhm2.btz_a();
        bgr bgr2 = this.a(bmg2, bgr.class);
        Class<?> clazz3 = clazz2 = bgr2 == null ? null : this.a(bgr2.g());
        if (clazz2 != null && !bfw4.boolean_a(clazz2) && !this.a(bfw4, clazz2)) {
            try {
                bfw4 = btz2.bfw_a(bfw4, clazz2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new bfy(null, String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", bfw4, clazz2.getName(), bmg2.java_lang_String_a(), illegalArgumentException.getMessage()), (Throwable)illegalArgumentException);
            }
        }
        if (bfw4.o()) {
            bfw3 = bfw4.bfw_b();
            Class<?> clazz4 = clazz = bgr2 == null ? null : this.a(bgr2.h());
            if (clazz != null && !this.a(bfw3, clazz)) {
                try {
                    bfw3 = btz2.bfw_a(bfw3, clazz);
                    bfw4 = ((btr)bfw4).btr_a(bfw3);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    throw new bfy(null, String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", bfw4, clazz.getName(), bmg2.java_lang_String_a(), illegalArgumentException.getMessage()), (Throwable)illegalArgumentException);
                }
            }
        }
        if ((bfw3 = bfw4.bfw_c()) != null) {
            Class<?> clazz5 = clazz = bgr2 == null ? null : this.a(bgr2.i());
            if (clazz != null && !this.a(bfw3, clazz)) {
                try {
                    bfw3 = btz2.bfw_a(bfw3, clazz);
                    bfw4 = bfw4.b(bfw3);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    throw new bfy(null, String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", bfw4, clazz.getName(), bmg2.java_lang_String_a(), illegalArgumentException.getMessage()), (Throwable)illegalArgumentException);
                }
            }
        }
        return bfw4;
    }

    @Override
    public Object b(bmh bmh2) {
        bgx bgx2 = this.a((bmg)bmh2, bgx.class);
        return bgx2 == null ? null : bgx2.a();
    }

    @Override
    public Class<?> a(bmh bmh2) {
        bgr bgr2 = this.a((bmg)bmh2, bgr.class);
        return bgr2 == null ? null : this.a(bgr2.d());
    }

    @Override
    public bgt.a bgt$a_a(bmh bmh2) {
        bgt bgt2 = this.a((bmg)bmh2, bgt.class);
        return bgt2 == null ? null : new bgt.a(bgt2);
    }

    @Override
    public bgj bgj_c(bmg bmg2) {
        Object object;
        boolean bl2 = false;
        bcb bcb2 = this.a(bmg2, bcb.class);
        if (bcb2 != null) {
            object = bcb2.java_lang_String_a();
            if (((String)object).isEmpty()) {
                bl2 = true;
            } else {
                return bgj.bgj_a((String)object);
            }
        }
        if ((object = this.a(bmg2, bbw.class)) != null) {
            String string = object.b();
            if (string != null && string.isEmpty()) {
                string = null;
            }
            return bgj.a(object.java_lang_String_a(), string);
        }
        if (bl2 || this.a(bmg2, b)) {
            return bgj.var_bgj_a;
        }
        return null;
    }

    @Override
    public Boolean java_lang_Boolean_d(bmg bmg2) {
        bbd bbd2 = this.a(bmg2, bbd.class);
        return bbd2 == null ? null : Boolean.valueOf(bbd2.a());
    }

    @Override
    public bcb.a bcb$a_a(bmg bmg2) {
        return bcb.a.a(this.a(bmg2, bcb.class));
    }

    @Override
    public Boolean java_lang_Boolean_e(bmg bmg2) {
        bbv bbv2 = this.a(bmg2, bbv.class);
        return bbv2 == null ? null : bbv2.a().a();
    }

    @Override
    @Deprecated
    public boolean boolean_a(bmg bmg2) {
        Boolean bl2;
        bbh bbh2 = this.a(bmg2, bbh.class);
        if (bbh2 != null) {
            return bbh2.a() != bbh.a.d;
        }
        if (this.var_boolean_a && bmg2 instanceof bmj && var_bma_a != null && (bl2 = var_bma_a.b(bmg2)) != null) {
            return bl2;
        }
        return false;
    }

    @Override
    @Deprecated
    public bbh.a bbh$a_a(bmg bmg2) {
        bbh bbh2 = this.a(bmg2, bbh.class);
        return bbh2 == null ? null : bbh2.a();
    }

    @Override
    public bbh.a bbh$a_a(bhm<?> bhm2, bmg bmg2) {
        Boolean bl2;
        bbh bbh2 = this.a(bmg2, bbh.class);
        if (bbh2 != null) {
            return bbh2.a();
        }
        if (this.var_boolean_a && bhm2.a(bgd.l) && bmg2 instanceof bmj && var_bma_a != null && (bl2 = var_bma_a.b(bmg2)) != null && bl2.booleanValue()) {
            return bbh.a.c;
        }
        return null;
    }

    protected boolean boolean_b(bmg bmg2) {
        Boolean bl2;
        bbo bbo2 = this.a(bmg2, bbo.class);
        if (bbo2 != null) {
            return bbo2.a();
        }
        if (var_bma_a != null && (bl2 = var_bma_a.a(bmg2)) != null) {
            return bl2;
        }
        return false;
    }

    protected Class<?> a(Class<?> clazz) {
        if (clazz == null || buk.c(clazz)) {
            return null;
        }
        return clazz;
    }

    protected Class<?> a(Class<?> clazz, Class<?> clazz2) {
        return (clazz = this.a(clazz)) == null || clazz == clazz2 ? null : clazz;
    }

    protected bgj a(String string, String string2) {
        if (string.isEmpty()) {
            return bgj.var_bgj_a;
        }
        if (string2 == null || string2.isEmpty()) {
            return bgj.bgj_a(string);
        }
        return bgj.a(string, string2);
    }

    @Override
    protected bgj bgj_d(bmg bmg2) {
        bgj bgj2;
        bmr bmr2;
        bms bms2;
        if (bmg2 instanceof bmr && (bms2 = (bmr2 = (bmr)bmg2).bms_a()) != null && var_bma_a != null && (bgj2 = var_bma_a.a(bmr2)) != null) {
            return bgj2;
        }
        return null;
    }

    protected bof<?> a(bhm<?> bhm2, bmg bmg2, bfw bfw2) {
        boe boe2;
        bow bow2;
        bce bce2 = this.a(bmg2, bce.class);
        bgw bgw2 = this.a(bmg2, bgw.class);
        if (bgw2 != null) {
            if (bce2 == null) {
                return null;
            }
            bow2 = bhm2.a(bmg2, (Class<bof<?>>)bgw2.a());
        } else {
            if (bce2 == null) {
                return null;
            }
            if (bce2.bce$b_a() == bce.b.var_bce$b_a) {
                return this.b();
            }
            bow2 = this.bow_a();
        }
        bgv bgv2 = this.a(bmg2, bgv.class);
        boe boe3 = boe2 = bgv2 == null ? null : bhm2.a(bmg2, (Class<boe>)bgv2.a());
        if (boe2 != null) {
            boe2.a(bfw2);
        }
        bow2 = bow2.a(bce2.bce$b_a(), boe2);
        bce.a a2 = bce2.bce$a_a();
        if (a2 == bce.a.d && bmg2 instanceof bmh) {
            a2 = bce.a.var_bce$a_a;
        }
        bow2 = bow2.a(a2);
        bow2 = bow2.a(bce2.java_lang_String_a());
        Class<?> clazz = bce2.a();
        if (clazz != bce.c.class && !clazz.isAnnotation()) {
            bow2 = bow2.a(clazz);
        }
        bow2 = bow2.a(bce2.boolean_a());
        return bow2;
    }

    protected bow bow_a() {
        return new bow();
    }

    protected bow b() {
        return bow.a();
    }

    private boolean a(Class<?> clazz, Class<?> clazz2) {
        if (clazz.isPrimitive()) {
            return clazz == buk.c(clazz2);
        }
        if (clazz2.isPrimitive()) {
            return clazz2 == buk.c(clazz);
        }
        return false;
    }

    private boolean a(bfw bfw2, Class<?> clazz) {
        if (bfw2.k()) {
            return bfw2.boolean_a(buk.c(clazz));
        }
        if (clazz.isPrimitive()) {
            return clazz == buk.c(bfw2.a());
        }
        return false;
    }

    static {
        var_java_lang_Class___extends_java_lang_annotation_Annotation__arr_a = new Class[]{bgu.class, bci.class, bbk.class, bce.class, bbz.class, bcg.class, bbg.class, bbu.class};
        b = new Class[]{bgr.class, bci.class, bbk.class, bce.class, bcg.class, bbg.class, bbu.class, bbv.class};
        bma bma2 = null;
        try {
            bma2 = bma.a();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        var_bma_a = bma2;
    }
}

