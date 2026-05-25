/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.jsonbeans;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonSerializer;
import com.esotericsoftware.jsonbeans.JsonValue;

public abstract class ReadOnlySerializer<T>
implements JsonSerializer<T> {
    @Override
    public void write(Json json, T t2, Class clazz) {
    }

    @Override
    public abstract T read(Json var1, JsonValue var2, Class var3);
}

