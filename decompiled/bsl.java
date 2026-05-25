/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

@bgp
public class bsl
extends bqg<Map<?, ?>>
implements bqh {
    protected static final bfw var_bfw_a;
    public static final Object var_java_lang_Object_a;
    protected final bfp var_bfp_a;
    protected final boolean var_boolean_a;
    protected final bfw var_bfw_b;
    protected final bfw var_bfw_c;
    protected bgb<Object> var_bgb_java_lang_Object__a;
    protected bgb<Object> var_bgb_java_lang_Object__b;
    protected final bog var_bog_a;
    protected bre var_bre_a;
    protected final Set<String> var_java_util_Set_java_lang_String__a;
    protected final Set<String> var_java_util_Set_java_lang_String__b;
    protected final Object var_java_lang_Object_b;
    protected final Object var_java_lang_Object_c;
    protected final boolean var_boolean_b;
    protected final bup.a var_bup$a_a;
    protected final boolean var_boolean_c;

    protected bsl(Set<String> set, Set<String> set2, bfw bfw2, bfw bfw3, boolean bl2, bog bog2, bgb<?> bgb2, bgb<?> bgb3) {
        super(Map.class, false);
        this.var_bfw_a = set == null || set.isEmpty() ? null : set;
        this.var_bfw_b = set2;
        this.var_bfw_b = bfw2;
        this.var_bfw_c = bfw3;
        this.var_boolean_a = bl2;
        this.var_bog_a = bog2;
        this.var_bfw_a = bgb2;
        this.var_bfw_b = bgb3;
        this.var_bre_a = bre.a();
        this.var_bfp_a = null;
        this.var_java_lang_Object_b = null;
        this.var_boolean_c = false;
        this.var_java_lang_Object_c = null;
        this.var_boolean_b = false;
        this.var_bup$a_a = bup.a((Set<String>)((Object)this.var_bfw_a), (Set<String>)((Object)this.var_bfw_b));
    }

    protected bsl(bsl bsl2, bfp bfp2, bgb<?> bgb2, bgb<?> bgb3, Set<String> set, Set<String> set2) {
        super(Map.class, false);
        this.var_bfw_a = set == null || set.isEmpty() ? null : set;
        this.var_bfw_b = set2;
        this.var_bfw_b = bsl2.var_bfw_b;
        this.var_bfw_c = bsl2.var_bfw_c;
        this.var_boolean_a = bsl2.var_boolean_a;
        this.var_bog_a = bsl2.var_bog_a;
        this.var_bfw_a = bgb2;
        this.var_bfw_b = bgb3;
        this.var_bre_a = bre.a();
        this.var_bfp_a = bfp2;
        this.var_java_lang_Object_b = bsl2.var_java_lang_Object_b;
        this.var_boolean_c = bsl2.var_boolean_c;
        this.var_java_lang_Object_c = bsl2.var_java_lang_Object_c;
        this.var_boolean_b = bsl2.var_boolean_b;
        this.var_bup$a_a = bup.a((Set<String>)((Object)this.var_bfw_a), (Set<String>)((Object)this.var_bfw_b));
    }

    protected bsl(bsl bsl2, bog bog2, Object object, boolean bl2) {
        super(Map.class, false);
        this.var_bfw_a = bsl2.var_bfw_a;
        this.var_bfw_b = bsl2.var_bfw_b;
        this.var_bfw_b = bsl2.var_bfw_b;
        this.var_bfw_c = bsl2.var_bfw_c;
        this.var_boolean_a = bsl2.var_boolean_a;
        this.var_bog_a = bog2;
        this.var_bfw_a = bsl2.var_bfw_a;
        this.var_bfw_b = bsl2.var_bfw_b;
        this.var_bre_a = bsl2.var_bre_a;
        this.var_bfp_a = bsl2.var_bfp_a;
        this.var_java_lang_Object_b = bsl2.var_java_lang_Object_b;
        this.var_boolean_c = bsl2.var_boolean_c;
        this.var_java_lang_Object_c = object;
        this.var_boolean_b = bl2;
        this.var_bup$a_a = bsl2.var_bup$a_a;
    }

    protected bsl(bsl bsl2, Object object, boolean bl2) {
        super(Map.class, false);
        this.var_bfw_a = bsl2.var_bfw_a;
        this.var_bfw_b = bsl2.var_bfw_b;
        this.var_bfw_b = bsl2.var_bfw_b;
        this.var_bfw_c = bsl2.var_bfw_c;
        this.var_boolean_a = bsl2.var_boolean_a;
        this.var_bog_a = bsl2.var_bog_a;
        this.var_bfw_a = bsl2.var_bfw_a;
        this.var_bfw_b = bsl2.var_bfw_b;
        this.var_bre_a = bre.a();
        this.var_bfp_a = bsl2.var_bfp_a;
        this.var_java_lang_Object_b = object;
        this.var_boolean_c = bl2;
        this.var_java_lang_Object_c = bsl2.var_java_lang_Object_c;
        this.var_boolean_b = bsl2.var_boolean_b;
        this.var_bup$a_a = bsl2.var_bup$a_a;
    }

    public bsl a(bog bog2) {
        if (this.var_bog_a == bog2) {
            return this;
        }
        this.a("_withValueTypeSerializer");
        return new bsl(this, bog2, this.var_java_lang_Object_c, this.var_boolean_b);
    }

    public bsl a(bfp bfp2, bgb<?> bgb2, bgb<?> bgb3, Set<String> set, Set<String> set2, boolean bl2) {
        this.a("withResolved");
        bsl bsl2 = new bsl(this, bfp2, bgb2, bgb3, set, set2);
        if (bl2 != bsl2.var_boolean_c) {
            bsl2 = new bsl(bsl2, this.var_java_lang_Object_b, bl2);
        }
        return bsl2;
    }

    public bsl a(Object object) {
        if (this.var_java_lang_Object_b == object) {
            return this;
        }
        this.a("withFilterId");
        return new bsl(this, object, this.var_boolean_c);
    }

    public bsl a(Object object, boolean bl2) {
        if (object == this.var_java_lang_Object_c && bl2 == this.var_boolean_b) {
            return this;
        }
        this.a("withContentInclusion");
        return new bsl(this, this.var_bog_a, object, bl2);
    }

    public static bsl a(Set<String> set, Set<String> set2, bfw bfw2, boolean bl2, bog bog2, bgb<Object> bgb2, bgb<Object> bgb3, Object object) {
        bfw bfw3;
        bfw bfw4;
        if (bfw2 == null) {
            bfw3 = bfw4 = var_bfw_a;
        } else {
            bfw3 = bfw2.bfw_b();
            bfw4 = bfw2.boolean_a(Properties.class) ? btz.bfw_a() : bfw2.bfw_c();
        }
        if (!bl2) {
            bl2 = bfw4 != null && bfw4.l();
        } else if (bfw4.a() == Object.class) {
            bl2 = false;
        }
        bsl bsl2 = new bsl(set, set2, bfw3, bfw4, bl2, bog2, bgb2, bgb3);
        if (object != null) {
            bsl2 = bsl2.a(object);
        }
        return bsl2;
    }

    public static bsl a(Set<String> set, bfw bfw2, boolean bl2, bog bog2, bgb<Object> bgb2, bgb<Object> bgb3, Object object) {
        return bsl.a(set, null, bfw2, bl2, bog2, bgb2, bgb3, object);
    }

    protected void a(String string) {
        buk.a(bsl.class, this, string);
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        Object object;
        Object object2;
        Object object3;
        Set<String> set;
        Serializable serializable;
        HashSet<Object> hashSet;
        bmn bmn2;
        bgb<Object> bgb2 = null;
        bgb<Object> bgb3 = null;
        bfn bfn2 = bgo2.bfn_a();
        bmn bmn3 = bmn2 = bfp2 == null ? null : bfp2.bmn_a();
        if (bsl.a(bmn2, bfn2)) {
            hashSet = bfn2.java_lang_Object_c((bmg)bmn2);
            if (hashSet != null) {
                bgb3 = bgo2.a((bmg)bmn2, (Object)hashSet);
            }
            if ((hashSet = bfn2.java_lang_Object_d(bmn2)) != null) {
                bgb2 = bgo2.a((bmg)bmn2, (Object)hashSet);
            }
        }
        if (bgb2 == null) {
            bgb2 = this.var_bfw_b;
        }
        if ((bgb2 = this.a(bgo2, bfp2, bgb2)) == null && this.var_boolean_a && !this.var_bfw_c.p()) {
            bgb2 = bgo2.c(this.var_bfw_c, bfp2);
        }
        if (bgb3 == null) {
            bgb3 = this.var_bfw_a;
        }
        bgb3 = bgb3 == null ? bgo2.d(this.var_bfw_b, bfp2) : bgo2.b(bgb3, bfp2);
        hashSet = this.var_bfw_a;
        Serializable serializable2 = this.var_bfw_b;
        boolean bl2 = false;
        if (bsl.a(bmn2, bfn2)) {
            serializable = bgo2.bgm_a();
            set = bfn2.bbp$a_a((bhm<?>)serializable, bmn2).a();
            if (bsl.b(set)) {
                hashSet = hashSet == null ? new HashSet<Object>() : new HashSet(hashSet);
                object3 = set.iterator();
                while (object3.hasNext()) {
                    object2 = (String)object3.next();
                    hashSet.add(object2);
                }
            }
            if ((object3 = bfn2.bbs$a_a((bhm<?>)serializable, bmn2).a()) != null) {
                serializable2 = serializable2 == null ? new HashSet() : new HashSet(serializable2);
                object2 = object3.iterator();
                while (object2.hasNext()) {
                    object = (String)object2.next();
                    serializable2.add(object);
                }
            }
            object2 = bfn2.java_lang_Object_a((bmg)bmn2);
            bl2 = Boolean.TRUE.equals(object2);
        }
        if ((serializable = this.bbk$d_a(bgo2, bfp2, Map.class)) != null && (set = ((bbk.d)serializable).a(bbk.a.g)) != null) {
            bl2 = (Boolean)((Object)set);
        }
        set = this.a(bfp2, bgb3, bgb2, (Set<String>)hashSet, (Set<String>)((Object)serializable2), bl2);
        if (bmn2 != null && (object3 = bfn2.java_lang_Object_a((bmg)bmn2)) != null) {
            set = ((bsl)((Object)set)).a(object3);
        }
        if ((object3 = this.bbr$b_a(bgo2, bfp2, Map.class)) != null && (object2 = ((bbr.b)object3).b()) != bbr.a.g) {
            boolean bl3;
            switch (bsm.a[((Enum)object2).ordinal()]) {
                case 1: {
                    object = buh.java_lang_Object_a(this.var_bfw_c);
                    bl3 = true;
                    if (object == null || !object.getClass().isArray()) break;
                    object = bue.a(object);
                    break;
                }
                case 2: {
                    bl3 = true;
                    object = this.var_bfw_c.a() != false ? var_java_lang_Object_a : null;
                    break;
                }
                case 3: {
                    bl3 = true;
                    object = var_java_lang_Object_a;
                    break;
                }
                case 4: {
                    object = bgo2.a((bmx)null, ((bbr.b)object3).b());
                    if (object == null) {
                        bl3 = true;
                        break;
                    }
                    bl3 = bgo2.boolean_a(object);
                    break;
                }
                case 5: {
                    object = null;
                    bl3 = true;
                    break;
                }
                default: {
                    object = null;
                    bl3 = false;
                }
            }
            set = ((bsl)((Object)set)).a(object, bl3);
        }
        return set;
    }

    public bfw a() {
        return this.var_bfw_c;
    }

    @Override
    public boolean a(bgo bgo2, Map<?, ?> map) {
        boolean bl2;
        if (map.isEmpty()) {
            return true;
        }
        Object object = this.var_java_lang_Object_c;
        if (object == null && !this.var_boolean_b) {
            return false;
        }
        Object object2 = this.var_bfw_b;
        boolean bl3 = bl2 = var_java_lang_Object_a == object;
        if (object2 != null) {
            for (Object obj : map.values()) {
                if (obj == null) {
                    if (this.var_boolean_b) continue;
                    return false;
                }
                if (!(bl2 ? !((bgb)object2).a(bgo2, obj) : object == null || !object.equals(map))) continue;
                return false;
            }
            return true;
        }
        for (Object obj : map.values()) {
            if (obj == null) {
                if (this.var_boolean_b) continue;
                return false;
            }
            try {
                object2 = this.a(bgo2, obj);
            }
            catch (bfy bfy2) {
                return false;
            }
            if (!(bl2 ? !((bgb)object2).a(bgo2, obj) : object == null || !object.equals(map))) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean a(Map<?, ?> map) {
        return map.size() == 1;
    }

    @Override
    public void a(Map<?, ?> map, bcy bcy2, bgo bgo2) {
        bcy2.c(map);
        this.b(map, bcy2, bgo2);
        bcy2.void_d();
    }

    @Override
    public void a(Map<?, ?> map, bcy bcy2, bgo bgo2, bog bog2) {
        bcy2.a(map);
        beu beu2 = bog2.a(bcy2, bog2.a(map, bdf.var_bdf_b));
        this.b(map, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }

    public void b(Map<?, ?> map, bcy bcy2, bgo bgo2) {
        if (!map.isEmpty()) {
            bqm bqm2;
            if (this.var_boolean_c || bgo2.a(bgn.w)) {
                map = this.a(map, bcy2, bgo2);
            }
            if (this.var_java_lang_Object_b != null && (bqm2 = this.a(bgo2, this.var_java_lang_Object_b, map)) != null) {
                this.a(map, bcy2, bgo2, bqm2, this.var_java_lang_Object_c);
            } else if (this.var_java_lang_Object_c != null || this.var_boolean_b) {
                this.a(map, bcy2, bgo2, this.var_java_lang_Object_c);
            } else if (this.var_bfw_b != null) {
                this.a(map, bcy2, bgo2, (bgb<Object>)((Object)this.var_bfw_b));
            } else {
                this.c(map, bcy2, bgo2);
            }
        }
    }

    public void c(Map<?, ?> map, bcy bcy2, bgo bgo2) {
        if (this.var_bog_a != null) {
            this.b(map, bcy2, bgo2, null);
            return;
        }
        bfw bfw2 = this.var_bfw_a;
        Object t2 = null;
        try {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                Object obj = entry.getValue();
                t2 = entry.getKey();
                if (t2 == null) {
                    bgo2.e(this.var_bfw_b, this.var_bfp_a).a(null, bcy2, bgo2);
                } else {
                    if (this.var_bup$a_a != null && this.var_bup$a_a.a(t2)) continue;
                    ((bgb)((Object)bfw2)).a(t2, bcy2, bgo2);
                }
                if (obj == null) {
                    bgo2.a(bcy2);
                    continue;
                }
                Object object = this.var_bfw_b;
                if (object == null) {
                    object = this.a(bgo2, obj);
                }
                ((bgb)object).a(obj, bcy2, bgo2);
            }
        }
        catch (Exception exception) {
            this.a(bgo2, (Throwable)exception, map, String.valueOf(t2));
        }
    }

    public void a(Map<?, ?> map, bcy bcy2, bgo bgo2, Object object) {
        if (this.var_bog_a != null) {
            this.b(map, bcy2, bgo2, object);
            return;
        }
        boolean bl2 = var_java_lang_Object_a == object;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object object2;
            Object object3;
            Object obj = entry.getKey();
            if (obj == null) {
                object3 = bgo2.e(this.var_bfw_b, this.var_bfp_a);
            } else {
                if (this.var_bup$a_a != null && this.var_bup$a_a.a(obj)) continue;
                object3 = this.var_bfw_a;
            }
            Object obj2 = entry.getValue();
            if (obj2 == null) {
                if (this.var_boolean_b) continue;
                object2 = bgo2.a();
            } else {
                object2 = this.var_bfw_b;
                if (object2 == null) {
                    object2 = this.a(bgo2, obj2);
                }
                if (bl2 ? ((bgb)object2).a(bgo2, obj2) : object != null && object.equals(obj2)) continue;
            }
            try {
                ((bgb)object3).a(obj, bcy2, bgo2);
                ((bgb)object2).a(obj2, bcy2, bgo2);
            }
            catch (Exception exception) {
                this.a(bgo2, (Throwable)exception, map, String.valueOf(obj));
            }
        }
    }

    public void a(Map<?, ?> map, bcy bcy2, bgo bgo2, bgb<Object> bgb2) {
        bfw bfw2 = this.var_bfw_a;
        bog bog2 = this.var_bog_a;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object obj = entry.getKey();
            if (this.var_bup$a_a != null && this.var_bup$a_a.a(obj)) continue;
            if (obj == null) {
                bgo2.e(this.var_bfw_b, this.var_bfp_a).a(null, bcy2, bgo2);
            } else {
                ((bgb)((Object)bfw2)).a(obj, bcy2, bgo2);
            }
            Object obj2 = entry.getValue();
            if (obj2 == null) {
                bgo2.a(bcy2);
                continue;
            }
            try {
                if (bog2 == null) {
                    bgb2.a(obj2, bcy2, bgo2);
                    continue;
                }
                bgb2.a(obj2, bcy2, bgo2, bog2);
            }
            catch (Exception exception) {
                this.a(bgo2, (Throwable)exception, map, String.valueOf(obj));
            }
        }
    }

    public void a(Map<?, ?> map, bcy bcy2, bgo bgo2, bqm bqm2, Object object) {
        bsk bsk2 = new bsk(this.var_bog_a, this.var_bfp_a);
        boolean bl2 = var_java_lang_Object_a == object;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object object2;
            Object obj = entry.getKey();
            if (this.var_bup$a_a != null && this.var_bup$a_a.a(obj)) continue;
            Object object3 = obj == null ? bgo2.e(this.var_bfw_b, this.var_bfp_a) : this.var_bfw_a;
            Object obj2 = entry.getValue();
            if (obj2 == null) {
                if (this.var_boolean_b) continue;
                object2 = bgo2.a();
            } else {
                object2 = this.var_bfw_b;
                if (object2 == null) {
                    object2 = this.a(bgo2, obj2);
                }
                if (bl2 ? ((bgb)object2).a(bgo2, obj2) : object != null && object.equals(obj2)) continue;
            }
            bsk2.a(obj, obj2, (bgb<Object>)object3, (bgb<Object>)object2);
            try {
                bqm2.a(map, bcy2, bgo2, bsk2);
            }
            catch (Exception exception) {
                this.a(bgo2, (Throwable)exception, map, String.valueOf(obj));
            }
        }
    }

    public void b(Map<?, ?> map, bcy bcy2, bgo bgo2, Object object) {
        boolean bl2 = var_java_lang_Object_a == object;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object object2;
            Object object3;
            Object obj = entry.getKey();
            if (obj == null) {
                object3 = bgo2.e(this.var_bfw_b, this.var_bfp_a);
            } else {
                if (this.var_bup$a_a != null && this.var_bup$a_a.a(obj)) continue;
                object3 = this.var_bfw_a;
            }
            Object obj2 = entry.getValue();
            if (obj2 == null) {
                if (this.var_boolean_b) continue;
                object2 = bgo2.a();
            } else {
                object2 = this.var_bfw_b;
                if (object2 == null) {
                    object2 = this.a(bgo2, obj2);
                }
                if (bl2 ? ((bgb)object2).a(bgo2, obj2) : object != null && object.equals(obj2)) continue;
            }
            ((bgb)object3).a(obj, bcy2, bgo2);
            try {
                ((bgb)object2).a(obj2, bcy2, bgo2, this.var_bog_a);
            }
            catch (Exception exception) {
                this.a(bgo2, (Throwable)exception, map, String.valueOf(obj));
            }
        }
    }

    public void a(bgo bgo2, bcy bcy2, Object object, Map<?, ?> map, bqm bqm2, Object object2) {
        bsk bsk2 = new bsk(this.var_bog_a, this.var_bfp_a);
        boolean bl2 = var_java_lang_Object_a == object2;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object object3;
            Object obj = entry.getKey();
            if (this.var_bup$a_a != null && this.var_bup$a_a.a(obj)) continue;
            Object object4 = obj == null ? bgo2.e(this.var_bfw_b, this.var_bfp_a) : this.var_bfw_a;
            Object obj2 = entry.getValue();
            if (obj2 == null) {
                if (this.var_boolean_b) continue;
                object3 = bgo2.a();
            } else {
                object3 = this.var_bfw_b;
                if (object3 == null) {
                    object3 = this.a(bgo2, obj2);
                }
                if (bl2 ? ((bgb)object3).a(bgo2, obj2) : object2 != null && object2.equals(obj2)) continue;
            }
            bsk2.a(obj, obj2, (bgb<Object>)object4, (bgb<Object>)object3);
            try {
                bqm2.a(object, bcy2, bgo2, bsk2);
            }
            catch (Exception exception) {
                this.a(bgo2, (Throwable)exception, map, String.valueOf(obj));
            }
        }
    }

    protected final bgb<Object> a(bre bre2, Class<?> clazz, bgo bgo2) {
        bre.d d2 = bre2.b(clazz, bgo2, this.var_bfp_a);
        if (bre2 != d2.var_bre_a) {
            this.var_bre_a = d2.var_bre_a;
        }
        return d2.var_bgb_java_lang_Object__a;
    }

    protected final bgb<Object> a(bre bre2, bfw bfw2, bgo bgo2) {
        bre.d d2 = bre2.b(bfw2, bgo2, this.var_bfp_a);
        if (bre2 != d2.var_bre_a) {
            this.var_bre_a = d2.var_bre_a;
        }
        return d2.var_bgb_java_lang_Object__a;
    }

    protected Map<?, ?> a(Map<?, ?> map, bcy bcy2, bgo bgo2) {
        if (map instanceof SortedMap) {
            return map;
        }
        if (this.b(map)) {
            TreeMap treeMap = new TreeMap();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                Object obj = entry.getKey();
                if (obj == null) {
                    this.a(bcy2, bgo2, entry.getValue());
                    continue;
                }
                treeMap.put(obj, entry.getValue());
            }
            return treeMap;
        }
        return new TreeMap(map);
    }

    protected boolean b(Map<?, ?> map) {
        return map instanceof HashMap && map.containsKey(null);
    }

    protected void a(bcy bcy2, bgo bgo2, Object object) {
        Object object2;
        bgb<Object> bgb2 = bgo2.e(this.var_bfw_b, this.var_bfp_a);
        if (object == null) {
            if (this.var_boolean_b) {
                return;
            }
            object2 = bgo2.a();
        } else {
            object2 = this.var_bfw_b;
            if (object2 == null) {
                object2 = this.a(bgo2, object);
            }
            if (this.var_java_lang_Object_c == var_java_lang_Object_a ? ((bgb)object2).a(bgo2, (Object)object) : this.var_java_lang_Object_c != null && this.var_java_lang_Object_c.equals(object)) {
                return;
            }
        }
        try {
            bgb2.a(null, bcy2, bgo2);
            ((bgb)object2).a((Object)object, bcy2, bgo2);
        }
        catch (Exception exception) {
            this.a(bgo2, (Throwable)exception, object, "");
        }
    }

    private final bgb<Object> a(bgo bgo2, Object object) {
        Class<?> clazz = object.getClass();
        bgb<Object> bgb2 = this.var_bre_a.a(clazz);
        if (bgb2 != null) {
            return bgb2;
        }
        if (this.var_bfw_c.r()) {
            return this.a(this.var_bre_a, bgo2.a(this.var_bfw_c, clazz), bgo2);
        }
        return this.a(this.var_bre_a, clazz, bgo2);
    }

    @Override
    public /* synthetic */ bqg b(bog bog2) {
        return this.a(bog2);
    }

    static {
        var_bfw_a = btz.bfw_a();
        var_java_lang_Object_a = bbr.a.d;
    }
}

