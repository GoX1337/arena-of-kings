/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.Serializable;

public class bfh
implements Serializable {
    protected byte[] var_byte_arr_a;
    protected CharSequence var_java_lang_CharSequence_a;
    protected String var_java_lang_String_a;

    public String toString() {
        if (this.var_byte_arr_a != null) {
            try {
                return new String(this.var_byte_arr_a, this.var_java_lang_String_a);
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
        return this.var_java_lang_CharSequence_a.toString();
    }
}

