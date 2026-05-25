/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import java.io.OutputStream;
import java.nio.ByteBuffer;

public class ByteBufferOutputStream
extends OutputStream {
    private ByteBuffer byteBuffer;

    public ByteBufferOutputStream() {
    }

    public ByteBufferOutputStream(int n2) {
        this(ByteBuffer.allocate(n2));
    }

    public ByteBufferOutputStream(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public void setByteBuffer(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override
    public void write(int n2) {
        if (!this.byteBuffer.hasRemaining()) {
            this.flush();
        }
        this.byteBuffer.put((byte)n2);
    }

    @Override
    public void write(byte[] byArray, int n2, int n3) {
        if (this.byteBuffer.remaining() < n3) {
            this.flush();
        }
        this.byteBuffer.put(byArray, n2, n3);
    }
}

