/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bhx
extends bhr
implements Serializable {
    private static final Class<?>[] var_java_lang_Class____arr_a;
    public static final bhx var_bhx_a;

    public bhx(bhk bhk2) {
        super(bhk2);
    }

    @Override
    public bfx<Object> d(bfs bfs2, bfw bfw2, bfo bfo2) {
        bfw bfw3;
        bfr bfr2 = bfs2.bfr_a();
        bfx<Object> bfx2 = this.a(bfw2, bfr2, bfo2);
        if (bfx2 != null) {
            if (this.var_java_lang_Class____arr_a.b()) {
                for (bhy bhy2 : this.var_java_lang_Class____arr_a.c()) {
                    bfx2 = bhy2.a(bfs2.bfr_a(), bfo2, bfx2);
                }
            }
            return bfx2;
        }
        if (bfw2.boolean_e()) {
            return this.i(bfs2, bfw2, bfo2);
        }
        if (bfw2.boolean_c() && !bfw2.k() && !bfw2.g() && (bfw3 = this.bfw_a(bfs2, bfw2, bfo2)) != null) {
            bfo2 = bfr2.bfo_a(bfw3);
            return this.g(bfs2, bfw3, bfo2);
        }
        bfx2 = this.e(bfs2, bfw2, bfo2);
        if (bfx2 != null) {
            return bfx2;
        }
        if (!this.a((Class<?>)bfw2.a())) {
            return null;
        }
        this.void_a(bfs2, bfw2, bfo2);
        bfx2 = this.f(bfs2, bfw2, bfo2);
        if (bfx2 != null) {
            return bfx2;
        }
        return this.g(bfs2, bfw2, bfo2);
    }

    @Override
    public bfx<Object> a(bfs bfs2, bfw bfw2, bfo bfo2, Class<?> clazz) {
        bfw bfw3 = bfs2.a(bgd.r) ? bfs2.btz_a().a(clazz, bfw2.bty_a()) : bfs2.bfw_a(clazz);
        bfo bfo3 = bfs2.bfr_a().a(bfw3, bfo2);
        return this.h(bfs2, bfw2, bfo3);
    }

    protected bfx<?> e(bfs bfs2, bfw bfw2, bfo bfo2) {
        bfx<?> bfx2 = this.c(bfs2, bfw2, bfo2);
        if (bfx2 != null && this.var_java_lang_Class____arr_a.b()) {
            for (bhy bhy2 : this.var_java_lang_Class____arr_a.c()) {
                bfx2 = bhy2.a(bfs2.bfr_a(), bfo2, bfx2);
            }
        }
        return bfx2;
    }

    protected bfx<Object> f(bfs bfs2, bfw bfw2, bfo bfo2) {
        Object object = buh.java_lang_Object_a(bfw2);
        if (object != null && bfs2.bfr_a().a((Class<?>)bfw2.a()) == null) {
            return new bjv(bfw2, (String)object);
        }
        return null;
    }

    protected bfw bfw_a(bfs bfs2, bfw bfw2, bfo bfo2) {
        for (bfm bfm2 : this.var_java_lang_Class____arr_a.d()) {
            bfw bfw3 = bfm2.a(bfs2.bfr_a(), bfo2);
            if (bfw3 == null) continue;
            return bfw3;
        }
        return null;
    }

    public bfx<Object> g(bfs bfs2, bfw bfw2, bfo bfo2) {
        bir bir2;
        try {
            bir2 = this.bir_a(bfs2, bfo2);
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return new biy(noClassDefFoundError);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            blq blq2 = blq.a(bfs2.bdc_a(), buk.java_lang_String_a(illegalArgumentException), bfo2, null);
            blq2.initCause(illegalArgumentException);
            throw blq2;
        }
        bhw bhw2 = this.bhw_a(bfs2, bfo2);
        bhw2.a(bir2);
        this.b(bfs2, bfo2, bhw2);
        this.a(bfs2, bfo2, bhw2);
        this.c(bfs2, bfo2, bhw2);
        this.d(bfs2, bfo2, bhw2);
        bfr bfr2 = bfs2.bfr_a();
        if (this.var_java_lang_Class____arr_a.b()) {
            for (bhy object : this.var_java_lang_Class____arr_a.c()) {
                bhw2 = object.a(bfr2, bfo2, bhw2);
            }
        }
        bfx bfx2 = bfw2.boolean_c() && !bir2.boolean_a() ? bhw2.bhq_a() : bhw2.a();
        if (this.var_java_lang_Class____arr_a.b()) {
            for (bhy bhy2 : this.var_java_lang_Class____arr_a.c()) {
                bfx2 = bhy2.a(bfr2, bfo2, bfx2);
            }
        }
        return bfx2;
    }

    protected bfx<Object> h(bfs bfs2, bfw bfw2, bfo bfo2) {
        bir bir2;
        try {
            bir2 = this.bir_a(bfs2, bfo2);
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return new biy(noClassDefFoundError);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw blq.a(bfs2.bdc_a(), buk.java_lang_String_a(illegalArgumentException), bfo2, null);
        }
        bfr bfr2 = bfs2.bfr_a();
        bhw bhw2 = this.bhw_a(bfs2, bfo2);
        bhw2.a(bir2);
        this.b(bfs2, bfo2, bhw2);
        this.a(bfs2, bfo2, bhw2);
        this.c(bfs2, bfo2, bhw2);
        this.d(bfs2, bfo2, bhw2);
        bgt.a a2 = bfo2.bgt$a_a();
        String string = a2 == null ? "build" : a2.a;
        bmo bmo2 = bfo2.a(string, null);
        if (bmo2 != null && bfr2.c()) {
            buk.a(bmo2.java_lang_reflect_Method_b(), bfr2.a(bgd.o));
        }
        bhw2.a(bmo2, a2);
        if (this.var_java_lang_Class____arr_a.b()) {
            for (bhy object : this.var_java_lang_Class____arr_a.c()) {
                bhw2 = object.a(bfr2, bfo2, bhw2);
            }
        }
        bfx<?> bfx2 = bhw2.a(bfw2, string);
        if (this.var_java_lang_Class____arr_a.b()) {
            for (bhy bhy2 : this.var_java_lang_Class____arr_a.c()) {
                bfx2 = bhy2.a(bfr2, bfo2, bfx2);
            }
        }
        return bfx2;
    }

    protected void a(bfs bfs2, bfo bfo2, bhw bhw2) {
        bck bck2;
        bfw bfw2;
        bio bio2;
        Object object;
        bni bni2 = bfo2.bni_a();
        if (bni2 == null) {
            return;
        }
        Class<? extends bck<?>> clazz = bni2.b();
        bcm bcm2 = bfs2.a((bmg)bfo2.bmh_a(), bni2);
        if (clazz == bcl.c.class) {
            object = bni2.bgj_a();
            bio2 = bhw2.a((bgj)object);
            if (bio2 == null) {
                throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", buk.a(bfo2.bfw_a()), buk.a((bgj)object)));
            }
            bfw2 = bio2.bfw_a();
            bck2 = new bjp(bni2.a());
        } else {
            object = bfs2.bfw_a(clazz);
            bfw2 = bfs2.btz_a().bfw_arr_a((bfw)object, bck.class)[0];
            bio2 = null;
            bck2 = bfs2.a((bmg)bfo2.bmh_a(), bni2);
        }
        object = bfs2.b(bfw2);
        bhw2.a(bjl.a(bfw2, bni2.bgj_a(), bck2, object, bio2, bcm2));
    }

    public bfx<Object> i(bfs bfs2, bfw bfw2, bfo bfo2) {
        bfx<?> bfx2;
        Iterator<bhy> iterator;
        bfr bfr2 = bfs2.bfr_a();
        bhw bhw2 = this.bhw_a(bfs2, bfo2);
        bhw2.a(this.bir_a(bfs2, bfo2));
        this.b(bfs2, bfo2, bhw2);
        bmo bmo2 = bfo2.a("initCause", var_java_lang_Class____arr_a);
        if (bmo2 != null && (iterator = this.a(bfs2, bfo2, (bmx)((Object)(bfx2 = bvc.a(bfs2.bfr_a(), bmo2, new bgj("cause")))), bmo2.bfw_a(0))) != null) {
            bhw2.a((bio)((Object)iterator), true);
        }
        bhw2.void_a("localizedMessage");
        bhw2.void_a("suppressed");
        if (this.var_java_lang_Class____arr_a.b()) {
            bfx2 = this.var_java_lang_Class____arr_a.c().iterator();
            while (bfx2.hasNext()) {
                iterator = bfx2.next();
                bhw2 = ((bhy)((Object)iterator)).a(bfr2, bfo2, bhw2);
            }
        }
        if ((bfx2 = bhw2.a()) instanceof bht) {
            bfx2 = new bll((bht)bfx2);
        }
        if (this.var_java_lang_Class____arr_a.b()) {
            for (bhy bhy2 : this.var_java_lang_Class____arr_a.c()) {
                bfx2 = bhy2.a(bfr2, bfo2, bfx2);
            }
        }
        return bfx2;
    }

    protected bhw bhw_a(bfs bfs2, bfo bfo2) {
        return new bhw(bfo2, bfs2);
    }

    protected void b(bfs bfs2, bfo bfo2, bhw bhw2) {
        bmn bmn2;
        Set<String> set;
        Set<Object> set2;
        boolean bl2 = !bfo2.bfw_a().boolean_c();
        bio[] bioArray = bl2 ? bhw2.bir_a().bio_arr_a(bfs2.bfr_a()) : null;
        boolean bl3 = bioArray != null;
        bbp.a a2 = bfs2.bfr_a().bbp$a_a(bfo2.a(), bfo2.bmh_a());
        if (a2 != null) {
            boolean bl4 = a2.boolean_a();
            bhw2.a(bl4);
            set2 = a2.b();
            for (String iterator2 : set2) {
                bhw2.void_a(iterator2);
            }
        } else {
            set2 = Collections.emptySet();
        }
        bbs.a a3 = bfs2.bfr_a().bbs$a_a(bfo2.a(), bfo2.bmh_a());
        Object object = null;
        if (a3 != null && (object = a3.a()) != null) {
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                set = (String)iterator.next();
                bhw2.b((String)((Object)set));
            }
        }
        if ((bmn2 = bfo2.d()) != null) {
            bhw2.a(this.a(bfs2, bfo2, bmn2));
        } else {
            set = bfo2.a();
            if (set != null) {
                for (String string : set) {
                    bhw2.void_a(string);
                }
            }
        }
        boolean bl4 = bfs2.a(bgd.b) && bfs2.a(bgd.f);
        List<bmx> list = this.a(bfs2, bfo2, bhw2, bfo2.a(), set2, (Set<String>)object);
        if (this.var_java_lang_Class____arr_a.b()) {
            for (bhy bhy2 : this.var_java_lang_Class____arr_a.c()) {
                list = bhy2.a(bfs2.bfr_a(), bfo2, list);
            }
        }
        for (bmx bmx2 : list) {
            Serializable serializable;
            Object object2;
            bio bio2 = null;
            if (bmx2.boolean_e()) {
                object2 = bmx2.bmo_b();
                serializable = object2.bfw_a(0);
                bio2 = this.a(bfs2, bfo2, bmx2, (bfw)serializable);
            } else if (bmx2.f()) {
                object2 = bmx2.bml_a();
                serializable = object2.bfw_a();
                bio2 = this.a(bfs2, bfo2, bmx2, (bfw)serializable);
            } else {
                object2 = bmx2.bmo_a();
                if (object2 != null) {
                    if (bl4 && this.b((Class<?>)object2.java_lang_Object_a())) {
                        if (!bhw2.boolean_a(bmx2.java_lang_String_a())) {
                            bio2 = this.a(bfs2, bfo2, bmx2);
                        }
                    } else if (!bmx2.g() && ((bgi)(serializable = bmx2.bgi_a())).bgi$a_a() != null) {
                        bio2 = this.a(bfs2, bfo2, bmx2);
                    }
                }
            }
            if (bl3 && bmx2.g()) {
                int n2;
                object2 = bmx2.java_lang_String_a();
                serializable = null;
                Object object3 = bioArray;
                int n3 = ((bio[])object3).length;
                for (n2 = 0; n2 < n3; ++n2) {
                    bio bio3 = object3[n2];
                    if (!object2.equals(bio3.java_lang_String_a()) || !(bio3 instanceof bid)) continue;
                    serializable = (bid)bio3;
                    break;
                }
                if (serializable == null) {
                    object3 = new ArrayList();
                    bio[] bioArray2 = bioArray;
                    n2 = bioArray2.length;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        bio bio4 = bioArray2[i2];
                        object3.add(bio4.java_lang_String_a());
                    }
                    bfs2.a(bfo2, bmx2, "Could not find creator property with name %s (known Creator properties: %s)", buk.b(object2), object3);
                    continue;
                }
                if (bio2 != null) {
                    ((bid)serializable).a(bio2);
                }
                if ((object3 = bmx2.java_lang_Class____arr_a()) == null) {
                    object3 = bfo2.java_lang_Class____arr_a();
                }
                ((bio)serializable).a((Class<?>[])object3);
                bhw2.b((bio)serializable);
                continue;
            }
            if (bio2 == null) continue;
            object2 = bmx2.java_lang_Class____arr_a();
            if (object2 == null) {
                object2 = bfo2.java_lang_Class____arr_a();
            }
            bio2.a((Class<?>[])object2);
            bhw2.a(bio2);
        }
    }

    private boolean b(Class<?> clazz) {
        return Collection.class.isAssignableFrom(clazz) || Map.class.isAssignableFrom(clazz);
    }

    protected List<bmx> a(bfs bfs2, bfo bfo2, bhw bhw2, List<bmx> list, Set<String> set, Set<String> set2) {
        ArrayList<bmx> arrayList = new ArrayList<bmx>(Math.max(4, list.size()));
        HashMap hashMap = new HashMap();
        for (bmx bmx2 : list) {
            Class<?> clazz;
            String string = bmx2.java_lang_String_a();
            if (bup.a(string, set, set2)) continue;
            if (!bmx2.g() && (clazz = bmx2.a()) != null && this.a(bfs2.bfr_a(), bmx2, clazz, hashMap)) {
                bhw2.void_a(string);
                continue;
            }
            arrayList.add(bmx2);
        }
        return arrayList;
    }

    protected void c(bfs bfs2, bfo bfo2, bhw bhw2) {
        List<bmx> list = bfo2.b();
        if (list != null) {
            for (bmx bmx2 : list) {
                String string = bmx2.java_lang_String_b();
                bhw2.a(string, this.a(bfs2, bfo2, bmx2, bmx2.bfw_a()));
            }
        }
    }

    protected void d(bfs bfs2, bfo bfo2, bhw bhw2) {
        Map<Object, bmn> map = bfo2.a();
        if (map != null) {
            for (Map.Entry<Object, bmn> entry : map.entrySet()) {
                bmn bmn2 = entry.getValue();
                bhw2.a(bgj.bgj_a(bmn2.java_lang_String_a()), bmn2.bfw_a(), bfo2.bud_a(), bmn2, entry.getKey());
            }
        }
    }

    protected bin a(bfs bfs2, bfo bfo2, bmn bmn2) {
        bfx<Object> bfx2;
        bfp.b b2;
        bfw bfw2;
        bfw bfw3;
        Object object;
        if (bmn2 instanceof bmo) {
            object = (bmo)bmn2;
            bfw3 = ((bmo)object).bfw_a(0);
            bfw2 = ((bmo)object).bfw_a(1);
            bfw2 = this.a(bfs2, bmn2, bfw2);
            b2 = new bfp.b(bgj.bgj_a(bmn2.java_lang_String_a()), bfw2, null, bmn2, bgi.var_bgi_b);
        } else if (bmn2 instanceof bml) {
            object = (bml)bmn2;
            bfx2 = ((bml)object).bfw_a();
            bfx2 = this.a(bfs2, bmn2, (bfw)((Object)bfx2));
            bfw3 = ((bfw)((Object)bfx2)).bfw_b();
            bfw2 = ((bfw)((Object)bfx2)).bfw_c();
            b2 = new bfp.b(bgj.bgj_a(bmn2.java_lang_String_a()), (bfw)((Object)bfx2), null, bmn2, bgi.var_bgi_b);
        } else {
            return (bin)bfs2.b(bfo2.bfw_a(), String.format("Unrecognized mutator type for any setter: %s", bmn2.getClass()));
        }
        object = this.bgc_a(bfs2, bmn2);
        if (object == null) {
            object = (bgc)bfw3.a();
        }
        if (object == null) {
            object = bfs2.a(bfw3, b2);
        } else if (object instanceof bic) {
            object = ((bic)object).a(bfs2, b2);
        }
        bfx2 = this.b(bfs2, bmn2);
        if (bfx2 == null) {
            bfx2 = (bfx)bfw2.a();
        }
        if (bfx2 != null) {
            bfx2 = bfs2.a(bfx2, (bfp)b2, bfw2);
        }
        boc boc2 = (boc)bfw2.b();
        return new bin(b2, bmn2, bfw2, (bgc)object, bfx2, boc2);
    }

    protected bio a(bfs bfs2, bfo bfo2, bmx bmx2, bfw bfw2) {
        bni bni2;
        bfn.a a2;
        bmn bmn2 = bmx2.bmn_c();
        if (bmn2 == null) {
            bfs2.a(bfo2, bmx2, "No non-constructor mutator available", new Object[0]);
        }
        bfw bfw3 = this.a(bfs2, bmn2, bfw2);
        boc boc2 = (boc)bfw3.b();
        bio bio2 = bmn2 instanceof bmo ? new bjh(bmx2, bfw3, boc2, bfo2.bud_a(), (bmo)bmn2) : new bjb(bmx2, bfw3, boc2, bfo2.bud_a(), (bml)bmn2);
        bfx<?> bfx2 = this.a(bfs2, bmn2);
        if (bfx2 == null) {
            bfx2 = (bfx<?>)bfw3.a();
        }
        if (bfx2 != null) {
            bfx2 = bfs2.a(bfx2, (bfp)bio2, bfw3);
            bio2 = bio2.a(bfx2);
        }
        if ((a2 = bmx2.bfn$a_a()) != null && a2.boolean_a()) {
            bio2.void_a(a2.java_lang_String_a());
        }
        if ((bni2 = bmx2.bni_a()) != null) {
            bio2.a(bni2);
        }
        return bio2;
    }

    protected bio a(bfs bfs2, bfo bfo2, bmx bmx2) {
        bmo bmo2 = bmx2.bmo_a();
        bfw bfw2 = this.a(bfs2, bmo2, bmo2.bfw_a());
        boc boc2 = (boc)bfw2.b();
        bio bio2 = new bjt(bmx2, bfw2, boc2, bfo2.bud_a(), bmo2);
        bfx<?> bfx2 = this.a(bfs2, bmo2);
        if (bfx2 == null) {
            bfx2 = (bfx<?>)bfw2.a();
        }
        if (bfx2 != null) {
            bfx2 = bfs2.a(bfx2, (bfp)bio2, bfw2);
            bio2 = ((bio)bio2).a(bfx2);
        }
        return bio2;
    }

    protected boolean a(Class<?> clazz) {
        Object object = buk.java_lang_String_a(clazz);
        if (object != null) {
            throw new IllegalArgumentException("Cannot deserialize Class " + clazz.getName() + " (of type " + object + ") as a Bean");
        }
        if (buk.boolean_a(clazz)) {
            throw new IllegalArgumentException("Cannot deserialize Proxy class " + clazz.getName() + " as a Bean");
        }
        object = buk.a(clazz, true);
        if (object != null) {
            throw new IllegalArgumentException("Cannot deserialize Class " + clazz.getName() + " (of type " + object + ") as a Bean");
        }
        return true;
    }

    protected boolean a(bfr bfr2, bmx bmx2, Class<?> clazz, Map<Class<?>, Boolean> map) {
        Boolean bl2 = map.get(clazz);
        if (bl2 != null) {
            return bl2;
        }
        if (clazz == String.class || clazz.isPrimitive()) {
            bl2 = Boolean.FALSE;
        } else {
            bl2 = bfr2.bhg_a(clazz).java_lang_Boolean_a();
            if (bl2 == null) {
                bfo bfo2 = bfr2.bfo_a(clazz);
                bl2 = bfr2.bfn_a().java_lang_Boolean_a(bfo2.bmh_a());
                if (bl2 == null) {
                    bl2 = Boolean.FALSE;
                }
            }
        }
        map.put(clazz, bl2);
        return bl2;
    }

    protected void void_a(bfs bfs2, bfw bfw2, bfo bfo2) {
        boy.a().a(bfs2, bfw2, bfo2);
    }

    static {
        var_java_lang_Class____arr_a = new Class[]{Throwable.class};
        var_bhx_a = new bhx(new bhk());
    }
}

