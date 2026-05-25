/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.kryonet;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.KryoNetException;
import com.esotericsoftware.kryonet.serialization.Serialization;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

class TcpConnection {
    SocketChannel socketChannel;
    int keepAliveMillis = 8000;
    final ByteBuffer readBuffer;
    final ByteBuffer writeBuffer;
    boolean bufferPositionFix;
    int timeoutMillis = 12000;
    float idleThreshold = 0.1f;
    final Serialization serialization;
    private SelectionKey selectionKey;
    private volatile long lastWriteTime;
    private volatile long lastReadTime;
    private int currentObjectLength;
    private final Object writeLock = new Object();

    public TcpConnection(Serialization serialization, int n2, int n3) {
        this.serialization = serialization;
        this.writeBuffer = ByteBuffer.allocate(n2);
        this.readBuffer = ByteBuffer.allocate(n3);
        this.readBuffer.flip();
    }

    public SelectionKey accept(Selector selector, SocketChannel socketChannel) {
        this.writeBuffer.clear();
        this.readBuffer.clear();
        this.readBuffer.flip();
        this.currentObjectLength = 0;
        try {
            this.socketChannel = socketChannel;
            socketChannel.configureBlocking(false);
            Socket socket = socketChannel.socket();
            socket.setTcpNoDelay(true);
            this.selectionKey = socketChannel.register(selector, 1);
            if (Log.DEBUG) {
                Log.debug("kryonet", "Port " + socketChannel.socket().getLocalPort() + "/TCP connected to: " + socketChannel.socket().getRemoteSocketAddress());
            }
            this.lastReadTime = this.lastWriteTime = System.currentTimeMillis();
            return this.selectionKey;
        }
        catch (IOException iOException) {
            this.close();
            throw iOException;
        }
    }

    public void connect(Selector selector, SocketAddress socketAddress, int n2) {
        this.close();
        this.writeBuffer.clear();
        this.readBuffer.clear();
        this.readBuffer.flip();
        this.currentObjectLength = 0;
        try {
            SocketChannel socketChannel = selector.provider().openSocketChannel();
            Socket socket = socketChannel.socket();
            socket.setTcpNoDelay(true);
            socket.connect(socketAddress, n2);
            socketChannel.configureBlocking(false);
            this.socketChannel = socketChannel;
            this.selectionKey = socketChannel.register(selector, 1);
            this.selectionKey.attach(this);
            if (Log.DEBUG) {
                Log.debug("kryonet", "Port " + socketChannel.socket().getLocalPort() + "/TCP connected to: " + socketChannel.socket().getRemoteSocketAddress());
            }
            this.lastReadTime = this.lastWriteTime = System.currentTimeMillis();
        }
        catch (IOException iOException) {
            this.close();
            throw new IOException("Unable to connect to: " + socketAddress, iOException);
        }
    }

