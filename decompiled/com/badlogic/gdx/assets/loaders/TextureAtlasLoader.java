/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class TextureAtlasLoader
extends SynchronousAssetLoader<TextureAtlas, TextureAtlasParameter> {
    TextureAtlas.TextureAtlasData data;

    public TextureAtlasLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public TextureAtlas load(AssetManager assetManager, String string, FileHandle fileHandle, TextureAtlasParameter textureAtlasParameter) {
        for (TextureAtlas.TextureAtlasData.Page page : this.data.getPages()) {
            Texture texture;
            page.texture = texture = assetManager.get(page.textureFile.path().replaceAll("\\\\", "/"), Texture.class);
        }
        TextureAtlas textureAtlas = new TextureAtlas(this.data);
        this.data = null;
        return textureAtlas;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, TextureAtlasParameter textureAtlasParameter) {
        FileHandle fileHandle2 = fileHandle.parent();
        this.data = textureAtlasParameter != null ? new TextureAtlas.TextureAtlasData(fileHandle, fileHandle2, textureAtlasParameter.flip) : new TextureAtlas.TextureAtlasData(fileHandle, fileHandle2, false);
        Array<AssetDescriptor> array = new Array<AssetDescriptor>();
        for (TextureAtlas.TextureAtlasData.Page page : this.data.getPages()) {
            TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();
            textureParameter.format = page.format;
            textureParameter.genMipMaps = page.useMipMaps;
            textureParameter.minFilter = page.minFilter;
            textureParameter.magFilter = page.magFilter;
            array.add(new AssetDescriptor<Texture>(page.textureFile, Texture.class, textureParameter));
        }
        return array;
    }

    public static class TextureAtlasParameter
    extends AssetLoaderParameters<TextureAtlas> {
        public boolean flip = false;

        public TextureAtlasParameter() {
        }

        public TextureAtlasParameter(boolean bl2) {
            this.flip = bl2;
        }
    }
}

