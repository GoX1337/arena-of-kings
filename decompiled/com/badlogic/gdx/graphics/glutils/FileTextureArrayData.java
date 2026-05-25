/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureArrayData;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class FileTextureArrayData
implements TextureArrayData {
    private TextureData[] textureDatas;
    private boolean prepared;
    private Pixmap.Format format;
    private int depth;
    boolean useMipMaps;

    public FileTextureArrayData(Pixmap.Format format, boolean bl2, FileHandle[] fileHandleArray) {
        this.format = format;
        this.useMipMaps = bl2;
        this.depth = fileHandleArray.length;
        this.textureDatas = new TextureData[fileHandleArray.length];
        for (int i2 = 0; i2 < fileHandleArray.length; ++i2) {
            this.textureDatas[i2] = TextureData.Factory.loadFromFile(fileHandleArray[i2], format, bl2);
        }
    }

    @Override
    public boolean isPrepared() {
        return this.prepared;
    }

    @Override
    public void prepare() {
        int n2 = -1;
        int n3 = -1;
        for (TextureData textureData : this.textureDatas) {
            textureData.prepare();
            if (n2 == -1) {
                n2 = textureData.getWidth();
                n3 = textureData.getHeight();
                continue;
            }
            if (n2 == textureData.getWidth() && n3 == textureData.getHeight()) continue;
            throw new GdxRuntimeException("Error whilst preparing TextureArray: TextureArray Textures must have equal dimensions.");
        }
        this.prepared = true;
    }

    @Override
    public void consumeTextureArrayData() {
        boolean bl2 = false;
        for (int i2 = 0; i2 < this.textureDatas.length; ++i2) {
            if (this.textureDatas[i2].getType() == TextureData.TextureDataType.Custom) {
                this.textureDatas[i2].consumeCustomData(35866);
                bl2 = true;
                continue;
            }
            TextureData textureData = this.textureDatas[i2];
            Pixmap pixmap = textureData.consumePixmap();
            boolean bl3 = textureData.disposePixmap();
            if (textureData.getFormat() != pixmap.getFormat()) {
                Pixmap pixmap2 = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), textureData.getFormat());
                pixmap2.setBlending(Pixmap.Blending.None);
                pixmap2.drawPixmap(pixmap, 0, 0, 0, 0, pixmap.getWidth(), pixmap.getHeight());
                if (textureData.disposePixmap()) {
                    pixmap.dispose();
                }
                pixmap = pixmap2;
                bl3 = true;
            }
            Gdx.gl30.glTexSubImage3D(35866, 0, 0, 0, i2, pixmap.getWidth(), pixmap.getHeight(), 1, pixmap.getGLInternalFormat(), pixmap.getGLType(), pixmap.getPixels());
            if (!bl3) continue;
            pixmap.dispose();
        }
        if (this.useMipMaps && !bl2) {
            Gdx.gl20.glGenerateMipmap(35866);
        }
    }

    @Override
    public int getWidth() {
        return this.textureDatas[0].getWidth();
    }

    @Override
    public int getHeight() {
        return this.textureDatas[0].getHeight();
    }

    @Override
    public int getDepth() {
        return this.depth;
    }

    @Override
    public int getInternalFormat() {
        return Pixmap.Format.toGlFormat(this.format);
    }

    @Override
    public int getGLType() {
        return Pixmap.Format.toGlType(this.format);
    }

    @Override
    public boolean isManaged() {
        for (TextureData textureData : this.textureDatas) {
            if (textureData.isManaged()) continue;
            return false;
        }
        return true;
    }
}

