/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

public final class bes {
    protected final bes var_bes_a;
    protected final AtomicReference<b> var_java_util_concurrent_atomic_AtomicReference_bes$b__a;
    protected final int var_int_a;
    protected final int var_int_b;
    protected boolean var_boolean_a;
    protected String[] var_java_lang_String_arr_a;
    protected a[] var_bes$a_arr_a;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected boolean var_boolean_b;
    protected BitSet var_java_util_BitSet_a;

    private bes(int n2) {
        this.var_bes_a = null;
        this.var_int_a = n2;
        this.var_boolean_a = true;
        this.var_int_b = -1;
        this.var_boolean_b = false;
        this.f = 0;
        this.var_bes_a = new AtomicReference<b>(bes$b.a(64));
    }

    private bes(bes bes2, int n2, int n3, b b2) {
        this.var_bes_a = bes2;
        this.var_int_a = n3;
        this.var_bes_a = null;
        this.var_int_b = n2;
        this.var_boolean_a = bcw.a.b.a(n2);
        this.var_java_lang_String_arr_a = b2.var_java_lang_String_arr_a;
        this.var_bes$a_arr_a = b2.var_bes$a_arr_a;
        this.c = b2.var_int_a;
        this.f = b2.b;
        int n4 = this.var_java_lang_String_arr_a.length;
        this.d = bes.int_b(n4);
        this.e = n4 - 1;
        this.var_boolean_b = true;
    }

    private static int int_b(int n2) {
        return n2 - (n2 >> 2);
    }

    public static bes bes_a() {
        long l2 = System.currentTimeMillis();
        int n2 = (int)l2 + (int)(l2 >>> 32) | 1;
        return bes.bes_a(n2);
    }

    protected static bes bes_a(int n2) {
        return new bes(n2);
    }

    public bes bes_b(int n2) {
        return new bes(this, n2, this.var_int_a, (b)((AtomicReference)((Object)this.var_bes_a)).get());
    }

    public void void_a() {
        if (!this.boolean_a()) {
            return;
        }
        if (this.var_bes_a != null && this.var_boolean_a) {
            this.var_bes_a.a(new b(this));
            this.var_boolean_b = true;
        }
    }

    private void a(b b2) {
        int n2 = b2.var_int_a;
        b b3 = (b)((AtomicReference)((Object)this.var_bes_a)).get();
        if (n2 == b3.var_int_a) {
            return;
        }
        if (n2 > 12000) {
            b2 = bes$b.a(64);
        }
        ((AtomicReference)((Object)this.var_bes_a)).compareAndSet(b3, b2);
    }

    public boolean boolean_a() {
        return !this.var_boolean_b;
    }

    public int int_a() {
        return this.var_int_a;
    }

    public String a(char[] cArray, int n2, int n3, int n4) {
        if (n3 < 1) {
            return "";
        }
        if (!this.var_boolean_a) {
            return new String(cArray, n2, n3);
        }
        int n5 = this.int_a(n4);
        String string = this.var_java_lang_String_arr_a[n5];
        if (string != null) {
            a a2;
            if (string.length() == n3) {
                int n6 = 0;
                while (string.charAt(n6) == cArray[n2 + n6]) {
                    if (++n6 != n3) continue;
                    return string;
                }
            }
            if ((a2 = this.var_bes$a_arr_a[n5 >> 1]) != null) {
                string = a2.a(cArray, n2, n3);
                if (string != null) {
                    return string;
                }
                string = this.a(cArray, n2, n3, a2.var_bes$a_a);
                if (string != null) {
                    return string;
                }
            }
        }
        return this.a(cArray, n2, n3, n4, n5);
    }

    private String a(char[] cArray, int n2, int n3, a a2) {
        while (a2 != null) {
            String string = a2.a(cArray, n2, n3);
            if (string != null) {
                return string;
            }
            a2 = a2.var_bes$a_a;
        }
        return null;
    }

    private String a(char[] cArray, int n2, int n3, int n4, int n5) {
        if (this.var_boolean_b) {
            this.b();
            this.var_boolean_b = false;
        } else if (this.c >= this.d) {
            this.c();
            n5 = this.int_a(this.a(cArray, n2, n3));
        }
        String string = new String(cArray, n2, n3);
        if (bcw.a.var_bcw$a_a.a(this.var_int_b)) {
            string = bfb.var_bfb_a.a(string);
        }
        ++this.c;
        if (this.var_java_lang_String_arr_a[n5] == null) {
            this.var_java_lang_String_arr_a[n5] = string;
        } else {
            int n6 = n5 >> 1;
            a a2 = new a(string, this.var_bes$a_arr_a[n6]);
            int n7 = a2.var_int_a;
            if (n7 > 100) {
                this.a(n6, a2, n5);
            } else {
                this.var_bes$a_arr_a[n6] = a2;
                this.f = Math.max(n7, this.f);
            }
        }
        return string;
    }

