/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.IndexData;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class IndexBufferObject
implements IndexData {
    final ShortBuffer buffer;
    final ByteBuffer byteBuffer;
    final boolean ownsBuffer;
    int bufferHandle;
    final boolean isDirect;
    boolean isDirty = true;
    boolean isBound = false;
    final int usage;
    private final boolean empty;

    public IndexBufferObject(int n2) {
        this(true, n2);
    }

    public IndexBufferObject(boolean bl2, int n2) {
        boolean bl3 = this.empty = n2 == 0;
        if (this.empty) {
            n2 = 1;
        }
        this.byteBuffer = BufferUtils.newUnsafeByteBuffer(n2 * 2);
        this.isDirect = true;
        this.buffer = this.byteBuffer.asShortBuffer();
        this.ownsBuffer = true;
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).flip();
        this.bufferHandle = Gdx.gl20.glGenBuffer();
        this.usage = bl2 ? 35044 : 35048;
    }

    public IndexBufferObject(boolean bl2, ByteBuffer byteBuffer) {
        this.empty = byteBuffer.limit() == 0;
        this.byteBuffer = byteBuffer;
        this.isDirect = true;
        this.buffer = this.byteBuffer.asShortBuffer();
        this.ownsBuffer = false;
        this.bufferHandle = Gdx.gl20.glGenBuffer();
        this.usage = bl2 ? 35044 : 35048;
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
        this.isDirty = true;
        ((Buffer)this.buffer).clear();
        this.buffer.put(sArray, n2, n3);
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).position(0);
        ((Buffer)this.byteBuffer).limit(n3 << 1);
        if (this.isBound) {
            Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    @Override
    public void setIndices(ShortBuffer shortBuffer) {
        this.isDirty = true;
        int n2 = shortBuffer.position();
        ((Buffer)this.buffer).clear();
        this.buffer.put(shortBuffer);
        ((Buffer)this.buffer).flip();
        ((Buffer)shortBuffer).position(n2);
        ((Buffer)this.byteBuffer).position(0);
        ((Buffer)this.byteBuffer).limit(this.buffer.limit() << 1);
        if (this.isBound) {
            Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    @Override
    public void updateIndices(int n2, short[] sArray, int n3, int n4) {
        this.isDirty = true;
        int n5 = this.byteBuffer.position();
        ((Buffer)this.byteBuffer).position(n2 * 2);
        BufferUtils.copy(sArray, n3, (Buffer)this.byteBuffer, n4);
        ((Buffer)this.byteBuffer).position(n5);
        ((Buffer)this.buffer).position(0);
        if (this.isBound) {
            Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    @Override
    public ShortBuffer getBuffer() {
        this.isDirty = true;
        return this.buffer;
    }

    @Override
    public void bind() {
        if (this.bufferHandle == 0) {
            throw new GdxRuntimeException("No buffer allocated!");
        }
        Gdx.gl20.glBindBuffer(34963, this.bufferHandle);
        if (this.isDirty) {
            ((Buffer)this.byteBuffer).limit(this.buffer.limit() * 2);
            Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
        this.isBound = true;
    }

    @Override
    public void unbind() {
        Gdx.gl20.glBindBuffer(34963, 0);
        this.isBound = false;
    }

    @Override
    public void invalidate() {
        this.bufferHandle = Gdx.gl20.glGenBuffer();
        this.isDirty = true;
    }

    @Override
    public void dispose() {
        Gdx.gl20.glBindBuffer(34963, 0);
        Gdx.gl20.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
        if (this.ownsBuffer) {
            BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
        }
    }
}

