/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class bhr
extends bii
implements Serializable {
    private static final Class<?> var_java_lang_Class____a;
    private static final Class<?> b;
    private static final Class<?> c;
    private static final Class<?> d;
    private static final Class<?> e;
    private static final Class<?> f;
    protected static final bgj var_bgj_a;
    protected final bhk var_bhk_a;

    protected bhr(bhk bhk2) {
        this.var_bhk_a = bhk2;
    }

    @Override
    public bfw bfw_a(bfr bfr2, bfw bfw2) {
        bfw bfw3;
        while ((bfw3 = this.b(bfr2, bfw2)) != null) {
            Object t2;
            Object t3 = bfw2.a();
            if (t3 == (t2 = bfw3.a()) || !((Class)t3).isAssignableFrom((Class<?>)t2)) {
                throw new IllegalArgumentException("Invalid abstract type resolution from " + bfw2 + " to " + bfw3 + ": latter is not a subtype of former");
            }
            bfw2 = bfw3;
        }
        return bfw2;
    }

    private bfw b(bfr bfr2, bfw bfw2) {
        Object t2 = bfw2.a();
        if (this.var_bhk_a.c()) {
            for (bfm bfm2 : this.var_bhk_a.d()) {
                bfw bfw3 = bfm2.a(bfr2, bfw2);
                if (bfw3 == null || bfw3.boolean_a((Class<?>)t2)) continue;
                return bfw3;
            }
        }
        return null;
    }

    public bir bir_a(bfs bfs2, bfo bfo2) {
        bfr bfr2 = bfs2.bfr_a();
        bir bir2 = null;
        bmh bmh2 = bfo2.bmh_a();
        Object object = bfs2.bfn_a().b(bmh2);
        if (object != null) {
            bir2 = this.a(bfr2, bmh2, object);
        }
        if (bir2 == null && (bir2 = bjd.a(bfr2, bfo2.a())) == null) {
            bir2 = this.b(bfs2, bfo2);
        }
        if (this.var_bhk_a.d()) {
            for (bis bis2 : this.var_bhk_a.e()) {
                bir2 = bis2.a(bfr2, bfo2, bir2);
                if (bir2 != null) continue;
                bfs2.a(bfo2, "Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator", bis2.getClass().getName());
            }
        }
        if (bir2 != null) {
            bir2 = bir2.a(bfs2, bfo2);
        }
        return bir2;
    }

    protected bir b(bfs bfs2, bfo bfo2) {
        Serializable serializable = bfs2.bfr_a();
        Object object = serializable.a(bfo2.a(), bfo2.bmh_a());
        bhi bhi2 = serializable.bhi_a();
        bix bix2 = new bix(bfo2, (bhm<?>)serializable);
        Map<bms, bmx[]> map = this.a(bfs2, bfo2);
        b b2 = new b(bfs2, bfo2, (bnu<?>)object, bix2, map);
        this.b(bfs2, b2, !bhi2.boolean_a());
        if (bfo2.bfw_a().boolean_d()) {
            if (bfo2.bfw_a().i() && (object = bnw.a(bfs2, bfo2, (List<String>)((Object)(serializable = new ArrayList())))) != null) {
                this.a(bfs2, b2, (bmj)object, (List<String>)((Object)serializable));
                return b2.var_bix_a.a(bfs2);
            }
            boolean bl2 = bfo2.boolean_a();
            if (!bl2) {
                boolean bl3 = bhi2.a(bfo2.a());
                this.a(bfs2, b2, bl3);
                if (b2.d() && !b2.c()) {
                    this.a(bfs2, b2, b2.b());
                }
            }
        }
        if (b2.boolean_b() && !b2.boolean_a() && !b2.c()) {
            this.b(bfs2, b2, b2.a());
        }
        return b2.var_bix_a.a(bfs2);
    }

    protected Map<bms, bmx[]> a(bfs bfs2, bfo bfo2) {
        Map<bms, bmx[]> map = Collections.emptyMap();
        for (bmx bmx2 : bfo2.a()) {
            Iterator<bmr> iterator = bmx2.a();
            while (iterator.hasNext()) {
                bmr bmr2 = iterator.next();
                bms bms2 = bmr2.bms_a();
                bmx[] bmxArray = map.get(bms2);
                int n2 = bmr2.int_a();
                if (bmxArray == null) {
                    if (map.isEmpty()) {
                        map = new LinkedHashMap<bms, bmx[]>();
                    }
                    bmxArray = new bmx[bms2.int_a()];
                    map.put(bms2, bmxArray);
                } else if (bmxArray[n2] != null) {
                    bfs2.a(bfo2, "Conflict: parameter #%d of %s bound to more than one property; %s vs %s", n2, bms2, bmxArray[n2], bmx2);
                }
                bmxArray[n2] = bmx2;
            }
        }
        return map;
    }

    public bir a(bfr bfr2, bmg bmg2, Object object) {
        bir bir2;
        if (object == null) {
            return null;
        }
        if (object instanceof bir) {
            return (bir)object;
        }
        if (!(object instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + object.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        }
        Class clazz = (Class)object;
        if (buk.c(clazz)) {
            return null;
        }
        if (!bir.class.isAssignableFrom(clazz)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + clazz.getName() + "; expected Class<ValueInstantiator>");
        }
        bhl bhl2 = bfr2.bhl_a();
        if (bhl2 != null && (bir2 = bhl2.bir_a((bhm<?>)bfr2, bmg2, (Class<?>)clazz)) != null) {
            return bir2;
        }
        return (bir)buk.a(clazz, bfr2.c());
    }

    protected void a(bfs bfs2, b b2, bmj bmj2, List<String> list) {
        int n2 = bmj2.int_a();
        bfn bfn2 = bfs2.bfn_a();
        bio[] bioArray = new bio[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            bmr bmr2 = bmj2.bmr_a(i2);
            bba.a a2 = bfn2.bba$a_a(bmr2);
            Object object = bfn2.java_lang_Object_c((bmg)bmr2);
            if (object == null || ((bgj)object).c()) {
                object = bgj.bgj_a(list.get(i2));
            }
            bioArray[i2] = this.a(bfs2, b2.var_bfo_a, (bgj)object, i2, bmr2, a2);
        }
        b2.var_bix_a.a((bms)bmj2, false, bioArray);
    }

    protected void a(bfs bfs2, b b2, boolean bl2) {
        bfo bfo2 = b2.var_bfo_a;
        bix bix2 = b2.var_bix_a;
        bfn bfn2 = b2.bfn_a();
        bfs bfs3 = b2.var_bfs_a;
        bfs bfs4 = b2.var_bfs_a;
        bmj bmj2 = bfo2.bmj_a();
        if (bmj2 != null && (!bix2.a() || this.boolean_a(bfs2, bmj2))) {
            bix2.void_a(bmj2);
        }
        for (bmj bmj3 : bfo2.c()) {
            bbh.a a2 = bfn2.bbh$a_a(bfs2.bfr_a(), bmj3);
            if (bbh.a.d == a2) continue;
            if (a2 == null) {
                if (!bl2 || !bfs3.a(bmj3)) continue;
                b2.b(biw.a(bfn2, bmj3, (bmx[])bfs4.get(bmj3)));
                continue;
            }
            switch (a2) {
                case b: {
                    this.a(bfs2, bfo2, bix2, biw.a(bfn2, bmj3, null));
                    break;
                }
                case c: {
                    this.b(bfs2, bfo2, bix2, biw.a(bfn2, bmj3, (bmx[])bfs4.get(bmj3)));
                    break;
                }
                default: {
                    this.a(bfs2, bfo2, bix2, biw.a(bfn2, bmj3, (bmx[])bfs4.get(bmj3)), bfs2.bfr_a().bhi_a());
                }
            }
            b2.void_b();
        }
    }

    protected void a(bfs bfs2, b b2, List<biw> list) {
        bfr bfr2 = bfs2.bfr_a();
        bfo bfo2 = b2.var_bfo_a;
        bix bix2 = b2.var_bix_a;
        bfn bfn2 = b2.bfn_a();
        bfs bfs3 = b2.var_bfs_a;
        LinkedList<bms> linkedList = null;
        boolean bl2 = bfr2.bhi_a().c();
        for (biw biw2 : list) {
            Serializable serializable;
            int n2;
            int n3 = biw2.int_a();
            bms bms2 = biw2.bms_a();
            if (n3 == 1) {
                boolean bl3;
                bmx bmx2 = biw2.bmx_a(0);
                boolean bl4 = bl3 = bl2 || this.a(bfn2, bms2, bmx2);
                if (bl3) {
                    bio[] bioArray = new bio[1];
                    bba.a a2 = biw2.bba$a_a(0);
                    bgj bgj2 = biw2.bgj_a(0);
                    if (bgj2 == null && (bgj2 = biw2.c(0)) == null && a2 == null) continue;
                    bioArray[0] = this.a(bfs2, bfo2, bgj2, 0, biw2.bmr_a(0), a2);
                    bix2.a(bms2, false, bioArray);
                    continue;
                }
                this.a(bix2, bms2, false, bfs3.a(bms2));
                if (bmx2 == null) continue;
                ((bnk)bmx2).void_b();
                continue;
            }
            int n4 = -1;
            bio[] bioArray = new bio[n3];
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            for (n2 = 0; n2 < n3; ++n2) {
                bgj bgj3;
                serializable = bms2.bmr_a(n2);
                bmx bmx3 = biw2.bmx_a(n2);
                bba.a a3 = bfn2.bba$a_a((bmn)serializable);
                bgj bgj4 = bgj3 = bmx3 == null ? null : bmx3.bgj_a();
                if (bmx3 != null && bmx3.boolean_b()) {
                    ++n5;
                    bioArray[n2] = this.a(bfs2, bfo2, bgj3, n2, (bmr)serializable, a3);
                    continue;
                }
                if (a3 != null) {
                    ++n7;
                    bioArray[n2] = this.a(bfs2, bfo2, bgj3, n2, (bmr)serializable, a3);
                    continue;
                }
                but but2 = bfn2.but_a((bmn)serializable);
                if (but2 != null) {
                    this.a(bfs2, bfo2, (bmr)serializable);
                    continue;
                }
                if (n4 >= 0) continue;
                n4 = n2;
            }
            n2 = n5 + n6;
            if (n5 > 0 || n7 > 0) {
                if (n2 + n7 == n3) {
                    bix2.a(bms2, false, bioArray);
                    continue;
                }
                if (n5 == 0 && n7 + 1 == n3) {
                    bix2.a(bms2, false, bioArray, 0);
                    continue;
                }
                serializable = biw2.c(n4);
                if (serializable == null || ((bgj)serializable).c()) {
                    bfs2.a(bfo2, "Argument #%d of constructor %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", n4, bms2);
                }
            }
            if (bix2.a()) continue;
            if (linkedList == null) {
                linkedList = new LinkedList<bms>();
            }
            linkedList.add(bms2);
        }
        if (linkedList != null && !bix2.b() && !bix2.c()) {
            this.a(bfs2, bfo2, (bnu<?>)((Object)bfs3), bfn2, bix2, (List<bms>)linkedList);
        }
    }

    protected void b(bfs bfs2, b b2, boolean bl2) {
        bfo bfo2 = b2.var_bfo_a;
        bix bix2 = b2.var_bix_a;
        bfn bfn2 = b2.bfn_a();
        bfs bfs3 = b2.var_bfs_a;
        bfs bfs4 = b2.var_bfs_a;
        for (bmo bmo2 : bfo2.d()) {
            bbh.a a2 = bfn2.bbh$a_a(bfs2.bfr_a(), bmo2);
            int n2 = bmo2.int_a();
            if (a2 == null) {
                if (!bl2 || n2 != 1 || !bfs3.a(bmo2)) continue;
                b2.a(biw.a(bfn2, bmo2, null));
                continue;
            }
            if (a2 == bbh.a.d) continue;
            if (n2 == 0) {
                bix2.void_a(bmo2);
                continue;
            }
            switch (a2) {
                case b: {
                    this.a(bfs2, bfo2, bix2, biw.a(bfn2, bmo2, null));
                    break;
                }
                case c: {
                    this.b(bfs2, bfo2, bix2, biw.a(bfn2, bmo2, (bmx[])bfs4.get(bmo2)));
                    break;
                }
                default: {
                    this.a(bfs2, bfo2, bix2, biw.a(bfn2, bmo2, (bmx[])bfs4.get(bmo2)), bhi.var_bhi_a);
                }
            }
            b2.void_a();
        }
    }

    protected void b(bfs bfs2, b b2, List<biw> list) {
        bfo bfo2 = b2.var_bfo_a;
        bix bix2 = b2.var_bix_a;
        bfn bfn2 = b2.bfn_a();
        bfs bfs3 = b2.var_bfs_a;
        bfs bfs4 = b2.var_bfs_a;
        for (biw biw2 : list) {
            int n2;
            int n3 = biw2.int_a();
            bms bms2 = biw2.bms_a();
            bmx[] bmxArray = (bmx[])bfs4.get(bms2);
            if (n3 != 1) continue;
            bmx bmx2 = biw2.bmx_a(0);
            boolean bl2 = this.a(bfn2, bms2, bmx2);
            if (!bl2) {
                this.a(bix2, bms2, false, bfs3.a(bms2));
                if (bmx2 == null) continue;
                ((bnk)bmx2).void_b();
                continue;
            }
            bmr bmr2 = null;
            bio[] bioArray = new bio[n3];
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            for (n2 = 0; n2 < n3; ++n2) {
                bgj bgj2;
                bmr bmr3 = bms2.bmr_a(n2);
                bmx bmx3 = bmxArray == null ? null : bmxArray[n2];
                bba.a a2 = bfn2.bba$a_a(bmr3);
                bgj bgj3 = bgj2 = bmx3 == null ? null : bmx3.bgj_a();
                if (bmx3 != null && bmx3.boolean_b()) {
                    ++n5;
                    bioArray[n2] = this.a(bfs2, bfo2, bgj2, n2, bmr3, a2);
                    continue;
                }
                if (a2 != null) {
                    ++n6;
                    bioArray[n2] = this.a(bfs2, bfo2, bgj2, n2, bmr3, a2);
                    continue;
                }
                but but2 = bfn2.but_a(bmr3);
                if (but2 != null) {
                    this.a(bfs2, bfo2, bmr3);
                    continue;
                }
                if (bmr2 != null) continue;
                bmr2 = bmr3;
            }
            n2 = n5 + n4;
            if (n5 <= 0 && n6 <= 0) continue;
            if (n2 + n6 == n3) {
                bix2.a(bms2, false, bioArray);
                continue;
            }
            if (n5 == 0 && n6 + 1 == n3) {
                bix2.a(bms2, false, bioArray, 0);
                continue;
            }
            bfs2.a(bfo2, "Argument #%d of factory method %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", bmr2.int_a(), bms2);
        }
    }

    protected void a(bfs bfs2, bfo bfo2, bix bix2, biw biw2) {
        int n2 = -1;
        int n3 = biw2.int_a();
        bio[] bioArray = new bio[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            bmr bmr2 = biw2.bmr_a(i2);
            bba.a a2 = biw2.bba$a_a(i2);
            if (a2 != null) {
                bioArray[i2] = this.a(bfs2, bfo2, null, i2, bmr2, a2);
                continue;
            }
            if (n2 < 0) {
                n2 = i2;
                continue;
            }
            bfs2.a(bfo2, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", n2, i2, biw2);
        }
        if (n2 < 0) {
            bfs2.a(bfo2, "No argument left as delegating for Creator %s: exactly one required", biw2);
        }
        if (n3 == 1) {
            this.a(bix2, biw2.bms_a(), true, true);
            bmx bmx2 = biw2.bmx_a(0);
            if (bmx2 != null) {
                ((bnk)bmx2).void_b();
            }
            return;
        }
        bix2.a(biw2.bms_a(), true, bioArray, n2);
    }

    protected void b(bfs bfs2, bfo bfo2, bix bix2, biw biw2) {
        int n2 = biw2.int_a();
        bio[] bioArray = new bio[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            bba.a a2 = biw2.bba$a_a(i2);
            bmr bmr2 = biw2.bmr_a(i2);
            bgj bgj2 = biw2.bgj_a(i2);
            if (bgj2 == null) {
                but but2 = bfs2.bfn_a().but_a(bmr2);
                if (but2 != null) {
                    this.a(bfs2, bfo2, bmr2);
                }
                bgj2 = biw2.c(i2);
                this.a(bfs2, bfo2, biw2, i2, bgj2, a2);
            }
            bioArray[i2] = this.a(bfs2, bfo2, bgj2, i2, bmr2, a2);
        }
        bix2.a(biw2.bms_a(), true, bioArray);
    }

    protected void a(bfs bfs2, bfo bfo2, bix bix2, biw biw2, bhi bhi2) {
        bio[] bioArray;
        boolean bl2;
        if (1 != biw2.int_a()) {
            int n2;
            if (!bhi2.c() && (n2 = biw2.b()) >= 0 && (bhi2.b() || biw2.bgj_a(n2) == null)) {
                this.a(bfs2, bfo2, bix2, biw2);
                return;
            }
            this.b(bfs2, bfo2, bix2, biw2);
            return;
        }
        bmr bmr2 = biw2.bmr_a(0);
        bba.a a2 = biw2.bba$a_a(0);
        bgj bgj2 = null;
        switch (bhi2.bhi$a_a()) {
            case var_bhi$a_a: {
                bl2 = false;
                break;
            }
            case b: {
                bl2 = true;
                bgj2 = biw2.bgj_a(0);
                if (bgj2 != null) break;
                this.a(bfs2, bfo2, biw2, 0, bgj2, a2);
                break;
            }
            case d: {
                bfs2.a(bfo2, "Single-argument constructor (%s) is annotated but no 'mode' defined; `CreatorDetector`configured with `SingleArgConstructor.REQUIRE_MODE`", biw2.bms_a());
                return;
            }
            default: {
                bioArray = biw2.bmx_a(0);
                bgj2 = biw2.b(0);
                boolean bl3 = bl2 = bgj2 != null || a2 != null;
                if (bl2 || bioArray == null) break;
                bgj2 = biw2.bgj_a(0);
                boolean bl4 = bl2 = bgj2 != null && bioArray.boolean_d();
            }
        }
        if (bl2) {
            bioArray = new bio[]{this.a(bfs2, bfo2, bgj2, 0, bmr2, a2)};
            bix2.a(biw2.bms_a(), true, bioArray);
            return;
        }
        this.a(bix2, biw2.bms_a(), true, true);
        bioArray = biw2.bmx_a(0);
        if (bioArray != null) {
            ((bnk)bioArray).void_b();
        }
    }

    private boolean a(bfn bfn2, bms bms2, bmx bmx2) {
        String string;
        if (bmx2 != null && bmx2.boolean_b() || bfn2.bba$a_a(bms2.bmr_a(0)) != null) {
            return true;
        }
        return bmx2 != null && (string = bmx2.java_lang_String_a()) != null && !string.isEmpty() && bmx2.boolean_d();
    }

    private void a(bfs bfs2, bfo bfo2, bnu<?> bnu2, bfn bfn2, bix bix2, List<bms> list) {
        Object object;
        Serializable serializable;
        bms bms2 = null;
        bio[] bioArray = null;
        block0: for (bms bms3 : list) {
            if (!bnu2.a(bms3)) continue;
            int n2 = bms3.int_a();
            bio[] bioArray2 = new bio[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                serializable = bms3.bmr_a(i2);
                object = this.a((bmr)serializable, bfn2);
                if (object == null || ((bgj)object).c()) continue block0;
                bioArray2[i2] = this.a(bfs2, bfo2, (bgj)object, ((bmr)serializable).int_a(), (bmr)serializable, null);
            }
            if (bms2 != null) {
                bms2 = null;
                break;
            }
            bms2 = bms3;
            bioArray = bioArray2;
        }
        if (bms2 != null) {
            bix2.a(bms2, false, bioArray);
            bmv bmv2 = (bmv)bfo2;
            for (bms bms4 : bioArray) {
                serializable = ((bio)((Object)bms4)).bgj_a();
                if (bmv2.boolean_a((bgj)serializable)) continue;
                object = bvc.a(bfs2.bfr_a(), ((bio)((Object)bms4)).bmn_a(), (bgj)serializable);
                bmv2.a((bmx)object);
            }
        }
    }

    protected boolean a(bix bix2, bms bms2, boolean bl2, boolean bl3) {
        Class<?> clazz = bms2.a(0);
        if (clazz == String.class || clazz == c) {
            if (bl2 || bl3) {
                bix2.a(bms2, bl2);
            }
            return true;
        }
        if (clazz == Integer.TYPE || clazz == Integer.class) {
            if (bl2 || bl3) {
                bix2.b(bms2, bl2);
            }
            return true;
        }
        if (clazz == Long.TYPE || clazz == Long.class) {
            if (bl2 || bl3) {
                bix2.c(bms2, bl2);
            }
            return true;
        }
        if (clazz == Double.TYPE || clazz == Double.class) {
            if (bl2 || bl3) {
                bix2.e(bms2, bl2);
            }
            return true;
        }
        if (clazz == Boolean.TYPE || clazz == Boolean.class) {
            if (bl2 || bl3) {
                bix2.g(bms2, bl2);
            }
            return true;
        }
        if (clazz == BigInteger.class && (bl2 || bl3)) {
            bix2.d(bms2, bl2);
        }
        if (clazz == BigDecimal.class && (bl2 || bl3)) {
            bix2.f(bms2, bl2);
        }
        if (bl2) {
            bix2.a(bms2, bl2, null, 0);
            return true;
        }
        return false;
    }

    protected void a(bfs bfs2, bfo bfo2, biw biw2, int n2, bgj bgj2, bba.a a2) {
        if (bgj2 == null && a2 == null) {
            bfs2.a(bfo2, "Argument #%d of constructor %s has no property name (and is not Injectable): can not use as property-based Creator", n2, biw2);
        }
    }

    protected void a(bfs bfs2, bfo bfo2, bmr bmr2) {
        bfs2.a(bfo2, "Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", bmr2.int_a());
    }

    protected bio a(bfs bfs2, bfo bfo2, bgj bgj2, int n2, bmr bmr2, bba.a a2) {
        Object object;
        Object object2;
        Object object3;
        Serializable serializable;
        bgi bgi2;
        bfr bfr2 = bfs2.bfr_a();
        bfn bfn2 = bfs2.bfn_a();
        if (bfn2 == null) {
            bgi2 = bgi.c;
        } else {
            serializable = bfn2.java_lang_Boolean_b(bmr2);
            object3 = bfn2.java_lang_String_b((bmg)bmr2);
            object2 = bfn2.java_lang_Object_a((bmg)bmr2);
            object = bfn2.java_lang_Object_a((bmg)bmr2);
            bgi2 = bgi.a((Boolean)serializable, (String)object3, (Integer)object2, (String)object);
        }
        serializable = this.a(bfs2, bmr2, bmr2.bfw_a());
        object3 = new bfp.b(bgj2, (bfw)serializable, (bgj)bfn2.java_lang_Object_a((bmg)bmr2), bmr2, bgi2);
        object2 = (boc)((bfw)serializable).b();
        if (object2 == null) {
            object2 = this.boc_a(bfr2, (bfw)serializable);
        }
        bgi2 = this.a(bfs2, (bfp)object3, bgi2);
        object = bid.a(bgj2, (bfw)serializable, ((bfp.b)object3).b(), (boc)object2, bfo2.bud_a(), bmr2, n2, a2, bgi2);
        bfx<?> bfx2 = this.a(bfs2, bmr2);
        if (bfx2 == null) {
            bfx2 = (bfx<?>)((bfw)serializable).a();
        }
        if (bfx2 != null) {
            bfx2 = bfs2.a(bfx2, (bfp)object, (bfw)serializable);
            object = ((bio)object).a(bfx2);
        }
        return object;
    }

    private bgj a(bmr bmr2, bfn bfn2) {
        if (bfn2 != null) {
            Object object = bfn2.java_lang_Object_c((bmg)bmr2);
            if (object != null && !((bgj)object).c()) {
                return object;
            }
            String string = bfn2.java_lang_String_a(bmr2);
            if (string != null && !string.isEmpty()) {
                return bgj.bgj_a(string);
            }
        }
        return null;
    }

    protected bgi a(bfs bfs2, bfp bfp2, bgi bgi2) {
        Object object;
        bfn bfn2 = bfs2.bfn_a();
        bfr bfr2 = bfs2.bfr_a();
        boolean bl2 = true;
        bcj bcj2 = null;
        bcj bcj3 = null;
        bmn bmn2 = bfp2.bmn_a();
        if (bmn2 != null) {
            bcb.a a2;
            if (bfn2 != null && (object = bfn2.java_lang_Object_a((bmg)bmn2)) != null) {
                bcj2 = ((bcb.a)object).bcj_a();
                bcj3 = ((bcb.a)object).b();
            }
            if ((bl2 || bcj2 == null || bcj3 == null) && (a2 = ((bhg)(object = bfr2.bhg_a((Class<?>)bfp2.bfw_a().a()))).bcb$a_a()) != null) {
                if (bcj2 == null) {
                    bcj2 = a2.bcj_a();
                }
                if (bcj3 == null) {
                    bcj3 = a2.b();
                }
            }
        }
        if (bl2 || bcj2 == null || bcj3 == null) {
            object = bfr2.bcb$a_a();
            if (bcj2 == null) {
                bcj2 = ((bcb.a)object).bcj_a();
            }
            if (bcj3 == null) {
                bcj3 = ((bcb.a)object).b();
            }
        }
        if (bcj2 != null || bcj3 != null) {
            bgi2 = bgi2.a(bcj2, bcj3);
        }
        return bgi2;
    }

    @Override
    public bfx<?> a(bfs bfs2, btl btl2, bfo bfo2) {
        bfx bfx2;
        bfr bfr2 = bfs2.bfr_a();
        bfw bfw2 = btl2.bfw_c();
        bfx bfx3 = (bfx)bfw2.a();
        boc boc2 = (boc)bfw2.b();
        if (boc2 == null) {
            boc2 = this.boc_a(bfr2, bfw2);
        }
        if ((bfx2 = this.a(btl2, bfr2, bfo2, boc2, bfx3)) == null) {
            if (bfx3 == null) {
                Object t2 = bfw2.a();
                if (bfw2.k()) {
                    return bky.a(t2);
                }
                if (t2 == String.class) {
                    return bli.var_bli_a;
                }
            }
            bfx2 = new bkx((bfw)btl2, bfx3, boc2);
        }
        if (this.var_bhk_a.b()) {
            for (bhy bhy2 : this.var_bhk_a.c()) {
                bfx2 = bhy2.a(bfr2, btl2, bfo2, bfx2);
            }
        }
        return bfx2;
    }

    @Override
    public bfx<?> a(bfs bfs2, btp object, bfo bfo2) {
        Object object2;
        bfx bfx2;
        bfw bfw2 = ((bto)object).bfw_c();
        bfx bfx3 = (bfx)bfw2.a();
        bfr bfr2 = bfs2.bfr_a();
        boc boc2 = (boc)bfw2.b();
        if (boc2 == null) {
            boc2 = this.boc_a(bfr2, bfw2);
        }
        if ((bfx2 = this.a((btp)object, bfr2, bfo2, boc2, bfx3)) == null) {
            object2 = ((bfw)object).a();
            if (bfx3 == null && EnumSet.class.isAssignableFrom((Class<?>)object2)) {
                bfx2 = new bkm(bfw2, null);
            }
        }
        if (bfx2 == null) {
            if (((bfw)object).j() || ((bfw)object).boolean_c()) {
                object2 = this.btp_a((bfw)object, bfr2);
                if (object2 == null) {
                    if (((bfw)object).b() == null) {
                        throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Collection type " + object);
                    }
                    bfx2 = bhq.a(bfo2);
                } else {
                    object = object2;
                    bfo2 = bfr2.b((bfw)object);
                }
            }
            if (bfx2 == null) {
                object2 = this.bir_a(bfs2, bfo2);
                if (!((bir)object2).i()) {
                    if (((bfw)object).boolean_a(ArrayBlockingQueue.class)) {
                        return new bjy((bfw)object, bfx3, boc2, (bir)object2);
                    }
                    bfx2 = bje.a(bfs2, (bfw)object);
                    if (bfx2 != null) {
                        return bfx2;
                    }
                }
                bfx2 = bfw2.boolean_a(String.class) ? new blj((bfw)object, bfx3, (bir)object2) : new bkf((bfw)object, bfx3, boc2, (bir)object2);
            }
        }
        if (this.var_bhk_a.b()) {
            for (bhy bhy2 : this.var_bhk_a.c()) {
                bfx2 = bhy2.a(bfr2, (btp)object, bfo2, bfx2);
            }
        }
        return bfx2;
    }

    protected btp btp_a(bfw bfw2, bfr bfr2) {
        Class<?> clazz = bhr$a.a(bfw2);
        if (clazz != null) {
            return (btp)bfr2.btz_a().a(bfw2, clazz, true);
        }
        return null;
    }

    @Override
    public bfx<?> a(bfs bfs2, bto bto2, bfo bfo2) {
        bfx<?> bfx2;
        bfw bfw2 = bto2.bfw_c();
        bfx bfx3 = (bfx)bfw2.a();
        bfr bfr2 = bfs2.bfr_a();
        boc boc2 = (boc)bfw2.b();
        if (boc2 == null) {
            boc2 = this.boc_a(bfr2, bfw2);
        }
        if ((bfx2 = this.a(bto2, bfr2, bfo2, boc2, bfx3)) != null && this.var_bhk_a.b()) {
            for (bhy bhy2 : this.var_bhk_a.c()) {
                bfx2 = bhy2.a(bfr2, bto2, bfo2, bfx2);
            }
        }
        return bfx2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public bfx<?> a(bfs bfs2, bts object, bfo bfo2) {
        bfx bfx2;
        bfr bfr2 = bfs2.bfr_a();
        bfw bfw2 = ((btr)object).bfw_b();
        bfw bfw3 = ((btr)object).bfw_c();
        bfx bfx3 = (bfx)bfw3.a();
        bgc bgc2 = (bgc)bfw2.a();
        boc boc2 = (boc)bfw3.b();
        if (boc2 == null) {
            boc2 = this.boc_a(bfr2, bfw3);
        }
        if ((bfx2 = this.a((bts)object, bfr2, bfo2, bgc2, boc2, bfx3)) == null) {
            Object object3 = ((bfw)object).a();
            if (EnumMap.class.isAssignableFrom((Class<?>)object3)) {
                void var12_14;
                if (object3 == EnumMap.class) {
                    Object object2 = null;
                } else {
                    bir bir2 = this.bir_a(bfs2, bfo2);
                }
                if (!bfw2.h()) {
                    throw new IllegalArgumentException("Cannot construct EnumMap; generic (key) type not available");
                }
                bfx2 = new bkl((bfw)object, (bir)var12_14, null, bfx3, boc2, null);
            }
            if (bfx2 == null) {
                if (((bfw)object).j() || ((bfw)object).boolean_c()) {
                    bts bts2 = this.bts_a((bfw)object, bfr2);
                    if (bts2 != null) {
                        object = bts2;
                        object3 = ((bfw)object).a();
                        bfo2 = bfr2.b((bfw)object);
                    } else {
                        if (((bfw)object).b() == null) {
                            throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Map type " + object);
                        }
                        bfx2 = bhq.a(bfo2);
                    }
                } else {
                    bfx2 = bje.b(bfs2, (bfw)object);
                    if (bfx2 != null) {
                        return bfx2;
                    }
                }
                if (bfx2 == null) {
                    bir bir3 = this.bir_a(bfs2, bfo2);
                    bks bks2 = new bks((bfw)object, bir3, bgc2, bfx3, boc2);
                    bbp.a a2 = bfr2.bbp$a_a(Map.class, bfo2.bmh_a());
                    Set<String> set = a2 == null ? null : a2.b();
                    bks2.a(set);
                    bbs.a a3 = bfr2.bbs$a_a(Map.class, bfo2.bmh_a());
                    Set<String> set2 = a3 == null ? null : a3.a();
                    bks2.b(set2);
                    bfx2 = bks2;
                }
            }
        }
        if (this.var_bhk_a.b()) {
            for (bhy bhy2 : this.var_bhk_a.c()) {
                bfx2 = bhy2.a(bfr2, (bts)object, bfo2, bfx2);
            }
        }
        return bfx2;
    }

    protected bts bts_a(bfw bfw2, bfr bfr2) {
        Class<?> clazz = bhr$a.b(bfw2);
        if (clazz != null) {
            return (bts)bfr2.btz_a().a(bfw2, clazz, true);
        }
        return null;
    }

    @Override
    public bfx<?> a(bfs bfs2, btr btr2, bfo bfo2) {
        bfx<?> bfx2;
        bfw bfw2 = btr2.bfw_b();
        bfw bfw3 = btr2.bfw_c();
        bfr bfr2 = bfs2.bfr_a();
        bfx bfx3 = (bfx)bfw3.a();
        bgc bgc2 = (bgc)bfw2.a();
        boc boc2 = (boc)bfw3.b();
        if (boc2 == null) {
            boc2 = this.boc_a(bfr2, bfw3);
        }
        if ((bfx2 = this.a(btr2, bfr2, bfo2, bgc2, boc2, bfx3)) != null && this.var_bhk_a.b()) {
            for (bhy bhy2 : this.var_bhk_a.c()) {
                bfx2 = bhy2.a(bfr2, btr2, bfo2, bfx2);
            }
        }
        return bfx2;
    }

    @Override
    public bfx<?> a(bfs bfs2, bfw bfw2, bfo bfo2) {
        bfr bfr2 = bfs2.bfr_a();
        Object t2 = bfw2.a();
        bfx bfx2 = this.b((Class<?>)t2, bfr2, bfo2);
        if (bfx2 == null) {
            if (t2 == Enum.class) {
                return bhq.a(bfo2);
            }
            bir bir2 = this.b(bfs2, bfo2);
            bio[] object = bir2 == null ? null : bir2.bio_arr_a(bfs2.bfr_a());
            for (bmo bmo2 : bfo2.d()) {
                if (!this.boolean_a(bfs2, bmo2)) continue;
                if (bmo2.int_a() == 0) {
                    bfx2 = bkj.a(bfr2, t2, bmo2);
                    break;
                }
                Class<?> clazz = bmo2.c();
                if (!clazz.isAssignableFrom((Class<?>)t2)) {
                    bfs2.b(bfw2, String.format("Invalid `@JsonCreator` annotated Enum factory method [%s]: needs to return compatible type", bmo2.toString()));
                }
                bfx2 = bkj.a(bfr2, t2, bmo2, bir2, object);
                break;
            }
            if (bfx2 == null) {
                bfx2 = new bkj(this.a((Class<?>)t2, bfr2, bfo2.bmn_b()), (Boolean)bfr2.a(bgd.w));
            }
        }
        if (this.var_bhk_a.b()) {
            for (bhy bhy2 : this.var_bhk_a.c()) {
                bfx2 = bhy2.a(bfr2, bfw2, bfo2, bfx2);
            }
        }
        return bfx2;
    }

    @Override
    public bfx<?> a(bfr bfr2, bfw bfw2, bfo bfo2) {
        Object t2 = bfw2.a();
        bfx<?> bfx2 = this.a((Class<? extends bfz>)t2, bfr2, bfo2);
        if (bfx2 != null) {
            return bfx2;
        }
        return bkr.a(t2);
    }

    @Override
    public bfx<?> a(bfs bfs2, btu btu2, bfo bfo2) {
        bfx<?> bfx2;
        bfw bfw2 = btu2.bfw_c();
        bfx bfx3 = (bfx)bfw2.a();
        bfr bfr2 = bfs2.bfr_a();
        boc boc2 = (boc)bfw2.b();
        if (boc2 == null) {
            boc2 = this.boc_a(bfr2, bfw2);
        }
        if ((bfx2 = this.a(btu2, bfr2, bfo2, boc2, bfx3)) == null && btu2.b(AtomicReference.class)) {
            Object t2 = btu2.a();
            bir bir2 = t2 == AtomicReference.class ? null : this.bir_a(bfs2, bfo2);
            return new bkc(btu2, bir2, boc2, bfx3);
        }
        if (bfx2 != null && this.var_bhk_a.b()) {
            for (bhy bhy2 : this.var_bhk_a.c()) {
                bfx2 = bhy2.a(bfr2, btu2, bfo2, bfx2);
            }
        }
        return bfx2;
    }

    @Override
    public boc boc_a(bfr bfr2, bfw bfw2) {
        bfw bfw3;
        bfo bfo2 = bfr2.bfo_a((Class<?>)bfw2.a());
        bmh bmh2 = bfo2.bmh_a();
        bfn bfn2 = bfr2.bfn_a();
        bof<?> bof2 = bfn2.a(bfr2, bmh2, bfw2);
        Collection<bnz> collection = null;
        if (bof2 == null) {
            bof2 = bfr2.a(bfw2);
            if (bof2 == null) {
                return null;
            }
        } else {
            collection = bfr2.bob_a().b(bfr2, bmh2);
        }
        if (bof2.a() == null && bfw2.boolean_c() && (bfw3 = this.bfw_a(bfr2, bfw2)) != null && !bfw3.boolean_a((Class<?>)bfw2.a())) {
            bof2 = bof2.a((Class<?>)bfw3.a());
        }
        try {
            return bof2.a(bfr2, bfw2, collection);
        }
        catch (IllegalArgumentException | IllegalStateException runtimeException) {
            blq blq2 = blq.a((bdc)null, buk.java_lang_String_a(runtimeException), bfw2);
            blq2.initCause(runtimeException);
            throw blq2;
        }
    }

    protected bfx<?> b(bfs bfs2, bfw bfw2, bfo bfo2) {
        return bme.var_bme_a.a(bfw2, bfs2.bfr_a(), bfo2);
    }

    @Override
    public bgc a(bfs bfs2, bfw bfw2) {
        bfr bfr2 = bfs2.bfr_a();
        bfo bfo2 = null;
        bgc bgc2 = null;
        if (this.var_bhk_a.a()) {
            bik object;
            bfo2 = bfr2.c(bfw2);
            Iterator<Object> iterator = this.var_bhk_a.b().iterator();
            while (iterator.hasNext() && (bgc2 = (object = iterator.next()).a(bfw2, bfr2, bfo2)) == null) {
            }
        }
        if (bgc2 == null) {
            if (bfo2 == null) {
                bfo2 = bfr2.bfo_a((Class<?>)bfw2.a());
            }
            if ((bgc2 = this.bgc_a(bfs2, bfo2.bmh_a())) == null) {
                bgc2 = bfw2.g() ? this.b(bfs2, bfw2) : blf.a(bfr2, bfw2);
            }
        }
        if (bgc2 != null && this.var_bhk_a.b()) {
            for (bhy bhy2 : this.var_bhk_a.c()) {
                bgc2 = bhy2.a(bfr2, bfw2, bgc2);
            }
        }
        return bgc2;
    }

    private bgc b(bfs bfs2, bfw bfw2) {
        bfr bfr2 = bfs2.bfr_a();
        Object t2 = bfw2.a();
        bfo bfo2 = bfr2.bfo_a(bfw2);
        bgc bgc2 = this.bgc_a(bfs2, bfo2.bmh_a());
        if (bgc2 != null) {
            return bgc2;
        }
        bfx<?> bfx2 = this.b((Class<?>)t2, bfr2, bfo2);
        if (bfx2 != null) {
            return blf.a(bfr2, bfw2, bfx2);
        }
        bfx<Object> bfx3 = this.a(bfs2, bfo2.bmh_a());
        if (bfx3 != null) {
            return blf.a(bfr2, bfw2, bfx3);
        }
        bfx2 = this.a((Class<?>)t2, bfr2, bfo2.bmn_b());
        for (bmo bmo2 : bfo2.d()) {
            Class<?> clazz;
            if (!this.boolean_a(bfs2, bmo2)) continue;
            int n2 = bmo2.int_a();
            if (n2 == 1 && (clazz = bmo2.c()).isAssignableFrom((Class<?>)t2)) {
                if (bmo2.a(0) != String.class) continue;
                if (bfr2.c()) {
                    buk.a(bmo2.java_lang_reflect_Method_b(), bfs2.a(bgd.o));
                }
                return blf.a((bun)((Object)bfx2), bmo2);
            }
            throw new IllegalArgumentException("Unsuitable method (" + bmo2 + ") decorated with @JsonCreator (for Enum type " + ((Class)t2).getName() + ")");
        }
        return blf.a((bun)((Object)bfx2));
    }

    public boc a(bfr bfr2, bfw bfw2, bmn bmn2) {
        bfn bfn2 = bfr2.bfn_a();
        bof<?> bof2 = bfn2.a(bfr2, bmn2, bfw2);
        if (bof2 == null) {
            return this.boc_a(bfr2, bfw2);
        }
        Collection<bnz> collection = bfr2.bob_a().b(bfr2, bmn2, bfw2);
        try {
            return bof2.a(bfr2, bfw2, collection);
        }
        catch (IllegalArgumentException | IllegalStateException runtimeException) {
            blq blq2 = blq.a((bdc)null, buk.java_lang_String_a(runtimeException), bfw2);
            blq2.initCause(runtimeException);
            throw blq2;
        }
    }

    public boc b(bfr bfr2, bfw bfw2, bmn bmn2) {
        bfn bfn2 = bfr2.bfn_a();
        bof<?> bof2 = bfn2.b(bfr2, bmn2, bfw2);
        bfw bfw3 = bfw2.bfw_c();
        if (bof2 == null) {
            return this.boc_a(bfr2, bfw3);
        }
        Collection<bnz> collection = bfr2.bob_a().b(bfr2, bmn2, bfw3);
        return bof2.a(bfr2, bfw3, collection);
    }

    public bfx<?> c(bfs bfs2, bfw bfw2, bfo bfo2) {
        bfx<?> bfx2;
        Object t2 = bfw2.a();
        if (t2 == var_java_lang_Class____a || t2 == f) {
            bfw bfw3;
            bfw bfw4;
            bfr bfr2 = bfs2.bfr_a();
            if (this.var_bhk_a.c()) {
                bfw4 = this.a(bfr2, List.class);
                bfw3 = this.a(bfr2, Map.class);
            } else {
                bfw3 = null;
                bfw4 = null;
            }
            return new blo(bfw4, bfw3);
        }
        if (t2 == b || t2 == c) {
            return blk.a;
        }
        if (t2 == d) {
            btz btz2 = bfs2.btz_a();
            bfw[] bfwArray = btz2.bfw_arr_a(bfw2, d);
            bfw bfw5 = bfwArray == null || bfwArray.length != 1 ? btz.bfw_a() : bfwArray[0];
            btp btp2 = btz2.a(Collection.class, bfw5);
            return this.a(bfs2, btp2, bfo2);
        }
        if (t2 == e) {
            bfw bfw6 = bfw2.b(0);
            bfw bfw7 = bfw2.b(1);
            boc boc2 = (boc)bfw7.b();
            if (boc2 == null) {
                boc2 = this.boc_a(bfs2.bfr_a(), bfw7);
            }
            bfx bfx3 = (bfx)bfw7.a();
            bgc bgc2 = (bgc)bfw6.a();
            return new bkt(bfw2, bgc2, (bfx<Object>)bfx3, boc2);
        }
        String string = ((Class)t2).getName();
        if (((Class)t2).isPrimitive() || string.startsWith("java.")) {
            bfx2 = bkv.a(t2, string);
            if (bfx2 == null) {
                bfx2 = bkh.a(t2, string);
            }
            if (bfx2 != null) {
                return bfx2;
            }
        }
        if (t2 == bve.class) {
            return new blm();
        }
        bfx2 = this.b(bfs2, bfw2, bfo2);
        if (bfx2 != null) {
            return bfx2;
        }
        return bkp.a(t2, string);
    }

    protected bfw a(bfr bfr2, Class<?> clazz) {
        bfw bfw2 = this.bfw_a(bfr2, bfr2.bfw_a(clazz));
        return bfw2 == null || bfw2.boolean_a(clazz) ? null : bfw2;
    }

    protected bfx<?> a(Class<? extends bfz> clazz, bfr bfr2, bfo bfo2) {
        for (bij bij2 : this.var_bhk_a.a()) {
            bfx<?> bfx2 = bij2.b(clazz, bfr2, bfo2);
            if (bfx2 == null) continue;
            return bfx2;
        }
        return null;
    }

    protected bfx<?> a(btu btu2, bfr bfr2, bfo bfo2, boc boc2, bfx<?> bfx2) {
        for (bij bij2 : this.var_bhk_a.a()) {
            bfx<?> bfx3 = bij2.a(btu2, bfr2, bfo2, boc2, bfx2);
            if (bfx3 == null) continue;
            return bfx3;
        }
        return null;
    }

    protected bfx<Object> a(bfw bfw2, bfr bfr2, bfo bfo2) {
        for (bij bij2 : this.var_bhk_a.a()) {
            bfx<Object> bfx2 = bij2.a(bfw2, bfr2, bfo2);
            if (bfx2 == null) continue;
            return bfx2;
        }
        return null;
    }

    protected bfx<?> a(btl btl2, bfr bfr2, bfo bfo2, boc boc2, bfx<?> bfx2) {
        for (bij bij2 : this.var_bhk_a.a()) {
            bfx<?> bfx3 = bij2.a(btl2, bfr2, bfo2, boc2, bfx2);
            if (bfx3 == null) continue;
            return bfx3;
        }
        return null;
    }

    protected bfx<?> a(btp btp2, bfr bfr2, bfo bfo2, boc boc2, bfx<?> bfx2) {
        for (bij bij2 : this.var_bhk_a.a()) {
            bfx<?> bfx3 = bij2.a(btp2, bfr2, bfo2, boc2, bfx2);
            if (bfx3 == null) continue;
            return bfx3;
        }
        return null;
    }

    protected bfx<?> a(bto bto2, bfr bfr2, bfo bfo2, boc boc2, bfx<?> bfx2) {
        for (bij bij2 : this.var_bhk_a.a()) {
            bfx<?> bfx3 = bij2.a(bto2, bfr2, bfo2, boc2, bfx2);
            if (bfx3 == null) continue;
            return bfx3;
        }
        return null;
    }

    protected bfx<?> b(Class<?> clazz, bfr bfr2, bfo bfo2) {
        for (bij bij2 : this.var_bhk_a.a()) {
            bfx<?> bfx2 = bij2.a(clazz, bfr2, bfo2);
            if (bfx2 == null) continue;
            return bfx2;
        }
        return null;
    }

    protected bfx<?> a(bts bts2, bfr bfr2, bfo bfo2, bgc bgc2, boc boc2, bfx<?> bfx2) {
        for (bij bij2 : this.var_bhk_a.a()) {
            bfx<?> bfx3 = bij2.a(bts2, bfr2, bfo2, bgc2, boc2, bfx2);
            if (bfx3 == null) continue;
            return bfx3;
        }
        return null;
    }

    protected bfx<?> a(btr btr2, bfr bfr2, bfo bfo2, bgc bgc2, boc boc2, bfx<?> bfx2) {
        for (bij bij2 : this.var_bhk_a.a()) {
            bfx<?> bfx3 = bij2.a(btr2, bfr2, bfo2, bgc2, boc2, bfx2);
            if (bfx3 == null) continue;
            return bfx3;
        }
        return null;
    }

    protected bfx<Object> a(bfs bfs2, bmg bmg2) {
        Object object;
        bfn bfn2 = bfs2.bfn_a();
        if (bfn2 != null && (object = bfn2.g(bmg2)) != null) {
            return bfs2.a(bmg2, object);
        }
        return null;
    }

    protected bgc bgc_a(bfs bfs2, bmg bmg2) {
        Object object;
        bfn bfn2 = bfs2.bfn_a();
        if (bfn2 != null && (object = bfn2.h(bmg2)) != null) {
            return bfs2.a(bmg2, object);
        }
        return null;
    }

    protected bfx<Object> b(bfs bfs2, bmg bmg2) {
        Object object;
        bfn bfn2 = bfs2.bfn_a();
        if (bfn2 != null && (object = bfn2.i(bmg2)) != null) {
            return bfs2.a(bmg2, object);
        }
        return null;
    }

    protected bfw a(bfs bfs2, bmn bmn2, bfw bfw2) {
        bfx<Object> bfx2;
        Object object;
        Object object2;
        bfn bfn2 = bfs2.bfn_a();
        if (bfn2 == null) {
            return bfw2;
        }
        if (bfw2.o() && (object2 = bfw2.bfw_b()) != null && (object = bfs2.a((bmg)bmn2, bfx2 = bfn2.h(bmn2))) != null) {
            bfw2 = ((btr)bfw2).e(object);
            object2 = bfw2.bfw_b();
        }
        if (bfw2.boolean_b()) {
            object2 = bfn2.i(bmn2);
            bfx2 = bfs2.a((bmg)bmn2, object2);
            if (bfx2 != null) {
                bfw2 = bfw2.d(bfx2);
            }
            if ((object = this.b(bfs2.bfr_a(), bfw2, bmn2)) != null) {
                bfw2 = bfw2.btp_b(object);
            }
        }
        if ((object2 = this.a(bfs2.bfr_a(), bfw2, bmn2)) != null) {
            bfw2 = bfw2.btp_a(object2);
        }
        bfw2 = bfn2.b(bfs2.bfr_a(), (bmg)bmn2, bfw2);
        return bfw2;
    }

    protected bun a(Class<?> clazz, bfr bfr2, bmn bmn2) {
        if (bmn2 != null) {
            if (bfr2.c()) {
                buk.a(bmn2.java_lang_reflect_Member_a(), bfr2.a(bgd.o));
            }
            return bun.a(bfr2, clazz, bmn2);
        }
        return bun.a(bfr2, clazz);
    }

    protected boolean boolean_a(bfs bfs2, bmg bmg2) {
        bfn bfn2 = bfs2.bfn_a();
        if (bfn2 != null) {
            bbh.a a2 = bfn2.bbh$a_a(bfs2.bfr_a(), bmg2);
            return a2 != null && a2 != bbh.a.d;
        }
        return false;
    }

    static {
        var_java_lang_Class____a = Object.class;
        b = String.class;
        c = CharSequence.class;
        d = Iterable.class;
        e = Map.Entry.class;
        f = Serializable.class;
        var_bgj_a = new bgj("@JsonUnwrapped");
    }

    protected static class b {
        public final bfs var_bfs_a;
        public final bfo var_bfo_a;
        public final bnu<?> var_bnu____a;
        public final bix var_bix_a;
        public final Map<bms, bmx[]> cfr_renamed_17;
        private List<biw> var_java_util_List_biw__a;
        private int var_int_a;
        private List<biw> var_java_util_List_biw__b;
        private int var_int_b;

        public b(bfs bfs2, bfo bfo2, bnu<?> bnu2, bix bix2, Map<bms, bmx[]> map) {
            this.var_bfs_a = bfs2;
            this.var_bfo_a = bfo2;
            this.var_bfs_a = bnu2;
            this.var_bix_a = bix2;
            this.var_bfs_a = map;
        }

        public bfn bfn_a() {
            return this.var_bfs_a.bfn_a();
        }

        public void a(biw biw2) {
            if (this.var_bfs_a == null) {
                this.var_bfs_a = new LinkedList();
            }
            this.var_bfs_a.add(biw2);
        }

        public void void_a() {
            ++this.var_int_a;
        }

        public boolean boolean_a() {
            return this.var_int_a > 0;
        }

        public boolean boolean_b() {
            return this.var_bfs_a != null;
        }

        public List<biw> a() {
            return this.var_bfs_a;
        }

        public void b(biw biw2) {
            if (this.var_java_util_List_biw__b == null) {
                this.var_java_util_List_biw__b = new LinkedList<biw>();
            }
            this.var_java_util_List_biw__b.add(biw2);
        }

        public void void_b() {
            ++this.var_int_b;
        }

        public boolean c() {
            return this.var_int_b > 0;
        }

        public boolean d() {
            return this.var_java_util_List_biw__b != null;
        }

        public List<biw> b() {
            return this.var_java_util_List_biw__b;
        }
    }

    protected static class a {
        static final HashMap<String, Class<? extends Collection>> a;
        static final HashMap<String, Class<? extends Map>> b;

        public static Class<?> a(bfw bfw2) {
            return a.get(((Class)bfw2.a()).getName());
        }

        public static Class<?> b(bfw bfw2) {
            return b.get(((Class)bfw2.a()).getName());
        }

        static {
            HashMap<String, Class> hashMap = new HashMap<String, Class>();
            Class clazz = ArrayList.class;
            Class<HashSet> clazz2 = HashSet.class;
            hashMap.put(Collection.class.getName(), clazz);
            hashMap.put(List.class.getName(), clazz);
            hashMap.put(Set.class.getName(), clazz2);
            hashMap.put(SortedSet.class.getName(), TreeSet.class);
            hashMap.put(Queue.class.getName(), LinkedList.class);
            hashMap.put(AbstractList.class.getName(), clazz);
            hashMap.put(AbstractSet.class.getName(), clazz2);
            hashMap.put(Deque.class.getName(), LinkedList.class);
            hashMap.put(NavigableSet.class.getName(), TreeSet.class);
            a = hashMap;
            hashMap = new HashMap();
            clazz = LinkedHashMap.class;
            hashMap.put(Map.class.getName(), clazz);
            hashMap.put(AbstractMap.class.getName(), clazz);
            hashMap.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
            hashMap.put(SortedMap.class.getName(), TreeMap.class);
            hashMap.put(NavigableMap.class.getName(), TreeMap.class);
            hashMap.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
            b = hashMap;
        }
    }
}

