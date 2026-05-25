/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression.rangecoder;

import com.badlogic.gdx.utils.compression.rangecoder.Decoder;
import com.badlogic.gdx.utils.compression.rangecoder.Encoder;

public class BitTreeEncoder {
    short[] Models;
    int NumBitLevels;

    public BitTreeEncoder(int n2) {
        this.NumBitLevels = n2;
        this.Models = new short[1 << n2];
    }

    public void Init() {
        Decoder.InitBitModels(this.Models);
    }

    public void Encode(Encoder encoder, int n2) {
        int n3 = 1;
        int n4 = this.NumBitLevels;
        while (n4 != 0) {
            int n5 = n2 >>> --n4 & 1;
            encoder.Encode(this.Models, n3, n5);
            n3 = n3 << 1 | n5;
        }
    }

    public void ReverseEncode(Encoder encoder, int n2) {
        int n3 = 1;
        for (int i2 = 0; i2 < this.NumBitLevels; ++i2) {
            int n4 = n2 & 1;
            encoder.Encode(this.Models, n3, n4);
            n3 = n3 << 1 | n4;
            n2 >>= 1;
        }
    }

    public int GetPrice(int n2) {
        int n3 = 0;
        int n4 = 1;
        int n5 = this.NumBitLevels;
        while (n5 != 0) {
            int n6 = n2 >>> --n5 & 1;
            n3 += Encoder.GetPrice(this.Models[n4], n6);
            n4 = (n4 << 1) + n6;
        }
        return n3;
    }

    public int ReverseGetPrice(int n2) {
        int n3 = 0;
        int n4 = 1;
        for (int i2 = this.NumBitLevels; i2 != 0; --i2) {
            int n5 = n2 & 1;
            n2 >>>= 1;
            n3 += Encoder.GetPrice(this.Models[n4], n5);
            n4 = n4 << 1 | n5;
        }
        return n3;
    }

    public static int ReverseGetPrice(short[] sArray, int n2, int n3, int n4) {
        int n5 = 0;
        int n6 = 1;
        for (int i2 = n3; i2 != 0; --i2) {
            int n7 = n4 & 1;
            n4 >>>= 1;
            n5 += Encoder.GetPrice(sArray[n2 + n6], n7);
            n6 = n6 << 1 | n7;
        }
        return n5;
    }

    public static void ReverseEncode(short[] sArray, int n2, Encoder encoder, int n3, int n4) {
        int n5 = 1;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n6 = n4 & 1;
            encoder.Encode(sArray, n2 + n5, n6);
            n5 = n5 << 1 | n6;
            n4 >>= 1;
        }
    }
}

