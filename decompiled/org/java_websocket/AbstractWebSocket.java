/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.util.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractWebSocket
extends WebSocketAdapter {
    private final Logger log = LoggerFactory.getLogger(AbstractWebSocket.class);
    private boolean tcpNoDelay;
    private boolean reuseAddr;
    private ScheduledExecutorService connectionLostCheckerService;
    private ScheduledFuture<?> connectionLostCheckerFuture;
    private long connectionLostTimeout = TimeUnit.SECONDS.toNanos(60L);
    private boolean websocketRunning = false;
    private final Object syncConnectionLost = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getConnectionLostTimeout() {
        Object object = this.syncConnectionLost;
        synchronized (object) {
            return (int)TimeUnit.NANOSECONDS.toSeconds(this.connectionLostTimeout);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setConnectionLostTimeout(int n2) {
        Object object = this.syncConnectionLost;
        synchronized (object) {
            this.connectionLostTimeout = TimeUnit.SECONDS.toNanos(n2);
            if (this.connectionLostTimeout <= 0L) {
                this.log.trace("Connection lost timer stopped");
                this.cancelConnectionLostTimer();
                return;
            }
            if (this.websocketRunning) {
                this.log.trace("Connection lost timer restarted");
                try {
                    ArrayList<WebSocket> arrayList = new ArrayList<WebSocket>(this.getConnections());
                    for (WebSocket webSocket : arrayList) {
                        if (!(webSocket instanceof WebSocketImpl)) continue;
                        WebSocketImpl webSocketImpl = (WebSocketImpl)webSocket;
                        webSocketImpl.updateLastPong();
                    }
                }
                catch (Exception exception) {
                    this.log.error("Exception during connection lost restart", exception);
                }
                this.restartConnectionLostTimer();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void stopConnectionLostTimer() {
        Object object = this.syncConnectionLost;
        synchronized (object) {
            if (this.connectionLostCheckerService != null || this.connectionLostCheckerFuture != null) {
                this.websocketRunning = false;
                this.log.trace("Connection lost timer stopped");
                this.cancelConnectionLostTimer();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void startConnectionLostTimer() {
        Object object = this.syncConnectionLost;
        synchronized (object) {
            if (this.connectionLostTimeout <= 0L) {
                this.log.trace("Connection lost timer deactivated");
                return;
            }
            this.log.trace("Connection lost timer started");
            this.websocketRunning = true;
            this.restartConnectionLostTimer();
        }
    }

    private void restartConnectionLostTimer() {
        this.cancelConnectionLostTimer();
        this.connectionLostCheckerService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("connectionLostChecker"));
        bxq bxq2 = new bxq(this);
        this.connectionLostCheckerFuture = this.connectionLostCheckerService.scheduleAtFixedRate(bxq2, this.connectionLostTimeout, this.connectionLostTimeout, TimeUnit.NANOSECONDS);
    }

    private void executeConnectionLostDetection(WebSocket webSocket, long l2) {
        if (!(webSocket instanceof WebSocketImpl)) {
            return;
        }
        WebSocketImpl webSocketImpl = (WebSocketImpl)webSocket;
        if (webSocketImpl.getLastPong() < l2) {
            this.log.trace("Closing connection due to no pong received: {}", (Object)webSocketImpl);
            webSocketImpl.closeConnection(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
        } else if (webSocketImpl.isOpen()) {
            webSocketImpl.sendPing();
        } else {
            this.log.trace("Trying to ping a non open connection: {}", (Object)webSocketImpl);
        }
    }

    public abstract Collection<WebSocket> getConnections();

    private void cancelConnectionLostTimer() {
        if (this.connectionLostCheckerService != null) {
            this.connectionLostCheckerService.shutdownNow();
            this.connectionLostCheckerService = null;
        }
        if (this.connectionLostCheckerFuture != null) {
            this.connectionLostCheckerFuture.cancel(false);
            this.connectionLostCheckerFuture = null;
        }
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public void setTcpNoDelay(boolean bl2) {
        this.tcpNoDelay = bl2;
    }

    public boolean isReuseAddr() {
        return this.reuseAddr;
    }

    public void setReuseAddr(boolean bl2) {
        this.reuseAddr = bl2;
    }

    public static /* synthetic */ Object access$000(AbstractWebSocket abstractWebSocket) {
        return abstractWebSocket.syncConnectionLost;
    }

    public static /* synthetic */ long access$100(AbstractWebSocket abstractWebSocket) {
        return abstractWebSocket.connectionLostTimeout;
    }

    public static /* synthetic */ void access$200(AbstractWebSocket abstractWebSocket, WebSocket webSocket, long l2) {
        abstractWebSocket.executeConnectionLostDetection(webSocket, l2);
    }
}

