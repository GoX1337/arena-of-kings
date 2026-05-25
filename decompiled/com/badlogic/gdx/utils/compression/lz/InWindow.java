/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression.lz;

import java.io.InputStream;

public class InWindow {
    public byte[] _bufferBase;
    InputStream _stream;
    int _posLimit;
    boolean _streamEndWasReached;
    int _pointerToLastSafePosition;
    public int _bufferOffset;
    public int _blockSize;
    public int _pos;
    int _keepSizeBefore;
    int _keepSizeAfter;
    public int _streamPos;

    public void MoveBlock() {
        int n2 = this._bufferOffset + this._pos - this._keepSizeBefore;
        if (n2 > 0) {
            --n2;
        }
        int n3 = this._bufferOffset + this._streamPos - n2;
        for (int i2 = 0; i2 < n3; ++i2) {
            this._bufferBase[i2] = this._bufferBase[n2 + i2];
        }
        this._bufferOffset -= n2;
    }

    public void ReadBlock() {
        if (this._streamEndWasReached) {
            return;
        }
        int n2;
        while ((n2 = 0 - this._bufferOffset + this._blockSize - this._streamPos) != 0) {
            int n3 = this._stream.read(this._bufferBase, this._bufferOffset + this._streamPos, n2);
            if (n3 == -1) {
                this._posLimit = this._streamPos;
                int n4 = this._bufferOffset + this._posLimit;
                if (n4 > this._pointerToLastSafePosition) {
                    this._posLimit = this._pointerToLastSafePosition - this._bufferOffset;
                }
                this._streamEndWasReached = true;
                return;
            }
            this._streamPos += n3;
            if (this._streamPos < this._pos + this._keepSizeAfter) continue;
            this._posLimit = this._streamPos - this._keepSizeAfter;
        }
        return;
    }

    void Free() {
        this._bufferBase = null;
    }

    public void Create(int n2, int n3, int n4) {
        this._keepSizeBefore = n2;
        this._keepSizeAfter = n3;
        int n5 = n2 + n3 + n4;
        if (this._bufferBase == null || this._blockSize != n5) {
            this.Free();
            this._blockSize = n5;
            this._bufferBase = new byte[this._blockSize];
        }
        this._pointerToLastSafePosition = this._blockSize - n3;
    }

    public void SetStream(InputStream inputStream) {
        this._stream = inputStream;
    }

    public void ReleaseStream() {
        this._stream = null;
    }

    public void Init() {
        this._bufferOffset = 0;
        this._pos = 0;
        this._streamPos = 0;
        this._streamEndWasReached = false;
        this.ReadBlock();
    }

    public void MovePos() {
        ++this._pos;
        if (this._pos > this._posLimit) {
            int n2 = this._bufferOffset + this._pos;
            if (n2 > this._pointerToLastSafePosition) {
                this.MoveBlock();
            }
            this.ReadBlock();
        }
    }

    public byte GetIndexByte(int n2) {
        return this._bufferBase[this._bufferOffset + this._pos + n2];
    }

    public int GetMatchLen(int n2, int n3, int n4) {
        int n5;
        if (this._streamEndWasReached && this._pos + n2 + n4 > this._streamPos) {
            n4 = this._streamPos - (this._pos + n2);
        }
        ++n3;
        int n6 = this._bufferOffset + this._pos + n2;
        for (n5 = 0; n5 < n4 && this._bufferBase[n6 + n5] == this._bufferBase[n6 + n5 - n3]; ++n5) {
        }
        return n5;
    }

    public int GetNumAvailableBytes() {
        return this._streamPos - this._pos;
    }

    public void ReduceOffsets(int n2) {
        this._bufferOffset += n2;
        this._posLimit -= n2;
        this._pos -= n2;
        this._streamPos -= n2;
    }
}

