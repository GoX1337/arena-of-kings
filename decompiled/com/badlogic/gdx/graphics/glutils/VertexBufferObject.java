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

public class VertexBufferObject
implements VertexData {
    private VertexAttributes attributes;
    private FloatBuffer buffer;
    private ByteBuffer byteBuffer;
    private boolean ownsBuffer;
    private int bufferHandle = Gdx.gl20.glGenBuffer();
    private int usage;
    boolean isDirty = false;
    boolean isBound = false;

    public VertexBufferObject(boolean bl2, int n2, VertexAttribute ... vertexAttributeArray) {
        this(bl2, n2, new VertexAttributes(vertexAttributeArray));
    }

    public VertexBufferObject(boolean bl2, int n2, VertexAttributes vertexAttributes) {
        ByteBuffer byteBuffer = BufferUtils.newUnsafeByteBuffer(vertexAttributes.vertexSize * n2);
        ((Buffer)byteBuffer).limit(0);
        this.setBuffer(byteBuffer, true, vertexAttributes);
        this.setUsage(bl2 ? 35044 : 35048);
    }

    protected VertexBufferObject(int n2, ByteBuffer byteBuffer, boolean bl2, VertexAttributes vertexAttributes) {
        this.setBuffer(byteBuffer, bl2, vertexAttributes);
        this.setUsage(n2);
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

    protected void setBuffer(Buffer buffer, boolean bl2, VertexAttributes vertexAttributes) {
        if (this.isBound) {
            throw new GdxRuntimeException("Cannot change attributes while VBO is bound");
        }
        if (this.ownsBuffer && this.byteBuffer != null) {
            BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
        }
        this.attributes = vertexAttributes;
        if (!(buffer instanceof ByteBuffer)) {
            throw new GdxRuntimeException("Only ByteBuffer is currently supported");
        }
        this.byteBuffer = (ByteBuffer)buffer;
        this.ownsBuffer = bl2;
        int n2 = this.byteBuffer.limit();
        ((Buffer)this.byteBuffer).limit(this.byteBuffer.capacity());
        this.buffer = this.byteBuffer.asFloatBuffer();
        ((Buffer)this.byteBuffer).limit(n2);
        ((Buffer)this.buffer).limit(n2 / 4);
    }

    private void bufferChanged() {
        if (this.isBound) {
            Gdx.gl20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    @Override
    public void setVertices(float[] fArray, int n2, int n3) {
        this.isDirty = true;
        BufferUtils.copy(fArray, this.byteBuffer, n3, n2);
        ((Buffer)this.buffer).position(0);
        ((Buffer)this.buffer).limit(n3);
        this.bufferChanged();
    }

    @Override
    public void updateVertices(int n2, float[] fArray, int n3, int n4) {
        this.isDirty = true;
        int n5 = this.byteBuffer.position();
        ((Buffer)this.byteBuffer).position(n2 * 4);
        BufferUtils.copy(fArray, n3, n4, (Buffer)this.byteBuffer);
        ((Buffer)this.byteBuffer).position(n5);
        ((Buffer)this.buffer).position(0);
        this.bufferChanged();
    }

    protected int getUsage() {
        return this.usage;
    }

    protected void setUsage(int n2) {
        if (this.isBound) {
            throw new GdxRuntimeException("Cannot change usage while VBO is bound");
        }
        this.usage = n2;
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
        this.bufferHandle = Gdx.gl20.glGenBuffer();
        this.isDirty = true;
    }

    @Override
    public void dispose() {
        GL20 gL20 = Gdx.gl20;
        gL20.glBindBuffer(34962, 0);
        gL20.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
        if (this.ownsBuffer) {
            BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
        }
    }
}

