/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.Pool;
import java.io.IOException;
import java.io.InputStream;

public class Input
extends InputStream
implements Pool.Poolable {
    protected byte[] buffer;
    protected int position;
    protected int capacity;
    protected int limit;
    protected long total;
    protected char[] chars = new char[32];
    protected InputStream inputStream;
    protected boolean varEncoding = true;

    public Input() {
    }

    public Input(int n2) {
        this.capacity = n2;
        this.buffer = new byte[n2];
    }

    public Input(byte[] byArray) {
        this.setBuffer(byArray, 0, byArray.length);
    }

    public Input(byte[] byArray, int n2, int n3) {
        this.setBuffer(byArray, n2, n3);
    }

    public Input(InputStream inputStream) {
        this(4096);
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null.");
        }
        this.inputStream = inputStream;
    }

    public Input(InputStream inputStream, int n2) {
        this(n2);
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null.");
        }
        this.inputStream = inputStream;
    }

    public void setBuffer(byte[] byArray) {
        this.setBuffer(byArray, 0, byArray.length);
    }

    public void setBuffer(byte[] byArray, int n2, int n3) {
        if (byArray == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        this.buffer = byArray;
        this.position = n2;
        this.limit = n2 + n3;
        this.capacity = byArray.length;
        this.total = 0L;
        this.inputStream = null;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        this.limit = 0;
        this.reset();
    }

    public boolean getVariableLengthEncoding() {
        return this.varEncoding;
    }

    public void setVariableLengthEncoding(boolean bl2) {
        this.varEncoding = bl2;
    }

    public long total() {
        return this.total + (long)this.position;
    }

    public void setTotal(long l2) {
        this.total = l2;
    }

    public int position() {
        return this.position;
    }

    public void setPosition(int n2) {
        this.position = n2;
    }

    public int limit() {
        return this.limit;
    }

    public void setLimit(int n2) {
        this.limit = n2;
    }

    @Override
    public void reset() {
        this.position = 0;
        this.total = 0L;
    }

    public void skip(int n2) {
        int n3 = Math.min(this.limit - this.position, n2);
        while (true) {
            this.position += n3;
            if ((n2 -= n3) == 0) break;
            n3 = Math.min(n2, this.capacity);
            this.require(n3);
        }
    }

    protected int fill(byte[] byArray, int n2, int n3) {
        if (this.inputStream == null) {
            return -1;
        }
        try {
            return this.inputStream.read(byArray, n2, n3);
        }
        catch (IOException iOException) {
            throw new KryoException(iOException);
        }
    }

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
            n3 = this.fill(this.buffer, this.limit, this.capacity - this.limit);
            if (n3 == -1) {
                throw new KryoException("Buffer underflow.");
            }
            if ((n4 += n3) >= n2) {
                this.limit += n3;
                return n4;
            }
        }
        System.arraycopy(this.buffer, this.position, this.buffer, 0, n4);
        this.total += (long)this.position;
        this.position = 0;
        do {
            if ((n3 = this.fill(this.buffer, n4, this.capacity - n4)) != -1) continue;
            if (n4 >= n2) break;
            throw new KryoException("Buffer underflow.");
        } while ((n4 += n3) < n2);
        this.limit = n4;
        return n4;
    }

    protected int optional(int n2) {
        int n3 = this.limit - this.position;
        if (n3 >= n2) {
            return n2;
        }
        n2 = Math.min(n2, this.capacity);
        int n4 = this.fill(this.buffer, this.limit, this.capacity - this.limit);
        if (n4 == -1) {
            return n3 == 0 ? -1 : Math.min(n3, n2);
        }
        if ((n3 += n4) >= n2) {
            this.limit += n4;
            return n2;
        }
        System.arraycopy(this.buffer, this.position, this.buffer, 0, n3);
        this.total += (long)this.position;
        this.position = 0;
        while ((n4 = this.fill(this.buffer, n3, this.capacity - n3)) != -1 && (n3 += n4) < n2) {
        }
        this.limit = n3;
        return n3 == 0 ? -1 : Math.min(n3, n2);
    }

    public boolean end() {
        return this.optional(1) <= 0;
    }

    @Override
    public int available() {
        return this.limit - this.position + (this.inputStream != null ? this.inputStream.available() : 0);
    }

    @Override
    public int read() {
        if (this.optional(1) <= 0) {
            return -1;
        }
        return this.buffer[this.position++] & 0xFF;
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
            System.arraycopy(this.buffer, this.position, byArray, n2, n5);
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

    public byte readByte() {
        if (this.position == this.limit) {
            this.require(1);
        }
        return this.buffer[this.position++];
    }

    public int readByteUnsigned() {
        if (this.position == this.limit) {
            this.require(1);
        }
        return this.buffer[this.position++] & 0xFF;
    }

    public byte[] readBytes(int n2) {
        byte[] byArray = new byte[n2];
        this.readBytes(byArray, 0, n2);
        return byArray;
    }

    public void readBytes(byte[] byArray) {
        this.readBytes(byArray, 0, byArray.length);
    }

    public void readBytes(byte[] byArray, int n2, int n3) {
        if (byArray == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        int n4 = Math.min(this.limit - this.position, n3);
        while (true) {
            System.arraycopy(this.buffer, this.position, byArray, n2, n4);
            this.position += n4;
            if ((n3 -= n4) == 0) break;
            n2 += n4;
            n4 = Math.min(n3, this.capacity);
            this.require(n4);
        }
    }

    public int readInt() {
        this.require(4);
        byte[] byArray = this.buffer;
        int n2 = this.position;
        this.position = n2 + 4;
        return byArray[n2] & 0xFF | (byArray[n2 + 1] & 0xFF) << 8 | (byArray[n2 + 2] & 0xFF) << 16 | (byArray[n2 + 3] & 0xFF) << 24;
    }

    public int readInt(boolean bl2) {
        if (this.varEncoding) {
            return this.readVarInt(bl2);
        }
        return this.readInt();
    }

    public boolean canReadInt() {
        if (this.varEncoding) {
            return this.canReadVarInt();
        }
        if (this.limit - this.position >= 4) {
            return true;
        }
        return this.optional(4) == 4;
    }

    public int readVarInt(boolean bl2) {
        if (this.require(1) < 5) {
            return this.readVarInt_slow(bl2);
        }
        byte by2 = this.buffer[this.position++];
        int n2 = by2 & 0x7F;
        if ((by2 & 0x80) != 0) {
            byte[] byArray = this.buffer;
            int n3 = this.position;
            by2 = byArray[n3++];
            n2 |= (by2 & 0x7F) << 7;
            if ((by2 & 0x80) != 0) {
                by2 = byArray[n3++];
                n2 |= (by2 & 0x7F) << 14;
                if ((by2 & 0x80) != 0) {
                    by2 = byArray[n3++];
                    n2 |= (by2 & 0x7F) << 21;
                    if ((by2 & 0x80) != 0) {
                        by2 = byArray[n3++];
                        n2 |= (by2 & 0x7F) << 28;
                    }
                }
            }
            this.position = n3;
        }
        return bl2 ? n2 : n2 >>> 1 ^ -(n2 & 1);
    }

    private int readVarInt_slow(boolean bl2) {
        byte by2 = this.buffer[this.position++];
        int n2 = by2 & 0x7F;
        if ((by2 & 0x80) != 0) {
            if (this.position == this.limit) {
                this.require(1);
            }
            byte[] byArray = this.buffer;
            by2 = byArray[this.position++];
            n2 |= (by2 & 0x7F) << 7;
            if ((by2 & 0x80) != 0) {
                if (this.position == this.limit) {
                    this.require(1);
                }
                by2 = byArray[this.position++];
                n2 |= (by2 & 0x7F) << 14;
                if ((by2 & 0x80) != 0) {
                    if (this.position == this.limit) {
                        this.require(1);
                    }
                    by2 = byArray[this.position++];
                    n2 |= (by2 & 0x7F) << 21;
                    if ((by2 & 0x80) != 0) {
                        if (this.position == this.limit) {
                            this.require(1);
                        }
                        by2 = byArray[this.position++];
                        n2 |= (by2 & 0x7F) << 28;
                    }
                }
            }
        }
        return bl2 ? n2 : n2 >>> 1 ^ -(n2 & 1);
    }

    public boolean canReadVarInt() {
        if (this.limit - this.position >= 5) {
            return true;
        }
        if (this.optional(5) <= 0) {
            return false;
        }
        int n2 = this.position;
        int n3 = this.limit;
        byte[] byArray = this.buffer;
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        return n2 != n3;
    }

    public boolean readVarIntFlag() {
        if (this.position == this.limit) {
            this.require(1);
        }
        return (this.buffer[this.position] & 0x80) != 0;
    }

    public int readVarIntFlag(boolean bl2) {
        if (this.require(1) < 5) {
            return this.readVarIntFlag_slow(bl2);
        }
        byte by2 = this.buffer[this.position++];
        int n2 = by2 & 0x3F;
        if ((by2 & 0x40) != 0) {
            byte[] byArray = this.buffer;
            int n3 = this.position;
            by2 = byArray[n3++];
            n2 |= (by2 & 0x7F) << 6;
            if ((by2 & 0x80) != 0) {
                by2 = byArray[n3++];
                n2 |= (by2 & 0x7F) << 13;
                if ((by2 & 0x80) != 0) {
                    by2 = byArray[n3++];
                    n2 |= (by2 & 0x7F) << 20;
                    if ((by2 & 0x80) != 0) {
                        by2 = byArray[n3++];
                        n2 |= (by2 & 0x7F) << 27;
                    }
                }
            }
            this.position = n3;
        }
        return bl2 ? n2 : n2 >>> 1 ^ -(n2 & 1);
    }

    private int readVarIntFlag_slow(boolean bl2) {
        byte by2 = this.buffer[this.position++];
        int n2 = by2 & 0x3F;
        if ((by2 & 0x40) != 0) {
            if (this.position == this.limit) {
                this.require(1);
            }
            byte[] byArray = this.buffer;
            by2 = byArray[this.position++];
            n2 |= (by2 & 0x7F) << 6;
            if ((by2 & 0x80) != 0) {
                if (this.position == this.limit) {
                    this.require(1);
                }
                by2 = byArray[this.position++];
                n2 |= (by2 & 0x7F) << 13;
                if ((by2 & 0x80) != 0) {
                    if (this.position == this.limit) {
                        this.require(1);
                    }
                    by2 = byArray[this.position++];
                    n2 |= (by2 & 0x7F) << 20;
                    if ((by2 & 0x80) != 0) {
                        if (this.position == this.limit) {
                            this.require(1);
                        }
                        by2 = byArray[this.position++];
                        n2 |= (by2 & 0x7F) << 27;
                    }
                }
            }
        }
        return bl2 ? n2 : n2 >>> 1 ^ -(n2 & 1);
    }

    public long readLong() {
        this.require(8);
        byte[] byArray = this.buffer;
        int n2 = this.position;
        this.position = n2 + 8;
        return (long)(byArray[n2] & 0xFF | (byArray[n2 + 1] & 0xFF) << 8 | (byArray[n2 + 2] & 0xFF) << 16) | (long)(byArray[n2 + 3] & 0xFF) << 24 | (long)(byArray[n2 + 4] & 0xFF) << 32 | (long)(byArray[n2 + 5] & 0xFF) << 40 | (long)(byArray[n2 + 6] & 0xFF) << 48 | (long)byArray[n2 + 7] << 56;
    }

    public long readLong(boolean bl2) {
        if (this.varEncoding) {
            return this.readVarLong(bl2);
        }
        return this.readLong();
    }

    public long readVarLong(boolean bl2) {
        if (this.require(1) < 9) {
            return this.readVarLong_slow(bl2);
        }
        int n2 = this.position;
        byte by2 = this.buffer[n2++];
        long l2 = by2 & 0x7F;
        if ((by2 & 0x80) != 0) {
            byte[] byArray = this.buffer;
            by2 = byArray[n2++];
            l2 |= (long)((by2 & 0x7F) << 7);
            if ((by2 & 0x80) != 0) {
                by2 = byArray[n2++];
                l2 |= (long)((by2 & 0x7F) << 14);
                if ((by2 & 0x80) != 0) {
                    by2 = byArray[n2++];
                    l2 |= (long)((by2 & 0x7F) << 21);
                    if ((by2 & 0x80) != 0) {
                        by2 = byArray[n2++];
                        l2 |= (long)(by2 & 0x7F) << 28;
                        if ((by2 & 0x80) != 0) {
                            by2 = byArray[n2++];
                            l2 |= (long)(by2 & 0x7F) << 35;
                            if ((by2 & 0x80) != 0) {
                                by2 = byArray[n2++];
                                l2 |= (long)(by2 & 0x7F) << 42;
                                if ((by2 & 0x80) != 0) {
                                    by2 = byArray[n2++];
                                    l2 |= (long)(by2 & 0x7F) << 49;
                                    if ((by2 & 0x80) != 0) {
                                        by2 = byArray[n2++];
                                        l2 |= (long)by2 << 56;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.position = n2;
        return bl2 ? l2 : l2 >>> 1 ^ -(l2 & 1L);
    }

    private long readVarLong_slow(boolean bl2) {
        byte by2 = this.buffer[this.position++];
        long l2 = by2 & 0x7F;
        if ((by2 & 0x80) != 0) {
            if (this.position == this.limit) {
                this.require(1);
            }
            byte[] byArray = this.buffer;
            by2 = byArray[this.position++];
            l2 |= (long)((by2 & 0x7F) << 7);
            if ((by2 & 0x80) != 0) {
                if (this.position == this.limit) {
                    this.require(1);
                }
                by2 = byArray[this.position++];
                l2 |= (long)((by2 & 0x7F) << 14);
                if ((by2 & 0x80) != 0) {
                    if (this.position == this.limit) {
                        this.require(1);
                    }
                    by2 = byArray[this.position++];
                    l2 |= (long)((by2 & 0x7F) << 21);
                    if ((by2 & 0x80) != 0) {
                        if (this.position == this.limit) {
                            this.require(1);
                        }
                        by2 = byArray[this.position++];
                        l2 |= (long)(by2 & 0x7F) << 28;
                        if ((by2 & 0x80) != 0) {
                            if (this.position == this.limit) {
                                this.require(1);
                            }
                            by2 = byArray[this.position++];
                            l2 |= (long)(by2 & 0x7F) << 35;
                            if ((by2 & 0x80) != 0) {
                                if (this.position == this.limit) {
                                    this.require(1);
                                }
                                by2 = byArray[this.position++];
                                l2 |= (long)(by2 & 0x7F) << 42;
                                if ((by2 & 0x80) != 0) {
                                    if (this.position == this.limit) {
                                        this.require(1);
                                    }
                                    by2 = byArray[this.position++];
                                    l2 |= (long)(by2 & 0x7F) << 49;
                                    if ((by2 & 0x80) != 0) {
                                        if (this.position == this.limit) {
                                            this.require(1);
                                        }
                                        by2 = byArray[this.position++];
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

    public boolean canReadLong() {
        if (this.varEncoding) {
            return this.canReadVarLong();
        }
        if (this.limit - this.position >= 8) {
            return true;
        }
        return this.optional(8) == 8;
    }

    public boolean canReadVarLong() {
        if (this.limit - this.position >= 9) {
            return true;
        }
        if (this.optional(5) <= 0) {
            return false;
        }
        int n2 = this.position;
        int n3 = this.limit;
        byte[] byArray = this.buffer;
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        if (n2 == n3) {
            return false;
        }
        if ((byArray[n2++] & 0x80) == 0) {
            return true;
        }
        return n2 != n3;
    }

    public float readFloat() {
        this.require(4);
        byte[] byArray = this.buffer;
        int n2 = this.position;
        this.position = n2 + 4;
        return Float.intBitsToFloat(byArray[n2] & 0xFF | (byArray[n2 + 1] & 0xFF) << 8 | (byArray[n2 + 2] & 0xFF) << 16 | (byArray[n2 + 3] & 0xFF) << 24);
    }

    public float readVarFloat(float f2, boolean bl2) {
        return (float)this.readVarInt(bl2) / f2;
    }

    public double readDouble() {
        this.require(8);
        byte[] byArray = this.buffer;
        int n2 = this.position;
        this.position = n2 + 8;
        return Double.longBitsToDouble((long)(byArray[n2] & 0xFF | (byArray[n2 + 1] & 0xFF) << 8 | (byArray[n2 + 2] & 0xFF) << 16) | (long)(byArray[n2 + 3] & 0xFF) << 24 | (long)(byArray[n2 + 4] & 0xFF) << 32 | (long)(byArray[n2 + 5] & 0xFF) << 40 | (long)(byArray[n2 + 6] & 0xFF) << 48 | (long)byArray[n2 + 7] << 56);
    }

    public double readVarDouble(double d2, boolean bl2) {
        return (double)this.readVarLong(bl2) / d2;
    }

    public short readShort() {
        this.require(2);
        int n2 = this.position;
        this.position = n2 + 2;
        return (short)(this.buffer[n2] & 0xFF | (this.buffer[n2 + 1] & 0xFF) << 8);
    }

    public int readShortUnsigned() {
        this.require(2);
        int n2 = this.position;
        this.position = n2 + 2;
        return this.buffer[n2] & 0xFF | (this.buffer[n2 + 1] & 0xFF) << 8;
    }

    public char readChar() {
        this.require(2);
        int n2 = this.position;
        this.position = n2 + 2;
        return (char)(this.buffer[n2] & 0xFF | (this.buffer[n2 + 1] & 0xFF) << 8);
    }

    public boolean readBoolean() {
        if (this.position == this.limit) {
            this.require(1);
        }
        return this.buffer[this.position++] == 1;
    }

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
                return new StringBuilder(0);
            }
        }
        this.readUtf8Chars(--n2);
        StringBuilder stringBuilder = new StringBuilder(n2);
        stringBuilder.append(this.chars, 0, n2);
        return stringBuilder;
    }

    private void readUtf8Chars(int n2) {
        if (this.chars.length < n2) {
            this.chars = new char[n2];
        }
        byte[] byArray = this.buffer;
        char[] cArray = this.chars;
        int n3 = 0;
        int n4 = Math.min(this.require(1), n2);
        int n5 = this.position;
        while (n3 < n4) {
            byte by2;
            if ((by2 = byArray[n5++]) < 0) {
                --n5;
                break;
            }
            cArray[n3++] = (char)by2;
        }
        this.position = n5;
        if (n3 < n2) {
            this.readUtf8Chars_slow(n2, n3);
        }
    }

    private void readUtf8Chars_slow(int n2, int n3) {
        char[] cArray = this.chars;
        byte[] byArray = this.buffer;
        while (n3 < n2) {
            if (this.position == this.limit) {
                this.require(1);
            }
            int n4 = byArray[this.position++] & 0xFF;
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
                    cArray[n3] = (char)((n4 & 0x1F) << 6 | byArray[this.position++] & 0x3F);
                    break;
                }
                case 14: {
                    this.require(2);
                    int n5 = this.position;
                    this.position = n5 + 2;
                    cArray[n3] = (char)((n4 & 0xF) << 12 | (byArray[n5] & 0x3F) << 6 | byArray[n5 + 1] & 0x3F);
                }
            }
            ++n3;
        }
    }

    private String readAsciiString() {
        char[] cArray = this.chars;
        byte[] byArray = this.buffer;
        int n2 = this.position;
        int n3 = 0;
        int n4 = Math.min(cArray.length, this.limit - this.position);
        while (n3 < n4) {
            byte by2 = byArray[n2];
            if ((by2 & 0x80) == 128) {
                this.position = n2 + 1;
                cArray[n3] = (char)(by2 & 0x7F);
                return new String(cArray, 0, n3 + 1);
            }
            cArray[n3] = (char)by2;
            ++n3;
            ++n2;
        }
        this.position = n2;
        return this.readAscii_slow(n3);
    }

    private String readAscii_slow(int n2) {
        char[] cArray = this.chars;
        byte[] byArray = this.buffer;
        while (true) {
            if (this.position == this.limit) {
                this.require(1);
            }
            byte by2 = byArray[this.position++];
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

    public int[] readInts(int n2) {
        int[] nArray = new int[n2];
        if (this.optional(n2 << 2) == n2 << 2) {
            byte[] byArray = this.buffer;
            int n3 = this.position;
            int n4 = 0;
            while (n4 < n2) {
                nArray[n4] = byArray[n3] & 0xFF | (byArray[n3 + 1] & 0xFF) << 8 | (byArray[n3 + 2] & 0xFF) << 16 | (byArray[n3 + 3] & 0xFF) << 24;
                ++n4;
                n3 += 4;
            }
            this.position = n3;
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                nArray[i2] = this.readInt();
            }
        }
        return nArray;
    }

    public int[] readInts(int n2, boolean bl2) {
        if (this.varEncoding) {
            int[] nArray = new int[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                nArray[i2] = this.readVarInt(bl2);
            }
            return nArray;
        }
        return this.readInts(n2);
    }

    public long[] readLongs(int n2) {
        long[] lArray = new long[n2];
        if (this.optional(n2 << 3) == n2 << 3) {
            byte[] byArray = this.buffer;
            int n3 = this.position;
            int n4 = 0;
            while (n4 < n2) {
                lArray[n4] = (long)(byArray[n3] & 0xFF | (byArray[n3 + 1] & 0xFF) << 8 | (byArray[n3 + 2] & 0xFF) << 16) | (long)(byArray[n3 + 3] & 0xFF) << 24 | (long)(byArray[n3 + 4] & 0xFF) << 32 | (long)(byArray[n3 + 5] & 0xFF) << 40 | (long)(byArray[n3 + 6] & 0xFF) << 48 | (long)byArray[n3 + 7] << 56;
                ++n4;
                n3 += 8;
            }
            this.position = n3;
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                lArray[i2] = this.readLong();
            }
        }
        return lArray;
    }

    public long[] readLongs(int n2, boolean bl2) {
        if (this.varEncoding) {
            long[] lArray = new long[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                lArray[i2] = this.readVarLong(bl2);
            }
            return lArray;
        }
        return this.readLongs(n2);
    }

    public float[] readFloats(int n2) {
        float[] fArray = new float[n2];
        if (this.optional(n2 << 2) == n2 << 2) {
            byte[] byArray = this.buffer;
            int n3 = this.position;
            int n4 = 0;
            while (n4 < n2) {
                fArray[n4] = Float.intBitsToFloat(byArray[n3] & 0xFF | (byArray[n3 + 1] & 0xFF) << 8 | (byArray[n3 + 2] & 0xFF) << 16 | (byArray[n3 + 3] & 0xFF) << 24);
                ++n4;
                n3 += 4;
            }
            this.position = n3;
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                fArray[i2] = this.readFloat();
            }
        }
        return fArray;
    }

    public double[] readDoubles(int n2) {
        double[] dArray = new double[n2];
        if (this.optional(n2 << 3) == n2 << 3) {
            byte[] byArray = this.buffer;
            int n3 = this.position;
            int n4 = 0;
            while (n4 < n2) {
                dArray[n4] = Double.longBitsToDouble((long)(byArray[n3] & 0xFF | (byArray[n3 + 1] & 0xFF) << 8 | (byArray[n3 + 2] & 0xFF) << 16) | (long)(byArray[n3 + 3] & 0xFF) << 24 | (long)(byArray[n3 + 4] & 0xFF) << 32 | (long)(byArray[n3 + 5] & 0xFF) << 40 | (long)(byArray[n3 + 6] & 0xFF) << 48 | (long)byArray[n3 + 7] << 56);
                ++n4;
                n3 += 8;
            }
            this.position = n3;
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray[i2] = this.readDouble();
            }
        }
        return dArray;
    }

    public short[] readShorts(int n2) {
        short[] sArray = new short[n2];
        if (this.optional(n2 << 1) == n2 << 1) {
            byte[] byArray = this.buffer;
            int n3 = this.position;
            int n4 = 0;
            while (n4 < n2) {
                sArray[n4] = (short)(byArray[n3] & 0xFF | (byArray[n3 + 1] & 0xFF) << 8);
                ++n4;
                n3 += 2;
            }
            this.position = n3;
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                sArray[i2] = this.readShort();
            }
        }
        return sArray;
    }

    public char[] readChars(int n2) {
        char[] cArray = new char[n2];
        if (this.optional(n2 << 1) == n2 << 1) {
            byte[] byArray = this.buffer;
            int n3 = this.position;
            int n4 = 0;
            while (n4 < n2) {
                cArray[n4] = (char)(byArray[n3] & 0xFF | (byArray[n3 + 1] & 0xFF) << 8);
                ++n4;
                n3 += 2;
            }
            this.position = n3;
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                cArray[i2] = this.readChar();
            }
        }
        return cArray;
    }

    public boolean[] readBooleans(int n2) {
        boolean[] blArray = new boolean[n2];
        if (this.optional(n2) == n2) {
            byte[] byArray = this.buffer;
            int n3 = this.position;
            int n4 = 0;
            while (n4 < n2) {
                blArray[n4] = byArray[n3] != 0;
                ++n4;
                ++n3;
            }
            this.position = n3;
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                blArray[i2] = this.readBoolean();
            }
        }
        return blArray;
    }
}

