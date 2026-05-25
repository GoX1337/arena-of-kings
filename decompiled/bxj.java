/*
 * Decompiled with CFR 0.152.
 */
public class bxj {
    protected bxh var_bxh_a;
    protected Throwable var_java_lang_Throwable_a;

    public bxj(bxh bxh2, Throwable throwable) {
        this.var_bxh_a = bxh2;
        this.var_java_lang_Throwable_a = throwable;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.var_bxh_a + ": " + this.var_java_lang_Throwable_a.getMessage());
        return stringBuffer.toString();
    }
}

