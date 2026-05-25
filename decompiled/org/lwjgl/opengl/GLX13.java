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
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLX12;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.XVisualInfo;

public class GLX13
extends GLX12 {
    public static final int GLX_WINDOW_BIT = 1;
    public static final int GLX_PIXMAP_BIT = 2;
    public static final int GLX_PBUFFER_BIT = 4;
    public static final int GLX_RGBA_BIT = 1;
    public static final int GLX_COLOR_INDEX_BIT = 2;
    public static final int GLX_PBUFFER_CLOBBER_MASK = 0x8000000;
    public static final int GLX_FRONT_LEFT_BUFFER_BIT = 1;
    public static final int GLX_FRONT_RIGHT_BUFFER_BIT = 2;
    public static final int GLX_BACK_LEFT_BUFFER_BIT = 4;
    public static final int GLX_BACK_RIGHT_BUFFER_BIT = 8;
    public static final int GLX_AUX_BUFFERS_BIT = 16;
    public static final int GLX_DEPTH_BUFFER_BIT = 32;
    public static final int GLX_STENCIL_BUFFER_BIT = 64;
    public static final int GLX_ACCUM_BUFFER_BIT = 128;
    public static final int GLX_CONFIG_CAVEAT = 32;
    public static final int GLX_X_VISUAL_TYPE = 34;
    public static final int GLX_TRANSPARENT_TYPE = 35;
    public static final int GLX_TRANSPARENT_INDEX_VALUE = 36;
    public static final int GLX_TRANSPARENT_RED_VALUE = 37;
    public static final int GLX_TRANSPARENT_GREEN_VALUE = 38;
    public static final int GLX_TRANSPARENT_BLUE_VALUE = 39;
    public static final int GLX_TRANSPARENT_ALPHA_VALUE = 40;
    public static final int GLX_DONT_CARE = -1;
    public static final int GLX_NONE = 32768;
    public static final int GLX_SLOW_CONFIG = 32769;
    public static final int GLX_TRUE_COLOR = 32770;
    public static final int GLX_DIRECT_COLOR = 32771;
    public static final int GLX_PSEUDO_COLOR = 32772;
    public static final int GLX_STATIC_COLOR = 32773;
    public static final int GLX_GRAY_SCALE = 32774;
    public static final int GLX_STATIC_GRAY = 32775;
    public static final int GLX_TRANSPARENT_RGB = 32776;
    public static final int GLX_TRANSPARENT_INDEX = 32777;
    public static final int GLX_VISUAL_ID = 32779;
    public static final int GLX_SCREEN = 32780;
    public static final int GLX_NON_CONFORMANT_CONFIG = 32781;
    public static final int GLX_DRAWABLE_TYPE = 32784;
    public static final int GLX_RENDER_TYPE = 32785;
    public static final int GLX_X_RENDERABLE = 32786;
    public static final int GLX_FBCONFIG_ID = 32787;
    public static final int GLX_RGBA_TYPE = 32788;
    public static final int GLX_COLOR_INDEX_TYPE = 32789;
    public static final int GLX_MAX_PBUFFER_WIDTH = 32790;
    public static final int GLX_MAX_PBUFFER_HEIGHT = 32791;
    public static final int GLX_MAX_PBUFFER_PIXELS = 32792;
    public static final int GLX_PRESERVED_CONTENTS = 32795;
    public static final int GLX_LARGEST_PBUFFER = 32796;
    public static final int GLX_WIDTH = 32797;
    public static final int GLX_HEIGHT = 32798;
    public static final int GLX_EVENT_MASK = 32799;
    public static final int GLX_DAMAGED = 32800;
    public static final int GLX_SAVED = 32801;
    public static final int GLX_WINDOW = 32802;
    public static final int GLX_PBUFFER = 32803;
    public static final int GLX_PBUFFER_HEIGHT = 32832;
    public static final int GLX_PBUFFER_WIDTH = 32833;

    protected GLX13() {
        throw new UnsupportedOperationException();
    }

    public static long nglXGetFBConfigs(long l2, int n2, long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXGetFBConfigs;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
        }
        return JNI.callPPP(l2, n2, l3, l4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="GLXFBConfig *")
    public static PointerBuffer glXGetFBConfigs(@NativeType(value="Display *") long l2, int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l3 = GLX13.nglXGetFBConfigs(l2, n2, MemoryUtil.memAddress(intBuffer));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(l3, intBuffer.get(0));
            return pointerBuffer;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static long nglXChooseFBConfig(long l2, int n2, long l3, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXChooseFBConfig;
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
    @NativeType(value="GLXFBConfig *")
    public static PointerBuffer glXChooseFBConfig(@NativeType(value="Display *") long l2, int n2, @Nullable @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        IntBuffer intBuffer2 = memoryStack.callocInt(1);
        try {
            long l3 = GLX13.nglXChooseFBConfig(l2, n2, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(intBuffer2));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(l3, intBuffer2.get(0));
            return pointerBuffer;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static int nglXGetFBConfigAttrib(long l2, long l3, int n2, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXGetFBConfigAttrib;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPPI(l2, l3, n2, l4, l5);
    }

    public static int glXGetFBConfigAttrib(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, int n2, @NativeType(value="int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return GLX13.nglXGetFBConfigAttrib(l2, l3, n2, MemoryUtil.memAddress(intBuffer));
    }

    public static long nglXGetVisualFromFBConfig(long l2, long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXGetVisualFromFBConfig;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPP(l2, l3, l4);
    }

    @Nullable
    @NativeType(value="XVisualInfo *")
    public static XVisualInfo glXGetVisualFromFBConfig(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3) {
        long l4 = GLX13.nglXGetVisualFromFBConfig(l2, l3);
        return XVisualInfo.createSafe(l4);
    }

    public static long nglXCreateWindow(long l2, long l3, long l4, long l5) {
        long l6 = GL.getCapabilitiesGLXClient().glXCreateWindow;
        if (Checks.CHECKS) {
            Checks.check(l6);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPNPP(l2, l3, l4, l5, l6);
    }

    @NativeType(value="GLXWindow")
    public static long glXCreateWindow(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @NativeType(value="Window") long l4, @Nullable @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        return GLX13.nglXCreateWindow(l2, l3, l4, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static long nglXCreatePixmap(long l2, long l3, long l4, long l5) {
        long l6 = GL.getCapabilitiesGLXClient().glXCreatePixmap;
        if (Checks.CHECKS) {
            Checks.check(l6);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPNPP(l2, l3, l4, l5, l6);
    }

    @NativeType(value="GLXPixmap")
    public static long glXCreatePixmap(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @NativeType(value="Pixmap") long l4, @Nullable @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        return GLX13.nglXCreatePixmap(l2, l3, l4, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glXDestroyPixmap(@NativeType(value="Display *") long l2, @NativeType(value="GLXPixmap") long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXDestroyPixmap;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPV(l2, l3, l4);
    }

    public static long nglXCreatePbuffer(long l2, long l3, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXCreatePbuffer;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPPP(l2, l3, l4, l5);
    }

    @NativeType(value="GLXPbuffer")
    public static long glXCreatePbuffer(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @Nullable @NativeType(value="int const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        return GLX13.nglXCreatePbuffer(l2, l3, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glXDestroyPbuffer(@NativeType(value="Display *") long l2, @NativeType(value="GLXPbuffer") long l3) {
        long l4 = GL.getCapabilitiesGLXClient().glXDestroyPbuffer;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPV(l2, l3, l4);
    }

    public static void nglXQueryDrawable(long l2, long l3, int n2, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXQueryDrawable;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPPV(l2, l3, n2, l4, l5);
    }

    public static void glXQueryDrawable(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, int n2, @NativeType(value="unsigned int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GLX13.nglXQueryDrawable(l2, l3, n2, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glXQueryDrawable(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GLX13.nglXQueryDrawable(l2, l3, n2, MemoryUtil.memAddress(intBuffer));
            int n4 = intBuffer.get(0);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="GLXContext")
    public static long glXCreateNewContext(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, int n2, @NativeType(value="GLXContext") long l4, @NativeType(value="Bool") boolean bl2) {
        long l5 = GL.getCapabilitiesGLXClient().glXCreateNewContext;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPPP(l2, l3, n2, l4, bl2 ? 1 : 0, l5);
    }

    @NativeType(value="Bool")
    public static boolean glXMakeContextCurrent(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="GLXDrawable") long l4, @NativeType(value="GLXContext") long l5) {
        long l6 = GL.getCapabilitiesGLXClient().glXMakeContextCurrent;
        if (Checks.CHECKS) {
            Checks.check(l6);
            Checks.check(l2);
        }
        return JNI.callPPPPI(l2, l3, l4, l5, l6) != 0;
    }

    @NativeType(value="GLXDrawable")
    public static long glXGetCurrentReadDrawable() {
        long l2 = GL.getCapabilitiesGLXClient().glXGetCurrentReadDrawable;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callP(l2);
    }

    public static int nglXQueryContext(long l2, long l3, int n2, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXQueryContext;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPPI(l2, l3, n2, l4, l5);
    }

    public static int glXQueryContext(@NativeType(value="Display *") long l2, @NativeType(value="GLXContext") long l3, int n2, @NativeType(value="int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return GLX13.nglXQueryContext(l2, l3, n2, MemoryUtil.memAddress(intBuffer));
    }

    public static void glXSelectEvent(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="unsigned long") long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXSelectEvent;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPNV(l2, l3, l4, l5);
    }

    public static void nglXGetSelectedEvent(long l2, long l3, long l4) {
        long l5 = GL.getCapabilitiesGLXClient().glXGetSelectedEvent;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPPV(l2, l3, l4, l5);
    }

    public static void glXGetSelectedEvent(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="unsigned long *") CLongBuffer cLongBuffer) {
        if (Checks.CHECKS) {
            Checks.check(cLongBuffer, 1);
        }
        GLX13.nglXGetSelectedEvent(l2, l3, MemoryUtil.memAddress(cLongBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="GLXFBConfig *")
    public static PointerBuffer glXChooseFBConfig(@NativeType(value="Display *") long l2, int n2, @Nullable @NativeType(value="int const *") int[] nArray) {
        long l3 = GL.getCapabilitiesGLXClient().glXChooseFBConfig;
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

    public static int glXGetFBConfigAttrib(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, int n2, @NativeType(value="int *") int[] nArray) {
        long l4 = GL.getCapabilitiesGLXClient().glXGetFBConfigAttrib;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(nArray, 1);
        }
        return JNI.callPPPI(l2, l3, n2, nArray, l4);
    }

    @NativeType(value="GLXWindow")
    public static long glXCreateWindow(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @NativeType(value="Window") long l4, @Nullable @NativeType(value="int const *") int[] nArray) {
        long l5 = GL.getCapabilitiesGLXClient().glXCreateWindow;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
            Checks.checkNTSafe(nArray);
        }
        return JNI.callPPNPP(l2, l3, l4, nArray, l5);
    }

    @NativeType(value="GLXPixmap")
    public static long glXCreatePixmap(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @NativeType(value="Pixmap") long l4, @Nullable @NativeType(value="int const *") int[] nArray) {
        long l5 = GL.getCapabilitiesGLXClient().glXCreatePixmap;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l2);
            Checks.check(l3);
            Checks.checkNTSafe(nArray);
        }
        return JNI.callPPNPP(l2, l3, l4, nArray, l5);
    }

    @NativeType(value="GLXPbuffer")
    public static long glXCreatePbuffer(@NativeType(value="Display *") long l2, @NativeType(value="GLXFBConfig") long l3, @Nullable @NativeType(value="int const *") int[] nArray) {
        long l4 = GL.getCapabilitiesGLXClient().glXCreatePbuffer;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
            Checks.checkNTSafe(nArray);
        }
        return JNI.callPPPP(l2, l3, nArray, l4);
    }

    public static void glXQueryDrawable(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, int n2, @NativeType(value="unsigned int *") int[] nArray) {
        long l4 = GL.getCapabilitiesGLXClient().glXQueryDrawable;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(nArray, 1);
        }
        JNI.callPPPV(l2, l3, n2, nArray, l4);
    }

    public static int glXQueryContext(@NativeType(value="Display *") long l2, @NativeType(value="GLXContext") long l3, int n2, @NativeType(value="int *") int[] nArray) {
        long l4 = GL.getCapabilitiesGLXClient().glXQueryContext;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(nArray, 1);
        }
        return JNI.callPPPI(l2, l3, n2, nArray, l4);
    }
}

