/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bqe
extends bpy
implements Serializable {
    public static final bqe a = new bqe(null);

    protected bqe(bhp bhp2) {
        super(bhp2);
    }

    @Override
    protected Iterable<bqr> a() {
        return ((bhp)((Object)this.a)).a();
    }

    @Override
    public bgb<Object> a(bgo bgo2, bfw bfw2) {
        boolean bl2;
        bfw bfw3;
        bgm bgm2 = bgo2.bgm_a();
        bfo bfo2 = bgm2.a(bfw2);
        bgb<Object> bgb2 = this.a(bgo2, bfo2.bmh_a());
        if (bgb2 != null) {
            return bgb2;
        }
        bfn bfn2 = bgm2.bfn_a();
        if (bfn2 == null) {
            bfw3 = bfw2;
        } else {
            try {
                bfw3 = bfn2.a(bgm2, (bmg)bfo2.bmh_a(), bfw2);
            }
            catch (bfy bfy2) {
                return (bgb)bgo2.a(bfo2, bfy2.getMessage(), new Object[0]);
            }
        }
        if (bfw3 == bfw2) {
            bl2 = false;
        } else {
            bl2 = true;
            if (!bfw3.boolean_a((Class<?>)bfw2.a())) {
                bfo2 = bgm2.a(bfw3);
            }
        }
        bum<Object, Object> bum2 = bfo2.a();
        if (bum2 == null) {
            return this.d(bgo2, bfw3, bfo2, bl2);
        }
        bfw bfw4 = bum2.b(bgo2.btz_a());
        if (!bfw4.boolean_a((Class<?>)bfw3.a())) {
            bfo2 = bgm2.a(bfw4);
            bgb2 = this.a(bgo2, bfo2.bmh_a());
        }
        if (bgb2 == null && !bfw4.p()) {
            bgb2 = this.d(bgo2, bfw4, bfo2, true);
        }
        return new bsz(bum2, bfw4, bgb2);
    }

    protected bgb<?> d(bgo bgo2, bfw bfw2, bfo bfo2, boolean bl2) {
        bgb<Object> bgb2 = null;
        bgm bgm2 = bgo2.bgm_a();
        if (bfw2.m()) {
            if (!bl2) {
                bl2 = this.a(bgm2, bfo2, (bog)null);
            }
            if ((bgb2 = this.c(bgo2, bfw2, bfo2, bl2)) != null) {
                return bgb2;
            }
        } else {
            if (bfw2.a() != false) {
                bgb2 = this.a(bgo2, (btu)bfw2, bfo2, bl2);
            } else {
                bqr object;
                Iterator<Object> iterator = this.a().iterator();
                while (iterator.hasNext() && (bgb2 = (object = iterator.next()).a(bgm2, bfw2, bfo2)) == null) {
                }
            }
            if (bgb2 == null) {
                bgb2 = this.a(bgo2, bfw2, bfo2);
            }
        }
        if (bgb2 == null && (bgb2 = this.a(bfw2, bgm2, bfo2, bl2)) == null && (bgb2 = this.a(bgo2, bfw2, bfo2, bl2)) == null && (bgb2 = this.e(bgo2, bfw2, bfo2, bl2)) == null) {
            bgb2 = bgo2.b(bfo2.a());
        }
        if (bgb2 != null && ((bhp)((Object)this.a)).b()) {
            for (bqf bqf2 : ((bhp)((Object)this.a)).c()) {
                bgb2 = bqf2.a(bgm2, bfo2, bgb2);
            }
        }
        return bgb2;
    }

    public bgb<Object> e(bgo bgo2, bfw bfw2, bfo bfo2, boolean bl2) {
        if (!this.b((Class<?>)bfw2.a()) && !buk.f(bfw2.a())) {
            return null;
        }
        return this.f(bgo2, bfw2, bfo2, bl2);
    }

    public bog a(bfw bfw2, bgm bgm2, bmn bmn2) {
        bog bog2;
        bfn bfn2 = bgm2.bfn_a();
        bof<?> bof2 = bfn2.a(bgm2, bmn2, bfw2);
        if (bof2 == null) {
            bog2 = this.a(bgm2, bfw2);
        } else {
            Collection<bnz> collection = bgm2.bob_a().a(bgm2, bmn2, bfw2);
            bog2 = bof2.a(bgm2, bfw2, collection);
        }
        return bog2;
    }

    public bog b(bfw bfw2, bgm bgm2, bmn bmn2) {
        bog bog2;
        bfw bfw3 = bfw2.bfw_c();
        bfn bfn2 = bgm2.bfn_a();
        bof<?> bof2 = bfn2.b(bgm2, bmn2, bfw2);
        if (bof2 == null) {
            bog2 = this.a(bgm2, bfw3);
        } else {
            Collection<bnz> collection = bgm2.bob_a().a(bgm2, bmn2, bfw3);
            bog2 = bof2.a(bgm2, bfw3, collection);
        }
        return bog2;
    }

    protected bgb<Object> f(bgo bgo2, bfw bfw2, bfo bfo2, boolean bl2) {
        if (bfo2.a() == Object.class) {
            return bgo2.b(Object.class);
        }
        bgb<Object> bgb2 = this.b(bgo2, bfw2, bfo2);
        if (bgb2 != null) {
            return bgb2;
        }
        bgm bgm2 = bgo2.bgm_a();
        bqd bqd2 = this.a(bfo2);
        bqd2.a(bgm2);
        List<bqb> list = this.a(bgo2, bfo2, bqd2);
        list = list == null ? new ArrayList<bqb>() : this.a(bgo2, bfo2, bqd2, list);
        bgo2.bfn_a().a(bgm2, bfo2.bmh_a(), list);
        if (((bhp)((Object)this.a)).b()) {
            for (bqf iterator : ((bhp)((Object)this.a)).c()) {
                list = iterator.a(bgm2, bfo2, list);
            }
        }
        list = this.a(bgm2, bfo2, list);
        if (((bhp)((Object)this.a)).b()) {
            for (bqf bqf2 : ((bhp)((Object)this.a)).c()) {
                list = bqf2.b(bgm2, bfo2, list);
            }
        }
        bqd2.a(this.a(bgo2, bfo2, list));
        bqd2.a(list);
        bqd2.a(this.a(bgm2, bfo2));
        bmn bmn2 = bfo2.c();
        if (bmn2 != null) {
            bfw bfw3 = bmn2.bfw_a();
            bfw bfw4 = bfw3.bfw_c();
            bog bog2 = this.a(bgm2, bfw4);
            bsl bsl2 = this.a(bgo2, bmn2);
            if (bsl2 == null) {
                bsl2 = bsl.a(null, bfw3, bgm2.a(bgd.p), bog2, null, null, null);
            }
            bgj bgj2 = bgj.bgj_a(bmn2.java_lang_String_a());
            bfp.b b2 = new bfp.b(bgj2, bfw4, null, bmn2, bgi.var_bgi_b);
            bqd2.a(new bpx(b2, bmn2, bsl2));
        }
        this.a(bgm2, bqd2);
        if (((bhp)((Object)this.a)).b()) {
            for (bqf bqf3 : ((bhp)((Object)this.a)).c()) {
                bqd2 = bqf3.a(bgm2, bfo2, bqd2);
            }
        }
        try {
            bgb2 = bqd2.java_lang_Object_a();
        }
        catch (RuntimeException runtimeException) {
            return (bgb)bgo2.a(bfo2, "Failed to construct BeanSerializer for %s: (%s) %s", bfo2.bfw_a(), runtimeException.getClass().getName(), runtimeException.getMessage());
        }
        if (bgb2 == null) {
            if (bfw2.i()) {
                return bqd2.java_lang_Object_a();
            }
            bgb2 = this.a(bgm2, bfw2, bfo2, bl2);
            if (bgb2 == null && bfo2.boolean_b()) {
                return bqd2.java_lang_Object_a();
            }
        }
        return bgb2;
    }

    protected brc a(bgo bgo2, bfo bfo2, List<bqb> list) {
        bni bni2 = bfo2.bni_a();
        if (bni2 == null) {
            return null;
        }
        Class<? extends bck<?>> clazz = bni2.b();
        if (clazz == bcl.c.class) {
            String string = bni2.bgj_a().java_lang_String_a();
            bqb bqb2 = null;
            int n2 = 0;
            int n3 = list.size();
            while (true) {
                if (n2 == n3) {
                    throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", buk.a(bfo2.bfw_a()), buk.b(string)));
                }
                bqb bqb3 = list.get(n2);
                if (string.equals(bqb3.java_lang_String_a())) {
                    bqb2 = bqb3;
                    if (n2 <= 0) break;
                    list.remove(n2);
                    list.add(0, bqb2);
                    break;
                }
                ++n2;
            }
            bfw bfw2 = bqb2.bfw_a();
            brd brd2 = new brd(bni2, bqb2);
            return brc.a(bfw2, null, brd2, bni2.boolean_a());
        }
        bfw bfw3 = bgo2.a((Type)clazz);
        bfw bfw4 = bgo2.btz_a().bfw_arr_a(bfw3, bck.class)[0];
        bck<?> bck2 = bgo2.a((bmg)bfo2.bmh_a(), bni2);
        return brc.a(bfw4, bni2.bgj_a(), bck2, bni2.boolean_a());
    }

    protected bqb a(bqb bqb2, Class<?>[] classArray) {
        return bqw.a(bqb2, classArray);
    }

    @Override
    protected bqk a(bgm bgm2, bfo bfo2) {
        return new bqk(bgm2, bfo2);
    }

    protected bqd a(bfo bfo2) {
        return new bqd(bfo2);
    }

    protected boolean b(Class<?> clazz) {
        return buk.java_lang_String_a(clazz) == null && !buk.boolean_a(clazz);
    }

    protected List<bqb> a(bgo bgo2, bfo bfo2, bqd bqd2) {
        List<bmx> list = bfo2.a();
        bgm bgm2 = bgo2.bgm_a();
        this.a(bgm2, bfo2, list);
        if (bgm2.a(bgd.i)) {
            this.b(bgm2, bfo2, list);
        }
        if (list.isEmpty()) {
            return null;
        }
        boolean bl2 = this.a(bgm2, bfo2, (bog)null);
        bqk bqk2 = this.a(bgm2, bfo2);
        ArrayList<bqb> arrayList = new ArrayList<bqb>(list.size());
        for (bmx bmx2 : list) {
            bmn bmn2 = bmx2.bmn_a();
            if (bmx2.h()) {
                if (bmn2 == null) continue;
                bqd2.a(bmn2);
                continue;
            }
            bfn.a a2 = bmx2.bfn$a_a();
            if (a2 != null && a2.b()) continue;
            if (bmn2 instanceof bmo) {
                arrayList.add(this.a(bgo2, bmx2, bqk2, bl2, (bmo)bmn2));
                continue;
            }
            arrayList.add(this.a(bgo2, bmx2, bqk2, bl2, (bml)bmn2));
        }
        return arrayList;
    }

    protected List<bqb> a(bgm bgm2, bfo bfo2, List<bqb> list) {
        bbp.a a2 = bgm2.bbp$a_a(bfo2.a(), bfo2.bmh_a());
        Set<String> set = null;
        if (a2 != null) {
            set = a2.a();
        }
        bbs.a a3 = bgm2.bbs$a_a(bfo2.a(), bfo2.bmh_a());
        Set<String> set2 = null;
        if (a3 != null) {
            set2 = a3.a();
        }
        if (set2 != null || set != null && !set.isEmpty()) {
            Iterator<bqb> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (!bup.a(iterator.next().java_lang_String_a(), set, set2)) continue;
                iterator.remove();
            }
        }
        return list;
    }

    protected void a(bgm bgm2, bqd bqd2) {
        Object object = bqd2.java_lang_Object_a();
        boolean bl2 = bgm2.a(bgd.s);
        int n2 = object.size();
        int n3 = 0;
        bqb[] bqbArray = new bqb[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            bqb bqb2 = (bqb)object.get(i2);
            Class<?>[] classArray = bqb2.java_lang_Class____arr_a();
            if (classArray == null || classArray.length == 0) {
                if (!bl2) continue;
                bqbArray[i2] = bqb2;
                continue;
            }
            ++n3;
            bqbArray[i2] = this.a(bqb2, classArray);
        }
        if (bl2 && n3 == 0) {
            return;
        }
        bqd2.a(bqbArray);
    }

    protected void a(bgm bgm2, bfo bfo2, List<bmx> list) {
        bfn bfn2 = bgm2.bfn_a();
        HashMap hashMap = new HashMap();
        Iterator<bmx> iterator = list.iterator();
        while (iterator.hasNext()) {
            bmx bmx2 = iterator.next();
            bmn bmn2 = bmx2.bmn_a();
            if (bmn2 == null) {
                iterator.remove();
                continue;
            }
            Class<?> clazz = bmx2.a();
            Boolean bl2 = (Boolean)hashMap.get(clazz);
            if (bl2 == null) {
                bfo bfo3;
                bmh bmh2;
                bl2 = bgm2.bhg_a(clazz).java_lang_Boolean_a();
                if (bl2 == null && (bl2 = bfn2.java_lang_Boolean_a(bmh2 = (bfo3 = bgm2.bfo_a(clazz)).bmh_a())) == null) {
                    bl2 = Boolean.FALSE;
                }
                hashMap.put(clazz, bl2);
            }
            if (!bl2.booleanValue()) continue;
            iterator.remove();
        }
    }

    protected void b(bgm bgm2, bfo bfo2, List<bmx> list) {
        Iterator<bmx> iterator = list.iterator();
        while (iterator.hasNext()) {
            bmx bmx2 = iterator.next();
            if (bmx2.boolean_c() || bmx2.boolean_a()) continue;
            iterator.remove();
        }
    }

    protected List<bqb> a(bgo bgo2, bfo bfo2, bqd bqd2, List<bqb> list) {
        int n2 = list.size();
        block0: for (int i2 = 0; i2 < n2; ++i2) {
            bqb bqb2 = list.get(i2);
            bog bog2 = bqb2.bog_a();
            if (bog2 == null || bog2.bce$a_a() != bce.a.d) continue;
            String string = bog2.java_lang_String_a();
            bgj bgj2 = bgj.bgj_a(string);
            for (bqb bqb3 : list) {
                if (bqb3 == bqb2 || !bqb3.boolean_a(bgj2)) continue;
                bqb2.a((bog)null);
                continue block0;
            }
        }
        return list;
    }

    protected bqb a(bgo bgo2, bmx bmx2, bqk bqk2, boolean bl2, bmn bmn2) {
        bgj bgj2 = bmx2.bgj_a();
        bfw bfw2 = bmn2.bfw_a();
        bfp.b b2 = new bfp.b(bgj2, bfw2, bmx2.bgj_b(), bmn2, bmx2.bgi_a());
        bgb<Object> bgb2 = this.a(bgo2, bmn2);
        if (bgb2 instanceof bqo) {
            ((bqo)((Object)bgb2)).void_a(bgo2);
        }
        bgb2 = bgo2.a(bgb2, (bfp)b2);
        bog bog2 = null;
        if (bfw2.m() || bfw2.a() != false) {
            bog2 = this.b(bfw2, bgo2.bgm_a(), bmn2);
        }
        bog bog3 = this.a(bfw2, bgo2.bgm_a(), bmn2);
        return bqk2.a(bgo2, bmx2, bfw2, bgb2, bog3, bog2, bmn2, bl2);
    }

    protected bgb<?> b(bgo bgo2, bfw bfw2, bfo bfo2) {
        Object object = buh.java_lang_Object_a(bfw2);
        if (object != null && bgo2.bgm_a().a((Class<?>)bfw2.a()) == null) {
            return new brm(bfw2, (String)object);
        }
        return null;
    }
}

