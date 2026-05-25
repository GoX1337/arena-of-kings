/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.ImmutableSerializer;
import com.esotericsoftware.minlog.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class RecordSerializer<T>
extends ImmutableSerializer<T> {
    private static final Method IS_RECORD;
    private static final Method GET_RECORD_COMPONENTS;
    private static final Method GET_NAME;
    private static final Method GET_TYPE;

    @Override
    public void write(Kryo kryo, Output output, T t2) {
        Class<?> clazz = t2.getClass();
        if (!this.isRecord(clazz)) {
            throw new KryoException(t2 + " is not a record");
        }
        for (RecordComponent recordComponent : RecordSerializer.recordComponents(clazz, Comparator.comparing(RecordComponent::name))) {
            Class<?> clazz2 = recordComponent.type();
            String string = recordComponent.name();
            try {
                if (Log.TRACE) {
                    Log.trace("kryo", "Write property: " + string + " (" + clazz2.getName() + ")");
                }
                if (recordComponent.type().isPrimitive()) {
                    kryo.writeObject(output, RecordSerializer.componentValue(t2, recordComponent));
                    continue;
                }
                kryo.writeObjectOrNull(output, RecordSerializer.componentValue(t2, recordComponent), clazz2);
            }
            catch (KryoException kryoException) {
                kryoException.addTrace(string + " (" + clazz2.getName() + ")");
                throw kryoException;
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(string + " (" + clazz2.getName() + ")");
                throw kryoException;
            }
        }
    }

    @Override
    public T read(Kryo kryo, Input input, Class<? extends T> clazz) {
        if (!this.isRecord(clazz)) {
            throw new KryoException("Not a record (" + clazz + ")");
        }
        RecordComponent[] recordComponentArray = RecordSerializer.recordComponents(clazz, Comparator.comparing(RecordComponent::name));
        Object[] objectArray = new Object[recordComponentArray.length];
        for (int i2 = 0; i2 < recordComponentArray.length; ++i2) {
            RecordComponent recordComponent = recordComponentArray[i2];
            String string = recordComponent.name();
            try {
                if (Log.TRACE) {
                    Log.trace("kryo", "Read property: " + string + " (" + clazz.getName() + ")");
                }
                objectArray[recordComponent.index()] = recordComponent.type().isPrimitive() ? kryo.readObject(input, recordComponent.type()) : kryo.readObjectOrNull(input, recordComponent.type());
                continue;
            }
            catch (KryoException kryoException) {
                kryoException.addTrace(string + " (" + clazz.getName() + ")");
                throw kryoException;
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(string + " (" + clazz.getName() + ")");
                throw kryoException;
            }
        }
        Arrays.sort(recordComponentArray, Comparator.comparing(RecordComponent::index));
        return RecordSerializer.invokeCanonicalConstructor(clazz, recordComponentArray, objectArray);
    }

    private boolean isRecord(Class<?> clazz) {
        try {
            return (Boolean)IS_RECORD.invoke(clazz, new Object[0]);
        }
        catch (Throwable throwable) {
            throw new KryoException("Could not determine type (" + clazz + ")");
        }
    }

    private static <T> RecordComponent[] recordComponents(Class<T> clazz, Comparator<RecordComponent> comparator) {
        try {
            Object[] objectArray = (Object[])GET_RECORD_COMPONENTS.invoke(clazz, new Object[0]);
            RecordComponent[] recordComponentArray = new RecordComponent[objectArray.length];
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Object object = objectArray[i2];
                recordComponentArray[i2] = new RecordComponent((String)GET_NAME.invoke(object, new Object[0]), (Class)GET_TYPE.invoke(object, new Object[0]), i2);
            }
            if (comparator != null) {
                Arrays.sort(recordComponentArray, comparator);
            }
            return recordComponentArray;
        }
        catch (Throwable throwable) {
            KryoException kryoException = new KryoException(throwable);
            kryoException.addTrace("Could not retrieve record components (" + clazz.getName() + ")");
            throw kryoException;
        }
    }

    private static Object componentValue(Object object, RecordComponent recordComponent) {
        try {
            Method method = object.getClass().getDeclaredMethod(recordComponent.name(), new Class[0]);
            return method.invoke(object, new Object[0]);
        }
        catch (Throwable throwable) {
            KryoException kryoException = new KryoException(throwable);
            kryoException.addTrace("Could not retrieve record components (" + object.getClass().getName() + ")");
            throw kryoException;
        }
    }

    private static <T> T invokeCanonicalConstructor(Class<T> clazz, RecordComponent[] recordComponentArray, Object[] objectArray) {
        try {
            Class[] classArray = (Class[])Arrays.stream(recordComponentArray).map(RecordComponent::type).toArray(Class[]::new);
            Constructor<T> constructor = clazz.getConstructor(classArray);
            return constructor.newInstance(objectArray);
        }
        catch (Throwable throwable) {
            KryoException kryoException = new KryoException(throwable);
            kryoException.addTrace("Could not construct type (" + clazz.getName() + ")");
            throw kryoException;
        }
    }

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        try {
            Class<?> clazz = Class.forName("java.lang.reflect.RecordComponent");
            method4 = Class.class.getDeclaredMethod("isRecord", new Class[0]);
            method3 = Class.class.getMethod("getRecordComponents", new Class[0]);
            method2 = clazz.getMethod("getName", new Class[0]);
            method = clazz.getMethod("getType", new Class[0]);
        }
        catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        IS_RECORD = method4;
        GET_RECORD_COMPONENTS = method3;
        GET_NAME = method2;
        GET_TYPE = method;
    }

    static final class RecordComponent {
        private final String name;
        private final Class<?> type;
        private final int index;

        RecordComponent(String string, Class<?> clazz, int n2) {
            this.name = string;
            this.type = clazz;
            this.index = n2;
        }

        String name() {
            return this.name;
        }

        Class<?> type() {
            return this.type;
        }

        int index() {
            return this.index;
        }
    }
}

