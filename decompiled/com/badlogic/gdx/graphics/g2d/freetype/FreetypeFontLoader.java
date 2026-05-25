/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g2d.freetype;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;

public class FreetypeFontLoader
extends AsynchronousAssetLoader<BitmapFont, FreeTypeFontLoaderParameter> {
    public FreetypeFontLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, FreeTypeFontLoaderParameter freeTypeFontLoaderParameter) {
        if (freeTypeFontLoaderParameter == null) {
            throw new RuntimeException("FreetypeFontParameter must be set in AssetManager#load to point at a TTF file!");
        }
    }

    @Override
    public BitmapFont loadSync(AssetManager assetManager, String string, FileHandle fileHandle, FreeTypeFontLoaderParameter freeTypeFontLoaderParameter) {
        if (freeTypeFontLoaderParameter == null) {
            throw new RuntimeException("FreetypeFontParameter must be set in AssetManager#load to point at a TTF file!");
        }
        FreeTypeFontGenerator freeTypeFontGenerator = assetManager.get(freeTypeFontLoaderParameter.fontFileName + ".gen", FreeTypeFontGenerator.class);
        BitmapFont bitmapFont = freeTypeFontGenerator.generateFont(freeTypeFontLoaderParameter.fontParameters);
        return bitmapFont;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, FreeTypeFontLoaderParameter freeTypeFontLoaderParameter) {
        Array<AssetDescriptor> array = new Array<AssetDescriptor>();
        array.add(new AssetDescriptor<FreeTypeFontGenerator>(freeTypeFontLoaderParameter.fontFileName + ".gen", FreeTypeFontGenerator.class));
        return array;
    }

    public static class FreeTypeFontLoaderParameter
    extends AssetLoaderParameters<BitmapFont> {
        public String fontFileName;
        public FreeTypeFontGenerator.FreeTypeFontParameter fontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
    }
}

