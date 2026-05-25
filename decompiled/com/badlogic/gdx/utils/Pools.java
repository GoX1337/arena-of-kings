/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.ReflectionPool;

public class Pools {
    private static final ObjectMap<Class, Pool> typePools = new ObjectMap();

    public static <T> Pool<T> get(Class<T> clazz, int n2) {
        ReflectionPool<T> reflectionPool = typePools.get(clazz);
        if (reflectionPool == null) {
            reflectionPool = new ReflectionPool<T>(clazz, 4, n2);
            typePools.put(clazz, reflectionPool);
        }
        return reflectionPool;
    }

    public static <T> Pool<T> get(Class<T> clazz) {
        return Pools.get(clazz, 100);
    }

    public static <T> void set(Class<T> clazz, Pool<T> pool) {
        typePools.put(clazz, pool);
    }

    public static <T> T obtain(Class<T> clazz) {
        return Pools.get(clazz).obtain();
    }

    public static void free(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        Pool pool = typePools.get(object.getClass());
        if (pool == null) {
            return;
        }
        pool.free(object);
    }

    public static void freeAll(Array array) {
        Pools.freeAll(array, false);
    }

    public static void freeAll(Array array, boolean bl2) {
        if (array == null) {
            throw new IllegalArgumentException("objects cannot be null.");
        }
        Pool pool = null;
        int n2 = array.size;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object t2 = array.get(i2);
            if (t2 == null || pool == null && (pool = typePools.get(t2.getClass())) == null) continue;
            pool.free(t2);
            if (bl2) continue;
            pool = null;
        }
    }

    private Pools() {
    }
}

