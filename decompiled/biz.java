/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class biz {
    private final bfw var_bfw_a;
    private final b[] var_biz$b_arr_a;
    private final Map<String, Object> cfr_renamed_25;
    private final String[] var_java_lang_String_arr_a;
    private final bve[] var_bve_arr_a;

    protected biz(bfw bfw2, b[] bArray, Map<String, Object> map, String[] stringArray, bve[] bveArray) {
        this.var_bfw_a = bfw2;
        this.var_biz$b_arr_a = bArray;
        this.var_bfw_a = map;
        this.var_java_lang_String_arr_a = stringArray;
        this.var_bve_arr_a = bveArray;
    }

    protected biz(biz biz2) {
        this.var_bfw_a = biz2.var_bfw_a;
        this.var_biz$b_arr_a = biz2.var_biz$b_arr_a;
        this.var_bfw_a = biz2.var_bfw_a;
        int n2 = this.var_biz$b_arr_a.length;
        this.var_java_lang_String_arr_a = new String[n2];
        this.var_bve_arr_a = new bve[n2];
    }

    public static a a(bfw bfw2) {
        return new a(bfw2);
    }

    public biz a() {
        return new biz(this);
    }

    public boolean a(bdc bdc2, bfs bfs2, String string, Object object) {
        Object v2 = this.var_bfw_a.get(string);
        if (v2 == null) {
            return false;
        }
        String string2 = bdc2.java_lang_String_e();
        if (v2 instanceof List) {
            boolean bl2 = false;
            for (Integer n2 : (List)v2) {
                if (!this.a(bdc2, bfs2, string, object, string2, n2)) continue;
                bl2 = true;
            }
            return bl2;
        }
        return this.a(bdc2, bfs2, string, object, string2, (Integer)v2);
    }

    private final boolean a(bdc bdc2, bfs bfs2, String string, Object object, String string2, int n2) {
        boolean bl2;
        b b2 = this.var_biz$b_arr_a[n2];
        if (!b2.a(string)) {
            return false;
        }
        boolean bl3 = bl2 = object != null && this.var_bve_arr_a[n2] != null;
        if (bl2) {
            this.a(bdc2, bfs2, object, n2, string2);
            this.var_bve_arr_a[n2] = null;
        } else {
            this.var_java_lang_String_arr_a[n2] = string2;
        }
        return true;
    }

    public boolean b(bdc bdc2, bfs bfs2, String string, Object object) {
        Object object2;
        boolean bl2;
        Object v2 = this.var_bfw_a.get(string);
        if (v2 == null) {
            return false;
        }
        if (v2 instanceof List) {
            Iterator iterator = ((List)v2).iterator();
            Integer n2 = (Integer)iterator.next();
            b b2 = this.var_biz$b_arr_a[n2];
            if (b2.a(string)) {
                String string2 = bdc2.java_lang_String_e();
                bdc2.bdc_a();
                this.var_java_lang_String_arr_a[n2.intValue()] = string2;
                while (iterator.hasNext()) {
                    this.var_java_lang_String_arr_a[((Integer)iterator.next()).intValue()] = string2;
                }
            } else {
                bve bve2 = new bve(bdc2, bfs2);
                bve2.b(bdc2);
                this.var_bve_arr_a[n2.intValue()] = bve2;
                while (iterator.hasNext()) {
                    this.var_bve_arr_a[((Integer)iterator.next()).intValue()] = bve2;
                }
            }
            return true;
        }
        int n3 = (Integer)v2;
        b b3 = this.var_biz$b_arr_a[n3];
        if (b3.a(string)) {
            this.var_java_lang_String_arr_a[n3] = bdc2.java_lang_String_f();
            bdc2.bdc_a();
            bl2 = object != null && this.var_bve_arr_a[n3] != null;
        } else {
            object2 = new bve(bdc2, bfs2);
            ((bve)object2).b(bdc2);
            this.var_bve_arr_a[n3] = object2;
            boolean bl3 = bl2 = object != null && this.var_java_lang_String_arr_a[n3] != null;
        }
        if (bl2) {
            object2 = this.var_java_lang_String_arr_a[n3];
            this.var_java_lang_String_arr_a[n3] = null;
            this.a(bdc2, bfs2, object, n3, (String)object2);
            this.var_bve_arr_a[n3] = null;
        }
        return true;
    }

    public Object a(bdc bdc2, bfs bfs2, Object object) {
        int n2 = this.var_biz$b_arr_a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2;
            String string = this.var_java_lang_String_arr_a[i2];
            b b2 = this.var_biz$b_arr_a[i2];
            if (string == null) {
                object2 = this.var_bve_arr_a[i2];
                if (object2 == null) continue;
                bdf bdf2 = ((bve)object2).bdf_a();
                if (bdf2.d()) {
                    bdc bdc3 = ((bve)object2).bdc_a(bdc2);
                    bdc3.bdf_a();
                    bio bio2 = b2.bio_a();
                    Object object3 = boc.a(bdc3, bfs2, bio2.bfw_a());
                    if (object3 != null) {
                        bio2.void_a(object, object3);
                        continue;
                    }
                }
                if (!b2.boolean_a()) {
                    bfs2.a(this.var_bfw_a, b2.bio_a().java_lang_String_a(), "Missing external type id property '%s' (and no 'defaultImpl' specified)", b2.java_lang_String_b());
                } else {
                    string = b2.java_lang_String_a();
                    if (string == null) {
                        bfs2.a(this.var_bfw_a, b2.bio_a().java_lang_String_a(), "Invalid default type id for property '%s': `null` returned by TypeIdResolver", b2.java_lang_String_b());
                    }
                }
            } else if (this.var_bve_arr_a[i2] == null) {
                object2 = b2.bio_a();
                if (((bna)object2).f() || bfs2.a(bfu.n)) {
                    bfs2.c(object.getClass(), ((bio)object2).java_lang_String_a(), "Missing property '%s' for external type id '%s'", ((bio)object2).java_lang_String_a(), b2.java_lang_String_b());
                }
                return object;
            }
            this.a(bdc2, bfs2, object, i2, string);
        }
        return object;
    }

    public Object a(bdc bdc2, bfs bfs2, bjr bjr2, bjo bjo2) {
        Object object;
        int n2 = this.var_biz$b_arr_a.length;
        Object[] objectArray = new Object[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            String string;
            Object object2;
            String string2 = this.var_java_lang_String_arr_a[i2];
            object = this.var_biz$b_arr_a[i2];
            if (string2 == null) {
                object2 = this.var_bve_arr_a[i2];
                if (object2 == null || ((bve)object2).bdf_a() == bdf.m) continue;
                if (!((b)object).boolean_a()) {
                    bfs2.a(this.var_bfw_a, ((b)object).bio_a().java_lang_String_a(), "Missing external type id property '%s'", ((b)object).java_lang_String_b());
                } else {
                    string2 = ((b)object).java_lang_String_a();
                }
            } else if (this.var_bve_arr_a[i2] == null && (((bna)(object2 = ((b)object).bio_a())).f() || bfs2.a(bfu.n))) {
                bfs2.a(this.var_bfw_a, ((bio)object2).java_lang_String_a(), "Missing property '%s' for external type id '%s'", ((bio)object2).java_lang_String_a(), this.var_biz$b_arr_a[i2].java_lang_String_b());
            }
            if (this.var_bve_arr_a[i2] != null) {
                objectArray[i2] = this.a(bdc2, bfs2, i2, string2);
            }
            if (((bio)(object2 = ((b)object).bio_a())).int_a() < 0) continue;
            bjr2.boolean_a((bio)object2, objectArray[i2]);
            bio bio2 = ((b)object).bio_b();
            if (bio2 == null || bio2.int_a() < 0) continue;
            if (bio2.bfw_a().boolean_a(String.class)) {
                string = string2;
            } else {
                bve bve2 = new bve(bdc2, bfs2);
                bve2.b(string2);
                string = ((bfx)bio2.bil_a()).a(bve2.bdc_b(), bfs2);
                bve2.close();
            }
            bjr2.boolean_a(bio2, (Object)string);
        }
        Object object3 = bjo2.a(bfs2, bjr2);
        for (int i3 = 0; i3 < n2; ++i3) {
            object = this.var_biz$b_arr_a[i3].bio_a();
            if (((bio)object).int_a() >= 0) continue;
            ((bio)object).void_a(object3, objectArray[i3]);
        }
        return object3;
    }

    protected final Object a(bdc bdc2, bfs bfs2, int n2, String string) {
        bdc bdc3 = this.var_bve_arr_a[n2].bdc_a(bdc2);
        bdf bdf2 = bdc3.bdf_a();
        if (bdf2 == bdf.m) {
            return null;
        }
        bve bve2 = new bve(bdc2, bfs2);
        bve2.void_a();
        bve2.b(string);
        bve2.b(bdc3);
        bve2.void_b();
        bdc bdc4 = bve2.bdc_a(bdc2);
        bdc4.bdf_a();
        return this.var_biz$b_arr_a[n2].bio_a().java_lang_Object_a(bdc4, bfs2);
    }

    protected final void a(bdc bdc2, bfs bfs2, Object object, int n2, String string) {
        bdc bdc3;
        bdf bdf2;
        if (string == null) {
            bfs2.a(this.var_bfw_a, "Internal error in external Type Id handling: `null` type id passed", new Object[0]);
        }
        if ((bdf2 = (bdc3 = this.var_bve_arr_a[n2].bdc_a(bdc2)).bdf_a()) == bdf.m) {
            this.var_biz$b_arr_a[n2].bio_a().void_a(object, null);
            return;
        }
        bve bve2 = new bve(bdc2, bfs2);
        bve2.void_a();
        bve2.b(string);
        bve2.b(bdc3);
        bve2.void_b();
        bdc bdc4 = bve2.bdc_a(bdc2);
        bdc4.bdf_a();
        this.var_biz$b_arr_a[n2].bio_a().void_a(bdc4, bfs2, object);
    }

    static final class b {
        private final bio var_bio_a;
        private final boc var_boc_a;
        private final String var_java_lang_String_a;
        private bio b;

        public b(bio bio2, boc boc2) {
            this.var_bio_a = bio2;
            this.var_boc_a = boc2;
            this.var_java_lang_String_a = boc2.java_lang_String_a();
        }

        public void a(bio bio2) {
            this.b = bio2;
        }

        public boolean a(String string) {
            return string.equals(this.var_java_lang_String_a);
        }

        public boolean boolean_a() {
            return this.var_boc_a.boolean_a();
        }

        public String java_lang_String_a() {
            Class<?> clazz = this.var_boc_a.a();
            if (clazz == null) {
                return null;
            }
            return this.var_boc_a.boe_a().a(null, clazz);
        }

        public String java_lang_String_b() {
            return this.var_java_lang_String_a;
        }

        public bio bio_a() {
            return this.var_bio_a;
        }

        public bio bio_b() {
            return this.b;
        }
    }

    public static class a {
        private final bfw var_bfw_a = new HashMap();
        private final List<b> var_java_util_List_biz$b__a;
        private final Map<String, Object> cfr_renamed_25;

        protected a(bfw bfw2) {
            this.var_bfw_a = bfw2;
        }

        public void a(bio bio2, boc boc2) {
            Integer n2 = this.var_bfw_a.size();
            this.var_bfw_a.add(new b(bio2, boc2));
            this.a(bio2.java_lang_String_a(), n2);
            this.a(boc2.java_lang_String_a(), n2);
        }

        private void a(String string, Integer n2) {
            Object v2 = this.var_bfw_a.get(string);
            if (v2 == null) {
                this.var_bfw_a.put(string, n2);
            } else if (v2 instanceof List) {
                List list = (List)v2;
                list.add(n2);
            } else {
                LinkedList<Object> linkedList = new LinkedList<Object>();
                linkedList.add(v2);
                linkedList.add(n2);
                this.var_bfw_a.put(string, linkedList);
            }
        }

        public biz a(biv biv2) {
            int n2 = this.var_bfw_a.size();
            b[] bArray = new b[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                b b2 = (b)this.var_bfw_a.get(i2);
                String string = b2.java_lang_String_b();
                bio bio2 = biv2.bio_a(string);
                if (bio2 != null) {
                    b2.a(bio2);
                }
                bArray[i2] = b2;
            }
            return new biz(this.var_bfw_a, bArray, (Map<String, Object>)((Object)this.var_bfw_a), null, null);
        }
    }
}

