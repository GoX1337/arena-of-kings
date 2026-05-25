/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class bhj {
    public static bhj a() {
        return a.b();
    }

    public abstract Object a(Object var1);

    public abstract bhj a(Object var1, Object var2);

    public static class a
    extends bhj
    implements Serializable {
        protected static final a var_bhj$a_a;
        protected static final Object var_java_lang_Object_a;
        protected final Map<?, ?> cfr_renamed_14;
        protected transient Map<Object, Object> b;

        protected a(Map<?, ?> map) {
            this.var_bhj$a_a = map;
            this.b = null;
        }

        protected a(Map<?, ?> map, Map<Object, Object> map2) {
            this.var_bhj$a_a = map;
            this.b = map2;
        }

        public static bhj b() {
            return var_bhj$a_a;
        }

        @Override
        public Object a(Object object) {
            Object object2;
            if (this.b != null && (object2 = this.b.get(object)) != null) {
                if (object2 == var_java_lang_Object_a) {
                    return null;
                }
                return object2;
            }
            return this.var_bhj$a_a.get(object);
        }

        @Override
        public bhj a(Object object, Object object2) {
            if (object2 == null) {
                if (this.var_bhj$a_a.containsKey(object)) {
                    object2 = var_java_lang_Object_a;
                } else {
                    if (this.b == null || !this.b.containsKey(object)) {
                        return this;
                    }
                    this.b.remove(object);
                    return this;
                }
            }
            if (this.b == null) {
                return this.b(object, object2);
            }
            this.b.put(object, object2);
            return this;
        }

        protected bhj b(Object object, Object object2) {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            if (object2 == null) {
                object2 = var_java_lang_Object_a;
            }
            hashMap.put(object, object2);
            return new a((Map<?, ?>)((Object)this.var_bhj$a_a), (Map<Object, Object>)hashMap);
        }

        static {
            var_bhj$a_a = new a(Collections.emptyMap());
            var_java_lang_Object_a = new Object();
        }
    }
}

