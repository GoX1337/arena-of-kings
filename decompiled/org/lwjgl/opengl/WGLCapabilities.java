/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.util.Set;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;

public final class WGLCapabilities {
    public final long wglGetGPUIDsAMD;
    public final long wglGetGPUInfoAMD;
    public final long wglGetContextGPUIDAMD;
    public final long wglCreateAssociatedContextAMD;
    public final long wglCreateAssociatedContextAttribsAMD;
    public final long wglDeleteAssociatedContextAMD;
    public final long wglMakeAssociatedContextCurrentAMD;
    public final long wglGetCurrentAssociatedContextAMD;
    public final long wglBlitContextFramebufferAMD;
    public final long wglCreateBufferRegionARB;
    public final long wglDeleteBufferRegionARB;
    public final long wglSaveBufferRegionARB;
    public final long wglRestoreBufferRegionARB;
    public final long wglCreateContextAttribsARB;
    public final long wglGetExtensionsStringARB;
    public final long wglMakeContextCurrentARB;
    public final long wglGetCurrentReadDCARB;
    public final long wglCreatePbufferARB;
    public final long wglGetPbufferDCARB;
    public final long wglReleasePbufferDCARB;
    public final long wglDestroyPbufferARB;
    public final long wglQueryPbufferARB;
    public final long wglGetPixelFormatAttribivARB;
    public final long wglGetPixelFormatAttribfvARB;
    public final long wglChoosePixelFormatARB;
    public final long wglBindTexImageARB;
    public final long wglReleaseTexImageARB;
    public final long wglSetPbufferAttribARB;
    public final long wglGetExtensionsStringEXT;
    public final long wglSwapIntervalEXT;
    public final long wglGetSwapIntervalEXT;
    public final long wglCopyImageSubDataNV;
    public final long wglDelayBeforeSwapNV;
    public final long wglDXSetResourceShareHandleNV;
    public final long wglDXOpenDeviceNV;
    public final long wglDXCloseDeviceNV;
    public final long wglDXRegisterObjectNV;
    public final long wglDXUnregisterObjectNV;
    public final long wglDXObjectAccessNV;
    public final long wglDXLockObjectsNV;
    public final long wglDXUnlockObjectsNV;
    public final long wglEnumGpusNV;
    public final long wglEnumGpuDevicesNV;
    public final long wglCreateAffinityDCNV;
    public final long wglEnumGpusFromAffinityDCNV;
    public final long wglDeleteDCNV;
    public final long wglJoinSwapGroupNV;
    public final long wglBindSwapBarrierNV;
    public final long wglQuerySwapGroupNV;
    public final long wglQueryMaxSwapGroupsNV;
    public final long wglQueryFrameCountNV;
    public final long wglResetFrameCountNV;
    public final long wglAllocateMemoryNV;
    public final long wglFreeMemoryNV;
    public final boolean WGL_AMD_gpu_association;
    public final boolean WGL_ARB_buffer_region;
    public final boolean WGL_ARB_context_flush_control;
    public final boolean WGL_ARB_create_context;
    public final boolean WGL_ARB_create_context_no_error;
    public final boolean WGL_ARB_create_context_profile;
    public final boolean WGL_ARB_create_context_robustness;
    public final boolean WGL_ARB_extensions_string;
    public final boolean WGL_ARB_framebuffer_sRGB;
    public final boolean WGL_ARB_make_current_read;
    public final boolean WGL_ARB_multisample;
    public final boolean WGL_ARB_pbuffer;
    public final boolean WGL_ARB_pixel_format;
    public final boolean WGL_ARB_pixel_format_float;
    public final boolean WGL_ARB_render_texture;
    public final boolean WGL_ARB_robustness_application_isolation;
    public final boolean WGL_ARB_robustness_share_group_isolation;
    public final boolean WGL_ATI_pixel_format_float;
    public final boolean WGL_ATI_render_texture_rectangle;
    public final boolean WGL_EXT_colorspace;
    public final boolean WGL_EXT_create_context_es2_profile;
    public final boolean WGL_EXT_create_context_es_profile;
    public final boolean WGL_EXT_depth_float;
    public final boolean WGL_EXT_extensions_string;
    public final boolean WGL_EXT_framebuffer_sRGB;
    public final boolean WGL_EXT_pixel_format_packed_float;
    public final boolean WGL_EXT_swap_control;
    public final boolean WGL_EXT_swap_control_tear;
    public final boolean WGL_NV_copy_image;
    public final boolean WGL_NV_delay_before_swap;
    public final boolean WGL_NV_DX_interop;
    public final boolean WGL_NV_DX_interop2;
    public final boolean WGL_NV_float_buffer;
    public final boolean WGL_NV_gpu_affinity;
    public final boolean WGL_NV_multigpu_context;
    public final boolean WGL_NV_multisample_coverage;
    public final boolean WGL_NV_render_depth_texture;
    public final boolean WGL_NV_render_texture_rectangle;
    public final boolean WGL_NV_swap_group;
    public final boolean WGL_NV_vertex_array_range;

