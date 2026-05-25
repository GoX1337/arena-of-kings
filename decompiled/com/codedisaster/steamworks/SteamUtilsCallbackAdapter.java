/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPIWarningMessageHook;
import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamUtilsCallback;

class SteamUtilsCallbackAdapter
extends SteamCallbackAdapter<SteamUtilsCallback> {
    private SteamAPIWarningMessageHook messageHook;

    SteamUtilsCallbackAdapter(SteamUtilsCallback steamUtilsCallback) {
        super(steamUtilsCallback);
    }

    void setWarningMessageHook(SteamAPIWarningMessageHook steamAPIWarningMessageHook) {
        this.messageHook = steamAPIWarningMessageHook;
    }

    void onWarningMessage(int n2, String string) {
        if (this.messageHook != null) {
            this.messageHook.onWarningMessage(n2, string);
        }
    }

    void onSteamShutdown() {
        ((SteamUtilsCallback)this.callback).onSteamShutdown();
    }
}

