/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.net;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class NetJavaSocketImpl
implements Socket {
    private java.net.Socket socket;

    public NetJavaSocketImpl(Net.Protocol protocol, String string, int n2, SocketHints socketHints) {
        try {
            this.socket = new java.net.Socket();
            this.applyHints(socketHints);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(string, n2);
            if (socketHints != null) {
                this.socket.connect(inetSocketAddress, socketHints.connectTimeout);
            } else {
                this.socket.connect(inetSocketAddress);
            }
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Error making a socket connection to " + string + ":" + n2, exception);
        }
    }

    public NetJavaSocketImpl(java.net.Socket socket, SocketHints socketHints) {
        this.socket = socket;
        this.applyHints(socketHints);
    }

    private void applyHints(SocketHints socketHints) {
        if (socketHints != null) {
            try {
                this.socket.setPerformancePreferences(socketHints.performancePrefConnectionTime, socketHints.performancePrefLatency, socketHints.performancePrefBandwidth);
                this.socket.setTrafficClass(socketHints.trafficClass);
                this.socket.setTcpNoDelay(socketHints.tcpNoDelay);
                this.socket.setKeepAlive(socketHints.keepAlive);
                this.socket.setSendBufferSize(socketHints.sendBufferSize);
                this.socket.setReceiveBufferSize(socketHints.receiveBufferSize);
                this.socket.setSoLinger(socketHints.linger, socketHints.lingerDuration);
                this.socket.setSoTimeout(socketHints.socketTimeout);
            }
            catch (Exception exception) {
                throw new GdxRuntimeException("Error setting socket hints.", exception);
            }
        }
    }

    @Override
    public boolean isConnected() {
        if (this.socket != null) {
            return this.socket.isConnected();
        }
        return false;
    }

    @Override
    public InputStream getInputStream() {
        try {
            return this.socket.getInputStream();
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Error getting input stream from socket.", exception);
        }
    }

    @Override
    public OutputStream getOutputStream() {
        try {
            return this.socket.getOutputStream();
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Error getting output stream from socket.", exception);
        }
    }

    @Override
    public String getRemoteAddress() {
        return this.socket.getRemoteSocketAddress().toString();
    }

    @Override
    public void dispose() {
        if (this.socket != null) {
            try {
                this.socket.close();
                this.socket = null;
            }
            catch (Exception exception) {
                throw new GdxRuntimeException("Error closing socket.", exception);
            }
        }
    }
}