    public Object readObject(Connection connection) {
        Object object;
        int n2;
        int n3;
        SocketChannel socketChannel = this.socketChannel;
        if (socketChannel == null) {
            throw new SocketException("Connection is closed.");
        }
        if (this.currentObjectLength == 0) {
            n3 = this.serialization.getLengthLength();
            if (this.readBuffer.remaining() < n3) {
                this.readBuffer.compact();
                n2 = socketChannel.read(this.readBuffer);
                this.readBuffer.flip();
                if (n2 == -1) {
                    throw new SocketException("Connection is closed.");
                }
                this.lastReadTime = System.currentTimeMillis();
                if (this.readBuffer.remaining() < n3) {
                    return null;
                }
            }
            this.currentObjectLength = this.serialization.readLength(this.readBuffer);
            if (this.currentObjectLength <= 0) {
                throw new KryoNetException("Invalid object length: " + this.currentObjectLength);
            }
            if (this.currentObjectLength > this.readBuffer.capacity()) {
                throw new KryoNetException("Unable to read object larger than read buffer: " + this.currentObjectLength);
            }
        }
        n3 = this.currentObjectLength;
        if (this.readBuffer.remaining() < n3) {
            this.readBuffer.compact();
            n2 = socketChannel.read(this.readBuffer);
            this.readBuffer.flip();
            if (n2 == -1) {
                throw new SocketException("Connection is closed.");
            }
            this.lastReadTime = System.currentTimeMillis();
            if (this.readBuffer.remaining() < n3) {
                return null;
            }
        }
        this.currentObjectLength = 0;
        n2 = this.readBuffer.position();
        int n4 = this.readBuffer.limit();
        this.readBuffer.limit(n2 + n3);
        try {
            object = this.serialization.read(connection, this.readBuffer);
        }
        catch (Exception exception) {
            throw new KryoNetException("Error during deserialization.", exception);
        }
        this.readBuffer.limit(n4);
        if (this.readBuffer.position() - n2 != n3) {
            throw new KryoNetException("Incorrect number of bytes (" + (n2 + n3 - this.readBuffer.position()) + " remaining) used to deserialize object: " + object);
        }
        return object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeOperation() {
        Object object = this.writeLock;
        synchronized (object) {
            if (this.writeToSocket()) {
                this.selectionKey.interestOps(1);
            }
            this.lastWriteTime = System.currentTimeMillis();
        }
    }

    private boolean writeToSocket() {
        SocketChannel socketChannel = this.socketChannel;
        if (socketChannel == null) {
            throw new SocketException("Connection is closed.");
        }
        ByteBuffer byteBuffer = this.writeBuffer;
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            if (this.bufferPositionFix) {
                byteBuffer.compact();
                byteBuffer.flip();
            }
            if (socketChannel.write(byteBuffer) != 0) continue;
        }
        byteBuffer.compact();
        return byteBuffer.position() == 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int send(Connection connection, Object object) {
        SocketChannel socketChannel = this.socketChannel;
        if (socketChannel == null) {
            throw new SocketException("Connection is closed.");
        }
        Object object2 = this.writeLock;
        synchronized (object2) {
            int n2 = this.writeBuffer.position();
            int n3 = this.serialization.getLengthLength();
            try {
                this.writeBuffer.position(this.writeBuffer.position() + n3);
                this.serialization.write(connection, this.writeBuffer, object);
            }
            catch (Throwable throwable) {
                throw new KryoNetException("Error serializing object of type: " + object.getClass().getName(), throwable);
            }
            int n4 = this.writeBuffer.position();
            this.writeBuffer.position(n2);
            this.serialization.writeLength(this.writeBuffer, n4 - n3 - n2);
            this.writeBuffer.position(n4);
            if (n2 == 0 && !this.writeToSocket()) {
                this.selectionKey.interestOps(5);
            } else {
                this.selectionKey.selector().wakeup();
            }
            if (Log.DEBUG || Log.TRACE) {
                float f2 = (float)this.writeBuffer.position() / (float)this.writeBuffer.capacity();
                if (Log.DEBUG && f2 > 0.75f) {
                    Log.debug("kryonet", " TCP write buffer is approaching capacity: " + f2 + "%");
                } else if (Log.TRACE && f2 > 0.25f) {
                    Log.trace("kryonet", " TCP write buffer utilization: " + f2 + "%");
                }
            }
            this.lastWriteTime = System.currentTimeMillis();
            return n4 - n2;
        }
    }

    public void close() {
        block4: {
            try {
                if (this.socketChannel != null) {
                    this.socketChannel.close();
                    this.socketChannel = null;
                    if (this.selectionKey != null) {
                        this.selectionKey.selector().wakeup();
                    }
                }
            }
            catch (IOException iOException) {
                if (!Log.DEBUG) break block4;
                Log.debug("kryonet", "Unable to close TCP connection.", iOException);
            }
        }
    }

    public boolean needsKeepAlive(long l2) {
        return this.socketChannel != null && this.keepAliveMillis > 0 && l2 - this.lastWriteTime > (long)this.keepAliveMillis;
    }

    public boolean isTimedOut(long l2) {
        return this.socketChannel != null && this.timeoutMillis > 0 && l2 - this.lastReadTime > (long)this.timeoutMillis;
    }
}

