/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet.util;

import com.esotericsoftware.kryonet.KryoNetException;
import com.esotericsoftware.kryonet.util.TcpIdleSender;
import java.io.IOException;
import java.io.InputStream;

public abstract class InputStreamSender
extends TcpIdleSender {
    private final InputStream input;
    private final byte[] chunk;

    public InputStreamSender(InputStream inputStream, int n2) {
        this.input = inputStream;
        this.chunk = new byte[n2];
    }

    @Override
    protected final Object next() {
        try {
            int n2;
            for (int i2 = 0; i2 < this.chunk.length; i2 += n2) {
                n2 = this.input.read(this.chunk, i2, this.chunk.length - i2);
                if (n2 >= 0) continue;
                if (i2 == 0) {
                    return null;
                }
                byte[] byArray = new byte[i2];
                System.arraycopy(this.chunk, 0, byArray, 0, i2);
                return this.next(byArray);
            }
        }
        catch (IOException iOException) {
            throw new KryoNetException(iOException);
        }
        return this.next(this.chunk);
    }

    protected abstract Object next(byte[] var1);
}

