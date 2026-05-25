/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import com.esotericsoftware.kryo.util.Util;
import java.util.ArrayList;

public class ListReferenceResolver
implements ReferenceResolver {
    protected Kryo kryo;
    protected final ArrayList seenObjects = new ArrayList();

    @Override
    public void setKryo(Kryo kryo) {
        this.kryo = kryo;
    }

    @Override
    public int addWrittenObject(Object object) {
        int n2 = this.seenObjects.size();
        this.seenObjects.add(object);
        return n2;
    }

    @Override
    public int getWrittenId(Object object) {
        int n2 = this.seenObjects.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.seenObjects.get(i2) != object) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public int nextReadId(Class clazz) {
        int n2 = this.seenObjects.size();
        this.seenObjects.add(null);
        return n2;
    }

    @Override
    public void setReadObject(int n2, Object object) {
        this.seenObjects.set(n2, object);
    }

    @Override
    public Object getReadObject(Class clazz, int n2) {
        return this.seenObjects.get(n2);
    }

    @Override
    public void reset() {
        this.seenObjects.clear();
    }

    @Override
    public boolean useReferences(Class clazz) {
        return !Util.isWrapperClass(clazz) && !Util.isEnum(clazz);
    }
}

