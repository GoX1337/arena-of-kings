/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamAPICall;
import com.codedisaster.steamworks.SteamInterface;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamRemoteStorage;
import com.codedisaster.steamworks.SteamUGCCallback;
import com.codedisaster.steamworks.SteamUGCCallbackAdapter;
import com.codedisaster.steamworks.SteamUGCDetails;
import com.codedisaster.steamworks.SteamUGCQuery;
import com.codedisaster.steamworks.SteamUGCUpdateHandle;
import java.util.Collection;
import java.util.EnumSet;

public class SteamUGC
extends SteamInterface {
    public SteamUGC(SteamUGCCallback steamUGCCallback) {
        super(SteamAPI.getSteamUGCPointer(), SteamUGC.createCallback(new SteamUGCCallbackAdapter(steamUGCCallback)));
    }

    public SteamUGCQuery createQueryUserUGCRequest(int n2, UserUGCList userUGCList, MatchingUGCType matchingUGCType, UserUGCListSortOrder userUGCListSortOrder, int n3, int n4, int n5) {
        return new SteamUGCQuery(SteamUGC.createQueryUserUGCRequest(this.pointer, n2, userUGCList.ordinal(), matchingUGCType.value, userUGCListSortOrder.ordinal(), n3, n4, n5));
    }

    public SteamUGCQuery createQueryAllUGCRequest(UGCQueryType uGCQueryType, MatchingUGCType matchingUGCType, int n2, int n3, int n4) {
        return new SteamUGCQuery(SteamUGC.createQueryAllUGCRequest(this.pointer, uGCQueryType.ordinal(), matchingUGCType.value, n2, n3, n4));
    }

    public SteamUGCQuery createQueryUGCDetailsRequest(SteamPublishedFileID steamPublishedFileID) {
        long[] lArray = new long[]{steamPublishedFileID.handle};
        return new SteamUGCQuery(SteamUGC.createQueryUGCDetailsRequest(this.pointer, lArray, 1));
    }

    public SteamUGCQuery createQueryUGCDetailsRequest(Collection<SteamPublishedFileID> collection) {
        int n2 = collection.size();
        long[] lArray = new long[n2];
        int n3 = 0;
        for (SteamPublishedFileID steamPublishedFileID : collection) {
            lArray[n3++] = steamPublishedFileID.handle;
        }
        return new SteamUGCQuery(SteamUGC.createQueryUGCDetailsRequest(this.pointer, lArray, n2));
    }

    public SteamAPICall sendQueryUGCRequest(SteamUGCQuery steamUGCQuery) {
        return new SteamAPICall(SteamUGC.sendQueryUGCRequest(this.pointer, this.callback, steamUGCQuery.handle));
    }

    public boolean getQueryUGCResult(SteamUGCQuery steamUGCQuery, int n2, SteamUGCDetails steamUGCDetails) {
        return SteamUGC.getQueryUGCResult(this.pointer, steamUGCQuery.handle, n2, steamUGCDetails);
    }

    public String getQueryUGCPreviewURL(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.getQueryUGCPreviewURL(this.pointer, steamUGCQuery.handle, n2);
    }

    public String getQueryUGCMetadata(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.getQueryUGCMetadata(this.pointer, steamUGCQuery.handle, n2);
    }

    public long getQueryUGCStatistic(SteamUGCQuery steamUGCQuery, int n2, ItemStatistic itemStatistic) {
        return SteamUGC.getQueryUGCStatistic(this.pointer, steamUGCQuery.handle, n2, itemStatistic.ordinal());
    }

    public int getQueryUGCNumAdditionalPreviews(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.getQueryUGCNumAdditionalPreviews(this.pointer, steamUGCQuery.handle, n2);
    }

    public boolean getQueryUGCAdditionalPreview(SteamUGCQuery steamUGCQuery, int n2, int n3, ItemAdditionalPreview itemAdditionalPreview) {
        return SteamUGC.getQueryUGCAdditionalPreview(this.pointer, steamUGCQuery.handle, n2, n3, itemAdditionalPreview);
    }

    public int getQueryUGCNumKeyValueTags(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.getQueryUGCNumKeyValueTags(this.pointer, steamUGCQuery.handle, n2);
    }

    public boolean getQueryUGCKeyValueTag(SteamUGCQuery steamUGCQuery, int n2, int n3, String[] stringArray) {
        return SteamUGC.getQueryUGCKeyValueTag(this.pointer, steamUGCQuery.handle, n2, n3, stringArray);
    }

    public boolean releaseQueryUserUGCRequest(SteamUGCQuery steamUGCQuery) {
        return SteamUGC.releaseQueryUserUGCRequest(this.pointer, steamUGCQuery.handle);
    }

    public boolean addRequiredTag(SteamUGCQuery steamUGCQuery, String string) {
        return SteamUGC.addRequiredTag(this.pointer, steamUGCQuery.handle, string);
    }

    public boolean addExcludedTag(SteamUGCQuery steamUGCQuery, String string) {
        return SteamUGC.addExcludedTag(this.pointer, steamUGCQuery.handle, string);
    }

    public boolean setReturnOnlyIDs(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnOnlyIDs(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnKeyValueTags(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnKeyValueTags(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnLongDescription(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnLongDescription(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnMetadata(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnMetadata(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnChildren(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnChildren(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnAdditionalPreviews(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnAdditionalPreviews(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnTotalOnly(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setReturnTotalOnly(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setReturnPlaytimeStats(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.setReturnPlaytimeStats(this.pointer, steamUGCQuery.handle, n2);
    }

    public boolean setLanguage(SteamUGCQuery steamUGCQuery, String string) {
        return SteamUGC.setLanguage(this.pointer, steamUGCQuery.handle, string);
    }

    public boolean setAllowCachedResponse(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.setAllowCachedResponse(this.pointer, steamUGCQuery.handle, n2);
    }

    public boolean setCloudFileNameFilter(SteamUGCQuery steamUGCQuery, String string) {
        return SteamUGC.setCloudFileNameFilter(this.pointer, steamUGCQuery.handle, string);
    }

    public boolean setMatchAnyTag(SteamUGCQuery steamUGCQuery, boolean bl2) {
        return SteamUGC.setMatchAnyTag(this.pointer, steamUGCQuery.handle, bl2);
    }

    public boolean setSearchText(SteamUGCQuery steamUGCQuery, String string) {
        return SteamUGC.setSearchText(this.pointer, steamUGCQuery.handle, string);
    }

    public boolean setRankedByTrendDays(SteamUGCQuery steamUGCQuery, int n2) {
        return SteamUGC.setRankedByTrendDays(this.pointer, steamUGCQuery.handle, n2);
    }

    public boolean addRequiredKeyValueTag(SteamUGCQuery steamUGCQuery, String string, String string2) {
        return SteamUGC.addRequiredKeyValueTag(this.pointer, steamUGCQuery.handle, string, string2);
    }

    @Deprecated
    public SteamAPICall requestUGCDetails(SteamPublishedFileID steamPublishedFileID, int n2) {
        return new SteamAPICall(SteamUGC.requestUGCDetails(this.pointer, this.callback, steamPublishedFileID.handle, n2));
    }

    public SteamAPICall createItem(int n2, SteamRemoteStorage.WorkshopFileType workshopFileType) {
        return new SteamAPICall(SteamUGC.createItem(this.pointer, this.callback, n2, workshopFileType.ordinal()));
    }

    public SteamUGCUpdateHandle startItemUpdate(int n2, SteamPublishedFileID steamPublishedFileID) {
        return new SteamUGCUpdateHandle(SteamUGC.startItemUpdate(this.pointer, n2, steamPublishedFileID.handle));
    }

    public boolean setItemTitle(SteamUGCUpdateHandle steamUGCUpdateHandle, String string) {
        return SteamUGC.setItemTitle(this.pointer, steamUGCUpdateHandle.handle, string);
    }

    public boolean setItemDescription(SteamUGCUpdateHandle steamUGCUpdateHandle, String string) {
        return SteamUGC.setItemDescription(this.pointer, steamUGCUpdateHandle.handle, string);
    }

    public boolean setItemUpdateLanguage(SteamUGCUpdateHandle steamUGCUpdateHandle, String string) {
        return SteamUGC.setItemUpdateLanguage(this.pointer, steamUGCUpdateHandle.handle, string);
    }

    public boolean setItemMetadata(SteamUGCUpdateHandle steamUGCUpdateHandle, String string) {
        return SteamUGC.setItemMetadata(this.pointer, steamUGCUpdateHandle.handle, string);
    }

    public boolean setItemVisibility(SteamUGCUpdateHandle steamUGCUpdateHandle, SteamRemoteStorage.PublishedFileVisibility publishedFileVisibility) {
        return SteamUGC.setItemVisibility(this.pointer, steamUGCUpdateHandle.handle, publishedFileVisibility.ordinal());
    }

    public boolean setItemTags(SteamUGCUpdateHandle steamUGCUpdateHandle, String[] stringArray) {
        return SteamUGC.setItemTags(this.pointer, steamUGCUpdateHandle.handle, stringArray, stringArray.length);
    }

    public boolean setItemContent(SteamUGCUpdateHandle steamUGCUpdateHandle, String string) {
        return SteamUGC.setItemContent(this.pointer, steamUGCUpdateHandle.handle, string);
    }

    public boolean setItemPreview(SteamUGCUpdateHandle steamUGCUpdateHandle, String string) {
        return SteamUGC.setItemPreview(this.pointer, steamUGCUpdateHandle.handle, string);
    }

    public boolean removeItemKeyValueTags(SteamUGCUpdateHandle steamUGCUpdateHandle, String string) {
        return SteamUGC.removeItemKeyValueTags(this.pointer, steamUGCUpdateHandle.handle, string);
    }

    public boolean addItemKeyValueTag(SteamUGCUpdateHandle steamUGCUpdateHandle, String string, String string2) {
        return SteamUGC.addItemKeyValueTag(this.pointer, steamUGCUpdateHandle.handle, string, string2);
    }

    public SteamAPICall submitItemUpdate(SteamUGCUpdateHandle steamUGCUpdateHandle, String string) {
        return new SteamAPICall(SteamUGC.submitItemUpdate(this.pointer, this.callback, steamUGCUpdateHandle.handle, string));
    }

    public ItemUpdateStatus getItemUpdateProgress(SteamUGCUpdateHandle steamUGCUpdateHandle, ItemUpdateInfo itemUpdateInfo) {
        long[] lArray = new long[2];
        ItemUpdateStatus itemUpdateStatus = ItemUpdateStatus.byOrdinal(SteamUGC.getItemUpdateProgress(this.pointer, steamUGCUpdateHandle.handle, lArray));
        itemUpdateInfo.bytesProcessed = lArray[0];
        itemUpdateInfo.bytesTotal = lArray[1];
        return itemUpdateStatus;
    }

    public SteamAPICall setUserItemVote(SteamPublishedFileID steamPublishedFileID, boolean bl2) {
        return new SteamAPICall(SteamUGC.setUserItemVote(this.pointer, this.callback, steamPublishedFileID.handle, bl2));
    }

    public SteamAPICall getUserItemVote(SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(SteamUGC.getUserItemVote(this.pointer, this.callback, steamPublishedFileID.handle));
    }

    public SteamAPICall addItemToFavorites(int n2, SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(SteamUGC.addItemToFavorites(this.pointer, this.callback, n2, steamPublishedFileID.handle));
    }

    public SteamAPICall removeItemFromFavorites(int n2, SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(SteamUGC.removeItemFromFavorites(this.pointer, this.callback, n2, steamPublishedFileID.handle));
    }

    public SteamAPICall subscribeItem(SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(SteamUGC.subscribeItem(this.pointer, this.callback, steamPublishedFileID.handle));
    }

    public SteamAPICall unsubscribeItem(SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(SteamUGC.unsubscribeItem(this.pointer, this.callback, steamPublishedFileID.handle));
    }

    public int getNumSubscribedItems() {
        return SteamUGC.getNumSubscribedItems(this.pointer);
    }

    public int getSubscribedItems(SteamPublishedFileID[] steamPublishedFileIDArray) {
        long[] lArray = new long[steamPublishedFileIDArray.length];
        int n2 = SteamUGC.getSubscribedItems(this.pointer, lArray, steamPublishedFileIDArray.length);
        for (int i2 = 0; i2 < n2; ++i2) {
            steamPublishedFileIDArray[i2] = new SteamPublishedFileID(lArray[i2]);
        }
        return n2;
    }

    public Collection<ItemState> getItemState(SteamPublishedFileID steamPublishedFileID) {
        return ItemState.fromBits(SteamUGC.getItemState(this.pointer, steamPublishedFileID.handle));
    }

    public boolean getItemInstallInfo(SteamPublishedFileID steamPublishedFileID, ItemInstallInfo itemInstallInfo) {
        return SteamUGC.getItemInstallInfo(this.pointer, steamPublishedFileID.handle, itemInstallInfo);
    }

    public boolean getItemDownloadInfo(SteamPublishedFileID steamPublishedFileID, ItemDownloadInfo itemDownloadInfo) {
        long[] lArray = new long[2];
        if (SteamUGC.getItemDownloadInfo(this.pointer, steamPublishedFileID.handle, lArray)) {
            itemDownloadInfo.bytesDownloaded = lArray[0];
            itemDownloadInfo.bytesTotal = lArray[1];
            return true;
        }
        return false;
    }

    public SteamAPICall deleteItem(SteamPublishedFileID steamPublishedFileID) {
        return new SteamAPICall(SteamUGC.deleteItem(this.pointer, this.callback, steamPublishedFileID.handle));
    }

    public boolean downloadItem(SteamPublishedFileID steamPublishedFileID, boolean bl2) {
        return SteamUGC.downloadItem(this.pointer, steamPublishedFileID.handle, bl2);
    }

    public boolean initWorkshopForGameServer(int n2, String string) {
        return SteamUGC.initWorkshopForGameServer(this.pointer, n2, string);
    }

    public void suspendDownloads(boolean bl2) {
        SteamUGC.suspendDownloads(this.pointer, bl2);
    }

    public SteamAPICall startPlaytimeTracking(SteamPublishedFileID[] steamPublishedFileIDArray) {
        long[] lArray = new long[steamPublishedFileIDArray.length];
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            lArray[i2] = steamPublishedFileIDArray[i2].handle;
        }
        return new SteamAPICall(SteamUGC.startPlaytimeTracking(this.pointer, this.callback, lArray, lArray.length));
    }

    public SteamAPICall stopPlaytimeTracking(SteamPublishedFileID[] steamPublishedFileIDArray) {
        long[] lArray = new long[steamPublishedFileIDArray.length];
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            lArray[i2] = steamPublishedFileIDArray[i2].handle;
        }
        return new SteamAPICall(SteamUGC.stopPlaytimeTracking(this.pointer, this.callback, lArray, lArray.length));
    }

    public SteamAPICall stopPlaytimeTrackingForAllItems() {
        return new SteamAPICall(SteamUGC.stopPlaytimeTrackingForAllItems(this.pointer, this.callback));
    }

    private static native long createCallback(SteamUGCCallbackAdapter var0);

    private static native long createQueryUserUGCRequest(long var0, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

    private static native long createQueryAllUGCRequest(long var0, int var2, int var3, int var4, int var5, int var6);

    private static native long createQueryUGCDetailsRequest(long var0, long[] var2, int var3);

    private static native long sendQueryUGCRequest(long var0, long var2, long var4);

    private static native boolean getQueryUGCResult(long var0, long var2, int var4, SteamUGCDetails var5);

    private static native String getQueryUGCPreviewURL(long var0, long var2, int var4);

    private static native String getQueryUGCMetadata(long var0, long var2, int var4);

    private static native long getQueryUGCStatistic(long var0, long var2, int var4, int var5);

    private static native int getQueryUGCNumAdditionalPreviews(long var0, long var2, int var4);

    private static native boolean getQueryUGCAdditionalPreview(long var0, long var2, int var4, int var5, ItemAdditionalPreview var6);

    private static native int getQueryUGCNumKeyValueTags(long var0, long var2, int var4);

    private static native boolean getQueryUGCKeyValueTag(long var0, long var2, int var4, int var5, String[] var6);

    private static native boolean releaseQueryUserUGCRequest(long var0, long var2);

    private static native boolean addRequiredTag(long var0, long var2, String var4);

    private static native boolean addExcludedTag(long var0, long var2, String var4);

    private static native boolean setReturnOnlyIDs(long var0, long var2, boolean var4);

    private static native boolean setReturnKeyValueTags(long var0, long var2, boolean var4);

    private static native boolean setReturnLongDescription(long var0, long var2, boolean var4);

    private static native boolean setReturnMetadata(long var0, long var2, boolean var4);

    private static native boolean setReturnChildren(long var0, long var2, boolean var4);

    private static native boolean setReturnAdditionalPreviews(long var0, long var2, boolean var4);

    private static native boolean setReturnTotalOnly(long var0, long var2, boolean var4);

    private static native boolean setReturnPlaytimeStats(long var0, long var2, int var4);

    private static native boolean setLanguage(long var0, long var2, String var4);

    private static native boolean setAllowCachedResponse(long var0, long var2, int var4);

    private static native boolean setCloudFileNameFilter(long var0, long var2, String var4);

    private static native boolean setMatchAnyTag(long var0, long var2, boolean var4);

    private static native boolean setSearchText(long var0, long var2, String var4);

    private static native boolean setRankedByTrendDays(long var0, long var2, int var4);

    private static native boolean addRequiredKeyValueTag(long var0, long var2, String var4, String var5);

    private static native long requestUGCDetails(long var0, long var2, long var4, int var6);

    private static native long createItem(long var0, long var2, int var4, int var5);

    private static native long startItemUpdate(long var0, int var2, long var3);

    private static native boolean setItemTitle(long var0, long var2, String var4);

    private static native boolean setItemDescription(long var0, long var2, String var4);

    private static native boolean setItemUpdateLanguage(long var0, long var2, String var4);

    private static native boolean setItemMetadata(long var0, long var2, String var4);

    private static native boolean setItemVisibility(long var0, long var2, int var4);

    private static native boolean setItemTags(long var0, long var2, String[] var4, int var5);

    private static native boolean setItemContent(long var0, long var2, String var4);

    private static native boolean setItemPreview(long var0, long var2, String var4);

    private static native boolean removeItemKeyValueTags(long var0, long var2, String var4);

    private static native boolean addItemKeyValueTag(long var0, long var2, String var4, String var5);

    private static native long submitItemUpdate(long var0, long var2, long var4, String var6);

    private static native int getItemUpdateProgress(long var0, long var2, long[] var4);

    private static native long setUserItemVote(long var0, long var2, long var4, boolean var6);

    private static native long getUserItemVote(long var0, long var2, long var4);

    private static native long addItemToFavorites(long var0, long var2, int var4, long var5);

    private static native long removeItemFromFavorites(long var0, long var2, int var4, long var5);

    private static native long subscribeItem(long var0, long var2, long var4);

    private static native long unsubscribeItem(long var0, long var2, long var4);

    private static native int getNumSubscribedItems(long var0);

    private static native int getSubscribedItems(long var0, long[] var2, int var3);

    private static native int getItemState(long var0, long var2);

    private static native boolean getItemInstallInfo(long var0, long var2, ItemInstallInfo var4);

    private static native boolean getItemDownloadInfo(long var0, long var2, long[] var4);

    private static native long deleteItem(long var0, long var2, long var4);

    private static native boolean downloadItem(long var0, long var2, boolean var4);

    private static native boolean initWorkshopForGameServer(long var0, int var2, String var3);

    private static native void suspendDownloads(long var0, boolean var2);

    private static native long startPlaytimeTracking(long var0, long var2, long[] var4, int var5);

    private static native long stopPlaytimeTracking(long var0, long var2, long[] var4, int var5);

    private static native long stopPlaytimeTrackingForAllItems(long var0, long var2);

    public static class ItemAdditionalPreview {
        private String urlOrVideoID;
        private String originalFileName;
        private int previewType;

        public String getUrlOrVideoID() {
            return this.urlOrVideoID;
        }

        public String getOriginalFileName() {
            return this.originalFileName;
        }

        public ItemPreviewType getPreviewType() {
            return ItemPreviewType.byValue(this.previewType);
        }
    }

    public static class ItemDownloadInfo {
        long bytesDownloaded;
        long bytesTotal;

        public long getBytesDownloaded() {
            return this.bytesDownloaded;
        }

        public long getBytesTotal() {
            return this.bytesTotal;
        }
    }

    public static class ItemInstallInfo {
        private String folder;
        private int sizeOnDisk;

        public String getFolder() {
            return this.folder;
        }

        public int getSizeOnDisk() {
            return this.sizeOnDisk;
        }
    }

    public static enum ItemPreviewType {
        Image(0),
        YouTubeVideo(1),
        Sketchfab(2),
        EnvironmentMap_HorizontalCross(3),
        EnvironmentMap_LatLong(4),
        ReservedMax(255),
        UnknownPreviewType_NotImplementedByAPI(-1);

        private final int value;
        private static final ItemPreviewType[] values;

        private ItemPreviewType(int n3) {
            this.value = n3;
        }

        static ItemPreviewType byValue(int n2) {
            for (ItemPreviewType itemPreviewType : values) {
                if (itemPreviewType.value != n2) continue;
                return itemPreviewType;
            }
            return UnknownPreviewType_NotImplementedByAPI;
        }

        static {
            values = ItemPreviewType.values();
        }
    }

    public static enum ItemStatistic {
        NumSubscriptions,
        NumFavorites,
        NumFollowers,
        NumUniqueSubscriptions,
        NumUniqueFavorites,
        NumUniqueFollowers,
        NumUniqueWebsiteViews,
        ReportScore,
        NumSecondsPlayed,
        NumPlaytimeSessions,
        NumComments,
        NumSecondsPlayedDuringTimePeriod,
        NumPlaytimeSessionsDuringTimePeriod;

    }

    public static enum ItemState {
        None(0),
        Subscribed(1),
        LegacyItem(2),
        Installed(4),
        NeedsUpdate(8),
        Downloading(16),
        DownloadPending(32);

        private final int bits;
        private static final ItemState[] values;

        private ItemState(int n3) {
            this.bits = n3;
        }

        static Collection<ItemState> fromBits(int n2) {
            EnumSet<ItemState> enumSet = EnumSet.noneOf(ItemState.class);
            for (ItemState itemState : values) {
                if ((n2 & itemState.bits) != itemState.bits) continue;
                enumSet.add(itemState);
            }
            return enumSet;
        }

        static {
            values = ItemState.values();
        }
    }

    public static class ItemUpdateInfo {
        long bytesProcessed;
        long bytesTotal;

        public long getBytesProcessed() {
            return this.bytesProcessed;
        }

        public long getBytesTotal() {
            return this.bytesTotal;
        }
    }

    public static enum ItemUpdateStatus {
        Invalid,
        PreparingConfig,
        PreparingContent,
        UploadingContent,
        UploadingPreviewFile,
        CommittingChanges;

        private static final ItemUpdateStatus[] values;

        static ItemUpdateStatus byOrdinal(int n2) {
            return values[n2];
        }

        static {
            values = ItemUpdateStatus.values();
        }
    }

    public static enum UGCQueryType {
        RankedByVote,
        RankedByPublicationDate,
        AcceptedForGameRankedByAcceptanceDate,
        RankedByTrend,
        FavoritedByFriendsRankedByPublicationDate,
        CreatedByFriendsRankedByPublicationDate,
        RankedByNumTimesReported,
        CreatedByFollowedUsersRankedByPublicationDate,
        NotYetRated,
        RankedByTotalVotesAsc,
        RankedByVotesUp,
        RankedByTextSearch,
        RankedByTotalUniqueSubscriptions,
        RankedByPlaytimeTrend,
        RankedByTotalPlaytime,
        RankedByAveragePlaytimeTrend,
        RankedByLifetimeAveragePlaytime,
        RankedByPlaytimeSessionsTrend,
        RankedByLifetimePlaytimeSessions;

    }

    public static enum UserUGCListSortOrder {
        CreationOrderDesc,
        CreationOrderAsc,
        TitleAsc,
        LastUpdatedDesc,
        SubscriptionDateDesc,
        VoteScoreDesc,
        ForModeration;

    }

    public static enum MatchingUGCType {
        Items(0),
        ItemsMtx(1),
        ItemsReadyToUse(2),
        Collections(3),
        Artwork(4),
        Videos(5),
        Screenshots(6),
        AllGuides(7),
        WebGuides(8),
        IntegratedGuides(9),
        UsableInGame(10),
        ControllerBindings(11),
        GameManagedItems(12),
        All(-1);

        private final int value;

        private MatchingUGCType(int n3) {
            this.value = n3;
        }
    }

    public static enum UserUGCList {
        Published,
        VotedOn,
        VotedUp,
        VotedDown,
        WillVoteLater,
        Favorited,
        Subscribed,
        UsedOrPlayed,
        Followed;

    }
}

