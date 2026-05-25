/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.platform.linux;

import com.sun.jna.platform.linux.Udev;
import java.io.File;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.NetworkIF;
import oshi.hardware.common.AbstractNetworkIF;
import oshi.util.FileUtil;
import oshi.util.Util;

@ThreadSafe
public final class LinuxNetworkIF
extends AbstractNetworkIF {
    private static final Logger LOG = LoggerFactory.getLogger(LinuxNetworkIF.class);
    private int ifType;
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

    public LinuxNetworkIF(NetworkInterface networkInterface) {
        super(networkInterface, LinuxNetworkIF.queryIfModel(networkInterface));
        this.updateAttributes();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static String queryIfModel(NetworkInterface networkInterface) {
        String string;
        block12: {
            string = networkInterface.getName();
            Udev.UdevContext udevContext = Udev.INSTANCE.udev_new();
            if (udevContext != null) {
                try {
                    Udev.UdevDevice udevDevice = udevContext.deviceNewFromSyspath("/sys/class/net/" + string);
                    if (udevDevice == null) break block12;
                    try {
                        String string2 = udevDevice.getPropertyValue("ID_VENDOR_FROM_DATABASE");
                        String string3 = udevDevice.getPropertyValue("ID_MODEL_FROM_DATABASE");
                        if (!Util.isBlank(string3)) {
                            if (!Util.isBlank(string2)) {
                                String string4 = string2 + " " + string3;
                                return string4;
                            }
                            String string5 = string3;
                            return string5;
                        }
                    }
                    finally {
                        udevDevice.unref();
                    }
                }
                finally {
                    udevContext.unref();
                }
            }
        }
        return string;
    }

    public static List<NetworkIF> getNetworks(boolean bl2) {
        ArrayList<NetworkIF> arrayList = new ArrayList<NetworkIF>();
        for (NetworkInterface networkInterface : LinuxNetworkIF.getNetworkInterfaces(bl2)) {
            try {
                arrayList.add(new LinuxNetworkIF(networkInterface));
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
        Object object;
        try {
            object = new File(String.format("/sys/class/net/%s/statistics", this.getName()));
            if (!((File)object).isDirectory()) {
                return false;
            }
        }
        catch (SecurityException securityException) {
            return false;
        }
        object = String.format("/sys/class/net/%s/type", this.getName());
        String string = String.format("/sys/class/net/%s/carrier", this.getName());
        String string2 = String.format("/sys/class/net/%s/statistics/tx_bytes", this.getName());
        String string3 = String.format("/sys/class/net/%s/statistics/rx_bytes", this.getName());
        String string4 = String.format("/sys/class/net/%s/statistics/tx_packets", this.getName());
        String string5 = String.format("/sys/class/net/%s/statistics/rx_packets", this.getName());
        String string6 = String.format("/sys/class/net/%s/statistics/tx_errors", this.getName());
        String string7 = String.format("/sys/class/net/%s/statistics/rx_errors", this.getName());
        String string8 = String.format("/sys/class/net/%s/statistics/collisions", this.getName());
        String string9 = String.format("/sys/class/net/%s/statistics/rx_dropped", this.getName());
        String string10 = String.format("/sys/class/net/%s/speed", this.getName());
        String string11 = String.format("/sys/class/net/%s/ifalias", this.getName());
        String string12 = String.format("/sys/class/net/%s/operstate", this.getName());
        this.timeStamp = System.currentTimeMillis();
        this.ifType = FileUtil.getIntFromFile((String)object);
        this.connectorPresent = FileUtil.getIntFromFile(string) > 0;
        this.bytesSent = FileUtil.getUnsignedLongFromFile(string2);
        this.bytesRecv = FileUtil.getUnsignedLongFromFile(string3);
        this.packetsSent = FileUtil.getUnsignedLongFromFile(string4);
        this.packetsRecv = FileUtil.getUnsignedLongFromFile(string5);
        this.outErrors = FileUtil.getUnsignedLongFromFile(string6);
        this.inErrors = FileUtil.getUnsignedLongFromFile(string7);
        this.collisions = FileUtil.getUnsignedLongFromFile(string8);
        this.inDrops = FileUtil.getUnsignedLongFromFile(string9);
        long l2 = FileUtil.getUnsignedLongFromFile(string10);
        this.speed = l2 < 0L ? 0L : l2 << 20;
        this.ifAlias = FileUtil.getStringFromFile(string11);
        this.ifOperStatus = LinuxNetworkIF.parseIfOperStatus(FileUtil.getStringFromFile(string12));
        return true;
    }

    private static NetworkIF.IfOperStatus parseIfOperStatus(String string) {
        switch (string) {
            case "up": {
                return NetworkIF.IfOperStatus.UP;
            }
            case "down": {
                return NetworkIF.IfOperStatus.DOWN;
            }
            case "testing": {
                return NetworkIF.IfOperStatus.TESTING;
            }
            case "dormant": {
                return NetworkIF.IfOperStatus.DORMANT;
            }
            case "notpresent": {
                return NetworkIF.IfOperStatus.NOT_PRESENT;
            }
            case "lowerlayerdown": {
                return NetworkIF.IfOperStatus.LOWER_LAYER_DOWN;
            }
        }
        return NetworkIF.IfOperStatus.UNKNOWN;
    }
}

