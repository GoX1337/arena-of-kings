/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3.audio;

import com.badlogic.gdx.backends.lwjgl3.audio.OggInputStream;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALLwjgl3Audio;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALMusic;
import com.badlogic.gdx.backends.lwjgl3.audio.OpenALSound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.ByteArrayOutputStream;

public class Ogg {

    public static class Sound
    extends OpenALSound {
        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Sound(OpenALLwjgl3Audio openALLwjgl3Audio, FileHandle fileHandle) {
            super(openALLwjgl3Audio);
            if (openALLwjgl3Audio.noDevice) {
                return;
            }
            OggInputStream oggInputStream = null;
            try {
                int n2;
                oggInputStream = new OggInputStream(fileHandle.read());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
                byte[] byArray = new byte[2048];
                while (!oggInputStream.atEnd() && (n2 = oggInputStream.read(byArray)) != -1) {
                    byteArrayOutputStream.write(byArray, 0, n2);
                }
                this.setup(byteArrayOutputStream.toByteArray(), oggInputStream.getChannels(), oggInputStream.getSampleRate());
            }
            catch (Throwable throwable) {
                StreamUtils.closeQuietly(oggInputStream);
                throw throwable;
            }
            StreamUtils.closeQuietly(oggInputStream);
        }
    }

    public static class Music
    extends OpenALMusic {
        private OggInputStream input;
        private OggInputStream previousInput;

        public Music(OpenALLwjgl3Audio openALLwjgl3Audio, FileHandle fileHandle) {
            super(openALLwjgl3Audio, fileHandle);
            if (openALLwjgl3Audio.noDevice) {
                return;
            }
            this.input = new OggInputStream(fileHandle.read());
            this.setup(this.input.getChannels(), this.input.getSampleRate());
        }

        @Override
        public int read(byte[] byArray) {
            if (this.input == null) {
                this.input = new OggInputStream(this.file.read(), this.previousInput);
                this.setup(this.input.getChannels(), this.input.getSampleRate());
                this.previousInput = null;
            }
            return this.input.read(byArray);
        }

        @Override
        public void reset() {
            StreamUtils.closeQuietly(this.input);
            this.previousInput = null;
            this.input = null;
        }

        @Override
        protected void loop() {
            StreamUtils.closeQuietly(this.input);
            this.previousInput = this.input;
            this.input = null;
        }
    }
}

