/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.FloatTextureData;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer;

public class FloatFrameBuffer
extends FrameBuffer {
    FloatFrameBuffer() {
    }

    protected FloatFrameBuffer(GLFrameBuffer.GLFrameBufferBuilder<? extends GLFrameBuffer<Texture>> gLFrameBufferBuilder) {
        super(gLFrameBufferBuilder);
    }

    public FloatFrameBuffer(int n2, int n3, boolean bl2) {
        GLFrameBuffer.FloatFrameBufferBuilder floatFrameBufferBuilder = new GLFrameBuffer.FloatFrameBufferBuilder(n2, n3);
        floatFrameBufferBuilder.addFloatAttachment(34836, 6408, 5126, false);
        if (bl2) {
            floatFrameBufferBuilder.addBasicDepthRenderBuffer();
        }
        this.bufferBuilder = floatFrameBufferBuilder;
        this.build();
    }

    @Override
    protected Texture createTexture(GLFrameBuffer.FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec) {
        FloatTextureData floatTextureData = new FloatTextureData(this.bufferBuilder.width, this.bufferBuilder.height, frameBufferTextureAttachmentSpec.internalFormat, frameBufferTextureAttachmentSpec.format, frameBufferTextureAttachmentSpec.type, frameBufferTextureAttachmentSpec.isGpuOnly);
        Texture texture = new Texture(floatTextureData);
        if (Gdx.app.getType() == Application.ApplicationType.Desktop || Gdx.app.getType() == Application.ApplicationType.Applet) {
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        } else {
            texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        }
        texture.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
        return texture;
    }
}

