/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Array;

public class PixmapLoader
extends AsynchronousAssetLoader<Pixmap, PixmapParameter> {
    Pixmap pixmap;

    public PixmapLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, PixmapParameter pixmapParameter) {
        this.pixmap = null;
        this.pixmap = new Pixmap(fileHandle);
    }

    @Override
    public Pixmap loadSync(AssetManager assetManager, String string, FileHandle fileHandle, PixmapParameter pixmapParameter) {
        Pixmap pixmap = this.pixmap;
        this.pixmap = null;
        return pixmap;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, PixmapParameter pixmapParameter) {
        return null;
    }

    public static class PixmapParameter
    extends AssetLoaderParameters<Pixmap> {
    }
}

