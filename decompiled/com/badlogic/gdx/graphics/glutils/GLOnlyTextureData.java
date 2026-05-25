/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class GLOnlyTextureData
implements TextureData {
    int width = 0;
    int height = 0;
    boolean isPrepared = false;
    int mipLevel = 0;
    int internalFormat;
    int format;
    int type;

    public GLOnlyTextureData(int n2, int n3, int n4, int n5, int n6, int n7) {
        this.width = n2;
        this.height = n3;
        this.mipLevel = n4;
        this.internalFormat = n5;
        this.format = n6;
        this.type = n7;
    }

    @Override
    public TextureData.TextureDataType getType() {
        return TextureData.TextureDataType.Custom;
    }

    @Override
    public boolean isPrepared() {
        return this.isPrepared;
    }

    @Override
    public void prepare() {
        if (this.isPrepared) {
            throw new GdxRuntimeException("Already prepared");
        }
        this.isPrepared = true;
    }

    @Override
    public void consumeCustomData(int n2) {
        Gdx.gl.glTexImage2D(n2, this.mipLevel, this.internalFormat, this.width, this.height, 0, this.format, this.type, null);
    }

    @Override
    public Pixmap consumePixmap() {
        throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
    }

    @Override
    public boolean disposePixmap() {
        throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Pixmap.Format getFormat() {
        return Pixmap.Format.RGBA8888;
    }

    @Override
    public boolean useMipMaps() {
        return false;
    }

    @Override
    public boolean isManaged() {
        return false;
    }
}

