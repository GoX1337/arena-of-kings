/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

public abstract class bko<T>
extends blg<T> {
    public static Class<?>[] java_lang_Class____arr_a() {
        return new Class[]{File.class, URL.class, URI.class, Class.class, bfw.class, Currency.class, Pattern.class, Locale.class, Charset.class, TimeZone.class, InetAddress.class, InetSocketAddress.class, StringBuilder.class};
    }

    protected bko(Class<?> clazz) {
        super(clazz);
    }

    public static bko<?> a(Class<?> clazz) {
        int n2 = 0;
        if (clazz == File.class) {
            n2 = 1;
        } else if (clazz == URL.class) {
            n2 = 2;
        } else if (clazz == URI.class) {
            n2 = 3;
        } else if (clazz == Class.class) {
            n2 = 4;
        } else if (clazz == bfw.class) {
            n2 = 5;
        } else if (clazz == Currency.class) {
            n2 = 6;
        } else if (clazz == Pattern.class) {
            n2 = 7;
        } else if (clazz == Locale.class) {
            n2 = 8;
        } else if (clazz == Charset.class) {
            n2 = 9;
        } else if (clazz == TimeZone.class) {
            n2 = 10;
        } else if (clazz == InetAddress.class) {
            n2 = 11;
        } else if (clazz == InetSocketAddress.class) {
            n2 = 12;
        } else {
            if (clazz == StringBuilder.class) {
                return new b();
            }
            return null;
        }
        return new a(clazz, n2);
    }

    @Override
    public btq btq_a() {
        return btq.m;
    }

    @Override
    public T a(bdc bdc2, bfs bfs2) {
        Object object;
        String string = bdc2.java_lang_String_f();
        if (string == null) {
            object = bdc2.bdf_c();
            if (object != bdf.var_bdf_b) {
                return (T)this.a(bdc2, bfs2, (bdf)((Object)object));
            }
            string = bfs2.a(bdc2, this, this.b);
        }
        if (string.isEmpty() || (string = string.trim()).isEmpty()) {
            return (T)this.c(bfs2);
        }
        object = null;
        try {
            return this.a(string, bfs2);
        }
        catch (IllegalArgumentException | MalformedURLException exception) {
            object = exception;
            String string2 = "not a valid textual representation";
            String string3 = ((Throwable)object).getMessage();
            if (string3 != null) {
                string2 = string2 + ", problem: " + string3;
            }
            bfy bfy2 = bfs2.a(string, this.b, string2);
            bfy2.initCause((Throwable)object);
            throw bfy2;
        }
    }

    protected abstract T a(String var1, bfs var2);

    @Override
    protected Object a(bdc bdc2, bfs bfs2, bdf bdf2) {
        if (bdf2 == bdf.var_bdf_d) {
            return this.e(bdc2, bfs2);
        }
        if (bdf2 == bdf.g) {
            Object object = bdc2.java_lang_Object_a();
            if (object == null) {
                return null;
            }
            if (this.b.isAssignableFrom(object.getClass())) {
                return object;
            }
            return this.a(object, bfs2);
        }
        return bfs2.a(this.b, bdc2);
    }

    protected T a(Object object, bfs bfs2) {
        bfs2.a(this, "Don't know how to convert embedded Object of type %s into %s", object.getClass().getName(), this.b.getName());
        return null;
    }

    protected Object c(bfs bfs2) {
        bha bha2 = bfs2.a(this.btq_a(), this.b, bhe.j);
        if (bha2 == bha.var_bha_a) {
            bfs2.a(this, "Cannot coerce empty String (\"\") to %s (but could if enabling coercion using `CoercionConfig`)", this.java_lang_String_a());
        }
        if (bha2 == bha.c) {
            return this.a(bfs2);
        }
        if (bha2 == bha.d) {
            return this.b(bfs2);
        }
        return this.d(bfs2);
    }

    protected Object d(bfs bfs2) {
        return this.a(bfs2);
    }

    static class b
    extends bko<Object> {
        public b() {
            super(StringBuilder.class);
        }

        @Override
        public btq a() {
            return btq.j;
        }

        @Override
        public Object b(bfs bfs2) {
            return new StringBuilder();
        }

        @Override
        public Object a(bdc bdc2, bfs bfs2) {
            String string = bdc2.java_lang_String_f();
            if (string != null) {
                return this.a(string, bfs2);
            }
            return super.a(bdc2, bfs2);
        }

        @Override
        protected Object a(String string, bfs bfs2) {
            return new StringBuilder(string);
        }
    }

    public static class a
    extends bko<Object> {
        protected final int a;

        protected a(Class<?> clazz, int n2) {
            super(clazz);
            this.a = n2;
        }

        @Override
        protected Object a(String string, bfs bfs2) {
            switch (this.a) {
                case 1: {
                    return new File(string);
                }
                case 2: {
                    return new URL(string);
                }
                case 3: {
                    return URI.create(string);
                }
                case 4: {
                    try {
                        return bfs2.a(string);
                    }
                    catch (Exception exception) {
                        return bfs2.a(this.b, (Object)string, buk.d(exception));
                    }
                }
                case 5: {
                    return bfs2.btz_a().a(string);
                }
                case 6: {
                    return Currency.getInstance(string);
                }
                case 7: {
                    return Pattern.compile(string);
                }
                case 8: {
                    int n2 = this.a(string);
                    if (n2 < 0) {
                        return new Locale(string);
                    }
                    String string2 = string.substring(0, n2);
                    if ((n2 = this.a(string = string.substring(n2 + 1))) < 0) {
                        return new Locale(string2, string);
                    }
                    String string3 = string.substring(0, n2);
                    return new Locale(string2, string3, string.substring(n2 + 1));
                }
                case 9: {
                    return Charset.forName(string);
                }
                case 10: {
                    return TimeZone.getTimeZone(string);
                }
                case 11: {
                    return InetAddress.getByName(string);
                }
                case 12: {
                    if (string.startsWith("[")) {
                        int n3 = string.lastIndexOf(93);
                        if (n3 == -1) {
                            throw new blr(bfs2.bdc_a(), "Bracketed IPv6 address must contain closing bracket", string, InetSocketAddress.class);
                        }
                        int n4 = string.indexOf(58, n3);
                        int n5 = n4 > -1 ? Integer.parseInt(string.substring(n4 + 1)) : 0;
                        return new InetSocketAddress(string.substring(0, n3 + 1), n5);
                    }
                    int n6 = string.indexOf(58);
                    if (n6 >= 0 && string.indexOf(58, n6 + 1) < 0) {
                        int n7 = Integer.parseInt(string.substring(n6 + 1));
                        return new InetSocketAddress(string.substring(0, n6), n7);
                    }
                    return new InetSocketAddress(string, 0);
                }
            }
            bfl.a();
            return null;
        }

        @Override
        public Object b(bfs bfs2) {
            switch (this.a) {
                case 3: {
                    return URI.create("");
                }
                case 8: {
                    return Locale.ROOT;
                }
            }
            return super.b(bfs2);
        }

        @Override
        protected Object d(bfs bfs2) {
            return this.b(bfs2);
        }

        protected int a(String string) {
            int n2 = string.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                char c2 = string.charAt(i2);
                if (c2 != '_' && c2 != '-') continue;
                return i2;
            }
            return -1;
        }
    }
}

