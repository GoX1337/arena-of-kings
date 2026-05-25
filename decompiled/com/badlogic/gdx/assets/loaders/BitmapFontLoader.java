/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class BitmapFontLoader
extends AsynchronousAssetLoader<BitmapFont, BitmapFontParameter> {
    BitmapFont.BitmapFontData data;

    public BitmapFontLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, BitmapFontParameter bitmapFontParameter) {
        Array<AssetDescriptor> array = new Array<AssetDescriptor>();
        if (bitmapFontParameter != null && bitmapFontParameter.bitmapFontData != null) {
            this.data = bitmapFontParameter.bitmapFontData;
            return array;
        }
        this.data = new BitmapFont.BitmapFontData(fileHandle, bitmapFontParameter != null && bitmapFontParameter.flip);
        if (bitmapFontParameter != null && bitmapFontParameter.atlasName != null) {
            array.add(new AssetDescriptor<TextureAtlas>(bitmapFontParameter.atlasName, TextureAtlas.class));
        } else {
            for (int i2 = 0; i2 < this.data.getImagePaths().length; ++i2) {
                String string2 = this.data.getImagePath(i2);
                FileHandle fileHandle2 = this.resolve(string2);
                TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();
                if (bitmapFontParameter != null) {
                    textureParameter.genMipMaps = bitmapFontParameter.genMipMaps;
                    textureParameter.minFilter = bitmapFontParameter.minFilter;
                    textureParameter.magFilter = bitmapFontParameter.magFilter;
                }
                AssetDescriptor<Texture> assetDescriptor = new AssetDescriptor<Texture>(fileHandle2, Texture.class, textureParameter);
                array.add(assetDescriptor);
            }
        }
        return array;
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, BitmapFontParameter bitmapFontParameter) {
    }

    @Override
    public BitmapFont loadSync(AssetManager assetManager, String string, FileHandle fileHandle, BitmapFontParameter bitmapFontParameter) {
        if (bitmapFontParameter != null && bitmapFontParameter.atlasName != null) {
            String string2;
            TextureAtlas textureAtlas = assetManager.get(bitmapFontParameter.atlasName, TextureAtlas.class);
            TextureAtlas.AtlasRegion atlasRegion = textureAtlas.findRegion(string2 = fileHandle.sibling(this.data.imagePaths[0]).nameWithoutExtension().toString());
            if (atlasRegion == null) {
                throw new GdxRuntimeException("Could not find font region " + string2 + " in atlas " + bitmapFontParameter.atlasName);
            }
            return new BitmapFont(fileHandle, atlasRegion);
        }
        int n2 = this.data.getImagePaths().length;
        Array<TextureRegion> array = new Array<TextureRegion>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            array.add(new TextureRegion(assetManager.get(this.data.getImagePath(i2), Texture.class)));
        }
        return new BitmapFont(this.data, array, true);
    }

    public static class BitmapFontParameter
    extends AssetLoaderParameters<BitmapFont> {
        public boolean flip = false;
        public boolean genMipMaps = false;
        public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
        public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
        public BitmapFont.BitmapFontData bitmapFontData = null;
        public String atlasName = null;
    }
}

