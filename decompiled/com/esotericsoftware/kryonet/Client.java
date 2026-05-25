/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.ClientDiscoveryHandler;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.FrameworkMessage;
import com.esotericsoftware.kryonet.KryoNetException;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.UdpConnection;
import com.esotericsoftware.kryonet.serialization.KryoSerialization;
import com.esotericsoftware.kryonet.serialization.Serialization;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Client
extends Connection
implements EndPoint {
    public static final int DEFAULT_WRITE_BUFFER_SIZE = 8192;
    public static final int DEFAULT_OBJECT_BUUFER_SIZE = 2048;
    private final Serialization serialization;
    private Selector selector;
    private int emptySelects;
    private volatile boolean tcpRegistered;
    private volatile boolean udpRegistered;
    private final Object tcpRegistrationLock = new Object();
    private final Object udpRegistrationLock = new Object();
    private volatile boolean shutdown;
    private final Object updateLock = new Object();
    private Thread updateThread;
    private int connectTimeout;
    private InetAddress connectHost;
    private int connectTcpPort;
    private int connectUdpPort;
    private boolean isClosed;
    private ClientDiscoveryHandler discoveryHandler;

    public Client() {
        this(8192, 2048);
    }

    public Client(int n2, int n3) {
        this(n2, n3, new KryoSerialization());
    }

    public Client(int n2, int n3, Serialization serialization) {
        this.endPoint = this;
        this.serialization = serialization;
        this.discoveryHandler = new ClientDiscoveryHandler(){};
        this.initialize(serialization, n2, n3);
        try {
            this.selector = Selector.open();
        }
        catch (IOException iOException) {
            throw new RuntimeException("Error opening selector.", iOException);
        }
    }

    public void setDiscoveryHandler(ClientDiscoveryHandler clientDiscoveryHandler) {
        this.discoveryHandler = clientDiscoveryHandler;
    }

    @Override
    public Kryo getKryo() {
        return this.serialization instanceof KryoSerialization ? ((KryoSerialization)this.serialization).getKryo() : null;
    }

    public void connect(String string, int n2) {
        this.connect(500, InetAddress.getByName(string), n2);
    }

    public void connect(int n2, String string, int n3) {
        this.connect(n2, InetAddress.getByName(string), n3, -1);
    }

    public void connect(int n2, String string, int n3, int n4) {
        this.connect(n2, InetAddress.getByName(string), n3, n4);
    }

    public void connect(int n2, InetAddress inetAddress, int n3) {
        this.connect(n2, inetAddress, n3, -1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void connect(int n2, InetAddress inetAddress, int n3, int n4) {
        if (inetAddress == null) {
            throw new NullPointerException("host cannot be null.");
        }
        if (Thread.currentThread() == this.getUpdateThread()) {
            throw new IllegalStateException("Cannot connect on the connection's update thread.");
        }
        this.connectTimeout = n2;
        this.connectHost = inetAddress;
        this.connectTcpPort = n3;
        this.connectUdpPort = n4;
        this.close();
        if (Log.INFO) {
            if (n4 != -1) {
                Log.info("kryonet", "Connecting: " + inetAddress + ":" + n3 + "/" + n4);
            } else {
                Log.info("kryonet", "Connecting: " + inetAddress + ":" + n3);
            }
        }
        this.id = -1;
        try {
            long l2;
            if (n4 != -1) {
                this.udp = new UdpConnection(this.serialization, this.tcp.readBuffer.capacity());
            }
            Object object = this.updateLock;
            synchronized (object) {
                this.tcpRegistered = false;
                this.selector.wakeup();
                l2 = System.currentTimeMillis() + (long)n2;
                this.tcp.connect(this.selector, new InetSocketAddress(inetAddress, n3), n2);
            }
            object = this.tcpRegistrationLock;
            synchronized (object) {
                while (!this.tcpRegistered && System.currentTimeMillis() < l2) {
                    try {
                        this.tcpRegistrationLock.wait(100L);
                    }
                    catch (InterruptedException interruptedException) {}
                }
                if (!this.tcpRegistered) {
                    throw new SocketTimeoutException("Connected, but timed out during TCP registration.\nNote: Client#update(int) must be called in a separate thread during connect.");
                }
            }
            if (n4 == -1) return;
            object = new InetSocketAddress(inetAddress, n4);
            Object object2 = this.updateLock;
            synchronized (object2) {
                this.udpRegistered = false;
                this.selector.wakeup();
                this.udp.connect(this.selector, (InetSocketAddress)object);
            }
            object2 = this.udpRegistrationLock;
            synchronized (object2) {
                while (!this.udpRegistered && System.currentTimeMillis() < l2) {
                    FrameworkMessage.RegisterUDP registerUDP = new FrameworkMessage.RegisterUDP();
                    registerUDP.connectionID = this.id;
                    this.udp.send(this, registerUDP, (SocketAddress)object);
                    try {
                        this.udpRegistrationLock.wait(100L);
                    }
                    catch (InterruptedException interruptedException) {}
                }
                if (this.udpRegistered) return;
                throw new SocketTimeoutException("Connected, but timed out during UDP registration: " + inetAddress + ":" + n4);
            }
        }
        catch (IOException iOException) {
            this.close();
            throw iOException;
        }
    }

    public void reconnect() {
        this.reconnect(this.connectTimeout);
    }

    public void reconnect(int n2) {
        if (this.connectHost == null) {
            throw new IllegalStateException("This client has never been connected.");
        }
        this.connect(n2, this.connectHost, this.connectTcpPort, this.connectUdpPort);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void update(int n2) {
        long l2;
        this.updateThread = Thread.currentThread();
        Object object = this.updateLock;
        synchronized (object) {
        }
        long l3 = System.currentTimeMillis();
        int n3 = 0;
        n3 = n2 > 0 ? this.selector.select(n2) : this.selector.selectNow();
        if (n3 == 0) {
            ++this.emptySelects;
            if (this.emptySelects == 100) {
                this.emptySelects = 0;
                l2 = System.currentTimeMillis() - l3;
                try {
                    if (l2 < 25L) {
                        Thread.sleep(25L - l2);
                    }
                }
                catch (InterruptedException interruptedException) {}
            }
        } else {
            Set<SelectionKey> set;
            this.emptySelects = 0;
            this.isClosed = false;
            Set<SelectionKey> set2 = set = this.selector.selectedKeys();
            synchronized (set2) {
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext()) {
                    this.keepAlive();
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    try {
                        int n4 = selectionKey.readyOps();
                        if ((n4 & 1) == 1) {
                            Object object2;
                            Object object3;
                            if (selectionKey.attachment() == this.tcp) {
                                while ((object3 = this.tcp.readObject(this)) != null) {
                                    if (!this.tcpRegistered) {
                                        if (!(object3 instanceof FrameworkMessage.RegisterTCP)) continue;
                                        this.id = ((FrameworkMessage.RegisterTCP)object3).connectionID;
                                        object2 = this.tcpRegistrationLock;
                                        synchronized (object2) {
                                            this.tcpRegistered = true;
                                            this.tcpRegistrationLock.notifyAll();
                                            if (Log.TRACE) {
                                                Log.trace("kryonet", this + " received TCP: RegisterTCP");
                                            }
                                            if (this.udp == null) {
                                                this.setConnected(true);
                                            }
                                        }
                                        if (this.udp != null) continue;
                                        this.notifyConnected();
                                        continue;
                                    }
                                    if (this.udp != null && !this.udpRegistered) {
                                        if (!(object3 instanceof FrameworkMessage.RegisterUDP)) continue;
                                        object2 = this.udpRegistrationLock;
                                        synchronized (object2) {
                                            this.udpRegistered = true;
                                            this.udpRegistrationLock.notifyAll();
                                            if (Log.TRACE) {
                                                Log.trace("kryonet", this + " received UDP: RegisterUDP");
                                            }
                                            if (Log.DEBUG) {
                                                Log.debug("kryonet", "Port " + this.udp.datagramChannel.socket().getLocalPort() + "/UDP connected to: " + this.udp.connectedAddress);
                                            }
                                            this.setConnected(true);
                                        }
                                        this.notifyConnected();
                                        continue;
                                    }
                                    if (!this.isConnected) continue;
                                    if (Log.DEBUG) {
                                        Object object4 = object2 = object3 == null ? "null" : object3.getClass().getSimpleName();
                                        if (!(object3 instanceof FrameworkMessage)) {
                                            Log.debug("kryonet", this + " received TCP: " + (String)object2);
                                        } else if (Log.TRACE) {
                                            Log.trace("kryonet", this + " received TCP: " + (String)object2);
                                        }
                                    }
                                    this.notifyReceived(object3);
                                }
                            } else {
                                if (this.udp.readFromAddress() == null || (object3 = this.udp.readObject(this)) == null) continue;
                                if (Log.DEBUG) {
                                    object2 = object3 == null ? "null" : object3.getClass().getSimpleName();
                                    Log.debug("kryonet", this + " received UDP: " + (String)object2);
                                }
                                this.notifyReceived(object3);
                            }
                        }
                        if ((n4 & 4) != 4) continue;
                        this.tcp.writeOperation();
                    }
                    catch (CancelledKeyException cancelledKeyException) {}
                }
            }
        }
        if (this.isConnected) {
            l2 = System.currentTimeMillis();
            if (this.tcp.isTimedOut(l2)) {
                if (Log.DEBUG) {
                    Log.debug("kryonet", this + " timed out.");
                }
                this.close();
            } else {
                this.keepAlive();
            }
            if (this.isIdle()) {
                this.notifyIdle();
            }
        }
    }

    void keepAlive() {
        if (!this.isConnected) {
            return;
        }
        long l2 = System.currentTimeMillis();
        if (this.tcp.needsKeepAlive(l2)) {
            this.sendTCP(FrameworkMessage.keepAlive);
        }
        if (this.udp != null && this.udpRegistered && this.udp.needsKeepAlive(l2)) {
            this.sendUDP(FrameworkMessage.keepAlive);
        }
    }

    @Override
    public void run() {
        if (Log.TRACE) {
            Log.trace("kryonet", "Client thread started.");
        }
        this.shutdown = false;
        while (!this.shutdown) {
            try {
                this.update(250);
            }
            catch (IOException iOException) {
                if (Log.TRACE) {
                    if (this.isConnected) {
                        Log.trace("kryonet", "Unable to update connection: " + this, iOException);
                    } else {
                        Log.trace("kryonet", "Unable to update connection.", iOException);
                    }
                } else if (Log.DEBUG) {
                    if (this.isConnected) {
                        Log.debug("kryonet", this + " update: " + iOException.getMessage());
                    } else {
                        Log.debug("kryonet", "Unable to update connection: " + iOException.getMessage());
                    }
                }
                this.close();
            }
            catch (KryoNetException kryoNetException) {
                this.lastProtocolError = kryoNetException;
                if (Log.ERROR) {
                    if (this.isConnected) {
                        Log.error("kryonet", "Error updating connection: " + this, kryoNetException);
                    } else {
                        Log.error("kryonet", "Error updating connection.", kryoNetException);
                    }
                }
                this.close();
                throw kryoNetException;
            }
        }
        if (Log.TRACE) {
            Log.trace("kryonet", "Client thread stopped.");
        }
    }

    @Override
    public void start() {
        if (this.updateThread != null) {
            this.shutdown = true;
            try {
                this.updateThread.join(5000L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
        this.updateThread = new Thread((Runnable)this, "Client");
        this.updateThread.setDaemon(true);
        this.updateThread.start();
    }

    @Override
    public void stop() {
        if (this.shutdown) {
            return;
        }
        this.close();
        if (Log.TRACE) {
            Log.trace("kryonet", "Client thread stopping.");
        }
        this.shutdown = true;
        this.selector.wakeup();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        super.close();
        Object object = this.updateLock;
        synchronized (object) {
            if (!this.isClosed) {
                this.isClosed = true;
                this.selector.wakeup();
                try {
                    this.selector.selectNow();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
    }

    public void dispose() {
        this.close();
        this.selector.close();
    }

    @Override
    public void addListener(Listener listener) {
        super.addListener(listener);
        if (Log.TRACE) {
            Log.trace("kryonet", "Client listener added.");
        }
    }

    @Override
    public void removeListener(Listener listener) {
        super.removeListener(listener);
        if (Log.TRACE) {
            Log.trace("kryonet", "Client listener removed.");
        }
    }

    public void setKeepAliveUDP(int n2) {
        if (this.udp == null) {
            throw new IllegalStateException("Not connected via UDP.");
        }
        this.udp.keepAliveMillis = n2;
    }

    @Override
    public Thread getUpdateThread() {
        return this.updateThread;
    }

    public Serialization getSerialization() {
        return this.serialization;
    }

    private void broadcast(int n2, DatagramSocket datagramSocket) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        this.serialization.write(null, byteBuffer, new FrameworkMessage.DiscoverHost());
        byteBuffer.flip();
        byte[] byArray = new byte[byteBuffer.limit()];
        byteBuffer.get(byArray);
        Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
        while (enumeration.hasMoreElements()) {
            NetworkInterface networkInterface = enumeration.nextElement();
            if (networkInterface.isLoopback() || !networkInterface.isUp()) continue;
            for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                InetAddress inetAddress = interfaceAddress.getBroadcast();
                if (inetAddress == null) continue;
                datagramSocket.send(new DatagramPacket(byArray, byArray.length, inetAddress, n2));
            }
        }
        if (Log.DEBUG) {
            Log.debug("kryonet", "Broadcasted host discovery on port: " + n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public InetAddress discoverHost(int n2, int n3) {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
            this.broadcast(n2, datagramSocket);
            datagramSocket.setSoTimeout(n3);
            DatagramPacket datagramPacket = this.discoveryHandler.onRequestNewDatagramPacket();
            try {
                datagramSocket.receive(datagramPacket);
            }
            catch (SocketTimeoutException socketTimeoutException) {
                if (Log.INFO) {
                    Log.info("kryonet", "Host discovery timed out.");
                }
                InetAddress inetAddress = null;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                this.discoveryHandler.onFinally();
                return inetAddress;
            }
            if (Log.INFO) {
                Log.info("kryonet", "Discovered server: " + datagramPacket.getAddress());
            }
            this.discoveryHandler.onDiscoveredHost(datagramPacket);
            InetAddress inetAddress = datagramPacket.getAddress();
            return inetAddress;
        }
        catch (IOException iOException) {
            if (Log.ERROR) {
                Log.error("kryonet", "Host discovery failed.", iOException);
            }
            InetAddress inetAddress = null;
            return inetAddress;
        }
        finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            this.discoveryHandler.onFinally();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<InetAddress> discoverHosts(int n2, int n3) {
        ArrayList<InetAddress> arrayList = new ArrayList<InetAddress>();
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
            this.broadcast(n2, datagramSocket);
            datagramSocket.setSoTimeout(n3);
            while (true) {
                DatagramPacket datagramPacket = this.discoveryHandler.onRequestNewDatagramPacket();
                try {
                    datagramSocket.receive(datagramPacket);
                }
                catch (SocketTimeoutException socketTimeoutException) {
                    if (Log.INFO) {
                        Log.info("kryonet", "Host discovery timed out.");
                    }
                    ArrayList<InetAddress> arrayList2 = arrayList;
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }
                    this.discoveryHandler.onFinally();
                    return arrayList2;
                }
                if (Log.INFO) {
                    Log.info("kryonet", "Discovered server: " + datagramPacket.getAddress());
                }
                this.discoveryHandler.onDiscoveredHost(datagramPacket);
                arrayList.add(datagramPacket.getAddress());
                continue;
                break;
            }
        }
        catch (IOException iOException) {
            if (Log.ERROR) {
                Log.error("kryonet", "Host discovery failed.", iOException);
            }
            ArrayList<InetAddress> arrayList3 = arrayList;
            return arrayList3;
        }
        finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            this.discoveryHandler.onFinally();
        }
    }

    static {
        try {
            System.setProperty("java.net.preferIPv6Addresses", "false");
        }
        catch (AccessControlException accessControlException) {
            // empty catch block
        }
    }
}

