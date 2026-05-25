/*
 * Decompiled with CFR 0.152.
 */
import java.io.PrintStream;

public class bzh {
    final a var_bzh$a_a;
    final PrintStream var_java_io_PrintStream_a;

    public bzh(a a2) {
        if (a2 == bzh$a.e) {
            throw new IllegalArgumentException();
        }
        this.var_bzh$a_a = a2;
        this.var_java_io_PrintStream_a = a2 == bzh$a.b ? System.out : (a2 == bzh$a.d ? System.err : null);
    }

    public bzh(PrintStream printStream) {
        this.var_bzh$a_a = bzh$a.e;
        this.var_java_io_PrintStream_a = printStream;
    }

    public PrintStream a() {
        switch (this.var_bzh$a_a) {
            case var_bzh$a_a: {
                return System.out;
            }
            case c: {
                return System.err;
            }
            case d: 
            case b: 
            case e: {
                return this.var_java_io_PrintStream_a;
            }
        }
        throw new IllegalArgumentException();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a
    extends Enum<a> {
        public static final /* enum */ a var_bzh$a_a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        public static final /* enum */ a d;
        public static final /* enum */ a e;
        private static final /* synthetic */ a[] var_bzh$a_arr_a;

        public static a[] values() {
            return (a[])var_bzh$a_arr_a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        static {
            var_bzh$a_a = new a();
            b = new a();
            c = new a();
            d = new a();
            e = new a();
            var_bzh$a_arr_a = new a[]{var_bzh$a_a, b, c, d, e};
        }
    }
}

