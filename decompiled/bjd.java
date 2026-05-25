/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class bjd {
    public static bir a(bfr bfr2, Class<?> clazz) {
        if (clazz == bda.class) {
            return new bkq();
        }
        if (Collection.class.isAssignableFrom(clazz)) {
            if (clazz == ArrayList.class) {
                return a.a;
            }
            if (Collections.EMPTY_SET.getClass() == clazz) {
                return new b(Collections.EMPTY_SET);
            }
            if (Collections.EMPTY_LIST.getClass() == clazz) {
                return new b(Collections.EMPTY_LIST);
            }
        } else if (Map.class.isAssignableFrom(clazz)) {
            if (clazz == LinkedHashMap.class) {
                return d.a;
            }
            if (clazz == HashMap.class) {
                return c.a;
            }
            if (Collections.EMPTY_MAP.getClass() == clazz) {
                return new b(Collections.EMPTY_MAP);
            }
        }
        return null;
    }

    static class b
    extends bir.a
    implements Serializable {
        protected final Object a;

        public b(Object object) {
            super(object.getClass());
            this.a = object;
        }

        @Override
        public boolean boolean_a() {
            return true;
        }

        @Override
        public boolean i() {
            return true;
        }

        @Override
        public Object a(bfs bfs2) {
            return this.a;
        }
    }

    static class d
    extends bir.a
    implements Serializable {
        public static final d a = new d();

        public d() {
            super(LinkedHashMap.class);
        }

        @Override
        public boolean boolean_a() {
            return true;
        }

        @Override
        public boolean i() {
            return true;
        }

        @Override
        public Object a(bfs bfs2) {
            return new LinkedHashMap();
        }
    }

    static class c
    extends bir.a
    implements Serializable {
        public static final c a = new c();

        public c() {
            super(HashMap.class);
        }

        @Override
        public boolean boolean_a() {
            return true;
        }

        @Override
        public boolean i() {
            return true;
        }

        @Override
        public Object a(bfs bfs2) {
            return new HashMap();
        }
    }

    static class a
    extends bir.a
    implements Serializable {
        public static final a a = new a();

        public a() {
            super(ArrayList.class);
        }

        @Override
        public boolean boolean_a() {
            return true;
        }

        @Override
        public boolean i() {
            return true;
        }

        @Override
        public Object a(bfs bfs2) {
            return new ArrayList();
        }
    }
}

