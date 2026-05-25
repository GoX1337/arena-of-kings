/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.net;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.NetJavaSocketImpl;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.net.InetSocketAddress;

public class NetJavaServerSocketImpl
implements ServerSocket {
    private Net.Protocol protocol;
    private java.net.ServerSocket server;

    public NetJavaServerSocketImpl(Net.Protocol protocol, int n2, ServerSocketHints serverSocketHints) {
        this(protocol, null, n2, serverSocketHints);
    }

    public NetJavaServerSocketImpl(Net.Protocol protocol, String string, int n2, ServerSocketHints serverSocketHints) {
        this.protocol = protocol;
        try {
            this.server = new java.net.ServerSocket();
            if (serverSocketHints != null) {
                this.server.setPerformancePreferences(serverSocketHints.performancePrefConnectionTime, serverSocketHints.performancePrefLatency, serverSocketHints.performancePrefBandwidth);
                this.server.setReuseAddress(serverSocketHints.reuseAddress);
                this.server.setSoTimeout(serverSocketHints.acceptTimeout);
                this.server.setReceiveBufferSize(serverSocketHints.receiveBufferSize);
            }
            InetSocketAddress inetSocketAddress = string != null ? new InetSocketAddress(string, n2) : new InetSocketAddress(n2);
            if (serverSocketHints != null) {
                this.server.bind(inetSocketAddress, serverSocketHints.backlog);
            } else {
                this.server.bind(inetSocketAddress);
            }
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Cannot create a server socket at port " + n2 + ".", exception);
        }
    }

    @Override
    public Net.Protocol getProtocol() {
        return this.protocol;
    }

    @Override
    public Socket accept(SocketHints socketHints) {
        try {
            return new NetJavaSocketImpl(this.server.accept(), socketHints);
        }
        catch (Exception exception) {
            throw new GdxRuntimeException("Error accepting socket.", exception);
        }
    }

    @Override
    public void dispose() {
        if (this.server != null) {
            try {
                this.server.close();
                this.server = null;
            }
            catch (Exception exception) {
                throw new GdxRuntimeException("Error closing server.", exception);
            }
        }
    }
}

