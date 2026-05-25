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
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLFWNativeWin32 {
    protected GLFWNativeWin32() {
        throw new UnsupportedOperationException();
    }

    public static long nglfwGetWin32Adapter(long l2) {
        long l3 = Functions.GetWin32Adapter;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetWin32Adapter(@NativeType(value="GLFWmonitor *") long l2) {
        long l3 = GLFWNativeWin32.nglfwGetWin32Adapter(l2);
        return MemoryUtil.memUTF8Safe(l3);
    }

    public static long nglfwGetWin32Monitor(long l2) {
        long l3 = Functions.GetWin32Monitor;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetWin32Monitor(@NativeType(value="GLFWmonitor *") long l2) {
        long l3 = GLFWNativeWin32.nglfwGetWin32Monitor(l2);
        return MemoryUtil.memUTF8Safe(l3);
    }

    @NativeType(value="HWND")
    public static long glfwGetWin32Window(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetWin32Window;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    @NativeType(value="GLFWwindow *")
    public static long glfwAttachWin32Window(@NativeType(value="HWND") long l2, @NativeType(value="GLFWwindow *") long l3) {
        long l4 = Functions.AttachWin32Window;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePPP(l2, l3, l4);
    }

    public static final class Functions {
        public static final long GetWin32Adapter = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWin32Adapter");
        public static final long GetWin32Monitor = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWin32Monitor");
        public static final long GetWin32Window = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWin32Window");
        public static final long AttachWin32Window = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwAttachWin32Window");

        private Functions() {
        }
    }
}

