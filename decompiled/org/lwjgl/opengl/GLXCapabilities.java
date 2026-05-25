/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.util.Set;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;

public final class GLXCapabilities {
    public final long glXQueryExtensionsString;
    public final long glXGetClientString;
    public final long glXQueryServerString;
    public final long glXGetCurrentDisplay;
    public final long glXGetFBConfigs;
    public final long glXChooseFBConfig;
    public final long glXGetFBConfigAttrib;
    public final long glXGetVisualFromFBConfig;
    public final long glXCreateWindow;
    public final long glXCreatePixmap;
    public final long glXDestroyPixmap;
    public final long glXCreatePbuffer;
    public final long glXDestroyPbuffer;
    public final long glXQueryDrawable;
    public final long glXCreateNewContext;
    public final long glXMakeContextCurrent;
    public final long glXGetCurrentReadDrawable;
    public final long glXQueryContext;
    public final long glXSelectEvent;
    public final long glXGetSelectedEvent;
    public final long glXGetProcAddress;
    public final long glXBlitContextFramebufferAMD;
    public final long glXCreateAssociatedContextAMD;
    public final long glXCreateAssociatedContextAttribsAMD;
    public final long glXDeleteAssociatedContextAMD;
    public final long glXGetContextGPUIDAMD;
    public final long glXGetCurrentAssociatedContextAMD;
    public final long glXGetGPUIDsAMD;
    public final long glXGetGPUInfoAMD;
    public final long glXMakeAssociatedContextCurrentAMD;
    public final long glXCreateContextAttribsARB;
    public final long glXGetProcAddressARB;
    public final long glXGetCurrentDisplayEXT;
    public final long glXQueryContextInfoEXT;
    public final long glXGetContextIDEXT;
    public final long glXImportContextEXT;
    public final long glXFreeContextEXT;
    public final long glXSwapIntervalEXT;
    public final long glXBindTexImageEXT;
    public final long glXReleaseTexImageEXT;
    public final long glXCopyBufferSubDataNV;
    public final long glXNamedCopyBufferSubDataNV;
    public final long glXCopyImageSubDataNV;
    public final long glXDelayBeforeSwapNV;
    public final long glXJoinSwapGroupNV;
    public final long glXBindSwapBarrierNV;
    public final long glXQuerySwapGroupNV;
    public final long glXQueryMaxSwapGroupsNV;
    public final long glXQueryFrameCountNV;
    public final long glXResetFrameCountNV;
    public final long glXMakeCurrentReadSGI;
    public final long glXGetCurrentReadDrawableSGI;
    public final long glXSwapIntervalSGI;
    public final long glXGetVideoSyncSGI;
    public final long glXWaitVideoSyncSGI;
    public final long glXGetFBConfigAttribSGIX;
    public final long glXChooseFBConfigSGIX;
    public final long glXCreateGLXPixmapWithConfigSGIX;
    public final long glXCreateContextWithConfigSGIX;
    public final long glXGetVisualFromFBConfigSGIX;
    public final long glXGetFBConfigFromVisualSGIX;
    public final long glXCreateGLXPbufferSGIX;
    public final long glXDestroyGLXPbufferSGIX;
    public final long glXQueryGLXPbufferSGIX;
    public final long glXSelectEventSGIX;
    public final long glXGetSelectedEventSGIX;
    public final long glXBindSwapBarrierSGIX;
    public final long glXQueryMaxSwapBarriersSGIX;
    public final long glXJoinSwapGroupSGIX;
    public final boolean GLX11;
    public final boolean GLX12;
    public final boolean GLX13;
    public final boolean GLX14;
    public final boolean GLX_AMD_gpu_association;
    public final boolean GLX_ARB_context_flush_control;
    public final boolean GLX_ARB_create_context;
    public final boolean GLX_ARB_create_context_no_error;
    public final boolean GLX_ARB_create_context_profile;
    public final boolean GLX_ARB_create_context_robustness;
    public final boolean GLX_ARB_fbconfig_float;
    public final boolean GLX_ARB_framebuffer_sRGB;
    public final boolean GLX_ARB_get_proc_address;
    public final boolean GLX_ARB_multisample;
    public final boolean GLX_ARB_robustness_application_isolation;
    public final boolean GLX_ARB_robustness_share_group_isolation;
    public final boolean GLX_ARB_vertex_buffer_object;
    public final boolean GLX_EXT_buffer_age;
    public final boolean GLX_EXT_context_priority;
    public final boolean GLX_EXT_create_context_es2_profile;
    public final boolean GLX_EXT_create_context_es_profile;
    public final boolean GLX_EXT_fbconfig_packed_float;
    public final boolean GLX_EXT_framebuffer_sRGB;
    public final boolean GLX_EXT_get_drawable_type;
    public final boolean GLX_EXT_import_context;
    public final boolean GLX_EXT_no_config_context;
    public final boolean GLX_EXT_stereo_tree;
    public final boolean GLX_EXT_swap_control;
    public final boolean GLX_EXT_swap_control_tear;
    public final boolean GLX_EXT_texture_from_pixmap;
    public final boolean GLX_EXT_visual_info;
    public final boolean GLX_EXT_visual_rating;
    public final boolean GLX_INTEL_swap_event;
    public final boolean GLX_NV_copy_buffer;
    public final boolean GLX_NV_copy_image;
    public final boolean GLX_NV_delay_before_swap;
    public final boolean GLX_NV_float_buffer;
    public final boolean GLX_NV_multigpu_context;
    public final boolean GLX_NV_multisample_coverage;
    public final boolean GLX_NV_robustness_video_memory_purge;
    public final boolean GLX_NV_swap_group;
    public final boolean GLX_SGI_make_current_read;
    public final boolean GLX_SGI_swap_control;
    public final boolean GLX_SGI_video_sync;
    public final boolean GLX_SGIX_fbconfig;
    public final boolean GLX_SGIX_pbuffer;
    public final boolean GLX_SGIX_swap_barrier;
    public final boolean GLX_SGIX_swap_group;

