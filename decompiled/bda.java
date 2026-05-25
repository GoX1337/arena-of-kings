/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.nio.charset.Charset;

public class bda
implements Serializable {
    public static final bda var_bda_a;
    protected final long var_long_a;
    protected final long var_long_b;
    protected final int var_int_a;
    protected final int var_int_b;
    final transient Object var_java_lang_Object_a;

    public bda(Object object, long l2, int n2, int n3) {
        this(object, -1L, l2, n2, n3);
    }

    public bda(Object object, long l2, long l3, int n2, int n3) {
        this.var_java_lang_Object_a = object;
        this.var_long_a = l2;
        this.var_long_b = l3;
        this.var_int_a = n2;
        this.var_int_b = n3;
    }

    public long a() {
        return this.var_long_a;
    }

    public int hashCode() {
        int n2 = this.var_java_lang_Object_a == null ? 1 : this.var_java_lang_Object_a.hashCode();
        n2 ^= this.var_int_a;
        n2 += this.var_int_b;
        n2 ^= (int)this.var_long_b;
        return n2 += (int)this.var_long_a;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof bda)) {
            return false;
        }
        bda bda2 = (bda)object;
        if (this.var_java_lang_Object_a == null ? bda2.var_java_lang_Object_a != null : !this.var_java_lang_Object_a.equals(bda2.var_java_lang_Object_a)) {
            return false;
        }
        return this.var_int_a == bda2.var_int_a && this.var_int_b == bda2.var_int_b && this.var_long_b == bda2.var_long_b && this.a() == bda2.a();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(80);
        stringBuilder.append("[Source: ");
        this.a(stringBuilder);
        stringBuilder.append("; line: ");
        stringBuilder.append(this.var_int_a);
        stringBuilder.append(", column: ");
        stringBuilder.append(this.var_int_b);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    protected StringBuilder a(StringBuilder stringBuilder) {
        int n2;
        Object object = this.var_java_lang_Object_a;
        if (object == null) {
            stringBuilder.append("UNKNOWN");
            return stringBuilder;
        }
        Class<?> clazz = object instanceof Class ? (Class<?>)object : object.getClass();
        String string = clazz.getName();
        if (string.startsWith("java.")) {
            string = clazz.getSimpleName();
        } else if (object instanceof byte[]) {
            string = "byte[]";
        } else if (object instanceof char[]) {
            string = "char[]";
        }
        stringBuilder.append('(').append(string).append(')');
        String string2 = " chars";
        if (object instanceof CharSequence) {
            CharSequence charSequence = (CharSequence)object;
            n2 = charSequence.length();
            n2 -= this.a(stringBuilder, charSequence.subSequence(0, Math.min(n2, 500)).toString());
        } else if (object instanceof char[]) {
            char[] cArray = (char[])object;
            n2 = cArray.length;
            n2 -= this.a(stringBuilder, new String(cArray, 0, Math.min(n2, 500)));
        } else if (object instanceof byte[]) {
            byte[] byArray = (byte[])object;
            int n3 = Math.min(byArray.length, 500);
            this.a(stringBuilder, new String(byArray, 0, n3, Charset.forName("UTF-8")));
            n2 = byArray.length - n3;
            string2 = " bytes";
        } else {
            n2 = 0;
        }
        if (n2 > 0) {
            stringBuilder.append("[truncated ").append(n2).append(string2).append(']');
        }
        return stringBuilder;
    }

    private int a(StringBuilder stringBuilder, String string) {
        stringBuilder.append('\"').append(string).append('\"');
        return string.length();
    }

    static {
        var_bda_a = new bda(null, -1L, -1L, -1, -1);
    }
}

