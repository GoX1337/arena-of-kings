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
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.CubemapData;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.KTXTextureData;
import com.badlogic.gdx.utils.Array;

public class CubemapLoader
extends AsynchronousAssetLoader<Cubemap, CubemapParameter> {
    CubemapLoaderInfo info = new CubemapLoaderInfo();

    public CubemapLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, CubemapParameter cubemapParameter) {
        this.info.filename = string;
        if (cubemapParameter == null || cubemapParameter.cubemapData == null) {
            Pixmap.Format format = null;
            boolean bl2 = false;
            this.info.cubemap = null;
            if (cubemapParameter != null) {
                format = cubemapParameter.format;
                this.info.cubemap = cubemapParameter.cubemap;
            }
            if (string.contains(".ktx") || string.contains(".zktx")) {
                this.info.data = new KTXTextureData(fileHandle, bl2);
            }
        } else {
            this.info.data = cubemapParameter.cubemapData;
            this.info.cubemap = cubemapParameter.cubemap;
        }
        if (!this.info.data.isPrepared()) {
            this.info.data.prepare();
        }
    }

    @Override
    public Cubemap loadSync(AssetManager assetManager, String string, FileHandle fileHandle, CubemapParameter cubemapParameter) {
        if (this.info == null) {
            return null;
        }
        Cubemap cubemap = this.info.cubemap;
        if (cubemap != null) {
            cubemap.load(this.info.data);
        } else {
            cubemap = new Cubemap(this.info.data);
        }
        if (cubemapParameter != null) {
            cubemap.setFilter(cubemapParameter.minFilter, cubemapParameter.magFilter);
            cubemap.setWrap(cubemapParameter.wrapU, cubemapParameter.wrapV);
        }
        return cubemap;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, CubemapParameter cubemapParameter) {
        return null;
    }

    public static class CubemapParameter
    extends AssetLoaderParameters<Cubemap> {
        public Pixmap.Format format = null;
        public Cubemap cubemap = null;
        public CubemapData cubemapData = null;
        public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
        public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
        public Texture.TextureWrap wrapU = Texture.TextureWrap.ClampToEdge;
        public Texture.TextureWrap wrapV = Texture.TextureWrap.ClampToEdge;
    }

    public static class CubemapLoaderInfo {
        String filename;
        CubemapData data;
        Cubemap cubemap;
    }
}

