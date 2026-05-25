/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.macosx.MacOSXLibraryBundle;

public class GLFWNativeNSGL {
    protected GLFWNativeNSGL() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="id")
    public static long glfwGetNSGLContext(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetNSGLContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    public static void setFrameworkLWJGL() {
        FunctionProvider functionProvider = GL.getFunctionProvider();
        if (!(functionProvider instanceof MacOSXLibraryBundle)) {
            APIUtil.apiLog("GLFW OpenGL path override not set: OpenGL function provider is not a framework.");
            return;
        }
        GLFWNativeNSGL.setFramework(((MacOSXLibraryBundle)functionProvider).getName());
    }

    public static void setFramework(@Nullable String string) {
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
        public static final long GetNSGLContext = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetNSGLContext");

        private Functions() {
        }
    }
}

