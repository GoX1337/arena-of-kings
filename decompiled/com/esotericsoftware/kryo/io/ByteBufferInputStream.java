/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class ByteBufferInputStream
extends InputStream {
    private ByteBuffer byteBuffer;

    public ByteBufferInputStream() {
    }

    public ByteBufferInputStream(int n2) {
        this(ByteBuffer.allocate(n2));
        this.flipBuffer(this.byteBuffer);
    }

    public ByteBufferInputStream(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public void setByteBuffer(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override
    public int read() {
        if (!this.byteBuffer.hasRemaining()) {
            return -1;
        }
        return this.byteBuffer.get() & 0xFF;
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) {
        if (n3 == 0) {
            return 0;
        }
        int n4 = Math.min(this.byteBuffer.remaining(), n3);
        if (n4 == 0) {
            return -1;
        }
        this.byteBuffer.get(byArray, n2, n4);
        return n4;
    }

    @Override
    public int available() {
        return this.byteBuffer.remaining();
    }

    private void flipBuffer(Buffer buffer) {
        buffer.flip();
    }
}

