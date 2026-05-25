/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.ImmutableSerializer;

public class EnumNameSerializer
extends ImmutableSerializer<Enum> {
    private final Class<? extends Enum> enumType;

    public EnumNameSerializer(Class<? extends Enum> clazz) {
        this.enumType = clazz;
    }

    @Override
    public void write(Kryo kryo, Output output, Enum enum_) {
        output.writeString(enum_.name());
    }

    @Override
    public Enum read(Kryo kryo, Input input, Class clazz) {
        String string = input.readString();
        try {
            return Enum.valueOf(this.enumType, string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new KryoException("Enum value not found with name: " + string, illegalArgumentException);
        }
    }
}