    GLXCapabilities(FunctionProvider functionProvider, Set<String> set) {
        long[] lArray = new long[69];
        this.GLX11 = GLXCapabilities.check_GLX11(functionProvider, lArray, set);
        this.GLX12 = GLXCapabilities.check_GLX12(functionProvider, lArray, set);
        this.GLX13 = GLXCapabilities.check_GLX13(functionProvider, lArray, set);
        this.GLX14 = GLXCapabilities.check_GLX14(functionProvider, lArray, set);
        this.GLX_AMD_gpu_association = GLXCapabilities.check_GLX_AMD_gpu_association(functionProvider, lArray, set);
        this.GLX_ARB_context_flush_control = set.contains("GLX_ARB_context_flush_control");
        this.GLX_ARB_create_context = GLXCapabilities.check_GLX_ARB_create_context(functionProvider, lArray, set);
        this.GLX_ARB_create_context_no_error = set.contains("GLX_ARB_create_context_no_error");
        this.GLX_ARB_create_context_profile = set.contains("GLX_ARB_create_context_profile");
        this.GLX_ARB_create_context_robustness = set.contains("GLX_ARB_create_context_robustness");
        this.GLX_ARB_fbconfig_float = set.contains("GLX_ARB_fbconfig_float");
        this.GLX_ARB_framebuffer_sRGB = set.contains("GLX_ARB_framebuffer_sRGB");
        this.GLX_ARB_get_proc_address = GLXCapabilities.check_GLX_ARB_get_proc_address(functionProvider, lArray, set);
        this.GLX_ARB_multisample = set.contains("GLX_ARB_multisample");
        this.GLX_ARB_robustness_application_isolation = set.contains("GLX_ARB_robustness_application_isolation");
        this.GLX_ARB_robustness_share_group_isolation = set.contains("GLX_ARB_robustness_share_group_isolation");
        this.GLX_ARB_vertex_buffer_object = set.contains("GLX_ARB_vertex_buffer_object");
        this.GLX_EXT_buffer_age = set.contains("GLX_EXT_buffer_age");
        this.GLX_EXT_context_priority = set.contains("GLX_EXT_context_priority");
        this.GLX_EXT_create_context_es2_profile = set.contains("GLX_EXT_create_context_es2_profile");
        this.GLX_EXT_create_context_es_profile = set.contains("GLX_EXT_create_context_es_profile");
        this.GLX_EXT_fbconfig_packed_float = set.contains("GLX_EXT_fbconfig_packed_float");
        this.GLX_EXT_framebuffer_sRGB = set.contains("GLX_EXT_framebuffer_sRGB");
        this.GLX_EXT_get_drawable_type = set.contains("GLX_EXT_get_drawable_type");
        this.GLX_EXT_import_context = GLXCapabilities.check_GLX_EXT_import_context(functionProvider, lArray, set);
        this.GLX_EXT_no_config_context = set.contains("GLX_EXT_no_config_context");
        this.GLX_EXT_stereo_tree = set.contains("GLX_EXT_stereo_tree");
        this.GLX_EXT_swap_control = GLXCapabilities.check_GLX_EXT_swap_control(functionProvider, lArray, set);
        this.GLX_EXT_swap_control_tear = set.contains("GLX_EXT_swap_control_tear");
        this.GLX_EXT_texture_from_pixmap = GLXCapabilities.check_GLX_EXT_texture_from_pixmap(functionProvider, lArray, set);
        this.GLX_EXT_visual_info = set.contains("GLX_EXT_visual_info");
        this.GLX_EXT_visual_rating = set.contains("GLX_EXT_visual_rating");
        this.GLX_INTEL_swap_event = set.contains("GLX_INTEL_swap_event");
        this.GLX_NV_copy_buffer = GLXCapabilities.check_GLX_NV_copy_buffer(functionProvider, lArray, set);
        this.GLX_NV_copy_image = GLXCapabilities.check_GLX_NV_copy_image(functionProvider, lArray, set);
        this.GLX_NV_delay_before_swap = GLXCapabilities.check_GLX_NV_delay_before_swap(functionProvider, lArray, set);
        this.GLX_NV_float_buffer = set.contains("GLX_NV_float_buffer");
        this.GLX_NV_multigpu_context = set.contains("GLX_NV_multigpu_context");
        this.GLX_NV_multisample_coverage = set.contains("GLX_NV_multisample_coverage");
        this.GLX_NV_robustness_video_memory_purge = set.contains("GLX_NV_robustness_video_memory_purge");
        this.GLX_NV_swap_group = GLXCapabilities.check_GLX_NV_swap_group(functionProvider, lArray, set);
        this.GLX_SGI_make_current_read = GLXCapabilities.check_GLX_SGI_make_current_read(functionProvider, lArray, set);
        this.GLX_SGI_swap_control = GLXCapabilities.check_GLX_SGI_swap_control(functionProvider, lArray, set);
        this.GLX_SGI_video_sync = GLXCapabilities.check_GLX_SGI_video_sync(functionProvider, lArray, set);
        this.GLX_SGIX_fbconfig = GLXCapabilities.check_GLX_SGIX_fbconfig(functionProvider, lArray, set);
        this.GLX_SGIX_pbuffer = GLXCapabilities.check_GLX_SGIX_pbuffer(functionProvider, lArray, set);
        this.GLX_SGIX_swap_barrier = GLXCapabilities.check_GLX_SGIX_swap_barrier(functionProvider, lArray, set);
        this.GLX_SGIX_swap_group = GLXCapabilities.check_GLX_SGIX_swap_group(functionProvider, lArray, set);
        this.glXQueryExtensionsString = lArray[0];
        this.glXGetClientString = lArray[1];
        this.glXQueryServerString = lArray[2];
        this.glXGetCurrentDisplay = lArray[3];
        this.glXGetFBConfigs = lArray[4];
        this.glXChooseFBConfig = lArray[5];
        this.glXGetFBConfigAttrib = lArray[6];
        this.glXGetVisualFromFBConfig = lArray[7];
        this.glXCreateWindow = lArray[8];
        this.glXCreatePixmap = lArray[9];
        this.glXDestroyPixmap = lArray[10];
        this.glXCreatePbuffer = lArray[11];
        this.glXDestroyPbuffer = lArray[12];
        this.glXQueryDrawable = lArray[13];
        this.glXCreateNewContext = lArray[14];
        this.glXMakeContextCurrent = lArray[15];
        this.glXGetCurrentReadDrawable = lArray[16];
        this.glXQueryContext = lArray[17];
        this.glXSelectEvent = lArray[18];
        this.glXGetSelectedEvent = lArray[19];
        this.glXGetProcAddress = lArray[20];
        this.glXBlitContextFramebufferAMD = lArray[21];
        this.glXCreateAssociatedContextAMD = lArray[22];
        this.glXCreateAssociatedContextAttribsAMD = lArray[23];
        this.glXDeleteAssociatedContextAMD = lArray[24];
        this.glXGetContextGPUIDAMD = lArray[25];
        this.glXGetCurrentAssociatedContextAMD = lArray[26];
        this.glXGetGPUIDsAMD = lArray[27];
        this.glXGetGPUInfoAMD = lArray[28];
        this.glXMakeAssociatedContextCurrentAMD = lArray[29];
        this.glXCreateContextAttribsARB = lArray[30];
        this.glXGetProcAddressARB = lArray[31];
        this.glXGetCurrentDisplayEXT = lArray[32];
        this.glXQueryContextInfoEXT = lArray[33];
        this.glXGetContextIDEXT = lArray[34];
        this.glXImportContextEXT = lArray[35];
        this.glXFreeContextEXT = lArray[36];
        this.glXSwapIntervalEXT = lArray[37];
        this.glXBindTexImageEXT = lArray[38];
        this.glXReleaseTexImageEXT = lArray[39];
        this.glXCopyBufferSubDataNV = lArray[40];
        this.glXNamedCopyBufferSubDataNV = lArray[41];
        this.glXCopyImageSubDataNV = lArray[42];
        this.glXDelayBeforeSwapNV = lArray[43];
        this.glXJoinSwapGroupNV = lArray[44];
        this.glXBindSwapBarrierNV = lArray[45];
        this.glXQuerySwapGroupNV = lArray[46];
        this.glXQueryMaxSwapGroupsNV = lArray[47];
        this.glXQueryFrameCountNV = lArray[48];
        this.glXResetFrameCountNV = lArray[49];
        this.glXMakeCurrentReadSGI = lArray[50];
        this.glXGetCurrentReadDrawableSGI = lArray[51];
        this.glXSwapIntervalSGI = lArray[52];
        this.glXGetVideoSyncSGI = lArray[53];
        this.glXWaitVideoSyncSGI = lArray[54];
        this.glXGetFBConfigAttribSGIX = lArray[55];
        this.glXChooseFBConfigSGIX = lArray[56];
        this.glXCreateGLXPixmapWithConfigSGIX = lArray[57];
        this.glXCreateContextWithConfigSGIX = lArray[58];
        this.glXGetVisualFromFBConfigSGIX = lArray[59];
        this.glXGetFBConfigFromVisualSGIX = lArray[60];
        this.glXCreateGLXPbufferSGIX = lArray[61];
        this.glXDestroyGLXPbufferSGIX = lArray[62];
        this.glXQueryGLXPbufferSGIX = lArray[63];
        this.glXSelectEventSGIX = lArray[64];
        this.glXGetSelectedEventSGIX = lArray[65];
        this.glXBindSwapBarrierSGIX = lArray[66];
        this.glXQueryMaxSwapBarriersSGIX = lArray[67];
        this.glXJoinSwapGroupSGIX = lArray[68];
    }

