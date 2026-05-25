/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.ByteBufferInput;
import com.esotericsoftware.kryo.io.ByteBufferOutput;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.FrameworkMessage;
import com.esotericsoftware.kryonet.serialization.Serialization;
import java.nio.ByteBuffer;

public class KryoSerialization
implements Serialization {
    private final Kryo kryo;
    private final ByteBufferInput input;
    private final ByteBufferOutput output;

    public KryoSerialization() {
        this(new Kryo());
        this.kryo.setReferences(false);
        this.kryo.setRegistrationRequired(true);
    }

    public KryoSerialization(Kryo kryo) {
        this.kryo = kryo;
        this.kryo.register(FrameworkMessage.RegisterTCP.class);
        this.kryo.register(FrameworkMessage.RegisterUDP.class);
        this.kryo.register(FrameworkMessage.KeepAlive.class);
        this.kryo.register(FrameworkMessage.DiscoverHost.class);
        this.kryo.register(FrameworkMessage.Ping.class);
        this.input = new ByteBufferInput();
        this.output = new ByteBufferOutput();
    }

    public Kryo getKryo() {
        return this.kryo;
    }

    @Override
    public synchronized void write(Connection connection, ByteBuffer byteBuffer, Object object) {
        this.output.setBuffer(byteBuffer);
        this.kryo.getContext().put("connection", connection);
        this.kryo.writeClassAndObject(this.output, object);
        this.output.flush();
    }

    @Override
    public synchronized Object read(Connection connection, ByteBuffer byteBuffer) {
        this.input.setBuffer(byteBuffer);
        this.kryo.getContext().put("connection", connection);
        return this.kryo.readClassAndObject(this.input);
    }

    @Override
    public void writeLength(ByteBuffer byteBuffer, int n2) {
        byteBuffer.putInt(n2);
    }

    @Override
    public int readLength(ByteBuffer byteBuffer) {
        return byteBuffer.getInt();
    }

    @Override
    public int getLengthLength() {
        return 4;
    }
}

