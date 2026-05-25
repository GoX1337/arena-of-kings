/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.solaris;

import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractInternetProtocolStats;
import oshi.software.os.InternetProtocolStats;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;

@ThreadSafe
public class SolarisInternetProtocolStats
extends AbstractInternetProtocolStats {
    @Override
    public InternetProtocolStats.TcpStats getTCPv4Stats() {
        return SolarisInternetProtocolStats.getTcpStats();
    }

    @Override
    public InternetProtocolStats.UdpStats getUDPv4Stats() {
        return SolarisInternetProtocolStats.getUdpStats();
    }

    private static InternetProtocolStats.TcpStats getTcpStats() {
        long l2 = 0L;
        long l3 = 0L;
        long l4 = 0L;
        long l5 = 0L;
        long l6 = 0L;
        long l7 = 0L;
        long l8 = 0L;
        long l9 = 0L;
        long l10 = 0L;
        long l11 = 0L;
        List<String> list = ExecutingCommand.runNative("netstat -s -P tcp");
        list.addAll(ExecutingCommand.runNative("netstat -s -P ip"));
        for (String string : list) {
            String[] stringArray;
            block25: for (String string2 : stringArray = SolarisInternetProtocolStats.splitOnPrefix(string, "tcp")) {
                String[] stringArray2;
                if (string2 == null || (stringArray2 = string2.split("=")).length != 2) continue;
                switch (stringArray2[0].trim()) {
                    case "tcpCurrEstab": {
                        l2 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block25;
                    }
                    case "tcpActiveOpens": {
                        l3 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block25;
                    }
                    case "tcpPassiveOpens": {
                        l4 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block25;
                    }
                    case "tcpAttemptFails": {
                        l5 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block25;
                    }
                    case "tcpEstabResets": {
                        l6 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block25;
                    }
                    case "tcpOutSegs": {
                        l7 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block25;
                    }
                    case "tcpInSegs": {
                        l8 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block25;
                    }
                    case "tcpRetransSegs": {
                        l9 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block25;
                    }
                    case "tcpInErr": {
                        l10 = ParseUtil.getFirstIntValue(stringArray2[1].trim());
                        continue block25;
                    }
                    case "tcpOutRsts": {
                        l11 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block25;
                    }
                }
            }
        }
        return new InternetProtocolStats.TcpStats(l2, l3, l4, l5, l6, l7, l8, l9, l10, l11);
    }

    private static InternetProtocolStats.UdpStats getUdpStats() {
        long l2 = 0L;
        long l3 = 0L;
        long l4 = 0L;
        long l5 = 0L;
        List<String> list = ExecutingCommand.runNative("netstat -s -P udp");
        list.addAll(ExecutingCommand.runNative("netstat -s -P ip"));
        for (String string : list) {
            String[] stringArray;
            block13: for (String string2 : stringArray = SolarisInternetProtocolStats.splitOnPrefix(string, "udp")) {
                String[] stringArray2;
                if (string2 == null || (stringArray2 = string2.split("=")).length != 2) continue;
                switch (stringArray2[0].trim()) {
                    case "udpOutDatagrams": {
                        l2 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block13;
                    }
                    case "udpInDatagrams": {
                        l3 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block13;
                    }
                    case "udpNoPorts": {
                        l4 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block13;
                    }
                    case "udpInErrors": {
                        l5 = ParseUtil.parseLongOrDefault(stringArray2[1].trim(), 0L);
                        continue block13;
                    }
                }
            }
        }
        return new InternetProtocolStats.UdpStats(l2, l3, l4, l5);
    }

    private static String[] splitOnPrefix(String string, String string2) {
        String[] stringArray = new String[2];
        int n2 = string.indexOf(string2);
        if (n2 >= 0) {
            int n3 = string.indexOf(string2, n2 + 1);
            if (n3 >= 0) {
                stringArray[0] = string.substring(n2, n3).trim();
                stringArray[1] = string.substring(n3).trim();
            } else {
                stringArray[0] = string.substring(n2).trim();
            }
        }
        return stringArray;
    }
}

