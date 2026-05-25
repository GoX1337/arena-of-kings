/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.KryoObjectInput;
import com.esotericsoftware.kryo.io.KryoObjectOutput;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.esotericsoftware.kryo.util.ObjectMap;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Method;

public class ExternalizableSerializer
extends Serializer {
    private ObjectMap<Class, JavaSerializer> javaSerializerByType;
    private KryoObjectInput objectInput = null;
    private KryoObjectOutput objectOutput = null;

    public void write(Kryo kryo, Output output, Object object) {
        JavaSerializer javaSerializer = this.getJavaSerializerIfRequired(object.getClass());
        if (javaSerializer == null) {
            this.writeExternal(kryo, output, object);
        } else {
            javaSerializer.write(kryo, output, object);
        }
    }

    public Object read(Kryo kryo, Input input, Class clazz) {
        JavaSerializer javaSerializer = this.getJavaSerializerIfRequired(clazz);
        if (javaSerializer == null) {
            return this.readExternal(kryo, input, clazz);
        }
        return javaSerializer.read(kryo, input, clazz);
    }

    private void writeExternal(Kryo kryo, Output output, Object object) {
        try {
            ((Externalizable)object).writeExternal(this.getObjectOutput(kryo, output));
        }
        catch (Exception exception) {
            throw new KryoException(exception);
        }
    }

    private Object readExternal(Kryo kryo, Input input, Class clazz) {
        try {
            Externalizable externalizable = (Externalizable)kryo.newInstance(clazz);
            externalizable.readExternal(this.getObjectInput(kryo, input));
            return externalizable;
        }
        catch (Exception exception) {
            throw new KryoException(exception);
        }
    }

    private ObjectOutput getObjectOutput(Kryo kryo, Output output) {
        if (this.objectOutput == null) {
            this.objectOutput = new KryoObjectOutput(kryo, output);
        } else {
            this.objectOutput.setOutput(output);
        }
        return this.objectOutput;
    }

    private ObjectInput getObjectInput(Kryo kryo, Input input) {
        if (this.objectInput == null) {
            this.objectInput = new KryoObjectInput(kryo, input);
        } else {
            this.objectInput.setInput(input);
        }
        return this.objectInput;
    }

    private JavaSerializer getJavaSerializerIfRequired(Class clazz) {
        JavaSerializer javaSerializer = this.getCachedSerializer(clazz);
        if (javaSerializer == null && this.isJavaSerializerRequired(clazz)) {
            javaSerializer = new JavaSerializer();
        }
        return javaSerializer;
    }

    private JavaSerializer getCachedSerializer(Class clazz) {
        if (this.javaSerializerByType == null) {
            this.javaSerializerByType = new ObjectMap();
            return null;
        }
        return this.javaSerializerByType.get(clazz);
    }

    private boolean isJavaSerializerRequired(Class clazz) {
        return ExternalizableSerializer.hasInheritableReplaceMethod(clazz, "writeReplace") || ExternalizableSerializer.hasInheritableReplaceMethod(clazz, "readResolve");
    }

    private static boolean hasInheritableReplaceMethod(Class clazz, String string) {
        Method method = null;
        for (Class clazz2 = clazz; clazz2 != null; clazz2 = clazz2.getSuperclass()) {
            try {
                method = clazz2.getDeclaredMethod(string, new Class[0]);
                break;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                continue;
            }
        }
        return method != null && method.getReturnType() == Object.class;
    }
}

