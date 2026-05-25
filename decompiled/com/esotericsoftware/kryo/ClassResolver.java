/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public interface ClassResolver {
    public void setKryo(Kryo var1);

    public Registration register(Registration var1);

    public Registration unregister(int var1);

    public Registration registerImplicit(Class var1);

    public Registration getRegistration(Class var1);

    public Registration getRegistration(int var1);

    public Registration writeClass(Output var1, Class var2);

    public Registration readClass(Input var1);

    public void reset();
}

