/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.nio.ByteBuffer;

public class bui
extends InputStream {
    protected final ByteBuffer a;

    public bui(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override
    public int available() {
        return this.a.remaining();
    }

    @Override
    public int read() {
        return this.a.hasRemaining() ? this.a.get() & 0xFF : -1;
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) {
        if (!this.a.hasRemaining()) {
            return -1;
        }
        n3 = Math.min(n3, this.a.remaining());
        this.a.get(byArray, n2, n3);
        return n3;
    }
}

