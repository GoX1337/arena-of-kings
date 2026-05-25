/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.BufferUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class ScreenUtils {
    public static void clear(Color color) {
        ScreenUtils.clear(color.r, color.g, color.b, color.a, false);
    }

    public static void clear(float f2, float f3, float f4, float f5) {
        ScreenUtils.clear(f2, f3, f4, f5, false);
    }

    public static void clear(Color color, boolean bl2) {
        ScreenUtils.clear(color.r, color.g, color.b, color.a, bl2);
    }

    public static void clear(float f2, float f3, float f4, float f5, boolean bl2) {
        Gdx.gl.glClearColor(f2, f3, f4, f5);
        int n2 = 16384;
        if (bl2) {
            n2 |= 0x100;
        }
        Gdx.gl.glClear(n2);
    }

    public static TextureRegion getFrameBufferTexture() {
        int n2 = Gdx.graphics.getBackBufferWidth();
        int n3 = Gdx.graphics.getBackBufferHeight();
        return ScreenUtils.getFrameBufferTexture(0, 0, n2, n3);
    }

    public static TextureRegion getFrameBufferTexture(int n2, int n3, int n4, int n5) {
        int n6 = MathUtils.nextPowerOfTwo(n4);
        int n7 = MathUtils.nextPowerOfTwo(n5);
        Pixmap pixmap = Pixmap.createFromFrameBuffer(n2, n3, n4, n5);
        Pixmap pixmap2 = new Pixmap(n6, n7, Pixmap.Format.RGBA8888);
        pixmap2.setBlending(Pixmap.Blending.None);
        pixmap2.drawPixmap(pixmap, 0, 0);
        Texture texture = new Texture(pixmap2);
        TextureRegion textureRegion = new TextureRegion(texture, 0, n5, n4, -n5);
        pixmap2.dispose();
        pixmap.dispose();
        return textureRegion;
    }

    @Deprecated
    public static Pixmap getFrameBufferPixmap(int n2, int n3, int n4, int n5) {
        return Pixmap.createFromFrameBuffer(n2, n3, n4, n5);
    }

    public static byte[] getFrameBufferPixels(boolean bl2) {
        int n2 = Gdx.graphics.getBackBufferWidth();
        int n3 = Gdx.graphics.getBackBufferHeight();
        return ScreenUtils.getFrameBufferPixels(0, 0, n2, n3, bl2);
    }

    public static byte[] getFrameBufferPixels(int n2, int n3, int n4, int n5, boolean bl2) {
        Gdx.gl.glPixelStorei(3333, 1);
        ByteBuffer byteBuffer = BufferUtils.newByteBuffer(n4 * n5 * 4);
        Gdx.gl.glReadPixels(n2, n3, n4, n5, 6408, 5121, byteBuffer);
        int n6 = n4 * n5 * 4;
        byte[] byArray = new byte[n6];
        if (bl2) {
            int n7 = n4 * 4;
            for (int i2 = 0; i2 < n5; ++i2) {
                ((Buffer)byteBuffer).position((n5 - i2 - 1) * n7);
                byteBuffer.get(byArray, i2 * n7, n7);
            }
        } else {
            ((Buffer)byteBuffer).clear();
            byteBuffer.get(byArray);
        }
        return byArray;
    }
}

