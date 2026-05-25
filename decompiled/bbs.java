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
public @interface bbs {
    public String[] a() default {};

    public static class a
    implements Serializable {
        protected static final a var_bbs$a_a;
        protected final Set<String> var_java_util_Set_java_lang_String__a;

        protected a(Set<String> set) {
            this.var_bbs$a_a = set;
        }

        public static a a(bbs bbs2) {
            if (bbs2 == null) {
                return var_bbs$a_a;
            }
            return new a(bbs$a.a(bbs2.a()));
        }

        public static a a() {
            return var_bbs$a_a;
        }

        public Set<String> a() {
            return this.var_bbs$a_a;
        }

        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", this.var_bbs$a_a);
        }

        public int hashCode() {
            return this.var_bbs$a_a == null ? 0 : this.var_bbs$a_a.size();
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object == null) {
                return false;
            }
            return object.getClass() == this.getClass() && bbs$a.a((Set<String>)((Object)this.var_bbs$a_a), (Set<String>)((Object)((a)object).var_bbs$a_a));
        }

        private static boolean a(Set<String> set, Set<String> set2) {
            return set == null ? set2 == null : set.equals(set2);
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

        static {
            var_bbs$a_a = new a(null);
        }
    }
}

