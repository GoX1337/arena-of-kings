/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureArrayData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.HashMap;
import java.util.Map;

public class TextureArray
extends GLTexture {
    static final Map<Application, Array<TextureArray>> managedTextureArrays = new HashMap<Application, Array<TextureArray>>();
    private TextureArrayData data;

    public TextureArray(String ... stringArray) {
        this(TextureArray.getInternalHandles(stringArray));
    }

    public TextureArray(FileHandle ... fileHandleArray) {
        this(false, fileHandleArray);
    }

    public TextureArray(boolean bl2, FileHandle ... fileHandleArray) {
        this(bl2, Pixmap.Format.RGBA8888, fileHandleArray);
    }

    public TextureArray(boolean bl2, Pixmap.Format format, FileHandle ... fileHandleArray) {
        this(TextureArrayData.Factory.loadFromFiles(format, bl2, fileHandleArray));
    }

    public TextureArray(TextureArrayData textureArrayData) {
        super(35866, Gdx.gl.glGenTexture());
        if (Gdx.gl30 == null) {
            throw new GdxRuntimeException("TextureArray requires a device running with GLES 3.0 compatibilty");
        }
        this.load(textureArrayData);
        if (textureArrayData.isManaged()) {
            TextureArray.addManagedTexture(Gdx.app, this);
        }
    }

    private static FileHandle[] getInternalHandles(String ... stringArray) {
        FileHandle[] fileHandleArray = new FileHandle[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            fileHandleArray[i2] = Gdx.files.internal(stringArray[i2]);
        }
        return fileHandleArray;
    }

    private void load(TextureArrayData textureArrayData) {
        if (this.data != null && textureArrayData.isManaged() != this.data.isManaged()) {
            throw new GdxRuntimeException("New data must have the same managed status as the old data");
        }
        this.data = textureArrayData;
        this.bind();
        Gdx.gl30.glTexImage3D(35866, 0, textureArrayData.getInternalFormat(), textureArrayData.getWidth(), textureArrayData.getHeight(), textureArrayData.getDepth(), 0, textureArrayData.getInternalFormat(), textureArrayData.getGLType(), null);
        if (!textureArrayData.isPrepared()) {
            textureArrayData.prepare();
        }
        textureArrayData.consumeTextureArrayData();
        this.setFilter(this.minFilter, this.magFilter);
        this.setWrap(this.uWrap, this.vWrap);
        Gdx.gl.glBindTexture(this.glTarget, 0);
    }

    @Override
    public int getWidth() {
        return this.data.getWidth();
    }

    @Override
    public int getHeight() {
        return this.data.getHeight();
    }

    @Override
    public int getDepth() {
        return this.data.getDepth();
    }

    @Override
    public boolean isManaged() {
        return this.data.isManaged();
    }

    @Override
    protected void reload() {
        if (!this.isManaged()) {
            throw new GdxRuntimeException("Tried to reload an unmanaged TextureArray");
        }
        this.glHandle = Gdx.gl.glGenTexture();
        this.load(this.data);
    }

    private static void addManagedTexture(Application application, TextureArray textureArray) {
        Array<TextureArray> array = managedTextureArrays.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(textureArray);
        managedTextureArrays.put(application, array);
    }

    public static void clearAllTextureArrays(Application application) {
        managedTextureArrays.remove(application);
    }

    public static void invalidateAllTextureArrays(Application application) {
        Array<TextureArray> array = managedTextureArrays.get(application);
        if (array == null) {
            return;
        }
        for (int i2 = 0; i2 < array.size; ++i2) {
            TextureArray textureArray = array.get(i2);
            textureArray.reload();
        }
    }

    public static String getManagedStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Managed TextureArrays/app: { ");
        for (Application application : managedTextureArrays.keySet()) {
            stringBuilder.append(TextureArray.managedTextureArrays.get((Object)application).size);
            stringBuilder.append(" ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static int getNumManagedTextureArrays() {
        return TextureArray.managedTextureArrays.get((Object)Gdx.app).size;
    }
}

