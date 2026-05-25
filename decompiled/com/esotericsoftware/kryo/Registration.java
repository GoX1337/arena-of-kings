/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.minlog.Log;
import org.objenesis.instantiator.ObjectInstantiator;

public class Registration {
    private final Class type;
    private final boolean typeNameAscii;
    private final int id;
    private Serializer serializer;
    private ObjectInstantiator instantiator;

    public Registration(Class clazz, Serializer serializer, int n2) {
        if (clazz == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.type = clazz;
        this.serializer = serializer;
        this.id = n2;
        this.typeNameAscii = Util.isAscii(clazz.getName());
    }

    public Class getType() {
        return this.type;
    }

    public boolean isTypeNameAscii() {
        return this.typeNameAscii;
    }

    public int getId() {
        return this.id;
    }

    public Serializer getSerializer() {
        return this.serializer;
    }

    public void setSerializer(Serializer serializer) {
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.serializer = serializer;
        if (Log.TRACE) {
            Log.trace("kryo", "Update registered serializer: " + this.type.getName() + " (" + serializer.getClass().getName() + ")");
        }
    }

    public ObjectInstantiator getInstantiator() {
        return this.instantiator;
    }

    public void setInstantiator(ObjectInstantiator objectInstantiator) {
        if (objectInstantiator == null) {
            throw new IllegalArgumentException("instantiator cannot be null.");
        }
        this.instantiator = objectInstantiator;
    }

    public String toString() {
        return "[" + this.id + ", " + Util.className(this.type) + "]";
    }
}

