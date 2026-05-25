/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public abstract class boa
implements Serializable {
    public abstract b boa$b_a(bhm<?> var1, bfw var2);

    public abstract b a(bhm<?> var1, bfw var2, String var3);

    public abstract b boa$b_a(bhm<?> var1, bfw var2, bfw var3);

    public static abstract class a
    extends boa
    implements Serializable {
        @Override
        public b boa$b_a(bhm<?> bhm2, bfw bfw2) {
            return b.c;
        }

        @Override
        public b a(bhm<?> bhm2, bfw bfw2, String string) {
            return b.c;
        }

        @Override
        public b boa$b_a(bhm<?> bhm2, bfw bfw2, bfw bfw3) {
            return b.c;
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b var_boa$b_a;
        public static final /* enum */ b b;
        public static final /* enum */ b c;
        private static final /* synthetic */ b[] var_boa$b_arr_a;

        public static b[] values() {
            return (b[])var_boa$b_arr_a.clone();
        }

        public static b valueOf(String string) {
            return Enum.valueOf(b.class, string);
        }

        static {
            var_boa$b_a = new b();
            b = new b();
            c = new b();
            var_boa$b_arr_a = new b[]{var_boa$b_a, b, c};
        }
    }
}

