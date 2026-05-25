/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet;

import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.FrameworkMessage;
import com.esotericsoftware.kryonet.KryoNetException;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.TcpConnection;
import com.esotericsoftware.kryonet.UdpConnection;
import com.esotericsoftware.kryonet.serialization.Serialization;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.SocketChannel;

public class Connection {
    int id = -1;
    private String name;
    EndPoint endPoint;
    TcpConnection tcp;
    UdpConnection udp;
    InetSocketAddress udpRemoteAddress;
    private Listener[] listeners = new Listener[0];
    private final Object listenerLock = new Object();
    private int lastPingID;
    private long lastPingSendTime;
    private int returnTripTime;
    volatile boolean isConnected;
    volatile KryoNetException lastProtocolError;
    private Object arbitraryData;

    protected Connection() {
    }

    void initialize(Serialization serialization, int n2, int n3) {
        this.tcp = new TcpConnection(serialization, n2, n3);
    }

    public int getID() {
        return this.id;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public KryoNetException getLastProtocolError() {
        return this.lastProtocolError;
    }

    public int sendTCP(Object object) {
        if (object == null) {
            throw new NullPointerException("object to send cannot be null.");
        }
        try {
            int n2 = this.tcp.send(this, object);
            if (n2 == 0) {
                if (Log.TRACE) {
                    Log.trace("kryonet", this + " TCP had nothing to send.");
                }
            } else if (Log.DEBUG) {
                String string;
                String string2 = string = object == null ? "null" : object.getClass().getSimpleName();
                if (!(object instanceof FrameworkMessage)) {
                    Log.debug("kryonet", this + " sent TCP: " + string + " (" + n2 + ")");
                } else if (Log.TRACE) {
                    Log.trace("kryonet", this + " sent TCP: " + string + " (" + n2 + ")");
                }
            }
            return n2;
        }
        catch (IOException iOException) {
            if (Log.DEBUG) {
                Log.debug("kryonet", "Unable to send TCP with connection: " + this, iOException);
            }
            this.close();
            return 0;
        }
        catch (KryoNetException kryoNetException) {
            if (Log.ERROR) {
                Log.error("kryonet", "Unable to send TCP with connection: " + this, kryoNetException);
            }
            this.close();
            return 0;
        }
    }

    public int sendUDP(Object object) {
        if (object == null) {
            throw new NullPointerException("object to send cannot be null.");
        }
        InetSocketAddress inetSocketAddress = this.udpRemoteAddress;
        if (inetSocketAddress == null && this.udp != null) {
            inetSocketAddress = this.udp.connectedAddress;
        }
        if (inetSocketAddress == null && this.isConnected) {
            throw new IllegalStateException("This connection is not connected via UDP.");
        }
        try {
            if (inetSocketAddress == null) {
                throw new SocketException("Connection is closed.");
            }
            int n2 = this.udp.send(this, object, inetSocketAddress);
            if (n2 == 0) {
                if (Log.TRACE) {
                    Log.trace("kryonet", this + " UDP had nothing to send.");
                }
            } else if (Log.DEBUG) {
                if (n2 != -1) {
                    String string;
                    String string2 = string = object == null ? "null" : object.getClass().getSimpleName();
                    if (!(object instanceof FrameworkMessage)) {
                        Log.debug("kryonet", this + " sent UDP: " + string + " (" + n2 + ")");
                    } else if (Log.TRACE) {
                        Log.trace("kryonet", this + " sent UDP: " + string + " (" + n2 + ")");
                    }
                } else {
                    Log.debug("kryonet", this + " was unable to send, UDP socket buffer full.");
                }
            }
            return n2;
        }
        catch (IOException iOException) {
            if (Log.DEBUG) {
                Log.debug("kryonet", "Unable to send UDP with connection: " + this, iOException);
            }
            this.close();
            return 0;
        }
        catch (KryoNetException kryoNetException) {
            if (Log.ERROR) {
                Log.error("kryonet", "Unable to send UDP with connection: " + this, kryoNetException);
            }
            this.close();
            return 0;
        }
    }

    public void close() {
        boolean bl2 = this.isConnected;
        this.isConnected = false;
        this.tcp.close();
        if (this.udp != null && this.udp.connectedAddress != null) {
            this.udp.close();
        }
        if (bl2) {
            this.notifyDisconnected();
            if (Log.INFO) {
                Log.info("kryonet", this + " disconnected.");
            }
        }
        this.setConnected(false);
    }

    public void updateReturnTripTime() {
        FrameworkMessage.Ping ping = new FrameworkMessage.Ping();
        ping.id = this.lastPingID++;
        this.lastPingSendTime = System.currentTimeMillis();
        this.sendTCP(ping);
    }

    public int getReturnTripTime() {
        return this.returnTripTime;
    }

    public void setKeepAliveTCP(int n2) {
        this.tcp.keepAliveMillis = n2;
    }

    public void setTimeout(int n2) {
        this.tcp.timeoutMillis = n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
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
            Log.trace("kryonet", "Connection listener added: " + listener.getClass().getName());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListener(Listener listener) {
        if (listener == null) {
            throw new NullPointerException("listener cannot be null.");
        }
        Object object = this.listenerLock;
        synchronized (object) {
            Listener[] listenerArray = this.listeners;
            int n2 = listenerArray.length;
            if (n2 == 0) {
                return;
            }
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
            Log.trace("kryonet", "Connection listener removed: " + listener.getClass().getName());
        }
    }

    void notifyConnected() {
        InetSocketAddress inetSocketAddress;
        Socket socket;
        Object object;
        if (Log.INFO && (object = this.tcp.socketChannel) != null && (socket = this.tcp.socketChannel.socket()) != null && (inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress()) != null) {
            Log.info("kryonet", this + " connected: " + inetSocketAddress.getAddress());
        }
        object = this.listeners;
        int n2 = ((Listener[])object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            object[i2].connected(this);
        }
    }

    void notifyDisconnected() {
        Listener[] listenerArray = this.listeners;
        int n2 = listenerArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            listenerArray[i2].disconnected(this);
        }
    }

    void notifyIdle() {
        Listener[] listenerArray = this.listeners;
        int n2 = listenerArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            listenerArray[i2].idle(this);
            if (!this.isIdle()) break;
        }
    }

