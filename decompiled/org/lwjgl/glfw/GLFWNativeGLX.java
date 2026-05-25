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

public class GLFWNativeGLX {
    protected GLFWNativeGLX() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="GLXContext")
    public static long glfwGetGLXContext(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetGLXContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    @NativeType(value="GLXWindow")
    public static long glfwGetGLXWindow(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetGLXWindow;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    @NativeType(value="GLXWindow")
    public static long glfwGetGLXFBConfig(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetGLXFBConfig;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    public static void setPath(FunctionProvider functionProvider) {
        if (!(functionProvider instanceof SharedLibrary)) {
            APIUtil.apiLog("GLFW OpenGL path override not set: Function provider is not a shared library.");
            return;
        }
        String string = ((SharedLibrary)functionProvider).getPath();
        if (string == null) {
            APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve the shared library path.");
            return;
        }
        GLFWNativeGLX.setPath(string);
    }

    public static void setPath(@Nullable String string) {
        long l2 = GLFW.getLibrary().getFunctionAddress("_glfw_opengl_library");
        if (l2 == 0L) {
            APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve override symbol.");
            return;
        }
        long l3 = MemoryUtil.memGetAddress(l2);
        if (l3 != 0L) {
            MemoryUtil.nmemFree(l3);
        }
        MemoryUtil.memPutAddress(l2, string == null ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(string)));
    }

    public static final class Functions {
        public static final long GetGLXContext = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetGLXContext");
        public static final long GetGLXWindow = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetGLXWindow");
        public static final long GetGLXFBConfig = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetGLXFBConfig");

        private Functions() {
        }
    }
}

