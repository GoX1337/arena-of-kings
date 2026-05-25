/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Output;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferOutput
extends Output {
    private static final ByteOrder nativeOrder = ByteOrder.nativeOrder();
    protected ByteBuffer byteBuffer;

    public ByteBufferOutput() {
    }

    public ByteBufferOutput(int n2) {
        this(n2, n2);
    }

    public ByteBufferOutput(int n2, int n3) {
        if (n3 < -1) {
            throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + n3);
        }
        this.capacity = n2;
        this.maxCapacity = n3 == -1 ? 0x7FFFFFF7 : n3;
        this.byteBuffer = ByteBuffer.allocateDirect(n2);
    }

    public ByteBufferOutput(ByteBuffer byteBuffer) {
        this.setBuffer(byteBuffer);
    }

    public ByteBufferOutput(ByteBuffer byteBuffer, int n2) {
        this.setBuffer(byteBuffer, n2);
    }

    public ByteBufferOutput(OutputStream outputStream) {
        this(4096, 4096);
        if (outputStream == null) {
            throw new IllegalArgumentException("outputStream cannot be null.");
        }
        this.outputStream = outputStream;
    }

    public ByteBufferOutput(OutputStream outputStream, int n2) {
        this(n2, n2);
        if (outputStream == null) {
            throw new IllegalArgumentException("outputStream cannot be null.");
        }
        this.outputStream = outputStream;
    }

    @Override
    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override
    public byte[] getBuffer() {
        throw new UnsupportedOperationException("This buffer does not used a byte[], see #getByteBuffer().");
    }

    @Override
    public void setBuffer(byte[] byArray) {
        throw new UnsupportedOperationException("This buffer does not used a byte[], see #setByteBuffer(ByteBuffer).");
    }

    @Override
    public void setBuffer(byte[] byArray, int n2) {
        throw new UnsupportedOperationException("This buffer does not used a byte[], see #setByteBuffer(ByteBuffer).");
    }

    public void setBuffer(byte[] byArray, int n2, int n3) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(byArray.length);
        byteBuffer.put(byArray, n2, n3);
        this.setBufferPosition(byteBuffer, 0);
        this.setBufferLimit(byteBuffer, byArray.length);
        this.setBuffer(byteBuffer);
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        this.setBuffer(byteBuffer, byteBuffer.capacity());
    }

    public void setBuffer(ByteBuffer byteBuffer, int n2) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("buffer cannot be null.");
        }
        if (n2 < -1) {
            throw new IllegalArgumentException("maxBufferSize cannot be < -1: " + n2);
        }
        this.byteBuffer = byteBuffer;
        this.maxCapacity = n2 == -1 ? 0x7FFFFFF7 : n2;
        this.capacity = byteBuffer.capacity();
        this.position = byteBuffer.position();
        this.total = 0L;
        this.outputStream = null;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    @Override
    public byte[] toBytes() {
        byte[] byArray = new byte[this.position];
        this.setBufferPosition(this.byteBuffer, 0);
        this.byteBuffer.get(byArray, 0, this.position);
        return byArray;
    }

    @Override
    public void setPosition(int n2) {
        this.position = n2;
        this.setBufferPosition(this.byteBuffer, n2);
    }

    @Override
    public void reset() {
        super.reset();
        this.setBufferPosition(this.byteBuffer, 0);
    }

    private int getBufferPosition(Buffer buffer) {
        return buffer.position();
    }

    private void setBufferPosition(Buffer buffer, int n2) {
        buffer.position(n2);
    }

    private void setBufferLimit(Buffer buffer, int n2) {
        buffer.limit(n2);
    }

    @Override
    public boolean require(int n2) {
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
        ByteBuffer byteBuffer = !this.byteBuffer.isDirect() ? ByteBuffer.allocate(this.capacity) : ByteBuffer.allocateDirect(this.capacity);
        this.setBufferPosition(this.byteBuffer, 0);
        this.setBufferLimit(this.byteBuffer, this.position);
        byteBuffer.put(this.byteBuffer);
        byteBuffer.order(this.byteBuffer.order());
        this.byteBuffer = byteBuffer;
        return true;
    }

    @Override
    public void flush() {
        if (this.outputStream == null) {
            return;
        }
        try {
            byte[] byArray = new byte[this.position];
            this.setBufferPosition(this.byteBuffer, 0);
            this.byteBuffer.get(byArray);
            this.setBufferPosition(this.byteBuffer, 0);
            this.outputStream.write(byArray, 0, this.position);
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
        this.byteBuffer.put((byte)n2);
        ++this.position;
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

    @Override
    public void writeByte(byte by2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        this.byteBuffer.put(by2);
        ++this.position;
    }

    @Override
    public void writeByte(int n2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        this.byteBuffer.put((byte)n2);
        ++this.position;
    }

    @Override
    public void writeBytes(byte[] byArray) {
        if (byArray == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        this.writeBytes(byArray, 0, byArray.length);
    }

    @Override
    public void writeBytes(byte[] byArray, int n2, int n3) {
        if (byArray == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        int n4 = Math.min(this.capacity - this.position, n3);
        while (true) {
            this.byteBuffer.put(byArray, n2, n4);
            this.position += n4;
            if ((n3 -= n4) == 0) {
                return;
            }
            n2 += n4;
            n4 = Math.min(this.capacity, n3);
            this.require(n4);
        }
    }

    @Override
    public void writeInt(int n2) {
        this.require(4);
        this.position += 4;
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.put((byte)n2);
        byteBuffer.put((byte)(n2 >> 8));
        byteBuffer.put((byte)(n2 >> 16));
        byteBuffer.put((byte)(n2 >> 24));
    }

    @Override
    public int writeVarInt(int n2, boolean bl2) {
        if (!bl2) {
            n2 = n2 << 1 ^ n2 >> 31;
        }
        if (n2 >>> 7 == 0) {
            if (this.position == this.capacity) {
                this.require(1);
            }
            ++this.position;
            this.byteBuffer.put((byte)n2);
            return 1;
        }
        if (n2 >>> 14 == 0) {
            this.require(2);
            this.position += 2;
            this.byteBuffer.put((byte)(n2 & 0x7F | 0x80));
            this.byteBuffer.put((byte)(n2 >>> 7));
            return 2;
        }
        if (n2 >>> 21 == 0) {
            this.require(3);
            this.position += 3;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.put((byte)(n2 & 0x7F | 0x80));
            byteBuffer.put((byte)(n2 >>> 7 | 0x80));
            byteBuffer.put((byte)(n2 >>> 14));
            return 3;
        }
        if (n2 >>> 28 == 0) {
            this.require(4);
            this.position += 4;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.put((byte)(n2 & 0x7F | 0x80));
            byteBuffer.put((byte)(n2 >>> 7 | 0x80));
            byteBuffer.put((byte)(n2 >>> 14 | 0x80));
            byteBuffer.put((byte)(n2 >>> 21));
            return 4;
        }
        this.require(5);
        this.position += 5;
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.put((byte)(n2 & 0x7F | 0x80));
        byteBuffer.put((byte)(n2 >>> 7 | 0x80));
        byteBuffer.put((byte)(n2 >>> 14 | 0x80));
        byteBuffer.put((byte)(n2 >>> 21 | 0x80));
        byteBuffer.put((byte)(n2 >>> 28));
        return 5;
    }

    @Override
    public int writeVarIntFlag(boolean bl2, int n2, boolean bl3) {
        if (!bl3) {
            n2 = n2 << 1 ^ n2 >> 31;
        }
        int n3 = n2 & 0x3F | (bl2 ? 128 : 0);
        if (n2 >>> 6 == 0) {
            if (this.position == this.capacity) {
                this.require(1);
            }
            this.byteBuffer.put((byte)n3);
            ++this.position;
            return 1;
        }
        if (n2 >>> 13 == 0) {
            this.require(2);
            this.position += 2;
            this.byteBuffer.put((byte)(n3 | 0x40));
            this.byteBuffer.put((byte)(n2 >>> 6));
            return 2;
        }
        if (n2 >>> 20 == 0) {
            this.require(3);
            this.position += 3;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.put((byte)(n3 | 0x40));
            byteBuffer.put((byte)(n2 >>> 6 | 0x80));
            byteBuffer.put((byte)(n2 >>> 13));
            return 3;
        }
        if (n2 >>> 27 == 0) {
            this.require(4);
            this.position += 4;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.put((byte)(n3 | 0x40));
            byteBuffer.put((byte)(n2 >>> 6 | 0x80));
            byteBuffer.put((byte)(n2 >>> 13 | 0x80));
            byteBuffer.put((byte)(n2 >>> 20));
            return 4;
        }
        this.require(5);
        this.position += 5;
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.put((byte)(n3 | 0x40));
        byteBuffer.put((byte)(n2 >>> 6 | 0x80));
        byteBuffer.put((byte)(n2 >>> 13 | 0x80));
        byteBuffer.put((byte)(n2 >>> 20 | 0x80));
        byteBuffer.put((byte)(n2 >>> 27));
        return 5;
    }

    @Override
    public void writeLong(long l2) {
        this.require(8);
        this.position += 8;
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.put((byte)l2);
        byteBuffer.put((byte)(l2 >>> 8));
        byteBuffer.put((byte)(l2 >>> 16));
        byteBuffer.put((byte)(l2 >>> 24));
        byteBuffer.put((byte)(l2 >>> 32));
        byteBuffer.put((byte)(l2 >>> 40));
        byteBuffer.put((byte)(l2 >>> 48));
        byteBuffer.put((byte)(l2 >>> 56));
    }

    @Override
    public int writeVarLong(long l2, boolean bl2) {
        if (!bl2) {
            l2 = l2 << 1 ^ l2 >> 63;
        }
        if (l2 >>> 7 == 0L) {
            if (this.position == this.capacity) {
                this.require(1);
            }
            ++this.position;
            this.byteBuffer.put((byte)l2);
            return 1;
        }
        if (l2 >>> 14 == 0L) {
            this.require(2);
            this.position += 2;
            this.byteBuffer.put((byte)(l2 & 0x7FL | 0x80L));
            this.byteBuffer.put((byte)(l2 >>> 7));
            return 2;
        }
        if (l2 >>> 21 == 0L) {
            this.require(3);
            this.position += 3;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.put((byte)(l2 & 0x7FL | 0x80L));
            byteBuffer.put((byte)(l2 >>> 7 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 14));
            return 3;
        }
        if (l2 >>> 28 == 0L) {
            this.require(4);
            this.position += 4;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.put((byte)(l2 & 0x7FL | 0x80L));
            byteBuffer.put((byte)(l2 >>> 7 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 14 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 21));
            return 4;
        }
        if (l2 >>> 35 == 0L) {
            this.require(5);
            this.position += 5;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.put((byte)(l2 & 0x7FL | 0x80L));
            byteBuffer.put((byte)(l2 >>> 7 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 14 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 21 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 28));
            return 5;
        }
        if (l2 >>> 42 == 0L) {
            this.require(6);
            this.position += 6;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.put((byte)(l2 & 0x7FL | 0x80L));
            byteBuffer.put((byte)(l2 >>> 7 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 14 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 21 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 28 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 35));
            return 6;
        }
        if (l2 >>> 49 == 0L) {
            this.require(7);
            this.position += 7;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.put((byte)(l2 & 0x7FL | 0x80L));
            byteBuffer.put((byte)(l2 >>> 7 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 14 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 21 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 28 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 35 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 42));
            return 7;
        }
        if (l2 >>> 56 == 0L) {
            this.require(8);
            this.position += 8;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.put((byte)(l2 & 0x7FL | 0x80L));
            byteBuffer.put((byte)(l2 >>> 7 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 14 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 21 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 28 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 35 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 42 | 0x80L));
            byteBuffer.put((byte)(l2 >>> 49));
            return 8;
        }
        this.require(9);
        this.position += 9;
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.put((byte)(l2 & 0x7FL | 0x80L));
        byteBuffer.put((byte)(l2 >>> 7 | 0x80L));
        byteBuffer.put((byte)(l2 >>> 14 | 0x80L));
        byteBuffer.put((byte)(l2 >>> 21 | 0x80L));
        byteBuffer.put((byte)(l2 >>> 28 | 0x80L));
        byteBuffer.put((byte)(l2 >>> 35 | 0x80L));
        byteBuffer.put((byte)(l2 >>> 42 | 0x80L));
        byteBuffer.put((byte)(l2 >>> 49 | 0x80L));
        byteBuffer.put((byte)(l2 >>> 56));
        return 9;
    }

    @Override
    public void writeFloat(float f2) {
        this.require(4);
        ByteBuffer byteBuffer = this.byteBuffer;
        this.position += 4;
        int n2 = Float.floatToIntBits(f2);
        byteBuffer.put((byte)n2);
        byteBuffer.put((byte)(n2 >> 8));
        byteBuffer.put((byte)(n2 >> 16));
        byteBuffer.put((byte)(n2 >> 24));
    }

    @Override
    public void writeDouble(double d2) {
        this.require(8);
        this.position += 8;
        ByteBuffer byteBuffer = this.byteBuffer;
        long l2 = Double.doubleToLongBits(d2);
        byteBuffer.put((byte)l2);
        byteBuffer.put((byte)(l2 >>> 8));
        byteBuffer.put((byte)(l2 >>> 16));
        byteBuffer.put((byte)(l2 >>> 24));
        byteBuffer.put((byte)(l2 >>> 32));
        byteBuffer.put((byte)(l2 >>> 40));
        byteBuffer.put((byte)(l2 >>> 48));
        byteBuffer.put((byte)(l2 >>> 56));
    }

    @Override
    public void writeShort(int n2) {
        this.require(2);
        this.position += 2;
        this.byteBuffer.put((byte)n2);
        this.byteBuffer.put((byte)(n2 >>> 8));
    }

    @Override
    public void writeChar(char c2) {
        this.require(2);
        this.position += 2;
        this.byteBuffer.put((byte)c2);
        this.byteBuffer.put((byte)(c2 >>> 8));
    }

    @Override
    public void writeBoolean(boolean bl2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        this.byteBuffer.put((byte)(bl2 ? 1 : 0));
        ++this.position;
    }

    @Override
    public void writeString(String string) {
        int n2;
        int n3;
        block11: {
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
                    break block11;
                }
                if (this.capacity - this.position < n3) {
                    this.writeAscii_slow(string, n3);
                } else {
                    int n4 = string.length();
                    for (n2 = 0; n2 < n4; ++n2) {
                        this.byteBuffer.put((byte)string.charAt(n2));
                    }
                    this.position += n3;
                }
                this.byteBuffer.put(this.position - 1, (byte)(this.byteBuffer.get(this.position - 1) | 0x80));
                return;
            }
        }
        this.writeVarIntFlag(true, n3 + 1, true);
        n2 = 0;
        if (this.capacity - this.position >= n3) {
            char c2;
            ByteBuffer byteBuffer = this.byteBuffer;
            while ((c2 = string.charAt(n2)) <= '\u007f') {
                byteBuffer.put((byte)c2);
                if (++n2 != n3) continue;
                this.position = this.getBufferPosition(byteBuffer);
                return;
            }
            this.position = this.getBufferPosition(byteBuffer);
        }
        if (n2 < n3) {
            this.writeUtf8_slow(string, n3, n2);
        }
    }

    @Override
    public void writeAscii(String string) {
        if (string == null) {
            this.writeByte(128);
            return;
        }
        int n2 = string.length();
        if (n2 == 0) {
            this.writeByte(129);
            return;
        }
        if (this.capacity - this.position < n2) {
            this.writeAscii_slow(string, n2);
        } else {
            ByteBuffer byteBuffer = this.byteBuffer;
            int n3 = string.length();
            for (int i2 = 0; i2 < n3; ++i2) {
                byteBuffer.put((byte)string.charAt(i2));
            }
            this.position += n2;
        }
        this.byteBuffer.put(this.position - 1, (byte)(this.byteBuffer.get(this.position - 1) | 0x80));
    }

    private void writeUtf8_slow(String string, int n2, int n3) {
        while (n3 < n2) {
            if (this.position == this.capacity) {
                this.require(Math.min(this.capacity, n2 - n3));
            }
            ++this.position;
            char c2 = string.charAt(n3);
            if (c2 <= '\u007f') {
                this.byteBuffer.put((byte)c2);
            } else if (c2 > '\u07ff') {
                this.byteBuffer.put((byte)(0xE0 | c2 >> 12 & 0xF));
                this.require(2);
                this.position += 2;
                this.byteBuffer.put((byte)(0x80 | c2 >> 6 & 0x3F));
                this.byteBuffer.put((byte)(0x80 | c2 & 0x3F));
            } else {
                this.byteBuffer.put((byte)(0xC0 | c2 >> 6 & 0x1F));
                if (this.position == this.capacity) {
                    this.require(1);
                }
                ++this.position;
                this.byteBuffer.put((byte)(0x80 | c2 & 0x3F));
            }
            ++n3;
        }
    }

    private void writeAscii_slow(String string, int n2) {
        ByteBuffer byteBuffer = this.byteBuffer;
        int n3 = 0;
        int n4 = Math.min(n2, this.capacity - this.position);
        while (n3 < n2) {
            byte[] byArray = new byte[n2];
            string.getBytes(n3, n3 + n4, byArray, 0);
            byteBuffer.put(byArray, 0, n4);
            this.position += n4;
            if (!this.require(n4 = Math.min(n2 - (n3 += n4), this.capacity))) continue;
            byteBuffer = this.byteBuffer;
        }
    }

    @Override
    public void writeInts(int[] nArray, int n2, int n3) {
        if (this.capacity >= n3 << 2) {
            this.require(n3 << 2);
            ByteBuffer byteBuffer = this.byteBuffer;
            int n4 = n2 + n3;
            while (n2 < n4) {
                int n5 = nArray[n2];
                byteBuffer.put((byte)n5);
                byteBuffer.put((byte)(n5 >> 8));
                byteBuffer.put((byte)(n5 >> 16));
                byteBuffer.put((byte)(n5 >> 24));
                ++n2;
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            int n6 = n2 + n3;
            while (n2 < n6) {
                this.writeInt(nArray[n2]);
                ++n2;
            }
        }
    }

    @Override
    public void writeLongs(long[] lArray, int n2, int n3) {
        if (this.capacity >= n3 << 3) {
            this.require(n3 << 3);
            ByteBuffer byteBuffer = this.byteBuffer;
            int n4 = n2 + n3;
            while (n2 < n4) {
                long l2 = lArray[n2];
                byteBuffer.put((byte)l2);
                byteBuffer.put((byte)(l2 >>> 8));
                byteBuffer.put((byte)(l2 >>> 16));
                byteBuffer.put((byte)(l2 >>> 24));
                byteBuffer.put((byte)(l2 >>> 32));
                byteBuffer.put((byte)(l2 >>> 40));
                byteBuffer.put((byte)(l2 >>> 48));
                byteBuffer.put((byte)(l2 >>> 56));
                ++n2;
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            int n5 = n2 + n3;
            while (n2 < n5) {
                this.writeLong(lArray[n2]);
                ++n2;
            }
        }
    }

    @Override
    public void writeFloats(float[] fArray, int n2, int n3) {
        if (this.capacity >= n3 << 2) {
            this.require(n3 << 2);
            ByteBuffer byteBuffer = this.byteBuffer;
            int n4 = n2 + n3;
            while (n2 < n4) {
                int n5 = Float.floatToIntBits(fArray[n2]);
                byteBuffer.put((byte)n5);
                byteBuffer.put((byte)(n5 >> 8));
                byteBuffer.put((byte)(n5 >> 16));
                byteBuffer.put((byte)(n5 >> 24));
                ++n2;
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            int n6 = n2 + n3;
            while (n2 < n6) {
                this.writeFloat(fArray[n2]);
                ++n2;
            }
        }
    }

    @Override
    public void writeDoubles(double[] dArray, int n2, int n3) {
        if (this.capacity >= n3 << 3) {
            this.require(n3 << 3);
            ByteBuffer byteBuffer = this.byteBuffer;
            int n4 = n2 + n3;
            while (n2 < n4) {
                long l2 = Double.doubleToLongBits(dArray[n2]);
                byteBuffer.put((byte)l2);
                byteBuffer.put((byte)(l2 >>> 8));
                byteBuffer.put((byte)(l2 >>> 16));
                byteBuffer.put((byte)(l2 >>> 24));
                byteBuffer.put((byte)(l2 >>> 32));
                byteBuffer.put((byte)(l2 >>> 40));
                byteBuffer.put((byte)(l2 >>> 48));
                byteBuffer.put((byte)(l2 >>> 56));
                ++n2;
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            int n5 = n2 + n3;
            while (n2 < n5) {
                this.writeDouble(dArray[n2]);
                ++n2;
            }
        }
    }

    @Override
    public void writeShorts(short[] sArray, int n2, int n3) {
        if (this.capacity >= n3 << 1) {
            this.require(n3 << 1);
            int n4 = n2 + n3;
            while (n2 < n4) {
                short s2 = sArray[n2];
                this.byteBuffer.put((byte)s2);
                this.byteBuffer.put((byte)(s2 >>> 8));
                ++n2;
            }
            this.position = this.getBufferPosition(this.byteBuffer);
        } else {
            int n5 = n2 + n3;
            while (n2 < n5) {
                this.writeShort(sArray[n2]);
                ++n2;
            }
        }
    }

    @Override
    public void writeChars(char[] cArray, int n2, int n3) {
        if (this.capacity >= n3 << 1) {
            this.require(n3 << 1);
            int n4 = n2 + n3;
            while (n2 < n4) {
                char c2 = cArray[n2];
                this.byteBuffer.put((byte)c2);
                this.byteBuffer.put((byte)(c2 >>> 8));
                ++n2;
            }
            this.position = this.getBufferPosition(this.byteBuffer);
        } else {
            int n5 = n2 + n3;
            while (n2 < n5) {
                this.writeChar(cArray[n2]);
                ++n2;
            }
        }
    }

    @Override
    public void writeBooleans(boolean[] blArray, int n2, int n3) {
        if (this.capacity >= n3) {
            this.require(n3);
            int n4 = n2 + n3;
            while (n2 < n4) {
                this.byteBuffer.put(blArray[n2] ? (byte)1 : 0);
                ++n2;
            }
            this.position = this.getBufferPosition(this.byteBuffer);
        } else {
            int n5 = n2 + n3;
            while (n2 < n5) {
                this.writeBoolean(blArray[n2]);
                ++n2;
            }
        }
    }
}

