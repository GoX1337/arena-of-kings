/*
 * Decompiled with CFR 0.152.
 */
import java.io.OutputStream;
import java.util.LinkedList;

public final class bex
extends OutputStream {
    public static final byte[] var_byte_arr_a;
    private final bev var_bev_a;
    private final LinkedList<byte[]> var_java_util_LinkedList_byte_arr__a;
    private int var_int_a;
    private byte[] var_byte_arr_b;
    private int var_int_b;

    public bex() {
        this(null);
    }

    public bex(bev bev2) {
        this(bev2, 500);
    }

    public bex(int n2) {
        this(null, n2);
    }

    public bex(bev bev2, int n2) {
        this.var_byte_arr_a = (byte[])new LinkedList();
        this.var_bev_a = bev2;
        if (n2 > 131072) {
            n2 = 131072;
        }
        this.var_byte_arr_b = bev2 == null ? new byte[n2] : bev2.byte_arr_a(2);
    }

    private bex(bev bev2, byte[] byArray, int n2) {
        this.var_byte_arr_a = (byte[])new LinkedList();
        this.var_bev_a = null;
        this.var_byte_arr_b = byArray;
        this.var_int_b = n2;
    }

    public static bex a(byte[] byArray, int n2) {
        return new bex(null, byArray, n2);
    }

    public void void_a() {
        this.var_int_a = 0;
        this.var_int_b = 0;
        if (!this.var_byte_arr_a.isEmpty()) {
            this.var_byte_arr_a.clear();
        }
    }

    public void void_a(int n2) {
        if (this.var_int_b >= this.var_byte_arr_b.length) {
            this.void_b();
        }
        this.var_byte_arr_b[this.var_int_b++] = (byte)n2;
    }

    public void b(int n2) {
        if (this.var_int_b + 1 < this.var_byte_arr_b.length) {
            this.var_byte_arr_b[this.var_int_b++] = (byte)(n2 >> 8);
            this.var_byte_arr_b[this.var_int_b++] = (byte)n2;
        } else {
            this.void_a(n2 >> 8);
            this.void_a(n2);
        }
    }

    public void c(int n2) {
        if (this.var_int_b + 2 < this.var_byte_arr_b.length) {
            this.var_byte_arr_b[this.var_int_b++] = (byte)(n2 >> 16);
            this.var_byte_arr_b[this.var_int_b++] = (byte)(n2 >> 8);
            this.var_byte_arr_b[this.var_int_b++] = (byte)n2;
        } else {
            this.void_a(n2 >> 16);
            this.void_a(n2 >> 8);
            this.void_a(n2);
        }
    }

    public byte[] byte_arr_a() {
        int n2 = this.var_int_a + this.var_int_b;
        if (n2 == 0) {
            return var_byte_arr_a;
        }
        byte[] byArray = new byte[n2];
        int n3 = 0;
        for (byte[] byArray2 : this.var_byte_arr_a) {
            int n4 = byArray2.length;
            System.arraycopy(byArray2, 0, byArray, n3, n4);
            n3 += n4;
        }
        System.arraycopy(this.var_byte_arr_b, 0, byArray, n3, this.var_int_b);
        if ((n3 += this.var_int_b) != n2) {
            throw new RuntimeException("Internal error: total len assumed to be " + n2 + ", copied " + n3 + " bytes");
        }
        if (!this.var_byte_arr_a.isEmpty()) {
            this.void_a();
        }
        return byArray;
    }

    public byte[] byte_arr_b() {
        this.void_b();
        return this.var_byte_arr_b;
    }

    public byte[] byte_arr_a(int n2) {
        this.var_int_b = n2;
        return this.byte_arr_a();
    }

    public byte[] c() {
        return this.var_byte_arr_b;
    }

    public void d(int n2) {
        this.var_int_b = n2;
    }

    public int int_a() {
        return this.var_int_b;
    }

    @Override
    public void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public void write(byte[] byArray, int n2, int n3) {
        while (true) {
            int n4;
            int n5;
            if ((n5 = Math.min(n4 = this.var_byte_arr_b.length - this.var_int_b, n3)) > 0) {
                System.arraycopy(byArray, n2, this.var_byte_arr_b, this.var_int_b, n5);
                n2 += n5;
                this.var_int_b += n5;
                n3 -= n5;
            }
            if (n3 <= 0) break;
            this.void_b();
        }
    }

    @Override
    public void write(int n2) {
        this.void_a(n2);
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }

    private void void_b() {
        int n2 = this.var_int_a + this.var_byte_arr_b.length;
        if (n2 < 0) {
            throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
        }
        this.var_int_a = n2;
        int n3 = Math.max(this.var_int_a >> 1, 1000);
        if (n3 > 131072) {
            n3 = 131072;
        }
        this.var_byte_arr_a.add(this.var_byte_arr_b);
        this.var_byte_arr_b = new byte[n3];
        this.var_int_b = 0;
    }

    static {
        var_byte_arr_a = new byte[0];
    }
}

