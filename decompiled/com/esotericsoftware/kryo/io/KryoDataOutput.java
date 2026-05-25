/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.io.Output;
import java.io.DataOutput;

public class KryoDataOutput
implements DataOutput,
AutoCloseable {
    protected Output output;

    public KryoDataOutput(Output output) {
        this.output = output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    @Override
    public void write(int n2) {
        this.output.write(n2);
    }

    @Override
    public void write(byte[] byArray) {
        this.output.write(byArray);
    }

    @Override
    public void write(byte[] byArray, int n2, int n3) {
        this.output.write(byArray, n2, n3);
    }

    @Override
    public void writeBoolean(boolean bl2) {
        this.output.writeBoolean(bl2);
    }

    @Override
    public void writeByte(int n2) {
        this.output.writeByte(n2);
    }

    @Override
    public void writeShort(int n2) {
        this.output.writeShort(n2);
    }

    @Override
    public void writeChar(int n2) {
        this.output.writeChar((char)n2);
    }

    @Override
    public void writeInt(int n2) {
        this.output.writeInt(n2);
    }

    @Override
    public void writeLong(long l2) {
        this.output.writeLong(l2);
    }

    @Override
    public void writeFloat(float f2) {
        this.output.writeFloat(f2);
    }

    @Override
    public void writeDouble(double d2) {
        this.output.writeDouble(d2);
    }

    @Override
    public void writeBytes(String string) {
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.output.write((byte)string.charAt(i2));
        }
    }

    @Override
    public void writeChars(String string) {
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            this.output.write(c2 & 0xFF);
            this.output.write(c2 >>> 8 & 0xFF);
        }
    }

    @Override
    public void writeUTF(String string) {
        this.output.writeString(string);
    }

    @Override
    public void close() {
        this.output.close();
    }
}

