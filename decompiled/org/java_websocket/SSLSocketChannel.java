/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import org.java_websocket.WrappedByteChannel;
import org.java_websocket.interfaces.ISSLChannel;
import org.java_websocket.util.ByteBufferUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSLSocketChannel
implements ByteChannel,
WrappedByteChannel,
ISSLChannel {
    private final Logger log = LoggerFactory.getLogger(SSLSocketChannel.class);
    private final SocketChannel socketChannel;
    private final SSLEngine engine;
    private ByteBuffer myAppData;
    private ByteBuffer myNetData;
    private ByteBuffer peerAppData;
    private ByteBuffer peerNetData;
    private ExecutorService executor;

    public SSLSocketChannel(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) {
        if (socketChannel == null || sSLEngine == null || this.executor == executorService) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.socketChannel = socketChannel;
        this.engine = sSLEngine;
        this.executor = executorService;
        this.myNetData = ByteBuffer.allocate(this.engine.getSession().getPacketBufferSize());
        this.peerNetData = ByteBuffer.allocate(this.engine.getSession().getPacketBufferSize());
        this.engine.beginHandshake();
        if (this.doHandshake()) {
            if (selectionKey != null) {
                selectionKey.interestOps(selectionKey.interestOps() | 4);
            }
        } else {
            try {
                this.socketChannel.close();
            }
            catch (IOException iOException) {
                this.log.error("Exception during the closing of the channel", iOException);
            }
        }
    }

    @Override
    public synchronized int read(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.peerAppData.hasRemaining()) {
            this.peerAppData.flip();
            return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
        }
        this.peerNetData.compact();
        int n2 = this.socketChannel.read(this.peerNetData);
        if (n2 > 0 || this.peerNetData.hasRemaining()) {
            this.peerNetData.flip();
            if (this.peerNetData.hasRemaining()) {
                SSLEngineResult sSLEngineResult;
                this.peerAppData.compact();
                try {
                    sSLEngineResult = this.engine.unwrap(this.peerNetData, this.peerAppData);
                }
                catch (SSLException sSLException) {
                    this.log.error("SSLException during unwrap", sSLException);
                    throw sSLException;
                }
                switch (sSLEngineResult.getStatus()) {
                    case OK: {
                        this.peerAppData.flip();
                        return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
                    }
                    case BUFFER_UNDERFLOW: {
                        this.peerAppData.flip();
                        return ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
                    }
                    case BUFFER_OVERFLOW: {
                        this.peerAppData = this.enlargeApplicationBuffer(this.peerAppData);
                        return this.read(byteBuffer);
                    }
                    case CLOSED: {
                        this.closeConnection();
                        byteBuffer.clear();
                        return -1;
                    }
                }
                throw new IllegalStateException("Invalid SSL status: " + (Object)((Object)sSLEngineResult.getStatus()));
            }
        } else if (n2 < 0) {
            this.handleEndOfStream();
        }
        ByteBufferUtils.transferByteBuffer(this.peerAppData, byteBuffer);
        return n2;
    }

    @Override
    public synchronized int write(ByteBuffer byteBuffer) {
        int n2 = 0;
        block6: while (byteBuffer.hasRemaining()) {
            this.myNetData.clear();
            SSLEngineResult sSLEngineResult = this.engine.wrap(byteBuffer, this.myNetData);
            switch (sSLEngineResult.getStatus()) {
                case OK: {
                    this.myNetData.flip();
                    while (this.myNetData.hasRemaining()) {
                        n2 += this.socketChannel.write(this.myNetData);
                    }
                    continue block6;
                }
                case BUFFER_OVERFLOW: {
                    this.myNetData = this.enlargePacketBuffer(this.myNetData);
                    continue block6;
                }
                case BUFFER_UNDERFLOW: {
                    throw new SSLException("Buffer underflow occurred after a wrap. I don't think we should ever get here.");
                }
                case CLOSED: {
                    this.closeConnection();
                    return 0;
                }
            }
            throw new IllegalStateException("Invalid SSL status: " + (Object)((Object)sSLEngineResult.getStatus()));
        }
        return n2;
    }

    private boolean doHandshake() {
        int n2 = this.engine.getSession().getApplicationBufferSize();
        this.myAppData = ByteBuffer.allocate(n2);
        this.peerAppData = ByteBuffer.allocate(n2);
        this.myNetData.clear();
        this.peerNetData.clear();
        SSLEngineResult.HandshakeStatus handshakeStatus = this.engine.getHandshakeStatus();
        boolean bl2 = false;
        block27: while (!bl2) {
            switch (handshakeStatus) {
                case FINISHED: {
                    boolean bl3 = bl2 = !this.peerNetData.hasRemaining();
                    if (bl2) {
                        return true;
                    }
                    this.socketChannel.write(this.peerNetData);
                    continue block27;
                }
                case NEED_UNWRAP: {
                    SSLEngineResult sSLEngineResult;
                    if (this.socketChannel.read(this.peerNetData) < 0) {
                        if (this.engine.isInboundDone() && this.engine.isOutboundDone()) {
                            return false;
                        }
                        try {
                            this.engine.closeInbound();
                        }
                        catch (SSLException sSLException) {
                            // empty catch block
                        }
                        this.engine.closeOutbound();
                        handshakeStatus = this.engine.getHandshakeStatus();
                        continue block27;
                    }
                    this.peerNetData.flip();
                    try {
                        sSLEngineResult = this.engine.unwrap(this.peerNetData, this.peerAppData);
                        this.peerNetData.compact();
                        handshakeStatus = sSLEngineResult.getHandshakeStatus();
                    }
                    catch (SSLException sSLException) {
                        this.engine.closeOutbound();
                        handshakeStatus = this.engine.getHandshakeStatus();
                        continue block27;
                    }
                    switch (sSLEngineResult.getStatus()) {
                        case OK: {
                            continue block27;
                        }
                        case BUFFER_OVERFLOW: {
                            this.peerAppData = this.enlargeApplicationBuffer(this.peerAppData);
                            continue block27;
                        }
                        case BUFFER_UNDERFLOW: {
                            this.peerNetData = this.handleBufferUnderflow(this.peerNetData);
                            continue block27;
                        }
                        case CLOSED: {
                            if (this.engine.isOutboundDone()) {
                                return false;
                            }
                            this.engine.closeOutbound();
                            handshakeStatus = this.engine.getHandshakeStatus();
                            continue block27;
                        }
                    }
                    throw new IllegalStateException("Invalid SSL status: " + (Object)((Object)sSLEngineResult.getStatus()));
                }
                case NEED_WRAP: {
                    SSLEngineResult sSLEngineResult;
                    this.myNetData.clear();
                    try {
                        sSLEngineResult = this.engine.wrap(this.myAppData, this.myNetData);
                        handshakeStatus = sSLEngineResult.getHandshakeStatus();
                    }
                    catch (SSLException sSLException) {
                        this.engine.closeOutbound();
                        handshakeStatus = this.engine.getHandshakeStatus();
                        continue block27;
                    }
                    switch (sSLEngineResult.getStatus()) {
                        case OK: {
                            this.myNetData.flip();
                            while (this.myNetData.hasRemaining()) {
                                this.socketChannel.write(this.myNetData);
                            }
                            continue block27;
                        }
                        case BUFFER_OVERFLOW: {
                            this.myNetData = this.enlargePacketBuffer(this.myNetData);
                            continue block27;
                        }
                        case BUFFER_UNDERFLOW: {
                            throw new SSLException("Buffer underflow occurred after a wrap. I don't think we should ever get here.");
                        }
                        case CLOSED: {
                            try {
                                this.myNetData.flip();
                                while (this.myNetData.hasRemaining()) {
                                    this.socketChannel.write(this.myNetData);
                                }
                                this.peerNetData.clear();
                            }
                            catch (Exception exception) {
                                handshakeStatus = this.engine.getHandshakeStatus();
                            }
                            continue block27;
                        }
                    }
                    throw new IllegalStateException("Invalid SSL status: " + (Object)((Object)sSLEngineResult.getStatus()));
                }
                case NEED_TASK: {
                    Runnable runnable;
                    while ((runnable = this.engine.getDelegatedTask()) != null) {
                        this.executor.execute(runnable);
                    }
                    handshakeStatus = this.engine.getHandshakeStatus();
                    continue block27;
                }
                case NOT_HANDSHAKING: {
                    continue block27;
                }
            }
            throw new IllegalStateException("Invalid SSL status: " + (Object)((Object)handshakeStatus));
        }
        return true;
    }

    private ByteBuffer enlargePacketBuffer(ByteBuffer byteBuffer) {
        return this.enlargeBuffer(byteBuffer, this.engine.getSession().getPacketBufferSize());
    }

    private ByteBuffer enlargeApplicationBuffer(ByteBuffer byteBuffer) {
        return this.enlargeBuffer(byteBuffer, this.engine.getSession().getApplicationBufferSize());
    }

    private ByteBuffer enlargeBuffer(ByteBuffer byteBuffer, int n2) {
        byteBuffer = n2 > byteBuffer.capacity() ? ByteBuffer.allocate(n2) : ByteBuffer.allocate(byteBuffer.capacity() * 2);
        return byteBuffer;
    }

    private ByteBuffer handleBufferUnderflow(ByteBuffer byteBuffer) {
        if (this.engine.getSession().getPacketBufferSize() < byteBuffer.limit()) {
            return byteBuffer;
        }
        ByteBuffer byteBuffer2 = this.enlargePacketBuffer(byteBuffer);
        byteBuffer.flip();
        byteBuffer2.put(byteBuffer);
        return byteBuffer2;
    }

    private void closeConnection() {
        this.engine.closeOutbound();
        try {
            this.doHandshake();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this.socketChannel.close();
    }

    private void handleEndOfStream() {
        try {
            this.engine.closeInbound();
        }
        catch (Exception exception) {
            this.log.error("This engine was forced to close inbound, without having received the proper SSL/TLS close notification message from the peer, due to end of stream.");
        }
        this.closeConnection();
    }

    @Override
    public boolean isNeedWrite() {
        return false;
    }

    @Override
    public void writeMore() {
    }

    @Override
    public boolean isNeedRead() {
        return this.peerNetData.hasRemaining() || this.peerAppData.hasRemaining();
    }

    @Override
    public int readMore(ByteBuffer byteBuffer) {
        return this.read(byteBuffer);
    }

    @Override
    public boolean isBlocking() {
        return this.socketChannel.isBlocking();
    }

    @Override
    public boolean isOpen() {
        return this.socketChannel.isOpen();
    }

    @Override
    public void close() {
        this.closeConnection();
    }

    @Override
    public SSLEngine getSSLEngine() {
        return this.engine;
    }
}

