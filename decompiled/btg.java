/*
 * Decompiled with CFR 0.152.
 */
import java.util.TimeZone;

public class btg
extends btd<TimeZone> {
    public btg() {
        super(TimeZone.class);
    }

    @Override
    public void a(TimeZone timeZone, bcy bcy2, bgo bgo2) {
        bcy2.b(timeZone.getID());
    }

    @Override
    public void a(TimeZone timeZone, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a((Object)timeZone, TimeZone.class, bdf.h));
        this.a(timeZone, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }
}

