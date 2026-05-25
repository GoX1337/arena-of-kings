/*
 * Decompiled with CFR 0.152.
 */
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class bsh
extends btd<InetSocketAddress> {
    public bsh() {
        super(InetSocketAddress.class);
    }

    @Override
    public void a(InetSocketAddress inetSocketAddress, bcy bcy2, bgo bgo2) {
        InetAddress inetAddress = inetSocketAddress.getAddress();
        String string = inetAddress == null ? inetSocketAddress.getHostName() : inetAddress.toString().trim();
        int n2 = string.indexOf(47);
        if (n2 >= 0) {
            string = n2 == 0 ? (inetAddress instanceof Inet6Address ? "[" + string.substring(1) + "]" : string.substring(1)) : string.substring(0, n2);
        }
        bcy2.b(string + ":" + inetSocketAddress.getPort());
    }

    @Override
    public void a(InetSocketAddress inetSocketAddress, bcy bcy2, bgo bgo2, bog bog2) {
        beu beu2 = bog2.a(bcy2, bog2.a((Object)inetSocketAddress, InetSocketAddress.class, bdf.h));
        this.a(inetSocketAddress, bcy2, bgo2);
        bog2.b(bcy2, beu2);
    }
}

