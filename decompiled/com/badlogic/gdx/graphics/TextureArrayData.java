/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.glutils.FileTextureArrayData;

public interface TextureArrayData {
    public boolean isPrepared();

    public void prepare();

    public void consumeTextureArrayData();

    public int getWidth();

    public int getHeight();

    public int getDepth();

    public boolean isManaged();

    public int getInternalFormat();

    public int getGLType();

    public static class Factory {
        public static TextureArrayData loadFromFiles(Pixmap.Format format, boolean bl2, FileHandle ... fileHandleArray) {
            return new FileTextureArrayData(format, bl2, fileHandleArray);
        }
    }
}

