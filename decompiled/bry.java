/*
 * Decompiled with CFR 0.152.
 */
import java.text.DateFormat;
import java.util.Calendar;

@bgp
public class bry
extends bsc<Calendar> {
    public static final bry a = new bry();

    public bry() {
        this(null, null);
    }

    public bry(Boolean bl2, DateFormat dateFormat) {
        super(Calendar.class, bl2, dateFormat);
    }

    public bry a(Boolean bl2, DateFormat dateFormat) {
        return new bry(bl2, dateFormat);
    }

    protected long a(Calendar calendar) {
        return calendar == null ? 0L : calendar.getTimeInMillis();
    }

    @Override
    public void a(Calendar calendar, bcy bcy2, bgo bgo2) {
        if (this.a(bgo2)) {
            bcy2.b(this.a(calendar));
            return;
        }
        this.b(calendar.getTime(), bcy2, bgo2);
    }
}

