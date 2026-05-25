/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.io.InputStream;

public class InputChunked
extends Input {
    private int chunkSize = -1;

    public InputChunked() {
    }

    public InputChunked(int n2) {
        super(n2);
    }

    public InputChunked(InputStream inputStream) {
        super(inputStream);
    }

    public InputChunked(InputStream inputStream, int n2) {
        super(inputStream, n2);
    }

    @Override
    public void setInputStream(InputStream inputStream) {
        super.setInputStream(inputStream);
        this.chunkSize = -1;
    }

    @Override
    public void setBuffer(byte[] byArray, int n2, int n3) {
        super.setBuffer(byArray, n2, n3);
        this.chunkSize = -1;
    }

    @Override
    public void reset() {
        super.reset();
        this.chunkSize = -1;
    }

    @Override
    protected int fill(byte[] byArray, int n2, int n3) {
        if (this.chunkSize == -1 ? !this.readChunkSize() : this.chunkSize == 0) {
            return -1;
        }
        int n4 = super.fill(byArray, n2, Math.min(this.chunkSize, n3));
        this.chunkSize -= n4;
        if (this.chunkSize == 0 && !this.readChunkSize()) {
            return -1;
        }
        return n4;
    }

    private boolean readChunkSize() {
        try {
            InputStream inputStream = this.getInputStream();
            int n2 = 0;
            for (int i2 = 0; i2 < 32; i2 += 7) {
                int n3 = inputStream.read();
                if (n3 == -1) {
                    return false;
                }
                n2 |= (n3 & 0x7F) << i2;
                if ((n3 & 0x80) != 0) continue;
                this.chunkSize = n2;
                if (Log.TRACE && this.chunkSize > 0) {
                    Log.trace("kryo", "Read chunk: " + this.chunkSize);
                }
                return true;
            }
        }
        catch (IOException iOException) {
            throw new KryoException("Unable to read chunk size.", iOException);
        }
        throw new KryoException("Unable to read chunk size: malformed integer");
    }

    public void nextChunk() {
        if (this.chunkSize == -1) {
            this.readChunkSize();
        }
        while (this.chunkSize > 0) {
            this.skip(this.chunkSize);
        }
        this.chunkSize = -1;
        if (Log.TRACE) {
            Log.trace("kryo", "Next chunk.");
        }
    }
}

