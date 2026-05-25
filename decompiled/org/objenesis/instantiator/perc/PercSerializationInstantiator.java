/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.perc;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.SERIALIZATION)
public class PercSerializationInstantiator<T>
implements ObjectInstantiator<T> {
    private final Object[] typeArgs;
    private final Method newInstanceMethod;

    public PercSerializationInstantiator(Class<T> clazz) {
        Class<T> clazz2 = clazz;
        while (Serializable.class.isAssignableFrom(clazz2)) {
            clazz2 = clazz2.getSuperclass();
        }
        try {
            Class<?> clazz3 = Class.forName("COM.newmonics.PercClassLoader.Method");
            this.newInstanceMethod = ObjectInputStream.class.getDeclaredMethod("noArgConstruct", Class.class, Object.class, clazz3);
            this.newInstanceMethod.setAccessible(true);
            Class<?> clazz4 = Class.forName("COM.newmonics.PercClassLoader.PercClass");
            Method method = clazz4.getDeclaredMethod("getPercClass", Class.class);
            Object object = method.invoke(null, clazz2);
            Method method2 = object.getClass().getDeclaredMethod("findMethod", String.class);
            Object object2 = method2.invoke(object, "<init>()V");
            this.typeArgs = new Object[]{clazz2, clazz, object2};
        }
        catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            throw new ObjenesisException(reflectiveOperationException);
        }
    }

    @Override
    public T newInstance() {
        try {
            return (T)this.newInstanceMethod.invoke(null, this.typeArgs);
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            throw new ObjenesisException(reflectiveOperationException);
        }
    }
}

