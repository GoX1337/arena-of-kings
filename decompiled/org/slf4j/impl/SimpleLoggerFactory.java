/*
 * Decompiled with CFR 0.152.
 */
package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.impl.SimpleLogger;

public class SimpleLoggerFactory
implements ILoggerFactory {
    ConcurrentMap<String, Logger> loggerMap = new ConcurrentHashMap<String, Logger>();

    public SimpleLoggerFactory() {
        SimpleLogger.lazyInit();
    }

    public Logger getLogger(String string) {
        Logger logger = (Logger)this.loggerMap.get(string);
        if (logger != null) {
            return logger;
        }
        SimpleLogger simpleLogger = new SimpleLogger(string);
        Logger logger2 = this.loggerMap.putIfAbsent(string, simpleLogger);
        return logger2 == null ? simpleLogger : logger2;
    }

    void reset() {
        this.loggerMap.clear();
    }
}

