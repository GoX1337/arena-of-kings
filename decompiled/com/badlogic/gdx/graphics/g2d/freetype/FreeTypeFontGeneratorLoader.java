/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d.freetype;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;

public class FreeTypeFontGeneratorLoader
extends SynchronousAssetLoader<FreeTypeFontGenerator, FreeTypeFontGeneratorParameters> {
    public FreeTypeFontGeneratorLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public FreeTypeFontGenerator load(AssetManager assetManager, String string, FileHandle fileHandle, FreeTypeFontGeneratorParameters freeTypeFontGeneratorParameters) {
        FreeTypeFontGenerator freeTypeFontGenerator = null;
        freeTypeFontGenerator = fileHandle.extension().equals("gen") ? new FreeTypeFontGenerator(fileHandle.sibling(fileHandle.nameWithoutExtension())) : new FreeTypeFontGenerator(fileHandle);
        return freeTypeFontGenerator;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, FreeTypeFontGeneratorParameters freeTypeFontGeneratorParameters) {
        return null;
    }

    public static class FreeTypeFontGeneratorParameters
    extends AssetLoaderParameters<FreeTypeFontGenerator> {
    }
}

