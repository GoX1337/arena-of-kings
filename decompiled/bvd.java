/*
 * Decompiled with CFR 0.152.
 */
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bvd
extends DateFormat {
    protected static final Pattern var_java_util_regex_Pattern_a;
    protected static final Pattern var_java_util_regex_Pattern_b;
    protected static final String[] var_java_lang_String_arr_a;
    protected static final TimeZone var_java_util_TimeZone_a;
    protected static final Locale var_java_util_Locale_a;
    protected static final DateFormat var_java_text_DateFormat_a;
    public static final bvd var_bvd_a;
    protected static final Calendar var_java_util_Calendar_a;
    protected transient TimeZone var_java_util_TimeZone_b;
    protected final Locale var_java_util_Locale_b;
    protected Boolean var_java_lang_Boolean_a;
    private transient Calendar var_java_util_Calendar_b;
    private transient DateFormat var_java_text_DateFormat_b;
    private boolean var_boolean_a = true;

    public bvd() {
        this.var_java_util_Locale_b = var_java_util_Locale_a;
    }

    protected bvd(TimeZone timeZone, Locale locale, Boolean bl2, boolean bl3) {
        this.var_java_util_TimeZone_b = timeZone;
        this.var_java_util_Locale_b = locale;
        this.var_java_lang_Boolean_a = bl2;
        this.var_boolean_a = bl3;
    }

    public bvd bvd_a(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = var_java_util_TimeZone_a;
        }
        if (timeZone == this.var_java_util_TimeZone_b || timeZone.equals(this.var_java_util_TimeZone_b)) {
            return this;
        }
        return new bvd(timeZone, this.var_java_util_Locale_b, this.var_java_lang_Boolean_a, this.var_boolean_a);
    }

    public bvd a(Locale locale) {
        if (locale.equals(this.var_java_util_Locale_b)) {
            return this;
        }
        return new bvd(this.var_java_util_TimeZone_b, locale, this.var_java_lang_Boolean_a, this.var_boolean_a);
    }

    public bvd a(Boolean bl2) {
        if (bvd.a(bl2, this.var_java_lang_Boolean_a)) {
            return this;
        }
        return new bvd(this.var_java_util_TimeZone_b, this.var_java_util_Locale_b, bl2, this.var_boolean_a);
    }

    public bvd bvd_a() {
        return new bvd(this.var_java_util_TimeZone_b, this.var_java_util_Locale_b, this.var_java_lang_Boolean_a, this.var_boolean_a);
    }

    @Override
    public TimeZone getTimeZone() {
        return this.var_java_util_TimeZone_b;
    }

    @Override
    public void setTimeZone(TimeZone timeZone) {
        if (!timeZone.equals(this.var_java_util_TimeZone_b)) {
            this.void_a();
            this.var_java_util_TimeZone_b = timeZone;
        }
    }

    @Override
    public void setLenient(boolean bl2) {
        Boolean bl3 = bl2;
        if (!bvd.a(bl3, this.var_java_lang_Boolean_a)) {
            this.var_java_lang_Boolean_a = bl3;
            this.void_a();
        }
    }

    @Override
    public boolean isLenient() {
        return this.var_java_lang_Boolean_a == null || this.var_java_lang_Boolean_a != false;
    }

    @Override
    public Date parse(String string) {
        ParsePosition parsePosition;
        Date date = this.a(string = string.trim(), parsePosition = new ParsePosition(0));
        if (date != null) {
            return date;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : var_java_lang_String_arr_a) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\", \"");
            } else {
                stringBuilder.append('\"');
            }
            stringBuilder.append(string2);
        }
        stringBuilder.append('\"');
        throw new ParseException(String.format("Cannot parse date \"%s\": not compatible with any of standard forms (%s)", string, stringBuilder.toString()), parsePosition.getErrorIndex());
    }

    @Override
    public Date parse(String string, ParsePosition parsePosition) {
        try {
            return this.a(string, parsePosition);
        }
        catch (ParseException parseException) {
            return null;
        }
    }

    protected Date a(String string, ParsePosition parsePosition) {
        char c2;
        if (this.a(string)) {
            return this.b(string, parsePosition);
        }
        int n2 = string.length();
        while (--n2 >= 0 && ((c2 = string.charAt(n2)) >= '0' && c2 <= '9' || n2 <= 0 && c2 == '-')) {
        }
        if (n2 < 0 && (string.charAt(0) == '-' || bea.a(string, false))) {
            return this.e(string, parsePosition);
        }
        return this.d(string, parsePosition);
    }

    @Override
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = this.var_java_util_TimeZone_b;
        if (timeZone == null) {
            timeZone = var_java_util_TimeZone_a;
        }
        this.a(timeZone, this.var_java_util_Locale_b, date, stringBuffer);
        return stringBuffer;
    }

    protected void a(TimeZone timeZone, Locale locale, Date date, StringBuffer stringBuffer) {
        Calendar calendar = this.java_util_Calendar_a(timeZone);
        calendar.setTime(date);
        int n2 = calendar.get(1);
        if (calendar.get(0) == 0) {
            this.a(stringBuffer, n2);
        } else {
            if (n2 > 9999) {
                stringBuffer.append('+');
            }
            bvd.d(stringBuffer, n2);
        }
        stringBuffer.append('-');
        bvd.b(stringBuffer, calendar.get(2) + 1);
        stringBuffer.append('-');
        bvd.b(stringBuffer, calendar.get(5));
        stringBuffer.append('T');
        bvd.b(stringBuffer, calendar.get(11));
        stringBuffer.append(':');
        bvd.b(stringBuffer, calendar.get(12));
        stringBuffer.append(':');
        bvd.b(stringBuffer, calendar.get(13));
        stringBuffer.append('.');
        bvd.c(stringBuffer, calendar.get(14));
        int n3 = timeZone.getOffset(calendar.getTimeInMillis());
        if (n3 != 0) {
            int n4 = Math.abs(n3 / 60000 / 60);
            int n5 = Math.abs(n3 / 60000 % 60);
            stringBuffer.append(n3 < 0 ? (char)'-' : '+');
            bvd.b(stringBuffer, n4);
            if (this.var_boolean_a) {
                stringBuffer.append(':');
            }
            bvd.b(stringBuffer, n5);
        } else if (this.var_boolean_a) {
            stringBuffer.append("+00:00");
        } else {
            stringBuffer.append("+0000");
        }
    }

    protected void a(StringBuffer stringBuffer, int n2) {
        if (n2 == 1) {
            stringBuffer.append("+0000");
            return;
        }
        int n3 = n2 - 1;
        stringBuffer.append('-');
        bvd.d(stringBuffer, n3);
    }

    private static void b(StringBuffer stringBuffer, int n2) {
        int n3 = n2 / 10;
        if (n3 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char)(48 + n3));
            n2 -= 10 * n3;
        }
        stringBuffer.append((char)(48 + n2));
    }

    private static void c(StringBuffer stringBuffer, int n2) {
        int n3 = n2 / 100;
        if (n3 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char)(48 + n3));
            n2 -= n3 * 100;
        }
        bvd.b(stringBuffer, n2);
    }

    private static void d(StringBuffer stringBuffer, int n2) {
        int n3 = n2 / 100;
        if (n3 == 0) {
            stringBuffer.append('0').append('0');
        } else {
            if (n3 > 99) {
                stringBuffer.append(n3);
            } else {
                bvd.b(stringBuffer, n3);
            }
            n2 -= 100 * n3;
        }
        bvd.b(stringBuffer, n2);
    }

    public String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", this.getClass().getName(), this.var_java_util_TimeZone_b, this.var_java_util_Locale_b, this.var_java_lang_Boolean_a);
    }

    public String java_lang_String_a() {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("[one of: '").append("yyyy-MM-dd'T'HH:mm:ss.SSSX").append("', '").append("EEE, dd MMM yyyy HH:mm:ss zzz").append("' (");
        stringBuilder.append(Boolean.FALSE.equals(this.var_java_lang_Boolean_a) ? "strict" : "lenient").append(")]");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object object) {
        return object == this;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    protected boolean a(String string) {
        return string.length() >= 7 && Character.isDigit(string.charAt(0)) && Character.isDigit(string.charAt(3)) && string.charAt(4) == '-' && Character.isDigit(string.charAt(5));
    }

    private Date e(String string, ParsePosition parsePosition) {
        long l2;
        try {
            l2 = bea.long_a(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new ParseException(String.format("Timestamp value %s out of 64-bit value range", string), parsePosition.getErrorIndex());
        }
        return new Date(l2);
    }

    protected Date b(String string, ParsePosition parsePosition) {
        try {
            return this.c(string, parsePosition);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ParseException(String.format("Cannot parse date \"%s\", problem: %s", string, illegalArgumentException.getMessage()), parsePosition.getErrorIndex());
        }
    }

    protected Date c(String string, ParsePosition parsePosition) {
        String string2;
        int n2 = string.length();
        TimeZone timeZone = var_java_util_TimeZone_a;
        if (this.var_java_util_TimeZone_b != null && 'Z' != string.charAt(n2 - 1)) {
            timeZone = this.var_java_util_TimeZone_b;
        }
        Calendar calendar = this.java_util_Calendar_a(timeZone);
        calendar.clear();
        if (n2 <= 10) {
            Matcher matcher = var_java_util_regex_Pattern_a.matcher(string);
            if (matcher.matches()) {
                int n3 = bvd.a(string, 0);
                int n4 = bvd.b(string, 5) - 1;
                int n5 = bvd.b(string, 8);
                calendar.set(n3, n4, n5, 0, 0, 0);
                calendar.set(14, 0);
                return calendar.getTime();
            }
            string2 = "yyyy-MM-dd";
        } else {
            Matcher matcher = var_java_util_regex_Pattern_b.matcher(string);
            if (matcher.matches()) {
                int n6;
                int n7 = matcher.start(2);
                int n8 = matcher.end(2);
                int n9 = n8 - n7;
                if (n9 > 1) {
                    n6 = bvd.b(string, n7 + 1) * 3600;
                    if (n9 >= 5) {
                        n6 += bvd.b(string, n8 - 2) * 60;
                    }
                    n6 = string.charAt(n7) == '-' ? (n6 *= -1000) : (n6 *= 1000);
                    calendar.set(15, n6);
                    calendar.set(16, 0);
                }
                n6 = bvd.a(string, 0);
                int n10 = bvd.b(string, 5) - 1;
                int n11 = bvd.b(string, 8);
                int n12 = bvd.b(string, 11);
                int n13 = bvd.b(string, 14);
                int n14 = n2 > 16 && string.charAt(16) == ':' ? bvd.b(string, 17) : 0;
                calendar.set(n6, n10, n11, n12, n13, n14);
                n7 = matcher.start(1) + 1;
                n8 = matcher.end(1);
                int n15 = 0;
                if (n7 >= n8) {
                    calendar.set(14, 0);
                } else {
                    n15 = 0;
                    int n16 = n8 - n7;
                    switch (n16) {
                        default: {
                            if (n16 > 9) {
                                throw new ParseException(String.format("Cannot parse date \"%s\": invalid fractional seconds '%s'; can use at most 9 digits", string, matcher.group(1).substring(1)), n7);
                            }
                        }
                        case 3: {
                            n15 += string.charAt(n7 + 2) - 48;
                        }
                        case 2: {
                            n15 += 10 * (string.charAt(n7 + 1) - 48);
                        }
                        case 1: {
                            n15 += 100 * (string.charAt(n7) - 48);
                        }
                        case 0: 
                    }
                    calendar.set(14, n15);
                }
                return calendar.getTime();
            }
            string2 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
        }
        throw new ParseException(String.format("Cannot parse date \"%s\": while it seems to fit format '%s', parsing fails (leniency? %s)", string, string2, this.var_java_lang_Boolean_a), 0);
    }

    private static int a(String string, int n2) {
        return 1000 * (string.charAt(n2) - 48) + 100 * (string.charAt(n2 + 1) - 48) + 10 * (string.charAt(n2 + 2) - 48) + (string.charAt(n2 + 3) - 48);
    }

    private static int b(String string, int n2) {
        return 10 * (string.charAt(n2) - 48) + (string.charAt(n2 + 1) - 48);
    }

    protected Date d(String string, ParsePosition parsePosition) {
        if (this.var_java_text_DateFormat_b == null) {
            this.var_java_text_DateFormat_b = bvd.a(var_java_text_DateFormat_a, "EEE, dd MMM yyyy HH:mm:ss zzz", this.var_java_util_TimeZone_b, this.var_java_util_Locale_b, this.var_java_lang_Boolean_a);
        }
        return this.var_java_text_DateFormat_b.parse(string, parsePosition);
    }

    private static final DateFormat a(DateFormat dateFormat, String string, TimeZone timeZone, Locale locale, Boolean bl2) {
        if (!locale.equals(var_java_util_Locale_a)) {
            dateFormat = new SimpleDateFormat(string, locale);
            dateFormat.setTimeZone(timeZone == null ? var_java_util_TimeZone_a : timeZone);
        } else {
            dateFormat = (DateFormat)dateFormat.clone();
            if (timeZone != null) {
                dateFormat.setTimeZone(timeZone);
            }
        }
        if (bl2 != null) {
            dateFormat.setLenient(bl2);
        }
        return dateFormat;
    }

    protected void void_a() {
        this.var_java_text_DateFormat_b = null;
    }

    protected Calendar java_util_Calendar_a(TimeZone timeZone) {
        Calendar calendar = this.var_java_util_Calendar_b;
        if (calendar == null) {
            this.var_java_util_Calendar_b = calendar = (Calendar)var_java_util_Calendar_a.clone();
        }
        if (!calendar.getTimeZone().equals(timeZone)) {
            calendar.setTimeZone(timeZone);
        }
        calendar.setLenient(this.isLenient());
        return calendar;
    }

    protected static <T> boolean a(T t2, T t3) {
        if (t2 == t3) {
            return true;
        }
        return t2 != null && t2.equals(t3);
    }

    @Override
    public /* synthetic */ Object clone() {
        return this.bvd_a();
    }

    static {
        var_java_util_regex_Pattern_a = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");
        Pattern pattern = null;
        try {
            pattern = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        var_java_util_regex_Pattern_b = pattern;
        var_java_lang_String_arr_a = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};
        var_java_util_TimeZone_a = TimeZone.getTimeZone("UTC");
        var_java_util_Locale_a = Locale.US;
        var_java_text_DateFormat_a = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", var_java_util_Locale_a);
        var_java_text_DateFormat_a.setTimeZone(var_java_util_TimeZone_a);
        var_bvd_a = new bvd();
        var_java_util_Calendar_a = new GregorianCalendar(var_java_util_TimeZone_a, var_java_util_Locale_a);
    }
}

