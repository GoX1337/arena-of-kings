/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketListener;
import org.java_websocket.client.DnsResolver;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.protocols.IProtocol;

public abstract class WebSocketClient
extends AbstractWebSocket
implements Runnable,
WebSocket {
    protected URI uri = null;
    private WebSocketImpl engine = null;
    private Socket socket = null;
    private SocketFactory socketFactory = null;
    private OutputStream ostream;
    private Proxy proxy = Proxy.NO_PROXY;
    private Thread writeThread;
    private Thread connectReadThread;
    private Draft draft;
    private Map<String, String> headers;
    private CountDownLatch connectLatch = new CountDownLatch(1);
    private CountDownLatch closeLatch = new CountDownLatch(1);
    private int connectTimeout = 0;
    private DnsResolver dnsResolver = null;

    public WebSocketClient(URI uRI) {
        this(uRI, new Draft_6455());
    }

    public WebSocketClient(URI uRI, Draft draft) {
        this(uRI, draft, null, 0);
    }

    public WebSocketClient(URI uRI, Map<String, String> map) {
        this(uRI, new Draft_6455(), map);
    }

    public WebSocketClient(URI uRI, Draft draft, Map<String, String> map) {
        this(uRI, draft, map, 0);
    }

    public WebSocketClient(URI uRI, Draft draft, Map<String, String> map, int n2) {
        if (uRI == null) {
            throw new IllegalArgumentException();
        }
        if (draft == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        this.uri = uRI;
        this.draft = draft;
        this.dnsResolver = new bxs(this);
        if (map != null) {
            this.headers = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
            this.headers.putAll(map);
        }
        this.connectTimeout = n2;
        this.setTcpNoDelay(false);
        this.setReuseAddr(false);
        this.engine = new WebSocketImpl((WebSocketListener)this, draft);
    }

    public URI getURI() {
        return this.uri;
    }

    @Override
    public Draft getDraft() {
        return this.draft;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void addHeader(String string, String string2) {
        if (this.headers == null) {
            this.headers = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        }
        this.headers.put(string, string2);
    }

    public String removeHeader(String string) {
        if (this.headers == null) {
            return null;
        }
        return this.headers.remove(string);
    }

    public void clearHeaders() {
        this.headers = null;
    }

    public void setDnsResolver(DnsResolver dnsResolver) {
        this.dnsResolver = dnsResolver;
    }

    public void reconnect() {
        this.reset();
        this.connect();
    }

    public boolean reconnectBlocking() {
        this.reset();
        return this.connectBlocking();
    }

    private void reset() {
        Thread thread = Thread.currentThread();
        if (thread == this.writeThread || thread == this.connectReadThread) {
            throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to ensure a successful cleanup.");
        }
        try {
            this.closeBlocking();
            if (this.writeThread != null) {
                this.writeThread.interrupt();
                this.writeThread = null;
            }
            if (this.connectReadThread != null) {
                this.connectReadThread.interrupt();
                this.connectReadThread = null;
            }
            this.draft.reset();
            if (this.socket != null) {
                this.socket.close();
                this.socket = null;
            }
        }
        catch (Exception exception) {
            this.onError(exception);
            this.engine.closeConnection(1006, exception.getMessage());
            return;
        }
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.engine = new WebSocketImpl((WebSocketListener)this, this.draft);
    }

    public void connect() {
        if (this.connectReadThread != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        this.connectReadThread = new Thread(this);
        this.connectReadThread.setName("WebSocketConnectReadThread-" + this.connectReadThread.getId());
        this.connectReadThread.start();
    }

    public boolean connectBlocking() {
        this.connect();
        this.connectLatch.await();
        return this.engine.isOpen();
    }

    public boolean connectBlocking(long l2, TimeUnit timeUnit) {
        this.connect();
        return this.connectLatch.await(l2, timeUnit) && this.engine.isOpen();
    }

    @Override
    public void close() {
        if (this.writeThread != null) {
            this.engine.close(1000);
        }
    }

    public void closeBlocking() {
        this.close();
        this.closeLatch.await();
    }

    @Override
    public void send(String string) {
        this.engine.send(string);
    }

    @Override
    public void send(byte[] byArray) {
        this.engine.send(byArray);
    }

    @Override
    public <T> T getAttachment() {
        return this.engine.getAttachment();
    }

    @Override
    public <T> void setAttachment(T t2) {
        this.engine.setAttachment(t2);
    }

    @Override
    public Collection<WebSocket> getConnections() {
        return Collections.singletonList(this.engine);
    }

    @Override
    public void sendPing() {
        this.engine.sendPing();
    }

    @Override
    public void run() {
        InputStream inputStream;
        try {
            Object object;
            boolean bl2 = this.prepareSocket();
            this.socket.setTcpNoDelay(this.isTcpNoDelay());
            this.socket.setReuseAddress(this.isReuseAddr());
            if (!this.socket.isConnected()) {
                object = this.dnsResolver == null ? InetSocketAddress.createUnresolved(this.uri.getHost(), this.getPort()) : new InetSocketAddress(this.dnsResolver.resolve(this.uri), this.getPort());
                this.socket.connect((SocketAddress)object, this.connectTimeout);
            }
            if (bl2 && "wss".equals(this.uri.getScheme())) {
                this.upgradeSocketToSSL();
            }
            if (this.socket instanceof SSLSocket) {
                object = (SSLSocket)this.socket;
                SSLParameters sSLParameters = ((SSLSocket)object).getSSLParameters();
                this.onSetSSLParameters(sSLParameters);
                ((SSLSocket)object).setSSLParameters(sSLParameters);
            }
            inputStream = this.socket.getInputStream();
            this.ostream = this.socket.getOutputStream();
            this.sendHandshake();
        }
        catch (Exception exception) {
            this.onWebsocketError(this.engine, exception);
            this.engine.closeConnection(-1, exception.getMessage());
            return;
        }
        catch (InternalError internalError) {
            if (internalError.getCause() instanceof InvocationTargetException && internalError.getCause().getCause() instanceof IOException) {
                IOException iOException = (IOException)internalError.getCause().getCause();
                this.onWebsocketError(this.engine, iOException);
                this.engine.closeConnection(-1, iOException.getMessage());
                return;
            }
            throw internalError;
        }
        this.writeThread = new Thread(new a(this));
        this.writeThread.start();
        byte[] byArray = new byte[16384];
        try {
            int n2;
            while (!this.isClosing() && !this.isClosed() && (n2 = inputStream.read(byArray)) != -1) {
                this.engine.decode(ByteBuffer.wrap(byArray, 0, n2));
            }
            this.engine.eot();
        }
        catch (IOException iOException) {
            this.handleIOException(iOException);
        }
        catch (RuntimeException runtimeException) {
            this.onError(runtimeException);
            this.engine.closeConnection(1006, runtimeException.getMessage());
        }
        this.connectReadThread = null;
    }

    private void upgradeSocketToSSL() {
        SSLSocketFactory sSLSocketFactory;
        if (this.socketFactory instanceof SSLSocketFactory) {
            sSLSocketFactory = (SSLSocketFactory)this.socketFactory;
        } else {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(null, null, null);
            sSLSocketFactory = sSLContext.getSocketFactory();
        }
        this.socket = sSLSocketFactory.createSocket(this.socket, this.uri.getHost(), this.getPort(), true);
    }

    private boolean prepareSocket() {
        boolean bl2 = false;
        if (this.proxy != Proxy.NO_PROXY) {
            this.socket = new Socket(this.proxy);
            bl2 = true;
        } else if (this.socketFactory != null) {
            this.socket = this.socketFactory.createSocket();
        } else if (this.socket == null) {
            this.socket = new Socket(this.proxy);
            bl2 = true;
        } else if (this.socket.isClosed()) {
            throw new IOException();
        }
        return bl2;
    }

    protected void onSetSSLParameters(SSLParameters sSLParameters) {
        sSLParameters.setEndpointIdentificationAlgorithm("HTTPS");
    }

    private int getPort() {
        int n2 = this.uri.getPort();
        String string = this.uri.getScheme();
        if ("wss".equals(string)) {
            return n2 == -1 ? 443 : n2;
        }
        if ("ws".equals(string)) {
            return n2 == -1 ? 80 : n2;
        }
        throw new IllegalArgumentException("unknown scheme: " + string);
    }

    private void sendHandshake() {
        String string = this.uri.getRawPath();
        String string2 = this.uri.getRawQuery();
        String string3 = string == null || string.length() == 0 ? "/" : string;
        if (string2 != null) {
            string3 = string3 + '?' + string2;
        }
        int n2 = this.getPort();
        String string4 = this.uri.getHost() + (n2 != 80 && n2 != 443 ? ":" + n2 : "");
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.setResourceDescriptor(string3);
        handshakeImpl1Client.put("Host", string4);
        if (this.headers != null) {
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                handshakeImpl1Client.put(entry.getKey(), entry.getValue());
            }
        }
        this.engine.startHandshake(handshakeImpl1Client);
    }

    @Override
    public ReadyState getReadyState() {
        return this.engine.getReadyState();
    }

    @Override
    public final void onWebsocketMessage(WebSocket webSocket, String string) {
        this.onMessage(string);
    }

    @Override
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        this.onMessage(byteBuffer);
    }

    @Override
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        this.startConnectionLostTimer();
        this.onOpen((ServerHandshake)handshakedata);
        this.connectLatch.countDown();
    }

    @Override
    public final void onWebsocketClose(WebSocket webSocket, int n2, String string, boolean bl2) {
        this.stopConnectionLostTimer();
        if (this.writeThread != null) {
            this.writeThread.interrupt();
        }
        this.onClose(n2, string, bl2);
        this.connectLatch.countDown();
        this.closeLatch.countDown();
    }

    @Override
    public final void onWebsocketError(WebSocket webSocket, Exception exception) {
        this.onError(exception);
    }

    @Override
    public final void onWriteDemand(WebSocket webSocket) {
    }

    @Override
    public void onWebsocketCloseInitiated(WebSocket webSocket, int n2, String string) {
        this.onCloseInitiated(n2, string);
    }

    @Override
    public void onWebsocketClosing(WebSocket webSocket, int n2, String string, boolean bl2) {
        this.onClosing(n2, string, bl2);
    }

    public void onCloseInitiated(int n2, String string) {
    }

    public void onClosing(int n2, String string, boolean bl2) {
    }

    public WebSocket getConnection() {
        return this.engine;
    }

    @Override
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        if (this.socket != null) {
            return (InetSocketAddress)this.socket.getLocalSocketAddress();
        }
        return null;
    }

    @Override
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        if (this.socket != null) {
            return (InetSocketAddress)this.socket.getRemoteSocketAddress();
        }
        return null;
    }

    public abstract void onOpen(ServerHandshake var1);

    public abstract void onMessage(String var1);

    public abstract void onClose(int var1, String var2, boolean var3);

    public abstract void onError(Exception var1);

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public void setProxy(Proxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        this.proxy = proxy;
    }

    @Deprecated
    public void setSocket(Socket socket) {
        if (this.socket != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.socket = socket;
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
    }

    @Override
    public void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean bl2) {
        this.engine.sendFragmentedFrame(opcode, byteBuffer, bl2);
    }

    @Override
    public boolean isOpen() {
        return this.engine.isOpen();
    }

    @Override
    public boolean isFlushAndClose() {
        return this.engine.isFlushAndClose();
    }

    @Override
    public boolean isClosed() {
        return this.engine.isClosed();
    }

    @Override
    public boolean isClosing() {
        return this.engine.isClosing();
    }

    @Override
    public boolean hasBufferedData() {
        return this.engine.hasBufferedData();
    }

    @Override
    public void close(int n2) {
        this.engine.close(n2);
    }

    @Override
    public void close(int n2, String string) {
        this.engine.close(n2, string);
    }

    @Override
    public void closeConnection(int n2, String string) {
        this.engine.closeConnection(n2, string);
    }

    @Override
    public void send(ByteBuffer byteBuffer) {
        this.engine.send(byteBuffer);
    }

    @Override
    public void sendFrame(Framedata framedata) {
        this.engine.sendFrame(framedata);
    }

    @Override
    public void sendFrame(Collection<Framedata> collection) {
        this.engine.sendFrame(collection);
    }

    @Override
    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.getLocalSocketAddress();
    }

    @Override
    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.getRemoteSocketAddress();
    }

    @Override
    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    @Override
    public boolean hasSSLSupport() {
        return this.socket instanceof SSLSocket;
    }

    @Override
    public SSLSession getSSLSession() {
        if (!this.hasSSLSupport()) {
            throw new IllegalArgumentException("This websocket uses ws instead of wss. No SSLSession available.");
        }
        return ((SSLSocket)this.socket).getSession();
    }

    @Override
    public IProtocol getProtocol() {
        return this.engine.getProtocol();
    }

    private void handleIOException(IOException iOException) {
        if (iOException instanceof SSLException) {
            this.onError(iOException);
        }
        this.engine.eot();
    }

    class a
    implements Runnable {
        private final WebSocketClient b;

        a(WebSocketClient webSocketClient2) {
            this.b = webSocketClient2;
        }

        @Override
        public void run() {
            Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            try {
                this.a();
            }
            catch (IOException iOException) {
                WebSocketClient.this.handleIOException(iOException);
            }
            finally {
                this.b();
                WebSocketClient.this.writeThread = null;
            }
        }

        private void a() {
            try {
                while (!Thread.interrupted()) {
                    ByteBuffer byteBuffer = ((WebSocketClient)WebSocketClient.this).engine.outQueue.take();
                    WebSocketClient.this.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                    WebSocketClient.this.ostream.flush();
                }
            }
            catch (InterruptedException interruptedException) {
                for (ByteBuffer byteBuffer : ((WebSocketClient)WebSocketClient.this).engine.outQueue) {
                    WebSocketClient.this.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                    WebSocketClient.this.ostream.flush();
                }
                Thread.currentThread().interrupt();
            }
        }

        private void b() {
            try {
                if (WebSocketClient.this.socket != null) {
                    WebSocketClient.this.socket.close();
                }
            }
            catch (IOException iOException) {
                WebSocketClient.this.onWebsocketError(this.b, iOException);
            }
        }
    }
}

