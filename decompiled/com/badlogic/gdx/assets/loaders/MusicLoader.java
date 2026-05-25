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
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class MusicLoader
extends AsynchronousAssetLoader<Music, MusicParameter> {
    private Music music;

    public MusicLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    protected Music getLoadedMusic() {
        return this.music;
    }

    @Override
    public void loadAsync(AssetManager assetManager, String string, FileHandle fileHandle, MusicParameter musicParameter) {
        this.music = Gdx.audio.newMusic(fileHandle);
    }

    @Override
    public Music loadSync(AssetManager assetManager, String string, FileHandle fileHandle, MusicParameter musicParameter) {
        Music music = this.music;
        this.music = null;
        return music;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String string, FileHandle fileHandle, MusicParameter musicParameter) {
        return null;
    }

    public static class MusicParameter
    extends AssetLoaderParameters<Music> {
    }
}

