/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class BooleanUtils {
    public static final String FALSE = "false";
    public static final String NO = "no";
    public static final String OFF = "off";
    public static final String ON = "on";
    public static final String TRUE = "true";
    public static final String YES = "yes";

    public static boolean and(boolean ... blArray) {
        ObjectUtils.requireNonEmpty(blArray, "array");
        for (boolean bl2 : blArray) {
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static Boolean and(Boolean ... booleanArray) {
        ObjectUtils.requireNonEmpty(booleanArray, "array");
        try {
            boolean[] blArray = ArrayUtils.toPrimitive(booleanArray);
            return BooleanUtils.and(blArray) ? Boolean.TRUE : Boolean.FALSE;
        }
        catch (NullPointerException nullPointerException) {
            throw new IllegalArgumentException("The array must not contain any null elements");
        }
    }

    public static Boolean[] booleanValues() {
        return new Boolean[]{Boolean.FALSE, Boolean.TRUE};
    }

    public static int compare(boolean bl2, boolean bl3) {
        if (bl2 == bl3) {
            return 0;
        }
        return bl2 ? 1 : -1;
    }

    public static boolean isFalse(Boolean bl2) {
        return Boolean.FALSE.equals(bl2);
    }

    public static boolean isNotFalse(Boolean bl2) {
        return !BooleanUtils.isFalse(bl2);
    }

    public static boolean isNotTrue(Boolean bl2) {
        return !BooleanUtils.isTrue(bl2);
    }

    public static boolean isTrue(Boolean bl2) {
        return Boolean.TRUE.equals(bl2);
    }

    public static Boolean negate(Boolean bl2) {
        if (bl2 == null) {
            return null;
        }
        return bl2 != false ? Boolean.FALSE : Boolean.TRUE;
    }

    public static boolean or(boolean ... blArray) {
        ObjectUtils.requireNonEmpty(blArray, "array");
        for (boolean bl2 : blArray) {
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static Boolean or(Boolean ... booleanArray) {
        ObjectUtils.requireNonEmpty(booleanArray, "array");
        try {
            boolean[] blArray = ArrayUtils.toPrimitive(booleanArray);
            return BooleanUtils.or(blArray) ? Boolean.TRUE : Boolean.FALSE;
        }
        catch (NullPointerException nullPointerException) {
            throw new IllegalArgumentException("The array must not contain any null elements");
        }
    }

    public static boolean[] primitiveValues() {
        return new boolean[]{false, true};
    }

    public static boolean toBoolean(Boolean bl2) {
        return bl2 != null && bl2 != false;
    }

    public static boolean toBoolean(int n2) {
        return n2 != 0;
    }

    public static boolean toBoolean(int n2, int n3, int n4) {
        if (n2 == n3) {
            return true;
        }
        if (n2 == n4) {
            return false;
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static boolean toBoolean(Integer n2, Integer n3, Integer n4) {
        if (n2 == null) {
            if (n3 == null) {
                return true;
            }
            if (n4 == null) {
                return false;
            }
        } else {
            if (n2.equals(n3)) {
                return true;
            }
            if (n2.equals(n4)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static boolean toBoolean(String string) {
        return BooleanUtils.toBooleanObject(string) == Boolean.TRUE;
    }

    public static boolean toBoolean(String string, String string2, String string3) {
        if (string == string2) {
            return true;
        }
        if (string == string3) {
            return false;
        }
        if (string != null) {
            if (string.equals(string2)) {
                return true;
            }
            if (string.equals(string3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The String did not match either specified value");
    }

    public static boolean toBooleanDefaultIfNull(Boolean bl2, boolean bl3) {
        if (bl2 == null) {
            return bl3;
        }
        return bl2;
    }

    public static Boolean toBooleanObject(int n2) {
        return n2 == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Boolean toBooleanObject(int n2, int n3, int n4, int n5) {
        if (n2 == n3) {
            return Boolean.TRUE;
        }
        if (n2 == n4) {
            return Boolean.FALSE;
        }
        if (n2 == n5) {
            return null;
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Boolean toBooleanObject(Integer n2) {
        if (n2 == null) {
            return null;
        }
        return n2 == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Boolean toBooleanObject(Integer n2, Integer n3, Integer n4, Integer n5) {
        if (n2 == null) {
            if (n3 == null) {
                return Boolean.TRUE;
            }
            if (n4 == null) {
                return Boolean.FALSE;
            }
            if (n5 == null) {
                return null;
            }
        } else {
            if (n2.equals(n3)) {
                return Boolean.TRUE;
            }
            if (n2.equals(n4)) {
                return Boolean.FALSE;
            }
            if (n2.equals(n5)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Boolean toBooleanObject(String string) {
        if (string == TRUE) {
            return Boolean.TRUE;
        }
        if (string == null) {
            return null;
        }
        switch (string.length()) {
            case 1: {
                char c2 = string.charAt(0);
                if (c2 == 'y' || c2 == 'Y' || c2 == 't' || c2 == 'T' || c2 == '1') {
                    return Boolean.TRUE;
                }
                if (c2 != 'n' && c2 != 'N' && c2 != 'f' && c2 != 'F' && c2 != '0') break;
                return Boolean.FALSE;
            }
            case 2: {
                char c3 = string.charAt(0);
                char c4 = string.charAt(1);
                if (!(c3 != 'o' && c3 != 'O' || c4 != 'n' && c4 != 'N')) {
                    return Boolean.TRUE;
                }
                if (c3 != 'n' && c3 != 'N' || c4 != 'o' && c4 != 'O') break;
                return Boolean.FALSE;
            }
            case 3: {
                char c5 = string.charAt(0);
                char c6 = string.charAt(1);
                char c7 = string.charAt(2);
                if (!(c5 != 'y' && c5 != 'Y' || c6 != 'e' && c6 != 'E' || c7 != 's' && c7 != 'S')) {
                    return Boolean.TRUE;
                }
                if (c5 != 'o' && c5 != 'O' || c6 != 'f' && c6 != 'F' || c7 != 'f' && c7 != 'F') break;
                return Boolean.FALSE;
            }
            case 4: {
                char c8 = string.charAt(0);
                char c9 = string.charAt(1);
                char c10 = string.charAt(2);
                char c11 = string.charAt(3);
                if (c8 != 't' && c8 != 'T' || c9 != 'r' && c9 != 'R' || c10 != 'u' && c10 != 'U' || c11 != 'e' && c11 != 'E') break;
                return Boolean.TRUE;
            }
            case 5: {
                char c12 = string.charAt(0);
                char c13 = string.charAt(1);
                char c14 = string.charAt(2);
                char c15 = string.charAt(3);
                char c16 = string.charAt(4);
                if (c12 != 'f' && c12 != 'F' || c13 != 'a' && c13 != 'A' || c14 != 'l' && c14 != 'L' || c15 != 's' && c15 != 'S' || c16 != 'e' && c16 != 'E') break;
                return Boolean.FALSE;
            }
        }
        return null;
    }

    public static Boolean toBooleanObject(String string, String string2, String string3, String string4) {
        if (string == null) {
            if (string2 == null) {
                return Boolean.TRUE;
            }
            if (string3 == null) {
                return Boolean.FALSE;
            }
            if (string4 == null) {
                return null;
            }
        } else {
            if (string.equals(string2)) {
                return Boolean.TRUE;
            }
            if (string.equals(string3)) {
                return Boolean.FALSE;
            }
            if (string.equals(string4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The String did not match any specified value");
    }

    public static int toInteger(boolean bl2) {
        return bl2 ? 1 : 0;
    }

    public static int toInteger(boolean bl2, int n2, int n3) {
        return bl2 ? n2 : n3;
    }

    public static int toInteger(Boolean bl2, int n2, int n3, int n4) {
        if (bl2 == null) {
            return n4;
        }
        return bl2 != false ? n2 : n3;
    }

    public static Integer toIntegerObject(boolean bl2) {
        return bl2 ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static Integer toIntegerObject(boolean bl2, Integer n2, Integer n3) {
        return bl2 ? n2 : n3;
    }

    public static Integer toIntegerObject(Boolean bl2) {
        if (bl2 == null) {
            return null;
        }
        return bl2 != false ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static Integer toIntegerObject(Boolean bl2, Integer n2, Integer n3, Integer n4) {
        if (bl2 == null) {
            return n4;
        }
        return bl2 != false ? n2 : n3;
    }

    public static String toString(boolean bl2, String string, String string2) {
        return bl2 ? string : string2;
    }

    public static String toString(Boolean bl2, String string, String string2, String string3) {
        if (bl2 == null) {
            return string3;
        }
        return bl2 != false ? string : string2;
    }

    public static String toStringOnOff(boolean bl2) {
        return BooleanUtils.toString(bl2, ON, OFF);
    }

    public static String toStringOnOff(Boolean bl2) {
        return BooleanUtils.toString(bl2, ON, OFF, null);
    }

    public static String toStringTrueFalse(boolean bl2) {
        return BooleanUtils.toString(bl2, TRUE, FALSE);
    }

    public static String toStringTrueFalse(Boolean bl2) {
        return BooleanUtils.toString(bl2, TRUE, FALSE, null);
    }

    public static String toStringYesNo(boolean bl2) {
        return BooleanUtils.toString(bl2, YES, NO);
    }

    public static String toStringYesNo(Boolean bl2) {
        return BooleanUtils.toString(bl2, YES, NO, null);
    }

    public static boolean xor(boolean ... blArray) {
        ObjectUtils.requireNonEmpty(blArray, "array");
        boolean bl2 = false;
        for (boolean bl3 : blArray) {
            bl2 ^= bl3;
        }
        return bl2;
    }

    public static Boolean xor(Boolean ... booleanArray) {
        ObjectUtils.requireNonEmpty(booleanArray, "array");
        try {
            boolean[] blArray = ArrayUtils.toPrimitive(booleanArray);
            return BooleanUtils.xor(blArray) ? Boolean.TRUE : Boolean.FALSE;
        }
        catch (NullPointerException nullPointerException) {
            throw new IllegalArgumentException("The array must not contain any null elements");
        }
    }
}

