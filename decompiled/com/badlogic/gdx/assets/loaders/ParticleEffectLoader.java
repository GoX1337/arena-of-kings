/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class ParticleEffectLoader
extends SynchronousAssetLoader<ParticleEffect, ParticleEffectParameter> {
    public ParticleEffectLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public ParticleEffect load(AssetManager assetManager, String string, FileHandle fileHandle, ParticleEffectParameter particleEffectParameter) {
        ParticleEffect particleEffect = new ParticleEffect();
        if (particleEffectParameter != null && particleEffectParameter.atlasFile != null) {
            particleEffect.load(fileHandle, assetManager.get(particleEffectParameter.atlasFile, TextureAtlas.class), particleEffectParameter.atlasPrefix);
        } else if (particleEffectParameter != null && particleEffectParameter.imagesDir != null) {
            particleEffect.load(fileHandle, particleEffectParameter.imagesDir);
        } else {
            particleEffect.load(fileHandle, fileHandle.parent());
        }
        return particleEffect;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, ParticleEffectParameter particleEffectParameter) {
        Array<AssetDescriptor<TextureAtlas>> array = null;
        if (particleEffectParameter != null && particleEffectParameter.atlasFile != null) {
            array = new Array<AssetDescriptor<TextureAtlas>>();
            array.add(new AssetDescriptor<TextureAtlas>(particleEffectParameter.atlasFile, TextureAtlas.class));
        }
        return array;
    }

    public static class ParticleEffectParameter
    extends AssetLoaderParameters<ParticleEffect> {
        public String atlasFile;
        public String atlasPrefix;
        public FileHandle imagesDir;
    }
}

