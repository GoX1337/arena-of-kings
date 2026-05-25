/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class BlowfishSerializer
extends Serializer {
    private final Serializer serializer;
    private static SecretKeySpec keySpec;

    public BlowfishSerializer(Serializer serializer, byte[] byArray) {
        this.serializer = serializer;
        keySpec = new SecretKeySpec(byArray, "Blowfish");
    }

    public void write(Kryo kryo, Output output, Object object) {
        Cipher cipher = BlowfishSerializer.getCipher(1);
        CipherOutputStream cipherOutputStream = new CipherOutputStream(output, cipher);
        Output output2 = new Output(cipherOutputStream, 256){

            @Override
            public void close() {
            }
        };
        this.serializer.write(kryo, output2, object);
        output2.flush();
        try {
            cipherOutputStream.close();
        }
        catch (IOException iOException) {
            throw new KryoException(iOException);
        }
    }

    public Object read(Kryo kryo, Input input, Class clazz) {
        Cipher cipher = BlowfishSerializer.getCipher(2);
        CipherInputStream cipherInputStream = new CipherInputStream(input, cipher);
        return this.serializer.read(kryo, new Input(cipherInputStream, 256), clazz);
    }

    public Object copy(Kryo kryo, Object object) {
        return this.serializer.copy(kryo, object);
    }

    private static Cipher getCipher(int n2) {
        try {
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(n2, keySpec);
            return cipher;
        }
        catch (Exception exception) {
            throw new KryoException(exception);
        }
    }
}

