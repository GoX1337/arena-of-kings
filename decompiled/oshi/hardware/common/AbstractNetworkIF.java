/*
 * Decompiled with CFR 0.152.
 */
package oshi.hardware.common;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.hardware.NetworkIF;
import oshi.util.FileUtil;
import oshi.util.FormatUtil;
import oshi.util.Memoizer;
import oshi.util.ParseUtil;

@ThreadSafe
public abstract class AbstractNetworkIF
implements NetworkIF {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractNetworkIF.class);
    private static final String OSHI_VM_MAC_ADDR_PROPERTIES = "oshi.vmmacaddr.properties";
    private NetworkInterface networkInterface;
    private String name;
    private String displayName;
    private int index;
    private long mtu;
    private String mac;
    private String[] ipv4;
    private Short[] subnetMasks;
    private String[] ipv6;
    private Short[] prefixLengths;
    private final Supplier<Properties> vmMacAddrProps = Memoizer.memoize(AbstractNetworkIF::queryVmMacAddrProps);

    public AbstractNetworkIF(NetworkInterface networkInterface) {
        this(networkInterface, networkInterface.getDisplayName());
    }

    public AbstractNetworkIF(NetworkInterface networkInterface, String string) {
        this.networkInterface = networkInterface;
        try {
            ArrayList<String> arrayList;
            this.name = this.networkInterface.getName();
            this.displayName = string;
            this.index = this.networkInterface.getIndex();
            this.mtu = ParseUtil.unsignedIntToLong(this.networkInterface.getMTU());
            byte[] byArray = this.networkInterface.getHardwareAddress();
            if (byArray != null) {
                arrayList = new ArrayList<String>(6);
                for (byte by2 : byArray) {
                    arrayList.add(String.format("%02x", by2));
                }
                this.mac = String.join((CharSequence)":", arrayList);
            } else {
                this.mac = "unknown";
            }
            arrayList = new ArrayList();
            Object object = new ArrayList();
            ArrayList<String> arrayList2 = new ArrayList<String>();
            ArrayList<Short> arrayList3 = new ArrayList<Short>();
            for (InterfaceAddress interfaceAddress : this.networkInterface.getInterfaceAddresses()) {
                InetAddress inetAddress = interfaceAddress.getAddress();
                if (inetAddress.getHostAddress().length() <= 0) continue;
                if (inetAddress.getHostAddress().contains(":")) {
                    arrayList2.add(inetAddress.getHostAddress().split("%")[0]);
                    arrayList3.add(interfaceAddress.getNetworkPrefixLength());
                    continue;
                }
                arrayList.add(inetAddress.getHostAddress());
                ((ArrayList)object).add(interfaceAddress.getNetworkPrefixLength());
            }
            this.ipv4 = arrayList.toArray(new String[0]);
            this.subnetMasks = ((ArrayList)object).toArray(new Short[0]);
            this.ipv6 = arrayList2.toArray(new String[0]);
            this.prefixLengths = arrayList3.toArray(new Short[0]);
        }
        catch (SocketException socketException) {
            throw new InstantiationException(socketException.getMessage());
        }
    }

    public static List<NetworkInterface> getNetworkInterfaces(boolean bl2) {
        List<NetworkInterface> list = AbstractNetworkIF.getAllNetworkInterfaces();
        return bl2 ? list : AbstractNetworkIF.getAllNetworkInterfaces().stream().filter(networkInterface -> !AbstractNetworkIF.isLocalInterface(networkInterface)).collect(Collectors.toList());
    }

    private static List<NetworkInterface> getAllNetworkInterfaces() {
        try {
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            return enumeration == null ? Collections.emptyList() : Collections.list(enumeration);
        }
        catch (SocketException socketException) {
            LOG.error("Socket exception when retrieving interfaces: {}", (Object)socketException.getMessage());
            return Collections.emptyList();
        }
    }

    private static boolean isLocalInterface(NetworkInterface networkInterface) {
        try {
            return networkInterface.getHardwareAddress() == null;
        }
        catch (SocketException socketException) {
            LOG.error("Socket exception when retrieving interface information for {}: {}", (Object)networkInterface, (Object)socketException.getMessage());
            return false;
        }
    }

    @Override
    public NetworkInterface queryNetworkInterface() {
        return this.networkInterface;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public long getMTU() {
        return this.mtu;
    }

    @Override
    public String getMacaddr() {
        return this.mac;
    }

    @Override
    public String[] getIPv4addr() {
        return Arrays.copyOf(this.ipv4, this.ipv4.length);
    }

    @Override
    public Short[] getSubnetMasks() {
        return Arrays.copyOf(this.subnetMasks, this.subnetMasks.length);
    }

    @Override
    public String[] getIPv6addr() {
        return Arrays.copyOf(this.ipv6, this.ipv6.length);
    }

    @Override
    public Short[] getPrefixLengths() {
        return Arrays.copyOf(this.prefixLengths, this.prefixLengths.length);
    }

    @Override
    public boolean isKnownVmMacAddr() {
        String string = this.getMacaddr().length() > 7 ? this.getMacaddr().substring(0, 8) : this.getMacaddr();
        return this.vmMacAddrProps.get().containsKey(string.toUpperCase());
    }

    private static Properties queryVmMacAddrProps() {
        return FileUtil.readPropertiesFromFilename(OSHI_VM_MAC_ADDR_PROPERTIES);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ").append(this.getName());
        if (!this.getName().equals(this.getDisplayName())) {
            stringBuilder.append(" (").append(this.getDisplayName()).append(")");
        }
        if (!this.getIfAlias().isEmpty()) {
            stringBuilder.append(" [IfAlias=").append(this.getIfAlias()).append("]");
        }
        stringBuilder.append("\n");
        stringBuilder.append("  MAC Address: ").append(this.getMacaddr()).append("\n");
        stringBuilder.append("  MTU: ").append(this.getMTU()).append(", ").append("Speed: ").append(this.getSpeed()).append("\n");
        Object[] objectArray = this.getIPv4addr();
        if (this.ipv4.length == this.subnetMasks.length) {
            for (int i2 = 0; i2 < this.subnetMasks.length; ++i2) {
                int n2 = i2;
                objectArray[n2] = (String)objectArray[n2] + "/" + this.subnetMasks[i2];
            }
        }
        stringBuilder.append("  IPv4: ").append(Arrays.toString(objectArray)).append("\n");
        Object[] objectArray2 = this.getIPv6addr();
        if (this.ipv6.length == this.prefixLengths.length) {
            for (int i3 = 0; i3 < this.prefixLengths.length; ++i3) {
                int n3 = i3;
                objectArray2[n3] = (String)objectArray2[n3] + "/" + this.prefixLengths[i3];
            }
        }
        stringBuilder.append("  IPv6: ").append(Arrays.toString(objectArray2)).append("\n");
        stringBuilder.append("  Traffic: received ").append(this.getPacketsRecv()).append(" packets/").append(FormatUtil.formatBytes(this.getBytesRecv())).append(" (" + this.getInErrors() + " err, ").append(this.getInDrops() + " drop);");
        stringBuilder.append(" transmitted ").append(this.getPacketsSent()).append(" packets/").append(FormatUtil.formatBytes(this.getBytesSent())).append(" (" + this.getOutErrors() + " err, ").append(this.getCollisions() + " coll);");
        return stringBuilder.toString();
    }
}

