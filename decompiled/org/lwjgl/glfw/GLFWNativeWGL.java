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

public class GLFWNativeWGL {
    protected GLFWNativeWGL() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="HGLRC")
    public static long glfwGetWGLContext(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetWGLContext;
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
        GLFWNativeWGL.setPath(string);
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
        MemoryUtil.memPutAddress(l2, string == null ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF16(string)));
    }

    public static final class Functions {
        public static final long GetWGLContext = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWGLContext");

        private Functions() {
        }
    }
}