    WGLCapabilities(FunctionProvider functionProvider, Set<String> set) {
        long[] lArray = new long[54];
        this.WGL_AMD_gpu_association = WGLCapabilities.check_WGL_AMD_gpu_association(functionProvider, lArray, set);
        this.WGL_ARB_buffer_region = WGLCapabilities.check_WGL_ARB_buffer_region(functionProvider, lArray, set);
        this.WGL_ARB_context_flush_control = set.contains("WGL_ARB_context_flush_control");
        this.WGL_ARB_create_context = WGLCapabilities.check_WGL_ARB_create_context(functionProvider, lArray, set);
        this.WGL_ARB_create_context_no_error = set.contains("WGL_ARB_create_context_no_error");
        this.WGL_ARB_create_context_profile = set.contains("WGL_ARB_create_context_profile");
        this.WGL_ARB_create_context_robustness = set.contains("WGL_ARB_create_context_robustness");
        this.WGL_ARB_extensions_string = WGLCapabilities.check_WGL_ARB_extensions_string(functionProvider, lArray, set);
        this.WGL_ARB_framebuffer_sRGB = set.contains("WGL_ARB_framebuffer_sRGB");
        this.WGL_ARB_make_current_read = WGLCapabilities.check_WGL_ARB_make_current_read(functionProvider, lArray, set);
        this.WGL_ARB_multisample = set.contains("WGL_ARB_multisample");
        this.WGL_ARB_pbuffer = WGLCapabilities.check_WGL_ARB_pbuffer(functionProvider, lArray, set);
        this.WGL_ARB_pixel_format = WGLCapabilities.check_WGL_ARB_pixel_format(functionProvider, lArray, set);
        this.WGL_ARB_pixel_format_float = set.contains("WGL_ARB_pixel_format_float");
        this.WGL_ARB_render_texture = WGLCapabilities.check_WGL_ARB_render_texture(functionProvider, lArray, set);
        this.WGL_ARB_robustness_application_isolation = set.contains("WGL_ARB_robustness_application_isolation");
        this.WGL_ARB_robustness_share_group_isolation = set.contains("WGL_ARB_robustness_share_group_isolation");
        this.WGL_ATI_pixel_format_float = set.contains("WGL_ATI_pixel_format_float");
        this.WGL_ATI_render_texture_rectangle = set.contains("WGL_ATI_render_texture_rectangle");
        this.WGL_EXT_colorspace = set.contains("WGL_EXT_colorspace");
        this.WGL_EXT_create_context_es2_profile = set.contains("WGL_EXT_create_context_es2_profile");
        this.WGL_EXT_create_context_es_profile = set.contains("WGL_EXT_create_context_es_profile");
        this.WGL_EXT_depth_float = set.contains("WGL_EXT_depth_float");
        this.WGL_EXT_extensions_string = WGLCapabilities.check_WGL_EXT_extensions_string(functionProvider, lArray, set);
        this.WGL_EXT_framebuffer_sRGB = set.contains("WGL_EXT_framebuffer_sRGB");
        this.WGL_EXT_pixel_format_packed_float = set.contains("WGL_EXT_pixel_format_packed_float");
        this.WGL_EXT_swap_control = WGLCapabilities.check_WGL_EXT_swap_control(functionProvider, lArray, set);
        this.WGL_EXT_swap_control_tear = set.contains("WGL_EXT_swap_control_tear");
        this.WGL_NV_copy_image = WGLCapabilities.check_WGL_NV_copy_image(functionProvider, lArray, set);
        this.WGL_NV_delay_before_swap = WGLCapabilities.check_WGL_NV_delay_before_swap(functionProvider, lArray, set);
        this.WGL_NV_DX_interop = WGLCapabilities.check_WGL_NV_DX_interop(functionProvider, lArray, set);
        this.WGL_NV_DX_interop2 = set.contains("WGL_NV_DX_interop2");
        this.WGL_NV_float_buffer = set.contains("WGL_NV_float_buffer");
        this.WGL_NV_gpu_affinity = WGLCapabilities.check_WGL_NV_gpu_affinity(functionProvider, lArray, set);
        this.WGL_NV_multigpu_context = set.contains("WGL_NV_multigpu_context");
        this.WGL_NV_multisample_coverage = set.contains("WGL_NV_multisample_coverage");
        this.WGL_NV_render_depth_texture = set.contains("WGL_NV_render_depth_texture");
        this.WGL_NV_render_texture_rectangle = set.contains("WGL_NV_render_texture_rectangle");
        this.WGL_NV_swap_group = WGLCapabilities.check_WGL_NV_swap_group(functionProvider, lArray, set);
        this.WGL_NV_vertex_array_range = WGLCapabilities.check_WGL_NV_vertex_array_range(functionProvider, lArray, set);
        this.wglGetGPUIDsAMD = lArray[0];
        this.wglGetGPUInfoAMD = lArray[1];
        this.wglGetContextGPUIDAMD = lArray[2];
        this.wglCreateAssociatedContextAMD = lArray[3];
        this.wglCreateAssociatedContextAttribsAMD = lArray[4];
        this.wglDeleteAssociatedContextAMD = lArray[5];
        this.wglMakeAssociatedContextCurrentAMD = lArray[6];
        this.wglGetCurrentAssociatedContextAMD = lArray[7];
        this.wglBlitContextFramebufferAMD = lArray[8];
        this.wglCreateBufferRegionARB = lArray[9];
        this.wglDeleteBufferRegionARB = lArray[10];
        this.wglSaveBufferRegionARB = lArray[11];
        this.wglRestoreBufferRegionARB = lArray[12];
        this.wglCreateContextAttribsARB = lArray[13];
        this.wglGetExtensionsStringARB = lArray[14];
        this.wglMakeContextCurrentARB = lArray[15];
        this.wglGetCurrentReadDCARB = lArray[16];
        this.wglCreatePbufferARB = lArray[17];
        this.wglGetPbufferDCARB = lArray[18];
        this.wglReleasePbufferDCARB = lArray[19];
        this.wglDestroyPbufferARB = lArray[20];
        this.wglQueryPbufferARB = lArray[21];
        this.wglGetPixelFormatAttribivARB = lArray[22];
        this.wglGetPixelFormatAttribfvARB = lArray[23];
        this.wglChoosePixelFormatARB = lArray[24];
        this.wglBindTexImageARB = lArray[25];
        this.wglReleaseTexImageARB = lArray[26];
        this.wglSetPbufferAttribARB = lArray[27];
        this.wglGetExtensionsStringEXT = lArray[28];
        this.wglSwapIntervalEXT = lArray[29];
        this.wglGetSwapIntervalEXT = lArray[30];
        this.wglCopyImageSubDataNV = lArray[31];
        this.wglDelayBeforeSwapNV = lArray[32];
        this.wglDXSetResourceShareHandleNV = lArray[33];
        this.wglDXOpenDeviceNV = lArray[34];
        this.wglDXCloseDeviceNV = lArray[35];
        this.wglDXRegisterObjectNV = lArray[36];
        this.wglDXUnregisterObjectNV = lArray[37];
        this.wglDXObjectAccessNV = lArray[38];
        this.wglDXLockObjectsNV = lArray[39];
        this.wglDXUnlockObjectsNV = lArray[40];
        this.wglEnumGpusNV = lArray[41];
        this.wglEnumGpuDevicesNV = lArray[42];
        this.wglCreateAffinityDCNV = lArray[43];
        this.wglEnumGpusFromAffinityDCNV = lArray[44];
        this.wglDeleteDCNV = lArray[45];
        this.wglJoinSwapGroupNV = lArray[46];
        this.wglBindSwapBarrierNV = lArray[47];
        this.wglQuerySwapGroupNV = lArray[48];
        this.wglQueryMaxSwapGroupsNV = lArray[49];
        this.wglQueryFrameCountNV = lArray[50];
        this.wglResetFrameCountNV = lArray[51];
        this.wglAllocateMemoryNV = lArray[52];
        this.wglFreeMemoryNV = lArray[53];
    }

