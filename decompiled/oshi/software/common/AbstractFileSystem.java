/*
 * Decompiled with CFR 0.152.
 */
package oshi.software.common;

import java.util.Arrays;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.util.GlobalConfig;

@ThreadSafe
public abstract class AbstractFileSystem
implements FileSystem {
    public static final String OSHI_NETWORK_FILESYSTEM_TYPES = "oshi.network.filesystem.types";
    public static final String OSHI_PSEUDO_FILESYSTEM_TYPES = "oshi.pseudo.filesystem.types";
    public static final List<String> NETWORK_FS_TYPES = Arrays.asList(GlobalConfig.get("oshi.network.filesystem.types", "").split(","));
    public static final List<String> PSEUDO_FS_TYPES = Arrays.asList(GlobalConfig.get("oshi.pseudo.filesystem.types", "").split(","));

    @Override
    public List<OSFileStore> getFileStores() {
        return this.getFileStores(false);
    }
}

