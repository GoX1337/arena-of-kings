/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Util;
import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

public class ClosureSerializer
extends Serializer {
    private static Method readResolve;

    public ClosureSerializer() {
        if (readResolve == null) {
            try {
                readResolve = SerializedLambda.class.getDeclaredMethod("readResolve", new Class[0]);
                readResolve.setAccessible(true);
            }
            catch (Exception exception) {
                throw new KryoException("Unable to obtain SerializedLambda#readResolve via reflection.", exception);
            }
        }
    }

    public void write(Kryo kryo, Output output, Object object) {
        SerializedLambda serializedLambda = this.toSerializedLambda(object);
        int n2 = serializedLambda.getCapturedArgCount();
        output.writeVarInt(n2, true);
        for (int i2 = 0; i2 < n2; ++i2) {
            kryo.writeClassAndObject(output, serializedLambda.getCapturedArg(i2));
        }
        try {
            kryo.writeClass(output, Class.forName(serializedLambda.getCapturingClass().replace('/', '.')));
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new KryoException("Error writing closure.", classNotFoundException);
        }
        output.writeString(serializedLambda.getFunctionalInterfaceClass());
        output.writeString(serializedLambda.getFunctionalInterfaceMethodName());
        output.writeString(serializedLambda.getFunctionalInterfaceMethodSignature());
        output.writeVarInt(serializedLambda.getImplMethodKind(), true);
        output.writeString(serializedLambda.getImplClass());
        output.writeString(serializedLambda.getImplMethodName());
        output.writeString(serializedLambda.getImplMethodSignature());
        output.writeString(serializedLambda.getInstantiatedMethodType());
    }

    public Object read(Kryo kryo, Input input, Class clazz) {
        int n2 = input.readVarInt(true);
        Object[] objectArray = new Object[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            objectArray[i2] = kryo.readClassAndObject(input);
        }
        SerializedLambda serializedLambda = new SerializedLambda(kryo.readClass(input).getType(), input.readString(), input.readString(), input.readString(), input.readVarInt(true), input.readString(), input.readString(), input.readString(), input.readString(), objectArray);
        try {
            return readResolve.invoke((Object)serializedLambda, new Object[0]);
        }
        catch (Exception exception) {
            throw new KryoException("Error reading closure.", exception);
        }
    }

    public Object copy(Kryo kryo, Object object) {
        try {
            return readResolve.invoke((Object)this.toSerializedLambda(object), new Object[0]);
        }
        catch (Exception exception) {
            throw new KryoException("Error copying closure.", exception);
        }
    }

    private SerializedLambda toSerializedLambda(Object object) {
        Object object2;
        try {
            Method method = object.getClass().getDeclaredMethod("writeReplace", new Class[0]);
            method.setAccessible(true);
            object2 = method.invoke(object, new Object[0]);
        }
        catch (Exception exception) {
            if (object instanceof Serializable) {
                throw new KryoException("Error serializing closure.", exception);
            }
            throw new KryoException("Closure must implement java.io.Serializable.", exception);
        }
        try {
            return (SerializedLambda)object2;
        }
        catch (Exception exception) {
            throw new KryoException("writeReplace must return a SerializedLambda: " + (object2 == null ? null : Util.className(object2.getClass())), exception);
        }
    }

    public static class Closure {
    }
}

