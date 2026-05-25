/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.windows;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.IPHlpAPI;
import com.sun.jna.platform.win32.VersionHelpers;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.NetworkIF;
import oshi.hardware.common.AbstractNetworkIF;
import oshi.util.ParseUtil;

@ThreadSafe
public final class WindowsNetworkIF
extends AbstractNetworkIF {
    private static final Logger LOG = LoggerFactory.getLogger(WindowsNetworkIF.class);
    private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
    private static final byte CONNECTOR_PRESENT_BIT = 4;
    private int ifType;
    private int ndisPhysicalMediumType;
    private boolean connectorPresent;
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
    private String ifAlias;
    private NetworkIF.IfOperStatus ifOperStatus;

    public WindowsNetworkIF(NetworkInterface networkInterface) {
        super(networkInterface);
        this.updateAttributes();
    }

    public static List<NetworkIF> getNetworks(boolean bl2) {
        ArrayList<NetworkIF> arrayList = new ArrayList<NetworkIF>();
        for (NetworkInterface networkInterface : WindowsNetworkIF.getNetworkInterfaces(bl2)) {
            try {
                arrayList.add(new WindowsNetworkIF(networkInterface));
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
    public int getNdisPhysicalMediumType() {
        return this.ndisPhysicalMediumType;
    }

    @Override
    public boolean isConnectorPresent() {
        return this.connectorPresent;
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
    public String getIfAlias() {
        return this.ifAlias;
    }

    @Override
    public NetworkIF.IfOperStatus getIfOperStatus() {
        return this.ifOperStatus;
    }

    @Override
    public boolean updateAttributes() {
        if (IS_VISTA_OR_GREATER) {
            IPHlpAPI.MIB_IF_ROW2 mIB_IF_ROW2 = new IPHlpAPI.MIB_IF_ROW2();
            mIB_IF_ROW2.InterfaceIndex = this.queryNetworkInterface().getIndex();
            if (0 != IPHlpAPI.INSTANCE.GetIfEntry2(mIB_IF_ROW2)) {
                LOG.error("Failed to retrieve data for interface {}, {}", (Object)this.queryNetworkInterface().getIndex(), (Object)this.getName());
                return false;
            }
            this.ifType = mIB_IF_ROW2.Type;
            this.ndisPhysicalMediumType = mIB_IF_ROW2.PhysicalMediumType;
            this.connectorPresent = (mIB_IF_ROW2.InterfaceAndOperStatusFlags & 4) > 0;
            this.bytesSent = mIB_IF_ROW2.OutOctets;
            this.bytesRecv = mIB_IF_ROW2.InOctets;
            this.packetsSent = mIB_IF_ROW2.OutUcastPkts;
            this.packetsRecv = mIB_IF_ROW2.InUcastPkts;
            this.outErrors = mIB_IF_ROW2.OutErrors;
            this.inErrors = mIB_IF_ROW2.InErrors;
            this.collisions = mIB_IF_ROW2.OutDiscards;
            this.inDrops = mIB_IF_ROW2.InDiscards;
            this.speed = mIB_IF_ROW2.ReceiveLinkSpeed;
            this.ifAlias = Native.toString(mIB_IF_ROW2.Alias);
            this.ifOperStatus = NetworkIF.IfOperStatus.byValue(mIB_IF_ROW2.OperStatus);
        } else {
            IPHlpAPI.MIB_IFROW mIB_IFROW = new IPHlpAPI.MIB_IFROW();
            mIB_IFROW.dwIndex = this.queryNetworkInterface().getIndex();
            if (0 != IPHlpAPI.INSTANCE.GetIfEntry(mIB_IFROW)) {
                LOG.error("Failed to retrieve data for interface {}, {}", (Object)this.queryNetworkInterface().getIndex(), (Object)this.getName());
                return false;
            }
            this.ifType = mIB_IFROW.dwType;
            this.bytesSent = ParseUtil.unsignedIntToLong(mIB_IFROW.dwOutOctets);
            this.bytesRecv = ParseUtil.unsignedIntToLong(mIB_IFROW.dwInOctets);
            this.packetsSent = ParseUtil.unsignedIntToLong(mIB_IFROW.dwOutUcastPkts);
            this.packetsRecv = ParseUtil.unsignedIntToLong(mIB_IFROW.dwInUcastPkts);
            this.outErrors = ParseUtil.unsignedIntToLong(mIB_IFROW.dwOutErrors);
            this.inErrors = ParseUtil.unsignedIntToLong(mIB_IFROW.dwInErrors);
            this.collisions = ParseUtil.unsignedIntToLong(mIB_IFROW.dwOutDiscards);
            this.inDrops = ParseUtil.unsignedIntToLong(mIB_IFROW.dwInDiscards);
            this.speed = ParseUtil.unsignedIntToLong(mIB_IFROW.dwSpeed);
            this.ifAlias = "";
            this.ifOperStatus = NetworkIF.IfOperStatus.UNKNOWN;
        }
        this.timeStamp = System.currentTimeMillis();
        return true;
    }
}

