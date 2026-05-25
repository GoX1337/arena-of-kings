/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.net.HttpStatus;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Net {
    public void sendHttpRequest(HttpRequest var1, @Null HttpResponseListener var2);

    public void cancelHttpRequest(HttpRequest var1);

    public ServerSocket newServerSocket(Protocol var1, String var2, int var3, ServerSocketHints var4);

    public ServerSocket newServerSocket(Protocol var1, int var2, ServerSocketHints var3);

    public Socket newClientSocket(Protocol var1, String var2, int var3, SocketHints var4);

    public boolean openURI(String var1);

    public static enum Protocol {
        TCP;

    }

    public static interface HttpResponseListener {
        public void handleHttpResponse(HttpResponse var1);

        public void failed(Throwable var1);

        public void cancelled();
    }

    public static class HttpRequest
    implements Pool.Poolable {
        private String httpMethod;
        private String url;
        private Map<String, String> headers = new HashMap<String, String>();
        private int timeOut = 0;
        private String content;
        private InputStream contentStream;
        private long contentLength;
        private boolean followRedirects = true;
        private boolean includeCredentials = false;

        public HttpRequest() {
        }

        public HttpRequest(String string) {
            this();
            this.httpMethod = string;
        }

        public void setUrl(String string) {
            this.url = string;
        }

        public void setHeader(String string, String string2) {
            this.headers.put(string, string2);
        }

        public void setContent(String string) {
            this.content = string;
        }

        public void setContent(InputStream inputStream, long l2) {
            this.contentStream = inputStream;
            this.contentLength = l2;
        }

        public void setTimeOut(int n2) {
            this.timeOut = n2;
        }

        public void setFollowRedirects(boolean bl2) {
            if (!bl2 && Gdx.app.getType() == Application.ApplicationType.WebGL) {
                throw new IllegalArgumentException("Following redirects can't be disabled using the GWT/WebGL backend!");
            }
            this.followRedirects = bl2;
        }

        public void setIncludeCredentials(boolean bl2) {
            this.includeCredentials = bl2;
        }

        public void setMethod(String string) {
            this.httpMethod = string;
        }

        public int getTimeOut() {
            return this.timeOut;
        }

        public String getMethod() {
            return this.httpMethod;
        }

        public String getUrl() {
            return this.url;
        }

        public String getContent() {
            return this.content;
        }

        public InputStream getContentStream() {
            return this.contentStream;
        }

        public long getContentLength() {
            return this.contentLength;
        }

        public Map<String, String> getHeaders() {
            return this.headers;
        }

        public boolean getFollowRedirects() {
            return this.followRedirects;
        }

        public boolean getIncludeCredentials() {
            return this.includeCredentials;
        }

        @Override
        public void reset() {
            this.httpMethod = null;
            this.url = null;
            this.headers.clear();
            this.timeOut = 0;
            this.content = null;
            this.contentStream = null;
            this.contentLength = 0L;
            this.followRedirects = true;
        }
    }

    public static interface HttpMethods {
        public static final String HEAD = "HEAD";
        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String PATCH = "PATCH";
        public static final String DELETE = "DELETE";
    }

    public static interface HttpResponse {
        public byte[] getResult();

        public String getResultAsString();

        public InputStream getResultAsStream();

        public HttpStatus getStatus();

        public String getHeader(String var1);

        public Map<String, List<String>> getHeaders();
    }
}

