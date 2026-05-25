/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform.win32;

import com.sun.jna.Function;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.OpenGL32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.User32Util;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinGDI;

public abstract class OpenGL32Util {
    public static Function wglGetProcAddress(String string) {
        Pointer pointer = OpenGL32.INSTANCE.wglGetProcAddress("wglEnumGpusNV");
        return pointer == null ? null : Function.getFunction(pointer);
    }

    public static int countGpusNV() {
        WinDef.HWND hWND = User32Util.createWindow("Message", null, 0, 0, 0, 0, 0, null, null, null, null);
        WinDef.HDC hDC = User32.INSTANCE.GetDC(hWND);
        WinGDI.PIXELFORMATDESCRIPTOR.ByReference byReference = new WinGDI.PIXELFORMATDESCRIPTOR.ByReference();
        byReference.nVersion = 1;
        byReference.dwFlags = 37;
        byReference.iPixelType = 0;
        byReference.cColorBits = (byte)24;
        byReference.cDepthBits = (byte)16;
        byReference.iLayerType = 0;
        GDI32.INSTANCE.SetPixelFormat(hDC, GDI32.INSTANCE.ChoosePixelFormat(hDC, byReference), byReference);
        WinDef.HGLRC hGLRC = OpenGL32.INSTANCE.wglCreateContext(hDC);
        OpenGL32.INSTANCE.wglMakeCurrent(hDC, hGLRC);
        Pointer pointer = OpenGL32.INSTANCE.wglGetProcAddress("wglEnumGpusNV");
        Function function = pointer == null ? null : Function.getFunction(pointer);
        OpenGL32.INSTANCE.wglDeleteContext(hGLRC);
        User32.INSTANCE.ReleaseDC(hWND, hDC);
        User32Util.destroyWindow(hWND);
        if (function == null) {
            return 0;
        }
        WinDef.HGLRCByReference hGLRCByReference = new WinDef.HGLRCByReference();
        for (int i2 = 0; i2 < 16; ++i2) {
            Boolean bl2 = (Boolean)function.invoke(Boolean.class, new Object[]{i2, hGLRCByReference});
            if (bl2.booleanValue()) continue;
            return i2;
        }
        return 0;
    }
}

