/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.unsafe;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.unsafe.UnsafeUtil;
import java.io.InputStream;

public class UnsafeInput
extends Input {
    public UnsafeInput() {
    }

    public UnsafeInput(int n2) {
        super(n2);
    }

    public UnsafeInput(byte[] byArray) {
        super(byArray);
    }

    public UnsafeInput(byte[] byArray, int n2, int n3) {
        super(byArray, n2, n3);
    }

    public UnsafeInput(InputStream inputStream) {
        super(inputStream);
    }

    public UnsafeInput(InputStream inputStream, int n2) {
        super(inputStream, n2);
    }

    @Override
    public int read() {
        if (this.optional(1) <= 0) {
            return -1;
        }
        return UnsafeUtil.unsafe.getByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position++) & 0xFF;
    }

    @Override
    public byte readByte() {
        if (this.position == this.limit) {
            this.require(1);
        }
        return UnsafeUtil.unsafe.getByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position++);
    }

    @Override
    public int readByteUnsigned() {
        if (this.position == this.limit) {
            this.require(1);
        }
        return UnsafeUtil.unsafe.getByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position++) & 0xFF;
    }

    @Override
    public int readInt() {
        this.require(4);
        int n2 = UnsafeUtil.unsafe.getInt(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position += 4;
        return n2;
    }

    @Override
    public long readLong() {
        this.require(8);
        long l2 = UnsafeUtil.unsafe.getLong(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position += 8;
        return l2;
    }

    @Override
    public float readFloat() {
        this.require(4);
        float f2 = UnsafeUtil.unsafe.getFloat(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position += 4;
        return f2;
    }

    @Override
    public double readDouble() {
        this.require(8);
        double d2 = UnsafeUtil.unsafe.getDouble(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position += 8;
        return d2;
    }

    @Override
    public short readShort() {
        this.require(2);
        short s2 = UnsafeUtil.unsafe.getShort(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position += 2;
        return s2;
    }

    @Override
    public char readChar() {
        this.require(2);
        char c2 = UnsafeUtil.unsafe.getChar(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position);
        this.position += 2;
        return c2;
    }

    @Override
    public boolean readBoolean() {
        if (this.position == this.limit) {
            this.require(1);
        }
        boolean bl2 = UnsafeUtil.unsafe.getByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position++) != 0;
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
            UnsafeUtil.unsafe.copyMemory(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, object, l2, n3);
            this.position += n3;
            if ((n2 -= n3) == 0) break;
            l2 += (long)n3;
            n3 = Math.min(n2, this.capacity);
            this.require(n3);
        }
    }
}

