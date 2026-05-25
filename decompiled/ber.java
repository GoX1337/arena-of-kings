/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class ber {
    protected final ber var_ber_a;
    protected final AtomicReference<a> var_java_util_concurrent_atomic_AtomicReference_ber$a__a;
    protected final int var_int_a;
    protected boolean var_boolean_a;
    protected final boolean var_boolean_b;
    protected int[] var_int_arr_a;
    protected int var_int_b;
    protected int var_int_c;
    protected int d;
    protected int e;
    protected int f;
    protected String[] var_java_lang_String_arr_a;
    protected int g;
    protected int h;
    protected boolean var_boolean_c;

    private ber(int n2, boolean bl2, int n3, boolean bl3) {
        this.var_ber_a = null;
        this.var_int_a = n3;
        this.var_boolean_a = bl2;
        this.var_boolean_b = bl3;
        if (n2 < 16) {
            n2 = 16;
        } else if ((n2 & n2 - 1) != 0) {
            int n4;
            for (n4 = 16; n4 < n2; n4 += n4) {
            }
            n2 = n4;
        }
        this.var_ber_a = new AtomicReference<a>(ber$a.a(n2));
    }

    private ber(ber ber2, boolean bl2, int n2, boolean bl3, a a2) {
        this.var_ber_a = ber2;
        this.var_int_a = n2;
        this.var_boolean_a = bl2;
        this.var_boolean_b = bl3;
        this.var_ber_a = null;
        this.f = a2.b;
        this.var_int_b = a2.var_int_a;
        this.var_int_c = this.var_int_b << 2;
        this.d = this.var_int_c + (this.var_int_c >> 1);
        this.e = a2.c;
        this.var_int_arr_a = a2.var_int_arr_a;
        this.var_java_lang_String_arr_a = a2.var_java_lang_String_arr_a;
        this.g = a2.d;
        this.h = a2.e;
        this.var_boolean_c = true;
    }

    public static ber ber_a() {
        long l2 = System.currentTimeMillis();
        int n2 = (int)l2 + (int)(l2 >>> 32) | 1;
        return ber.ber_a(n2);
    }

    protected static ber ber_a(int n2) {
        return new ber(64, true, n2, true);
    }

    public ber ber_b(int n2) {
        return new ber(this, bcw.a.var_bcw$a_a.a(n2), this.var_int_a, bcw.a.c.a(n2), (a)((AtomicReference)((Object)this.var_ber_a)).get());
    }

    public void void_a() {
        if (this.var_ber_a != null && this.boolean_a()) {
            this.var_ber_a.a(new a(this));
            this.var_boolean_c = true;
        }
    }

    private void a(a a2) {
        int n2 = a2.b;
        a a3 = (a)((AtomicReference)((Object)this.var_ber_a)).get();
        if (n2 == a3.b) {
            return;
        }
        if (n2 > 6000) {
            a2 = ber$a.a(64);
        }
        ((AtomicReference)((Object)this.var_ber_a)).compareAndSet(a3, a2);
    }

    public boolean boolean_a() {
        return !this.var_boolean_c;
    }

    public int int_a() {
        int n2 = 0;
        int n3 = this.var_int_c;
        for (int i2 = 3; i2 < n3; i2 += 4) {
            if (this.var_int_arr_a[i2] == 0) continue;
            ++n2;
        }
        return n2;
    }

    public int int_b() {
        int n2 = 0;
        int n3 = this.d;
        for (int i2 = this.var_int_c + 3; i2 < n3; i2 += 4) {
            if (this.var_int_arr_a[i2] == 0) continue;
            ++n2;
        }
        return n2;
    }

    public int int_c() {
        int n2;
        int n3 = 0;
        int n4 = n2 + this.var_int_b;
        for (n2 = this.d + 3; n2 < n4; n2 += 4) {
            if (this.var_int_arr_a[n2] == 0) continue;
            ++n3;
        }
        return n3;
    }

    public int int_d() {
        return this.g - this.f() >> 2;
    }

    public int e() {
        int n2 = 0;
        int n3 = this.var_int_b << 3;
        for (int i2 = 3; i2 < n3; i2 += 4) {
            if (this.var_int_arr_a[i2] == 0) continue;
            ++n2;
        }
        return n2;
    }

    public String toString() {
        int n2 = this.int_a();
        int n3 = this.int_b();
        int n4 = this.int_c();
        int n5 = this.int_d();
        int n6 = this.e();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", this.getClass().getName(), this.f, this.var_int_b, n2, n3, n4, n5, n2 + n3 + n4 + n5, n6);
    }

    public String java_lang_String_a(int n2) {
        int n3;
        int[] nArray = this.var_int_arr_a;
        int n4 = this.c(this.int_a(n2));
        int n5 = nArray[n4 + 3];
        if (n5 == 1) {
            if (nArray[n4] == n2) {
                return this.var_java_lang_String_arr_a[n4 >> 2];
            }
        } else if (n5 == 0) {
            return null;
        }
        if ((n5 = nArray[(n3 = this.var_int_c + (n4 >> 3 << 2)) + 3]) == 1) {
            if (nArray[n3] == n2) {
                return this.var_java_lang_String_arr_a[n3 >> 2];
            }
        } else if (n5 == 0) {
            return null;
        }
        return this.b(n4, n2);
    }

    public String java_lang_String_a(int n2, int n3) {
        int n4;
        int[] nArray = this.var_int_arr_a;
        int n5 = this.c(this.int_a(n2, n3));
        int n6 = nArray[n5 + 3];
        if (n6 == 2) {
            if (n2 == nArray[n5] && n3 == nArray[n5 + 1]) {
                return this.var_java_lang_String_arr_a[n5 >> 2];
            }
        } else if (n6 == 0) {
            return null;
        }
        if ((n6 = nArray[(n4 = this.var_int_c + (n5 >> 3 << 2)) + 3]) == 2) {
            if (n2 == nArray[n4] && n3 == nArray[n4 + 1]) {
                return this.var_java_lang_String_arr_a[n4 >> 2];
            }
        } else if (n6 == 0) {
            return null;
        }
        return this.b(n5, n2, n3);
    }

    public String java_lang_String_a(int n2, int n3, int n4) {
        int n5;
        int[] nArray = this.var_int_arr_a;
        int n6 = this.c(this.int_a(n2, n3, n4));
        int n7 = nArray[n6 + 3];
        if (n7 == 3) {
            if (n2 == nArray[n6] && nArray[n6 + 1] == n3 && nArray[n6 + 2] == n4) {
                return this.var_java_lang_String_arr_a[n6 >> 2];
            }
        } else if (n7 == 0) {
            return null;
        }
        if ((n7 = nArray[(n5 = this.var_int_c + (n6 >> 3 << 2)) + 3]) == 3) {
            if (n2 == nArray[n5] && nArray[n5 + 1] == n3 && nArray[n5 + 2] == n4) {
                return this.var_java_lang_String_arr_a[n5 >> 2];
            }
        } else if (n7 == 0) {
            return null;
        }
        return this.a(n6, n2, n3, n4);
    }

    public String java_lang_String_a(int[] nArray, int n2) {
        if (n2 < 4) {
            switch (n2) {
                case 3: {
                    return this.java_lang_String_a(nArray[0], nArray[1], nArray[2]);
                }
                case 2: {
                    return this.java_lang_String_a(nArray[0], nArray[1]);
                }
                case 1: {
                    return this.java_lang_String_a(nArray[0]);
                }
            }
            return "";
        }
        int n3 = this.int_a(nArray, n2);
        int n4 = this.c(n3);
        int[] nArray2 = this.var_int_arr_a;
        int n5 = nArray2[n4 + 3];
        if (n3 == nArray2[n4] && n5 == n2 && this.a(nArray, n2, nArray2[n4 + 1])) {
            return this.var_java_lang_String_arr_a[n4 >> 2];
        }
        if (n5 == 0) {
            return null;
        }
        int n6 = this.var_int_c + (n4 >> 3 << 2);
        int n7 = nArray2[n6 + 3];
        if (n3 == nArray2[n6] && n7 == n2 && this.a(nArray, n2, nArray2[n6 + 1])) {
            return this.var_java_lang_String_arr_a[n6 >> 2];
        }
        return this.a(n4, n3, nArray, n2);
    }

    private final int c(int n2) {
        int n3 = n2 & this.var_int_b - 1;
        return n3 << 2;
    }

    private String b(int n2, int n3) {
        int n4;
        int[] nArray = this.var_int_arr_a;
        int n5 = 1 << this.e;
        int n6 = n4 + n5;
        for (n4 = this.d + (n2 >> this.e + 2 << this.e); n4 < n6; n4 += 4) {
            int n7 = nArray[n4 + 3];
            if (n3 == nArray[n4] && 1 == n7) {
                return this.var_java_lang_String_arr_a[n4 >> 2];
            }
            if (n7 != 0) continue;
            return null;
        }
        for (n4 = this.f(); n4 < this.g; n4 += 4) {
            if (n3 != nArray[n4] || 1 != nArray[n4 + 3]) continue;
            return this.var_java_lang_String_arr_a[n4 >> 2];
        }
        return null;
    }

    private String b(int n2, int n3, int n4) {
        int n5;
        int[] nArray = this.var_int_arr_a;
        int n6 = 1 << this.e;
        int n7 = n5 + n6;
        for (n5 = this.d + (n2 >> this.e + 2 << this.e); n5 < n7; n5 += 4) {
            int n8 = nArray[n5 + 3];
            if (n3 == nArray[n5] && n4 == nArray[n5 + 1] && 2 == n8) {
                return this.var_java_lang_String_arr_a[n5 >> 2];
            }
            if (n8 != 0) continue;
            return null;
        }
        for (n5 = this.f(); n5 < this.g; n5 += 4) {
            if (n3 != nArray[n5] || n4 != nArray[n5 + 1] || 2 != nArray[n5 + 3]) continue;
            return this.var_java_lang_String_arr_a[n5 >> 2];
        }
        return null;
    }

    private String a(int n2, int n3, int n4, int n5) {
        int n6;
        int[] nArray = this.var_int_arr_a;
        int n7 = 1 << this.e;
        int n8 = n6 + n7;
        for (n6 = this.d + (n2 >> this.e + 2 << this.e); n6 < n8; n6 += 4) {
            int n9 = nArray[n6 + 3];
            if (n3 == nArray[n6] && n4 == nArray[n6 + 1] && n5 == nArray[n6 + 2] && 3 == n9) {
                return this.var_java_lang_String_arr_a[n6 >> 2];
            }
            if (n9 != 0) continue;
            return null;
        }
        for (n6 = this.f(); n6 < this.g; n6 += 4) {
            if (n3 != nArray[n6] || n4 != nArray[n6 + 1] || n5 != nArray[n6 + 2] || 3 != nArray[n6 + 3]) continue;
            return this.var_java_lang_String_arr_a[n6 >> 2];
        }
        return null;
    }

    private String a(int n2, int n3, int[] nArray, int n4) {
        int n5;
        int[] nArray2 = this.var_int_arr_a;
        int n6 = 1 << this.e;
        int n7 = n5 + n6;
        for (n5 = this.d + (n2 >> this.e + 2 << this.e); n5 < n7; n5 += 4) {
            int n8 = nArray2[n5 + 3];
            if (n3 == nArray2[n5] && n4 == n8 && this.a(nArray, n4, nArray2[n5 + 1])) {
                return this.var_java_lang_String_arr_a[n5 >> 2];
            }
            if (n8 != 0) continue;
            return null;
        }
        for (n5 = this.f(); n5 < this.g; n5 += 4) {
            if (n3 != nArray2[n5] || n4 != nArray2[n5 + 3] || !this.a(nArray, n4, nArray2[n5 + 1])) continue;
            return this.var_java_lang_String_arr_a[n5 >> 2];
        }
        return null;
    }

    private boolean a(int[] nArray, int n2, int n3) {
        int[] nArray2 = this.var_int_arr_a;
        int n4 = 0;
        switch (n2) {
            default: {
                return this.b(nArray, n2, n3);
            }
            case 8: {
                if (nArray[n4++] != nArray2[n3++]) {
                    return false;
                }
            }
            case 7: {
                if (nArray[n4++] != nArray2[n3++]) {
                    return false;
                }
            }
            case 6: {
                if (nArray[n4++] != nArray2[n3++]) {
                    return false;
                }
            }
            case 5: {
                if (nArray[n4++] == nArray2[n3++]) break;
                return false;
            }
            case 4: 
        }
        if (nArray[n4++] != nArray2[n3++]) {
            return false;
        }
        if (nArray[n4++] != nArray2[n3++]) {
            return false;
        }
        if (nArray[n4++] != nArray2[n3++]) {
            return false;
        }
        return nArray[n4++] == nArray2[n3++];
    }

    private boolean b(int[] nArray, int n2, int n3) {
        int n4 = 0;
        do {
            if (nArray[n4++] == this.var_int_arr_a[n3++]) continue;
            return false;
        } while (n4 < n2);
        return true;
    }

    public String a(String string, int[] nArray, int n2) {
        this.void_c();
        if (this.var_boolean_a) {
            string = bfb.var_bfb_a.a(string);
        }
        switch (n2) {
            case 1: {
                int n3 = this.d(this.int_a(nArray[0]));
                this.var_int_arr_a[n3] = nArray[0];
                this.var_int_arr_a[n3 + 3] = 1;
                break;
            }
            case 2: {
                int n3 = this.d(this.int_a(nArray[0], nArray[1]));
                this.var_int_arr_a[n3] = nArray[0];
                this.var_int_arr_a[n3 + 1] = nArray[1];
                this.var_int_arr_a[n3 + 3] = 2;
                break;
            }
            case 3: {
                int n3 = this.d(this.int_a(nArray[0], nArray[1], nArray[2]));
                this.var_int_arr_a[n3] = nArray[0];
                this.var_int_arr_a[n3 + 1] = nArray[1];
                this.var_int_arr_a[n3 + 2] = nArray[2];
                this.var_int_arr_a[n3 + 3] = 3;
                break;
            }
            default: {
                int n4;
                int n5 = this.int_a(nArray, n2);
                int n3 = this.d(n5);
                this.var_int_arr_a[n3] = n5;
                this.var_int_arr_a[n3 + 1] = n4 = this.b(nArray, n2);
                this.var_int_arr_a[n3 + 3] = n2;
            }
        }
        this.var_java_lang_String_arr_a[n3 >> 2] = string;
        ++this.f;
        return string;
    }

    private void void_c() {
        if (this.var_boolean_c) {
            this.var_int_arr_a = Arrays.copyOf(this.var_int_arr_a, this.var_int_arr_a.length);
            this.var_java_lang_String_arr_a = Arrays.copyOf(this.var_java_lang_String_arr_a, this.var_java_lang_String_arr_a.length);
            this.var_boolean_c = false;
        }
    }

    private int d(int n2) {
        int[] nArray = this.var_int_arr_a;
        int n3 = this.c(n2);
        if (nArray[n3 + 3] == 0) {
            return n3;
        }
        if (this.boolean_b()) {
            return this.e(n2);
        }
        int n4 = this.var_int_c + (n3 >> 3 << 2);
        if (nArray[n4 + 3] == 0) {
            return n4;
        }
        int n5 = 1 << this.e;
        int n6 = n4 + n5;
        for (n4 = this.d + (n3 >> this.e + 2 << this.e); n4 < n6; n4 += 4) {
            if (nArray[n4 + 3] != 0) continue;
            return n4;
        }
        n3 = this.g;
        this.g += 4;
        n6 = this.var_int_b << 3;
        if (this.g >= n6) {
            if (this.var_boolean_b) {
                this.void_b();
            }
            return this.e(n2);
        }
        return n3;
    }

    private int e(int n2) {
        this.void_d();
        int n3 = this.c(n2);
        int[] nArray = this.var_int_arr_a;
        if (nArray[n3 + 3] == 0) {
            return n3;
        }
        int n4 = this.var_int_c + (n3 >> 3 << 2);
        if (nArray[n4 + 3] == 0) {
            return n4;
        }
        int n5 = 1 << this.e;
        int n6 = n4 + n5;
        for (n4 = this.d + (n3 >> this.e + 2 << this.e); n4 < n6; n4 += 4) {
            if (nArray[n4 + 3] != 0) continue;
            return n4;
        }
        n3 = this.g;
        this.g += 4;
        return n3;
    }

    private boolean boolean_b() {
        int n2;
        return this.f > this.var_int_b >> 1 && ((n2 = this.g - this.f() >> 2) > 1 + this.f >> 7 || (double)this.f > (double)this.var_int_b * 0.8);
    }

    private int b(int[] nArray, int n2) {
        int n3 = this.h;
        if (n3 + n2 > this.var_int_arr_a.length) {
            int n4 = n3 + n2 - this.var_int_arr_a.length;
            int n5 = Math.min(4096, this.var_int_b);
            int n6 = this.var_int_arr_a.length + Math.max(n4, n5);
            this.var_int_arr_a = Arrays.copyOf(this.var_int_arr_a, n6);
        }
        System.arraycopy(nArray, 0, this.var_int_arr_a, n3, n2);
        this.h += n2;
        return n3;
    }

    public int int_a(int n2) {
        int n3 = n2 ^ this.var_int_a;
        n3 += n3 >>> 16;
        n3 ^= n3 << 3;
        n3 += n3 >>> 12;
        return n3;
    }

    public int int_a(int n2, int n3) {
        int n4 = n2;
        n4 += n4 >>> 15;
        n4 ^= n4 >>> 9;
        n4 += n3 * 33;
        n4 ^= this.var_int_a;
        n4 += n4 >>> 16;
        n4 ^= n4 >>> 4;
        n4 += n4 << 3;
        return n4;
    }

    public int int_a(int n2, int n3, int n4) {
        int n5 = n2 ^ this.var_int_a;
        n5 += n5 >>> 9;
        n5 *= 31;
        n5 += n3;
        n5 *= 33;
        n5 += n5 >>> 15;
        n5 ^= n4;
        n5 += n5 >>> 4;
        n5 += n5 >>> 15;
        n5 ^= n5 << 9;
        return n5;
    }

    public int int_a(int[] nArray, int n2) {
        if (n2 < 4) {
            throw new IllegalArgumentException();
        }
        int n3 = nArray[0] ^ this.var_int_a;
        n3 += n3 >>> 9;
        n3 += nArray[1];
        n3 += n3 >>> 15;
        n3 *= 33;
        n3 ^= nArray[2];
        n3 += n3 >>> 4;
        for (int i2 = 3; i2 < n2; ++i2) {
            int n4 = nArray[i2];
            n4 ^= n4 >> 21;
            n3 += n4;
        }
        n3 *= 65599;
        n3 += n3 >>> 19;
        n3 ^= n3 << 5;
        return n3;
    }

    private void void_d() {
        this.var_boolean_c = false;
        int[] nArray = this.var_int_arr_a;
        String[] stringArray = this.var_java_lang_String_arr_a;
        int n2 = this.var_int_b;
        int n3 = this.f;
        int n4 = n2 + n2;
        int n5 = this.g;
        if (n4 > 65536) {
            this.a(true);
            return;
        }
        this.var_int_arr_a = new int[nArray.length + (n2 << 3)];
        this.var_int_b = n4;
        this.var_int_c = n4 << 2;
        this.d = this.var_int_c + (this.var_int_c >> 1);
        this.e = ber.int_b(n4);
        this.var_java_lang_String_arr_a = new String[stringArray.length << 1];
        this.a(false);
        int n6 = 0;
        int[] nArray2 = new int[16];
        int n7 = n5;
        block5: for (int i2 = 0; i2 < n7; i2 += 4) {
            int n8 = nArray[i2 + 3];
            if (n8 == 0) continue;
            ++n6;
            String string = stringArray[i2 >> 2];
            switch (n8) {
                case 1: {
                    nArray2[0] = nArray[i2];
                    this.a(string, nArray2, 1);
                    continue block5;
                }
                case 2: {
                    nArray2[0] = nArray[i2];
                    nArray2[1] = nArray[i2 + 1];
                    this.a(string, nArray2, 2);
                    continue block5;
                }
                case 3: {
                    nArray2[0] = nArray[i2];
                    nArray2[1] = nArray[i2 + 1];
                    nArray2[2] = nArray[i2 + 2];
                    this.a(string, nArray2, 3);
                    continue block5;
                }
                default: {
                    if (n8 > nArray2.length) {
                        nArray2 = new int[n8];
                    }
                    int n9 = nArray[i2 + 1];
                    System.arraycopy(nArray, n9, nArray2, 0, n8);
                    this.a(string, nArray2, n8);
                }
            }
        }
        if (n6 != n3) {
            throw new IllegalStateException("Failed rehash(): old count=" + n3 + ", copyCount=" + n6);
        }
    }

    private void a(boolean bl2) {
        this.f = 0;
        this.g = this.f();
        this.h = this.var_int_b << 3;
        if (bl2) {
            Arrays.fill(this.var_int_arr_a, 0);
            Arrays.fill(this.var_java_lang_String_arr_a, null);
        }
    }

    private final int f() {
        int n2 = this.var_int_b;
        return (n2 << 3) - n2;
    }

    protected void void_b() {
        if (this.var_int_b <= 1024) {
            return;
        }
        throw new IllegalStateException("Spill-over slots in symbol table with " + this.f + " entries, hash area of " + this.var_int_b + " slots is now full (all " + (this.var_int_b >> 3) + " slots -- suspect a DoS attack based on hash collisions. You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
    }

    static int int_b(int n2) {
        int n3 = n2 >> 2;
        if (n3 < 64) {
            return 4;
        }
        if (n3 <= 256) {
            return 5;
        }
        if (n3 <= 1024) {
            return 6;
        }
        return 7;
    }

    static final class a {
        public final int var_int_a;
        public final int b;
        public final int c;
        public final int[] var_int_arr_a;
        public final String[] var_java_lang_String_arr_a;
        public final int d;
        public final int e;

        public a(int n2, int n3, int n4, int[] nArray, String[] stringArray, int n5, int n6) {
            this.var_int_a = n2;
            this.b = n3;
            this.c = n4;
            this.var_int_arr_a = nArray;
            this.var_java_lang_String_arr_a = stringArray;
            this.d = n5;
            this.e = n6;
        }

        public a(ber ber2) {
            this.var_int_a = ber2.var_int_b;
            this.b = ber2.f;
            this.c = ber2.e;
            this.var_int_arr_a = ber2.var_int_arr_a;
            this.var_java_lang_String_arr_a = ber2.var_java_lang_String_arr_a;
            this.d = ber2.g;
            this.e = ber2.h;
        }

        public static a a(int n2) {
            int n3 = n2 << 3;
            int n4 = ber.int_b(n2);
            return new a(n2, 0, n4, new int[n3], new String[n2 << 1], n3 - n2, n3);
        }
    }
}

