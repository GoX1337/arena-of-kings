/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

public class biv
implements Serializable,
Iterable<bio> {
    protected final boolean var_boolean_a;
    private int var_int_a;
    private int var_int_b;
    private int c;
    private Object[] var_java_lang_Object_arr_a;
    private final bio[] var_bio_arr_a;
    private final Map<String, List<bgj>> cfr_renamed_23;
    private final Map<String, String> cfr_renamed_24;
    private final Locale var_java_util_Locale_a;

    public biv(boolean bl2, Collection<bio> collection, Map<String, List<bgj>> map, Locale locale) {
        this.var_boolean_a = bl2;
        this.var_bio_arr_a = collection.toArray(new bio[collection.size()]);
        this.var_boolean_a = map;
        this.var_java_util_Locale_a = locale;
        this.var_int_b = (int)this.a(map, bl2, locale);
        this.a(collection);
    }

    private biv(biv biv2, bio bio2, int n2, int n3) {
        this.var_boolean_a = biv2.var_boolean_a;
        this.var_java_util_Locale_a = biv2.var_java_util_Locale_a;
        this.var_int_a = biv2.var_int_a;
        this.var_int_b = biv2.var_int_b;
        this.c = biv2.c;
        this.var_boolean_a = biv2.var_boolean_a;
        this.var_int_b = biv2.var_int_b;
        this.var_java_lang_Object_arr_a = Arrays.copyOf(biv2.var_java_lang_Object_arr_a, biv2.var_java_lang_Object_arr_a.length);
        this.var_bio_arr_a = Arrays.copyOf(biv2.var_bio_arr_a, biv2.var_bio_arr_a.length);
        this.var_java_lang_Object_arr_a[n2] = bio2;
        this.var_bio_arr_a[n3] = bio2;
    }

    private biv(biv biv2, bio bio2, String string, int n2) {
        this.var_boolean_a = biv2.var_boolean_a;
        this.var_java_util_Locale_a = biv2.var_java_util_Locale_a;
        this.var_int_a = biv2.var_int_a;
        this.var_int_b = biv2.var_int_b;
        this.c = biv2.c;
        this.var_boolean_a = biv2.var_boolean_a;
        this.var_int_b = biv2.var_int_b;
        this.var_java_lang_Object_arr_a = Arrays.copyOf(biv2.var_java_lang_Object_arr_a, biv2.var_java_lang_Object_arr_a.length);
        int n3 = biv2.var_bio_arr_a.length;
        this.var_bio_arr_a = Arrays.copyOf(biv2.var_bio_arr_a, n3 + 1);
        this.var_bio_arr_a[n3] = bio2;
        int n4 = this.var_int_a + 1;
        int n5 = n2 << 1;
        if (this.var_java_lang_Object_arr_a[n5] != null && this.var_java_lang_Object_arr_a[n5 = n4 + (n2 >> 1) << 1] != null) {
            n5 = (n4 + (n4 >> 1) << 1) + this.c;
            this.c += 2;
            if (n5 >= this.var_java_lang_Object_arr_a.length) {
                this.var_java_lang_Object_arr_a = Arrays.copyOf(this.var_java_lang_Object_arr_a, this.var_java_lang_Object_arr_a.length + 4);
            }
        }
        this.var_java_lang_Object_arr_a[n5] = string;
        this.var_java_lang_Object_arr_a[n5 + 1] = bio2;
    }

    protected biv(biv biv2, boolean bl2) {
        this.var_boolean_a = bl2;
        this.var_java_util_Locale_a = biv2.var_java_util_Locale_a;
        this.var_boolean_a = biv2.var_boolean_a;
        this.var_int_b = biv2.var_int_b;
        this.var_bio_arr_a = Arrays.copyOf(biv2.var_bio_arr_a, biv2.var_bio_arr_a.length);
        this.a(Arrays.asList(this.var_bio_arr_a));
    }

    public biv a(boolean bl2) {
        if (this.var_boolean_a == bl2) {
            return this;
        }
        return new biv(this, bl2);
    }

    protected void a(Collection<bio> collection) {
        this.var_int_b = collection.size();
        int n2 = biv.a(this.var_int_b);
        this.var_int_a = n2 - 1;
        int n3 = (n2 + (n2 >> 1)) * 2;
        Object[] objectArray = new Object[n3];
        int n4 = 0;
        for (bio bio2 : collection) {
            if (bio2 == null) continue;
            String string = this.java_lang_String_a(bio2);
            int n5 = this.int_a(string);
            int n6 = n5 << 1;
            if (objectArray[n6] != null && objectArray[n6 = n2 + (n5 >> 1) << 1] != null) {
                n6 = (n2 + (n2 >> 1) << 1) + n4;
                n4 += 2;
                if (n6 >= objectArray.length) {
                    objectArray = Arrays.copyOf(objectArray, objectArray.length + 4);
                }
            }
            objectArray[n6] = string;
            objectArray[n6 + 1] = bio2;
        }
        this.var_java_lang_Object_arr_a = objectArray;
        this.c = n4;
    }

    private static final int a(int n2) {
        int n3;
        if (n2 <= 5) {
            return 8;
        }
        if (n2 <= 12) {
            return 16;
        }
        int n4 = n2 + (n2 >> 2);
        for (n3 = 32; n3 < n4; n3 += n3) {
        }
        return n3;
    }

    public static biv a(bhm<?> bhm2, Collection<bio> collection, Map<String, List<bgj>> map, boolean bl2) {
        return new biv(bl2, collection, map, bhm2.java_util_Locale_a());
    }

    public biv biv_a(bio bio2) {
        int n2;
        String string = this.java_lang_String_a(bio2);
        int n3 = this.var_java_lang_Object_arr_a.length;
        for (n2 = 1; n2 < n3; n2 += 2) {
            bio bio3 = (bio)this.var_java_lang_Object_arr_a[n2];
            if (bio3 == null || !bio3.java_lang_String_a().equals(string)) continue;
            return new biv(this, bio2, n2, this.int_a(bio3));
        }
        n2 = this.int_a(string);
        return new biv(this, bio2, string, n2);
    }

    public biv biv_a() {
        int n2 = 0;
        int n3 = this.var_java_lang_Object_arr_a.length;
        for (int i2 = 1; i2 < n3; i2 += 2) {
            bio bio2 = (bio)this.var_java_lang_Object_arr_a[i2];
            if (bio2 == null) continue;
            bio2.a(n2++);
        }
        return this;
    }

    public biv a(but but2) {
        if (but2 == null || but2 == but.a) {
            return this;
        }
        int n2 = this.var_bio_arr_a.length;
        ArrayList<bio> arrayList = new ArrayList<bio>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            bio bio2 = this.var_bio_arr_a[i2];
            if (bio2 == null) {
                arrayList.add(bio2);
                continue;
            }
            arrayList.add(this.a(bio2, but2));
        }
        return new biv(this.var_boolean_a, arrayList, (Map<String, List<bgj>>)this.var_boolean_a, this.var_java_util_Locale_a);
    }

    public biv a(Collection<String> collection, Collection<String> collection2) {
        if ((collection == null || collection.isEmpty()) && collection2 == null) {
            return this;
        }
        int n2 = this.var_bio_arr_a.length;
        ArrayList<bio> arrayList = new ArrayList<bio>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            bio bio2 = this.var_bio_arr_a[i2];
            if (bio2 == null || bup.a(bio2.java_lang_String_a(), collection, collection2)) continue;
            arrayList.add(bio2);
        }
        return new biv(this.var_boolean_a, arrayList, (Map<String, List<bgj>>)this.var_boolean_a, this.var_java_util_Locale_a);
    }

    public void a(bio bio2, bio bio3) {
        int n2 = 1;
        int n3 = this.var_java_lang_Object_arr_a.length;
        while (true) {
            if (n2 > n3) {
                throw new NoSuchElementException("No entry '" + bio2.java_lang_String_a() + "' found, can't replace");
            }
            if (this.var_java_lang_Object_arr_a[n2] == bio2) break;
            n2 += 2;
        }
        this.var_java_lang_Object_arr_a[n2] = bio3;
        this.var_bio_arr_a[this.int_a((bio)bio2)] = bio3;
    }

    public void void_a(bio bio2) {
        ArrayList<bio> arrayList = new ArrayList<bio>(this.var_int_b);
        String string = this.java_lang_String_a(bio2);
        boolean bl2 = false;
        int n2 = this.var_java_lang_Object_arr_a.length;
        for (int i2 = 1; i2 < n2; i2 += 2) {
            bio bio3 = (bio)this.var_java_lang_Object_arr_a[i2];
            if (bio3 == null) continue;
            if (!bl2 && (bl2 = string.equals(this.var_java_lang_Object_arr_a[i2 - 1]))) {
                this.var_bio_arr_a[this.int_a((bio)bio3)] = null;
                continue;
            }
            arrayList.add(bio3);
        }
        if (!bl2) {
            throw new NoSuchElementException("No entry '" + bio2.java_lang_String_a() + "' found, can't remove");
        }
        this.a(arrayList);
    }

    public int int_a() {
        return this.var_int_b;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    @Override
    public Iterator<bio> iterator() {
        return this.a().iterator();
    }

    private List<bio> a() {
        ArrayList<bio> arrayList = new ArrayList<bio>(this.var_int_b);
        int n2 = this.var_java_lang_Object_arr_a.length;
        for (int i2 = 1; i2 < n2; i2 += 2) {
            bio bio2 = (bio)this.var_java_lang_Object_arr_a[i2];
            if (bio2 == null) continue;
            arrayList.add(bio2);
        }
        return arrayList;
    }

    public bio[] bio_arr_a() {
        return this.var_bio_arr_a;
    }

    protected final String java_lang_String_a(bio bio2) {
        return this.var_boolean_a ? bio2.java_lang_String_a().toLowerCase(this.var_java_util_Locale_a) : bio2.java_lang_String_a();
    }

    public bio bio_a(String string) {
        int n2;
        int n3;
        Object object;
        if (string == null) {
            throw new IllegalArgumentException("Cannot pass null property name");
        }
        if (this.var_boolean_a) {
            string = string.toLowerCase(this.var_java_util_Locale_a);
        }
        if ((object = this.var_java_lang_Object_arr_a[n3 = (n2 = string.hashCode() & this.var_int_a) << 1]) == string || string.equals(object)) {
            return (bio)this.var_java_lang_Object_arr_a[n3 + 1];
        }
        return this.a(string, n2, object);
    }

    private final bio a(String string, int n2, Object object) {
        if (object == null) {
            return this.b((String)this.var_int_b.get(string));
        }
        int n3 = this.var_int_a + 1;
        int n4 = n3 + (n2 >> 1) << 1;
        object = this.var_java_lang_Object_arr_a[n4];
        if (string.equals(object)) {
            return (bio)this.var_java_lang_Object_arr_a[n4 + 1];
        }
        if (object != null) {
            int n5;
            int n6 = n5 + this.c;
            for (n5 = n3 + (n3 >> 1) << 1; n5 < n6; n5 += 2) {
                object = this.var_java_lang_Object_arr_a[n5];
                if (object != string && !string.equals(object)) continue;
                return (bio)this.var_java_lang_Object_arr_a[n5 + 1];
            }
        }
        return this.b((String)this.var_int_b.get(string));
    }

    private bio b(String string) {
        if (string == null) {
            return null;
        }
        int n2 = this.int_a(string);
        int n3 = n2 << 1;
        Object object = this.var_java_lang_Object_arr_a[n3];
        if (string.equals(object)) {
            return (bio)this.var_java_lang_Object_arr_a[n3 + 1];
        }
        if (object == null) {
            return null;
        }
        return this.b(string, n2, object);
    }

    private bio b(String string, int n2, Object object) {
        int n3 = this.var_int_a + 1;
        int n4 = n3 + (n2 >> 1) << 1;
        object = this.var_java_lang_Object_arr_a[n4];
        if (string.equals(object)) {
            return (bio)this.var_java_lang_Object_arr_a[n4 + 1];
        }
        if (object != null) {
            int n5;
            int n6 = n5 + this.c;
            for (n5 = n3 + (n3 >> 1) << 1; n5 < n6; n5 += 2) {
                object = this.var_java_lang_Object_arr_a[n5];
                if (object != string && !string.equals(object)) continue;
                return (bio)this.var_java_lang_Object_arr_a[n5 + 1];
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Properties=[");
        int n2 = 0;
        for (bio bio2 : this) {
            if (n2++ > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(bio2.java_lang_String_a());
            stringBuilder.append('(');
            stringBuilder.append(bio2.bfw_a());
            stringBuilder.append(')');
        }
        stringBuilder.append(']');
        if (!this.var_boolean_a.isEmpty()) {
            stringBuilder.append("(aliases: ");
            stringBuilder.append((Object)this.var_boolean_a);
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }

    protected bio a(bio bio2, but but2) {
        bfx bfx2;
        if (bio2 == null) {
            return bio2;
        }
        String string = but2.a(bio2.java_lang_String_a());
        bil bil2 = (bio2 = bio2.bio_a(string)).bil_a();
        if (bil2 != null && (bfx2 = ((bfx)bil2).a(but2)) != bil2) {
            bio2 = bio2.a(bfx2);
        }
        return bio2;
    }

    private final int int_a(bio bio2) {
        int n2 = this.var_bio_arr_a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.var_bio_arr_a[i2] != bio2) continue;
            return i2;
        }
        throw new IllegalStateException("Illegal state: property '" + bio2.java_lang_String_a() + "' missing from _propsInOrder");
    }

    private final int int_a(String string) {
        return string.hashCode() & this.var_int_a;
    }

    private Map<String, String> a(Map<String, List<bgj>> map, boolean bl2, Locale locale) {
        if (map == null || map.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (Map.Entry<String, List<bgj>> entry : map.entrySet()) {
            String string = entry.getKey();
            if (bl2) {
                string = string.toLowerCase(locale);
            }
            for (bgj bgj2 : entry.getValue()) {
                String string2 = bgj2.java_lang_String_a();
                if (bl2) {
                    string2 = string2.toLowerCase(locale);
                }
                hashMap.put(string2, string);
            }
        }
        return hashMap;
    }
}

