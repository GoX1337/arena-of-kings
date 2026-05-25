/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.aix;

import com.sun.jna.Native;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.jna.platform.unix.AixLibc;
import oshi.software.common.AbstractNetworkParams;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
final class AixNetworkParams
extends AbstractNetworkParams {
    private static final AixLibc LIBC = AixLibc.INSTANCE;

    AixNetworkParams() {
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
        return AixNetworkParams.getDefaultGateway("netstat -rnf inet");
    }

    @Override
    public String getIpv6DefaultGateway() {
        return AixNetworkParams.getDefaultGateway("netstat -rnf inet6");
    }

    private static String getDefaultGateway(String string) {
        for (String string2 : ExecutingCommand.runNative(string)) {
            String[] stringArray = ParseUtil.whitespaces.split(string2);
            if (stringArray.length <= 7 || !"default".equals(stringArray[0])) continue;
            return stringArray[1];
        }
        return "unknown";
    }
}

