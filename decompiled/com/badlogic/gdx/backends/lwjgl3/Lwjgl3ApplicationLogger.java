/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.ApplicationLogger;

public class Lwjgl3ApplicationLogger
implements ApplicationLogger {
    @Override
    public void log(String string, String string2) {
        System.out.println("[" + string + "] " + string2);
    }

    @Override
    public void log(String string, String string2, Throwable throwable) {
        System.out.println("[" + string + "] " + string2);
        throwable.printStackTrace(System.out);
    }

    @Override
    public void error(String string, String string2) {
        System.err.println("[" + string + "] " + string2);
    }

    @Override
    public void error(String string, String string2, Throwable throwable) {
        System.err.println("[" + string + "] " + string2);
        throwable.printStackTrace(System.err);
    }

    @Override
    public void debug(String string, String string2) {
        System.out.println("[" + string + "] " + string2);
    }

    @Override
    public void debug(String string, String string2, Throwable throwable) {
        System.out.println("[" + string + "] " + string2);
        throwable.printStackTrace(System.out);
    }
}

