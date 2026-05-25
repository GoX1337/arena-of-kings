/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3.audio;

import com.badlogic.gdx.backends.lwjgl3.audio.OpenALLwjgl3Audio;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALMusic;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALSound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.ByteArrayOutputStream;

public class Mp3 {

    public static class Sound
    extends OpenALSound {
        public Sound(OpenALLwjgl3Audio openALLwjgl3Audio, FileHandle fileHandle) {
            super(openALLwjgl3Audio);
            if (openALLwjgl3Audio.noDevice) {
                return;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
            bwp bwp2 = new bwp(fileHandle.read());
            bwz bwz2 = new bwz();
            try {
                bwu bwu2;
                bxa bxa2 = null;
                int n2 = -1;
                int n3 = -1;
                while ((bwu2 = bwp2.bwu_a()) != null) {
                    if (bxa2 == null) {
                        n3 = bwu2.f() == 3 ? 1 : 2;
                        bxa2 = new bxa(n3, false);
                        bwz2.a(bxa2);
                        n2 = bwu2.k();
                    }
                    try {
                        bwz2.a(bwu2, bwp2);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    bwp2.c();
                    byteArrayOutputStream.write(bxa2.byte_arr_a(), 0, bxa2.int_a());
                }
                bwp2.void_a();
                this.setup(byteArrayOutputStream.toByteArray(), n3, n2);
            }
            catch (Throwable throwable) {
                throw new GdxRuntimeException("Error reading audio data.", throwable);
            }
        }
    }

    public static class Music
    extends OpenALMusic {
        private bwp bitstream;
        private bxa outputBuffer;
        private bwz decoder;

        public Music(OpenALLwjgl3Audio openALLwjgl3Audio, FileHandle fileHandle) {
            super(openALLwjgl3Audio, fileHandle);
            if (openALLwjgl3Audio.noDevice) {
                return;
            }
            this.bitstream = new bwp(fileHandle.read());
            this.decoder = new bwz();
            try {
                bwu bwu2 = this.bitstream.bwu_a();
                if (bwu2 == null) {
                    throw new GdxRuntimeException("Empty MP3");
                }
                int n2 = bwu2.f() == 3 ? 1 : 2;
                this.outputBuffer = new bxa(n2, false);
                this.decoder.a(this.outputBuffer);
                this.setup(n2, bwu2.k());
            }
            catch (bwq bwq2) {
                throw new GdxRuntimeException("error while preloading mp3", bwq2);
            }
        }

        @Override
        public int read(byte[] byArray) {
            try {
                bwu bwu2;
                int n2;
                int n3;
                boolean bl2;
                boolean bl3 = bl2 = this.bitstream == null;
                if (bl2) {
                    this.bitstream = new bwp(this.file.read());
                    this.decoder = new bwz();
                }
                int n4 = byArray.length - 4608;
                for (n2 = 0; n2 <= n4 && (bwu2 = this.bitstream.bwu_a()) != null; n2 += n3) {
                    if (bl2) {
                        n3 = bwu2.f() == 3 ? 1 : 2;
                        this.outputBuffer = new bxa(n3, false);
                        this.decoder.a(this.outputBuffer);
                        this.setup(n3, bwu2.k());
                        bl2 = false;
                    }
                    try {
                        this.decoder.a(bwu2, this.bitstream);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    this.bitstream.c();
                    n3 = this.outputBuffer.int_a();
                    System.arraycopy(this.outputBuffer.byte_arr_a(), 0, byArray, n2, n3);
                }
                return n2;
            }
            catch (Throwable throwable) {
                this.reset();
                throw new GdxRuntimeException("Error reading audio data.", throwable);
            }
        }

        @Override
        public void reset() {
            if (this.bitstream == null) {
                return;
            }
            try {
                this.bitstream.void_a();
            }
            catch (bwq bwq2) {
                // empty catch block
            }
            this.bitstream = null;
        }
    }
}

