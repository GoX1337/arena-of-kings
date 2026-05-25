/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

public abstract class AsynchronousAssetLoader<T, P extends AssetLoaderParameters<T>>
extends AssetLoader<T, P> {
    public AsynchronousAssetLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public abstract void loadAsync(AssetManager var1, String var2, FileHandle var3, P var4);

    public void unloadAsync(AssetManager assetManager, String string, FileHandle fileHandle, P p2) {
    }

    public abstract T loadSync(AssetManager var1, String var2, FileHandle var3, P var4);
}

