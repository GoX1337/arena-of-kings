/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@bgp
public class ble
extends bgc
implements Serializable {
    protected final int var_int_a;
    protected final Class<?> var_java_lang_Class____a;
    protected final bko<?> var_bko____a;

    protected ble(int n2, Class<?> clazz) {
        this(n2, clazz, null);
    }

    protected ble(int n2, Class<?> clazz, bko<?> bko2) {
        this.var_int_a = n2;
        this.var_int_a = (int)clazz;
        this.var_int_a = (int)bko2;
    }

    public static ble a(Class<?> clazz) {
        int n2;
        if (clazz == String.class || clazz == Object.class || clazz == CharSequence.class || clazz == Serializable.class) {
            return e.a(clazz);
        }
        if (clazz == UUID.class) {
            n2 = 12;
        } else if (clazz == Integer.class) {
            n2 = 5;
        } else if (clazz == Long.class) {
            n2 = 6;
        } else if (clazz == Date.class) {
            n2 = 10;
        } else if (clazz == Calendar.class) {
            n2 = 11;
        } else if (clazz == Boolean.class) {
            n2 = 1;
        } else if (clazz == Byte.class) {
            n2 = 2;
        } else if (clazz == Character.class) {
            n2 = 4;
        } else if (clazz == Short.class) {
            n2 = 3;
        } else if (clazz == Float.class) {
            n2 = 7;
        } else if (clazz == Double.class) {
            n2 = 8;
        } else if (clazz == URI.class) {
            n2 = 13;
        } else if (clazz == URL.class) {
            n2 = 14;
        } else if (clazz == Class.class) {
            n2 = 15;
        } else {
            if (clazz == Locale.class) {
                bko<Locale> bko2 = bko.a(Locale.class);
                return new ble(9, clazz, bko2);
            }
            if (clazz == Currency.class) {
                bko<Currency> bko3 = bko.a(Currency.class);
                return new ble(16, clazz, bko3);
            }
            if (clazz == byte[].class) {
                n2 = 17;
            } else {
                return null;
            }
        }
        return new ble(n2, clazz);
    }

    @Override
    public Object a(String string, bfs bfs2) {
        if (string == null) {
            return null;
        }
        try {
            Object object = this.b(string, bfs2);
            if (object != null) {
                return object;
            }
        }
        catch (Exception exception) {
            return bfs2.a((Class<?>)this.var_int_a, string, "not a valid representation, problem: (%s) %s", exception.getClass().getName(), buk.java_lang_String_a(exception));
        }
        if (buk.f(this.var_int_a) && bfs2.bfr_a().a(bfu.x)) {
            return null;
        }
        return bfs2.a((Class<?>)this.var_int_a, string, "not a valid representation", new Object[0]);
    }

    protected Object b(String string, bfs bfs2) {
        switch (this.var_int_a) {
            case 1: {
                if ("true".equals(string)) {
                    return Boolean.TRUE;
                }
                if ("false".equals(string)) {
                    return Boolean.FALSE;
                }
                return bfs2.a((Class<?>)this.var_int_a, string, "value not 'true' or 'false'", new Object[0]);
            }
            case 2: {
                int n2 = this.int_a(string);
                if (n2 < -128 || n2 > 255) {
                    return bfs2.a((Class<?>)this.var_int_a, string, "overflow, value cannot be represented as 8-bit value", new Object[0]);
                }
                return (byte)n2;
            }
            case 3: {
                int n3 = this.int_a(string);
                if (n3 < Short.MIN_VALUE || n3 > Short.MAX_VALUE) {
                    return bfs2.a((Class<?>)this.var_int_a, string, "overflow, value cannot be represented as 16-bit value", new Object[0]);
                }
                return (short)n3;
            }
            case 4: {
                if (string.length() == 1) {
                    return Character.valueOf(string.charAt(0));
                }
                return bfs2.a((Class<?>)this.var_int_a, string, "can only convert 1-character Strings", new Object[0]);
            }
            case 5: {
                return this.int_a(string);
            }
            case 6: {
                return this.long_a(string);
            }
            case 7: {
                return Float.valueOf((float)this.double_a(string));
            }
            case 8: {
                return this.double_a(string);
            }
            case 9: {
                try {
                    return this.var_int_a.a(string, bfs2);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    return this.a(bfs2, string, illegalArgumentException);
                }
            }
            case 16: {
                try {
                    return this.var_int_a.a(string, bfs2);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    return this.a(bfs2, string, illegalArgumentException);
                }
            }
            case 10: {
                return bfs2.java_util_Date_a(string);
            }
            case 11: {
                return bfs2.a(bfs2.java_util_Date_a(string));
            }
            case 12: {
                try {
                    return UUID.fromString(string);
                }
                catch (Exception exception) {
                    return this.a(bfs2, string, exception);
                }
            }
            case 13: {
                try {
                    return URI.create(string);
                }
                catch (Exception exception) {
                    return this.a(bfs2, string, exception);
                }
            }
            case 14: {
                try {
                    return new URL(string);
                }
                catch (MalformedURLException malformedURLException) {
                    return this.a(bfs2, string, malformedURLException);
                }
            }
            case 15: {
                try {
                    return bfs2.a(string);
                }
                catch (Exception exception) {
                    return bfs2.a((Class<?>)this.var_int_a, string, "unable to parse key as Class", new Object[0]);
                }
            }
            case 17: {
                try {
                    return bfs2.bfr_a().bcq_a().a(string);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    return this.a(bfs2, string, illegalArgumentException);
                }
            }
        }
        throw new IllegalStateException("Internal error: unknown key type " + this.var_int_a);
    }

    protected int int_a(String string) {
        return Integer.parseInt(string);
    }

    protected long long_a(String string) {
        return Long.parseLong(string);
    }

    protected double double_a(String string) {
        return bea.double_a(string);
    }

    protected Object a(bfs bfs2, String string, Exception exception) {
        return bfs2.a((Class<?>)this.var_int_a, string, "problem: %s", buk.java_lang_String_a(exception));
    }

    static final class d
    extends ble {
        final Method a;

        public d(Method method) {
            super(-1, method.getDeclaringClass());
            this.a = method;
        }

        @Override
        public Object b(String string, bfs bfs2) {
            return this.a.invoke(null, string);
        }
    }

    static final class c
    extends ble {
        protected final Constructor<?> a;

        public c(Constructor<?> constructor) {
            super(-1, constructor.getDeclaringClass());
            this.a = constructor;
        }

        @Override
        public Object b(String string, bfs bfs2) {
            return this.a.newInstance(string);
        }
    }

    @bgp
    static final class b
    extends ble {
        protected final bun var_bun_a;
        protected final bmo var_bmo_a;
        protected bun b;
        protected final Enum<?> var_java_lang_Enum____a;

        protected b(bun bun2, bmo bmo2) {
            super(-1, bun2.a());
            this.var_bun_a = bun2;
            this.var_bmo_a = bmo2;
            this.var_bun_a = bun2.a();
        }

        @Override
        public Object b(String string, bfs bfs2) {
            bun bun2;
            Object object;
            if (this.var_bmo_a != null) {
                try {
                    return this.var_bmo_a.a(string);
                }
                catch (Exception exception) {
                    buk.void_b(exception);
                }
            }
            if ((object = (bun2 = bfs2.a(bfu.w) ? this.a(bfs2) : this.var_bun_a).a(string)) == null) {
                if (this.var_bun_a != null && bfs2.a(bfu.y)) {
                    object = this.var_bun_a;
                } else if (!bfs2.a(bfu.x)) {
                    return bfs2.a((Class<?>)((Object)this.var_bun_a), string, "not one of the values accepted for Enum class: %s", bun2.a());
                }
            }
            return object;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private bun a(bfs bfs2) {
            bun bun2 = this.b;
            if (bun2 == null) {
                b b2 = this;
                synchronized (b2) {
                    this.b = bun2 = bun.b(bfs2.bfr_a(), this.var_bun_a.a());
                }
            }
            return bun2;
        }
    }

    static final class a
    extends bgc
    implements Serializable {
        protected final Class<?> var_java_lang_Class____a;
        protected final bfx<?> var_bfx____a;

        protected a(Class<?> clazz, bfx<?> bfx2) {
            this.var_java_lang_Class____a = clazz;
            this.var_java_lang_Class____a = bfx2;
        }

        @Override
        public final Object a(String string, bfs bfs2) {
            if (string == null) {
                return null;
            }
            bve bve2 = new bve(bfs2.bdc_a(), bfs2);
            bve2.b(string);
            try {
                bdc bdc2 = bve2.bdc_a();
                bdc2.bdf_a();
                Object t2 = ((bfx)((Object)this.var_java_lang_Class____a)).a(bdc2, bfs2);
                if (t2 != null) {
                    return t2;
                }
                return bfs2.a(this.var_java_lang_Class____a, string, "not a valid representation", new Object[0]);
            }
            catch (Exception exception) {
                return bfs2.a(this.var_java_lang_Class____a, string, "not a valid representation: %s", exception.getMessage());
            }
        }
    }

    @bgp
    static final class e
    extends ble {
        private static final e a = new e(String.class);
        private static final e b = new e(Object.class);

        private e(Class<?> clazz) {
            super(-1, clazz);
        }

        public static e a(Class<?> clazz) {
            if (clazz == String.class) {
                return a;
            }
            if (clazz == Object.class) {
                return b;
            }
            return new e(clazz);
        }

        @Override
        public Object a(String string, bfs bfs2) {
            return string;
        }
    }
}

