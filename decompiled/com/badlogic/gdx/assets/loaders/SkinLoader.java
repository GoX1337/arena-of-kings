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
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

public class SkinLoader
extends AsynchronousAssetLoader<Skin, SkinParameter> {
    public SkinLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, SkinParameter skinParameter) {
        Array<AssetDescriptor> array = new Array<AssetDescriptor>();
        if (skinParameter == null || skinParameter.textureAtlasPath == null) {
            array.add(new AssetDescriptor<TextureAtlas>(fileHandle.pathWithoutExtension() + ".atlas", TextureAtlas.class));
        } else if (skinParameter.textureAtlasPath != null) {
            array.add(new AssetDescriptor<TextureAtlas>(skinParameter.textureAtlasPath, TextureAtlas.class));
        }
        return array;
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, SkinParameter skinParameter) {
    }

    @Override
    public Skin loadSync(AssetManager assetManager, String string, FileHandle fileHandle, SkinParameter skinParameter) {
        String string2 = fileHandle.pathWithoutExtension() + ".atlas";
        ObjectMap<String, Object> objectMap = null;
        if (skinParameter != null) {
            if (skinParameter.textureAtlasPath != null) {
                string2 = skinParameter.textureAtlasPath;
            }
            if (skinParameter.resources != null) {
                objectMap = skinParameter.resources;
            }
        }
        TextureAtlas textureAtlas = assetManager.get(string2, TextureAtlas.class);
        Skin skin = this.newSkin(textureAtlas);
        if (objectMap != null) {
            for (ObjectMap.Entry entry : objectMap.entries()) {
                skin.add((String)entry.key, entry.value);
            }
        }
        skin.load(fileHandle);
        return skin;
    }

    protected Skin newSkin(TextureAtlas textureAtlas) {
        return new Skin(textureAtlas);
    }

    public static class SkinParameter
    extends AssetLoaderParameters<Skin> {
        public final String textureAtlasPath;
        public final ObjectMap<String, Object> resources;

        public SkinParameter() {
            this(null, null);
        }

        public SkinParameter(ObjectMap<String, Object> objectMap) {
            this(null, objectMap);
        }

        public SkinParameter(String string) {
            this(string, null);
        }

        public SkinParameter(String string, ObjectMap<String, Object> objectMap) {
            this.textureAtlasPath = string;
            this.resources = objectMap;
        }
    }
}

