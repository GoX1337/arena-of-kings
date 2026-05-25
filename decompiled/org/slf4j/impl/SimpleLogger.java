/*
 * Decompiled with CFR 0.152.
 */
package org.slf4j.impl;

import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Date;
import org.slf4j.event.LoggingEvent;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.impl.SimpleLoggerConfiguration;

public class SimpleLogger
extends MarkerIgnoringBase {
    private static final long serialVersionUID = -632788891211436180L;
    private static long START_TIME = System.currentTimeMillis();
    protected static final int LOG_LEVEL_TRACE = 0;
    protected static final int LOG_LEVEL_DEBUG = 10;
    protected static final int LOG_LEVEL_INFO = 20;
    protected static final int LOG_LEVEL_WARN = 30;
    protected static final int LOG_LEVEL_ERROR = 40;
    protected static final int LOG_LEVEL_OFF = 50;
    private static boolean INITIALIZED = false;
    static SimpleLoggerConfiguration CONFIG_PARAMS = null;
    protected int currentLogLevel = 20;
    private transient String shortLogName = null;
    public static final String SYSTEM_PREFIX = "org.slf4j.simpleLogger.";
    public static final String LOG_KEY_PREFIX = "org.slf4j.simpleLogger.log.";
    public static final String CACHE_OUTPUT_STREAM_STRING_KEY = "org.slf4j.simpleLogger.cacheOutputStream";
    public static final String WARN_LEVEL_STRING_KEY = "org.slf4j.simpleLogger.warnLevelString";
    public static final String LEVEL_IN_BRACKETS_KEY = "org.slf4j.simpleLogger.levelInBrackets";
    public static final String LOG_FILE_KEY = "org.slf4j.simpleLogger.logFile";
    public static final String SHOW_SHORT_LOG_NAME_KEY = "org.slf4j.simpleLogger.showShortLogName";
    public static final String SHOW_LOG_NAME_KEY = "org.slf4j.simpleLogger.showLogName";
    public static final String SHOW_THREAD_NAME_KEY = "org.slf4j.simpleLogger.showThreadName";
    public static final String DATE_TIME_FORMAT_KEY = "org.slf4j.simpleLogger.dateTimeFormat";
    public static final String SHOW_DATE_TIME_KEY = "org.slf4j.simpleLogger.showDateTime";
    public static final String DEFAULT_LOG_LEVEL_KEY = "org.slf4j.simpleLogger.defaultLogLevel";

    static void lazyInit() {
        if (INITIALIZED) {
            return;
        }
        INITIALIZED = true;
        SimpleLogger.init();
    }

    static void init() {
        CONFIG_PARAMS = new SimpleLoggerConfiguration();
        CONFIG_PARAMS.init();
    }

    SimpleLogger(String string) {
        this.name = string;
        String string2 = this.recursivelyComputeLevelString();
        this.currentLogLevel = string2 != null ? SimpleLoggerConfiguration.stringToLevel(string2) : SimpleLogger.CONFIG_PARAMS.defaultLogLevel;
    }

    String recursivelyComputeLevelString() {
        String string = this.name;
        String string2 = null;
        int n2 = string.length();
        while (string2 == null && n2 > -1) {
            string = string.substring(0, n2);
            string2 = CONFIG_PARAMS.getStringProperty(LOG_KEY_PREFIX + string, null);
            n2 = String.valueOf(string).lastIndexOf(".");
        }
        return string2;
    }

    private void log(int n2, String string, Throwable throwable) {
        if (!this.isLevelEnabled(n2)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        if (SimpleLogger.CONFIG_PARAMS.showDateTime) {
            if (SimpleLogger.CONFIG_PARAMS.dateFormatter != null) {
                stringBuilder.append(this.getFormattedDate());
                stringBuilder.append(' ');
            } else {
                stringBuilder.append(System.currentTimeMillis() - START_TIME);
                stringBuilder.append(' ');
            }
        }
        if (SimpleLogger.CONFIG_PARAMS.showThreadName) {
            stringBuilder.append('[');
            stringBuilder.append(Thread.currentThread().getName());
            stringBuilder.append("] ");
        }
        if (SimpleLogger.CONFIG_PARAMS.levelInBrackets) {
            stringBuilder.append('[');
        }
        String string2 = this.renderLevel(n2);
        stringBuilder.append(string2);
        if (SimpleLogger.CONFIG_PARAMS.levelInBrackets) {
            stringBuilder.append(']');
        }
        stringBuilder.append(' ');
        if (SimpleLogger.CONFIG_PARAMS.showShortLogName) {
            if (this.shortLogName == null) {
                this.shortLogName = this.computeShortName();
            }
            stringBuilder.append(String.valueOf(this.shortLogName)).append(" - ");
        } else if (SimpleLogger.CONFIG_PARAMS.showLogName) {
            stringBuilder.append(String.valueOf(this.name)).append(" - ");
        }
        stringBuilder.append(string);
        this.write(stringBuilder, throwable);
    }

    protected String renderLevel(int n2) {
        switch (n2) {
            case 0: {
                return "TRACE";
            }
            case 10: {
                return "DEBUG";
            }
            case 20: {
                return "INFO";
            }
            case 30: {
                return SimpleLogger.CONFIG_PARAMS.warnLevelString;
            }
            case 40: {
                return "ERROR";
            }
        }
        throw new IllegalStateException("Unrecognized level [" + n2 + "]");
    }

    void write(StringBuilder stringBuilder, Throwable throwable) {
        PrintStream printStream = SimpleLogger.CONFIG_PARAMS.outputChoice.a();
        printStream.println(stringBuilder.toString());
        this.writeThrowable(throwable, printStream);
        printStream.flush();
    }

    protected void writeThrowable(Throwable throwable, PrintStream printStream) {
        if (throwable != null) {
            throwable.printStackTrace(printStream);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String getFormattedDate() {
        String string;
        Date date = new Date();
        DateFormat dateFormat = SimpleLogger.CONFIG_PARAMS.dateFormatter;
        synchronized (dateFormat) {
            string = SimpleLogger.CONFIG_PARAMS.dateFormatter.format(date);
        }
        return string;
    }

    private String computeShortName() {
        return this.name.substring(this.name.lastIndexOf(".") + 1);
    }

    private void formatAndLog(int n2, String string, Object object, Object object2) {
        if (!this.isLevelEnabled(n2)) {
            return;
        }
        FormattingTuple formattingTuple = MessageFormatter.format(string, object, object2);
        this.log(n2, formattingTuple.getMessage(), formattingTuple.getThrowable());
    }

    private void formatAndLog(int n2, String string, Object ... objectArray) {
        if (!this.isLevelEnabled(n2)) {
            return;
        }
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(string, objectArray);
        this.log(n2, formattingTuple.getMessage(), formattingTuple.getThrowable());
    }

    protected boolean isLevelEnabled(int n2) {
        return n2 >= this.currentLogLevel;
    }

    public boolean isTraceEnabled() {
        return this.isLevelEnabled(0);
    }

    public void trace(String string) {
        this.log(0, string, null);
    }

    public void trace(String string, Object object) {
        this.formatAndLog(0, string, object, (Object)null);
    }

    public void trace(String string, Object object, Object object2) {
        this.formatAndLog(0, string, object, object2);
    }

    public void trace(String string, Object ... objectArray) {
        this.formatAndLog(0, string, objectArray);
    }

    public void trace(String string, Throwable throwable) {
        this.log(0, string, throwable);
    }

    public boolean isDebugEnabled() {
        return this.isLevelEnabled(10);
    }

    public void debug(String string) {
        this.log(10, string, null);
    }

    public void debug(String string, Object object) {
        this.formatAndLog(10, string, object, (Object)null);
    }

    public void debug(String string, Object object, Object object2) {
        this.formatAndLog(10, string, object, object2);
    }

    public void debug(String string, Object ... objectArray) {
        this.formatAndLog(10, string, objectArray);
    }

    public void debug(String string, Throwable throwable) {
        this.log(10, string, throwable);
    }

    public boolean isInfoEnabled() {
        return this.isLevelEnabled(20);
    }

    public void info(String string) {
        this.log(20, string, null);
    }

    public void info(String string, Object object) {
        this.formatAndLog(20, string, object, (Object)null);
    }

    public void info(String string, Object object, Object object2) {
        this.formatAndLog(20, string, object, object2);
    }

    public void info(String string, Object ... objectArray) {
        this.formatAndLog(20, string, objectArray);
    }

    public void info(String string, Throwable throwable) {
        this.log(20, string, throwable);
    }

    public boolean isWarnEnabled() {
        return this.isLevelEnabled(30);
    }

    public void warn(String string) {
        this.log(30, string, null);
    }

    public void warn(String string, Object object) {
        this.formatAndLog(30, string, object, (Object)null);
    }

    public void warn(String string, Object object, Object object2) {
        this.formatAndLog(30, string, object, object2);
    }

    public void warn(String string, Object ... objectArray) {
        this.formatAndLog(30, string, objectArray);
    }

    public void warn(String string, Throwable throwable) {
        this.log(30, string, throwable);
    }

    public boolean isErrorEnabled() {
        return this.isLevelEnabled(40);
    }

    public void error(String string) {
        this.log(40, string, null);
    }

    public void error(String string, Object object) {
        this.formatAndLog(40, string, object, (Object)null);
    }

    public void error(String string, Object object, Object object2) {
        this.formatAndLog(40, string, object, object2);
    }

    public void error(String string, Object ... objectArray) {
        this.formatAndLog(40, string, objectArray);
    }

    public void error(String string, Throwable throwable) {
        this.log(40, string, throwable);
    }

    public void log(LoggingEvent loggingEvent) {
        int n2 = loggingEvent.getLevel().toInt();
        if (!this.isLevelEnabled(n2)) {
            return;
        }
        FormattingTuple formattingTuple = MessageFormatter.arrayFormat(loggingEvent.getMessage(), loggingEvent.getArgumentArray(), loggingEvent.getThrowable());
        this.log(n2, formattingTuple.getMessage(), loggingEvent.getThrowable());
    }
}

