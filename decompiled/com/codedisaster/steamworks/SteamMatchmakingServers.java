/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamMatchmakingGameServerItem;
import com.codedisaster.steamworks.SteamMatchmakingKeyValuePair;
import com.codedisaster.steamworks.SteamMatchmakingPingResponse;
import com.codedisaster.steamworks.SteamMatchmakingPlayersResponse;
import com.codedisaster.steamworks.SteamMatchmakingRulesResponse;
import com.codedisaster.steamworks.SteamMatchmakingServerListResponse;
import com.codedisaster.steamworks.SteamServerListRequest;
import com.codedisaster.steamworks.SteamServerQuery;

public class SteamMatchmakingServers
extends SteamInterface {
    public SteamMatchmakingServers() {
        super(SteamAPI.getSteamMatchmakingServersPointer());
    }

    public SteamServerListRequest requestInternetServerList(int n2, SteamMatchmakingKeyValuePair[] steamMatchmakingKeyValuePairArray, SteamMatchmakingServerListResponse steamMatchmakingServerListResponse) {
        return new SteamServerListRequest(SteamMatchmakingServers.requestInternetServerList(this.pointer, n2, steamMatchmakingKeyValuePairArray, steamMatchmakingKeyValuePairArray.length, steamMatchmakingServerListResponse.callback));
    }

    public SteamServerListRequest requestLANServerList(int n2, SteamMatchmakingServerListResponse steamMatchmakingServerListResponse) {
        return new SteamServerListRequest(SteamMatchmakingServers.requestLANServerList(this.pointer, n2, steamMatchmakingServerListResponse.callback));
    }

    public SteamServerListRequest requestFriendsServerList(int n2, SteamMatchmakingKeyValuePair[] steamMatchmakingKeyValuePairArray, SteamMatchmakingServerListResponse steamMatchmakingServerListResponse) {
        return new SteamServerListRequest(SteamMatchmakingServers.requestFriendsServerList(this.pointer, n2, steamMatchmakingKeyValuePairArray, steamMatchmakingKeyValuePairArray.length, steamMatchmakingServerListResponse.callback));
    }

    public SteamServerListRequest requestFavoritesServerList(int n2, SteamMatchmakingKeyValuePair[] steamMatchmakingKeyValuePairArray, SteamMatchmakingServerListResponse steamMatchmakingServerListResponse) {
        return new SteamServerListRequest(SteamMatchmakingServers.requestFavoritesServerList(this.pointer, n2, steamMatchmakingKeyValuePairArray, steamMatchmakingKeyValuePairArray.length, steamMatchmakingServerListResponse.callback));
    }

    public SteamServerListRequest requestHistoryServerList(int n2, SteamMatchmakingKeyValuePair[] steamMatchmakingKeyValuePairArray, SteamMatchmakingServerListResponse steamMatchmakingServerListResponse) {
        return new SteamServerListRequest(SteamMatchmakingServers.requestHistoryServerList(this.pointer, n2, steamMatchmakingKeyValuePairArray, steamMatchmakingKeyValuePairArray.length, steamMatchmakingServerListResponse.callback));
    }

    public SteamServerListRequest requestSpectatorServerList(int n2, SteamMatchmakingKeyValuePair[] steamMatchmakingKeyValuePairArray, SteamMatchmakingServerListResponse steamMatchmakingServerListResponse) {
        return new SteamServerListRequest(SteamMatchmakingServers.requestSpectatorServerList(this.pointer, n2, steamMatchmakingKeyValuePairArray, steamMatchmakingKeyValuePairArray.length, steamMatchmakingServerListResponse.callback));
    }

    public void releaseRequest(SteamServerListRequest steamServerListRequest) {
        SteamMatchmakingServers.releaseRequest(this.pointer, steamServerListRequest.handle);
    }

    public boolean getServerDetails(SteamServerListRequest steamServerListRequest, int n2, SteamMatchmakingGameServerItem steamMatchmakingGameServerItem) {
        return SteamMatchmakingServers.getServerDetails(this.pointer, steamServerListRequest.handle, n2, steamMatchmakingGameServerItem);
    }

    public void cancelQuery(SteamServerListRequest steamServerListRequest) {
        SteamMatchmakingServers.cancelQuery(this.pointer, steamServerListRequest.handle);
    }

    public void refreshQuery(SteamServerListRequest steamServerListRequest) {
        SteamMatchmakingServers.refreshQuery(this.pointer, steamServerListRequest.handle);
    }

    public boolean isRefreshing(SteamServerListRequest steamServerListRequest) {
        return SteamMatchmakingServers.isRefreshing(this.pointer, steamServerListRequest.handle);
    }

    public int getServerCount(SteamServerListRequest steamServerListRequest) {
        return SteamMatchmakingServers.getServerCount(this.pointer, steamServerListRequest.handle);
    }

    public void refreshServer(SteamServerListRequest steamServerListRequest, int n2) {
        SteamMatchmakingServers.refreshServer(this.pointer, steamServerListRequest.handle, n2);
    }

    public SteamServerQuery pingServer(int n2, short s2, SteamMatchmakingPingResponse steamMatchmakingPingResponse) {
        return new SteamServerQuery(SteamMatchmakingServers.pingServer(this.pointer, n2, s2, steamMatchmakingPingResponse.callback));
    }

    public SteamServerQuery playerDetails(int n2, short s2, SteamMatchmakingPlayersResponse steamMatchmakingPlayersResponse) {
        return new SteamServerQuery(SteamMatchmakingServers.playerDetails(this.pointer, n2, s2, steamMatchmakingPlayersResponse.callback));
    }

    public SteamServerQuery serverRules(int n2, short s2, SteamMatchmakingRulesResponse steamMatchmakingRulesResponse) {
        return new SteamServerQuery(SteamMatchmakingServers.serverRules(this.pointer, n2, s2, steamMatchmakingRulesResponse.callback));
    }

    public void cancelServerQuery(SteamServerQuery steamServerQuery) {
        SteamMatchmakingServers.cancelServerQuery(this.pointer, steamServerQuery.handle);
    }

    private static native long requestInternetServerList(long var0, int var2, SteamMatchmakingKeyValuePair[] var3, int var4, long var5);

    private static native long requestLANServerList(long var0, int var2, long var3);

    private static native long requestFriendsServerList(long var0, int var2, SteamMatchmakingKeyValuePair[] var3, int var4, long var5);

    private static native long requestFavoritesServerList(long var0, int var2, SteamMatchmakingKeyValuePair[] var3, int var4, long var5);

    private static native long requestHistoryServerList(long var0, int var2, SteamMatchmakingKeyValuePair[] var3, int var4, long var5);

    private static native long requestSpectatorServerList(long var0, int var2, SteamMatchmakingKeyValuePair[] var3, int var4, long var5);

    private static native void releaseRequest(long var0, long var2);

    private static native boolean getServerDetails(long var0, long var2, int var4, SteamMatchmakingGameServerItem var5);

    private static native void cancelQuery(long var0, long var2);

    private static native void refreshQuery(long var0, long var2);

    private static native boolean isRefreshing(long var0, long var2);

    private static native int getServerCount(long var0, long var2);

    private static native void refreshServer(long var0, long var2, int var4);

    private static native int pingServer(long var0, int var2, short var3, long var4);

    private static native int playerDetails(long var0, int var2, short var3, long var4);

    private static native int serverRules(long var0, int var2, short var3, long var4);

    private static native void cancelServerQuery(long var0, int var2);
}

