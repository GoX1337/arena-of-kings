/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.server;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.java_websocket.SSLSocketChannel2;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketListener;
import org.java_websocket.WebSocketServerFactory;
import org.java_websocket.drafts.Draft;

public class DefaultSSLWebSocketServerFactory
implements WebSocketServerFactory {
    protected SSLContext sslcontext;
    protected ExecutorService exec;

    public DefaultSSLWebSocketServerFactory(SSLContext sSLContext) {
        this(sSLContext, Executors.newSingleThreadScheduledExecutor());
    }

    public DefaultSSLWebSocketServerFactory(SSLContext sSLContext, ExecutorService executorService) {
        if (sSLContext == null || executorService == null) {
            throw new IllegalArgumentException();
        }
        this.sslcontext = sSLContext;
        this.exec = executorService;
    }

    @Override
    public ByteChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine sSLEngine = this.sslcontext.createSSLEngine();
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(sSLEngine.getEnabledCipherSuites()));
        arrayList.remove("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        sSLEngine.setEnabledCipherSuites(arrayList.toArray(new String[arrayList.size()]));
        sSLEngine.setUseClientMode(false);
        return new SSLSocketChannel2(socketChannel, sSLEngine, this.exec, selectionKey);
    }

    @Override
    public WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft) {
        return new WebSocketImpl((WebSocketListener)webSocketAdapter, draft);
    }

    @Override
    public WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list) {
        return new WebSocketImpl((WebSocketListener)webSocketAdapter, list);
    }

    @Override
    public void close() {
        this.exec.shutdown();
    }
}

