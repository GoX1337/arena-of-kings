/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import com.esotericsoftware.kryo.util.Util;
import java.util.ArrayList;
import java.util.IdentityHashMap;

public class HashMapReferenceResolver
implements ReferenceResolver {
    protected Kryo kryo;
    protected final IdentityHashMap<Object, Integer> writtenObjects = new IdentityHashMap();
    protected final ArrayList readObjects = new ArrayList();

    @Override
    public void setKryo(Kryo kryo) {
        this.kryo = kryo;
    }

    @Override
    public int addWrittenObject(Object object) {
        int n2 = this.writtenObjects.size();
        this.writtenObjects.put(object, n2);
        return n2;
    }

    @Override
    public int getWrittenId(Object object) {
        Integer n2 = this.writtenObjects.get(object);
        if (n2 == null) {
            return -1;
        }
        return n2;
    }

    @Override
    public int nextReadId(Class clazz) {
        int n2 = this.readObjects.size();
        this.readObjects.add(null);
        return n2;
    }

    @Override
    public void setReadObject(int n2, Object object) {
        this.readObjects.set(n2, object);
    }

    @Override
    public Object getReadObject(Class clazz, int n2) {
        return this.readObjects.get(n2);
    }

    @Override
    public void reset() {
        this.readObjects.clear();
        this.writtenObjects.clear();
    }

    @Override
    public boolean useReferences(Class clazz) {
        return !Util.isWrapperClass(clazz) && !Util.isEnum(clazz);
    }
}

