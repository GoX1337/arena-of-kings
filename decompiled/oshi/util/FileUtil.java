/*
 * Decompiled with CFR 0.152.
 */
package oshi.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.annotation.concurrent.ThreadSafe;
import oshi.util.ParseUtil;

@ThreadSafe
public final class FileUtil {
    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);
    private static final String READING_LOG = "Reading file {}";
    private static final String READ_LOG = "Read {}";

    private FileUtil() {
    }

    public static List<String> readFile(String string) {
        return FileUtil.readFile(string, true);
    }

    public static List<String> readFile(String string, boolean bl2) {
        if (new File(string).canRead()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(READING_LOG, (Object)string);
            }
            try {
                return Files.readAllLines(Paths.get(string, new String[0]), StandardCharsets.UTF_8);
            }
            catch (IOException iOException) {
                if (bl2) {
                    LOG.error("Error reading file {}. {}", (Object)string, (Object)iOException.getMessage());
                } else {
                    LOG.debug("Error reading file {}. {}", (Object)string, (Object)iOException.getMessage());
                }
            }
        } else if (bl2) {
            LOG.warn("File not found or not readable: {}", (Object)string);
        }
        return new ArrayList<String>();
    }

    public static byte[] readAllBytes(String string) {
        return FileUtil.readAllBytes(string, true);
    }

    public static byte[] readAllBytes(String string, boolean bl2) {
        if (new File(string).canRead()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(READING_LOG, (Object)string);
            }
            try {
                return Files.readAllBytes(Paths.get(string, new String[0]));
            }
            catch (IOException iOException) {
                if (bl2) {
                    LOG.error("Error reading file {}. {}", (Object)string, (Object)iOException.getMessage());
                } else {
                    LOG.debug("Error reading file {}. {}", (Object)string, (Object)iOException.getMessage());
                }
            }
        } else if (bl2) {
            LOG.warn("File not found or not readable: {}", (Object)string);
        }
        return new byte[0];
    }

    public static long getLongFromFile(String string) {
        List<String> list;
        if (LOG.isDebugEnabled()) {
            LOG.debug(READING_LOG, (Object)string);
        }
        if (!(list = FileUtil.readFile(string, false)).isEmpty()) {
            if (LOG.isTraceEnabled()) {
                LOG.trace(READ_LOG, (Object)list.get(0));
            }
            return ParseUtil.parseLongOrDefault(list.get(0), 0L);
        }
        return 0L;
    }

    public static long getUnsignedLongFromFile(String string) {
        List<String> list;
        if (LOG.isDebugEnabled()) {
            LOG.debug(READING_LOG, (Object)string);
        }
        if (!(list = FileUtil.readFile(string, false)).isEmpty()) {
            if (LOG.isTraceEnabled()) {
                LOG.trace(READ_LOG, (Object)list.get(0));
            }
            return ParseUtil.parseUnsignedLongOrDefault(list.get(0), 0L);
        }
        return 0L;
    }

    public static int getIntFromFile(String string) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(READING_LOG, (Object)string);
        }
        try {
            List<String> list = FileUtil.readFile(string, false);
            if (!list.isEmpty()) {
                if (LOG.isTraceEnabled()) {
                    LOG.trace(READ_LOG, (Object)list.get(0));
                }
                return Integer.parseInt(list.get(0));
            }
        }
        catch (NumberFormatException numberFormatException) {
            LOG.warn("Unable to read value from {}. {}", (Object)string, (Object)numberFormatException.getMessage());
        }
        return 0;
    }

    public static String getStringFromFile(String string) {
        List<String> list;
        if (LOG.isDebugEnabled()) {
            LOG.debug(READING_LOG, (Object)string);
        }
        if (!(list = FileUtil.readFile(string, false)).isEmpty()) {
            if (LOG.isTraceEnabled()) {
                LOG.trace(READ_LOG, (Object)list.get(0));
            }
            return list.get(0);
        }
        return "";
    }

    public static Map<String, String> getKeyValueMapFromFile(String string, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (LOG.isDebugEnabled()) {
            LOG.debug(READING_LOG, (Object)string);
        }
        List<String> list = FileUtil.readFile(string, false);
        for (String string3 : list) {
            String[] stringArray = string3.split(string2);
            if (stringArray.length != 2) continue;
            hashMap.put(stringArray[0], stringArray[1].trim());
        }
        return hashMap;
    }

    public static Properties readPropertiesFromFilename(String string) {
        Properties properties = new Properties();
        for (ClassLoader classLoader : Stream.of(Thread.currentThread().getContextClassLoader(), ClassLoader.getSystemClassLoader(), FileUtil.class.getClassLoader()).collect(Collectors.toCollection(LinkedHashSet::new))) {
            if (!FileUtil.readPropertiesFromClassLoader(string, properties, classLoader)) continue;
            return properties;
        }
        LOG.warn("Failed to load default configuration");
        return properties;
    }

    private static boolean readPropertiesFromClassLoader(String string, Properties properties, ClassLoader classLoader) {
        if (classLoader == null) {
            return false;
        }
        try {
            ArrayList<URL> arrayList = Collections.list(classLoader.getResources(string));
            if (arrayList.isEmpty()) {
                LOG.debug("No {} file found from ClassLoader {}", (Object)string, (Object)classLoader);
                return false;
            }
            if (arrayList.size() > 1) {
                LOG.warn("Configuration conflict: there is more than one {} file on the classpath", (Object)string);
                return true;
            }
            try (InputStream inputStream = ((URL)arrayList.get(0)).openStream();){
                if (inputStream != null) {
                    properties.load(inputStream);
                }
            }
            return true;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public static String readSymlinkTarget(File file) {
        try {
            return Files.readSymbolicLink(Paths.get(file.getAbsolutePath(), new String[0])).toString();
        }
        catch (IOException iOException) {
            return null;
        }
    }
}

