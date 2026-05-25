/*
 * Decompiled with CFR 0.152.
 */
package org.slf4j.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.AccessController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import org.slf4j.helpers.Util;

public class SimpleLoggerConfiguration {
    private static final String CONFIGURATION_FILE = "simplelogger.properties";
    static int DEFAULT_LOG_LEVEL_DEFAULT = 20;
    int defaultLogLevel = DEFAULT_LOG_LEVEL_DEFAULT;
    private static final boolean SHOW_DATE_TIME_DEFAULT = false;
    boolean showDateTime = false;
    private static final String DATE_TIME_FORMAT_STR_DEFAULT;
    private static String dateTimeFormatStr;
    DateFormat dateFormatter = null;
    private static final boolean SHOW_THREAD_NAME_DEFAULT = true;
    boolean showThreadName = true;
    static final boolean SHOW_LOG_NAME_DEFAULT = true;
    boolean showLogName = true;
    private static final boolean SHOW_SHORT_LOG_NAME_DEFAULT = false;
    boolean showShortLogName = false;
    private static final boolean LEVEL_IN_BRACKETS_DEFAULT = false;
    boolean levelInBrackets = false;
    private static String LOG_FILE_DEFAULT;
    private String logFile = LOG_FILE_DEFAULT;
    bzh outputChoice = null;
    private static final boolean CACHE_OUTPUT_STREAM_DEFAULT = false;
    private boolean cacheOutputStream = false;
    private static final String WARN_LEVELS_STRING_DEFAULT = "WARN";
    String warnLevelString = "WARN";
    private final Properties properties = new Properties();

    void init() {
        this.loadProperties();
        String string = this.getStringProperty("org.slf4j.simpleLogger.defaultLogLevel", null);
        if (string != null) {
            this.defaultLogLevel = SimpleLoggerConfiguration.stringToLevel(string);
        }
        this.showLogName = this.getBooleanProperty("org.slf4j.simpleLogger.showLogName", true);
        this.showShortLogName = this.getBooleanProperty("org.slf4j.simpleLogger.showShortLogName", false);
        this.showDateTime = this.getBooleanProperty("org.slf4j.simpleLogger.showDateTime", false);
        this.showThreadName = this.getBooleanProperty("org.slf4j.simpleLogger.showThreadName", true);
        dateTimeFormatStr = this.getStringProperty("org.slf4j.simpleLogger.dateTimeFormat", DATE_TIME_FORMAT_STR_DEFAULT);
        this.levelInBrackets = this.getBooleanProperty("org.slf4j.simpleLogger.levelInBrackets", false);
        this.warnLevelString = this.getStringProperty("org.slf4j.simpleLogger.warnLevelString", WARN_LEVELS_STRING_DEFAULT);
        this.logFile = this.getStringProperty("org.slf4j.simpleLogger.logFile", this.logFile);
        this.cacheOutputStream = this.getBooleanProperty("org.slf4j.simpleLogger.cacheOutputStream", false);
        this.outputChoice = SimpleLoggerConfiguration.computeOutputChoice(this.logFile, this.cacheOutputStream);
        if (dateTimeFormatStr != null) {
            try {
                this.dateFormatter = new SimpleDateFormat(dateTimeFormatStr);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                Util.report("Bad date format in simplelogger.properties; will output relative time", illegalArgumentException);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void loadProperties() {
        InputStream inputStream = AccessController.doPrivileged(new bzi(this));
        if (null != inputStream) {
            try {
                this.properties.load(inputStream);
            }
            catch (IOException iOException) {
            }
            finally {
                try {
                    inputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    String getStringProperty(String string, String string2) {
        String string3 = this.getStringProperty(string);
        return string3 == null ? string2 : string3;
    }

    boolean getBooleanProperty(String string, boolean bl2) {
        String string2 = this.getStringProperty(string);
        return string2 == null ? bl2 : "true".equalsIgnoreCase(string2);
    }

    String getStringProperty(String string) {
        String string2 = null;
        try {
            string2 = System.getProperty(string);
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        return string2 == null ? this.properties.getProperty(string) : string2;
    }

    static int stringToLevel(String string) {
        if ("trace".equalsIgnoreCase(string)) {
            return 0;
        }
        if ("debug".equalsIgnoreCase(string)) {
            return 10;
        }
        if ("info".equalsIgnoreCase(string)) {
            return 20;
        }
        if ("warn".equalsIgnoreCase(string)) {
            return 30;
        }
        if ("error".equalsIgnoreCase(string)) {
            return 40;
        }
        if ("off".equalsIgnoreCase(string)) {
            return 50;
        }
        return 20;
    }

    private static bzh computeOutputChoice(String string, boolean bl2) {
        if ("System.err".equalsIgnoreCase(string)) {
            if (bl2) {
                return new bzh(bzh.a.d);
            }
            return new bzh(bzh.a.c);
        }
        if ("System.out".equalsIgnoreCase(string)) {
            if (bl2) {
                return new bzh(bzh.a.b);
            }
            return new bzh(bzh.a.var_bzh$a_a);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            PrintStream printStream = new PrintStream(fileOutputStream);
            return new bzh(printStream);
        }
        catch (FileNotFoundException fileNotFoundException) {
            Util.report("Could not open [" + string + "]. Defaulting to System.err", fileNotFoundException);
            return new bzh(bzh.a.c);
        }
    }

    static {
        dateTimeFormatStr = DATE_TIME_FORMAT_STR_DEFAULT = null;
        LOG_FILE_DEFAULT = "System.err";
    }
}

