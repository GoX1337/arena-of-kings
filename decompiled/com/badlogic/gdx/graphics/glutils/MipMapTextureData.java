/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class MipMapTextureData
implements TextureData {
    TextureData[] mips;

    public MipMapTextureData(TextureData ... textureDataArray) {
        this.mips = new TextureData[textureDataArray.length];
        System.arraycopy(textureDataArray, 0, this.mips, 0, textureDataArray.length);
    }

    @Override
    public TextureData.TextureDataType getType() {
        return TextureData.TextureDataType.Custom;
    }

    @Override
    public boolean isPrepared() {
        return true;
    }

    @Override
    public void prepare() {
    }

    @Override
    public Pixmap consumePixmap() {
        throw new GdxRuntimeException("It's compressed, use the compressed method");
    }

    @Override
    public boolean disposePixmap() {
        return false;
    }

    @Override
    public void consumeCustomData(int n2) {
        for (int i2 = 0; i2 < this.mips.length; ++i2) {
            GLTexture.uploadImageData(n2, this.mips[i2], i2);
        }
    }

    @Override
    public int getWidth() {
        return this.mips[0].getWidth();
    }

    @Override
    public int getHeight() {
        return this.mips[0].getHeight();
    }

    @Override
    public Pixmap.Format getFormat() {
        return this.mips[0].getFormat();
    }

    @Override
    public boolean useMipMaps() {
        return false;
    }

    @Override
    public boolean isManaged() {
        return true;
    }
}

