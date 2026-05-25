/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLFWNativeX11 {
    protected GLFWNativeX11() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="Display *")
    public static long glfwGetX11Display() {
        long l2 = Functions.GetX11Display;
        return JNI.invokeP(l2);
    }

    @NativeType(value="RRCrtc")
    public static long glfwGetX11Adapter(@NativeType(value="GLFWmonitor *") long l2) {
        long l3 = Functions.GetX11Adapter;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePN(l2, l3);
    }

    @NativeType(value="RROutput")
    public static long glfwGetX11Monitor(@NativeType(value="GLFWmonitor *") long l2) {
        long l3 = Functions.GetX11Monitor;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePN(l2, l3);
    }

    @NativeType(value="Window")
    public static long glfwGetX11Window(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetX11Window;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePN(l2, l3);
    }

    public static void nglfwSetX11SelectionString(long l2) {
        long l3 = Functions.SetX11SelectionString;
        JNI.invokePV(l2, l3);
    }

    public static void glfwSetX11SelectionString(@NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        GLFWNativeX11.nglfwSetX11SelectionString(MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glfwSetX11SelectionString(@NativeType(value="char const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            GLFWNativeX11.nglfwSetX11SelectionString(l2);
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static long nglfwGetX11SelectionString() {
        long l2 = Functions.GetX11SelectionString;
        return JNI.invokeP(l2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String glfwGetX11SelectionString() {
        long l2 = GLFWNativeX11.nglfwGetX11SelectionString();
        return MemoryUtil.memUTF8Safe(l2);
    }

    public static final class Functions {
        public static final long GetX11Display = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetX11Display");
        public static final long GetX11Adapter = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetX11Adapter");
        public static final long GetX11Monitor = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetX11Monitor");
        public static final long GetX11Window = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetX11Window");
        public static final long SetX11SelectionString = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwSetX11SelectionString");
        public static final long GetX11SelectionString = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetX11SelectionString");

        private Functions() {
        }
    }
}

