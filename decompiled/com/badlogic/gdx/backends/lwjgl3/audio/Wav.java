/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3.audio;

import com.badlogic.gdx.backends.lwjgl3.audio.OpenALLwjgl3Audio;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALMusic;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALSound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;

public class Wav {

    public static class WavInputStream
    extends FilterInputStream {
        public int channels;
        public int sampleRate;
        public int dataRemaining;

        public WavInputStream(FileHandle fileHandle) {
            super(fileHandle.read());
            try {
                if (this.read() != 82 || this.read() != 73 || this.read() != 70 || this.read() != 70) {
                    throw new GdxRuntimeException("RIFF header not found: " + fileHandle);
                }
                this.skipFully(4);
                if (this.read() != 87 || this.read() != 65 || this.read() != 86 || this.read() != 69) {
                    throw new GdxRuntimeException("Invalid wave file header: " + fileHandle);
                }
                int n2 = this.seekToChunk('f', 'm', 't', ' ');
                int n3 = this.read() & 0xFF | (this.read() & 0xFF) << 8;
                if (n3 != 1) {
                    String string;
                    switch (n3) {
                        case 2: {
                            string = "ADPCM";
                            break;
                        }
                        case 3: {
                            string = "IEEE float";
                            break;
                        }
                        case 6: {
                            string = "8-bit ITU-T G.711 A-law";
                            break;
                        }
                        case 7: {
                            string = "8-bit ITU-T G.711 u-law";
                            break;
                        }
                        case 65534: {
                            string = "Extensible";
                            break;
                        }
                        default: {
                            string = "Unknown";
                        }
                    }
                    throw new GdxRuntimeException("WAV files must be PCM, unsupported format: " + string + " (" + n3 + ")");
                }
                this.channels = this.read() & 0xFF | (this.read() & 0xFF) << 8;
                if (this.channels != 1 && this.channels != 2) {
                    throw new GdxRuntimeException("WAV files must have 1 or 2 channels: " + this.channels);
                }
                this.sampleRate = this.read() & 0xFF | (this.read() & 0xFF) << 8 | (this.read() & 0xFF) << 16 | (this.read() & 0xFF) << 24;
                this.skipFully(6);
                int n4 = this.read() & 0xFF | (this.read() & 0xFF) << 8;
                if (n4 != 16) {
                    throw new GdxRuntimeException("WAV files must have 16 bits per sample: " + n4);
                }
                this.skipFully(n2 - 16);
                this.dataRemaining = this.seekToChunk('d', 'a', 't', 'a');
            }
            catch (Throwable throwable) {
                StreamUtils.closeQuietly(this);
                throw new GdxRuntimeException("Error reading WAV file: " + fileHandle, throwable);
            }
        }

        private int seekToChunk(char c2, char c3, char c4, char c5) {
            while (true) {
                boolean bl2 = this.read() == c2;
                bl2 &= this.read() == c3;
                bl2 &= this.read() == c4;
                bl2 &= this.read() == c5;
                int n2 = this.read() & 0xFF | (this.read() & 0xFF) << 8 | (this.read() & 0xFF) << 16 | (this.read() & 0xFF) << 24;
                if (n2 == -1) {
                    throw new IOException("Chunk not found: " + c2 + c3 + c4 + c5);
                }
                if (bl2) {
                    return n2;
                }
                this.skipFully(n2);
            }
        }

        private void skipFully(int n2) {
            while (n2 > 0) {
                long l2 = this.in.skip(n2);
                if (l2 <= 0L) {
                    throw new EOFException("Unable to skip.");
                }
                n2 = (int)((long)n2 - l2);
            }
        }

        @Override
        public int read(byte[] byArray) {
            int n2;
            if (this.dataRemaining == 0) {
                return -1;
            }
            int n3 = 0;
            do {
                if ((n2 = Math.min(super.read(byArray, n3, byArray.length - n3), this.dataRemaining)) == -1) {
                    if (n3 > 0) {
                        return n3;
                    }
                    return -1;
                }
                this.dataRemaining -= n2;
            } while ((n3 += n2) < byArray.length);
            return n3;
        }
    }

    public static class Sound
    extends OpenALSound {
        public Sound(OpenALLwjgl3Audio openALLwjgl3Audio, FileHandle fileHandle) {
            super(openALLwjgl3Audio);
            if (openALLwjgl3Audio.noDevice) {
                return;
            }
            WavInputStream wavInputStream = null;
            try {
                wavInputStream = new WavInputStream(fileHandle);
                this.setup(StreamUtils.copyStreamToByteArray(wavInputStream, wavInputStream.dataRemaining), wavInputStream.channels, wavInputStream.sampleRate);
            }
            catch (IOException iOException) {
                try {
                    throw new GdxRuntimeException("Error reading WAV file: " + fileHandle, iOException);
                }
                catch (Throwable throwable) {
                    StreamUtils.closeQuietly(wavInputStream);
                    throw throwable;
                }
            }
            StreamUtils.closeQuietly(wavInputStream);
        }
    }

    public static class Music
    extends OpenALMusic {
        private WavInputStream input;

        public Music(OpenALLwjgl3Audio openALLwjgl3Audio, FileHandle fileHandle) {
            super(openALLwjgl3Audio, fileHandle);
            this.input = new WavInputStream(fileHandle);
            if (openALLwjgl3Audio.noDevice) {
                return;
            }
            this.setup(this.input.channels, this.input.sampleRate);
        }

        @Override
        public int read(byte[] byArray) {
            if (this.input == null) {
                this.input = new WavInputStream(this.file);
                this.setup(this.input.channels, this.input.sampleRate);
            }
            try {
                return this.input.read(byArray);
            }
            catch (IOException iOException) {
                throw new GdxRuntimeException("Error reading WAV file: " + this.file, iOException);
            }
        }

        @Override
        public void reset() {
            StreamUtils.closeQuietly(this.input);
            this.input = null;
        }
    }
}

