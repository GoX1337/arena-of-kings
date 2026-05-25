/*
 * Decompiled with CFR 0.152.
 */
package org.slf4j.helpers;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class Util {
    private static a SECURITY_MANAGER;
    private static boolean SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED;

    private Util() {
    }

    public static String safeGetSystemProperty(String string) {
        if (string == null) {
            throw new IllegalArgumentException("null input");
        }
        String string2 = null;
        try {
            string2 = System.getProperty(string);
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        return string2;
    }

    public static boolean safeGetBooleanSystemProperty(String string) {
        String string2 = Util.safeGetSystemProperty(string);
        if (string2 == null) {
            return false;
        }
        return string2.equalsIgnoreCase("true");
    }

    private static a getSecurityManager() {
        if (SECURITY_MANAGER != null) {
            return SECURITY_MANAGER;
        }
        if (SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED) {
            return null;
        }
        SECURITY_MANAGER = Util.safeCreateSecurityManager();
        SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = true;
        return SECURITY_MANAGER;
    }

    private static a safeCreateSecurityManager() {
        try {
            return new a();
        }
        catch (SecurityException securityException) {
            return null;
        }
    }

    public static Class<?> getCallingClass() {
        int n2;
        a a2 = Util.getSecurityManager();
        if (a2 == null) {
            return null;
        }
        Class<?>[] classArray = a2.getClassContext();
        String string = Util.class.getName();
        for (n2 = 0; n2 < classArray.length && !string.equals(classArray[n2].getName()); ++n2) {
        }
        if (n2 >= classArray.length || n2 + 2 >= classArray.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classArray[n2 + 2];
    }

    public static final void report(String string, Throwable throwable) {
        System.err.println(string);
        System.err.println("Reported exception:");
        throwable.printStackTrace();
    }

    public static final void report(String string) {
        System.err.println("SLF4J: " + string);
    }

    static {
        SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = false;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a
    extends SecurityManager {
        private a() {
        }

        @Override
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }
}

