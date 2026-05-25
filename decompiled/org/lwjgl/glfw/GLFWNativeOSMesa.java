/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.glfw;

import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;

public class GLFWNativeOSMesa {
    protected GLFWNativeOSMesa() {
        throw new UnsupportedOperationException();
    }

    public static int nglfwGetOSMesaColorBuffer(long l2, long l3, long l4, long l5, long l6) {
        long l7 = Functions.GetOSMesaColorBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePPPPPI(l2, l3, l4, l5, l6, l7);
    }

    @NativeType(value="int")
    public static boolean glfwGetOSMesaColorBuffer(@NativeType(value="GLFWwindow *") long l2, @Nullable @NativeType(value="int *") IntBuffer intBuffer, @Nullable @NativeType(value="int *") IntBuffer intBuffer2, @Nullable @NativeType(value="int *") IntBuffer intBuffer3, @Nullable @NativeType(value="void **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
            Checks.checkSafe((Buffer)intBuffer3, 1);
            Checks.checkSafe(pointerBuffer, 1);
        }
        return GLFWNativeOSMesa.nglfwGetOSMesaColorBuffer(l2, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3), MemoryUtil.memAddressSafe(pointerBuffer)) != 0;
    }

    public static int nglfwGetOSMesaDepthBuffer(long l2, long l3, long l4, long l5, long l6) {
        long l7 = Functions.GetOSMesaDepthBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePPPPPI(l2, l3, l4, l5, l6, l7);
    }

    public static int glfwGetOSMesaDepthBuffer(@NativeType(value="GLFWwindow *") long l2, @Nullable @NativeType(value="int *") IntBuffer intBuffer, @Nullable @NativeType(value="int *") IntBuffer intBuffer2, @Nullable @NativeType(value="int *") IntBuffer intBuffer3, @Nullable @NativeType(value="void **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
            Checks.checkSafe((Buffer)intBuffer3, 1);
            Checks.checkSafe(pointerBuffer, 1);
        }
        return GLFWNativeOSMesa.nglfwGetOSMesaDepthBuffer(l2, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3), MemoryUtil.memAddressSafe(pointerBuffer));
    }

    @NativeType(value="OSMesaContext")
    public static long glfwGetOSMesaContext(@NativeType(value="GLFWwindow *") long l2) {
        long l3 = Functions.GetOSMesaContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l2, l3);
    }

    @NativeType(value="int")
    public static boolean glfwGetOSMesaColorBuffer(@NativeType(value="GLFWwindow *") long l2, @Nullable @NativeType(value="int *") int[] nArray, @Nullable @NativeType(value="int *") int[] nArray2, @Nullable @NativeType(value="int *") int[] nArray3, @Nullable @NativeType(value="void **") PointerBuffer pointerBuffer) {
        long l3 = Functions.GetOSMesaColorBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
            Checks.checkSafe(nArray3, 1);
            Checks.checkSafe(pointerBuffer, 1);
        }
        return JNI.invokePPPPPI(l2, nArray, nArray2, nArray3, MemoryUtil.memAddressSafe(pointerBuffer), l3) != 0;
    }

    public static int glfwGetOSMesaDepthBuffer(@NativeType(value="GLFWwindow *") long l2, @Nullable @NativeType(value="int *") int[] nArray, @Nullable @NativeType(value="int *") int[] nArray2, @Nullable @NativeType(value="int *") int[] nArray3, @Nullable @NativeType(value="void **") PointerBuffer pointerBuffer) {
        long l3 = Functions.GetOSMesaDepthBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
            Checks.checkSafe(nArray3, 1);
            Checks.checkSafe(pointerBuffer, 1);
        }
        return JNI.invokePPPPPI(l2, nArray, nArray2, nArray3, MemoryUtil.memAddressSafe(pointerBuffer), l3);
    }

    public static void setPath(FunctionProvider functionProvider) {
        if (!(functionProvider instanceof SharedLibrary)) {
            APIUtil.apiLog("GLFW OSMesa path override not set: Function provider is not a shared library.");
            return;
        }
        String string = ((SharedLibrary)functionProvider).getPath();
        if (string == null) {
            APIUtil.apiLog("GLFW OSMesa path override not set: Could not resolve the OSMesa shared library path.");
            return;
        }
        GLFWNativeOSMesa.setPath(string);
    }

    public static void setPath(@Nullable String string) {
        long l2 = GLFW.getLibrary().getFunctionAddress("_glfw_mesa_library");
        if (l2 == 0L) {
            APIUtil.apiLog("GLFW OSMesa path override not set: Could not resolve override symbol.");
            return;
        }
        long l3 = MemoryUtil.memGetAddress(l2);
        if (l3 != 0L) {
            MemoryUtil.nmemFree(l3);
        }
        MemoryUtil.memPutAddress(l2, string == null ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(string)));
    }

    public static final class Functions {
        public static final long GetOSMesaColorBuffer = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetOSMesaColorBuffer");
        public static final long GetOSMesaDepthBuffer = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetOSMesaDepthBuffer");
        public static final long GetOSMesaContext = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetOSMesaContext");

        private Functions() {
        }
    }
}

