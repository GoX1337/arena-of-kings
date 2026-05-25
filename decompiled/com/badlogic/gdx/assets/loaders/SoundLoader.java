/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class SoundLoader
extends AsynchronousAssetLoader<Sound, SoundParameter> {
    private Sound sound;

    public SoundLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    protected Sound getLoadedSound() {
        return this.sound;
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, SoundParameter soundParameter) {
        this.sound = Gdx.audio.newSound(fileHandle);
    }

    @Override
    public Sound loadSync(AssetManager assetManager, String string, FileHandle fileHandle, SoundParameter soundParameter) {
        Sound sound = this.sound;
        this.sound = null;
        return sound;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, SoundParameter soundParameter) {
        return null;
    }

    public static class SoundParameter
    extends AssetLoaderParameters<Sound> {
    }
}

