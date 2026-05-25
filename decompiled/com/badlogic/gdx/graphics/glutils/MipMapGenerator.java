/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class MipMapGenerator {
    private static boolean useHWMipMap = true;

    private MipMapGenerator() {
    }

    public static void setUseHardwareMipMap(boolean bl2) {
        useHWMipMap = bl2;
    }

    public static void generateMipMap(Pixmap pixmap, int n2, int n3) {
        MipMapGenerator.generateMipMap(3553, pixmap, n2, n3);
    }

    public static void generateMipMap(int n2, Pixmap pixmap, int n3, int n4) {
        if (!useHWMipMap) {
            MipMapGenerator.generateMipMapCPU(n2, pixmap, n3, n4);
            return;
        }
        if (Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.WebGL || Gdx.app.getType() == Application.ApplicationType.iOS) {
            MipMapGenerator.generateMipMapGLES20(n2, pixmap);
        } else {
            MipMapGenerator.generateMipMapDesktop(n2, pixmap, n3, n4);
        }
    }

    private static void generateMipMapGLES20(int n2, Pixmap pixmap) {
        Gdx.gl.glTexImage2D(n2, 0, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
        Gdx.gl20.glGenerateMipmap(n2);
    }

    private static void generateMipMapDesktop(int n2, Pixmap pixmap, int n3, int n4) {
        if (Gdx.graphics.supportsExtension("GL_ARB_framebuffer_object") || Gdx.graphics.supportsExtension("GL_EXT_framebuffer_object") || Gdx.gl20.getClass().getName().equals("com.badlogic.gdx.backends.lwjgl3.Lwjgl3GLES20") || Gdx.gl30 != null) {
            Gdx.gl.glTexImage2D(n2, 0, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
            Gdx.gl20.glGenerateMipmap(n2);
        } else {
            MipMapGenerator.generateMipMapCPU(n2, pixmap, n3, n4);
        }
    }

    private static void generateMipMapCPU(int n2, Pixmap pixmap, int n3, int n4) {
        Gdx.gl.glTexImage2D(n2, 0, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
        if (Gdx.gl20 == null && n3 != n4) {
            throw new GdxRuntimeException("texture width and height must be square when using mipmapping.");
        }
        int n5 = pixmap.getWidth() / 2;
        int n6 = pixmap.getHeight() / 2;
        int n7 = 1;
        while (n5 > 0 && n6 > 0) {
            Pixmap pixmap2 = new Pixmap(n5, n6, pixmap.getFormat());
            pixmap2.setBlending(Pixmap.Blending.None);
            pixmap2.drawPixmap(pixmap, 0, 0, pixmap.getWidth(), pixmap.getHeight(), 0, 0, n5, n6);
            if (n7 > 1) {
                pixmap.dispose();
            }
            pixmap = pixmap2;
            Gdx.gl.glTexImage2D(n2, n7, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap.getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
            n5 = pixmap.getWidth() / 2;
            n6 = pixmap.getHeight() / 2;
            ++n7;
        }
    }
}

