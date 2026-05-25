/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.HdpiMode;

public class HdpiUtils {
    private static HdpiMode mode = HdpiMode.Logical;

    public static void setMode(HdpiMode hdpiMode) {
        mode = hdpiMode;
    }

    public static void glScissor(int n2, int n3, int n4, int n5) {
        if (mode == HdpiMode.Logical && (Gdx.graphics.getWidth() != Gdx.graphics.getBackBufferWidth() || Gdx.graphics.getHeight() != Gdx.graphics.getBackBufferHeight())) {
            Gdx.gl.glScissor(HdpiUtils.toBackBufferX(n2), HdpiUtils.toBackBufferY(n3), HdpiUtils.toBackBufferX(n4), HdpiUtils.toBackBufferY(n5));
        } else {
            Gdx.gl.glScissor(n2, n3, n4, n5);
        }
    }

    public static void glViewport(int n2, int n3, int n4, int n5) {
        if (mode == HdpiMode.Logical && (Gdx.graphics.getWidth() != Gdx.graphics.getBackBufferWidth() || Gdx.graphics.getHeight() != Gdx.graphics.getBackBufferHeight())) {
            Gdx.gl.glViewport(HdpiUtils.toBackBufferX(n2), HdpiUtils.toBackBufferY(n3), HdpiUtils.toBackBufferX(n4), HdpiUtils.toBackBufferY(n5));
        } else {
            Gdx.gl.glViewport(n2, n3, n4, n5);
        }
    }

    public static int toLogicalX(int n2) {
        return (int)((float)(n2 * Gdx.graphics.getWidth()) / (float)Gdx.graphics.getBackBufferWidth());
    }

    public static int toLogicalY(int n2) {
        return (int)((float)(n2 * Gdx.graphics.getHeight()) / (float)Gdx.graphics.getBackBufferHeight());
    }

    public static int toBackBufferX(int n2) {
        return (int)((float)(n2 * Gdx.graphics.getBackBufferWidth()) / (float)Gdx.graphics.getWidth());
    }

    public static int toBackBufferY(int n2) {
        return (int)((float)(n2 * Gdx.graphics.getBackBufferHeight()) / (float)Gdx.graphics.getHeight());
    }
}

