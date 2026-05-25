/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.net;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpParametersUtils;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Pools;
import java.io.InputStream;
import java.util.Map;

public class HttpRequestBuilder {
    public static String baseUrl = "";
    public static int defaultTimeout = 1000;
    public static Json json = new Json();
    private Net.HttpRequest httpRequest;

    public HttpRequestBuilder newRequest() {
        if (this.httpRequest != null) {
            throw new IllegalStateException("A new request has already been started. Call HttpRequestBuilder.build() first.");
        }
        this.httpRequest = Pools.obtain(Net.HttpRequest.class);
        this.httpRequest.setTimeOut(defaultTimeout);
        return this;
    }

    public HttpRequestBuilder method(String string) {
        this.validate();
        this.httpRequest.setMethod(string);
        return this;
    }

    public HttpRequestBuilder url(String string) {
        this.validate();
        this.httpRequest.setUrl(baseUrl + string);
        return this;
    }

    public HttpRequestBuilder timeout(int n2) {
        this.validate();
        this.httpRequest.setTimeOut(n2);
        return this;
    }

    public HttpRequestBuilder followRedirects(boolean bl2) {
        this.validate();
        this.httpRequest.setFollowRedirects(bl2);
        return this;
    }

    public HttpRequestBuilder includeCredentials(boolean bl2) {
        this.validate();
        this.httpRequest.setIncludeCredentials(bl2);
        return this;
    }

    public HttpRequestBuilder header(String string, String string2) {
        this.validate();
        this.httpRequest.setHeader(string, string2);
        return this;
    }

    public HttpRequestBuilder content(String string) {
        this.validate();
        this.httpRequest.setContent(string);
        return this;
    }

    public HttpRequestBuilder content(InputStream inputStream, long l2) {
        this.validate();
        this.httpRequest.setContent(inputStream, l2);
        return this;
    }

    public HttpRequestBuilder formEncodedContent(Map<String, String> map) {
        this.validate();
        this.httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
        String string = HttpParametersUtils.convertHttpParameters(map);
        this.httpRequest.setContent(string);
        return this;
    }

    public HttpRequestBuilder jsonContent(Object object) {
        this.validate();
        this.httpRequest.setHeader("Content-Type", "application/json");
        String string = json.toJson(object);
        this.httpRequest.setContent(string);
        return this;
    }

    public HttpRequestBuilder basicAuthentication(String string, String string2) {
        this.validate();
        this.httpRequest.setHeader("Authorization", "Basic " + Base64Coder.encodeString(string + ":" + string2));
        return this;
    }

    public Net.HttpRequest build() {
        this.validate();
        Net.HttpRequest httpRequest = this.httpRequest;
        this.httpRequest = null;
        return httpRequest;
    }

    private void validate() {
        if (this.httpRequest == null) {
            throw new IllegalStateException("A new request has not been started yet. Call HttpRequestBuilder.newRequest() first.");
        }
    }
}

