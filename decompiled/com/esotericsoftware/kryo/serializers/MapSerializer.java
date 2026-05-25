/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.SerializerFactory;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Generics;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public class MapSerializer<T extends Map>
extends Serializer<T> {
    private Class keyClass;
    private Class valueClass;
    private Serializer keySerializer;
    private Serializer valueSerializer;
    private boolean keysCanBeNull = true;
    private boolean valuesCanBeNull = true;

    public MapSerializer() {
        this.setAcceptsNull(true);
    }

    public void setKeysCanBeNull(boolean bl2) {
        this.keysCanBeNull = bl2;
    }

    public void setKeyClass(Class clazz) {
        this.keyClass = clazz;
    }

    public Class getKeyClass() {
        return this.keyClass;
    }

    public void setKeyClass(Class clazz, Serializer serializer) {
        this.keyClass = clazz;
        this.keySerializer = serializer;
    }

    public void setKeySerializer(Serializer serializer) {
        this.keySerializer = serializer;
    }

    public Serializer getKeySerializer() {
        return this.keySerializer;
    }

    public void setValueClass(Class clazz) {
        this.valueClass = clazz;
    }

    public Class getValueClass() {
        return this.valueClass;
    }

    public void setValueClass(Class clazz, Serializer serializer) {
        this.valueClass = clazz;
        this.valueSerializer = serializer;
    }

    public void setValueSerializer(Serializer serializer) {
        this.valueSerializer = serializer;
    }

    public Serializer getValueSerializer() {
        return this.valueSerializer;
    }

    public void setValuesCanBeNull(boolean bl2) {
        this.valuesCanBeNull = bl2;
    }

    @Override
    public void write(Kryo kryo, Output output, T t2) {
        if (t2 == null) {
            output.writeByte(0);
            return;
        }
        int n2 = t2.size();
        if (n2 == 0) {
            output.writeByte(1);
            this.writeHeader(kryo, output, t2);
            return;
        }
        output.writeVarInt(n2 + 1, true);
        this.writeHeader(kryo, output, t2);
        Serializer serializer = this.keySerializer;
        Serializer serializer2 = this.valueSerializer;
        Generics.GenericType[] genericTypeArray = kryo.getGenerics().nextGenericTypes();
        if (genericTypeArray != null) {
            Object object;
            if (serializer == null && (object = genericTypeArray[0].resolve(kryo.getGenerics())) != null && kryo.isFinal((Class)object)) {
                serializer = kryo.getSerializer((Class)object);
            }
            if (serializer2 == null && (object = genericTypeArray[1].resolve(kryo.getGenerics())) != null && kryo.isFinal((Class)object)) {
                serializer2 = kryo.getSerializer((Class)object);
            }
        }
        for (Map.Entry entry : t2.entrySet()) {
            if (genericTypeArray != null) {
                kryo.getGenerics().pushGenericType(genericTypeArray[0]);
            }
            if (serializer != null) {
                if (this.keysCanBeNull) {
                    kryo.writeObjectOrNull(output, entry.getKey(), serializer);
                } else {
                    kryo.writeObject(output, entry.getKey(), serializer);
                }
            } else {
                kryo.writeClassAndObject(output, entry.getKey());
            }
            if (genericTypeArray != null) {
                kryo.getGenerics().popGenericType();
            }
            if (serializer2 != null) {
                if (this.valuesCanBeNull) {
                    kryo.writeObjectOrNull(output, entry.getValue(), serializer2);
                    continue;
                }
                kryo.writeObject(output, entry.getValue(), serializer2);
                continue;
            }
            kryo.writeClassAndObject(output, entry.getValue());
        }
        kryo.getGenerics().popGenericType();
    }

    protected void writeHeader(Kryo kryo, Output output, T t2) {
    }

    protected T create(Kryo kryo, Input input, Class<? extends T> clazz, int n2) {
        if (clazz == HashMap.class) {
            if (n2 < 3) {
                ++n2;
            } else if (n2 < 0x40000000) {
                n2 = (int)((float)n2 / 0.75f + 1.0f);
            }
            return (T)new HashMap(n2);
        }
        return (T)((Map)kryo.newInstance(clazz));
    }

    @Override
    public T read(Kryo kryo, Input input, Class<? extends T> clazz) {
        int n2 = input.readVarInt(true);
        if (n2 == 0) {
            return null;
        }
        T t2 = this.create(kryo, input, clazz, --n2);
        kryo.reference(t2);
        if (n2 == 0) {
            return t2;
        }
        Class clazz2 = this.keyClass;
        Class clazz3 = this.valueClass;
        Serializer serializer = this.keySerializer;
        Serializer serializer2 = this.valueSerializer;
        Generics.GenericType[] genericTypeArray = kryo.getGenerics().nextGenericTypes();
        if (genericTypeArray != null) {
            Class clazz4;
            if (serializer == null && (clazz4 = genericTypeArray[0].resolve(kryo.getGenerics())) != null && kryo.isFinal(clazz4)) {
                serializer = kryo.getSerializer(clazz4);
                clazz2 = clazz4;
            }
            if (serializer2 == null && (clazz4 = genericTypeArray[1].resolve(kryo.getGenerics())) != null && kryo.isFinal(clazz4)) {
                serializer2 = kryo.getSerializer(clazz4);
                clazz3 = clazz4;
            }
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            if (genericTypeArray != null) {
                kryo.getGenerics().pushGenericType(genericTypeArray[0]);
            }
            Object object = serializer != null ? (this.keysCanBeNull ? kryo.readObjectOrNull(input, clazz2, serializer) : kryo.readObject(input, clazz2, serializer)) : kryo.readClassAndObject(input);
            if (genericTypeArray != null) {
                kryo.getGenerics().popGenericType();
            }
            Object object2 = serializer2 != null ? (this.valuesCanBeNull ? kryo.readObjectOrNull(input, clazz3, serializer2) : kryo.readObject(input, clazz3, serializer2)) : kryo.readClassAndObject(input);
            t2.put((Object)object, (Object)object2);
        }
        kryo.getGenerics().popGenericType();
        return t2;
    }

    protected T createCopy(Kryo kryo, T t2) {
        return (T)((Map)kryo.newInstance(t2.getClass()));
    }

    @Override
    public T copy(Kryo kryo, T t2) {
        T t3 = this.createCopy(kryo, t2);
        for (Map.Entry entry : t2.entrySet()) {
            t3.put(kryo.copy(entry.getKey()), kryo.copy(entry.getValue()));
        }
        return t3;
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    public static @interface BindMap {
        public Class keyClass() default Object.class;

        public Class<? extends Serializer> keySerializer() default Serializer.class;

        public Class<? extends SerializerFactory> keySerializerFactory() default SerializerFactory.class;

        public Class valueClass() default Object.class;

        public Class<? extends Serializer> valueSerializer() default Serializer.class;

        public Class<? extends SerializerFactory> valueSerializerFactory() default SerializerFactory.class;

        public boolean keysCanBeNull() default true;

        public boolean valuesCanBeNull() default true;
    }
}

