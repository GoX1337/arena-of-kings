/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text;

import java.util.Arrays;
import org.apache.commons.lang3.ArraySorter;
import org.apache.commons.lang3.StringUtils;

@Deprecated
public abstract class StrMatcher {
    private static final StrMatcher COMMA_MATCHER = new CharMatcher(',');
    private static final StrMatcher TAB_MATCHER = new CharMatcher('\t');
    private static final StrMatcher SPACE_MATCHER = new CharMatcher(' ');
    private static final StrMatcher SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
    private static final StrMatcher TRIM_MATCHER = new TrimMatcher();
    private static final StrMatcher SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
    private static final StrMatcher DOUBLE_QUOTE_MATCHER = new CharMatcher('\"');
    private static final StrMatcher QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
    private static final StrMatcher NONE_MATCHER = new NoMatcher();

    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public static StrMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }

    public static StrMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public static StrMatcher charMatcher(char c2) {
        return new CharMatcher(c2);
    }

    public static StrMatcher charSetMatcher(char ... cArray) {
        if (cArray == null || cArray.length == 0) {
            return NONE_MATCHER;
        }
        if (cArray.length == 1) {
            return new CharMatcher(cArray[0]);
        }
        return new CharSetMatcher(cArray);
    }

    public static StrMatcher charSetMatcher(String string) {
        if (StringUtils.isEmpty(string)) {
            return NONE_MATCHER;
        }
        if (string.length() == 1) {
            return new CharMatcher(string.charAt(0));
        }
        return new CharSetMatcher(string.toCharArray());
    }

    public static StrMatcher stringMatcher(String string) {
        if (StringUtils.isEmpty(string)) {
            return NONE_MATCHER;
        }
        return new StringMatcher(string);
    }

    protected StrMatcher() {
    }

    public abstract int isMatch(char[] var1, int var2, int var3, int var4);

    public int isMatch(char[] cArray, int n2) {
        return this.isMatch(cArray, n2, 0, cArray.length);
    }

    static final class TrimMatcher
    extends StrMatcher {
        TrimMatcher() {
        }

        @Override
        public int isMatch(char[] cArray, int n2, int n3, int n4) {
            return cArray[n2] <= ' ' ? 1 : 0;
        }
    }

    static final class NoMatcher
    extends StrMatcher {
        NoMatcher() {
        }

        @Override
        public int isMatch(char[] cArray, int n2, int n3, int n4) {
            return 0;
        }
    }

    static final class StringMatcher
    extends StrMatcher {
        private final char[] chars;

        StringMatcher(String string) {
            this.chars = string.toCharArray();
        }

        @Override
        public int isMatch(char[] cArray, int n2, int n3, int n4) {
            int n5 = this.chars.length;
            if (n2 + n5 > n4) {
                return 0;
            }
            int n6 = 0;
            while (n6 < this.chars.length) {
                if (this.chars[n6] != cArray[n2]) {
                    return 0;
                }
                ++n6;
                ++n2;
            }
            return n5;
        }

        public String toString() {
            return super.toString() + ' ' + Arrays.toString(this.chars);
        }
    }

    static final class CharMatcher
    extends StrMatcher {
        private final char ch;

        CharMatcher(char c2) {
            this.ch = c2;
        }

        @Override
        public int isMatch(char[] cArray, int n2, int n3, int n4) {
            return this.ch == cArray[n2] ? 1 : 0;
        }
    }

    static final class CharSetMatcher
    extends StrMatcher {
        private final char[] chars;

        CharSetMatcher(char[] cArray) {
            this.chars = ArraySorter.sort((char[])cArray.clone());
        }

        @Override
        public int isMatch(char[] cArray, int n2, int n3, int n4) {
            return Arrays.binarySearch(this.chars, cArray[n2]) >= 0 ? 1 : 0;
        }
    }
}

