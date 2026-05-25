/*
 * Decompiled with CFR 0.152.
 */
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class bfy
extends bdd {
    protected LinkedList<a> var_java_util_LinkedList_bfy$a__a;
    protected transient Closeable var_java_io_Closeable_a;

    public bfy(Closeable closeable, String string) {
        super(string);
        this.var_java_io_Closeable_a = closeable;
        if (closeable instanceof bdc) {
            this.var_java_util_LinkedList_bfy$a__a = ((bdc)closeable).bda_a();
        }
    }

    public bfy(Closeable closeable, String string, Throwable throwable) {
        super(string, throwable);
        this.var_java_io_Closeable_a = closeable;
        if (throwable instanceof bdd) {
            this.var_java_util_LinkedList_bfy$a__a = ((bdd)throwable).bda_a();
        } else if (closeable instanceof bdc) {
            this.var_java_util_LinkedList_bfy$a__a = ((bdc)closeable).bda_a();
        }
    }

    public bfy(Closeable closeable, String string, bda bda2) {
        super(string, bda2);
        this.var_java_io_Closeable_a = closeable;
    }

    public static bfy a(bdc bdc2, String string) {
        return new bfy(bdc2, string);
    }

    public static bfy a(bdc bdc2, String string, Throwable throwable) {
        return new bfy((Closeable)bdc2, string, throwable);
    }

    public static bfy a(bcy bcy2, String string) {
        return new bfy((Closeable)bcy2, string, (Throwable)null);
    }

    public static bfy a(bcy bcy2, String string, Throwable throwable) {
        return new bfy((Closeable)bcy2, string, throwable);
    }

    public static bfy a(bfs bfs2, String string) {
        return new bfy(bfs2.bdc_a(), string);
    }

    public static bfy a(bfs bfs2, String string, Throwable throwable) {
        return new bfy((Closeable)bfs2.bdc_a(), string, throwable);
    }

    public static bfy a(IOException iOException) {
        return new bfy(null, String.format("Unexpected IOException (of type %s): %s", iOException.getClass().getName(), buk.java_lang_String_a(iOException)));
    }

    public static bfy a(Throwable throwable, Object object, String string) {
        return bfy.a(throwable, new a(object, string));
    }

    public static bfy a(Throwable throwable, Object object, int n2) {
        return bfy.a(throwable, new a(object, n2));
    }

    public static bfy a(Throwable throwable, a a2) {
        bfy bfy2;
        if (throwable instanceof bfy) {
            bfy2 = (bfy)throwable;
        } else {
            Object object;
            String string = buk.java_lang_String_a(throwable);
            if (string == null || string.isEmpty()) {
                string = "(was " + throwable.getClass().getName() + ")";
            }
            Closeable closeable = null;
            if (throwable instanceof bdd && (object = ((bdd)throwable).java_lang_Object_a()) instanceof Closeable) {
                closeable = (Closeable)object;
            }
            bfy2 = new bfy(closeable, string, throwable);
        }
        bfy2.a(a2);
        return bfy2;
    }

    public StringBuilder java_lang_StringBuilder_a(StringBuilder stringBuilder) {
        this.void_a(stringBuilder);
        return stringBuilder;
    }

    public void a(Object object, String string) {
        a a2 = new a(object, string);
        this.a(a2);
    }

    public void a(a a2) {
        if (this.var_java_util_LinkedList_bfy$a__a == null) {
            this.var_java_util_LinkedList_bfy$a__a = new LinkedList();
        }
        if (this.var_java_util_LinkedList_bfy$a__a.size() < 1000) {
            this.var_java_util_LinkedList_bfy$a__a.addFirst(a2);
        }
    }

    @Override
    @bbo
    public Object java_lang_String_a() {
        return this.var_java_io_Closeable_a;
    }

    @Override
    public String getLocalizedMessage() {
        return this.c();
    }

    @Override
    public String getMessage() {
        return this.c();
    }

    protected String c() {
        String string = super.getMessage();
        if (this.var_java_util_LinkedList_bfy$a__a == null) {
            return string;
        }
        StringBuilder stringBuilder = string == null ? new StringBuilder() : new StringBuilder(string);
        stringBuilder.append(" (through reference chain: ");
        stringBuilder = this.java_lang_StringBuilder_a(stringBuilder);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ": " + this.getMessage();
    }

    protected void void_a(StringBuilder stringBuilder) {
        if (this.var_java_util_LinkedList_bfy$a__a == null) {
            return;
        }
        Iterator iterator = this.var_java_util_LinkedList_bfy$a__a.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(((a)iterator.next()).toString());
            if (!iterator.hasNext()) continue;
            stringBuilder.append("->");
        }
    }

    public static class a
    implements Serializable {
        protected transient Object var_java_lang_Object_a;
        protected String var_java_lang_String_a;
        protected int var_int_a = -1;
        protected String b;

        protected a() {
        }

        public a(Object object, String string) {
            this.var_java_lang_Object_a = object;
            if (string == null) {
                throw new NullPointerException("Cannot pass null fieldName");
            }
            this.var_java_lang_String_a = string;
        }

        public a(Object object, int n2) {
            this.var_java_lang_Object_a = object;
            this.var_int_a = n2;
        }

        public String a() {
            if (this.b == null) {
                StringBuilder stringBuilder = new StringBuilder();
                if (this.var_java_lang_Object_a == null) {
                    stringBuilder.append("UNKNOWN");
                } else {
                    Class<?> clazz = this.var_java_lang_Object_a instanceof Class ? (Class<?>)this.var_java_lang_Object_a : this.var_java_lang_Object_a.getClass();
                    int n2 = 0;
                    while (clazz.isArray()) {
                        clazz = clazz.getComponentType();
                        ++n2;
                    }
                    stringBuilder.append(clazz.getName());
                    while (--n2 >= 0) {
                        stringBuilder.append("[]");
                    }
                }
                stringBuilder.append('[');
                if (this.var_java_lang_String_a != null) {
                    stringBuilder.append('\"');
                    stringBuilder.append(this.var_java_lang_String_a);
                    stringBuilder.append('\"');
                } else if (this.var_int_a >= 0) {
                    stringBuilder.append(this.var_int_a);
                } else {
                    stringBuilder.append('?');
                }
                stringBuilder.append(']');
                this.b = stringBuilder.toString();
            }
            return this.b;
        }

        public String toString() {
            return this.a();
        }
    }
}

