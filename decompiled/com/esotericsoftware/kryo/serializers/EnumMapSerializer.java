/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import java.util.EnumMap;

public class EnumMapSerializer
extends MapSerializer<EnumMap> {
    private final Class<? extends Enum> enumType;

    public EnumMapSerializer(Class<? extends Enum> clazz) {
        this.enumType = clazz;
    }

    @Override
    protected EnumMap create(Kryo kryo, Input input, Class<? extends EnumMap> clazz, int n2) {
        return new EnumMap(this.enumType);
    }

    @Override
    protected EnumMap createCopy(Kryo kryo, EnumMap enumMap) {
        return new EnumMap(enumMap);
    }
}

