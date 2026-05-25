/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

public class azv {
    private StopWatch var_org_apache_commons_lang3_time_StopWatch_a;
    private long var_long_a;
    boolean var_boolean_a = false;
    private long b;

    public azv(long l2) {
        this.var_long_a = l2;
        this.var_org_apache_commons_lang3_time_StopWatch_a = StopWatch.create();
    }

    public azv(long l2, boolean bl2) {
        this.var_long_a = l2;
        this.var_org_apache_commons_lang3_time_StopWatch_a = bl2 ? StopWatch.createStarted() : StopWatch.create();
    }

    public void void_a() {
        if (!this.var_org_apache_commons_lang3_time_StopWatch_a.isStarted()) {
            this.var_org_apache_commons_lang3_time_StopWatch_a.start();
        }
    }

    public void void_b() {
        if (this.var_org_apache_commons_lang3_time_StopWatch_a.isStarted()) {
            this.var_org_apache_commons_lang3_time_StopWatch_a.stop();
        }
    }

    public void void_c() {
        this.b = 0L;
        this.var_org_apache_commons_lang3_time_StopWatch_a.reset();
        this.var_org_apache_commons_lang3_time_StopWatch_a.start();
    }

    public void a(int n2) {
        this.b = n2;
        this.var_org_apache_commons_lang3_time_StopWatch_a.reset();
        this.var_org_apache_commons_lang3_time_StopWatch_a.start();
    }

    public void d() {
        this.b = 0L;
        this.var_org_apache_commons_lang3_time_StopWatch_a.reset();
    }

    public boolean boolean_a() {
        return this.var_org_apache_commons_lang3_time_StopWatch_a.isStarted();
    }

    public long a(TimeUnit timeUnit) {
        return this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(timeUnit);
    }

    public float float_a() {
        if (this.b != 0L) {
            return (float)((double)this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.MILLISECONDS) * 1.0 / (double)this.b);
        }
        return (float)((double)this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.MILLISECONDS) * 1.0 / (double)this.var_long_a);
    }

    public boolean boolean_b() {
        if (this.var_boolean_a) {
            return true;
        }
        if (this.b > 0L && this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.MILLISECONDS) >= this.b) {
            if (!this.var_org_apache_commons_lang3_time_StopWatch_a.isStopped()) {
                this.var_org_apache_commons_lang3_time_StopWatch_a.stop();
            }
            this.b = 0L;
            return true;
        }
        if (this.var_long_a == -1L) {
            return false;
        }
        return this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.MILLISECONDS) >= this.var_long_a;
    }

    public boolean boolean_c() {
        return !this.var_org_apache_commons_lang3_time_StopWatch_a.isStarted() && this.var_org_apache_commons_lang3_time_StopWatch_a.getTime(TimeUnit.MILLISECONDS) == 0L;
    }

    public void e() {
        this.var_boolean_a = true;
    }

    public int int_a() {
        if (this.b > 0L) {
            if ((int)(this.b / 1000L - this.a(TimeUnit.SECONDS)) < 0) {
                return 0;
            }
            return (int)(this.b / 1000L - this.a(TimeUnit.SECONDS));
        }
        if ((int)(this.var_long_a / 1000L - this.a(TimeUnit.SECONDS)) < 0) {
            return 0;
        }
        return (int)(this.var_long_a / 1000L - this.a(TimeUnit.SECONDS));
    }

    public int int_b() {
        if (this.b > 0L) {
            if ((int)(this.b - this.a(TimeUnit.MILLISECONDS)) < 0) {
                return 0;
            }
            return (int)(this.b - this.a(TimeUnit.MILLISECONDS));
        }
        if ((int)(this.var_long_a - this.a(TimeUnit.MILLISECONDS)) < 0) {
            return 0;
        }
        return (int)(this.var_long_a - this.a(TimeUnit.MILLISECONDS));
    }

    public void a(long l2) {
        this.var_long_a = l2;
    }

    public long long_a() {
        if (this.b > 0L) {
            return this.b;
        }
        return this.var_long_a;
    }

    public long long_b() {
        return this.var_long_a;
    }

    public String toString() {
        return this.var_org_apache_commons_lang3_time_StopWatch_a.toString();
    }

    public void a(boolean bl2) {
        this.var_boolean_a = bl2;
    }
}

