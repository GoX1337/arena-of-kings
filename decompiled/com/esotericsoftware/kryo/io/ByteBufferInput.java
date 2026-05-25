/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferInput
extends Input {
    private static final ByteOrder nativeOrder = ByteOrder.nativeOrder();
    protected ByteBuffer byteBuffer;
    private byte[] tempBuffer;

    public ByteBufferInput() {
    }

    public ByteBufferInput(int n2) {
        this.capacity = n2;
        this.byteBuffer = ByteBuffer.allocateDirect(n2);
    }

    public ByteBufferInput(byte[] byArray) {
        this(byArray, 0, byArray.length);
    }

    public ByteBufferInput(byte[] byArray, int n2, int n3) {
        if (byArray == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(byArray.length);
        byteBuffer.put(byArray);
        this.flipBuffer(byteBuffer);
        this.setBuffer(byteBuffer);
    }

    public ByteBufferInput(ByteBuffer byteBuffer) {
        this.setBuffer(byteBuffer);
    }

    public ByteBufferInput(InputStream inputStream) {
        this(4096);
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null.");
        }
        this.inputStream = inputStream;
    }

    public ByteBufferInput(InputStream inputStream, int n2) {
        this(n2);
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null.");
        }
        this.inputStream = inputStream;
    }

    @Override
    public byte[] getBuffer() {
        throw new UnsupportedOperationException("This input does not used a byte[], see #getByteBuffer().");
    }

    @Override
    public void setBuffer(byte[] byArray) {
        throw new UnsupportedOperationException("This input does not used a byte[], see #setByteBuffer(ByteBuffer).");
    }

    @Override
    public void setBuffer(byte[] byArray, int n2, int n3) {
        throw new UnsupportedOperationException("This input does not used a byte[], see #setByteBufferByteBuffer().");
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("buffer cannot be null.");
        }
        this.byteBuffer = byteBuffer;
        this.position = byteBuffer.position();
        this.limit = byteBuffer.limit();
        this.capacity = byteBuffer.capacity();
        this.total = 0L;
        this.inputStream = null;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    @Override
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        this.limit = 0;
        this.reset();
    }

    @Override
    public void reset() {
        super.reset();
        this.setBufferPosition(this.byteBuffer, 0);
    }

    protected int fill(ByteBuffer byteBuffer, int n2, int n3) {
        if (this.inputStream == null) {
            return -1;
        }
        try {
            if (this.tempBuffer == null) {
                this.tempBuffer = new byte[2048];
            }
            this.setBufferPosition(byteBuffer, n2);
            int n4 = 0;
            while (n3 > 0) {
                int n5 = this.inputStream.read(this.tempBuffer, 0, Math.min(this.tempBuffer.length, n3));
                if (n5 == -1) {
                    if (n4 != 0) break;
                    return -1;
                }
                byteBuffer.put(this.tempBuffer, 0, n5);
                n3 -= n5;
                n4 += n5;
            }
            return n4;
        }
        catch (IOException iOException) {
            throw new KryoException(iOException);
        }
    }

    @Override
    protected int require(int n2) {
        int n3;
        int n4 = this.limit - this.position;
        if (n4 >= n2) {
            return n4;
        }
        if (n2 > this.capacity) {
            throw new KryoException("Buffer too small: capacity: " + this.capacity + ", required: " + n2);
        }
        if (n4 > 0) {
            n3 = this.fill(this.byteBuffer, this.limit, this.capacity - this.limit);
            if (n3 == -1) {
                throw new KryoException("Buffer underflow.");
            }
            this.setBufferPosition(this.byteBuffer, this.position);
            if ((n4 += n3) >= n2) {
                this.limit += n3;
                return n4;
            }
        }
        this.byteBuffer.compact();
        this.total += (long)this.position;
        this.position = 0;
        do {
            if ((n3 = this.fill(this.byteBuffer, n4, this.capacity - n4)) != -1) continue;
            if (n4 >= n2) break;
            throw new KryoException("Buffer underflow.");
        } while ((n4 += n3) < n2);
        this.limit = n4;
        this.setBufferPosition(this.byteBuffer, 0);
        return n4;
    }

    @Override
    protected int optional(int n2) {
        int n3 = this.limit - this.position;
        if (n3 >= n2) {
            return n2;
        }
        n2 = Math.min(n2, this.capacity);
        int n4 = this.fill(this.byteBuffer, this.limit, this.capacity - this.limit);
        this.setBufferPosition(this.byteBuffer, this.position);
        if (n4 == -1) {
            return n3 == 0 ? -1 : Math.min(n3, n2);
        }
        if ((n3 += n4) >= n2) {
            this.limit += n4;
            return n2;
        }
        this.byteBuffer.compact();
        this.total += (long)this.position;
        this.position = 0;
        while ((n4 = this.fill(this.byteBuffer, n3, this.capacity - n3)) != -1 && (n3 += n4) < n2) {
        }
        this.limit = n3;
        this.setBufferPosition(this.byteBuffer, 0);
        return n3 == 0 ? -1 : Math.min(n3, n2);
    }

    @Override
    public int read() {
        if (this.optional(1) <= 0) {
            return -1;
        }
        ++this.position;
        return this.byteBuffer.get() & 0xFF;
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) {
        if (byArray == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        int n4 = n3;
        int n5 = Math.min(this.limit - this.position, n3);
        do {
            this.byteBuffer.get(byArray, n2, n5);
            this.position += n5;
            if ((n3 -= n5) == 0) break;
            n2 += n5;
            n5 = this.optional(n3);
            if (n5 != -1) continue;
            if (n4 == n3) {
                return -1;
            }
            break;
        } while (this.position != this.limit);
        return n4 - n3;
    }

    @Override
    public void setPosition(int n2) {
        this.position = n2;
        this.setBufferPosition(this.byteBuffer, n2);
    }

    @Override
    public void setLimit(int n2) {
        this.limit = n2;
        this.setBufferLimit(this.byteBuffer, n2);
    }

    @Override
    public void skip(int n2) {
        super.skip(n2);
        this.setBufferPosition(this.byteBuffer, this.position);
    }

    @Override
    public long skip(long l2) {
        int n2;
        for (long i2 = l2; i2 > 0L; i2 -= (long)n2) {
            n2 = (int)Math.min(0x7FFFFFF7L, i2);
            this.skip(n2);
        }
        return l2;
    }

    @Override
    public void close() {
        if (this.inputStream != null) {
            try {
                this.inputStream.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
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

    private void flipBuffer(Buffer buffer) {
        buffer.flip();
    }

    @Override
    public byte readByte() {
        if (this.position == this.limit) {
            this.require(1);
        }
        ++this.position;
        return this.byteBuffer.get();
    }

    @Override
    public int readByteUnsigned() {
        if (this.position == this.limit) {
            this.require(1);
        }
        ++this.position;
        return this.byteBuffer.get() & 0xFF;
    }

    @Override
    public byte[] readBytes(int n2) {
        byte[] byArray = new byte[n2];
        this.readBytes(byArray, 0, n2);
        return byArray;
    }

    @Override
    public void readBytes(byte[] byArray, int n2, int n3) {
        if (byArray == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        int n4 = Math.min(this.limit - this.position, n3);
        while (true) {
            this.byteBuffer.get(byArray, n2, n4);
            this.position += n4;
            if ((n3 -= n4) == 0) break;
            n2 += n4;
            n4 = Math.min(n3, this.capacity);
            this.require(n4);
        }
    }

    @Override
    public int readInt() {
        this.require(4);
        this.position += 4;
        ByteBuffer byteBuffer = this.byteBuffer;
        return byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8 | (byteBuffer.get() & 0xFF) << 16 | (byteBuffer.get() & 0xFF) << 24;
    }

    @Override
    public int readVarInt(boolean bl2) {
        if (this.require(1) < 5) {
            return this.readVarInt_slow(bl2);
        }
        byte by2 = this.byteBuffer.get();
        int n2 = by2 & 0x7F;
        if ((by2 & 0x80) != 0) {
            ByteBuffer byteBuffer = this.byteBuffer;
            by2 = byteBuffer.get();
            n2 |= (by2 & 0x7F) << 7;
            if ((by2 & 0x80) != 0) {
                by2 = byteBuffer.get();
                n2 |= (by2 & 0x7F) << 14;
                if ((by2 & 0x80) != 0) {
                    by2 = byteBuffer.get();
                    n2 |= (by2 & 0x7F) << 21;
                    if ((by2 & 0x80) != 0) {
                        by2 = byteBuffer.get();
                        n2 |= (by2 & 0x7F) << 28;
                    }
                }
            }
        }
        this.position = this.getBufferPosition(this.byteBuffer);
        return bl2 ? n2 : n2 >>> 1 ^ -(n2 & 1);
    }

    private int readVarInt_slow(boolean bl2) {
        ++this.position;
        byte by2 = this.byteBuffer.get();
        int n2 = by2 & 0x7F;
        if ((by2 & 0x80) != 0) {
            if (this.position == this.limit) {
                this.require(1);
            }
            ByteBuffer byteBuffer = this.byteBuffer;
            ++this.position;
            by2 = byteBuffer.get();
            n2 |= (by2 & 0x7F) << 7;
            if ((by2 & 0x80) != 0) {
                if (this.position == this.limit) {
                    this.require(1);
                }
                ++this.position;
                by2 = byteBuffer.get();
                n2 |= (by2 & 0x7F) << 14;
                if ((by2 & 0x80) != 0) {
                    if (this.position == this.limit) {
                        this.require(1);
                    }
                    ++this.position;
                    by2 = byteBuffer.get();
                    n2 |= (by2 & 0x7F) << 21;
                    if ((by2 & 0x80) != 0) {
                        if (this.position == this.limit) {
                            this.require(1);
                        }
                        ++this.position;
                        by2 = byteBuffer.get();
                        n2 |= (by2 & 0x7F) << 28;
                    }
                }
            }
        }
        return bl2 ? n2 : n2 >>> 1 ^ -(n2 & 1);
    }

    @Override
    public boolean canReadVarInt() {
        if (this.limit - this.position >= 5) {
            return true;
        }
        if (this.optional(5) <= 0) {
            return false;
        }
        int n2 = this.position;
        int n3 = this.limit;
        ByteBuffer byteBuffer = this.byteBuffer;
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        return n2 != n3;
    }

    @Override
    public boolean readVarIntFlag() {
        if (this.position == this.limit) {
            this.require(1);
        }
        return (this.byteBuffer.get(this.position) & 0x80) != 0;
    }

    @Override
    public int readVarIntFlag(boolean bl2) {
        if (this.require(1) < 5) {
            return this.readVarIntFlag_slow(bl2);
        }
        byte by2 = this.byteBuffer.get();
        int n2 = by2 & 0x3F;
        if ((by2 & 0x40) != 0) {
            ByteBuffer byteBuffer = this.byteBuffer;
            by2 = byteBuffer.get();
            n2 |= (by2 & 0x7F) << 6;
            if ((by2 & 0x80) != 0) {
                by2 = byteBuffer.get();
                n2 |= (by2 & 0x7F) << 13;
                if ((by2 & 0x80) != 0) {
                    by2 = byteBuffer.get();
                    n2 |= (by2 & 0x7F) << 20;
                    if ((by2 & 0x80) != 0) {
                        by2 = byteBuffer.get();
                        n2 |= (by2 & 0x7F) << 27;
                    }
                }
            }
        }
        this.position = this.getBufferPosition(this.byteBuffer);
        return bl2 ? n2 : n2 >>> 1 ^ -(n2 & 1);
    }

    private int readVarIntFlag_slow(boolean bl2) {
        ++this.position;
        byte by2 = this.byteBuffer.get();
        int n2 = by2 & 0x3F;
        if ((by2 & 0x40) != 0) {
            if (this.position == this.limit) {
                this.require(1);
            }
            ++this.position;
            ByteBuffer byteBuffer = this.byteBuffer;
            by2 = byteBuffer.get();
            n2 |= (by2 & 0x7F) << 6;
            if ((by2 & 0x80) != 0) {
                if (this.position == this.limit) {
                    this.require(1);
                }
                ++this.position;
                by2 = byteBuffer.get();
                n2 |= (by2 & 0x7F) << 13;
                if ((by2 & 0x80) != 0) {
                    if (this.position == this.limit) {
                        this.require(1);
                    }
                    ++this.position;
                    by2 = byteBuffer.get();
                    n2 |= (by2 & 0x7F) << 20;
                    if ((by2 & 0x80) != 0) {
                        if (this.position == this.limit) {
                            this.require(1);
                        }
                        ++this.position;
                        by2 = byteBuffer.get();
                        n2 |= (by2 & 0x7F) << 27;
                    }
                }
            }
        }
        return bl2 ? n2 : n2 >>> 1 ^ -(n2 & 1);
    }

    @Override
    public long readLong() {
        this.require(8);
        this.position += 8;
        ByteBuffer byteBuffer = this.byteBuffer;
        return (long)(byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8 | (byteBuffer.get() & 0xFF) << 16) | (long)(byteBuffer.get() & 0xFF) << 24 | (long)(byteBuffer.get() & 0xFF) << 32 | (long)(byteBuffer.get() & 0xFF) << 40 | (long)(byteBuffer.get() & 0xFF) << 48 | (long)byteBuffer.get() << 56;
    }

    @Override
    public long readVarLong(boolean bl2) {
        if (this.require(1) < 9) {
            return this.readVarLong_slow(bl2);
        }
        byte by2 = this.byteBuffer.get();
        long l2 = by2 & 0x7F;
        if ((by2 & 0x80) != 0) {
            ByteBuffer byteBuffer = this.byteBuffer;
            by2 = byteBuffer.get();
            l2 |= (long)((by2 & 0x7F) << 7);
            if ((by2 & 0x80) != 0) {
                by2 = byteBuffer.get();
                l2 |= (long)((by2 & 0x7F) << 14);
                if ((by2 & 0x80) != 0) {
                    by2 = byteBuffer.get();
                    l2 |= (long)((by2 & 0x7F) << 21);
                    if ((by2 & 0x80) != 0) {
                        by2 = byteBuffer.get();
                        l2 |= (long)(by2 & 0x7F) << 28;
                        if ((by2 & 0x80) != 0) {
                            by2 = byteBuffer.get();
                            l2 |= (long)(by2 & 0x7F) << 35;
                            if ((by2 & 0x80) != 0) {
                                by2 = byteBuffer.get();
                                l2 |= (long)(by2 & 0x7F) << 42;
                                if ((by2 & 0x80) != 0) {
                                    by2 = byteBuffer.get();
                                    l2 |= (long)(by2 & 0x7F) << 49;
                                    if ((by2 & 0x80) != 0) {
                                        by2 = byteBuffer.get();
                                        l2 |= (long)by2 << 56;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.position = this.getBufferPosition(this.byteBuffer);
        return bl2 ? l2 : l2 >>> 1 ^ -(l2 & 1L);
    }

    private long readVarLong_slow(boolean bl2) {
        ++this.position;
        byte by2 = this.byteBuffer.get();
        long l2 = by2 & 0x7F;
        if ((by2 & 0x80) != 0) {
            if (this.position == this.limit) {
                this.require(1);
            }
            ByteBuffer byteBuffer = this.byteBuffer;
            ++this.position;
            by2 = byteBuffer.get();
            l2 |= (long)((by2 & 0x7F) << 7);
            if ((by2 & 0x80) != 0) {
                if (this.position == this.limit) {
                    this.require(1);
                }
                ++this.position;
                by2 = byteBuffer.get();
                l2 |= (long)((by2 & 0x7F) << 14);
                if ((by2 & 0x80) != 0) {
                    if (this.position == this.limit) {
                        this.require(1);
                    }
                    ++this.position;
                    by2 = byteBuffer.get();
                    l2 |= (long)((by2 & 0x7F) << 21);
                    if ((by2 & 0x80) != 0) {
                        if (this.position == this.limit) {
                            this.require(1);
                        }
                        ++this.position;
                        by2 = byteBuffer.get();
                        l2 |= (long)(by2 & 0x7F) << 28;
                        if ((by2 & 0x80) != 0) {
                            if (this.position == this.limit) {
                                this.require(1);
                            }
                            ++this.position;
                            by2 = byteBuffer.get();
                            l2 |= (long)(by2 & 0x7F) << 35;
                            if ((by2 & 0x80) != 0) {
                                if (this.position == this.limit) {
                                    this.require(1);
                                }
                                ++this.position;
                                by2 = byteBuffer.get();
                                l2 |= (long)(by2 & 0x7F) << 42;
                                if ((by2 & 0x80) != 0) {
                                    if (this.position == this.limit) {
                                        this.require(1);
                                    }
                                    ++this.position;
                                    by2 = byteBuffer.get();
                                    l2 |= (long)(by2 & 0x7F) << 49;
                                    if ((by2 & 0x80) != 0) {
                                        if (this.position == this.limit) {
                                            this.require(1);
                                        }
                                        ++this.position;
                                        by2 = byteBuffer.get();
                                        l2 |= (long)by2 << 56;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl2 ? l2 : l2 >>> 1 ^ -(l2 & 1L);
    }

    @Override
    public boolean canReadVarLong() {
        if (this.limit - this.position >= 9) {
            return true;
        }
        if (this.optional(5) <= 0) {
            return false;
        }
        int n2 = this.position;
        int n3 = this.limit;
        ByteBuffer byteBuffer = this.byteBuffer;
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byteBuffer.get(n2++) & 0x80) == 0) {
            return true;
        }
        return n2 != n3;
    }

    @Override
    public float readFloat() {
        this.require(4);
        ByteBuffer byteBuffer = this.byteBuffer;
        int n2 = this.position;
        this.position = n2 + 4;
        return Float.intBitsToFloat(byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8 | (byteBuffer.get() & 0xFF) << 16 | (byteBuffer.get() & 0xFF) << 24);
    }

    @Override
    public double readDouble() {
        this.require(8);
        ByteBuffer byteBuffer = this.byteBuffer;
        int n2 = this.position;
        this.position = n2 + 8;
        return Double.longBitsToDouble((long)(byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8 | (byteBuffer.get() & 0xFF) << 16) | (long)(byteBuffer.get() & 0xFF) << 24 | (long)(byteBuffer.get() & 0xFF) << 32 | (long)(byteBuffer.get() & 0xFF) << 40 | (long)(byteBuffer.get() & 0xFF) << 48 | (long)byteBuffer.get() << 56);
    }

    @Override
    public boolean readBoolean() {
        if (this.position == this.limit) {
            this.require(1);
        }
        ++this.position;
        return this.byteBuffer.get() == 1;
    }

    @Override
    public short readShort() {
        this.require(2);
        this.position += 2;
        return (short)(this.byteBuffer.get() & 0xFF | (this.byteBuffer.get() & 0xFF) << 8);
    }

    @Override
    public int readShortUnsigned() {
        this.require(2);
        this.position += 2;
        return this.byteBuffer.get() & 0xFF | (this.byteBuffer.get() & 0xFF) << 8;
    }

    @Override
    public char readChar() {
        this.require(2);
        this.position += 2;
        return (char)(this.byteBuffer.get() & 0xFF | (this.byteBuffer.get() & 0xFF) << 8);
    }

    @Override
    public String readString() {
        if (!this.readVarIntFlag()) {
            return this.readAsciiString();
        }
        int n2 = this.readVarIntFlag(true);
        switch (n2) {
            case 0: {
                return null;
            }
            case 1: {
                return "";
            }
        }
        this.readUtf8Chars(--n2);
        return new String(this.chars, 0, n2);
    }

    @Override
    public StringBuilder readStringBuilder() {
        if (!this.readVarIntFlag()) {
            return new StringBuilder(this.readAsciiString());
        }
        int n2 = this.readVarIntFlag(true);
        switch (n2) {
            case 0: {
                return null;
            }
            case 1: {
                return new StringBuilder("");
            }
        }
        this.readUtf8Chars(--n2);
        StringBuilder stringBuilder = new StringBuilder(n2);
        stringBuilder.append(this.chars, 0, n2);
        return stringBuilder;
    }

    private void readUtf8Chars(int n2) {
        byte by2;
        if (this.chars.length < n2) {
            this.chars = new char[n2];
        }
        char[] cArray = this.chars;
        ByteBuffer byteBuffer = this.byteBuffer;
        int n3 = 0;
        int n4 = Math.min(this.require(1), n2);
        while (n3 < n4 && (by2 = byteBuffer.get()) >= 0) {
            cArray[n3++] = (char)by2;
        }
        this.position += n3;
        if (n3 < n2) {
            this.setBufferPosition(byteBuffer, this.position);
            this.readUtf8Chars_slow(n2, n3);
        }
    }

    private void readUtf8Chars_slow(int n2, int n3) {
        ByteBuffer byteBuffer = this.byteBuffer;
        char[] cArray = this.chars;
        while (n3 < n2) {
            if (this.position == this.limit) {
                this.require(1);
            }
            ++this.position;
            int n4 = byteBuffer.get() & 0xFF;
            switch (n4 >> 4) {
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: {
                    cArray[n3] = (char)n4;
                    break;
                }
                case 12: 
                case 13: {
                    if (this.position == this.limit) {
                        this.require(1);
                    }
                    ++this.position;
                    cArray[n3] = (char)((n4 & 0x1F) << 6 | byteBuffer.get() & 0x3F);
                    break;
                }
                case 14: {
                    this.require(2);
                    this.position += 2;
                    byte by2 = byteBuffer.get();
                    byte by3 = byteBuffer.get();
                    cArray[n3] = (char)((n4 & 0xF) << 12 | (by2 & 0x3F) << 6 | by3 & 0x3F);
                }
            }
            ++n3;
        }
    }

    private String readAsciiString() {
        int n2;
        char[] cArray = this.chars;
        ByteBuffer byteBuffer = this.byteBuffer;
        int n3 = Math.min(cArray.length, this.limit - this.position);
        for (n2 = 0; n2 < n3; ++n2) {
            byte by2 = byteBuffer.get();
            if ((by2 & 0x80) == 128) {
                this.position = this.getBufferPosition(byteBuffer);
                cArray[n2] = (char)(by2 & 0x7F);
                return new String(cArray, 0, n2 + 1);
            }
            cArray[n2] = (char)by2;
        }
        this.position = this.getBufferPosition(byteBuffer);
        return this.readAscii_slow(n2);
    }

    private String readAscii_slow(int n2) {
        char[] cArray = this.chars;
        ByteBuffer byteBuffer = this.byteBuffer;
        while (true) {
            if (this.position == this.limit) {
                this.require(1);
            }
            ++this.position;
            byte by2 = byteBuffer.get();
            if (n2 == cArray.length) {
                char[] cArray2 = new char[n2 * 2];
                System.arraycopy(cArray, 0, cArray2, 0, n2);
                cArray = cArray2;
                this.chars = cArray2;
            }
            if ((by2 & 0x80) == 128) {
                cArray[n2] = (char)(by2 & 0x7F);
                return new String(cArray, 0, n2 + 1);
            }
            cArray[n2++] = (char)by2;
        }
    }

    @Override
    public int[] readInts(int n2) {
        int[] nArray = new int[n2];
        if (this.optional(n2 << 2) == n2 << 2) {
            ByteBuffer byteBuffer = this.byteBuffer;
            for (int i2 = 0; i2 < n2; ++i2) {
                nArray[i2] = byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8 | (byteBuffer.get() & 0xFF) << 16 | (byteBuffer.get() & 0xFF) << 24;
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                nArray[i3] = this.readInt();
            }
        }
        return nArray;
    }

    @Override
    public long[] readLongs(int n2) {
        long[] lArray = new long[n2];
        if (this.optional(n2 << 3) == n2 << 3) {
            ByteBuffer byteBuffer = this.byteBuffer;
            for (int i2 = 0; i2 < n2; ++i2) {
                lArray[i2] = (long)(byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8 | (byteBuffer.get() & 0xFF) << 16) | (long)(byteBuffer.get() & 0xFF) << 24 | (long)(byteBuffer.get() & 0xFF) << 32 | (long)(byteBuffer.get() & 0xFF) << 40 | (long)(byteBuffer.get() & 0xFF) << 48 | (long)byteBuffer.get() << 56;
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                lArray[i3] = this.readLong();
            }
        }
        return lArray;
    }

    @Override
    public float[] readFloats(int n2) {
        float[] fArray = new float[n2];
        if (this.optional(n2 << 2) == n2 << 2) {
            ByteBuffer byteBuffer = this.byteBuffer;
            for (int i2 = 0; i2 < n2; ++i2) {
                fArray[i2] = Float.intBitsToFloat(byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8 | (byteBuffer.get() & 0xFF) << 16 | (byteBuffer.get() & 0xFF) << 24);
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                fArray[i3] = this.readFloat();
            }
        }
        return fArray;
    }

    @Override
    public double[] readDoubles(int n2) {
        double[] dArray = new double[n2];
        if (this.optional(n2 << 3) == n2 << 3) {
            ByteBuffer byteBuffer = this.byteBuffer;
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray[i2] = Double.longBitsToDouble((long)(byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8 | (byteBuffer.get() & 0xFF) << 16) | (long)(byteBuffer.get() & 0xFF) << 24 | (long)(byteBuffer.get() & 0xFF) << 32 | (long)(byteBuffer.get() & 0xFF) << 40 | (long)(byteBuffer.get() & 0xFF) << 48 | (long)byteBuffer.get() << 56);
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                dArray[i3] = this.readDouble();
            }
        }
        return dArray;
    }

    @Override
    public short[] readShorts(int n2) {
        short[] sArray = new short[n2];
        if (this.optional(n2 << 1) == n2 << 1) {
            ByteBuffer byteBuffer = this.byteBuffer;
            for (int i2 = 0; i2 < n2; ++i2) {
                sArray[i2] = (short)(byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8);
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                sArray[i3] = this.readShort();
            }
        }
        return sArray;
    }

    @Override
    public char[] readChars(int n2) {
        char[] cArray = new char[n2];
        if (this.optional(n2 << 1) == n2 << 1) {
            ByteBuffer byteBuffer = this.byteBuffer;
            for (int i2 = 0; i2 < n2; ++i2) {
                cArray[i2] = (char)(byteBuffer.get() & 0xFF | (byteBuffer.get() & 0xFF) << 8);
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                cArray[i3] = this.readChar();
            }
        }
        return cArray;
    }

    @Override
    public boolean[] readBooleans(int n2) {
        boolean[] blArray = new boolean[n2];
        if (this.optional(n2) == n2) {
            ByteBuffer byteBuffer = this.byteBuffer;
            for (int i2 = 0; i2 < n2; ++i2) {
                blArray[i2] = byteBuffer.get() != 0;
            }
            this.position = this.getBufferPosition(byteBuffer);
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                blArray[i3] = this.readBoolean();
            }
        }
        return blArray;
    }
}

