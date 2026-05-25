/*
 * Decompiled with CFR 0.152.
 */
import java.math.BigDecimal;
import java.util.Map;

public class bsq {
    public static void a(Map<String, bgb<?>> map) {
        map.put(Integer.class.getName(), new e(Integer.class));
        map.put(Integer.TYPE.getName(), new e((Class<?>)Integer.TYPE));
        map.put(Long.class.getName(), new f(Long.class));
        map.put(Long.TYPE.getName(), new f((Class<?>)Long.TYPE));
        map.put(Byte.class.getName(), d.a);
        map.put(Byte.TYPE.getName(), d.a);
        map.put(Short.class.getName(), g.a);
        map.put(Short.TYPE.getName(), g.a);
        map.put(Double.class.getName(), new b(Double.class));
        map.put(Double.TYPE.getName(), new b((Class<?>)Double.TYPE));
        map.put(Float.class.getName(), c.a);
        map.put(Float.TYPE.getName(), c.a);
    }

    @bgp
    public static class b
    extends a<Object> {
        public b(Class<?> clazz) {
            super(clazz, bdc.b.e, "number");
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            bcy2.a((Double)object);
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
            Double d2 = (Double)object;
            if (b.a(d2)) {
                beu beu2 = bog2.a(bcy2, bog2.a(object, bdf.j));
                bcy2.a(d2);
                bog2.b(bcy2, beu2);
            } else {
                bcy2.a(d2);
            }
        }

        public static boolean a(double d2) {
            return Double.isNaN(d2) || Double.isInfinite(d2);
        }
    }

    @bgp
    public static class c
    extends a<Object> {
        static final c a = new c();

        public c() {
            super(Float.class, bdc.b.d, "number");
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            bcy2.a(((Float)object).floatValue());
        }
    }

    @bgp
    public static class f
    extends a<Object> {
        public f(Class<?> clazz) {
            super(clazz, bdc.b.b, "number");
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            bcy2.b((Long)object);
        }
    }

    @bgp
    public static class d
    extends a<Object> {
        static final d a = new d();

        public d() {
            super(Number.class, bdc.b.var_bdc$b_a, "integer");
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            bcy2.void_b(((Number)object).intValue());
        }
    }

    @bgp
    public static class e
    extends a<Object> {
        public e(Class<?> clazz) {
            super(clazz, bdc.b.var_bdc$b_a, "integer");
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            bcy2.void_b((Integer)object);
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2, bog bog2) {
            this.a(object, bcy2, bgo2);
        }
    }

    @bgp
    public static class g
    extends a<Object> {
        static final g a = new g();

        public g() {
            super(Short.class, bdc.b.var_bdc$b_a, "number");
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            bcy2.a((Short)object);
        }
    }

    public static abstract class a<T>
    extends btd<T>
    implements bqh {
        protected final bdc.b var_bdc$b_a;
        protected final String var_java_lang_String_a;
        protected final boolean var_boolean_a;

        protected a(Class<?> clazz, bdc.b b2, String string) {
            super(clazz, false);
            this.var_bdc$b_a = b2;
            this.var_java_lang_String_a = string;
            this.var_boolean_a = b2 == bdc.b.var_bdc$b_a || b2 == bdc.b.b || b2 == bdc.b.c;
        }

        @Override
        public bgb<?> a(bgo bgo2, bfp bfp2) {
            bbk.d d2 = this.bbk$d_a(bgo2, bfp2, this.a());
            if (d2 != null) {
                switch (d2.bbk$c_a()) {
                    case i: {
                        if (this.a() == BigDecimal.class) {
                            return bso.a();
                        }
                        return bth.a;
                    }
                }
            }
            return this;
        }
    }
}

