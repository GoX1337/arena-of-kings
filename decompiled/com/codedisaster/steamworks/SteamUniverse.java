/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

public enum SteamUniverse {
    Invalid(0),
    Public(1),
    Beta(2),
    Internal(3),
    Dev(4);

    private final int value;
    private static final SteamUniverse[] values;

    private SteamUniverse(int n3) {
        this.value = n3;
    }

    static SteamUniverse byValue(int n2) {
        for (SteamUniverse steamUniverse : values) {
            if (steamUniverse.value != n2) continue;
            return steamUniverse;
        }
        return Invalid;
    }

    static {
        values = SteamUniverse.values();
    }
}

