/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamCallbackAdapter;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamScreenshotHandle;
import com.codedisaster.steamworks.SteamScreenshotsCallback;

public class SteamScreenshotsCallbackAdapter
extends SteamCallbackAdapter<SteamScreenshotsCallback> {
    SteamScreenshotsCallbackAdapter(SteamScreenshotsCallback steamScreenshotsCallback) {
        super(steamScreenshotsCallback);
    }

    void onScreenshotReady(int n2, int n3) {
        ((SteamScreenshotsCallback)this.callback).onScreenshotReady(new SteamScreenshotHandle(n2), SteamResult.byValue(n3));
    }

    void onScreenshotRequested() {
        ((SteamScreenshotsCallback)this.callback).onScreenshotRequested();
    }
}

