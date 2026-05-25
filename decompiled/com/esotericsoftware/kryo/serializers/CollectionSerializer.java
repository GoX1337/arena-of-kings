/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.SerializerFactory;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionSerializer<T extends Collection>
extends Serializer<T> {
    private boolean elementsCanBeNull = true;
    private Serializer elementSerializer;
    private Class elementClass;

    public CollectionSerializer() {
        this.setAcceptsNull(true);
    }

    public void setElementsCanBeNull(boolean bl2) {
        this.elementsCanBeNull = bl2;
    }

    public void setElementClass(Class clazz) {
        this.elementClass = clazz;
    }

    public Class getElementClass() {
        return this.elementClass;
    }

    public void setElementClass(Class clazz, Serializer serializer) {
        this.elementClass = clazz;
        this.elementSerializer = serializer;
    }

    public void setElementSerializer(Serializer serializer) {
        this.elementSerializer = serializer;
    }

    public Serializer getElementSerializer() {
        return this.elementSerializer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(Kryo kryo, Output output, T t2) {
        Iterator iterator;
        if (t2 == null) {
            output.writeByte((byte)0);
            return;
        }
        int n2 = t2.size();
        if (n2 == 0) {
            output.writeByte(1);
            this.writeHeader(kryo, output, t2);
            return;
        }
        boolean bl2 = this.elementsCanBeNull;
        Serializer serializer = this.elementSerializer;
        if (serializer == null && (iterator = kryo.getGenerics().nextGenericClass()) != null && kryo.isFinal((Class)((Object)iterator))) {
            serializer = kryo.getSerializer((Class)((Object)iterator));
        }
        try {
            block25: {
                if (serializer != null) {
                    block24: {
                        if (bl2) {
                            for (Object e2 : t2) {
                                if (e2 != null) continue;
                                output.writeVarIntFlag(true, n2 + 1, true);
                                break block24;
                            }
                            output.writeVarIntFlag(false, n2 + 1, true);
                            bl2 = false;
                        } else {
                            output.writeVarInt(n2 + 1, true);
                        }
                    }
                    this.writeHeader(kryo, output, t2);
                } else {
                    iterator = null;
                    boolean bl3 = false;
                    for (Object e3 : t2) {
                        if (e3 == null) {
                            bl3 = true;
                            continue;
                        }
                        if (iterator == null) {
                            iterator = e3.getClass();
                            continue;
                        }
                        if (e3.getClass() == iterator) continue;
                        output.writeVarIntFlag(false, n2 + 1, true);
                        this.writeHeader(kryo, output, t2);
                        break block25;
                    }
                    output.writeVarIntFlag(true, n2 + 1, true);
                    this.writeHeader(kryo, output, t2);
                    if (iterator == null) {
                        output.writeByte((byte)0);
                        return;
                    }
                    kryo.writeClass(output, (Class)((Object)iterator));
                    serializer = kryo.getSerializer((Class)((Object)iterator));
                    if (bl2) {
                        output.writeBoolean(bl3);
                        bl2 = bl3;
                    }
                }
            }
            if (serializer != null) {
                if (bl2) {
                    for (Object e2 : t2) {
                        kryo.writeObjectOrNull(output, e2, serializer);
                    }
                } else {
                    for (Object e2 : t2) {
                        kryo.writeObject(output, e2, serializer);
                    }
                }
            } else {
                for (Object e2 : t2) {
                    kryo.writeClassAndObject(output, e2);
                }
            }
        }
        finally {
            kryo.getGenerics().popGenericType();
        }
    }

    protected void writeHeader(Kryo kryo, Output output, T t2) {
    }

    protected T create(Kryo kryo, Input input, Class<? extends T> clazz, int n2) {
        if (clazz == ArrayList.class) {
            return (T)new ArrayList(n2);
        }
        if (clazz == HashSet.class) {
            return (T)new HashSet(Math.max((int)((float)n2 / 0.75f) + 1, 16));
        }
        Collection collection = (Collection)kryo.newInstance(clazz);
        if (collection instanceof ArrayList) {
            ((ArrayList)collection).ensureCapacity(n2);
        }
        return (T)collection;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public T read(Kryo kryo, Input input, Class<? extends T> clazz) {
        Class clazz2;
        Class clazz3 = this.elementClass;
        Serializer serializer = this.elementSerializer;
        if (serializer == null && (clazz2 = kryo.getGenerics().nextGenericClass()) != null && kryo.isFinal(clazz2)) {
            serializer = kryo.getSerializer(clazz2);
            clazz3 = clazz2;
        }
        try {
            int n2;
            int n3;
            boolean bl2 = this.elementsCanBeNull;
            if (serializer != null) {
                if (bl2) {
                    bl2 = input.readVarIntFlag();
                    n3 = input.readVarIntFlag(true);
                } else {
                    n3 = input.readVarInt(true);
                }
                if (n3 == 0) {
                    T t2 = null;
                    return t2;
                }
                clazz2 = this.create(kryo, input, clazz, --n3);
                kryo.reference(clazz2);
                if (n3 == 0) {
                    Class clazz4 = clazz2;
                    return (T)clazz4;
                }
            } else {
                n2 = input.readVarIntFlag();
                n3 = input.readVarIntFlag(true);
                if (n3 == 0) {
                    T t3 = null;
                    return t3;
                }
                clazz2 = this.create(kryo, input, clazz, --n3);
                kryo.reference(clazz2);
                if (n3 == 0) {
                    Class clazz5 = clazz2;
                    return (T)clazz5;
                }
                if (n2 != 0) {
                    Registration registration = kryo.readClass(input);
                    if (registration == null) {
                        for (int i2 = 0; i2 < n3; ++i2) {
                            clazz2.add(null);
                        }
                        kryo.getGenerics().popGenericType();
                        Class clazz6 = clazz2;
                        return (T)clazz6;
                    }
                    clazz3 = registration.getType();
                    serializer = kryo.getSerializer(clazz3);
                    if (bl2) {
                        bl2 = input.readBoolean();
                    }
                }
            }
            if (serializer != null) {
                if (bl2) {
                    for (n2 = 0; n2 < n3; ++n2) {
                        clazz2.add(kryo.readObjectOrNull(input, clazz3, serializer));
                    }
                } else {
                    for (n2 = 0; n2 < n3; ++n2) {
                        clazz2.add(kryo.readObject(input, clazz3, serializer));
                    }
                }
            } else {
                for (n2 = 0; n2 < n3; ++n2) {
                    clazz2.add(kryo.readClassAndObject(input));
                }
            }
            Class clazz7 = clazz2;
            return (T)clazz7;
        }
        finally {
            kryo.getGenerics().popGenericType();
        }
    }

    protected T createCopy(Kryo kryo, T t2) {
        return (T)((Collection)kryo.newInstance(t2.getClass()));
    }

    @Override
    public T copy(Kryo kryo, T t2) {
        T t3 = this.createCopy(kryo, t2);
        kryo.reference(t3);
        for (Object e2 : t2) {
            t3.add(kryo.copy(e2));
        }
        return t3;
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    public static @interface BindCollection {
        public Class elementClass() default Object.class;

        public Class<? extends Serializer> elementSerializer() default Serializer.class;

        public Class<? extends SerializerFactory> elementSerializerFactory() default SerializerFactory.class;

        public boolean elementsCanBeNull() default true;
    }
}

