/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression.lz;

import com.badlogic.gdx.utils.compression.lz.InWindow;

public class BinTree
extends InWindow {
    int _cyclicBufferPos;
    int _cyclicBufferSize = 0;
    int _matchMaxLen;
    int[] _son;
    int[] _hash;
    int _cutValue = 255;
    int _hashMask;
    int _hashSizeSum = 0;
    boolean HASH_ARRAY = true;
    static final int kHash2Size = 1024;
    static final int kHash3Size = 65536;
    static final int kBT2HashSize = 65536;
    static final int kStartMaxLen = 1;
    static final int kHash3Offset = 1024;
    static final int kEmptyHashValue = 0;
    static final int kMaxValForNormalize = 0x3FFFFFFF;
    int kNumHashDirectBytes = 0;
    int kMinMatchCheck = 4;
    int kFixHashSize = 66560;
    private static final int[] CrcTable = new int[256];

    public void SetType(int n2) {
        boolean bl2 = this.HASH_ARRAY = n2 > 2;
        if (this.HASH_ARRAY) {
            this.kNumHashDirectBytes = 0;
            this.kMinMatchCheck = 4;
            this.kFixHashSize = 66560;
        } else {
            this.kNumHashDirectBytes = 2;
            this.kMinMatchCheck = 3;
            this.kFixHashSize = 0;
        }
    }

    @Override
    public void Init() {
        super.Init();
        for (int i2 = 0; i2 < this._hashSizeSum; ++i2) {
            this._hash[i2] = 0;
        }
        this._cyclicBufferPos = 0;
        this.ReduceOffsets(-1);
    }

    @Override
    public void MovePos() {
        if (++this._cyclicBufferPos >= this._cyclicBufferSize) {
            this._cyclicBufferPos = 0;
        }
        super.MovePos();
        if (this._pos == 0x3FFFFFFF) {
            this.Normalize();
        }
    }

    public boolean Create(int n2, int n3, int n4, int n5) {
        if (n2 > 0x3FFFFEFF) {
            return false;
        }
        this._cutValue = 16 + (n4 >> 1);
        int n6 = (n2 + n3 + n4 + n5) / 2 + 256;
        super.Create(n2 + n3, n4 + n5, n6);
        this._matchMaxLen = n4;
        int n7 = n2 + 1;
        if (this._cyclicBufferSize != n7) {
            this._cyclicBufferSize = n7;
            this._son = new int[this._cyclicBufferSize * 2];
        }
        int n8 = 65536;
        if (this.HASH_ARRAY) {
            n8 = n2 - 1;
            n8 |= n8 >> 1;
            n8 |= n8 >> 2;
            n8 |= n8 >> 4;
            n8 |= n8 >> 8;
            n8 >>= 1;
            if ((n8 |= 0xFFFF) > 0x1000000) {
                n8 >>= 1;
            }
            this._hashMask = n8++;
            n8 += this.kFixHashSize;
        }
        if (n8 != this._hashSizeSum) {
            this._hashSizeSum = n8;
            this._hash = new int[this._hashSizeSum];
        }
        return true;
    }

    public int GetMatches(int[] nArray) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        if (this._pos + this._matchMaxLen <= this._streamPos) {
            n7 = this._matchMaxLen;
        } else {
            n7 = this._streamPos - this._pos;
            if (n7 < this.kMinMatchCheck) {
                this.MovePos();
                return 0;
            }
        }
        int n8 = 0;
        int n9 = this._pos > this._cyclicBufferSize ? this._pos - this._cyclicBufferSize : 0;
        int n10 = this._bufferOffset + this._pos;
        int n11 = 1;
        int n12 = 0;
        int n13 = 0;
        if (this.HASH_ARRAY) {
            n6 = CrcTable[this._bufferBase[n10] & 0xFF] ^ this._bufferBase[n10 + 1] & 0xFF;
            n12 = n6 & 0x3FF;
            n13 = (n6 ^= (this._bufferBase[n10 + 2] & 0xFF) << 8) & 0xFFFF;
            n5 = (n6 ^ CrcTable[this._bufferBase[n10 + 3] & 0xFF] << 5) & this._hashMask;
        } else {
            n5 = this._bufferBase[n10] & 0xFF ^ (this._bufferBase[n10 + 1] & 0xFF) << 8;
        }
        n6 = this._hash[this.kFixHashSize + n5];
        if (this.HASH_ARRAY) {
            n4 = this._hash[n12];
            n3 = this._hash[1024 + n13];
            this._hash[n12] = this._pos;
            this._hash[1024 + n13] = this._pos;
            if (n4 > n9 && this._bufferBase[this._bufferOffset + n4] == this._bufferBase[n10]) {
                int n14 = n8++;
                n11 = 2;
                nArray[n14] = 2;
                nArray[n8++] = this._pos - n4 - 1;
            }
            if (n3 > n9 && this._bufferBase[this._bufferOffset + n3] == this._bufferBase[n10]) {
                if (n3 == n4) {
                    n8 -= 2;
                }
                int n15 = n8++;
                n11 = 3;
                nArray[n15] = 3;
                nArray[n8++] = this._pos - n3 - 1;
                n4 = n3;
            }
            if (n8 != 0 && n4 == n6) {
                n8 -= 2;
                n11 = 1;
            }
        }
        this._hash[this.kFixHashSize + n5] = this._pos;
        n4 = (this._cyclicBufferPos << 1) + 1;
        n3 = this._cyclicBufferPos << 1;
        int n16 = n2 = this.kNumHashDirectBytes;
        if (this.kNumHashDirectBytes != 0 && n6 > n9 && this._bufferBase[this._bufferOffset + n6 + this.kNumHashDirectBytes] != this._bufferBase[n10 + this.kNumHashDirectBytes]) {
            nArray[n8++] = n11 = this.kNumHashDirectBytes;
            nArray[n8++] = this._pos - n6 - 1;
        }
        int n17 = this._cutValue;
        while (true) {
            if (n6 <= n9 || n17-- == 0) {
                this._son[n3] = 0;
                this._son[n4] = 0;
                break;
            }
            int n18 = this._pos - n6;
            int n19 = (n18 <= this._cyclicBufferPos ? this._cyclicBufferPos - n18 : this._cyclicBufferPos - n18 + this._cyclicBufferSize) << 1;
            int n20 = this._bufferOffset + n6;
            int n21 = Math.min(n16, n2);
            if (this._bufferBase[n20 + n21] == this._bufferBase[n10 + n21]) {
                while (++n21 != n7 && this._bufferBase[n20 + n21] == this._bufferBase[n10 + n21]) {
                }
                if (n11 < n21) {
                    nArray[n8++] = n11 = n21;
                    nArray[n8++] = n18 - 1;
                    if (n21 == n7) {
                        this._son[n3] = this._son[n19];
                        this._son[n4] = this._son[n19 + 1];
                        break;
                    }
                }
            }
            if ((this._bufferBase[n20 + n21] & 0xFF) < (this._bufferBase[n10 + n21] & 0xFF)) {
                this._son[n3] = n6;
                n3 = n19 + 1;
                n6 = this._son[n3];
                n2 = n21;
                continue;
            }
            this._son[n4] = n6;
            n4 = n19;
            n6 = this._son[n4];
            n16 = n21;
        }
        this.MovePos();
        return n8;
    }

    public void Skip(int n2) {
        do {
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            if (this._pos + this._matchMaxLen <= this._streamPos) {
                n8 = this._matchMaxLen;
            } else {
                n8 = this._streamPos - this._pos;
                if (n8 < this.kMinMatchCheck) {
                    this.MovePos();
                    continue;
                }
            }
            int n9 = this._pos > this._cyclicBufferSize ? this._pos - this._cyclicBufferSize : 0;
            int n10 = this._bufferOffset + this._pos;
            if (this.HASH_ARRAY) {
                n7 = CrcTable[this._bufferBase[n10] & 0xFF] ^ this._bufferBase[n10 + 1] & 0xFF;
                n6 = n7 & 0x3FF;
                this._hash[n6] = this._pos;
                n5 = (n7 ^= (this._bufferBase[n10 + 2] & 0xFF) << 8) & 0xFFFF;
                this._hash[1024 + n5] = this._pos;
                n4 = (n7 ^ CrcTable[this._bufferBase[n10 + 3] & 0xFF] << 5) & this._hashMask;
            } else {
                n4 = this._bufferBase[n10] & 0xFF ^ (this._bufferBase[n10 + 1] & 0xFF) << 8;
            }
            n7 = this._hash[this.kFixHashSize + n4];
            this._hash[this.kFixHashSize + n4] = this._pos;
            n6 = (this._cyclicBufferPos << 1) + 1;
            n5 = this._cyclicBufferPos << 1;
            int n11 = n3 = this.kNumHashDirectBytes;
            int n12 = this._cutValue;
            while (true) {
                if (n7 <= n9 || n12-- == 0) {
                    this._son[n5] = 0;
                    this._son[n6] = 0;
                    break;
                }
                int n13 = this._pos - n7;
                int n14 = (n13 <= this._cyclicBufferPos ? this._cyclicBufferPos - n13 : this._cyclicBufferPos - n13 + this._cyclicBufferSize) << 1;
                int n15 = this._bufferOffset + n7;
                int n16 = Math.min(n11, n3);
                if (this._bufferBase[n15 + n16] == this._bufferBase[n10 + n16]) {
                    while (++n16 != n8 && this._bufferBase[n15 + n16] == this._bufferBase[n10 + n16]) {
                    }
                    if (n16 == n8) {
                        this._son[n5] = this._son[n14];
                        this._son[n6] = this._son[n14 + 1];
                        break;
                    }
                }
                if ((this._bufferBase[n15 + n16] & 0xFF) < (this._bufferBase[n10 + n16] & 0xFF)) {
                    this._son[n5] = n7;
                    n5 = n14 + 1;
                    n7 = this._son[n5];
                    n3 = n16;
                    continue;
                }
                this._son[n6] = n7;
                n6 = n14;
                n7 = this._son[n6];
                n11 = n16;
            }
            this.MovePos();
        } while (--n2 != 0);
    }

    void NormalizeLinks(int[] nArray, int n2, int n3) {
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = nArray[i2];
            n4 = n4 <= n3 ? 0 : (n4 -= n3);
            nArray[i2] = n4;
        }
    }

    void Normalize() {
        int n2 = this._pos - this._cyclicBufferSize;
        this.NormalizeLinks(this._son, this._cyclicBufferSize * 2, n2);
        this.NormalizeLinks(this._hash, this._hashSizeSum, n2);
        this.ReduceOffsets(n2);
    }

    public void SetCutValue(int n2) {
        this._cutValue = n2;
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
            BinTree.CrcTable[i2] = n2;
        }
    }
}

