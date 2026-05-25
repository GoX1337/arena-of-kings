/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamMatchmakingCallback;
import com.codedisaster.steamworks.SteamMatchmakingCallbackAdapter;
import com.codedisaster.steamworks.SteamMatchmakingKeyValuePair;
import java.nio.ByteBuffer;

public class SteamMatchmaking
extends SteamInterface {
    public SteamMatchmaking(SteamMatchmakingCallback steamMatchmakingCallback) {
        super(SteamAPI.getSteamMatchmakingPointer(), SteamMatchmaking.createCallback(new SteamMatchmakingCallbackAdapter(steamMatchmakingCallback)));
    }

    public int getFavoriteGameCount() {
        return SteamMatchmaking.getFavoriteGameCount(this.pointer);
    }

    public boolean getFavoriteGame(int n2, int[] nArray, int[] nArray2, short[] sArray, short[] sArray2, int[] nArray3, int[] nArray4) {
        return SteamMatchmaking.getFavoriteGame(this.pointer, n2, nArray, nArray2, sArray, sArray2, nArray3, nArray4);
    }

    public int addFavoriteGame(int n2, int n3, short s2, short s3, int n4, int n5) {
        return SteamMatchmaking.addFavoriteGame(this.pointer, n2, n3, s2, s3, n4, n5);
    }

    public boolean removeFavoriteGame(int n2, int n3, short s2, short s3, int n4) {
        return SteamMatchmaking.removeFavoriteGame(this.pointer, n2, n3, s2, s3, n4);
    }

    public SteamAPICall requestLobbyList() {
        return new SteamAPICall(SteamMatchmaking.requestLobbyList(this.pointer, this.callback));
    }

    public void addRequestLobbyListStringFilter(String string, String string2, LobbyComparison lobbyComparison) {
        SteamMatchmaking.addRequestLobbyListStringFilter(this.pointer, string, string2, lobbyComparison.value);
    }

    public void addRequestLobbyListNumericalFilter(String string, int n2, LobbyComparison lobbyComparison) {
        SteamMatchmaking.addRequestLobbyListNumericalFilter(this.pointer, string, n2, lobbyComparison.value);
    }

    public void addRequestLobbyListNearValueFilter(String string, int n2) {
        SteamMatchmaking.addRequestLobbyListNearValueFilter(this.pointer, string, n2);
    }

    public void addRequestLobbyListFilterSlotsAvailable(int n2) {
        SteamMatchmaking.addRequestLobbyListFilterSlotsAvailable(this.pointer, n2);
    }

    public void addRequestLobbyListDistanceFilter(LobbyDistanceFilter lobbyDistanceFilter) {
        SteamMatchmaking.addRequestLobbyListDistanceFilter(this.pointer, lobbyDistanceFilter.ordinal());
    }

    public void addRequestLobbyListResultCountFilter(int n2) {
        SteamMatchmaking.addRequestLobbyListResultCountFilter(this.pointer, n2);
    }

    public void addRequestLobbyListCompatibleMembersFilter(SteamID steamID) {
        SteamMatchmaking.addRequestLobbyListCompatibleMembersFilter(this.pointer, steamID.handle);
    }

    public SteamID getLobbyByIndex(int n2) {
        return new SteamID(SteamMatchmaking.getLobbyByIndex(this.pointer, n2));
    }

    public SteamAPICall createLobby(LobbyType lobbyType, int n2) {
        return new SteamAPICall(SteamMatchmaking.createLobby(this.pointer, this.callback, lobbyType.ordinal(), n2));
    }

    public SteamAPICall joinLobby(SteamID steamID) {
        return new SteamAPICall(SteamMatchmaking.joinLobby(this.pointer, this.callback, steamID.handle));
    }

    public void leaveLobby(SteamID steamID) {
        SteamMatchmaking.leaveLobby(this.pointer, steamID.handle);
    }

    public boolean inviteUserToLobby(SteamID steamID, SteamID steamID2) {
        return SteamMatchmaking.inviteUserToLobby(this.pointer, steamID.handle, steamID2.handle);
    }

    public int getNumLobbyMembers(SteamID steamID) {
        return SteamMatchmaking.getNumLobbyMembers(this.pointer, steamID.handle);
    }

    public SteamID getLobbyMemberByIndex(SteamID steamID, int n2) {
        return new SteamID(SteamMatchmaking.getLobbyMemberByIndex(this.pointer, steamID.handle, n2));
    }

    public String getLobbyData(SteamID steamID, String string) {
        return SteamMatchmaking.getLobbyData(this.pointer, steamID.handle, string);
    }

    public boolean setLobbyData(SteamID steamID, String string, String string2) {
        return SteamMatchmaking.setLobbyData(this.pointer, steamID.handle, string, string2);
    }

    public boolean setLobbyData(SteamID steamID, SteamMatchmakingKeyValuePair steamMatchmakingKeyValuePair) {
        return SteamMatchmaking.setLobbyData(this.pointer, steamID.handle, steamMatchmakingKeyValuePair.getKey(), steamMatchmakingKeyValuePair.getValue());
    }

    public String getLobbyMemberData(SteamID steamID, SteamID steamID2, String string) {
        return SteamMatchmaking.getLobbyMemberData(this.pointer, steamID.handle, steamID2.handle, string);
    }

    public void setLobbyMemberData(SteamID steamID, String string, String string2) {
        SteamMatchmaking.setLobbyMemberData(this.pointer, steamID.handle, string, string2);
    }

    public void setLobbyMemberData(SteamID steamID, SteamMatchmakingKeyValuePair steamMatchmakingKeyValuePair) {
        SteamMatchmaking.setLobbyMemberData(this.pointer, steamID.handle, steamMatchmakingKeyValuePair.getKey(), steamMatchmakingKeyValuePair.getValue());
    }

    public int getLobbyDataCount(SteamID steamID) {
        return SteamMatchmaking.getLobbyDataCount(this.pointer, steamID.handle);
    }

    public boolean getLobbyDataByIndex(SteamID steamID, int n2, SteamMatchmakingKeyValuePair steamMatchmakingKeyValuePair) {
        return SteamMatchmaking.getLobbyDataByIndex(this.pointer, steamID.handle, n2, steamMatchmakingKeyValuePair);
    }

    public boolean deleteLobbyData(SteamID steamID, String string) {
        return SteamMatchmaking.deleteLobbyData(this.pointer, steamID.handle, string);
    }

    public boolean sendLobbyChatMsg(SteamID steamID, ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return SteamMatchmaking.sendLobbyChatMsg(this.pointer, steamID.handle, byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public boolean sendLobbyChatMsg(SteamID steamID, String string) {
        return SteamMatchmaking.sendLobbyChatMsg(this.pointer, steamID.handle, string);
    }

    public int getLobbyChatEntry(SteamID steamID, int n2, ChatEntry chatEntry, ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new SteamException("Direct buffer required!");
        }
        return SteamMatchmaking.getLobbyChatEntry(this.pointer, steamID.handle, n2, chatEntry, byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public boolean requestLobbyData(SteamID steamID) {
        return SteamMatchmaking.requestLobbyData(this.pointer, steamID.handle);
    }

    public void setLobbyGameServer(SteamID steamID, int n2, short s2, SteamID steamID2) {
        SteamMatchmaking.setLobbyGameServer(this.pointer, steamID.handle, n2, s2, steamID2.handle);
    }

    public boolean getLobbyGameServer(SteamID steamID, int[] nArray, short[] sArray, SteamID steamID2) {
        long[] lArray = new long[1];
        if (SteamMatchmaking.getLobbyGameServer(this.pointer, steamID.handle, nArray, sArray, lArray)) {
            steamID2.handle = lArray[0];
            return true;
        }
        return false;
    }

    public boolean setLobbyMemberLimit(SteamID steamID, int n2) {
        return SteamMatchmaking.setLobbyMemberLimit(this.pointer, steamID.handle, n2);
    }

    public int getLobbyMemberLimit(SteamID steamID) {
        return SteamMatchmaking.getLobbyMemberLimit(this.pointer, steamID.handle);
    }

    public boolean setLobbyType(SteamID steamID, LobbyType lobbyType) {
        return SteamMatchmaking.setLobbyType(this.pointer, steamID.handle, lobbyType.ordinal());
    }

    public boolean setLobbyJoinable(SteamID steamID, boolean bl2) {
        return SteamMatchmaking.setLobbyJoinable(this.pointer, steamID.handle, bl2);
    }

    public SteamID getLobbyOwner(SteamID steamID) {
        return new SteamID(SteamMatchmaking.getLobbyOwner(this.pointer, steamID.handle));
    }

    public boolean setLobbyOwner(SteamID steamID, SteamID steamID2) {
        return SteamMatchmaking.setLobbyOwner(this.pointer, steamID.handle, steamID2.handle);
    }

    public boolean setLinkedLobby(SteamID steamID, SteamID steamID2) {
        return SteamMatchmaking.setLinkedLobby(this.pointer, steamID.handle, steamID2.handle);
    }

    private static native long createCallback(SteamMatchmakingCallbackAdapter var0);

    private static native int getFavoriteGameCount(long var0);

    private static native boolean getFavoriteGame(long var0, int var2, int[] var3, int[] var4, short[] var5, short[] var6, int[] var7, int[] var8);

    private static native int addFavoriteGame(long var0, int var2, int var3, short var4, short var5, int var6, int var7);

    private static native boolean removeFavoriteGame(long var0, int var2, int var3, short var4, short var5, int var6);

    private static native long requestLobbyList(long var0, long var2);

    private static native void addRequestLobbyListStringFilter(long var0, String var2, String var3, int var4);

    private static native void addRequestLobbyListNumericalFilter(long var0, String var2, int var3, int var4);

    private static native void addRequestLobbyListNearValueFilter(long var0, String var2, int var3);

    private static native void addRequestLobbyListFilterSlotsAvailable(long var0, int var2);

    private static native void addRequestLobbyListDistanceFilter(long var0, int var2);

    private static native void addRequestLobbyListResultCountFilter(long var0, int var2);

    private static native void addRequestLobbyListCompatibleMembersFilter(long var0, long var2);

    private static native long getLobbyByIndex(long var0, int var2);

    private static native long createLobby(long var0, long var2, int var4, int var5);

    private static native long joinLobby(long var0, long var2, long var4);

    private static native void leaveLobby(long var0, long var2);

    private static native boolean inviteUserToLobby(long var0, long var2, long var4);

    private static native int getNumLobbyMembers(long var0, long var2);

    private static native long getLobbyMemberByIndex(long var0, long var2, int var4);

    private static native String getLobbyData(long var0, long var2, String var4);

    private static native boolean setLobbyData(long var0, long var2, String var4, String var5);

    private static native String getLobbyMemberData(long var0, long var2, long var4, String var6);

    private static native void setLobbyMemberData(long var0, long var2, String var4, String var5);

    private static native int getLobbyDataCount(long var0, long var2);

    private static native boolean getLobbyDataByIndex(long var0, long var2, int var4, SteamMatchmakingKeyValuePair var5);

    private static native boolean deleteLobbyData(long var0, long var2, String var4);

    private static native boolean sendLobbyChatMsg(long var0, long var2, ByteBuffer var4, int var5, int var6);

    private static native boolean sendLobbyChatMsg(long var0, long var2, String var4);

    private static native int getLobbyChatEntry(long var0, long var2, int var4, ChatEntry var5, ByteBuffer var6, int var7, int var8);

    private static native boolean requestLobbyData(long var0, long var2);

    private static native void setLobbyGameServer(long var0, long var2, int var4, short var5, long var6);

    private static native boolean getLobbyGameServer(long var0, long var2, int[] var4, short[] var5, long[] var6);

    private static native boolean setLobbyMemberLimit(long var0, long var2, int var4);

    private static native int getLobbyMemberLimit(long var0, long var2);

    private static native boolean setLobbyType(long var0, long var2, int var4);

    private static native boolean setLobbyJoinable(long var0, long var2, boolean var4);

    private static native long getLobbyOwner(long var0, long var2);

    private static native boolean setLobbyOwner(long var0, long var2, long var4);

    private static native boolean setLinkedLobby(long var0, long var2, long var4);

    public static class ChatEntry {
        private long steamIDUser;
        private int chatEntryType;

        public SteamID getSteamIDUser() {
            return new SteamID(this.steamIDUser);
        }

        public ChatEntryType getChatEntryType() {
            return ChatEntryType.byCode(this.chatEntryType);
        }
    }

    public static enum ChatEntryType {
        Invalid(0),
        ChatMsg(1),
        Typing(2),
        InviteGame(3),
        Emote(4),
        LeftConversation(6),
        Entered(7),
        WasKicked(8),
        WasBanned(9),
        Disconnected(10),
        HistoricalChat(11),
        Reserved1(12),
        Reserved2(13),
        LinkBlocked(14);

        private final int code;
        private static final ChatEntryType[] values;

        private ChatEntryType(int n3) {
            this.code = n3;
        }

        static ChatEntryType byCode(int n2) {
            for (ChatEntryType chatEntryType : values) {
                if (chatEntryType.code != n2) continue;
                return chatEntryType;
            }
            return Invalid;
        }

        static {
            values = ChatEntryType.values();
        }
    }

    public static enum ChatMemberStateChange {
        Entered(1),
        Left(2),
        Disconnected(4),
        Kicked(8),
        Banned(16);

        private final int bits;

        private ChatMemberStateChange(int n3) {
            this.bits = n3;
        }

        static boolean isSet(ChatMemberStateChange chatMemberStateChange, int n2) {
            return (chatMemberStateChange.bits & n2) == chatMemberStateChange.bits;
        }
    }

    public static enum ChatRoomEnterResponse {
        Success(1),
        DoesntExist(2),
        NotAllowed(3),
        Full(4),
        Error(5),
        Banned(6),
        Limited(7),
        ClanDisabled(8),
        CommunityBan(9),
        MemberBlockedYou(10),
        YouBlockedMember(11),
        RatelimitExceeded(15);

        private final int code;
        private static final ChatRoomEnterResponse[] values;

        private ChatRoomEnterResponse(int n3) {
            this.code = n3;
        }

        static ChatRoomEnterResponse byCode(int n2) {
            for (ChatRoomEnterResponse chatRoomEnterResponse : values) {
                if (chatRoomEnterResponse.code != n2) continue;
                return chatRoomEnterResponse;
            }
            return Error;
        }

        static {
            values = ChatRoomEnterResponse.values();
        }
    }

    public static enum LobbyDistanceFilter {
        Close,
        Default,
        Far,
        Worldwide;

    }

    public static enum LobbyComparison {
        EqualToOrLessThan(-2),
        LessThan(-1),
        Equal(0),
        GreaterThan(1),
        EqualToOrGreaterThan(2),
        NotEqual(3);

        private final int value;

        private LobbyComparison(int n3) {
            this.value = n3;
        }
    }

    public static enum LobbyType {
        Private,
        FriendsOnly,
        Public,
        Invisible;

    }
}

