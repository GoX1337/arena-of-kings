/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

public class LittleEndianInputStream
extends FilterInputStream
implements DataInput {
    private DataInputStream din;

    public LittleEndianInputStream(InputStream inputStream) {
        super(inputStream);
        this.din = new DataInputStream(inputStream);
    }

    @Override
    public void readFully(byte[] byArray) {
        this.din.readFully(byArray);
    }

    @Override
    public void readFully(byte[] byArray, int n2, int n3) {
        this.din.readFully(byArray, n2, n3);
    }

    @Override
    public int skipBytes(int n2) {
        return this.din.skipBytes(n2);
    }

    @Override
    public boolean readBoolean() {
        return this.din.readBoolean();
    }

    @Override
    public byte readByte() {
        return this.din.readByte();
    }

    @Override
    public int readUnsignedByte() {
        return this.din.readUnsignedByte();
    }

    @Override
    public short readShort() {
        int n2 = this.din.read();
        int n3 = this.din.read();
        return (short)(n3 << 8 | n2 & 0xFF);
    }

    @Override
    public int readUnsignedShort() {
        int n2 = this.din.read();
        int n3 = this.din.read();
        return (n3 & 0xFF) << 8 | n2 & 0xFF;
    }

    @Override
    public char readChar() {
        return this.din.readChar();
    }

    @Override
    public int readInt() {
        int[] nArray = new int[4];
        for (int i2 = 3; i2 >= 0; --i2) {
            nArray[i2] = this.din.read();
        }
        return (nArray[0] & 0xFF) << 24 | (nArray[1] & 0xFF) << 16 | (nArray[2] & 0xFF) << 8 | nArray[3] & 0xFF;
    }

    @Override
    public long readLong() {
        int[] nArray = new int[8];
        for (int i2 = 7; i2 >= 0; --i2) {
            nArray[i2] = this.din.read();
        }
        return (long)(nArray[0] & 0xFF) << 56 | (long)(nArray[1] & 0xFF) << 48 | (long)(nArray[2] & 0xFF) << 40 | (long)(nArray[3] & 0xFF) << 32 | (long)(nArray[4] & 0xFF) << 24 | (long)(nArray[5] & 0xFF) << 16 | (long)(nArray[6] & 0xFF) << 8 | (long)(nArray[7] & 0xFF);
    }

    @Override
    public float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public double readDouble() {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override
    public final String readLine() {
        return this.din.readLine();
    }

    @Override
    public String readUTF() {
        return this.din.readUTF();
    }
}

