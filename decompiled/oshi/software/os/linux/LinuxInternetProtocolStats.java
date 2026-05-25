/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.linux;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.linux.proc.ProcessStat;
import oshi.driver.unix.NetStat;
import oshi.software.common.AbstractInternetProtocolStats;
import oshi.software.os.InternetProtocolStats;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;
import oshi.util.platform.linux.ProcPath;
import oshi.util.tuples.Pair;

@ThreadSafe
public class LinuxInternetProtocolStats
extends AbstractInternetProtocolStats {
    @Override
    public InternetProtocolStats.TcpStats getTCPv4Stats() {
        return NetStat.queryTcpStats("netstat -st4");
    }

    @Override
    public InternetProtocolStats.UdpStats getUDPv4Stats() {
        return NetStat.queryUdpStats("netstat -su4");
    }

    @Override
    public InternetProtocolStats.UdpStats getUDPv6Stats() {
        return NetStat.queryUdpStats("netstat -su6");
    }

    @Override
    public List<InternetProtocolStats.IPConnection> getConnections() {
        ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList<InternetProtocolStats.IPConnection>();
        Map<Integer, Integer> map = ProcessStat.querySocketToPidMap();
        arrayList.addAll(LinuxInternetProtocolStats.queryConnections("tcp", 4, map));
        arrayList.addAll(LinuxInternetProtocolStats.queryConnections("tcp", 6, map));
        arrayList.addAll(LinuxInternetProtocolStats.queryConnections("udp", 4, map));
        arrayList.addAll(LinuxInternetProtocolStats.queryConnections("udp", 6, map));
        return arrayList;
    }

    private static List<InternetProtocolStats.IPConnection> queryConnections(String string, int n2, Map<Integer, Integer> map) {
        ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList<InternetProtocolStats.IPConnection>();
        for (String string2 : FileUtil.readFile(ProcPath.NET + "/" + string + (n2 == 6 ? "6" : ""))) {
            String[] stringArray;
            if (string2.indexOf(58) < 0 || (stringArray = ParseUtil.whitespaces.split(string2.trim())).length <= 9) continue;
            Pair<byte[], Integer> pair = LinuxInternetProtocolStats.parseIpAddr(stringArray[1]);
            Pair<byte[], Integer> pair2 = LinuxInternetProtocolStats.parseIpAddr(stringArray[2]);
            InternetProtocolStats.TcpState tcpState = LinuxInternetProtocolStats.stateLookup(ParseUtil.hexStringToInt(stringArray[3], 0));
            Pair<Integer, Integer> pair3 = LinuxInternetProtocolStats.parseHexColonHex(stringArray[4]);
            int n3 = ParseUtil.parseIntOrDefault(stringArray[9], 0);
            arrayList.add(new InternetProtocolStats.IPConnection(string + n2, pair.getA(), pair.getB(), pair2.getA(), pair2.getB(), tcpState, pair3.getA(), pair3.getB(), map.getOrDefault(n3, -1)));
        }
        return arrayList;
    }

    private static Pair<byte[], Integer> parseIpAddr(String string) {
        int n2 = string.indexOf(58);
        if (n2 > 0 && n2 < string.length()) {
            byte[] byArray = ParseUtil.hexStringToByteArray(string.substring(0, n2));
            int n3 = 0;
            while (n3 + 3 < byArray.length) {
                byte by2 = byArray[n3];
                byArray[n3] = byArray[n3 + 3];
                byArray[n3 + 3] = by2;
                by2 = byArray[n3 + 1];
                byArray[n3 + 1] = byArray[n3 + 2];
                byArray[n3 + 2] = by2;
                n3 += 4;
            }
            n3 = ParseUtil.hexStringToInt(string.substring(n2 + 1), 0);
            return new Pair<byte[], Integer>(byArray, n3);
        }
        return new Pair<byte[], Integer>(new byte[0], 0);
    }

    private static Pair<Integer, Integer> parseHexColonHex(String string) {
        int n2 = string.indexOf(58);
        if (n2 > 0 && n2 < string.length()) {
            int n3 = ParseUtil.hexStringToInt(string.substring(0, n2), 0);
            int n4 = ParseUtil.hexStringToInt(string.substring(n2 + 1), 0);
            return new Pair<Integer, Integer>(n3, n4);
        }
        return new Pair<Integer, Integer>(0, 0);
    }

    private static InternetProtocolStats.TcpState stateLookup(int n2) {
        switch (n2) {
            case 1: {
                return InternetProtocolStats.TcpState.ESTABLISHED;
            }
            case 2: {
                return InternetProtocolStats.TcpState.SYN_SENT;
            }
            case 3: {
                return InternetProtocolStats.TcpState.SYN_RECV;
            }
            case 4: {
                return InternetProtocolStats.TcpState.FIN_WAIT_1;
            }
            case 5: {
                return InternetProtocolStats.TcpState.FIN_WAIT_2;
            }
            case 6: {
                return InternetProtocolStats.TcpState.TIME_WAIT;
            }
            case 7: {
                return InternetProtocolStats.TcpState.CLOSED;
            }
            case 8: {
                return InternetProtocolStats.TcpState.CLOSE_WAIT;
            }
            case 9: {
                return InternetProtocolStats.TcpState.LAST_ACK;
            }
            case 10: {
                return InternetProtocolStats.TcpState.LISTEN;
            }
            case 11: {
                return InternetProtocolStats.TcpState.CLOSING;
            }
        }
        return InternetProtocolStats.TcpState.UNKNOWN;
    }
}

