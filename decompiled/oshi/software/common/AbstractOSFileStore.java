/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.common;

import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.OSFileStore;

@ThreadSafe
public abstract class AbstractOSFileStore
implements OSFileStore {
    private String name;
    private String volume;
    private String label;
    private String mount;
    private String options;
    private String uuid;

    public AbstractOSFileStore(String string, String string2, String string3, String string4, String string5, String string6) {
        this.name = string;
        this.volume = string2;
        this.label = string3;
        this.mount = string4;
        this.options = string5;
        this.uuid = string6;
    }

    protected AbstractOSFileStore() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getVolume() {
        return this.volume;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public String getMount() {
        return this.mount;
    }

    @Override
    public String getOptions() {
        return this.options;
    }

    @Override
    public String getUUID() {
        return this.uuid;
    }

    public String toString() {
        return "OSFileStore [name=" + this.getName() + ", volume=" + this.getVolume() + ", label=" + this.getLabel() + ", logicalVolume=" + this.getLogicalVolume() + ", mount=" + this.getMount() + ", description=" + this.getDescription() + ", fsType=" + this.getType() + ", options=\"" + this.getOptions() + "\", uuid=" + this.getUUID() + ", freeSpace=" + this.getFreeSpace() + ", usableSpace=" + this.getUsableSpace() + ", totalSpace=" + this.getTotalSpace() + ", freeInodes=" + this.getFreeInodes() + ", totalInodes=" + this.getTotalInodes() + "]";
    }
}

