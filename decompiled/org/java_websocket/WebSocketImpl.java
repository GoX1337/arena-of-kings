/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.net.ssl.SSLSession;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketListener;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.interfaces.ISSLChannel;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.util.Charsetfunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketImpl
implements WebSocket {
    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_WSS_PORT = 443;
    public static final int RCVBUF = 16384;
    private final Logger log = LoggerFactory.getLogger(WebSocketImpl.class);
    public final BlockingQueue<ByteBuffer> outQueue;
    public final BlockingQueue<ByteBuffer> inQueue;
    private final WebSocketListener wsl;
    private SelectionKey key;
    private ByteChannel channel;
    private WebSocketServer.WebSocketWorker workerThread;
    private boolean flushandclosestate = false;
    private volatile ReadyState readyState = ReadyState.NOT_YET_CONNECTED;
    private List<Draft> knownDrafts;
    private Draft draft = null;
    private Role role;
    private ByteBuffer tmpHandshakeBytes = ByteBuffer.allocate(0);
    private ClientHandshake handshakerequest = null;
    private String closemessage = null;
    private Integer closecode = null;
    private Boolean closedremotely = null;
    private String resourceDescriptor = null;
    private long lastPong = System.nanoTime();
    private final Object synchronizeWriteObject = new Object();
    private Object attachment;

    public WebSocketImpl(WebSocketListener webSocketListener, List<Draft> list) {
        this(webSocketListener, (Draft)null);
        this.role = Role.SERVER;
        if (list == null || list.isEmpty()) {
            this.knownDrafts = new ArrayList<Draft>();
            this.knownDrafts.add(new Draft_6455());
        } else {
            this.knownDrafts = list;
        }
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft) {
        if (webSocketListener == null || draft == null && this.role == Role.SERVER) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.outQueue = new LinkedBlockingQueue<ByteBuffer>();
        this.inQueue = new LinkedBlockingQueue<ByteBuffer>();
        this.wsl = webSocketListener;
        this.role = Role.CLIENT;
        if (draft != null) {
            this.draft = draft.copyInstance();
        }
    }

    public void decode(ByteBuffer byteBuffer) {
        assert (byteBuffer.hasRemaining());
        this.log.trace("process({}): ({})", (Object)byteBuffer.remaining(), (Object)(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())));
        if (this.readyState != ReadyState.NOT_YET_CONNECTED) {
            if (this.readyState == ReadyState.OPEN) {
                this.decodeFrames(byteBuffer);
            }
        } else if (this.decodeHandshake(byteBuffer) && !this.isClosing() && !this.isClosed()) {
            assert (this.tmpHandshakeBytes.hasRemaining() != byteBuffer.hasRemaining() || !byteBuffer.hasRemaining());
            if (byteBuffer.hasRemaining()) {
                this.decodeFrames(byteBuffer);
            } else if (this.tmpHandshakeBytes.hasRemaining()) {
                this.decodeFrames(this.tmpHandshakeBytes);
            }
        }
    }

    private boolean decodeHandshake(ByteBuffer byteBuffer) {
        block28: {
            Object object;
            ByteBuffer byteBuffer2;
            if (this.tmpHandshakeBytes.capacity() == 0) {
                byteBuffer2 = byteBuffer;
            } else {
                if (this.tmpHandshakeBytes.remaining() < byteBuffer.remaining()) {
                    object = ByteBuffer.allocate(this.tmpHandshakeBytes.capacity() + byteBuffer.remaining());
                    this.tmpHandshakeBytes.flip();
                    object.put(this.tmpHandshakeBytes);
                    this.tmpHandshakeBytes = object;
                }
                this.tmpHandshakeBytes.put(byteBuffer);
                this.tmpHandshakeBytes.flip();
                byteBuffer2 = this.tmpHandshakeBytes;
            }
            byteBuffer2.mark();
            try {
                try {
                    if (this.role == Role.SERVER) {
                        if (this.draft == null) {
                            for (Draft draft : this.knownDrafts) {
                                draft = draft.copyInstance();
                                try {
                                    ServerHandshakeBuilder serverHandshakeBuilder;
                                    draft.setParseMode(this.role);
                                    byteBuffer2.reset();
                                    Handshakedata handshakedata = draft.translateHandshake(byteBuffer2);
                                    if (!(handshakedata instanceof ClientHandshake)) {
                                        this.log.trace("Closing due to wrong handshake");
                                        this.closeConnectionDueToWrongHandshake(new InvalidDataException(1002, "wrong http function"));
                                        return false;
                                    }
                                    ClientHandshake clientHandshake = (ClientHandshake)handshakedata;
                                    object = draft.acceptHandshakeAsServer(clientHandshake);
                                    if (object != HandshakeState.MATCHED) continue;
                                    this.resourceDescriptor = clientHandshake.getResourceDescriptor();
                                    try {
                                        serverHandshakeBuilder = this.wsl.onWebsocketHandshakeReceivedAsServer(this, draft, clientHandshake);
                                    }
                                    catch (InvalidDataException invalidDataException) {
                                        this.log.trace("Closing due to wrong handshake. Possible handshake rejection", invalidDataException);
                                        this.closeConnectionDueToWrongHandshake(invalidDataException);
                                        return false;
                                    }
                                    catch (RuntimeException runtimeException) {
                                        this.log.error("Closing due to internal server error", runtimeException);
                                        this.wsl.onWebsocketError(this, runtimeException);
                                        this.closeConnectionDueToInternalServerError(runtimeException);
                                        return false;
                                    }
                                    this.write(draft.createHandshake(draft.postProcessHandshakeResponseAsServer(clientHandshake, serverHandshakeBuilder)));
                                    this.draft = draft;
                                    this.open(clientHandshake);
                                    return true;
                                }
                                catch (InvalidHandshakeException invalidHandshakeException) {
                                }
                            }
                            if (this.draft == null) {
                                this.log.trace("Closing due to protocol error: no draft matches");
                                this.closeConnectionDueToWrongHandshake(new InvalidDataException(1002, "no draft matches"));
                            }
                            return false;
                        }
                        Handshakedata handshakedata = this.draft.translateHandshake(byteBuffer2);
                        if (!(handshakedata instanceof ClientHandshake)) {
                            this.log.trace("Closing due to protocol error: wrong http function");
                            this.flushAndClose(1002, "wrong http function", false);
                            return false;
                        }
                        ClientHandshake clientHandshake = (ClientHandshake)handshakedata;
                        object = this.draft.acceptHandshakeAsServer(clientHandshake);
                        if (object == HandshakeState.MATCHED) {
                            this.open(clientHandshake);
                            return true;
                        }
                        this.log.trace("Closing due to protocol error: the handshake did finally not match");
                        this.close(1002, "the handshake did finally not match");
                        return false;
                    }
                    if (this.role != Role.CLIENT) break block28;
                    this.draft.setParseMode(this.role);
                    Handshakedata handshakedata = this.draft.translateHandshake(byteBuffer2);
                    if (!(handshakedata instanceof ServerHandshake)) {
                        this.log.trace("Closing due to protocol error: wrong http function");
                        this.flushAndClose(1002, "wrong http function", false);
                        return false;
                    }
                    ServerHandshake serverHandshake = (ServerHandshake)handshakedata;
                    object = this.draft.acceptHandshakeAsClient(this.handshakerequest, serverHandshake);
                    if (object == HandshakeState.MATCHED) {
                        try {
                            this.wsl.onWebsocketHandshakeReceivedAsClient(this, this.handshakerequest, serverHandshake);
                        }
                        catch (InvalidDataException invalidDataException) {
                            this.log.trace("Closing due to invalid data exception. Possible handshake rejection", invalidDataException);
                            this.flushAndClose(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
                            return false;
                        }
                        catch (RuntimeException runtimeException) {
                            this.log.error("Closing since client was never connected", runtimeException);
                            this.wsl.onWebsocketError(this, runtimeException);
                            this.flushAndClose(-1, runtimeException.getMessage(), false);
                            return false;
                        }
                        this.open(serverHandshake);
                        return true;
                    }
                    this.log.trace("Closing due to protocol error: draft {} refuses handshake", (Object)this.draft);
                    this.close(1002, "draft " + this.draft + " refuses handshake");
                }
                catch (InvalidHandshakeException invalidHandshakeException) {
                    this.log.trace("Closing due to invalid handshake", invalidHandshakeException);
                    this.close(invalidHandshakeException);
                }
            }
            catch (IncompleteHandshakeException incompleteHandshakeException) {
                if (this.tmpHandshakeBytes.capacity() == 0) {
                    byteBuffer2.reset();
                    int n2 = incompleteHandshakeException.getPreferredSize();
                    if (n2 == 0) {
                        n2 = byteBuffer2.capacity() + 16;
                    } else assert (incompleteHandshakeException.getPreferredSize() >= byteBuffer2.remaining());
                    this.tmpHandshakeBytes = ByteBuffer.allocate(n2);
                    this.tmpHandshakeBytes.put(byteBuffer);
                }
                this.tmpHandshakeBytes.position(this.tmpHandshakeBytes.limit());
                this.tmpHandshakeBytes.limit(this.tmpHandshakeBytes.capacity());
            }
        }
        return false;
    }

    private void decodeFrames(ByteBuffer byteBuffer) {
        try {
            List<Framedata> list = this.draft.translateFrame(byteBuffer);
            for (Framedata framedata : list) {
                this.log.trace("matched frame: {}", (Object)framedata);
                this.draft.processFrame(this, framedata);
            }
        }
        catch (LimitExceededException limitExceededException) {
            if (limitExceededException.getLimit() == Integer.MAX_VALUE) {
                this.log.error("Closing due to invalid size of frame", limitExceededException);
                this.wsl.onWebsocketError(this, limitExceededException);
            }
            this.close(limitExceededException);
        }
        catch (InvalidDataException invalidDataException) {
            this.log.error("Closing due to invalid data in frame", invalidDataException);
            this.wsl.onWebsocketError(this, invalidDataException);
            this.close(invalidDataException);
        }
    }

    private void closeConnectionDueToWrongHandshake(InvalidDataException invalidDataException) {
        this.write(this.generateHttpResponseDueToError(404));
        this.flushAndClose(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void closeConnectionDueToInternalServerError(RuntimeException runtimeException) {
        this.write(this.generateHttpResponseDueToError(500));
        this.flushAndClose(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer generateHttpResponseDueToError(int n2) {
        String string;
        switch (n2) {
            case 404: {
                string = "404 WebSocket Upgrade Failure";
                break;
            }
            default: {
                string = "500 Internal Server Error";
            }
        }
        return ByteBuffer.wrap(Charsetfunctions.asciiBytes("HTTP/1.1 " + string + "\r\nContent-Type: text/html\r\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (48 + string.length()) + "\r\n\r\n<html><head></head><body><h1>" + string + "</h1></body></html>"));
    }

    public synchronized void close(int n2, String string, boolean bl2) {
        if (this.readyState != ReadyState.CLOSING && this.readyState != ReadyState.CLOSED) {
            if (this.readyState == ReadyState.OPEN) {
                if (n2 == 1006) {
                    assert (!bl2);
                    this.readyState = ReadyState.CLOSING;
                    this.flushAndClose(n2, string, false);
                    return;
                }
                if (this.draft.getCloseHandshakeType() != CloseHandshakeType.NONE) {
                    try {
                        if (!bl2) {
                            try {
                                this.wsl.onWebsocketCloseInitiated(this, n2, string);
                            }
                            catch (RuntimeException runtimeException) {
                                this.wsl.onWebsocketError(this, runtimeException);
                            }
                        }
                        if (this.isOpen()) {
                            CloseFrame closeFrame = new CloseFrame();
                            closeFrame.setReason(string);
                            closeFrame.setCode(n2);
                            closeFrame.isValid();
                            this.sendFrame(closeFrame);
                        }
                    }
                    catch (InvalidDataException invalidDataException) {
                        this.log.error("generated frame is invalid", invalidDataException);
                        this.wsl.onWebsocketError(this, invalidDataException);
                        this.flushAndClose(1006, "generated frame is invalid", false);
                    }
                }
                this.flushAndClose(n2, string, bl2);
            } else if (n2 == -3) {
                assert (bl2);
                this.flushAndClose(-3, string, true);
            } else if (n2 == 1002) {
                this.flushAndClose(n2, string, bl2);
            } else {
                this.flushAndClose(-1, string, false);
            }
            this.readyState = ReadyState.CLOSING;
            this.tmpHandshakeBytes = null;
            return;
        }
    }

    @Override
    public void close(int n2, String string) {
        this.close(n2, string, false);
    }

    public synchronized void closeConnection(int n2, String string, boolean bl2) {
        if (this.readyState == ReadyState.CLOSED) {
            return;
        }
        if (this.readyState == ReadyState.OPEN && n2 == 1006) {
            this.readyState = ReadyState.CLOSING;
        }
        if (this.key != null) {
            this.key.cancel();
        }
        if (this.channel != null) {
            try {
                this.channel.close();
            }
            catch (IOException iOException) {
                if (iOException.getMessage() != null && iOException.getMessage().equals("Broken pipe")) {
                    this.log.trace("Caught IOException: Broken pipe during closeConnection()", iOException);
                }
                this.log.error("Exception during channel.close()", iOException);
                this.wsl.onWebsocketError(this, iOException);
            }
        }
        try {
            this.wsl.onWebsocketClose(this, n2, string, bl2);
        }
        catch (RuntimeException runtimeException) {
            this.wsl.onWebsocketError(this, runtimeException);
        }
        if (this.draft != null) {
            this.draft.reset();
        }
        this.handshakerequest = null;
        this.readyState = ReadyState.CLOSED;
    }

    protected void closeConnection(int n2, boolean bl2) {
        this.closeConnection(n2, "", bl2);
    }

    public void closeConnection() {
        if (this.closedremotely == null) {
            throw new IllegalStateException("this method must be used in conjunction with flushAndClose");
        }
        this.closeConnection(this.closecode, this.closemessage, this.closedremotely);
    }

    @Override
    public void closeConnection(int n2, String string) {
        this.closeConnection(n2, string, false);
    }

    public synchronized void flushAndClose(int n2, String string, boolean bl2) {
        if (this.flushandclosestate) {
            return;
        }
        this.closecode = n2;
        this.closemessage = string;
        this.closedremotely = bl2;
        this.flushandclosestate = true;
        this.wsl.onWriteDemand(this);
        try {
            this.wsl.onWebsocketClosing(this, n2, string, bl2);
        }
        catch (RuntimeException runtimeException) {
            this.log.error("Exception in onWebsocketClosing", runtimeException);
            this.wsl.onWebsocketError(this, runtimeException);
        }
        if (this.draft != null) {
            this.draft.reset();
        }
        this.handshakerequest = null;
    }

    public void eot() {
        if (this.readyState == ReadyState.NOT_YET_CONNECTED) {
            this.closeConnection(-1, true);
        } else if (this.flushandclosestate) {
            this.closeConnection(this.closecode, this.closemessage, this.closedremotely);
        } else if (this.draft.getCloseHandshakeType() == CloseHandshakeType.NONE) {
            this.closeConnection(1000, true);
        } else if (this.draft.getCloseHandshakeType() == CloseHandshakeType.ONEWAY) {
            if (this.role == Role.SERVER) {
                this.closeConnection(1006, true);
            } else {
                this.closeConnection(1000, true);
            }
        } else {
            this.closeConnection(1006, true);
        }
    }

    @Override
    public void close(int n2) {
        this.close(n2, "", false);
    }

    public void close(InvalidDataException invalidDataException) {
        this.close(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    @Override
    public void send(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        this.send(this.draft.createFrames(string, this.role == Role.CLIENT));
    }

    @Override
    public void send(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        this.send(this.draft.createFrames(byteBuffer, this.role == Role.CLIENT));
    }

    @Override
    public void send(byte[] byArray) {
        this.send(ByteBuffer.wrap(byArray));
    }

    private void send(Collection<Framedata> collection) {
        if (!this.isOpen()) {
            throw new WebsocketNotConnectedException();
        }
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<ByteBuffer> arrayList = new ArrayList<ByteBuffer>();
        for (Framedata framedata : collection) {
            this.log.trace("send frame: {}", (Object)framedata);
            arrayList.add(this.draft.createBinaryFrame(framedata));
        }
        this.write(arrayList);
    }

    @Override
    public void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean bl2) {
        this.send(this.draft.continuousFrame(opcode, byteBuffer, bl2));
    }

    @Override
    public void sendFrame(Collection<Framedata> collection) {
        this.send(collection);
    }

    @Override
    public void sendFrame(Framedata framedata) {
        this.send(Collections.singletonList(framedata));
    }

    @Override
    public void sendPing() {
        PingFrame pingFrame = this.wsl.onPreparePing(this);
        if (pingFrame == null) {
            throw new NullPointerException("onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
        }
        this.sendFrame(pingFrame);
    }

    @Override
    public boolean hasBufferedData() {
        return !this.outQueue.isEmpty();
    }

    public void startHandshake(ClientHandshakeBuilder clientHandshakeBuilder) {
        this.handshakerequest = this.draft.postProcessHandshakeRequestAsClient(clientHandshakeBuilder);
        this.resourceDescriptor = clientHandshakeBuilder.getResourceDescriptor();
        assert (this.resourceDescriptor != null);
        try {
            this.wsl.onWebsocketHandshakeSentAsClient(this, this.handshakerequest);
        }
        catch (InvalidDataException invalidDataException) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
        catch (RuntimeException runtimeException) {
            this.log.error("Exception in startHandshake", runtimeException);
            this.wsl.onWebsocketError(this, runtimeException);
            throw new InvalidHandshakeException("rejected because of " + runtimeException);
        }
        this.write(this.draft.createHandshake(this.handshakerequest));
    }

    private void write(ByteBuffer byteBuffer) {
        this.log.trace("write({}): {}", (Object)byteBuffer.remaining(), (Object)(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())));
        this.outQueue.add(byteBuffer);
        this.wsl.onWriteDemand(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void write(List<ByteBuffer> list) {
        Object object = this.synchronizeWriteObject;
        synchronized (object) {
            for (ByteBuffer byteBuffer : list) {
                this.write(byteBuffer);
            }
        }
    }

    private void open(Handshakedata handshakedata) {
        this.log.trace("open using draft: {}", (Object)this.draft);
        this.readyState = ReadyState.OPEN;
        this.updateLastPong();
        try {
            this.wsl.onWebsocketOpen(this, handshakedata);
        }
        catch (RuntimeException runtimeException) {
            this.wsl.onWebsocketError(this, runtimeException);
        }
    }

    @Override
    public boolean isOpen() {
        return this.readyState == ReadyState.OPEN;
    }

    @Override
    public boolean isClosing() {
        return this.readyState == ReadyState.CLOSING;
    }

    @Override
    public boolean isFlushAndClose() {
        return this.flushandclosestate;
    }

    @Override
    public boolean isClosed() {
        return this.readyState == ReadyState.CLOSED;
    }

    @Override
    public ReadyState getReadyState() {
        return this.readyState;
    }

    public void setSelectionKey(SelectionKey selectionKey) {
        this.key = selectionKey;
    }

    public SelectionKey getSelectionKey() {
        return this.key;
    }

    public String toString() {
        return super.toString();
    }

    @Override
    public InetSocketAddress getRemoteSocketAddress() {
        return this.wsl.getRemoteSocketAddress(this);
    }

    @Override
    public InetSocketAddress getLocalSocketAddress() {
        return this.wsl.getLocalSocketAddress(this);
    }

    @Override
    public Draft getDraft() {
        return this.draft;
    }

    @Override
    public void close() {
        this.close(1000);
    }

    @Override
    public String getResourceDescriptor() {
        return this.resourceDescriptor;
    }

    long getLastPong() {
        return this.lastPong;
    }

    public void updateLastPong() {
        this.lastPong = System.nanoTime();
    }

    public WebSocketListener getWebSocketListener() {
        return this.wsl;
    }

    @Override
    public <T> T getAttachment() {
        return (T)this.attachment;
    }

    @Override
    public boolean hasSSLSupport() {
        return this.channel instanceof ISSLChannel;
    }

    @Override
    public SSLSession getSSLSession() {
        if (!this.hasSSLSupport()) {
            throw new IllegalArgumentException("This websocket uses ws instead of wss. No SSLSession available.");
        }
        return ((ISSLChannel)((Object)this.channel)).getSSLEngine().getSession();
    }

    @Override
    public IProtocol getProtocol() {
        if (this.draft == null) {
            return null;
        }
        if (!(this.draft instanceof Draft_6455)) {
            throw new IllegalArgumentException("This draft does not support Sec-WebSocket-Protocol");
        }
        return ((Draft_6455)this.draft).getProtocol();
    }

    @Override
    public <T> void setAttachment(T t2) {
        this.attachment = t2;
    }

    public ByteChannel getChannel() {
        return this.channel;
    }

    public void setChannel(ByteChannel byteChannel) {
        this.channel = byteChannel;
    }

    public WebSocketServer.WebSocketWorker getWorkerThread() {
        return this.workerThread;
    }

    public void setWorkerThread(WebSocketServer.WebSocketWorker webSocketWorker) {
        this.workerThread = webSocketWorker;
    }
}

