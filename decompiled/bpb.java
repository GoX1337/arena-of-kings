/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class bpb
extends bpa {
    protected final bhm<?> var_bhm____a;
    protected final ConcurrentHashMap<String, String> cfr_renamed_36;
    protected final Map<String, bfw> cfr_renamed_37;
    protected final boolean var_boolean_a;

    protected bpb(bhm<?> bhm2, bfw bfw2, ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, bfw> hashMap) {
        super(bfw2, bhm2.btz_a());
        this.var_bhm____a = bhm2;
        this.var_bhm____a = concurrentHashMap;
        this.var_bhm____a = hashMap;
        this.var_boolean_a = bhm2.a(bgd.x);
    }

    public static bpb a(bhm<?> bhm2, bfw bfw2, Collection<bnz> collection, boolean bl2, boolean bl3) {
        HashMap<String, bfw> hashMap;
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (bl2 == bl3) {
            throw new IllegalArgumentException();
        }
        if (bl2) {
            concurrentHashMap = new ConcurrentHashMap<String, String>();
            hashMap = null;
        } else {
            hashMap = new HashMap<String, bfw>();
            concurrentHashMap = new ConcurrentHashMap(4);
        }
        boolean bl4 = bhm2.a(bgd.x);
        if (collection != null) {
            for (bnz bnz2 : collection) {
                bfw bfw3;
                String string;
                Class<?> clazz = bnz2.a();
                String string2 = string = bnz2.boolean_a() ? bnz2.java_lang_String_a() : bpb.b(clazz);
                if (bl2) {
                    concurrentHashMap.put(clazz.getName(), string);
                }
                if (!bl3) continue;
                if (bl4) {
                    string = string.toLowerCase();
                }
                if ((bfw3 = hashMap.get(string)) != null && clazz.isAssignableFrom((Class<?>)bfw3.a())) continue;
                hashMap.put(string, bhm2.bfw_a(clazz));
            }
        }
        return new bpb(bhm2, bfw2, concurrentHashMap, hashMap);
    }

    @Override
    public String a(Object object) {
        return this.a(object.getClass());
    }

    protected String a(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        String string = clazz.getName();
        Object object = (String)((ConcurrentHashMap)((Object)this.var_bhm____a)).get(string);
        if (object == null) {
            Object t2 = ((btz)((Object)this.var_bhm____a)).a((Type)clazz).a();
            if (this.var_bhm____a.b()) {
                bfo bfo2 = this.var_bhm____a.bfo_a((Class<?>)t2);
                object = this.var_bhm____a.bfn_a().java_lang_Object_a(bfo2.bmh_a());
            }
            if (object == null) {
                object = bpb.b(t2);
            }
            ((ConcurrentHashMap)((Object)this.var_bhm____a)).put(string, object);
        }
        return object;
    }

    @Override
    public String a(Object object, Class<?> clazz) {
        if (object == null) {
            return this.a(clazz);
        }
        return this.a(object);
    }

    @Override
    public bfw a(bfq bfq2, String string) {
        return this.a(string);
    }

    protected bfw a(String string) {
        if (this.var_boolean_a) {
            string = string.toLowerCase();
        }
        return (bfw)this.var_bhm____a.get(string);
    }

    @Override
    public String b() {
        TreeSet treeSet = new TreeSet();
        for (Map.Entry entry : this.var_bhm____a.entrySet()) {
            if (!((bfw)entry.getValue()).boolean_d()) continue;
            treeSet.add(entry.getKey());
        }
        return treeSet.toString();
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", this.getClass().getName(), this.var_bhm____a);
    }

    protected static String b(Class<?> clazz) {
        String string = clazz.getName();
        int n2 = string.lastIndexOf(46);
        return n2 < 0 ? string : string.substring(n2 + 1);
    }
}

