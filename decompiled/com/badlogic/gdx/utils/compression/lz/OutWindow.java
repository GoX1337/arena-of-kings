/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.compression.lz;

import java.io.OutputStream;

public class OutWindow {
    byte[] _buffer;
    int _pos;
    int _windowSize = 0;
    int _streamPos;
    OutputStream _stream;

    public void Create(int n2) {
        if (this._buffer == null || this._windowSize != n2) {
            this._buffer = new byte[n2];
        }
        this._windowSize = n2;
        this._pos = 0;
        this._streamPos = 0;
    }

    public void SetStream(OutputStream outputStream) {
        this.ReleaseStream();
        this._stream = outputStream;
    }

    public void ReleaseStream() {
        this.Flush();
        this._stream = null;
    }

    public void Init(boolean bl2) {
        if (!bl2) {
            this._streamPos = 0;
            this._pos = 0;
        }
    }

    public void Flush() {
        int n2 = this._pos - this._streamPos;
        if (n2 == 0) {
            return;
        }
        this._stream.write(this._buffer, this._streamPos, n2);
        if (this._pos >= this._windowSize) {
            this._pos = 0;
        }
        this._streamPos = this._pos;
    }

    public void CopyBlock(int n2, int n3) {
        int n4 = this._pos - n2 - 1;
        if (n4 < 0) {
            n4 += this._windowSize;
        }
        while (n3 != 0) {
            if (n4 >= this._windowSize) {
                n4 = 0;
            }
            this._buffer[this._pos++] = this._buffer[n4++];
            if (this._pos >= this._windowSize) {
                this.Flush();
            }
            --n3;
        }
    }

    public void PutByte(byte by2) {
        this._buffer[this._pos++] = by2;
        if (this._pos >= this._windowSize) {
            this.Flush();
        }
    }

    public byte GetByte(int n2) {
        int n3 = this._pos - n2 - 1;
        if (n3 < 0) {
            n3 += this._windowSize;
        }
        return this._buffer[n3];
    }
}

