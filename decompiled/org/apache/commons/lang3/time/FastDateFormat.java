/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.time.DateParser;
import org.apache.commons.lang3.time.DatePrinter;
import org.apache.commons.lang3.time.FastDateParser;
import org.apache.commons.lang3.time.FastDatePrinter;
import org.apache.commons.lang3.time.FormatCache;

public class FastDateFormat
extends Format
implements DateParser,
DatePrinter {
    private static final long serialVersionUID = 2L;
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final FormatCache<FastDateFormat> cache = new FormatCache<FastDateFormat>(){

        @Override
        protected FastDateFormat createInstance(String string, TimeZone timeZone, Locale locale) {
            return new FastDateFormat(string, timeZone, locale);
        }
    };
    private final FastDatePrinter printer;
    private final FastDateParser parser;

    public static FastDateFormat getInstance() {
        return cache.getInstance();
    }

    public static FastDateFormat getInstance(String string) {
        return cache.getInstance(string, null, null);
    }

    public static FastDateFormat getInstance(String string, TimeZone timeZone) {
        return cache.getInstance(string, timeZone, null);
    }

    public static FastDateFormat getInstance(String string, Locale locale) {
        return cache.getInstance(string, null, locale);
    }

    public static FastDateFormat getInstance(String string, TimeZone timeZone, Locale locale) {
        return cache.getInstance(string, timeZone, locale);
    }

    public static FastDateFormat getDateInstance(int n2) {
        return cache.getDateInstance(n2, null, null);
    }

    public static FastDateFormat getDateInstance(int n2, Locale locale) {
        return cache.getDateInstance(n2, null, locale);
    }

    public static FastDateFormat getDateInstance(int n2, TimeZone timeZone) {
        return cache.getDateInstance(n2, timeZone, null);
    }

    public static FastDateFormat getDateInstance(int n2, TimeZone timeZone, Locale locale) {
        return cache.getDateInstance(n2, timeZone, locale);
    }

    public static FastDateFormat getTimeInstance(int n2) {
        return cache.getTimeInstance(n2, null, null);
    }

    public static FastDateFormat getTimeInstance(int n2, Locale locale) {
        return cache.getTimeInstance(n2, null, locale);
    }

    public static FastDateFormat getTimeInstance(int n2, TimeZone timeZone) {
        return cache.getTimeInstance(n2, timeZone, null);
    }

    public static FastDateFormat getTimeInstance(int n2, TimeZone timeZone, Locale locale) {
        return cache.getTimeInstance(n2, timeZone, locale);
    }

    public static FastDateFormat getDateTimeInstance(int n2, int n3) {
        return cache.getDateTimeInstance(n2, n3, (TimeZone)null, (Locale)null);
    }

    public static FastDateFormat getDateTimeInstance(int n2, int n3, Locale locale) {
        return cache.getDateTimeInstance(n2, n3, (TimeZone)null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int n2, int n3, TimeZone timeZone) {
        return FastDateFormat.getDateTimeInstance(n2, n3, timeZone, null);
    }

    public static FastDateFormat getDateTimeInstance(int n2, int n3, TimeZone timeZone, Locale locale) {
        return cache.getDateTimeInstance(n2, n3, timeZone, locale);
    }

    protected FastDateFormat(String string, TimeZone timeZone, Locale locale) {
        this(string, timeZone, locale, null);
    }

    protected FastDateFormat(String string, TimeZone timeZone, Locale locale, Date date) {
        this.printer = new FastDatePrinter(string, timeZone, locale);
        this.parser = new FastDateParser(string, timeZone, locale, date);
    }

    @Override
    public StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return stringBuffer.append(this.printer.format(object));
    }

    @Override
    public String format(long l2) {
        return this.printer.format(l2);
    }

    @Override
    public String format(Date date) {
        return this.printer.format(date);
    }

    @Override
    public String format(Calendar calendar) {
        return this.printer.format(calendar);
    }

    @Override
    @Deprecated
    public StringBuffer format(long l2, StringBuffer stringBuffer) {
        return this.printer.format(l2, stringBuffer);
    }

    @Override
    @Deprecated
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        return this.printer.format(date, stringBuffer);
    }

    @Override
    @Deprecated
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.format(calendar, stringBuffer);
    }

    @Override
    public <B extends Appendable> B format(long l2, B b2) {
        return this.printer.format(l2, b2);
    }

    @Override
    public <B extends Appendable> B format(Date date, B b2) {
        return this.printer.format(date, b2);
    }

    @Override
    public <B extends Appendable> B format(Calendar calendar, B b2) {
        return this.printer.format(calendar, b2);
    }

    @Override
    public Date parse(String string) {
        return this.parser.parse(string);
    }

    @Override
    public Date parse(String string, ParsePosition parsePosition) {
        return this.parser.parse(string, parsePosition);
    }

    @Override
    public boolean parse(String string, ParsePosition parsePosition, Calendar calendar) {
        return this.parser.parse(string, parsePosition, calendar);
    }

    @Override
    public Object parseObject(String string, ParsePosition parsePosition) {
        return this.parser.parseObject(string, parsePosition);
    }

    @Override
    public String getPattern() {
        return this.printer.getPattern();
    }

    @Override
    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    @Override
    public Locale getLocale() {
        return this.printer.getLocale();
    }

    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    public boolean equals(Object object) {
        if (!(object instanceof FastDateFormat)) {
            return false;
        }
        FastDateFormat fastDateFormat = (FastDateFormat)object;
        return this.printer.equals(fastDateFormat.printer);
    }

    public int hashCode() {
        return this.printer.hashCode();
    }

    public String toString() {
        return "FastDateFormat[" + this.printer.getPattern() + "," + this.printer.getLocale() + "," + this.printer.getTimeZone().getID() + "]";
    }

    @Deprecated
    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.applyRules(calendar, stringBuffer);
    }
}

