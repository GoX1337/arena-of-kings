/*
 * Decompiled with CFR 0.152.
 */
public class bxa {
    private Float var_java_lang_Float_a;
    private int var_int_a;
    private byte[] var_byte_arr_a;
    private int[] var_int_arr_a;
    private boolean var_boolean_a;

    public bxa(int n2, boolean bl2) {
        this.var_int_a = n2;
        this.var_boolean_a = bl2;
        this.var_byte_arr_a = new byte[2304 * n2];
        this.var_int_arr_a = new int[n2];
        this.int_a();
    }

    private void a(int n2, short s2) {
        byte by2;
        byte by3;
        if (this.var_boolean_a) {
            by3 = (byte)(s2 >>> 8 & 0xFF);
            by2 = (byte)(s2 & 0xFF);
        } else {
            by3 = (byte)(s2 & 0xFF);
            by2 = (byte)(s2 >>> 8 & 0xFF);
        }
        this.var_byte_arr_a[this.var_int_arr_a[n2]] = by3;
        this.var_byte_arr_a[this.var_int_arr_a[n2] + 1] = by2;
        int n3 = n2;
        this.var_int_arr_a[n3] = this.var_int_arr_a[n3] + this.var_int_a * 2;
    }

    public void a(int n2, float[] fArray) {
        if (this.var_java_lang_Float_a != null) {
            int n3 = 0;
            while (n3 < 32) {
                short s2 = this.a(fArray[n3++] * this.var_java_lang_Float_a.floatValue());
                this.a(n2, s2);
            }
        } else {
            int n4 = 0;
            while (n4 < 32) {
                short s3 = this.a(fArray[n4++]);
                this.a(n2, s3);
            }
        }
    }

    public byte[] byte_arr_a() {
        return this.var_byte_arr_a;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int int_a() {
        int n2;
        try {
            int n3 = this.var_int_a - 1;
            n2 = this.var_int_arr_a[n3] - n3 * 2;
        }
        catch (Throwable throwable) {
            for (int i2 = 0; i2 < this.var_int_a; ++i2) {
                this.var_int_arr_a[i2] = i2 * 2;
            }
            throw throwable;
        }
        for (int i3 = 0; i3 < this.var_int_a; ++i3) {
            this.var_int_arr_a[i3] = i3 * 2;
        }
        return n2;
    }

    private final short a(float f2) {
        return (short)(f2 > 32767.0f ? Short.MAX_VALUE : (short)(f2 < -32768.0f ? Short.MIN_VALUE : (short)f2));
    }
}

