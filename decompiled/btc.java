/*
 * Decompiled with CFR 0.152.
 */
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public abstract class btc {
    protected static final bgb<Object> a = new btb();
    protected static final bgb<Object> b = new d();

    public static bgb<Object> a(bgm bgm2, Class<?> clazz, boolean bl2) {
        if (clazz == null || clazz == Object.class) {
            return new b();
        }
        if (clazz == String.class) {
            return b;
        }
        if (clazz.isPrimitive()) {
            clazz = buk.b(clazz);
        }
        if (clazz == Integer.class) {
            return new a(5, clazz);
        }
        if (clazz == Long.class) {
            return new a(6, clazz);
        }
        if (clazz.isPrimitive() || Number.class.isAssignableFrom(clazz)) {
            return new a(8, clazz);
        }
        if (clazz == Class.class) {
            return new a(3, clazz);
        }
        if (Date.class.isAssignableFrom(clazz)) {
            return new a(1, clazz);
        }
        if (Calendar.class.isAssignableFrom(clazz)) {
            return new a(2, clazz);
        }
        if (clazz == UUID.class) {
            return new a(8, clazz);
        }
        if (clazz == byte[].class) {
            return new a(7, clazz);
        }
        if (bl2) {
            return new a(8, clazz);
        }
        return null;
    }

    public static bgb<Object> a(bgm bgm2, Class<?> clazz) {
        if (clazz != null) {
            if (clazz == Enum.class) {
                return new b();
            }
            if (buk.f(clazz)) {
                return c.a(clazz, buo.a(bgm2, clazz));
            }
        }
        return new a(8, clazz);
    }

    public static class c
    extends bte<Object> {
        protected final buo a;

        protected c(Class<?> clazz, buo buo2) {
            super(clazz, false);
            this.a = buo2;
        }

        public static c a(Class<?> clazz, buo buo2) {
            return new c(clazz, buo2);
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            if (bgo2.a(bgn.o)) {
                bcy2.a(object.toString());
                return;
            }
            Enum enum_ = (Enum)object;
            if (bgo2.a(bgn.q)) {
                bcy2.a(String.valueOf(enum_.ordinal()));
                return;
            }
            bcy2.void_a(this.a.a(enum_));
        }
    }

    public static class d
    extends bte<Object> {
        public d() {
            super(String.class, false);
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            bcy2.a((String)object);
        }
    }

    public static class b
    extends bte<Object> {
        protected transient bre a = bre.a();

        public b() {
            super(String.class, false);
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            bre bre2 = this.a;
            Class<?> clazz = object.getClass();
            bgb<Object> bgb2 = bre2.a(clazz);
            if (bgb2 == null) {
                bgb2 = this.a(bre2, clazz, bgo2);
            }
            bgb2.a(object, bcy2, bgo2);
        }

        protected bgb<Object> a(bre bre2, Class<?> clazz, bgo bgo2) {
            if (clazz == Object.class) {
                a a2 = new a(8, clazz);
                this.a = bre2.bre_a(clazz, (bgb<Object>)a2);
                return a2;
            }
            bre.d d2 = bre2.c(clazz, bgo2, null);
            if (bre2 != d2.var_bre_a) {
                this.a = d2.var_bre_a;
            }
            return d2.var_bgb_java_lang_Object__a;
        }
    }

    public static class a
    extends bte<Object> {
        protected final int a;

        public a(int n2, Class<?> clazz) {
            super(clazz, false);
            this.a = n2;
        }

        @Override
        public void a(Object object, bcy bcy2, bgo bgo2) {
            switch (this.a) {
                case 1: {
                    bgo2.b((Date)object, bcy2);
                    break;
                }
                case 2: {
                    bgo2.a(((Calendar)object).getTimeInMillis(), bcy2);
                    break;
                }
                case 3: {
                    bcy2.a(((Class)object).getName());
                    break;
                }
                case 4: {
                    String string;
                    if (bgo2.a(bgn.o)) {
                        string = object.toString();
                    } else {
                        Enum enum_ = (Enum)object;
                        string = bgo2.a(bgn.q) ? String.valueOf(enum_.ordinal()) : enum_.name();
                    }
                    bcy2.a(string);
                    break;
                }
                case 5: 
                case 6: {
                    bcy2.a(((Number)object).longValue());
                    break;
                }
                case 7: {
                    String string = bgo2.bgm_a().bcq_a().a((byte[])object);
                    bcy2.a(string);
                    break;
                }
                default: {
                    bcy2.a(object.toString());
                }
            }
        }
    }
}

