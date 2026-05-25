/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.net.NetJavaImpl;
import com.badlogic.gdx.net.NetJavaServerSocketImpl;
import com.badlogic.gdx.net.NetJavaSocketImpl;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.utils.SharedLibraryLoader;
import java.awt.Desktop;
import java.net.URI;

public class Lwjgl3Net
implements Net {
    NetJavaImpl netJavaImpl;

    public Lwjgl3Net(Lwjgl3ApplicationConfiguration lwjgl3ApplicationConfiguration) {
        this.netJavaImpl = new NetJavaImpl(lwjgl3ApplicationConfiguration.maxNetThreads);
    }

    @Override
    public void sendHttpRequest(Net.HttpRequest httpRequest, Net.HttpResponseListener httpResponseListener) {
        this.netJavaImpl.sendHttpRequest(httpRequest, httpResponseListener);
    }

    @Override
    public void cancelHttpRequest(Net.HttpRequest httpRequest) {
        this.netJavaImpl.cancelHttpRequest(httpRequest);
    }

    @Override
    public ServerSocket newServerSocket(Net.Protocol protocol, String string, int n2, ServerSocketHints serverSocketHints) {
        return new NetJavaServerSocketImpl(protocol, string, n2, serverSocketHints);
    }

    @Override
    public ServerSocket newServerSocket(Net.Protocol protocol, int n2, ServerSocketHints serverSocketHints) {
        return new NetJavaServerSocketImpl(protocol, n2, serverSocketHints);
    }

    @Override
    public Socket newClientSocket(Net.Protocol protocol, String string, int n2, SocketHints socketHints) {
        return new NetJavaSocketImpl(protocol, string, n2, socketHints);
    }

    @Override
    public boolean openURI(String string) {
        if (SharedLibraryLoader.isMac) {
            try {
                new ProcessBuilder("open", new URI(string).toString()).start();
                return true;
            }
            catch (Throwable throwable) {
                return false;
            }
        }
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(string));
                return true;
            }
            catch (Throwable throwable) {
                return false;
            }
        }
        if (SharedLibraryLoader.isLinux) {
            try {
                new ProcessBuilder("xdg-open", new URI(string).toString()).start();
                return true;
            }
            catch (Throwable throwable) {
                return false;
            }
        }
        return false;
    }
}

