/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.StringUtils;

public class CharSetUtils {
    public static boolean containsAny(String string, String ... stringArray) {
        if (StringUtils.isEmpty(string) || CharSetUtils.deepEmpty(stringArray)) {
            return false;
        }
        CharSet charSet = CharSet.getInstance(stringArray);
        for (char c2 : string.toCharArray()) {
            if (!charSet.contains(c2)) continue;
            return true;
        }
        return false;
    }

    public static int count(String string, String ... stringArray) {
        if (StringUtils.isEmpty(string) || CharSetUtils.deepEmpty(stringArray)) {
            return 0;
        }
        CharSet charSet = CharSet.getInstance(stringArray);
        int n2 = 0;
        for (char c2 : string.toCharArray()) {
            if (!charSet.contains(c2)) continue;
            ++n2;
        }
        return n2;
    }

    private static boolean deepEmpty(String[] stringArray) {
        if (stringArray != null) {
            for (String string : stringArray) {
                if (!StringUtils.isNotEmpty(string)) continue;
                return false;
            }
        }
        return true;
    }

    public static String delete(String string, String ... stringArray) {
        if (StringUtils.isEmpty(string) || CharSetUtils.deepEmpty(stringArray)) {
            return string;
        }
        return CharSetUtils.modify(string, stringArray, false);
    }

    public static String keep(String string, String ... stringArray) {
        if (string == null) {
            return null;
        }
        if (string.isEmpty() || CharSetUtils.deepEmpty(stringArray)) {
            return "";
        }
        return CharSetUtils.modify(string, stringArray, true);
    }

    private static String modify(String string, String[] stringArray, boolean bl2) {
        char[] cArray;
        CharSet charSet = CharSet.getInstance(stringArray);
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (char c2 : cArray = string.toCharArray()) {
            if (charSet.contains(c2) != bl2) continue;
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public static String squeeze(String string, String ... stringArray) {
        if (StringUtils.isEmpty(string) || CharSetUtils.deepEmpty(stringArray)) {
            return string;
        }
        CharSet charSet = CharSet.getInstance(stringArray);
        StringBuilder stringBuilder = new StringBuilder(string.length());
        char[] cArray = string.toCharArray();
        int n2 = cArray.length;
        char c2 = cArray[0];
        char c3 = ' ';
        Character c4 = null;
        Character c5 = null;
        stringBuilder.append(c2);
        for (int i2 = 1; i2 < n2; ++i2) {
            c3 = cArray[i2];
            if (c3 == c2) {
                if (c4 != null && c3 == c4.charValue()) continue;
                if (c5 == null || c3 != c5.charValue()) {
                    if (charSet.contains(c3)) {
                        c4 = Character.valueOf(c3);
                        continue;
                    }
                    c5 = Character.valueOf(c3);
                }
            }
            stringBuilder.append(c3);
            c2 = c3;
        }
        return stringBuilder.toString();
    }
}

