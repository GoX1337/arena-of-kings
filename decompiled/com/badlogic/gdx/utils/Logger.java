/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.Gdx;

public class Logger {
    public static final int NONE = 0;
    public static final int ERROR = 1;
    public static final int INFO = 2;
    public static final int DEBUG = 3;
    private final String tag;
    private int level;

    public Logger(String string) {
        this(string, 1);
    }

    public Logger(String string, int n2) {
        this.tag = string;
        this.level = n2;
    }

    public void debug(String string) {
        if (this.level >= 3) {
            Gdx.app.debug(this.tag, string);
        }
    }

    public void debug(String string, Exception exception) {
        if (this.level >= 3) {
            Gdx.app.debug(this.tag, string, exception);
        }
    }

    public void info(String string) {
        if (this.level >= 2) {
            Gdx.app.log(this.tag, string);
        }
    }

    public void info(String string, Exception exception) {
        if (this.level >= 2) {
            Gdx.app.log(this.tag, string, exception);
        }
    }

    public void error(String string) {
        if (this.level >= 1) {
            Gdx.app.error(this.tag, string);
        }
    }

    public void error(String string, Throwable throwable) {
        if (this.level >= 1) {
            Gdx.app.error(this.tag, string, throwable);
        }
    }

    public void setLevel(int n2) {
        this.level = n2;
    }

    public int getLevel() {
        return this.level;
    }
}

