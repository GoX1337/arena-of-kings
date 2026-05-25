/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.JavaScriptObject
 */
package net.zschech.gwt.websockets.client;

import com.google.gwt.core.client.JavaScriptObject;
import net.zschech.gwt.websockets.client.CloseHandler;
import net.zschech.gwt.websockets.client.ErrorHandler;
import net.zschech.gwt.websockets.client.MessageHandler;
import net.zschech.gwt.websockets.client.OpenHandler;

public class WebSocket
extends JavaScriptObject {
    public static final int CONNECTING = 0;
    public static final int OPEN = 1;
    public static final int CLOSED = 2;

    public static native WebSocket create(String var0);

    public static native WebSocket create(String var0, String var1);

    protected WebSocket() {
    }

    public final native int getReadyState();

    public final native int getBufferedAmount();

    public final native void send(String var1);

    public final native void close();

    public final native void setOnOpen(OpenHandler var1);

    public final native void setOnClose(CloseHandler var1);

    public final native void setOnError(ErrorHandler var1);

    public final native void setOnMessage(MessageHandler var1);
}

