/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.platform.unix.LibCAPI$size_t$ByReference
 */
package oshi.driver.mac.net;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.mac.SystemB;
import com.sun.jna.platform.unix.LibCAPI;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.Immutable;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class NetStat {
    private static final Logger LOG = LoggerFactory.getLogger(NetStat.class);
    private static final int CTL_NET = 4;
    private static final int PF_ROUTE = 17;
    private static final int NET_RT_IFLIST2 = 6;
    private static final int RTM_IFINFO2 = 18;

    private NetStat() {
    }

    public static Map<Integer, IFdata> queryIFdata(int n2) {
        SystemB.IFmsgHdr iFmsgHdr;
        HashMap<Integer, IFdata> hashMap = new HashMap<Integer, IFdata>();
        int[] nArray = new int[]{4, 17, 0, 0, 6, 0};
        LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference();
        if (0 != SystemB.INSTANCE.sysctl(nArray, 6, null, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.error("Didn't get buffer length for IFLIST2");
            return hashMap;
        }
        Memory memory = new Memory(byReference.longValue());
        if (0 != SystemB.INSTANCE.sysctl(nArray, 6, memory, byReference, null, LibCAPI.size_t.ZERO)) {
            LOG.error("Didn't get buffer for IFLIST2");
            return hashMap;
        }
        long l2 = System.currentTimeMillis();
        int n3 = (int)(memory.size() - (long)new SystemB.IFmsgHdr().size());
        for (int i2 = 0; i2 < n3; i2 += iFmsgHdr.ifm_msglen) {
            Pointer pointer = memory.share(i2);
            iFmsgHdr = new SystemB.IFmsgHdr(pointer);
            iFmsgHdr.read();
            if (iFmsgHdr.ifm_type != 18) continue;
            SystemB.IFmsgHdr2 iFmsgHdr2 = new SystemB.IFmsgHdr2(pointer);
            iFmsgHdr2.read();
            if (n2 >= 0 && n2 != iFmsgHdr2.ifm_index) continue;
            hashMap.put(Integer.valueOf(iFmsgHdr2.ifm_index), new IFdata(0xFF & iFmsgHdr2.ifm_data.ifi_type, iFmsgHdr2.ifm_data.ifi_opackets, iFmsgHdr2.ifm_data.ifi_ipackets, iFmsgHdr2.ifm_data.ifi_obytes, iFmsgHdr2.ifm_data.ifi_ibytes, iFmsgHdr2.ifm_data.ifi_oerrors, iFmsgHdr2.ifm_data.ifi_ierrors, iFmsgHdr2.ifm_data.ifi_collisions, iFmsgHdr2.ifm_data.ifi_iqdrops, iFmsgHdr2.ifm_data.ifi_baudrate, l2));
            if (n2 < 0) continue;
            return hashMap;
        }
        return hashMap;
    }

    @Immutable
    public static class IFdata {
        private final int ifType;
        private final long oPackets;
        private final long iPackets;
        private final long oBytes;
        private final long iBytes;
        private final long oErrors;
        private final long iErrors;
        private final long collisions;
        private final long iDrops;
        private final long speed;
        private final long timeStamp;

        IFdata(int n2, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11) {
            this.ifType = n2;
            this.oPackets = l2 & 0xFFFFFFFFL;
            this.iPackets = l3 & 0xFFFFFFFFL;
            this.oBytes = l4 & 0xFFFFFFFFL;
            this.iBytes = l5 & 0xFFFFFFFFL;
            this.oErrors = l6 & 0xFFFFFFFFL;
            this.iErrors = l7 & 0xFFFFFFFFL;
            this.collisions = l8 & 0xFFFFFFFFL;
            this.iDrops = l9 & 0xFFFFFFFFL;
            this.speed = l10 & 0xFFFFFFFFL;
            this.timeStamp = l11;
        }

        public int getIfType() {
            return this.ifType;
        }

        public long getOPackets() {
            return this.oPackets;
        }

        public long getIPackets() {
            return this.iPackets;
        }

        public long getOBytes() {
            return this.oBytes;
        }

        public long getIBytes() {
            return this.iBytes;
        }

        public long getOErrors() {
            return this.oErrors;
        }

        public long getIErrors() {
            return this.iErrors;
        }

        public long getCollisions() {
            return this.collisions;
        }

        public long getIDrops() {
            return this.iDrops;
        }

        public long getSpeed() {
            return this.speed;
        }

        public long getTimeStamp() {
            return this.timeStamp;
        }
    }
}

