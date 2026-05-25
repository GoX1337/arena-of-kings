/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.XVisualInfo;

public class GLXSGIXFBConfig {
    public static final int GLX_DRAWABLE_TYPE_SGIX = 32784;
    public static final int GLX_RENDER_TYPE_SGIX = 32785;
    public static final int GLX_X_RENDERABLE_SGIX = 32786;
    public static final int GLX_FBCONFIG_ID_SGIX = 32787;
    public static final int GLX_SCREEN_EXT = 32780;
    public static final int GLX_WINDOW_BIT_SGIX = 1;
    public static final int GLX_PIXMAP_BIT_SGIX = 2;
    public static final int GLX_RGBA_BIT_SGIX = 1;
    public static final int GLX_COLOR_INDEX_BIT_SGIX = 2;
    public static final int GLX_RGBA_TYPE_SGIX = 32788;
    public static final int GLX_COLOR_INDEX_TYPE_SGIX = 32789;

    protected GLXSGIXFBConfig() {
        throw new UnsupportedOperationException();
    }

    public static int nglXGetFBConfigAttribSGIX(long l2, long l3, int n2, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXGetFBConfigAttribSGIX;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPPI(l2, l3, n2, l4, l5);
    }

    public static int glXGetFBConfigAttribSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfigSGIX") long l3, int n2, @NativeType(value="int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return GLXSGIXFBConfig.nglXGetFBConfigAttribSGIX(l2, l3, n2, MemoryUtil.memAddress(intBuffer));
    }

    public static long nglXChooseFBConfigSGIX(long l2, int n2, long l3, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXChooseFBConfigSGIX;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
        }
        return JNI.callPPPP(l2, n2, l3, l4, l5);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="GLXFBConfigSGIX *")
    public static PointerBuffer glXChooseFBConfigSGIX(@NativeType(value="Display *") long l2, int n2, @Nullable @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        IntBuffer intBuffer2 = memoryStack.callocInt(1);
        try {
            long l3 = GLXSGIXFBConfig.nglXChooseFBConfigSGIX(l2, n2, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(intBuffer2));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(l3, intBuffer2.get(0));
            return pointerBuffer;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="GLXPixmap")
    public static long glXCreateGLXPixmapWithConfigSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @NativeType(value="Pixmap") long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXCreateGLXPixmapWithConfigSGIX;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPNP(l2, l3, l4, l5);
    }

    @NativeType(value="GLXContext")
    public static long glXCreateContextWithConfigSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, int n2, @NativeType(value="GLXContext") long l4, @NativeType(value="Bool") boolean bl2) {
        long l5 = GL.getCapabilitiesGLXClient().glXCreateContextWithConfigSGIX;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(l4);
        }
        return JNI.callPPPP(l2, l3, n2, l4, bl2 ? 1 : 0, l5);
    }

    public static long nglXGetVisualFromFBConfigSGIX(long l2, long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXGetVisualFromFBConfigSGIX;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPP(l2, l3, l4);
    }

    @Nullable
    @NativeType(value="XVisualInfo *")
    public static XVisualInfo glXGetVisualFromFBConfigSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3) {
        long l4 = GLXSGIXFBConfig.nglXGetVisualFromFBConfigSGIX(l2, l3);
        return XVisualInfo.createSafe(l4);
    }

    public static long nglXGetFBConfigFromVisualSGIX(long l2, long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXGetFBConfigFromVisualSGIX;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            XVisualInfo.validate(l3);
        }
        return JNI.callPPP(l2, l3, l4);
    }

    @NativeType(value="GLXFBConfigSGIX")
    public static long glXGetFBConfigFromVisualSGIX(@NativeType(value="Display *") long l2, @NativeType(value="XVisualInfo *") XVisualInfo xVisualInfo) {
        return GLXSGIXFBConfig.nglXGetFBConfigFromVisualSGIX(l2, xVisualInfo.address());
    }

    public static int glXGetFBConfigAttribSGIX(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfigSGIX") long l3, int n2, @NativeType(value="int *") int[] nArray) {
        long l4 = GL.getCapabilitiesGLXClient().glXGetFBConfigAttribSGIX;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(nArray, 1);
        }
        return JNI.callPPPI(l2, l3, n2, nArray, l4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="GLXFBConfigSGIX *")
    public static PointerBuffer glXChooseFBConfigSGIX(@NativeType(value="Display *") long l2, int n2, @Nullable @NativeType(value="int const *") int[] nArray) {
        long l3 = GL.getCapabilitiesGLXClient().glXChooseFBConfigSGIX;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.checkNTSafe(nArray);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l4 = JNI.callPPPP(l2, n2, nArray, MemoryUtil.memAddress(intBuffer), l3);
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(l4, intBuffer.get(0));
            return pointerBuffer;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }
}

