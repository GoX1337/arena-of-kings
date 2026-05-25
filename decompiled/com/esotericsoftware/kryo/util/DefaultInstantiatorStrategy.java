/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.Util;
import com.esotericsoftware.reflectasm.ConstructorAccess;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.strategy.InstantiatorStrategy;

public class DefaultInstantiatorStrategy
implements InstantiatorStrategy {
    private InstantiatorStrategy fallbackStrategy;

    public DefaultInstantiatorStrategy() {
    }

    public DefaultInstantiatorStrategy(InstantiatorStrategy instantiatorStrategy) {
        this.fallbackStrategy = instantiatorStrategy;
    }

    public void setFallbackInstantiatorStrategy(InstantiatorStrategy instantiatorStrategy) {
        this.fallbackStrategy = instantiatorStrategy;
    }

    public InstantiatorStrategy getFallbackInstantiatorStrategy() {
        return this.fallbackStrategy;
    }

    public ObjectInstantiator newInstantiatorOf(final Class clazz) {
        GenericDeclaration genericDeclaration;
        if (!Util.isAndroid) {
            boolean bl2;
            genericDeclaration = clazz.getEnclosingClass();
            boolean bl3 = bl2 = genericDeclaration != null && clazz.isMemberClass() && !Modifier.isStatic(clazz.getModifiers());
            if (!bl2) {
                try {
                    final ConstructorAccess constructorAccess = ConstructorAccess.get(clazz);
                    return new ObjectInstantiator(){

                        public Object newInstance() {
                            try {
                                return constructorAccess.newInstance();
                            }
                            catch (Exception exception) {
                                throw new KryoException("Error constructing instance of class: " + Util.className(clazz), exception);
                            }
                        }
                    };
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        try {
            try {
                genericDeclaration = clazz.getConstructor(null);
            }
            catch (Exception exception) {
                genericDeclaration = clazz.getDeclaredConstructor(null);
                ((Constructor)genericDeclaration).setAccessible(true);
            }
            GenericDeclaration genericDeclaration2 = genericDeclaration;
            return new ObjectInstantiator((Constructor)genericDeclaration2, clazz){
                final /* synthetic */ Constructor val$constructor;
                final /* synthetic */ Class val$type;
                {
                    this.val$constructor = constructor;
                    this.val$type = clazz;
                }

                public Object newInstance() {
                    try {
                        return this.val$constructor.newInstance(new Object[0]);
                    }
                    catch (Exception exception) {
                        throw new KryoException("Error constructing instance of class: " + Util.className(this.val$type), exception);
                    }
                }
            };
        }
        catch (Exception exception) {
            if (this.fallbackStrategy == null) {
                if (clazz.isMemberClass() && !Modifier.isStatic(clazz.getModifiers())) {
                    throw new KryoException("Class cannot be created (non-static member class): " + Util.className(clazz));
                }
                StringBuilder stringBuilder = new StringBuilder("Class cannot be created (missing no-arg constructor): " + Util.className(clazz));
                if (clazz.getSimpleName().equals("")) {
                    stringBuilder.append("\nNote: This is an anonymous class, which is not serializable by default in Kryo. Possible solutions:\n").append("1. Remove uses of anonymous classes, including double brace initialization, from the containing\n").append("class. This is the safest solution, as anonymous classes don't have predictable names for serialization.\n").append("2. Register a FieldSerializer for the containing class and call FieldSerializer\n").append("setIgnoreSyntheticFields(false) on it. This is not safe but may be sufficient temporarily.");
                }
                throw new KryoException(stringBuilder.toString());
            }
            return this.fallbackStrategy.newInstantiatorOf(clazz);
        }
    }
}

