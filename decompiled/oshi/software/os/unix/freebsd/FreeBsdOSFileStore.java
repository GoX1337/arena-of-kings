/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.os.unix.freebsd;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.common.AbstractOSFileStore;
import oshi.software.os.OSFileStore;
import oshi.software.os.unix.freebsd.FreeBsdFileSystem;

@ThreadSafe
public class FreeBsdOSFileStore
extends AbstractOSFileStore {
    private String logicalVolume;
    private String description;
    private String fsType;
    private long freeSpace;
    private long usableSpace;
    private long totalSpace;
    private long freeInodes;
    private long totalInodes;

    public FreeBsdOSFileStore(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, long l2, long l3, long l4, long l5, long l6) {
        super(string, string2, string3, string4, string5, string6);
        this.logicalVolume = string7;
        this.description = string8;
        this.fsType = string9;
        this.freeSpace = l2;
        this.usableSpace = l3;
        this.totalSpace = l4;
        this.freeInodes = l5;
        this.totalInodes = l6;
    }

    @Override
    public String getLogicalVolume() {
        return this.logicalVolume;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getType() {
        return this.fsType;
    }

    @Override
    public long getFreeSpace() {
        return this.freeSpace;
    }

    @Override
    public long getUsableSpace() {
        return this.usableSpace;
    }

    @Override
    public long getTotalSpace() {
        return this.totalSpace;
    }

    @Override
    public long getFreeInodes() {
        return this.freeInodes;
    }

    @Override
    public long getTotalInodes() {
        return this.totalInodes;
    }

    @Override
    public boolean updateAttributes() {
        for (OSFileStore oSFileStore : new FreeBsdFileSystem().getFileStores()) {
            if (!this.getName().equals(oSFileStore.getName()) || !this.getVolume().equals(oSFileStore.getVolume()) || !this.getMount().equals(oSFileStore.getMount())) continue;
            this.logicalVolume = oSFileStore.getLogicalVolume();
            this.description = oSFileStore.getDescription();
            this.fsType = oSFileStore.getType();
            this.freeSpace = oSFileStore.getFreeSpace();
            this.usableSpace = oSFileStore.getUsableSpace();
            this.totalSpace = oSFileStore.getTotalSpace();
            this.freeInodes = oSFileStore.getFreeInodes();
            this.totalInodes = oSFileStore.getTotalInodes();
            return true;
        }
        return false;
    }
}

