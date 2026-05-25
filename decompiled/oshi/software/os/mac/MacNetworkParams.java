/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.mac;

import com.sun.jna.Native;
import com.sun.jna.ptr.PointerByReference;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.mac.SystemB;
import oshi.jna.platform.unix.CLibrary;
import oshi.software.common.AbstractNetworkParams;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
final class MacNetworkParams
extends AbstractNetworkParams {
    private static final Logger LOG = LoggerFactory.getLogger(MacNetworkParams.class);
    private static final SystemB SYS = SystemB.INSTANCE;
    private static final String IPV6_ROUTE_HEADER = "Internet6:";
    private static final String DEFAULT_GATEWAY = "default";

    MacNetworkParams() {
    }

    @Override
    public String getDomainName() {
        CLibrary.Addrinfo addrinfo = new CLibrary.Addrinfo();
        addrinfo.ai_flags = 2;
        String string = "";
        try {
            string = InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException unknownHostException) {
            LOG.error("Unknown host exception when getting address of local host: {}", (Object)unknownHostException.getMessage());
            return "";
        }
        PointerByReference pointerByReference = new PointerByReference();
        int n2 = SYS.getaddrinfo(string, null, addrinfo, pointerByReference);
        if (n2 > 0) {
            if (LOG.isErrorEnabled()) {
                LOG.error("Failed getaddrinfo(): {}", (Object)SYS.gai_strerror(n2));
            }
            return "";
        }
        CLibrary.Addrinfo addrinfo2 = new CLibrary.Addrinfo(pointerByReference.getValue());
        String string2 = addrinfo2.ai_canonname.trim();
        SYS.freeaddrinfo(pointerByReference.getValue());
        return string2;
    }

    @Override
    public String getHostName() {
        byte[] byArray = new byte[256];
        if (0 != SYS.gethostname(byArray, byArray.length)) {
            return super.getHostName();
        }
        return Native.toString(byArray);
    }

    @Override
    public String getIpv4DefaultGateway() {
        return MacNetworkParams.searchGateway(ExecutingCommand.runNative("route -n get default"));
    }

    @Override
    public String getIpv6DefaultGateway() {
        List<String> list = ExecutingCommand.runNative("netstat -nr");
        boolean bl2 = false;
        for (String string : list) {
            if (bl2 && string.startsWith(DEFAULT_GATEWAY)) {
                String[] stringArray = ParseUtil.whitespaces.split(string);
                if (stringArray.length <= 2 || !stringArray[2].contains("G")) continue;
                return stringArray[1].split("%")[0];
            }
            if (!string.startsWith(IPV6_ROUTE_HEADER)) continue;
            bl2 = true;
        }
        return "";
    }
}

