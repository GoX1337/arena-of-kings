/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

public class ResourceData<T>
implements Json.Serializable {
    private ObjectMap<String, SaveData> uniqueData = new ObjectMap();
    private Array<SaveData> data = new Array(true, 3, SaveData.class);
    Array<AssetData> sharedAssets = new Array();
    private int currentLoadIndex = 0;
    public T resource;

    public ResourceData() {
    }

    public ResourceData(T t2) {
        this();
        this.resource = t2;
    }

    <K> int getAssetData(String string, Class<K> clazz) {
        int n2 = 0;
        for (AssetData assetData : this.sharedAssets) {
            if (assetData.filename.equals(string) && assetData.type.equals(clazz)) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public Array<AssetDescriptor> getAssetDescriptors() {
        Array<AssetDescriptor> array = new Array<AssetDescriptor>();
        for (AssetData assetData : this.sharedAssets) {
            array.add(new AssetDescriptor(assetData.filename, assetData.type));
        }
        return array;
    }

    public Array<AssetData> getAssets() {
        return this.sharedAssets;
    }

    public SaveData createSaveData() {
        SaveData saveData = new SaveData(this);
        this.data.add(saveData);
        return saveData;
    }

    public SaveData createSaveData(String string) {
        SaveData saveData = new SaveData(this);
        if (this.uniqueData.containsKey(string)) {
            throw new RuntimeException("Key already used, data must be unique, use a different key");
        }
        this.uniqueData.put(string, saveData);
        return saveData;
    }

    public SaveData getSaveData() {
        return this.data.get(this.currentLoadIndex++);
    }

    public SaveData getSaveData(String string) {
        return this.uniqueData.get(string);
    }

    @Override
    public void write(Json json) {
        json.writeValue("unique", this.uniqueData, ObjectMap.class);
        json.writeValue("data", this.data, Array.class, SaveData.class);
        json.writeValue("assets", this.sharedAssets.toArray(AssetData.class), AssetData[].class);
        json.writeValue("resource", this.resource, null);
    }

    @Override
    public void read(Json json, JsonValue jsonValue) {
        this.uniqueData = json.readValue("unique", ObjectMap.class, jsonValue);
        for (ObjectMap.Entry object : this.uniqueData.entries()) {
            ((SaveData)object.value).resources = this;
        }
        this.data = json.readValue("data", Array.class, SaveData.class, jsonValue);
        for (SaveData saveData : this.data) {
            saveData.resources = this;
        }
        this.sharedAssets.addAll(json.readValue("assets", Array.class, AssetData.class, jsonValue));
        this.resource = json.readValue("resource", null, jsonValue);
    }

    public static class AssetData<T>
    implements Json.Serializable {
        public String filename;
        public Class<T> type;

        public AssetData() {
        }

        public AssetData(String string, Class<T> clazz) {
            this.filename = string;
            this.type = clazz;
        }

        @Override
        public void write(Json json) {
            json.writeValue("filename", this.filename);
            json.writeValue("type", this.type.getName());
        }

        @Override
        public void read(Json json, JsonValue jsonValue) {
            this.filename = json.readValue("filename", String.class, jsonValue);
            String string = json.readValue("type", String.class, jsonValue);
            try {
                this.type = ClassReflection.forName(string);
            }
            catch (ReflectionException reflectionException) {
                throw new GdxRuntimeException("Class not found: " + string, reflectionException);
            }
        }
    }

    public static class SaveData
    implements Json.Serializable {
        ObjectMap<String, Object> data = new ObjectMap();
        IntArray assets = new IntArray();
        private int loadIndex = 0;
        protected ResourceData resources;

        public SaveData() {
        }

        public SaveData(ResourceData resourceData) {
            this.resources = resourceData;
        }

        public <K> void saveAsset(String string, Class<K> clazz) {
            int n2 = this.resources.getAssetData(string, clazz);
            if (n2 == -1) {
                this.resources.sharedAssets.add(new AssetData<K>(string, clazz));
                n2 = this.resources.sharedAssets.size - 1;
            }
            this.assets.add(n2);
        }

        public void save(String string, Object object) {
            this.data.put(string, object);
        }

        public AssetDescriptor loadAsset() {
            if (this.loadIndex == this.assets.size) {
                return null;
            }
            AssetData assetData = this.resources.sharedAssets.get(this.assets.get(this.loadIndex++));
            return new AssetDescriptor(assetData.filename, assetData.type);
        }

        public <K> K load(String string) {
            return (K)this.data.get(string);
        }

        @Override
        public void write(Json json) {
            json.writeValue("data", this.data, ObjectMap.class);
            json.writeValue("indices", this.assets.toArray(), int[].class);
        }

        @Override
        public void read(Json json, JsonValue jsonValue) {
            this.data = json.readValue("data", ObjectMap.class, jsonValue);
            this.assets.addAll(json.readValue("indices", int[].class, jsonValue));
        }
    }

    public static interface Configurable<T> {
        public void save(AssetManager var1, ResourceData<T> var2);

        public void load(AssetManager var1, ResourceData<T> var2);
    }
}

