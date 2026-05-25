/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Type;

public interface bns {
    public bfw a(Type var1);

    public static class b
    implements bns {
        private final btz a;

        public b(btz btz2) {
            this.a = btz2;
        }

        @Override
        public bfw a(Type type) {
            return this.a.a(type);
        }
    }

    public static class a
    implements bns {
        private final btz var_btz_a;
        private final bty var_bty_a;

        public a(btz btz2, bty bty2) {
            this.var_btz_a = btz2;
            this.var_bty_a = bty2;
        }

        @Override
        public bfw a(Type type) {
            return this.var_btz_a.a(type, this.var_bty_a);
        }
    }
}

