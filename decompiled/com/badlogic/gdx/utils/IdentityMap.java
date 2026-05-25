/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.ObjectMap;

public class IdentityMap<K, V>
extends ObjectMap<K, V> {
    public IdentityMap() {
    }

    public IdentityMap(int n2) {
        super(n2);
    }

    public IdentityMap(int n2, float f2) {
        super(n2, f2);
    }

    public IdentityMap(IdentityMap<K, V> identityMap) {
        super(identityMap);
    }

    @Override
    protected int place(K k2) {
        return (int)((long)System.identityHashCode(k2) * -7046029254386353131L >>> this.shift);
    }

    @Override
    int locateKey(K k2) {
        if (k2 == null) {
            throw new IllegalArgumentException("key cannot be null.");
        }
        Object[] objectArray = this.keyTable;
        int n2 = this.place(k2);
        Object object;
        while ((object = objectArray[n2]) != null) {
            if (object == k2) {
                return n2;
            }
            n2 = n2 + 1 & this.mask;
        }
        return -(n2 + 1);
    }

    @Override
    public int hashCode() {
        int n2 = this.size;
        Object[] objectArray = this.keyTable;
        Object[] objectArray2 = this.valueTable;
        int n3 = objectArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            Object object = objectArray[i2];
            if (object == null) continue;
            n2 += System.identityHashCode(object);
            Object object2 = objectArray2[i2];
            if (object2 == null) continue;
            n2 += object2.hashCode();
        }
        return n2;
    }
}

