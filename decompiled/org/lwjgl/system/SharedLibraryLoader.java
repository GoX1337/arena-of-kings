/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.GuardedBy
 */
package org.lwjgl.system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.zip.CRC32;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.lwjgl.Version;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Platform;

final class SharedLibraryLoader {
    private static final Lock EXTRACT_PATH_LOCK = new ReentrantLock();
    @Nullable
    @GuardedBy(value="EXTRACT_PATH_LOCK")
    private static Path extractPath;
    private static HashSet<Path> extractPaths;
    private static boolean checkedJDK8195129;

    private SharedLibraryLoader() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static FileChannel load(String string, String string2, URL uRL, @Nullable Consumer<String> consumer) {
        try {
            Path path;
            EXTRACT_PATH_LOCK.lock();
            try {
                if (extractPath != null) {
                    path = extractPath.resolve(string2);
                } else {
                    path = SharedLibraryLoader.getExtractPath(string2, uRL, consumer);
                    Path path2 = path.getParent();
                    if (Platform.get() != Platform.WINDOWS || checkedJDK8195129) {
                        extractPath = path2;
                    }
                    SharedLibraryLoader.initExtractPath(path2);
                }
            }
            finally {
                EXTRACT_PATH_LOCK.unlock();
            }
            return SharedLibraryLoader.extract(path, uRL);
        }
        catch (Exception exception) {
            throw new RuntimeException("\tFailed to extract " + string + " library", exception);
        }
    }

    private static void initExtractPath(Path path) {
        if (extractPaths.contains(path)) {
            return;
        }
        extractPaths.add(path);
        String string = path.toAbsolutePath().toString();
        String string2 = Configuration.LIBRARY_PATH.get();
        if (string2 != null && !string2.isEmpty()) {
            string = string + File.pathSeparator + string2;
        }
        System.setProperty(Configuration.LIBRARY_PATH.getProperty(), string);
        Configuration.LIBRARY_PATH.set(string);
    }

