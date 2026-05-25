/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.VertexData;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class VertexBufferObjectSubData
implements VertexData {
    final VertexAttributes attributes;
    final FloatBuffer buffer;
    final ByteBuffer byteBuffer;
    int bufferHandle;
    final boolean isDirect;
    final boolean isStatic;
    final int usage;
    boolean isDirty = false;
    boolean isBound = false;

    public VertexBufferObjectSubData(boolean bl2, int n2, VertexAttribute ... vertexAttributeArray) {
        this(bl2, n2, new VertexAttributes(vertexAttributeArray));
    }

    public VertexBufferObjectSubData(boolean bl2, int n2, VertexAttributes vertexAttributes) {
        this.isStatic = bl2;
        this.attributes = vertexAttributes;
        this.byteBuffer = BufferUtils.newByteBuffer(this.attributes.vertexSize * n2);
        this.isDirect = true;
        this.usage = bl2 ? 35044 : 35048;
        this.buffer = this.byteBuffer.asFloatBuffer();
        this.bufferHandle = this.createBufferObject();
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).flip();
    }

    private int createBufferObject() {
        int n2 = Gdx.gl20.glGenBuffer();
        Gdx.gl20.glBindBuffer(34962, n2);
        Gdx.gl20.glBufferData(34962, this.byteBuffer.capacity(), null, this.usage);
        Gdx.gl20.glBindBuffer(34962, 0);
        return n2;
    }

    @Override
    public VertexAttributes getAttributes() {
        return this.attributes;
    }

    @Override
    public int getNumVertices() {
        return this.buffer.limit() * 4 / this.attributes.vertexSize;
    }

    @Override
    public int getNumMaxVertices() {
        return this.byteBuffer.capacity() / this.attributes.vertexSize;
    }

    @Override
    public FloatBuffer getBuffer() {
        this.isDirty = true;
        return this.buffer;
    }

    private void bufferChanged() {
        if (this.isBound) {
            Gdx.gl20.glBufferSubData(34962, 0, this.byteBuffer.limit(), this.byteBuffer);
            this.isDirty = false;
        }
    }

    @Override
    public void setVertices(float[] fArray, int n2, int n3) {
        this.isDirty = true;
        if (this.isDirect) {
            BufferUtils.copy(fArray, this.byteBuffer, n3, n2);
            ((Buffer)this.buffer).position(0);
            ((Buffer)this.buffer).limit(n3);
        } else {
            ((Buffer)this.buffer).clear();
            this.buffer.put(fArray, n2, n3);
            ((Buffer)this.buffer).flip();
            ((Buffer)this.byteBuffer).position(0);
            ((Buffer)this.byteBuffer).limit(this.buffer.limit() << 2);
        }
        this.bufferChanged();
    }

    @Override
    public void updateVertices(int n2, float[] fArray, int n3, int n4) {
        this.isDirty = true;
        if (!this.isDirect) {
            throw new GdxRuntimeException("Buffer must be allocated direct.");
        }
        int n5 = this.byteBuffer.position();
        ((Buffer)this.byteBuffer).position(n2 * 4);
        BufferUtils.copy(fArray, n3, n4, (Buffer)this.byteBuffer);
        ((Buffer)this.byteBuffer).position(n5);
        this.bufferChanged();
    }

    @Override
    public void bind(ShaderProgram shaderProgram) {
        this.bind(shaderProgram, null);
    }

    @Override
    public void bind(ShaderProgram shaderProgram, int[] nArray) {
        GL20 gL20 = Gdx.gl20;
        gL20.glBindBuffer(34962, this.bufferHandle);
        if (this.isDirty) {
            ((Buffer)this.byteBuffer).limit(this.buffer.limit() * 4);
            gL20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
        int n2 = this.attributes.size();
        if (nArray == null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                VertexAttribute vertexAttribute = this.attributes.get(i2);
                int n3 = shaderProgram.getAttributeLocation(vertexAttribute.alias);
                if (n3 < 0) continue;
                shaderProgram.enableVertexAttribute(n3);
                shaderProgram.setVertexAttribute(n3, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                VertexAttribute vertexAttribute = this.attributes.get(i3);
                int n4 = nArray[i3];
                if (n4 < 0) continue;
                shaderProgram.enableVertexAttribute(n4);
                shaderProgram.setVertexAttribute(n4, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
            }
        }
        this.isBound = true;
    }

    @Override
    public void unbind(ShaderProgram shaderProgram) {
        this.unbind(shaderProgram, null);
    }

    @Override
    public void unbind(ShaderProgram shaderProgram, int[] nArray) {
        GL20 gL20 = Gdx.gl20;
        int n2 = this.attributes.size();
        if (nArray == null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                shaderProgram.disableVertexAttribute(this.attributes.get((int)i2).alias);
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                int n3 = nArray[i3];
                if (n3 < 0) continue;
                shaderProgram.disableVertexAttribute(n3);
            }
        }
        gL20.glBindBuffer(34962, 0);
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
        gL20.glBindBuffer(34962, 0);
        gL20.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
    }

    public int getBufferHandle() {
        return this.bufferHandle;
    }
}

