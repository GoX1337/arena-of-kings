/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer;
import com.badlogic.gdx.graphics.glutils.GLOnlyTextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class FrameBufferCubemap
extends GLFrameBuffer<Cubemap> {
    private int currentSide;
    private static final Cubemap.CubemapSide[] cubemapSides = Cubemap.CubemapSide.values();

    FrameBufferCubemap() {
    }

    protected FrameBufferCubemap(GLFrameBuffer.GLFrameBufferBuilder<? extends GLFrameBuffer<Cubemap>> gLFrameBufferBuilder) {
        super(gLFrameBufferBuilder);
    }

    public FrameBufferCubemap(Pixmap.Format format, int n2, int n3, boolean bl2) {
        this(format, n2, n3, bl2, false);
    }

    public FrameBufferCubemap(Pixmap.Format format, int n2, int n3, boolean bl2, boolean bl3) {
        GLFrameBuffer.FrameBufferCubemapBuilder frameBufferCubemapBuilder = new GLFrameBuffer.FrameBufferCubemapBuilder(n2, n3);
        frameBufferCubemapBuilder.addBasicColorTextureAttachment(format);
        if (bl2) {
            frameBufferCubemapBuilder.addBasicDepthRenderBuffer();
        }
        if (bl3) {
            frameBufferCubemapBuilder.addBasicStencilRenderBuffer();
        }
        this.bufferBuilder = frameBufferCubemapBuilder;
        this.build();
    }

    @Override
    protected Cubemap createTexture(GLFrameBuffer.FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec) {
        GLOnlyTextureData gLOnlyTextureData = new GLOnlyTextureData(this.bufferBuilder.width, this.bufferBuilder.height, 0, frameBufferTextureAttachmentSpec.internalFormat, frameBufferTextureAttachmentSpec.format, frameBufferTextureAttachmentSpec.type);
        Cubemap cubemap = new Cubemap(gLOnlyTextureData, gLOnlyTextureData, gLOnlyTextureData, gLOnlyTextureData, gLOnlyTextureData, gLOnlyTextureData);
        cubemap.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        cubemap.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
        return cubemap;
    }

    @Override
    protected void disposeColorTexture(Cubemap cubemap) {
        cubemap.dispose();
    }

    @Override
    protected void attachFrameBufferColorTexture(Cubemap cubemap) {
        Cubemap.CubemapSide[] cubemapSideArray;
        GL20 gL20 = Gdx.gl20;
        int n2 = cubemap.getTextureObjectHandle();
        for (Cubemap.CubemapSide cubemapSide : cubemapSideArray = Cubemap.CubemapSide.values()) {
            gL20.glFramebufferTexture2D(36160, 36064, cubemapSide.glEnum, n2, 0);
        }
    }

    @Override
    public void bind() {
        this.currentSide = -1;
        super.bind();
    }

    public boolean nextSide() {
        if (this.currentSide > 5) {
            throw new GdxRuntimeException("No remaining sides.");
        }
        if (this.currentSide == 5) {
            return false;
        }
        ++this.currentSide;
        this.bindSide(this.getSide());
        return true;
    }

    protected void bindSide(Cubemap.CubemapSide cubemapSide) {
        Gdx.gl20.glFramebufferTexture2D(36160, 36064, cubemapSide.glEnum, ((Cubemap)this.getColorBufferTexture()).getTextureObjectHandle(), 0);
    }

    public Cubemap.CubemapSide getSide() {
        return this.currentSide < 0 ? null : cubemapSides[this.currentSide];
    }
}

