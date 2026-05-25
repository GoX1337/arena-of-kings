/*
 * Decompiled with CFR 0.152.
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class bsc<T>
extends btd<T>
implements bqh {
    protected final Boolean var_java_lang_Boolean_a;
    protected final DateFormat var_java_text_DateFormat_a;
    protected final AtomicReference<DateFormat> var_java_util_concurrent_atomic_AtomicReference_java_text_DateFormat__a;

    protected bsc(Class<T> clazz, Boolean bl2, DateFormat dateFormat) {
        super(clazz);
        this.var_java_lang_Boolean_a = bl2;
        this.var_java_text_DateFormat_a = dateFormat;
        this.var_java_lang_Boolean_a = dateFormat == null ? null : new AtomicReference();
    }

    public abstract bsc<T> a(Boolean var1, DateFormat var2);

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        boolean bl2;
        boolean bl3;
        bbk.d d2 = this.bbk$d_a(bgo2, bfp2, this.a());
        if (d2 == null) {
            return this;
        }
        bbk.c c2 = d2.bbk$c_a();
        if (c2.a()) {
            return this.a(Boolean.TRUE, null);
        }
        if (d2.b()) {
            Locale locale = d2.c() ? d2.java_util_Locale_a() : bgo2.java_util_Locale_a();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(d2.java_lang_String_a(), locale);
            TimeZone timeZone = d2.d() ? d2.java_util_TimeZone_a() : bgo2.java_util_TimeZone_a();
            simpleDateFormat.setTimeZone(timeZone);
            return this.a(Boolean.FALSE, simpleDateFormat);
        }
        boolean bl4 = d2.c();
        boolean bl5 = d2.d();
        boolean bl6 = bl3 = c2 == bbk.c.i;
        if (!(bl4 || bl5 || bl3)) {
            return this;
        }
        DateFormat dateFormat = bgo2.bgm_a().java_text_DateFormat_a();
        if (dateFormat instanceof bvd) {
            bvd bvd2 = (bvd)dateFormat;
            if (d2.c()) {
                bvd2 = bvd2.a(d2.java_util_Locale_a());
            }
            if (d2.d()) {
                bvd2 = bvd2.bvd_a(d2.java_util_TimeZone_a());
            }
            return this.a(Boolean.FALSE, bvd2);
        }
        if (!(dateFormat instanceof SimpleDateFormat)) {
            bgo2.a(this.a(), String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", dateFormat.getClass().getName()));
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)dateFormat;
        simpleDateFormat = bl4 ? new SimpleDateFormat(simpleDateFormat.toPattern(), d2.java_util_Locale_a()) : (SimpleDateFormat)simpleDateFormat.clone();
        TimeZone timeZone = d2.java_util_TimeZone_a();
        boolean bl7 = bl2 = timeZone != null && !timeZone.equals(simpleDateFormat.getTimeZone());
        if (bl2) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        return this.a(Boolean.FALSE, simpleDateFormat);
    }

    @Override
    public boolean a(bgo bgo2, T t2) {
        return false;
    }

    protected boolean a(bgo bgo2) {
        if (this.var_java_lang_Boolean_a != null) {
            return this.var_java_lang_Boolean_a;
        }
        if (this.var_java_text_DateFormat_a == null) {
            if (bgo2 != null) {
                return bgo2.a(bgn.j);
            }
            throw new IllegalArgumentException("Null SerializerProvider passed for " + this.a().getName());
        }
        return false;
    }

    protected void b(Date date, bcy bcy2, bgo bgo2) {
        if (this.var_java_text_DateFormat_a == null) {
            bgo2.a(date, bcy2);
            return;
        }
        DateFormat dateFormat = ((AtomicReference)((Object)this.var_java_lang_Boolean_a)).getAndSet(null);
        if (dateFormat == null) {
            dateFormat = (DateFormat)this.var_java_text_DateFormat_a.clone();
        }
        bcy2.b(dateFormat.format(date));
        ((AtomicReference)((Object)this.var_java_lang_Boolean_a)).compareAndSet(null, dateFormat);
    }
}

