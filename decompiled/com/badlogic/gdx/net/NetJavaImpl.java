/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.net;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpStatus;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NetJavaImpl {
    private final ThreadPoolExecutor executorService;
    final ObjectMap<Net.HttpRequest, HttpURLConnection> connections;
    final ObjectMap<Net.HttpRequest, Net.HttpResponseListener> listeners;
    final ObjectMap<Net.HttpRequest, Future<?>> tasks;

    public NetJavaImpl() {
        this(Integer.MAX_VALUE);
    }

    public NetJavaImpl(int n2) {
        boolean bl2 = n2 == Integer.MAX_VALUE;
        this.executorService = new ThreadPoolExecutor(bl2 ? 0 : n2, n2, 60L, TimeUnit.SECONDS, (BlockingQueue<Runnable>)((BlockingQueue)((Object)(bl2 ? new SynchronousQueue() : new LinkedBlockingQueue()))), new ThreadFactory(){
            AtomicInteger threadID = new AtomicInteger();

            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "NetThread" + this.threadID.getAndIncrement());
                thread.setDaemon(true);
                return thread;
            }
        });
        this.executorService.allowCoreThreadTimeOut(!bl2);
        this.connections = new ObjectMap();
        this.listeners = new ObjectMap();
        this.tasks = new ObjectMap();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sendHttpRequest(final Net.HttpRequest httpRequest, Net.HttpResponseListener httpResponseListener) {
        if (httpRequest.getUrl() == null) {
            httpResponseListener.failed(new GdxRuntimeException("can't process a HTTP request without URL set"));
            return;
        }
        try {
            URL uRL;
            Object object;
            boolean bl2;
            String string = httpRequest.getMethod();
            boolean bl3 = !string.equalsIgnoreCase("HEAD");
            boolean bl4 = bl2 = string.equalsIgnoreCase("POST") || string.equalsIgnoreCase("PUT") || string.equalsIgnoreCase("PATCH");
            if (string.equalsIgnoreCase("GET") || string.equalsIgnoreCase("HEAD")) {
                object = "";
                String string2 = httpRequest.getContent();
                if (string2 != null && !"".equals(string2)) {
                    object = "?" + (String)string2;
                }
                uRL = new URL(httpRequest.getUrl() + (String)object);
            } else {
                uRL = new URL(httpRequest.getUrl());
            }
            object = (HttpURLConnection)uRL.openConnection();
            ((URLConnection)object).setDoOutput(bl2);
            ((URLConnection)object).setDoInput(bl3);
            ((HttpURLConnection)object).setRequestMethod(string);
            HttpURLConnection.setFollowRedirects(httpRequest.getFollowRedirects());
            this.putIntoConnectionsAndListeners(httpRequest, httpResponseListener, (HttpURLConnection)object);
            for (Map.Entry entry : httpRequest.getHeaders().entrySet()) {
                ((URLConnection)object).addRequestProperty((String)entry.getKey(), (String)entry.getValue());
            }
            ((URLConnection)object).setConnectTimeout(httpRequest.getTimeOut());
            ((URLConnection)object).setReadTimeout(httpRequest.getTimeOut());
            this.tasks.put(httpRequest, this.executorService.submit(new Runnable((HttpURLConnection)object, httpResponseListener){
                final /* synthetic */ HttpURLConnection val$connection;
                final /* synthetic */ Net.HttpResponseListener val$httpResponseListener;
                {
                    this.val$connection = httpURLConnection;
                    this.val$httpResponseListener = httpResponseListener;
                }

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void run() {
                    try {
                        Object object;
                        Object object2;
                        if (bl2) {
                            object2 = httpRequest.getContent();
                            if (object2 != null) {
                                object = new OutputStreamWriter(this.val$connection.getOutputStream(), "UTF8");
                                try {
                                    ((Writer)object).write((String)object2);
                                }
                                finally {
                                    StreamUtils.closeQuietly((Closeable)object);
                                }
                            }
                            object = httpRequest.getContentStream();
                            if (object != null) {
                                OutputStream outputStream = this.val$connection.getOutputStream();
                                try {
                                    StreamUtils.copyStream((InputStream)object, outputStream);
                                }
                                finally {
                                    StreamUtils.closeQuietly(outputStream);
                                }
                            }
                        }
                        this.val$connection.connect();
                        object2 = new HttpClientResponse(this.val$connection);
                        try {
                            object = NetJavaImpl.this.getFromListeners(httpRequest);
                            if (object != null) {
                                object.handleHttpResponse((Net.HttpResponse)object2);
                            }
                            NetJavaImpl.this.removeFromConnectionsAndListeners(httpRequest);
                        }
                        finally {
                            this.val$connection.disconnect();
                        }
                    }
                    catch (Exception exception) {
                        this.val$connection.disconnect();
                        try {
                            this.val$httpResponseListener.failed(exception);
                        }
                        finally {
                            NetJavaImpl.this.removeFromConnectionsAndListeners(httpRequest);
                        }
                    }
                }
            }));
        }
        catch (Exception exception) {
            try {
                httpResponseListener.failed(exception);
            }
            finally {
                this.removeFromConnectionsAndListeners(httpRequest);
            }
            return;
        }
    }

    public void cancelHttpRequest(Net.HttpRequest httpRequest) {
        Net.HttpResponseListener httpResponseListener = this.getFromListeners(httpRequest);
        if (httpResponseListener != null) {
            httpResponseListener.cancelled();
            this.cancelTask(httpRequest);
            this.removeFromConnectionsAndListeners(httpRequest);
        }
    }

    private void cancelTask(Net.HttpRequest httpRequest) {
        Future<?> future = this.tasks.get(httpRequest);
        if (future != null) {
            future.cancel(false);
        }
    }

    synchronized void removeFromConnectionsAndListeners(Net.HttpRequest httpRequest) {
        this.connections.remove(httpRequest);
        this.listeners.remove(httpRequest);
        this.tasks.remove(httpRequest);
    }

    synchronized void putIntoConnectionsAndListeners(Net.HttpRequest httpRequest, Net.HttpResponseListener httpResponseListener, HttpURLConnection httpURLConnection) {
        this.connections.put(httpRequest, httpURLConnection);
        this.listeners.put(httpRequest, httpResponseListener);
    }

    synchronized Net.HttpResponseListener getFromListeners(Net.HttpRequest httpRequest) {
        Net.HttpResponseListener httpResponseListener = this.listeners.get(httpRequest);
        return httpResponseListener;
    }

    static class HttpClientResponse
    implements Net.HttpResponse {
        private final HttpURLConnection connection;
        private HttpStatus status;

        public HttpClientResponse(HttpURLConnection httpURLConnection) {
            this.connection = httpURLConnection;
            try {
                this.status = new HttpStatus(httpURLConnection.getResponseCode());
            }
            catch (IOException iOException) {
                this.status = new HttpStatus(-1);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public byte[] getResult() {
            InputStream inputStream = this.getInputStream();
            if (inputStream == null) {
                return StreamUtils.EMPTY_BYTES;
            }
            try {
                byte[] byArray = StreamUtils.copyStreamToByteArray(inputStream, this.connection.getContentLength());
                return byArray;
            }
            catch (IOException iOException) {
                byte[] byArray = StreamUtils.EMPTY_BYTES;
                return byArray;
            }
            finally {
                StreamUtils.closeQuietly(inputStream);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public String getResultAsString() {
            InputStream inputStream = this.getInputStream();
            if (inputStream == null) {
                return "";
            }
            try {
                String string = StreamUtils.copyStreamToString(inputStream, this.connection.getContentLength(), "UTF8");
                return string;
            }
            catch (IOException iOException) {
                String string = "";
                return string;
            }
            finally {
                StreamUtils.closeQuietly(inputStream);
            }
        }

        @Override
        public InputStream getResultAsStream() {
            return this.getInputStream();
        }

        @Override
        public HttpStatus getStatus() {
            return this.status;
        }

        @Override
        public String getHeader(String string) {
            return this.connection.getHeaderField(string);
        }

        @Override
        public Map<String, List<String>> getHeaders() {
            return this.connection.getHeaderFields();
        }

        private InputStream getInputStream() {
            try {
                return this.connection.getInputStream();
            }
            catch (IOException iOException) {
                return this.connection.getErrorStream();
            }
        }
    }
}

