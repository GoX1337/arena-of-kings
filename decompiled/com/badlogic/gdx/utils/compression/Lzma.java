/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression;

import com.badlogic.gdx.utils.compression.lzma.Decoder;
import com.badlogic.gdx.utils.compression.lzma.Encoder;
import java.io.InputStream;
import java.io.OutputStream;

public class Lzma {
    public static void compress(InputStream inputStream, OutputStream outputStream) {
        long l2;
        Encoder encoder;
        CommandLine commandLine = new CommandLine();
        boolean bl2 = false;
        if (commandLine.Eos) {
            bl2 = true;
        }
        if (!(encoder = new Encoder()).SetAlgorithm(commandLine.Algorithm)) {
            throw new RuntimeException("Incorrect compression mode");
        }
        if (!encoder.SetDictionarySize(commandLine.DictionarySize)) {
            throw new RuntimeException("Incorrect dictionary size");
        }
        if (!encoder.SetNumFastBytes(commandLine.Fb)) {
            throw new RuntimeException("Incorrect -fb value");
        }
        if (!encoder.SetMatchFinder(commandLine.MatchFinder)) {
            throw new RuntimeException("Incorrect -mf value");
        }
        if (!encoder.SetLcLpPb(commandLine.Lc, commandLine.Lp, commandLine.Pb)) {
            throw new RuntimeException("Incorrect -lc or -lp or -pb value");
        }
        encoder.SetEndMarkerMode(bl2);
        encoder.WriteCoderProperties(outputStream);
        if (bl2) {
            l2 = -1L;
        } else {
            l2 = inputStream.available();
            if (l2 == 0L) {
                l2 = -1L;
            }
        }
        for (int i2 = 0; i2 < 8; ++i2) {
            outputStream.write((int)(l2 >>> 8 * i2) & 0xFF);
        }
        encoder.Code(inputStream, outputStream, -1L, -1L, null);
    }

    public static void decompress(InputStream inputStream, OutputStream outputStream) {
        int n2 = 5;
        byte[] byArray = new byte[n2];
        if (inputStream.read(byArray, 0, n2) != n2) {
            throw new RuntimeException("input .lzma file is too short");
        }
        Decoder decoder = new Decoder();
        if (!decoder.SetDecoderProperties(byArray)) {
            throw new RuntimeException("Incorrect stream properties");
        }
        long l2 = 0L;
        for (int i2 = 0; i2 < 8; ++i2) {
            int n3 = inputStream.read();
            if (n3 < 0) {
                throw new RuntimeException("Can't read stream size");
            }
            l2 |= (long)n3 << 8 * i2;
        }
        if (!decoder.Code(inputStream, outputStream, l2)) {
            throw new RuntimeException("Error in data stream");
        }
    }

    static class CommandLine {
        public static final int kEncode = 0;
        public static final int kDecode = 1;
        public static final int kBenchmak = 2;
        public int Command = -1;
        public int NumBenchmarkPasses = 10;
        public int DictionarySize = 0x800000;
        public boolean DictionarySizeIsDefined = false;
        public int Lc = 3;
        public int Lp = 0;
        public int Pb = 2;
        public int Fb = 128;
        public boolean FbIsDefined = false;
        public boolean Eos = false;
        public int Algorithm = 2;
        public int MatchFinder = 1;
        public String InFile;
        public String OutFile;

        CommandLine() {
        }
    }
}

