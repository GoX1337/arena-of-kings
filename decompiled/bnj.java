/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Modifier;
import java.util.AbstractMap;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class bnj {
    protected final bhm<?> var_bhm____a;
    protected final bmf var_bmf_a;
    protected final boolean var_boolean_a;
    protected final bfw var_bfw_a;
    protected final bmh var_bmh_a;
    protected final bnu<?> var_bnu____a;
    protected final bfn var_bfn_a;
    protected final boolean var_boolean_b;
    protected boolean var_boolean_c;
    protected LinkedHashMap<String, bnk> cfr_renamed_31;
    protected LinkedList<bnk> var_java_util_LinkedList_bnk__a;
    protected Map<bgj, bgj> cfr_renamed_32;
    protected LinkedList<bmn> var_java_util_LinkedList_bmn__b;
    protected LinkedList<bmn> var_java_util_LinkedList_bmn__c;
    protected LinkedList<bmo> var_java_util_LinkedList_bmo__d;
    protected LinkedList<bmn> e;
    protected LinkedList<bmn> f;
    protected LinkedList<bmn> g;
    protected HashSet<String> var_java_util_HashSet_java_lang_String__a;
    protected LinkedHashMap<Object, bmn> cfr_renamed_33;
    @Deprecated
    protected final boolean var_boolean_d;
    @Deprecated
    protected String var_java_lang_String_a = "set";

    protected bnj(bhm<?> bhm2, boolean bl2, bfw bfw2, bmh bmh2, bmf bmf2) {
        this.var_bhm____a = bhm2;
        this.var_boolean_a = bl2;
        this.var_bfw_a = bfw2;
        this.var_bmh_a = bmh2;
        if (bhm2.b()) {
            this.var_boolean_b = true;
            this.var_bfn_a = this.var_bhm____a.bfn_a();
        } else {
            this.var_boolean_b = false;
            this.var_bfn_a = bfn.bfn_a();
        }
        this.var_bhm____a = this.var_bhm____a.a((Class<?>)bfw2.a(), bmh2);
        this.var_bmf_a = bmf2;
        this.var_boolean_d = bhm2.a(bgd.z);
    }

    public bhm<?> a() {
        return this.var_bhm____a;
    }

    public bfw bfw_a() {
        return this.var_bfw_a;
    }

    public bmh bmh_a() {
        return this.var_bmh_a;
    }

    public List<bmx> a() {
        Map<String, bnk> map = this.b();
        return new ArrayList<bmx>(map.values());
    }

    public Map<Object, bmn> a() {
        if (!this.var_boolean_c) {
            this.void_a();
        }
        return this.var_boolean_b;
    }

    public bmn bmn_a() {
        if (!this.var_boolean_c) {
            this.void_a();
        }
        if (this.f != null) {
            if (this.f.size() > 1) {
                this.a("Multiple 'as-key' properties defined (%s vs %s)", this.f.get(0), this.f.get(1));
            }
            return this.f.get(0);
        }
        return null;
    }

    public bmn b() {
        if (!this.var_boolean_c) {
            this.void_a();
        }
        if (this.g != null) {
            if (this.g.size() > 1) {
                this.a("Multiple 'as-value' properties defined (%s vs %s)", this.g.get(0), this.g.get(1));
            }
            return this.g.get(0);
        }
        return null;
    }

    public bmn c() {
        if (!this.var_boolean_c) {
            this.void_a();
        }
        if (this.var_boolean_c != null) {
            if (this.var_boolean_c.size() > 1) {
                this.a("Multiple 'any-getter' fields defined (%s vs %s)", this.var_boolean_c.get(0), this.var_boolean_c.get(1));
            }
            return (bmn)this.var_boolean_c.getFirst();
        }
        return null;
    }

    public bmn d() {
        if (!this.var_boolean_c) {
            this.void_a();
        }
        if (this.var_boolean_b != null) {
            if (this.var_boolean_b.size() > 1) {
                this.a("Multiple 'any-getter' methods defined (%s vs %s)", this.var_boolean_b.get(0), this.var_boolean_b.get(1));
            }
            return (bmn)this.var_boolean_b.getFirst();
        }
        return null;
    }

    public bmn e() {
        if (!this.var_boolean_c) {
            this.void_a();
        }
        if (this.e != null) {
            if (this.e.size() > 1) {
                this.a("Multiple 'any-setter' fields defined (%s vs %s)", this.e.get(0), this.e.get(1));
            }
            return this.e.getFirst();
        }
        return null;
    }

    public bmo bmo_a() {
        if (!this.var_boolean_c) {
            this.void_a();
        }
        if (this.var_java_util_LinkedList_bmo__d != null) {
            if (this.var_java_util_LinkedList_bmo__d.size() > 1) {
                this.a("Multiple 'any-setter' methods defined (%s vs %s)", this.var_java_util_LinkedList_bmo__d.get(0), this.var_java_util_LinkedList_bmo__d.get(1));
            }
            return this.var_java_util_LinkedList_bmo__d.getFirst();
        }
        return null;
    }

    public Set<String> a() {
        return this.var_bhm____a;
    }

    public bni bni_a() {
        bni bni2 = this.var_bfn_a.bni_a((bmg)this.var_bmh_a);
        if (bni2 != null) {
            bni2 = this.var_bfn_a.a((bmg)this.var_bmh_a, bni2);
        }
        return bni2;
    }

    protected Map<String, bnk> b() {
        if (!this.var_boolean_c) {
            this.void_a();
        }
        return this.var_bhm____a;
    }

    protected void void_a() {
        LinkedHashMap<String, bnk> linkedHashMap = new LinkedHashMap<String, bnk>();
        this.a(linkedHashMap);
        this.c(linkedHashMap);
        if (!this.var_bmh_a.b()) {
            this.b(linkedHashMap);
        }
        this.e(linkedHashMap);
        this.f(linkedHashMap);
        this.g(linkedHashMap);
        this.d(linkedHashMap);
        for (bnk bnk2 : linkedHashMap.values()) {
            bnk2.a(this.var_boolean_a);
        }
        for (bnk bnk2 : linkedHashMap.values()) {
            bnk2.void_c();
        }
        bgk bgk2 = this.bgk_a();
        if (bgk2 != null) {
            this.a(linkedHashMap, bgk2);
        }
        if (this.var_bhm____a.a(bgd.y)) {
            this.h(linkedHashMap);
        }
        this.i(linkedHashMap);
        this.var_bhm____a = linkedHashMap;
        this.var_boolean_c = true;
    }

    protected void a(Map<String, bnk> map) {
        bfn bfn2 = this.var_bfn_a;
        boolean bl2 = !this.var_boolean_a && !this.var_bhm____a.a(bgd.j);
        boolean bl3 = this.var_bhm____a.a(bgd.c);
        for (bml bml2 : this.var_bmh_a.b()) {
            boolean bl4;
            Object object;
            boolean bl5;
            boolean bl6;
            if (Boolean.TRUE.equals(bfn2.java_lang_Boolean_a(this.var_bhm____a, bml2))) {
                if (this.f == null) {
                    this.f = new LinkedList();
                }
                this.f.add(bml2);
            }
            if (Boolean.TRUE.equals(bfn2.java_lang_Object_b((bmg)bml2))) {
                if (this.g == null) {
                    this.g = new LinkedList();
                }
                this.g.add(bml2);
                continue;
            }
            boolean bl7 = Boolean.TRUE.equals(bfn2.java_lang_Object_c((bmg)bml2));
            boolean bl8 = Boolean.TRUE.equals(bfn2.java_lang_Object_d(bml2));
            if (bl7 || bl8) {
                if (bl7) {
                    if (this.var_boolean_c == null) {
                        this.var_boolean_c = new LinkedList();
                    }
                    this.var_boolean_c.add(bml2);
                }
                if (!bl8) continue;
                if (this.e == null) {
                    this.e = new LinkedList();
                }
                this.e.add(bml2);
                continue;
            }
            String string = bfn2.java_lang_String_a(bml2);
            if (string == null) {
                string = bml2.java_lang_String_a();
            }
            if ((string = this.var_bmf_a.a(bml2, string)) == null) continue;
            bgj bgj2 = this.bgj_a(string);
            bgj bgj3 = bfn2.a(this.var_bhm____a, bml2, bgj2);
            if (bgj3 != null && !bgj3.equals(bgj2)) {
                if (this.var_bhm____a == null) {
                    this.var_bhm____a = new HashMap();
                }
                this.var_bhm____a.put(bgj3, bgj2);
            }
            if ((bl6 = (bl5 = (object = this.var_boolean_a ? bfn2.java_lang_Object_b((bmg)bml2) : bfn2.java_lang_Object_c((bmg)bml2)) != null)) && ((bgj)object).c()) {
                object = this.bgj_a(string);
                bl6 = false;
            }
            boolean bl9 = bl4 = object != null;
            if (!bl4) {
                bl4 = this.var_bhm____a.a(bml2);
            }
            boolean bl10 = bfn2.boolean_a(bml2);
            if (bml2.boolean_a() && !bl5) {
                bl4 = false;
                if (bl3) {
                    bl10 = true;
                }
            }
            if (bl2 && object == null && !bl10 && Modifier.isFinal(bml2.int_a())) continue;
            this.a(map, string).a(bml2, (bgj)object, bl6, bl4, bl10);
        }
    }

    protected void b(Map<String, bnk> map) {
        int n2;
        int n3;
        if (!this.var_boolean_b) {
            return;
        }
        for (bmj bms2 : this.var_bmh_a.a()) {
            if (this.var_bhm____a == null) {
                this.var_bhm____a = new LinkedList();
            }
            n3 = bms2.int_a();
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(map, bms2.bmr_a(n2));
            }
        }
        for (bmo bmo2 : this.var_bmh_a.b()) {
            if (this.var_bhm____a == null) {
                this.var_bhm____a = new LinkedList();
            }
            n3 = bmo2.int_a();
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(map, bmo2.bmr_a(n2));
            }
        }
    }

    protected void a(Map<String, bnk> map, bmr bmr2) {
        Object object;
        Object object2;
        boolean bl2;
        String string = this.var_bfn_a.java_lang_String_a(bmr2);
        if (string == null) {
            string = "";
        }
        boolean bl3 = bl2 = (object2 = this.var_bfn_a.java_lang_Object_c((bmg)bmr2)) != null && !((bgj)object2).c();
        if (!bl2) {
            if (string.isEmpty()) {
                return;
            }
            object = this.var_bfn_a.bbh$a_a(this.var_bhm____a, bmr2.bms_a());
            if (object == null || object == bbh.a.d) {
                return;
            }
            object2 = bgj.bgj_a(string);
        }
        string = this.java_lang_String_a(string);
        object = bl2 && string.isEmpty() ? this.a(map, (bgj)object2) : this.a(map, string);
        ((bnk)object).a(bmr2, (bgj)object2, bl2, true, false);
        ((LinkedList)((Object)this.var_bhm____a)).add((Object)object);
    }

    protected void c(Map<String, bnk> map) {
        for (bmo bmo2 : this.var_bmh_a.a()) {
            int n2 = bmo2.int_a();
            if (n2 == 0) {
                this.a(map, bmo2, this.var_bfn_a);
                continue;
            }
            if (n2 == 1) {
                this.b(map, bmo2, this.var_bfn_a);
                continue;
            }
            if (n2 != 2 || !Boolean.TRUE.equals(this.var_bfn_a.java_lang_Object_d(bmo2))) continue;
            if (this.var_java_util_LinkedList_bmo__d == null) {
                this.var_java_util_LinkedList_bmo__d = new LinkedList();
            }
            this.var_java_util_LinkedList_bmo__d.add(bmo2);
        }
    }

    protected void a(Map<String, bnk> map, bmo bmo2, bfn bfn2) {
        boolean bl2;
        boolean bl3;
        Object object = bmo2.c();
        if (object == Void.TYPE || object == Void.class && !this.var_bhm____a.a(bgd.m)) {
            return;
        }
        if (Boolean.TRUE.equals(bfn2.java_lang_Object_c((bmg)bmo2))) {
            if (this.var_boolean_b == null) {
                this.var_boolean_b = new LinkedList();
            }
            this.var_boolean_b.add(bmo2);
            return;
        }
        if (Boolean.TRUE.equals(bfn2.java_lang_Boolean_a(this.var_bhm____a, bmo2))) {
            if (this.f == null) {
                this.f = new LinkedList();
            }
            this.f.add(bmo2);
            return;
        }
        if (Boolean.TRUE.equals(bfn2.java_lang_Object_b((bmg)bmo2))) {
            if (this.g == null) {
                this.g = new LinkedList();
            }
            this.g.add(bmo2);
            return;
        }
        Object object2 = bfn2.java_lang_Object_b((bmg)bmo2);
        boolean bl4 = bl3 = object2 != null;
        if (!bl3) {
            object = bfn2.java_lang_String_a((bmn)bmo2);
            if (object == null) {
                object = this.var_bmf_a.b(bmo2, bmo2.java_lang_String_a());
            }
            if (object == null) {
                object = this.var_bmf_a.a(bmo2, bmo2.java_lang_String_a());
                if (object == null) {
                    return;
                }
                bl2 = this.var_bhm____a.b(bmo2);
            } else {
                bl2 = this.var_bhm____a.a(bmo2);
            }
        } else {
            object = bfn2.java_lang_String_a((bmn)bmo2);
            if (object == null && (object = this.var_bmf_a.b(bmo2, bmo2.java_lang_String_a())) == null) {
                object = this.var_bmf_a.a(bmo2, bmo2.java_lang_String_a());
            }
            if (object == null) {
                object = bmo2.java_lang_String_a();
            }
            if (((bgj)object2).c()) {
                object2 = this.bgj_a((String)object);
                bl3 = false;
            }
            bl2 = true;
        }
        object = this.java_lang_String_a((String)object);
        boolean bl5 = bfn2.boolean_a((bmn)bmo2);
        this.a(map, (String)object).a(bmo2, (bgj)object2, bl3, bl2, bl5);
    }

    protected void b(Map<String, bnk> map, bmo bmo2, bfn bfn2) {
        boolean bl2;
        String string;
        boolean bl3;
        Object object = bfn2.java_lang_Object_c((bmg)bmo2);
        boolean bl4 = bl3 = object != null;
        if (!bl3) {
            string = bfn2.java_lang_String_a((bmn)bmo2);
            if (string == null) {
                string = this.var_bmf_a.c(bmo2, bmo2.java_lang_String_a());
            }
            if (string == null) {
                return;
            }
            bl2 = this.var_bhm____a.c(bmo2);
        } else {
            string = bfn2.java_lang_String_a((bmn)bmo2);
            if (string == null) {
                string = this.var_bmf_a.c(bmo2, bmo2.java_lang_String_a());
            }
            if (string == null) {
                string = bmo2.java_lang_String_a();
            }
            if (((bgj)object).c()) {
                object = this.bgj_a(string);
                bl3 = false;
            }
            bl2 = true;
        }
        string = this.java_lang_String_a(string);
        boolean bl5 = bfn2.boolean_a((bmn)bmo2);
        this.a(map, string).b(bmo2, (bgj)object, bl3, bl2, bl5);
    }

    protected void d(Map<String, bnk> map) {
        for (bml bmn2 : this.var_bmh_a.b()) {
            this.a(this.var_bfn_a.bba$a_a(bmn2), bmn2);
        }
        for (bmo bmo2 : this.var_bmh_a.a()) {
            if (bmo2.int_a() != 1) continue;
            this.a(this.var_bfn_a.bba$a_a((bmn)bmo2), bmo2);
        }
    }

    protected void a(bba.a a2, bmn bmn2) {
        bmn bmn3;
        if (a2 == null) {
            return;
        }
        Object object = a2.java_lang_Object_a();
        if (this.var_boolean_b == null) {
            this.var_boolean_b = new LinkedHashMap();
        }
        if ((bmn3 = this.var_boolean_b.put(object, bmn2)) != null && bmn3.getClass() == bmn2.getClass()) {
            String string = object.getClass().getName();
            throw new IllegalArgumentException("Duplicate injectable value with id '" + object + "' (of type " + string + ")");
        }
    }

    private bgj bgj_a(String string) {
        return bgj.a(string, null);
    }

    private String java_lang_String_a(String string) {
        bgj bgj2;
        if (this.var_bhm____a != null && (bgj2 = (bgj)this.var_bhm____a.get(this.bgj_a(string))) != null) {
            string = bgj2.java_lang_String_a();
            return string;
        }
        return string;
    }

    protected void e(Map<String, bnk> map) {
        Iterator<bnk> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            bnk bnk2 = iterator.next();
            if (!bnk2.j()) {
                iterator.remove();
                continue;
            }
            if (!bnk2.k()) continue;
            if (!bnk2.boolean_a()) {
                iterator.remove();
                this.void_a(bnk2.java_lang_String_a());
                continue;
            }
            bnk2.void_a();
            if (bnk2.boolean_c()) continue;
            this.void_a(bnk2.java_lang_String_a());
        }
    }

    protected void f(Map<String, bnk> map) {
        boolean bl2 = this.var_bhm____a.a(bgd.k);
        for (bnk bnk2 : map.values()) {
            bnk2.a(bl2, this.var_boolean_a ? null : this);
        }
    }

    protected void void_a(String string) {
        if (!this.var_boolean_a && string != null) {
            if (this.var_bhm____a == null) {
                this.var_bhm____a = new HashSet();
            }
            ((HashSet)((Object)this.var_bhm____a)).add((String)string);
        }
    }

    protected void g(Map<String, bnk> map) {
        Object object;
        Object object2;
        Iterator<Map.Entry<String, bnk>> iterator = map.entrySet().iterator();
        LinkedList<bnk> linkedList = null;
        while (iterator.hasNext()) {
            Map.Entry<String, bnk> entry = iterator.next();
            bnk bnk2 = entry.getValue();
            object2 = bnk2.a();
            if (object2.isEmpty()) continue;
            iterator.remove();
            if (linkedList == null) {
                linkedList = new LinkedList<bnk>();
            }
            if (object2.size() == 1) {
                object = (bgj)object2.iterator().next();
                linkedList.add(bnk2.bnk_a((bgj)object));
                continue;
            }
            linkedList.addAll(bnk2.a((Collection<bgj>)object2));
        }
        if (linkedList != null) {
            for (bnk bnk2 : linkedList) {
                object2 = bnk2.java_lang_String_a();
                object = map.get(object2);
                if (object == null) {
                    map.put((String)object2, bnk2);
                } else {
                    ((bnk)object).void_a(bnk2);
                }
                if (!this.a(bnk2, (List<bnk>)((Object)this.var_bhm____a)) || this.var_bhm____a == null) continue;
                ((HashSet)((Object)this.var_bhm____a)).remove(object2);
            }
        }
    }

    protected void a(Map<String, bnk> map, bgk bgk2) {
        bnk[] bnkArray = map.values().toArray(new bnk[map.size()]);
        map.clear();
        for (bnk bnk2 : bnkArray) {
            String string;
            bgj bgj2 = bnk2.bgj_a();
            String string2 = null;
            if (!bnk2.boolean_b() || this.var_bhm____a.a(bgd.A)) {
                if (this.var_boolean_a) {
                    if (bnk2.i()) {
                        string2 = bgk2.a(this.var_bhm____a, bnk2.bmo_a(), bgj2.java_lang_String_a());
                    } else if (bnk2.f()) {
                        string2 = bgk2.a(this.var_bhm____a, bnk2.bml_a(), bgj2.java_lang_String_a());
                    }
                } else if (bnk2.boolean_e()) {
                    string2 = bgk2.b(this.var_bhm____a, bnk2.bmo_b(), bgj2.java_lang_String_a());
                } else if (bnk2.g()) {
                    string2 = bgk2.a(this.var_bhm____a, bnk2.bmr_a(), bgj2.java_lang_String_a());
                } else if (bnk2.f()) {
                    string2 = bgk2.a(this.var_bhm____a, bnk2.bml_a(), bgj2.java_lang_String_a());
                } else if (bnk2.i()) {
                    string2 = bgk2.a(this.var_bhm____a, bnk2.bmo_a(), bgj2.java_lang_String_a());
                }
            }
            if (string2 != null && !bgj2.boolean_a(string2)) {
                bnk2 = bnk2.a(string2);
                string = string2;
            } else {
                string = bgj2.java_lang_String_a();
            }
            bnk bnk3 = map.get(string);
            if (bnk3 == null) {
                map.put(string, bnk2);
            } else {
                bnk3.void_a(bnk2);
            }
            this.a(bnk2, (List<bnk>)((Object)this.var_bhm____a));
        }
    }

    protected void h(Map<String, bnk> map) {
        Object object;
        Object object2;
        Iterator<Map.Entry<String, bnk>> iterator = map.entrySet().iterator();
        LinkedList<bnk> linkedList = null;
        while (iterator.hasNext()) {
            Map.Entry<String, bnk> entry = iterator.next();
            bnk bnk2 = entry.getValue();
            object2 = bnk2.bmn_d();
            if (object2 == null || (object = this.var_bfn_a.java_lang_Object_a((bmg)object2)) == null || !((bgj)object).boolean_a() || ((bgj)object).equals(bnk2.bgj_a())) continue;
            if (linkedList == null) {
                linkedList = new LinkedList<bnk>();
            }
            bnk2 = bnk2.bnk_a((bgj)object);
            linkedList.add(bnk2);
            iterator.remove();
        }
        if (linkedList != null) {
            for (bnk bnk2 : linkedList) {
                object2 = bnk2.java_lang_String_a();
                object = map.get(object2);
                if (object == null) {
                    map.put((String)object2, bnk2);
                    continue;
                }
                ((bnk)object).void_a(bnk2);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void i(Map<String, bnk> map) {
        Comparable<bnk> comparable;
        bfn bfn2 = this.var_bfn_a;
        Object object3 = bfn2.java_lang_Object_a((bmg)this.var_bmh_a);
        boolean bl2 = object3 == null ? this.var_bhm____a.d() : ((Boolean)object3).booleanValue();
        boolean bl3 = this.a(map.values());
        String[] stringArray = bfn2.java_lang_String_arr_a(this.var_bmh_a);
        if (!bl2 && !bl3 && this.var_bhm____a == null && stringArray == null) {
            return;
        }
        int n2 = map.size();
        AbstractMap abstractMap = bl2 ? new TreeMap() : new LinkedHashMap(n2 + n2);
        for (bnk object22 : map.values()) {
            abstractMap.put(object22.java_lang_String_a(), object22);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(n2 + n2);
        if (stringArray != null) {
            for (String string : stringArray) {
                void var13_27;
                comparable = (bnk)abstractMap.remove(string);
                if (comparable == null) {
                    for (bnk bnk2 : map.values()) {
                        if (!string.equals(bnk2.java_lang_String_c())) continue;
                        comparable = bnk2;
                        String string2 = bnk2.java_lang_String_a();
                        break;
                    }
                }
                if (comparable == null) continue;
                linkedHashMap.put(var13_27, comparable);
            }
        }
        if (bl3) {
            TreeMap<bnk, bnk> treeMap = new TreeMap<bnk, bnk>();
            Iterator iterator = abstractMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                bnk bnk3 = (bnk)entry.getValue();
                comparable = bnk3.bgi_a().java_lang_Integer_a();
                if (comparable == null) continue;
                treeMap.put((bnk)comparable, bnk3);
                iterator.remove();
            }
            for (bnk bnk4 : treeMap.values()) {
                linkedHashMap.put(bnk4.java_lang_String_a(), bnk4);
            }
        }
        if (this.var_bhm____a != null && (!bl2 || this.var_bhm____a.a(bgd.u))) {
            void var10_17;
            if (bl2) {
                TreeMap<String, bnk> treeMap = new TreeMap<String, bnk>();
                Iterator iterator = ((AbstractSequentialList)((Object)this.var_bhm____a)).iterator();
                while (iterator.hasNext()) {
                    bnk bnk5 = (bnk)iterator.next();
                    treeMap.put(bnk5.java_lang_String_a(), bnk5);
                }
                Collection collection = treeMap.values();
            } else {
                bhm<?> bhm2 = this.var_bhm____a;
            }
            for (bnk bnk6 : var10_17) {
                String string = bnk6.java_lang_String_a();
                if (!abstractMap.containsKey(string)) continue;
                linkedHashMap.put(string, bnk6);
            }
        }
        linkedHashMap.putAll(abstractMap);
        map.clear();
        map.putAll(linkedHashMap);
    }

    private boolean a(Collection<bnk> collection) {
        for (bnk bnk2 : collection) {
            if (!bnk2.bgi_a().boolean_b()) continue;
            return true;
        }
        return false;
    }

    protected void a(String string, Object ... objectArray) {
        if (objectArray.length > 0) {
            string = String.format(string, objectArray);
        }
        throw new IllegalArgumentException("Problem with definition of " + this.var_bmh_a + ": " + string);
    }

    protected bnk a(Map<String, bnk> map, bgj bgj2) {
        String string = bgj2.java_lang_String_a();
        bnk bnk2 = map.get(string);
        if (bnk2 == null) {
            bnk2 = new bnk(this.var_bhm____a, this.var_bfn_a, this.var_boolean_a, bgj2);
            map.put(string, bnk2);
        }
        return bnk2;
    }

    protected bnk a(Map<String, bnk> map, String string) {
        bnk bnk2 = map.get(string);
        if (bnk2 == null) {
            bnk2 = new bnk(this.var_bhm____a, this.var_bfn_a, this.var_boolean_a, bgj.bgj_a(string));
            map.put(string, bnk2);
        }
        return bnk2;
    }

    private bgk bgk_a() {
        bgk bgk2;
        Object object = this.var_bfn_a.java_lang_Object_a(this.var_bmh_a);
        if (object == null) {
            return this.var_bhm____a.bgk_a();
        }
        if (object instanceof bgk) {
            return (bgk)object;
        }
        if (!(object instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + object.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
        }
        Class clazz = (Class)object;
        if (clazz == bgk.class) {
            return null;
        }
        if (!bgk.class.isAssignableFrom(clazz)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + clazz.getName() + "; expected Class<PropertyNamingStrategy>");
        }
        bhl bhl2 = this.var_bhm____a.bhl_a();
        if (bhl2 != null && (bgk2 = bhl2.bgk_a(this.var_bhm____a, (bmg)this.var_bmh_a, clazz)) != null) {
            return bgk2;
        }
        return (bgk)buk.a(clazz, this.var_bhm____a.c());
    }

    protected boolean a(bnk bnk2, List<bnk> list) {
        if (list != null) {
            String string = bnk2.java_lang_String_c();
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!list.get(i2).java_lang_String_c().equals(string)) continue;
                list.set(i2, bnk2);
                return true;
            }
        }
        return false;
    }
}

