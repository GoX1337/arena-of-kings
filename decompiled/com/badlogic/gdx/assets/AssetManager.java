/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetLoadingTask;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader;
import com.badlogic.gdx.assets.loaders.CubemapLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.I18NBundleLoader;
import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.assets.loaders.ParticleEffectLoader;
import com.badlogic.gdx.assets.loaders.PixmapLoader;
import com.badlogic.gdx.assets.loaders.ShaderProgramLoader;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.assets.loaders.SoundLoader;
import com.badlogic.gdx.assets.loaders.TextureAtlasLoader;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonRegionLoader;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ObjectIntMap;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.UBJsonReader;
import com.badlogic.gdx.utils.async.AsyncExecutor;
import com.badlogic.gdx.utils.async.ThreadUtils;
import com.badlogic.gdx.utils.reflect.ClassReflection;

public class AssetManager
implements Disposable {
    final ObjectMap<Class, ObjectMap<String, RefCountedContainer>> assets = new ObjectMap();
    final ObjectMap<String, Class> assetTypes = new ObjectMap();
    final ObjectMap<String, Array<String>> assetDependencies = new ObjectMap();
    final ObjectSet<String> injected = new ObjectSet();
    final ObjectMap<Class, ObjectMap<String, AssetLoader>> loaders = new ObjectMap();
    final Array<AssetDescriptor> loadQueue = new Array();
    final AsyncExecutor executor;
    final Array<AssetLoadingTask> tasks = new Array();
    AssetErrorListener listener;
    int loaded;
    int toLoad;
    int peakTasks;
    final FileHandleResolver resolver;
    Logger log = new Logger("AssetManager", 0);

    public AssetManager() {
        this(new InternalFileHandleResolver());
    }

    public AssetManager(FileHandleResolver fileHandleResolver) {
        this(fileHandleResolver, true);
    }

    public AssetManager(FileHandleResolver fileHandleResolver, boolean bl2) {
        this.resolver = fileHandleResolver;
        if (bl2) {
            this.setLoader(BitmapFont.class, new BitmapFontLoader(fileHandleResolver));
            this.setLoader(Music.class, new MusicLoader(fileHandleResolver));
            this.setLoader(Pixmap.class, new PixmapLoader(fileHandleResolver));
            this.setLoader(Sound.class, new SoundLoader(fileHandleResolver));
            this.setLoader(TextureAtlas.class, new TextureAtlasLoader(fileHandleResolver));
            this.setLoader(Texture.class, new TextureLoader(fileHandleResolver));
            this.setLoader(Skin.class, new SkinLoader(fileHandleResolver));
            this.setLoader(com.badlogic.gdx.graphics.g2d.ParticleEffect.class, new ParticleEffectLoader(fileHandleResolver));
            this.setLoader(ParticleEffect.class, new com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader(fileHandleResolver));
            this.setLoader(PolygonRegion.class, new PolygonRegionLoader(fileHandleResolver));
            this.setLoader(I18NBundle.class, new I18NBundleLoader(fileHandleResolver));
            this.setLoader(Model.class, ".g3dj", new G3dModelLoader(new JsonReader(), fileHandleResolver));
            this.setLoader(Model.class, ".g3db", new G3dModelLoader(new UBJsonReader(), fileHandleResolver));
            this.setLoader(Model.class, ".obj", new ObjLoader(fileHandleResolver));
            this.setLoader(ShaderProgram.class, new ShaderProgramLoader(fileHandleResolver));
            this.setLoader(Cubemap.class, new CubemapLoader(fileHandleResolver));
        }
        this.executor = new AsyncExecutor(1, "AssetManager");
    }

    public FileHandleResolver getFileHandleResolver() {
        return this.resolver;
    }

    public synchronized <T> T get(String string) {
        return this.get(string, true);
    }

    public synchronized <T> T get(String string, Class<T> clazz) {
        return this.get(string, clazz, true);
    }

    @Null
    public synchronized <T> T get(String string, boolean bl2) {
        RefCountedContainer refCountedContainer;
        ObjectMap<String, RefCountedContainer> objectMap;
        Class clazz = this.assetTypes.get(string);
        if (clazz != null && (objectMap = this.assets.get(clazz)) != null && (refCountedContainer = objectMap.get(string)) != null) {
            return (T)refCountedContainer.object;
        }
        if (bl2) {
            throw new GdxRuntimeException("Asset not loaded: " + string);
        }
        return null;
    }

    @Null
    public synchronized <T> T get(String string, Class<T> clazz, boolean bl2) {
        RefCountedContainer refCountedContainer;
        ObjectMap<String, RefCountedContainer> objectMap = this.assets.get(clazz);
        if (objectMap != null && (refCountedContainer = objectMap.get(string)) != null) {
            return (T)refCountedContainer.object;
        }
        if (bl2) {
            throw new GdxRuntimeException("Asset not loaded: " + string);
        }
        return null;
    }

    public synchronized <T> T get(AssetDescriptor<T> assetDescriptor) {
        return this.get(assetDescriptor.fileName, assetDescriptor.type, true);
    }

    public synchronized <T> Array<T> getAll(Class<T> clazz, Array<T> array) {
        ObjectMap<String, RefCountedContainer> objectMap = this.assets.get(clazz);
        if (objectMap != null) {
            for (RefCountedContainer refCountedContainer : objectMap.values()) {
                array.add(refCountedContainer.object);
            }
        }
        return array;
    }

    public synchronized boolean contains(String string) {
        if (this.tasks.size > 0 && this.tasks.first().assetDesc.fileName.equals(string)) {
            return true;
        }
        for (int i2 = 0; i2 < this.loadQueue.size; ++i2) {
            if (!this.loadQueue.get((int)i2).fileName.equals(string)) continue;
            return true;
        }
        return this.isLoaded(string);
    }

    public synchronized boolean contains(String string, Class clazz) {
        if (this.tasks.size > 0) {
            AssetDescriptor assetDescriptor = this.tasks.first().assetDesc;
            if (assetDescriptor.type == clazz && assetDescriptor.fileName.equals(string)) {
                return true;
            }
        }
        for (int i2 = 0; i2 < this.loadQueue.size; ++i2) {
            AssetDescriptor assetDescriptor = this.loadQueue.get(i2);
            if (assetDescriptor.type != clazz || !assetDescriptor.fileName.equals(string)) continue;
            return true;
        }
        return this.isLoaded(string, clazz);
    }

    public synchronized void unload(String string) {
        Object object;
        if (this.tasks.size > 0) {
            object = this.tasks.first();
            if (((AssetLoadingTask)object).assetDesc.fileName.equals(string)) {
                this.log.info("Unload (from tasks): " + string);
                ((AssetLoadingTask)object).cancel = true;
                ((AssetLoadingTask)object).unload();
                return;
            }
        }
        object = this.assetTypes.get(string);
        int n2 = -1;
        for (int i2 = 0; i2 < this.loadQueue.size; ++i2) {
            if (!this.loadQueue.get((int)i2).fileName.equals(string)) continue;
            n2 = i2;
            break;
        }
        if (n2 != -1) {
            --this.toLoad;
            AssetDescriptor assetDescriptor = this.loadQueue.removeIndex(n2);
            this.log.info("Unload (from queue): " + string);
            if (object != null && assetDescriptor.params != null && assetDescriptor.params.loadedCallback != null) {
                assetDescriptor.params.loadedCallback.finishedLoading(this, assetDescriptor.fileName, assetDescriptor.type);
            }
            return;
        }
        if (object == null) {
            throw new GdxRuntimeException("Asset not loaded: " + string);
        }
        RefCountedContainer refCountedContainer = this.assets.get(object).get(string);
        --refCountedContainer.refCount;
        if (refCountedContainer.refCount <= 0) {
            this.log.info("Unload (dispose): " + string);
            if (refCountedContainer.object instanceof Disposable) {
                ((Disposable)refCountedContainer.object).dispose();
            }
            this.assetTypes.remove(string);
            this.assets.get(object).remove(string);
        } else {
            this.log.info("Unload (decrement): " + string);
        }
        Array<String> array = this.assetDependencies.get(string);
        if (array != null) {
            for (String string2 : array) {
                if (!this.isLoaded(string2)) continue;
                this.unload(string2);
            }
        }
        if (refCountedContainer.refCount <= 0) {
            this.assetDependencies.remove(string);
        }
    }

    public synchronized <T> boolean containsAsset(T t2) {
        ObjectMap<String, RefCountedContainer> objectMap = this.assets.get(t2.getClass());
        if (objectMap == null) {
            return false;
        }
        for (RefCountedContainer refCountedContainer : objectMap.values()) {
            if (refCountedContainer.object != t2 && !t2.equals(refCountedContainer.object)) continue;
            return true;
        }
        return false;
    }

    public synchronized <T> String getAssetFileName(T t2) {
        for (Class clazz : this.assets.keys()) {
            ObjectMap<String, RefCountedContainer> objectMap = this.assets.get(clazz);
            for (ObjectMap.Entry entry : objectMap) {
                Object object = ((RefCountedContainer)entry.value).object;
                if (object != t2 && !t2.equals(object)) continue;
                return (String)entry.key;
            }
        }
        return null;
    }

    public synchronized boolean isLoaded(AssetDescriptor assetDescriptor) {
        return this.isLoaded(assetDescriptor.fileName);
    }

    public synchronized boolean isLoaded(String string) {
        if (string == null) {
            return false;
        }
        return this.assetTypes.containsKey(string);
    }

    public synchronized boolean isLoaded(String string, Class clazz) {
        ObjectMap<String, RefCountedContainer> objectMap = this.assets.get(clazz);
        if (objectMap == null) {
            return false;
        }
        return objectMap.get(string) != null;
    }

    public <T> AssetLoader getLoader(Class<T> clazz) {
        return this.getLoader(clazz, null);
    }

    public <T> AssetLoader getLoader(Class<T> clazz, String string) {
        ObjectMap<String, AssetLoader> objectMap = this.loaders.get(clazz);
        if (objectMap == null || objectMap.size < 1) {
            return null;
        }
        if (string == null) {
            return objectMap.get("");
        }
        AssetLoader assetLoader = null;
        int n2 = -1;
        for (ObjectMap.Entry entry : objectMap.entries()) {
            if (((String)entry.key).length() <= n2 || !string.endsWith((String)entry.key)) continue;
            assetLoader = (AssetLoader)entry.value;
            n2 = ((String)entry.key).length();
        }
        return assetLoader;
    }

    public synchronized <T> void load(String string, Class<T> clazz) {
        this.load(string, clazz, null);
    }

    public synchronized <T> void load(String string, Class<T> clazz, AssetLoaderParameters<T> assetLoaderParameters) {
        AssetDescriptor<T> assetDescriptor;
        int n2;
        AssetLoader assetLoader = this.getLoader(clazz, string);
        if (assetLoader == null) {
            throw new GdxRuntimeException("No loader for type: " + ClassReflection.getSimpleName(clazz));
        }
        if (this.loadQueue.size == 0) {
            this.loaded = 0;
            this.toLoad = 0;
            this.peakTasks = 0;
        }
        for (n2 = 0; n2 < this.loadQueue.size; ++n2) {
            assetDescriptor = this.loadQueue.get(n2);
            if (!assetDescriptor.fileName.equals(string) || assetDescriptor.type.equals(clazz)) continue;
            throw new GdxRuntimeException("Asset with name '" + string + "' already in preload queue, but has different type (expected: " + ClassReflection.getSimpleName(clazz) + ", found: " + ClassReflection.getSimpleName(assetDescriptor.type) + ")");
        }
        for (n2 = 0; n2 < this.tasks.size; ++n2) {
            assetDescriptor = this.tasks.get((int)n2).assetDesc;
            if (!assetDescriptor.fileName.equals(string) || assetDescriptor.type.equals(clazz)) continue;
            throw new GdxRuntimeException("Asset with name '" + string + "' already in task list, but has different type (expected: " + ClassReflection.getSimpleName(clazz) + ", found: " + ClassReflection.getSimpleName(assetDescriptor.type) + ")");
        }
        Class clazz2 = this.assetTypes.get(string);
        if (clazz2 != null && !clazz2.equals(clazz)) {
            throw new GdxRuntimeException("Asset with name '" + string + "' already loaded, but has different type (expected: " + ClassReflection.getSimpleName(clazz) + ", found: " + ClassReflection.getSimpleName(clazz2) + ")");
        }
        ++this.toLoad;
        assetDescriptor = new AssetDescriptor<T>(string, clazz, assetLoaderParameters);
        this.loadQueue.add(assetDescriptor);
        this.log.debug("Queued: " + assetDescriptor);
    }

    public synchronized void load(AssetDescriptor assetDescriptor) {
        this.load(assetDescriptor.fileName, assetDescriptor.type, assetDescriptor.params);
    }

    public synchronized boolean update() {
        try {
            if (this.tasks.size == 0) {
                while (this.loadQueue.size != 0 && this.tasks.size == 0) {
                    this.nextTask();
                }
                if (this.tasks.size == 0) {
                    return true;
                }
            }
            return this.updateTask() && this.loadQueue.size == 0 && this.tasks.size == 0;
        }
        catch (Throwable throwable) {
            this.handleTaskError(throwable);
            return this.loadQueue.size == 0;
        }
    }

    public boolean update(int n2) {
        long l2 = TimeUtils.millis() + (long)n2;
        boolean bl2;
        while (!(bl2 = this.update()) && TimeUtils.millis() <= l2) {
            ThreadUtils.yield();
        }
        return bl2;
    }

    public synchronized boolean isFinished() {
        return this.loadQueue.size == 0 && this.tasks.size == 0;
    }

    public void finishLoading() {
        this.log.debug("Waiting for loading to complete...");
        while (!this.update()) {
            ThreadUtils.yield();
        }
        this.log.debug("Loading complete.");
    }

    public <T> T finishLoadingAsset(AssetDescriptor assetDescriptor) {
        return this.finishLoadingAsset(assetDescriptor.fileName);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T finishLoadingAsset(String string) {
        this.log.debug("Waiting for asset to be loaded: " + string);
        while (true) {
            AssetManager assetManager = this;
            synchronized (assetManager) {
                RefCountedContainer refCountedContainer;
                ObjectMap<String, RefCountedContainer> objectMap;
                Class clazz = this.assetTypes.get(string);
                if (clazz != null && (objectMap = this.assets.get(clazz)) != null && (refCountedContainer = objectMap.get(string)) != null) {
                    this.log.debug("Asset loaded: " + string);
                    return (T)refCountedContainer.object;
                }
                this.update();
            }
            ThreadUtils.yield();
        }
    }

    synchronized void injectDependencies(String string, Array<AssetDescriptor> array) {
        ObjectSet<String> objectSet = this.injected;
        for (AssetDescriptor assetDescriptor : array) {
            if (objectSet.contains(assetDescriptor.fileName)) continue;
            objectSet.add(assetDescriptor.fileName);
            this.injectDependency(string, assetDescriptor);
        }
        objectSet.clear(32);
    }

    private synchronized void injectDependency(String string, AssetDescriptor assetDescriptor) {
        Array<String> array = this.assetDependencies.get(string);
        if (array == null) {
            array = new Array();
            this.assetDependencies.put(string, array);
        }
        array.add(assetDescriptor.fileName);
        if (this.isLoaded(assetDescriptor.fileName)) {
            this.log.debug("Dependency already loaded: " + assetDescriptor);
            Class clazz = this.assetTypes.get(assetDescriptor.fileName);
            RefCountedContainer refCountedContainer = this.assets.get(clazz).get(assetDescriptor.fileName);
            ++refCountedContainer.refCount;
            this.incrementRefCountedDependencies(assetDescriptor.fileName);
        } else {
            this.log.info("Loading dependency: " + assetDescriptor);
            this.addTask(assetDescriptor);
        }
    }

    private void nextTask() {
        AssetDescriptor assetDescriptor = this.loadQueue.removeIndex(0);
        if (this.isLoaded(assetDescriptor.fileName)) {
            this.log.debug("Already loaded: " + assetDescriptor);
            Class clazz = this.assetTypes.get(assetDescriptor.fileName);
            RefCountedContainer refCountedContainer = this.assets.get(clazz).get(assetDescriptor.fileName);
            ++refCountedContainer.refCount;
            this.incrementRefCountedDependencies(assetDescriptor.fileName);
            if (assetDescriptor.params != null && assetDescriptor.params.loadedCallback != null) {
                assetDescriptor.params.loadedCallback.finishedLoading(this, assetDescriptor.fileName, assetDescriptor.type);
            }
            ++this.loaded;
        } else {
            this.log.info("Loading: " + assetDescriptor);
            this.addTask(assetDescriptor);
        }
    }

    private void addTask(AssetDescriptor assetDescriptor) {
        AssetLoader assetLoader = this.getLoader(assetDescriptor.type, assetDescriptor.fileName);
        if (assetLoader == null) {
            throw new GdxRuntimeException("No loader for type: " + ClassReflection.getSimpleName(assetDescriptor.type));
        }
        this.tasks.add(new AssetLoadingTask(this, assetDescriptor, assetLoader, this.executor));
        ++this.peakTasks;
    }

    public <T> void addAsset(String string, Class<T> clazz, T t2) {
        this.assetTypes.put(string, clazz);
        ObjectMap<String, RefCountedContainer> objectMap = this.assets.get(clazz);
        if (objectMap == null) {
            objectMap = new ObjectMap();
            this.assets.put(clazz, objectMap);
        }
        RefCountedContainer refCountedContainer = new RefCountedContainer();
        refCountedContainer.object = t2;
        objectMap.put(string, refCountedContainer);
    }

    private boolean updateTask() {
        AssetLoadingTask assetLoadingTask = this.tasks.peek();
        boolean bl2 = true;
        try {
            bl2 = assetLoadingTask.cancel || assetLoadingTask.update();
        }
        catch (RuntimeException runtimeException) {
            assetLoadingTask.cancel = true;
            this.taskFailed(assetLoadingTask.assetDesc, runtimeException);
        }
        if (bl2) {
            if (this.tasks.size == 1) {
                ++this.loaded;
                this.peakTasks = 0;
            }
            this.tasks.pop();
            if (assetLoadingTask.cancel) {
                return true;
            }
            this.addAsset(assetLoadingTask.assetDesc.fileName, assetLoadingTask.assetDesc.type, assetLoadingTask.asset);
            if (assetLoadingTask.assetDesc.params != null && assetLoadingTask.assetDesc.params.loadedCallback != null) {
                assetLoadingTask.assetDesc.params.loadedCallback.finishedLoading(this, assetLoadingTask.assetDesc.fileName, assetLoadingTask.assetDesc.type);
            }
            long l2 = TimeUtils.nanoTime();
            this.log.debug("Loaded: " + (float)(l2 - assetLoadingTask.startTime) / 1000000.0f + "ms " + assetLoadingTask.assetDesc);
            return true;
        }
        return false;
    }

    protected void taskFailed(AssetDescriptor assetDescriptor, RuntimeException runtimeException) {
        throw runtimeException;
    }

    private void incrementRefCountedDependencies(String string) {
        Array<String> array = this.assetDependencies.get(string);
        if (array == null) {
            return;
        }
        for (String string2 : array) {
            Class clazz = this.assetTypes.get(string2);
            RefCountedContainer refCountedContainer = this.assets.get(clazz).get(string2);
            ++refCountedContainer.refCount;
            this.incrementRefCountedDependencies(string2);
        }
    }

    private void handleTaskError(Throwable throwable) {
        this.log.error("Error loading asset.", throwable);
        if (this.tasks.isEmpty()) {
            throw new GdxRuntimeException(throwable);
        }
        AssetLoadingTask assetLoadingTask = this.tasks.pop();
        AssetDescriptor assetDescriptor = assetLoadingTask.assetDesc;
        if (assetLoadingTask.dependenciesLoaded && assetLoadingTask.dependencies != null) {
            for (AssetDescriptor assetDescriptor2 : assetLoadingTask.dependencies) {
                this.unload(assetDescriptor2.fileName);
            }
        }
        this.tasks.clear();
        if (this.listener == null) {
            throw new GdxRuntimeException(throwable);
        }
        this.listener.error(assetDescriptor, throwable);
    }

    public synchronized <T, P extends AssetLoaderParameters<T>> void setLoader(Class<T> clazz, AssetLoader<T, P> assetLoader) {
        this.setLoader(clazz, null, assetLoader);
    }

    public synchronized <T, P extends AssetLoaderParameters<T>> void setLoader(Class<T> clazz, String string, AssetLoader<T, P> assetLoader) {
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (assetLoader == null) {
            throw new IllegalArgumentException("loader cannot be null.");
        }
        this.log.debug("Loader set: " + ClassReflection.getSimpleName(clazz) + " -> " + ClassReflection.getSimpleName(assetLoader.getClass()));
        ObjectMap objectMap = this.loaders.get(clazz);
        if (objectMap == null) {
            objectMap = new ObjectMap();
            this.loaders.put(clazz, objectMap);
        }
        objectMap.put(string == null ? "" : string, assetLoader);
    }

    public synchronized int getLoadedAssets() {
        return this.assetTypes.size;
    }

    public synchronized int getQueuedAssets() {
        return this.loadQueue.size + this.tasks.size;
    }

    public synchronized float getProgress() {
        if (this.toLoad == 0) {
            return 1.0f;
        }
        float f2 = this.loaded;
        if (this.peakTasks > 0) {
            f2 += (float)(this.peakTasks - this.tasks.size) / (float)this.peakTasks;
        }
        return Math.min(1.0f, f2 / (float)this.toLoad);
    }

    public synchronized void setErrorListener(AssetErrorListener assetErrorListener) {
        this.listener = assetErrorListener;
    }

    @Override
    public void dispose() {
        this.log.debug("Disposing.");
        this.clear();
        this.executor.dispose();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        AssetManager assetManager = this;
        synchronized (assetManager) {
            this.loadQueue.clear();
        }
        this.finishLoading();
        assetManager = this;
        synchronized (assetManager) {
            ObjectIntMap<String> objectIntMap = new ObjectIntMap<String>();
            while (this.assetTypes.size > 0) {
                objectIntMap.clear(51);
                Array<String> array = this.assetTypes.keys().toArray();
                for (String string : array) {
                    Array<String> array2 = this.assetDependencies.get(string);
                    if (array2 == null) continue;
                    for (String string2 : array2) {
                        objectIntMap.getAndIncrement(string2, 0, 1);
                    }
                }
                for (String string : array) {
                    if (objectIntMap.get(string, 0) != 0) continue;
                    this.unload(string);
                }
            }
            this.assets.clear(51);
            this.assetTypes.clear(51);
            this.assetDependencies.clear(51);
            this.loaded = 0;
            this.toLoad = 0;
            this.peakTasks = 0;
            this.loadQueue.clear();
            this.tasks.clear();
        }
    }

    public Logger getLogger() {
        return this.log;
    }

    public void setLogger(Logger logger) {
        this.log = logger;
    }

    public synchronized int getReferenceCount(String string) {
        Class clazz = this.assetTypes.get(string);
        if (clazz == null) {
            throw new GdxRuntimeException("Asset not loaded: " + string);
        }
        return this.assets.get(clazz).get(string).refCount;
    }

    public synchronized void setReferenceCount(String string, int n2) {
        Class clazz = this.assetTypes.get(string);
        if (clazz == null) {
            throw new GdxRuntimeException("Asset not loaded: " + string);
        }
        this.assets.get(clazz).get(string).refCount = n2;
    }

    public synchronized String getDiagnostics() {
        StringBuilder stringBuilder = new StringBuilder(256);
        for (ObjectMap.Entry entry : this.assetTypes) {
            String string = (String)entry.key;
            Class clazz = (Class)entry.value;
            if (stringBuilder.length() > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(string);
            stringBuilder.append(", ");
            stringBuilder.append(ClassReflection.getSimpleName(clazz));
            stringBuilder.append(", refs: ");
            stringBuilder.append(this.assets.get(clazz).get(string).refCount);
            Array<String> array = this.assetDependencies.get(string);
            if (array == null) continue;
            stringBuilder.append(", deps: [");
            for (String string2 : array) {
                stringBuilder.append(string2);
                stringBuilder.append(',');
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    public synchronized Array<String> getAssetNames() {
        return this.assetTypes.keys().toArray();
    }

    public synchronized Array<String> getDependencies(String string) {
        return this.assetDependencies.get(string);
    }

    public synchronized Class getAssetType(String string) {
        return this.assetTypes.get(string);
    }

    static class RefCountedContainer {
        Object object;
        int refCount = 1;

        RefCountedContainer() {
        }
    }
}

