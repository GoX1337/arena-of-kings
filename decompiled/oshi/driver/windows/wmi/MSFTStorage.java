/*
 * Decompiled with CFR 0.152.
 */
package oshi.driver.windows.wmi;

import com.sun.jna.platform.win32.COM.WbemcliUtil;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.platform.windows.WmiQueryHandler;

@ThreadSafe
public final class MSFTStorage {
    private static final String STORAGE_NAMESPACE = "ROOT\\Microsoft\\Windows\\Storage";
    private static final String MSFT_STORAGE_POOL_WHERE_IS_PRIMORDIAL_FALSE = "MSFT_StoragePool WHERE IsPrimordial=FALSE";
    private static final String MSFT_STORAGE_POOL_TO_PHYSICAL_DISK = "MSFT_StoragePoolToPhysicalDisk";
    private static final String MSFT_PHYSICAL_DISK = "MSFT_PhysicalDisk";
    private static final String MSFT_VIRTUAL_DISK = "MSFT_VirtualDisk";

    private MSFTStorage() {
    }

    public static WbemcliUtil.WmiResult<StoragePoolProperty> queryStoragePools(WmiQueryHandler wmiQueryHandler) {
        WbemcliUtil.WmiQuery<StoragePoolProperty> wmiQuery = new WbemcliUtil.WmiQuery<StoragePoolProperty>(STORAGE_NAMESPACE, MSFT_STORAGE_POOL_WHERE_IS_PRIMORDIAL_FALSE, StoragePoolProperty.class);
        return wmiQueryHandler.queryWMI(wmiQuery, false);
    }

    public static WbemcliUtil.WmiResult<StoragePoolToPhysicalDiskProperty> queryStoragePoolPhysicalDisks(WmiQueryHandler wmiQueryHandler) {
        WbemcliUtil.WmiQuery<StoragePoolToPhysicalDiskProperty> wmiQuery = new WbemcliUtil.WmiQuery<StoragePoolToPhysicalDiskProperty>(STORAGE_NAMESPACE, MSFT_STORAGE_POOL_TO_PHYSICAL_DISK, StoragePoolToPhysicalDiskProperty.class);
        return wmiQueryHandler.queryWMI(wmiQuery, false);
    }

    public static WbemcliUtil.WmiResult<PhysicalDiskProperty> queryPhysicalDisks(WmiQueryHandler wmiQueryHandler) {
        WbemcliUtil.WmiQuery<PhysicalDiskProperty> wmiQuery = new WbemcliUtil.WmiQuery<PhysicalDiskProperty>(STORAGE_NAMESPACE, MSFT_PHYSICAL_DISK, PhysicalDiskProperty.class);
        return wmiQueryHandler.queryWMI(wmiQuery, false);
    }

    public static WbemcliUtil.WmiResult<VirtualDiskProperty> queryVirtualDisks(WmiQueryHandler wmiQueryHandler) {
        WbemcliUtil.WmiQuery<VirtualDiskProperty> wmiQuery = new WbemcliUtil.WmiQuery<VirtualDiskProperty>(STORAGE_NAMESPACE, MSFT_VIRTUAL_DISK, VirtualDiskProperty.class);
        return wmiQueryHandler.queryWMI(wmiQuery, false);
    }

    public static enum StoragePoolProperty {
        FRIENDLYNAME,
        OBJECTID;

    }

    public static enum StoragePoolToPhysicalDiskProperty {
        STORAGEPOOL,
        PHYSICALDISK;

    }

    public static enum PhysicalDiskProperty {
        FRIENDLYNAME,
        PHYSICALLOCATION,
        OBJECTID;

    }

    public static enum VirtualDiskProperty {
        FRIENDLYNAME,
        OBJECTID;

    }
}

