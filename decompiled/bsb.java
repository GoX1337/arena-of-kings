/*
 * Decompiled with CFR 0.152.
 */
import java.text.DateFormat;
import java.util.Date;

@bgp
public class bsb
extends bsc<Date> {
    public static final bsb a = new bsb();

    public bsb() {
        this(null, null);
    }

    public bsb(Boolean bl2, DateFormat dateFormat) {
        super(Date.class, bl2, dateFormat);
    }

    public bsb a(Boolean bl2, DateFormat dateFormat) {
        return new bsb(bl2, dateFormat);
    }

    protected long a(Date date) {
        return date == null ? 0L : date.getTime();
    }

    @Override
    public void a(Date date, bcy bcy2, bgo bgo2) {
        if (this.a(bgo2)) {
            bcy2.b(this.a(date));
            return;
        }
        this.b(date, bcy2, bgo2);
    }
}

