/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.ReflectField;
import com.esotericsoftware.kryo.util.Generics;
import java.lang.reflect.Field;

class AsmField
extends ReflectField {
    public AsmField(Field field, FieldSerializer fieldSerializer, Generics.GenericType genericType) {
        super(field, fieldSerializer, genericType);
    }

    @Override
    public Object get(Object object) {
        return this.access.get(object, this.accessIndex);
    }

    @Override
    public void set(Object object, Object object2) {
        this.access.set(object, this.accessIndex, object2);
    }

    @Override
    public void copy(Object object, Object object2) {
        try {
            this.access.set(object2, this.accessIndex, this.fieldSerializer.kryo.copy(this.access.get(object, this.accessIndex)));
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

    static final class StringAsmField
    extends FieldSerializer.CachedField {
        public StringAsmField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeString(this.access.getString(object, this.accessIndex));
        }

        @Override
        public void read(Input input, Object object) {
            this.access.set(object, this.accessIndex, (Object)input.readString());
        }

        @Override
        public void copy(Object object, Object object2) {
            this.access.set(object2, this.accessIndex, (Object)this.access.getString(object, this.accessIndex));
        }
    }

    static final class DoubleAsmField
    extends FieldSerializer.CachedField {
        public DoubleAsmField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeDouble(this.access.getDouble(object, this.accessIndex));
        }

        @Override
        public void read(Input input, Object object) {
            this.access.setDouble(object, this.accessIndex, input.readDouble());
        }

        @Override
        public void copy(Object object, Object object2) {
            this.access.setDouble(object2, this.accessIndex, this.access.getDouble(object, this.accessIndex));
        }
    }

    static final class LongAsmField
    extends FieldSerializer.CachedField {
        public LongAsmField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            if (this.varEncoding) {
                output.writeVarLong(this.access.getLong(object, this.accessIndex), false);
            } else {
                output.writeLong(this.access.getLong(object, this.accessIndex));
            }
        }

        @Override
        public void read(Input input, Object object) {
            if (this.varEncoding) {
                this.access.setLong(object, this.accessIndex, input.readVarLong(false));
            } else {
                this.access.setLong(object, this.accessIndex, input.readLong());
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            this.access.setLong(object2, this.accessIndex, this.access.getLong(object, this.accessIndex));
        }
    }

    static final class CharAsmField
    extends FieldSerializer.CachedField {
        public CharAsmField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeChar(this.access.getChar(object, this.accessIndex));
        }

        @Override
        public void read(Input input, Object object) {
            this.access.setChar(object, this.accessIndex, input.readChar());
        }

        @Override
        public void copy(Object object, Object object2) {
            this.access.setChar(object2, this.accessIndex, this.access.getChar(object, this.accessIndex));
        }
    }

    static final class BooleanAsmField
    extends FieldSerializer.CachedField {
        public BooleanAsmField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeBoolean(this.access.getBoolean(object, this.accessIndex));
        }

        @Override
        public void read(Input input, Object object) {
            this.access.setBoolean(object, this.accessIndex, input.readBoolean());
        }

        @Override
        public void copy(Object object, Object object2) {
            this.access.setBoolean(object2, this.accessIndex, this.access.getBoolean(object, this.accessIndex));
        }
    }

    static final class ByteAsmField
    extends FieldSerializer.CachedField {
        public ByteAsmField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeByte(this.access.getByte(object, this.accessIndex));
        }

        @Override
        public void read(Input input, Object object) {
            this.access.setByte(object, this.accessIndex, input.readByte());
        }

        @Override
        public void copy(Object object, Object object2) {
            this.access.setByte(object2, this.accessIndex, this.access.getByte(object, this.accessIndex));
        }
    }

    static final class ShortAsmField
    extends FieldSerializer.CachedField {
        public ShortAsmField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeShort(this.access.getShort(object, this.accessIndex));
        }

        @Override
        public void read(Input input, Object object) {
            this.access.setShort(object, this.accessIndex, input.readShort());
        }

        @Override
        public void copy(Object object, Object object2) {
            this.access.setShort(object2, this.accessIndex, this.access.getShort(object, this.accessIndex));
        }
    }

    static final class FloatAsmField
    extends FieldSerializer.CachedField {
        public FloatAsmField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            output.writeFloat(this.access.getFloat(object, this.accessIndex));
        }

        @Override
        public void read(Input input, Object object) {
            this.access.setFloat(object, this.accessIndex, input.readFloat());
        }

        @Override
        public void copy(Object object, Object object2) {
            this.access.setFloat(object2, this.accessIndex, this.access.getFloat(object, this.accessIndex));
        }
    }

    static final class IntAsmField
    extends FieldSerializer.CachedField {
        public IntAsmField(Field field) {
            super(field);
        }

        @Override
        public void write(Output output, Object object) {
            if (this.varEncoding) {
                output.writeVarInt(this.access.getInt(object, this.accessIndex), false);
            } else {
                output.writeInt(this.access.getInt(object, this.accessIndex));
            }
        }

        @Override
        public void read(Input input, Object object) {
            if (this.varEncoding) {
                this.access.setInt(object, this.accessIndex, input.readVarInt(false));
            } else {
                this.access.setInt(object, this.accessIndex, input.readInt());
            }
        }

        @Override
        public void copy(Object object, Object object2) {
            this.access.setInt(object2, this.accessIndex, this.access.getInt(object, this.accessIndex));
        }
    }
}

