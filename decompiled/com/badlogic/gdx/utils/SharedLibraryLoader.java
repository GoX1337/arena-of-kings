/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.SharedLibraryLoadRuntimeException;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SharedLibraryLoader {
    public static boolean isWindows = System.getProperty("os.name").contains("Windows");
    public static boolean isLinux = System.getProperty("os.name").contains("Linux");
    public static boolean isMac = System.getProperty("os.name").contains("Mac");
    public static boolean isIos = false;
    public static boolean isAndroid = false;
    public static boolean isARM = System.getProperty("os.arch").startsWith("arm") || System.getProperty("os.arch").startsWith("aarch64");
    public static boolean is64Bit = System.getProperty("os.arch").contains("64") || System.getProperty("os.arch").startsWith("armv8");
    private static final HashSet<String> loadedLibraries;
    private static final Random random;
    private String nativesJar;

    public SharedLibraryLoader() {
    }

    static String randomUUID() {
        return new UUID(random.nextLong(), random.nextLong()).toString();
    }

    public SharedLibraryLoader(String string) {
        this.nativesJar = string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String crc(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        CRC32 cRC32 = new CRC32();
        byte[] byArray = new byte[4096];
        try {
            int n2;
            while ((n2 = inputStream.read(byArray)) != -1) {
                cRC32.update(byArray, 0, n2);
            }
        }
        catch (Exception exception) {
        }
        finally {
            SharedLibraryLoader.closeQuietly(inputStream);
        }
        return Long.toString(cRC32.getValue(), 16);
    }

    public String mapLibraryName(String string) {
        if (isWindows) {
            return string + (is64Bit ? "64.dll" : ".dll");
        }
        if (isLinux) {
            return "lib" + string + (isARM ? "arm" : "") + (is64Bit ? "64.so" : ".so");
        }
        if (isMac) {
            return "lib" + string + (isARM ? "arm" : "") + (is64Bit ? "64.dylib" : ".dylib");
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void load(String string) {
        if (isIos) {
            return;
        }
        Class<SharedLibraryLoader> clazz = SharedLibraryLoader.class;
        synchronized (SharedLibraryLoader.class) {
            if (SharedLibraryLoader.isLoaded(string)) {
                // ** MonitorExit[var2_2] (shouldn't be in output)
                return;
            }
            String string2 = this.mapLibraryName(string);
            try {
                if (isAndroid) {
                    System.loadLibrary(string2);
                } else {
                    this.loadFile(string2);
                }
                SharedLibraryLoader.setLoaded(string);
            }
            catch (Throwable throwable) {
                throw new SharedLibraryLoadRuntimeException("Couldn't load shared library '" + string2 + "' for target: " + (isAndroid ? "Android" : System.getProperty("os.name") + (isARM ? ", ARM" : "") + (is64Bit ? ", 64-bit" : ", 32-bit")), throwable);
            }
            return;
        }
    }

    private InputStream readFile(String string) {
        if (this.nativesJar == null) {
            InputStream inputStream = SharedLibraryLoader.class.getResourceAsStream("/" + string);
            if (inputStream == null) {
                throw new SharedLibraryLoadRuntimeException("Unable to read file for extraction: " + string);
            }
            return inputStream;
        }
        try {
            ZipFile zipFile = new ZipFile(this.nativesJar);
            ZipEntry zipEntry = zipFile.getEntry(string);
            if (zipEntry == null) {
                throw new SharedLibraryLoadRuntimeException("Couldn't find '" + string + "' in JAR: " + this.nativesJar);
            }
            return zipFile.getInputStream(zipEntry);
        }
        catch (IOException iOException) {
            throw new SharedLibraryLoadRuntimeException("Error reading '" + string + "' in JAR: " + this.nativesJar, iOException);
        }
    }

    public File extractFile(String string, String string2) {
        try {
            File file;
            String string3 = this.crc(this.readFile(string));
            if (string2 == null) {
                string2 = string3;
            }
            if ((file = this.getExtractedFile(string2, new File(string).getName())) == null && (file = this.getExtractedFile(SharedLibraryLoader.randomUUID(), new File(string).getName())) == null) {
                throw new SharedLibraryLoadRuntimeException("Unable to find writable path to extract file. Is the user home directory writable?");
            }
            return this.extractFile(string, string3, file);
        }
        catch (RuntimeException runtimeException) {
            File file = new File(System.getProperty("java.library.path"), string);
            if (file.exists()) {
                return file;
            }
            throw runtimeException;
        }
    }

    public void extractFileTo(String string, File file) {
        this.extractFile(string, this.crc(this.readFile(string)), new File(file, new File(string).getName()));
    }

    private File getExtractedFile(String string, String string2) {
        File file;
        File file2 = new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + string, string2);
        if (this.canWrite(file2)) {
            return file2;
        }
        try {
            file = File.createTempFile(string, null);
            if (file.delete() && this.canWrite(file = new File(file, string2))) {
                return file;
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        file = new File(System.getProperty("user.home") + "/.libgdx/" + string, string2);
        if (this.canWrite(file)) {
            return file;
        }
        file = new File(".temp/" + string, string2);
        if (this.canWrite(file)) {
            return file;
        }
        if (System.getenv("APP_SANDBOX_CONTAINER_ID") != null) {
            return file2;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean canWrite(File file) {
        File file2;
        File file3 = file.getParentFile();
        if (file.exists()) {
            if (!file.canWrite() || !this.canExecute(file)) {
                return false;
            }
            file2 = new File(file3, SharedLibraryLoader.randomUUID().toString());
        } else {
            file3.mkdirs();
            if (!file3.isDirectory()) {
                return false;
            }
            file2 = file;
        }
        try {
            new FileOutputStream(file2).close();
            if (!this.canExecute(file2)) {
                boolean bl2 = false;
                return bl2;
            }
            boolean bl3 = true;
            return bl3;
        }
        catch (Throwable throwable) {
            boolean bl4 = false;
            return bl4;
        }
        finally {
            file2.delete();
        }
    }

    private boolean canExecute(File file) {
        try {
            Method method = File.class.getMethod("canExecute", new Class[0]);
            if (((Boolean)method.invoke((Object)file, new Object[0])).booleanValue()) {
                return true;
            }
            Method method2 = File.class.getMethod("setExecutable", Boolean.TYPE, Boolean.TYPE);
            method2.invoke((Object)file, true, false);
            return (Boolean)method.invoke((Object)file, new Object[0]);
        }
        catch (Exception exception) {
            return false;
        }
    }

    private File extractFile(String string, String string2, File file) {
        String string3 = null;
        if (file.exists()) {
            try {
                string3 = this.crc(new FileInputStream(file));
            }
            catch (FileNotFoundException fileNotFoundException) {
                // empty catch block
            }
        }
        if (string3 == null || !string3.equals(string2)) {
            InputStream inputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                int n2;
                inputStream = this.readFile(string);
                file.getParentFile().mkdirs();
                fileOutputStream = new FileOutputStream(file);
                byte[] byArray = new byte[4096];
                while ((n2 = inputStream.read(byArray)) != -1) {
                    fileOutputStream.write(byArray, 0, n2);
                }
            }
            catch (IOException iOException) {
                try {
                    throw new SharedLibraryLoadRuntimeException("Error extracting file: " + string + "\nTo: " + file.getAbsolutePath(), iOException);
                }
                catch (Throwable throwable) {
                    SharedLibraryLoader.closeQuietly(inputStream);
                    SharedLibraryLoader.closeQuietly(fileOutputStream);
                    throw throwable;
                }
            }
            SharedLibraryLoader.closeQuietly(inputStream);
            SharedLibraryLoader.closeQuietly(fileOutputStream);
        }
        return file;
    }

    private void loadFile(String string) {
        String string2 = this.crc(this.readFile(string));
        String string3 = new File(string).getName();
        File file = new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + string2, string3);
        Throwable throwable = this.loadFile(string, string2, file);
        if (throwable == null) {
            return;
        }
        try {
            file = File.createTempFile(string2, null);
            if (file.delete() && this.loadFile(string, string2, file) == null) {
                return;
            }
        }
        catch (Throwable throwable2) {
            // empty catch block
        }
        file = new File(System.getProperty("user.home") + "/.libgdx/" + string2, string3);
        if (this.loadFile(string, string2, file) == null) {
            return;
        }
        file = new File(".temp/" + string2, string3);
        if (this.loadFile(string, string2, file) == null) {
            return;
        }
        file = new File(System.getProperty("java.library.path"), string);
        if (file.exists()) {
            System.load(file.getAbsolutePath());
            return;
        }
        throw new SharedLibraryLoadRuntimeException(throwable);
    }

    private Throwable loadFile(String string, String string2, File file) {
        try {
            System.load(this.extractFile(string, string2, file).getAbsolutePath());
            return null;
        }
        catch (Throwable throwable) {
            return throwable;
        }
    }

    public static synchronized void setLoaded(String string) {
        loadedLibraries.add(string);
    }

    public static synchronized boolean isLoaded(String string) {
        return loadedLibraries.contains(string);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    static {
        boolean bl2 = System.getProperty("moe.platform.name") != null;
        String string = System.getProperty("java.runtime.name");
        if (string != null && string.contains("Android Runtime")) {
            isAndroid = true;
            isWindows = false;
            isLinux = false;
            isMac = false;
            is64Bit = false;
        }
        if (bl2 || !isAndroid && !isWindows && !isLinux && !isMac) {
            isIos = true;
            isAndroid = false;
            isWindows = false;
            isLinux = false;
            isMac = false;
            is64Bit = false;
        }
        loadedLibraries = new HashSet();
        random = new Random();
    }
}

