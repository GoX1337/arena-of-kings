/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.InputChunked;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class DeflateSerializer
extends Serializer {
    private final Serializer serializer;
    private boolean noHeaders = true;
    private int compressionLevel = 4;

    public DeflateSerializer(Serializer serializer) {
        this.serializer = serializer;
    }

    public void write(Kryo kryo, Output output, Object object) {
        OutputChunked outputChunked = new OutputChunked(output, 256);
        Deflater deflater = new Deflater(this.compressionLevel, this.noHeaders);
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream((OutputStream)outputChunked, deflater);
            Output output2 = new Output(deflaterOutputStream, 256);
            this.serializer.write(kryo, output2, object);
            output2.flush();
            deflaterOutputStream.finish();
        }
        catch (IOException iOException) {
            throw new KryoException(iOException);
        }
        finally {
            deflater.end();
        }
        outputChunked.endChunk();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object read(Kryo kryo, Input input, Class clazz) {
        Inflater inflater = new Inflater(this.noHeaders);
        try {
            InflaterInputStream inflaterInputStream = new InflaterInputStream(new InputChunked(input, 256), inflater);
            Object t2 = this.serializer.read(kryo, new Input(inflaterInputStream, 256), clazz);
            return t2;
        }
        finally {
            inflater.end();
        }
    }

    public void setNoHeaders(boolean bl2) {
        this.noHeaders = bl2;
    }

    public void setCompressionLevel(int n2) {
        this.compressionLevel = n2;
    }

    public Object copy(Kryo kryo, Object object) {
        return this.serializer.copy(kryo, object);
    }
}

