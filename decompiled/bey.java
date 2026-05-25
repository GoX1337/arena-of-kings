/*
 * Decompiled with CFR 0.152.
 */
public class bey
extends bez.c {
    public static final String var_java_lang_String_a;
    public static final bey var_bey_a;
    private final char[] var_char_arr_a;
    private final int var_int_a;
    private final String b;

    public bey() {
        this("  ", var_java_lang_String_a);
    }

    public bey(String string, String string2) {
        this.var_int_a = string.length();
        this.var_char_arr_a = new char[string.length() * 16];
        int n2 = 0;
        for (int i2 = 0; i2 < 16; ++i2) {
            string.getChars(0, string.length(), this.var_char_arr_a, n2);
            n2 += string.length();
        }
        this.b = string2;
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public void a(bcy bcy2, int n2) {
        bcy2.c(this.b);
        if (n2 > 0) {
            n2 *= this.var_int_a;
            while (n2 > this.var_char_arr_a.length) {
                bcy2.b(this.var_char_arr_a, 0, this.var_char_arr_a.length);
                n2 -= this.var_char_arr_a.length;
            }
            bcy2.b(this.var_char_arr_a, 0, n2);
        }
    }

    static {
        String string;
        try {
            string = System.getProperty("line.separator");
        }
        catch (Throwable throwable) {
            string = "\n";
        }
        var_java_lang_String_a = string;
        var_bey_a = new bey("  ", var_java_lang_String_a);
    }
}

