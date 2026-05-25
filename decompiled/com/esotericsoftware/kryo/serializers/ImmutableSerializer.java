/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Serializer;

public abstract class ImmutableSerializer<T>
extends Serializer<T> {
    public ImmutableSerializer() {
        this.setImmutable(true);
    }
}

