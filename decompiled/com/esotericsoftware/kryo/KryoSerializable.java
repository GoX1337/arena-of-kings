/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public interface KryoSerializable {
    public void write(Kryo var1, Output var2);

    public void read(Kryo var1, Input var2);
}

