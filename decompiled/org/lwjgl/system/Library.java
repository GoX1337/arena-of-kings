/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.lwjgl.Version;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.SharedLibraryLoader;

public final class Library {
    public static final String JNI_LIBRARY_NAME = Configuration.LIBRARY_NAME.get(Platform.mapLibraryNameBundled("lwjgl"));
    static final String JAVA_LIBRARY_PATH = "java.library.path";
    private static final Pattern PATH_SEPARATOR = Pattern.compile(File.pathSeparator);
    private static final Pattern NATIVES_JAR = Pattern.compile("/[\\w-]+?-natives-\\w+.jar!/");

    private Library() {
    }

    public static void initialize() {
    }

    public static void loadSystem(String string, String string2) {
        Library.loadSystem(System::load, System::loadLibrary, Library.class, string, string2);
    }

    public static void loadSystem(Consumer<String> consumer, Consumer<String> consumer2, Class<?> clazz, String string, String string2) {
        String string3;
        boolean bl2;
        String string4;
        block28: {
            APIUtil.apiLog("Loading JNI library: " + string2);
            APIUtil.apiLog("\tModule: " + string);
            if (Paths.get(string2, new String[0]).isAbsolute()) {
                consumer.accept(string2);
                APIUtil.apiLog("\tSuccess");
                return;
            }
            string4 = Platform.get().mapLibraryName(string2);
            URL uRL = Library.findResource(clazz, string, string4, bl2 = string2.contains("lwjgl"));
            if (uRL == null) {
                if (Library.loadSystemFromLibraryPath(consumer, clazz, string, string4, bl2)) {
                    return;
                }
            } else {
                boolean bl3 = Configuration.DEBUG_LOADER.get(false);
                try {
                    string3 = Library.getRegularFilePath(uRL);
                    if (string3 != null) {
                        consumer.accept(string3);
                        APIUtil.apiLog("\tLoaded from classpath: " + string3);
                        return;
                    }
                    if (bl3) {
                        APIUtil.apiLog("\tUsing SharedLibraryLoader...");
                    }
                    try (FileChannel fileChannel = SharedLibraryLoader.load(string2, string4, uRL, consumer);){
                        if (Library.loadSystemFromLibraryPath(consumer, clazz, string, string4, bl2)) {
                            return;
                        }
                    }
                }
                catch (Exception exception) {
                    if (!bl3) break block28;
                    exception.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        String string5 = System.getProperty(JAVA_LIBRARY_PATH);
        if (bl2 && string5 != null && Library.loadSystem(consumer, clazz, string, Library.getBundledPath(string, string4), false, JAVA_LIBRARY_PATH, string5)) {
            return;
        }
        try {
            consumer2.accept(string2);
            String string6 = string3 = string5 == null ? null : Library.findFile(string5, string, string4, bl2);
            if (string3 != null) {
                APIUtil.apiLog(String.format("\tLoaded from %s: %s", JAVA_LIBRARY_PATH, string3));
                Library.checkHash(clazz, (Path)((Object)string3));
            } else {
                APIUtil.apiLog("\tLoaded from a ClassLoader provided path.");
            }
            return;
        }
        catch (Throwable throwable) {
            APIUtil.apiLog(String.format("\t%s not found in %s", string4, JAVA_LIBRARY_PATH));
            Library.detectPlatformMismatch(clazz, string);
            Library.printError(true);
            throw new UnsatisfiedLinkError("Failed to locate library: " + string4);
        }
    }

    private static boolean loadSystemFromLibraryPath(Consumer<String> consumer, Class<?> clazz, String string, String string2, boolean bl2) {
        String string3 = Configuration.LIBRARY_PATH.get();
        return string3 != null && Library.loadSystem(consumer, clazz, string, string2, bl2, Configuration.LIBRARY_PATH.getProperty(), string3);
    }

    private static boolean loadSystem(Consumer<String> consumer, Class<?> clazz, String string, String string2, boolean bl2, String string3, String string4) {
        Path path = Library.findFile(string4, string, string2, bl2);
        if (path == null) {
            APIUtil.apiLog(String.format("\t%s not found in %s=%s", string2, string3, string4));
            return false;
        }
        consumer.accept(path.toAbsolutePath().toString());
        APIUtil.apiLog(String.format("\tLoaded from %s: %s", string3, path));
        Library.checkHash(clazz, path);
        return true;
    }

    public static SharedLibrary loadNative(String string, String string2) {
        return Library.loadNative(Library.class, string, string2);
    }

    public static SharedLibrary loadNative(Class<?> clazz, String string, String string2) {
        return Library.loadNative(clazz, string, string2, false);
    }

    public static SharedLibrary loadNative(Class<?> clazz, String string, String string2, boolean bl2) {
        return Library.loadNative(clazz, string, string2, bl2, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static SharedLibrary loadNative(Class<?> clazz, String string, String string2, boolean bl2, boolean bl3) {
        String string3;
        String string4;
        SharedLibrary sharedLibrary;
        String string5;
        block30: {
            APIUtil.apiLog("Loading library: " + string2);
            APIUtil.apiLog("\tModule: " + string);
            if (Paths.get(string2, new String[0]).isAbsolute()) {
                SharedLibrary sharedLibrary3 = APIUtil.apiCreateLibrary(string2);
                APIUtil.apiLog("\tSuccess");
                return sharedLibrary3;
            }
            string5 = Platform.get().mapLibraryName(string2);
            URL uRL = Library.findResource(clazz, string, string5, bl2);
            if (uRL == null) {
                sharedLibrary = Library.loadNativeFromLibraryPath(clazz, string, string5, bl2);
                if (sharedLibrary != null) {
                    return sharedLibrary;
                }
            } else {
                boolean bl4 = Configuration.DEBUG_LOADER.get(false);
                try {
                    string4 = Library.getRegularFilePath(uRL);
                    if (string4 != null) {
                        SharedLibrary sharedLibrary4 = APIUtil.apiCreateLibrary(string4);
                        APIUtil.apiLog("\tLoaded from classpath: " + string4);
                        return sharedLibrary4;
                    }
                    if (bl4) {
                        APIUtil.apiLog("\tUsing SharedLibraryLoader...");
                    }
                    try (FileChannel fileChannel = SharedLibraryLoader.load(string2, string5, uRL, null);){
                        sharedLibrary = Library.loadNativeFromLibraryPath(clazz, string, string5, bl2);
                        if (sharedLibrary != null) {
                            SharedLibrary sharedLibrary2 = sharedLibrary;
                            return sharedLibrary2;
                        }
                    }
                }
                catch (Exception exception) {
                    if (!bl4) break block30;
                    exception.printStackTrace(APIUtil.DEBUG_STREAM);
                }
            }
        }
        if (!bl2 && (sharedLibrary = Library.loadNativeFromSystem(string5)) != null) {
            return sharedLibrary;
        }
        if (Configuration.EMULATE_SYSTEM_LOADLIBRARY.get(false).booleanValue()) {
            try {
                Method method = ClassLoader.class.getDeclaredMethod("findLibrary", String.class);
                method.setAccessible(true);
                string4 = (String)method.invoke((Object)clazz.getClassLoader(), string2);
                if (string4 != null) {
                    sharedLibrary = APIUtil.apiCreateLibrary(string4);
                    APIUtil.apiLog(String.format("\tLoaded from ClassLoader provided path: %s", string4));
                    return sharedLibrary;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if ((string3 = System.getProperty(JAVA_LIBRARY_PATH)) != null && (sharedLibrary = Library.loadNative(clazz, string, string5, bl2, JAVA_LIBRARY_PATH, string3)) != null) {
            return sharedLibrary;
        }
        if (bl2 && (sharedLibrary = Library.loadNativeFromSystem(string5)) != null) {
            return sharedLibrary;
        }
        if (!bl3) throw new UnsatisfiedLinkError("Failed to locate library: " + string5);
        Library.detectPlatformMismatch(clazz, string);
        Library.printError(bl2);
        throw new UnsatisfiedLinkError("Failed to locate library: " + string5);
    }

    @Nullable
    private static SharedLibrary loadNativeFromSystem(String string) {
        SharedLibrary sharedLibrary;
        try {
            sharedLibrary = APIUtil.apiCreateLibrary(string);
            String string2 = sharedLibrary.getPath();
            APIUtil.apiLog(string2 == null ? "\tLoaded from system paths" : "\tLoaded from system paths: " + string2);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            sharedLibrary = null;
            APIUtil.apiLog(String.format("\t%s not found in system paths", string));
        }
        return sharedLibrary;
    }

    @Nullable
    private static SharedLibrary loadNativeFromLibraryPath(Class<?> clazz, String string, String string2, boolean bl2) {
        String string3 = Configuration.LIBRARY_PATH.get();
        if (string3 == null) {
            return null;
        }
        return Library.loadNative(clazz, string, string2, bl2, Configuration.LIBRARY_PATH.getProperty(), string3);
    }

    @Nullable
    private static SharedLibrary loadNative(Class<?> clazz, String string, String string2, boolean bl2, String string3, String string4) {
        Path path = Library.findFile(string4, string, string2, bl2);
        if (path == null) {
            APIUtil.apiLog(String.format("\t%s not found in %s=%s", string2, string3, string4));
            return null;
        }
        SharedLibrary sharedLibrary = APIUtil.apiCreateLibrary(path.toAbsolutePath().toString());
        APIUtil.apiLog(String.format("\tLoaded from %s: %s", string3, path));
        Library.checkHash(clazz, path);
        return sharedLibrary;
    }

    public static SharedLibrary loadNative(Class<?> clazz, String string, @Nullable Configuration<String> configuration, String ... stringArray) {
        return Library.loadNative(clazz, string, configuration, null, stringArray);
    }

    public static SharedLibrary loadNative(Class<?> clazz, String string, @Nullable Configuration<String> configuration, @Nullable Supplier<SharedLibrary> supplier, String ... stringArray) {
        String string2;
        if (stringArray.length == 0) {
            throw new IllegalArgumentException("No default names specified.");
        }
        if (configuration != null && (string2 = configuration.get()) != null) {
            return Library.loadNative(clazz, string, string2);
        }
        if (supplier == null && stringArray.length <= 1) {
            return Library.loadNative(clazz, string, stringArray[0]);
        }
        try {
            return Library.loadNative(clazz, string, stringArray[0], false, false);
        }
        catch (Throwable throwable) {
            for (int i2 = 1; i2 < stringArray.length; ++i2) {
                try {
                    return Library.loadNative(clazz, string, stringArray[i2], false, supplier == null && i2 == stringArray.length - 1);
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

    private static String getBundledPath(String string, String string2) {
        return Platform.mapLibraryPathBundled(string.replace('.', '/') + "/" + string2);
    }

    @Nullable
    static URL findResource(Class<?> clazz, String string, String string2, boolean bl2) {
        String string3;
        URL uRL = null;
        if (bl2 && !(string3 = Library.getBundledPath(string, string2)).equals(string2)) {
            uRL = clazz.getClassLoader().getResource(string3);
        }
        return uRL == null ? clazz.getClassLoader().getResource(string2) : uRL;
    }

    @Nullable
    static String getRegularFilePath(URL uRL) {
        if (uRL.getProtocol().equals("file")) {
            try {
                Path path = Paths.get(uRL.toURI());
                if (path.isAbsolute() && Files.isReadable(path)) {
                    return path.toString();
                }
            }
            catch (URISyntaxException uRISyntaxException) {
                // empty catch block
            }
        }
        return null;
    }

    @Nullable
    static Path findFile(String string, String string2, String string3, boolean bl2) {
        Path path;
        String string4;
        if (bl2 && !(string4 = Library.getBundledPath(string2, string3)).equals(string3) && (path = Library.findFile(string, string4)) != null) {
            return path;
        }
        return Library.findFile(string, string3);
    }

    @Nullable
    private static Path findFile(String string, String string2) {
        for (String string3 : PATH_SEPARATOR.split(string)) {
            Path path = Paths.get(string3, string2);
            if (!Files.isReadable(path)) continue;
            return path;
        }
        return null;
    }

    private static void detectPlatformMismatch(Class<?> clazz, String string) {
        String string2 = string.equals("org.lwjgl") ? "lwjgl" : "lwjgl-" + string.substring("org.lwjgl.".length());
        ArrayList<String> arrayList = new ArrayList<String>(8);
        try {
            Enumeration<URL> enumeration = clazz.getClassLoader().getResources("META-INF/MANIFEST.MF");
            while (enumeration.hasMoreElements()) {
                InputStream inputStream = enumeration.nextElement().openStream();
                Throwable throwable = null;
                try {
                    String string3;
                    Manifest manifest = new Manifest(inputStream);
                    Attributes attributes = manifest.getMainAttributes();
                    if (!string2.equals(attributes.getValue("Implementation-Title")) || (string3 = attributes.getValue("LWJGL-Platform")) == null) continue;
                    arrayList.add(string3);
                }
                catch (Throwable throwable2) {
                    throwable = throwable2;
                    throw throwable2;
                }
                finally {
                    if (inputStream == null) continue;
                    if (throwable != null) {
                        try {
                            inputStream.close();
                        }
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                        continue;
                    }
                    inputStream.close();
                }
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (!arrayList.isEmpty()) {
            APIUtil.DEBUG_STREAM.println("[LWJGL] Platform/architecture mismatch detected for module: " + string);
            APIUtil.DEBUG_STREAM.println("\tJVM platform:");
            APIUtil.DEBUG_STREAM.format("\t\t%s %s %s\n", Platform.get().getName(), System.getProperty("os.arch"), System.getProperty("java.version"));
            APIUtil.DEBUG_STREAM.format("\t\t%s v%s by %s\n", System.getProperty("java.vm.name"), System.getProperty("java.vm.version"), System.getProperty("java.vm.vendor"));
            APIUtil.DEBUG_STREAM.format("\tPlatform%s available on classpath:\n\t\t%s\n", arrayList.size() == 1 ? "" : "s", String.join((CharSequence)"\n\t\t", arrayList));
        }
    }

    private static void printError(boolean bl2) {
        Library.printError("[LWJGL] Failed to load a library. Possible solutions:\n" + (bl2 ? "\ta) Add the directory that contains the shared library to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the shared library to the classpath." : "\ta) Install the library or the driver that provides the library.\n\tb) Ensure that the library is accessible from the system library paths."));
    }

    static void printError(String string) {
        APIUtil.DEBUG_STREAM.println(string);
        if (!Checks.DEBUG) {
            APIUtil.DEBUG_STREAM.println("[LWJGL] Enable debug mode with -Dorg.lwjgl.util.Debug=true for better diagnostics.");
            if (!Configuration.DEBUG_LOADER.get(false).booleanValue()) {
                APIUtil.DEBUG_STREAM.println("[LWJGL] Enable the SharedLibraryLoader debug mode with -Dorg.lwjgl.util.DebugLoader=true for better diagnostics.");
            }
        }
    }

    private static void checkHash(Class<?> clazz, Path path) {
        block7: {
            if (!Checks.CHECKS) {
                return;
            }
            try {
                byte[] byArray;
                Object object;
                Object object2 = null;
                Object object3 = null;
                Enumeration<URL> enumeration = clazz.getClassLoader().getResources(path.getFileName() + ".sha1");
                while (enumeration.hasMoreElements()) {
                    object = enumeration.nextElement();
                    if (NATIVES_JAR.matcher(((URL)object).toExternalForm()).find()) {
                        object3 = object;
                        continue;
                    }
                    object2 = object;
                }
                if (object2 == null) {
                    return;
                }
                object = Library.getSHA1(object2);
                byte[] byArray2 = byArray = Checks.DEBUG || object3 == null ? Library.getSHA1(path) : Library.getSHA1(object3);
                if (!Arrays.equals((byte[])object, byArray)) {
                    APIUtil.DEBUG_STREAM.println("[LWJGL] [ERROR] Incompatible Java and native library versions detected.\nPossible reasons:\n\ta) -Djava.library.path is set to a folder containing shared libraries of an older LWJGL version.\n\tb) The classpath contains jar files of an older LWJGL version.\nPossible solutions:\n\ta) Make sure to not set -Djava.library.path (it is not needed for developing with LWJGL 3) or make\n\t   sure the folder it points to contains the shared libraries of the correct LWJGL version.\n\tb) Check the classpath and make sure to only have jar files of the same LWJGL version in it.");
                }
            }
            catch (Throwable throwable) {
                if (!Checks.DEBUG) break block7;
                APIUtil.apiLog("Failed to verify native library.");
                throwable.printStackTrace();
            }
        }
    }

    private static byte[] getSHA1(URL uRL) {
        byte[] byArray = new byte[20];
        try (InputStream inputStream = uRL.openStream();){
            for (int i2 = 0; i2 < 20; ++i2) {
                byArray[i2] = (byte)(Character.digit(inputStream.read(), 16) << 4 | Character.digit(inputStream.read(), 16));
            }
        }
        return byArray;
    }

    private static byte[] getSHA1(Path path) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        try (InputStream inputStream = Files.newInputStream(path, new OpenOption[0]);){
            int n2;
            byte[] byArray = new byte[8192];
            while ((n2 = inputStream.read(byArray)) != -1) {
                messageDigest.update(byArray, 0, n2);
            }
        }
        return messageDigest.digest();
    }

    static {
        if (Checks.DEBUG) {
            APIUtil.apiLog("Version: " + Version.getVersion());
            APIUtil.apiLog("\t OS: " + System.getProperty("os.name") + " v" + System.getProperty("os.version"));
            APIUtil.apiLog("\tJRE: " + Platform.get().getName() + " " + System.getProperty("os.arch") + " " + System.getProperty("java.version"));
            APIUtil.apiLog("\tJVM: " + System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor"));
        }
        Library.loadSystem("org.lwjgl", JNI_LIBRARY_NAME);
    }
}

