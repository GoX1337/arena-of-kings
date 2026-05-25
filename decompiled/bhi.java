/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public final class bhi
implements Serializable {
    public static final bhi var_bhi_a;
    public static final bhi var_bhi_b;
    public static final bhi c;
    public static final bhi d;
    protected final a var_bhi$a_a;
    protected final boolean var_boolean_a;
    protected final boolean var_boolean_b;

    protected bhi(a a2, boolean bl2, boolean bl3) {
        this.var_bhi$a_a = a2;
        this.var_boolean_a = bl2;
        this.var_boolean_b = bl3;
    }

    protected bhi(a a2) {
        this(a2, false, false);
    }

    public a bhi$a_a() {
        return this.var_bhi$a_a;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    public boolean b() {
        return this.var_bhi$a_a == bhi$a.var_bhi$a_a;
    }

    public boolean c() {
        return this.var_bhi$a_a == bhi$a.b;
    }

    public boolean a(Class<?> clazz) {
        if (this.var_boolean_a) {
            return false;
        }
        return this.var_boolean_b || !buk.h(clazz) || Throwable.class.isAssignableFrom(clazz);
    }

    static {
        var_bhi_a = new bhi(bhi$a.c);
        var_bhi_b = new bhi(bhi$a.b);
        c = new bhi(bhi$a.var_bhi$a_a);
        d = new bhi(bhi$a.d);
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_bhi$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        private static final /* synthetic */ a[] var_bhi$a_arr_a;

        public static a[] values() {
            return (a[])var_bhi$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        static {
            var_bhi$a_a = new a();
            b = new a();
            c = new a();
            d = new a();
            var_bhi$a_arr_a = new a[]{var_bhi$a_a, b, c, d};
        }
    }
}

