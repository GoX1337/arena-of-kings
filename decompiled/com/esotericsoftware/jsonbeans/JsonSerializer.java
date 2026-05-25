/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.jsonbeans;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonValue;

public interface JsonSerializer<T> {
    public void write(Json var1, T var2, Class var3);

    public T read(Json var1, JsonValue var2, Class var3);
}

