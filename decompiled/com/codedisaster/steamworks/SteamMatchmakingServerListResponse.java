/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamServerListRequest;

public abstract class SteamMatchmakingServerListResponse
extends SteamInterface {
    protected SteamMatchmakingServerListResponse() {
        super(-1L);
        this.callback = SteamMatchmakingServerListResponse.createProxy(this);
    }

    public abstract void serverResponded(SteamServerListRequest var1, int var2);

    void serverResponded(long l2, int n2) {
        this.serverResponded(new SteamServerListRequest(l2), n2);
    }

    public abstract void serverFailedToRespond(SteamServerListRequest var1, int var2);

    void serverFailedToRespond(long l2, int n2) {
        this.serverFailedToRespond(new SteamServerListRequest(l2), n2);
    }

    public abstract void refreshComplete(SteamServerListRequest var1, Response var2);

    void refreshComplete(long l2, int n2) {
        this.refreshComplete(new SteamServerListRequest(l2), Response.byOrdinal(n2));
    }

    private static native long createProxy(SteamMatchmakingServerListResponse var0);

    public static enum Response {
        ServerResponded,
        ServerFailedToRespond,
        NoServersListedOnMasterServer;

        private static final Response[] values;

        static Response byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = Response.values();
        }
    }
}