    private static boolean check_GLX11(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX11")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{0, 1, 2}, "glXQueryExtensionsString", "glXGetClientString", "glXQueryServerString") || Checks.reportMissing("GLX", "GLX11");
    }

    private static boolean check_GLX12(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX12")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{3}, "glXGetCurrentDisplay") || Checks.reportMissing("GLX", "GLX12");
    }

    private static boolean check_GLX13(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX13")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, "glXGetFBConfigs", "glXChooseFBConfig", "glXGetFBConfigAttrib", "glXGetVisualFromFBConfig", "glXCreateWindow", "glXCreatePixmap", "glXDestroyPixmap", "glXCreatePbuffer", "glXDestroyPbuffer", "glXQueryDrawable", "glXCreateNewContext", "glXMakeContextCurrent", "glXGetCurrentReadDrawable", "glXQueryContext", "glXSelectEvent", "glXGetSelectedEvent") || Checks.reportMissing("GLX", "GLX13");
    }

    private static boolean check_GLX14(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX14")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{20}, "glXGetProcAddress") || Checks.reportMissing("GLX", "GLX14");
    }

    private static boolean check_GLX_AMD_gpu_association(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_AMD_gpu_association")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{21, 22, 23, 24, 25, 26, 27, 28, 29}, "glXBlitContextFramebufferAMD", "glXCreateAssociatedContextAMD", "glXCreateAssociatedContextAttribsAMD", "glXDeleteAssociatedContextAMD", "glXGetContextGPUIDAMD", "glXGetCurrentAssociatedContextAMD", "glXGetGPUIDsAMD", "glXGetGPUInfoAMD", "glXMakeAssociatedContextCurrentAMD") || Checks.reportMissing("GLX", "GLX_AMD_gpu_association");
    }

