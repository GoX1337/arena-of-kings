/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import org.apache.commons.lang3.math.NumberUtils;

public enum JavaVersion {
    JAVA_0_9(1.5f, "0.9"),
    JAVA_1_1(1.1f, "1.1"),
    JAVA_1_2(1.2f, "1.2"),
    JAVA_1_3(1.3f, "1.3"),
    JAVA_1_4(1.4f, "1.4"),
    JAVA_1_5(1.5f, "1.5"),
    JAVA_1_6(1.6f, "1.6"),
    JAVA_1_7(1.7f, "1.7"),
    JAVA_1_8(1.8f, "1.8"),
    JAVA_1_9(9.0f, "9"),
    JAVA_9(9.0f, "9"),
    JAVA_10(10.0f, "10"),
    JAVA_11(11.0f, "11"),
    JAVA_12(12.0f, "12"),
    JAVA_13(13.0f, "13"),
    JAVA_14(14.0f, "14"),
    JAVA_15(15.0f, "15"),
    JAVA_16(16.0f, "16"),
    JAVA_17(17.0f, "17"),
    JAVA_RECENT(JavaVersion.maxVersion(), Float.toString(JavaVersion.maxVersion()));

    private final float value;
    private final String name;

    private JavaVersion(float f2, String string2) {
        this.value = f2;
        this.name = string2;
    }

    public boolean atLeast(JavaVersion javaVersion) {
        return this.value >= javaVersion.value;
    }

    public boolean atMost(JavaVersion javaVersion) {
        return this.value <= javaVersion.value;
    }

    static JavaVersion getJavaVersion(String string) {
        return JavaVersion.get(string);
    }

    static JavaVersion get(String string) {
        int n2;
        int n3;
        if (string == null) {
            return null;
        }
        switch (string) {
            case "0.9": {
                return JAVA_0_9;
            }
            case "1.1": {
                return JAVA_1_1;
            }
            case "1.2": {
                return JAVA_1_2;
            }
            case "1.3": {
                return JAVA_1_3;
            }
            case "1.4": {
                return JAVA_1_4;
            }
            case "1.5": {
                return JAVA_1_5;
            }
            case "1.6": {
                return JAVA_1_6;
            }
            case "1.7": {
                return JAVA_1_7;
            }
            case "1.8": {
                return JAVA_1_8;
            }
            case "9": {
                return JAVA_9;
            }
            case "10": {
                return JAVA_10;
            }
            case "11": {
                return JAVA_11;
            }
            case "12": {
                return JAVA_12;
            }
            case "13": {
                return JAVA_13;
            }
            case "14": {
                return JAVA_14;
            }
            case "15": {
                return JAVA_15;
            }
            case "16": {
                return JAVA_16;
            }
            case "17": {
                return JAVA_17;
            }
        }
        float f2 = JavaVersion.toFloatVersion(string);
        if ((double)f2 - 1.0 < 1.0 ? Float.parseFloat(string.substring((n3 = Math.max(string.indexOf(46), string.indexOf(44))) + 1, n2 = Math.max(string.length(), string.indexOf(44, n3)))) > 0.9f : f2 > 10.0f) {
            return JAVA_RECENT;
        }
        return null;
    }

    public String toString() {
        return this.name;
    }

    private static float maxVersion() {
        float f2 = JavaVersion.toFloatVersion(System.getProperty("java.specification.version", "99.0"));
        if (f2 > 0.0f) {
            return f2;
        }
        return 99.0f;
    }

    private static float toFloatVersion(String string) {
        int n2 = -1;
        if (string.contains(".")) {
            String[] stringArray = string.split("\\.");
            if (stringArray.length >= 2) {
                return NumberUtils.toFloat(stringArray[0] + '.' + stringArray[1], -1.0f);
            }
        } else {
            return NumberUtils.toFloat(string, -1.0f);
        }
        return -1.0f;
    }
}

