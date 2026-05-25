/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression;

public class CRC {
    public static int[] Table = new int[256];
    int _value = -1;

    public void Init() {
        this._value = -1;
    }

    public void Update(byte[] byArray, int n2, int n3) {
        for (int i2 = 0; i2 < n3; ++i2) {
            this._value = Table[(this._value ^ byArray[n2 + i2]) & 0xFF] ^ this._value >>> 8;
        }
    }

    public void Update(byte[] byArray) {
        int n2 = byArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this._value = Table[(this._value ^ byArray[i2]) & 0xFF] ^ this._value >>> 8;
        }
    }

    public void UpdateByte(int n2) {
        this._value = Table[(this._value ^ n2) & 0xFF] ^ this._value >>> 8;
    }

    public int GetDigest() {
        return ~this._value;
    }

    static {
        for (int i2 = 0; i2 < 256; ++i2) {
            int n2 = i2;
            for (int i3 = 0; i3 < 8; ++i3) {
                if ((n2 & 1) != 0) {
                    n2 = n2 >>> 1 ^ 0xEDB88320;
                    continue;
                }
                n2 >>>= 1;
            }
            CRC.Table[i2] = n2;
        }
    }
}

