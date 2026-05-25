/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;

public final class bdz
extends InputStream {
    private final bdv var_bdv_a;
    private final InputStream var_java_io_InputStream_a;
    private byte[] var_byte_arr_a;
    private int var_int_a;
    private final int b;

    public bdz(bdv bdv2, InputStream inputStream, byte[] byArray, int n2, int n3) {
        this.var_bdv_a = bdv2;
        this.var_java_io_InputStream_a = inputStream;
        this.var_byte_arr_a = byArray;
        this.var_int_a = n2;
        this.b = n3;
    }

    @Override
    public int available() {
        if (this.var_byte_arr_a != null) {
            return this.b - this.var_int_a;
        }
        return this.var_java_io_InputStream_a.available();
    }

    @Override
    public void close() {
        this.a();
        this.var_java_io_InputStream_a.close();
    }

    @Override
    public synchronized void mark(int n2) {
        if (this.var_byte_arr_a == null) {
            this.var_java_io_InputStream_a.mark(n2);
        }
    }

    @Override
    public boolean markSupported() {
        return this.var_byte_arr_a == null && this.var_java_io_InputStream_a.markSupported();
    }

    @Override
    public int read() {
        if (this.var_byte_arr_a != null) {
            int n2 = this.var_byte_arr_a[this.var_int_a++] & 0xFF;
            if (this.var_int_a >= this.b) {
                this.a();
            }
            return n2;
        }
        return this.var_java_io_InputStream_a.read();
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) {
        if (this.var_byte_arr_a != null) {
            int n4 = this.b - this.var_int_a;
            if (n3 > n4) {
                n3 = n4;
            }
            System.arraycopy(this.var_byte_arr_a, this.var_int_a, byArray, n2, n3);
            this.var_int_a += n3;
            if (this.var_int_a >= this.b) {
                this.a();
            }
            return n3;
        }
        return this.var_java_io_InputStream_a.read(byArray, n2, n3);
    }

    @Override
    public synchronized void reset() {
        if (this.var_byte_arr_a == null) {
            this.var_java_io_InputStream_a.reset();
        }
    }

    @Override
    public long skip(long l2) {
        long l3 = 0L;
        if (this.var_byte_arr_a != null) {
            int n2 = this.b - this.var_int_a;
            if ((long)n2 > l2) {
                this.var_int_a += (int)l2;
                return l2;
            }
            this.a();
            l3 += (long)n2;
            l2 -= (long)n2;
        }
        if (l2 > 0L) {
            l3 += this.var_java_io_InputStream_a.skip(l2);
        }
        return l3;
    }

    private void a() {
        byte[] byArray = this.var_byte_arr_a;
        if (byArray != null) {
            this.var_byte_arr_a = null;
            if (this.var_bdv_a != null) {
                this.var_bdv_a.a(byArray);
            }
        }
    }
}

