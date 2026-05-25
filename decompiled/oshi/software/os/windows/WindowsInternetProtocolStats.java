/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.windows;

import com.sun.jna.Memory;
import com.sun.jna.platform.win32.IPHlpAPI;
import com.sun.jna.platform.win32.VersionHelpers;
import com.sun.jna.ptr.IntByReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractInternetProtocolStats;
import oshi.software.os.InternetProtocolStats;
import oshi.util.ParseUtil;

@ThreadSafe
public class WindowsInternetProtocolStats
extends AbstractInternetProtocolStats {
    private static final IPHlpAPI IPHLP = IPHlpAPI.INSTANCE;
    private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();

    @Override
    public InternetProtocolStats.TcpStats getTCPv4Stats() {
        IPHlpAPI.MIB_TCPSTATS mIB_TCPSTATS = new IPHlpAPI.MIB_TCPSTATS();
        IPHLP.GetTcpStatisticsEx(mIB_TCPSTATS, 2);
        return new InternetProtocolStats.TcpStats(mIB_TCPSTATS.dwCurrEstab, mIB_TCPSTATS.dwActiveOpens, mIB_TCPSTATS.dwPassiveOpens, mIB_TCPSTATS.dwAttemptFails, mIB_TCPSTATS.dwEstabResets, mIB_TCPSTATS.dwOutSegs, mIB_TCPSTATS.dwInSegs, mIB_TCPSTATS.dwRetransSegs, mIB_TCPSTATS.dwInErrs, mIB_TCPSTATS.dwOutRsts);
    }

    @Override
    public InternetProtocolStats.TcpStats getTCPv6Stats() {
        IPHlpAPI.MIB_TCPSTATS mIB_TCPSTATS = new IPHlpAPI.MIB_TCPSTATS();
        IPHLP.GetTcpStatisticsEx(mIB_TCPSTATS, 23);
        return new InternetProtocolStats.TcpStats(mIB_TCPSTATS.dwCurrEstab, mIB_TCPSTATS.dwActiveOpens, mIB_TCPSTATS.dwPassiveOpens, mIB_TCPSTATS.dwAttemptFails, mIB_TCPSTATS.dwEstabResets, mIB_TCPSTATS.dwOutSegs, mIB_TCPSTATS.dwInSegs, mIB_TCPSTATS.dwRetransSegs, mIB_TCPSTATS.dwInErrs, mIB_TCPSTATS.dwOutRsts);
    }

    @Override
    public InternetProtocolStats.UdpStats getUDPv4Stats() {
        IPHlpAPI.MIB_UDPSTATS mIB_UDPSTATS = new IPHlpAPI.MIB_UDPSTATS();
        IPHLP.GetUdpStatisticsEx(mIB_UDPSTATS, 2);
        return new InternetProtocolStats.UdpStats(mIB_UDPSTATS.dwOutDatagrams, mIB_UDPSTATS.dwInDatagrams, mIB_UDPSTATS.dwNoPorts, mIB_UDPSTATS.dwInErrors);
    }

    @Override
    public InternetProtocolStats.UdpStats getUDPv6Stats() {
        IPHlpAPI.MIB_UDPSTATS mIB_UDPSTATS = new IPHlpAPI.MIB_UDPSTATS();
        IPHLP.GetUdpStatisticsEx(mIB_UDPSTATS, 23);
        return new InternetProtocolStats.UdpStats(mIB_UDPSTATS.dwOutDatagrams, mIB_UDPSTATS.dwInDatagrams, mIB_UDPSTATS.dwNoPorts, mIB_UDPSTATS.dwInErrors);
    }

    @Override
    public List<InternetProtocolStats.IPConnection> getConnections() {
        if (IS_VISTA_OR_GREATER) {
            ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList<InternetProtocolStats.IPConnection>();
            arrayList.addAll(WindowsInternetProtocolStats.queryTCPv4Connections());
            arrayList.addAll(WindowsInternetProtocolStats.queryTCPv6Connections());
            arrayList.addAll(WindowsInternetProtocolStats.queryUDPv4Connections());
            arrayList.addAll(WindowsInternetProtocolStats.queryUDPv6Connections());
            return arrayList;
        }
        return Collections.emptyList();
    }

    private static List<InternetProtocolStats.IPConnection> queryTCPv4Connections() {
        Memory memory;
        int n2;
        ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList<InternetProtocolStats.IPConnection>();
        IntByReference intByReference = new IntByReference();
        IPHLP.GetExtendedTcpTable(null, intByReference, false, 2, 5, 0);
        do {
            n2 = intByReference.getValue();
            memory = new Memory(n2);
            IPHLP.GetExtendedTcpTable(memory, intByReference, false, 2, 5, 0);
        } while (n2 < intByReference.getValue());
        IPHlpAPI.MIB_TCPTABLE_OWNER_PID mIB_TCPTABLE_OWNER_PID = new IPHlpAPI.MIB_TCPTABLE_OWNER_PID(memory);
        for (int i2 = 0; i2 < mIB_TCPTABLE_OWNER_PID.dwNumEntries; ++i2) {
            IPHlpAPI.MIB_TCPROW_OWNER_PID mIB_TCPROW_OWNER_PID = mIB_TCPTABLE_OWNER_PID.table[i2];
            arrayList.add(new InternetProtocolStats.IPConnection("tcp4", ParseUtil.parseIntToIP(mIB_TCPROW_OWNER_PID.dwLocalAddr), ParseUtil.bigEndian16ToLittleEndian(mIB_TCPROW_OWNER_PID.dwLocalPort), ParseUtil.parseIntToIP(mIB_TCPROW_OWNER_PID.dwRemoteAddr), ParseUtil.bigEndian16ToLittleEndian(mIB_TCPROW_OWNER_PID.dwRemotePort), WindowsInternetProtocolStats.stateLookup(mIB_TCPROW_OWNER_PID.dwState), 0, 0, mIB_TCPROW_OWNER_PID.dwOwningPid));
        }
        return arrayList;
    }

    private static List<InternetProtocolStats.IPConnection> queryTCPv6Connections() {
        Memory memory;
        int n2;
        ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList<InternetProtocolStats.IPConnection>();
        IntByReference intByReference = new IntByReference();
        IPHLP.GetExtendedTcpTable(null, intByReference, false, 23, 5, 0);
        do {
            n2 = intByReference.getValue();
            memory = new Memory(n2);
            IPHLP.GetExtendedTcpTable(memory, intByReference, false, 23, 5, 0);
        } while (n2 < intByReference.getValue());
        IPHlpAPI.MIB_TCP6TABLE_OWNER_PID mIB_TCP6TABLE_OWNER_PID = new IPHlpAPI.MIB_TCP6TABLE_OWNER_PID(memory);
        for (int i2 = 0; i2 < mIB_TCP6TABLE_OWNER_PID.dwNumEntries; ++i2) {
            IPHlpAPI.MIB_TCP6ROW_OWNER_PID mIB_TCP6ROW_OWNER_PID = mIB_TCP6TABLE_OWNER_PID.table[i2];
            arrayList.add(new InternetProtocolStats.IPConnection("tcp6", mIB_TCP6ROW_OWNER_PID.LocalAddr, ParseUtil.bigEndian16ToLittleEndian(mIB_TCP6ROW_OWNER_PID.dwLocalPort), mIB_TCP6ROW_OWNER_PID.RemoteAddr, ParseUtil.bigEndian16ToLittleEndian(mIB_TCP6ROW_OWNER_PID.dwRemotePort), WindowsInternetProtocolStats.stateLookup(mIB_TCP6ROW_OWNER_PID.State), 0, 0, mIB_TCP6ROW_OWNER_PID.dwOwningPid));
        }
        return arrayList;
    }

    private static List<InternetProtocolStats.IPConnection> queryUDPv4Connections() {
        Memory memory;
        int n2;
        ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList<InternetProtocolStats.IPConnection>();
        IntByReference intByReference = new IntByReference();
        IPHLP.GetExtendedUdpTable(null, intByReference, false, 2, 1, 0);
        do {
            n2 = intByReference.getValue();
            memory = new Memory(n2);
            IPHLP.GetExtendedUdpTable(memory, intByReference, false, 2, 1, 0);
        } while (n2 < intByReference.getValue());
        IPHlpAPI.MIB_UDPTABLE_OWNER_PID mIB_UDPTABLE_OWNER_PID = new IPHlpAPI.MIB_UDPTABLE_OWNER_PID(memory);
        for (int i2 = 0; i2 < mIB_UDPTABLE_OWNER_PID.dwNumEntries; ++i2) {
            IPHlpAPI.MIB_UDPROW_OWNER_PID mIB_UDPROW_OWNER_PID = mIB_UDPTABLE_OWNER_PID.table[i2];
            arrayList.add(new InternetProtocolStats.IPConnection("udp4", ParseUtil.parseIntToIP(mIB_UDPROW_OWNER_PID.dwLocalAddr), ParseUtil.bigEndian16ToLittleEndian(mIB_UDPROW_OWNER_PID.dwLocalPort), new byte[0], 0, InternetProtocolStats.TcpState.NONE, 0, 0, mIB_UDPROW_OWNER_PID.dwOwningPid));
        }
        return arrayList;
    }

    private static List<InternetProtocolStats.IPConnection> queryUDPv6Connections() {
        Memory memory;
        int n2;
        ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList<InternetProtocolStats.IPConnection>();
        IntByReference intByReference = new IntByReference();
        IPHLP.GetExtendedUdpTable(null, intByReference, false, 23, 1, 0);
        do {
            n2 = intByReference.getValue();
            memory = new Memory(n2);
            IPHLP.GetExtendedUdpTable(memory, intByReference, false, 23, 1, 0);
        } while (n2 < intByReference.getValue());
        IPHlpAPI.MIB_UDP6TABLE_OWNER_PID mIB_UDP6TABLE_OWNER_PID = new IPHlpAPI.MIB_UDP6TABLE_OWNER_PID(memory);
        for (int i2 = 0; i2 < mIB_UDP6TABLE_OWNER_PID.dwNumEntries; ++i2) {
            IPHlpAPI.MIB_UDP6ROW_OWNER_PID mIB_UDP6ROW_OWNER_PID = mIB_UDP6TABLE_OWNER_PID.table[i2];
            arrayList.add(new InternetProtocolStats.IPConnection("udp6", mIB_UDP6ROW_OWNER_PID.ucLocalAddr, ParseUtil.bigEndian16ToLittleEndian(mIB_UDP6ROW_OWNER_PID.dwLocalPort), new byte[0], 0, InternetProtocolStats.TcpState.NONE, 0, 0, mIB_UDP6ROW_OWNER_PID.dwOwningPid));
        }
        return arrayList;
    }

    private static InternetProtocolStats.TcpState stateLookup(int n2) {
        switch (n2) {
            case 1: 
            case 12: {
                return InternetProtocolStats.TcpState.CLOSED;
            }
            case 2: {
                return InternetProtocolStats.TcpState.LISTEN;
            }
            case 3: {
                return InternetProtocolStats.TcpState.SYN_SENT;
            }
            case 4: {
                return InternetProtocolStats.TcpState.SYN_RECV;
            }
            case 5: {
                return InternetProtocolStats.TcpState.ESTABLISHED;
            }
            case 6: {
                return InternetProtocolStats.TcpState.FIN_WAIT_1;
            }
            case 7: {
                return InternetProtocolStats.TcpState.FIN_WAIT_2;
            }
            case 8: {
                return InternetProtocolStats.TcpState.CLOSE_WAIT;
            }
            case 9: {
                return InternetProtocolStats.TcpState.CLOSING;
            }
            case 10: {
                return InternetProtocolStats.TcpState.LAST_ACK;
            }
            case 11: {
                return InternetProtocolStats.TcpState.TIME_WAIT;
            }
        }
        return InternetProtocolStats.TcpState.UNKNOWN;
    }
}

