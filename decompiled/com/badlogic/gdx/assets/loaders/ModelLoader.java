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
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;
import java.util.Iterator;

public abstract class ModelLoader<P extends ModelParameters>
extends AsynchronousAssetLoader<Model, P> {
    protected Array<ObjectMap.Entry<String, ModelData>> items = new Array();
    protected ModelParameters defaultParameters = new ModelParameters();

    public ModelLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public abstract ModelData loadModelData(FileHandle var1, P var2);

    public ModelData loadModelData(FileHandle fileHandle) {
        return this.loadModelData(fileHandle, null);
    }

    public Model loadModel(FileHandle fileHandle, TextureProvider textureProvider, P p2) {
        ModelData modelData = this.loadModelData(fileHandle, p2);
        return modelData == null ? null : new Model(modelData, textureProvider);
    }

    public Model loadModel(FileHandle fileHandle, P p2) {
        return this.loadModel(fileHandle, new TextureProvider.FileTextureProvider(), p2);
    }

    public Model loadModel(FileHandle fileHandle, TextureProvider textureProvider) {
        return this.loadModel(fileHandle, textureProvider, null);
    }

    public Model loadModel(FileHandle fileHandle) {
        return this.loadModel(fileHandle, new TextureProvider.FileTextureProvider(), null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, P p2) {
        Array<AssetDescriptor> array = new Array<AssetDescriptor>();
        ModelData modelData = this.loadModelData(fileHandle, p2);
        if (modelData == null) {
            return array;
        }
        ObjectMap.Entry entry = new ObjectMap.Entry();
        entry.key = string;
        entry.value = modelData;
        Object object = this.items;
        synchronized (object) {
            this.items.add(entry);
        }
        object = p2 != null ? ((ModelParameters)p2).textureParameter : this.defaultParameters.textureParameter;
        for (ModelMaterial modelMaterial : modelData.materials) {
            if (modelMaterial.textures == null) continue;
            for (ModelTexture modelTexture : modelMaterial.textures) {
                array.add(new AssetDescriptor<Texture>(modelTexture.fileName, Texture.class, (AssetLoaderParameters<Texture>)object));
            }
        }
        return array;
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, P p2) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Model loadSync(AssetManager assetManager, String string, FileHandle fileHandle, P p2) {
        ModelData modelData = null;
        Object object = this.items;
        synchronized (object) {
            for (int i2 = 0; i2 < this.items.size; ++i2) {
                if (!((String)this.items.get((int)i2).key).equals(string)) continue;
                modelData = (ModelData)this.items.get((int)i2).value;
                this.items.removeIndex(i2);
            }
        }
        if (modelData == null) {
            return null;
        }
        object = new Model(modelData, new TextureProvider.AssetTextureProvider(assetManager));
        Iterator<Disposable> iterator = ((Model)object).getManagedDisposables().iterator();
        while (iterator.hasNext()) {
            Disposable disposable = iterator.next();
            if (!(disposable instanceof Texture)) continue;
            iterator.remove();
        }
        return object;
    }

    public static class ModelParameters
    extends AssetLoaderParameters<Model> {
        public TextureLoader.TextureParameter textureParameter = new TextureLoader.TextureParameter();

        public ModelParameters() {
            this.textureParameter.minFilter = this.textureParameter.magFilter = Texture.TextureFilter.Linear;
            this.textureParameter.wrapU = this.textureParameter.wrapV = Texture.TextureWrap.Repeat;
        }
    }
}

