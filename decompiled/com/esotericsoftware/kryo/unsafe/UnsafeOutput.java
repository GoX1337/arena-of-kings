/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.unsafe;

import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.unsafe.UnsafeUtil;
import java.io.OutputStream;

public class UnsafeOutput
extends Output {
    public UnsafeOutput() {
    }

    public UnsafeOutput(int n2) {
        this(n2, n2);
    }

    public UnsafeOutput(int n2, int n3) {
        super(n2, n3);
    }

    public UnsafeOutput(byte[] byArray) {
        this(byArray, byArray.length);
    }

    public UnsafeOutput(byte[] byArray, int n2) {
        super(byArray, n2);
    }

    public UnsafeOutput(OutputStream outputStream) {
        super(outputStream);
    }

    public UnsafeOutput(OutputStream outputStream, int n2) {
        super(outputStream, n2);
    }

    @Override
    public void write(int n2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        UnsafeUtil.unsafe.putByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position++, (byte)n2);
    }

    @Override
    public void writeByte(byte by2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        UnsafeUtil.unsafe.putByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position++, by2);
    }

    @Override
    public void writeByte(int n2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        UnsafeUtil.unsafe.putByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position++, (byte)n2);
    }

    @Override
    public void writeInt(int n2) {
        this.require(4);
        UnsafeUtil.unsafe.putInt(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, n2);
        this.position += 4;
    }

    @Override
    public void writeLong(long l2) {
        this.require(8);
        UnsafeUtil.unsafe.putLong(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, l2);
        this.position += 8;
    }

    @Override
    public void writeFloat(float f2) {
        this.require(4);
        UnsafeUtil.unsafe.putFloat(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, f2);
        this.position += 4;
    }

    @Override
    public void writeDouble(double d2) {
        this.require(8);
        UnsafeUtil.unsafe.putDouble(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, d2);
        this.position += 8;
    }

    @Override
    public void writeShort(int n2) {
        this.require(2);
        UnsafeUtil.unsafe.putShort(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, (short)n2);
        this.position += 2;
    }

    @Override
    public void writeChar(char c2) {
        this.require(2);
        UnsafeUtil.unsafe.putChar(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, c2);
        this.position += 2;
    }

    @Override
    public void writeBoolean(boolean bl2) {
        if (this.position == this.capacity) {
            this.require(1);
        }
        UnsafeUtil.unsafe.putByte(this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position++, bl2 ? (byte)1 : 0);
    }

    @Override
    public void writeInts(int[] nArray, int n2, int n3) {
        this.writeBytes(nArray, UnsafeUtil.intArrayBaseOffset, nArray.length << 2);
    }

    @Override
    public void writeLongs(long[] lArray, int n2, int n3) {
        this.writeBytes(lArray, UnsafeUtil.longArrayBaseOffset, lArray.length << 3);
    }

    @Override
    public void writeFloats(float[] fArray, int n2, int n3) {
        this.writeBytes(fArray, UnsafeUtil.floatArrayBaseOffset, fArray.length << 2);
    }

    @Override
    public void writeDoubles(double[] dArray, int n2, int n3) {
        this.writeBytes(dArray, UnsafeUtil.doubleArrayBaseOffset, dArray.length << 3);
    }

    @Override
    public void writeShorts(short[] sArray, int n2, int n3) {
        this.writeBytes(sArray, UnsafeUtil.shortArrayBaseOffset, sArray.length << 1);
    }

    @Override
    public void writeChars(char[] cArray, int n2, int n3) {
        this.writeBytes(cArray, UnsafeUtil.charArrayBaseOffset, cArray.length << 1);
    }

    @Override
    public void writeBooleans(boolean[] blArray, int n2, int n3) {
        this.writeBytes(blArray, UnsafeUtil.booleanArrayBaseOffset, blArray.length);
    }

    @Override
    public void writeBytes(byte[] byArray, int n2, int n3) {
        this.writeBytes((Object)byArray, UnsafeUtil.byteArrayBaseOffset + (long)n2, n3);
    }

    public void writeBytes(Object object, long l2, int n2) {
        int n3 = Math.min(this.capacity - this.position, n2);
        while (true) {
            UnsafeUtil.unsafe.copyMemory(object, l2, this.buffer, UnsafeUtil.byteArrayBaseOffset + (long)this.position, n3);
            this.position += n3;
            if ((n2 -= n3) == 0) break;
            l2 += (long)n3;
            n3 = Math.min(this.capacity, n2);
            this.require(n3);
        }
    }
}