    private static boolean check_GLX_ARB_create_context(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_ARB_create_context")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{30}, "glXCreateContextAttribsARB") || Checks.reportMissing("GLX", "GLX_ARB_create_context");
    }

    private static boolean check_GLX_ARB_get_proc_address(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_ARB_get_proc_address")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{31}, "glXGetProcAddressARB") || Checks.reportMissing("GLX", "GLX_ARB_get_proc_address");
    }

    private static boolean check_GLX_EXT_import_context(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_EXT_import_context")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{32, 33, 34, 35, 36}, "glXGetCurrentDisplayEXT", "glXQueryContextInfoEXT", "glXGetContextIDEXT", "glXImportContextEXT", "glXFreeContextEXT") || Checks.reportMissing("GLX", "GLX_EXT_import_context");
    }

    private static boolean check_GLX_EXT_swap_control(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_EXT_swap_control")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{37}, "glXSwapIntervalEXT") || Checks.reportMissing("GLX", "GLX_EXT_swap_control");
    }

    private static boolean check_GLX_EXT_texture_from_pixmap(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_EXT_texture_from_pixmap")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{38, 39}, "glXBindTexImageEXT", "glXReleaseTexImageEXT") || Checks.reportMissing("GLX", "GLX_EXT_texture_from_pixmap");
    }

