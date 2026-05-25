/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class PixmapTextureData
implements TextureData {
    final Pixmap pixmap;
    final Pixmap.Format format;
    final boolean useMipMaps;
    final boolean disposePixmap;
    final boolean managed;

    public PixmapTextureData(Pixmap pixmap, Pixmap.Format format, boolean bl2, boolean bl3) {
        this(pixmap, format, bl2, bl3, false);
    }

    public PixmapTextureData(Pixmap pixmap, Pixmap.Format format, boolean bl2, boolean bl3, boolean bl4) {
        this.pixmap = pixmap;
        this.format = format == null ? pixmap.getFormat() : format;
        this.useMipMaps = bl2;
        this.disposePixmap = bl3;
        this.managed = bl4;
    }

    @Override
    public boolean disposePixmap() {
        return this.disposePixmap;
    }

    @Override
    public Pixmap consumePixmap() {
        return this.pixmap;
    }

    @Override
    public int getWidth() {
        return this.pixmap.getWidth();
    }

    @Override
    public int getHeight() {
        return this.pixmap.getHeight();
    }

    @Override
    public Pixmap.Format getFormat() {
        return this.format;
    }

    @Override
    public boolean useMipMaps() {
        return this.useMipMaps;
    }

    @Override
    public boolean isManaged() {
        return this.managed;
    }

    @Override
    public TextureData.TextureDataType getType() {
        return TextureData.TextureDataType.Pixmap;
    }

    @Override
    public void consumeCustomData(int n2) {
        throw new GdxRuntimeException("This TextureData implementation does not upload data itself");
    }

    @Override
    public boolean isPrepared() {
        return true;
    }

    @Override
    public void prepare() {
        throw new GdxRuntimeException("prepare() must not be called on a PixmapTextureData instance as it is already prepared.");
    }
}

