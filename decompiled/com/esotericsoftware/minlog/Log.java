/*
 * Decompiled with CFR 0.152.
 */
package com.esotericsoftware.minlog;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Log {
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_ERROR = 5;
    public static final int LEVEL_WARN = 4;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_TRACE = 1;
    private static int level = 3;
    public static boolean ERROR = level <= 5;
    public static boolean WARN = level <= 4;
    public static boolean INFO = level <= 3;
    public static boolean DEBUG = level <= 2;
    public static boolean TRACE = level <= 1;
    private static Logger logger = new Logger();

    public static void set(int n2) {
        level = n2;
        ERROR = n2 <= 5;
        WARN = n2 <= 4;
        INFO = n2 <= 3;
        DEBUG = n2 <= 2;
        TRACE = n2 <= 1;
    }

    public static void NONE() {
        Log.set(6);
    }

    public static void ERROR() {
        Log.set(5);
    }

    public static void WARN() {
        Log.set(4);
    }

    public static void INFO() {
        Log.set(3);
    }

    public static void DEBUG() {
        Log.set(2);
    }

    public static void TRACE() {
        Log.set(1);
    }

    public static void setLogger(Logger logger) {
        Log.logger = logger;
    }

    public static void error(String string, Throwable throwable) {
        if (ERROR) {
            logger.log(5, null, string, throwable);
        }
    }

    public static void error(String string, String string2, Throwable throwable) {
        if (ERROR) {
            logger.log(5, string, string2, throwable);
        }
    }

    public static void error(String string) {
        if (ERROR) {
            logger.log(5, null, string, null);
        }
    }

    public static void error(String string, String string2) {
        if (ERROR) {
            logger.log(5, string, string2, null);
        }
    }

    public static void warn(String string, Throwable throwable) {
        if (WARN) {
            logger.log(4, null, string, throwable);
        }
    }

    public static void warn(String string, String string2, Throwable throwable) {
        if (WARN) {
            logger.log(4, string, string2, throwable);
        }
    }

    public static void warn(String string) {
        if (WARN) {
            logger.log(4, null, string, null);
        }
    }

    public static void warn(String string, String string2) {
        if (WARN) {
            logger.log(4, string, string2, null);
        }
    }

    public static void info(String string, Throwable throwable) {
        if (INFO) {
            logger.log(3, null, string, throwable);
        }
    }

    public static void info(String string, String string2, Throwable throwable) {
        if (INFO) {
            logger.log(3, string, string2, throwable);
        }
    }

    public static void info(String string) {
        if (INFO) {
            logger.log(3, null, string, null);
        }
    }

    public static void info(String string, String string2) {
        if (INFO) {
            logger.log(3, string, string2, null);
        }
    }

    public static void debug(String string, Throwable throwable) {
        if (DEBUG) {
            logger.log(2, null, string, throwable);
        }
    }

    public static void debug(String string, String string2, Throwable throwable) {
        if (DEBUG) {
            logger.log(2, string, string2, throwable);
        }
    }

    public static void debug(String string) {
        if (DEBUG) {
            logger.log(2, null, string, null);
        }
    }

    public static void debug(String string, String string2) {
        if (DEBUG) {
            logger.log(2, string, string2, null);
        }
    }

    public static void trace(String string, Throwable throwable) {
        if (TRACE) {
            logger.log(1, null, string, throwable);
        }
    }

    public static void trace(String string, String string2, Throwable throwable) {
        if (TRACE) {
            logger.log(1, string, string2, throwable);
        }
    }

    public static void trace(String string) {
        if (TRACE) {
            logger.log(1, null, string, null);
        }
    }

    public static void trace(String string, String string2) {
        if (TRACE) {
            logger.log(1, string, string2, null);
        }
    }

    private Log() {
    }

    public static class Logger {
        private final long firstLogTime = System.currentTimeMillis();

        public void log(int n2, String string, String string2, Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder(256);
            long l2 = System.currentTimeMillis() - this.firstLogTime;
            long l3 = l2 / 60000L;
            long l4 = l2 / 1000L % 60L;
            if (l3 <= 9L) {
                stringBuilder.append('0');
            }
            stringBuilder.append(l3);
            stringBuilder.append(':');
            if (l4 <= 9L) {
                stringBuilder.append('0');
            }
            stringBuilder.append(l4);
            switch (n2) {
                case 5: {
                    stringBuilder.append(" ERROR: ");
                    break;
                }
                case 4: {
                    stringBuilder.append("  WARN: ");
                    break;
                }
                case 3: {
                    stringBuilder.append("  INFO: ");
                    break;
                }
                case 2: {
                    stringBuilder.append(" DEBUG: ");
                    break;
                }
                case 1: {
                    stringBuilder.append(" TRACE: ");
                }
            }
            if (string != null) {
                stringBuilder.append('[');
                stringBuilder.append(string);
                stringBuilder.append("] ");
            }
            stringBuilder.append(string2);
            if (throwable != null) {
                StringWriter stringWriter = new StringWriter(256);
                throwable.printStackTrace(new PrintWriter(stringWriter));
                stringBuilder.append('\n');
                stringBuilder.append(stringWriter.toString().trim());
            }
            this.print(stringBuilder.toString());
        }

        protected void print(String string) {
            System.out.println(string);
        }
    }
}

