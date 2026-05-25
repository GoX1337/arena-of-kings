/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.glutils.FloatFrameBuffer;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.FrameBufferCubemap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class GLFrameBuffer<T extends GLTexture>
implements Disposable {
    protected static final Map<Application, Array<GLFrameBuffer>> buffers = new HashMap<Application, Array<GLFrameBuffer>>();
    protected static final int GL_DEPTH24_STENCIL8_OES = 35056;
    protected Array<T> textureAttachments = new Array();
    protected static int defaultFramebufferHandle;
    protected static boolean defaultFramebufferHandleInitialized;
    protected int framebufferHandle;
    protected int depthbufferHandle;
    protected int stencilbufferHandle;
    protected int depthStencilPackedBufferHandle;
    protected boolean hasDepthStencilPackedBuffer;
    protected boolean isMRT;
    protected GLFrameBufferBuilder<? extends GLFrameBuffer<T>> bufferBuilder;

    GLFrameBuffer() {
    }

    protected GLFrameBuffer(GLFrameBufferBuilder<? extends GLFrameBuffer<T>> gLFrameBufferBuilder) {
        this.bufferBuilder = gLFrameBufferBuilder;
        this.build();
    }

    public T getColorBufferTexture() {
        return (T)((GLTexture)this.textureAttachments.first());
    }

    public Array<T> getTextureAttachments() {
        return this.textureAttachments;
    }

    protected abstract T createTexture(FrameBufferTextureAttachmentSpec var1);

    protected abstract void disposeColorTexture(T var1);

    protected abstract void attachFrameBufferColorTexture(T var1);

    protected void build() {
        Object object;
        GL20 gL20 = Gdx.gl20;
        this.checkValidBuilder();
        if (!defaultFramebufferHandleInitialized) {
            defaultFramebufferHandleInitialized = true;
            if (Gdx.app.getType() == Application.ApplicationType.iOS) {
                IntBuffer intBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                gL20.glGetIntegerv(36006, intBuffer);
                defaultFramebufferHandle = intBuffer.get(0);
            } else {
                defaultFramebufferHandle = 0;
            }
        }
        this.framebufferHandle = gL20.glGenFramebuffer();
        gL20.glBindFramebuffer(36160, this.framebufferHandle);
        int n2 = this.bufferBuilder.width;
        int n3 = this.bufferBuilder.height;
        if (this.bufferBuilder.hasDepthRenderBuffer) {
            this.depthbufferHandle = gL20.glGenRenderbuffer();
            gL20.glBindRenderbuffer(36161, this.depthbufferHandle);
            gL20.glRenderbufferStorage(36161, this.bufferBuilder.depthRenderBufferSpec.internalFormat, n2, n3);
        }
        if (this.bufferBuilder.hasStencilRenderBuffer) {
            this.stencilbufferHandle = gL20.glGenRenderbuffer();
            gL20.glBindRenderbuffer(36161, this.stencilbufferHandle);
            gL20.glRenderbufferStorage(36161, this.bufferBuilder.stencilRenderBufferSpec.internalFormat, n2, n3);
        }
        if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
            this.depthStencilPackedBufferHandle = gL20.glGenRenderbuffer();
            gL20.glBindRenderbuffer(36161, this.depthStencilPackedBufferHandle);
            gL20.glRenderbufferStorage(36161, this.bufferBuilder.packedStencilDepthRenderBufferSpec.internalFormat, n2, n3);
        }
        this.isMRT = this.bufferBuilder.textureAttachmentSpecs.size > 1;
        int n4 = 0;
        if (this.isMRT) {
            for (FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec : this.bufferBuilder.textureAttachmentSpecs) {
                Object object2 = this.createTexture(frameBufferTextureAttachmentSpec);
                this.textureAttachments.add(object2);
                if (frameBufferTextureAttachmentSpec.isColorTexture()) {
                    gL20.glFramebufferTexture2D(36160, 36064 + n4, 3553, ((GLTexture)object2).getTextureObjectHandle(), 0);
                    ++n4;
                    continue;
                }
                if (frameBufferTextureAttachmentSpec.isDepth) {
                    gL20.glFramebufferTexture2D(36160, 36096, 3553, ((GLTexture)object2).getTextureObjectHandle(), 0);
                    continue;
                }
                if (!frameBufferTextureAttachmentSpec.isStencil) continue;
                gL20.glFramebufferTexture2D(36160, 36128, 3553, ((GLTexture)object2).getTextureObjectHandle(), 0);
            }
        } else {
            object = this.createTexture(this.bufferBuilder.textureAttachmentSpecs.first());
            this.textureAttachments.add((Iterator<Object>)object);
            gL20.glBindTexture(((GLTexture)object).glTarget, ((GLTexture)object).getTextureObjectHandle());
        }
        if (this.isMRT) {
            object = BufferUtils.newIntBuffer(n4);
            for (int i2 = 0; i2 < n4; ++i2) {
                ((IntBuffer)object).put(36064 + i2);
            }
            ((Buffer)object).position(0);
            Gdx.gl30.glDrawBuffers(n4, (IntBuffer)object);
        } else {
            this.attachFrameBufferColorTexture((GLTexture)this.textureAttachments.first());
        }
        if (this.bufferBuilder.hasDepthRenderBuffer) {
            gL20.glFramebufferRenderbuffer(36160, 36096, 36161, this.depthbufferHandle);
        }
        if (this.bufferBuilder.hasStencilRenderBuffer) {
            gL20.glFramebufferRenderbuffer(36160, 36128, 36161, this.stencilbufferHandle);
        }
        if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
            gL20.glFramebufferRenderbuffer(36160, 33306, 36161, this.depthStencilPackedBufferHandle);
        }
        gL20.glBindRenderbuffer(36161, 0);
        for (GLTexture gLTexture : this.textureAttachments) {
            gL20.glBindTexture(gLTexture.glTarget, 0);
        }
        int n5 = gL20.glCheckFramebufferStatus(36160);
        if (n5 == 36061 && this.bufferBuilder.hasDepthRenderBuffer && this.bufferBuilder.hasStencilRenderBuffer && (Gdx.graphics.supportsExtension("GL_OES_packed_depth_stencil") || Gdx.graphics.supportsExtension("GL_EXT_packed_depth_stencil"))) {
            if (this.bufferBuilder.hasDepthRenderBuffer) {
                gL20.glDeleteRenderbuffer(this.depthbufferHandle);
                this.depthbufferHandle = 0;
            }
            if (this.bufferBuilder.hasStencilRenderBuffer) {
                gL20.glDeleteRenderbuffer(this.stencilbufferHandle);
                this.stencilbufferHandle = 0;
            }
            if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
                gL20.glDeleteRenderbuffer(this.depthStencilPackedBufferHandle);
                this.depthStencilPackedBufferHandle = 0;
            }
            this.depthStencilPackedBufferHandle = gL20.glGenRenderbuffer();
            this.hasDepthStencilPackedBuffer = true;
            gL20.glBindRenderbuffer(36161, this.depthStencilPackedBufferHandle);
            gL20.glRenderbufferStorage(36161, 35056, n2, n3);
            gL20.glBindRenderbuffer(36161, 0);
            gL20.glFramebufferRenderbuffer(36160, 36096, 36161, this.depthStencilPackedBufferHandle);
            gL20.glFramebufferRenderbuffer(36160, 36128, 36161, this.depthStencilPackedBufferHandle);
            n5 = gL20.glCheckFramebufferStatus(36160);
        }
        gL20.glBindFramebuffer(36160, defaultFramebufferHandle);
        if (n5 != 36053) {
            for (Object object2 : this.textureAttachments) {
                this.disposeColorTexture(object2);
            }
            if (this.hasDepthStencilPackedBuffer) {
                gL20.glDeleteBuffer(this.depthStencilPackedBufferHandle);
            } else {
                if (this.bufferBuilder.hasDepthRenderBuffer) {
                    gL20.glDeleteRenderbuffer(this.depthbufferHandle);
                }
                if (this.bufferBuilder.hasStencilRenderBuffer) {
                    gL20.glDeleteRenderbuffer(this.stencilbufferHandle);
                }
            }
            gL20.glDeleteFramebuffer(this.framebufferHandle);
            if (n5 == 36054) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment");
            }
            if (n5 == 36057) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions");
            }
            if (n5 == 36055) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment");
            }
            if (n5 == 36061) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats");
            }
            throw new IllegalStateException("Frame buffer couldn't be constructed: unknown error " + n5);
        }
        GLFrameBuffer.addManagedFrameBuffer(Gdx.app, this);
    }

    private void checkValidBuilder() {
        boolean bl2 = Gdx.graphics.isGL30Available();
        if (!bl2) {
            if (this.bufferBuilder.hasPackedStencilDepthRenderBuffer) {
                throw new GdxRuntimeException("Packed Stencil/Render render buffers are not available on GLES 2.0");
            }
            if (this.bufferBuilder.textureAttachmentSpecs.size > 1) {
                throw new GdxRuntimeException("Multiple render targets not available on GLES 2.0");
            }
            for (FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec : this.bufferBuilder.textureAttachmentSpecs) {
                if (frameBufferTextureAttachmentSpec.isDepth) {
                    throw new GdxRuntimeException("Depth texture FrameBuffer Attachment not available on GLES 2.0");
                }
                if (frameBufferTextureAttachmentSpec.isStencil) {
                    throw new GdxRuntimeException("Stencil texture FrameBuffer Attachment not available on GLES 2.0");
                }
                if (!frameBufferTextureAttachmentSpec.isFloat || Gdx.graphics.supportsExtension("OES_texture_float")) continue;
                throw new GdxRuntimeException("Float texture FrameBuffer Attachment not available on GLES 2.0");
            }
        }
    }

    @Override
    public void dispose() {
        GL20 gL20 = Gdx.gl20;
        for (GLTexture gLTexture : this.textureAttachments) {
            this.disposeColorTexture(gLTexture);
        }
        if (this.hasDepthStencilPackedBuffer) {
            gL20.glDeleteRenderbuffer(this.depthStencilPackedBufferHandle);
        } else {
            if (this.bufferBuilder.hasDepthRenderBuffer) {
                gL20.glDeleteRenderbuffer(this.depthbufferHandle);
            }
            if (this.bufferBuilder.hasStencilRenderBuffer) {
                gL20.glDeleteRenderbuffer(this.stencilbufferHandle);
            }
        }
        gL20.glDeleteFramebuffer(this.framebufferHandle);
        if (buffers.get(Gdx.app) != null) {
            buffers.get(Gdx.app).removeValue(this, true);
        }
    }

    public void bind() {
        Gdx.gl20.glBindFramebuffer(36160, this.framebufferHandle);
    }

    public static void unbind() {
        Gdx.gl20.glBindFramebuffer(36160, defaultFramebufferHandle);
    }

    public void begin() {
        this.bind();
        this.setFrameBufferViewport();
    }

    protected void setFrameBufferViewport() {
        Gdx.gl20.glViewport(0, 0, this.bufferBuilder.width, this.bufferBuilder.height);
    }

    public void end() {
        this.end(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight());
    }

    public void end(int n2, int n3, int n4, int n5) {
        GLFrameBuffer.unbind();
        Gdx.gl20.glViewport(n2, n3, n4, n5);
    }

    public int getFramebufferHandle() {
        return this.framebufferHandle;
    }

    public int getDepthBufferHandle() {
        return this.depthbufferHandle;
    }

    public int getStencilBufferHandle() {
        return this.stencilbufferHandle;
    }

    protected int getDepthStencilPackedBuffer() {
        return this.depthStencilPackedBufferHandle;
    }

    public int getHeight() {
        return this.bufferBuilder.height;
    }

    public int getWidth() {
        return this.bufferBuilder.width;
    }

    private static void addManagedFrameBuffer(Application application, GLFrameBuffer gLFrameBuffer) {
        Array array = buffers.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(gLFrameBuffer);
        buffers.put(application, array);
    }

    public static void invalidateAllFrameBuffers(Application application) {
        if (Gdx.gl20 == null) {
            return;
        }
        Array<GLFrameBuffer> array = buffers.get(application);
        if (array == null) {
            return;
        }
        for (int i2 = 0; i2 < array.size; ++i2) {
            array.get(i2).build();
        }
    }

    public static void clearAllFrameBuffers(Application application) {
        buffers.remove(application);
    }

    public static StringBuilder getManagedStatus(StringBuilder stringBuilder) {
        stringBuilder.append("Managed buffers/app: { ");
        for (Application application : buffers.keySet()) {
            stringBuilder.append(GLFrameBuffer.buffers.get((Object)application).size);
            stringBuilder.append(" ");
        }
        stringBuilder.append("}");
        return stringBuilder;
    }

    public static String getManagedStatus() {
        return GLFrameBuffer.getManagedStatus(new StringBuilder()).toString();
    }

    static {
        defaultFramebufferHandleInitialized = false;
    }

    public static class FrameBufferCubemapBuilder
    extends GLFrameBufferBuilder<FrameBufferCubemap> {
        public FrameBufferCubemapBuilder(int n2, int n3) {
            super(n2, n3);
        }

        @Override
        public FrameBufferCubemap build() {
            return new FrameBufferCubemap(this);
        }
    }

    public static class FloatFrameBufferBuilder
    extends GLFrameBufferBuilder<FloatFrameBuffer> {
        public FloatFrameBufferBuilder(int n2, int n3) {
            super(n2, n3);
        }

        @Override
        public FloatFrameBuffer build() {
            return new FloatFrameBuffer(this);
        }
    }

    public static class FrameBufferBuilder
    extends GLFrameBufferBuilder<FrameBuffer> {
        public FrameBufferBuilder(int n2, int n3) {
            super(n2, n3);
        }

        @Override
        public FrameBuffer build() {
            return new FrameBuffer(this);
        }
    }

    public static abstract class GLFrameBufferBuilder<U extends GLFrameBuffer<? extends GLTexture>> {
        protected int width;
        protected int height;
        protected Array<FrameBufferTextureAttachmentSpec> textureAttachmentSpecs = new Array();
        protected FrameBufferRenderBufferAttachmentSpec stencilRenderBufferSpec;
        protected FrameBufferRenderBufferAttachmentSpec depthRenderBufferSpec;
        protected FrameBufferRenderBufferAttachmentSpec packedStencilDepthRenderBufferSpec;
        protected boolean hasStencilRenderBuffer;
        protected boolean hasDepthRenderBuffer;
        protected boolean hasPackedStencilDepthRenderBuffer;

        public GLFrameBufferBuilder(int n2, int n3) {
            this.width = n2;
            this.height = n3;
        }

        public GLFrameBufferBuilder<U> addColorTextureAttachment(int n2, int n3, int n4) {
            this.textureAttachmentSpecs.add(new FrameBufferTextureAttachmentSpec(n2, n3, n4));
            return this;
        }

        public GLFrameBufferBuilder<U> addBasicColorTextureAttachment(Pixmap.Format format) {
            int n2 = Pixmap.Format.toGlFormat(format);
            int n3 = Pixmap.Format.toGlType(format);
            return this.addColorTextureAttachment(n2, n2, n3);
        }

        public GLFrameBufferBuilder<U> addFloatAttachment(int n2, int n3, int n4, boolean bl2) {
            FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec = new FrameBufferTextureAttachmentSpec(n2, n3, n4);
            frameBufferTextureAttachmentSpec.isFloat = true;
            frameBufferTextureAttachmentSpec.isGpuOnly = bl2;
            this.textureAttachmentSpecs.add(frameBufferTextureAttachmentSpec);
            return this;
        }

        public GLFrameBufferBuilder<U> addDepthTextureAttachment(int n2, int n3) {
            FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec = new FrameBufferTextureAttachmentSpec(n2, 6402, n3);
            frameBufferTextureAttachmentSpec.isDepth = true;
            this.textureAttachmentSpecs.add(frameBufferTextureAttachmentSpec);
            return this;
        }

        public GLFrameBufferBuilder<U> addStencilTextureAttachment(int n2, int n3) {
            FrameBufferTextureAttachmentSpec frameBufferTextureAttachmentSpec = new FrameBufferTextureAttachmentSpec(n2, 36128, n3);
            frameBufferTextureAttachmentSpec.isStencil = true;
            this.textureAttachmentSpecs.add(frameBufferTextureAttachmentSpec);
            return this;
        }

        public GLFrameBufferBuilder<U> addDepthRenderBuffer(int n2) {
            this.depthRenderBufferSpec = new FrameBufferRenderBufferAttachmentSpec(n2);
            this.hasDepthRenderBuffer = true;
            return this;
        }

        public GLFrameBufferBuilder<U> addStencilRenderBuffer(int n2) {
            this.stencilRenderBufferSpec = new FrameBufferRenderBufferAttachmentSpec(n2);
            this.hasStencilRenderBuffer = true;
            return this;
        }

        public GLFrameBufferBuilder<U> addStencilDepthPackedRenderBuffer(int n2) {
            this.packedStencilDepthRenderBufferSpec = new FrameBufferRenderBufferAttachmentSpec(n2);
            this.hasPackedStencilDepthRenderBuffer = true;
            return this;
        }

        public GLFrameBufferBuilder<U> addBasicDepthRenderBuffer() {
            return this.addDepthRenderBuffer(33189);
        }

        public GLFrameBufferBuilder<U> addBasicStencilRenderBuffer() {
            return this.addStencilRenderBuffer(36168);
        }

        public GLFrameBufferBuilder<U> addBasicStencilDepthPackedRenderBuffer() {
            return this.addStencilDepthPackedRenderBuffer(35056);
        }

        public abstract U build();
    }

    protected static class FrameBufferRenderBufferAttachmentSpec {
        int internalFormat;

        public FrameBufferRenderBufferAttachmentSpec(int n2) {
            this.internalFormat = n2;
        }
    }

    protected static class FrameBufferTextureAttachmentSpec {
        int internalFormat;
        int format;
        int type;
        boolean isFloat;
        boolean isGpuOnly;
        boolean isDepth;
        boolean isStencil;

        public FrameBufferTextureAttachmentSpec(int n2, int n3, int n4) {
            this.internalFormat = n2;
            this.format = n3;
            this.type = n4;
        }

        public boolean isColorTexture() {
            return !this.isDepth && !this.isStencil;
        }
    }
}

