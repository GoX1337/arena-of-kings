/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils.reflect;

import com.badlogic.gdx.utils.reflect.ReflectionException;
import java.lang.reflect.InvocationTargetException;

public final class Constructor {
    private final java.lang.reflect.Constructor constructor;

    Constructor(java.lang.reflect.Constructor constructor) {
        this.constructor = constructor;
    }

    public Class[] getParameterTypes() {
        return this.constructor.getParameterTypes();
    }

    public Class getDeclaringClass() {
        return this.constructor.getDeclaringClass();
    }

    public boolean isAccessible() {
        return this.constructor.isAccessible();
    }

    public void setAccessible(boolean bl2) {
        this.constructor.setAccessible(bl2);
    }

    public Object newInstance(Object ... objectArray) {
        try {
            return this.constructor.newInstance(objectArray);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ReflectionException("Illegal argument(s) supplied to constructor for class: " + this.getDeclaringClass().getName(), illegalArgumentException);
        }
        catch (InstantiationException instantiationException) {
            throw new ReflectionException("Could not instantiate instance of class: " + this.getDeclaringClass().getName(), instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ReflectionException("Could not instantiate instance of class: " + this.getDeclaringClass().getName(), illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new ReflectionException("Exception occurred in constructor for class: " + this.getDeclaringClass().getName(), invocationTargetException);
        }
    }
}

