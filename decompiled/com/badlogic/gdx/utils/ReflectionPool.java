/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Constructor;
import com.badlogic.gdx.utils.reflect.ReflectionException;

public class ReflectionPool<T>
extends Pool<T> {
    private final Constructor constructor;

    public ReflectionPool(Class<T> clazz) {
        this(clazz, 16, Integer.MAX_VALUE);
    }

    public ReflectionPool(Class<T> clazz, int n2) {
        this(clazz, n2, Integer.MAX_VALUE);
    }

    public ReflectionPool(Class<T> clazz, int n2, int n3) {
        super(n2, n3);
        this.constructor = this.findConstructor(clazz);
        if (this.constructor == null) {
            throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + clazz.getName());
        }
    }

    @Null
    private Constructor findConstructor(Class<T> clazz) {
        try {
            return ClassReflection.getConstructor(clazz, null);
        }
        catch (Exception exception) {
            try {
                Constructor constructor = ClassReflection.getDeclaredConstructor(clazz, null);
                constructor.setAccessible(true);
                return constructor;
            }
            catch (ReflectionException reflectionException) {
                return null;
            }
        }
    }

    @Override
    protected T newObject() {
        try {
            return (T)this.constructor.newInstance(null);
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Unable to create new instance: " + this.constructor.getDeclaringClass().getName(), exception);
        }
    }
}

