/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.Pool;
import java.io.IOException;
import java.io.OutputStream;

public class Output
extends OutputStream
implements Pool.Poolable,
AutoCloseable {
    protected int maxCapacity;
    protected long total;
    protected int position;
    protected int capacity;
    protected byte[] buffer;
    protected OutputStream outputStream;
    protected boolean varEncoding = true;

    public Output() {
    }

    public Output(int n2) {
        this(n2, n2);
    }

    public Output(int n2, int n3) {
        if (n2 > n3 && n3 != -1) {
            throw new IllegalArgumentException("bufferSize: " + n2 + " cannot be greater than maxBufferSize: " + n3);
        }
        if (n3 < -1) {
            throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + n3);
        }
        this.capacity = n2;
        this.maxCapacity = n3 == -1 ? 0x7FFFFFF7 : n3;
        this.buffer = new byte[n2];
    }

    public Output(byte[] byArray) {
        this(byArray, byArray.length);
    }

    public Output(byte[] byArray, int n2) {
        if (byArray == null) {
            throw new IllegalArgumentException("buffer cannot be null.");
        }
        this.setBuffer(byArray, n2);
    }

    public Output(OutputStream outputStream) {
        this(4096, 4096);
        if (outputStream == null) {
            throw new IllegalArgumentException("outputStream cannot be null.");
        }
        this.outputStream = outputStream;
    }

    public Output(OutputStream outputStream, int n2) {
        this(n2, n2);
        if (outputStream == null) {
            throw new IllegalArgumentException("outputStream cannot be null.");
        }
        this.outputStream = outputStream;
    }

    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.reset();
    }

    public void setBuffer(byte[] byArray) {
        this.setBuffer(byArray, byArray.length);
    }

    public void setBuffer(byte[] byArray, int n2) {
        if (byArray == null) {
            throw new IllegalArgumentException("buffer cannot be null.");
        }
        if (byArray.length > n2 && n2 != -1) {
            throw new IllegalArgumentException("buffer has length: " + byArray.length + " cannot be greater than maxBufferSize: " + n2);
        }
        if (n2 < -1) {
            throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + n2);
        }
        this.buffer = byArray;
        this.maxCapacity = n2 == -1 ? 0x7FFFFFF7 : n2;
        this.capacity = byArray.length;
        this.position = 0;
        this.total = 0L;
        this.outputStream = null;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public byte[] toBytes() {
        byte[] byArray = new byte[this.position];
        System.arraycopy(this.buffer, 0, byArray, 0, this.position);
        return byArray;
    }

    public boolean getVariableLengthEncoding() {
        return this.varEncoding;
    }

    public void setVariableLengthEncoding(boolean bl2) {
        this.varEncoding = bl2;
    }

    public int position() {
        return this.position;
    }

    public void setPosition(int n2) {
        this.position = n2;
    }

    public long total() {
        return this.total + (long)this.position;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    @Override
    public void reset() {
        this.position = 0;
        this.total = 0L;
    }

    protected boolean require(int n2) {
        if (this.capacity - this.position >= n2) {
            return false;
        }
        this.flush();
        if (this.capacity - this.position >= n2) {
            return true;
        }
        if (n2 > this.maxCapacity - this.position) {
            if (n2 > this.maxCapacity) {
                throw new KryoException("Buffer overflow. Max capacity: " + this.maxCapacity + ", required: " + n2);
            }
            throw new KryoException("Buffer overflow. Available: " + (this.maxCapacity - this.position) + ", required: " + n2);
        }
        if (this.capacity == 0) {
            this.capacity = 16;
        }
        do {
            this.capacity = Math.min(this.capacity * 2, this.maxCapacity);
        } while (this.capacity - this.position < n2);
        byte[] byArray = new byte[this.capacity];
        System.arraycopy(this.buffer, 0, byArray, 0, this.position);
        this.buffer = byArray;
        return true;
    }

    @Override
    public void flush() {
        if (this.outputStream == null) {
            return;
        }
        try {
            this.outputStream.write(this.buffer, 0, this.position);
            this.outputStream.flush();
        }
        catch (IOException iOException) {
            throw new KryoException(iOException);
        }
        this.total += (long)this.position;
        this.position = 0;
    }

    @Override
    public void close() {
        this.flush();
        if (this.outputStream != null) {
            try {
                this.outputStream.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    @Override
    public void write(int n2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        this.buffer[this.position++] = (byte)n2;
    }

    @Override
    public void write(byte[] byArray) {
        if (byArray == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        this.writeBytes(byArray, 0, byArray.length);
    }

    @Override
    public void write(byte[] byArray, int n2, int n3) {
        this.writeBytes(byArray, n2, n3);
    }

    public void writeByte(byte by2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        this.buffer[this.position++] = by2;
    }

    public void writeByte(int n2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        this.buffer[this.position++] = (byte)n2;
    }

    public void writeBytes(byte[] byArray) {
        if (byArray == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        this.writeBytes(byArray, 0, byArray.length);
    }

    public void writeBytes(byte[] byArray, int n2, int n3) {
        if (byArray == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        int n4 = Math.min(this.capacity - this.position, n3);
        while (true) {
            System.arraycopy(byArray, n2, this.buffer, this.position, n4);
            this.position += n4;
            if ((n3 -= n4) == 0) {
                return;
            }
            n2 += n4;
            n4 = Math.min(Math.max(this.capacity, 1), n3);
            this.require(n4);
        }
    }

    public void writeInt(int n2) {
        this.require(4);
        byte[] byArray = this.buffer;
        int n3 = this.position;
        this.position = n3 + 4;
        byArray[n3] = (byte)n2;
        byArray[n3 + 1] = (byte)(n2 >> 8);
        byArray[n3 + 2] = (byte)(n2 >> 16);
        byArray[n3 + 3] = (byte)(n2 >> 24);
    }

    public int writeInt(int n2, boolean bl2) {
        if (this.varEncoding) {
            return this.writeVarInt(n2, bl2);
        }
        this.writeInt(n2);
        return 4;
    }

    public int writeVarInt(int n2, boolean bl2) {
        if (!bl2) {
            n2 = n2 << 1 ^ n2 >> 31;
        }
        if (n2 >>> 7 == 0) {
            if (this.position == this.capacity) {
                this.require(1);
            }
            this.buffer[this.position++] = (byte)n2;
            return 1;
        }
        if (n2 >>> 14 == 0) {
            this.require(2);
            int n3 = this.position;
            this.position = n3 + 2;
            this.buffer[n3] = (byte)(n2 & 0x7F | 0x80);
            this.buffer[n3 + 1] = (byte)(n2 >>> 7);
            return 2;
        }
        if (n2 >>> 21 == 0) {
            this.require(3);
            int n4 = this.position;
            this.position = n4 + 3;
            byte[] byArray = this.buffer;
            byArray[n4] = (byte)(n2 & 0x7F | 0x80);
            byArray[n4 + 1] = (byte)(n2 >>> 7 | 0x80);
            byArray[n4 + 2] = (byte)(n2 >>> 14);
            return 3;
        }
        if (n2 >>> 28 == 0) {
            this.require(4);
            int n5 = this.position;
            this.position = n5 + 4;
            byte[] byArray = this.buffer;
            byArray[n5] = (byte)(n2 & 0x7F | 0x80);
            byArray[n5 + 1] = (byte)(n2 >>> 7 | 0x80);
            byArray[n5 + 2] = (byte)(n2 >>> 14 | 0x80);
            byArray[n5 + 3] = (byte)(n2 >>> 21);
            return 4;
        }
        this.require(5);
        int n6 = this.position;
        this.position = n6 + 5;
        byte[] byArray = this.buffer;
        byArray[n6] = (byte)(n2 & 0x7F | 0x80);
        byArray[n6 + 1] = (byte)(n2 >>> 7 | 0x80);
        byArray[n6 + 2] = (byte)(n2 >>> 14 | 0x80);
        byArray[n6 + 3] = (byte)(n2 >>> 21 | 0x80);
        byArray[n6 + 4] = (byte)(n2 >>> 28);
        return 5;
    }

    public int writeVarIntFlag(boolean bl2, int n2, boolean bl3) {
        if (!bl3) {
            n2 = n2 << 1 ^ n2 >> 31;
        }
        int n3 = n2 & 0x3F | (bl2 ? 128 : 0);
        if (n2 >>> 6 == 0) {
            if (this.position == this.capacity) {
                this.require(1);
            }
            this.buffer[this.position++] = (byte)n3;
            return 1;
        }
        if (n2 >>> 13 == 0) {
            this.require(2);
            int n4 = this.position;
            this.position = n4 + 2;
            this.buffer[n4] = (byte)(n3 | 0x40);
            this.buffer[n4 + 1] = (byte)(n2 >>> 6);
            return 2;
        }
        if (n2 >>> 20 == 0) {
            this.require(3);
            byte[] byArray = this.buffer;
            int n5 = this.position;
            this.position = n5 + 3;
            byArray[n5] = (byte)(n3 | 0x40);
            byArray[n5 + 1] = (byte)(n2 >>> 6 | 0x80);
            byArray[n5 + 2] = (byte)(n2 >>> 13);
            return 3;
        }
        if (n2 >>> 27 == 0) {
            this.require(4);
            byte[] byArray = this.buffer;
            int n6 = this.position;
            this.position = n6 + 4;
            byArray[n6] = (byte)(n3 | 0x40);
            byArray[n6 + 1] = (byte)(n2 >>> 6 | 0x80);
            byArray[n6 + 2] = (byte)(n2 >>> 13 | 0x80);
            byArray[n6 + 3] = (byte)(n2 >>> 20);
            return 4;
        }
        this.require(5);
        byte[] byArray = this.buffer;
        int n7 = this.position;
        this.position = n7 + 5;
        byArray[n7] = (byte)(n3 | 0x40);
        byArray[n7 + 1] = (byte)(n2 >>> 6 | 0x80);
        byArray[n7 + 2] = (byte)(n2 >>> 13 | 0x80);
        byArray[n7 + 3] = (byte)(n2 >>> 20 | 0x80);
        byArray[n7 + 4] = (byte)(n2 >>> 27);
        return 5;
    }

    public int intLength(int n2, boolean bl2) {
        if (this.varEncoding) {
            return Output.varIntLength(n2, bl2);
        }
        return 4;
    }

    public void writeLong(long l2) {
        this.require(8);
        byte[] byArray = this.buffer;
        int n2 = this.position;
        this.position = n2 + 8;
        byArray[n2] = (byte)l2;
        byArray[n2 + 1] = (byte)(l2 >>> 8);
        byArray[n2 + 2] = (byte)(l2 >>> 16);
        byArray[n2 + 3] = (byte)(l2 >>> 24);
        byArray[n2 + 4] = (byte)(l2 >>> 32);
        byArray[n2 + 5] = (byte)(l2 >>> 40);
        byArray[n2 + 6] = (byte)(l2 >>> 48);
        byArray[n2 + 7] = (byte)(l2 >>> 56);
    }

    public int writeLong(long l2, boolean bl2) {
        if (this.varEncoding) {
            return this.writeVarLong(l2, bl2);
        }
        this.writeLong(l2);
        return 8;
    }

    public int writeVarLong(long l2, boolean bl2) {
        if (!bl2) {
            l2 = l2 << 1 ^ l2 >> 63;
        }
        if (l2 >>> 7 == 0L) {
            if (this.position == this.capacity) {
                this.require(1);
            }
            this.buffer[this.position++] = (byte)l2;
            return 1;
        }
        if (l2 >>> 14 == 0L) {
            this.require(2);
            int n2 = this.position;
            this.position = n2 + 2;
            this.buffer[n2] = (byte)(l2 & 0x7FL | 0x80L);
            this.buffer[n2 + 1] = (byte)(l2 >>> 7);
            return 2;
        }
        if (l2 >>> 21 == 0L) {
            this.require(3);
            int n3 = this.position;
            this.position = n3 + 3;
            byte[] byArray = this.buffer;
            byArray[n3] = (byte)(l2 & 0x7FL | 0x80L);
            byArray[n3 + 1] = (byte)(l2 >>> 7 | 0x80L);
            byArray[n3 + 2] = (byte)(l2 >>> 14);
            return 3;
        }
        if (l2 >>> 28 == 0L) {
            this.require(4);
            int n4 = this.position;
            this.position = n4 + 4;
            byte[] byArray = this.buffer;
            byArray[n4] = (byte)(l2 & 0x7FL | 0x80L);
            byArray[n4 + 1] = (byte)(l2 >>> 7 | 0x80L);
            byArray[n4 + 2] = (byte)(l2 >>> 14 | 0x80L);
            byArray[n4 + 3] = (byte)(l2 >>> 21);
            return 4;
        }
        if (l2 >>> 35 == 0L) {
            this.require(5);
            int n5 = this.position;
            this.position = n5 + 5;
            byte[] byArray = this.buffer;
            byArray[n5] = (byte)(l2 & 0x7FL | 0x80L);
            byArray[n5 + 1] = (byte)(l2 >>> 7 | 0x80L);
            byArray[n5 + 2] = (byte)(l2 >>> 14 | 0x80L);
            byArray[n5 + 3] = (byte)(l2 >>> 21 | 0x80L);
            byArray[n5 + 4] = (byte)(l2 >>> 28);
            return 5;
        }
        if (l2 >>> 42 == 0L) {
            this.require(6);
            int n6 = this.position;
            this.position = n6 + 6;
            byte[] byArray = this.buffer;
            byArray[n6] = (byte)(l2 & 0x7FL | 0x80L);
            byArray[n6 + 1] = (byte)(l2 >>> 7 | 0x80L);
            byArray[n6 + 2] = (byte)(l2 >>> 14 | 0x80L);
            byArray[n6 + 3] = (byte)(l2 >>> 21 | 0x80L);
            byArray[n6 + 4] = (byte)(l2 >>> 28 | 0x80L);
            byArray[n6 + 5] = (byte)(l2 >>> 35);
            return 6;
        }
        if (l2 >>> 49 == 0L) {
            this.require(7);
            int n7 = this.position;
            this.position = n7 + 7;
            byte[] byArray = this.buffer;
            byArray[n7] = (byte)(l2 & 0x7FL | 0x80L);
            byArray[n7 + 1] = (byte)(l2 >>> 7 | 0x80L);
            byArray[n7 + 2] = (byte)(l2 >>> 14 | 0x80L);
            byArray[n7 + 3] = (byte)(l2 >>> 21 | 0x80L);
            byArray[n7 + 4] = (byte)(l2 >>> 28 | 0x80L);
            byArray[n7 + 5] = (byte)(l2 >>> 35 | 0x80L);
            byArray[n7 + 6] = (byte)(l2 >>> 42);
            return 7;
        }
        if (l2 >>> 56 == 0L) {
            this.require(8);
            int n8 = this.position;
            this.position = n8 + 8;
            byte[] byArray = this.buffer;
            byArray[n8] = (byte)(l2 & 0x7FL | 0x80L);
            byArray[n8 + 1] = (byte)(l2 >>> 7 | 0x80L);
            byArray[n8 + 2] = (byte)(l2 >>> 14 | 0x80L);
            byArray[n8 + 3] = (byte)(l2 >>> 21 | 0x80L);
            byArray[n8 + 4] = (byte)(l2 >>> 28 | 0x80L);
            byArray[n8 + 5] = (byte)(l2 >>> 35 | 0x80L);
            byArray[n8 + 6] = (byte)(l2 >>> 42 | 0x80L);
            byArray[n8 + 7] = (byte)(l2 >>> 49);
            return 8;
        }
        this.require(9);
        int n9 = this.position;
        this.position = n9 + 9;
        byte[] byArray = this.buffer;
        byArray[n9] = (byte)(l2 & 0x7FL | 0x80L);
        byArray[n9 + 1] = (byte)(l2 >>> 7 | 0x80L);
        byArray[n9 + 2] = (byte)(l2 >>> 14 | 0x80L);
        byArray[n9 + 3] = (byte)(l2 >>> 21 | 0x80L);
        byArray[n9 + 4] = (byte)(l2 >>> 28 | 0x80L);
        byArray[n9 + 5] = (byte)(l2 >>> 35 | 0x80L);
        byArray[n9 + 6] = (byte)(l2 >>> 42 | 0x80L);
        byArray[n9 + 7] = (byte)(l2 >>> 49 | 0x80L);
        byArray[n9 + 8] = (byte)(l2 >>> 56);
        return 9;
    }

    public int longLength(int n2, boolean bl2) {
        if (this.varEncoding) {
            return Output.varLongLength(n2, bl2);
        }
        return 8;
    }

    public void writeFloat(float f2) {
        this.require(4);
        byte[] byArray = this.buffer;
        int n2 = this.position;
        this.position = n2 + 4;
        int n3 = Float.floatToIntBits(f2);
        byArray[n2] = (byte)n3;
        byArray[n2 + 1] = (byte)(n3 >> 8);
        byArray[n2 + 2] = (byte)(n3 >> 16);
        byArray[n2 + 3] = (byte)(n3 >> 24);
    }

    public int writeVarFloat(float f2, float f3, boolean bl2) {
        return this.writeVarInt((int)(f2 * f3), bl2);
    }

    public void writeDouble(double d2) {
        this.require(8);
        byte[] byArray = this.buffer;
        int n2 = this.position;
        this.position = n2 + 8;
        long l2 = Double.doubleToLongBits(d2);
        byArray[n2] = (byte)l2;
        byArray[n2 + 1] = (byte)(l2 >>> 8);
        byArray[n2 + 2] = (byte)(l2 >>> 16);
        byArray[n2 + 3] = (byte)(l2 >>> 24);
        byArray[n2 + 4] = (byte)(l2 >>> 32);
        byArray[n2 + 5] = (byte)(l2 >>> 40);
        byArray[n2 + 6] = (byte)(l2 >>> 48);
        byArray[n2 + 7] = (byte)(l2 >>> 56);
    }

    public int writeVarDouble(double d2, double d3, boolean bl2) {
        return this.writeVarLong((long)(d2 * d3), bl2);
    }

    public void writeShort(int n2) {
        this.require(2);
        int n3 = this.position;
        this.position = n3 + 2;
        this.buffer[n3] = (byte)n2;
        this.buffer[n3 + 1] = (byte)(n2 >>> 8);
    }

    public void writeChar(char c2) {
        this.require(2);
        int n2 = this.position;
        this.position = n2 + 2;
        this.buffer[n2] = (byte)c2;
        this.buffer[n2 + 1] = (byte)(c2 >>> 8);
    }

    public void writeBoolean(boolean bl2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        this.buffer[this.position++] = bl2 ? (byte)1 : 0;
    }

    public void writeString(String string) {
        int n2;
        int n3;
        block10: {
            if (string == null) {
                this.writeByte(128);
                return;
            }
            n3 = string.length();
            if (n3 == 0) {
                this.writeByte(129);
                return;
            }
            if (n3 > 1 && n3 <= 32) {
                for (n2 = 0; n2 < n3; ++n2) {
                    if (string.charAt(n2) <= '\u007f') {
                        continue;
                    }
                    break block10;
                }
                if (this.capacity - this.position < n3) {
                    this.writeAscii_slow(string, n3);
                } else {
                    string.getBytes(0, n3, this.buffer, this.position);
                    this.position += n3;
                }
                int n4 = this.position - 1;
                this.buffer[n4] = (byte)(this.buffer[n4] | 0x80);
                return;
            }
        }
        this.writeVarIntFlag(true, n3 + 1, true);
        n2 = 0;
        if (this.capacity - this.position >= n3) {
            char c2;
            byte[] byArray = this.buffer;
            int n5 = this.position;
            while ((c2 = string.charAt(n2)) <= '\u007f') {
                byArray[n5++] = (byte)c2;
                if (++n2 != n3) continue;
                this.position = n5;
                return;
            }
            this.position = n5;
        }
        if (n2 < n3) {
            this.writeUtf8_slow(string, n3, n2);
        }
    }

    public void writeAscii(String string) {
        if (string == null) {
            this.writeByte(128);
            return;
        }
        int n2 = string.length();
        switch (n2) {
            case 0: {
                this.writeByte(129);
                return;
            }
            case 1: {
                this.require(2);
                this.buffer[this.position++] = -126;
                this.buffer[this.position++] = (byte)string.charAt(0);
                return;
            }
        }
        if (this.capacity - this.position < n2) {
            this.writeAscii_slow(string, n2);
        } else {
            string.getBytes(0, n2, this.buffer, this.position);
            this.position += n2;
        }
        int n3 = this.position - 1;
        this.buffer[n3] = (byte)(this.buffer[n3] | 0x80);
    }

    private void writeUtf8_slow(String string, int n2, int n3) {
        while (n3 < n2) {
            char c2;
            if (this.position == this.capacity) {
                this.require(Math.min(this.capacity, n2 - n3));
            }
            if ((c2 = string.charAt(n3)) <= '\u007f') {
                this.buffer[this.position++] = (byte)c2;
            } else if (c2 > '\u07ff') {
                this.buffer[this.position++] = (byte)(0xE0 | c2 >> 12 & 0xF);
                this.require(2);
                this.buffer[this.position++] = (byte)(0x80 | c2 >> 6 & 0x3F);
                this.buffer[this.position++] = (byte)(0x80 | c2 & 0x3F);
            } else {
                this.buffer[this.position++] = (byte)(0xC0 | c2 >> 6 & 0x1F);
                if (this.position == this.capacity) {
                    this.require(1);
                }
                this.buffer[this.position++] = (byte)(0x80 | c2 & 0x3F);
            }
            ++n3;
        }
    }

    private void writeAscii_slow(String string, int n2) {
        if (n2 == 0) {
            return;
        }
        if (this.position == this.capacity) {
            this.require(1);
        }
        int n3 = 0;
        byte[] byArray = this.buffer;
        int n4 = Math.min(n2, this.capacity - this.position);
        while (n3 < n2) {
            string.getBytes(n3, n3 + n4, byArray, this.position);
            this.position += n4;
            if (!this.require(n4 = Math.min(n2 - (n3 += n4), this.capacity))) continue;
            byArray = this.buffer;
        }
    }

    public void writeInts(int[] nArray, int n2, int n3) {
        if (this.capacity >= n3 << 2) {
            this.require(n3 << 2);
            byte[] byArray = this.buffer;
            int n4 = this.position;
            int n5 = n2 + n3;
            while (n2 < n5) {
                int n6 = nArray[n2];
                byArray[n4] = (byte)n6;
                byArray[n4 + 1] = (byte)(n6 >> 8);
                byArray[n4 + 2] = (byte)(n6 >> 16);
                byArray[n4 + 3] = (byte)(n6 >> 24);
                ++n2;
                n4 += 4;
            }
            this.position = n4;
        } else {
            int n7 = n2 + n3;
            while (n2 < n7) {
                this.writeInt(nArray[n2]);
                ++n2;
            }
        }
    }

    public void writeInts(int[] nArray, int n2, int n3, boolean bl2) {
        if (this.varEncoding) {
            int n4 = n2 + n3;
            while (n2 < n4) {
                this.writeVarInt(nArray[n2], bl2);
                ++n2;
            }
        } else {
            this.writeInts(nArray, n2, n3);
        }
    }

    public void writeLongs(long[] lArray, int n2, int n3) {
        if (this.capacity >= n3 << 3) {
            this.require(n3 << 3);
            byte[] byArray = this.buffer;
            int n4 = this.position;
            int n5 = n2 + n3;
            while (n2 < n5) {
                long l2 = lArray[n2];
                byArray[n4] = (byte)l2;
                byArray[n4 + 1] = (byte)(l2 >>> 8);
                byArray[n4 + 2] = (byte)(l2 >>> 16);
                byArray[n4 + 3] = (byte)(l2 >>> 24);
                byArray[n4 + 4] = (byte)(l2 >>> 32);
                byArray[n4 + 5] = (byte)(l2 >>> 40);
                byArray[n4 + 6] = (byte)(l2 >>> 48);
                byArray[n4 + 7] = (byte)(l2 >>> 56);
                ++n2;
                n4 += 8;
            }
            this.position = n4;
        } else {
            int n6 = n2 + n3;
            while (n2 < n6) {
                this.writeLong(lArray[n2]);
                ++n2;
            }
        }
    }

    public void writeLongs(long[] lArray, int n2, int n3, boolean bl2) {
        if (this.varEncoding) {
            int n4 = n2 + n3;
            while (n2 < n4) {
                this.writeVarLong(lArray[n2], bl2);
                ++n2;
            }
        } else {
            this.writeLongs(lArray, n2, n3);
        }
    }

    public void writeFloats(float[] fArray, int n2, int n3) {
        if (this.capacity >= n3 << 2) {
            this.require(n3 << 2);
            byte[] byArray = this.buffer;
            int n4 = this.position;
            int n5 = n2 + n3;
            while (n2 < n5) {
                int n6 = Float.floatToIntBits(fArray[n2]);
                byArray[n4] = (byte)n6;
                byArray[n4 + 1] = (byte)(n6 >> 8);
                byArray[n4 + 2] = (byte)(n6 >> 16);
                byArray[n4 + 3] = (byte)(n6 >> 24);
                ++n2;
                n4 += 4;
            }
            this.position = n4;
        } else {
            int n7 = n2 + n3;
            while (n2 < n7) {
                this.writeFloat(fArray[n2]);
                ++n2;
            }
        }
    }

    public void writeDoubles(double[] dArray, int n2, int n3) {
        if (this.capacity >= n3 << 3) {
            this.require(n3 << 3);
            byte[] byArray = this.buffer;
            int n4 = this.position;
            int n5 = n2 + n3;
            while (n2 < n5) {
                long l2 = Double.doubleToLongBits(dArray[n2]);
                byArray[n4] = (byte)l2;
                byArray[n4 + 1] = (byte)(l2 >>> 8);
                byArray[n4 + 2] = (byte)(l2 >>> 16);
                byArray[n4 + 3] = (byte)(l2 >>> 24);
                byArray[n4 + 4] = (byte)(l2 >>> 32);
                byArray[n4 + 5] = (byte)(l2 >>> 40);
                byArray[n4 + 6] = (byte)(l2 >>> 48);
                byArray[n4 + 7] = (byte)(l2 >>> 56);
                ++n2;
                n4 += 8;
            }
            this.position = n4;
        } else {
            int n6 = n2 + n3;
            while (n2 < n6) {
                this.writeDouble(dArray[n2]);
                ++n2;
            }
        }
    }

    public void writeShorts(short[] sArray, int n2, int n3) {
        if (this.capacity >= n3 << 1) {
            this.require(n3 << 1);
            byte[] byArray = this.buffer;
            int n4 = this.position;
            int n5 = n2 + n3;
            while (n2 < n5) {
                short s2 = sArray[n2];
                byArray[n4] = (byte)s2;
                byArray[n4 + 1] = (byte)(s2 >>> 8);
                ++n2;
                n4 += 2;
            }
            this.position = n4;
        } else {
            int n6 = n2 + n3;
            while (n2 < n6) {
                this.writeShort(sArray[n2]);
                ++n2;
            }
        }
    }

    public void writeChars(char[] cArray, int n2, int n3) {
        if (this.capacity >= n3 << 1) {
            this.require(n3 << 1);
            byte[] byArray = this.buffer;
            int n4 = this.position;
            int n5 = n2 + n3;
            while (n2 < n5) {
                char c2 = cArray[n2];
                byArray[n4] = (byte)c2;
                byArray[n4 + 1] = (byte)(c2 >>> 8);
                ++n2;
                n4 += 2;
            }
            this.position = n4;
        } else {
            int n6 = n2 + n3;
            while (n2 < n6) {
                this.writeChar(cArray[n2]);
                ++n2;
            }
        }
    }

    public void writeBooleans(boolean[] blArray, int n2, int n3) {
        if (this.capacity >= n3) {
            this.require(n3);
            byte[] byArray = this.buffer;
            int n4 = this.position;
            int n5 = n2 + n3;
            while (n2 < n5) {
                byArray[n4] = blArray[n2] ? (byte)1 : 0;
                ++n2;
                ++n4;
            }
            this.position = n4;
        } else {
            int n6 = n2 + n3;
            while (n2 < n6) {
                this.writeBoolean(blArray[n2]);
                ++n2;
            }
        }
    }

    public static int varIntLength(int n2, boolean bl2) {
        if (!bl2) {
            n2 = n2 << 1 ^ n2 >> 31;
        }
        if (n2 >>> 7 == 0) {
            return 1;
        }
        if (n2 >>> 14 == 0) {
            return 2;
        }
        if (n2 >>> 21 == 0) {
            return 3;
        }
        if (n2 >>> 28 == 0) {
            return 4;
        }
        return 5;
    }

    public static int varLongLength(long l2, boolean bl2) {
        if (!bl2) {
            l2 = l2 << 1 ^ l2 >> 63;
        }
        if (l2 >>> 7 == 0L) {
            return 1;
        }
        if (l2 >>> 14 == 0L) {
            return 2;
        }
        if (l2 >>> 21 == 0L) {
            return 3;
        }
        if (l2 >>> 28 == 0L) {
            return 4;
        }
        if (l2 >>> 35 == 0L) {
            return 5;
        }
        if (l2 >>> 42 == 0L) {
            return 6;
        }
        if (l2 >>> 49 == 0L) {
            return 7;
        }
        if (l2 >>> 56 == 0L) {
            return 8;
        }
        return 9;
    }
}

