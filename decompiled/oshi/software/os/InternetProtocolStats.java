/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import oshi.annotation.concurrent.Immutable;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface InternetProtocolStats {
    public TcpStats getTCPv4Stats();

    public TcpStats getTCPv6Stats();

    public UdpStats getUDPv4Stats();

    public UdpStats getUDPv6Stats();

    public List<IPConnection> getConnections();

    @Immutable
    public static final class IPConnection {
        private final String type;
        private final byte[] localAddress;
        private final int localPort;
        private final byte[] foreignAddress;
        private final int foreignPort;
        private final TcpState state;
        private final int transmitQueue;
        private final int receiveQueue;
        private int owningProcessId;

        public IPConnection(String string, byte[] byArray, int n2, byte[] byArray2, int n3, TcpState tcpState, int n4, int n5, int n6) {
            this.type = string;
            this.localAddress = Arrays.copyOf(byArray, byArray.length);
            this.localPort = n2;
            this.foreignAddress = Arrays.copyOf(byArray2, byArray2.length);
            this.foreignPort = n3;
            this.state = tcpState;
            this.transmitQueue = n4;
            this.receiveQueue = n5;
            this.owningProcessId = n6;
        }

        public String getType() {
            return this.type;
        }

        public byte[] getLocalAddress() {
            return Arrays.copyOf(this.localAddress, this.localAddress.length);
        }

        public int getLocalPort() {
            return this.localPort;
        }

        public byte[] getForeignAddress() {
            return Arrays.copyOf(this.foreignAddress, this.foreignAddress.length);
        }

        public int getForeignPort() {
            return this.foreignPort;
        }

        public TcpState getState() {
            return this.state;
        }

        public int getTransmitQueue() {
            return this.transmitQueue;
        }

        public int getReceiveQueue() {
            return this.receiveQueue;
        }

        public int getowningProcessId() {
            return this.owningProcessId;
        }

        public String toString() {
            String string = "*";
            try {
                string = InetAddress.getByAddress(this.localAddress).toString();
            }
            catch (UnknownHostException unknownHostException) {
                // empty catch block
            }
            String string2 = "*";
            try {
                string2 = InetAddress.getByAddress(this.foreignAddress).toString();
            }
            catch (UnknownHostException unknownHostException) {
                // empty catch block
            }
            return "IPConnection [type=" + this.type + ", localAddress=" + string + ", localPort=" + this.localPort + ", foreignAddress=" + string2 + ", foreignPort=" + this.foreignPort + ", state=" + (Object)((Object)this.state) + ", transmitQueue=" + this.transmitQueue + ", receiveQueue=" + this.receiveQueue + ", owningProcessId=" + this.owningProcessId + "]";
        }
    }

    public static enum TcpState {
        UNKNOWN,
        CLOSED,
        LISTEN,
        SYN_SENT,
        SYN_RECV,
        ESTABLISHED,
        FIN_WAIT_1,
        FIN_WAIT_2,
        CLOSE_WAIT,
        CLOSING,
        LAST_ACK,
        TIME_WAIT,
        NONE;

    }

    @Immutable
    public static final class UdpStats {
        private final long datagramsSent;
        private final long datagramsReceived;
        private final long datagramsNoPort;
        private final long datagramsReceivedErrors;

        public UdpStats(long l2, long l3, long l4, long l5) {
            this.datagramsSent = l2;
            this.datagramsReceived = l3;
            this.datagramsNoPort = l4;
            this.datagramsReceivedErrors = l5;
        }

        public long getDatagramsSent() {
            return this.datagramsSent;
        }

        public long getDatagramsReceived() {
            return this.datagramsReceived;
        }

        public long getDatagramsNoPort() {
            return this.datagramsNoPort;
        }

        public long getDatagramsReceivedErrors() {
            return this.datagramsReceivedErrors;
        }

        public String toString() {
            return "UdpStats [datagramsSent=" + this.datagramsSent + ", datagramsReceived=" + this.datagramsReceived + ", datagramsNoPort=" + this.datagramsNoPort + ", datagramsReceivedErrors=" + this.datagramsReceivedErrors + "]";
        }
    }

    @Immutable
    public static final class TcpStats {
        private final long connectionsEstablished;
        private final long connectionsActive;
        private final long connectionsPassive;
        private final long connectionFailures;
        private final long connectionsReset;
        private final long segmentsSent;
        private final long segmentsReceived;
        private final long segmentsRetransmitted;
        private final long inErrors;
        private final long outResets;

        public TcpStats(long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11) {
            this.connectionsEstablished = l2;
            this.connectionsActive = l3;
            this.connectionsPassive = l4;
            this.connectionFailures = l5;
            this.connectionsReset = l6;
            this.segmentsSent = l7;
            this.segmentsReceived = l8;
            this.segmentsRetransmitted = l9;
            this.inErrors = l10;
            this.outResets = l11;
        }

        public long getConnectionsEstablished() {
            return this.connectionsEstablished;
        }

        public long getConnectionsActive() {
            return this.connectionsActive;
        }

        public long getConnectionsPassive() {
            return this.connectionsPassive;
        }

        public long getConnectionFailures() {
            return this.connectionFailures;
        }

        public long getConnectionsReset() {
            return this.connectionsReset;
        }

        public long getSegmentsSent() {
            return this.segmentsSent;
        }

        public long getSegmentsReceived() {
            return this.segmentsReceived;
        }

        public long getSegmentsRetransmitted() {
            return this.segmentsRetransmitted;
        }

        public long getInErrors() {
            return this.inErrors;
        }

        public long getOutResets() {
            return this.outResets;
        }

        public String toString() {
            return "TcpStats [connectionsEstablished=" + this.connectionsEstablished + ", connectionsActive=" + this.connectionsActive + ", connectionsPassive=" + this.connectionsPassive + ", connectionFailures=" + this.connectionFailures + ", connectionsReset=" + this.connectionsReset + ", segmentsSent=" + this.segmentsSent + ", segmentsReceived=" + this.segmentsReceived + ", segmentsRetransmitted=" + this.segmentsRetransmitted + ", inErrors=" + this.inErrors + ", outResets=" + this.outResets + "]";
        }
    }
}

