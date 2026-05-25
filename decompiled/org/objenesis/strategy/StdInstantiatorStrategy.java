/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.strategy;

import java.io.Serializable;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.android.Android10Instantiator;
import org.objenesis.instantiator.android.Android17Instantiator;
import org.objenesis.instantiator.android.Android18Instantiator;
import org.objenesis.instantiator.basic.AccessibleInstantiator;
import org.objenesis.instantiator.basic.ObjectInputStreamInstantiator;
import org.objenesis.instantiator.gcj.GCJInstantiator;
import org.objenesis.instantiator.perc.PercInstantiator;
import org.objenesis.instantiator.sun.SunReflectionFactoryInstantiator;
import org.objenesis.instantiator.sun.UnsafeFactoryInstantiator;
import org.objenesis.strategy.BaseInstantiatorStrategy;
import org.objenesis.strategy.PlatformDescription;

public class StdInstantiatorStrategy
extends BaseInstantiatorStrategy {
    @Override
    public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> clazz) {
        if (PlatformDescription.isThisJVM("Java HotSpot") || PlatformDescription.isThisJVM("OpenJDK")) {
            if (PlatformDescription.isGoogleAppEngine() && PlatformDescription.SPECIFICATION_VERSION.equals("1.7")) {
                if (Serializable.class.isAssignableFrom(clazz)) {
                    return new ObjectInputStreamInstantiator<T>(clazz);
                }
                return new AccessibleInstantiator<T>(clazz);
            }
            return new SunReflectionFactoryInstantiator<T>(clazz);
        }
        if (PlatformDescription.isThisJVM("Dalvik")) {
            if (PlatformDescription.isAndroidOpenJDK()) {
                return new UnsafeFactoryInstantiator<T>(clazz);
            }
            if (PlatformDescription.ANDROID_VERSION <= 10) {
                return new Android10Instantiator<T>(clazz);
            }
            if (PlatformDescription.ANDROID_VERSION <= 17) {
                return new Android17Instantiator<T>(clazz);
            }
            return new Android18Instantiator<T>(clazz);
        }
        if (PlatformDescription.isThisJVM("GNU libgcj")) {
            return new GCJInstantiator<T>(clazz);
        }
        if (PlatformDescription.isThisJVM("PERC")) {
            return new PercInstantiator<T>(clazz);
        }
        return new UnsafeFactoryInstantiator<T>(clazz);
    }
}

