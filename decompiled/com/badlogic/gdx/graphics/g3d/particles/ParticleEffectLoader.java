/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.reflect.ClassReflection;

public class ParticleEffectLoader
extends AsynchronousAssetLoader<ParticleEffect, ParticleEffectLoadParameter> {
    protected Array<ObjectMap.Entry<String, ResourceData<ParticleEffect>>> items = new Array();

    public ParticleEffectLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, ParticleEffectLoadParameter particleEffectLoadParameter) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, ParticleEffectLoadParameter particleEffectLoadParameter) {
        Json json = new Json();
        ResourceData resourceData = json.fromJson(ResourceData.class, fileHandle);
        Array<ResourceData.AssetData> array = null;
        Array<ObjectMap.Entry<String, ResourceData<ParticleEffect>>> array2 = this.items;
        synchronized (array2) {
            ObjectMap.Entry entry = new ObjectMap.Entry();
            entry.key = string;
            entry.value = resourceData;
            this.items.add(entry);
            array = resourceData.getAssets();
        }
        array2 = new Array();
        for (ResourceData.AssetData assetData : array) {
            if (!this.resolve(assetData.filename).exists()) {
                assetData.filename = fileHandle.parent().child(Gdx.files.internal(assetData.filename).name()).path();
            }
            if (assetData.type == ParticleEffect.class) {
                array2.add((ObjectMap.Entry<String, ResourceData<ParticleEffect>>)((Object)new AssetDescriptor<ParticleEffect>(assetData.filename, assetData.type, particleEffectLoadParameter)));
                continue;
            }
            array2.add((ObjectMap.Entry<String, ResourceData<ParticleEffect>>)((Object)new AssetDescriptor(assetData.filename, assetData.type)));
        }
        return array2;
    }

    public void save(ParticleEffect particleEffect, ParticleEffectSaveParameter particleEffectSaveParameter) {
        ResourceData<ParticleEffect> resourceData = new ResourceData<ParticleEffect>(particleEffect);
        particleEffect.save(particleEffectSaveParameter.manager, (ResourceData)resourceData);
        if (particleEffectSaveParameter.batches != null) {
            for (ParticleBatch particleBatch : particleEffectSaveParameter.batches) {
                boolean bl2 = false;
                for (ParticleController particleController : particleEffect.getControllers()) {
                    if (!particleController.renderer.isCompatible(particleBatch)) continue;
                    bl2 = true;
                    break;
                }
                if (!bl2) continue;
                particleBatch.save(particleEffectSaveParameter.manager, (ResourceData)resourceData);
            }
        }
        Json json = new Json();
        json.toJson(resourceData, particleEffectSaveParameter.file);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @Override
    public ParticleEffect loadSync(AssetManager assetManager, String string, FileHandle fileHandle, ParticleEffectLoadParameter particleEffectLoadParameter) {
        ResourceData resourceData = null;
        Array<ObjectMap.Entry<String, ResourceData<ParticleEffect>>> array = this.items;
        synchronized (array) {
            void particleBatch;
            boolean i2 = false;
            while (particleBatch < this.items.size) {
                ObjectMap.Entry<String, ResourceData<ParticleEffect>> entry = this.items.get((int)particleBatch);
                if (((String)entry.key).equals(string)) {
                    resourceData = (ResourceData)entry.value;
                    this.items.removeIndex((int)particleBatch);
                    break;
                }
                ++particleBatch;
            }
        }
        ((ParticleEffect)resourceData.resource).load(assetManager, resourceData);
        if (particleEffectLoadParameter != null) {
            if (particleEffectLoadParameter.batches != null) {
                for (ParticleBatch particleBatch : particleEffectLoadParameter.batches) {
                    particleBatch.load(assetManager, resourceData);
                }
            }
            ((ParticleEffect)resourceData.resource).setBatch(particleEffectLoadParameter.batches);
        }
        return (ParticleEffect)resourceData.resource;
    }

    private <T> T find(Array<?> array, Class<T> clazz) {
        for (Object e2 : array) {
            if (!ClassReflection.isAssignableFrom(clazz, e2.getClass())) continue;
            return (T)e2;
        }
        return null;
    }

    public static class ParticleEffectSaveParameter
    extends AssetLoaderParameters<ParticleEffect> {
        Array<ParticleBatch<?>> batches;
        FileHandle file;
        AssetManager manager;

        public ParticleEffectSaveParameter(FileHandle fileHandle, AssetManager assetManager, Array<ParticleBatch<?>> array) {
            this.batches = array;
            this.file = fileHandle;
            this.manager = assetManager;
        }
    }

    public static class ParticleEffectLoadParameter
    extends AssetLoaderParameters<ParticleEffect> {
        Array<ParticleBatch<?>> batches;

        public ParticleEffectLoadParameter(Array<ParticleBatch<?>> array) {
            this.batches = array;
        }
    }
}

