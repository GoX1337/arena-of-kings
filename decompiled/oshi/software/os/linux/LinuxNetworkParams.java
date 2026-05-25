/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.linux;

import com.sun.jna.Native;
import com.sun.jna.platform.linux.LibC;
import com.sun.jna.ptr.PointerByReference;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.linux.LinuxLibc;
import oshi.jna.platform.unix.CLibrary;
import oshi.software.common.AbstractNetworkParams;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
final class LinuxNetworkParams
extends AbstractNetworkParams {
    private static final Logger LOG = LoggerFactory.getLogger(LinuxNetworkParams.class);
    private static final LinuxLibc LIBC = LinuxLibc.INSTANCE;
    private static final String IPV4_DEFAULT_DEST = "0.0.0.0";
    private static final String IPV6_DEFAULT_DEST = "::/0";

    LinuxNetworkParams() {
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
        int n2 = LIBC.getaddrinfo(string, null, addrinfo, pointerByReference);
        if (n2 > 0) {
            if (LOG.isErrorEnabled()) {
                LOG.error("Failed getaddrinfo(): {}", (Object)LIBC.gai_strerror(n2));
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
        if (0 != LibC.INSTANCE.gethostname(byArray, byArray.length)) {
            return super.getHostName();
        }
        return Native.toString(byArray);
    }

    @Override
    public String getIpv4DefaultGateway() {
        List<String> list = ExecutingCommand.runNative("route -A inet -n");
        if (list.size() <= 2) {
            return "";
        }
        String string = "";
        int n2 = Integer.MAX_VALUE;
        for (int i2 = 2; i2 < list.size(); ++i2) {
            String[] stringArray = ParseUtil.whitespaces.split(list.get(i2));
            if (stringArray.length <= 4 || !stringArray[0].equals(IPV4_DEFAULT_DEST)) continue;
            boolean bl2 = stringArray[3].indexOf(71) != -1;
            int n3 = ParseUtil.parseIntOrDefault(stringArray[4], Integer.MAX_VALUE);
            if (!bl2 || n3 >= n2) continue;
            n2 = n3;
            string = stringArray[1];
        }
        return string;
    }

    @Override
    public String getIpv6DefaultGateway() {
        List<String> list = ExecutingCommand.runNative("route -A inet6 -n");
        if (list.size() <= 2) {
            return "";
        }
        String string = "";
        int n2 = Integer.MAX_VALUE;
        for (int i2 = 2; i2 < list.size(); ++i2) {
            String[] stringArray = ParseUtil.whitespaces.split(list.get(i2));
            if (stringArray.length <= 3 || !stringArray[0].equals(IPV6_DEFAULT_DEST)) continue;
            boolean bl2 = stringArray[2].indexOf(71) != -1;
            int n3 = ParseUtil.parseIntOrDefault(stringArray[3], Integer.MAX_VALUE);
            if (!bl2 || n3 >= n2) continue;
            n2 = n3;
            string = stringArray[1];
        }
        return string;
    }
}

