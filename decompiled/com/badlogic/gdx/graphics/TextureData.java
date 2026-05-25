/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.glutils.ETC1TextureData;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.badlogic.gdx.graphics.glutils.KTXTextureData;

public interface TextureData {
    public TextureDataType getType();

    public boolean isPrepared();

    public void prepare();

    public Pixmap consumePixmap();

    public boolean disposePixmap();

    public void consumeCustomData(int var1);

    public int getWidth();

    public int getHeight();

    public Pixmap.Format getFormat();

    public boolean useMipMaps();

    public boolean isManaged();

    public static class Factory {
        public static TextureData loadFromFile(FileHandle fileHandle, boolean bl2) {
            return Factory.loadFromFile(fileHandle, null, bl2);
        }

        public static TextureData loadFromFile(FileHandle fileHandle, Pixmap.Format format, boolean bl2) {
            if (fileHandle == null) {
                return null;
            }
            if (fileHandle.name().endsWith(".cim")) {
                return new FileTextureData(fileHandle, PixmapIO.readCIM(fileHandle), format, bl2);
            }
            if (fileHandle.name().endsWith(".etc1")) {
                return new ETC1TextureData(fileHandle, bl2);
            }
            if (fileHandle.name().endsWith(".ktx") || fileHandle.name().endsWith(".zktx")) {
                return new KTXTextureData(fileHandle, bl2);
            }
            return new FileTextureData(fileHandle, new Pixmap(fileHandle), format, bl2);
        }
    }

    public static enum TextureDataType {
        Pixmap,
        Custom;

    }
}

