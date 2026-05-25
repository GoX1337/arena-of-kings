/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.freebsd;

import com.sun.jna.Native;
import com.sun.jna.ptr.PointerByReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.unix.CLibrary;
import oshi.jna.platform.unix.FreeBsdLibc;
import oshi.software.common.AbstractNetworkParams;
import oshi.util.ExecutingCommand;

@ThreadSafe
final class FreeBsdNetworkParams
extends AbstractNetworkParams {
    private static final Logger LOG = LoggerFactory.getLogger(FreeBsdNetworkParams.class);
    private static final FreeBsdLibc LIBC = FreeBsdLibc.INSTANCE;

    FreeBsdNetworkParams() {
    }

    @Override
    public String getDomainName() {
        PointerByReference pointerByReference;
        CLibrary.Addrinfo addrinfo = new CLibrary.Addrinfo();
        addrinfo.ai_flags = 2;
        String string = this.getHostName();
        int n2 = LIBC.getaddrinfo(string, null, addrinfo, pointerByReference = new PointerByReference());
        if (n2 > 0) {
            if (LOG.isErrorEnabled()) {
                LOG.warn("Failed getaddrinfo(): {}", (Object)LIBC.gai_strerror(n2));
            }
            return "";
        }
        CLibrary.Addrinfo addrinfo2 = new CLibrary.Addrinfo(pointerByReference.getValue());
        String string2 = addrinfo2.ai_canonname.trim();
        LIBC.freeaddrinfo(pointerByReference.getValue());
        return string2;
    }

    @Override
    public String getHostName() {
        byte[] byArray = new byte[256];
        if (0 != LIBC.gethostname(byArray, byArray.length)) {
            return super.getHostName();
        }
        return Native.toString(byArray);
    }

    @Override
    public String getIpv4DefaultGateway() {
        return FreeBsdNetworkParams.searchGateway(ExecutingCommand.runNative("route -4 get default"));
    }

    @Override
    public String getIpv6DefaultGateway() {
        return FreeBsdNetworkParams.searchGateway(ExecutingCommand.runNative("route -6 get default"));
    }
}

