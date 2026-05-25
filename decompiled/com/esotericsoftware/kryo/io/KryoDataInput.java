/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import java.io.DataInput;
import java.io.EOFException;

public class KryoDataInput
implements DataInput,
AutoCloseable {
    protected Input input;

    public KryoDataInput(Input input) {
        this.input = input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    @Override
    public void readFully(byte[] byArray) {
        this.readFully(byArray, 0, byArray.length);
    }

    @Override
    public void readFully(byte[] byArray, int n2, int n3) {
        try {
            this.input.readBytes(byArray, n2, n3);
        }
        catch (KryoException kryoException) {
            throw new EOFException(kryoException.getMessage());
        }
    }

    @Override
    public int skipBytes(int n2) {
        return (int)this.input.skip((long)n2);
    }

    @Override
    public boolean readBoolean() {
        return this.input.readBoolean();
    }

    @Override
    public byte readByte() {
        return this.input.readByte();
    }

    @Override
    public int readUnsignedByte() {
        return this.input.readByteUnsigned();
    }

    @Override
    public short readShort() {
        return this.input.readShort();
    }

    @Override
    public int readUnsignedShort() {
        return this.input.readShortUnsigned();
    }

    @Override
    public char readChar() {
        return this.input.readChar();
    }

    @Override
    public int readInt() {
        return this.input.readInt();
    }

    @Override
    public long readLong() {
        return this.input.readLong();
    }

    @Override
    public float readFloat() {
        return this.input.readFloat();
    }

    @Override
    public double readDouble() {
        return this.input.readDouble();
    }

    @Override
    public String readLine() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String readUTF() {
        return this.input.readString();
    }

    @Override
    public void close() {
        this.input.close();
    }
}

