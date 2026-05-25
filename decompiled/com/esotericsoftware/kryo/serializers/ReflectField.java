/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.util.Generics;
import java.lang.reflect.Field;

class ReflectField
extends FieldSerializer.CachedField {
    final FieldSerializer fieldSerializer;
    final Generics.GenericType genericType;

    ReflectField(Field field, FieldSerializer fieldSerializer, Generics.GenericType genericType) {
        super(field);
        this.fieldSerializer = fieldSerializer;
        this.genericType = genericType;
    }

    public Object get(Object object) {
        return this.field.get(object);
    }

    public void set(Object object, Object object2) {
        this.field.set(object, object2);
    }

    @Override
    public void write(Output output, Object object) {
        Kryo kryo = this.fieldSerializer.kryo;
        try {
            Object object2 = this.get(object);
            Serializer serializer = this.serializer;
            Class clazz = this.resolveFieldClass();
            if (clazz == null) {
                if (object2 == null) {
                    kryo.writeClass(output, null);
                    return;
                }
                Registration registration = kryo.writeClass(output, object2.getClass());
                if (serializer == null) {
                    serializer = registration.getSerializer();
                }
                kryo.getGenerics().pushGenericType(this.genericType);
                kryo.writeObject(output, object2, serializer);
            } else {
                if (serializer == null) {
                    serializer = kryo.getSerializer(clazz);
                    if (this.valueClass != null && this.reuseSerializer) {
                        this.serializer = serializer;
                    }
                }
                kryo.getGenerics().pushGenericType(this.genericType);
                if (this.canBeNull) {
                    kryo.writeObjectOrNull(output, object2, serializer);
                } else {
                    if (object2 == null) {
                        throw new KryoException("Field value cannot be null when canBeNull is false: " + this.name + " (" + object.getClass().getName() + ")");
                    }
                    kryo.writeObject(output, object2, serializer);
                }
            }
            kryo.getGenerics().popGenericType();
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new KryoException("Error accessing field: " + this.name + " (" + object.getClass().getName() + ")", illegalAccessException);
        }
        catch (KryoException kryoException) {
            kryoException.addTrace(this.name + " (" + object.getClass().getName() + ")");
            throw kryoException;
        }
        catch (StackOverflowError stackOverflowError) {
            throw new KryoException("A StackOverflow occurred. The most likely cause is that your data has a circular reference resulting in infinite recursion. Try enabling references with Kryo.setReferences(true). If your data structure is really more than " + kryo.getDepth() + " levels deep then try increasing your Java stack size.", stackOverflowError);
        }
        catch (Throwable throwable) {
            KryoException kryoException = new KryoException(throwable);
            kryoException.addTrace(this.name + " (" + object.getClass().getName() + ")");
            throw kryoException;
        }
    }

    @Override
    public void read(Input input, Object object) {
        Kryo kryo = this.fieldSerializer.kryo;
        try {
            Object t2;
            Serializer serializer = this.serializer;
            Class clazz = this.resolveFieldClass();
            if (clazz == null) {
                Registration registration = kryo.readClass(input);
                if (registration == null) {
                    this.set(object, null);
                    return;
                }
                if (serializer == null) {
                    serializer = registration.getSerializer();
                }
                kryo.getGenerics().pushGenericType(this.genericType);
                t2 = kryo.readObject(input, registration.getType(), serializer);
            } else {
                if (serializer == null) {
                    serializer = kryo.getSerializer(clazz);
                    if (this.valueClass != null && this.reuseSerializer) {
                        this.serializer = serializer;
                    }
                }
                kryo.getGenerics().pushGenericType(this.genericType);
                t2 = this.canBeNull ? kryo.readObjectOrNull(input, clazz, serializer) : kryo.readObject(input, clazz, serializer);
            }
            kryo.getGenerics().popGenericType();
            this.set(object, t2);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new KryoException("Error accessing field: " + this.name + " (" + this.fieldSerializer.type.getName() + ")", illegalAccessException);
        }
        catch (KryoException kryoException) {
            kryoException.addTrace(this.name + " (" + this.fieldSerializer.type.getName() + ")");
            throw kryoException;
        }
        catch (Throwable throwable) {
            KryoException kryoException = new KryoException(throwable);
            kryoException.addTrace(this.name + " (" + this.fieldSerializer.type.getName() + ")");
            throw kryoException;
        }
    }

    Class resolveFieldClass() {
        Class clazz;
        if (this.valueClass == null && (clazz = this.genericType.resolve(this.fieldSerializer.kryo.getGenerics())) != null && this.fieldSerializer.kryo.isFinal(clazz)) {
            return clazz;
        }
        return this.valueClass;
    }

    @Override
    public void copy(Object object, Object object2) {
        try {
            this.set(object2, this.fieldSerializer.kryo.copy(this.get(object)));
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new KryoException("Error accessing field: " + this.name + " (" + this.fieldSerializer.type.getName() + ")", illegalAccessException);
        }
        catch (KryoException kryoException) {
            kryoException.addTrace(this.name + " (" + this.fieldSerializer.type.getName() + ")");
            throw kryoException;
        }
        catch (Throwable throwable) {
            KryoException kryoException = new KryoException(throwable);
            kryoException.addTrace(this.name + " (" + this.fieldSerializer.type.getName() + ")");
            throw kryoException;
        }
    }

    static final class DoubleReflectField
    extends FieldSerializer.CachedField {
        public DoubleReflectField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeDouble(this.field.getDouble(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (double)");
                throw kryoException;
            }
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setDouble(object, input.readDouble());
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (double)");
                throw kryoException;
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                this.field.setDouble(object2, this.field.getDouble(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (double)");
                throw kryoException;
            }
        }
    }

    static final class LongReflectField
    extends FieldSerializer.CachedField {
        public LongReflectField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            try {
                if (this.varEncoding) {
                    output.writeVarLong(this.field.getLong(object), false);
                } else {
                    output.writeLong(this.field.getLong(object));
                }
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (long)");
                throw kryoException;
            }
        }

        @Override
        public void read(Input input, Object object) {
            try {
                if (this.varEncoding) {
                    this.field.setLong(object, input.readVarLong(false));
                } else {
                    this.field.setLong(object, input.readLong());
                }
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (long)");
                throw kryoException;
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                this.field.setLong(object2, this.field.getLong(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (long)");
                throw kryoException;
            }
        }
    }

    static final class CharReflectField
    extends FieldSerializer.CachedField {
        public CharReflectField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeChar(this.field.getChar(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (char)");
                throw kryoException;
            }
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setChar(object, input.readChar());
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (char)");
                throw kryoException;
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                this.field.setChar(object2, this.field.getChar(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (char)");
                throw kryoException;
            }
        }
    }

    static final class BooleanReflectField
    extends FieldSerializer.CachedField {
        public BooleanReflectField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeBoolean(this.field.getBoolean(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (boolean)");
                throw kryoException;
            }
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setBoolean(object, input.readBoolean());
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (boolean)");
                throw kryoException;
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                this.field.setBoolean(object2, this.field.getBoolean(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (boolean)");
                throw kryoException;
            }
        }
    }

    static final class ByteReflectField
    extends FieldSerializer.CachedField {
        public ByteReflectField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeByte(this.field.getByte(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (byte)");
                throw kryoException;
            }
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setByte(object, input.readByte());
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (byte)");
                throw kryoException;
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                this.field.setByte(object2, this.field.getByte(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (byte)");
                throw kryoException;
            }
        }
    }

    static final class ShortReflectField
    extends FieldSerializer.CachedField {
        public ShortReflectField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeShort(this.field.getShort(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (short)");
                throw kryoException;
            }
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setShort(object, input.readShort());
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (short)");
                throw kryoException;
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                this.field.setShort(object2, this.field.getShort(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (short)");
                throw kryoException;
            }
        }
    }

    static final class FloatReflectField
    extends FieldSerializer.CachedField {
        public FloatReflectField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            try {
                output.writeFloat(this.field.getFloat(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (float)");
                throw kryoException;
            }
        }

        @Override
        public void read(Input input, Object object) {
            try {
                this.field.setFloat(object, input.readFloat());
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (float)");
                throw kryoException;
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                this.field.setFloat(object2, this.field.getFloat(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (float)");
                throw kryoException;
            }
        }
    }

    static final class IntReflectField
    extends FieldSerializer.CachedField {
        public IntReflectField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            try {
                if (this.varEncoding) {
                    output.writeVarInt(this.field.getInt(object), false);
                } else {
                    output.writeInt(this.field.getInt(object));
                }
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (int)");
                throw kryoException;
            }
        }

        @Override
        public void read(Input input, Object object) {
            try {
                if (this.varEncoding) {
                    this.field.setInt(object, input.readVarInt(false));
                } else {
                    this.field.setInt(object, input.readInt());
                }
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (int)");
                throw kryoException;
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            try {
                this.field.setInt(object2, this.field.getInt(object));
            }
            catch (Throwable throwable) {
                KryoException kryoException = new KryoException(throwable);
                kryoException.addTrace(this.name + " (int)");
                throw kryoException;
            }
        }
    }
}

