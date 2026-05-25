/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class DurationFormatUtils {
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";
    static final String y = "y";
    static final String M = "M";
    static final String d = "d";
    static final String H = "H";
    static final String m = "m";
    static final String s = "s";
    static final String S = "S";

    public static String formatDurationHMS(long l2) {
        return DurationFormatUtils.formatDuration(l2, "HH:mm:ss.SSS");
    }

    public static String formatDurationISO(long l2) {
        return DurationFormatUtils.formatDuration(l2, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDuration(long l2, String string) {
        return DurationFormatUtils.formatDuration(l2, string, true);
    }

    public static String formatDuration(long l2, String string, boolean bl2) {
        Validate.inclusiveBetween(0L, Long.MAX_VALUE, l2, "durationMillis must not be negative");
        Token[] tokenArray = DurationFormatUtils.lexx(string);
        long l3 = 0L;
        long l4 = 0L;
        long l5 = 0L;
        long l6 = 0L;
        long l7 = l2;
        if (Token.containsTokenWithValue(tokenArray, d)) {
            l3 = l7 / 86400000L;
            l7 -= l3 * 86400000L;
        }
        if (Token.containsTokenWithValue(tokenArray, H)) {
            l4 = l7 / 3600000L;
            l7 -= l4 * 3600000L;
        }
        if (Token.containsTokenWithValue(tokenArray, m)) {
            l5 = l7 / 60000L;
            l7 -= l5 * 60000L;
        }
        if (Token.containsTokenWithValue(tokenArray, s)) {
            l6 = l7 / 1000L;
            l7 -= l6 * 1000L;
        }
        return DurationFormatUtils.format(tokenArray, 0L, 0L, l3, l4, l5, l6, l7, bl2);
    }

    public static String formatDurationWords(long l2, boolean bl2, boolean bl3) {
        String string;
        String string2 = DurationFormatUtils.formatDuration(l2, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (bl2) {
            string2 = " " + string2;
            string = StringUtils.replaceOnce(string2, " 0 days", "");
            if (string.length() != string2.length() && (string = StringUtils.replaceOnce(string2 = string, " 0 hours", "")).length() != string2.length()) {
                string2 = string;
                string2 = string = StringUtils.replaceOnce(string2, " 0 minutes", "");
                if (string.length() != string2.length()) {
                    string2 = StringUtils.replaceOnce(string, " 0 seconds", "");
                }
            }
            if (!string2.isEmpty()) {
                string2 = string2.substring(1);
            }
        }
        if (bl3 && (string = StringUtils.replaceOnce(string2, " 0 seconds", "")).length() != string2.length() && (string = StringUtils.replaceOnce(string2 = string, " 0 minutes", "")).length() != string2.length() && (string = StringUtils.replaceOnce(string2 = string, " 0 hours", "")).length() != string2.length()) {
            string2 = StringUtils.replaceOnce(string, " 0 days", "");
        }
        string2 = " " + string2;
        string2 = StringUtils.replaceOnce(string2, " 1 seconds", " 1 second");
        string2 = StringUtils.replaceOnce(string2, " 1 minutes", " 1 minute");
        string2 = StringUtils.replaceOnce(string2, " 1 hours", " 1 hour");
        string2 = StringUtils.replaceOnce(string2, " 1 days", " 1 day");
        return string2.trim();
    }

    public static String formatPeriodISO(long l2, long l3) {
        return DurationFormatUtils.formatPeriod(l2, l3, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    public static String formatPeriod(long l2, long l3, String string) {
        return DurationFormatUtils.formatPeriod(l2, l3, string, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long l2, long l3, String string, boolean bl2, TimeZone timeZone) {
        Validate.isTrue(l2 <= l3, "startMillis must not be greater than endMillis", new Object[0]);
        Token[] tokenArray = DurationFormatUtils.lexx(string);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(l2));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(l3));
        int n2 = calendar2.get(14) - calendar.get(14);
        int n3 = calendar2.get(13) - calendar.get(13);
        int n4 = calendar2.get(12) - calendar.get(12);
        int n5 = calendar2.get(11) - calendar.get(11);
        int n6 = calendar2.get(5) - calendar.get(5);
        int n7 = calendar2.get(2) - calendar.get(2);
        int n8 = calendar2.get(1) - calendar.get(1);
        while (n2 < 0) {
            n2 += 1000;
            --n3;
        }
        while (n3 < 0) {
            n3 += 60;
            --n4;
        }
        while (n4 < 0) {
            n4 += 60;
            --n5;
        }
        while (n5 < 0) {
            n5 += 24;
            --n6;
        }
        if (Token.containsTokenWithValue(tokenArray, M)) {
            while (n6 < 0) {
                n6 += calendar.getActualMaximum(5);
                --n7;
                calendar.add(2, 1);
            }
            while (n7 < 0) {
                n7 += 12;
                --n8;
            }
            if (!Token.containsTokenWithValue(tokenArray, y) && n8 != 0) {
                while (n8 != 0) {
                    n7 += 12 * n8;
                    n8 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(tokenArray, y)) {
                int n9 = calendar2.get(1);
                if (n7 < 0) {
                    --n9;
                }
                while (calendar.get(1) != n9) {
                    n6 += calendar.getActualMaximum(6) - calendar.get(6);
                    if (calendar instanceof GregorianCalendar && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        ++n6;
                    }
                    calendar.add(1, 1);
                    n6 += calendar.get(6);
                }
                n8 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                n6 += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            n7 = 0;
            while (n6 < 0) {
                n6 += calendar.getActualMaximum(5);
                --n7;
                calendar.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(tokenArray, d)) {
            n5 += 24 * n6;
            n6 = 0;
        }
        if (!Token.containsTokenWithValue(tokenArray, H)) {
            n4 += 60 * n5;
            n5 = 0;
        }
        if (!Token.containsTokenWithValue(tokenArray, m)) {
            n3 += 60 * n4;
            n4 = 0;
        }
        if (!Token.containsTokenWithValue(tokenArray, s)) {
            n2 += 1000 * n3;
            n3 = 0;
        }
        return DurationFormatUtils.format(tokenArray, n8, n7, n6, n5, n4, n3, n2, bl2);
    }

    static String format(Token[] tokenArray, long l2, long l3, long l4, long l5, long l6, long l7, long l8, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl3 = false;
        for (Token token : tokenArray) {
            Object object = token.getValue();
            int n2 = token.getCount();
            if (object instanceof StringBuilder) {
                stringBuilder.append(object.toString());
                continue;
            }
            if (object.equals(y)) {
                stringBuilder.append(DurationFormatUtils.paddedValue(l2, bl2, n2));
                bl3 = false;
                continue;
            }
            if (object.equals(M)) {
                stringBuilder.append(DurationFormatUtils.paddedValue(l3, bl2, n2));
                bl3 = false;
                continue;
            }
            if (object.equals(d)) {
                stringBuilder.append(DurationFormatUtils.paddedValue(l4, bl2, n2));
                bl3 = false;
                continue;
            }
            if (object.equals(H)) {
                stringBuilder.append(DurationFormatUtils.paddedValue(l5, bl2, n2));
                bl3 = false;
                continue;
            }
            if (object.equals(m)) {
                stringBuilder.append(DurationFormatUtils.paddedValue(l6, bl2, n2));
                bl3 = false;
                continue;
            }
            if (object.equals(s)) {
                stringBuilder.append(DurationFormatUtils.paddedValue(l7, bl2, n2));
                bl3 = true;
                continue;
            }
            if (!object.equals(S)) continue;
            if (bl3) {
                int n3 = bl2 ? Math.max(3, n2) : 3;
                stringBuilder.append(DurationFormatUtils.paddedValue(l8, true, n3));
            } else {
                stringBuilder.append(DurationFormatUtils.paddedValue(l8, bl2, n2));
            }
            bl3 = false;
        }
        return stringBuilder.toString();
    }

    private static String paddedValue(long l2, boolean bl2, int n2) {
        String string = Long.toString(l2);
        return bl2 ? StringUtils.leftPad(string, n2, '0') : string;
    }

    static Token[] lexx(String string) {
        ArrayList<Token> arrayList = new ArrayList<Token>(string.length());
        boolean bl2 = false;
        StringBuilder stringBuilder = null;
        Token token = null;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (bl2 && c2 != '\'') {
                stringBuilder.append(c2);
                continue;
            }
            String string2 = null;
            switch (c2) {
                case '\'': {
                    if (bl2) {
                        stringBuilder = null;
                        bl2 = false;
                        break;
                    }
                    stringBuilder = new StringBuilder();
                    arrayList.add(new Token(stringBuilder));
                    bl2 = true;
                    break;
                }
                case 'y': {
                    string2 = y;
                    break;
                }
                case 'M': {
                    string2 = M;
                    break;
                }
                case 'd': {
                    string2 = d;
                    break;
                }
                case 'H': {
                    string2 = H;
                    break;
                }
                case 'm': {
                    string2 = m;
                    break;
                }
                case 's': {
                    string2 = s;
                    break;
                }
                case 'S': {
                    string2 = S;
                    break;
                }
                default: {
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                        arrayList.add(new Token(stringBuilder));
                    }
                    stringBuilder.append(c2);
                }
            }
            if (string2 == null) continue;
            if (token != null && token.getValue().equals(string2)) {
                token.increment();
            } else {
                Token token2 = new Token(string2);
                arrayList.add(token2);
                token = token2;
            }
            stringBuilder = null;
        }
        if (bl2) {
            throw new IllegalArgumentException("Unmatched quote in format: " + string);
        }
        return arrayList.toArray(Token.EMPTY_ARRAY);
    }

    static class Token {
        private static final Token[] EMPTY_ARRAY = new Token[0];
        private final Object value;
        private int count;

        static boolean containsTokenWithValue(Token[] tokenArray, Object object) {
            for (Token token : tokenArray) {
                if (token.getValue() != object) continue;
                return true;
            }
            return false;
        }

        Token(Object object) {
            this.value = object;
            this.count = 1;
        }

        Token(Object object, int n2) {
            this.value = object;
            this.count = n2;
        }

        void increment() {
            ++this.count;
        }

        int getCount() {
            return this.count;
        }

        Object getValue() {
            return this.value;
        }

        public boolean equals(Object object) {
            if (object instanceof Token) {
                Token token = (Token)object;
                if (this.value.getClass() != token.value.getClass()) {
                    return false;
                }
                if (this.count != token.count) {
                    return false;
                }
                if (this.value instanceof StringBuilder) {
                    return this.value.toString().equals(token.value.toString());
                }
                if (this.value instanceof Number) {
                    return this.value.equals(token.value);
                }
                return this.value == token.value;
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }
}

