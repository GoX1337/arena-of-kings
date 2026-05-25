/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public final class brf {
    private final a[] var_brf$a_arr_a;
    private final int var_int_a;
    private final int b;

    public brf(Map<bvh, bgb<Object>> map) {
        int n2;
        this.var_int_a = n2 = brf.a(map.size());
        this.b = n2 - 1;
        a[] aArray = new a[n2];
        for (Map.Entry<bvh, bgb<Object>> entry : map.entrySet()) {
            bvh bvh2 = entry.getKey();
            int n3 = bvh2.hashCode() & this.b;
            aArray[n3] = new a(aArray[n3], bvh2, entry.getValue());
        }
        this.var_brf$a_arr_a = aArray;
    }

    private static final int a(int n2) {
        int n3;
        int n4 = n2 <= 64 ? n2 + n2 : n2 + (n2 >> 2);
        for (n3 = 8; n3 < n4; n3 += n3) {
        }
        return n3;
    }

    public static brf a(HashMap<bvh, bgb<Object>> hashMap) {
        return new brf(hashMap);
    }

    public bgb<Object> a(bfw bfw2) {
        a a2 = this.var_brf$a_arr_a[bvh.b(bfw2) & this.b];
        if (a2 == null) {
            return null;
        }
        if (a2.a(bfw2)) {
            return a2.var_bgb_java_lang_Object__a;
        }
        while ((a2 = a2.var_brf$a_a) != null) {
            if (!a2.a(bfw2)) continue;
            return a2.var_bgb_java_lang_Object__a;
        }
        return null;
    }

    public bgb<Object> a(Class<?> clazz) {
        a a2 = this.var_brf$a_arr_a[bvh.b(clazz) & this.b];
        if (a2 == null) {
            return null;
        }
        if (a2.a(clazz)) {
            return a2.var_bgb_java_lang_Object__a;
        }
        while ((a2 = a2.var_brf$a_a) != null) {
            if (!a2.a(clazz)) continue;
            return a2.var_bgb_java_lang_Object__a;
        }
        return null;
    }

    public bgb<Object> b(bfw bfw2) {
        a a2 = this.var_brf$a_arr_a[bvh.a(bfw2) & this.b];
        if (a2 == null) {
            return null;
        }
        if (a2.b(bfw2)) {
            return a2.var_bgb_java_lang_Object__a;
        }
        while ((a2 = a2.var_brf$a_a) != null) {
            if (!a2.b(bfw2)) continue;
            return a2.var_bgb_java_lang_Object__a;
        }
        return null;
    }

    public bgb<Object> b(Class<?> clazz) {
        a a2 = this.var_brf$a_arr_a[bvh.a(clazz) & this.b];
        if (a2 == null) {
            return null;
        }
        if (a2.b(clazz)) {
            return a2.var_bgb_java_lang_Object__a;
        }
        while ((a2 = a2.var_brf$a_a) != null) {
            if (!a2.b(clazz)) continue;
            return a2.var_bgb_java_lang_Object__a;
        }
        return null;
    }

    static final class a {
        public final bgb<Object> var_bgb_java_lang_Object__a;
        public final a var_brf$a_a;
        protected final Class<?> var_java_lang_Class____a;
        protected final bfw var_bfw_a;
        protected final boolean var_boolean_a;

        public a(a a2, bvh bvh2, bgb<Object> bgb2) {
            this.var_brf$a_a = a2;
            this.var_bgb_java_lang_Object__a = bgb2;
            this.var_boolean_a = bvh2.boolean_a();
            this.var_bgb_java_lang_Object__a = bvh2.a();
            this.var_bfw_a = bvh2.bfw_a();
        }

        public boolean a(Class<?> clazz) {
            return this.var_bgb_java_lang_Object__a == clazz && this.var_boolean_a;
        }

        public boolean b(Class<?> clazz) {
            return this.var_bgb_java_lang_Object__a == clazz && !this.var_boolean_a;
        }

        public boolean a(bfw bfw2) {
            return this.var_boolean_a && bfw2.equals(this.var_bfw_a);
        }

        public boolean b(bfw bfw2) {
            return !this.var_boolean_a && bfw2.equals(this.var_bfw_a);
        }
    }
}

