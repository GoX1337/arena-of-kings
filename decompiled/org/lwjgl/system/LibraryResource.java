/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Library;
import org.lwjgl.system.SharedLibraryLoader;

public final class LibraryResource {
    private LibraryResource() {
    }

    public static Path load(String string, String string2) {
        return LibraryResource.load(LibraryResource.class, string, string2);
    }

    public static Path load(Class<?> clazz, String string, String string2) {
        return LibraryResource.load(clazz, string, string2, false, true);
    }

    public static Path load(Class<?> clazz, String string, String string2, boolean bl2) {
        return LibraryResource.load(clazz, string, string2, bl2, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Path load(Class<?> clazz, String string, String string2, boolean bl2, boolean bl3) {
        String string3;
        Path path;
        block25: {
            APIUtil.apiLog("Loading library resource: " + string2);
            APIUtil.apiLog("\tModule: " + string);
            path = Paths.get(string2, new String[0]);
            if (path.isAbsolute()) {
                if (!Files.exists(path, new LinkOption[0])) {
                    if (!bl3) throw new IllegalStateException("Failed to locate library resource: " + string2);
                    LibraryResource.printError();
                    throw new IllegalStateException("Failed to locate library resource: " + string2);
                }
                APIUtil.apiLog("\tSuccess");
                return path;
            }
            URL uRL = Library.findResource(clazz, string, string2, bl2);
            if (uRL == null) {
                path = LibraryResource.loadFromLibraryPath(string, string2, bl2);
                if (path != null) {
                    return path;
                }
            } else {
                boolean bl4 = Configuration.DEBUG_LOADER.get(false);
                try {
                    String string4 = Library.getRegularFilePath(uRL);
                    if (string4 != null) {
                        APIUtil.apiLog("\tLoaded from classpath: " + string4);
                        return Paths.get(string4, new String[0]);
                    }
                    if (bl4) {
                        APIUtil.apiLog("\tUsing SharedLibraryLoader...");
                    }
                    try (FileChannel fileChannel = SharedLibraryLoader.load(string2, string2, uRL, null);){
                        path = LibraryResource.loadFromLibraryPath(string, string2, bl2);
                        if (path != null) {
                            Path path2 = path;
                            return path2;
                        }
                    }
                }
                catch (Exception exception) {
                    if (!bl4) break block25;
                    exception.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        if ((string3 = System.getProperty("java.library.path")) != null && (path = LibraryResource.load(string, string2, bl2, "java.library.path", string3)) != null) {
            return path;
        }
        if (!bl3) throw new IllegalStateException("Failed to locate library resource: " + string2);
        LibraryResource.printError();
        throw new IllegalStateException("Failed to locate library resource: " + string2);
    }

    @Nullable
    private static Path loadFromLibraryPath(String string, String string2, boolean bl2) {
        String string3 = Configuration.LIBRARY_PATH.get();
        if (string3 == null) {
            return null;
        }
        return LibraryResource.load(string, string2, bl2, Configuration.LIBRARY_PATH.getProperty(), string3);
    }

    @Nullable
    private static Path load(String string, String string2, boolean bl2, String string3, String string4) {
        Path path = Library.findFile(string4, string, string2, bl2);
        if (path == null) {
            APIUtil.apiLog(String.format("\t%s not found in %s=%s", string2, string3, string4));
            return null;
        }
        APIUtil.apiLog(String.format("\tLoaded from %s: %s", string3, path));
        return path;
    }

    public static Path load(Class<?> clazz, String string, Configuration<String> configuration, String ... stringArray) {
        return LibraryResource.load(clazz, string, configuration, null, stringArray);
    }

    public static Path load(Class<?> clazz, String string, Configuration<String> configuration, @Nullable Supplier<Path> supplier, String ... stringArray) {
        if (stringArray.length == 0) {
            throw new IllegalArgumentException("No default names specified.");
        }
        String string2 = configuration.get();
        if (string2 != null) {
            return LibraryResource.load(clazz, string, string2);
        }
        if (supplier == null && stringArray.length <= 1) {
            return LibraryResource.load(clazz, string, stringArray[0]);
        }
        try {
            return LibraryResource.load(clazz, string, stringArray[0], false, false);
        }
        catch (Throwable throwable) {
            for (int i2 = 1; i2 < stringArray.length; ++i2) {
                try {
                    return LibraryResource.load(clazz, string, stringArray[i2], false, supplier == null && i2 == stringArray.length - 1);
                }
                catch (Throwable throwable2) {
                    continue;
                }
            }
            if (supplier != null) {
                return supplier.get();
            }
            throw throwable;
        }
    }

    private static void printError() {
        Library.printError("[LWJGL] Failed to load a library resource. Possible solutions:\n\ta) Add the directory that contains the resource to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the resource to the classpath.");
    }

    static {
        Library.initialize();
    }
}

