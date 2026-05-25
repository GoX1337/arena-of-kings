/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.DatePrinter;

public class FastDatePrinter
implements Serializable,
DatePrinter {
    private static final Rule[] EMPTY_RULE_ARRAY = new Rule[0];
    private static final long serialVersionUID = 1L;
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private final String mPattern;
    private final TimeZone mTimeZone;
    private final Locale mLocale;
    private transient Rule[] mRules;
    private transient int mMaxLengthEstimate;
    private static final int MAX_DIGITS = 10;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap<TimeZoneDisplayKey, String>(7);

    protected FastDatePrinter(String string, TimeZone timeZone, Locale locale) {
        this.mPattern = string;
        this.mTimeZone = timeZone;
        this.mLocale = LocaleUtils.toLocale(locale);
        this.init();
    }

    private void init() {
        List<Rule> list = this.parsePattern();
        this.mRules = list.toArray(EMPTY_RULE_ARRAY);
        int n2 = 0;
        int n3 = this.mRules.length;
        while (--n3 >= 0) {
            n2 += this.mRules[n3].estimateLength();
        }
        this.mMaxLengthEstimate = n2;
    }

    protected List<Rule> parsePattern() {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList<Rule> arrayList = new ArrayList<Rule>();
        String[] stringArray = dateFormatSymbols.getEras();
        String[] stringArray2 = dateFormatSymbols.getMonths();
        String[] stringArray3 = dateFormatSymbols.getShortMonths();
        String[] stringArray4 = dateFormatSymbols.getWeekdays();
        String[] stringArray5 = dateFormatSymbols.getShortWeekdays();
        String[] stringArray6 = dateFormatSymbols.getAmPmStrings();
        int n2 = this.mPattern.length();
        int[] nArray = new int[1];
        for (int i2 = 0; i2 < n2; ++i2) {
            Rule rule;
            nArray[0] = i2;
            String string = this.parseToken(this.mPattern, nArray);
            i2 = nArray[0];
            int n3 = string.length();
            if (n3 == 0) break;
            char c2 = string.charAt(0);
            switch (c2) {
                case 'G': {
                    rule = new TextField(0, stringArray);
                    break;
                }
                case 'Y': 
                case 'y': {
                    rule = n3 == 2 ? TwoDigitYearField.INSTANCE : this.selectNumberRule(1, Math.max(n3, 4));
                    if (c2 != 'Y') break;
                    rule = new WeekYear((NumberRule)rule);
                    break;
                }
                case 'M': {
                    if (n3 >= 4) {
                        rule = new TextField(2, stringArray2);
                        break;
                    }
                    if (n3 == 3) {
                        rule = new TextField(2, stringArray3);
                        break;
                    }
                    if (n3 == 2) {
                        rule = TwoDigitMonthField.INSTANCE;
                        break;
                    }
                    rule = UnpaddedMonthField.INSTANCE;
                    break;
                }
                case 'd': {
                    rule = this.selectNumberRule(5, n3);
                    break;
                }
                case 'h': {
                    rule = new TwelveHourField(this.selectNumberRule(10, n3));
                    break;
                }
                case 'H': {
                    rule = this.selectNumberRule(11, n3);
                    break;
                }
                case 'm': {
                    rule = this.selectNumberRule(12, n3);
                    break;
                }
                case 's': {
                    rule = this.selectNumberRule(13, n3);
                    break;
                }
                case 'S': {
                    rule = this.selectNumberRule(14, n3);
                    break;
                }
                case 'E': {
                    rule = new TextField(7, n3 < 4 ? stringArray5 : stringArray4);
                    break;
                }
                case 'u': {
                    rule = new DayInWeekField(this.selectNumberRule(7, n3));
                    break;
                }
                case 'D': {
                    rule = this.selectNumberRule(6, n3);
                    break;
                }
                case 'F': {
                    rule = this.selectNumberRule(8, n3);
                    break;
                }
                case 'w': {
                    rule = this.selectNumberRule(3, n3);
                    break;
                }
                case 'W': {
                    rule = this.selectNumberRule(4, n3);
                    break;
                }
                case 'a': {
                    rule = new TextField(9, stringArray6);
                    break;
                }
                case 'k': {
                    rule = new TwentyFourHourField(this.selectNumberRule(11, n3));
                    break;
                }
                case 'K': {
                    rule = this.selectNumberRule(10, n3);
                    break;
                }
                case 'X': {
                    rule = Iso8601_Rule.getRule(n3);
                    break;
                }
                case 'z': {
                    if (n3 >= 4) {
                        rule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1);
                        break;
                    }
                    rule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
                    break;
                }
                case 'Z': {
                    if (n3 == 1) {
                        rule = TimeZoneNumberRule.INSTANCE_NO_COLON;
                        break;
                    }
                    if (n3 == 2) {
                        rule = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                        break;
                    }
                    rule = TimeZoneNumberRule.INSTANCE_COLON;
                    break;
                }
                case '\'': {
                    String string2 = string.substring(1);
                    if (string2.length() == 1) {
                        rule = new CharacterLiteral(string2.charAt(0));
                        break;
                    }
                    rule = new StringLiteral(string2);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Illegal pattern component: " + string);
                }
            }
            arrayList.add(rule);
        }
        return arrayList;
    }

    protected String parseToken(String string, int[] nArray) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = string.length();
        char c2 = string.charAt(n2);
        if (c2 >= 'A' && c2 <= 'Z' || c2 >= 'a' && c2 <= 'z') {
            char c3;
            stringBuilder.append(c2);
            while (n2 + 1 < n3 && (c3 = string.charAt(n2 + 1)) == c2) {
                stringBuilder.append(c2);
                ++n2;
            }
        } else {
            stringBuilder.append('\'');
            boolean bl2 = false;
            for (n2 = nArray[0]; n2 < n3; ++n2) {
                c2 = string.charAt(n2);
                if (c2 == '\'') {
                    if (n2 + 1 < n3 && string.charAt(n2 + 1) == '\'') {
                        ++n2;
                        stringBuilder.append(c2);
                        continue;
                    }
                    bl2 = !bl2;
                    continue;
                }
                if (bl2 || (c2 < 'A' || c2 > 'Z') && (c2 < 'a' || c2 > 'z')) {
                    stringBuilder.append(c2);
                    continue;
                }
                break;
            }
        }
        nArray[0] = --n2;
        return stringBuilder.toString();
    }

    protected NumberRule selectNumberRule(int n2, int n3) {
        switch (n3) {
            case 1: {
                return new UnpaddedNumberField(n2);
            }
            case 2: {
                return new TwoDigitNumberField(n2);
            }
        }
        return new PaddedNumberField(n2, n3);
    }

    @Override
    @Deprecated
    public StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (object instanceof Date) {
            return this.format((Date)object, stringBuffer);
        }
        if (object instanceof Calendar) {
            return this.format((Calendar)object, stringBuffer);
        }
        if (object instanceof Long) {
            return this.format((long)((Long)object), stringBuffer);
        }
        throw new IllegalArgumentException("Unknown class: " + (object == null ? "<null>" : object.getClass().getName()));
    }

    String format(Object object) {
        if (object instanceof Date) {
            return this.format((Date)object);
        }
        if (object instanceof Calendar) {
            return this.format((Calendar)object);
        }
        if (object instanceof Long) {
            return this.format((Long)object);
        }
        throw new IllegalArgumentException("Unknown class: " + (object == null ? "<null>" : object.getClass().getName()));
    }

    @Override
    public String format(long l2) {
        Calendar calendar = this.newCalendar();
        calendar.setTimeInMillis(l2);
        return this.applyRulesToString(calendar);
    }

    private String applyRulesToString(Calendar calendar) {
        return this.applyRules(calendar, new StringBuilder(this.mMaxLengthEstimate)).toString();
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    @Override
    public String format(Date date) {
        Calendar calendar = this.newCalendar();
        calendar.setTime(date);
        return this.applyRulesToString(calendar);
    }

    @Override
    public String format(Calendar calendar) {
        return this.format(calendar, new StringBuilder(this.mMaxLengthEstimate)).toString();
    }

    @Override
    public StringBuffer format(long l2, StringBuffer stringBuffer) {
        Calendar calendar = this.newCalendar();
        calendar.setTimeInMillis(l2);
        return this.applyRules(calendar, (Appendable)stringBuffer);
    }

    @Override
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar calendar = this.newCalendar();
        calendar.setTime(date);
        return this.applyRules(calendar, (Appendable)stringBuffer);
    }

    @Override
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return this.format(calendar.getTime(), stringBuffer);
    }

    @Override
    public <B extends Appendable> B format(long l2, B b2) {
        Calendar calendar = this.newCalendar();
        calendar.setTimeInMillis(l2);
        return this.applyRules(calendar, b2);
    }

    @Override
    public <B extends Appendable> B format(Date date, B b2) {
        Calendar calendar = this.newCalendar();
        calendar.setTime(date);
        return this.applyRules(calendar, b2);
    }

    @Override
    public <B extends Appendable> B format(Calendar calendar, B b2) {
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar = (Calendar)calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return this.applyRules(calendar, b2);
    }

    @Deprecated
    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return this.applyRules(calendar, (Appendable)stringBuffer);
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b2) {
        try {
            for (Rule rule : this.mRules) {
                rule.appendTo(b2, calendar);
            }
        }
        catch (IOException iOException) {
            ExceptionUtils.rethrow(iOException);
        }
        return b2;
    }

    @Override
    public String getPattern() {
        return this.mPattern;
    }

    @Override
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    @Override
    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public boolean equals(Object object) {
        if (!(object instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter)object;
        return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
    }

    public int hashCode() {
        return this.mPattern.hashCode() + 13 * (this.mTimeZone.hashCode() + 13 * this.mLocale.hashCode());
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.init();
    }

    private static void appendDigits(Appendable appendable, int n2) {
        appendable.append((char)(n2 / 10 + 48));
        appendable.append((char)(n2 % 10 + 48));
    }

    private static void appendFullDigits(Appendable appendable, int n2, int n3) {
        if (n2 < 10000) {
            int n4 = 4;
            if (n2 < 1000) {
                --n4;
                if (n2 < 100) {
                    --n4;
                    if (n2 < 10) {
                        --n4;
                    }
                }
            }
            for (int i2 = n3 - n4; i2 > 0; --i2) {
                appendable.append('0');
            }
            switch (n4) {
                case 4: {
                    appendable.append((char)(n2 / 1000 + 48));
                    n2 %= 1000;
                }
                case 3: {
                    if (n2 >= 100) {
                        appendable.append((char)(n2 / 100 + 48));
                        n2 %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                case 2: {
                    if (n2 >= 10) {
                        appendable.append((char)(n2 / 10 + 48));
                        n2 %= 10;
                    } else {
                        appendable.append('0');
                    }
                }
                case 1: {
                    appendable.append((char)(n2 + 48));
                }
            }
        } else {
            char[] cArray = new char[10];
            int n5 = 0;
            while (n2 != 0) {
                cArray[n5++] = (char)(n2 % 10 + 48);
                n2 /= 10;
            }
            while (n5 < n3) {
                appendable.append('0');
                --n3;
            }
            while (--n5 >= 0) {
                appendable.append(cArray[n5]);
            }
        }
    }

    static String getTimeZoneDisplay(TimeZone timeZone, boolean bl2, int n2, Locale locale) {
        String string;
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, bl2, n2, locale);
        String string2 = (String)cTimeZoneDisplayCache.get(timeZoneDisplayKey);
        if (string2 == null && (string = cTimeZoneDisplayCache.putIfAbsent(timeZoneDisplayKey, string2 = timeZone.getDisplayName(bl2, n2, locale))) != null) {
            string2 = string;
        }
        return string2;
    }

    static class TimeZoneDisplayKey {
        private final TimeZone mTimeZone;
        private final int mStyle;
        private final Locale mLocale;

        TimeZoneDisplayKey(TimeZone timeZone, boolean bl2, int n2, Locale locale) {
            this.mTimeZone = timeZone;
            this.mStyle = bl2 ? n2 | Integer.MIN_VALUE : n2;
            this.mLocale = LocaleUtils.toLocale(locale);
        }

        public int hashCode() {
            return (this.mStyle * 31 + this.mLocale.hashCode()) * 31 + this.mTimeZone.hashCode();
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object instanceof TimeZoneDisplayKey) {
                TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey)object;
                return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
            }
            return false;
        }
    }

    static class Iso8601_Rule
    implements Rule {
        static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);
        final int length;

        static Iso8601_Rule getRule(int n2) {
            switch (n2) {
                case 1: {
                    return ISO8601_HOURS;
                }
                case 2: {
                    return ISO8601_HOURS_MINUTES;
                }
                case 3: {
                    return ISO8601_HOURS_COLON_MINUTES;
                }
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        Iso8601_Rule(int n2) {
            this.length = n2;
        }

        @Override
        public int estimateLength() {
            return this.length;
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            int n2 = calendar.get(15) + calendar.get(16);
            if (n2 == 0) {
                appendable.append("Z");
                return;
            }
            if (n2 < 0) {
                appendable.append('-');
                n2 = -n2;
            } else {
                appendable.append('+');
            }
            int n3 = n2 / 3600000;
            FastDatePrinter.appendDigits(appendable, n3);
            if (this.length < 5) {
                return;
            }
            if (this.length == 6) {
                appendable.append(':');
            }
            int n4 = n2 / 60000 - 60 * n3;
            FastDatePrinter.appendDigits(appendable, n4);
        }
    }

    static class TimeZoneNumberRule
    implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        TimeZoneNumberRule(boolean bl2) {
            this.mColon = bl2;
        }

        @Override
        public int estimateLength() {
            return 5;
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            int n2 = calendar.get(15) + calendar.get(16);
            if (n2 < 0) {
                appendable.append('-');
                n2 = -n2;
            } else {
                appendable.append('+');
            }
            int n3 = n2 / 3600000;
            FastDatePrinter.appendDigits(appendable, n3);
            if (this.mColon) {
                appendable.append(':');
            }
            int n4 = n2 / 60000 - 60 * n3;
            FastDatePrinter.appendDigits(appendable, n4);
        }
    }

    static class TimeZoneNameRule
    implements Rule {
        private final Locale mLocale;
        private final int mStyle;
        private final String mStandard;
        private final String mDaylight;

        TimeZoneNameRule(TimeZone timeZone, Locale locale, int n2) {
            this.mLocale = LocaleUtils.toLocale(locale);
            this.mStyle = n2;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, n2, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, n2, locale);
        }

        @Override
        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            TimeZone timeZone = calendar.getTimeZone();
            if (calendar.get(16) == 0) {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            } else {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            }
        }
    }

    static class WeekYear
    implements NumberRule {
        private final NumberRule mRule;

        WeekYear(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            this.mRule.appendTo(appendable, calendar.getWeekYear());
        }

        @Override
        public void appendTo(Appendable appendable, int n2) {
            this.mRule.appendTo(appendable, n2);
        }
    }

    static class DayInWeekField
    implements NumberRule {
        private final NumberRule mRule;

        DayInWeekField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            int n2 = calendar.get(7);
            this.mRule.appendTo(appendable, n2 == 1 ? 7 : n2 - 1);
        }

        @Override
        public void appendTo(Appendable appendable, int n2) {
            this.mRule.appendTo(appendable, n2);
        }
    }

    static class TwentyFourHourField
    implements NumberRule {
        private final NumberRule mRule;

        TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            int n2 = calendar.get(11);
            if (n2 == 0) {
                n2 = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(appendable, n2);
        }

        @Override
        public void appendTo(Appendable appendable, int n2) {
            this.mRule.appendTo(appendable, n2);
        }
    }

    static class TwelveHourField
    implements NumberRule {
        private final NumberRule mRule;

        TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            int n2 = calendar.get(10);
            if (n2 == 0) {
                n2 = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(appendable, n2);
        }

        @Override
        public void appendTo(Appendable appendable, int n2) {
            this.mRule.appendTo(appendable, n2);
        }
    }

    static class TwoDigitMonthField
    implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        @Override
        public int estimateLength() {
            return 2;
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            this.appendTo(appendable, calendar.get(2) + 1);
        }

        @Override
        public final void appendTo(Appendable appendable, int n2) {
            FastDatePrinter.appendDigits(appendable, n2);
        }
    }

    static class TwoDigitYearField
    implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        @Override
        public int estimateLength() {
            return 2;
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            this.appendTo(appendable, calendar.get(1) % 100);
        }

        @Override
        public final void appendTo(Appendable appendable, int n2) {
            FastDatePrinter.appendDigits(appendable, n2 % 100);
        }
    }

    static class TwoDigitNumberField
    implements NumberRule {
        private final int mField;

        TwoDigitNumberField(int n2) {
            this.mField = n2;
        }

        @Override
        public int estimateLength() {
            return 2;
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            this.appendTo(appendable, calendar.get(this.mField));
        }

        @Override
        public final void appendTo(Appendable appendable, int n2) {
            if (n2 < 100) {
                FastDatePrinter.appendDigits(appendable, n2);
            } else {
                FastDatePrinter.appendFullDigits(appendable, n2, 2);
            }
        }
    }

    static class PaddedNumberField
    implements NumberRule {
        private final int mField;
        private final int mSize;

        PaddedNumberField(int n2, int n3) {
            if (n3 < 3) {
                throw new IllegalArgumentException();
            }
            this.mField = n2;
            this.mSize = n3;
        }

        @Override
        public int estimateLength() {
            return this.mSize;
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            this.appendTo(appendable, calendar.get(this.mField));
        }

        @Override
        public final void appendTo(Appendable appendable, int n2) {
            FastDatePrinter.appendFullDigits(appendable, n2, this.mSize);
        }
    }

    static class UnpaddedMonthField
    implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        @Override
        public int estimateLength() {
            return 2;
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            this.appendTo(appendable, calendar.get(2) + 1);
        }

        @Override
        public final void appendTo(Appendable appendable, int n2) {
            if (n2 < 10) {
                appendable.append((char)(n2 + 48));
            } else {
                FastDatePrinter.appendDigits(appendable, n2);
            }
        }
    }

    static class UnpaddedNumberField
    implements NumberRule {
        private final int mField;

        UnpaddedNumberField(int n2) {
            this.mField = n2;
        }

        @Override
        public int estimateLength() {
            return 4;
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            this.appendTo(appendable, calendar.get(this.mField));
        }

        @Override
        public final void appendTo(Appendable appendable, int n2) {
            if (n2 < 10) {
                appendable.append((char)(n2 + 48));
            } else if (n2 < 100) {
                FastDatePrinter.appendDigits(appendable, n2);
            } else {
                FastDatePrinter.appendFullDigits(appendable, n2, 1);
            }
        }
    }

    static class TextField
    implements Rule {
        private final int mField;
        private final String[] mValues;

        TextField(int n2, String[] stringArray) {
            this.mField = n2;
            this.mValues = stringArray;
        }

        @Override
        public int estimateLength() {
            int n2 = 0;
            int n3 = this.mValues.length;
            while (--n3 >= 0) {
                int n4 = this.mValues[n3].length();
                if (n4 <= n2) continue;
                n2 = n4;
            }
            return n2;
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            appendable.append(this.mValues[calendar.get(this.mField)]);
        }
    }

    static class StringLiteral
    implements Rule {
        private final String mValue;

        StringLiteral(String string) {
            this.mValue = string;
        }

        @Override
        public int estimateLength() {
            return this.mValue.length();
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            appendable.append(this.mValue);
        }
    }

    static class CharacterLiteral
    implements Rule {
        private final char mValue;

        CharacterLiteral(char c2) {
            this.mValue = c2;
        }

        @Override
        public int estimateLength() {
            return 1;
        }

        @Override
        public void appendTo(Appendable appendable, Calendar calendar) {
            appendable.append(this.mValue);
        }
    }

    static interface NumberRule
    extends Rule {
        public void appendTo(Appendable var1, int var2);
    }

    static interface Rule {
        public int estimateLength();

        public void appendTo(Appendable var1, Calendar var2);
    }
}

