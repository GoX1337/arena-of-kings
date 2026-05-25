/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.async.AsyncExecutor;
import com.badlogic.gdx.utils.async.AsyncResult;
import com.badlogic.gdx.utils.async.AsyncTask;

class AssetLoadingTask
implements AsyncTask<Void> {
    AssetManager manager;
    final AssetDescriptor assetDesc;
    final AssetLoader loader;
    final AsyncExecutor executor;
    final long startTime;
    volatile boolean asyncDone;
    volatile boolean dependenciesLoaded;
    volatile Array<AssetDescriptor> dependencies;
    volatile AsyncResult<Void> depsFuture;
    volatile AsyncResult<Void> loadFuture;
    volatile Object asset;
    volatile boolean cancel;

    public AssetLoadingTask(AssetManager assetManager, AssetDescriptor assetDescriptor, AssetLoader assetLoader, AsyncExecutor asyncExecutor) {
        this.manager = assetManager;
        this.assetDesc = assetDescriptor;
        this.loader = assetLoader;
        this.executor = asyncExecutor;
        this.startTime = assetManager.log.getLevel() == 3 ? TimeUtils.nanoTime() : 0L;
    }

    @Override
    public Void call() {
        if (this.cancel) {
            return null;
        }
        AsynchronousAssetLoader asynchronousAssetLoader = (AsynchronousAssetLoader)this.loader;
        if (!this.dependenciesLoaded) {
            this.dependencies = asynchronousAssetLoader.getDependencies(this.assetDesc.fileName, this.resolve(this.loader, this.assetDesc), this.assetDesc.params);
            if (this.dependencies != null) {
                this.removeDuplicates(this.dependencies);
                this.manager.injectDependencies(this.assetDesc.fileName, this.dependencies);
            } else {
                asynchronousAssetLoader.loadAsync(this.manager, this.assetDesc.fileName, this.resolve(this.loader, this.assetDesc), this.assetDesc.params);
                this.asyncDone = true;
            }
        } else {
            asynchronousAssetLoader.loadAsync(this.manager, this.assetDesc.fileName, this.resolve(this.loader, this.assetDesc), this.assetDesc.params);
            this.asyncDone = true;
        }
        return null;
    }

    public boolean update() {
        if (this.loader instanceof SynchronousAssetLoader) {
            this.handleSyncLoader();
        } else {
            this.handleAsyncLoader();
        }
        return this.asset != null;
    }

    private void handleSyncLoader() {
        SynchronousAssetLoader synchronousAssetLoader = (SynchronousAssetLoader)this.loader;
        if (!this.dependenciesLoaded) {
            this.dependenciesLoaded = true;
            this.dependencies = synchronousAssetLoader.getDependencies(this.assetDesc.fileName, this.resolve(this.loader, this.assetDesc), this.assetDesc.params);
            if (this.dependencies == null) {
                this.asset = synchronousAssetLoader.load(this.manager, this.assetDesc.fileName, this.resolve(this.loader, this.assetDesc), this.assetDesc.params);
                return;
            }
            this.removeDuplicates(this.dependencies);
            this.manager.injectDependencies(this.assetDesc.fileName, this.dependencies);
        } else {
            this.asset = synchronousAssetLoader.load(this.manager, this.assetDesc.fileName, this.resolve(this.loader, this.assetDesc), this.assetDesc.params);
        }
    }

    private void handleAsyncLoader() {
        AsynchronousAssetLoader asynchronousAssetLoader = (AsynchronousAssetLoader)this.loader;
        if (!this.dependenciesLoaded) {
            if (this.depsFuture == null) {
                this.depsFuture = this.executor.submit(this);
            } else if (this.depsFuture.isDone()) {
                try {
                    this.depsFuture.get();
                }
                catch (Exception exception) {
                    throw new GdxRuntimeException("Couldn't load dependencies of asset: " + this.assetDesc.fileName, exception);
                }
                this.dependenciesLoaded = true;
                if (this.asyncDone) {
                    this.asset = asynchronousAssetLoader.loadSync(this.manager, this.assetDesc.fileName, this.resolve(this.loader, this.assetDesc), this.assetDesc.params);
                }
            }
        } else if (this.loadFuture == null && !this.asyncDone) {
            this.loadFuture = this.executor.submit(this);
        } else if (this.asyncDone) {
            this.asset = asynchronousAssetLoader.loadSync(this.manager, this.assetDesc.fileName, this.resolve(this.loader, this.assetDesc), this.assetDesc.params);
        } else if (this.loadFuture.isDone()) {
            try {
                this.loadFuture.get();
            }
            catch (Exception exception) {
                throw new GdxRuntimeException("Couldn't load asset: " + this.assetDesc.fileName, exception);
            }
            this.asset = asynchronousAssetLoader.loadSync(this.manager, this.assetDesc.fileName, this.resolve(this.loader, this.assetDesc), this.assetDesc.params);
        }
    }

    public void unload() {
        if (this.loader instanceof AsynchronousAssetLoader) {
            ((AsynchronousAssetLoader)this.loader).unloadAsync(this.manager, this.assetDesc.fileName, this.resolve(this.loader, this.assetDesc), this.assetDesc.params);
        }
    }

    private FileHandle resolve(AssetLoader assetLoader, AssetDescriptor assetDescriptor) {
        if (assetDescriptor.file == null) {
            assetDescriptor.file = assetLoader.resolve(assetDescriptor.fileName);
        }
        return assetDescriptor.file;
    }

    private void removeDuplicates(Array<AssetDescriptor> array) {
        boolean bl2 = array.ordered;
        array.ordered = true;
        for (int i2 = 0; i2 < array.size; ++i2) {
            String string = array.get((int)i2).fileName;
            Class clazz = array.get((int)i2).type;
            for (int i3 = array.size - 1; i3 > i2; --i3) {
                if (clazz != array.get((int)i3).type || !string.equals(array.get((int)i3).fileName)) continue;
                array.removeIndex(i3);
            }
        }
        array.ordered = bl2;
    }
}

