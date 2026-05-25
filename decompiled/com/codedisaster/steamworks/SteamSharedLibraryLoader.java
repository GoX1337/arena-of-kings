/*
 * Decompiled with CFR 0.152.
 */
package com.codedisaster.steamworks;

import com.codedisaster.steamworks.SteamException;
import com.codedisaster.steamworks.Version;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

class SteamSharedLibraryLoader {
    private static final PLATFORM OS;
    private static final boolean IS_64_BIT;
    private static final String SHARED_LIBRARY_EXTRACT_DIRECTORY;
    private static final String SHARED_LIBRARY_EXTRACT_PATH;
    private static final String SDK_REDISTRIBUTABLE_BIN_PATH;
    private static final String SDK_LIBRARY_PATH;
    static final boolean DEBUG;

    SteamSharedLibraryLoader() {
    }

    private static String getPlatformLibName(String string) {
        switch (OS) {
            case Windows: {
                return string + (IS_64_BIT ? "64" : "") + ".dll";
            }
            case Linux: {
                return "lib" + string + ".so";
            }
            case MacOS: {
                return "lib" + string + ".dylib";
            }
        }
        throw new RuntimeException("Unknown host architecture");
    }

    static String getSdkRedistributableBinPath() {
        File file;
        switch (OS) {
            case Windows: {
                file = new File(SDK_REDISTRIBUTABLE_BIN_PATH, IS_64_BIT ? "win64" : "");
                break;
            }
            case Linux: {
                file = new File(SDK_REDISTRIBUTABLE_BIN_PATH, "linux64");
                break;
            }
            case MacOS: {
                file = new File(SDK_REDISTRIBUTABLE_BIN_PATH, "osx32");
                break;
            }
            default: {
                return null;
            }
        }
        return file.exists() ? file.getPath() : null;
    }

    static String getSdkLibraryPath() {
        File file;
        switch (OS) {
            case Windows: {
                file = new File(SDK_LIBRARY_PATH, IS_64_BIT ? "win64" : "win32");
                break;
            }
            case Linux: {
                file = new File(SDK_LIBRARY_PATH, "linux64");
                break;
            }
            case MacOS: {
                file = new File(SDK_LIBRARY_PATH, "osx32");
                break;
            }
            default: {
                return null;
            }
        }
        return file.exists() ? file.getPath() : null;
    }

    static void loadLibrary(String string, String string2) {
        try {
            Object object;
            String string3 = SteamSharedLibraryLoader.getPlatformLibName(string);
            Object object2 = SteamSharedLibraryLoader.discoverExtractLocation(SHARED_LIBRARY_EXTRACT_DIRECTORY + "/" + Version.getVersion(), string3);
            if (string2 == null) {
                SteamSharedLibraryLoader.extractLibrary((File)object2, string3);
            } else {
                object = new File(string2, string3);
                if (OS != PLATFORM.Windows) {
                    SteamSharedLibraryLoader.extractLibrary((File)object2, (File)object);
                } else {
                    object2 = object;
                }
            }
            object = ((File)object2).getCanonicalPath();
            System.load((String)object);
        }
        catch (IOException iOException) {
            throw new SteamException(iOException);
        }
    }

    private static void extractLibrary(File file, String string) {
        SteamSharedLibraryLoader.extractLibrary(file, SteamSharedLibraryLoader.class.getResourceAsStream("/" + string));
    }

    private static void extractLibrary(File file, File file2) {
        SteamSharedLibraryLoader.extractLibrary(file, new FileInputStream(file2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void extractLibrary(File file, InputStream inputStream) {
        block20: {
            if (inputStream != null) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(file);){
                    int n2;
                    byte[] byArray = new byte[4096];
                    while ((n2 = inputStream.read(byArray)) != -1) {
                        fileOutputStream.write(byArray, 0, n2);
                    }
                    fileOutputStream.close();
                    break block20;
                }
                catch (IOException iOException) {
                    if (!file.exists()) {
                        throw iOException;
                    }
                    break block20;
                }
                finally {
                    inputStream.close();
                }
            }
            throw new IOException("Failed to read input stream for " + file.getCanonicalPath());
        }
    }

    private static File discoverExtractLocation(String string, String string2) {
        File file;
        if (SHARED_LIBRARY_EXTRACT_PATH != null && SteamSharedLibraryLoader.canWrite(file = new File(SHARED_LIBRARY_EXTRACT_PATH, string2))) {
            return file;
        }
        file = new File(System.getProperty("java.io.tmpdir") + "/" + string, string2);
        if (SteamSharedLibraryLoader.canWrite(file)) {
            return file;
        }
        try {
            File file2 = File.createTempFile(string, null);
            if (file2.delete() && SteamSharedLibraryLoader.canWrite(file = new File(file2, string2))) {
                return file;
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        file = new File(System.getProperty("user.home") + "/." + string, string2);
        if (SteamSharedLibraryLoader.canWrite(file)) {
            return file;
        }
        file = new File(".tmp/" + string, string2);
        if (SteamSharedLibraryLoader.canWrite(file)) {
            return file;
        }
        throw new IOException("No suitable extraction path found");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean canWrite(File file) {
        File file2 = file.getParentFile();
        if (file.exists()) {
            if (!file.canWrite() || !SteamSharedLibraryLoader.canExecute(file)) {
                return false;
            }
        } else {
            if (!file2.exists() && !file2.mkdirs()) {
                return false;
            }
            if (!file2.isDirectory()) {
                return false;
            }
        }
        File file3 = new File(file2, UUID.randomUUID().toString());
        try {
            new FileOutputStream(file3).close();
            boolean bl2 = SteamSharedLibraryLoader.canExecute(file3);
            return bl2;
        }
        catch (IOException iOException) {
            boolean bl3 = false;
            return bl3;
        }
        finally {
            file3.delete();
        }
    }

    private static boolean canExecute(File file) {
        try {
            if (file.canExecute()) {
                return true;
            }
            if (file.setExecutable(true)) {
                return file.canExecute();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    static {
        SHARED_LIBRARY_EXTRACT_DIRECTORY = System.getProperty("com.codedisaster.steamworks.SharedLibraryExtractDirectory", "steamworks4j");
        SHARED_LIBRARY_EXTRACT_PATH = System.getProperty("com.codedisaster.steamworks.SharedLibraryExtractPath", null);
        SDK_REDISTRIBUTABLE_BIN_PATH = System.getProperty("com.codedisaster.steamworks.SDKRedistributableBinPath", "sdk/redistributable_bin");
        SDK_LIBRARY_PATH = System.getProperty("com.codedisaster.steamworks.SDKLibraryPath", "sdk/public/steam/lib");
        DEBUG = Boolean.parseBoolean(System.getProperty("com.codedisaster.steamworks.Debug", "false"));
        String string = System.getProperty("os.name");
        String string2 = System.getProperty("os.arch");
        if (string.contains("Windows")) {
            OS = PLATFORM.Windows;
        } else if (string.contains("Linux")) {
            OS = PLATFORM.Linux;
        } else if (string.contains("Mac")) {
            OS = PLATFORM.MacOS;
        } else {
            throw new RuntimeException("Unknown host architecture: " + string + ", " + string2);
        }
        IS_64_BIT = string2.equals("amd64") || string2.equals("x86_64");
    }

    static enum PLATFORM {
        Windows,
        Linux,
        MacOS;

    }
}

