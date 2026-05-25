/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.atomic.AtomicReferenceArray;

public class bev {
    private static final int[] var_int_arr_a;
    private static final int[] var_int_arr_b;
    protected final AtomicReferenceArray<byte[]> var_java_util_concurrent_atomic_AtomicReferenceArray_byte_arr__a;
    protected final AtomicReferenceArray<char[]> var_java_util_concurrent_atomic_AtomicReferenceArray_char_arr__b;

    public bev() {
        this(4, 4);
    }

    protected bev(int n2, int n3) {
        this.var_int_arr_a = (int[])new AtomicReferenceArray(n2);
        this.var_int_arr_b = (int[])new AtomicReferenceArray(n3);
    }

    public final byte[] byte_arr_a(int n2) {
        return this.byte_arr_a(n2, 0);
    }

    public byte[] byte_arr_a(int n2, int n3) {
        byte[] byArray;
        int n4 = this.int_a(n2);
        if (n3 < n4) {
            n3 = n4;
        }
        if ((byArray = (byte[])this.var_int_arr_a.getAndSet(n2, null)) == null || byArray.length < n3) {
            byArray = this.byte_arr_b(n3);
        }
        return byArray;
    }

    public void a(int n2, byte[] byArray) {
        this.var_int_arr_a.set(n2, byArray);
    }

    public final char[] char_arr_a(int n2) {
        return this.char_arr_a(n2, 0);
    }

    public char[] char_arr_a(int n2, int n3) {
        char[] cArray;
        int n4 = this.int_b(n2);
        if (n3 < n4) {
            n3 = n4;
        }
        if ((cArray = (char[])this.var_int_arr_b.getAndSet(n2, null)) == null || cArray.length < n3) {
            cArray = this.char_arr_b(n3);
        }
        return cArray;
    }

    public void a(int n2, char[] cArray) {
        this.var_int_arr_b.set(n2, cArray);
    }

    protected int int_a(int n2) {
        return var_int_arr_a[n2];
    }

    protected int int_b(int n2) {
        return var_int_arr_b[n2];
    }

    protected byte[] byte_arr_b(int n2) {
        return new byte[n2];
    }

    protected char[] char_arr_b(int n2) {
        return new char[n2];
    }

    static {
        var_int_arr_a = new int[]{8000, 8000, 2000, 2000};
        var_int_arr_b = new int[]{4000, 4000, 200, 200};
    }
}