    private void a(int n2, a a2, int n3) {
        if (this.var_java_util_BitSet_a == null) {
            this.var_java_util_BitSet_a = new BitSet();
            this.var_java_util_BitSet_a.set(n2);
        } else if (this.var_java_util_BitSet_a.get(n2)) {
            if (bcw.a.c.a(this.var_int_b)) {
                this.void_a(100);
            }
            this.var_boolean_a = false;
        } else {
            this.var_java_util_BitSet_a.set(n2);
        }
        this.var_java_lang_String_arr_a[n3] = a2.var_java_lang_String_a;
        this.var_bes$a_arr_a[n2] = null;
        this.c -= a2.var_int_a;
        this.f = -1;
    }

    public int int_a(int n2) {
        n2 += n2 >>> 15;
        n2 ^= n2 << 7;
        n2 += n2 >>> 3;
        return n2 & this.e;
    }

    public int a(char[] cArray, int n2, int n3) {
        int n4 = this.var_int_a;
        int n5 = n2 + n3;
        for (int i2 = n2; i2 < n5; ++i2) {
            n4 = n4 * 33 + cArray[i2];
        }
        return n4 == 0 ? 1 : n4;
    }

    public int a(String string) {
        int n2 = string.length();
        int n3 = this.var_int_a;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 = n3 * 33 + string.charAt(i2);
        }
        return n3 == 0 ? 1 : n3;
    }

    private void b() {
        String[] stringArray = this.var_java_lang_String_arr_a;
        this.var_java_lang_String_arr_a = Arrays.copyOf(stringArray, stringArray.length);
        a[] aArray = this.var_bes$a_arr_a;
        this.var_bes$a_arr_a = Arrays.copyOf(aArray, aArray.length);
    }

    private void c() {
        int n2;
        int n3 = this.var_java_lang_String_arr_a.length;
        int n4 = n3 + n3;
        if (n4 > 65536) {
            this.c = 0;
            this.var_boolean_a = false;
            this.var_java_lang_String_arr_a = new String[64];
            this.var_bes$a_arr_a = new a[32];
            this.e = 63;
            this.var_boolean_b = false;
            return;
        }
        String[] stringArray = this.var_java_lang_String_arr_a;
        a[] aArray = this.var_bes$a_arr_a;
        this.var_java_lang_String_arr_a = new String[n4];
        this.var_bes$a_arr_a = new a[n4 >> 1];
        this.e = n4 - 1;
        this.d = bes.int_b(n4);
        int n5 = 0;
        int n6 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            a a2;
            String string = stringArray[n2];
            if (string == null) continue;
            ++n5;
            int n7 = this.int_a(this.a(string));
            if (this.var_java_lang_String_arr_a[n7] == null) {
                this.var_java_lang_String_arr_a[n7] = string;
                continue;
            }
            int n8 = n7 >> 1;
            this.var_bes$a_arr_a[n8] = a2 = new a(string, this.var_bes$a_arr_a[n8]);
            n6 = Math.max(n6, a2.var_int_a);
        }
        n2 = n3 >> 1;
        for (int i2 = 0; i2 < n2; ++i2) {
            a a3 = aArray[i2];
            while (a3 != null) {
                ++n5;
                String string = a3.var_java_lang_String_a;
                int n9 = this.int_a(this.a(string));
                if (this.var_java_lang_String_arr_a[n9] == null) {
                    this.var_java_lang_String_arr_a[n9] = string;
                } else {
                    a a4;
                    int n10 = n9 >> 1;
                    this.var_bes$a_arr_a[n10] = a4 = new a(string, this.var_bes$a_arr_a[n10]);
                    n6 = Math.max(n6, a4.var_int_a);
                }
                a3 = a3.var_bes$a_a;
            }
        }
        this.f = n6;
        this.var_java_util_BitSet_a = null;
        if (n5 != this.c) {
            throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", this.c, n5));
        }
    }

    protected void void_a(int n2) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.c + ") now exceeds maximum, " + n2 + " -- suspect a DoS attack based on hash collisions");
    }

    static final class b {
        final int var_int_a;
        final int b;
        final String[] var_java_lang_String_arr_a;
        final a[] var_bes$a_arr_a;

        public b(int n2, int n3, String[] stringArray, a[] aArray) {
            this.var_int_a = n2;
            this.b = n3;
            this.var_java_lang_String_arr_a = stringArray;
            this.var_bes$a_arr_a = aArray;
        }

        public b(bes bes2) {
            this.var_int_a = bes2.c;
            this.b = bes2.f;
            this.var_java_lang_String_arr_a = bes2.var_java_lang_String_arr_a;
            this.var_bes$a_arr_a = bes2.var_bes$a_arr_a;
        }

        public static b a(int n2) {
            return new b(0, 0, new String[n2], new a[n2 >> 1]);
        }
    }

    static final class a {
        public final String var_java_lang_String_a;
        public final a var_bes$a_a;
        public final int var_int_a;

        public a(String string, a a2) {
            this.var_java_lang_String_a = string;
            this.var_bes$a_a = a2;
            this.var_int_a = a2 == null ? 1 : a2.var_int_a + 1;
        }

        public String a(char[] cArray, int n2, int n3) {
            if (this.var_java_lang_String_a.length() != n3) {
                return null;
            }
            int n4 = 0;
            do {
                if (this.var_java_lang_String_a.charAt(n4) == cArray[n2 + n4]) continue;
                return null;
            } while (++n4 < n3);
            return this.var_java_lang_String_a;
        }
    }
}

