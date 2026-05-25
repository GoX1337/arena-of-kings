/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.SocketChannelIOHelper;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketFactory;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketServerFactory;
import org.java_websocket.WrappedByteChannel;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.exceptions.WrappedIOException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.server.DefaultWebSocketServerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WebSocketServer
extends AbstractWebSocket
implements Runnable {
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    private final Collection<WebSocket> connections;
    private final InetSocketAddress address;
    private ServerSocketChannel server;
    private Selector selector;
    private List<Draft> drafts;
    private Thread selectorthread;
    private final AtomicBoolean isclosed = new AtomicBoolean(false);
    protected List<WebSocketWorker> decoders;
    private List<WebSocketImpl> iqueue;
    private BlockingQueue<ByteBuffer> buffers;
    private int queueinvokes = 0;
    private final AtomicInteger queuesize = new AtomicInteger(0);
    private WebSocketServerFactory wsf = new DefaultWebSocketServerFactory();
    private int maxPendingConnections = -1;

    public WebSocketServer() {
        this(new InetSocketAddress(80), AVAILABLE_PROCESSORS, null);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress) {
        this(inetSocketAddress, AVAILABLE_PROCESSORS, null);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int n2) {
        this(inetSocketAddress, n2, null);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, List<Draft> list) {
        this(inetSocketAddress, AVAILABLE_PROCESSORS, list);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int n2, List<Draft> list) {
        this(inetSocketAddress, n2, list, new HashSet<WebSocket>());
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int n2, List<Draft> list, Collection<WebSocket> collection) {
        if (inetSocketAddress == null || n2 < 1 || collection == null) {
            throw new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
        }
        this.drafts = list == null ? Collections.emptyList() : list;
        this.address = inetSocketAddress;
        this.connections = collection;
        this.setTcpNoDelay(false);
        this.setReuseAddr(false);
        this.iqueue = new LinkedList<WebSocketImpl>();
        this.decoders = new ArrayList<WebSocketWorker>(n2);
        this.buffers = new LinkedBlockingQueue<ByteBuffer>();
        for (int i2 = 0; i2 < n2; ++i2) {
            WebSocketWorker webSocketWorker = new WebSocketWorker();
            this.decoders.add(webSocketWorker);
        }
    }

    public void start() {
        if (this.selectorthread != null) {
            throw new IllegalStateException(this.getClass().getName() + " can only be started once.");
        }
        new Thread(this).start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stop(int n2) {
        ArrayList<WebSocket> arrayList;
        if (!this.isclosed.compareAndSet(false, true)) {
            return;
        }
        Object object = this.connections;
        synchronized (object) {
            arrayList = new ArrayList<WebSocket>(this.connections);
        }
        for (WebSocket webSocket : arrayList) {
            webSocket.close(1001);
        }
        this.wsf.close();
        object = this;
        synchronized (object) {
            if (this.selectorthread != null && this.selector != null) {
                this.selector.wakeup();
                this.selectorthread.join(n2);
            }
        }
    }

    public void stop() {
        this.stop(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection<WebSocket> getConnections() {
        Collection<WebSocket> collection = this.connections;
        synchronized (collection) {
            return Collections.unmodifiableCollection(new ArrayList<WebSocket>(this.connections));
        }
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    public int getPort() {
        int n2 = this.getAddress().getPort();
        if (n2 == 0 && this.server != null) {
            n2 = this.server.socket().getLocalPort();
        }
        return n2;
    }

    public List<Draft> getDraft() {
        return Collections.unmodifiableList(this.drafts);
    }

    public void setMaxPendingConnections(int n2) {
        this.maxPendingConnections = n2;
    }

    public int getMaxPendingConnections() {
        return this.maxPendingConnections;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[CATCHBLOCK]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void doAdditionalRead() {
        while (!this.iqueue.isEmpty()) {
            WebSocketImpl webSocketImpl = this.iqueue.remove(0);
            WrappedByteChannel wrappedByteChannel = (WrappedByteChannel)webSocketImpl.getChannel();
            ByteBuffer byteBuffer = this.takeBuffer();
            try {
                if (SocketChannelIOHelper.readMore(byteBuffer, webSocketImpl, wrappedByteChannel)) {
                    this.iqueue.add(webSocketImpl);
                }
                if (byteBuffer.hasRemaining()) {
                    webSocketImpl.inQueue.put(byteBuffer);
                    this.queue(webSocketImpl);
                    continue;
                }
                this.pushBuffer(byteBuffer);
            }
            catch (IOException iOException) {
                this.pushBuffer(byteBuffer);
                throw iOException;
            }
        }
    }

    private void doAccept(SelectionKey selectionKey, Iterator<SelectionKey> iterator) {
        if (!this.onConnect(selectionKey)) {
            selectionKey.cancel();
            return;
        }
        SocketChannel socketChannel = this.server.accept();
        if (socketChannel == null) {
            return;
        }
        socketChannel.configureBlocking(false);
        Socket socket = socketChannel.socket();
        socket.setTcpNoDelay(this.isTcpNoDelay());
        socket.setKeepAlive(true);
        WebSocket webSocket = this.wsf.createWebSocket((WebSocketAdapter)this, (List)this.drafts);
        ((WebSocketImpl)webSocket).setSelectionKey(socketChannel.register(this.selector, 1, webSocket));
        try {
            ((WebSocketImpl)webSocket).setChannel(this.wsf.wrapChannel(socketChannel, ((WebSocketImpl)webSocket).getSelectionKey()));
            iterator.remove();
            this.allocateBuffers(webSocket);
        }
        catch (IOException iOException) {
            if (((WebSocketImpl)webSocket).getSelectionKey() != null) {
                ((WebSocketImpl)webSocket).getSelectionKey().cancel();
            }
            this.handleIOException(((WebSocketImpl)webSocket).getSelectionKey(), null, iOException);
        }
    }

    private boolean doRead(SelectionKey selectionKey, Iterator<SelectionKey> iterator) {
        WebSocketImpl webSocketImpl = (WebSocketImpl)selectionKey.attachment();
        ByteBuffer byteBuffer = this.takeBuffer();
        if (webSocketImpl.getChannel() == null) {
            selectionKey.cancel();
            this.handleIOException(selectionKey, webSocketImpl, new IOException());
            return false;
        }
        try {
            if (SocketChannelIOHelper.read(byteBuffer, webSocketImpl, webSocketImpl.getChannel())) {
                if (byteBuffer.hasRemaining()) {
                    webSocketImpl.inQueue.put(byteBuffer);
                    this.queue(webSocketImpl);
                    iterator.remove();
                    if (webSocketImpl.getChannel() instanceof WrappedByteChannel && ((WrappedByteChannel)webSocketImpl.getChannel()).isNeedRead()) {
                        this.iqueue.add(webSocketImpl);
                    }
                } else {
                    this.pushBuffer(byteBuffer);
                }
            } else {
                this.pushBuffer(byteBuffer);
            }
        }
        catch (IOException iOException) {
            this.pushBuffer(byteBuffer);
            throw new WrappedIOException(webSocketImpl, iOException);
        }
        return true;
    }

    private void doWrite(SelectionKey selectionKey) {
        WebSocketImpl webSocketImpl = (WebSocketImpl)selectionKey.attachment();
        try {
            if (SocketChannelIOHelper.batch(webSocketImpl, webSocketImpl.getChannel()) && selectionKey.isValid()) {
                selectionKey.interestOps(1);
            }
        }
        catch (IOException iOException) {
            throw new WrappedIOException(webSocketImpl, iOException);
        }
    }

    private boolean doSetupSelectorAndServerThread() {
        this.selectorthread.setName("WebSocketSelector-" + this.selectorthread.getId());
        try {
            this.server = ServerSocketChannel.open();
            this.server.configureBlocking(false);
            ServerSocket serverSocket = this.server.socket();
            serverSocket.setReceiveBufferSize(16384);
            serverSocket.setReuseAddress(this.isReuseAddr());
            serverSocket.bind(this.address, this.getMaxPendingConnections());
            this.selector = Selector.open();
            this.server.register(this.selector, this.server.validOps());
            this.startConnectionLostTimer();
            for (WebSocketWorker webSocketWorker : this.decoders) {
                webSocketWorker.start();
            }
            this.onStart();
        }
        catch (IOException iOException) {
            this.handleFatal(null, iOException);
            return false;
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean doEnsureSingleThread() {
        WebSocketServer webSocketServer = this;
        synchronized (webSocketServer) {
            if (this.selectorthread != null) {
                throw new IllegalStateException(this.getClass().getName() + " can only be started once.");
            }
            this.selectorthread = Thread.currentThread();
            if (this.isclosed.get()) {
                return false;
            }
        }
        return true;
    }

    private void doServerShutdown() {
        this.stopConnectionLostTimer();
        if (this.decoders != null) {
            for (WebSocketWorker webSocketWorker : this.decoders) {
                webSocketWorker.interrupt();
            }
        }
        if (this.selector != null) {
            try {
                this.selector.close();
            }
            catch (IOException iOException) {
                this.log.error("IOException during selector.close", iOException);
                this.onError(null, iOException);
            }
        }
        if (this.server != null) {
            try {
                this.server.close();
            }
            catch (IOException iOException) {
                this.log.error("IOException during server.close", iOException);
                this.onError(null, iOException);
            }
        }
    }

    protected void allocateBuffers(WebSocket webSocket) {
        if (this.queuesize.get() >= 2 * this.decoders.size() + 1) {
            return;
        }
        this.queuesize.incrementAndGet();
        this.buffers.put(this.createBuffer());
    }

    protected void releaseBuffers(WebSocket webSocket) {
    }

    public ByteBuffer createBuffer() {
        return ByteBuffer.allocate(16384);
    }

    protected void queue(WebSocketImpl webSocketImpl) {
        if (webSocketImpl.getWorkerThread() == null) {
            webSocketImpl.setWorkerThread(this.decoders.get(this.queueinvokes % this.decoders.size()));
            ++this.queueinvokes;
        }
        webSocketImpl.getWorkerThread().put(webSocketImpl);
    }

    private ByteBuffer takeBuffer() {
        return this.buffers.take();
    }

    private void pushBuffer(ByteBuffer byteBuffer) {
        if (this.buffers.size() > this.queuesize.intValue()) {
            return;
        }
        this.buffers.put(byteBuffer);
    }

    private void handleIOException(SelectionKey selectionKey, WebSocket webSocket, IOException iOException) {
        SelectableChannel selectableChannel;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        if (webSocket != null) {
            webSocket.closeConnection(1006, iOException.getMessage());
        } else if (selectionKey != null && (selectableChannel = selectionKey.channel()) != null && selectableChannel.isOpen()) {
            try {
                selectableChannel.close();
            }
            catch (IOException iOException2) {
                // empty catch block
            }
            this.log.trace("Connection closed because of exception", iOException);
        }
    }

    private void handleFatal(WebSocket webSocket, Exception exception) {
        this.log.error("Shutdown due to fatal error", exception);
        this.onError(webSocket, exception);
        if (this.decoders != null) {
            for (WebSocketWorker webSocketWorker : this.decoders) {
                webSocketWorker.interrupt();
            }
        }
        if (this.selectorthread != null) {
            this.selectorthread.interrupt();
        }
        try {
            this.stop();
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            this.log.error("Interrupt during stop", exception);
            this.onError(null, interruptedException);
        }
    }

    @Override
    public final void onWebsocketMessage(WebSocket webSocket, String string) {
        this.onMessage(webSocket, string);
    }

    @Override
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        this.onMessage(webSocket, byteBuffer);
    }

    @Override
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        if (this.addConnection(webSocket)) {
            this.onOpen(webSocket, (ClientHandshake)handshakedata);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void onWebsocketClose(WebSocket webSocket, int n2, String string, boolean bl2) {
        this.selector.wakeup();
        try {
            if (this.removeConnection(webSocket)) {
                this.onClose(webSocket, n2, string, bl2);
            }
        }
        finally {
            try {
                this.releaseBuffers(webSocket);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean removeConnection(WebSocket webSocket) {
        boolean bl2 = false;
        Collection<WebSocket> collection = this.connections;
        synchronized (collection) {
            if (this.connections.contains(webSocket)) {
                bl2 = this.connections.remove(webSocket);
            } else {
                this.log.trace("Removing connection which is not in the connections collection! Possible no handshake received! {}", (Object)webSocket);
            }
        }
        if (this.isclosed.get() && this.connections.isEmpty()) {
            this.selectorthread.interrupt();
        }
        return bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean addConnection(WebSocket webSocket) {
        if (!this.isclosed.get()) {
            Collection<WebSocket> collection = this.connections;
            synchronized (collection) {
                return this.connections.add(webSocket);
            }
        }
        webSocket.close(1001);
        return true;
    }

    @Override
    public final void onWebsocketError(WebSocket webSocket, Exception exception) {
        this.onError(webSocket, exception);
    }

    @Override
    public final void onWriteDemand(WebSocket webSocket) {
        WebSocketImpl webSocketImpl = (WebSocketImpl)webSocket;
        try {
            webSocketImpl.getSelectionKey().interestOps(5);
        }
        catch (CancelledKeyException cancelledKeyException) {
            webSocketImpl.outQueue.clear();
        }
        this.selector.wakeup();
    }

    @Override
    public void onWebsocketCloseInitiated(WebSocket webSocket, int n2, String string) {
        this.onCloseInitiated(webSocket, n2, string);
    }

    @Override
    public void onWebsocketClosing(WebSocket webSocket, int n2, String string, boolean bl2) {
        this.onClosing(webSocket, n2, string, bl2);
    }

    public void onCloseInitiated(WebSocket webSocket, int n2, String string) {
    }

    public void onClosing(WebSocket webSocket, int n2, String string, boolean bl2) {
    }

    public final void setWebSocketFactory(WebSocketServerFactory webSocketServerFactory) {
        if (this.wsf != null) {
            this.wsf.close();
        }
        this.wsf = webSocketServerFactory;
    }

    public final WebSocketFactory getWebSocketFactory() {
        return this.wsf;
    }

    protected boolean onConnect(SelectionKey selectionKey) {
        return true;
    }

    private Socket getSocket(WebSocket webSocket) {
        WebSocketImpl webSocketImpl = (WebSocketImpl)webSocket;
        return ((SocketChannel)webSocketImpl.getSelectionKey().channel()).socket();
    }

    @Override
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        return (InetSocketAddress)this.getSocket(webSocket).getLocalSocketAddress();
    }

    @Override
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        return (InetSocketAddress)this.getSocket(webSocket).getRemoteSocketAddress();
    }

    public abstract void onOpen(WebSocket var1, ClientHandshake var2);

    public abstract void onClose(WebSocket var1, int var2, String var3, boolean var4);

    public abstract void onMessage(WebSocket var1, String var2);

    public abstract void onError(WebSocket var1, Exception var2);

    public abstract void onStart();

    public void onMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
    }

    public void broadcast(String string) {
        this.broadcast(string, this.connections);
    }

    public void broadcast(byte[] byArray) {
        this.broadcast(byArray, this.connections);
    }

    public void broadcast(ByteBuffer byteBuffer) {
        this.broadcast(byteBuffer, this.connections);
    }

    public void broadcast(byte[] byArray, Collection<WebSocket> collection) {
        if (byArray == null || collection == null) {
            throw new IllegalArgumentException();
        }
        this.broadcast(ByteBuffer.wrap(byArray), collection);
    }

    public void broadcast(ByteBuffer byteBuffer, Collection<WebSocket> collection) {
        if (byteBuffer == null || collection == null) {
            throw new IllegalArgumentException();
        }
        this.doBroadcast(byteBuffer, collection);
    }

    public void broadcast(String string, Collection<WebSocket> collection) {
        if (string == null || collection == null) {
            throw new IllegalArgumentException();
        }
        this.doBroadcast(string, collection);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doBroadcast(Object object, Collection<WebSocket> collection) {
        ArrayList<WebSocket> arrayList;
        String string = null;
        if (object instanceof String) {
            string = (String)object;
        }
        ByteBuffer byteBuffer = null;
        if (object instanceof ByteBuffer) {
            byteBuffer = (ByteBuffer)object;
        }
        if (string == null && byteBuffer == null) {
            return;
        }
        HashMap<Draft, List<Framedata>> hashMap = new HashMap<Draft, List<Framedata>>();
        Collection<WebSocket> collection2 = collection;
        synchronized (collection2) {
            arrayList = new ArrayList<WebSocket>(collection);
        }
        for (WebSocket webSocket : arrayList) {
            if (webSocket == null) continue;
            Draft draft = webSocket.getDraft();
            this.fillFrames(draft, hashMap, string, byteBuffer);
            try {
                webSocket.sendFrame((Collection)hashMap.get(draft));
            }
            catch (WebsocketNotConnectedException websocketNotConnectedException) {}
        }
    }

    private void fillFrames(Draft draft, Map<Draft, List<Framedata>> map, String string, ByteBuffer byteBuffer) {
        if (!map.containsKey(draft)) {
            List<Framedata> list = null;
            if (string != null) {
                list = draft.createFrames(string, false);
            }
            if (byteBuffer != null) {
                list = draft.createFrames(byteBuffer, false);
            }
            if (list != null) {
                map.put(draft, list);
            }
        }
    }

    public class WebSocketWorker
    extends Thread {
        private BlockingQueue<WebSocketImpl> iqueue = new LinkedBlockingQueue<WebSocketImpl>();

        public WebSocketWorker() {
            this.setName("WebSocketWorker-" + this.getId());
            this.setUncaughtExceptionHandler(new bxu(this, WebSocketServer.this));
        }

        public void put(WebSocketImpl webSocketImpl) {
            this.iqueue.put(webSocketImpl);
        }

        @Override
        public void run() {
            WebSocketImpl webSocketImpl = null;
            try {
                while (true) {
                    webSocketImpl = this.iqueue.take();
                    ByteBuffer byteBuffer = (ByteBuffer)webSocketImpl.inQueue.poll();
                    assert (byteBuffer != null);
                    this.doDecode(webSocketImpl, byteBuffer);
                    webSocketImpl = null;
                }
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            catch (RuntimeException runtimeException) {
                WebSocketServer.this.handleFatal(webSocketImpl, runtimeException);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void doDecode(WebSocketImpl webSocketImpl, ByteBuffer byteBuffer) {
            try {
                webSocketImpl.decode(byteBuffer);
            }
            catch (Exception exception) {
                WebSocketServer.this.log.error("Error while reading from remote connection", exception);
            }
            finally {
                WebSocketServer.this.pushBuffer(byteBuffer);
            }
        }
    }
}

