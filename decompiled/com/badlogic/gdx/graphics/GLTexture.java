/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.MipMapGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public abstract class GLTexture
implements Disposable {
    public final int glTarget;
    protected int glHandle;
    protected Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
    protected Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
    protected Texture.TextureWrap uWrap = Texture.TextureWrap.ClampToEdge;
    protected Texture.TextureWrap vWrap = Texture.TextureWrap.ClampToEdge;
    protected float anisotropicFilterLevel = 1.0f;
    private static float maxAnisotropicFilterLevel = 0.0f;

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract int getDepth();

    public GLTexture(int n2) {
        this(n2, Gdx.gl.glGenTexture());
    }

    public GLTexture(int n2, int n3) {
        this.glTarget = n2;
        this.glHandle = n3;
    }

    public abstract boolean isManaged();

    protected abstract void reload();

    public void bind() {
        Gdx.gl.glBindTexture(this.glTarget, this.glHandle);
    }

    public void bind(int n2) {
        Gdx.gl.glActiveTexture(33984 + n2);
        Gdx.gl.glBindTexture(this.glTarget, this.glHandle);
    }

    public Texture.TextureFilter getMinFilter() {
        return this.minFilter;
    }

    public Texture.TextureFilter getMagFilter() {
        return this.magFilter;
    }

    public Texture.TextureWrap getUWrap() {
        return this.uWrap;
    }

    public Texture.TextureWrap getVWrap() {
        return this.vWrap;
    }

    public int getTextureObjectHandle() {
        return this.glHandle;
    }

    public void unsafeSetWrap(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        this.unsafeSetWrap(textureWrap, textureWrap2, false);
    }

    public void unsafeSetWrap(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2, boolean bl2) {
        if (textureWrap != null && (bl2 || this.uWrap != textureWrap)) {
            Gdx.gl.glTexParameteri(this.glTarget, 10242, textureWrap.getGLEnum());
            this.uWrap = textureWrap;
        }
        if (textureWrap2 != null && (bl2 || this.vWrap != textureWrap2)) {
            Gdx.gl.glTexParameteri(this.glTarget, 10243, textureWrap2.getGLEnum());
            this.vWrap = textureWrap2;
        }
    }

    public void setWrap(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        this.uWrap = textureWrap;
        this.vWrap = textureWrap2;
        this.bind();
        Gdx.gl.glTexParameteri(this.glTarget, 10242, textureWrap.getGLEnum());
        Gdx.gl.glTexParameteri(this.glTarget, 10243, textureWrap2.getGLEnum());
    }

    public void unsafeSetFilter(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2) {
        this.unsafeSetFilter(textureFilter, textureFilter2, false);
    }

    public void unsafeSetFilter(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean bl2) {
        if (textureFilter != null && (bl2 || this.minFilter != textureFilter)) {
            Gdx.gl.glTexParameteri(this.glTarget, 10241, textureFilter.getGLEnum());
            this.minFilter = textureFilter;
        }
        if (textureFilter2 != null && (bl2 || this.magFilter != textureFilter2)) {
            Gdx.gl.glTexParameteri(this.glTarget, 10240, textureFilter2.getGLEnum());
            this.magFilter = textureFilter2;
        }
    }

    public void setFilter(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2) {
        this.minFilter = textureFilter;
        this.magFilter = textureFilter2;
        this.bind();
        Gdx.gl.glTexParameteri(this.glTarget, 10241, textureFilter.getGLEnum());
        Gdx.gl.glTexParameteri(this.glTarget, 10240, textureFilter2.getGLEnum());
    }

    public float unsafeSetAnisotropicFilter(float f2) {
        return this.unsafeSetAnisotropicFilter(f2, false);
    }

    public float unsafeSetAnisotropicFilter(float f2, boolean bl2) {
        float f3 = GLTexture.getMaxAnisotropicFilterLevel();
        if (f3 == 1.0f) {
            return 1.0f;
        }
        f2 = Math.min(f2, f3);
        if (!bl2 && MathUtils.isEqual(f2, this.anisotropicFilterLevel, 0.1f)) {
            return this.anisotropicFilterLevel;
        }
        Gdx.gl20.glTexParameterf(3553, 34046, f2);
        this.anisotropicFilterLevel = f2;
        return this.anisotropicFilterLevel;
    }

    public float setAnisotropicFilter(float f2) {
        float f3 = GLTexture.getMaxAnisotropicFilterLevel();
        if (f3 == 1.0f) {
            return 1.0f;
        }
        if (MathUtils.isEqual(f2 = Math.min(f2, f3), this.anisotropicFilterLevel, 0.1f)) {
            return f2;
        }
        this.bind();
        Gdx.gl20.glTexParameterf(3553, 34046, f2);
        this.anisotropicFilterLevel = f2;
        return this.anisotropicFilterLevel;
    }

    public float getAnisotropicFilter() {
        return this.anisotropicFilterLevel;
    }

    public static float getMaxAnisotropicFilterLevel() {
        if (maxAnisotropicFilterLevel > 0.0f) {
            return maxAnisotropicFilterLevel;
        }
        if (Gdx.graphics.supportsExtension("GL_EXT_texture_filter_anisotropic")) {
            FloatBuffer floatBuffer = BufferUtils.newFloatBuffer(16);
            ((Buffer)floatBuffer).position(0);
            ((Buffer)floatBuffer).limit(floatBuffer.capacity());
            Gdx.gl20.glGetFloatv(34047, floatBuffer);
            maxAnisotropicFilterLevel = floatBuffer.get(0);
            return maxAnisotropicFilterLevel;
        }
        maxAnisotropicFilterLevel = 1.0f;
        return 1.0f;
    }

    protected void delete() {
        if (this.glHandle != 0) {
            Gdx.gl.glDeleteTexture(this.glHandle);
            this.glHandle = 0;
        }
    }

    @Override
    public void dispose() {
        this.delete();
    }

    protected static void uploadImageData(int n2, TextureData textureData) {
        GLTexture.uploadImageData(n2, textureData, 0);
    }

    public static void uploadImageData(int n2, TextureData textureData, int n3) {
        TextureData.TextureDataType textureDataType;
        if (textureData == null) {
            return;
        }
        if (!textureData.isPrepared()) {
            textureData.prepare();
        }
        if ((textureDataType = textureData.getType()) == TextureData.TextureDataType.Custom) {
            textureData.consumeCustomData(n2);
            return;
        }
        Pixmap pixmap = textureData.consumePixmap();
        boolean bl2 = textureData.disposePixmap();
        if (textureData.getFormat() != pixmap.getFormat()) {
            Pixmap pixmap2 = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), textureData.getFormat());
            pixmap2.setBlending(Pixmap.Blending.None);
            pixmap2.drawPixmap(pixmap, 0, 0, 0, 0, pixmap.getWidth(), pixmap.getHeight());
            if (textureData.disposePixmap()) {
                pixmap.dispose();
            }
            pixmap = pixmap2;
            bl2 = true;
        }
        Gdx.gl.glPixelStorei(3317, 1);
        if (textureData.useMipMaps()) {
            MipMapGenerator.generateMipMap(n2, pixmap, pixmap.getWidth(), pixmap.getHeight());
        } else {
            Gdx.gl.glTexImage2D(n2, n3, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
        }
        if (bl2) {
            pixmap.dispose();
        }
    }
}

