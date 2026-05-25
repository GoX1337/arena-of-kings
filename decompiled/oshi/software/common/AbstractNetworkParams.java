/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.common;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.NetworkParams;
import oshi.util.FileUtil;
import oshi.util.ParseUtil;

@ThreadSafe
public abstract class AbstractNetworkParams
implements NetworkParams {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractNetworkParams.class);
    private static final String NAMESERVER = "nameserver";

    @Override
    public String getDomainName() {
        try {
            return InetAddress.getLocalHost().getCanonicalHostName();
        }
        catch (UnknownHostException unknownHostException) {
            LOG.error("Unknown host exception when getting address of local host: {}", (Object)unknownHostException.getMessage());
            return "";
        }
    }

    @Override
    public String getHostName() {
        try {
            String string = InetAddress.getLocalHost().getHostName();
            int n2 = string.indexOf(46);
            if (n2 == -1) {
                return string;
            }
            return string.substring(0, n2);
        }
        catch (UnknownHostException unknownHostException) {
            LOG.error("Unknown host exception when getting address of local host: {}", (Object)unknownHostException.getMessage());
            return "";
        }
    }

    @Override
    public String[] getDnsServers() {
        List<String> list = FileUtil.readFile("/etc/resolv.conf");
        String string = NAMESERVER;
        int n2 = 3;
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i2 = 0; i2 < list.size() && arrayList.size() < n2; ++i2) {
            String string2;
            String string3 = list.get(i2);
            if (!string3.startsWith(string) || (string2 = string3.substring(string.length()).replaceFirst("^[ \t]+", "")).length() == 0 || string2.charAt(0) == '#' || string2.charAt(0) == ';') continue;
            String string4 = string2.split("[ \t#;]", 2)[0];
            arrayList.add(string4);
        }
        return arrayList.toArray(new String[0]);
    }

    protected static String searchGateway(List<String> list) {
        for (String string : list) {
            String string2 = string.replaceFirst("^\\s+", "");
            if (!string2.startsWith("gateway:")) continue;
            String[] stringArray = ParseUtil.whitespaces.split(string2);
            if (stringArray.length < 2) {
                return "";
            }
            return stringArray[1].split("%")[0];
        }
        return "";
    }

    public String toString() {
        return String.format("Host name: %s, Domain name: %s, DNS servers: %s, IPv4 Gateway: %s, IPv6 Gateway: %s", this.getHostName(), this.getDomainName(), Arrays.toString(this.getDnsServers()), this.getIpv4DefaultGateway(), this.getIpv6DefaultGateway());
    }
}

