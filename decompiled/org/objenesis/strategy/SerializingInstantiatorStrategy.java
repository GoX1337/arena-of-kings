/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.strategy;

import java.io.NotSerializableException;
import java.io.Serializable;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.android.AndroidSerializationInstantiator;
import org.objenesis.instantiator.basic.ObjectInputStreamInstantiator;
import org.objenesis.instantiator.basic.ObjectStreamClassInstantiator;
import org.objenesis.instantiator.gcj.GCJSerializationInstantiator;
import org.objenesis.instantiator.perc.PercSerializationInstantiator;
import org.objenesis.instantiator.sun.SunReflectionFactorySerializationInstantiator;
import org.objenesis.strategy.BaseInstantiatorStrategy;
import org.objenesis.strategy.PlatformDescription;

public class SerializingInstantiatorStrategy
extends BaseInstantiatorStrategy {
    @Override
    public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> clazz) {
        if (!Serializable.class.isAssignableFrom(clazz)) {
            throw new ObjenesisException(new NotSerializableException(clazz + " not serializable"));
        }
        if (PlatformDescription.JVM_NAME.startsWith("Java HotSpot") || PlatformDescription.isThisJVM("OpenJDK")) {
            if (PlatformDescription.isGoogleAppEngine() && PlatformDescription.SPECIFICATION_VERSION.equals("1.7")) {
                return new ObjectInputStreamInstantiator<T>(clazz);
            }
            return new SunReflectionFactorySerializationInstantiator<T>(clazz);
        }
        if (PlatformDescription.JVM_NAME.startsWith("Dalvik")) {
            if (PlatformDescription.isAndroidOpenJDK()) {
                return new ObjectStreamClassInstantiator<T>(clazz);
            }
            return new AndroidSerializationInstantiator<T>(clazz);
        }
        if (PlatformDescription.JVM_NAME.startsWith("GNU libgcj")) {
            return new GCJSerializationInstantiator<T>(clazz);
        }
        if (PlatformDescription.JVM_NAME.startsWith("PERC")) {
            return new PercSerializationInstantiator<T>(clazz);
        }
        return new SunReflectionFactorySerializationInstantiator<T>(clazz);
    }
}

