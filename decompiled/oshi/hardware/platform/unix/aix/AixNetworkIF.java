/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.aix;

import com.sun.jna.Native;
import com.sun.jna.platform.unix.aix.Perfstat;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.unix.aix.perfstat.PerfstatNetInterface;
import oshi.hardware.NetworkIF;
import oshi.hardware.common.AbstractNetworkIF;
import oshi.util.Memoizer;

@ThreadSafe
public final class AixNetworkIF
extends AbstractNetworkIF {
    private static final Logger LOG = LoggerFactory.getLogger(AixNetworkIF.class);
    private long bytesRecv;
    private long bytesSent;
    private long packetsRecv;
    private long packetsSent;
    private long inErrors;
    private long outErrors;
    private long inDrops;
    private long collisions;
    private long speed;
    private long timeStamp;
    private Supplier<Perfstat.perfstat_netinterface_t[]> netstats;

    public AixNetworkIF(NetworkInterface networkInterface, Supplier<Perfstat.perfstat_netinterface_t[]> supplier) {
        super(networkInterface);
        this.netstats = supplier;
        this.updateAttributes();
    }

    public static List<NetworkIF> getNetworks(boolean bl2) {
        Supplier<Perfstat.perfstat_netinterface_t[]> supplier = Memoizer.memoize(PerfstatNetInterface::queryNetInterfaces, Memoizer.defaultExpiration());
        ArrayList<NetworkIF> arrayList = new ArrayList<NetworkIF>();
        for (NetworkInterface networkInterface : AixNetworkIF.getNetworkInterfaces(bl2)) {
            try {
                arrayList.add(new AixNetworkIF(networkInterface, supplier));
            }
            catch (InstantiationException instantiationException) {
                LOG.debug("Network Interface Instantiation failed: {}", (Object)instantiationException.getMessage());
            }
        }
        return arrayList;
    }

    @Override
    public long getBytesRecv() {
        return this.bytesRecv;
    }

    @Override
    public long getBytesSent() {
        return this.bytesSent;
    }

    @Override
    public long getPacketsRecv() {
        return this.packetsRecv;
    }

    @Override
    public long getPacketsSent() {
        return this.packetsSent;
    }

    @Override
    public long getInErrors() {
        return this.inErrors;
    }

    @Override
    public long getOutErrors() {
        return this.outErrors;
    }

    @Override
    public long getInDrops() {
        return this.inDrops;
    }

    @Override
    public long getCollisions() {
        return this.collisions;
    }

    @Override
    public long getSpeed() {
        return this.speed;
    }

    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public boolean updateAttributes() {
        Perfstat.perfstat_netinterface_t[] perfstat_netinterface_tArray = this.netstats.get();
        long l2 = System.currentTimeMillis();
        for (Perfstat.perfstat_netinterface_t perfstat_netinterface_t2 : perfstat_netinterface_tArray) {
            String string = Native.toString(perfstat_netinterface_t2.name);
            if (!string.equals(this.getName())) continue;
            this.bytesSent = perfstat_netinterface_t2.obytes;
            this.bytesRecv = perfstat_netinterface_t2.ibytes;
            this.packetsSent = perfstat_netinterface_t2.opackets;
            this.packetsRecv = perfstat_netinterface_t2.ipackets;
            this.outErrors = perfstat_netinterface_t2.oerrors;
            this.inErrors = perfstat_netinterface_t2.ierrors;
            this.collisions = perfstat_netinterface_t2.collisions;
            this.inDrops = perfstat_netinterface_t2.if_iqdrops;
            this.speed = perfstat_netinterface_t2.bitrate;
            this.timeStamp = l2;
            return true;
        }
        return false;
    }
}

