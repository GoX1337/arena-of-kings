/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketListener;
import org.java_websocket.drafts.Draft;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.framing.PongFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;

public abstract class WebSocketAdapter
implements WebSocketListener {
    private PingFrame pingFrame;

    @Override
    public ServerHandshakeBuilder onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) {
        return new HandshakeImpl1Server();
    }

    @Override
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
    }

    @Override
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, ClientHandshake clientHandshake) {
    }

    @Override
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        webSocket.sendFrame(new PongFrame((PingFrame)framedata));
    }

    @Override
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
    }

    @Override
    public PingFrame onPreparePing(WebSocket webSocket) {
        if (this.pingFrame == null) {
            this.pingFrame = new PingFrame();
        }
        return this.pingFrame;
    }
}

