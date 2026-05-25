/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamAuth;
import com.codedisaster.steamworks.SteamAuthTicket;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamUserCallback;
import com.codedisaster.steamworks.SteamUserCallbackAdapter;
import java.nio.ByteBuffer;

public class SteamUser
extends SteamInterface {
    public SteamUser(SteamUserCallback steamUserCallback) {
        super(SteamAPI.getSteamUserPointer(), SteamUser.createCallback(new SteamUserCallbackAdapter(steamUserCallback)));
    }

    public SteamID getSteamID() {
        return new SteamID(SteamUser.getSteamID(this.pointer));
    }

    public int initiateGameConnection(ByteBuffer byteBuffer, SteamID steamID, int n2, short s2, boolean bl2) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        int n3 = SteamUser.initiateGameConnection(this.pointer, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), steamID.handle, n2, s2, bl2);
        if (n3 > 0) {
            byteBuffer.limit(n3);
        }
        return n3;
    }

    public void terminateGameConnection(int n2, short s2) {
        SteamUser.terminateGameConnection(this.pointer, n2, s2);
    }

    public void startVoiceRecording() {
        SteamUser.startVoiceRecording(this.pointer);
    }

    public void stopVoiceRecording() {
        SteamUser.stopVoiceRecording(this.pointer);
    }

    public VoiceResult getAvailableVoice(int[] nArray) {
        int n2 = SteamUser.getAvailableVoice(this.pointer, nArray);
        return VoiceResult.byOrdinal(n2);
    }

    public VoiceResult getVoice(ByteBuffer byteBuffer, int[] nArray) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        int n2 = SteamUser.getVoice(this.pointer, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), nArray);
        return VoiceResult.byOrdinal(n2);
    }

    public VoiceResult decompressVoice(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int[] nArray, int n2) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        if (!byteBuffer2.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        int n3 = SteamUser.decompressVoice(this.pointer, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), byteBuffer2, byteBuffer2.position(), byteBuffer2.remaining(), nArray, n2);
        return VoiceResult.byOrdinal(n3);
    }

    public int getVoiceOptimalSampleRate() {
        return SteamUser.getVoiceOptimalSampleRate(this.pointer);
    }

    public SteamAuthTicket getAuthSessionTicket(ByteBuffer byteBuffer, int[] nArray) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        int n2 = SteamUser.getAuthSessionTicket(this.pointer, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), nArray);
        if ((long)n2 != 0L) {
            byteBuffer.limit(nArray[0]);
        }
        return new SteamAuthTicket(n2);
    }

    public SteamAuth.BeginAuthSessionResult beginAuthSession(ByteBuffer byteBuffer, SteamID steamID) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        int n2 = SteamUser.beginAuthSession(this.pointer, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), steamID.handle);
        return SteamAuth.BeginAuthSessionResult.byOrdinal(n2);
    }

    public void endAuthSession(SteamID steamID) {
        SteamUser.endAuthSession(this.pointer, steamID.handle);
    }

    public void cancelAuthTicket(SteamAuthTicket steamAuthTicket) {
        SteamUser.cancelAuthTicket(this.pointer, (int)steamAuthTicket.handle);
    }

    public SteamAuth.UserHasLicenseForAppResult userHasLicenseForApp(SteamID steamID, int n2) {
        return SteamAuth.UserHasLicenseForAppResult.byOrdinal(SteamUser.userHasLicenseForApp(this.pointer, steamID.handle, n2));
    }

    public SteamAPICall requestEncryptedAppTicket(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return new SteamAPICall(SteamUser.requestEncryptedAppTicket(this.pointer, this.callback, byteBuffer, byteBuffer.position(), byteBuffer.remaining()));
    }

    public boolean getEncryptedAppTicket(ByteBuffer byteBuffer, int[] nArray) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return SteamUser.getEncryptedAppTicket(this.pointer, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), nArray);
    }

    public boolean isBehindNAT() {
        return SteamUser.isBehindNAT(this.pointer);
    }

    public void advertiseGame(SteamID steamID, int n2, short s2) {
        SteamUser.advertiseGame(this.pointer, steamID.handle, n2, s2);
    }

    private static native long createCallback(SteamUserCallbackAdapter var0);

    private static native long getSteamID(long var0);

    private static native int initiateGameConnection(long var0, ByteBuffer var2, int var3, int var4, long var5, int var7, short var8, boolean var9);

    private static native void terminateGameConnection(long var0, int var2, short var3);

    private static native void startVoiceRecording(long var0);

    private static native void stopVoiceRecording(long var0);

    private static native int getAvailableVoice(long var0, int[] var2);

    private static native int getVoice(long var0, ByteBuffer var2, int var3, int var4, int[] var5);

    private static native int decompressVoice(long var0, ByteBuffer var2, int var3, int var4, ByteBuffer var5, int var6, int var7, int[] var8, int var9);

    private static native int getVoiceOptimalSampleRate(long var0);

    private static native int getAuthSessionTicket(long var0, ByteBuffer var2, int var3, int var4, int[] var5);

    private static native int beginAuthSession(long var0, ByteBuffer var2, int var3, int var4, long var5);

    private static native void endAuthSession(long var0, long var2);

    private static native void cancelAuthTicket(long var0, int var2);

    private static native int userHasLicenseForApp(long var0, long var2, int var4);

    private static native long requestEncryptedAppTicket(long var0, long var2, ByteBuffer var4, int var5, int var6);

    private static native boolean getEncryptedAppTicket(long var0, ByteBuffer var2, int var3, int var4, int[] var5);

    private static native boolean isBehindNAT(long var0);

    private static native void advertiseGame(long var0, long var2, int var4, short var5);

    public static enum VoiceResult {
        OK,
        NotInitialized,
        NotRecording,
        NoData,
        BufferTooSmall,
        DataCorrupted,
        Restricted,
        UnsupportedCodec,
        ReceiverOutOfDate,
        ReceiverDidNotAnswer;

        private static final VoiceResult[] values;

        static VoiceResult byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = VoiceResult.values();
        }
    }
}

