/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression.rangecoder;

import java.io.OutputStream;

public class Encoder {
    static final int kTopMask = -16777216;
    static final int kNumBitModelTotalBits = 11;
    static final int kBitModelTotal = 2048;
    static final int kNumMoveBits = 5;
    OutputStream Stream;
    long Low;
    int Range;
    int _cacheSize;
    int _cache;
    long _position;
    static final int kNumMoveReducingBits = 2;
    public static final int kNumBitPriceShiftBits = 6;
    private static int[] ProbPrices = new int[512];

    public void SetStream(OutputStream outputStream) {
        this.Stream = outputStream;
    }

    public void ReleaseStream() {
        this.Stream = null;
    }

    public void Init() {
        this._position = 0L;
        this.Low = 0L;
        this.Range = -1;
        this._cacheSize = 1;
        this._cache = 0;
    }

    public void FlushData() {
        for (int i2 = 0; i2 < 5; ++i2) {
            this.ShiftLow();
        }
    }

    public void FlushStream() {
        this.Stream.flush();
    }

    public void ShiftLow() {
        int n2 = (int)(this.Low >>> 32);
        if (n2 != 0 || this.Low < 0xFF000000L) {
            this._position += (long)this._cacheSize;
            int n3 = this._cache;
            do {
                this.Stream.write(n3 + n2);
                n3 = 255;
            } while (--this._cacheSize != 0);
            this._cache = (int)this.Low >>> 24;
        }
        ++this._cacheSize;
        this.Low = (this.Low & 0xFFFFFFL) << 8;
    }

    public void EncodeDirectBits(int n2, int n3) {
        for (int i2 = n3 - 1; i2 >= 0; --i2) {
            this.Range >>>= 1;
            if ((n2 >>> i2 & 1) == 1) {
                this.Low += (long)this.Range;
            }
            if ((this.Range & 0xFF000000) != 0) continue;
            this.Range <<= 8;
            this.ShiftLow();
        }
    }

    public long GetProcessedSizeAdd() {
        return (long)this._cacheSize + this._position + 4L;
    }

    public static void InitBitModels(short[] sArray) {
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            sArray[i2] = 1024;
        }
    }

    public void Encode(short[] sArray, int n2, int n3) {
        short s2 = sArray[n2];
        int n4 = (this.Range >>> 11) * s2;
        if (n3 == 0) {
            this.Range = n4;
            sArray[n2] = (short)(s2 + (2048 - s2 >>> 5));
        } else {
            this.Low += (long)n4 & 0xFFFFFFFFL;
            this.Range -= n4;
            sArray[n2] = (short)(s2 - (s2 >>> 5));
        }
        if ((this.Range & 0xFF000000) == 0) {
            this.Range <<= 8;
            this.ShiftLow();
        }
    }

    public static int GetPrice(int n2, int n3) {
        return ProbPrices[((n2 - n3 ^ -n3) & 0x7FF) >>> 2];
    }

    public static int GetPrice0(int n2) {
        return ProbPrices[n2 >>> 2];
    }

    public static int GetPrice1(int n2) {
        return ProbPrices[2048 - n2 >>> 2];
    }

    static {
        int n2 = 9;
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            int n3 = 1 << n2 - i2 - 1;
            int n4 = 1 << n2 - i2;
            for (int i3 = n3; i3 < n4; ++i3) {
                Encoder.ProbPrices[i3] = (i2 << 6) + (n4 - i3 << 6 >>> n2 - i2 - 1);
            }
        }
    }
}

