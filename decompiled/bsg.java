/*
 * Decompiled with CFR 0.152.
 */
import java.net.InetAddress;

public class bsg
extends btd<InetAddress>
implements bqh {
    protected final boolean a;

    public bsg() {
        this(false);
    }

    public bsg(boolean bl2) {
        super(InetAddress.class);
        this.a = bl2;
    }

    @Override
    public bgb<?> a(bgo bgo2, bfp bfp2) {
        bbk.c c2;
        bbk.d d2 = this.bbk$d_a(bgo2, bfp2, this.a());
        boolean bl2 = false;
        if (d2 != null && ((c2 = d2.bbk$c_a()).a() || c2 == bbk.c.d)) {
            bl2 = true;
        }
        if (bl2 != this.a) {
            return new bsg(bl2);
        }
        return this;
    }

    @Override
    public void a(InetAddress inetAddress, bcy bcy2, bgo bgo2) {
        String string;
        if (this.a) {
            string = inetAddress.getHostAddress();
        } else {
            string = inetAddress.toString().trim();
            int n2 = string.indexOf(47);
            if (n2 >= 0) {
                string = n2 == 0 ? string.substring(1) : string.substring(0, n2);
            }
        }
        bcy2.b(string);
    }

    @Override
    public void a(InetAddress inetAddress, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a((Object)inetAddress, InetAddress.class, bdf.h));
        this.a(inetAddress, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }
}

