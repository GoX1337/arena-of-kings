/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.util.ObjectIntMap;

public class IdentityObjectIntMap<K>
extends ObjectIntMap<K> {
    public IdentityObjectIntMap() {
    }

    public IdentityObjectIntMap(int n2) {
        super(n2);
    }

    public IdentityObjectIntMap(int n2, float f2) {
        super(n2, f2);
    }

    public IdentityObjectIntMap(IdentityObjectIntMap<K> identityObjectIntMap) {
        super(identityObjectIntMap);
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
        int[] nArray = this.valueTable;
        int n3 = objectArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            Object object = objectArray[i2];
            if (object == null) continue;
            n2 += System.identityHashCode(object) + nArray[i2];
        }
        return n2;
    }
}

