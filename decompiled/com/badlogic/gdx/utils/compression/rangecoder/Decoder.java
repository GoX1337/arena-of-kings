/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression.rangecoder;

import java.io.InputStream;

public class Decoder {
    static final int kTopMask = -16777216;
    static final int kNumBitModelTotalBits = 11;
    static final int kBitModelTotal = 2048;
    static final int kNumMoveBits = 5;
    int Range;
    int Code;
    InputStream Stream;

    public final void SetStream(InputStream inputStream) {
        this.Stream = inputStream;
    }

    public final void ReleaseStream() {
        this.Stream = null;
    }

    public final void Init() {
        this.Code = 0;
        this.Range = -1;
        for (int i2 = 0; i2 < 5; ++i2) {
            this.Code = this.Code << 8 | this.Stream.read();
        }
    }

    public final int DecodeDirectBits(int n2) {
        int n3 = 0;
        for (int i2 = n2; i2 != 0; --i2) {
            this.Range >>>= 1;
            int n4 = this.Code - this.Range >>> 31;
            this.Code -= this.Range & n4 - 1;
            n3 = n3 << 1 | 1 - n4;
            if ((this.Range & 0xFF000000) != 0) continue;
            this.Code = this.Code << 8 | this.Stream.read();
            this.Range <<= 8;
        }
        return n3;
    }

    public int DecodeBit(short[] sArray, int n2) {
        short s2 = sArray[n2];
        int n3 = (this.Range >>> 11) * s2;
        if ((this.Code ^ Integer.MIN_VALUE) < (n3 ^ Integer.MIN_VALUE)) {
            this.Range = n3;
            sArray[n2] = (short)(s2 + (2048 - s2 >>> 5));
            if ((this.Range & 0xFF000000) == 0) {
                this.Code = this.Code << 8 | this.Stream.read();
                this.Range <<= 8;
            }
            return 0;
        }
        this.Range -= n3;
        this.Code -= n3;
        sArray[n2] = (short)(s2 - (s2 >>> 5));
        if ((this.Range & 0xFF000000) == 0) {
            this.Code = this.Code << 8 | this.Stream.read();
            this.Range <<= 8;
        }
        return 1;
    }

    public static void InitBitModels(short[] sArray) {
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            sArray[i2] = 1024;
        }
    }
}

