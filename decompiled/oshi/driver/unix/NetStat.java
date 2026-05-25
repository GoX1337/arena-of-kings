/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.unix;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.InternetProtocolStats;
import oshi.util.ExecutingCommand;
import oshi.util.ParseUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public final class NetStat {
    private NetStat() {
    }

    public static Pair<Long, Long> queryTcpnetstat() {
        long l2 = 0L;
        long l3 = 0L;
        List<String> list = ExecutingCommand.runNative("netstat -n -p tcp");
        for (String string : list) {
            if (!string.endsWith("ESTABLISHED")) continue;
            if (string.startsWith("tcp4")) {
                ++l2;
                continue;
            }
            if (!string.startsWith("tcp6")) continue;
            ++l3;
        }
        return new Pair<Long, Long>(l2, l3);
    }

    public static List<InternetProtocolStats.IPConnection> queryNetstat() {
        ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList<InternetProtocolStats.IPConnection>();
        List<String> list = ExecutingCommand.runNative("netstat -n");
        for (String string : list) {
            String[] stringArray = null;
            if (!string.startsWith("tcp") && !string.startsWith("udp") || (stringArray = ParseUtil.whitespaces.split(string)).length < 5) continue;
            String string2 = stringArray.length == 6 ? stringArray[5] : null;
            String string3 = stringArray[0];
            Pair<byte[], Integer> pair = NetStat.parseIP(stringArray[3]);
            Pair<byte[], Integer> pair2 = NetStat.parseIP(stringArray[4]);
            arrayList.add(new InternetProtocolStats.IPConnection(string3, pair.getA(), pair.getB(), pair2.getA(), pair2.getB(), string2 == null ? InternetProtocolStats.TcpState.NONE : InternetProtocolStats.TcpState.valueOf(string2), ParseUtil.parseIntOrDefault(stringArray[2], 0), ParseUtil.parseIntOrDefault(stringArray[1], 0), -1));
        }
        return arrayList;
    }

    private static Pair<byte[], Integer> parseIP(String string) {
        int n2 = string.lastIndexOf(46);
        if (n2 > 0 && string.length() > n2) {
            int n3 = ParseUtil.parseIntOrDefault(string.substring(n2 + 1), 0);
            String string2 = string.substring(0, n2);
            try {
                return new Pair<byte[], Integer>(InetAddress.getByName(string2).getAddress(), n3);
            }
            catch (UnknownHostException unknownHostException) {
                try {
                    string2 = string2.endsWith(":") && string2.contains("::") ? string2 + "0" : (string2.endsWith(":") || string2.contains("::") ? string2 + ":0" : string2 + "::0");
                    return new Pair<byte[], Integer>(InetAddress.getByName(string2).getAddress(), n3);
                }
                catch (UnknownHostException unknownHostException2) {
                    return new Pair<byte[], Integer>(new byte[0], n3);
                }
            }
        }
        return new Pair<byte[], Integer>(new byte[0], 0);
    }

    public static InternetProtocolStats.TcpStats queryTcpStats(String string) {
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
        List<String> list = ExecutingCommand.runNative(string);
        block38: for (String string2 : list) {
            String[] stringArray = string2.trim().split(" ", 2);
            if (stringArray.length != 2) continue;
            switch (stringArray[1]) {
                case "connections established": 
                case "connection established (including accepts)": 
                case "connections established (including accepts)": {
                    l2 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    continue block38;
                }
                case "active connection openings": {
                    l3 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    continue block38;
                }
                case "passive connection openings": {
                    l4 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    continue block38;
                }
                case "failed connection attempts": 
                case "bad connection attempts": {
                    l5 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    continue block38;
                }
                case "connection resets received": 
                case "dropped due to RST": {
                    l6 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    continue block38;
                }
                case "segments sent out": 
                case "packet sent": 
                case "packets sent": {
                    l7 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    continue block38;
                }
                case "segments received": 
                case "packet received": 
                case "packets received": {
                    l8 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    continue block38;
                }
                case "segments retransmitted": {
                    l9 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    continue block38;
                }
                case "bad segments received": 
                case "discarded for bad checksum": 
                case "discarded for bad checksums": 
                case "discarded for bad header offset field": 
                case "discarded for bad header offset fields": 
                case "discarded because packet too short": 
                case "discarded for missing IPsec protection": {
                    l10 += ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    continue block38;
                }
                case "resets sent": {
                    l11 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    continue block38;
                }
            }
            if (!stringArray[1].contains("retransmitted") || !stringArray[1].contains("data packet")) continue;
            l9 += ParseUtil.parseLongOrDefault(stringArray[0], 0L);
        }
        return new InternetProtocolStats.TcpStats(l2, l3, l4, l5, l6, l7, l8, l9, l10, l11);
    }

    public static InternetProtocolStats.UdpStats queryUdpStats(String string) {
        long l2 = 0L;
        long l3 = 0L;
        long l4 = 0L;
        long l5 = 0L;
        List<String> list = ExecutingCommand.runNative(string);
        for (String string2 : list) {
            String[] stringArray = string2.trim().split(" ", 2);
            if (stringArray.length != 2) continue;
            switch (stringArray[1]) {
                case "packets sent": 
                case "datagram output": 
                case "datagrams output": {
                    l2 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    break;
                }
                case "packets received": 
                case "datagram received": 
                case "datagrams received": {
                    l3 = ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    break;
                }
                case "packets to unknown port received": 
                case "dropped due to no socket": 
                case "broadcast/multicast datagram dropped due to no socket": 
                case "broadcast/multicast datagrams dropped due to no socket": {
                    l4 += ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    break;
                }
                case "packet receive errors": 
                case "with incomplete header": 
                case "with bad data length field": 
                case "with bad checksum": 
                case "woth no checksum": {
                    l5 += ParseUtil.parseLongOrDefault(stringArray[0], 0L);
                    break;
                }
            }
        }
        return new InternetProtocolStats.UdpStats(l2, l3, l4, l5);
    }
}

