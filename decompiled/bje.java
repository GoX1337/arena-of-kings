/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class bje {
    private static final Class<?> a = Arrays.asList(null, null).getClass();
    private static final Class<?> b;
    private static final Class<?> c;
    private static final Class<?> d;
    private static final Class<?> e;
    private static final Class<?> f;
    private static final Class<?> g;
    private static final Class<?> h;

    public static bfx<?> a(bfs bfs2, bfw bfw2) {
        a a2;
        if (bfw2.boolean_a(a)) {
            a2 = bje.a(11, bfw2, List.class);
        } else if (bfw2.boolean_a(c)) {
            a2 = bje.a(2, bfw2, List.class);
        } else if (bfw2.boolean_a(b)) {
            a2 = bje.a(1, bfw2, Set.class);
        } else if (bfw2.boolean_a(f) || bfw2.boolean_a(g)) {
            a2 = bje.a(5, bfw2, List.class);
        } else if (bfw2.boolean_a(e)) {
            a2 = bje.a(4, bfw2, Set.class);
        } else {
            String string = bje.a(bfw2.a());
            if (string.endsWith("Set")) {
                a2 = bje.a(7, bfw2, Set.class);
            } else if (string.endsWith("List")) {
                a2 = bje.a(9, bfw2, List.class);
            } else if (string.endsWith("Collection")) {
                a2 = bje.a(8, bfw2, Collection.class);
            } else {
                return null;
            }
        }
        return new blb<Object>(a2);
    }

    public static bfx<?> b(bfs bfs2, bfw bfw2) {
        a a2;
        if (bfw2.boolean_a(d)) {
            a2 = bje.a(3, bfw2, Map.class);
        } else if (bfw2.boolean_a(h)) {
            a2 = bje.a(6, bfw2, Map.class);
        } else {
            String string = bje.a(bfw2.a());
            if (string.endsWith("Map")) {
                a2 = bje.a(10, bfw2, Map.class);
            } else {
                return null;
            }
        }
        return new blb<Object>(a2);
    }

    static a a(int n2, bfw bfw2, Class<?> clazz) {
        return new a(n2, bfw2.bfw_a(clazz));
    }

    private static String a(Class<?> clazz) {
        String string = bje.b(clazz);
        if (string != null && string.startsWith("Synchronized")) {
            return string.substring(12);
        }
        return "";
    }

    private static String b(Class<?> clazz) {
        String string = clazz.getName();
        if (string.startsWith("java.util.Collections$")) {
            return string.substring("java.util.Collections$".length());
        }
        return "";
    }

    static {
        Set<Boolean> set = Collections.singleton(Boolean.TRUE);
        b = set.getClass();
        e = Collections.unmodifiableSet(set).getClass();
        List<Boolean> list = Collections.singletonList(Boolean.TRUE);
        c = list.getClass();
        f = Collections.unmodifiableList(list).getClass();
        g = Collections.unmodifiableList(new LinkedList()).getClass();
        Map<String, String> map = Collections.singletonMap("a", "b");
        d = map.getClass();
        h = Collections.unmodifiableMap(map).getClass();
    }

    static class a
    implements bum<Object, Object> {
        private final bfw var_bfw_a;
        private final int var_int_a;

        a(int n2, bfw bfw2) {
            this.var_bfw_a = bfw2;
            this.var_int_a = n2;
        }

        @Override
        public Object a(Object object) {
            if (object == null) {
                return null;
            }
            switch (this.var_int_a) {
                case 1: {
                    Set set = (Set)object;
                    this.a(set.size());
                    return Collections.singleton(set.iterator().next());
                }
                case 2: {
                    List list = (List)object;
                    this.a(list.size());
                    return Collections.singletonList(list.get(0));
                }
                case 3: {
                    Map map = (Map)object;
                    this.a(map.size());
                    Map.Entry entry = map.entrySet().iterator().next();
                    return Collections.singletonMap(entry.getKey(), entry.getValue());
                }
                case 4: {
                    return Collections.unmodifiableSet((Set)object);
                }
                case 5: {
                    return Collections.unmodifiableList((List)object);
                }
                case 6: {
                    return Collections.unmodifiableMap((Map)object);
                }
                case 7: {
                    return Collections.synchronizedSet((Set)object);
                }
                case 9: {
                    return Collections.synchronizedList((List)object);
                }
                case 8: {
                    return Collections.synchronizedCollection((Collection)object);
                }
                case 10: {
                    return Collections.synchronizedMap((Map)object);
                }
            }
            return object;
        }

        @Override
        public bfw a(btz btz2) {
            return this.var_bfw_a;
        }

        @Override
        public bfw b(btz btz2) {
            return this.var_bfw_a;
        }

        @Override
        private void a(int n2) {
            if (n2 != 1) {
                throw new IllegalArgumentException("Can not deserialize Singleton container from " + n2 + " entries");
            }
        }
    }
}

