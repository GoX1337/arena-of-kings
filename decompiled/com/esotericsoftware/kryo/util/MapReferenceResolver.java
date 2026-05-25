/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ReferenceResolver;
import com.esotericsoftware.kryo.util.IdentityObjectIntMap;
import com.esotericsoftware.kryo.util.Util;
import java.util.ArrayList;

public class MapReferenceResolver
implements ReferenceResolver {
    private static final int DEFAULT_CAPACITY = 2048;
    protected Kryo kryo;
    protected final IdentityObjectIntMap<Object> writtenObjects = new IdentityObjectIntMap();
    protected final ArrayList<Object> readObjects = new ArrayList();
    private final int maximumCapacity;

    public MapReferenceResolver() {
        this(2048);
    }

    public MapReferenceResolver(int n2) {
        this.maximumCapacity = n2;
    }

    @Override
    public void setKryo(Kryo kryo) {
        this.kryo = kryo;
    }

    @Override
    public int addWrittenObject(Object object) {
        int n2 = this.writtenObjects.size;
        this.writtenObjects.put(object, n2);
        return n2;
    }

    @Override
    public int getWrittenId(Object object) {
        return this.writtenObjects.get(object, -1);
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
        int n2 = this.readObjects.size();
        this.readObjects.clear();
        if (n2 > this.maximumCapacity) {
            this.readObjects.trimToSize();
            this.readObjects.ensureCapacity(this.maximumCapacity);
        }
        this.writtenObjects.clear(this.maximumCapacity);
    }

    @Override
    public boolean useReferences(Class clazz) {
        return !Util.isWrapperClass(clazz) && !Util.isEnum(clazz);
    }
}

