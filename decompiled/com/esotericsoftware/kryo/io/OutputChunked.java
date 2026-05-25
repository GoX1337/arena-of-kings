/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.io.OutputStream;

public class OutputChunked
extends Output {
    public OutputChunked() {
    }

    public OutputChunked(int n2) {
        super(n2);
    }

    public OutputChunked(OutputStream outputStream) {
        super(outputStream);
    }

    public OutputChunked(OutputStream outputStream, int n2) {
        super(outputStream, n2);
    }

    @Override
    public void flush() {
        if (this.position() > 0) {
            try {
                this.writeChunkSize();
                super.flush();
            }
            catch (IOException iOException) {
                throw new KryoException(iOException);
            }
        }
        super.flush();
    }

    private void writeChunkSize() {
        int n2 = this.position();
        if (Log.TRACE) {
            Log.trace("kryo", "Write chunk: " + n2 + Util.pos(n2));
        }
        OutputStream outputStream = this.getOutputStream();
        if ((n2 & 0xFFFFFF80) == 0) {
            outputStream.write(n2);
            return;
        }
        outputStream.write(n2 & 0x7F | 0x80);
        if (((n2 >>>= 7) & 0xFFFFFF80) == 0) {
            outputStream.write(n2);
            return;
        }
        outputStream.write(n2 & 0x7F | 0x80);
        if (((n2 >>>= 7) & 0xFFFFFF80) == 0) {
            outputStream.write(n2);
            return;
        }
        outputStream.write(n2 & 0x7F | 0x80);
        if (((n2 >>>= 7) & 0xFFFFFF80) == 0) {
            outputStream.write(n2);
            return;
        }
        outputStream.write(n2 & 0x7F | 0x80);
        outputStream.write(n2 >>>= 7);
    }

    public void endChunk() {
        this.flush();
        if (Log.TRACE) {
            Log.trace("kryo", "End chunk.");
        }
        try {
            this.getOutputStream().write(0);
        }
        catch (IOException iOException) {
            throw new KryoException(iOException);
        }
    }
}

