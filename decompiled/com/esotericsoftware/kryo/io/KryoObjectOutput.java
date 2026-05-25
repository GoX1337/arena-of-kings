/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.io;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.KryoDataOutput;
import com.esotericsoftware.kryo.io.Output;
import java.io.ObjectOutput;

public class KryoObjectOutput
extends KryoDataOutput
implements ObjectOutput {
    private final Kryo kryo;

    public KryoObjectOutput(Kryo kryo, Output output) {
        super(output);
        this.kryo = kryo;
    }

    @Override
    public void writeObject(Object object) {
        this.kryo.writeClassAndObject(this.output, object);
    }

    @Override
    public void flush() {
        this.output.flush();
    }

    @Override
    public void close() {
        this.output.close();
    }
}

