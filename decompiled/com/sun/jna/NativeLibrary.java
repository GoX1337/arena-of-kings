/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Function;
import com.sun.jna.FunctionMapper;
import com.sun.jna.LastErrorException;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NativeLibrary {
    private static final Logger LOG = Logger.getLogger(NativeLibrary.class.getName());
    private static final Level DEBUG_LOAD_LEVEL = Native.DEBUG_LOAD ? Level.INFO : Level.FINE;
    private long handle;
    private final String libraryName;
    private final String libraryPath;
    private final Map<String, Function> functions = new HashMap<String, Function>();
    final int callFlags;
    private String encoding;
    final Map<String, ?> options;
    private static final Map<String, Reference<NativeLibrary>> libraries = new HashMap<String, Reference<NativeLibrary>>();
    private static final Map<String, List<String>> searchPaths = Collections.synchronizedMap(new HashMap());
    private static final LinkedHashSet<String> librarySearchPath = new LinkedHashSet();
    private static final int DEFAULT_OPEN_OPTIONS = -1;
    private static Method addSuppressedMethod;

    private static String functionKey(String string, int n2, String string2) {
        return string + "|" + n2 + "|" + string2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private NativeLibrary(String string, String string2, long l2, Map<String, ?> map) {
        int n2;
        this.libraryName = this.getLibraryName(string);
        this.libraryPath = string2;
        this.handle = l2;
        Object obj = map.get("calling-convention");
        this.callFlags = n2 = obj instanceof Number ? ((Number)obj).intValue() : 0;
        this.options = map;
        this.encoding = (String)map.get("string-encoding");
        if (this.encoding == null) {
            this.encoding = Native.getDefaultStringEncoding();
        }
        if (Platform.isWindows() && "kernel32".equals(this.libraryName.toLowerCase())) {
            Map<String, Function> map2 = this.functions;
            synchronized (map2) {
                Function function = new Function(this, "GetLastError", 63, this.encoding){

                    @Override
                    Object invoke(Object[] objectArray, Class<?> clazz, boolean bl2, int n2) {
                        return Native.getLastError();
                    }

                    @Override
                    Object invoke(Method method, Class<?>[] classArray, Class<?> clazz, Object[] objectArray, Map<String, ?> map) {
                        return Native.getLastError();
                    }
                };
                this.functions.put(NativeLibrary.functionKey("GetLastError", this.callFlags, this.encoding), function);
            }
        }
    }

    private static int openFlags(Map<String, ?> map) {
        Object obj = map.get("open-flags");
        if (obj instanceof Number) {
            return ((Number)obj).intValue();
        }
        return -1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static NativeLibrary loadLibrary(String string, Map<String, ?> map) {
        long l2;
        String string2;
        block40: {
            Object object;
            LOG.log(DEBUG_LOAD_LEVEL, "Looking for library '" + string + "'");
            ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
            boolean bl2 = new File(string).isAbsolute();
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
            int n2 = NativeLibrary.openFlags(map);
            List<String> list = searchPaths.get(string);
            if (list != null) {
                object = list;
                synchronized (object) {
                    linkedHashSet.addAll(list);
                }
            }
            if ((object = Native.getWebStartLibraryPath(string)) != null) {
                LOG.log(DEBUG_LOAD_LEVEL, "Adding web start path " + (String)object);
                linkedHashSet.add((String)object);
            }
            LOG.log(DEBUG_LOAD_LEVEL, "Adding paths from jna.library.path: " + System.getProperty("jna.library.path"));
            linkedHashSet.addAll(NativeLibrary.initPaths("jna.library.path"));
            string2 = NativeLibrary.findLibraryPath(string, linkedHashSet);
            l2 = 0L;
            try {
                LOG.log(DEBUG_LOAD_LEVEL, "Trying " + string2);
                l2 = Native.open(string2, n2);
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError.getMessage());
                LOG.log(DEBUG_LOAD_LEVEL, "Adding system paths: " + librarySearchPath);
                arrayList.add(unsatisfiedLinkError);
                linkedHashSet.addAll(librarySearchPath);
            }
            try {
                if (l2 == 0L) {
                    string2 = NativeLibrary.findLibraryPath(string, linkedHashSet);
                    LOG.log(DEBUG_LOAD_LEVEL, "Trying " + string2);
                    l2 = Native.open(string2, n2);
                    if (l2 == 0L) {
                        throw new UnsatisfiedLinkError("Failed to load library '" + string + "'");
                    }
                }
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                Object object2;
                LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError.getMessage());
                arrayList.add(unsatisfiedLinkError);
                if (Platform.isAndroid()) {
                    try {
                        LOG.log(DEBUG_LOAD_LEVEL, "Preload (via System.loadLibrary) " + string);
                        System.loadLibrary(string);
                        l2 = Native.open(string2, n2);
                    }
                    catch (UnsatisfiedLinkError unsatisfiedLinkError2) {
                        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError2.getMessage());
                        arrayList.add(unsatisfiedLinkError2);
                    }
                } else if (Platform.isLinux() || Platform.isFreeBSD()) {
                    LOG.log(DEBUG_LOAD_LEVEL, "Looking for version variants");
                    string2 = NativeLibrary.matchLibrary(string, linkedHashSet);
                    if (string2 != null) {
                        LOG.log(DEBUG_LOAD_LEVEL, "Trying " + string2);
                        try {
                            l2 = Native.open(string2, n2);
                        }
                        catch (UnsatisfiedLinkError unsatisfiedLinkError3) {
                            LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError3.getMessage());
                            arrayList.add(unsatisfiedLinkError3);
                        }
                    }
                } else if (Platform.isMac() && !string.endsWith(".dylib")) {
                    for (String object3 : NativeLibrary.matchFramework(string)) {
                        try {
                            LOG.log(DEBUG_LOAD_LEVEL, "Trying " + (String)object3);
                            l2 = Native.open(object3, n2);
                            break;
                        }
                        catch (UnsatisfiedLinkError unsatisfiedLinkError2) {
                            LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError2.getMessage());
                            arrayList.add(unsatisfiedLinkError2);
                        }
                    }
                } else if (Platform.isWindows() && !bl2) {
                    LOG.log(DEBUG_LOAD_LEVEL, "Looking for lib- prefix");
                    string2 = NativeLibrary.findLibraryPath("lib" + string, linkedHashSet);
                    if (string2 != null) {
                        LOG.log(DEBUG_LOAD_LEVEL, "Trying " + string2);
                        try {
                            l2 = Native.open(string2, n2);
                        }
                        catch (UnsatisfiedLinkError unsatisfiedLinkError5) {
                            LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + unsatisfiedLinkError5.getMessage());
                            arrayList.add(unsatisfiedLinkError5);
                        }
                    }
                }
                if (l2 == 0L) {
                    try {
                        object2 = Native.extractFromResourcePath(string, (ClassLoader)map.get("classloader"));
                        try {
                            l2 = Native.open(((File)object2).getAbsolutePath(), n2);
                            string2 = ((File)object2).getAbsolutePath();
                        }
                        finally {
                            if (Native.isUnpacked((File)object2)) {
                                Native.deleteLibrary((File)object2);
                            }
                        }
                    }
                    catch (IOException iOException) {
                        LOG.log(DEBUG_LOAD_LEVEL, "Loading failed with message: " + iOException.getMessage());
                        arrayList.add(iOException);
                    }
                }
                if (l2 != 0L) break block40;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unable to load library '");
                ((StringBuilder)object2).append(string);
                ((StringBuilder)object2).append("':");
                for (Throwable throwable : arrayList) {
                    ((StringBuilder)object2).append("\n");
                    ((StringBuilder)object2).append(throwable.getMessage());
                }
                UnsatisfiedLinkError unsatisfiedLinkError6 = new UnsatisfiedLinkError(((StringBuilder)object2).toString());
                for (Throwable throwable : arrayList) {
                    NativeLibrary.addSuppressedReflected(unsatisfiedLinkError6, throwable);
                }
                throw unsatisfiedLinkError6;
            }
        }
        LOG.log(DEBUG_LOAD_LEVEL, "Found library '" + string + "' at " + string2);
        return new NativeLibrary(string, string2, l2, map);
    }

    private static void addSuppressedReflected(Throwable throwable, Throwable throwable2) {
        if (addSuppressedMethod == null) {
            return;
        }
        try {
            addSuppressedMethod.invoke((Object)throwable, throwable2);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("Failed to call addSuppressedMethod", illegalAccessException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new RuntimeException("Failed to call addSuppressedMethod", illegalArgumentException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException("Failed to call addSuppressedMethod", invocationTargetException);
        }
    }

    static String[] matchFramework(String string) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        File file = new File(string);
        if (file.isAbsolute()) {
            if (string.contains(".framework")) {
                if (file.exists()) {
                    return new String[]{file.getAbsolutePath()};
                }
                linkedHashSet.add(file.getAbsolutePath());
            } else {
                if ((file = new File(new File(file.getParentFile(), file.getName() + ".framework"), file.getName())).exists()) {
                    return new String[]{file.getAbsolutePath()};
                }
                linkedHashSet.add(file.getAbsolutePath());
            }
        } else {
            String[] stringArray = new String[]{System.getProperty("user.home"), "", "/System"};
            String string2 = !string.contains(".framework") ? string + ".framework/" + string : string;
            for (String string3 : stringArray) {
                file = new File(string3 + "/Library/Frameworks/" + string2);
                if (file.exists()) {
                    return new String[]{file.getAbsolutePath()};
                }
                linkedHashSet.add(file.getAbsolutePath());
            }
        }
        return linkedHashSet.toArray(new String[0]);
    }

    private String getLibraryName(String string) {
        String string2;
        int n2;
        String string3 = string;
        String string4 = "---";
        String string5 = NativeLibrary.mapSharedLibraryName("---");
        int n3 = string5.indexOf("---");
        if (n3 > 0 && string3.startsWith(string5.substring(0, n3))) {
            string3 = string3.substring(n3);
        }
        if ((n2 = string3.indexOf(string2 = string5.substring(n3 + "---".length()))) != -1) {
            string3 = string3.substring(0, n2);
        }
        return string3;
    }

    public static final NativeLibrary getInstance(String string) {
        return NativeLibrary.getInstance(string, Collections.emptyMap());
    }

    public static final NativeLibrary getInstance(String string, ClassLoader classLoader) {
        return NativeLibrary.getInstance(string, Collections.singletonMap("classloader", classLoader));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final NativeLibrary getInstance(String string, Map<String, ?> map) {
        HashMap hashMap = new HashMap(map);
        if (hashMap.get("calling-convention") == null) {
            hashMap.put("calling-convention", 0);
        }
        if ((Platform.isLinux() || Platform.isFreeBSD() || Platform.isAIX()) && Platform.C_LIBRARY_NAME.equals(string)) {
            string = null;
        }
        Map<String, Reference<NativeLibrary>> map2 = libraries;
        synchronized (map2) {
            NativeLibrary nativeLibrary;
            Reference<NativeLibrary> reference = libraries.get(string + hashMap);
            NativeLibrary nativeLibrary2 = nativeLibrary = reference != null ? reference.get() : null;
            if (nativeLibrary == null) {
                nativeLibrary = string == null ? new NativeLibrary("<process>", null, Native.open(null, NativeLibrary.openFlags(hashMap)), hashMap) : NativeLibrary.loadLibrary(string, hashMap);
                reference = new WeakReference<NativeLibrary>(nativeLibrary);
                libraries.put(nativeLibrary.getName() + hashMap, reference);
                File file = nativeLibrary.getFile();
                if (file != null) {
                    libraries.put(file.getAbsolutePath() + hashMap, reference);
                    libraries.put(file.getName() + hashMap, reference);
                }
            }
            return nativeLibrary;
        }
    }

    public static final synchronized NativeLibrary getProcess() {
        return NativeLibrary.getInstance(null);
    }

    public static final synchronized NativeLibrary getProcess(Map<String, ?> map) {
        return NativeLibrary.getInstance(null, map);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void addSearchPath(String string, String string2) {
        Map<String, List<String>> map = searchPaths;
        synchronized (map) {
            List<String> list = searchPaths.get(string);
            if (list == null) {
                list = Collections.synchronizedList(new ArrayList());
                searchPaths.put(string, list);
            }
            list.add(string2);
        }
    }

    public Function getFunction(String string) {
        return this.getFunction(string, this.callFlags);
    }

    Function getFunction(String string, Method method) {
        String string2;
        FunctionMapper functionMapper = (FunctionMapper)this.options.get("function-mapper");
        if (functionMapper != null) {
            string = functionMapper.getFunctionName(this, method);
        }
        if (string.startsWith(string2 = System.getProperty("jna.profiler.prefix", "$$YJP$$"))) {
            string = string.substring(string2.length());
        }
        int n2 = this.callFlags;
        Class<?>[] classArray = method.getExceptionTypes();
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            if (!LastErrorException.class.isAssignableFrom(classArray[i2])) continue;
            n2 |= 0x40;
        }
        return this.getFunction(string, n2);
    }

    public Function getFunction(String string, int n2) {
        return this.getFunction(string, n2, this.encoding);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Function getFunction(String string, int n2, String string2) {
        if (string == null) {
            throw new NullPointerException("Function name may not be null");
        }
        Map<String, Function> map = this.functions;
        synchronized (map) {
            String string3 = NativeLibrary.functionKey(string, n2, string2);
            Function function = this.functions.get(string3);
            if (function == null) {
                function = new Function(this, string, n2, string2);
                this.functions.put(string3, function);
            }
            return function;
        }
    }

    public Map<String, ?> getOptions() {
        return this.options;
    }

    public Pointer getGlobalVariableAddress(String string) {
        try {
            return new Pointer(this.getSymbolAddress(string));
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            throw new UnsatisfiedLinkError("Error looking up '" + string + "': " + unsatisfiedLinkError.getMessage());
        }
    }

    long getSymbolAddress(String string) {
        if (this.handle == 0L) {
            throw new UnsatisfiedLinkError("Library has been unloaded");
        }
        return Native.findSymbol(this.handle, string);
    }

    public String toString() {
        return "Native Library <" + this.libraryPath + "@" + this.handle + ">";
    }

    public String getName() {
        return this.libraryName;
    }

    public File getFile() {
        if (this.libraryPath == null) {
            return null;
        }
        return new File(this.libraryPath);
    }

    protected void finalize() {
        this.dispose();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void disposeAll() {
        LinkedHashSet<Reference<NativeLibrary>> linkedHashSet;
        Map<String, Reference<NativeLibrary>> map = libraries;
        synchronized (map) {
            linkedHashSet = new LinkedHashSet<Reference<NativeLibrary>>(libraries.values());
        }
        for (Reference reference : linkedHashSet) {
            NativeLibrary nativeLibrary = (NativeLibrary)reference.get();
            if (nativeLibrary == null) continue;
            nativeLibrary.dispose();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dispose() {
        HashSet hashSet = new HashSet();
        Object object = libraries;
        synchronized (object) {
            for (Map.Entry<String, Reference<NativeLibrary>> entry : libraries.entrySet()) {
                Reference<NativeLibrary> reference = entry.getValue();
                if (reference.get() != this) continue;
                hashSet.add(entry.getKey());
            }
            for (Map.Entry<String, Reference<NativeLibrary>> entry : hashSet) {
                libraries.remove(entry);
            }
        }
        object = this;
        synchronized (object) {
            if (this.handle != 0L) {
                Native.close(this.handle);
                this.handle = 0L;
            }
        }
    }

    private static List<String> initPaths(String string) {
        String string2 = System.getProperty(string, "");
        if ("".equals(string2)) {
            return Collections.emptyList();
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string2, File.pathSeparator);
        ArrayList<String> arrayList = new ArrayList<String>();
        while (stringTokenizer.hasMoreTokens()) {
            String string3 = stringTokenizer.nextToken();
            if ("".equals(string3)) continue;
            arrayList.add(string3);
        }
        return arrayList;
    }

    private static String findLibraryPath(String string, Collection<String> collection) {
        if (new File(string).isAbsolute()) {
            return string;
        }
        String string2 = NativeLibrary.mapSharedLibraryName(string);
        for (String string3 : collection) {
            File file = new File(string3, string2);
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            if (!Platform.isMac() || !string2.endsWith(".dylib") || !(file = new File(string3, string2.substring(0, string2.lastIndexOf(".dylib")) + ".jnilib")).exists()) continue;
            return file.getAbsolutePath();
        }
        return string2;
    }

    static String mapSharedLibraryName(String string) {
        if (Platform.isMac()) {
            if (string.startsWith("lib") && (string.endsWith(".dylib") || string.endsWith(".jnilib"))) {
                return string;
            }
            String string2 = System.mapLibraryName(string);
            if (string2.endsWith(".jnilib")) {
                return string2.substring(0, string2.lastIndexOf(".jnilib")) + ".dylib";
            }
            return string2;
        }
        if (Platform.isLinux() || Platform.isFreeBSD() ? NativeLibrary.isVersionedName(string) || string.endsWith(".so") : (Platform.isAIX() ? string.startsWith("lib") : Platform.isWindows() && (string.endsWith(".drv") || string.endsWith(".dll") || string.endsWith(".ocx")))) {
            return string;
        }
        return System.mapLibraryName(string);
    }

    private static boolean isVersionedName(String string) {
        int n2;
        if (string.startsWith("lib") && (n2 = string.lastIndexOf(".so.")) != -1 && n2 + 4 < string.length()) {
            for (int i2 = n2 + 4; i2 < string.length(); ++i2) {
                char c2 = string.charAt(i2);
                if (Character.isDigit(c2) || c2 == '.') continue;
                return false;
            }
            return true;
        }
        return false;
    }

    static String matchLibrary(final String string, Collection<String> collection) {
        Object object;
        File file = new File(string);
        if (file.isAbsolute()) {
            collection = Arrays.asList(file.getParent());
        }
        FilenameFilter filenameFilter = new FilenameFilter(){

            @Override
            public boolean accept(File file, String string2) {
                return (string2.startsWith("lib" + string + ".so") || string2.startsWith(string + ".so") && string.startsWith("lib")) && NativeLibrary.isVersionedName(string2);
            }
        };
        LinkedList<File> linkedList = new LinkedList<File>();
        for (String string2 : collection) {
            object = new File(string2).listFiles(filenameFilter);
            if (object == null || ((File[])object).length <= 0) continue;
            linkedList.addAll(Arrays.asList(object));
        }
        double d2 = -1.0;
        object = null;
        for (File file2 : linkedList) {
            String string3 = file2.getAbsolutePath();
            String string4 = string3.substring(string3.lastIndexOf(".so.") + 4);
            double d3 = NativeLibrary.parseVersion(string4);
            if (!(d3 > d2)) continue;
            d2 = d3;
            object = string3;
        }
        return object;
    }

    static double parseVersion(String string) {
        double d2 = 0.0;
        double d3 = 1.0;
        int n2 = string.indexOf(".");
        while (string != null) {
            String string2;
            if (n2 != -1) {
                string2 = string.substring(0, n2);
                string = string.substring(n2 + 1);
                n2 = string.indexOf(".");
            } else {
                string2 = string;
                string = null;
            }
            try {
                d2 += (double)Integer.parseInt(string2) / d3;
            }
            catch (NumberFormatException numberFormatException) {
                return 0.0;
            }
            d3 *= 100.0;
        }
        return d2;
    }

    private static String getMultiArchPath() {
        String string = Platform.ARCH;
        String string2 = Platform.iskFreeBSD() ? "-kfreebsd" : (Platform.isGNU() ? "" : "-linux");
        String string3 = "-gnu";
        if (Platform.isIntel()) {
            string = Platform.is64Bit() ? "x86_64" : "i386";
        } else if (Platform.isPPC()) {
            string = Platform.is64Bit() ? "powerpc64" : "powerpc";
        } else if (Platform.isARM()) {
            string = "arm";
            string3 = "-gnueabi";
        } else if (Platform.ARCH.equals("mips64el")) {
            string3 = "-gnuabi64";
        }
        return string + string2 + string3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ArrayList<String> getLinuxLdPaths() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Process process = null;
        BufferedReader bufferedReader = null;
        try {
            String string;
            process = Runtime.getRuntime().exec("/sbin/ldconfig -p");
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((string = bufferedReader.readLine()) != null) {
                String string2;
                int n2 = string.indexOf(" => ");
                int n3 = string.lastIndexOf(47);
                if (n2 == -1 || n3 == -1 || n2 >= n3 || arrayList.contains(string2 = string.substring(n2 + 4, n3))) continue;
                arrayList.add(string2);
            }
        }
        catch (Exception exception) {
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException iOException) {}
            }
            if (process != null) {
                try {
                    process.waitFor();
                }
                catch (InterruptedException interruptedException) {}
            }
        }
        return arrayList;
    }

    static {
        if (Native.POINTER_SIZE == 0) {
            throw new Error("Native library not initialized");
        }
        addSuppressedMethod = null;
        try {
            addSuppressedMethod = Throwable.class.getMethod("addSuppressed", Throwable.class);
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (SecurityException securityException) {
            Logger.getLogger(NativeLibrary.class.getName()).log(Level.SEVERE, "Failed to initialize 'addSuppressed' method", securityException);
        }
        String string = Native.getWebStartLibraryPath("jnidispatch");
        if (string != null) {
            librarySearchPath.add(string);
        }
        if (System.getProperty("jna.platform.library.path") == null && !Platform.isWindows()) {
            Object object;
            String string2 = "";
            String string3 = "";
            String string4 = "";
            if (Platform.isLinux() || Platform.isSolaris() || Platform.isFreeBSD() || Platform.iskFreeBSD()) {
                string4 = (Platform.isSolaris() ? "/" : "") + Native.POINTER_SIZE * 8;
            }
            String[] stringArray = new String[]{"/usr/lib" + string4, "/lib" + string4, "/usr/lib", "/lib"};
            if (Platform.isLinux() || Platform.iskFreeBSD() || Platform.isGNU()) {
                object = NativeLibrary.getMultiArchPath();
                stringArray = new String[]{"/usr/lib/" + (String)object, "/lib/" + (String)object, "/usr/lib" + string4, "/lib" + string4, "/usr/lib", "/lib"};
            }
            if (Platform.isLinux()) {
                object = NativeLibrary.getLinuxLdPaths();
                for (int i2 = stringArray.length - 1; 0 <= i2; --i2) {
                    int n2 = ((ArrayList)object).indexOf(stringArray[i2]);
                    if (n2 != -1) {
                        ((ArrayList)object).remove(n2);
                    }
                    ((ArrayList)object).add(0, stringArray[i2]);
                }
                stringArray = ((ArrayList)object).toArray(new String[0]);
            }
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                File file = new File(stringArray[i3]);
                if (!file.exists() || !file.isDirectory()) continue;
                string2 = string2 + string3 + stringArray[i3];
                string3 = File.pathSeparator;
            }
            if (!"".equals(string2)) {
                System.setProperty("jna.platform.library.path", string2);
            }
        }
        librarySearchPath.addAll(NativeLibrary.initPaths("jna.platform.library.path"));
    }
}

