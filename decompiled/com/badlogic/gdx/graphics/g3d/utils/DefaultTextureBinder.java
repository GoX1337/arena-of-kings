/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.g3d.utils.TextureBinder;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.IntBuffer;

public final class DefaultTextureBinder
implements TextureBinder {
    public static final int ROUNDROBIN = 0;
    public static final int LRU = 1;
    public static final int MAX_GLES_UNITS = 32;
    private final int offset;
    private final int count;
    private final GLTexture[] textures;
    private int[] unitsLRU;
    private final int method;
    private boolean reused;
    private int reuseCount = 0;
    private int bindCount = 0;
    private final TextureDescriptor tempDesc = new TextureDescriptor();
    private int currentTexture = 0;

    public DefaultTextureBinder(int n2) {
        this(n2, 0);
    }

    public DefaultTextureBinder(int n2, int n3) {
        this(n2, n3, -1);
    }

    public DefaultTextureBinder(int n2, int n3, int n4) {
        int n5 = Math.min(DefaultTextureBinder.getMaxTextureUnits(), 32);
        if (n4 < 0) {
            n4 = n5 - n3;
        }
        if (n3 < 0 || n4 < 0 || n3 + n4 > n5) {
            throw new GdxRuntimeException("Illegal arguments");
        }
        this.method = n2;
        this.offset = n3;
        this.count = n4;
        this.textures = new GLTexture[n4];
        this.unitsLRU = n2 == 1 ? new int[n4] : null;
    }

    private static int getMaxTextureUnits() {
        IntBuffer intBuffer = BufferUtils.newIntBuffer(16);
        Gdx.gl.glGetIntegerv(34930, intBuffer);
        return intBuffer.get(0);
    }

    @Override
    public void begin() {
        for (int i2 = 0; i2 < this.count; ++i2) {
            this.textures[i2] = null;
            if (this.unitsLRU == null) continue;
            this.unitsLRU[i2] = i2;
        }
    }

    @Override
    public void end() {
        Gdx.gl.glActiveTexture(33984);
    }

    @Override
    public final int bind(TextureDescriptor textureDescriptor) {
        return this.bindTexture(textureDescriptor, false);
    }

    @Override
    public final int bind(GLTexture gLTexture) {
        this.tempDesc.set(gLTexture, null, null, null, null);
        return this.bindTexture(this.tempDesc, false);
    }

    private final int bindTexture(TextureDescriptor textureDescriptor, boolean bl2) {
        int n2;
        Object t2 = textureDescriptor.texture;
        this.reused = false;
        switch (this.method) {
            case 0: {
                int n3 = this.bindTextureRoundRobin((GLTexture)t2);
                n2 = this.offset + n3;
                break;
            }
            case 1: {
                int n4 = this.bindTextureLRU((GLTexture)t2);
                n2 = this.offset + n4;
                break;
            }
            default: {
                return -1;
            }
        }
        if (this.reused) {
            ++this.reuseCount;
            if (bl2) {
                ((GLTexture)t2).bind(n2);
            } else {
                Gdx.gl.glActiveTexture(33984 + n2);
            }
        } else {
            ++this.bindCount;
        }
        ((GLTexture)t2).unsafeSetWrap(textureDescriptor.uWrap, textureDescriptor.vWrap);
        ((GLTexture)t2).unsafeSetFilter(textureDescriptor.minFilter, textureDescriptor.magFilter);
        return n2;
    }

    private final int bindTextureRoundRobin(GLTexture gLTexture) {
        for (int i2 = 0; i2 < this.count; ++i2) {
            int n2 = (this.currentTexture + i2) % this.count;
            if (this.textures[n2] != gLTexture) continue;
            this.reused = true;
            return n2;
        }
        this.currentTexture = (this.currentTexture + 1) % this.count;
        this.textures[this.currentTexture] = gLTexture;
        gLTexture.bind(this.offset + this.currentTexture);
        return this.currentTexture;
    }

    private final int bindTextureLRU(GLTexture gLTexture) {
        int n2;
        int n3;
        for (n3 = 0; n3 < this.count; ++n3) {
            n2 = this.unitsLRU[n3];
            if (this.textures[n2] == gLTexture) {
                this.reused = true;
                break;
            }
            if (this.textures[n2] == null) break;
        }
        if (n3 >= this.count) {
            n3 = this.count - 1;
        }
        n2 = this.unitsLRU[n3];
        while (n3 > 0) {
            this.unitsLRU[n3] = this.unitsLRU[n3 - 1];
            --n3;
        }
        this.unitsLRU[0] = n2;
        if (!this.reused) {
            this.textures[n2] = gLTexture;
            gLTexture.bind(this.offset + n2);
        }
        return n2;
    }

    @Override
    public final int getBindCount() {
        return this.bindCount;
    }

    @Override
    public final int getReuseCount() {
        return this.reuseCount;
    }

    @Override
    public final void resetCounts() {
        this.reuseCount = 0;
        this.bindCount = 0;
    }
}

