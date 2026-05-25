/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.jsonbeans;

import com.esotericsoftware.jsonbeans.Json;
import com.esotericsoftware.jsonbeans.JsonValue;

public interface JsonSerializable {
    public void write(Json var1);

    public void read(Json var1, JsonValue var2);
}

