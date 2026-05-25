/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamSharedLibraryLoader;
import java.io.PrintStream;

public class SteamAPI {
    private static boolean isRunning = false;
    private static boolean isNativeAPILoaded = false;

    public static void loadLibraries() {
        SteamAPI.loadLibraries(null);
    }

    public static void loadLibraries(String string) {
        if (isNativeAPILoaded) {
            return;
        }
        if (string == null && SteamSharedLibraryLoader.DEBUG) {
            String string2 = SteamSharedLibraryLoader.getSdkRedistributableBinPath();
            SteamSharedLibraryLoader.loadLibrary("steam_api", string2);
        } else {
            SteamSharedLibraryLoader.loadLibrary("steam_api", string);
        }
        SteamSharedLibraryLoader.loadLibrary("steamworks4j", string);
        isNativeAPILoaded = true;
    }

    public static boolean restartAppIfNecessary(int n2) {
        if (!isNativeAPILoaded) {
            throw new SteamException("Native libraries not loaded.\nEnsure to call SteamAPI.loadLibraries() first!");
        }
        return SteamAPI.nativeRestartAppIfNecessary(n2);
    }

    public static boolean init() {
        if (!isNativeAPILoaded) {
            throw new SteamException("Native libraries not loaded.\nEnsure to call SteamAPI.loadLibraries() first!");
        }
        isRunning = SteamAPI.nativeInit();
        return isRunning;
    }

    public static void shutdown() {
        isRunning = false;
        SteamAPI.nativeShutdown();
    }

    public static boolean isSteamRunning() {
        return SteamAPI.isSteamRunning(false);
    }

    public static boolean isSteamRunning(boolean bl2) {
        return isRunning && (!bl2 || SteamAPI.isSteamRunningNative());
    }

    public static void printDebugInfo(PrintStream printStream) {
        printStream.println("  Steam API initialized: " + isRunning);
        printStream.println("  Steam client active: " + SteamAPI.isSteamRunning());
    }

    static boolean isIsNativeAPILoaded() {
        return isNativeAPILoaded;
    }

    private static native boolean nativeRestartAppIfNecessary(int var0);

    public static native void releaseCurrentThreadMemory();

    private static native boolean nativeInit();

    private static native void nativeShutdown();

    public static native void runCallbacks();

    private static native boolean isSteamRunningNative();

    static native long getSteamAppsPointer();

    static native long getSteamControllerPointer();

    static native long getSteamFriendsPointer();

    static native long getSteamHTTPPointer();

    static native long getSteamMatchmakingPointer();

    static native long getSteamMatchmakingServersPointer();

    static native long getSteamNetworkingPointer();

    static native long getSteamRemoteStoragePointer();

    static native long getSteamScreenshotsPointer();

    static native long getSteamUGCPointer();

    static native long getSteamUserPointer();

    static native long getSteamUserStatsPointer();

    static native long getSteamUtilsPointer();
}

