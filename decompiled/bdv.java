/*
 * Decompiled with CFR 0.152.
 */
public class bdv {
    protected final Object var_java_lang_Object_a;
    protected bcv var_bcv_a;
    protected final boolean var_boolean_a;
    protected final bev var_bev_a;
    protected byte[] var_byte_arr_a;
    protected byte[] var_byte_arr_b;
    protected byte[] var_byte_arr_c;
    protected char[] var_char_arr_a;
    protected char[] var_char_arr_b;
    protected char[] var_char_arr_c;

    public bdv(bev bev2, Object object, boolean bl2) {
        this.var_bev_a = bev2;
        this.var_java_lang_Object_a = object;
        this.var_boolean_a = bl2;
    }

    public void a(bcv bcv2) {
        this.var_bcv_a = bcv2;
    }

    public Object java_lang_Object_a() {
        return this.var_java_lang_Object_a;
    }

    public bcv bcv_a() {
        return this.var_bcv_a;
    }

    public boolean boolean_a() {
        return this.var_boolean_a;
    }

    public bfj bfj_a() {
        return new bfj(this.var_bev_a);
    }

    public byte[] byte_arr_a() {
        this.a((Object)this.var_byte_arr_a);
        this.var_byte_arr_a = this.var_bev_a.byte_arr_a(0);
        return this.var_byte_arr_a;
    }

    public byte[] byte_arr_b() {
        this.a((Object)this.var_byte_arr_b);
        this.var_byte_arr_b = this.var_bev_a.byte_arr_a(1);
        return this.var_byte_arr_b;
    }

    public byte[] c() {
        this.a((Object)this.var_byte_arr_c);
        this.var_byte_arr_c = this.var_bev_a.byte_arr_a(3);
        return this.var_byte_arr_c;
    }

    public char[] char_arr_a() {
        this.a((Object)this.var_char_arr_a);
        this.var_char_arr_a = this.var_bev_a.char_arr_a(0);
        return this.var_char_arr_a;
    }

    public char[] char_arr_b() {
        this.a((Object)this.var_char_arr_b);
        this.var_char_arr_b = this.var_bev_a.char_arr_a(1);
        return this.var_char_arr_b;
    }

    public char[] a(int n2) {
        this.a((Object)this.var_char_arr_c);
        this.var_char_arr_c = this.var_bev_a.char_arr_a(3, n2);
        return this.var_char_arr_c;
    }

    public void a(byte[] byArray) {
        if (byArray != null) {
            this.a(byArray, this.var_byte_arr_a);
            this.var_byte_arr_a = null;
            this.var_bev_a.a(0, byArray);
        }
    }

    public void b(byte[] byArray) {
        if (byArray != null) {
            this.a(byArray, this.var_byte_arr_b);
            this.var_byte_arr_b = null;
            this.var_bev_a.a(1, byArray);
        }
    }

    public void c(byte[] byArray) {
        if (byArray != null) {
            this.a(byArray, this.var_byte_arr_c);
            this.var_byte_arr_c = null;
            this.var_bev_a.a(3, byArray);
        }
    }

    public void a(char[] cArray) {
        if (cArray != null) {
            this.a(cArray, this.var_char_arr_a);
            this.var_char_arr_a = null;
            this.var_bev_a.a(0, cArray);
        }
    }

    public void b(char[] cArray) {
        if (cArray != null) {
            this.a(cArray, this.var_char_arr_b);
            this.var_char_arr_b = null;
            this.var_bev_a.a(1, cArray);
        }
    }

    public void c(char[] cArray) {
        if (cArray != null) {
            this.a(cArray, this.var_char_arr_c);
            this.var_char_arr_c = null;
            this.var_bev_a.a(3, cArray);
        }
    }

    protected final void a(Object object) {
        if (object != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    protected final void a(byte[] byArray, byte[] byArray2) {
        if (byArray != byArray2 && byArray.length < byArray2.length) {
            throw this.java_lang_Object_a();
        }
    }

    protected final void a(char[] cArray, char[] cArray2) {
        if (cArray != cArray2 && cArray.length < cArray2.length) {
            throw this.java_lang_Object_a();
        }
    }

    private IllegalArgumentException java_lang_IllegalArgumentException_a() {
        return new IllegalArgumentException("Trying to release buffer smaller than original");
    }
}

