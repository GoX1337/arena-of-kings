/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.VertexData;
import com.badlogic.gdx.utils.BufferUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class VertexArray
implements VertexData {
    final VertexAttributes attributes;
    final FloatBuffer buffer;
    final ByteBuffer byteBuffer;
    boolean isBound = false;

    public VertexArray(int n2, VertexAttribute ... vertexAttributeArray) {
        this(n2, new VertexAttributes(vertexAttributeArray));
    }

    public VertexArray(int n2, VertexAttributes vertexAttributes) {
        this.attributes = vertexAttributes;
        this.byteBuffer = BufferUtils.newUnsafeByteBuffer(this.attributes.vertexSize * n2);
        this.buffer = this.byteBuffer.asFloatBuffer();
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).flip();
    }

    @Override
    public void dispose() {
        BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
    }

    @Override
    public FloatBuffer getBuffer() {
        return this.buffer;
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
    public void setVertices(float[] fArray, int n2, int n3) {
        BufferUtils.copy(fArray, this.byteBuffer, n3, n2);
        ((Buffer)this.buffer).position(0);
        ((Buffer)this.buffer).limit(n3);
    }

    @Override
    public void updateVertices(int n2, float[] fArray, int n3, int n4) {
        int n5 = this.byteBuffer.position();
        ((Buffer)this.byteBuffer).position(n2 * 4);
        BufferUtils.copy(fArray, n3, n4, (Buffer)this.byteBuffer);
        ((Buffer)this.byteBuffer).position(n5);
    }

    @Override
    public void bind(ShaderProgram shaderProgram) {
        this.bind(shaderProgram, null);
    }

    @Override
    public void bind(ShaderProgram shaderProgram, int[] nArray) {
        int n2 = this.attributes.size();
        ((Buffer)this.byteBuffer).limit(this.buffer.limit() * 4);
        if (nArray == null) {
            for (int i2 = 0; i2 < n2; ++i2) {
                VertexAttribute vertexAttribute = this.attributes.get(i2);
                int n3 = shaderProgram.getAttributeLocation(vertexAttribute.alias);
                if (n3 < 0) continue;
                shaderProgram.enableVertexAttribute(n3);
                if (vertexAttribute.type == 5126) {
                    ((Buffer)this.buffer).position(vertexAttribute.offset / 4);
                    shaderProgram.setVertexAttribute(n3, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, (Buffer)this.buffer);
                    continue;
                }
                ((Buffer)this.byteBuffer).position(vertexAttribute.offset);
                shaderProgram.setVertexAttribute(n3, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, (Buffer)this.byteBuffer);
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                VertexAttribute vertexAttribute = this.attributes.get(i3);
                int n4 = nArray[i3];
                if (n4 < 0) continue;
                shaderProgram.enableVertexAttribute(n4);
                if (vertexAttribute.type == 5126) {
                    ((Buffer)this.buffer).position(vertexAttribute.offset / 4);
                    shaderProgram.setVertexAttribute(n4, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, (Buffer)this.buffer);
                    continue;
                }
                ((Buffer)this.byteBuffer).position(vertexAttribute.offset);
                shaderProgram.setVertexAttribute(n4, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, (Buffer)this.byteBuffer);
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
        this.isBound = false;
    }

    @Override
    public VertexAttributes getAttributes() {
        return this.attributes;
    }

    @Override
    public void invalidate() {
    }
}

