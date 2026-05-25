/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bbp {
    public String[] java_lang_String_arr_a() default {};

    public boolean boolean_a() default false;

    public boolean b() default false;

    public boolean c() default false;

    public static class a
    implements Serializable {
        protected static final a var_bbp$a_a;
        protected final Set<String> var_java_util_Set_java_lang_String__a;
        protected final boolean var_boolean_a;
        protected final boolean b;
        protected final boolean c;
        protected final boolean d;

        protected a(Set<String> set, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
            this.var_bbp$a_a = set == null ? Collections.emptySet() : set;
            this.var_boolean_a = bl2;
            this.b = bl3;
            this.c = bl4;
            this.d = bl5;
        }

        public static a a(bbp bbp2) {
            if (bbp2 == null) {
                return var_bbp$a_a;
            }
            return bbp$a.bbp$a_a(bbp$a.a(bbp2.java_lang_String_arr_a()), bbp2.boolean_a(), bbp2.b(), bbp2.c(), false);
        }

        public static a bbp$a_a(Set<String> set, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
            if (bbp$a.boolean_a(set, bl2, bl3, bl4, bl5)) {
                return var_bbp$a_a;
            }
            return new a(set, bl2, bl3, bl4, bl5);
        }

        public static a bbp$a_a() {
            return var_bbp$a_a;
        }

        public static a bbp$a_a(a a2, a a3) {
            return a2 == null ? a3 : a2.a(a3);
        }

        public a a(a a2) {
            if (a2 == null || a2 == var_bbp$a_a) {
                return this;
            }
            if (!a2.d) {
                return a2;
            }
            if (bbp$a.boolean_a(this, a2)) {
                return this;
            }
            Set<String> set = bbp$a.a((Set<String>)((Object)this.var_bbp$a_a), (Set<String>)((Object)a2.var_bbp$a_a));
            boolean bl2 = this.var_boolean_a || a2.var_boolean_a;
            boolean bl3 = this.b || a2.b;
            boolean bl4 = this.c || a2.c;
            return bbp$a.bbp$a_a(set, bl2, bl3, bl4, true);
        }

        public Set<String> a() {
            if (this.b) {
                return Collections.emptySet();
            }
            return this.var_bbp$a_a;
        }

        public Set<String> b() {
            if (this.c) {
                return Collections.emptySet();
            }
            return this.var_bbp$a_a;
        }

        public boolean boolean_a() {
            return this.var_boolean_a;
        }

        public String toString() {
            return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", this.var_bbp$a_a, this.var_boolean_a, this.b, this.c, this.d);
        }

        public int hashCode() {
            return this.var_bbp$a_a.size() + (this.var_boolean_a ? 1 : -3) + (this.b ? 3 : -7) + (this.c ? 7 : -11) + (this.d ? 11 : -13);
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object == null) {
                return false;
            }
            return object.getClass() == this.getClass() && bbp$a.boolean_a(this, (a)object);
        }

        private static boolean boolean_a(a a2, a a3) {
            return a2.var_boolean_a == a3.var_boolean_a && a2.d == a3.d && a2.b == a3.b && a2.c == a3.c && a2.var_bbp$a_a.equals(a3.var_bbp$a_a);
        }

        private static Set<String> a(String[] stringArray) {
            if (stringArray == null || stringArray.length == 0) {
                return Collections.emptySet();
            }
            HashSet<String> hashSet = new HashSet<String>(stringArray.length);
            for (String string : stringArray) {
                hashSet.add(string);
            }
            return hashSet;
        }

        private static Set<String> a(Set<String> set, Set<String> set2) {
            if (set.isEmpty()) {
                return set2;
            }
            if (set2.isEmpty()) {
                return set;
            }
            HashSet<String> hashSet = new HashSet<String>(set.size() + set2.size());
            hashSet.addAll(set);
            hashSet.addAll(set2);
            return hashSet;
        }

        private static boolean boolean_a(Set<String> set, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
            if (bl2 == bbp$a.var_bbp$a_a.var_boolean_a && bl3 == bbp$a.var_bbp$a_a.b && bl4 == bbp$a.var_bbp$a_a.c && bl5 == bbp$a.var_bbp$a_a.d) {
                return set == null || set.size() == 0;
            }
            return false;
        }

        static {
            var_bbp$a_a = new a(Collections.<String>emptySet(), false, false, false, true);
        }
    }
}