    private static boolean check_GLX_NV_copy_buffer(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_NV_copy_buffer")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{40, 41}, "glXCopyBufferSubDataNV", "glXNamedCopyBufferSubDataNV") || Checks.reportMissing("GLX", "GLX_NV_copy_buffer");
    }

    private static boolean check_GLX_NV_copy_image(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_NV_copy_image")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{42}, "glXCopyImageSubDataNV") || Checks.reportMissing("GLX", "GLX_NV_copy_image");
    }

    private static boolean check_GLX_NV_delay_before_swap(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_NV_delay_before_swap")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{43}, "glXDelayBeforeSwapNV") || Checks.reportMissing("GLX", "GLX_NV_delay_before_swap");
    }

    private static boolean check_GLX_NV_swap_group(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_NV_swap_group")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{44, 45, 46, 47, 48, 49}, "glXJoinSwapGroupNV", "glXBindSwapBarrierNV", "glXQuerySwapGroupNV", "glXQueryMaxSwapGroupsNV", "glXQueryFrameCountNV", "glXResetFrameCountNV") || Checks.reportMissing("GLX", "GLX_NV_swap_group");
    }

    private static boolean check_GLX_SGI_make_current_read(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_SGI_make_current_read")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{50, 51}, "glXMakeCurrentReadSGI", "glXGetCurrentReadDrawableSGI") || Checks.reportMissing("GLX", "GLX_SGI_make_current_read");
    }

    private static boolean check_GLX_SGI_swap_control(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_SGI_swap_control")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{52}, "glXSwapIntervalSGI") || Checks.reportMissing("GLX", "GLX_SGI_swap_control");
    }

    private static boolean check_GLX_SGI_video_sync(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_SGI_video_sync")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{53, 54}, "glXGetVideoSyncSGI", "glXWaitVideoSyncSGI") || Checks.reportMissing("GLX", "GLX_SGI_video_sync");
    }

    private static boolean check_GLX_SGIX_fbconfig(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_SGIX_fbconfig")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{55, 56, 57, 58, 59, 60}, "glXGetFBConfigAttribSGIX", "glXChooseFBConfigSGIX", "glXCreateGLXPixmapWithConfigSGIX", "glXCreateContextWithConfigSGIX", "glXGetVisualFromFBConfigSGIX", "glXGetFBConfigFromVisualSGIX") || Checks.reportMissing("GLX", "GLX_SGIX_fbconfig");
    }

    private static boolean check_GLX_SGIX_pbuffer(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_SGIX_pbuffer")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{61, 62, 63, 64, 65}, "glXCreateGLXPbufferSGIX", "glXDestroyGLXPbufferSGIX", "glXQueryGLXPbufferSGIX", "glXSelectEventSGIX", "glXGetSelectedEventSGIX") || Checks.reportMissing("GLX", "GLX_SGIX_pbuffer");
    }

    private static boolean check_GLX_SGIX_swap_barrier(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_SGIX_swap_barrier")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{66, 67}, "glXBindSwapBarrierSGIX", "glXQueryMaxSwapBarriersSGIX") || Checks.reportMissing("GLX", "GLX_SGIX_swap_barrier");
    }

    private static boolean check_GLX_SGIX_swap_group(FunctionProvider functionProvider, long[] lArray, Set<String> set) {
        if (!set.contains("GLX_SGIX_swap_group")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, lArray, new int[]{68}, "glXJoinSwapGroupSGIX") || Checks.reportMissing("GLX", "GLX_SGIX_swap_group");
    }
}

