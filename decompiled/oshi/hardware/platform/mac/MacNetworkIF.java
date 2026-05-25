/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.mac;

import com.sun.jna.Pointer;
import com.sun.jna.platform.mac.CoreFoundation;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.driver.mac.net.NetStat;
import oshi.hardware.NetworkIF;
import oshi.hardware.common.AbstractNetworkIF;
import oshi.jna.platform.mac.SystemConfiguration;

@ThreadSafe
public final class MacNetworkIF
extends AbstractNetworkIF {
    private static final Logger LOG = LoggerFactory.getLogger(MacNetworkIF.class);
    private int ifType;
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

    public MacNetworkIF(NetworkInterface networkInterface, Map<Integer, NetStat.IFdata> map) {
        super(networkInterface, MacNetworkIF.queryIfDisplayName(networkInterface));
        this.updateNetworkStats(map);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static String queryIfDisplayName(NetworkInterface networkInterface) {
        String string = networkInterface.getName();
        CoreFoundation.CFArrayRef cFArrayRef = SystemConfiguration.INSTANCE.SCNetworkInterfaceCopyAll();
        if (cFArrayRef != null) {
            try {
                int n2 = cFArrayRef.getCount();
                for (int i2 = 0; i2 < n2; ++i2) {
                    Pointer pointer = cFArrayRef.getValueAtIndex(i2);
                    SystemConfiguration.SCNetworkInterfaceRef sCNetworkInterfaceRef = new SystemConfiguration.SCNetworkInterfaceRef(pointer);
                    CoreFoundation.CFStringRef cFStringRef = SystemConfiguration.INSTANCE.SCNetworkInterfaceGetBSDName(sCNetworkInterfaceRef);
                    if (cFStringRef == null || !string.equals(cFStringRef.stringValue())) continue;
                    CoreFoundation.CFStringRef cFStringRef2 = SystemConfiguration.INSTANCE.SCNetworkInterfaceGetLocalizedDisplayName(sCNetworkInterfaceRef);
                    String string2 = cFStringRef2.stringValue();
                    return string2;
                }
            }
            finally {
                cFArrayRef.release();
            }
        }
        return string;
    }

    public static List<NetworkIF> getNetworks(boolean bl2) {
        Map<Integer, NetStat.IFdata> map = NetStat.queryIFdata(-1);
        ArrayList<NetworkIF> arrayList = new ArrayList<NetworkIF>();
        for (NetworkInterface networkInterface : MacNetworkIF.getNetworkInterfaces(bl2)) {
            try {
                arrayList.add(new MacNetworkIF(networkInterface, map));
            }
            catch (InstantiationException instantiationException) {
                LOG.debug("Network Interface Instantiation failed: {}", (Object)instantiationException.getMessage());
            }
        }
        return arrayList;
    }

    @Override
    public int getIfType() {
        return this.ifType;
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
        int n2 = this.queryNetworkInterface().getIndex();
        return this.updateNetworkStats(NetStat.queryIFdata(n2));
    }

    private boolean updateNetworkStats(Map<Integer, NetStat.IFdata> map) {
        int n2 = this.queryNetworkInterface().getIndex();
        if (map.containsKey(n2)) {
            NetStat.IFdata iFdata = map.get(n2);
            this.ifType = iFdata.getIfType();
            this.bytesSent = iFdata.getOBytes();
            this.bytesRecv = iFdata.getIBytes();
            this.packetsSent = iFdata.getOPackets();
            this.packetsRecv = iFdata.getIPackets();
            this.outErrors = iFdata.getOErrors();
            this.inErrors = iFdata.getIErrors();
            this.collisions = iFdata.getCollisions();
            this.inDrops = iFdata.getIDrops();
            this.speed = iFdata.getSpeed();
            this.timeStamp = iFdata.getTimeStamp();
            return true;
        }
        return false;
    }
}

