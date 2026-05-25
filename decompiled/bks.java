/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@bgp
public class bks
extends bkg<Map<Object, Object>>
implements bib,
bim {
    protected final bgc var_bgc_a;
    protected boolean var_boolean_b;
    protected final bfx<Object> var_bfx_java_lang_Object__a;
    protected final boc var_boc_a;
    protected final bir var_bir_a;
    protected bfx<Object> var_bfx_java_lang_Object__b;
    protected bjo var_bjo_a;
    protected final boolean c;
    protected Set<String> var_java_util_Set_java_lang_String__a;
    protected Set<String> var_java_util_Set_java_lang_String__b;
    protected bup.a var_bup$a_a;

    public bks(bfw bfw2, bir bir2, bgc bgc2, bfx<Object> bfx2, boc boc2) {
        super(bfw2, null, null);
        this.var_bgc_a = bgc2;
        this.var_bgc_a = bfx2;
        this.var_boc_a = boc2;
        this.var_bir_a = bir2;
        this.c = bir2.i();
        this.var_boolean_b = null;
        this.var_bjo_a = null;
        this.var_boolean_b = this.a(bfw2, bgc2);
        this.var_bup$a_a = null;
    }

    protected bks(bks bks2, bgc bgc2, bfx<Object> bfx2, boc boc2, bil bil2, Set<String> set, Set<String> set2) {
        super(bks2, bil2, (Boolean)((Object)bks2.var_bgc_a));
        this.var_bgc_a = bgc2;
        this.var_bgc_a = bfx2;
        this.var_boc_a = boc2;
        this.var_bir_a = bks2.var_bir_a;
        this.var_bjo_a = bks2.var_bjo_a;
        this.var_boolean_b = bks2.var_boolean_b;
        this.c = bks2.c;
        this.var_bgc_a = set;
        this.var_boolean_b = set2;
        this.var_bup$a_a = bup.a(set, set2);
        this.var_boolean_b = this.a((bfw)((Object)this.var_bgc_a), bgc2);
    }

    protected bks a(bgc bgc2, boc boc2, bfx<?> bfx2, bil bil2, Set<String> set, Set<String> set2) {
        if (this.var_bgc_a == bgc2 && this.var_bgc_a == bfx2 && this.var_boc_a == boc2 && this.var_bgc_a == bil2 && this.var_bgc_a == set && this.var_boolean_b == set2) {
            return this;
        }
        return new bks(this, bgc2, bfx2, boc2, bil2, set, set2);
    }

    protected final boolean a(bfw bfw2, bgc bgc2) {
        if (bgc2 == null) {
            return true;
        }
        bfw bfw3 = bfw2.bfw_b();
        if (bfw3 == null) {
            return true;
        }
        Object t2 = bfw3.a();
        return (t2 == String.class || t2 == Object.class) && this.a(bgc2);
    }

    public void a(Set<String> set) {
        this.var_bgc_a = set == null || set.size() == 0 ? null : set;
        this.var_bup$a_a = bup.a((Set<String>)((Object)this.var_bgc_a), (Set<String>)this.var_boolean_b);
    }

    public void b(Set<String> set) {
        this.var_boolean_b = set;
        this.var_bup$a_a = bup.a((Set<String>)((Object)this.var_bgc_a), (Set<String>)this.var_boolean_b);
    }

    @Override
    public void a(bfs bfs2) {
        Object object;
        if (this.var_bir_a.j()) {
            object = this.var_bir_a.bfw_a(bfs2.bfr_a());
            if (object == null) {
                bfs2.b((bfw)((Object)this.var_bgc_a), String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", this.var_bgc_a, this.var_bir_a.getClass().getName()));
            }
            this.var_boolean_b = this.a(bfs2, (bfw)object, null);
        } else if (this.var_bir_a.k()) {
            object = this.var_bir_a.b(bfs2.bfr_a());
            if (object == null) {
                bfs2.b((bfw)((Object)this.var_bgc_a), String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", this.var_bgc_a, this.var_bir_a.getClass().getName()));
            }
            this.var_boolean_b = this.a(bfs2, (bfw)object, null);
        }
        if (this.var_bir_a.l()) {
            object = this.var_bir_a.bio_arr_a(bfs2.bfr_a());
            this.var_bjo_a = bjo.a(bfs2, this.var_bir_a, object, bfs2.a(bgd.v));
        }
        this.var_boolean_b = this.a((bfw)((Object)this.var_bgc_a), this.var_bgc_a);
    }

    @Override
    public bfx<?> a(bfs bfs2, bfp bfp2) {
        bmn bmn2;
        bgc bgc2 = this.var_bgc_a;
        if (bgc2 == null) {
            bgc2 = bfs2.a(((bfw)((Object)this.var_bgc_a)).bfw_b(), bfp2);
        } else if (bgc2 instanceof bic) {
            bgc2 = ((bic)((Object)bgc2)).a(bfs2, bfp2);
        }
        bfx<Object> bfx2 = this.var_bgc_a;
        if (bfp2 != null) {
            bfx2 = this.a(bfs2, bfp2, bfx2);
        }
        bfw bfw2 = ((bfw)((Object)this.var_bgc_a)).bfw_c();
        bfx2 = bfx2 == null ? bfs2.a(bfw2, bfp2) : bfs2.b(bfx2, bfp2, bfw2);
        boc boc2 = this.var_boc_a;
        if (boc2 != null) {
            boc2 = boc2.a(bfp2);
        }
        Object object = this.var_bgc_a;
        Object object2 = this.var_boolean_b;
        bfn bfn2 = bfs2.bfn_a();
        if (bks.a(bfn2, bfp2) && (bmn2 = bfp2.bmn_a()) != null) {
            HashSet<String> hashSet;
            Object object3;
            Object object4;
            bfr bfr2 = bfs2.bfr_a();
            bbp.a a2 = bfn2.bbp$a_a(bfr2, bmn2);
            if (a2 != null && !(object4 = a2.b()).isEmpty()) {
                object = object == null ? new HashSet() : new HashSet(object);
                object3 = object4.iterator();
                while (object3.hasNext()) {
                    hashSet = (String)object3.next();
                    object.add(hashSet);
                }
            }
            if ((object4 = bfn2.bbs$a_a(bfr2, bmn2)) != null && (object3 = ((bbs.a)object4).a()) != null) {
                hashSet = new HashSet();
                if (object2 == null) {
                    hashSet = new HashSet<String>((Collection<String>)object3);
                } else {
                    Iterator iterator = object3.iterator();
                    while (iterator.hasNext()) {
                        String string = (String)iterator.next();
                        if (!object2.contains(string)) continue;
                        hashSet.add(string);
                    }
                }
                object2 = hashSet;
            }
        }
        return this.a(bgc2, boc2, bfx2, this.a(bfs2, bfp2, bfx2), (Set<String>)object, (Set<String>)object2);
    }

    @Override
    public bfx<Object> a() {
        return this.var_bgc_a;
    }

    @Override
    public bir bir_a() {
        return this.var_bir_a;
    }

    @Override
    public boolean boolean_a() {
        return this.var_bgc_a == null && this.var_bgc_a == null && this.var_boc_a == null && this.var_bgc_a == null && this.var_boolean_b == null;
    }

    @Override
    public btq btq_a() {
        return btq.c;
    }

    @Override
    public Map<Object, Object> a(bdc bdc2, bfs bfs2) {
        if (this.var_bjo_a != null) {
            return this.b(bdc2, bfs2);
        }
        if (this.var_boolean_b != null) {
            return (Map)this.var_bir_a.a(bfs2, this.var_boolean_b.a(bdc2, bfs2));
        }
        if (!this.c) {
            return (Map)bfs2.a(this.b(), this.bir_a(), bdc2, "no default constructor found", new Object[0]);
        }
        switch (bdc2.int_a()) {
            case 1: 
            case 2: 
            case 5: {
                Map map = (Map)this.var_bir_a.a(bfs2);
                if (this.var_boolean_b) {
                    this.b(bdc2, bfs2, map);
                    return map;
                }
                this.a(bdc2, bfs2, map);
                return map;
            }
            case 6: {
                return (Map)this.r(bdc2, bfs2);
            }
            case 3: {
                return (Map)this.e(bdc2, bfs2);
            }
        }
        return (Map)bfs2.a(this.bfw_a(bfs2), bdc2);
    }

    @Override
    public Map<Object, Object> a(bdc bdc2, bfs bfs2, Map<Object, Object> map) {
        bdc2.a(map);
        bdf bdf2 = bdc2.bdf_c();
        if (bdf2 != bdf.var_bdf_b && bdf2 != bdf.f) {
            return (Map)bfs2.a(this.b(), bdc2);
        }
        if (this.var_boolean_b) {
            this.d(bdc2, bfs2, map);
            return map;
        }
        this.c(bdc2, bfs2, map);
        return map;
    }

    @Override
    public Object a(bdc bdc2, bfs bfs2, boc boc2) {
        return boc2.java_lang_Object_a(bdc2, bfs2);
    }

    public final Class<?> b() {
        return ((bfw)((Object)this.var_bgc_a)).a();
    }

    @Override
    public bfw bfw_a() {
        return this.var_bgc_a;
    }

    @Override
    protected final void a(bdc bdc2, bfs bfs2, Map<Object, Object> map) {
        Object object;
        String string;
        boolean bl2;
        bgc bgc2 = this.var_bgc_a;
        bgc bgc3 = this.var_bgc_a;
        boc boc2 = this.var_boc_a;
        b b2 = null;
        boolean bl3 = bl2 = ((bfx)((Object)bgc3)).bjl_a() != null;
        if (bl2) {
            b2 = new b((Class<?>)((bfw)((Object)this.var_bgc_a)).bfw_c().a(), map);
        }
        if (bdc2.boolean_d()) {
            string = bdc2.java_lang_String_a();
        } else {
            object = bdc2.bdf_c();
            if (object != bdf.f) {
                if (object == bdf.var_bdf_c) {
                    return;
                }
                bfs2.a(this, bdf.f, null, new Object[0]);
            }
            string = bdc2.java_lang_String_d();
        }
        while (string != null) {
            block15: {
                object = bgc2.a(string, bfs2);
                bdf bdf2 = bdc2.bdf_a();
                if (this.var_bup$a_a != null && this.var_bup$a_a.a(string)) {
                    bdc2.bdc_a();
                } else {
                    try {
                        Object object2;
                        if (bdf2 == bdf.m) {
                            if (this.var_bgc_a != false) break block15;
                            object2 = this.var_bgc_a.a(bfs2);
                        } else {
                            object2 = boc2 == null ? ((bfx)((Object)bgc3)).a(bdc2, bfs2) : ((bfx)((Object)bgc3)).a(bdc2, bfs2, boc2);
                        }
                        if (bl2) {
                            b2.a(object, object2);
                        } else {
                            map.put(object, object2);
                        }
                    }
                    catch (bip bip2) {
                        this.a(bfs2, b2, object, bip2);
                    }
                    catch (Exception exception) {
                        this.a(bfs2, exception, map, string);
                    }
                }
            }
            string = bdc2.java_lang_String_a();
        }
    }

    protected final void b(bdc bdc2, bfs bfs2, Map<Object, Object> map) {
        bdf bdf2;
        String string;
        boolean bl2;
        bgc bgc2 = this.var_bgc_a;
        boc boc2 = this.var_boc_a;
        b b2 = null;
        boolean bl3 = bl2 = ((bfx)((Object)bgc2)).bjl_a() != null;
        if (bl2) {
            b2 = new b((Class<?>)((bfw)((Object)this.var_bgc_a)).bfw_c().a(), map);
        }
        if (bdc2.boolean_d()) {
            string = bdc2.java_lang_String_a();
        } else {
            bdf2 = bdc2.bdf_c();
            if (bdf2 == bdf.var_bdf_c) {
                return;
            }
            if (bdf2 != bdf.f) {
                bfs2.a(this, bdf.f, null, new Object[0]);
            }
            string = bdc2.java_lang_String_d();
        }
        while (string != null) {
            block15: {
                bdf2 = bdc2.bdf_a();
                if (this.var_bup$a_a != null && this.var_bup$a_a.a(string)) {
                    bdc2.bdc_a();
                } else {
                    try {
                        Object object;
                        if (bdf2 == bdf.m) {
                            if (this.var_bgc_a != false) break block15;
                            object = this.var_bgc_a.a(bfs2);
                        } else {
                            object = boc2 == null ? ((bfx)((Object)bgc2)).a(bdc2, bfs2) : ((bfx)((Object)bgc2)).a(bdc2, bfs2, boc2);
                        }
                        if (bl2) {
                            b2.a(string, object);
                        } else {
                            map.put(string, object);
                        }
                    }
                    catch (bip bip2) {
                        this.a(bfs2, b2, (Object)string, bip2);
                    }
                    catch (Exception exception) {
                        this.a(bfs2, exception, map, string);
                    }
                }
            }
            string = bdc2.java_lang_String_a();
        }
    }

    public Map<Object, Object> b(bdc bdc2, bfs bfs2) {
        bjo bjo2 = this.var_bjo_a;
        bjr bjr2 = bjo2.a(bdc2, bfs2, null);
        bgc bgc2 = this.var_bgc_a;
        boc boc2 = this.var_boc_a;
        String string = bdc2.boolean_d() ? bdc2.java_lang_String_a() : (bdc2.boolean_a(bdf.f) ? bdc2.java_lang_String_d() : null);
        while (string != null) {
            block13: {
                bdf bdf2 = bdc2.bdf_a();
                if (this.var_bup$a_a != null && this.var_bup$a_a.a(string)) {
                    bdc2.bdc_a();
                } else {
                    Object object;
                    bio bio2 = bjo2.a(string);
                    if (bio2 != null) {
                        if (bjr2.boolean_a(bio2, bio2.java_lang_Object_a(bdc2, bfs2))) {
                            bdc2.bdf_a();
                            try {
                                object = (Map)bjo2.a(bfs2, bjr2);
                            }
                            catch (Exception exception) {
                                return (Map)this.a(bfs2, exception, ((bfw)((Object)this.var_bgc_a)).a(), string);
                            }
                            this.a(bdc2, bfs2, (Map<Object, Object>)object);
                            return object;
                        }
                    } else {
                        Object object2;
                        block14: {
                            object = this.var_bgc_a.a(string, bfs2);
                            try {
                                if (bdf2 == bdf.m) {
                                    if (this.var_bgc_a != false) break block13;
                                    object2 = this.var_bgc_a.a(bfs2);
                                    break block14;
                                }
                                object2 = boc2 == null ? ((bfx)((Object)bgc2)).a(bdc2, bfs2) : ((bfx)((Object)bgc2)).a(bdc2, bfs2, boc2);
                            }
                            catch (Exception exception) {
                                this.a(bfs2, exception, ((bfw)((Object)this.var_bgc_a)).a(), string);
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
            return (Map)bjo2.a(bfs2, bjr2);
        }
        catch (Exception exception) {
            this.a(bfs2, exception, ((bfw)((Object)this.var_bgc_a)).a(), string);
            return null;
        }
    }

    protected final void c(bdc bdc2, bfs bfs2, Map<Object, Object> map) {
        Object object;
        String string;
        bgc bgc2 = this.var_bgc_a;
        bgc bgc3 = this.var_bgc_a;
        boc boc2 = this.var_boc_a;
        if (bdc2.boolean_d()) {
            string = bdc2.java_lang_String_a();
        } else {
            object = bdc2.bdf_c();
            if (object == bdf.var_bdf_c) {
                return;
            }
            if (object != bdf.f) {
                bfs2.a(this, bdf.f, null, new Object[0]);
            }
            string = bdc2.java_lang_String_d();
        }
        while (string != null) {
            object = bgc2.a(string, bfs2);
            bdf bdf2 = bdc2.bdf_a();
            if (this.var_bup$a_a != null && this.var_bup$a_a.a(string)) {
                bdc2.bdc_a();
            } else {
                try {
                    if (bdf2 == bdf.m) {
                        if (this.var_bgc_a == false) {
                            map.put(object, this.var_bgc_a.a(bfs2));
                        }
                    } else {
                        Object object2 = map.get(object);
                        Object object3 = object2 != null ? (boc2 == null ? ((bfx)((Object)bgc3)).a(bdc2, bfs2, object2) : ((bfx)((Object)bgc3)).a(bdc2, bfs2, boc2, object2)) : (boc2 == null ? ((bfx)((Object)bgc3)).a(bdc2, bfs2) : ((bfx)((Object)bgc3)).a(bdc2, bfs2, boc2));
                        if (object3 != object2) {
                            map.put(object, object3);
                        }
                    }
                }
                catch (Exception exception) {
                    this.a(bfs2, exception, map, string);
                }
            }
            string = bdc2.java_lang_String_a();
        }
    }

    protected final void d(bdc bdc2, bfs bfs2, Map<Object, Object> map) {
        bdf bdf2;
        String string;
        bgc bgc2 = this.var_bgc_a;
        boc boc2 = this.var_boc_a;
        if (bdc2.boolean_d()) {
            string = bdc2.java_lang_String_a();
        } else {
            bdf2 = bdc2.bdf_c();
            if (bdf2 == bdf.var_bdf_c) {
                return;
            }
            if (bdf2 != bdf.f) {
                bfs2.a(this, bdf.f, null, new Object[0]);
            }
            string = bdc2.java_lang_String_d();
        }
        while (string != null) {
            bdf2 = bdc2.bdf_a();
            if (this.var_bup$a_a != null && this.var_bup$a_a.a(string)) {
                bdc2.bdc_a();
            } else {
                try {
                    if (bdf2 == bdf.m) {
                        if (this.var_bgc_a == false) {
                            map.put(string, this.var_bgc_a.a(bfs2));
                        }
                    } else {
                        Object object = map.get(string);
                        Object object2 = object != null ? (boc2 == null ? ((bfx)((Object)bgc2)).a(bdc2, bfs2, object) : ((bfx)((Object)bgc2)).a(bdc2, bfs2, boc2, object)) : (boc2 == null ? ((bfx)((Object)bgc2)).a(bdc2, bfs2) : ((bfx)((Object)bgc2)).a(bdc2, bfs2, boc2));
                        if (object2 != object) {
                            map.put(string, object2);
                        }
                    }
                }
                catch (Exception exception) {
                    this.a(bfs2, exception, map, string);
                }
            }
            string = bdc2.java_lang_String_a();
        }
    }

    private void a(bfs bfs2, b b2, Object object, bip bip2) {
        if (b2 == null) {
            bfs2.a(this, "Unresolved forward reference but no identity info: " + bip2, new Object[0]);
        }
        bjs.a a2 = b2.a(bip2, object);
        bip2.bjs_a().a(a2);
    }

    static class a
    extends bjs.a {
        private final b var_bks$b_a = new LinkedHashMap();
        public final Map<Object, Object> cfr_renamed_26;
        public final Object var_java_lang_Object_a;

        a(b b2, bip bip2, Class<?> clazz, Object object) {
            super(bip2, clazz);
            this.var_bks$b_a = b2;
            this.var_java_lang_Object_a = object;
        }

        @Override
        public void a(Object object, Object object2) {
            this.var_bks$b_a.b(object, object2);
        }
    }

    static final class b {
        private final Class<?> var_java_lang_Class____a = new ArrayList();
        private Map<Object, Object> cfr_renamed_26;
        private List<a> var_java_util_List_bks$a__a;

        public b(Class<?> clazz, Map<Object, Object> map) {
            this.var_java_lang_Class____a = clazz;
            this.var_java_lang_Class____a = map;
        }

        public void a(Object object, Object object2) {
            if (this.var_java_lang_Class____a.isEmpty()) {
                this.var_java_lang_Class____a.put(object, object2);
            } else {
                a a2 = (a)this.var_java_lang_Class____a.get(this.var_java_lang_Class____a.size() - 1);
                a2.var_bks$b_a.put(object, object2);
            }
        }

        public bjs.a a(bip bip2, Object object) {
            a a2 = new a(this, bip2, this.var_java_lang_Class____a, object);
            this.var_java_lang_Class____a.add((a)a2);
            return a2;
        }

        public void b(Object object, Object object2) {
            Iterator iterator = this.var_java_lang_Class____a.iterator();
            Object object3 = this.var_java_lang_Class____a;
            while (iterator.hasNext()) {
                a a2 = (a)iterator.next();
                if (a2.boolean_a(object)) {
                    iterator.remove();
                    object3.put(a2.var_java_lang_Object_a, object2);
                    object3.putAll(a2.var_bks$b_a);
                    return;
                }
                object3 = a2.var_bks$b_a;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + object + "] that wasn't previously seen as unresolved.");
        }
    }
}

