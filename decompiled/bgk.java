/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bgk
implements Serializable {
    @Deprecated
    public static final bgk a = new bgk();
    @Deprecated
    public static final bgk b = new f();
    @Deprecated
    public static final bgk c = new e();
    @Deprecated
    public static final bgk d = new b();
    @Deprecated
    public static final bgk e = new a();
    @Deprecated
    public static final bgk f = new c();
    @Deprecated
    public static final bgk g = c;
    @Deprecated
    public static final bgk h = b;

    public String a(bhm<?> bhm2, bml bml2, String string) {
        return string;
    }

    public String a(bhm<?> bhm2, bmo bmo2, String string) {
        return string;
    }

    public String b(bhm<?> bhm2, bmo bmo2, String string) {
        return string;
    }

    public String a(bhm<?> bhm2, bmr bmr2, String string) {
        return string;
    }

    @Deprecated
    public static class c
    extends d {
        @Override
        public String a(String string) {
            return bgk$c.a(string, '.');
        }
    }

    @Deprecated
    public static class a
    extends d {
        @Override
        public String a(String string) {
            return bgk$a.a(string, '-');
        }
    }

    @Deprecated
    public static class b
    extends d {
        @Override
        public String a(String string) {
            return string.toLowerCase();
        }
    }

    @Deprecated
    public static class f
    extends d {
        @Override
        public String a(String string) {
            char c2;
            if (string == null || string.isEmpty()) {
                return string;
            }
            char c3 = string.charAt(0);
            if (c3 == (c2 = Character.toUpperCase(c3))) {
                return string;
            }
            StringBuilder stringBuilder = new StringBuilder(string);
            stringBuilder.setCharAt(0, c2);
            return stringBuilder.toString();
        }
    }

    @Deprecated
    public static class e
    extends d {
        @Override
        public String a(String string) {
            if (string == null) {
                return string;
            }
            int n2 = string.length();
            StringBuilder stringBuilder = new StringBuilder(n2 * 2);
            int n3 = 0;
            boolean bl2 = false;
            for (int i2 = 0; i2 < n2; ++i2) {
                char c2 = string.charAt(i2);
                if (i2 <= 0 && c2 == '_') continue;
                if (Character.isUpperCase(c2)) {
                    if (!bl2 && n3 > 0 && stringBuilder.charAt(n3 - 1) != '_') {
                        stringBuilder.append('_');
                        ++n3;
                    }
                    c2 = Character.toLowerCase(c2);
                    bl2 = true;
                } else {
                    bl2 = false;
                }
                stringBuilder.append(c2);
                ++n3;
            }
            return n3 > 0 ? stringBuilder.toString() : string;
        }
    }

    @Deprecated
    public static abstract class d
    extends bgk {
        @Override
        public String a(bhm<?> bhm2, bml bml2, String string) {
            return this.a(string);
        }

        @Override
        public String a(bhm<?> bhm2, bmo bmo2, String string) {
            return this.a(string);
        }

        @Override
        public String b(bhm<?> bhm2, bmo bmo2, String string) {
            return this.a(string);
        }

        @Override
        public String a(bhm<?> bhm2, bmr bmr2, String string) {
            return this.a(string);
        }

        public abstract String a(String var1);

        protected static String a(String string, char c2) {
            if (string == null) {
                return string;
            }
            int n2 = string.length();
            if (n2 == 0) {
                return string;
            }
            StringBuilder stringBuilder = new StringBuilder(n2 + (n2 >> 1));
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                char c3 = string.charAt(i2);
                char c4 = Character.toLowerCase(c3);
                if (c4 == c3) {
                    if (n3 > 1) {
                        stringBuilder.insert(stringBuilder.length() - 1, c2);
                    }
                    n3 = 0;
                } else {
                    if (n3 == 0 && i2 > 0) {
                        stringBuilder.append(c2);
                    }
                    ++n3;
                }
                stringBuilder.append(c4);
            }
            return stringBuilder.toString();
        }
    }
}

