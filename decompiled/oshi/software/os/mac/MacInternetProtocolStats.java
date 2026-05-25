/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.mac;

import com.sun.jna.Memory;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.NetStat;
import oshi.jna.platform.mac.SystemB;
import oshi.jna.platform.unix.CLibrary;
import oshi.software.common.AbstractInternetProtocolStats;
import oshi.software.os.InternetProtocolStats;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;
import oshi.util.platform.mac.SysctlUtil;
import oshi.util.tuples.Pair;

@ThreadSafe
public class MacInternetProtocolStats
extends AbstractInternetProtocolStats {
    private boolean isElevated;
    private Supplier<Pair<Long, Long>> establishedv4v6 = Memoizer.memoize(NetStat::queryTcpnetstat, Memoizer.defaultExpiration());
    private Supplier<CLibrary.BsdTcpstat> tcpstat = Memoizer.memoize(MacInternetProtocolStats::queryTcpstat, Memoizer.defaultExpiration());
    private Supplier<CLibrary.BsdUdpstat> udpstat = Memoizer.memoize(MacInternetProtocolStats::queryUdpstat, Memoizer.defaultExpiration());
    private Supplier<CLibrary.BsdIpstat> ipstat = Memoizer.memoize(MacInternetProtocolStats::queryIpstat, Memoizer.defaultExpiration());
    private Supplier<CLibrary.BsdIp6stat> ip6stat = Memoizer.memoize(MacInternetProtocolStats::queryIp6stat, Memoizer.defaultExpiration());

    public MacInternetProtocolStats(boolean bl2) {
        this.isElevated = bl2;
    }

    @Override
    public InternetProtocolStats.TcpStats getTCPv4Stats() {
        CLibrary.BsdTcpstat bsdTcpstat = this.tcpstat.get();
        if (this.isElevated) {
            return new InternetProtocolStats.TcpStats(this.establishedv4v6.get().getA(), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_connattempt), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_accepts), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_conndrops), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_drops), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_sndpack), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_rcvpack), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_sndrexmitpack), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_rcvbadsum + bsdTcpstat.tcps_rcvbadoff + bsdTcpstat.tcps_rcvmemdrop + bsdTcpstat.tcps_rcvshort), 0L);
        }
        CLibrary.BsdIpstat bsdIpstat = this.ipstat.get();
        CLibrary.BsdUdpstat bsdUdpstat = this.udpstat.get();
        return new InternetProtocolStats.TcpStats(this.establishedv4v6.get().getA(), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_connattempt), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_accepts), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_conndrops), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_drops), Math.max(0L, ParseUtil.unsignedIntToLong(bsdIpstat.ips_delivered - bsdUdpstat.udps_opackets)), Math.max(0L, ParseUtil.unsignedIntToLong(bsdIpstat.ips_total - bsdUdpstat.udps_ipackets)), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_sndrexmitpack), Math.max(0L, ParseUtil.unsignedIntToLong(bsdIpstat.ips_badsum + bsdIpstat.ips_tooshort + bsdIpstat.ips_toosmall + bsdIpstat.ips_badhlen + bsdIpstat.ips_badlen - bsdUdpstat.udps_hdrops + bsdUdpstat.udps_badsum + bsdUdpstat.udps_badlen)), 0L);
    }

    @Override
    public InternetProtocolStats.TcpStats getTCPv6Stats() {
        CLibrary.BsdIp6stat bsdIp6stat = this.ip6stat.get();
        CLibrary.BsdUdpstat bsdUdpstat = this.udpstat.get();
        return new InternetProtocolStats.TcpStats(this.establishedv4v6.get().getB(), 0L, 0L, 0L, 0L, bsdIp6stat.ip6s_localout - ParseUtil.unsignedIntToLong(bsdUdpstat.udps_snd6_swcsum), bsdIp6stat.ip6s_total - ParseUtil.unsignedIntToLong(bsdUdpstat.udps_rcv6_swcsum), 0L, 0L, 0L);
    }

    @Override
    public InternetProtocolStats.UdpStats getUDPv4Stats() {
        CLibrary.BsdUdpstat bsdUdpstat = this.udpstat.get();
        return new InternetProtocolStats.UdpStats(ParseUtil.unsignedIntToLong(bsdUdpstat.udps_opackets), ParseUtil.unsignedIntToLong(bsdUdpstat.udps_ipackets), ParseUtil.unsignedIntToLong(bsdUdpstat.udps_noportmcast), ParseUtil.unsignedIntToLong(bsdUdpstat.udps_hdrops + bsdUdpstat.udps_badsum + bsdUdpstat.udps_badlen));
    }

    @Override
    public InternetProtocolStats.UdpStats getUDPv6Stats() {
        CLibrary.BsdUdpstat bsdUdpstat = this.udpstat.get();
        return new InternetProtocolStats.UdpStats(ParseUtil.unsignedIntToLong(bsdUdpstat.udps_snd6_swcsum), ParseUtil.unsignedIntToLong(bsdUdpstat.udps_rcv6_swcsum), 0L, 0L);
    }

    @Override
    public List<InternetProtocolStats.IPConnection> getConnections() {
        ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList<InternetProtocolStats.IPConnection>();
        int[] nArray = new int[1024];
        int n2 = SystemB.INSTANCE.proc_listpids(1, 0, nArray, nArray.length * com.sun.jna.platform.mac.SystemB.INT_SIZE) / com.sun.jna.platform.mac.SystemB.INT_SIZE;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (nArray[i2] <= 0) continue;
            for (Integer n3 : MacInternetProtocolStats.queryFdList(nArray[i2])) {
                InternetProtocolStats.IPConnection iPConnection = MacInternetProtocolStats.queryIPConnection(nArray[i2], n3);
                if (iPConnection == null) continue;
                arrayList.add(iPConnection);
            }
        }
        return arrayList;
    }

    private static List<Integer> queryFdList(int n2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = SystemB.INSTANCE.proc_pidinfo(n2, 1, 0L, null, 0);
        if (n3 > 0) {
            SystemB.ProcFdInfo procFdInfo = new SystemB.ProcFdInfo();
            int n4 = n3 / procFdInfo.size();
            SystemB.ProcFdInfo[] procFdInfoArray = (SystemB.ProcFdInfo[])procFdInfo.com_sun_jna_Structure_arr_toArray(n4);
            n3 = SystemB.INSTANCE.proc_pidinfo(n2, 1, 0L, procFdInfoArray[0], n3);
            n4 = n3 / procFdInfo.size();
            for (int i2 = 0; i2 < n4; ++i2) {
                if (procFdInfoArray[i2].proc_fdtype != 2) continue;
                arrayList.add(procFdInfoArray[i2].proc_fd);
            }
        }
        return arrayList;
    }

    private static InternetProtocolStats.IPConnection queryIPConnection(int n2, int n3) {
        SystemB.SocketFdInfo socketFdInfo = new SystemB.SocketFdInfo();
        int n4 = SystemB.INSTANCE.proc_pidfdinfo(n2, n3, 3, socketFdInfo, socketFdInfo.size());
        if (socketFdInfo.size() == n4 && socketFdInfo.psi.soi_family == 2 || socketFdInfo.psi.soi_family == 30) {
            byte[] byArray;
            byte[] byArray2;
            String string;
            InternetProtocolStats.TcpState tcpState;
            SystemB.InSockInfo inSockInfo;
            if (socketFdInfo.psi.soi_kind == 2) {
                socketFdInfo.psi.soi_proto.setType("pri_tcp");
                socketFdInfo.psi.soi_proto.read();
                inSockInfo = socketFdInfo.psi.soi_proto.pri_tcp.tcpsi_ini;
                tcpState = MacInternetProtocolStats.stateLookup(socketFdInfo.psi.soi_proto.pri_tcp.tcpsi_state);
                string = "tcp";
            } else if (socketFdInfo.psi.soi_kind == 1) {
                socketFdInfo.psi.soi_proto.setType("pri_in");
                socketFdInfo.psi.soi_proto.read();
                inSockInfo = socketFdInfo.psi.soi_proto.pri_in;
                tcpState = InternetProtocolStats.TcpState.NONE;
                string = "udp";
            } else {
                return null;
            }
            if (inSockInfo.insi_vflag == 1) {
                byArray2 = ParseUtil.parseIntToIP(inSockInfo.insi_laddr[3]);
                byArray = ParseUtil.parseIntToIP(inSockInfo.insi_faddr[3]);
                string = string + "4";
            } else if (inSockInfo.insi_vflag == 2) {
                byArray2 = ParseUtil.parseIntArrayToIP(inSockInfo.insi_laddr);
                byArray = ParseUtil.parseIntArrayToIP(inSockInfo.insi_faddr);
                string = string + "6";
            } else {
                return null;
            }
            int n5 = ParseUtil.bigEndian16ToLittleEndian(inSockInfo.insi_lport);
            int n6 = ParseUtil.bigEndian16ToLittleEndian(inSockInfo.insi_fport);
            return new InternetProtocolStats.IPConnection(string, byArray2, n5, byArray, n6, tcpState, socketFdInfo.psi.soi_qlen, socketFdInfo.psi.soi_incqlen, n2);
        }
        return null;
    }

    private static InternetProtocolStats.TcpState stateLookup(int n2) {
        switch (n2) {
            case 0: {
                return InternetProtocolStats.TcpState.CLOSED;
            }
            case 1: {
                return InternetProtocolStats.TcpState.LISTEN;
            }
            case 2: {
                return InternetProtocolStats.TcpState.SYN_SENT;
            }
            case 3: {
                return InternetProtocolStats.TcpState.SYN_RECV;
            }
            case 4: {
                return InternetProtocolStats.TcpState.ESTABLISHED;
            }
            case 5: {
                return InternetProtocolStats.TcpState.CLOSE_WAIT;
            }
            case 6: {
                return InternetProtocolStats.TcpState.FIN_WAIT_1;
            }
            case 7: {
                return InternetProtocolStats.TcpState.CLOSING;
            }
            case 8: {
                return InternetProtocolStats.TcpState.LAST_ACK;
            }
            case 9: {
                return InternetProtocolStats.TcpState.FIN_WAIT_2;
            }
            case 10: {
                return InternetProtocolStats.TcpState.TIME_WAIT;
            }
        }
        return InternetProtocolStats.TcpState.UNKNOWN;
    }

    private static CLibrary.BsdTcpstat queryTcpstat() {
        CLibrary.BsdTcpstat bsdTcpstat = new CLibrary.BsdTcpstat();
        Memory memory = SysctlUtil.sysctl("net.inet.tcp.stats");
        if (memory != null && memory.size() >= 128L) {
            bsdTcpstat.tcps_connattempt = memory.getInt(0L);
            bsdTcpstat.tcps_accepts = memory.getInt(4L);
            bsdTcpstat.tcps_drops = memory.getInt(12L);
            bsdTcpstat.tcps_conndrops = memory.getInt(16L);
            bsdTcpstat.tcps_sndpack = memory.getInt(64L);
            bsdTcpstat.tcps_sndrexmitpack = memory.getInt(72L);
            bsdTcpstat.tcps_rcvpack = memory.getInt(104L);
            bsdTcpstat.tcps_rcvbadsum = memory.getInt(112L);
            bsdTcpstat.tcps_rcvbadoff = memory.getInt(116L);
            bsdTcpstat.tcps_rcvmemdrop = memory.getInt(120L);
            bsdTcpstat.tcps_rcvshort = memory.getInt(124L);
        }
        return bsdTcpstat;
    }

    private static CLibrary.BsdIpstat queryIpstat() {
        CLibrary.BsdIpstat bsdIpstat = new CLibrary.BsdIpstat();
        Memory memory = SysctlUtil.sysctl("net.inet.ip.stats");
        if (memory != null && memory.size() >= 60L) {
            bsdIpstat.ips_total = memory.getInt(0L);
            bsdIpstat.ips_badsum = memory.getInt(4L);
            bsdIpstat.ips_tooshort = memory.getInt(8L);
            bsdIpstat.ips_toosmall = memory.getInt(12L);
            bsdIpstat.ips_badhlen = memory.getInt(16L);
            bsdIpstat.ips_badlen = memory.getInt(20L);
            bsdIpstat.ips_delivered = memory.getInt(56L);
        }
        return bsdIpstat;
    }

    private static CLibrary.BsdIp6stat queryIp6stat() {
        CLibrary.BsdIp6stat bsdIp6stat = new CLibrary.BsdIp6stat();
        Memory memory = SysctlUtil.sysctl("net.inet6.ip6.stats");
        if (memory != null && memory.size() >= 96L) {
            bsdIp6stat.ip6s_total = memory.getLong(0L);
            bsdIp6stat.ip6s_localout = memory.getLong(88L);
        }
        return bsdIp6stat;
    }

    public static CLibrary.BsdUdpstat queryUdpstat() {
        CLibrary.BsdUdpstat bsdUdpstat = new CLibrary.BsdUdpstat();
        Memory memory = SysctlUtil.sysctl("net.inet.udp.stats");
        if (memory != null && memory.size() >= 1644L) {
            bsdUdpstat.udps_ipackets = memory.getInt(0L);
            bsdUdpstat.udps_hdrops = memory.getInt(4L);
            bsdUdpstat.udps_badsum = memory.getInt(8L);
            bsdUdpstat.udps_badlen = memory.getInt(12L);
            bsdUdpstat.udps_opackets = memory.getInt(36L);
            bsdUdpstat.udps_noportmcast = memory.getInt(48L);
            bsdUdpstat.udps_rcv6_swcsum = memory.getInt(64L);
            bsdUdpstat.udps_snd6_swcsum = memory.getInt(80L);
        }
        return bsdUdpstat;
    }
}

