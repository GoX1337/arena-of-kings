/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamAPIWarningMessageHook;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamUniverse;
import com.codedisaster.steamworks.SteamUtilsCallback;
import com.codedisaster.steamworks.SteamUtilsCallbackAdapter;
import java.nio.ByteBuffer;

public class SteamUtils
extends SteamInterface {
    private SteamUtilsCallbackAdapter callbackAdapter;

    public SteamUtils(SteamUtilsCallback steamUtilsCallback) {
        super(SteamAPI.getSteamUtilsPointer());
        this.callbackAdapter = new SteamUtilsCallbackAdapter(steamUtilsCallback);
        this.setCallback(SteamUtils.createCallback(this.callbackAdapter));
    }

    public int getSecondsSinceAppActive() {
        return SteamUtils.getSecondsSinceAppActive(this.pointer);
    }

    public int getSecondsSinceComputerActive() {
        return SteamUtils.getSecondsSinceComputerActive(this.pointer);
    }

    public SteamUniverse getConnectedUniverse() {
        return SteamUniverse.byValue(SteamUtils.getConnectedUniverse(this.pointer));
    }

    public int getServerRealTime() {
        return SteamUtils.getServerRealTime(this.pointer);
    }

    public int getImageWidth(int n2) {
        return SteamUtils.getImageWidth(this.pointer, n2);
    }

    public int getImageHeight(int n2) {
        return SteamUtils.getImageHeight(this.pointer, n2);
    }

    public boolean getImageSize(int n2, int[] nArray) {
        return SteamUtils.getImageSize(this.pointer, n2, nArray);
    }

    public boolean getImageRGBA(int n2, ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return SteamUtils.getImageRGBA(this.pointer, n2, byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public int getAppID() {
        return SteamUtils.getAppID(this.pointer);
    }

    public void setOverlayNotificationPosition(NotificationPosition notificationPosition) {
        SteamUtils.setOverlayNotificationPosition(this.pointer, notificationPosition.ordinal());
    }

    public boolean isAPICallCompleted(SteamAPICall steamAPICall, boolean[] blArray) {
        return SteamUtils.isAPICallCompleted(this.pointer, steamAPICall.handle, blArray);
    }

    public SteamAPICallFailure getAPICallFailureReason(SteamAPICall steamAPICall) {
        return SteamAPICallFailure.byValue(SteamUtils.getAPICallFailureReason(this.pointer, steamAPICall.handle));
    }

    public void setWarningMessageHook(SteamAPIWarningMessageHook steamAPIWarningMessageHook) {
        this.callbackAdapter.setWarningMessageHook(steamAPIWarningMessageHook);
        SteamUtils.enableWarningMessageHook(this.callback, steamAPIWarningMessageHook != null);
    }

    public boolean isOverlayEnabled() {
        return SteamUtils.isOverlayEnabled(this.pointer);
    }

    private static native long createCallback(SteamUtilsCallbackAdapter var0);

    private static native int getSecondsSinceAppActive(long var0);

    private static native int getSecondsSinceComputerActive(long var0);

    private static native int getConnectedUniverse(long var0);

    private static native int getServerRealTime(long var0);

    private static native String getIPCountry(long var0);

    private static native int getImageWidth(long var0, int var2);

    private static native int getImageHeight(long var0, int var2);

    private static native boolean getImageSize(long var0, int var2, int[] var3);

    private static native boolean getImageRGBA(long var0, int var2, ByteBuffer var3, int var4, int var5);

    private static native int getAppID(long var0);

    private static native void setOverlayNotificationPosition(long var0, int var2);

    private static native boolean isAPICallCompleted(long var0, long var2, boolean[] var4);

    private static native int getAPICallFailureReason(long var0, long var2);

    private static native void enableWarningMessageHook(long var0, boolean var2);

    private static native boolean isOverlayEnabled(long var0);

    public static enum NotificationPosition {
        TopLeft,
        TopRight,
        BottomLeft,
        BottomRight;

    }

    public static enum SteamAPICallFailure {
        None(-1),
        SteamGone(0),
        NetworkFailure(1),
        InvalidHandle(2),
        MismatchedCallback(3);

        private final int code;
        private static final SteamAPICallFailure[] values;

        private SteamAPICallFailure(int n3) {
            this.code = n3;
        }

        static SteamAPICallFailure byValue(int n2) {
            for (SteamAPICallFailure steamAPICallFailure : values) {
                if (steamAPICallFailure.code != n2) continue;
                return steamAPICallFailure;
            }
            return None;
        }

        static {
            values = SteamAPICallFailure.values();
        }
    }
}

