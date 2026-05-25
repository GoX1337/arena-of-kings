/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.android;

import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.SERIALIZATION)
public class AndroidSerializationInstantiator<T>
implements ObjectInstantiator<T> {
    private final Class<T> type;
    private final ObjectStreamClass objectStreamClass;
    private final Method newInstanceMethod;

    public AndroidSerializationInstantiator(Class<T> clazz) {
        Method method;
        this.type = clazz;
        this.newInstanceMethod = AndroidSerializationInstantiator.getNewInstanceMethod();
        try {
            method = ObjectStreamClass.class.getMethod("lookupAny", Class.class);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new ObjenesisException(noSuchMethodException);
        }
        try {
            this.objectStreamClass = (ObjectStreamClass)method.invoke(null, clazz);
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw new ObjenesisException(reflectiveOperationException);
        }
    }

    @Override
    public T newInstance() {
        try {
            return this.type.cast(this.newInstanceMethod.invoke((Object)this.objectStreamClass, this.type));
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
            throw new ObjenesisException(exception);
        }
    }

    private static Method getNewInstanceMethod() {
        try {
            Method method = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class);
            method.setAccessible(true);
            return method;
        }
        catch (NoSuchMethodException | RuntimeException exception) {
            throw new ObjenesisException(exception);
        }
    }
}

