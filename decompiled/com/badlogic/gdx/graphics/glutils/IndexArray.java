/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.glutils.IndexData;
import com.badlogic.gdx.utils.BufferUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class IndexArray
implements IndexData {
    final ShortBuffer buffer;
    final ByteBuffer byteBuffer;
    private final boolean empty;

    public IndexArray(int n2) {
        boolean bl2 = this.empty = n2 == 0;
        if (this.empty) {
            n2 = 1;
        }
        this.byteBuffer = BufferUtils.newUnsafeByteBuffer(n2 * 2);
        this.buffer = this.byteBuffer.asShortBuffer();
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).flip();
    }

    @Override
    public int getNumIndices() {
        return this.empty ? 0 : this.buffer.limit();
    }

    @Override
    public int getNumMaxIndices() {
        return this.empty ? 0 : this.buffer.capacity();
    }

    @Override
    public void setIndices(short[] sArray, int n2, int n3) {
        ((Buffer)this.buffer).clear();
        this.buffer.put(sArray, n2, n3);
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).position(0);
        ((Buffer)this.byteBuffer).limit(n3 << 1);
    }

    @Override
    public void setIndices(ShortBuffer shortBuffer) {
        int n2 = shortBuffer.position();
        ((Buffer)this.buffer).clear();
        ((Buffer)this.buffer).limit(shortBuffer.remaining());
        this.buffer.put(shortBuffer);
        ((Buffer)this.buffer).flip();
        ((Buffer)shortBuffer).position(n2);
        ((Buffer)this.byteBuffer).position(0);
        ((Buffer)this.byteBuffer).limit(this.buffer.limit() << 1);
    }

    @Override
    public void updateIndices(int n2, short[] sArray, int n3, int n4) {
        int n5 = this.byteBuffer.position();
        ((Buffer)this.byteBuffer).position(n2 * 2);
        BufferUtils.copy(sArray, n3, (Buffer)this.byteBuffer, n4);
        ((Buffer)this.byteBuffer).position(n5);
    }

    @Override
    public ShortBuffer getBuffer() {
        return this.buffer;
    }

    @Override
    public void bind() {
    }

    @Override
    public void unbind() {
    }

    @Override
    public void invalidate() {
    }

    @Override
    public void dispose() {
        BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
    }
}

