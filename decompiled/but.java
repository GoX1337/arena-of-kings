/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public abstract class but {
    public static final but a = new b();

    protected but() {
    }

    public static but a(String string, String string2) {
        boolean bl2;
        boolean bl3 = string != null && !string.isEmpty();
        boolean bl4 = bl2 = string2 != null && !string2.isEmpty();
        if (bl3) {
            if (bl2) {
                return new buu(string, string2);
            }
            return new buv(string);
        }
        if (bl2) {
            return new buw(string2);
        }
        return a;
    }

    public static but a(but but2, but but3) {
        return new a(but2, but3);
    }

    public abstract String a(String var1);

    public static class a
    extends but
    implements Serializable {
        protected final but b;
        protected final but c;

        public a(but but2, but but3) {
            this.b = but2;
            this.c = but3;
        }

        @Override
        public String a(String string) {
            return this.b.a(this.c.a(string));
        }

        public String toString() {
            return "[ChainedTransformer(" + this.b + ", " + this.c + ")]";
        }
    }

    protected static final class b
    extends but
    implements Serializable {
        protected b() {
        }

        @Override
        public String a(String string) {
            return string;
        }
    }
}

