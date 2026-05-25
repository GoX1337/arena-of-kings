/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamFriendsCallback;
import com.codedisaster.steamworks.SteamFriendsCallbackAdapter;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamInterface;
import java.util.Collection;

public class SteamFriends
extends SteamInterface {
    public SteamFriends(SteamFriendsCallback steamFriendsCallback) {
        super(SteamAPI.getSteamFriendsPointer(), SteamFriends.createCallback(new SteamFriendsCallbackAdapter(steamFriendsCallback)));
    }

    public String getPersonaName() {
        return SteamFriends.getPersonaName(this.pointer);
    }

    public SteamAPICall setPersonaName(String string) {
        return new SteamAPICall(SteamFriends.setPersonaName(this.pointer, this.callback, string));
    }

    public PersonaState getPersonaState() {
        return PersonaState.byOrdinal(SteamFriends.getPersonaState(this.pointer));
    }

    public int getFriendCount(FriendFlags friendFlags) {
        return SteamFriends.getFriendCount(this.pointer, friendFlags.bits);
    }

    public int getFriendCount(Collection<FriendFlags> collection) {
        return SteamFriends.getFriendCount(this.pointer, FriendFlags.asBits(collection));
    }

    public SteamID getFriendByIndex(int n2, FriendFlags friendFlags) {
        return new SteamID(SteamFriends.getFriendByIndex(this.pointer, n2, friendFlags.bits));
    }

    public SteamID getFriendByIndex(int n2, Collection<FriendFlags> collection) {
        return new SteamID(SteamFriends.getFriendByIndex(this.pointer, n2, FriendFlags.asBits(collection)));
    }

    public FriendRelationship getFriendRelationship(SteamID steamID) {
        return FriendRelationship.byOrdinal(SteamFriends.getFriendRelationship(this.pointer, steamID.handle));
    }

    public PersonaState getFriendPersonaState(SteamID steamID) {
        return PersonaState.byOrdinal(SteamFriends.getFriendPersonaState(this.pointer, steamID.handle));
    }

    public String getFriendPersonaName(SteamID steamID) {
        return SteamFriends.getFriendPersonaName(this.pointer, steamID.handle);
    }

    public boolean getFriendGamePlayed(SteamID steamID, FriendGameInfo friendGameInfo) {
        return SteamFriends.getFriendGamePlayed(this.pointer, steamID.handle, friendGameInfo);
    }

    public void setInGameVoiceSpeaking(SteamID steamID, boolean bl2) {
        SteamFriends.setInGameVoiceSpeaking(this.pointer, steamID.handle, bl2);
    }

    public int getSmallFriendAvatar(SteamID steamID) {
        return SteamFriends.getSmallFriendAvatar(this.pointer, steamID.handle);
    }

    public int getMediumFriendAvatar(SteamID steamID) {
        return SteamFriends.getMediumFriendAvatar(this.pointer, steamID.handle);
    }

    public int getLargeFriendAvatar(SteamID steamID) {
        return SteamFriends.getLargeFriendAvatar(this.pointer, steamID.handle);
    }

    public boolean requestUserInformation(SteamID steamID, boolean bl2) {
        return SteamFriends.requestUserInformation(this.pointer, steamID.handle, bl2);
    }

    public void activateGameOverlay(OverlayDialog overlayDialog) {
        SteamFriends.activateGameOverlay(this.pointer, overlayDialog.id);
    }

    public void activateGameOverlayToUser(OverlayToUserDialog overlayToUserDialog, SteamID steamID) {
        SteamFriends.activateGameOverlayToUser(this.pointer, overlayToUserDialog.id, steamID.handle);
    }

    public void activateGameOverlayToWebPage(String string) {
        SteamFriends.activateGameOverlayToWebPage(this.pointer, string);
    }

    public void activateGameOverlayToStore(int n2, OverlayToStoreFlag overlayToStoreFlag) {
        SteamFriends.activateGameOverlayToStore(this.pointer, n2, overlayToStoreFlag.ordinal());
    }

    public void activateGameOverlayInviteDialog(SteamID steamID) {
        SteamFriends.activateGameOverlayInviteDialog(this.pointer, steamID.handle);
    }

    public boolean setRichPresence(String string, String string2) {
        return SteamFriends.setRichPresence(this.pointer, string, string2 != null ? string2 : "");
    }

    public void clearRichPresence() {
        SteamFriends.clearRichPresence(this.pointer);
    }

    public String getFriendRichPresence(SteamID steamID, String string) {
        return SteamFriends.getFriendRichPresence(this.pointer, steamID.handle, string);
    }

    public int getFriendRichPresenceKeyCount(SteamID steamID) {
        return SteamFriends.getFriendRichPresenceKeyCount(this.pointer, steamID.handle);
    }

    public String getFriendRichPresenceKeyByIndex(SteamID steamID, int n2) {
        return SteamFriends.getFriendRichPresenceKeyByIndex(this.pointer, steamID.handle, n2);
    }

    public void requestFriendRichPresence(SteamID steamID) {
        SteamFriends.requestFriendRichPresence(this.pointer, steamID.handle);
    }

    public boolean inviteUserToGame(SteamID steamID, String string) {
        return SteamFriends.inviteUserToGame(this.pointer, steamID.handle, string);
    }

    private static native long createCallback(SteamFriendsCallbackAdapter var0);

    private static native String getPersonaName(long var0);

    private static native long setPersonaName(long var0, long var2, String var4);

    private static native int getPersonaState(long var0);

    private static native int getFriendCount(long var0, int var2);

    private static native long getFriendByIndex(long var0, int var2, int var3);

    private static native int getFriendRelationship(long var0, long var2);

    private static native int getFriendPersonaState(long var0, long var2);

    private static native String getFriendPersonaName(long var0, long var2);

    private static native boolean getFriendGamePlayed(long var0, long var2, FriendGameInfo var4);

    private static native void setInGameVoiceSpeaking(long var0, long var2, boolean var4);

    private static native int getSmallFriendAvatar(long var0, long var2);

    private static native int getMediumFriendAvatar(long var0, long var2);

    private static native int getLargeFriendAvatar(long var0, long var2);

    private static native boolean requestUserInformation(long var0, long var2, boolean var4);

    private static native void activateGameOverlay(long var0, String var2);

    private static native void activateGameOverlayToUser(long var0, String var2, long var3);

    private static native void activateGameOverlayToWebPage(long var0, String var2);

    private static native void activateGameOverlayToStore(long var0, int var2, int var3);

    private static native void activateGameOverlayInviteDialog(long var0, long var2);

    private static native boolean setRichPresence(long var0, String var2, String var3);

    private static native void clearRichPresence(long var0);

    private static native String getFriendRichPresence(long var0, long var2, String var4);

    private static native int getFriendRichPresenceKeyCount(long var0, long var2);

    private static native String getFriendRichPresenceKeyByIndex(long var0, long var2, int var4);

    private static native void requestFriendRichPresence(long var0, long var2);

    private static native boolean inviteUserToGame(long var0, long var2, String var4);

    public static enum OverlayToStoreFlag {
        None,
        AddToCart,
        AddToCartAndShow;

    }

    public static enum OverlayToUserDialog {
        SteamID("steamid"),
        Chat("chat"),
        JoinTrade("jointrade"),
        Stats("stats"),
        Achievements("achievements"),
        FriendAdd("friendadd"),
        FriendRemove("friendremove"),
        FriendRequestAccept("friendrequestaccept"),
        FriendRequestIgnore("friendrequestignore");

        private final String id;

        private OverlayToUserDialog(String string2) {
            this.id = string2;
        }
    }

    public static enum OverlayDialog {
        Friends("Friends"),
        Community("Community"),
        Players("Players"),
        Settings("Settings"),
        OfficialGameGroup("OfficialGameGroup"),
        Stats("Stats"),
        Achievements("Achievements");

        private final String id;

        private OverlayDialog(String string2) {
            this.id = string2;
        }
    }

    public static class FriendGameInfo {
        private long gameID;
        private int gameIP;
        private short gamePort;
        private short queryPort;
        private long steamIDLobby;

        public long getGameID() {
            return this.gameID;
        }

        public int getGameIP() {
            return this.gameIP;
        }

        public short getGamePort() {
            return this.gamePort;
        }

        public short getQueryPort() {
            return this.queryPort;
        }

        public SteamID getSteamIDLobby() {
            return new SteamID(this.steamIDLobby);
        }
    }

    public static enum PersonaChange {
        Name(1),
        Status(2),
        ComeOnline(4),
        GoneOffline(8),
        GamePlayed(16),
        GameServer(32),
        Avatar(64),
        JoinedSource(128),
        LeftSource(256),
        RelationshipChanged(512),
        NameFirstSet(1024),
        FacebookInfo(2048),
        Nickname(4096),
        SteamLevel(8192);

        private final int bits;

        private PersonaChange(int n3) {
            this.bits = n3;
        }

        static boolean isSet(PersonaChange personaChange, int n2) {
            return (personaChange.bits & n2) == personaChange.bits;
        }
    }

    public static enum FriendFlags {
        None(0),
        Blocked(1),
        FriendshipRequested(2),
        Immediate(4),
        ClanMember(8),
        OnGameServer(16),
        RequestingFriendship(128),
        RequestingInfo(256),
        Ignored(512),
        IgnoredFriend(1024),
        ChatMember(4096),
        All(65535);

        private final int bits;

        private FriendFlags(int n3) {
            this.bits = n3;
        }

        static int asBits(Collection<FriendFlags> collection) {
            int n2 = 0;
            for (FriendFlags friendFlags : collection) {
                n2 |= friendFlags.bits;
            }
            return n2;
        }
    }

    public static enum PersonaState {
        Offline,
        Online,
        Busy,
        Away,
        Snooze,
        LookingToTrade,
        LookingToPlay;

        private static final PersonaState[] values;

        static PersonaState byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = PersonaState.values();
        }
    }

    public static enum FriendRelationship {
        None,
        Blocked,
        Recipient,
        Friend,
        RequestInitiator,
        Ignored,
        IgnoredFriend,
        Suggested_DEPRECATED,
        Max;

        private static final FriendRelationship[] values;

        static FriendRelationship byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = FriendRelationship.values();
        }
    }
}

