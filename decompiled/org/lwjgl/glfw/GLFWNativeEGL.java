/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;

public class GLFWNativeEGL {
    protected GLFWNativeEGL() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="EGLDisplay")
    public static long glfwGetEGLDisplay() {
        long l2 = Functions.GetEGLDisplay;
        return JNI.invokeP(l2);
    }

    @NativeType(value="EGLContext")
    public static long glfwGetEGLContext(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetEGLContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    @NativeType(value="EGLSurface")
    public static long glfwGetEGLSurface(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetEGLSurface;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    @NativeType(value="EGLConfig")
    public static long glfwGetEGLConfig(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetEGLConfig;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    public static void setEGLPath(FunctionProvider functionProvider) {
        if (!(functionProvider instanceof SharedLibrary)) {
            APIUtil.apiLog("GLFW EGL path override not set: Function provider is not a shared library.");
            return;
        }
        String string = ((SharedLibrary)functionProvider).getPath();
        if (string == null) {
            APIUtil.apiLog("GLFW EGL path override not set: Could not resolve the shared library path.");
            return;
        }
        GLFWNativeEGL.setEGLPath(string);
    }

    public static void setEGLPath(@Nullable String string) {
        if (!GLFWNativeEGL.override("_glfw_egl_library", string)) {
            APIUtil.apiLog("GLFW EGL path override not set: Could not resolve override symbol.");
        }
    }

    public static void setGLESPath(FunctionProvider functionProvider) {
        if (!(functionProvider instanceof SharedLibrary)) {
            APIUtil.apiLog("GLFW OpenGL ES path override not set: Function provider is not a shared library.");
            return;
        }
        String string = ((SharedLibrary)functionProvider).getPath();
        if (string == null) {
            APIUtil.apiLog("GLFW OpenGL ES path override not set: Could not resolve the shared library path.");
            return;
        }
        GLFWNativeEGL.setGLESPath(string);
    }

    public static void setGLESPath(@Nullable String string) {
        if (!GLFWNativeEGL.override("_glfw_opengles_library", string)) {
            APIUtil.apiLog("GLFW OpenGL ES path override not set: Could not resolve override symbol.");
        }
    }

    private static boolean override(String string, @Nullable String string2) {
        long l2 = GLFW.getLibrary().getFunctionAddress(string);
        if (l2 == 0L) {
            return false;
        }
        long l3 = MemoryUtil.memGetAddress(l2);
        if (l3 != 0L) {
            MemoryUtil.nmemFree(l3);
        }
        MemoryUtil.memPutAddress(l2, string2 == null ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(string2)));
        return true;
    }

    public static final class Functions {
        public static final long GetEGLDisplay = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetEGLDisplay");
        public static final long GetEGLContext = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetEGLContext");
        public static final long GetEGLSurface = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetEGLSurface");
        public static final long GetEGLConfig = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetEGLConfig");

        private Functions() {
        }
    }
}

