/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Locale;
import java.util.TimeZone;

@Target(value={ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface bbk {
    public String java_lang_String_a() default "";

    public c bbk$c_a() default c.ANY;

    public String java_lang_String_b() default "##default";

    public String c() default "##default";

    public bcn bcn_a() default bcn.DEFAULT;

    public a[] bbk$a_arr_a() default {};

    public a[] bbk$a_arr_b() default {};

    public static class d
    implements Serializable {
        private static final d var_bbk$d_a;
        private final String var_java_lang_String_a;
        private final c var_bbk$c_a;
        private final Locale var_java_util_Locale_a;
        private final String b;
        private final Boolean var_java_lang_Boolean_a;
        private final b var_bbk$b_a;
        private transient TimeZone var_java_util_TimeZone_a;

        public d() {
            this("", c.var_bbk$c_a, "", "", bbk$b.a(), null);
        }

        public d(bbk bbk2) {
            this(bbk2.java_lang_String_a(), bbk2.bbk$c_a(), bbk2.java_lang_String_b(), bbk2.c(), bbk$b.a(bbk2), bbk2.bcn_a().a());
        }

        public d(String string, c c2, String string2, String string3, b b2, Boolean bl2) {
            this(string, c2, string2 == null || string2.length() == 0 || "##default".equals(string2) ? null : new Locale(string2), string3 == null || string3.length() == 0 || "##default".equals(string3) ? null : string3, null, b2, bl2);
        }

        public d(String string, c c2, Locale locale, String string2, TimeZone timeZone, b b2, Boolean bl2) {
            this.var_java_lang_String_a = string == null ? "" : string;
            this.var_bbk$c_a = c2 == null ? c.var_bbk$c_a : c2;
            this.var_java_util_Locale_a = locale;
            this.var_java_util_TimeZone_a = timeZone;
            this.b = string2;
            this.var_bbk$b_a = b2 == null ? bbk$b.a() : b2;
            this.var_java_lang_Boolean_a = bl2;
        }

        public static final d bbk$d_a() {
            return var_bbk$d_a;
        }

        public static d a(d d2, d d3) {
            return d2 == null ? d3 : d2.a(d3);
        }

        public static final d a(bbk bbk2) {
            return bbk2 == null ? var_bbk$d_a : new d(bbk2);
        }

        public final d a(d d2) {
            TimeZone timeZone;
            String string;
            b b2;
            Locale locale;
            c c2;
            if (d2 == null || d2 == var_bbk$d_a || d2 == this) {
                return this;
            }
            if (this == var_bbk$d_a) {
                return d2;
            }
            String string2 = d2.var_java_lang_String_a;
            if (string2 == null || string2.isEmpty()) {
                string2 = this.var_java_lang_String_a;
            }
            if ((c2 = d2.var_bbk$c_a) == c.var_bbk$c_a) {
                c2 = this.var_bbk$c_a;
            }
            if ((locale = d2.var_java_util_Locale_a) == null) {
                locale = this.var_java_util_Locale_a;
            }
            b2 = (b2 = this.var_bbk$b_a) == null ? d2.var_bbk$b_a : b2.a(d2.var_bbk$b_a);
            Boolean bl2 = d2.var_java_lang_Boolean_a;
            if (bl2 == null) {
                bl2 = this.var_java_lang_Boolean_a;
            }
            if ((string = d2.b) == null || string.isEmpty()) {
                string = this.b;
                timeZone = this.var_java_util_TimeZone_a;
            } else {
                timeZone = d2.var_java_util_TimeZone_a;
            }
            return new d(string2, c2, locale, string, timeZone, b2, bl2);
        }

        public static d a(boolean bl2) {
            return new d("", null, null, null, null, bbk$b.a(), bl2);
        }

        public d a(Boolean bl2) {
            if (bl2 == this.var_java_lang_Boolean_a) {
                return this;
            }
            return new d(this.var_java_lang_String_a, this.var_bbk$c_a, this.var_java_util_Locale_a, this.b, this.var_java_util_TimeZone_a, this.var_bbk$b_a, bl2);
        }

        public String java_lang_String_a() {
            return this.var_java_lang_String_a;
        }

        public c bbk$c_a() {
            return this.var_bbk$c_a;
        }

        public Locale java_util_Locale_a() {
            return this.var_java_util_Locale_a;
        }

        public Boolean java_lang_Boolean_a() {
            return this.var_java_lang_Boolean_a;
        }

        public TimeZone java_util_TimeZone_a() {
            TimeZone timeZone = this.var_java_util_TimeZone_a;
            if (timeZone == null) {
                if (this.b == null) {
                    return null;
                }
                this.var_java_util_TimeZone_a = timeZone = TimeZone.getTimeZone(this.b);
            }
            return timeZone;
        }

        public boolean boolean_a() {
            return this.var_bbk$c_a != c.var_bbk$c_a;
        }

        public boolean b() {
            return this.var_java_lang_String_a != null && this.var_java_lang_String_a.length() > 0;
        }

        public boolean c() {
            return this.var_java_util_Locale_a != null;
        }

        public boolean d() {
            return this.var_java_util_TimeZone_a != null || this.b != null && !this.b.isEmpty();
        }

        public boolean e() {
            return this.var_java_lang_Boolean_a != null;
        }

        public Boolean a(a a2) {
            return this.var_bbk$b_a.a(a2);
        }

        public String toString() {
            return String.format("JsonFormat.Value(pattern=%s,shape=%s,lenient=%s,locale=%s,timezone=%s,features=%s)", new Object[]{this.var_java_lang_String_a, this.var_bbk$c_a, this.var_java_lang_Boolean_a, this.var_java_util_Locale_a, this.b, this.var_bbk$b_a});
        }

        public int hashCode() {
            int n2;
            int n3 = n2 = this.b == null ? 1 : this.b.hashCode();
            if (this.var_java_lang_String_a != null) {
                n2 ^= this.var_java_lang_String_a.hashCode();
            }
            n2 += this.var_bbk$c_a.hashCode();
            if (this.var_java_lang_Boolean_a != null) {
                n2 ^= this.var_java_lang_Boolean_a.hashCode();
            }
            if (this.var_java_util_Locale_a != null) {
                n2 += this.var_java_util_Locale_a.hashCode();
            }
            return n2 ^= this.var_bbk$b_a.hashCode();
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (object.getClass() != this.getClass()) {
                return false;
            }
            d d2 = (d)object;
            if (this.var_bbk$c_a != d2.var_bbk$c_a || !this.var_bbk$b_a.equals(d2.var_bbk$b_a)) {
                return false;
            }
            return d.a(this.var_java_lang_Boolean_a, d2.var_java_lang_Boolean_a) && d.a(this.b, d2.b) && d.a(this.var_java_lang_String_a, d2.var_java_lang_String_a) && d.a(this.var_java_util_TimeZone_a, d2.var_java_util_TimeZone_a) && d.a(this.var_java_util_Locale_a, d2.var_java_util_Locale_a);
        }

        private static <T> boolean a(T t2, T t3) {
            if (t2 == null) {
                return t3 == null;
            }
            if (t3 == null) {
                return false;
            }
            return t2.equals(t3);
        }

        static {
            var_bbk$d_a = new d();
        }
    }

    public static class b {
        private final int var_int_a;
        private final int b;
        private static final b var_bbk$b_a;

        private b(int n2, int n3) {
            this.var_int_a = n2;
            this.b = n3;
        }

        public static b a() {
            return var_bbk$b_a;
        }

        public static b a(bbk bbk2) {
            return bbk$b.a(bbk2.bbk$a_arr_a(), bbk2.bbk$a_arr_b());
        }

        public static b a(a[] aArray, a[] aArray2) {
            int n2 = 0;
            for (a a2 : aArray) {
                n2 |= 1 << a2.ordinal();
            }
            int n3 = 0;
            for (a a3 : aArray2) {
                n3 |= 1 << a3.ordinal();
            }
            return new b(n2, n3);
        }

        public b a(b b2) {
            if (b2 == null) {
                return this;
            }
            int n2 = b2.b;
            int n3 = b2.var_int_a;
            if (n2 == 0 && n3 == 0) {
                return this;
            }
            if (this.var_int_a == 0 && this.b == 0) {
                return b2;
            }
            int n4 = this.var_int_a & ~n2 | n3;
            int n5 = this.b & ~n3 | n2;
            if (n4 == this.var_int_a && n5 == this.b) {
                return this;
            }
            return new b(n4, n5);
        }

        public Boolean a(a a2) {
            int n2 = 1 << a2.ordinal();
            if ((this.b & n2) != 0) {
                return Boolean.FALSE;
            }
            if ((this.var_int_a & n2) != 0) {
                return Boolean.TRUE;
            }
            return null;
        }

        public String toString() {
            if (this == var_bbk$b_a) {
                return "EMPTY";
            }
            return String.format("(enabled=0x%x,disabled=0x%x)", this.var_int_a, this.b);
        }

        public int hashCode() {
            return this.b + this.var_int_a;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (object.getClass() != this.getClass()) {
                return false;
            }
            b b2 = (b)object;
            return b2.var_int_a == this.var_int_a && b2.b == this.b;
        }

        static {
            var_bbk$b_a = new b(0, 0);
        }
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_bbk$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        private static final /* synthetic */ a[] var_bbk$a_arr_a;

        public static a[] values() {
            return (a[])var_bbk$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        static {
            var_bbk$a_a = new a();
            b = new a();
            c = new a();
            d = new a();
            e = new a();
            f = new a();
            g = new a();
            h = new a();
            var_bbk$a_arr_a = new a[]{var_bbk$a_a, b, c, d, e, f, g, h};
        }
    }

    public static final class c
    extends Enum<c> {
        public static final /* enum */ c var_bbk$c_a;
        public static final /* enum */ c b;
        public static final /* enum */ c c;
        public static final /* enum */ c d;
        public static final /* enum */ c e;
        public static final /* enum */ c f;
        public static final /* enum */ c g;
        public static final /* enum */ c h;
        public static final /* enum */ c i;
        public static final /* enum */ c j;
        public static final /* enum */ c k;
        private static final /* synthetic */ c[] var_bbk$c_arr_a;

        public static c[] values() {
            return (c[])var_bbk$c_arr_a.clone();
        }

        public static c valueOf(String string) {
            return Enum.valueOf(c.class, string);
        }

        public boolean a() {
            return this == f || this == h || this == g;
        }

        static {
            var_bbk$c_a = new c();
            b = new c();
            c = new c();
            d = new c();
            e = new c();
            f = new c();
            g = new c();
            h = new c();
            i = new c();
            j = new c();
            k = new c();
            var_bbk$c_arr_a = new c[]{var_bbk$c_a, b, c, d, e, f, g, h, i, j, k};
        }
    }
}

