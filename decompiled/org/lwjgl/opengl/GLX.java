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
import org.lwjgl.opengl.GL;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.XVisualInfo;

public class GLX {
    public static final int GLXBadContext = 0;
    public static final int GLXBadContextState = 1;
    public static final int GLXBadDrawable = 2;
    public static final int GLXBadPixmap = 3;
    public static final int GLXBadContextTag = 4;
    public static final int GLXBadCurrentWindow = 5;
    public static final int GLXBadRenderRequest = 6;
    public static final int GLXBadLargeRequest = 7;
    public static final int GLXUnsupportedPrivateRequest = 8;
    public static final int GLXBadFBConfig = 9;
    public static final int GLXBadPbuffer = 10;
    public static final int GLXBadCurrentDrawable = 11;
    public static final int GLXBadWindow = 12;
    public static final int GLX_USE_GL = 1;
    public static final int GLX_BUFFER_SIZE = 2;
    public static final int GLX_LEVEL = 3;
    public static final int GLX_RGBA = 4;
    public static final int GLX_DOUBLEBUFFER = 5;
    public static final int GLX_STEREO = 6;
    public static final int GLX_AUX_BUFFERS = 7;
    public static final int GLX_RED_SIZE = 8;
    public static final int GLX_GREEN_SIZE = 9;
    public static final int GLX_BLUE_SIZE = 10;
    public static final int GLX_ALPHA_SIZE = 11;
    public static final int GLX_DEPTH_SIZE = 12;
    public static final int GLX_STENCIL_SIZE = 13;
    public static final int GLX_ACCUM_RED_SIZE = 14;
    public static final int GLX_ACCUM_GREEN_SIZE = 15;
    public static final int GLX_ACCUM_BLUE_SIZE = 16;
    public static final int GLX_ACCUM_ALPHA_SIZE = 17;
    public static final int GLX_BAD_SCREEN = 1;
    public static final int GLX_BAD_ATTRIBUTE = 2;
    public static final int GLX_NO_EXTENSION = 3;
    public static final int GLX_BAD_VISUAL = 4;
    public static final int GLX_BAD_CONTEXT = 5;
    public static final int GLX_BAD_VALUE = 6;
    public static final int GLX_BAD_ENUM = 7;

    protected GLX() {
        throw new UnsupportedOperationException();
    }

