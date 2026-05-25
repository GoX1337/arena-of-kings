/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamScreenshotHandle;
import com.codedisaster.steamworks.SteamScreenshotsCallback;
import com.codedisaster.steamworks.SteamScreenshotsCallbackAdapter;
import java.nio.ByteBuffer;

public class SteamScreenshots
extends SteamInterface {
    public SteamScreenshots(SteamScreenshotsCallback steamScreenshotsCallback) {
        super(SteamAPI.getSteamScreenshotsPointer(), SteamScreenshots.createCallback(new SteamScreenshotsCallbackAdapter(steamScreenshotsCallback)));
    }

    public SteamScreenshotHandle writeScreenshot(ByteBuffer byteBuffer, int n2, int n3) {
        return new SteamScreenshotHandle(SteamScreenshots.writeScreenshot(this.pointer, byteBuffer, byteBuffer.remaining(), n2, n3));
    }

    public SteamScreenshotHandle addScreenshotToLibrary(String string, String string2, int n2, int n3) {
        return new SteamScreenshotHandle(SteamScreenshots.addScreenshotToLibrary(this.pointer, string, string2, n2, n3));
    }

    public void triggerScreenshot() {
        SteamScreenshots.triggerScreenshot(this.pointer);
    }

    public void hookScreenshots(boolean bl2) {
        SteamScreenshots.hookScreenshots(this.pointer, bl2);
    }

    public boolean setLocation(SteamScreenshotHandle steamScreenshotHandle, String string) {
        return SteamScreenshots.setLocation(this.pointer, steamScreenshotHandle.handle, string);
    }

    public boolean tagUser(SteamScreenshotHandle steamScreenshotHandle, SteamID steamID) {
        return SteamScreenshots.tagUser(this.pointer, steamScreenshotHandle.handle, steamID.handle);
    }

    public boolean tagPublishedFile(SteamScreenshotHandle steamScreenshotHandle, SteamPublishedFileID steamPublishedFileID) {
        return SteamScreenshots.tagPublishedFile(this.pointer, steamScreenshotHandle.handle, steamPublishedFileID.handle);
    }

    public boolean isScreenshotsHooked() {
        return SteamScreenshots.isScreenshotsHooked(this.pointer);
    }

    private static native long createCallback(SteamScreenshotsCallbackAdapter var0);

    private static native int writeScreenshot(long var0, ByteBuffer var2, int var3, int var4, int var5);

    private static native int addScreenshotToLibrary(long var0, String var2, String var3, int var4, int var5);

    private static native void triggerScreenshot(long var0);

    private static native void hookScreenshots(long var0, boolean var2);

    private static native boolean setLocation(long var0, int var2, String var3);

    private static native boolean tagUser(long var0, int var2, long var3);

    private static native boolean tagPublishedFile(long var0, int var2, long var3);

    private static native boolean isScreenshotsHooked(long var0);
}

