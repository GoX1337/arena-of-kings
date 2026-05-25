/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.StringBuilder;

public class Align {
    public static final int center = 1;
    public static final int top = 2;
    public static final int bottom = 4;
    public static final int left = 8;
    public static final int right = 16;
    public static final int topLeft = 10;
    public static final int topRight = 18;
    public static final int bottomLeft = 12;
    public static final int bottomRight = 20;

    public static final boolean isLeft(int n2) {
        return (n2 & 8) != 0;
    }

    public static final boolean isRight(int n2) {
        return (n2 & 0x10) != 0;
    }

    public static final boolean isTop(int n2) {
        return (n2 & 2) != 0;
    }

    public static final boolean isBottom(int n2) {
        return (n2 & 4) != 0;
    }

    public static final boolean isCenterVertical(int n2) {
        return (n2 & 2) == 0 && (n2 & 4) == 0;
    }

    public static final boolean isCenterHorizontal(int n2) {
        return (n2 & 8) == 0 && (n2 & 0x10) == 0;
    }

    public static String toString(int n2) {
        StringBuilder stringBuilder = new StringBuilder(13);
        if ((n2 & 2) != 0) {
            stringBuilder.append("top,");
        } else if ((n2 & 4) != 0) {
            stringBuilder.append("bottom,");
        } else {
            stringBuilder.append("center,");
        }
        if ((n2 & 8) != 0) {
            stringBuilder.append("left");
        } else if ((n2 & 0x10) != 0) {
            stringBuilder.append("right");
        } else {
            stringBuilder.append("center");
        }
        return stringBuilder.toString();
    }
}

