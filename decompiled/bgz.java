/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class bgz
implements Serializable {
    private static final TimeZone b = TimeZone.getTimeZone("UTC");
    protected final btz var_btz_a;
    protected final bmy var_bmy_a;
    protected final bfn var_bfn_a;
    protected final bgk var_bgk_a;
    protected final bmf.a var_bmf$a_a;
    protected final bof<?> var_bof____a;
    protected final boa var_boa_a;
    protected final DateFormat var_java_text_DateFormat_a;
    protected final bhl var_bhl_a;
    protected final Locale var_java_util_Locale_a;
    protected final TimeZone var_java_util_TimeZone_a;
    protected final bcq var_bcq_a;

    public bgz(bmy bmy2, bfn bfn2, bgk bgk2, btz btz2, bof<?> bof2, DateFormat dateFormat, bhl bhl2, Locale locale, TimeZone timeZone, bcq bcq2, boa boa2, bmf.a a2) {
        this.var_bmy_a = bmy2;
        this.var_bfn_a = bfn2;
        this.var_bgk_a = bgk2;
        this.var_btz_a = btz2;
        this.var_btz_a = bof2;
        this.var_java_text_DateFormat_a = dateFormat;
        this.var_bhl_a = bhl2;
        this.var_java_util_Locale_a = locale;
        this.var_java_util_TimeZone_a = timeZone;
        this.var_bcq_a = bcq2;
        this.var_boa_a = boa2;
        this.var_bmf$a_a = a2;
    }

    public bgz a(bmy bmy2) {
        if (this.var_bmy_a == bmy2) {
            return this;
        }
        return new bgz(bmy2, this.var_bfn_a, this.var_bgk_a, this.var_btz_a, (bof<?>)((Object)this.var_btz_a), this.var_java_text_DateFormat_a, this.var_bhl_a, this.var_java_util_Locale_a, this.var_java_util_TimeZone_a, this.var_bcq_a, this.var_boa_a, this.var_bmf$a_a);
    }

    public bmy bmy_a() {
        return this.var_bmy_a;
    }

    public bfn bfn_a() {
        return this.var_bfn_a;
    }

    public bgk bgk_a() {
        return this.var_bgk_a;
    }

    public bmf.a bmf$a_a() {
        return this.var_bmf$a_a;
    }

    public btz btz_a() {
        return this.var_btz_a;
    }

    public bof<?> a() {
        return this.var_btz_a;
    }

    public boa boa_a() {
        return this.var_boa_a;
    }

    public DateFormat java_text_DateFormat_a() {
        return this.var_java_text_DateFormat_a;
    }

    public bhl bhl_a() {
        return this.var_bhl_a;
    }

    public Locale java_util_Locale_a() {
        return this.var_java_util_Locale_a;
    }

    public TimeZone java_util_TimeZone_a() {
        TimeZone timeZone = this.var_java_util_TimeZone_a;
        return timeZone == null ? b : timeZone;
    }

    public bcq bcq_a() {
        return this.var_bcq_a;
    }
}

