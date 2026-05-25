/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class bov
extends bob
implements Serializable {
    protected LinkedHashSet<bnz> a;

    @Override
    public Collection<bnz> a(bhm<?> bhm2, bmn bmn2, bfw bfw2) {
        Object object;
        Object object2;
        Object object3;
        bfn bfn2 = bhm2.bfn_a();
        AnnotatedElement annotatedElement = bfw2 == null ? bmn2.java_lang_reflect_AnnotatedElement_a() : bfw2.a();
        HashMap<bnz, bnz> hashMap = new HashMap<bnz, bnz>();
        if (this.a != null) {
            object3 = this.a.iterator();
            while (object3.hasNext()) {
                object2 = (bnz)object3.next();
                if (!((Class)annotatedElement).isAssignableFrom(((bnz)object2).a())) continue;
                object = bmi.bmh_a(bhm2, ((bnz)object2).a());
                this.a((bmh)object, (bnz)object2, bhm2, bfn2, hashMap);
            }
        }
        if (bmn2 != null && (object3 = bfn2.java_lang_Object_a((bmg)bmn2)) != null) {
            object2 = object3.iterator();
            while (object2.hasNext()) {
                object = (bnz)object2.next();
                bmh bmh2 = bmi.bmh_a(bhm2, ((bnz)object).a());
                this.a(bmh2, (bnz)object, bhm2, bfn2, hashMap);
            }
        }
        object3 = new bnz((Class<?>)annotatedElement, null);
        object2 = bmi.bmh_a(bhm2, annotatedElement);
        this.a((bmh)object2, (bnz)object3, bhm2, bfn2, hashMap);
        return new ArrayList<bnz>(hashMap.values());
    }

    @Override
    public Collection<bnz> a(bhm<?> bhm2, bmh bmh2) {
        Object object;
        bfn bfn2 = bhm2.bfn_a();
        HashMap<bnz, bnz> hashMap = new HashMap<bnz, bnz>();
        if (this.a != null) {
            object = bmh2.java_lang_reflect_AnnotatedElement_a();
            for (bnz bnz2 : this.a) {
                if (!((Class)object).isAssignableFrom(bnz2.a())) continue;
                bmh bmh3 = bmi.bmh_a(bhm2, bnz2.a());
                this.a(bmh3, bnz2, bhm2, bfn2, hashMap);
            }
        }
        object = new bnz((Class<?>)bmh2.java_lang_reflect_AnnotatedElement_a(), null);
        this.a(bmh2, (bnz)object, bhm2, bfn2, hashMap);
        return new ArrayList<bnz>(hashMap.values());
    }

    @Override
    public Collection<bnz> b(bhm<?> bhm2, bmn bmn2, bfw bfw2) {
        Object object;
        Iterator iterator;
        bfn bfn2 = bhm2.bfn_a();
        Object t2 = bfw2.a();
        HashSet hashSet = new HashSet();
        LinkedHashMap<String, bnz> linkedHashMap = new LinkedHashMap<String, bnz>();
        bnz bnz2 = new bnz((Class<?>)t2, null);
        bmh bmh2 = bmi.bmh_a(bhm2, t2);
        this.a(bmh2, bnz2, bhm2, hashSet, linkedHashMap);
        if (bmn2 != null && (iterator = bfn2.java_lang_Object_a((bmg)bmn2)) != null) {
            Iterator object2 = iterator.iterator();
            while (object2.hasNext()) {
                object = (bnz)object2.next();
                bmh2 = bmi.bmh_a(bhm2, ((bnz)object).a());
                this.a(bmh2, (bnz)object, bhm2, hashSet, linkedHashMap);
            }
        }
        if (this.a != null) {
            for (bnz bnz3 : this.a) {
                if (!((Class)t2).isAssignableFrom(bnz3.a())) continue;
                object = bmi.bmh_a(bhm2, bnz3.a());
                this.a((bmh)object, bnz3, bhm2, hashSet, linkedHashMap);
            }
        }
        return this.a((Class<?>)t2, hashSet, (Map<String, bnz>)linkedHashMap);
    }

    @Override
    public Collection<bnz> b(bhm<?> bhm2, bmh bmh2) {
        AnnotatedElement annotatedElement = bmh2.java_lang_reflect_AnnotatedElement_a();
        HashSet hashSet = new HashSet();
        LinkedHashMap<String, bnz> linkedHashMap = new LinkedHashMap<String, bnz>();
        bnz bnz2 = new bnz((Class<?>)annotatedElement, null);
        this.a(bmh2, bnz2, bhm2, hashSet, linkedHashMap);
        if (this.a != null) {
            for (bnz bnz3 : this.a) {
                if (!((Class)annotatedElement).isAssignableFrom(bnz3.a())) continue;
                bmh bmh3 = bmi.bmh_a(bhm2, bnz3.a());
                this.a(bmh3, bnz3, bhm2, hashSet, linkedHashMap);
            }
        }
        return this.a((Class<?>)annotatedElement, hashSet, (Map<String, bnz>)linkedHashMap);
    }

    protected void a(bmh bmh2, bnz bnz2, bhm<?> bhm2, bfn bfn2, HashMap<bnz, bnz> hashMap) {
        Object object;
        if (!bnz2.boolean_a() && (object = bfn2.java_lang_Object_a(bmh2)) != null) {
            bnz2 = new bnz(bnz2.a(), (String)object);
        }
        if (hashMap.containsKey(object = new bnz(bnz2.a()))) {
            bnz bnz3;
            if (bnz2.boolean_a() && !(bnz3 = hashMap.get(object)).boolean_a()) {
                hashMap.put((bnz)object, bnz2);
            }
            return;
        }
        hashMap.put((bnz)object, bnz2);
        Object object2 = bfn2.java_lang_Object_a((bmg)bmh2);
        if (object2 != null && !object2.isEmpty()) {
            Iterator iterator = object2.iterator();
            while (iterator.hasNext()) {
                bnz bnz4 = (bnz)iterator.next();
                bmh bmh3 = bmi.bmh_a(bhm2, bnz4.a());
                this.a(bmh3, bnz4, bhm2, bfn2, hashMap);
            }
        }
    }

    protected void a(bmh bmh2, bnz bnz2, bhm<?> bhm2, Set<Class<?>> set, Map<String, bnz> map) {
        Object object;
        bfn bfn2 = bhm2.bfn_a();
        if (!bnz2.boolean_a() && (object = bfn2.java_lang_Object_a(bmh2)) != null) {
            bnz2 = new bnz(bnz2.a(), (String)object);
        }
        if (bnz2.boolean_a()) {
            map.put(bnz2.java_lang_String_a(), bnz2);
        }
        if (set.add(bnz2.a()) && (object = bfn2.java_lang_Object_a((bmg)bmh2)) != null && !object.isEmpty()) {
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                bnz bnz3 = (bnz)iterator.next();
                bmh bmh3 = bmi.bmh_a(bhm2, bnz3.a());
                this.a(bmh3, bnz3, bhm2, set, map);
            }
        }
    }

    protected Collection<bnz> a(Class<?> clazz, Set<Class<?>> set, Map<String, bnz> map) {
        ArrayList<bnz> arrayList = new ArrayList<bnz>(map.values());
        for (bnz serializable : map.values()) {
            set.remove(serializable.a());
        }
        for (Class clazz2 : set) {
            if (clazz2 == clazz && Modifier.isAbstract(clazz2.getModifiers())) continue;
            arrayList.add(new bnz(clazz2));
        }
        return arrayList;
    }
}

