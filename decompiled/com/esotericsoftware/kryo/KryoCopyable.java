/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.Kryo;

public interface KryoCopyable<T> {
    public T copy(Kryo var1);
}

