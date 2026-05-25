/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.unix.solaris;

import com.sun.jna.platform.unix.solaris.LibKstat;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.NetworkIF;
import oshi.hardware.common.AbstractNetworkIF;
import oshi.util.platform.unix.solaris.KstatUtil;

@ThreadSafe
public final class SolarisNetworkIF
extends AbstractNetworkIF {
    private static final Logger LOG = LoggerFactory.getLogger(SolarisNetworkIF.class);
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

    public SolarisNetworkIF(NetworkInterface networkInterface) {
        super(networkInterface);
        this.updateAttributes();
    }

    public static List<NetworkIF> getNetworks(boolean bl2) {
        ArrayList<NetworkIF> arrayList = new ArrayList<NetworkIF>();
        for (NetworkInterface networkInterface : SolarisNetworkIF.getNetworkInterfaces(bl2)) {
            try {
                arrayList.add(new SolarisNetworkIF(networkInterface));
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
        try (KstatUtil.KstatChain kstatChain = KstatUtil.openChain();){
            LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup("link", -1, this.getName());
            if (kstat == null) {
                kstat = KstatUtil.KstatChain.lookup(null, -1, this.getName());
            }
            if (kstat != null && KstatUtil.KstatChain.read(kstat)) {
                this.bytesSent = KstatUtil.dataLookupLong(kstat, "obytes64");
                this.bytesRecv = KstatUtil.dataLookupLong(kstat, "rbytes64");
                this.packetsSent = KstatUtil.dataLookupLong(kstat, "opackets64");
                this.packetsRecv = KstatUtil.dataLookupLong(kstat, "ipackets64");
                this.outErrors = KstatUtil.dataLookupLong(kstat, "oerrors");
                this.inErrors = KstatUtil.dataLookupLong(kstat, "ierrors");
                this.collisions = KstatUtil.dataLookupLong(kstat, "collisions");
                this.inDrops = KstatUtil.dataLookupLong(kstat, "dl_idrops");
                this.speed = KstatUtil.dataLookupLong(kstat, "ifspeed");
                this.timeStamp = kstat.ks_snaptime / 1000000L;
                boolean bl2 = true;
                return bl2;
            }
        }
        return false;
    }
}

