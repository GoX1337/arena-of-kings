/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.CubemapData;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class FacedCubemapData
implements CubemapData {
    protected final TextureData[] data = new TextureData[6];

    public FacedCubemapData() {
        this((TextureData)null, (TextureData)null, (TextureData)null, (TextureData)null, (TextureData)null, (TextureData)null);
    }

    public FacedCubemapData(FileHandle fileHandle, FileHandle fileHandle2, FileHandle fileHandle3, FileHandle fileHandle4, FileHandle fileHandle5, FileHandle fileHandle6) {
        this(TextureData.Factory.loadFromFile(fileHandle, false), TextureData.Factory.loadFromFile(fileHandle2, false), TextureData.Factory.loadFromFile(fileHandle3, false), TextureData.Factory.loadFromFile(fileHandle4, false), TextureData.Factory.loadFromFile(fileHandle5, false), TextureData.Factory.loadFromFile(fileHandle6, false));
    }

    public FacedCubemapData(FileHandle fileHandle, FileHandle fileHandle2, FileHandle fileHandle3, FileHandle fileHandle4, FileHandle fileHandle5, FileHandle fileHandle6, boolean bl2) {
        this(TextureData.Factory.loadFromFile(fileHandle, bl2), TextureData.Factory.loadFromFile(fileHandle2, bl2), TextureData.Factory.loadFromFile(fileHandle3, bl2), TextureData.Factory.loadFromFile(fileHandle4, bl2), TextureData.Factory.loadFromFile(fileHandle5, bl2), TextureData.Factory.loadFromFile(fileHandle6, bl2));
    }

    public FacedCubemapData(Pixmap pixmap, Pixmap pixmap2, Pixmap pixmap3, Pixmap pixmap4, Pixmap pixmap5, Pixmap pixmap6) {
        this(pixmap, pixmap2, pixmap3, pixmap4, pixmap5, pixmap6, false);
    }

    public FacedCubemapData(Pixmap pixmap, Pixmap pixmap2, Pixmap pixmap3, Pixmap pixmap4, Pixmap pixmap5, Pixmap pixmap6, boolean bl2) {
        this(pixmap == null ? null : new PixmapTextureData(pixmap, null, bl2, false), pixmap2 == null ? null : new PixmapTextureData(pixmap2, null, bl2, false), pixmap3 == null ? null : new PixmapTextureData(pixmap3, null, bl2, false), pixmap4 == null ? null : new PixmapTextureData(pixmap4, null, bl2, false), pixmap5 == null ? null : new PixmapTextureData(pixmap5, null, bl2, false), pixmap6 == null ? null : new PixmapTextureData(pixmap6, null, bl2, false));
    }

    public FacedCubemapData(int n2, int n3, int n4, Pixmap.Format format) {
        this(new PixmapTextureData(new Pixmap(n4, n3, format), null, false, true), new PixmapTextureData(new Pixmap(n4, n3, format), null, false, true), new PixmapTextureData(new Pixmap(n2, n4, format), null, false, true), new PixmapTextureData(new Pixmap(n2, n4, format), null, false, true), new PixmapTextureData(new Pixmap(n2, n3, format), null, false, true), new PixmapTextureData(new Pixmap(n2, n3, format), null, false, true));
    }

    public FacedCubemapData(TextureData textureData, TextureData textureData2, TextureData textureData3, TextureData textureData4, TextureData textureData5, TextureData textureData6) {
        this.data[0] = textureData;
        this.data[1] = textureData2;
        this.data[2] = textureData3;
        this.data[3] = textureData4;
        this.data[4] = textureData5;
        this.data[5] = textureData6;
    }

    @Override
    public boolean isManaged() {
        for (TextureData textureData : this.data) {
            if (textureData.isManaged()) continue;
            return false;
        }
        return true;
    }

    public void load(Cubemap.CubemapSide cubemapSide, FileHandle fileHandle) {
        this.data[cubemapSide.index] = TextureData.Factory.loadFromFile(fileHandle, false);
    }

    public void load(Cubemap.CubemapSide cubemapSide, Pixmap pixmap) {
        this.data[cubemapSide.index] = pixmap == null ? null : new PixmapTextureData(pixmap, null, false, false);
    }

    public boolean isComplete() {
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            if (this.data[i2] != null) continue;
            return false;
        }
        return true;
    }

    public TextureData getTextureData(Cubemap.CubemapSide cubemapSide) {
        return this.data[cubemapSide.index];
    }

    @Override
    public int getWidth() {
        int n2;
        int n3 = 0;
        if (this.data[Cubemap.CubemapSide.PositiveZ.index] != null && (n2 = this.data[Cubemap.CubemapSide.PositiveZ.index].getWidth()) > n3) {
            n3 = n2;
        }
        if (this.data[Cubemap.CubemapSide.NegativeZ.index] != null && (n2 = this.data[Cubemap.CubemapSide.NegativeZ.index].getWidth()) > n3) {
            n3 = n2;
        }
        if (this.data[Cubemap.CubemapSide.PositiveY.index] != null && (n2 = this.data[Cubemap.CubemapSide.PositiveY.index].getWidth()) > n3) {
            n3 = n2;
        }
        if (this.data[Cubemap.CubemapSide.NegativeY.index] != null && (n2 = this.data[Cubemap.CubemapSide.NegativeY.index].getWidth()) > n3) {
            n3 = n2;
        }
        return n3;
    }

    @Override
    public int getHeight() {
        int n2;
        int n3 = 0;
        if (this.data[Cubemap.CubemapSide.PositiveZ.index] != null && (n2 = this.data[Cubemap.CubemapSide.PositiveZ.index].getHeight()) > n3) {
            n3 = n2;
        }
        if (this.data[Cubemap.CubemapSide.NegativeZ.index] != null && (n2 = this.data[Cubemap.CubemapSide.NegativeZ.index].getHeight()) > n3) {
            n3 = n2;
        }
        if (this.data[Cubemap.CubemapSide.PositiveX.index] != null && (n2 = this.data[Cubemap.CubemapSide.PositiveX.index].getHeight()) > n3) {
            n3 = n2;
        }
        if (this.data[Cubemap.CubemapSide.NegativeX.index] != null && (n2 = this.data[Cubemap.CubemapSide.NegativeX.index].getHeight()) > n3) {
            n3 = n2;
        }
        return n3;
    }

    @Override
    public boolean isPrepared() {
        return false;
    }

    @Override
    public void prepare() {
        if (!this.isComplete()) {
            throw new GdxRuntimeException("You need to complete your cubemap data before using it");
        }
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            if (this.data[i2].isPrepared()) continue;
            this.data[i2].prepare();
        }
    }

    @Override
    public void consumeCubemapData() {
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            if (this.data[i2].getType() == TextureData.TextureDataType.Custom) {
                this.data[i2].consumeCustomData(34069 + i2);
                continue;
            }
            Pixmap pixmap = this.data[i2].consumePixmap();
            boolean bl2 = this.data[i2].disposePixmap();
            if (this.data[i2].getFormat() != pixmap.getFormat()) {
                Pixmap pixmap2 = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), this.data[i2].getFormat());
                pixmap2.setBlending(Pixmap.Blending.None);
                pixmap2.drawPixmap(pixmap, 0, 0, 0, 0, pixmap.getWidth(), pixmap.getHeight());
                if (this.data[i2].disposePixmap()) {
                    pixmap.dispose();
                }
                pixmap = pixmap2;
                bl2 = true;
            }
            Gdx.gl.glPixelStorei(3317, 1);
            Gdx.gl.glTexImage2D(34069 + i2, 0, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
            if (!bl2) continue;
            pixmap.dispose();
        }
    }
}

