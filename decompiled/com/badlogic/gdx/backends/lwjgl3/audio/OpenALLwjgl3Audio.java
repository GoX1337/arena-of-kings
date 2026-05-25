/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3.audio;

import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.AudioRecorder;
import com.badlogic.gdx.backends.lwjgl3.audio.JavaSoundAudioRecorder;
import com.badlogic.gdx.backends.lwjgl3.audio.Lwjgl3Audio;
import com.badlogic.gdx.backends.lwjgl3.audio.Mp3;
import com.badlogic.gdx.backends.lwjgl3.audio.Ogg;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALAudioDevice;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALMusic;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALSound;
import com.badlogic.gdx.backends.lwjgl3.audio.Wav;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.LongMap;
import com.badlogic.gdx.utils.ObjectMap;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALCCapabilities;

public class OpenALLwjgl3Audio
implements Lwjgl3Audio {
    private final int deviceBufferSize;
    private final int deviceBufferCount;
    private IntArray idleSources;
    private IntArray allSources;
    private LongMap<Integer> soundIdToSource;
    private IntMap<Long> sourceToSoundId;
    private long nextSoundId = 0L;
    private ObjectMap<String, Class<? extends OpenALSound>> extensionToSoundClass = new ObjectMap();
    private ObjectMap<String, Class<? extends OpenALMusic>> extensionToMusicClass = new ObjectMap();
    private OpenALSound[] recentSounds;
    private int mostRecetSound = -1;
    Array<OpenALMusic> music = new Array(false, 1, OpenALMusic.class);
    long device;
    long context;
    boolean noDevice = false;

    public OpenALLwjgl3Audio() {
        this(16, 9, 512);
    }

    public OpenALLwjgl3Audio(int n2, int n3, int n4) {
        this.deviceBufferSize = n4;
        this.deviceBufferCount = n3;
        this.registerSound("ogg", Ogg.Sound.class);
        this.registerMusic("ogg", Ogg.Music.class);
        this.registerSound("wav", Wav.Sound.class);
        this.registerMusic("wav", Wav.Music.class);
        this.registerSound("mp3", Mp3.Sound.class);
        this.registerMusic("mp3", Mp3.Music.class);
        this.device = ALC10.alcOpenDevice((ByteBuffer)null);
        if (this.device == 0L) {
            this.noDevice = true;
            return;
        }
        ALCCapabilities aLCCapabilities = ALC.createCapabilities(this.device);
        this.context = ALC10.alcCreateContext(this.device, (IntBuffer)null);
        if (this.context == 0L) {
            ALC10.alcCloseDevice(this.device);
            this.noDevice = true;
            return;
        }
        if (!ALC10.alcMakeContextCurrent(this.context)) {
            this.noDevice = true;
            return;
        }
        AL.createCapabilities(aLCCapabilities);
        AL10.alGetError();
        this.allSources = new IntArray(false, n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5 = AL10.alGenSources();
            if (AL10.alGetError() != 0) break;
            this.allSources.add(n5);
        }
        this.idleSources = new IntArray(this.allSources);
        this.soundIdToSource = new LongMap();
        this.sourceToSoundId = new IntMap();
        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(6).put(new float[]{0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f});
        ((Buffer)floatBuffer).flip();
        AL10.alListenerfv(4111, floatBuffer);
        FloatBuffer floatBuffer2 = BufferUtils.createFloatBuffer(3).put(new float[]{0.0f, 0.0f, 0.0f});
        ((Buffer)floatBuffer2).flip();
        AL10.alListenerfv(4102, floatBuffer2);
        FloatBuffer floatBuffer3 = BufferUtils.createFloatBuffer(3).put(new float[]{0.0f, 0.0f, 0.0f});
        ((Buffer)floatBuffer3).flip();
        AL10.alListenerfv(4100, floatBuffer3);
        this.recentSounds = new OpenALSound[n2];
    }

    public void registerSound(String string, Class<? extends OpenALSound> clazz) {
        if (string == null) {
            throw new IllegalArgumentException("extension cannot be null.");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("soundClass cannot be null.");
        }
        this.extensionToSoundClass.put(string, clazz);
    }

    public void registerMusic(String string, Class<? extends OpenALMusic> clazz) {
        if (string == null) {
            throw new IllegalArgumentException("extension cannot be null.");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("musicClass cannot be null.");
        }
        this.extensionToMusicClass.put(string, clazz);
    }

    @Override
    public OpenALSound newSound(FileHandle fileHandle) {
        if (fileHandle == null) {
            throw new IllegalArgumentException("file cannot be null.");
        }
        Class<? extends OpenALSound> clazz = this.extensionToSoundClass.get(fileHandle.extension().toLowerCase());
        if (clazz == null) {
            throw new GdxRuntimeException("Unknown file extension for sound: " + fileHandle);
        }
        try {
            return clazz.getConstructor(OpenALLwjgl3Audio.class, FileHandle.class).newInstance(this, fileHandle);
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Error creating sound " + clazz.getName() + " for file: " + fileHandle, exception);
        }
    }

    @Override
    public OpenALMusic newMusic(FileHandle fileHandle) {
        if (fileHandle == null) {
            throw new IllegalArgumentException("file cannot be null.");
        }
        Class<? extends OpenALMusic> clazz = this.extensionToMusicClass.get(fileHandle.extension().toLowerCase());
        if (clazz == null) {
            throw new GdxRuntimeException("Unknown file extension for music: " + fileHandle);
        }
        try {
            return clazz.getConstructor(OpenALLwjgl3Audio.class, FileHandle.class).newInstance(this, fileHandle);
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Error creating music " + clazz.getName() + " for file: " + fileHandle, exception);
        }
    }

    int obtainSource(boolean bl2) {
        if (this.noDevice) {
            return 0;
        }
        int n2 = this.idleSources.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.idleSources.get(i2);
            int n4 = AL10.alGetSourcei(n3, 4112);
            if (n4 == 4114 || n4 == 4115) continue;
            Long l2 = this.sourceToSoundId.remove(n3);
            if (l2 != null) {
                this.soundIdToSource.remove(l2);
            }
            if (bl2) {
                this.idleSources.removeIndex(i2);
            } else {
                long l3 = this.nextSoundId++;
                this.sourceToSoundId.put(n3, l3);
                this.soundIdToSource.put(l3, n3);
            }
            AL10.alSourceStop(n3);
            AL10.alSourcei(n3, 4105, 0);
            AL10.alSourcef(n3, 4106, 1.0f);
            AL10.alSourcef(n3, 4099, 1.0f);
            AL10.alSource3f(n3, 4100, 0.0f, 0.0f, 1.0f);
            AL10.alSourcei(n3, 4147, 1);
            return n3;
        }
        return -1;
    }

    void freeSource(int n2) {
        if (this.noDevice) {
            return;
        }
        AL10.alSourceStop(n2);
        AL10.alSourcei(n2, 4105, 0);
        Long l2 = this.sourceToSoundId.remove(n2);
        if (l2 != null) {
            this.soundIdToSource.remove(l2);
        }
        this.idleSources.add(n2);
    }

    void freeBuffer(int n2) {
        if (this.noDevice) {
            return;
        }
        int n3 = this.idleSources.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.idleSources.get(i2);
            if (AL10.alGetSourcei(n4, 4105) != n2) continue;
            Long l2 = this.sourceToSoundId.remove(n4);
            if (l2 != null) {
                this.soundIdToSource.remove(l2);
            }
            AL10.alSourceStop(n4);
            AL10.alSourcei(n4, 4105, 0);
        }
    }

    void stopSourcesWithBuffer(int n2) {
        if (this.noDevice) {
            return;
        }
        int n3 = this.idleSources.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.idleSources.get(i2);
            if (AL10.alGetSourcei(n4, 4105) != n2) continue;
            Long l2 = this.sourceToSoundId.remove(n4);
            if (l2 != null) {
                this.soundIdToSource.remove(l2);
            }
            AL10.alSourceStop(n4);
        }
    }

    void pauseSourcesWithBuffer(int n2) {
        if (this.noDevice) {
            return;
        }
        int n3 = this.idleSources.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.idleSources.get(i2);
            if (AL10.alGetSourcei(n4, 4105) != n2) continue;
            AL10.alSourcePause(n4);
        }
    }

    void resumeSourcesWithBuffer(int n2) {
        if (this.noDevice) {
            return;
        }
        int n3 = this.idleSources.size;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.idleSources.get(i2);
            if (AL10.alGetSourcei(n4, 4105) != n2 || AL10.alGetSourcei(n4, 4112) != 4115) continue;
            AL10.alSourcePlay(n4);
        }
    }

    @Override
    public void update() {
        if (this.noDevice) {
            return;
        }
        for (int i2 = 0; i2 < this.music.size; ++i2) {
            ((OpenALMusic[])this.music.items)[i2].update();
        }
    }

    public long getSoundId(int n2) {
        Long l2 = this.sourceToSoundId.get(n2);
        return l2 != null ? l2 : -1L;
    }

    public int getSourceId(long l2) {
        Integer n2 = this.soundIdToSource.get(l2);
        return n2 != null ? n2 : -1;
    }

    public void stopSound(long l2) {
        Integer n2 = this.soundIdToSource.get(l2);
        if (n2 != null) {
            AL10.alSourceStop(n2);
        }
    }

    public void pauseSound(long l2) {
        Integer n2 = this.soundIdToSource.get(l2);
        if (n2 != null) {
            AL10.alSourcePause(n2);
        }
    }

    public void resumeSound(long l2) {
        int n2 = this.soundIdToSource.get(l2, -1);
        if (n2 != -1 && AL10.alGetSourcei(n2, 4112) == 4115) {
            AL10.alSourcePlay(n2);
        }
    }

    public void setSoundGain(long l2, float f2) {
        Integer n2 = this.soundIdToSource.get(l2);
        if (n2 != null) {
            AL10.alSourcef(n2, 4106, f2);
        }
    }

    public void setSoundLooping(long l2, boolean bl2) {
        Integer n2 = this.soundIdToSource.get(l2);
        if (n2 != null) {
            AL10.alSourcei(n2, 4103, bl2 ? 1 : 0);
        }
    }

    public void setSoundPitch(long l2, float f2) {
        Integer n2 = this.soundIdToSource.get(l2);
        if (n2 != null) {
            AL10.alSourcef(n2, 4099, f2);
        }
    }

    public void setSoundPan(long l2, float f2, float f3) {
        int n2 = this.soundIdToSource.get(l2, -1);
        if (n2 != -1) {
            AL10.alSource3f(n2, 4100, MathUtils.cos((f2 - 1.0f) * 1.5707964f), 0.0f, MathUtils.sin((f2 + 1.0f) * 1.5707964f));
            AL10.alSourcef(n2, 4106, f3);
        }
    }

    @Override
    public void dispose() {
        if (this.noDevice) {
            return;
        }
        int n2 = this.allSources.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.allSources.get(i2);
            int n4 = AL10.alGetSourcei(n3, 4112);
            if (n4 != 4116) {
                AL10.alSourceStop(n3);
            }
            AL10.alDeleteSources(n3);
        }
        this.sourceToSoundId = null;
        this.soundIdToSource = null;
        ALC10.alcDestroyContext(this.context);
        ALC10.alcCloseDevice(this.device);
    }

    @Override
    public AudioDevice newAudioDevice(int n2, final boolean bl2) {
        if (this.noDevice) {
            return new AudioDevice(){

                @Override
                public void writeSamples(float[] fArray, int n2, int n3) {
                }

                @Override
                public void writeSamples(short[] sArray, int n2, int n3) {
                }

                @Override
                public void setVolume(float f2) {
                }

                @Override
                public boolean isMono() {
                    return bl2;
                }

                @Override
                public int getLatency() {
                    return 0;
                }

                @Override
                public void dispose() {
                }

                @Override
                public void pause() {
                }

                @Override
                public void resume() {
                }
            };
        }
        return new OpenALAudioDevice(this, n2, bl2, this.deviceBufferSize, this.deviceBufferCount);
    }

    @Override
    public AudioRecorder newAudioRecorder(int n2, boolean bl2) {
        if (this.noDevice) {
            return new AudioRecorder(){

                @Override
                public void read(short[] sArray, int n2, int n3) {
                }

                @Override
                public void dispose() {
                }
            };
        }
        return new JavaSoundAudioRecorder(n2, bl2);
    }

    protected void retain(OpenALSound openALSound, boolean bl2) {
        ++this.mostRecetSound;
        this.mostRecetSound %= this.recentSounds.length;
        if (bl2 && this.recentSounds[this.mostRecetSound] != null) {
            this.recentSounds[this.mostRecetSound].stop();
        }
        this.recentSounds[this.mostRecetSound] = openALSound;
    }

    public void forget(OpenALSound openALSound) {
        for (int i2 = 0; i2 < this.recentSounds.length; ++i2) {
            if (this.recentSounds[i2] != openALSound) continue;
            this.recentSounds[i2] = null;
        }
    }
}

