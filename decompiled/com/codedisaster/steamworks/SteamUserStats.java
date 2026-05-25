/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamLeaderboardEntriesHandle;
import com.codedisaster.steamworks.SteamLeaderboardEntry;
import com.codedisaster.steamworks.SteamLeaderboardHandle;
import com.codedisaster.steamworks.SteamUserStatsCallback;
import com.codedisaster.steamworks.SteamUserStatsCallbackAdapter;

public class SteamUserStats
extends SteamInterface {
    public SteamUserStats(SteamUserStatsCallback steamUserStatsCallback) {
        super(SteamAPI.getSteamUserStatsPointer(), SteamUserStats.createCallback(new SteamUserStatsCallbackAdapter(steamUserStatsCallback)));
    }

    public boolean requestCurrentStats() {
        return SteamUserStats.requestCurrentStats(this.pointer);
    }

    public int getStatI(String string, int n2) {
        int[] nArray = new int[1];
        if (SteamUserStats.getStat(this.pointer, string, nArray)) {
            return nArray[0];
        }
        return n2;
    }

    public boolean setStatI(String string, int n2) {
        return SteamUserStats.setStat(this.pointer, string, n2);
    }

    public float getStatF(String string, float f2) {
        float[] fArray = new float[1];
        if (SteamUserStats.getStat(this.pointer, string, fArray)) {
            return fArray[0];
        }
        return f2;
    }

    public boolean setStatF(String string, float f2) {
        return SteamUserStats.setStat(this.pointer, string, f2);
    }

    public boolean isAchieved(String string, boolean bl2) {
        boolean[] blArray = new boolean[1];
        if (SteamUserStats.getAchievement(this.pointer, string, blArray)) {
            return blArray[0];
        }
        return bl2;
    }

    public boolean setAchievement(String string) {
        return SteamUserStats.setAchievement(this.pointer, string);
    }

    public boolean clearAchievement(String string) {
        return SteamUserStats.clearAchievement(this.pointer, string);
    }

    public boolean storeStats() {
        return SteamUserStats.storeStats(this.pointer);
    }

    public boolean indicateAchievementProgress(String string, int n2, int n3) {
        return SteamUserStats.indicateAchievementProgress(this.pointer, string, n2, n3);
    }

    public int getNumAchievements() {
        return SteamUserStats.getNumAchievements(this.pointer);
    }

    public String getAchievementName(int n2) {
        return SteamUserStats.getAchievementName(this.pointer, n2);
    }

    public boolean resetAllStats(boolean bl2) {
        return SteamUserStats.resetAllStats(this.pointer, bl2);
    }

    public SteamAPICall findOrCreateLeaderboard(String string, LeaderboardSortMethod leaderboardSortMethod, LeaderboardDisplayType leaderboardDisplayType) {
        return new SteamAPICall(SteamUserStats.findOrCreateLeaderboard(this.pointer, this.callback, string, leaderboardSortMethod.ordinal(), leaderboardDisplayType.ordinal()));
    }

    public SteamAPICall findLeaderboard(String string) {
        return new SteamAPICall(SteamUserStats.findLeaderboard(this.pointer, this.callback, string));
    }

    public String getLeaderboardName(SteamLeaderboardHandle steamLeaderboardHandle) {
        return SteamUserStats.getLeaderboardName(this.pointer, steamLeaderboardHandle.handle);
    }

    public int getLeaderboardEntryCount(SteamLeaderboardHandle steamLeaderboardHandle) {
        return SteamUserStats.getLeaderboardEntryCount(this.pointer, steamLeaderboardHandle.handle);
    }

    public LeaderboardSortMethod getLeaderboardSortMethod(SteamLeaderboardHandle steamLeaderboardHandle) {
        return LeaderboardSortMethod.values()[SteamUserStats.getLeaderboardSortMethod(this.pointer, steamLeaderboardHandle.handle)];
    }

    public LeaderboardDisplayType getLeaderboardDisplayType(SteamLeaderboardHandle steamLeaderboardHandle) {
        return LeaderboardDisplayType.values()[SteamUserStats.getLeaderboardDisplayType(this.pointer, steamLeaderboardHandle.handle)];
    }

    public SteamAPICall downloadLeaderboardEntries(SteamLeaderboardHandle steamLeaderboardHandle, LeaderboardDataRequest leaderboardDataRequest, int n2, int n3) {
        return new SteamAPICall(SteamUserStats.downloadLeaderboardEntries(this.pointer, this.callback, steamLeaderboardHandle.handle, leaderboardDataRequest.ordinal(), n2, n3));
    }

    public SteamAPICall downloadLeaderboardEntriesForUsers(SteamLeaderboardHandle steamLeaderboardHandle, SteamID[] steamIDArray) {
        int n2 = steamIDArray.length;
        long[] lArray = new long[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            lArray[i2] = steamIDArray[i2].handle;
        }
        return new SteamAPICall(SteamUserStats.downloadLeaderboardEntriesForUsers(this.pointer, this.callback, steamLeaderboardHandle.handle, lArray, n2));
    }

    public boolean getDownloadedLeaderboardEntry(SteamLeaderboardEntriesHandle steamLeaderboardEntriesHandle, int n2, SteamLeaderboardEntry steamLeaderboardEntry, int[] nArray) {
        return nArray == null ? SteamUserStats.getDownloadedLeaderboardEntry(this.pointer, steamLeaderboardEntriesHandle.handle, n2, steamLeaderboardEntry) : SteamUserStats.getDownloadedLeaderboardEntry(this.pointer, steamLeaderboardEntriesHandle.handle, n2, steamLeaderboardEntry, nArray, nArray.length);
    }

    public SteamAPICall uploadLeaderboardScore(SteamLeaderboardHandle steamLeaderboardHandle, LeaderboardUploadScoreMethod leaderboardUploadScoreMethod, int n2, int[] nArray) {
        return new SteamAPICall(nArray == null ? SteamUserStats.uploadLeaderboardScore(this.pointer, this.callback, steamLeaderboardHandle.handle, leaderboardUploadScoreMethod.ordinal(), n2) : SteamUserStats.uploadLeaderboardScore(this.pointer, this.callback, steamLeaderboardHandle.handle, leaderboardUploadScoreMethod.ordinal(), n2, nArray, nArray.length));
    }

    public SteamAPICall requestGlobalStats(int n2) {
        return new SteamAPICall(SteamUserStats.requestGlobalStats(this.pointer, this.callback, n2));
    }

    public long getGlobalStat(String string, long l2) {
        long[] lArray = new long[1];
        if (SteamUserStats.getGlobalStat(this.pointer, string, lArray)) {
            return lArray[0];
        }
        return l2;
    }

    public double getGlobalStat(String string, double d2) {
        double[] dArray = new double[1];
        if (SteamUserStats.getGlobalStat(this.pointer, string, dArray)) {
            return dArray[0];
        }
        return d2;
    }

    public int getGlobalStatHistory(String string, long[] lArray) {
        return SteamUserStats.getGlobalStatHistory(this.pointer, string, lArray, lArray.length);
    }

    public int getGlobalStatHistory(String string, double[] dArray) {
        return SteamUserStats.getGlobalStatHistory(this.pointer, string, dArray, dArray.length);
    }

    private static native long createCallback(SteamUserStatsCallbackAdapter var0);

    private static native boolean requestCurrentStats(long var0);

    private static native boolean getStat(long var0, String var2, int[] var3);

    private static native boolean setStat(long var0, String var2, int var3);

    private static native boolean getStat(long var0, String var2, float[] var3);

    private static native boolean setStat(long var0, String var2, float var3);

    private static native boolean getAchievement(long var0, String var2, boolean[] var3);

    private static native boolean setAchievement(long var0, String var2);

    private static native boolean clearAchievement(long var0, String var2);

    private static native boolean storeStats(long var0);

    private static native boolean indicateAchievementProgress(long var0, String var2, int var3, int var4);

    private static native int getNumAchievements(long var0);

    private static native String getAchievementName(long var0, int var2);

    private static native boolean resetAllStats(long var0, boolean var2);

    private static native long findOrCreateLeaderboard(long var0, long var2, String var4, int var5, int var6);

    private static native long findLeaderboard(long var0, long var2, String var4);

    private static native String getLeaderboardName(long var0, long var2);

    private static native int getLeaderboardEntryCount(long var0, long var2);

    private static native int getLeaderboardSortMethod(long var0, long var2);

    private static native int getLeaderboardDisplayType(long var0, long var2);

    private static native long downloadLeaderboardEntries(long var0, long var2, long var4, int var6, int var7, int var8);

    private static native long downloadLeaderboardEntriesForUsers(long var0, long var2, long var4, long[] var6, int var7);

    private static native boolean getDownloadedLeaderboardEntry(long var0, long var2, int var4, SteamLeaderboardEntry var5, int[] var6, int var7);

    private static native boolean getDownloadedLeaderboardEntry(long var0, long var2, int var4, SteamLeaderboardEntry var5);

    private static native long uploadLeaderboardScore(long var0, long var2, long var4, int var6, int var7, int[] var8, int var9);

    private static native long uploadLeaderboardScore(long var0, long var2, long var4, int var6, int var7);

    private static native long requestGlobalStats(long var0, long var2, int var4);

    private static native boolean getGlobalStat(long var0, String var2, long[] var3);

    private static native boolean getGlobalStat(long var0, String var2, double[] var3);

    private static native int getGlobalStatHistory(long var0, String var2, long[] var3, int var4);

    private static native int getGlobalStatHistory(long var0, String var2, double[] var3, int var4);

    public static enum LeaderboardUploadScoreMethod {
        None,
        KeepBest,
        ForceUpdate;

    }

    public static enum LeaderboardSortMethod {
        None,
        Ascending,
        Descending;

    }

    public static enum LeaderboardDisplayType {
        None,
        Numeric,
        TimeSeconds,
        TimeMilliSeconds;

    }

    public static enum LeaderboardDataRequest {
        Global,
        GlobalAroundUser,
        Friends,
        Users;

    }
}