    private static boolean check_WGL_AMD_gpu_association(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_AMD_gpu_association")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, "wglGetGPUIDsAMD", "wglGetGPUInfoAMD", "wglGetContextGPUIDAMD", "wglCreateAssociatedContextAMD", "wglCreateAssociatedContextAttribsAMD", "wglDeleteAssociatedContextAMD", "wglMakeAssociatedContextCurrentAMD", "wglGetCurrentAssociatedContextAMD") || Checks.reportMissing("WGL", "WGL_AMD_gpu_association");
    }

    private static boolean check_WGL_ARB_buffer_region(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_ARB_buffer_region")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{9, 10, 11, 12}, "wglCreateBufferRegionARB", "wglDeleteBufferRegionARB", "wglSaveBufferRegionARB", "wglRestoreBufferRegionARB") || Checks.reportMissing("WGL", "WGL_ARB_buffer_region");
    }

    private static boolean check_WGL_ARB_create_context(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_ARB_create_context")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{13}, "wglCreateContextAttribsARB") || Checks.reportMissing("WGL", "WGL_ARB_create_context");
    }

    private static boolean check_WGL_ARB_extensions_string(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_ARB_extensions_string")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{14}, "wglGetExtensionsStringARB") || Checks.reportMissing("WGL", "WGL_ARB_extensions_string");
    }

