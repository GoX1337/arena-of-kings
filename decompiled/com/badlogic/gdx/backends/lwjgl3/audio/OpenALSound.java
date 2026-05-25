/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3.audio;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALLwjgl3Audio;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.lwjgl.openal.AL10;

public class OpenALSound
implements Sound {
    private int bufferID = -1;
    private final OpenALLwjgl3Audio audio;
    private float duration;
    private int sampleRate;
    private int channels;

    public OpenALSound(OpenALLwjgl3Audio openALLwjgl3Audio) {
        this.audio = openALLwjgl3Audio;
    }

    void setup(byte[] byArray, int n2, int n3) {
        this.channels = n2;
        this.sampleRate = n3;
        int n4 = byArray.length - byArray.length % (n2 > 1 ? 4 : 2);
        int n5 = n4 / (2 * n2);
        this.duration = (float)n5 / (float)n3;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n4);
        byteBuffer.order(ByteOrder.nativeOrder());
        byteBuffer.put(byArray, 0, n4);
        ((Buffer)byteBuffer).flip();
        if (this.bufferID == -1) {
            this.bufferID = AL10.alGenBuffers();
            AL10.alBufferData(this.bufferID, n2 > 1 ? 4355 : 4353, byteBuffer.asShortBuffer(), n3);
        }
    }

    @Override
    public long play() {
        return this.play(1.0f);
    }

    @Override
    public long play(float f2) {
        if (this.audio.noDevice) {
            return 0L;
        }
        int n2 = this.audio.obtainSource(false);
        if (n2 == -1) {
            this.audio.retain(this, true);
            n2 = this.audio.obtainSource(false);
        } else {
            this.audio.retain(this, false);
        }
        if (n2 == -1) {
            return -1L;
        }
        long l2 = this.audio.getSoundId(n2);
        AL10.alSourcei(n2, 4105, this.bufferID);
        AL10.alSourcei(n2, 4103, 0);
        AL10.alSourcef(n2, 4106, f2);
        AL10.alSourcePlay(n2);
        return l2;
    }

    @Override
    public long loop() {
        return this.loop(1.0f);
    }

    @Override
    public long loop(float f2) {
        if (this.audio.noDevice) {
            return 0L;
        }
        int n2 = this.audio.obtainSource(false);
        if (n2 == -1) {
            return -1L;
        }
        long l2 = this.audio.getSoundId(n2);
        AL10.alSourcei(n2, 4105, this.bufferID);
        AL10.alSourcei(n2, 4103, 1);
        AL10.alSourcef(n2, 4106, f2);
        AL10.alSourcePlay(n2);
        return l2;
    }

    @Override
    public void stop() {
        if (this.audio.noDevice) {
            return;
        }
        this.audio.stopSourcesWithBuffer(this.bufferID);
    }

    @Override
    public void dispose() {
        if (this.audio.noDevice) {
            return;
        }
        if (this.bufferID == -1) {
            return;
        }
        this.audio.freeBuffer(this.bufferID);
        AL10.alDeleteBuffers(this.bufferID);
        this.bufferID = -1;
        this.audio.forget(this);
    }

    @Override
    public void stop(long l2) {
        if (this.audio.noDevice) {
            return;
        }
        this.audio.stopSound(l2);
    }

    @Override
    public void pause() {
        if (this.audio.noDevice) {
            return;
        }
        this.audio.pauseSourcesWithBuffer(this.bufferID);
    }

    @Override
    public void pause(long l2) {
        if (this.audio.noDevice) {
            return;
        }
        this.audio.pauseSound(l2);
    }

    @Override
    public void resume() {
        if (this.audio.noDevice) {
            return;
        }
        this.audio.resumeSourcesWithBuffer(this.bufferID);
    }

    @Override
    public void resume(long l2) {
        if (this.audio.noDevice) {
            return;
        }
        this.audio.resumeSound(l2);
    }

    @Override
    public void setPitch(long l2, float f2) {
        if (this.audio.noDevice) {
            return;
        }
        this.audio.setSoundPitch(l2, f2);
    }

    @Override
    public void setVolume(long l2, float f2) {
        if (this.audio.noDevice) {
            return;
        }
        this.audio.setSoundGain(l2, f2);
    }

    @Override
    public void setLooping(long l2, boolean bl2) {
        if (this.audio.noDevice) {
            return;
        }
        this.audio.setSoundLooping(l2, bl2);
    }

    @Override
    public void setPan(long l2, float f2, float f3) {
        if (this.audio.noDevice) {
            return;
        }
        this.audio.setSoundPan(l2, f2, f3);
    }

    @Override
    public long play(float f2, float f3, float f4) {
        long l2 = this.play();
        this.setPitch(l2, f3);
        this.setPan(l2, f4, f2);
        return l2;
    }

    @Override
    public long loop(float f2, float f3, float f4) {
        long l2 = this.loop();
        this.setPitch(l2, f3);
        this.setPan(l2, f4, f2);
        return l2;
    }

    public float duration() {
        return this.duration;
    }

    public int getRate() {
        return this.sampleRate;
    }

    public int getChannels() {
        return this.channels;
    }
}

