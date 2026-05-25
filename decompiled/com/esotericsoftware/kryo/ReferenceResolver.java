/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.Kryo;

public interface ReferenceResolver {
    public void setKryo(Kryo var1);

    public int getWrittenId(Object var1);

    public int addWrittenObject(Object var1);

    public int nextReadId(Class var1);

    public void setReadObject(int var1, Object var2);

    public Object getReadObject(Class var1, int var2);

    public void reset();

    public boolean useReferences(Class var1);
}

