/*
 * Decompiled with CFR 0.152.
 */
public class beu {
    public Object var_java_lang_Object_a;
    public Class<?> var_java_lang_Class____a;
    public Object b;
    public String var_java_lang_String_a;
    public a var_beu$a_a;
    public bdf var_bdf_a;
    public boolean var_boolean_a;

    public beu() {
    }

    public beu(Object object, bdf bdf2) {
        this(object, bdf2, null);
    }

    public beu(Object object, bdf bdf2, Object object2) {
        this.var_java_lang_Object_a = object;
        this.b = object2;
        this.var_bdf_a = bdf2;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_beu$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        public static final /* enum */ a e;
        private static final /* synthetic */ a[] var_beu$a_arr_a;

        public static a[] values() {
            return (a[])var_beu$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        public boolean a() {
            return this == c || this == d;
        }

        static {
            var_beu$a_a = new a();
            b = new a();
            c = new a();
            d = new a();
            e = new a();
            var_beu$a_arr_a = new a[]{var_beu$a_a, b, c, d, e};
        }
    }
}

