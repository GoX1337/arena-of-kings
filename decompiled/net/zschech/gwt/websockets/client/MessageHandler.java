/*
 * Decompiled with CFR 0.152.
 */
package net.zschech.gwt.websockets.client;

import net.zschech.gwt.websockets.client.MessageEvent;
import net.zschech.gwt.websockets.client.WebSocket;

public interface MessageHandler {
    public void onMessage(WebSocket var1, MessageEvent var2);
}

