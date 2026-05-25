/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.aix;

import com.sun.jna.Native;
import com.sun.jna.platform.unix.aix.Perfstat;
import java.util.function.Supplier;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.aix.perfstat.PerfstatProtocol;
import oshi.software.common.AbstractInternetProtocolStats;
import oshi.software.os.InternetProtocolStats;
import oshi.util.Memoizer;

@ThreadSafe
public class AixInternetProtocolStats
extends AbstractInternetProtocolStats {
    private Supplier<Perfstat.perfstat_protocol_t[]> ipstats = Memoizer.memoize(PerfstatProtocol::queryProtocols, Memoizer.defaultExpiration());

    @Override
    public InternetProtocolStats.TcpStats getTCPv4Stats() {
        for (Perfstat.perfstat_protocol_t perfstat_protocol_t2 : this.ipstats.get()) {
            if (!"tcp".equals(Native.toString(perfstat_protocol_t2.name))) continue;
            return new InternetProtocolStats.TcpStats(perfstat_protocol_t2.u.tcp.established, perfstat_protocol_t2.u.tcp.initiated, perfstat_protocol_t2.u.tcp.accepted, perfstat_protocol_t2.u.tcp.dropped, perfstat_protocol_t2.u.tcp.dropped, perfstat_protocol_t2.u.tcp.opackets, perfstat_protocol_t2.u.tcp.ipackets, 0L, perfstat_protocol_t2.u.tcp.ierrors, 0L);
        }
        return new InternetProtocolStats.TcpStats(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L);
    }

    @Override
    public InternetProtocolStats.UdpStats getUDPv4Stats() {
        for (Perfstat.perfstat_protocol_t perfstat_protocol_t2 : this.ipstats.get()) {
            if (!"udp".equals(Native.toString(perfstat_protocol_t2.name))) continue;
            return new InternetProtocolStats.UdpStats(perfstat_protocol_t2.u.udp.opackets, perfstat_protocol_t2.u.udp.ipackets, perfstat_protocol_t2.u.udp.no_socket, perfstat_protocol_t2.u.udp.ierrors);
        }
        return new InternetProtocolStats.UdpStats(0L, 0L, 0L, 0L);
    }
}

