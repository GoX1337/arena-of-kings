/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

@Deprecated
public class WordUtils {
    public static String wrap(String string, int n2) {
        return WordUtils.wrap(string, n2, null, false);
    }

    public static String wrap(String string, int n2, String string2, boolean bl2) {
        return WordUtils.wrap(string, n2, string2, bl2, " ");
    }

    public static String wrap(String string, int n2, String string2, boolean bl2, String string3) {
        if (string == null) {
            return null;
        }
        if (string2 == null) {
            string2 = System.lineSeparator();
        }
        if (n2 < 1) {
            n2 = 1;
        }
        if (StringUtils.isBlank(string3)) {
            string3 = " ";
        }
        Pattern pattern = Pattern.compile(string3);
        int n3 = string.length();
        int n4 = 0;
        StringBuilder stringBuilder = new StringBuilder(n3 + 32);
        while (n4 < n3) {
            int n5 = -1;
            Matcher matcher = pattern.matcher(string.substring(n4, Math.min((int)Math.min(Integer.MAX_VALUE, (long)(n4 + n2) + 1L), n3)));
            if (matcher.find()) {
                if (matcher.start() == 0) {
                    n4 += matcher.end();
                    continue;
                }
                n5 = matcher.start() + n4;
            }
            if (n3 - n4 <= n2) break;
            while (matcher.find()) {
                n5 = matcher.start() + n4;
            }
            if (n5 >= n4) {
                stringBuilder.append(string, n4, n5);
                stringBuilder.append(string2);
                n4 = n5 + 1;
                continue;
            }
            if (bl2) {
                stringBuilder.append(string, n4, n2 + n4);
                stringBuilder.append(string2);
                n4 += n2;
                continue;
            }
            matcher = pattern.matcher(string.substring(n4 + n2));
            if (matcher.find()) {
                n5 = matcher.start() + n4 + n2;
            }
            if (n5 >= 0) {
                stringBuilder.append(string, n4, n5);
                stringBuilder.append(string2);
                n4 = n5 + 1;
                continue;
            }
            stringBuilder.append(string, n4, string.length());
            n4 = n3;
        }
        stringBuilder.append(string, n4, string.length());
        return stringBuilder.toString();
    }

    public static String capitalize(String string) {
        return WordUtils.capitalize(string, null);
    }

    public static String capitalize(String string, char ... cArray) {
        int n2;
        int n3 = n2 = cArray == null ? -1 : cArray.length;
        if (StringUtils.isEmpty(string) || n2 == 0) {
            return string;
        }
        char[] cArray2 = string.toCharArray();
        boolean bl2 = true;
        for (int i2 = 0; i2 < cArray2.length; ++i2) {
            char c2 = cArray2[i2];
            if (WordUtils.isDelimiter(c2, cArray)) {
                bl2 = true;
                continue;
            }
            if (!bl2) continue;
            cArray2[i2] = Character.toTitleCase(c2);
            bl2 = false;
        }
        return new String(cArray2);
    }

    public static String capitalizeFully(String string) {
        return WordUtils.capitalizeFully(string, null);
    }

    public static String capitalizeFully(String string, char ... cArray) {
        int n2;
        int n3 = n2 = cArray == null ? -1 : cArray.length;
        if (StringUtils.isEmpty(string) || n2 == 0) {
            return string;
        }
        string = string.toLowerCase();
        return WordUtils.capitalize(string, cArray);
    }

    public static String uncapitalize(String string) {
        return WordUtils.uncapitalize(string, null);
    }

    public static String uncapitalize(String string, char ... cArray) {
        int n2;
        int n3 = n2 = cArray == null ? -1 : cArray.length;
        if (StringUtils.isEmpty(string) || n2 == 0) {
            return string;
        }
        char[] cArray2 = string.toCharArray();
        boolean bl2 = true;
        for (int i2 = 0; i2 < cArray2.length; ++i2) {
            char c2 = cArray2[i2];
            if (WordUtils.isDelimiter(c2, cArray)) {
                bl2 = true;
                continue;
            }
            if (!bl2) continue;
            cArray2[i2] = Character.toLowerCase(c2);
            bl2 = false;
        }
        return new String(cArray2);
    }

    public static String swapCase(String string) {
        if (StringUtils.isEmpty(string)) {
            return string;
        }
        char[] cArray = string.toCharArray();
        boolean bl2 = true;
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            char c2 = cArray[i2];
            if (Character.isUpperCase(c2) || Character.isTitleCase(c2)) {
                cArray[i2] = Character.toLowerCase(c2);
                bl2 = false;
                continue;
            }
            if (Character.isLowerCase(c2)) {
                if (bl2) {
                    cArray[i2] = Character.toTitleCase(c2);
                    bl2 = false;
                    continue;
                }
                cArray[i2] = Character.toUpperCase(c2);
                continue;
            }
            bl2 = Character.isWhitespace(c2);
        }
        return new String(cArray);
    }

    public static String initials(String string) {
        return WordUtils.initials(string, null);
    }

    public static String initials(String string, char ... cArray) {
        if (StringUtils.isEmpty(string)) {
            return string;
        }
        if (cArray != null && cArray.length == 0) {
            return "";
        }
        int n2 = string.length();
        char[] cArray2 = new char[n2 / 2 + 1];
        int n3 = 0;
        boolean bl2 = true;
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            if (WordUtils.isDelimiter(c2, cArray)) {
                bl2 = true;
                continue;
            }
            if (!bl2) continue;
            cArray2[n3++] = c2;
            bl2 = false;
        }
        return new String(cArray2, 0, n3);
    }

    public static boolean containsAllWords(CharSequence charSequence, CharSequence ... charSequenceArray) {
        if (StringUtils.isEmpty(charSequence) || ArrayUtils.isEmpty(charSequenceArray)) {
            return false;
        }
        for (CharSequence charSequence2 : charSequenceArray) {
            if (StringUtils.isBlank(charSequence2)) {
                return false;
            }
            Pattern pattern = Pattern.compile(".*\\b" + charSequence2 + "\\b.*");
            if (pattern.matcher(charSequence).matches()) continue;
            return false;
        }
        return true;
    }

    private static boolean isDelimiter(char c2, char[] cArray) {
        if (cArray == null) {
            return Character.isWhitespace(c2);
        }
        for (char c3 : cArray) {
            if (c2 != c3) continue;
            return true;
        }
        return false;
    }
}

