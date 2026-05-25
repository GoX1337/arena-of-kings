/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class bup {
    public static boolean a(Object object, Collection<String> collection, Collection<String> collection2) {
        if (collection == null && collection2 == null) {
            return false;
        }
        if (collection2 == null) {
            return collection.contains(object);
        }
        if (collection == null) {
            return !collection2.contains(object);
        }
        return !collection2.contains(object) || collection.contains(object);
    }

    public static a a(Set<String> set, Set<String> set2) {
        if (set2 == null && (set == null || set.isEmpty())) {
            return null;
        }
        return a.a(set, set2);
    }

    public static Set<String> a(Set<String> set, Set<String> set2) {
        if (set == null) {
            return set2;
        }
        if (set2 == null) {
            return set;
        }
        HashSet<String> hashSet = new HashSet<String>();
        for (String string : set2) {
            if (!set.contains(string)) continue;
            hashSet.add(string);
        }
        return hashSet;
    }

    public static final class a
    implements Serializable {
        private final Set<String> a;
        private final Set<String> b;

        private a(Set<String> set, Set<String> set2) {
            if (set == null) {
                set = Collections.emptySet();
            }
            this.a = set;
            this.b = set2;
        }

        public static a a(Set<String> set, Set<String> set2) {
            return new a(set, set2);
        }

        public boolean a(Object object) {
            return this.b != null && !this.b.contains(object) || this.a.contains(object);
        }
    }
}

