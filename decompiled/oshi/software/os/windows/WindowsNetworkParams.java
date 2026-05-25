/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.windows;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.IPHlpAPI;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.ptr.IntByReference;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractNetworkParams;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
final class WindowsNetworkParams
extends AbstractNetworkParams {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsNetworkParams.class);
    private static final int COMPUTER_NAME_DNS_DOMAIN_FULLY_QUALIFIED = 3;

    WindowsNetworkParams() {
    }

    @Override
    public String getDomainName() {
        char[] cArray = new char[256];
        IntByReference intByReference = new IntByReference(cArray.length);
        if (!Kernel32.INSTANCE.GetComputerNameEx(3, cArray, intByReference)) {
            LOG.error("Failed to get dns domain name. Error code: {}", (Object)Kernel32.INSTANCE.GetLastError());
            return "";
        }
        return Native.toString(cArray);
    }

    @Override
    public String[] getDnsServers() {
        IntByReference intByReference = new IntByReference();
        int n2 = IPHlpAPI.INSTANCE.GetNetworkParams(null, intByReference);
        if (n2 != 111) {
            LOG.error("Failed to get network parameters buffer size. Error code: {}", (Object)n2);
            return new String[0];
        }
        Memory memory = new Memory(intByReference.getValue());
        n2 = IPHlpAPI.INSTANCE.GetNetworkParams(memory, intByReference);
        if (n2 != 0) {
            LOG.error("Failed to get network parameters. Error code: {}", (Object)n2);
            return new String[0];
        }
        IPHlpAPI.FIXED_INFO fIXED_INFO = new IPHlpAPI.FIXED_INFO(memory);
        ArrayList<String> arrayList = new ArrayList<String>();
        IPHlpAPI.IP_ADDR_STRING iP_ADDR_STRING = fIXED_INFO.DnsServerList;
        while (iP_ADDR_STRING != null) {
            String string = Native.toString(iP_ADDR_STRING.IpAddress.String, StandardCharsets.US_ASCII);
            int n3 = string.indexOf(0);
            if (n3 != -1) {
                string = string.substring(0, n3);
            }
            arrayList.add(string);
            iP_ADDR_STRING = iP_ADDR_STRING.Next;
        }
        return arrayList.toArray(new String[0]);
    }

    @Override
    public String getHostName() {
        return Kernel32Util.getComputerName();
    }

    @Override
    public String getIpv4DefaultGateway() {
        return WindowsNetworkParams.parseIpv4Route();
    }

    @Override
    public String getIpv6DefaultGateway() {
        return WindowsNetworkParams.parseIpv6Route();
    }

    private static String parseIpv4Route() {
        List<String> list = ExecutingCommand.runNative("route print -4 0.0.0.0");
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string.trim());
            if (stringArray.length <= 2 || !"0.0.0.0".equals(stringArray[0])) continue;
            return stringArray[2];
        }
        return "";
    }

    private static String parseIpv6Route() {
        List<String> list = ExecutingCommand.runNative("route print -6 ::/0");
        for (String string : list) {
            String[] stringArray = ParseUtil.whitespaces.split(string.trim());
            if (stringArray.length <= 3 || !"::/0".equals(stringArray[2])) continue;
            return stringArray[3];
        }
        return "";
    }
}

