/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLSession;
import org.java_websocket.WrappedByteChannel;
import org.java_websocket.interfaces.ISSLChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSLSocketChannel2
implements ByteChannel,
WrappedByteChannel,
ISSLChannel {
    protected static ByteBuffer emptybuffer = ByteBuffer.allocate(0);
    private final Logger log = LoggerFactory.getLogger(SSLSocketChannel2.class);
    protected ExecutorService exec;
    protected List<Future<?>> tasks;
    protected ByteBuffer inData;
    protected ByteBuffer outCrypt;
    protected ByteBuffer inCrypt;
    protected SocketChannel socketChannel;
    protected SelectionKey selectionKey;
    protected SSLEngine sslEngine;
    protected SSLEngineResult readEngineResult;
    protected SSLEngineResult writeEngineResult;
    protected int bufferallocations = 0;
    private byte[] saveCryptData = null;

    public SSLSocketChannel2(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) {
        if (socketChannel == null || sSLEngine == null || executorService == null) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.socketChannel = socketChannel;
        this.sslEngine = sSLEngine;
        this.exec = executorService;
        this.readEngineResult = this.writeEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngine.getHandshakeStatus(), 0, 0);
        this.tasks = new ArrayList(3);
        if (selectionKey != null) {
            selectionKey.interestOps(selectionKey.interestOps() | 4);
            this.selectionKey = selectionKey;
        }
        this.createBuffers(sSLEngine.getSession());
        this.socketChannel.write(this.wrap(emptybuffer));
        this.processHandshake();
    }

    private void consumeFutureUninterruptible(Future<?> future) {
        try {
            while (true) {
                try {
                    future.get();
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    continue;
                }
                break;
            }
        }
        catch (ExecutionException executionException) {
            throw new RuntimeException(executionException);
        }
    }

    private synchronized void processHandshake() {
        if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return;
        }
        if (!this.tasks.isEmpty()) {
            Iterator<Future<?>> iterator = this.tasks.iterator();
            while (iterator.hasNext()) {
                Future<?> future = iterator.next();
                if (future.isDone()) {
                    iterator.remove();
                    continue;
                }
                if (this.isBlocking()) {
                    this.consumeFutureUninterruptible(future);
                }
                return;
            }
        }
        if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            if (!this.isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                this.inCrypt.compact();
                int n2 = this.socketChannel.read(this.inCrypt);
                if (n2 == -1) {
                    throw new IOException("connection closed unexpectedly by peer");
                }
                this.inCrypt.flip();
            }
            this.inData.compact();
            this.unwrap();
            if (this.readEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                this.createBuffers(this.sslEngine.getSession());
                return;
            }
        }
        this.consumeDelegatedTasks();
        if (this.tasks.isEmpty() || this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            this.socketChannel.write(this.wrap(emptybuffer));
            if (this.writeEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                this.createBuffers(this.sslEngine.getSession());
                return;
            }
        }
        assert (this.sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
        this.bufferallocations = 1;
    }

    private synchronized ByteBuffer wrap(ByteBuffer byteBuffer) {
        this.outCrypt.compact();
        this.writeEngineResult = this.sslEngine.wrap(byteBuffer, this.outCrypt);
        this.outCrypt.flip();
        return this.outCrypt;
    }

    private synchronized ByteBuffer unwrap() {
        int n2;
        if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED && this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            try {
                this.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        do {
            n2 = this.inData.remaining();
            this.readEngineResult = this.sslEngine.unwrap(this.inCrypt, this.inData);
        } while (this.readEngineResult.getStatus() == SSLEngineResult.Status.OK && (n2 != this.inData.remaining() || this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP));
        this.inData.flip();
        return this.inData;
    }

    protected void consumeDelegatedTasks() {
        Runnable runnable;
        while ((runnable = this.sslEngine.getDelegatedTask()) != null) {
            this.tasks.add(this.exec.submit(runnable));
        }
    }

    protected void createBuffers(SSLSession sSLSession) {
        this.saveCryptedData();
        int n2 = sSLSession.getPacketBufferSize();
        int n3 = Math.max(sSLSession.getApplicationBufferSize(), n2);
        if (this.inData == null) {
            this.inData = ByteBuffer.allocate(n3);
            this.outCrypt = ByteBuffer.allocate(n2);
            this.inCrypt = ByteBuffer.allocate(n2);
        } else {
            if (this.inData.capacity() != n3) {
                this.inData = ByteBuffer.allocate(n3);
            }
            if (this.outCrypt.capacity() != n2) {
                this.outCrypt = ByteBuffer.allocate(n2);
            }
            if (this.inCrypt.capacity() != n2) {
                this.inCrypt = ByteBuffer.allocate(n2);
            }
        }
        if (this.inData.remaining() != 0 && this.log.isTraceEnabled()) {
            this.log.trace(new String(this.inData.array(), this.inData.position(), this.inData.remaining()));
        }
        this.inData.rewind();
        this.inData.flip();
        if (this.inCrypt.remaining() != 0 && this.log.isTraceEnabled()) {
            this.log.trace(new String(this.inCrypt.array(), this.inCrypt.position(), this.inCrypt.remaining()));
        }
        this.inCrypt.rewind();
        this.inCrypt.flip();
        this.outCrypt.rewind();
        this.outCrypt.flip();
        ++this.bufferallocations;
    }

    @Override
    public int write(ByteBuffer byteBuffer) {
        if (!this.isHandShakeComplete()) {
            this.processHandshake();
            return 0;
        }
        int n2 = this.socketChannel.write(this.wrap(byteBuffer));
        if (this.writeEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) {
            throw new EOFException("Connection is closed");
        }
        return n2;
    }

    @Override
    public int read(ByteBuffer byteBuffer) {
        int n2;
        this.tryRestoreCryptedData();
        do {
            int n3;
            if (!byteBuffer.hasRemaining()) {
                return 0;
            }
            if (!this.isHandShakeComplete()) {
                if (this.isBlocking()) {
                    while (!this.isHandShakeComplete()) {
                        this.processHandshake();
                    }
                } else {
                    this.processHandshake();
                    if (!this.isHandShakeComplete()) {
                        return 0;
                    }
                }
            }
            if ((n3 = this.readRemaining(byteBuffer)) != 0) {
                return n3;
            }
            assert (this.inData.position() == 0);
            this.inData.clear();
            if (!this.inCrypt.hasRemaining()) {
                this.inCrypt.clear();
            } else {
                this.inCrypt.compact();
            }
            if ((this.isBlocking() || this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) && this.socketChannel.read(this.inCrypt) == -1) {
                return -1;
            }
            this.inCrypt.flip();
            this.unwrap();
            n2 = this.transfereTo(this.inData, byteBuffer);
        } while (n2 == 0 && this.isBlocking());
        return n2;
    }

    private int readRemaining(ByteBuffer byteBuffer) {
        if (this.inData.hasRemaining()) {
            return this.transfereTo(this.inData, byteBuffer);
        }
        if (!this.inData.hasRemaining()) {
            this.inData.clear();
        }
        this.tryRestoreCryptedData();
        if (this.inCrypt.hasRemaining()) {
            this.unwrap();
            int n2 = this.transfereTo(this.inData, byteBuffer);
            if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) {
                return -1;
            }
            if (n2 > 0) {
                return n2;
            }
        }
        return 0;
    }

    public boolean isConnected() {
        return this.socketChannel.isConnected();
    }

    @Override
    public void close() {
        this.sslEngine.closeOutbound();
        this.sslEngine.getSession().invalidate();
        if (this.socketChannel.isOpen()) {
            this.socketChannel.write(this.wrap(emptybuffer));
        }
        this.socketChannel.close();
    }

    private boolean isHandShakeComplete() {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.sslEngine.getHandshakeStatus();
        return handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    public SelectableChannel configureBlocking(boolean bl2) {
        return this.socketChannel.configureBlocking(bl2);
    }

    public boolean connect(SocketAddress socketAddress) {
        return this.socketChannel.connect(socketAddress);
    }

    public boolean finishConnect() {
        return this.socketChannel.finishConnect();
    }

    public Socket socket() {
        return this.socketChannel.socket();
    }

    public boolean isInboundDone() {
        return this.sslEngine.isInboundDone();
    }

    @Override
    public boolean isOpen() {
        return this.socketChannel.isOpen();
    }

    @Override
    public boolean isNeedWrite() {
        return this.outCrypt.hasRemaining() || !this.isHandShakeComplete();
    }

    @Override
    public void writeMore() {
        this.write(this.outCrypt);
    }

    @Override
    public boolean isNeedRead() {
        return this.saveCryptData != null || this.inData.hasRemaining() || this.inCrypt.hasRemaining() && this.readEngineResult.getStatus() != SSLEngineResult.Status.BUFFER_UNDERFLOW && this.readEngineResult.getStatus() != SSLEngineResult.Status.CLOSED;
    }

    @Override
    public int readMore(ByteBuffer byteBuffer) {
        return this.readRemaining(byteBuffer);
    }

    private int transfereTo(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int n2;
        int n3 = byteBuffer.remaining();
        if (n3 > (n2 = byteBuffer2.remaining())) {
            int n4 = Math.min(n3, n2);
            for (int i2 = 0; i2 < n4; ++i2) {
                byteBuffer2.put(byteBuffer.get());
            }
            return n4;
        }
        byteBuffer2.put(byteBuffer);
        return n3;
    }

    @Override
    public boolean isBlocking() {
        return this.socketChannel.isBlocking();
    }

    @Override
    public SSLEngine getSSLEngine() {
        return this.sslEngine;
    }

    private void saveCryptedData() {
        if (this.inCrypt != null && this.inCrypt.remaining() > 0) {
            int n2 = this.inCrypt.remaining();
            this.saveCryptData = new byte[n2];
            this.inCrypt.get(this.saveCryptData);
        }
    }

    private void tryRestoreCryptedData() {
        if (this.saveCryptData != null) {
            this.inCrypt.clear();
            this.inCrypt.put(this.saveCryptData);
            this.inCrypt.flip();
            this.saveCryptData = null;
        }
    }
}

