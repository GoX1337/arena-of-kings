/*
 * Decompiled with CFR 0.152.
 */
public final class bwu {
    public static final int[][] var_int_arr_arr_a;
    private int var_int_c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean var_boolean_a;
    private boolean var_boolean_b;
    private double[] var_double_arr_a = new double[]{-1.0, 384.0, 1152.0, 1152.0};
    private boolean var_boolean_c;
    private int m;
    private int n;
    private int o;
    private byte[] var_byte_arr_a;
    private byte var_byte_a = bwp.var_byte_a;
    private bwr var_bwr_a;
    public short var_short_a;
    public int var_int_a;
    public int var_int_b;
    private int p = -1;
    private static final int[][][] var_int_arr_arr_arr_a;
    private static final String[][][] var_java_lang_String_arr_arr_arr_a;

    bwu() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("Layer ");
        stringBuffer.append(this.java_lang_String_a());
        stringBuffer.append(" frame ");
        stringBuffer.append(this.java_lang_String_d());
        stringBuffer.append(' ');
        stringBuffer.append(this.java_lang_String_e());
        if (!this.boolean_a()) {
            stringBuffer.append(" no");
        }
        stringBuffer.append(" checksums");
        stringBuffer.append(' ');
        stringBuffer.append(this.java_lang_String_c());
        stringBuffer.append(',');
        stringBuffer.append(' ');
        stringBuffer.append(this.java_lang_String_b());
        String string = stringBuffer.toString();
        return string;
    }

    void a(bwp bwp2, bwr[] bwrArray) {
        int n2;
        boolean bl2 = false;
        do {
            this.p = n2 = bwp2.a(this.var_byte_a);
            if (this.var_byte_a == bwp.var_byte_a) {
                this.h = n2 >>> 19 & 1;
                if ((n2 >>> 20 & 1) == 0) {
                    if (this.h == 0) {
                        this.h = 2;
                    } else {
                        throw bwp2.bwq_a(256);
                    }
                }
                if ((this.j = n2 >>> 10 & 3) == 3) {
                    throw bwp2.bwq_a(256);
                }
            }
            this.var_int_c = 4 - (n2 >>> 17) & 3;
            this.d = n2 >>> 16 & 1;
            this.e = n2 >>> 12 & 0xF;
            this.f = n2 >>> 9 & 1;
            this.i = n2 >>> 6 & 3;
            this.g = n2 >>> 4 & 3;
            this.l = this.i == 1 ? (this.g << 2) + 4 : 0;
            if ((n2 >>> 3 & 1) == 1) {
                this.var_boolean_a = true;
            }
            if ((n2 >>> 2 & 1) == 1) {
                this.var_boolean_b = true;
            }
            if (this.var_int_c == 1) {
                this.k = 32;
            } else {
                int n3 = this.e;
                if (this.i != 3) {
                    n3 = n3 == 4 ? 1 : (n3 -= 4);
                }
                this.k = n3 == 1 || n3 == 2 ? (this.j == 2 ? 12 : 8) : (this.j == 1 || n3 >= 3 && n3 <= 5 ? 27 : 30);
            }
            if (this.l > this.k) {
                this.l = this.k;
            }
            this.i();
            int n4 = bwp2.int_a(this.var_int_a);
            if (this.var_int_a >= 0 && n4 != this.var_int_a) {
                throw bwp2.bwq_a(261);
            }
            if (bwp2.boolean_a((int)this.var_byte_a)) {
                if (this.var_byte_a == bwp.var_byte_a) {
                    this.var_byte_a = bwp.var_byte_b;
                    bwp2.void_a(n2 & 0xFFF80CC0);
                }
                bl2 = true;
                continue;
            }
            bwp2.void_b();
        } while (!bl2);
        bwp2.d();
        if (this.d == 0) {
            this.var_short_a = (short)bwp2.b(16);
            if (this.var_bwr_a == null) {
                this.var_bwr_a = new bwr();
            }
            this.var_bwr_a.a(n2, 16);
            bwrArray[0] = this.var_bwr_a;
        } else {
            bwrArray[0] = null;
        }
        if (this.j == 0) {
            // empty if block
        }
    }

    void a(byte[] byArray) {
        String string = "Xing";
        byte[] byArray2 = new byte[4];
        int n2 = 0;
        n2 = this.h == 1 ? (this.i == 3 ? 17 : 32) : (this.i == 3 ? 9 : 17);
        try {
            System.arraycopy(byArray, n2, byArray2, 0, 4);
            if (string.equals(new String(byArray2))) {
                this.var_boolean_c = true;
                this.m = -1;
                this.o = -1;
                this.n = -1;
                this.var_byte_arr_a = new byte[100];
                int n3 = 4;
                byte[] byArray3 = new byte[4];
                System.arraycopy(byArray, n2 + n3, byArray3, 0, byArray3.length);
                n3 += byArray3.length;
                if ((byArray3[3] & 1) != 0) {
                    System.arraycopy(byArray, n2 + n3, byArray2, 0, byArray2.length);
                    this.m = byArray2[0] << 24 & 0xFF000000 | byArray2[1] << 16 & 0xFF0000 | byArray2[2] << 8 & 0xFF00 | byArray2[3] & 0xFF;
                    n3 += 4;
                }
                if ((byArray3[3] & 2) != 0) {
                    System.arraycopy(byArray, n2 + n3, byArray2, 0, byArray2.length);
                    this.o = byArray2[0] << 24 & 0xFF000000 | byArray2[1] << 16 & 0xFF0000 | byArray2[2] << 8 & 0xFF00 | byArray2[3] & 0xFF;
                    n3 += 4;
                }
                if ((byArray3[3] & 4) != 0) {
                    System.arraycopy(byArray, n2 + n3, this.var_byte_arr_a, 0, this.var_byte_arr_a.length);
                    n3 += this.var_byte_arr_a.length;
                }
                if ((byArray3[3] & 8) != 0) {
                    System.arraycopy(byArray, n2 + n3, byArray2, 0, byArray2.length);
                    this.n = byArray2[0] << 24 & 0xFF000000 | byArray2[1] << 16 & 0xFF0000 | byArray2[2] << 8 & 0xFF00 | byArray2[3] & 0xFF;
                    n3 += 4;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new bwq("XingVBRHeader Corrupted", (Throwable)arrayIndexOutOfBoundsException);
        }
        String string2 = "VBRI";
        n2 = 32;
        try {
            System.arraycopy(byArray, n2, byArray2, 0, 4);
            if (string2.equals(new String(byArray2))) {
                this.var_boolean_c = true;
                this.m = -1;
                this.o = -1;
                this.n = -1;
                this.var_byte_arr_a = new byte[100];
                int n4 = 10;
                System.arraycopy(byArray, n2 + n4, byArray2, 0, byArray2.length);
                this.o = byArray2[0] << 24 & 0xFF000000 | byArray2[1] << 16 & 0xFF0000 | byArray2[2] << 8 & 0xFF00 | byArray2[3] & 0xFF;
                System.arraycopy(byArray, n2 + (n4 += 4), byArray2, 0, byArray2.length);
                this.m = byArray2[0] << 24 & 0xFF000000 | byArray2[1] << 16 & 0xFF0000 | byArray2[2] << 8 & 0xFF00 | byArray2[3] & 0xFF;
                n4 += 4;
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new bwq("VBRIVBRHeader Corrupted", (Throwable)arrayIndexOutOfBoundsException);
        }
    }

    public int int_a() {
        return this.h;
    }

    public int int_b() {
        return this.var_int_c;
    }

    public int int_c() {
        return this.e;
    }

    public int int_d() {
        return this.j;
    }

    public int int_e() {
        return var_int_arr_arr_a[this.h][this.j];
    }

    public int f() {
        return this.i;
    }

    public boolean boolean_a() {
        return this.d == 0;
    }

    public boolean boolean_b() {
        return this.var_short_a == this.var_bwr_a.a();
    }

    public int g() {
        return this.var_int_b;
    }

    public int h() {
        return this.g;
    }

    public int i() {
        if (this.var_int_c == 1) {
            this.var_int_a = 12 * var_int_arr_arr_arr_a[this.h][0][this.e] / var_int_arr_arr_a[this.h][this.j];
            if (this.f != 0) {
                ++this.var_int_a;
            }
            this.var_int_a <<= 2;
            this.var_int_b = 0;
        } else {
            this.var_int_a = 144 * var_int_arr_arr_arr_a[this.h][this.var_int_c - 1][this.e] / var_int_arr_arr_a[this.h][this.j];
            if (this.h == 0 || this.h == 2) {
                this.var_int_a >>= 1;
            }
            if (this.f != 0) {
                ++this.var_int_a;
            }
            this.var_int_b = this.var_int_c == 3 ? (this.h == 1 ? this.var_int_a - (this.i == 3 ? 17 : 32) - (this.d != 0 ? 0 : 2) - 4 : this.var_int_a - (this.i == 3 ? 9 : 17) - (this.d != 0 ? 0 : 2) - 4) : 0;
        }
        this.var_int_a -= 4;
        return this.var_int_a;
    }

    public float float_a() {
        if (this.var_boolean_c) {
            double d2 = this.var_double_arr_a[this.int_b()] / (double)this.int_e();
            if (this.h == 0 || this.h == 2) {
                d2 /= 2.0;
            }
            return (float)(d2 * 1000.0);
        }
        float[][] fArrayArray = new float[][]{{8.707483f, 8.0f, 12.0f}, {26.12245f, 24.0f, 36.0f}, {26.12245f, 24.0f, 36.0f}};
        return fArrayArray[this.var_int_c - 1][this.j];
    }

    public String java_lang_String_a() {
        switch (this.var_int_c) {
            case 1: {
                return "I";
            }
            case 2: {
                return "II";
            }
            case 3: {
                return "III";
            }
        }
        return null;
    }

    public String java_lang_String_b() {
        if (this.var_boolean_c) {
            return Integer.toString(this.j() / 1000) + " kb/s";
        }
        return var_java_lang_String_arr_arr_arr_a[this.h][this.var_int_c - 1][this.e];
    }

    public int j() {
        if (this.var_boolean_c) {
            return (int)((float)(this.o * 8) / (this.float_a() * (float)this.m)) * 1000;
        }
        return var_int_arr_arr_arr_a[this.h][this.var_int_c - 1][this.e];
    }

    public String java_lang_String_c() {
        switch (this.j) {
            case 2: {
                if (this.h == 1) {
                    return "32 kHz";
                }
                if (this.h == 0) {
                    return "16 kHz";
                }
                return "8 kHz";
            }
            case 0: {
                if (this.h == 1) {
                    return "44.1 kHz";
                }
                if (this.h == 0) {
                    return "22.05 kHz";
                }
                return "11.025 kHz";
            }
            case 1: {
                if (this.h == 1) {
                    return "48 kHz";
                }
                if (this.h == 0) {
                    return "24 kHz";
                }
                return "12 kHz";
            }
        }
        return null;
    }

    public int k() {
        switch (this.j) {
            case 2: {
                if (this.h == 1) {
                    return 32000;
                }
                if (this.h == 0) {
                    return 16000;
                }
                return 8000;
            }
            case 0: {
                if (this.h == 1) {
                    return 44100;
                }
                if (this.h == 0) {
                    return 22050;
                }
                return 11025;
            }
            case 1: {
                if (this.h == 1) {
                    return 48000;
                }
                if (this.h == 0) {
                    return 24000;
                }
                return 12000;
            }
        }
        return 0;
    }

    public String java_lang_String_d() {
        switch (this.i) {
            case 0: {
                return "Stereo";
            }
            case 1: {
                return "Joint stereo";
            }
            case 2: {
                return "Dual channel";
            }
            case 3: {
                return "Single channel";
            }
        }
        return null;
    }

    public String java_lang_String_e() {
        switch (this.h) {
            case 1: {
                return "MPEG-1";
            }
            case 0: {
                return "MPEG-2 LSF";
            }
            case 2: {
                return "MPEG-2.5 LSF";
            }
        }
        return null;
    }

    public int l() {
        return this.k;
    }

    public int m() {
        return this.l;
    }

    static {
        var_int_arr_arr_a = new int[][]{{22050, 24000, 16000, 1}, {44100, 48000, 32000, 1}, {11025, 12000, 8000, 1}};
        var_int_arr_arr_arr_a = new int[][][]{new int[][]{{0, 32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000, 0}, {0, 8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 0}, {0, 8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 0}}, new int[][]{{0, 32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000, 0}, {0, 32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000, 0}, {0, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 0}}, new int[][]{{0, 32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000, 0}, {0, 8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 0}, {0, 8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 0}}};
        var_java_lang_String_arr_arr_arr_a = new String[][][]{{{"free format", "32 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "176 kbit/s", "192 kbit/s", "224 kbit/s", "256 kbit/s", "forbidden"}, {"free format", "8 kbit/s", "16 kbit/s", "24 kbit/s", "32 kbit/s", "40 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "forbidden"}, {"free format", "8 kbit/s", "16 kbit/s", "24 kbit/s", "32 kbit/s", "40 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "forbidden"}}, {{"free format", "32 kbit/s", "64 kbit/s", "96 kbit/s", "128 kbit/s", "160 kbit/s", "192 kbit/s", "224 kbit/s", "256 kbit/s", "288 kbit/s", "320 kbit/s", "352 kbit/s", "384 kbit/s", "416 kbit/s", "448 kbit/s", "forbidden"}, {"free format", "32 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "160 kbit/s", "192 kbit/s", "224 kbit/s", "256 kbit/s", "320 kbit/s", "384 kbit/s", "forbidden"}, {"free format", "32 kbit/s", "40 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "160 kbit/s", "192 kbit/s", "224 kbit/s", "256 kbit/s", "320 kbit/s", "forbidden"}}, {{"free format", "32 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "176 kbit/s", "192 kbit/s", "224 kbit/s", "256 kbit/s", "forbidden"}, {"free format", "8 kbit/s", "16 kbit/s", "24 kbit/s", "32 kbit/s", "40 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "forbidden"}, {"free format", "8 kbit/s", "16 kbit/s", "24 kbit/s", "32 kbit/s", "40 kbit/s", "48 kbit/s", "56 kbit/s", "64 kbit/s", "80 kbit/s", "96 kbit/s", "112 kbit/s", "128 kbit/s", "144 kbit/s", "160 kbit/s", "forbidden"}}};
    }
}

