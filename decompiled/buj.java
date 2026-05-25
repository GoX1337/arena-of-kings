/*
 * Decompiled with CFR 0.152.
 */
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class buj
extends OutputStream {
    protected final ByteBuffer a;

    public buj(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override
    public void write(int n2) {
        this.a.put((byte)n2);
    }

    @Override
    public void write(byte[] byArray, int n2, int n3) {
        this.a.put(byArray, n2, n3);
    }
}

