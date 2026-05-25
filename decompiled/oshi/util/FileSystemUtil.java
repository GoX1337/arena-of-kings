/*
 * Decompiled with CFR 0.152.
 */
package oshi.util;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.GlobalConfig;

@ThreadSafe
public final class FileSystemUtil {
    private static final String GLOB_PREFIX = "glob:";
    private static final String REGEX_PREFIX = "regex:";

    private FileSystemUtil() {
    }

    public static boolean isFileStoreExcluded(String string, String string2, List<PathMatcher> list, List<PathMatcher> list2, List<PathMatcher> list3, List<PathMatcher> list4) {
        Path path = Paths.get(string, new String[0]);
        Path path2 = Paths.get(string2, new String[0]);
        if (FileSystemUtil.matches(path, list) || FileSystemUtil.matches(path2, list3)) {
            return false;
        }
        return FileSystemUtil.matches(path, list2) || FileSystemUtil.matches(path2, list4);
    }

    public static List<PathMatcher> loadAndParseFileSystemConfig(String string) {
        String string2 = GlobalConfig.get(string, "");
        return FileSystemUtil.parseFileSystemConfig(string2);
    }

    public static List<PathMatcher> parseFileSystemConfig(String string) {
        FileSystem fileSystem = FileSystems.getDefault();
        ArrayList<PathMatcher> arrayList = new ArrayList<PathMatcher>();
        for (String string2 : string.split(",")) {
            if (string2.length() <= 0) continue;
            if (!string2.startsWith(GLOB_PREFIX) && !string2.startsWith(REGEX_PREFIX)) {
                string2 = GLOB_PREFIX + string2;
            }
            arrayList.add(fileSystem.getPathMatcher(string2));
        }
        return arrayList;
    }

    public static boolean matches(Path path, List<PathMatcher> list) {
        for (PathMatcher pathMatcher : list) {
            if (!pathMatcher.matches(path)) continue;
            return true;
        }
        return false;
    }
}

