/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.instantiator.perc;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(value=Typology.STANDARD)
public class PercInstantiator<T>
implements ObjectInstantiator<T> {
    private final Method newInstanceMethod;
    private final Object[] typeArgs = new Object[]{null, Boolean.FALSE};

    public PercInstantiator(Class<T> clazz) {
        this.typeArgs[0] = clazz;
        try {
            this.newInstanceMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Boolean.TYPE);
            this.newInstanceMethod.setAccessible(true);
        }
        catch (NoSuchMethodException | RuntimeException exception) {
            throw new ObjenesisException(exception);
        }
    }

    @Override
    public T newInstance() {
        try {
            return (T)this.newInstanceMethod.invoke(null, this.typeArgs);
        }
        catch (Exception exception) {
            throw new ObjenesisException(exception);
        }
    }
}