    private static boolean check_WGL_ARB_make_current_read(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_ARB_make_current_read")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{15, 16}, "wglMakeContextCurrentARB", "wglGetCurrentReadDCARB") || Checks.reportMissing("WGL", "WGL_ARB_make_current_read");
    }

    private static boolean check_WGL_ARB_pbuffer(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_ARB_pbuffer")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{17, 18, 19, 20, 21}, "wglCreatePbufferARB", "wglGetPbufferDCARB", "wglReleasePbufferDCARB", "wglDestroyPbufferARB", "wglQueryPbufferARB") || Checks.reportMissing("WGL", "WGL_ARB_pbuffer");
    }

    private static boolean check_WGL_ARB_pixel_format(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_ARB_pixel_format")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{22, 23, 24}, "wglGetPixelFormatAttribivARB", "wglGetPixelFormatAttribfvARB", "wglChoosePixelFormatARB") || Checks.reportMissing("WGL", "WGL_ARB_pixel_format");
    }

    private static boolean check_WGL_ARB_render_texture(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_ARB_render_texture")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{25, 26, 27}, "wglBindTexImageARB", "wglReleaseTexImageARB", "wglSetPbufferAttribARB") || Checks.reportMissing("WGL", "WGL_ARB_render_texture");
    }

    private static boolean check_WGL_EXT_extensions_string(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_EXT_extensions_string")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{28}, "wglGetExtensionsStringEXT") || Checks.reportMissing("WGL", "WGL_EXT_extensions_string");
    }

    private static boolean check_WGL_EXT_swap_control(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_EXT_swap_control")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{29, 30}, "wglSwapIntervalEXT", "wglGetSwapIntervalEXT") || Checks.reportMissing("WGL", "WGL_EXT_swap_control");
    }

    private static boolean check_WGL_NV_copy_image(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_NV_copy_image")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{31}, "wglCopyImageSubDataNV") || Checks.reportMissing("WGL", "WGL_NV_copy_image");
    }

    private static boolean check_WGL_NV_delay_before_swap(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_NV_delay_before_swap")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{32}, "wglDelayBeforeSwapNV") || Checks.reportMissing("WGL", "WGL_NV_delay_before_swap");
    }

    private static boolean check_WGL_NV_DX_interop(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_NV_DX_interop")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{33, 34, 35, 36, 37, 38, 39, 40}, "wglDXSetResourceShareHandleNV", "wglDXOpenDeviceNV", "wglDXCloseDeviceNV", "wglDXRegisterObjectNV", "wglDXUnregisterObjectNV", "wglDXObjectAccessNV", "wglDXLockObjectsNV", "wglDXUnlockObjectsNV") || Checks.reportMissing("WGL", "WGL_NV_DX_interop");
    }

    private static boolean check_WGL_NV_gpu_affinity(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_NV_gpu_affinity")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{41, 42, 43, 44, 45}, "wglEnumGpusNV", "wglEnumGpuDevicesNV", "wglCreateAffinityDCNV", "wglEnumGpusFromAffinityDCNV", "wglDeleteDCNV") || Checks.reportMissing("WGL", "WGL_NV_gpu_affinity");
    }

    private static boolean check_WGL_NV_swap_group(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_NV_swap_group")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{46, 47, 48, 49, 50, 51}, "wglJoinSwapGroupNV", "wglBindSwapBarrierNV", "wglQuerySwapGroupNV", "wglQueryMaxSwapGroupsNV", "wglQueryFrameCountNV", "wglResetFrameCountNV") || Checks.reportMissing("WGL", "WGL_NV_swap_group");
    }

    private static boolean check_WGL_NV_vertex_array_range(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("WGL_NV_vertex_array_range")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{52, 53}, "wglAllocateMemoryNV", "wglFreeMemoryNV") || Checks.reportMissing("WGL", "WGL_NV_vertex_array_range");
    }
}

