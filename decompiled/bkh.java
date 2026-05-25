/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

public class bkh {
    private static final HashSet<String> a = new HashSet();

    public static bfx<?> a(Class<?> clazz, String string) {
        if (a.contains(string)) {
            if (clazz == Calendar.class) {
                return new a();
            }
            if (clazz == Date.class) {
                return c.a;
            }
            if (clazz == GregorianCalendar.class) {
                return new a((Class<? extends Calendar>)GregorianCalendar.class);
            }
        }
        return null;
    }

    static {
        a.add("java.util.Calendar");
        a.add("java.util.GregorianCalendar");
        a.add("java.util.Date");
    }

    @bgp
    public static class c
    extends b<Date> {
        public static final c a = new c();

        public c() {
            super(Date.class);
        }

        public c(c c2, DateFormat dateFormat, String string) {
            super(c2, dateFormat, string);
        }

        protected c a(DateFormat dateFormat, String string) {
            return new c(this, dateFormat, string);
        }

        @Override
        public Object b(bfs bfs2) {
            return new Date(0L);
        }

        public Date b(bdc bdc2, bfs bfs2) {
            return this.a(bdc2, bfs2);
        }

        @Override
        public /* synthetic */ Object a(bdc bdc2, bfs bfs2) {
            return this.b(bdc2, bfs2);
        }
    }

    @bgp
    public static class a
    extends b<Calendar> {
        protected final Constructor<Calendar> a;

        public a() {
            super(Calendar.class);
            this.a = null;
        }

        public a(Class<? extends Calendar> clazz) {
            super(clazz);
            this.a = (Constructor<Calendar>)buk.a(clazz, false);
        }

        public a(a a2, DateFormat dateFormat, String string) {
            super(a2, dateFormat, string);
            this.a = a2.a;
        }

        protected a a(DateFormat dateFormat, String string) {
            return new a(this, dateFormat, string);
        }

        @Override
        public Object b(bfs bfs2) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }

        @Override
        public Calendar a(bdc bdc2, bfs bfs2) {
            Object object = this.a(bdc2, bfs2);
            if (object == null) {
                return null;
            }
            if (this.a == null) {
                return bfs2.a((Date)object);
            }
            try {
                Calendar calendar = this.a.newInstance(new Object[0]);
                calendar.setTimeInMillis(((Date)object).getTime());
                TimeZone timeZone = bfs2.java_util_TimeZone_a();
                if (timeZone != null) {
                    calendar.setTimeZone(timeZone);
                }
                return calendar;
            }
            catch (Exception exception) {
                return (Calendar)bfs2.a(this.a(), object, exception);
            }
        }
    }

    protected static abstract class b<T>
    extends blg<T>
    implements bib {
        protected final DateFormat var_java_text_DateFormat_a;
        protected final String var_java_lang_String_a;

        protected b(Class<?> clazz) {
            super(clazz);
            this.var_java_text_DateFormat_a = null;
            this.var_java_lang_String_a = null;
        }

        protected b(b<T> b2, DateFormat dateFormat, String string) {
            super(b2.b);
            this.var_java_text_DateFormat_a = dateFormat;
            this.var_java_lang_String_a = string;
        }

        protected abstract b<T> a(DateFormat var1, String var2);

        @Override
        public btq a() {
            return btq.l;
        }

        @Override
        public bfx<?> a(bfs bfs2, bfp bfp2) {
            bbk.d d2 = this.a(bfs2, bfp2, this.a());
            if (d2 != null) {
                TimeZone timeZone = d2.java_util_TimeZone_a();
                Boolean bl2 = d2.java_lang_Boolean_a();
                if (d2.b()) {
                    String string = d2.java_lang_String_a();
                    Locale locale = d2.c() ? d2.java_util_Locale_a() : bfs2.java_util_Locale_a();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string, locale);
                    if (timeZone == null) {
                        timeZone = bfs2.java_util_TimeZone_a();
                    }
                    simpleDateFormat.setTimeZone(timeZone);
                    if (bl2 != null) {
                        simpleDateFormat.setLenient(bl2);
                    }
                    return this.a(simpleDateFormat, string);
                }
                if (timeZone != null) {
                    DateFormat dateFormat = bfs2.bfr_a().java_text_DateFormat_a();
                    if (dateFormat.getClass() == bvd.class) {
                        Locale locale = d2.c() ? d2.java_util_Locale_a() : bfs2.java_util_Locale_a();
                        bvd bvd2 = (bvd)dateFormat;
                        bvd2 = bvd2.bvd_a(timeZone);
                        bvd2 = bvd2.a(locale);
                        if (bl2 != null) {
                            bvd2 = bvd2.a(bl2);
                        }
                        dateFormat = bvd2;
                    } else {
                        dateFormat = (DateFormat)dateFormat.clone();
                        dateFormat.setTimeZone(timeZone);
                        if (bl2 != null) {
                            dateFormat.setLenient(bl2);
                        }
                    }
                    return this.a(dateFormat, this.var_java_lang_String_a);
                }
                if (bl2 != null) {
                    DateFormat dateFormat = bfs2.bfr_a().java_text_DateFormat_a();
                    String string = this.var_java_lang_String_a;
                    if (dateFormat.getClass() == bvd.class) {
                        bvd bvd3 = (bvd)dateFormat;
                        bvd3 = bvd3.a(bl2);
                        dateFormat = bvd3;
                        string = bvd3.java_lang_String_a();
                    } else {
                        dateFormat = (DateFormat)dateFormat.clone();
                        dateFormat.setLenient(bl2);
                        if (dateFormat instanceof SimpleDateFormat) {
                            ((SimpleDateFormat)dateFormat).toPattern();
                        }
                    }
                    if (string == null) {
                        string = "[unknown]";
                    }
                    return this.a(dateFormat, string);
                }
            }
            return this;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        protected Date a(bdc bdc2, bfs bfs2) {
            if (this.var_java_text_DateFormat_a != null && bdc2.boolean_a(bdf.h)) {
                String string = bdc2.java_lang_String_e().trim();
                if (string.isEmpty()) {
                    bha bha2 = this.bha_a(bfs2, string);
                    switch (bha2) {
                        case d: {
                            return new Date(0L);
                        }
                    }
                    return null;
                }
                DateFormat dateFormat = this.var_java_text_DateFormat_a;
                synchronized (dateFormat) {
                    try {
                        return this.var_java_text_DateFormat_a.parse(string);
                    }
                    catch (ParseException parseException) {
                        return (Date)bfs2.b(this.a(), string, "expected format \"%s\"", this.var_java_lang_String_a);
                    }
                }
            }
            return super.java_util_Date_a(bdc2, bfs2);
        }
    }
}

