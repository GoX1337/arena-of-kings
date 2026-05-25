/*
 * Decompiled with CFR 0.152.
 */
package org.junit;

import org.junit.Assert;

public class ComparisonFailure
extends AssertionError {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1L;
    private String fExpected;
    private String fActual;

    public ComparisonFailure(String string, String string2, String string3) {
        super((Object)string);
        this.fExpected = string2;
        this.fActual = string3;
    }

    public String getMessage() {
        return new a(20, this.fExpected, this.fActual).a(super.getMessage());
    }

    public String getActual() {
        return this.fActual;
    }

    public String getExpected() {
        return this.fExpected;
    }

    static class a {
        private int var_int_a;
        private String var_java_lang_String_a;
        private String var_java_lang_String_b;
        private int var_int_b;
        private int c;

        public a(int n2, String string, String string2) {
            this.var_int_a = n2;
            this.var_java_lang_String_a = string;
            this.var_java_lang_String_b = string2;
        }

        private String a(String string) {
            if (this.var_java_lang_String_a == null || this.var_java_lang_String_b == null || this.boolean_a()) {
                return Assert.format(string, this.var_java_lang_String_a, this.var_java_lang_String_b);
            }
            this.void_a();
            this.void_b();
            String string2 = this.b(this.var_java_lang_String_a);
            String string3 = this.b(this.var_java_lang_String_b);
            return Assert.format(string, string2, string3);
        }

        private String b(String string) {
            String string2 = "[" + string.substring(this.var_int_b, string.length() - this.c + 1) + "]";
            if (this.var_int_b > 0) {
                string2 = this.java_lang_String_a() + string2;
            }
            if (this.c > 0) {
                string2 = string2 + this.java_lang_String_b();
            }
            return string2;
        }

        private void void_a() {
            this.var_int_b = 0;
            int n2 = Math.min(this.var_java_lang_String_a.length(), this.var_java_lang_String_b.length());
            while (this.var_int_b < n2 && this.var_java_lang_String_a.charAt(this.var_int_b) == this.var_java_lang_String_b.charAt(this.var_int_b)) {
                ++this.var_int_b;
            }
        }

        private void void_b() {
            int n2 = this.var_java_lang_String_a.length() - 1;
            for (int i2 = this.var_java_lang_String_b.length() - 1; i2 >= this.var_int_b && n2 >= this.var_int_b && this.var_java_lang_String_a.charAt(n2) == this.var_java_lang_String_b.charAt(i2); --i2, --n2) {
            }
            this.c = this.var_java_lang_String_a.length() - n2;
        }

        private String java_lang_String_a() {
            return (this.var_int_b > this.var_int_a ? "..." : "") + this.var_java_lang_String_a.substring(Math.max(0, this.var_int_b - this.var_int_a), this.var_int_b);
        }

        private String java_lang_String_b() {
            int n2 = Math.min(this.var_java_lang_String_a.length() - this.c + 1 + this.var_int_a, this.var_java_lang_String_a.length());
            return this.var_java_lang_String_a.substring(this.var_java_lang_String_a.length() - this.c + 1, n2) + (this.var_java_lang_String_a.length() - this.c + 1 < this.var_java_lang_String_a.length() - this.var_int_a ? "..." : "");
        }

        private boolean boolean_a() {
            return this.var_java_lang_String_a.equals(this.var_java_lang_String_b);
        }
    }
}

