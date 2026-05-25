/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.KryoDataInput;
import java.io.ObjectInput;

public class KryoObjectInput
extends KryoDataInput
implements ObjectInput {
    private final Kryo kryo;

    public KryoObjectInput(Kryo kryo, Input input) {
        super(input);
        this.kryo = kryo;
    }

    @Override
    public Object readObject() {
        return this.kryo.readClassAndObject(this.input);
    }

    @Override
    public int read() {
        return this.input.read();
    }

    @Override
    public int read(byte[] byArray) {
        return this.input.read(byArray);
    }

    @Override
    public int read(byte[] byArray, int n2, int n3) {
        return this.input.read(byArray, n2, n3);
    }

    @Override
    public long skip(long l2) {
        return this.input.skip(l2);
    }

    @Override
    public int available() {
        return 0;
    }

    @Override
    public void close() {
        this.input.close();
    }
}

