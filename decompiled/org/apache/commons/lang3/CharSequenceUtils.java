/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class CharSequenceUtils {
    private static final int NOT_FOUND = -1;
    static final int TO_STRING_LIMIT = 16;

    public static CharSequence subSequence(CharSequence charSequence, int n2) {
        return charSequence == null ? null : charSequence.subSequence(n2, charSequence.length());
    }

    static int indexOf(CharSequence charSequence, int n2, int n3) {
        if (charSequence instanceof String) {
            return ((String)charSequence).indexOf(n2, n3);
        }
        int n4 = charSequence.length();
        if (n3 < 0) {
            n3 = 0;
        }
        if (n2 < 65536) {
            for (int i2 = n3; i2 < n4; ++i2) {
                if (charSequence.charAt(i2) != n2) continue;
                return i2;
            }
            return -1;
        }
        if (n2 <= 0x10FFFF) {
            char[] cArray = Character.toChars(n2);
            for (int i3 = n3; i3 < n4 - 1; ++i3) {
                char c2 = charSequence.charAt(i3);
                char c3 = charSequence.charAt(i3 + 1);
                if (c2 != cArray[0] || c3 != cArray[1]) continue;
                return i3;
            }
        }
        return -1;
    }

    static int indexOf(CharSequence charSequence, CharSequence charSequence2, int n2) {
        if (charSequence instanceof String) {
            return ((String)charSequence).indexOf(charSequence2.toString(), n2);
        }
        if (charSequence instanceof StringBuilder) {
            return ((StringBuilder)charSequence).indexOf(charSequence2.toString(), n2);
        }
        if (charSequence instanceof StringBuffer) {
            return ((StringBuffer)charSequence).indexOf(charSequence2.toString(), n2);
        }
        return charSequence.toString().indexOf(charSequence2.toString(), n2);
    }

    static int lastIndexOf(CharSequence charSequence, int n2, int n3) {
        if (charSequence instanceof String) {
            return ((String)charSequence).lastIndexOf(n2, n3);
        }
        int n4 = charSequence.length();
        if (n3 < 0) {
            return -1;
        }
        if (n3 >= n4) {
            n3 = n4 - 1;
        }
        if (n2 < 65536) {
            for (int i2 = n3; i2 >= 0; --i2) {
                if (charSequence.charAt(i2) != n2) continue;
                return i2;
            }
            return -1;
        }
        if (n2 <= 0x10FFFF) {
            char[] cArray = Character.toChars(n2);
            if (n3 == n4 - 1) {
                return -1;
            }
            for (int i3 = n3; i3 >= 0; --i3) {
                char c2 = charSequence.charAt(i3);
                char c3 = charSequence.charAt(i3 + 1);
                if (cArray[0] != c2 || cArray[1] != c3) continue;
                return i3;
            }
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     */
    static int lastIndexOf(CharSequence var0, CharSequence var1_1, int var2_2) {
        if (var1_1 == null || var0 == null) {
            return -1;
        }
        if (var1_1 instanceof String) {
            if (var0 instanceof String) {
                return ((String)var0).lastIndexOf((String)var1_1, var2_2);
            }
            if (var0 instanceof StringBuilder) {
                return ((StringBuilder)var0).lastIndexOf((String)var1_1, var2_2);
            }
            if (var0 instanceof StringBuffer) {
                return ((StringBuffer)var0).lastIndexOf((String)var1_1, var2_2);
            }
        }
        var3_3 = var0.length();
        var4_4 = var1_1.length();
        if (var2_2 > var3_3) {
            var2_2 = var3_3;
        }
        if (var2_2 < 0 || var4_4 < 0 || var4_4 > var3_3) {
            return -1;
        }
        if (var4_4 == 0) {
            return var2_2;
        }
        if (var4_4 <= 16) {
            if (var0 instanceof String) {
                return ((String)var0).lastIndexOf(var1_1.toString(), var2_2);
            }
            if (var0 instanceof StringBuilder) {
                return ((StringBuilder)var0).lastIndexOf(var1_1.toString(), var2_2);
            }
            if (var0 instanceof StringBuffer) {
                return ((StringBuffer)var0).lastIndexOf(var1_1.toString(), var2_2);
            }
        }
        if (var2_2 + var4_4 > var3_3) {
            var2_2 = var3_3 - var4_4;
        }
        var5_5 = var1_1.charAt(0);
        var6_6 = var2_2;
        do lbl-1000:
        // 3 sources

        {
            block14: {
                if (var0.charAt(var6_6) == var5_5) break block14;
                if (--var6_6 >= 0) ** GOTO lbl-1000
                return -1;
            }
            if (!CharSequenceUtils.checkLaterThan1(var0, var1_1, var4_4, var6_6)) continue;
            return var6_6;
        } while (--var6_6 >= 0);
        return -1;
    }

    private static boolean checkLaterThan1(CharSequence charSequence, CharSequence charSequence2, int n2, int n3) {
        int n4 = 1;
        for (int i2 = n2 - 1; n4 <= i2; ++n4, --i2) {
            if (charSequence.charAt(n3 + n4) == charSequence2.charAt(n4) && charSequence.charAt(n3 + i2) == charSequence2.charAt(i2)) continue;
            return false;
        }
        return true;
    }

    public static char[] toCharArray(CharSequence charSequence) {
        int n2 = StringUtils.length(charSequence);
        if (n2 == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        if (charSequence instanceof String) {
            return ((String)charSequence).toCharArray();
        }
        char[] cArray = new char[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            cArray[i2] = charSequence.charAt(i2);
        }
        return cArray;
    }

    static boolean regionMatches(CharSequence charSequence, boolean bl2, int n2, CharSequence charSequence2, int n3, int n4) {
        if (charSequence instanceof String && charSequence2 instanceof String) {
            return ((String)charSequence).regionMatches(bl2, n2, (String)charSequence2, n3, n4);
        }
        int n5 = n2;
        int n6 = n3;
        int n7 = n4;
        int n8 = charSequence.length() - n2;
        int n9 = charSequence2.length() - n3;
        if (n2 < 0 || n3 < 0 || n4 < 0) {
            return false;
        }
        if (n8 < n4 || n9 < n4) {
            return false;
        }
        while (n7-- > 0) {
            char c2;
            char c3;
            char c4;
            if ((c4 = charSequence.charAt(n5++)) == (c3 = charSequence2.charAt(n6++))) continue;
            if (!bl2) {
                return false;
            }
            char c5 = Character.toUpperCase(c4);
            if (c5 == (c2 = Character.toUpperCase(c3)) || Character.toLowerCase(c5) == Character.toLowerCase(c2)) continue;
            return false;
        }
        return true;
    }
}

