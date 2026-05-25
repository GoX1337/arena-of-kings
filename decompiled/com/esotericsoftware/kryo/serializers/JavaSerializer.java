/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.ObjectMap;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class JavaSerializer
extends Serializer {
    public void write(Kryo kryo, Output output, Object object) {
        try {
            ObjectMap objectMap = kryo.getGraphContext();
            ObjectOutputStream objectOutputStream = (ObjectOutputStream)objectMap.get(this);
            if (objectOutputStream == null) {
                objectOutputStream = new ObjectOutputStream(output);
                objectMap.put(this, objectOutputStream);
            }
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        }
        catch (Exception exception) {
            throw new KryoException("Error during Java serialization.", exception);
        }
    }

    public Object read(Kryo kryo, Input input, Class clazz) {
        try {
            ObjectMap objectMap = kryo.getGraphContext();
            ObjectInputStream objectInputStream = (ObjectInputStream)objectMap.get(this);
            if (objectInputStream == null) {
                objectInputStream = new ObjectInputStreamWithKryoClassLoader(input, kryo);
                objectMap.put(this, objectInputStream);
            }
            return objectInputStream.readObject();
        }
        catch (Exception exception) {
            throw new KryoException("Error during Java deserialization.", exception);
        }
    }

    static class ObjectInputStreamWithKryoClassLoader
    extends ObjectInputStream {
        private final Kryo kryo;

        ObjectInputStreamWithKryoClassLoader(InputStream inputStream, Kryo kryo) {
            super(inputStream);
            this.kryo = kryo;
        }

        protected Class resolveClass(ObjectStreamClass objectStreamClass) {
            try {
                return Class.forName(objectStreamClass.getName(), false, this.kryo.getClassLoader());
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new KryoException("Class not found: " + objectStreamClass.getName(), classNotFoundException);
            }
        }
    }
}

