/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.ReflectField;
import com.esotericsoftware.kryo.unsafe.UnsafeUtil;
import com.esotericsoftware.kryo.util.Generics;
import java.lang.reflect.Field;

class UnsafeField
extends ReflectField {
    public UnsafeField(Field field, FieldSerializer fieldSerializer, Generics.GenericType genericType) {
        super(field, fieldSerializer, genericType);
        this.offset = UnsafeUtil.unsafe.objectFieldOffset(field);
    }

    @Override
    public Object get(Object object) {
        return UnsafeUtil.unsafe.getObject(object, this.offset);
    }

    @Override
    public void set(Object object, Object object2) {
        UnsafeUtil.unsafe.putObject(object, this.offset, object2);
    }

    @Override
    public void copy(Object object, Object object2) {
        try {
            UnsafeUtil.unsafe.putObject(object2, this.offset, this.fieldSerializer.kryo.copy(UnsafeUtil.unsafe.getObject(object, this.offset)));
        }
        catch (KryoException kryoException) {
            kryoException.addTrace(this + " (" + this.fieldSerializer.type.getName() + ")");
            throw kryoException;
        }
        catch (Throwable throwable) {
            KryoException kryoException = new KryoException(throwable);
            kryoException.addTrace(this + " (" + this.fieldSerializer.type.getName() + ")");
            throw kryoException;
        }
    }

    static final class StringUnsafeField
    extends FieldSerializer.CachedField {
        public StringUnsafeField(Field field) {
            super(field);
            this.offset = UnsafeUtil.unsafe.objectFieldOffset(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeString((String)UnsafeUtil.unsafe.getObject(object, this.offset));
        }

        @Override
        public void read(Input input, Object object) {
            UnsafeUtil.unsafe.putObject(object, this.offset, input.readString());
        }

        @Override
        public void copy(Object object, Object object2) {
            UnsafeUtil.unsafe.putObject(object2, this.offset, UnsafeUtil.unsafe.getObject(object, this.offset));
        }
    }

    static final class DoubleUnsafeField
    extends FieldSerializer.CachedField {
        public DoubleUnsafeField(Field field) {
            super(field);
            this.offset = UnsafeUtil.unsafe.objectFieldOffset(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeDouble(UnsafeUtil.unsafe.getDouble(object, this.offset));
        }

        @Override
        public void read(Input input, Object object) {
            UnsafeUtil.unsafe.putDouble(object, this.offset, input.readDouble());
        }

        @Override
        public void copy(Object object, Object object2) {
            UnsafeUtil.unsafe.putDouble(object2, this.offset, UnsafeUtil.unsafe.getDouble(object, this.offset));
        }
    }

    static final class LongUnsafeField
    extends FieldSerializer.CachedField {
        public LongUnsafeField(Field field) {
            super(field);
            this.offset = UnsafeUtil.unsafe.objectFieldOffset(field);
        }

        @Override
        public void write(Output output, Object object) {
            if (this.varEncoding) {
                output.writeVarLong(UnsafeUtil.unsafe.getLong(object, this.offset), false);
            } else {
                output.writeLong(UnsafeUtil.unsafe.getLong(object, this.offset));
            }
        }

        @Override
        public void read(Input input, Object object) {
            if (this.varEncoding) {
                UnsafeUtil.unsafe.putLong(object, this.offset, input.readVarLong(false));
            } else {
                UnsafeUtil.unsafe.putLong(object, this.offset, input.readLong());
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            UnsafeUtil.unsafe.putLong(object2, this.offset, UnsafeUtil.unsafe.getLong(object, this.offset));
        }
    }

    static final class CharUnsafeField
    extends FieldSerializer.CachedField {
        public CharUnsafeField(Field field) {
            super(field);
            this.offset = UnsafeUtil.unsafe.objectFieldOffset(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeChar(UnsafeUtil.unsafe.getChar(object, this.offset));
        }

        @Override
        public void read(Input input, Object object) {
            UnsafeUtil.unsafe.putChar(object, this.offset, input.readChar());
        }

        @Override
        public void copy(Object object, Object object2) {
            UnsafeUtil.unsafe.putChar(object2, this.offset, UnsafeUtil.unsafe.getChar(object, this.offset));
        }
    }

    static final class BooleanUnsafeField
    extends FieldSerializer.CachedField {
        public BooleanUnsafeField(Field field) {
            super(field);
            this.offset = UnsafeUtil.unsafe.objectFieldOffset(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeBoolean(UnsafeUtil.unsafe.getBoolean(object, this.offset));
        }

        @Override
        public void read(Input input, Object object) {
            UnsafeUtil.unsafe.putBoolean(object, this.offset, input.readBoolean());
        }

        @Override
        public void copy(Object object, Object object2) {
            UnsafeUtil.unsafe.putBoolean(object2, this.offset, UnsafeUtil.unsafe.getBoolean(object, this.offset));
        }
    }

    static final class ByteUnsafeField
    extends FieldSerializer.CachedField {
        public ByteUnsafeField(Field field) {
            super(field);
            this.offset = UnsafeUtil.unsafe.objectFieldOffset(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeByte(UnsafeUtil.unsafe.getByte(object, this.offset));
        }

        @Override
        public void read(Input input, Object object) {
            UnsafeUtil.unsafe.putByte(object, this.offset, input.readByte());
        }

        @Override
        public void copy(Object object, Object object2) {
            UnsafeUtil.unsafe.putByte(object2, this.offset, UnsafeUtil.unsafe.getByte(object, this.offset));
        }
    }

    static final class ShortUnsafeField
    extends FieldSerializer.CachedField {
        public ShortUnsafeField(Field field) {
            super(field);
            this.offset = UnsafeUtil.unsafe.objectFieldOffset(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeShort(UnsafeUtil.unsafe.getShort(object, this.offset));
        }

        @Override
        public void read(Input input, Object object) {
            UnsafeUtil.unsafe.putShort(object, this.offset, input.readShort());
        }

        @Override
        public void copy(Object object, Object object2) {
            UnsafeUtil.unsafe.putShort(object2, this.offset, UnsafeUtil.unsafe.getShort(object, this.offset));
        }
    }

    static final class FloatUnsafeField
    extends FieldSerializer.CachedField {
        public FloatUnsafeField(Field field) {
            super(field);
            this.offset = UnsafeUtil.unsafe.objectFieldOffset(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeFloat(UnsafeUtil.unsafe.getFloat(object, this.offset));
        }

        @Override
        public void read(Input input, Object object) {
            UnsafeUtil.unsafe.putFloat(object, this.offset, input.readFloat());
        }

        @Override
        public void copy(Object object, Object object2) {
            UnsafeUtil.unsafe.putFloat(object2, this.offset, UnsafeUtil.unsafe.getFloat(object, this.offset));
        }
    }

    static final class IntUnsafeField
    extends FieldSerializer.CachedField {
        public IntUnsafeField(Field field) {
            super(field);
            this.offset = UnsafeUtil.unsafe.objectFieldOffset(field);
        }

        @Override
        public void write(Output output, Object object) {
            if (this.varEncoding) {
                output.writeVarInt(UnsafeUtil.unsafe.getInt(object, this.offset), false);
            } else {
                output.writeInt(UnsafeUtil.unsafe.getInt(object, this.offset));
            }
        }

        @Override
        public void read(Input input, Object object) {
            if (this.varEncoding) {
                UnsafeUtil.unsafe.putInt(object, this.offset, input.readVarInt(false));
            } else {
                UnsafeUtil.unsafe.putInt(object, this.offset, input.readInt());
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            UnsafeUtil.unsafe.putInt(object2, this.offset, UnsafeUtil.unsafe.getInt(object, this.offset));
        }
    }
}