    public static int nglXQueryExtension(long l2, long l3, long l4) {
        long l5 = Functions.QueryExtension;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPPI(l2, l3, l4, l5);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryExtension(@NativeType(value="Display *") long l2, @NativeType(value="int *") IntBuffer intBuffer, @NativeType(value="int *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        return GLX.nglXQueryExtension(l2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2)) != 0;
    }

    public static int nglXQueryVersion(long l2, long l3, long l4) {
        long l5 = Functions.QueryVersion;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPPI(l2, l3, l4, l5);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryVersion(@NativeType(value="Display *") long l2, @NativeType(value="int *") IntBuffer intBuffer, @NativeType(value="int *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        return GLX.nglXQueryVersion(l2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2)) != 0;
    }

    public static int nglXGetConfig(long l2, long l3, int n2, long l4) {
        long l5 = Functions.GetConfig;
        if (Checks.CHECKS) {
            Checks.check(l2);
            XVisualInfo.validate(l3);
        }
        return JNI.callPPPI(l2, l3, n2, l4, l5);
    }

    public static int glXGetConfig(@NativeType(value="Display *") long l2, @NativeType(value="XVisualInfo *") XVisualInfo xVisualInfo, int n2, @NativeType(value="int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return GLX.nglXGetConfig(l2, xVisualInfo.address(), n2, MemoryUtil.memAddress(intBuffer));
    }

    public static long nglXChooseVisual(long l2, int n2, long l3) {
        long l4 = Functions.ChooseVisual;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPP(l2, n2, l3, l4);
    }

    @Nullable
    @NativeType(value="XVisualInfo *")
    public static XVisualInfo glXChooseVisual(@NativeType(value="Display *") long l2, int n2, @Nullable @NativeType(value="int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        long l3 = GLX.nglXChooseVisual(l2, n2, MemoryUtil.memAddressSafe(intBuffer));
        return XVisualInfo.createSafe(l3);
    }

    public static long nglXCreateContext(long l2, long l3, long l4, int n2) {
        long l5 = Functions.CreateContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
            XVisualInfo.validate(l3);
        }
        return JNI.callPPPP(l2, l3, l4, n2, l5);
    }

    @NativeType(value="GLXContext")
    public static long glXCreateContext(@NativeType(value="Display *") long l2, @NativeType(value="XVisualInfo *") XVisualInfo xVisualInfo, @NativeType(value="GLXContext") long l3, @NativeType(value="Bool") boolean bl2) {
        return GLX.nglXCreateContext(l2, xVisualInfo.address(), l3, bl2 ? 1 : 0);
    }

    @NativeType(value="Bool")
    public static boolean glXMakeCurrent(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3, @NativeType(value="GLXContext") long l4) {
        long l5 = Functions.MakeCurrent;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPPI(l2, l3, l4, l5) != 0;
    }

    public static void glXCopyContext(@NativeType(value="Display *") long l2, @NativeType(value="GLXContext") long l3, @NativeType(value="GLXContext") long l4, @NativeType(value="unsigned long") long l5) {
        long l6 = Functions.CopyContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(l4);
        }
        JNI.callPPPNV(l2, l3, l4, l5, l6);
    }

    @NativeType(value="Bool")
    public static boolean glXIsDirect(@NativeType(value="Display *") long l2, @NativeType(value="GLXContext") long l3) {
        long l4 = Functions.IsDirect;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPI(l2, l3, l4) != 0;
    }

    public static void glXDestroyContext(@NativeType(value="Display *") long l2, @NativeType(value="GLXContext") long l3) {
        long l4 = Functions.DestroyContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPV(l2, l3, l4);
    }

    @NativeType(value="GLXContext")
    public static long glXGetCurrentContext() {
        long l2 = Functions.GetCurrentContext;
        return JNI.callP(l2);
    }

    @NativeType(value="GLXDrawable")
    public static long glXGetCurrentDrawable() {
        long l2 = Functions.GetCurrentDrawable;
        return JNI.callP(l2);
    }

    public static void glXWaitGL() {
        long l2 = Functions.WaitGL;
        JNI.callV(l2);
    }

    public static void glXWaitX() {
        long l2 = Functions.WaitX;
        JNI.callV(l2);
    }

    public static void glXSwapBuffers(@NativeType(value="Display *") long l2, @NativeType(value="GLXDrawable") long l3) {
        long l4 = Functions.SwapBuffers;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPV(l2, l3, l4);
    }

    public static void glXUseXFont(@NativeType(value="Font") long l2, int n2, int n3, int n4) {
        long l3 = Functions.UseXFont;
        JNI.callNV(l2, n2, n3, n4, l3);
    }

    public static long nglXCreateGLXPixmap(long l2, long l3, long l4) {
        long l5 = Functions.CreateGLXPixmap;
        if (Checks.CHECKS) {
            Checks.check(l2);
            XVisualInfo.validate(l3);
        }
        return JNI.callPPNP(l2, l3, l4, l5);
    }

    @NativeType(value="GLXPixmap")
    public static long glXCreateGLXPixmap(@NativeType(value="Display *") long l2, @NativeType(value="XVisualInfo *") XVisualInfo xVisualInfo, @NativeType(value="Pixmap") long l3) {
        return GLX.nglXCreateGLXPixmap(l2, xVisualInfo.address(), l3);
    }

    public static void glXDestroyGLXPixmap(@NativeType(value="Display *") long l2, @NativeType(value="GLXPixmap") long l3) {
        long l4 = Functions.DestroyGLXPixmap;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
        }
        JNI.callPPV(l2, l3, l4);
    }

    @NativeType(value="Bool")
    public static boolean glXQueryExtension(@NativeType(value="Display *") long l2, @NativeType(value="int *") int[] nArray, @NativeType(value="int *") int[] nArray2) {
        long l3 = Functions.QueryExtension;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        return JNI.callPPPI(l2, nArray, nArray2, l3) != 0;
    }

    @NativeType(value="Bool")
    public static boolean glXQueryVersion(@NativeType(value="Display *") long l2, @NativeType(value="int *") int[] nArray, @NativeType(value="int *") int[] nArray2) {
        long l3 = Functions.QueryVersion;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        return JNI.callPPPI(l2, nArray, nArray2, l3) != 0;
    }

    public static int glXGetConfig(@NativeType(value="Display *") long l2, @NativeType(value="XVisualInfo *") XVisualInfo xVisualInfo, int n2, @NativeType(value="int *") int[] nArray) {
        long l3 = Functions.GetConfig;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
            XVisualInfo.validate(xVisualInfo.address());
        }
        return JNI.callPPPI(l2, xVisualInfo.address(), n2, nArray, l3);
    }

    @Nullable
    @NativeType(value="XVisualInfo *")
    public static XVisualInfo glXChooseVisual(@NativeType(value="Display *") long l2, int n2, @Nullable @NativeType(value="int *") int[] nArray) {
        long l3 = Functions.ChooseVisual;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkNTSafe(nArray);
        }
        long l4 = JNI.callPPP(l2, n2, nArray, l3);
        return XVisualInfo.createSafe(l4);
    }

    public static final class Functions {
        public static final long QueryExtension = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXQueryExtension");
        public static final long QueryVersion = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXQueryVersion");
        public static final long GetConfig = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetConfig");
        public static final long ChooseVisual = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXChooseVisual");
        public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCreateContext");
        public static final long MakeCurrent = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXMakeCurrent");
        public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCopyContext");
        public static final long IsDirect = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXIsDirect");
        public static final long DestroyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXDestroyContext");
        public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetCurrentContext");
        public static final long GetCurrentDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetCurrentDrawable");
        public static final long WaitGL = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXWaitGL");
        public static final long WaitX = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXWaitX");
        public static final long SwapBuffers = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXSwapBuffers");
        public static final long UseXFont = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXUseXFont");
        public static final long CreateGLXPixmap = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCreateGLXPixmap");
        public static final long DestroyGLXPixmap = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXDestroyGLXPixmap");

        private Functions() {
        }
    }
}

