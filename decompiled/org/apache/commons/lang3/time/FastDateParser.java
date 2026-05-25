/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.time;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.time.DateParser;
import org.apache.commons.lang3.time.FastTimeZone;

public class FastDateParser
implements Serializable,
DateParser {
    private static final long serialVersionUID = 3L;
    static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    private final String pattern;
    private final TimeZone timeZone;
    private final Locale locale;
    private final int century;
    private final int startYear;
    private transient List<StrategyAndWidth> patterns;
    private static final Comparator<String> LONGER_FIRST_LOWERCASE = Comparator.reverseOrder();
    private static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1){

        @Override
        int modify(FastDateParser fastDateParser, int n2) {
            return n2 < 100 ? fastDateParser.adjustYear(n2) : n2;
        }
    };
    private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2){

        @Override
        int modify(FastDateParser fastDateParser, int n2) {
            return n2 - 1;
        }
    };
    private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    private static final Strategy DAY_OF_WEEK_STRATEGY = new NumberStrategy(7){

        @Override
        int modify(FastDateParser fastDateParser, int n2) {
            return n2 == 7 ? 1 : n2 + 1;
        }
    };
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    private static final Strategy HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11){

        @Override
        int modify(FastDateParser fastDateParser, int n2) {
            return n2 == 24 ? 0 : n2;
        }
    };
    private static final Strategy HOUR12_STRATEGY = new NumberStrategy(10){

        @Override
        int modify(FastDateParser fastDateParser, int n2) {
            return n2 == 12 ? 0 : n2;
        }
    };
    private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);

    protected FastDateParser(String string, TimeZone timeZone, Locale locale) {
        this(string, timeZone, locale, null);
    }

    protected FastDateParser(String string, TimeZone timeZone, Locale locale, Date date) {
        int n2;
        this.pattern = string;
        this.timeZone = timeZone;
        this.locale = LocaleUtils.toLocale(locale);
        Calendar calendar = Calendar.getInstance(timeZone, this.locale);
        if (date != null) {
            calendar.setTime(date);
            n2 = calendar.get(1);
        } else if (this.locale.equals(JAPANESE_IMPERIAL)) {
            n2 = 0;
        } else {
            calendar.setTime(new Date());
            n2 = calendar.get(1) - 80;
        }
        this.century = n2 / 100 * 100;
        this.startYear = n2 - this.century;
        this.init(calendar);
    }

    private void init(Calendar calendar) {
        StrategyAndWidth strategyAndWidth;
        this.patterns = new ArrayList<StrategyAndWidth>();
        StrategyParser strategyParser = new StrategyParser(calendar);
        while ((strategyAndWidth = strategyParser.getNextStrategy()) != null) {
            this.patterns.add(strategyAndWidth);
        }
    }

    private static boolean isFormatLetter(char c2) {
        return c2 >= 'A' && c2 <= 'Z' || c2 >= 'a' && c2 <= 'z';
    }

    @Override
    public String getPattern() {
        return this.pattern;
    }

    @Override
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override
    public Locale getLocale() {
        return this.locale;
    }

    public boolean equals(Object object) {
        if (!(object instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser)object;
        return this.pattern.equals(fastDateParser.pattern) && this.timeZone.equals(fastDateParser.timeZone) && this.locale.equals(fastDateParser.locale);
    }

    public int hashCode() {
        return this.pattern.hashCode() + 13 * (this.timeZone.hashCode() + 13 * this.locale.hashCode());
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + ", " + this.locale + ", " + this.timeZone.getID() + "]";
    }

    public String toStringAll() {
        return "FastDateParser [pattern=" + this.pattern + ", timeZone=" + this.timeZone + ", locale=" + this.locale + ", century=" + this.century + ", startYear=" + this.startYear + ", patterns=" + this.patterns + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.init(calendar);
    }

    @Override
    public Object parseObject(String string) {
        return this.parse(string);
    }

    @Override
    public Date parse(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = this.parse(string, parsePosition);
        if (date == null) {
            if (this.locale.equals(JAPANESE_IMPERIAL)) {
                throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + string, parsePosition.getErrorIndex());
            }
            throw new ParseException("Unparseable date: " + string, parsePosition.getErrorIndex());
        }
        return date;
    }

    @Override
    public Object parseObject(String string, ParsePosition parsePosition) {
        return this.parse(string, parsePosition);
    }

    @Override
    public Date parse(String string, ParsePosition parsePosition) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        calendar.clear();
        return this.parse(string, parsePosition, calendar) ? calendar.getTime() : null;
    }

    @Override
    public boolean parse(String string, ParsePosition parsePosition, Calendar calendar) {
        ListIterator<StrategyAndWidth> listIterator = this.patterns.listIterator();
        while (listIterator.hasNext()) {
            StrategyAndWidth strategyAndWidth = listIterator.next();
            int n2 = strategyAndWidth.getMaxWidth(listIterator);
            if (strategyAndWidth.strategy.parse(this, calendar, string, parsePosition, n2)) continue;
            return false;
        }
        return true;
    }

    private static StringBuilder simpleQuote(StringBuilder stringBuilder, String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            switch (c2) {
                case '$': 
                case '(': 
                case ')': 
                case '*': 
                case '+': 
                case '.': 
                case '?': 
                case '[': 
                case '\\': 
                case '^': 
                case '{': 
                case '|': {
                    stringBuilder.append('\\');
                }
            }
            stringBuilder.append(c2);
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) == '.') {
            stringBuilder.append('?');
        }
        return stringBuilder;
    }

    private static Map<String, Integer> appendDisplayNames(Calendar calendar, Locale locale, int n2, StringBuilder stringBuilder) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        locale = LocaleUtils.toLocale(locale);
        Map<String, Integer> map = calendar.getDisplayNames(n2, 0, locale);
        TreeSet<String> treeSet = new TreeSet<String>(LONGER_FIRST_LOWERCASE);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String string = entry.getKey().toLowerCase(locale);
            if (!treeSet.add(string)) continue;
            hashMap.put(string, entry.getValue());
        }
        for (String string : treeSet) {
            FastDateParser.simpleQuote(stringBuilder, string).append('|');
        }
        return hashMap;
    }

    private int adjustYear(int n2) {
        int n3 = this.century + n2;
        return n2 >= this.startYear ? n3 : n3 + 100;
    }

    private Strategy getStrategy(char c2, int n2, Calendar calendar) {
        switch (c2) {
            default: {
                throw new IllegalArgumentException("Format '" + c2 + "' not supported");
            }
            case 'D': {
                return DAY_OF_YEAR_STRATEGY;
            }
            case 'E': {
                return this.getLocaleSpecificStrategy(7, calendar);
            }
            case 'F': {
                return DAY_OF_WEEK_IN_MONTH_STRATEGY;
            }
            case 'G': {
                return this.getLocaleSpecificStrategy(0, calendar);
            }
            case 'H': {
                return HOUR_OF_DAY_STRATEGY;
            }
            case 'K': {
                return HOUR_STRATEGY;
            }
            case 'M': {
                return n2 >= 3 ? this.getLocaleSpecificStrategy(2, calendar) : NUMBER_MONTH_STRATEGY;
            }
            case 'S': {
                return MILLISECOND_STRATEGY;
            }
            case 'W': {
                return WEEK_OF_MONTH_STRATEGY;
            }
            case 'a': {
                return this.getLocaleSpecificStrategy(9, calendar);
            }
            case 'd': {
                return DAY_OF_MONTH_STRATEGY;
            }
            case 'h': {
                return HOUR12_STRATEGY;
            }
            case 'k': {
                return HOUR24_OF_DAY_STRATEGY;
            }
            case 'm': {
                return MINUTE_STRATEGY;
            }
            case 's': {
                return SECOND_STRATEGY;
            }
            case 'u': {
                return DAY_OF_WEEK_STRATEGY;
            }
            case 'w': {
                return WEEK_OF_YEAR_STRATEGY;
            }
            case 'Y': 
            case 'y': {
                return n2 > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
            }
            case 'X': {
                return ISO8601TimeZoneStrategy.getStrategy(n2);
            }
            case 'Z': {
                if (n2 != 2) break;
                return ISO8601TimeZoneStrategy.ISO_8601_3_STRATEGY;
            }
            case 'z': 
        }
        return this.getLocaleSpecificStrategy(15, calendar);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ConcurrentMap<Locale, Strategy> getCache(int n2) {
        ConcurrentMap<Locale, Strategy>[] concurrentMapArray = caches;
        synchronized (caches) {
            if (caches[n2] == null) {
                FastDateParser.caches[n2] = new ConcurrentHashMap<Locale, Strategy>(3);
            }
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return caches[n2];
        }
    }

    private Strategy getLocaleSpecificStrategy(int n2, Calendar calendar) {
        Strategy strategy;
        ConcurrentMap<Locale, Strategy> concurrentMap = FastDateParser.getCache(n2);
        Strategy strategy2 = (Strategy)concurrentMap.get(this.locale);
        if (strategy2 == null && (strategy = concurrentMap.putIfAbsent(this.locale, strategy2 = n2 == 15 ? new TimeZoneStrategy(this.locale) : new CaseInsensitiveTextStrategy(n2, calendar, this.locale))) != null) {
            return strategy;
        }
        return strategy2;
    }

    static class ISO8601TimeZoneStrategy
    extends PatternStrategy {
        private static final Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
        private static final Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
        private static final Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

        ISO8601TimeZoneStrategy(String string) {
            this.createPattern(string);
        }

        @Override
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String string) {
            calendar.setTimeZone(FastTimeZone.getGmtTimeZone(string));
        }

        static Strategy getStrategy(int n2) {
            switch (n2) {
                case 1: {
                    return ISO_8601_1_STRATEGY;
                }
                case 2: {
                    return ISO_8601_2_STRATEGY;
                }
                case 3: {
                    return ISO_8601_3_STRATEGY;
                }
            }
            throw new IllegalArgumentException("invalid number of X");
        }
    }

    static class TimeZoneStrategy
    extends PatternStrategy {
        private static final String RFC_822_TIME_ZONE = "[+-]\\d{4}";
        private static final String GMT_OPTION = "GMT[+-]\\d{1,2}:\\d{2}";
        private final Locale locale;
        private final Map<String, TzInfo> tzNames = new HashMap<String, TzInfo>();
        private static final int ID = 0;

        TimeZoneStrategy(Locale locale) {
            this.locale = LocaleUtils.toLocale(locale);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet<String> treeSet = new TreeSet<String>(LONGER_FIRST_LOWERCASE);
            String[][] stringArray = DateFormatSymbols.getInstance(locale).getZoneStrings();
            for (String[] stringArray2 : stringArray) {
                TzInfo tzInfo;
                String string = stringArray2[0];
                if (string.equalsIgnoreCase("GMT")) continue;
                TimeZone timeZone = TimeZone.getTimeZone(string);
                TzInfo tzInfo2 = tzInfo = new TzInfo(timeZone, false);
                for (int i2 = 1; i2 < stringArray2.length; ++i2) {
                    String string2;
                    switch (i2) {
                        case 3: {
                            tzInfo2 = new TzInfo(timeZone, true);
                            break;
                        }
                        case 5: {
                            tzInfo2 = tzInfo;
                            break;
                        }
                    }
                    if (stringArray2[i2] == null || !treeSet.add(string2 = stringArray2[i2].toLowerCase(locale))) continue;
                    this.tzNames.put(string2, tzInfo2);
                }
            }
            for (String string : treeSet) {
                FastDateParser.simpleQuote(stringBuilder.append('|'), string);
            }
            stringBuilder.append(")");
            this.createPattern(stringBuilder);
        }

        @Override
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String string) {
            TimeZone timeZone = FastTimeZone.getGmtTimeZone(string);
            if (timeZone != null) {
                calendar.setTimeZone(timeZone);
            } else {
                String string2 = string.toLowerCase(this.locale);
                TzInfo tzInfo = this.tzNames.get(string2);
                if (tzInfo == null) {
                    tzInfo = this.tzNames.get(string2 + '.');
                }
                calendar.set(16, tzInfo.dstOffset);
                calendar.set(15, tzInfo.zone.getRawOffset());
            }
        }

        @Override
        public String toString() {
            return "TimeZoneStrategy [locale=" + this.locale + ", tzNames=" + this.tzNames + ", pattern=" + this.pattern + "]";
        }

        static class TzInfo {
            final TimeZone zone;
            final int dstOffset;

            TzInfo(TimeZone timeZone, boolean bl2) {
                this.zone = timeZone;
                this.dstOffset = bl2 ? timeZone.getDSTSavings() : 0;
            }
        }
    }

    static class NumberStrategy
    extends Strategy {
        private final int field;

        NumberStrategy(int n2) {
            this.field = n2;
        }

        @Override
        boolean isNumber() {
            return true;
        }

        @Override
        boolean parse(FastDateParser fastDateParser, Calendar calendar, String string, ParsePosition parsePosition, int n2) {
            int n3;
            int n4;
            int n5 = string.length();
            if (n2 == 0) {
                for (n4 = parsePosition.getIndex(); n4 < n5 && Character.isWhitespace((char)(n3 = (int)string.charAt(n4))); ++n4) {
                }
                parsePosition.setIndex(n4);
            } else {
                n3 = n4 + n2;
                if (n5 > n3) {
                    n5 = n3;
                }
            }
            while (n4 < n5 && Character.isDigit((char)(n3 = (int)string.charAt(n4)))) {
                ++n4;
            }
            if (parsePosition.getIndex() == n4) {
                parsePosition.setErrorIndex(n4);
                return false;
            }
            n3 = Integer.parseInt(string.substring(parsePosition.getIndex(), n4));
            parsePosition.setIndex(n4);
            calendar.set(this.field, this.modify(fastDateParser, n3));
            return true;
        }

        int modify(FastDateParser fastDateParser, int n2) {
            return n2;
        }

        public String toString() {
            return "NumberStrategy [field=" + this.field + "]";
        }
    }

    static class CaseInsensitiveTextStrategy
    extends PatternStrategy {
        private final int field;
        final Locale locale;
        private final Map<String, Integer> lKeyValues;

        CaseInsensitiveTextStrategy(int n2, Calendar calendar, Locale locale) {
            this.field = n2;
            this.locale = LocaleUtils.toLocale(locale);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("((?iu)");
            this.lKeyValues = FastDateParser.appendDisplayNames(calendar, locale, n2, stringBuilder);
            stringBuilder.setLength(stringBuilder.length() - 1);
            stringBuilder.append(")");
            this.createPattern(stringBuilder);
        }

        @Override
        void setCalendar(FastDateParser fastDateParser, Calendar calendar, String string) {
            String string2 = string.toLowerCase(this.locale);
            Integer n2 = this.lKeyValues.get(string2);
            if (n2 == null) {
                n2 = this.lKeyValues.get(string2 + '.');
            }
            calendar.set(this.field, n2);
        }

        @Override
        public String toString() {
            return "CaseInsensitiveTextStrategy [field=" + this.field + ", locale=" + this.locale + ", lKeyValues=" + this.lKeyValues + ", pattern=" + this.pattern + "]";
        }
    }

    static class CopyQuotedStrategy
    extends Strategy {
        private final String formatField;

        CopyQuotedStrategy(String string) {
            this.formatField = string;
        }

        @Override
        boolean isNumber() {
            return false;
        }

        @Override
        boolean parse(FastDateParser fastDateParser, Calendar calendar, String string, ParsePosition parsePosition, int n2) {
            for (int i2 = 0; i2 < this.formatField.length(); ++i2) {
                int n3 = i2 + parsePosition.getIndex();
                if (n3 == string.length()) {
                    parsePosition.setErrorIndex(n3);
                    return false;
                }
                if (this.formatField.charAt(i2) == string.charAt(n3)) continue;
                parsePosition.setErrorIndex(n3);
                return false;
            }
            parsePosition.setIndex(this.formatField.length() + parsePosition.getIndex());
            return true;
        }

        public String toString() {
            return "CopyQuotedStrategy [formatField=" + this.formatField + "]";
        }
    }

    static abstract class PatternStrategy
    extends Strategy {
        Pattern pattern;

        private PatternStrategy() {
        }

        void createPattern(StringBuilder stringBuilder) {
            this.createPattern(stringBuilder.toString());
        }

        void createPattern(String string) {
            this.pattern = Pattern.compile(string);
        }

        @Override
        boolean isNumber() {
            return false;
        }

        @Override
        boolean parse(FastDateParser fastDateParser, Calendar calendar, String string, ParsePosition parsePosition, int n2) {
            Matcher matcher = this.pattern.matcher(string.substring(parsePosition.getIndex()));
            if (!matcher.lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            parsePosition.setIndex(parsePosition.getIndex() + matcher.end(1));
            this.setCalendar(fastDateParser, calendar, matcher.group(1));
            return true;
        }

        abstract void setCalendar(FastDateParser var1, Calendar var2, String var3);

        public String toString() {
            return this.getClass().getSimpleName() + " [pattern=" + this.pattern + "]";
        }
    }

    static abstract class Strategy {
        private Strategy() {
        }

        boolean isNumber() {
            return false;
        }

        abstract boolean parse(FastDateParser var1, Calendar var2, String var3, ParsePosition var4, int var5);
    }

    class StrategyParser {
        private final Calendar definingCalendar;
        private int currentIdx;

        StrategyParser(Calendar calendar) {
            this.definingCalendar = calendar;
        }

        StrategyAndWidth getNextStrategy() {
            if (this.currentIdx >= FastDateParser.this.pattern.length()) {
                return null;
            }
            char c2 = FastDateParser.this.pattern.charAt(this.currentIdx);
            if (FastDateParser.isFormatLetter(c2)) {
                return this.letterPattern(c2);
            }
            return this.literal();
        }

        private StrategyAndWidth letterPattern(char c2) {
            int n2 = this.currentIdx;
            while (++this.currentIdx < FastDateParser.this.pattern.length() && FastDateParser.this.pattern.charAt(this.currentIdx) == c2) {
            }
            int n3 = this.currentIdx - n2;
            return new StrategyAndWidth(FastDateParser.this.getStrategy(c2, n3, this.definingCalendar), n3);
        }

        private StrategyAndWidth literal() {
            boolean bl2 = false;
            StringBuilder stringBuilder = new StringBuilder();
            while (this.currentIdx < FastDateParser.this.pattern.length()) {
                char c2 = FastDateParser.this.pattern.charAt(this.currentIdx);
                if (!bl2 && FastDateParser.isFormatLetter(c2)) break;
                if (c2 == '\'' && (++this.currentIdx == FastDateParser.this.pattern.length() || FastDateParser.this.pattern.charAt(this.currentIdx) != '\'')) {
                    bl2 = !bl2;
                    continue;
                }
                ++this.currentIdx;
                stringBuilder.append(c2);
            }
            if (bl2) {
                throw new IllegalArgumentException("Unterminated quote");
            }
            String string = stringBuilder.toString();
            return new StrategyAndWidth(new CopyQuotedStrategy(string), string.length());
        }
    }

    static class StrategyAndWidth {
        final Strategy strategy;
        final int width;

        StrategyAndWidth(Strategy strategy, int n2) {
            this.strategy = strategy;
            this.width = n2;
        }

        int getMaxWidth(ListIterator<StrategyAndWidth> listIterator) {
            if (!this.strategy.isNumber() || !listIterator.hasNext()) {
                return 0;
            }
            Strategy strategy = listIterator.next().strategy;
            listIterator.previous();
            return strategy.isNumber() ? this.width : 0;
        }

        public String toString() {
            return "StrategyAndWidth [strategy=" + this.strategy + ", width=" + this.width + "]";
        }
    }
}

