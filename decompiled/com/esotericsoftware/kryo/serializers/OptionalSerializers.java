/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.ImmutableSerializer;
import com.esotericsoftware.kryo.util.Util;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public final class OptionalSerializers {
    public static void addDefaultSerializers(Kryo kryo) {
        if (Util.isClassAvailable("java.util.Optional")) {
            kryo.addDefaultSerializer(Optional.class, OptionalSerializer.class);
        }
        if (Util.isClassAvailable("java.util.OptionalInt")) {
            kryo.addDefaultSerializer(OptionalInt.class, OptionalIntSerializer.class);
        }
        if (Util.isClassAvailable("java.util.OptionalLong")) {
            kryo.addDefaultSerializer(OptionalLong.class, OptionalLongSerializer.class);
        }
        if (Util.isClassAvailable("java.util.OptionalDouble")) {
            kryo.addDefaultSerializer(OptionalDouble.class, OptionalDoubleSerializer.class);
        }
    }

    public static class OptionalDoubleSerializer
    extends ImmutableSerializer<OptionalDouble> {
        @Override
        public void write(Kryo kryo, Output output, OptionalDouble optionalDouble) {
            output.writeBoolean(optionalDouble.isPresent());
            if (optionalDouble.isPresent()) {
                output.writeDouble(optionalDouble.getAsDouble());
            }
        }

        @Override
        public OptionalDouble read(Kryo kryo, Input input, Class clazz) {
            boolean bl2 = input.readBoolean();
            return bl2 ? OptionalDouble.of(input.readDouble()) : OptionalDouble.empty();
        }
    }

    public static class OptionalLongSerializer
    extends ImmutableSerializer<OptionalLong> {
        @Override
        public void write(Kryo kryo, Output output, OptionalLong optionalLong) {
            output.writeBoolean(optionalLong.isPresent());
            if (optionalLong.isPresent()) {
                output.writeLong(optionalLong.getAsLong());
            }
        }

        @Override
        public OptionalLong read(Kryo kryo, Input input, Class clazz) {
            boolean bl2 = input.readBoolean();
            return bl2 ? OptionalLong.of(input.readLong()) : OptionalLong.empty();
        }
    }

    public static class OptionalIntSerializer
    extends ImmutableSerializer<OptionalInt> {
        @Override
        public void write(Kryo kryo, Output output, OptionalInt optionalInt) {
            output.writeBoolean(optionalInt.isPresent());
            if (optionalInt.isPresent()) {
                output.writeInt(optionalInt.getAsInt());
            }
        }

        @Override
        public OptionalInt read(Kryo kryo, Input input, Class clazz) {
            boolean bl2 = input.readBoolean();
            return bl2 ? OptionalInt.of(input.readInt()) : OptionalInt.empty();
        }
    }

    public static class OptionalSerializer
    extends Serializer<Optional> {
        public OptionalSerializer() {
            this.setAcceptsNull(false);
        }

        @Override
        public void write(Kryo kryo, Output output, Optional optional) {
            Object var4_4 = optional.isPresent() ? optional.get() : null;
            kryo.writeClassAndObject(output, var4_4);
        }

        @Override
        public Optional read(Kryo kryo, Input input, Class clazz) {
            return Optional.ofNullable(kryo.readClassAndObject(input));
        }

        @Override
        public Optional copy(Kryo kryo, Optional optional) {
            if (optional.isPresent()) {
                return Optional.of(kryo.copy(optional.get()));
            }
            return optional;
        }
    }
}

