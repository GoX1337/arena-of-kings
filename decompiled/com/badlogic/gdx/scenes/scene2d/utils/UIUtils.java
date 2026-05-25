/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.Gdx;

public final class UIUtils {
    public static boolean isAndroid = System.getProperty("java.runtime.name").contains("Android");
    public static boolean isMac = !isAndroid && System.getProperty("os.name").contains("Mac");
    public static boolean isWindows = !isAndroid && System.getProperty("os.name").contains("Windows");
    public static boolean isLinux = !isAndroid && System.getProperty("os.name").contains("Linux");
    public static boolean isIos = !isAndroid && !isWindows && !isLinux && !isMac;

    private UIUtils() {
    }

    public static boolean left() {
        return Gdx.input.isButtonPressed(0);
    }

    public static boolean left(int n2) {
        return n2 == 0;
    }

    public static boolean right() {
        return Gdx.input.isButtonPressed(1);
    }

    public static boolean right(int n2) {
        return n2 == 1;
    }

    public static boolean middle() {
        return Gdx.input.isButtonPressed(2);
    }

    public static boolean middle(int n2) {
        return n2 == 2;
    }

    public static boolean shift() {
        return Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60);
    }

    public static boolean shift(int n2) {
        return n2 == 59 || n2 == 60;
    }

    public static boolean ctrl() {
        if (isMac) {
            return Gdx.input.isKeyPressed(63);
        }
        return Gdx.input.isKeyPressed(129) || Gdx.input.isKeyPressed(130);
    }

    public static boolean ctrl(int n2) {
        if (isMac) {
            return n2 == 63;
        }
        return n2 == 129 || n2 == 130;
    }

    public static boolean alt() {
        return Gdx.input.isKeyPressed(57) || Gdx.input.isKeyPressed(58);
    }

    public static boolean alt(int n2) {
        return n2 == 57 || n2 == 58;
    }
}

