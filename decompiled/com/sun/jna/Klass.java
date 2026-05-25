/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import java.lang.reflect.InvocationTargetException;

abstract class Klass {
    private Klass() {
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (IllegalAccessException illegalAccessException) {
            String string = "Can't create an instance of " + clazz + ", requires a public no-arg constructor: " + illegalAccessException;
            throw new IllegalArgumentException(string, illegalAccessException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            String string = "Can't create an instance of " + clazz + ", requires a public no-arg constructor: " + illegalArgumentException;
            throw new IllegalArgumentException(string, illegalArgumentException);
        }
        catch (InstantiationException instantiationException) {
            String string = "Can't create an instance of " + clazz + ", requires a public no-arg constructor: " + instantiationException;
            throw new IllegalArgumentException(string, instantiationException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            String string = "Can't create an instance of " + clazz + ", requires a public no-arg constructor: " + noSuchMethodException;
            throw new IllegalArgumentException(string, noSuchMethodException);
        }
        catch (SecurityException securityException) {
            String string = "Can't create an instance of " + clazz + ", requires a public no-arg constructor: " + securityException;
            throw new IllegalArgumentException(string, securityException);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (invocationTargetException.getCause() instanceof RuntimeException) {
                throw (RuntimeException)invocationTargetException.getCause();
            }
            String string = "Can't create an instance of " + clazz + ", requires a public no-arg constructor: " + invocationTargetException;
            throw new IllegalArgumentException(string, invocationTargetException);
        }
    }
}

