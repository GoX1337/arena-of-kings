/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.maps;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;

public interface ImageResolver {
    public TextureRegion getImage(String var1);

    public static class TextureAtlasImageResolver
    implements ImageResolver {
        private final TextureAtlas atlas;

        public TextureAtlasImageResolver(TextureAtlas textureAtlas) {
            this.atlas = textureAtlas;
        }

        @Override
        public TextureRegion getImage(String string) {
            return this.atlas.findRegion(string);
        }
    }

    public static class AssetManagerImageResolver
    implements ImageResolver {
        private final AssetManager assetManager;

        public AssetManagerImageResolver(AssetManager assetManager) {
            this.assetManager = assetManager;
        }

        @Override
        public TextureRegion getImage(String string) {
            return new TextureRegion(this.assetManager.get(string, Texture.class));
        }
    }

    public static class DirectImageResolver
    implements ImageResolver {
        private final ObjectMap<String, Texture> images;

        public DirectImageResolver(ObjectMap<String, Texture> objectMap) {
            this.images = objectMap;
        }

        @Override
        public TextureRegion getImage(String string) {
            return new TextureRegion(this.images.get(string));
        }
    }
}

