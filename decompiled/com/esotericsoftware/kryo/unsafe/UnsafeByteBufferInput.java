/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.unsafe;

import com.esotericsoftware.kryo.io.ByteBufferInput;
import com.esotericsoftware.kryo.unsafe.UnsafeUtil;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import sun.nio.ch.DirectBuffer;

public class UnsafeByteBufferInput
extends ByteBufferInput {
    private long bufferAddress;

    public UnsafeByteBufferInput() {
    }

    public UnsafeByteBufferInput(int n2) {
        super(n2);
        this.updateBufferAddress();
    }

    public UnsafeByteBufferInput(byte[] byArray) {
        super(byArray);
        this.updateBufferAddress();
    }

    public UnsafeByteBufferInput(byte[] byArray, int n2, int n3) {
        super(byArray, n2, n3);
        this.updateBufferAddress();
    }

    public UnsafeByteBufferInput(ByteBuffer byteBuffer) {
        super(byteBuffer);
        this.updateBufferAddress();
    }

    public UnsafeByteBufferInput(long l2, int n2) {
        super(UnsafeUtil.newDirectBuffer(l2, n2));
        this.updateBufferAddress();
    }

    public UnsafeByteBufferInput(InputStream inputStream) {
        super(inputStream);
        this.updateBufferAddress();
    }

    public UnsafeByteBufferInput(InputStream inputStream, int n2) {
        super(inputStream, n2);
        this.updateBufferAddress();
    }

    @Override
    public void setBuffer(ByteBuffer byteBuffer) {
        if (!(byteBuffer instanceof DirectBuffer)) {
            throw new IllegalArgumentException("buffer must be direct.");
        }
        if (byteBuffer != this.byteBuffer) {
            UnsafeUtil.dispose(this.byteBuffer);
        }
        super.setBuffer(byteBuffer);
        this.updateBufferAddress();
    }

    private void updateBufferAddress() {
        this.bufferAddress = ((DirectBuffer)((Object)this.byteBuffer)).address();
    }

    private void setBufferPosition(Buffer buffer, int n2) {
        buffer.position(n2);
    }

    @Override
    public int read() {
        if (this.optional(1) <= 0) {
            return -1;
        }
        int n2 = UnsafeUtil.unsafe.getByte(this.bufferAddress + (long)this.position++) & 0xFF;
        this.setBufferPosition(this.byteBuffer, this.position);
        return n2;
    }

    @Override
    public byte readByte() {
        if (this.position == this.limit) {
            this.require(1);
        }
        byte by2 = UnsafeUtil.unsafe.getByte(this.bufferAddress + (long)this.position++);
        this.setBufferPosition(this.byteBuffer, this.position);
        return by2;
    }

    @Override
    public int readByteUnsigned() {
        if (this.position == this.limit) {
            this.require(1);
        }
        int n2 = UnsafeUtil.unsafe.getByte(this.bufferAddress + (long)this.position++) & 0xFF;
        this.setBufferPosition(this.byteBuffer, this.position);
        return n2;
    }

    @Override
    public int readInt() {
        this.require(4);
        int n2 = UnsafeUtil.unsafe.getInt(this.bufferAddress + (long)this.position);
        this.position += 4;
        this.setBufferPosition(this.byteBuffer, this.position);
        return n2;
    }

    @Override
    public long readLong() {
        this.require(8);
        long l2 = UnsafeUtil.unsafe.getLong(this.bufferAddress + (long)this.position);
        this.position += 8;
        this.setBufferPosition(this.byteBuffer, this.position);
        return l2;
    }

    @Override
    public float readFloat() {
        this.require(4);
        float f2 = UnsafeUtil.unsafe.getFloat(this.bufferAddress + (long)this.position);
        this.position += 4;
        this.setBufferPosition(this.byteBuffer, this.position);
        return f2;
    }

    @Override
    public double readDouble() {
        this.require(8);
        double d2 = UnsafeUtil.unsafe.getDouble(this.bufferAddress + (long)this.position);
        this.position += 8;
        this.setBufferPosition(this.byteBuffer, this.position);
        return d2;
    }

    @Override
    public short readShort() {
        this.require(2);
        short s2 = UnsafeUtil.unsafe.getShort(this.bufferAddress + (long)this.position);
        this.position += 2;
        this.setBufferPosition(this.byteBuffer, this.position);
        return s2;
    }

    @Override
    public char readChar() {
        this.require(2);
        char c2 = UnsafeUtil.unsafe.getChar(this.bufferAddress + (long)this.position);
        this.position += 2;
        this.setBufferPosition(this.byteBuffer, this.position);
        return c2;
    }

    @Override
    public boolean readBoolean() {
        if (this.position == this.limit) {
            this.require(1);
        }
        boolean bl2 = UnsafeUtil.unsafe.getByte(this.bufferAddress + (long)this.position++) != 0;
        this.setBufferPosition(this.byteBuffer, this.position);
        return bl2;
    }

    @Override
    public int[] readInts(int n2) {
        int[] nArray = new int[n2];
        this.readBytes(nArray, UnsafeUtil.intArrayBaseOffset, n2 << 2);
        return nArray;
    }

    @Override
    public long[] readLongs(int n2) {
        long[] lArray = new long[n2];
        this.readBytes(lArray, UnsafeUtil.longArrayBaseOffset, n2 << 3);
        return lArray;
    }

    @Override
    public float[] readFloats(int n2) {
        float[] fArray = new float[n2];
        this.readBytes(fArray, UnsafeUtil.floatArrayBaseOffset, n2 << 2);
        return fArray;
    }

    @Override
    public double[] readDoubles(int n2) {
        double[] dArray = new double[n2];
        this.readBytes(dArray, UnsafeUtil.doubleArrayBaseOffset, n2 << 3);
        return dArray;
    }

    @Override
    public short[] readShorts(int n2) {
        short[] sArray = new short[n2];
        this.readBytes(sArray, UnsafeUtil.shortArrayBaseOffset, n2 << 1);
        return sArray;
    }

    @Override
    public char[] readChars(int n2) {
        char[] cArray = new char[n2];
        this.readBytes(cArray, UnsafeUtil.charArrayBaseOffset, n2 << 1);
        return cArray;
    }

    @Override
    public boolean[] readBooleans(int n2) {
        boolean[] blArray = new boolean[n2];
        this.readBytes(blArray, UnsafeUtil.booleanArrayBaseOffset, n2);
        return blArray;
    }

    @Override
    public void readBytes(byte[] byArray, int n2, int n3) {
        this.readBytes((Object)byArray, UnsafeUtil.byteArrayBaseOffset + (long)n2, n3);
    }

    public void readBytes(Object object, long l2, int n2) {
        int n3 = Math.min(this.limit - this.position, n2);
        while (true) {
            UnsafeUtil.unsafe.copyMemory(null, this.bufferAddress + (long)this.position, object, l2, n3);
            this.position += n3;
            if ((n2 -= n3) == 0) break;
            l2 += (long)n3;
            n3 = Math.min(n2, this.capacity);
            this.require(n3);
        }
        this.setBufferPosition(this.byteBuffer, this.position);
    }
}

