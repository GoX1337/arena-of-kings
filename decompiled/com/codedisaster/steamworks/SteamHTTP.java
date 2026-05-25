/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamHTTPCallback;
import com.codedisaster.steamworks.SteamHTTPCallbackAdapter;
import com.codedisaster.steamworks.SteamHTTPRequestHandle;
import com.codedisaster.steamworks.SteamInterface;
import java.nio.ByteBuffer;

public class SteamHTTP
extends SteamInterface {
    public SteamHTTP(SteamHTTPCallback steamHTTPCallback) {
        this(SteamAPI.getSteamHTTPPointer(), SteamHTTP.createCallback(new SteamHTTPCallbackAdapter(steamHTTPCallback)));
    }

    SteamHTTP(long l2, long l3) {
        super(l2, l3);
    }

    public SteamHTTPRequestHandle createHTTPRequest(HTTPMethod hTTPMethod, String string) {
        return new SteamHTTPRequestHandle(SteamHTTP.createHTTPRequest(this.pointer, hTTPMethod.ordinal(), string));
    }

    public boolean setHTTPRequestContextValue(SteamHTTPRequestHandle steamHTTPRequestHandle, long l2) {
        return SteamHTTP.setHTTPRequestContextValue(this.pointer, steamHTTPRequestHandle.handle, l2);
    }

    public boolean setHTTPRequestNetworkActivityTimeout(SteamHTTPRequestHandle steamHTTPRequestHandle, int n2) {
        return SteamHTTP.setHTTPRequestNetworkActivityTimeout(this.pointer, steamHTTPRequestHandle.handle, n2);
    }

    public boolean setHTTPRequestHeaderValue(SteamHTTPRequestHandle steamHTTPRequestHandle, String string, String string2) {
        return SteamHTTP.setHTTPRequestHeaderValue(this.pointer, steamHTTPRequestHandle.handle, string, string2);
    }

    public boolean setHTTPRequestGetOrPostParameter(SteamHTTPRequestHandle steamHTTPRequestHandle, String string, String string2) {
        return SteamHTTP.setHTTPRequestGetOrPostParameter(this.pointer, steamHTTPRequestHandle.handle, string, string2);
    }

    public SteamAPICall sendHTTPRequest(SteamHTTPRequestHandle steamHTTPRequestHandle) {
        return new SteamAPICall(SteamHTTP.sendHTTPRequest(this.pointer, this.callback, steamHTTPRequestHandle.handle));
    }

    public SteamAPICall sendHTTPRequestAndStreamResponse(SteamHTTPRequestHandle steamHTTPRequestHandle) {
        return new SteamAPICall(SteamHTTP.sendHTTPRequestAndStreamResponse(this.pointer, steamHTTPRequestHandle.handle));
    }

    public int getHTTPResponseHeaderSize(SteamHTTPRequestHandle steamHTTPRequestHandle, String string) {
        return SteamHTTP.getHTTPResponseHeaderSize(this.pointer, steamHTTPRequestHandle.handle, string);
    }

    public boolean getHTTPResponseHeaderValue(SteamHTTPRequestHandle steamHTTPRequestHandle, String string, ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return SteamHTTP.getHTTPResponseHeaderValue(this.pointer, steamHTTPRequestHandle.handle, string, byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public int getHTTPResponseBodySize(SteamHTTPRequestHandle steamHTTPRequestHandle) {
        return SteamHTTP.getHTTPResponseBodySize(this.pointer, steamHTTPRequestHandle.handle);
    }

    public boolean getHTTPResponseBodyData(SteamHTTPRequestHandle steamHTTPRequestHandle, ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return SteamHTTP.getHTTPResponseBodyData(this.pointer, steamHTTPRequestHandle.handle, byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public boolean getHTTPStreamingResponseBodyData(SteamHTTPRequestHandle steamHTTPRequestHandle, int n2, ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return SteamHTTP.getHTTPStreamingResponseBodyData(this.pointer, steamHTTPRequestHandle.handle, n2, byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public boolean releaseHTTPRequest(SteamHTTPRequestHandle steamHTTPRequestHandle) {
        return SteamHTTP.releaseHTTPRequest(this.pointer, steamHTTPRequestHandle.handle);
    }

    private static native long createCallback(SteamHTTPCallbackAdapter var0);

    private static native long createHTTPRequest(long var0, int var2, String var3);

    private static native boolean setHTTPRequestContextValue(long var0, long var2, long var4);

    private static native boolean setHTTPRequestNetworkActivityTimeout(long var0, long var2, int var4);

    private static native boolean setHTTPRequestHeaderValue(long var0, long var2, String var4, String var5);

    private static native boolean setHTTPRequestGetOrPostParameter(long var0, long var2, String var4, String var5);

    private static native long sendHTTPRequest(long var0, long var2, long var4);

    private static native long sendHTTPRequestAndStreamResponse(long var0, long var2);

    private static native int getHTTPResponseHeaderSize(long var0, long var2, String var4);

    private static native boolean getHTTPResponseHeaderValue(long var0, long var2, String var4, ByteBuffer var5, int var6, int var7);

    private static native int getHTTPResponseBodySize(long var0, long var2);

    private static native boolean getHTTPResponseBodyData(long var0, long var2, ByteBuffer var4, int var5, int var6);

    private static native boolean getHTTPStreamingResponseBodyData(long var0, long var2, int var4, ByteBuffer var5, int var6, int var7);

    private static native boolean releaseHTTPRequest(long var0, long var2);

    public static enum HTTPStatusCode {
        Invalid(0),
        Continue(100),
        SwitchingProtocols(101),
        OK(200),
        Created(201),
        Accepted(202),
        NonAuthoritative(203),
        NoContent(204),
        ResetContent(205),
        PartialContent(206),
        MultipleChoices(300),
        MovedPermanently(301),
        Found(302),
        SeeOther(303),
        NotModified(304),
        UseProxy(305),
        TemporaryRedirect(307),
        BadRequest(400),
        Unauthorized(401),
        PaymentRequired(402),
        Forbidden(403),
        NotFound(404),
        MethodNotAllowed(405),
        NotAcceptable(406),
        ProxyAuthRequired(407),
        RequestTimeout(408),
        Conflict(409),
        Gone(410),
        LengthRequired(411),
        PreconditionFailed(412),
        RequestEntityTooLarge(413),
        RequestURITooLong(414),
        UnsupportedMediaType(415),
        RequestedRangeNotSatisfiable(416),
        ExpectationFailed(417),
        Unknown4xx(418),
        TooManyRequests(429),
        InternalServerError(500),
        NotImplemented(501),
        BadGateway(502),
        ServiceUnavailable(503),
        GatewayTimeout(504),
        HTTPVersionNotSupported(505),
        Unknown5xx(599);

        private final int code;
        private static final HTTPStatusCode[] values;

        private HTTPStatusCode(int n3) {
            this.code = n3;
        }

        static HTTPStatusCode byValue(int n2) {
            for (HTTPStatusCode hTTPStatusCode : values) {
                if (hTTPStatusCode.code != n2) continue;
                return hTTPStatusCode;
            }
            return Invalid;
        }

        static {
            values = HTTPStatusCode.values();
        }
    }

    public static enum HTTPMethod {
        Invalid,
        GET,
        HEAD,
        POST,
        PUT,
        DELETE,
        OPTIONS;

    }
}