    void notifyReceived(Object object) {
        Listener[] listenerArray;
        if (object instanceof FrameworkMessage.Ping) {
            listenerArray = (Listener[])object;
            if (listenerArray.isReply) {
                if (listenerArray.id == this.lastPingID - 1) {
                    this.returnTripTime = (int)(System.currentTimeMillis() - this.lastPingSendTime);
                    if (Log.TRACE) {
                        Log.trace("kryonet", this + " return trip time: " + this.returnTripTime);
                    }
                }
            } else {
                listenerArray.isReply = true;
                this.sendTCP(listenerArray);
            }
        }
        listenerArray = this.listeners;
        int n2 = listenerArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            listenerArray[i2].received(this, object);
        }
    }

    public EndPoint getEndPoint() {
        return this.endPoint;
    }

    public InetSocketAddress getRemoteAddressTCP() {
        Socket socket;
        SocketChannel socketChannel = this.tcp.socketChannel;
        if (socketChannel != null && (socket = this.tcp.socketChannel.socket()) != null) {
            return (InetSocketAddress)socket.getRemoteSocketAddress();
        }
        return null;
    }

    public InetSocketAddress getRemoteAddressUDP() {
        InetSocketAddress inetSocketAddress = this.udp.connectedAddress;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        return this.udpRemoteAddress;
    }

    public void setBufferPositionFix(boolean bl2) {
        this.tcp.bufferPositionFix = bl2;
    }

    public void setName(String string) {
        this.name = string;
    }

    public int getTcpWriteBufferSize() {
        return this.tcp.writeBuffer.position();
    }

    public boolean isIdle() {
        return (float)this.tcp.writeBuffer.position() / (float)this.tcp.writeBuffer.capacity() < this.tcp.idleThreshold;
    }

    public void setIdleThreshold(float f2) {
        this.tcp.idleThreshold = f2;
    }

    public String toString() {
        if (this.name != null) {
            return this.name;
        }
        return "Connection " + this.id;
    }

    void setConnected(boolean bl2) {
        this.isConnected = bl2;
        if (bl2 && this.name == null) {
            this.name = "Connection " + this.id;
        }
    }

    public Object getArbitraryData() {
        return this.arbitraryData;
    }

    public void setArbitraryData(Object object) {
        this.arbitraryData = object;
    }

    public int hashCode() {
        return 31 + this.id;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Connection connection = (Connection)object;
        return this.id == connection.id;
    }
}

