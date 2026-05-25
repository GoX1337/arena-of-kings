/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.util.IntMap;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.FrameworkMessage;
import com.esotericsoftware.kryonet.KryoNetException;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.ServerDiscoveryHandler;
import com.esotericsoftware.kryonet.UdpConnection;
import com.esotericsoftware.kryonet.serialization.KryoSerialization;
import com.esotericsoftware.kryonet.serialization.Serialization;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class Server
implements EndPoint {
    public static final int DEFAULT_WRITE_BUFFER_SIZE = 16384;
    public static final int DEFAULT_OBJECT_BUFFER_SIZE = 2048;
    private final Serialization serialization;
    private final int writeBufferSize;
    private final int objectBufferSize;
    private final Selector selector;
    private int emptySelects;
    private ServerSocketChannel serverChannel;
    private UdpConnection udp;
    private Connection[] connections = new Connection[0];
    private final IntMap<Connection> pendingConnections = new IntMap();
    Listener[] listeners = new Listener[0];
    private final Object listenerLock = new Object();
    private int nextConnectionID = 1;
    private volatile boolean shutdown;
    private final Object updateLock = new Object();
    private Thread updateThread;
    private ServerDiscoveryHandler discoveryHandler;
    private final Listener dispatchListener = new Listener(){

        @Override
        public void connected(Connection connection) {
            Listener[] listenerArray = Server.this.listeners;
            int n2 = listenerArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                listenerArray[i2].connected(connection);
            }
        }

        @Override
        public void disconnected(Connection connection) {
            Server.this.removeConnection(connection);
            Listener[] listenerArray = Server.this.listeners;
            int n2 = listenerArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                listenerArray[i2].disconnected(connection);
            }
        }

        @Override
        public void received(Connection connection, Object object) {
            Listener[] listenerArray = Server.this.listeners;
            int n2 = listenerArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                listenerArray[i2].received(connection, object);
            }
        }

        @Override
        public void idle(Connection connection) {
            Listener[] listenerArray = Server.this.listeners;
            int n2 = listenerArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                listenerArray[i2].idle(connection);
            }
        }
    };

    public Server() {
        this(16384, 2048);
    }

    public Server(int n2, int n3) {
        this(n2, n3, new KryoSerialization());
    }

    public Server(int n2, int n3, Serialization serialization) {
        this.writeBufferSize = n2;
        this.objectBufferSize = n3;
        this.serialization = serialization;
        this.discoveryHandler = new ServerDiscoveryHandler(){};
        try {
            this.selector = Selector.open();
        }
        catch (IOException iOException) {
            throw new RuntimeException("Error opening the selector.", iOException);
        }
    }

    public void setDiscoveryHandler(ServerDiscoveryHandler serverDiscoveryHandler) {
        this.discoveryHandler = serverDiscoveryHandler;
    }

    public Serialization getSerialization() {
        return this.serialization;
    }

    @Override
    public Kryo getKryo() {
        return this.serialization instanceof KryoSerialization ? ((KryoSerialization)this.serialization).getKryo() : null;
    }

    public void bind(int n2) {
        this.bind(new InetSocketAddress(n2), null);
    }

    public void bind(int n2, int n3) {
        this.bind(new InetSocketAddress(n2), new InetSocketAddress(n3));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void bind(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        this.close();
        Object object = this.updateLock;
        synchronized (object) {
            this.selector.wakeup();
            try {
                this.serverChannel = this.selector.provider().openServerSocketChannel();
                this.serverChannel.socket().bind(inetSocketAddress);
                this.serverChannel.configureBlocking(false);
                this.serverChannel.register(this.selector, 16);
                if (Log.DEBUG) {
                    Log.debug("kryonet", "Accepting connections on port: " + inetSocketAddress + "/TCP");
                }
                if (inetSocketAddress2 != null) {
                    this.udp = new UdpConnection(this.serialization, this.objectBufferSize);
                    this.udp.bind(this.selector, inetSocketAddress2);
                    if (Log.DEBUG) {
                        Log.debug("kryonet", "Accepting connections on port: " + inetSocketAddress2 + "/UDP");
                    }
                }
            }
            catch (IOException iOException) {
                this.close();
                throw iOException;
            }
        }
        if (Log.INFO) {
            Log.info("kryonet", "Server opened.");
        }
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
            Set<SelectionKey> set2 = set = this.selector.selectedKeys();
            synchronized (set2) {
                UdpConnection udpConnection = this.udp;
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext()) {
                    this.keepAlive();
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    Connection connection = (Connection)selectionKey.attachment();
                    try {
                        Object object2;
                        Connection connection2;
                        Object object3;
                        Object object4;
                        int n4 = selectionKey.readyOps();
                        if (connection != null) {
                            if (udpConnection != null && connection.udpRemoteAddress == null) {
                                connection.close();
                                continue;
                            }
                            if ((n4 & 1) == 1) {
                                try {
                                    while ((object4 = connection.tcp.readObject(connection)) != null) {
                                        if (Log.DEBUG) {
                                            Object object5 = object3 = object4 == null ? "null" : object4.getClass().getSimpleName();
                                            if (!(object4 instanceof FrameworkMessage)) {
                                                Log.debug("kryonet", connection + " received TCP: " + (String)object3);
                                            } else if (Log.TRACE) {
                                                Log.trace("kryonet", connection + " received TCP: " + (String)object3);
                                            }
                                        }
                                        connection.notifyReceived(object4);
                                    }
                                }
                                catch (IOException iOException) {
                                    if (Log.TRACE) {
                                        Log.trace("kryonet", "Unable to read TCP from: " + connection, iOException);
                                    } else if (Log.DEBUG) {
                                        Log.debug("kryonet", connection + " update: " + iOException.getMessage());
                                    }
                                    connection.close();
                                }
                                catch (KryoNetException kryoNetException) {
                                    if (Log.ERROR) {
                                        Log.error("kryonet", "Error reading TCP from connection: " + connection, kryoNetException);
                                    }
                                    connection.close();
                                }
                            }
                            if ((n4 & 4) != 4) continue;
                            try {
                                connection.tcp.writeOperation();
                            }
                            catch (IOException iOException) {
                                if (Log.TRACE) {
                                    Log.trace("kryonet", "Unable to write TCP to connection: " + connection, iOException);
                                } else if (Log.DEBUG) {
                                    Log.debug("kryonet", connection + " update: " + iOException.getMessage());
                                }
                                connection.close();
                            }
                            continue;
                        }
                        if ((n4 & 0x10) == 16) {
                            object4 = this.serverChannel;
                            if (object4 == null) continue;
                            try {
                                object3 = ((ServerSocketChannel)object4).accept();
                                if (object3 == null) continue;
                                this.acceptOperation((SocketChannel)object3);
                            }
                            catch (IOException iOException) {
                                if (!Log.DEBUG) continue;
                                Log.debug("kryonet", "Unable to accept new connection.", iOException);
                            }
                            continue;
                        }
                        if (udpConnection == null) {
                            selectionKey.channel().close();
                            continue;
                        }
                        try {
                            object4 = udpConnection.readFromAddress();
                        }
                        catch (IOException iOException) {
                            if (!Log.WARN) continue;
                            Log.warn("kryonet", "Error reading UDP data.", iOException);
                            continue;
                        }
                        if (object4 == null) continue;
                        object3 = this.connections;
                        int n5 = ((Connection[])object3).length;
                        for (int i2 = 0; i2 < n5; ++i2) {
                            connection2 = object3[i2];
                            if (!((InetSocketAddress)object4).equals(connection2.udpRemoteAddress)) continue;
                            connection = connection2;
                            break;
                        }
                        try {
                            object2 = udpConnection.readObject(connection);
                        }
                        catch (KryoNetException kryoNetException) {
                            if (!Log.WARN) continue;
                            if (connection != null) {
                                if (!Log.ERROR) continue;
                                Log.error("kryonet", "Error reading UDP from connection: " + connection, kryoNetException);
                                continue;
                            }
                            Log.warn("kryonet", "Error reading UDP from unregistered address: " + object4, kryoNetException);
                            continue;
                        }
                        if (object2 instanceof FrameworkMessage) {
                            if (object2 instanceof FrameworkMessage.RegisterUDP) {
                                n5 = ((FrameworkMessage.RegisterUDP)object2).connectionID;
                                connection2 = this.pendingConnections.remove(n5);
                                if (connection2 != null) {
                                    if (connection2.udpRemoteAddress != null) continue;
                                    connection2.udpRemoteAddress = object4;
                                    this.addConnection(connection2);
                                    connection2.sendTCP(new FrameworkMessage.RegisterUDP());
                                    if (Log.DEBUG) {
                                        Log.debug("kryonet", "Port " + udpConnection.datagramChannel.socket().getLocalPort() + "/UDP connected to: " + object4);
                                    }
                                    connection2.notifyConnected();
                                    continue;
                                }
                                if (!Log.DEBUG) continue;
                                Log.debug("kryonet", "Ignoring incoming RegisterUDP with invalid connection ID: " + n5);
                                continue;
                            }
                            if (object2 instanceof FrameworkMessage.DiscoverHost) {
                                try {
                                    n5 = this.discoveryHandler.onDiscoverHost(udpConnection.datagramChannel, (InetSocketAddress)object4) ? 1 : 0;
                                    if (!Log.DEBUG || n5 == 0) continue;
                                    Log.debug("kryonet", "Responded to host discovery from: " + object4);
                                }
                                catch (IOException iOException) {
                                    if (!Log.WARN) continue;
                                    Log.warn("kryonet", "Error replying to host discovery from: " + object4, iOException);
                                }
                                continue;
                            }
                        }
                        if (connection != null) {
                            if (Log.DEBUG) {
                                String string;
                                String string2 = string = object2 == null ? "null" : object2.getClass().getSimpleName();
                                if (object2 instanceof FrameworkMessage) {
                                    if (Log.TRACE) {
                                        Log.trace("kryonet", connection + " received UDP: " + string);
                                    }
                                } else {
                                    Log.debug("kryonet", connection + " received UDP: " + string);
                                }
                            }
                            connection.notifyReceived(object2);
                            continue;
                        }
                        if (!Log.DEBUG) continue;
                        Log.debug("kryonet", "Ignoring UDP from unregistered address: " + object4);
                    }
                    catch (CancelledKeyException cancelledKeyException) {
                        if (connection != null) {
                            connection.close();
                            continue;
                        }
                        selectionKey.channel().close();
                    }
                }
            }
        }
        l2 = System.currentTimeMillis();
        for (Connection connection : this.connections) {
            if (connection.tcp.isTimedOut(l2)) {
                if (Log.DEBUG) {
                    Log.debug("kryonet", connection + " timed out.");
                }
                connection.close();
            } else if (connection.tcp.needsKeepAlive(l2)) {
                connection.sendTCP(FrameworkMessage.keepAlive);
            }
            if (!connection.isIdle()) continue;
            connection.notifyIdle();
        }
    }

    private void keepAlive() {
        long l2 = System.currentTimeMillis();
        for (Connection connection : this.connections) {
            if (!connection.tcp.needsKeepAlive(l2)) continue;
            connection.sendTCP(FrameworkMessage.keepAlive);
        }
    }

    @Override
    public void run() {
        if (Log.TRACE) {
            Log.trace("kryonet", "Server thread started.");
        }
        this.shutdown = false;
        while (!this.shutdown) {
            try {
                this.update(250);
            }
            catch (IOException iOException) {
                if (Log.ERROR) {
                    Log.error("kryonet", "Error updating server connections.", iOException);
                }
                this.close();
            }
        }
        if (Log.TRACE) {
            Log.trace("kryonet", "Server thread stopped.");
        }
    }

    @Override
    public void start() {
        new Thread((Runnable)this, "Server").start();
    }

    @Override
    public void stop() {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        this.close();
        if (Log.TRACE) {
            Log.trace("kryonet", "Server thread stopping.");
        }
    }

    private void acceptOperation(SocketChannel socketChannel) {
        block7: {
            Connection connection = this.newConnection();
            connection.initialize(this.serialization, this.writeBufferSize, this.objectBufferSize);
            connection.endPoint = this;
            UdpConnection udpConnection = this.udp;
            if (udpConnection != null) {
                connection.udp = udpConnection;
            }
            try {
                SelectionKey selectionKey = connection.tcp.accept(this.selector, socketChannel);
                selectionKey.attach(connection);
                int n2 = this.nextConnectionID++;
                if (this.nextConnectionID == -1) {
                    this.nextConnectionID = 1;
                }
                connection.id = n2;
                connection.setConnected(true);
                connection.addListener(this.dispatchListener);
                if (udpConnection == null) {
                    this.addConnection(connection);
                } else {
                    this.pendingConnections.put(n2, connection);
                }
                FrameworkMessage.RegisterTCP registerTCP = new FrameworkMessage.RegisterTCP();
                registerTCP.connectionID = n2;
                connection.sendTCP(registerTCP);
                if (udpConnection == null) {
                    connection.notifyConnected();
                }
            }
            catch (IOException iOException) {
                connection.close();
                if (!Log.DEBUG) break block7;
                Log.debug("kryonet", "Unable to accept TCP connection.", iOException);
            }
        }
    }

    protected Connection newConnection() {
        return new Connection();
    }

    private void addConnection(Connection connection) {
        Connection[] connectionArray = new Connection[this.connections.length + 1];
        connectionArray[0] = connection;
        System.arraycopy(this.connections, 0, connectionArray, 1, this.connections.length);
        this.connections = connectionArray;
    }

    void removeConnection(Connection connection) {
        ArrayList<Connection> arrayList = new ArrayList<Connection>(Arrays.asList(this.connections));
        arrayList.remove(connection);
        this.connections = arrayList.toArray(new Connection[arrayList.size()]);
        this.pendingConnections.remove(connection.id);
    }

    public void sendToAllTCP(Object object) {
        for (Connection connection : this.connections) {
            connection.sendTCP(object);
        }
    }

    public void sendToAllExceptTCP(int n2, Object object) {
        for (Connection connection : this.connections) {
            if (connection.id == n2) continue;
            connection.sendTCP(object);
        }
    }

    public void sendToTCP(int n2, Object object) {
        for (Connection connection : this.connections) {
            if (connection.id != n2) continue;
            connection.sendTCP(object);
            break;
        }
    }

    public void sendToAllUDP(Object object) {
        for (Connection connection : this.connections) {
            connection.sendUDP(object);
        }
    }

    public void sendToAllExceptUDP(int n2, Object object) {
        for (Connection connection : this.connections) {
            if (connection.id == n2) continue;
            connection.sendUDP(object);
        }
    }

    public void sendToUDP(int n2, Object object) {
        for (Connection connection : this.connections) {
            if (connection.id != n2) continue;
            connection.sendUDP(object);
            break;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addListener(Listener listener) {
        if (listener == null) {
            throw new NullPointerException("listener cannot be null.");
        }
        Object object = this.listenerLock;
        synchronized (object) {
            Listener[] listenerArray = this.listeners;
            int n2 = listenerArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (listener != listenerArray[i2]) continue;
                return;
            }
            Listener[] listenerArray2 = new Listener[n2 + 1];
            listenerArray2[0] = listener;
            System.arraycopy(listenerArray, 0, listenerArray2, 1, n2);
            this.listeners = listenerArray2;
        }
        if (Log.TRACE) {
            Log.trace("kryonet", "Server listener added: " + listener.getClass().getName());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeListener(Listener listener) {
        if (listener == null) {
            throw new NullPointerException("listener cannot be null.");
        }
        Object object = this.listenerLock;
        synchronized (object) {
            Listener[] listenerArray = this.listeners;
            int n2 = listenerArray.length;
            Listener[] listenerArray2 = new Listener[n2 - 1];
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                Listener listener2 = listenerArray[i2];
                if (listener == listener2) continue;
                if (n3 == n2 - 1) {
                    return;
                }
                listenerArray2[n3++] = listener2;
            }
            this.listeners = listenerArray2;
        }
        if (Log.TRACE) {
            Log.trace("kryonet", "Server listener removed: " + listener.getClass().getName());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        UdpConnection udpConnection;
        Connection[] connectionArray = this.connections;
        if (Log.INFO && connectionArray.length > 0) {
            Log.info("kryonet", "Closing server connections...");
        }
        int n2 = connectionArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            connectionArray[i2].close();
        }
        connectionArray = new Connection[]{};
        ServerSocketChannel serverSocketChannel = this.serverChannel;
        if (serverSocketChannel != null) {
            block15: {
                try {
                    serverSocketChannel.close();
                    if (Log.INFO) {
                        Log.info("kryonet", "Server closed.");
                    }
                }
                catch (IOException iOException) {
                    if (!Log.DEBUG) break block15;
                    Log.debug("kryonet", "Unable to close server.", iOException);
                }
            }
            this.serverChannel = null;
        }
        if ((udpConnection = this.udp) != null) {
            udpConnection.close();
            this.udp = null;
        }
        Object object = this.updateLock;
        synchronized (object) {
        }
        object = this.updateLock;
        synchronized (object) {
            this.selector.wakeup();
            try {
                this.selector.selectNow();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    public void dispose() {
        this.close();
        this.selector.close();
    }

    @Override
    public Thread getUpdateThread() {
        return this.updateThread;
    }

    public Collection<Connection> getConnections() {
        return Collections.unmodifiableCollection(Arrays.asList(this.connections));
    }
}

