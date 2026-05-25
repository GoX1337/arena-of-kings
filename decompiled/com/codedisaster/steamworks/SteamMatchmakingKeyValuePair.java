/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

public class SteamMatchmakingKeyValuePair {
    private String key;
    private String value;

    public SteamMatchmakingKeyValuePair() {
    }

    public SteamMatchmakingKeyValuePair(String string, String string2) {
        this.key = string;
        this.value = string2;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}

