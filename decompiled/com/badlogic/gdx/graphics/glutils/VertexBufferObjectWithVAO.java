/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.VertexData;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.IntArray;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class VertexBufferObjectWithVAO
implements VertexData {
    static final IntBuffer tmpHandle = BufferUtils.newIntBuffer(1);
    final VertexAttributes attributes;
    final FloatBuffer buffer;
    final ByteBuffer byteBuffer;
    final boolean ownsBuffer;
    int bufferHandle;
    final boolean isStatic;
    final int usage;
    boolean isDirty = false;
    boolean isBound = false;
    int vaoHandle = -1;
    IntArray cachedLocations = new IntArray();

    public VertexBufferObjectWithVAO(boolean bl2, int n2, VertexAttribute ... vertexAttributeArray) {
        this(bl2, n2, new VertexAttributes(vertexAttributeArray));
    }

    public VertexBufferObjectWithVAO(boolean bl2, int n2, VertexAttributes vertexAttributes) {
        this.isStatic = bl2;
        this.attributes = vertexAttributes;
        this.byteBuffer = BufferUtils.newUnsafeByteBuffer(this.attributes.vertexSize * n2);
        this.buffer = this.byteBuffer.asFloatBuffer();
        this.ownsBuffer = true;
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).flip();
        this.bufferHandle = Gdx.gl20.glGenBuffer();
        this.usage = bl2 ? 35044 : 35048;
        this.createVAO();
    }

    public VertexBufferObjectWithVAO(boolean bl2, ByteBuffer byteBuffer, VertexAttributes vertexAttributes) {
        this.isStatic = bl2;
        this.attributes = vertexAttributes;
        this.byteBuffer = byteBuffer;
        this.ownsBuffer = false;
        this.buffer = this.byteBuffer.asFloatBuffer();
        ((Buffer)this.buffer).flip();
        ((Buffer)this.byteBuffer).flip();
        this.bufferHandle = Gdx.gl20.glGenBuffer();
        this.usage = bl2 ? 35044 : 35048;
        this.createVAO();
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
            Gdx.gl20.glBindBuffer(34962, this.bufferHandle);
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

    @Override
    public void bind(ShaderProgram shaderProgram) {
        this.bind(shaderProgram, null);
    }

    @Override
    public void bind(ShaderProgram shaderProgram, int[] nArray) {
        GL30 gL30 = Gdx.gl30;
        gL30.glBindVertexArray(this.vaoHandle);
        this.bindAttributes(shaderProgram, nArray);
        this.bindData(gL30);
        this.isBound = true;
    }

    private void bindAttributes(ShaderProgram shaderProgram, int[] nArray) {
        int n2;
        VertexAttribute vertexAttribute;
        int n3;
        boolean bl2 = this.cachedLocations.size != 0;
        int n4 = this.attributes.size();
        if (bl2) {
            if (nArray == null) {
                for (n3 = 0; bl2 && n3 < n4; ++n3) {
                    vertexAttribute = this.attributes.get(n3);
                    n2 = shaderProgram.getAttributeLocation(vertexAttribute.alias);
                    bl2 = n2 == this.cachedLocations.get(n3);
                }
            } else {
                bl2 = nArray.length == this.cachedLocations.size;
                for (n3 = 0; bl2 && n3 < n4; ++n3) {
                    bl2 = nArray[n3] == this.cachedLocations.get(n3);
                }
            }
        }
        if (!bl2) {
            Gdx.gl.glBindBuffer(34962, this.bufferHandle);
            this.unbindAttributes(shaderProgram);
            this.cachedLocations.clear();
            for (n3 = 0; n3 < n4; ++n3) {
                vertexAttribute = this.attributes.get(n3);
                if (nArray == null) {
                    this.cachedLocations.add(shaderProgram.getAttributeLocation(vertexAttribute.alias));
                } else {
                    this.cachedLocations.add(nArray[n3]);
                }
                n2 = this.cachedLocations.get(n3);
                if (n2 < 0) continue;
                shaderProgram.enableVertexAttribute(n2);
                shaderProgram.setVertexAttribute(n2, vertexAttribute.numComponents, vertexAttribute.type, vertexAttribute.normalized, this.attributes.vertexSize, vertexAttribute.offset);
            }
        }
    }

    private void unbindAttributes(ShaderProgram shaderProgram) {
        if (this.cachedLocations.size == 0) {
            return;
        }
        int n2 = this.attributes.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.cachedLocations.get(i2);
            if (n3 < 0) continue;
            shaderProgram.disableVertexAttribute(n3);
        }
    }

    private void bindData(GL20 gL20) {
        if (this.isDirty) {
            gL20.glBindBuffer(34962, this.bufferHandle);
            ((Buffer)this.byteBuffer).limit(this.buffer.limit() * 4);
            gL20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
            this.isDirty = false;
        }
    }

    @Override
    public void unbind(ShaderProgram shaderProgram) {
        this.unbind(shaderProgram, null);
    }

    @Override
    public void unbind(ShaderProgram shaderProgram, int[] nArray) {
        GL30 gL30 = Gdx.gl30;
        gL30.glBindVertexArray(0);
        this.isBound = false;
    }

    @Override
    public void invalidate() {
        this.bufferHandle = Gdx.gl30.glGenBuffer();
        this.createVAO();
        this.isDirty = true;
    }

    @Override
    public void dispose() {
        GL30 gL30 = Gdx.gl30;
        gL30.glBindBuffer(34962, 0);
        gL30.glDeleteBuffer(this.bufferHandle);
        this.bufferHandle = 0;
        if (this.ownsBuffer) {
            BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
        }
        this.deleteVAO();
    }

    private void createVAO() {
        ((Buffer)tmpHandle).clear();
        Gdx.gl30.glGenVertexArrays(1, tmpHandle);
        this.vaoHandle = tmpHandle.get();
    }

    private void deleteVAO() {
        if (this.vaoHandle != -1) {
            ((Buffer)tmpHandle).clear();
            tmpHandle.put(this.vaoHandle);
            ((Buffer)tmpHandle).flip();
            Gdx.gl30.glDeleteVertexArrays(1, tmpHandle);
            this.vaoHandle = -1;
        }
    }
}

