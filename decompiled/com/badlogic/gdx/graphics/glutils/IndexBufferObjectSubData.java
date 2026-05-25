/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.IndexData;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class IndexBufferObjectSubData
implements IndexData {
    final ShortBuffer buffer;
    final ByteBuffer byteBuffer;
    int bufferHandle;
    final boolean isDirect;
    boolean isDirty = true;
    boolean isBound = false;
    final int usage;

    public IndexBufferObjectSubData(boolean bl2, int n2) {
        this.byteBuffer = BufferUtils.newByteBuffer(n2 * 2);
        this.isDirect = true;
        this.usage = bl2 ? 35044 : 35048;
        this.buffer = this.byteBuffer.asShortBuffer();
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).flip();
        this.bufferHandle = this.createBufferObject();
    }

    public IndexBufferObjectSubData(int n2) {
        this.byteBuffer = BufferUtils.newByteBuffer(n2 * 2);
        this.isDirect = true;
        this.usage = 35044;
        this.buffer = this.byteBuffer.asShortBuffer();
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).flip();
        this.bufferHandle = this.createBufferObject();
    }

    private int createBufferObject() {
        int n2 = Gdx.gl20.glGenBuffer();
        Gdx.gl20.glBindBuffer(34963, n2);
        Gdx.gl20.glBufferData(34963, this.byteBuffer.capacity(), null, this.usage);
        Gdx.gl20.glBindBuffer(34963, 0);
        return n2;
    }

    @Override
    public int getNumIndices() {
        return this.buffer.limit();
    }

    @Override
    public int getNumMaxIndices() {
        return this.buffer.capacity();
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
            Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
            this.isDirty = false;
        }
    }

    @Override
    public void setIndices(ShortBuffer shortBuffer) {
        int n2 = shortBuffer.position();
        this.isDirty = true;
        ((Buffer)this.buffer).clear();
        this.buffer.put(shortBuffer);
        ((Buffer)this.buffer).flip();
        ((Buffer)shortBuffer).position(n2);
        ((Buffer)this.byteBuffer).position(0);
        ((Buffer)this.byteBuffer).limit(this.buffer.limit() << 1);
        if (this.isBound) {
            Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
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
            Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
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
            throw new GdxRuntimeException("IndexBufferObject cannot be used after it has been disposed.");
        }
        Gdx.gl20.glBindBuffer(34963, this.bufferHandle);
        if (this.isDirty) {
            ((Buffer)this.byteBuffer).limit(this.buffer.limit() * 2);
            Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
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
        this.bufferHandle = this.createBufferObject();
        this.isDirty = true;
    }

    @Override
    public void dispose() {
        GL20 gL20 = Gdx.gl20;
        gL20.glBindBuffer(34963, 0);
        gL20.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
    }
}

