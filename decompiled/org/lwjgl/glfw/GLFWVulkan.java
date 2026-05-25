/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  org.lwjgl.vulkan.VK
 *  org.lwjgl.vulkan.VkAllocationCallbacks
 *  org.lwjgl.vulkan.VkInstance
 *  org.lwjgl.vulkan.VkPhysicalDevice
 */
package org.lwjgl.glfw;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Platform;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.vulkan.VK;
import org.lwjgl.vulkan.VkAllocationCallbacks;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;

public class GLFWVulkan {
    protected GLFWVulkan() {
        throw new UnsupportedOperationException();
    }

    public static void glfwInitVulkanLoader(@NativeType(value="PFN_vkGetInstanceProcAddr") long l2) {
        long l3 = Functions.InitVulkanLoader;
        JNI.invokePV(l2, l3);
    }

    @NativeType(value="int")
    public static boolean glfwVulkanSupported() {
        long l2 = Functions.VulkanSupported;
        return JNI.invokeI(l2) != 0;
    }

    public static long nglfwGetRequiredInstanceExtensions(long l2) {
        long l3 = Functions.GetRequiredInstanceExtensions;
        return JNI.invokePP(l2, l3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    @NativeType(value="char const **")
    public static PointerBuffer glfwGetRequiredInstanceExtensions() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l2 = GLFWVulkan.nglfwGetRequiredInstanceExtensions(MemoryUtil.memAddress(intBuffer));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(l2, intBuffer.get(0));
            return pointerBuffer;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static long nglfwGetInstanceProcAddress(long l2, long l3) {
        long l4 = Functions.GetInstanceProcAddress;
        return JNI.invokePPP(l2, l3, l4);
    }

    @NativeType(value="GLFWvkproc")
    public static long glfwGetInstanceProcAddress(@Nullable VkInstance vkInstance, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return GLFWVulkan.nglfwGetInstanceProcAddress(MemoryUtil.memAddressSafe((Pointer)vkInstance), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLFWvkproc")
    public static long glfwGetInstanceProcAddress(@Nullable VkInstance vkInstance, @NativeType(value="char const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            long l3 = GLFWVulkan.nglfwGetInstanceProcAddress(MemoryUtil.memAddressSafe((Pointer)vkInstance), l2);
            return l3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    @NativeType(value="int")
    public static boolean glfwGetPhysicalDevicePresentationSupport(VkInstance vkInstance, VkPhysicalDevice vkPhysicalDevice, @NativeType(value="uint32_t") int n2) {
        long l2 = Functions.GetPhysicalDevicePresentationSupport;
        return JNI.invokePPI(vkInstance.address(), vkPhysicalDevice.address(), n2, l2) != 0;
    }

    public static int nglfwCreateWindowSurface(long l2, long l3, long l4, long l5) {
        long l6 = Functions.CreateWindowSurface;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return JNI.invokePPPPI(l2, l3, l4, l5, l6);
    }

    @NativeType(value="VkResult")
    public static int glfwCreateWindowSurface(VkInstance vkInstance, @NativeType(value="GLFWwindow *") long l2, @Nullable @NativeType(value="VkAllocationCallbacks const *") VkAllocationCallbacks vkAllocationCallbacks, @NativeType(value="VkSurfaceKHR *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        return GLFWVulkan.nglfwCreateWindowSurface(vkInstance.address(), l2, MemoryUtil.memAddressSafe((Pointer)vkAllocationCallbacks), MemoryUtil.memAddress(longBuffer));
    }

    @NativeType(value="VkResult")
    public static int glfwCreateWindowSurface(VkInstance vkInstance, @NativeType(value="GLFWwindow *") long l2, @Nullable @NativeType(value="VkAllocationCallbacks const *") VkAllocationCallbacks vkAllocationCallbacks, @NativeType(value="VkSurfaceKHR *") long[] lArray) {
        long l3 = Functions.CreateWindowSurface;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(lArray, 1);
        }
        return JNI.invokePPPPI(vkInstance.address(), l2, MemoryUtil.memAddressSafe((Pointer)vkAllocationCallbacks), lArray, l3);
    }

    public static void setPath(FunctionProvider functionProvider) {
        if (!(functionProvider instanceof SharedLibrary)) {
            APIUtil.apiLog("GLFW Vulkan path override not set: function provider is not a shared library.");
            return;
        }
        String string = ((SharedLibrary)functionProvider).getPath();
        if (string == null) {
            APIUtil.apiLog("GLFW Vulkan path override not set: Could not resolve the shared library path.");
            return;
        }
        GLFWVulkan.setPath(string);
    }

    public static void setPath(@Nullable String string) {
        long l2 = GLFW.getLibrary().getFunctionAddress("_glfw_vulkan_library");
        if (l2 == 0L) {
            APIUtil.apiLog("GLFW Vulkan path override not set: Could not resolve override symbol.");
            return;
        }
        long l3 = MemoryUtil.memGetAddress(l2);
        if (l3 != 0L) {
            MemoryUtil.nmemFree(l3);
        }
        MemoryUtil.memPutAddress(l2, string == null ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(string)));
    }

    static {
        if (Platform.get() == Platform.MACOSX) {
            GLFWVulkan.setPath(VK.getFunctionProvider());
        }
    }

    public static final class Functions {
        public static final long InitVulkanLoader = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwInitVulkanLoader");
        public static final long VulkanSupported = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwVulkanSupported");
        public static final long GetRequiredInstanceExtensions = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetRequiredInstanceExtensions");
        public static final long GetInstanceProcAddress = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetInstanceProcAddress");
        public static final long GetPhysicalDevicePresentationSupport = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetPhysicalDevicePresentationSupport");
        public static final long CreateWindowSurface = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwCreateWindowSurface");

        private Functions() {
        }
    }
}

