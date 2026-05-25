/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bub
implements Serializable {
    protected final btz a;

    public bub(btz btz2) {
        this.a = btz2;
    }

    public bfw a(String string) {
        a a2 = new a(string.trim());
        bfw bfw2 = this.a(a2);
        if (a2.hasMoreTokens()) {
            throw this.a(a2, "Unexpected tokens after complete type");
        }
        return bfw2;
    }

    protected bfw a(a a2) {
        if (!a2.hasMoreTokens()) {
            throw this.a(a2, "Unexpected end-of-string");
        }
        Class<?> clazz = this.a(a2.nextToken(), a2);
        if (a2.hasMoreTokens()) {
            String string = a2.nextToken();
            if ("<".equals(string)) {
                List<bfw> list = this.a(a2);
                bty bty2 = bty.a(clazz, list);
                return this.a.bfw_a(null, clazz, bty2);
            }
            a2.a(string);
        }
        return this.a.bfw_a(null, clazz, bty.bty_a());
    }

    protected List<bfw> a(a a2) {
        ArrayList<bfw> arrayList = new ArrayList<bfw>();
        while (a2.hasMoreTokens()) {
            arrayList.add(this.a(a2));
            if (!a2.hasMoreTokens()) break;
            String string = a2.nextToken();
            if (">".equals(string)) {
                return arrayList;
            }
            if (",".equals(string)) continue;
            throw this.a(a2, "Unexpected token '" + string + "', expected ',' or '>')");
        }
        throw this.a(a2, "Unexpected end-of-string");
    }

    protected Class<?> a(String string, a a2) {
        try {
            return this.a.a(string);
        }
        catch (Exception exception) {
            buk.java_lang_Throwable_b(exception);
            throw this.a(a2, "Cannot locate class '" + string + "', problem: " + exception.getMessage());
        }
    }

    protected IllegalArgumentException a(a a2, String string) {
        return new IllegalArgumentException(String.format("Failed to parse type '%s' (remaining: '%s'): %s", a2.a(), a2.b(), string));
    }

    static final class a
    extends StringTokenizer {
        protected final String var_java_lang_String_a;
        protected int var_int_a;
        protected String b;

        public a(String string) {
            super(string, "<,>", true);
            this.var_java_lang_String_a = string;
        }

        @Override
        public boolean hasMoreTokens() {
            return this.b != null || super.hasMoreTokens();
        }

        @Override
        public String nextToken() {
            String string;
            if (this.b != null) {
                string = this.b;
                this.b = null;
            } else {
                string = super.nextToken();
                this.var_int_a += string.length();
                string = string.trim();
            }
            return string;
        }

        public void a(String string) {
            this.b = string;
        }

        public String a() {
            return this.var_java_lang_String_a;
        }

        public String b() {
            return this.var_java_lang_String_a.substring(this.var_int_a);
        }
    }
}

