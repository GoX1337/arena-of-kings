/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bnw {
    public static String[] a(Class<?> clazz) {
        return c.a().java_lang_String_arr_a(clazz);
    }

    public static bmj a(bfs bfs2, bfo bfo2, List<String> list) {
        return new a(bfs2, bfo2).a(list);
    }

    static class a {
        protected final bfo var_bfo_a;
        protected final bfr var_bfr_a;
        protected final bfn var_bfn_a;
        protected final List<bmj> var_java_util_List_bmj__a;
        protected final bmj var_bmj_a;
        protected final b[] var_bnw$b_arr_a;

        a(bfs bfs2, bfo bfo2) {
            this.var_bfo_a = bfo2;
            this.var_bfn_a = bfs2.bfn_a();
            this.var_bfr_a = bfs2.bfr_a();
            this.var_bnw$b_arr_a = c.a().bnw$b_arr_a(bfo2.a());
            int n2 = this.var_bnw$b_arr_a.length;
            bmj bmj2 = null;
            if (n2 == 0) {
                bmj2 = bfo2.bmj_a();
                this.var_bfo_a = Collections.singletonList(bmj2);
            } else {
                this.var_bfo_a = bfo2.c();
                Iterator iterator = this.var_bfo_a.iterator();
                block0: while (iterator.hasNext()) {
                    bmj bmj3 = (bmj)iterator.next();
                    if (bmj3.int_a() != n2) continue;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        if (!bmj3.a(i2).equals(this.var_bnw$b_arr_a[i2].var_java_lang_Class____a)) continue block0;
                    }
                    bmj2 = bmj3;
                    break;
                }
            }
            if (bmj2 == null) {
                throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + buk.a(this.var_bfo_a.bfw_a()));
            }
            this.var_bmj_a = bmj2;
        }

        public bmj a(List<String> list) {
            b[] bArray = this.var_bfo_a.iterator();
            while (bArray.hasNext()) {
                bmj bmj2 = (bmj)bArray.next();
                bbh.a a2 = this.var_bfn_a.bbh$a_a(this.var_bfr_a, bmj2);
                if (null == a2 || bbh.a.d == a2) continue;
                if (bbh.a.b == a2) {
                    return null;
                }
                if (bmj2 == this.var_bmj_a) continue;
                return null;
            }
            for (b b2 : this.var_bnw$b_arr_a) {
                list.add(b2.var_java_lang_String_a);
            }
            return this.var_bmj_a;
        }
    }

    static class b {
        public final Class<?> var_java_lang_Class____a;
        public final String var_java_lang_String_a;

        public b(Class<?> clazz, String string) {
            this.var_java_lang_Class____a = clazz;
            this.var_java_lang_String_a = string;
        }
    }

    static class c {
        private final Method var_java_lang_reflect_Method_a;
        private final Method b;
        private final Method c;
        private static final c var_bnw$c_a;
        private static final RuntimeException var_java_lang_RuntimeException_a;

        private c() {
            try {
                this.var_java_lang_reflect_Method_a = Class.class.getMethod("getRecordComponents", new Class[0]);
                Class<?> clazz = Class.forName("java.lang.reflect.RecordComponent");
                this.b = clazz.getMethod("getName", new Class[0]);
                this.c = clazz.getMethod("getType", new Class[0]);
            }
            catch (Exception exception) {
                throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", exception.getClass().getName(), exception.getMessage()), exception);
            }
        }

        public static c a() {
            if (var_java_lang_RuntimeException_a != null) {
                throw var_java_lang_RuntimeException_a;
            }
            return var_bnw$c_a;
        }

        public String[] java_lang_String_arr_a(Class<?> clazz) {
            Object[] objectArray = this.java_lang_Object_arr_a(clazz);
            String[] stringArray = new String[objectArray.length];
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    stringArray[i2] = (String)this.b.invoke(objectArray[i2], new Object[0]);
                    continue;
                }
                catch (Exception exception) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", i2, objectArray.length, buk.java_lang_String_b(clazz)), exception);
                }
            }
            return stringArray;
        }

        public b[] bnw$b_arr_a(Class<?> clazz) {
            Object[] objectArray = this.java_lang_Object_arr_a(clazz);
            b[] bArray = new b[objectArray.length];
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Class clazz2;
                String string;
                try {
                    string = (String)this.b.invoke(objectArray[i2], new Object[0]);
                }
                catch (Exception exception) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", i2, objectArray.length, buk.java_lang_String_b(clazz)), exception);
                }
                try {
                    clazz2 = (Class)this.c.invoke(objectArray[i2], new Object[0]);
                }
                catch (Exception exception) {
                    throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", i2, objectArray.length, buk.java_lang_String_b(clazz)), exception);
                }
                bArray[i2] = new b(clazz2, string);
            }
            return bArray;
        }

        protected Object[] java_lang_Object_arr_a(Class<?> clazz) {
            try {
                return (Object[])this.var_java_lang_reflect_Method_a.invoke(clazz, new Object[0]);
            }
            catch (Exception exception) {
                throw new IllegalArgumentException("Failed to access RecordComponents of type " + buk.java_lang_String_b(clazz));
            }
        }

        static {
            RuntimeException runtimeException = null;
            c c2 = null;
            try {
                c2 = new c();
            }
            catch (RuntimeException runtimeException2) {
                runtimeException = runtimeException2;
            }
            var_bnw$c_a = c2;
            var_java_lang_RuntimeException_a = runtimeException;
        }
    }
}

