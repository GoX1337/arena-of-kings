/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.SerializationException;
import org.apache.commons.lang3.Validate;

public class SerializationUtils {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <T extends Serializable> T clone(T t2) {
        if (t2 == null) {
            return null;
        }
        byte[] byArray = SerializationUtils.serialize(t2);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        try (ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream = new ClassLoaderAwareObjectInputStream(byteArrayInputStream, t2.getClass().getClassLoader());){
            Serializable serializable;
            Serializable serializable2 = serializable = (Serializable)classLoaderAwareObjectInputStream.readObject();
            return (T)serializable2;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new SerializationException("ClassNotFoundException while reading cloned object data", classNotFoundException);
        }
        catch (IOException iOException) {
            throw new SerializationException("IOException while reading or closing cloned object data", iOException);
        }
    }

    public static <T> T deserialize(byte[] byArray) {
        Validate.notNull(byArray, "objectData", new Object[0]);
        return SerializationUtils.deserialize(new ByteArrayInputStream(byArray));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static <T> T deserialize(InputStream inputStream) {
        Validate.notNull(inputStream, "inputStream", new Object[0]);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);){
            Object object;
            Object object2 = object = objectInputStream.readObject();
            return (T)object2;
        }
        catch (IOException | ClassNotFoundException exception) {
            throw new SerializationException(exception);
        }
    }

    public static <T extends Serializable> T roundtrip(T t2) {
        return (T)((Serializable)SerializationUtils.deserialize(SerializationUtils.serialize(t2)));
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        SerializationUtils.serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) {
        Validate.notNull(outputStream, "outputStream", new Object[0]);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);){
            objectOutputStream.writeObject(serializable);
        }
        catch (IOException iOException) {
            throw new SerializationException(iOException);
        }
    }

    static class ClassLoaderAwareObjectInputStream
    extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes = new HashMap();
        private final ClassLoader classLoader;

        ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader) {
            super(inputStream);
            this.classLoader = classLoader;
        }

        @Override
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
            String string = objectStreamClass.getName();
            try {
                return Class.forName(string, false, this.classLoader);
            }
            catch (ClassNotFoundException classNotFoundException) {
                try {
                    return Class.forName(string, false, Thread.currentThread().getContextClassLoader());
                }
                catch (ClassNotFoundException classNotFoundException2) {
                    Class<?> clazz = primitiveTypes.get(string);
                    if (clazz != null) {
                        return clazz;
                    }
                    throw classNotFoundException2;
                }
            }
        }

        static {
            primitiveTypes.put("byte", Byte.TYPE);
            primitiveTypes.put("short", Short.TYPE);
            primitiveTypes.put("int", Integer.TYPE);
            primitiveTypes.put("long", Long.TYPE);
            primitiveTypes.put("float", Float.TYPE);
            primitiveTypes.put("double", Double.TYPE);
            primitiveTypes.put("boolean", Boolean.TYPE);
            primitiveTypes.put("char", Character.TYPE);
            primitiveTypes.put("void", Void.TYPE);
        }
    }
}