    private static Path getExtractPath(String string, URL uRL, @Nullable Consumer<String> consumer) {
        Path path;
        Path path2;
        String string2 = Configuration.SHARED_LIBRARY_EXTRACT_PATH.get();
        if (string2 != null) {
            path2 = Paths.get(string2, new String[0]);
            if (SharedLibraryLoader.canWrite(path2, path = path2.resolve(string), uRL, consumer)) {
                return path;
            }
            APIUtil.apiLog(String.format("\tThe path %s is not accessible. Trying other paths.", string2));
        }
        String string3 = Version.getVersion().replace(' ', '-');
        path2 = Paths.get(System.getProperty("java.io.tmpdir"), new String[0]);
        if (SharedLibraryLoader.canWrite(path2, path = path2.resolve(Paths.get(Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY.get("lwjgl" + System.getProperty("user.name")), string3, string)), uRL, consumer)) {
            return path;
        }
        Path path3 = Paths.get("." + Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY.get("lwjgl"), string3, string);
        path2 = Paths.get("", new String[0]).toAbsolutePath();
        if (SharedLibraryLoader.canWrite(path2, path = path2.resolve(path3), uRL, consumer)) {
            return path;
        }
        path2 = Paths.get(System.getProperty("user.home"), new String[0]);
        if (SharedLibraryLoader.canWrite(path2, path = path2.resolve(path3), uRL, consumer)) {
            return path;
        }
        if (Platform.get() == Platform.WINDOWS) {
            String string4 = System.getenv("SystemRoot");
            if (string4 != null && SharedLibraryLoader.canWrite(path2 = Paths.get(string4, "Temp"), path = path2.resolve(path3), uRL, consumer)) {
                return path;
            }
            string4 = System.getenv("SystemDrive");
            if (string4 != null && SharedLibraryLoader.canWrite(path2 = Paths.get(string4 + "/", new String[0]), path = path2.resolve(Paths.get("Temp", new String[0]).resolve(path3)), uRL, consumer)) {
                return path;
            }
        }
        try {
            path = Files.createTempDirectory("lwjgl", new FileAttribute[0]);
            path2 = path.getParent();
            path = path.resolve(string);
            if (SharedLibraryLoader.canWrite(path2, path, uRL, consumer)) {
                return path;
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        throw new RuntimeException("Failed to find an appropriate directory to extract the native library");
    }

    private static FileChannel extract(Path path, URL uRL) {
        Throwable throwable;
        InputStream inputStream;
        if (Files.exists(path, new LinkOption[0])) {
            inputStream = uRL.openStream();
            throwable = null;
            try (InputStream inputStream2 = Files.newInputStream(path, new OpenOption[0]);){
                if (SharedLibraryLoader.crc(inputStream) == SharedLibraryLoader.crc(inputStream2)) {
                    if (Configuration.DEBUG_LOADER.get(false).booleanValue()) {
                        APIUtil.apiLog(String.format("\tFound at: %s", path));
                    }
                    FileChannel fileChannel = SharedLibraryLoader.lock(path);
                    return fileChannel;
                }
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                if (inputStream != null) {
                    if (throwable != null) {
                        try {
                            inputStream.close();
                        }
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                    } else {
                        inputStream.close();
                    }
                }
            }
        }
        APIUtil.apiLog(String.format("\tExtracting: %s", uRL.getPath()));
        if (extractPath == null) {
            APIUtil.apiLog(String.format("\t        to: %s", path));
        }
        Files.createDirectories(path.getParent(), new FileAttribute[0]);
        inputStream = uRL.openStream();
        throwable = null;
        try {
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Throwable throwable4) {
            throwable = throwable4;
            throw throwable4;
        }
        finally {
            if (inputStream != null) {
                if (throwable != null) {
                    try {
                        inputStream.close();
                    }
                    catch (Throwable throwable5) {
                        throwable.addSuppressed(throwable5);
                    }
                } else {
                    inputStream.close();
                }
            }
        }
        return SharedLibraryLoader.lock(path);
    }

    private static FileChannel lock(Path path) {
        try {
            FileChannel fileChannel = FileChannel.open(path, new OpenOption[0]);
            if (fileChannel.tryLock(0L, Long.MAX_VALUE, true) == null) {
                if (Configuration.DEBUG_LOADER.get(false).booleanValue()) {
                    APIUtil.apiLog("\tFile is locked by another process, waiting...");
                }
                fileChannel.lock(0L, Long.MAX_VALUE, true);
            }
            return fileChannel;
        }
        catch (Exception exception) {
            throw new RuntimeException("Failed to lock file.", exception);
        }
    }

    private static long crc(InputStream inputStream) {
        int n2;
        CRC32 cRC32 = new CRC32();
        byte[] byArray = new byte[8192];
        while ((n2 = inputStream.read(byArray)) != -1) {
            cRC32.update(byArray, 0, n2);
        }
        return cRC32.getValue();
    }

    private static boolean canWrite(Path path, Path path2, URL uRL, @Nullable Consumer<String> consumer) {
        Path path3;
        if (Files.exists(path2, new LinkOption[0])) {
            if (!Files.isWritable(path2)) {
                return false;
            }
            path3 = path2.getParent().resolve(".lwjgl.test");
        } else {
            try {
                Files.createDirectories(path2.getParent(), new FileAttribute[0]);
            }
            catch (IOException iOException) {
                return false;
            }
            path3 = path2;
        }
        try {
            Files.write(path3, new byte[0], new OpenOption[0]);
            Files.delete(path3);
            if (consumer != null && Platform.get() == Platform.WINDOWS) {
                SharedLibraryLoader.workaroundJDK8195129(path2, uRL, consumer);
            }
            return true;
        }
        catch (Throwable throwable) {
            if (path2 == path3) {
                SharedLibraryLoader.canWriteCleanup(path, path2);
            }
            return false;
        }
    }

    private static void canWriteCleanup(Path path, Path path2) {
        try {
            Files.deleteIfExists(path2);
            Path path3 = path2.getParent();
            while (!Files.isSameFile(path3, path)) {
                block17: {
                    try (Stream<Path> stream = Files.list(path3);){
                        if (!stream.findAny().isPresent()) break block17;
                        break;
                    }
                }
                Files.delete(path3);
                path3 = path3.getParent();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    private static void workaroundJDK8195129(Path path, URL uRL, @Nonnull Consumer<String> consumer) {
        String string = path.toAbsolutePath().toString();
        if (string.endsWith(".dll")) {
            boolean bl2 = false;
            for (int i2 = 0; i2 < string.length(); ++i2) {
                if ('\u0080' > string.charAt(i2)) continue;
                bl2 = true;
            }
            if (bl2) {
                try (FileChannel fileChannel = SharedLibraryLoader.extract(path, uRL);){
                    consumer.accept(path.toAbsolutePath().toString());
                }
            }
            checkedJDK8195129 = true;
        }
    }

    static {
        extractPaths = new HashSet(4);
    }
}

