/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public abstract class Serializer<T> {
    private boolean acceptsNull;
    private boolean immutable;

    public Serializer() {
    }

    public Serializer(boolean bl2) {
        this.acceptsNull = bl2;
    }

    public Serializer(boolean bl2, boolean bl3) {
        this.acceptsNull = bl2;
        this.immutable = bl3;
    }

    public abstract void write(Kryo var1, Output var2, T var3);

    public abstract T read(Kryo var1, Input var2, Class<? extends T> var3);

    public boolean getAcceptsNull() {
        return this.acceptsNull;
    }

    public void setAcceptsNull(boolean bl2) {
        this.acceptsNull = bl2;
    }

    public boolean isImmutable() {
        return this.immutable;
    }

    public void setImmutable(boolean bl2) {
        this.immutable = bl2;
    }

    public T copy(Kryo kryo, T t2) {
        if (this.isImmutable()) {
            return t2;
        }
        throw new KryoException("Serializer does not support copy: " + this.getClass().getName());
    }
}

