/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3.audio.mock;

import com.badlogic.gdx.audio.Music;

public class MockMusic
implements Music {
    @Override
    public void play() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void stop() {
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public void setLooping(boolean bl2) {
    }

    @Override
    public boolean isLooping() {
        return false;
    }

    @Override
    public void setVolume(float f2) {
    }

    @Override
    public float getVolume() {
        return 0.0f;
    }

    @Override
    public void setPan(float f2, float f3) {
    }

    @Override
    public void setPosition(float f2) {
    }

    @Override
    public float getPosition() {
        return 0.0f;
    }

    @Override
    public void dispose() {
    }

    @Override
    public void setOnCompletionListener(Music.OnCompletionListener onCompletionListener) {
    }
}

