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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.Array;

public class TextureLoader
extends AsynchronousAssetLoader<Texture, TextureParameter> {
    TextureLoaderInfo info = new TextureLoaderInfo();

    public TextureLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, TextureParameter textureParameter) {
        this.info.filename = string;
        if (textureParameter == null || textureParameter.textureData == null) {
            Pixmap.Format format = null;
            boolean bl2 = false;
            this.info.texture = null;
            if (textureParameter != null) {
                format = textureParameter.format;
                bl2 = textureParameter.genMipMaps;
                this.info.texture = textureParameter.texture;
            }
            this.info.data = TextureData.Factory.loadFromFile(fileHandle, format, bl2);
        } else {
            this.info.data = textureParameter.textureData;
            this.info.texture = textureParameter.texture;
        }
        if (!this.info.data.isPrepared()) {
            this.info.data.prepare();
        }
    }

    @Override
    public Texture loadSync(AssetManager assetManager, String string, FileHandle fileHandle, TextureParameter textureParameter) {
        if (this.info == null) {
            return null;
        }
        Texture texture = this.info.texture;
        if (texture != null) {
            texture.load(this.info.data);
        } else {
            texture = new Texture(this.info.data);
        }
        if (textureParameter != null) {
            texture.setFilter(textureParameter.minFilter, textureParameter.magFilter);
            texture.setWrap(textureParameter.wrapU, textureParameter.wrapV);
        }
        return texture;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, TextureParameter textureParameter) {
        return null;
    }

    public static class TextureParameter
    extends AssetLoaderParameters<Texture> {
        public Pixmap.Format format = null;
        public boolean genMipMaps = false;
        public Texture texture = null;
        public TextureData textureData = null;
        public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
        public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
        public Texture.TextureWrap wrapU = Texture.TextureWrap.ClampToEdge;
        public Texture.TextureWrap wrapV = Texture.TextureWrap.ClampToEdge;
    }

    public static class TextureLoaderInfo {
        String filename;
        TextureData data;
        Texture texture;
    }
}

