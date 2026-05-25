/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression.rangecoder;

import com.badlogic.gdx.utils.compression.rangecoder.Decoder;

public class BitTreeDecoder {
    short[] Models;
    int NumBitLevels;

    public BitTreeDecoder(int n2) {
        this.NumBitLevels = n2;
        this.Models = new short[1 << n2];
    }

    public void Init() {
        Decoder.InitBitModels(this.Models);
    }

    public int Decode(Decoder decoder) {
        int n2 = 1;
        for (int i2 = this.NumBitLevels; i2 != 0; --i2) {
            n2 = (n2 << 1) + decoder.DecodeBit(this.Models, n2);
        }
        return n2 - (1 << this.NumBitLevels);
    }

    public int ReverseDecode(Decoder decoder) {
        int n2 = 1;
        int n3 = 0;
        for (int i2 = 0; i2 < this.NumBitLevels; ++i2) {
            int n4 = decoder.DecodeBit(this.Models, n2);
            n2 <<= 1;
            n2 += n4;
            n3 |= n4 << i2;
        }
        return n3;
    }

    public static int ReverseDecode(short[] sArray, int n2, Decoder decoder, int n3) {
        int n4 = 1;
        int n5 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n6 = decoder.DecodeBit(sArray, n2 + n4);
            n4 <<= 1;
            n4 += n6;
            n5 |= n6 << i2;
        }
        return n5;
    }
}

