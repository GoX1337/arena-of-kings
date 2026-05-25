/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3.audio;

import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALLwjgl3Audio;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;

public class OpenALAudioDevice
implements AudioDevice {
    private static final int bytesPerSample = 2;
    private final OpenALLwjgl3Audio audio;
    private final int channels;
    private IntBuffer buffers;
    private int sourceID = -1;
    private int format;
    private int sampleRate;
    private boolean isPlaying;
    private float volume = 1.0f;
    private float renderedSeconds;
    private float secondsPerBuffer;
    private byte[] bytes;
    private final int bufferSize;
    private final int bufferCount;
    private final ByteBuffer tempBuffer;

    public OpenALAudioDevice(OpenALLwjgl3Audio openALLwjgl3Audio, int n2, boolean bl2, int n3, int n4) {
        this.audio = openALLwjgl3Audio;
        this.channels = bl2 ? 1 : 2;
        this.bufferSize = n3;
        this.bufferCount = n4;
        this.format = this.channels > 1 ? 4355 : 4353;
        this.sampleRate = n2;
        this.secondsPerBuffer = (float)n3 / 2.0f / (float)this.channels / (float)n2;
        this.tempBuffer = BufferUtils.createByteBuffer(n3);
    }

    @Override
    public void writeSamples(short[] sArray, int n2, int n3) {
        if (this.bytes == null || this.bytes.length < n3 * 2) {
            this.bytes = new byte[n3 * 2];
        }
        int n4 = Math.min(n2 + n3, sArray.length);
        int n5 = 0;
        for (int i2 = n2; i2 < n4; ++i2) {
            short s2 = sArray[i2];
            this.bytes[n5++] = (byte)(s2 & 0xFF);
            this.bytes[n5++] = (byte)(s2 >> 8 & 0xFF);
        }
        this.writeSamples(this.bytes, 0, n3 * 2);
    }

    @Override
    public void writeSamples(float[] fArray, int n2, int n3) {
        if (this.bytes == null || this.bytes.length < n3 * 2) {
            this.bytes = new byte[n3 * 2];
        }
        int n4 = Math.min(n2 + n3, fArray.length);
        int n5 = 0;
        for (int i2 = n2; i2 < n4; ++i2) {
            float f2 = fArray[i2];
            f2 = MathUtils.clamp(f2, -1.0f, 1.0f);
            int n6 = (int)(f2 * 32767.0f);
            this.bytes[n5++] = (byte)(n6 & 0xFF);
            this.bytes[n5++] = (byte)(n6 >> 8 & 0xFF);
        }
        this.writeSamples(this.bytes, 0, n3 * 2);
    }

    public void writeSamples(byte[] byArray, int n2, int n3) {
        int n4;
        if (n3 < 0) {
            throw new IllegalArgumentException("length cannot be < 0.");
        }
        if (this.sourceID == -1) {
            this.sourceID = this.audio.obtainSource(true);
            if (this.sourceID == -1) {
                return;
            }
            if (this.buffers == null) {
                this.buffers = BufferUtils.createIntBuffer(this.bufferCount);
                AL10.alGetError();
                AL10.alGenBuffers(this.buffers);
                if (AL10.alGetError() != 0) {
                    throw new GdxRuntimeException("Unabe to allocate audio buffers.");
                }
            }
            AL10.alSourcei(this.sourceID, 4103, 0);
            AL10.alSourcef(this.sourceID, 4106, this.volume);
            for (n4 = 0; n4 < this.bufferCount; ++n4) {
                int n5 = this.buffers.get(n4);
                int n6 = Math.min(this.bufferSize, n3);
                ((Buffer)this.tempBuffer).clear();
                ((Buffer)this.tempBuffer.put(byArray, n2, n6)).flip();
                AL10.alBufferData(n5, this.format, this.tempBuffer, this.sampleRate);
                AL10.alSourceQueueBuffers(this.sourceID, n5);
                n3 -= n6;
                n2 += n6;
            }
            AL10.alSourcePlay(this.sourceID);
            this.isPlaying = true;
        }
        while (n3 > 0) {
            n4 = this.fillBuffer(byArray, n2, n3);
            n3 -= n4;
            n2 += n4;
        }
    }

    private int fillBuffer(byte[] byArray, int n2, int n3) {
        int n4;
        int n5 = Math.min(this.bufferSize, n3);
        while (true) {
            int n6 = AL10.alGetSourcei(this.sourceID, 4118);
            if (n6-- > 0 && (n4 = AL10.alSourceUnqueueBuffers(this.sourceID)) != 40963) {
                this.renderedSeconds += this.secondsPerBuffer;
                break;
            }
            try {
                Thread.sleep((long)(1000.0f * this.secondsPerBuffer));
            }
            catch (InterruptedException interruptedException) {}
        }
        ((Buffer)this.tempBuffer).clear();
        ((Buffer)this.tempBuffer.put(byArray, n2, n5)).flip();
        AL10.alBufferData(n4, this.format, this.tempBuffer, this.sampleRate);
        AL10.alSourceQueueBuffers(this.sourceID, n4);
        if (!this.isPlaying || AL10.alGetSourcei(this.sourceID, 4112) != 4114) {
            AL10.alSourcePlay(this.sourceID);
            this.isPlaying = true;
        }
        return n5;
    }

    public void stop() {
        if (this.sourceID == -1) {
            return;
        }
        this.audio.freeSource(this.sourceID);
        this.sourceID = -1;
        this.renderedSeconds = 0.0f;
        this.isPlaying = false;
    }

    public boolean isPlaying() {
        if (this.sourceID == -1) {
            return false;
        }
        return this.isPlaying;
    }

    @Override
    public void setVolume(float f2) {
        this.volume = f2;
        if (this.sourceID != -1) {
            AL10.alSourcef(this.sourceID, 4106, f2);
        }
    }

    public float getPosition() {
        if (this.sourceID == -1) {
            return 0.0f;
        }
        return this.renderedSeconds + AL10.alGetSourcef(this.sourceID, 4132);
    }

    public void setPosition(float f2) {
        this.renderedSeconds = f2;
    }

    public int getChannels() {
        return this.format == 4355 ? 2 : 1;
    }

    public int getRate() {
        return this.sampleRate;
    }

    @Override
    public void dispose() {
        if (this.buffers == null) {
            return;
        }
        if (this.sourceID != -1) {
            this.audio.freeSource(this.sourceID);
            this.sourceID = -1;
        }
        AL10.alDeleteBuffers(this.buffers);
        this.buffers = null;
    }

    @Override
    public boolean isMono() {
        return this.channels == 1;
    }

    @Override
    public int getLatency() {
        return (int)(this.secondsPerBuffer * (float)this.bufferCount * 1000.0f);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}

