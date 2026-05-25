/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.KryoNetException;
import com.esotericsoftware.kryonet.serialization.Serialization;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class UdpConnection {
    public static boolean androidFixDisabled = false;
    InetSocketAddress connectedAddress;
    DatagramChannel datagramChannel;
    int keepAliveMillis = 19000;
    final ByteBuffer readBuffer;
    final ByteBuffer writeBuffer;
    private final Serialization serialization;
    private SelectionKey selectionKey;
    private final Object writeLock = new Object();
    private long lastCommunicationTime;

    public UdpConnection(Serialization serialization, int n2) {
        this.serialization = serialization;
        this.readBuffer = ByteBuffer.allocate(n2);
        this.writeBuffer = ByteBuffer.allocateDirect(n2);
    }

    public void bind(Selector selector, InetSocketAddress inetSocketAddress) {
        this.close();
        this.readBuffer.clear();
        this.writeBuffer.clear();
        try {
            this.datagramChannel = selector.provider().openDatagramChannel();
            this.datagramChannel.socket().bind(inetSocketAddress);
            this.datagramChannel.configureBlocking(false);
            this.selectionKey = this.datagramChannel.register(selector, 1);
            this.lastCommunicationTime = System.currentTimeMillis();
        }
        catch (IOException iOException) {
            this.close();
            throw iOException;
        }
    }

    public void connect(Selector selector, InetSocketAddress inetSocketAddress) {
        this.close();
        this.readBuffer.clear();
        this.writeBuffer.clear();
        try {
            this.datagramChannel = selector.provider().openDatagramChannel();
            this.datagramChannel.socket().bind(null);
            this.datagramChannel.socket().connect(inetSocketAddress);
            this.datagramChannel.configureBlocking(false);
            this.selectionKey = this.datagramChannel.register(selector, 1);
            this.lastCommunicationTime = System.currentTimeMillis();
            this.connectedAddress = inetSocketAddress;
        }
        catch (IOException iOException) {
            this.close();
            IOException iOException2 = new IOException("Unable to connect to: " + inetSocketAddress);
            iOException2.initCause(iOException);
            throw iOException2;
        }
    }

    public InetSocketAddress readFromAddress() {
        DatagramChannel datagramChannel = this.datagramChannel;
        if (datagramChannel == null) {
            throw new SocketException("Connection is closed.");
        }
        this.lastCommunicationTime = System.currentTimeMillis();
        if (androidFixDisabled || !datagramChannel.isConnected()) {
            return (InetSocketAddress)datagramChannel.receive(this.readBuffer);
        }
        datagramChannel.read(this.readBuffer);
        return this.connectedAddress;
    }

    public Object readObject(Connection connection) {
        this.readBuffer.flip();
        try {
            Object object = this.serialization.read(connection, this.readBuffer);
            if (this.readBuffer.hasRemaining()) {
                throw new KryoNetException("Incorrect number of bytes (" + this.readBuffer.remaining() + " remaining) used to deserialize object: " + object);
            }
            Object object2 = object;
            return object2;
        }
        catch (Exception exception) {
            throw new KryoNetException("Error during deserialization.", exception);
        }
        finally {
            this.readBuffer.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int send(Connection connection, Object object, SocketAddress socketAddress) {
        DatagramChannel datagramChannel = this.datagramChannel;
        if (datagramChannel == null) {
            throw new SocketException("Connection is closed.");
        }
        Object object2 = this.writeLock;
        synchronized (object2) {
            int n2;
            try {
                try {
                    this.serialization.write(connection, this.writeBuffer, object);
                }
                catch (Exception exception) {
                    throw new KryoNetException("Error serializing object of type: " + object.getClass().getName(), exception);
                }
                this.writeBuffer.flip();
                int n3 = this.writeBuffer.limit();
                datagramChannel.send(this.writeBuffer, socketAddress);
                this.lastCommunicationTime = System.currentTimeMillis();
                boolean bl2 = !this.writeBuffer.hasRemaining();
                n2 = bl2 ? n3 : -1;
                this.writeBuffer.clear();
            }
            catch (Throwable throwable) {
                this.writeBuffer.clear();
                throw throwable;
            }
            return n2;
        }
    }

    public void close() {
        block4: {
            this.connectedAddress = null;
            try {
                if (this.datagramChannel != null) {
                    this.datagramChannel.close();
                    this.datagramChannel = null;
                    if (this.selectionKey != null) {
                        this.selectionKey.selector().wakeup();
                    }
                }
            }
            catch (IOException iOException) {
                if (!Log.DEBUG) break block4;
                Log.debug("kryonet", "Unable to close UDP connection.", iOException);
            }
        }
    }

    public boolean needsKeepAlive(long l2) {
        return this.connectedAddress != null && this.keepAliveMillis > 0 && l2 - this.lastCommunicationTime > (long)this.keepAliveMillis;
    }
}

