/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet.serialization;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonException;
import com.esotericsoftware.kryo.io.ByteBufferInputStream;
import com.esotericsoftware.kryo.io.ByteBufferOutputStream;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.FrameworkMessage;
import com.esotericsoftware.kryonet.serialization.Serialization;
import com.esotericsoftware.minlog.Log;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;

public class JsonSerialization
implements Serialization {
    private final Json json = new Json();
    private final ByteBufferInputStream byteBufferInputStream = new ByteBufferInputStream();
    private final ByteBufferOutputStream byteBufferOutputStream = new ByteBufferOutputStream();
    private final OutputStreamWriter writer = new OutputStreamWriter(this.byteBufferOutputStream);
    private boolean logging = true;
    private boolean prettyPrint = true;
    private byte[] logBuffer = new byte[0];

    public JsonSerialization() {
        this.json.addClassTag("RegisterTCP", FrameworkMessage.RegisterTCP.class);
        this.json.addClassTag("RegisterUDP", FrameworkMessage.RegisterUDP.class);
        this.json.addClassTag("KeepAlive", FrameworkMessage.KeepAlive.class);
        this.json.addClassTag("DiscoverHost", FrameworkMessage.DiscoverHost.class);
        this.json.addClassTag("Ping", FrameworkMessage.Ping.class);
        this.json.setWriter(this.writer);
    }

    public void setLogging(boolean bl2, boolean bl3) {
        this.logging = bl2;
        this.prettyPrint = bl3;
    }

    @Override
    public synchronized void write(Connection connection, ByteBuffer byteBuffer, Object object) {
        this.byteBufferOutputStream.setByteBuffer(byteBuffer);
        int n2 = byteBuffer.position();
        try {
            this.json.writeValue(object, Object.class, null);
            this.writer.flush();
        }
        catch (Exception exception) {
            throw new JsonException("Error writing object: " + object, exception);
        }
        if (Log.INFO && this.logging) {
            int n3 = byteBuffer.position();
            byteBuffer.position(n2);
            byteBuffer.limit(n3);
            int n4 = n3 - n2;
            if (this.logBuffer.length < n4) {
                this.logBuffer = new byte[n4];
            }
            byteBuffer.get(this.logBuffer, 0, n4);
            byteBuffer.position(n3);
            byteBuffer.limit(byteBuffer.capacity());
            String string = new String(this.logBuffer, 0, n4);
            if (this.prettyPrint) {
                string = this.json.prettyPrint(string);
            }
            Log.info("Wrote: " + string);
        }
    }

    @Override
    public synchronized Object read(Connection connection, ByteBuffer byteBuffer) {
        this.byteBufferInputStream.setByteBuffer(byteBuffer);
        return this.json.fromJson(Object.class, this.byteBufferInputStream);
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

