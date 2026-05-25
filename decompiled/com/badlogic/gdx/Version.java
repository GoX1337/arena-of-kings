/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx;

import com.badlogic.gdx.utils.GdxRuntimeException;

public class Version {
    public static final String VERSION = "1.10.1";
    public static final int MAJOR;
    public static final int MINOR;
    public static final int REVISION;

    public static boolean isHigher(int n2, int n3, int n4) {
        return Version.isHigherEqual(n2, n3, n4 + 1);
    }

    public static boolean isHigherEqual(int n2, int n3, int n4) {
        if (MAJOR != n2) {
            return MAJOR > n2;
        }
        if (MINOR != n3) {
            return MINOR > n3;
        }
        return REVISION >= n4;
    }

    public static boolean isLower(int n2, int n3, int n4) {
        return Version.isLowerEqual(n2, n3, n4 - 1);
    }

    public static boolean isLowerEqual(int n2, int n3, int n4) {
        if (MAJOR != n2) {
            return MAJOR < n2;
        }
        if (MINOR != n3) {
            return MINOR < n3;
        }
        return REVISION <= n4;
    }

    static {
        try {
            String[] stringArray = VERSION.split("\\.");
            MAJOR = stringArray.length < 1 ? 0 : Integer.valueOf(stringArray[0]);
            MINOR = stringArray.length < 2 ? 0 : Integer.valueOf(stringArray[1]);
            REVISION = stringArray.length < 3 ? 0 : Integer.valueOf(stringArray[2]);
        }
        catch (Throwable throwable) {
            throw new GdxRuntimeException("Invalid version 1.10.1", throwable);
        }
    }
}

