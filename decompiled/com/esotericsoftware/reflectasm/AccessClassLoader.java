/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.reflectasm;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;
import com.esotericsoftware.reflectasm.PublicConstructorAccess;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.WeakHashMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class AccessClassLoader
extends ClassLoader {
    private static final WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> accessClassLoaders = new WeakHashMap();
    private static final ClassLoader selfContextParentClassLoader = AccessClassLoader.getParentClassLoader(AccessClassLoader.class);
    private static volatile AccessClassLoader selfContextAccessClassLoader = new AccessClassLoader(selfContextParentClassLoader);
    private static volatile Method defineClassMethod;
    private final HashSet<String> localClassNames = new HashSet();

    private AccessClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    Class loadAccessClass(String string) {
        if (this.localClassNames.contains(string)) {
            try {
                return this.loadClass(string, false);
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new RuntimeException(classNotFoundException);
            }
        }
        return null;
    }

    Class defineAccessClass(String string, byte[] byArray) {
        this.localClassNames.add(string);
        return this.defineClass(string, byArray);
    }

    @Override
    protected Class<?> loadClass(String string, boolean bl2) {
        if (string.equals(FieldAccess.class.getName())) {
            return FieldAccess.class;
        }
        if (string.equals(MethodAccess.class.getName())) {
            return MethodAccess.class;
        }
        if (string.equals(ConstructorAccess.class.getName())) {
            return ConstructorAccess.class;
        }
        if (string.equals(PublicConstructorAccess.class.getName())) {
            return PublicConstructorAccess.class;
        }
        return super.loadClass(string, bl2);
    }

    Class<?> defineClass(String string, byte[] byArray) {
        try {
            return (Class)AccessClassLoader.getDefineClassMethod().invoke((Object)this.getParent(), string, byArray, 0, byArray.length, this.getClass().getProtectionDomain());
        }
        catch (Exception exception) {
            return this.defineClass(string, byArray, 0, byArray.length, this.getClass().getProtectionDomain());
        }
    }

    static boolean areInSameRuntimeClassLoader(Class clazz, Class clazz2) {
        if (clazz.getPackage() != clazz2.getPackage()) {
            return false;
        }
        ClassLoader classLoader = clazz.getClassLoader();
        ClassLoader classLoader2 = clazz2.getClassLoader();
        ClassLoader classLoader3 = ClassLoader.getSystemClassLoader();
        if (classLoader == null) {
            return classLoader2 == null || classLoader2 == classLoader3;
        }
        if (classLoader2 == null) {
            return classLoader == classLoader3;
        }
        return classLoader == classLoader2;
    }

    private static ClassLoader getParentClassLoader(Class clazz) {
        ClassLoader classLoader = clazz.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return classLoader;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static Method getDefineClassMethod() {
        if (defineClassMethod == null) {
            WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> weakHashMap = accessClassLoaders;
            synchronized (weakHashMap) {
                if (defineClassMethod == null) {
                    defineClassMethod = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class);
                    try {
                        defineClassMethod.setAccessible(true);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            }
        }
        return defineClassMethod;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static AccessClassLoader get(Class clazz) {
        ClassLoader classLoader = AccessClassLoader.getParentClassLoader(clazz);
        if (selfContextParentClassLoader.equals(classLoader)) {
            if (selfContextAccessClassLoader == null) {
                WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> weakHashMap = accessClassLoaders;
                synchronized (weakHashMap) {
                    if (selfContextAccessClassLoader == null) {
                        selfContextAccessClassLoader = new AccessClassLoader(selfContextParentClassLoader);
                    }
                }
            }
            return selfContextAccessClassLoader;
        }
        WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> weakHashMap = accessClassLoaders;
        synchronized (weakHashMap) {
            AccessClassLoader accessClassLoader;
            WeakReference<AccessClassLoader> weakReference = accessClassLoaders.get(classLoader);
            if (weakReference != null) {
                accessClassLoader = (AccessClassLoader)weakReference.get();
                if (accessClassLoader != null) {
                    return accessClassLoader;
                }
                accessClassLoaders.remove(classLoader);
            }
            accessClassLoader = new AccessClassLoader(classLoader);
            accessClassLoaders.put(classLoader, new WeakReference<AccessClassLoader>(accessClassLoader));
            return accessClassLoader;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void remove(ClassLoader classLoader) {
        if (selfContextParentClassLoader.equals(classLoader)) {
            selfContextAccessClassLoader = null;
        } else {
            WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> weakHashMap = accessClassLoaders;
            synchronized (weakHashMap) {
                accessClassLoaders.remove(classLoader);
            }
        }
    }

    public static int activeAccessClassLoaders() {
        int n2 = accessClassLoaders.size();
        if (selfContextAccessClassLoader != null) {
            ++n2;
        }
        return n2;
    }
}

