/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer;
import com.badlogic.gdx.graphics.glutils.GLOnlyTextureData;

public class FrameBuffer
extends GLFrameBuffer<Texture> {
    FrameBuffer() {
    }

    protected FrameBuffer(GLFrameBuffer.GLFrameBufferBuilder<? extends GLFrameBuffer<Texture>> gLFrameBufferBuilder) {
        super(gLFrameBufferBuilder);
    }

    public FrameBuffer(Pixmap.Format format, int n2, int n3, boolean bl2) {
        this(format, n2, n3, bl2, false);
    }

    public FrameBuffer(Pixmap.Format format, int n2, int n3, boolean bl2, boolean bl3) {
        GLFrameBuffer.FrameBufferBuilder frameBufferBuilder = new GLFrameBuffer.FrameBufferBuilder(n2, n3);
        frameBufferBuilder.addBasicColorTextureAttachment(format);
        if (bl2) {
            frameBufferBuilder.addBasicDepthRenderBuffer();
        }
        if (bl3) {
            frameBufferBuilder.addBasicStencilRenderBuffer();
        }
        this.bufferBuilder = frameBufferBuilder;
        this.build();
    }

    @Override
    protected Texture createTexture(GLFrameBuffer.FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec) {
        GLOnlyTextureData gLOnlyTextureData = new GLOnlyTextureData(this.bufferBuilder.width, this.bufferBuilder.height, 0, frameBufferTextureAttachmentSpec.internalFormat, frameBufferTextureAttachmentSpec.format, frameBufferTextureAttachmentSpec.type);
        Texture texture = new Texture(gLOnlyTextureData);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        texture.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
        return texture;
    }

    @Override
    protected void disposeColorTexture(Texture texture) {
        texture.dispose();
    }

    @Override
    protected void attachFrameBufferColorTexture(Texture texture) {
        Gdx.gl20.glFramebufferTexture2D(36160, 36064, 3553, texture.getTextureObjectHandle(), 0);
    }

    public static void unbind() {
        GLFrameBuffer.unbind();
    }
}

