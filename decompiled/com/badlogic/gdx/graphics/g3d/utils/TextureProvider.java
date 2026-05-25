/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public interface TextureProvider {
    public Texture load(String var1);

    public static class AssetTextureProvider
    implements TextureProvider {
        public final AssetManager assetManager;

        public AssetTextureProvider(AssetManager assetManager) {
            this.assetManager = assetManager;
        }

        @Override
        public Texture load(String string) {
            return this.assetManager.get(string, Texture.class);
        }
    }

    public static class FileTextureProvider
    implements TextureProvider {
        private Texture.TextureFilter minFilter;
        private Texture.TextureFilter magFilter;
        private Texture.TextureWrap uWrap;
        private Texture.TextureWrap vWrap;
        private boolean useMipMaps;

        public FileTextureProvider() {
            this.minFilter = this.magFilter = Texture.TextureFilter.Linear;
            this.uWrap = this.vWrap = Texture.TextureWrap.Repeat;
            this.useMipMaps = false;
        }

        public FileTextureProvider(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2, boolean bl2) {
            this.minFilter = textureFilter;
            this.magFilter = textureFilter2;
            this.uWrap = textureWrap;
            this.vWrap = textureWrap2;
            this.useMipMaps = bl2;
        }

        @Override
        public Texture load(String string) {
            Texture texture = new Texture(Gdx.files.internal(string), this.useMipMaps);
            texture.setFilter(this.minFilter, this.magFilter);
            texture.setWrap(this.uWrap, this.vWrap);
            return texture;
        }
    }
}

