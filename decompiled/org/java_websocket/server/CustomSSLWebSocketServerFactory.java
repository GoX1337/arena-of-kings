/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.server;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.java_websocket.SSLSocketChannel2;
import org.java_websocket.server.DefaultSSLWebSocketServerFactory;

public class CustomSSLWebSocketServerFactory
extends DefaultSSLWebSocketServerFactory {
    private final String[] enabledProtocols;
    private final String[] enabledCiphersuites;

    public CustomSSLWebSocketServerFactory(SSLContext sSLContext, String[] stringArray, String[] stringArray2) {
        this(sSLContext, Executors.newSingleThreadScheduledExecutor(), stringArray, stringArray2);
    }

    public CustomSSLWebSocketServerFactory(SSLContext sSLContext, ExecutorService executorService, String[] stringArray, String[] stringArray2) {
        super(sSLContext, executorService);
        this.enabledProtocols = stringArray;
        this.enabledCiphersuites = stringArray2;
    }

    @Override
    public ByteChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine sSLEngine = this.sslcontext.createSSLEngine();
        if (this.enabledProtocols != null) {
            sSLEngine.setEnabledProtocols(this.enabledProtocols);
        }
        if (this.enabledCiphersuites != null) {
            sSLEngine.setEnabledCipherSuites(this.enabledCiphersuites);
        }
        sSLEngine.setUseClientMode(false);
        return new SSLSocketChannel2(socketChannel, sSLEngine, this.exec, selectionKey);
    }
}

