/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class bee
implements bdi,
Serializable {
    private static final bdy var_bdy_a;
    protected final String var_java_lang_String_a;
    protected byte[] var_byte_arr_a;
    protected byte[] b;
    protected char[] var_char_arr_a;

    public bee(String string) {
        if (string == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this.var_java_lang_String_a = string;
    }

    @Override
    public final String java_lang_String_a() {
        return this.var_java_lang_String_a;
    }

    @Override
    public final char[] char_arr_a() {
        char[] cArray = this.var_char_arr_a;
        if (cArray == null) {
            this.var_char_arr_a = cArray = var_bdy_a.char_arr_a(this.var_java_lang_String_a);
        }
        return cArray;
    }

    @Override
    public final byte[] b() {
        byte[] byArray = this.var_byte_arr_a;
        if (byArray == null) {
            this.var_byte_arr_a = byArray = var_bdy_a.byte_arr_a(this.var_java_lang_String_a);
        }
        return byArray;
    }

    @Override
    public final byte[] byte_arr_a() {
        byte[] byArray = this.b;
        if (byArray == null) {
            this.b = byArray = var_bdy_a.b(this.var_java_lang_String_a);
        }
        return byArray;
    }

    @Override
    public int a(char[] cArray, int n2) {
        int n3;
        char[] cArray2 = this.var_char_arr_a;
        if (cArray2 == null) {
            this.var_char_arr_a = cArray2 = var_bdy_a.char_arr_a(this.var_java_lang_String_a);
        }
        if (n2 + (n3 = cArray2.length) > cArray.length) {
            return -1;
        }
        System.arraycopy(cArray2, 0, cArray, n2, n3);
        return n3;
    }

    @Override
    public int a(byte[] byArray, int n2) {
        int n3;
        byte[] byArray2 = this.var_byte_arr_a;
        if (byArray2 == null) {
            this.var_byte_arr_a = byArray2 = var_bdy_a.byte_arr_a(this.var_java_lang_String_a);
        }
        if (n2 + (n3 = byArray2.length) > byArray.length) {
            return -1;
        }
        System.arraycopy(byArray2, 0, byArray, n2, n3);
        return n3;
    }

    @Override
    public int b(char[] cArray, int n2) {
        String string = this.var_java_lang_String_a;
        int n3 = string.length();
        if (n2 + n3 > cArray.length) {
            return -1;
        }
        string.getChars(0, n3, cArray, n2);
        return n3;
    }

    @Override
    public int b(byte[] byArray, int n2) {
        int n3;
        byte[] byArray2 = this.b;
        if (byArray2 == null) {
            this.b = byArray2 = var_bdy_a.b(this.var_java_lang_String_a);
        }
        if (n2 + (n3 = byArray2.length) > byArray.length) {
            return -1;
        }
        System.arraycopy(byArray2, 0, byArray, n2, n3);
        return n3;
    }

    public final String toString() {
        return this.var_java_lang_String_a;
    }

    public final int hashCode() {
        return this.var_java_lang_String_a.hashCode();
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        bee bee2 = (bee)object;
        return this.var_java_lang_String_a.equals(bee2.var_java_lang_String_a);
    }

    static {
        var_bdy_a = bdy.bdy_a();
    }
}

