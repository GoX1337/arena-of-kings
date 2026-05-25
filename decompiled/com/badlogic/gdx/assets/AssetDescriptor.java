/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.files.FileHandle;

public class AssetDescriptor<T> {
    public final String fileName;
    public final Class<T> type;
    public final AssetLoaderParameters params;
    public FileHandle file;

    public AssetDescriptor(String string, Class<T> clazz) {
        this(string, clazz, null);
    }

    public AssetDescriptor(FileHandle fileHandle, Class<T> clazz) {
        this(fileHandle, clazz, null);
    }

    public AssetDescriptor(String string, Class<T> clazz, AssetLoaderParameters<T> assetLoaderParameters) {
        this.fileName = string;
        this.type = clazz;
        this.params = assetLoaderParameters;
    }

    public AssetDescriptor(FileHandle fileHandle, Class<T> clazz, AssetLoaderParameters<T> assetLoaderParameters) {
        this.fileName = fileHandle.path();
        this.file = fileHandle;
        this.type = clazz;
        this.params = assetLoaderParameters;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.fileName);
        stringBuilder.append(", ");
        stringBuilder.append(this.type.getName());
        return stringBuilder.toString();
    }
}

