/*
 * Decompiled with CFR 0.152.
 */
package org.objenesis.strategy;

import java.lang.reflect.Field;
import org.objenesis.ObjenesisException;

public final class PlatformDescription {
    public static final String GNU = "GNU libgcj";
    public static final String HOTSPOT = "Java HotSpot";
    @Deprecated
    public static final String SUN = "Java HotSpot";
    public static final String OPENJDK = "OpenJDK";
    public static final String PERC = "PERC";
    public static final String DALVIK = "Dalvik";
    public static final String SPECIFICATION_VERSION = System.getProperty("java.specification.version");
    public static final String VM_VERSION = System.getProperty("java.runtime.version");
    public static final String VM_INFO = System.getProperty("java.vm.info");
    public static final String VENDOR_VERSION = System.getProperty("java.vm.version");
    public static final String VENDOR = System.getProperty("java.vm.vendor");
    public static final String JVM_NAME = System.getProperty("java.vm.name");
    public static final int ANDROID_VERSION = PlatformDescription.getAndroidVersion();
    public static final boolean IS_ANDROID_OPENJDK = PlatformDescription.getIsAndroidOpenJDK();
    public static final String GAE_VERSION = PlatformDescription.getGaeRuntimeVersion();

    public static String describePlatform() {
        String string = "Java " + SPECIFICATION_VERSION + " (VM vendor name=\"" + VENDOR + "\", VM vendor version=" + VENDOR_VERSION + ", JVM name=\"" + JVM_NAME + "\", JVM version=" + VM_VERSION + ", JVM info=" + VM_INFO;
        if (ANDROID_VERSION != 0) {
            string = string + ", API level=" + ANDROID_VERSION;
        }
        string = string + ")";
        return string;
    }

    public static boolean isThisJVM(String string) {
        return JVM_NAME.startsWith(string);
    }

    public static boolean isAndroidOpenJDK() {
        return IS_ANDROID_OPENJDK;
    }

    private static boolean getIsAndroidOpenJDK() {
        if (PlatformDescription.getAndroidVersion() == 0) {
            return false;
        }
        String string = System.getProperty("java.boot.class.path");
        return string != null && string.toLowerCase().contains("core-oj.jar");
    }

    public static boolean isAfterJigsaw() {
        String string = SPECIFICATION_VERSION;
        return string.indexOf(46) < 0;
    }

    public static boolean isAfterJava11() {
        if (!PlatformDescription.isAfterJigsaw()) {
            return false;
        }
        int n2 = Integer.parseInt(SPECIFICATION_VERSION);
        return n2 >= 11;
    }

    public static boolean isGoogleAppEngine() {
        return GAE_VERSION != null;
    }

    private static String getGaeRuntimeVersion() {
        return System.getProperty("com.google.appengine.runtime.version");
    }

    private static int getAndroidVersion() {
        if (!PlatformDescription.isThisJVM(DALVIK)) {
            return 0;
        }
        return PlatformDescription.getAndroidVersion0();
    }

    private static int getAndroidVersion0() {
        int n2;
        Field field;
        Class<?> clazz;
        try {
            clazz = Class.forName("android.os.Build$VERSION");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ObjenesisException(classNotFoundException);
        }
        try {
            field = clazz.getField("SDK_INT");
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return PlatformDescription.getOldAndroidVersion(clazz);
        }
        try {
            n2 = (Integer)field.get(null);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
        return n2;
    }

    private static int getOldAndroidVersion(Class<?> clazz) {
        String string;
        Field field;
        try {
            field = clazz.getField("SDK");
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new ObjenesisException(noSuchFieldException);
        }
        try {
            string = (String)field.get(null);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
        return Integer.parseInt(string);
    }

    private PlatformDescription() {
    }
}

