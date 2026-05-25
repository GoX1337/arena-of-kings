/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class CGL {
    public static final int kCGLPFAAllRenderers = 1;
    public static final int kCGLPFATripleBuffer = 3;
    public static final int kCGLPFADoubleBuffer = 5;
    public static final int kCGLPFAStereo = 6;
    public static final int kCGLPFAColorSize = 8;
    public static final int kCGLPFAAlphaSize = 11;
    public static final int kCGLPFADepthSize = 12;
    public static final int kCGLPFAStencilSize = 13;
    public static final int kCGLPFAMinimumPolicy = 51;
    public static final int kCGLPFAMaximumPolicy = 52;
    public static final int kCGLPFASampleBuffers = 55;
    public static final int kCGLPFASamples = 56;
    public static final int kCGLPFAColorFloat = 58;
    public static final int kCGLPFAMultisample = 59;
    public static final int kCGLPFASupersample = 60;
    public static final int kCGLPFASampleAlpha = 61;
    public static final int kCGLPFARendererID = 70;
    public static final int kCGLPFASingleRenderer = 71;
    public static final int kCGLPFANoRecovery = 72;
    public static final int kCGLPFAAccelerated = 73;
    public static final int kCGLPFAClosestPolicy = 74;
    public static final int kCGLPFABackingStore = 76;
    public static final int kCGLPFABackingVolatile = 77;
    public static final int kCGLPFADisplayMask = 84;
    public static final int kCGLPFAAllowOfflineRenderers = 96;
    public static final int kCGLPFAAcceleratedCompute = 97;
    public static final int kCGLPFAOpenGLProfile = 99;
    public static final int kCGLPFASupportsAutomaticGraphicsSwitching = 101;
    public static final int kCGLPFAVirtualScreenCount = 128;
    public static final int kCGLPFAAuxBuffers = 7;
    public static final int kCGLPFAAccumSize = 14;
    public static final int kCGLPFAOffScreen = 53;
    public static final int kCGLPFAAuxDepthStencil = 57;
    public static final int kCGLPFAWindow = 80;
    public static final int kCGLPFACompliant = 83;
    public static final int kCGLPFAPBuffer = 90;
    public static final int kCGLPFARemotePBuffer = 91;
    public static final int kCGLPFARobust = 75;
    public static final int kCGLPFAMPSafe = 78;
    public static final int kCGLPFAMultiScreen = 81;
    public static final int kCGLPFAFullScreen = 54;
    public static final int kCGLRPOffScreen = 53;
    public static final int kCGLRPRendererID = 70;
    public static final int kCGLRPAccelerated = 73;
    public static final int kCGLRPBackingStore = 76;
    public static final int kCGLRPWindow = 80;
    public static final int kCGLRPCompliant = 83;
    public static final int kCGLRPDisplayMask = 84;
    public static final int kCGLRPBufferModes = 100;
    public static final int kCGLRPColorModes = 103;
    public static final int kCGLRPAccumModes = 104;
    public static final int kCGLRPDepthModes = 105;
    public static final int kCGLRPStencilModes = 106;
    public static final int kCGLRPMaxAuxBuffers = 107;
    public static final int kCGLRPMaxSampleBuffers = 108;
    public static final int kCGLRPMaxSamples = 109;
    public static final int kCGLRPSampleModes = 110;
    public static final int kCGLRPSampleAlpha = 111;
    public static final int kCGLRPVideoMemory = 120;
    public static final int kCGLRPTextureMemory = 121;
    public static final int kCGLRPGPUVertProcCapable = 122;
    public static final int kCGLRPGPUFragProcCapable = 123;
    public static final int kCGLRPRendererCount = 128;
    public static final int kCGLRPOnline = 129;
    public static final int kCGLRPAcceleratedCompute = 130;
    public static final int kCGLRPVideoMemoryMegabytes = 131;
    public static final int kCGLRPTextureMemoryMegabytes = 132;
    public static final int kCGLRPRobust = 75;
    public static final int kCGLRPMPSafe = 78;
    public static final int kCGLRPMultiScreen = 81;
    public static final int kCGLRPFullScreen = 54;
    public static final int kCGLCESwapRectangle = 201;
    public static final int kCGLCESwapLimit = 203;
    public static final int kCGLCERasterization = 221;
    public static final int kCGLCEStateValidation = 301;
    public static final int kCGLCESurfaceBackingSize = 305;
    public static final int kCGLCEDisplayListOptimization = 307;
    public static final int kCGLCEMPEngine = 313;
    public static final int kCGLCPSwapRectangle = 200;
    public static final int kCGLCPSwapInterval = 222;
    public static final int kCGLCPDispatchTableSize = 224;
    public static final int kCGLCPClientStorage = 226;
    public static final int kCGLCPSurfaceTexture = 228;
    public static final int kCGLCPSurfaceOrder = 235;
    public static final int kCGLCPSurfaceOpacity = 236;
    public static final int kCGLCPSurfaceBackingSize = 304;
    public static final int kCGLCPSurfaceSurfaceVolatile = 306;
    public static final int kCGLCPReclaimResources = 308;
    public static final int kCGLCPCurrentRendererID = 309;
    public static final int kCGLCPGPUVertexProcessing = 310;
    public static final int kCGLCPGPUFragmentProcessing = 311;
    public static final int kCGLCPHasDrawable = 314;
    public static final int kCGLCPMPSwapsInFlight = 315;
    public static final int kCGLGOFormatCacheSize = 501;
    public static final int kCGLGOClearFormatCache = 502;
    public static final int kCGLGORetainRenderers = 503;
    public static final int kCGLGOResetLibrary = 504;
    public static final int kCGLGOUseErrorHandler = 505;
    public static final int kCGLGOUseBuildCache = 506;
    public static final int kCGLOGLPVersion_Legacy = 4096;
    public static final int kCGLOGLPVersion_3_2_Core = 12800;
    public static final int kCGLNoError = 0;
    public static final int kCGLBadAttribute = 10000;
    public static final int kCGLBadProperty = 10001;
    public static final int kCGLBadPixelFormat = 10002;
    public static final int kCGLBadRendererInfo = 10003;
    public static final int kCGLBadContext = 10004;
    public static final int kCGLBadDrawable = 10005;
    public static final int kCGLBadDisplay = 10006;
    public static final int kCGLBadState = 10007;
    public static final int kCGLBadValue = 10008;
    public static final int kCGLBadMatch = 10009;
    public static final int kCGLBadEnumeration = 10010;
    public static final int kCGLBadOffScreen = 10011;
    public static final int kCGLBadFullScreen = 10012;
    public static final int kCGLBadWindow = 10013;
    public static final int kCGLBadAddress = 10014;
    public static final int kCGLBadCodeModule = 10015;
    public static final int kCGLBadAlloc = 10016;
    public static final int kCGLBadConnection = 10017;
    public static final int kCGLMonoscopicBit = 1;
    public static final int kCGLStereoscopicBit = 2;
    public static final int kCGLSingleBufferBit = 4;
    public static final int kCGLDoubleBufferBit = 8;
    public static final int kCGLTripleBufferBit = 16;
    public static final int kCGL0Bit = 1;
    public static final int kCGL1Bit = 2;
    public static final int kCGL2Bit = 4;
    public static final int kCGL3Bit = 8;
    public static final int kCGL4Bit = 16;
    public static final int kCGL5Bit = 32;
    public static final int kCGL6Bit = 64;
    public static final int kCGL8Bit = 128;
    public static final int kCGL10Bit = 256;
    public static final int kCGL12Bit = 512;
    public static final int kCGL16Bit = 1024;
    public static final int kCGL24Bit = 2048;
    public static final int kCGL32Bit = 4096;
    public static final int kCGL48Bit = 8192;
    public static final int kCGL64Bit = 16384;
    public static final int kCGL96Bit = 32768;
    public static final int kCGL128Bit = 65536;
    public static final int kCGLRGB444Bit = 64;
    public static final int kCGLARGB4444Bit = 128;
    public static final int kCGLRGB444A8Bit = 256;
    public static final int kCGLRGB555Bit = 512;
    public static final int kCGLARGB1555Bit = 1024;
    public static final int kCGLRGB555A8Bit = 2048;
    public static final int kCGLRGB565Bit = 4096;
    public static final int kCGLRGB565A8Bit = 8192;
    public static final int kCGLRGB888Bit = 16384;
    public static final int kCGLARGB8888Bit = 32768;
    public static final int kCGLRGB888A8Bit = 65536;
    public static final int kCGLRGB101010Bit = 131072;
    public static final int kCGLARGB2101010Bit = 262144;
    public static final int kCGLRGB101010_A8Bit = 524288;
    public static final int kCGLRGB121212Bit = 0x100000;
    public static final int kCGLARGB12121212Bit = 0x200000;
    public static final int kCGLRGB161616Bit = 0x400000;
    public static final int kCGLRGBA16161616Bit = 0x800000;
    public static final int kCGLRGBFloat64Bit = 0x1000000;
    public static final int kCGLRGBAFloat64Bit = 0x2000000;
    public static final int kCGLRGBFloat128Bit = 0x4000000;
    public static final int kCGLRGBAFloat128Bit = 0x8000000;
    public static final int kCGLRGBFloat256Bit = 0x10000000;
    public static final int kCGLRGBAFloat256Bit = 0x20000000;
    public static final int kCGLSupersampleBit = 1;
    public static final int kCGLMultisampleBit = 2;

    protected CGL() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="CGLContextObj")
    public static long CGLGetCurrentContext() {
        long l2 = Functions.GetCurrentContext;
        return JNI.callP(l2);
    }

    @NativeType(value="CGLError")
    public static int CGLSetCurrentContext(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.SetCurrentContext;
        return JNI.callPI(l2, l3);
    }

    @NativeType(value="CGLShareGroupObj")
    public static long CGLGetShareGroup(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.GetShareGroup;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPP(l2, l3);
    }

    public static int nCGLChoosePixelFormat(long l2, long l3, long l4) {
        long l5 = Functions.ChoosePixelFormat;
        return JNI.callPPPI(l2, l3, l4, l5);
    }

    @NativeType(value="CGLError")
    public static int CGLChoosePixelFormat(@NativeType(value="CGLPixelFormatAttribute const *") IntBuffer intBuffer, @NativeType(value="CGLPixelFormatObj *") PointerBuffer pointerBuffer, @NativeType(value="GLint *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkNT(intBuffer);
            Checks.check(pointerBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        return CGL.nCGLChoosePixelFormat(MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(pointerBuffer), MemoryUtil.memAddress(intBuffer2));
    }

    @NativeType(value="CGLError")
    public static int CGLDestroyPixelFormat(@NativeType(value="CGLPixelFormatObj") long l2) {
        long l3 = Functions.DestroyPixelFormat;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    public static int nCGLDescribePixelFormat(long l2, int n2, int n3, long l3) {
        long l4 = Functions.DescribePixelFormat;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, n3, l3, l4);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribePixelFormat(@NativeType(value="CGLPixelFormatObj") long l2, @NativeType(value="GLint") int n2, @NativeType(value="CGLPixelFormatAttribute") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return CGL.nCGLDescribePixelFormat(l2, n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static void CGLReleasePixelFormat(@NativeType(value="CGLPixelFormatObj") long l2) {
        long l3 = Functions.ReleasePixelFormat;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(l2, l3);
    }

    @NativeType(value="CGLPixelFormatObj")
    public static long CGLRetainPixelFormat(@NativeType(value="CGLPixelFormatObj") long l2) {
        long l3 = Functions.RetainPixelFormat;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPP(l2, l3);
    }

    @NativeType(value="GLuint")
    public static int CGLGetPixelFormatRetainCount(@NativeType(value="CGLPixelFormatObj") long l2) {
        long l3 = Functions.GetPixelFormatRetainCount;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    public static int nCGLQueryRendererInfo(int n2, long l2, long l3) {
        long l4 = Functions.QueryRendererInfo;
        return JNI.callPPI(n2, l2, l3, l4);
    }

    @NativeType(value="CGLError")
    public static int CGLQueryRendererInfo(@NativeType(value="GLuint") int n2, @NativeType(value="CGLRendererInfoObj *") PointerBuffer pointerBuffer, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
            Checks.check((Buffer)intBuffer, 1);
        }
        return CGL.nCGLQueryRendererInfo(n2, MemoryUtil.memAddress(pointerBuffer), MemoryUtil.memAddress(intBuffer));
    }

    @NativeType(value="CGLError")
    public static int CGLDestroyRendererInfo(@NativeType(value="CGLRendererInfoObj") long l2) {
        long l3 = Functions.DestroyRendererInfo;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    public static int nCGLDescribeRenderer(long l2, int n2, int n3, long l3) {
        long l4 = Functions.DescribeRenderer;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, n3, l3, l4);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribeRenderer(@NativeType(value="CGLRendererInfoObj") long l2, @NativeType(value="GLint") int n2, @NativeType(value="CGLRendererProperty") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return CGL.nCGLDescribeRenderer(l2, n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static int nCGLCreateContext(long l2, long l3, long l4) {
        long l5 = Functions.CreateContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPPI(l2, l3, l4, l5);
    }

    @NativeType(value="CGLError")
    public static int CGLCreateContext(@NativeType(value="CGLPixelFormatObj") long l2, @NativeType(value="CGLContextObj") long l3, @NativeType(value="CGLContextObj *") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return CGL.nCGLCreateContext(l2, l3, MemoryUtil.memAddress(pointerBuffer));
    }

    @NativeType(value="CGLError")
    public static int CGLDestroyContext(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.DestroyContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLCopyContext(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLContextObj") long l3, @NativeType(value="GLbitfield") int n2) {
        long l4 = Functions.CopyContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPI(l2, l3, n2, l4);
    }

    @NativeType(value="CGLContextObj")
    public static long CGLRetainContext(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.RetainContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPP(l2, l3);
    }

    public static void CGLReleaseContext(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.ReleaseContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(l2, l3);
    }

    @NativeType(value="GLuint")
    public static int CGLGetContextRetainCount(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.GetContextRetainCount;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    @NativeType(value="CGLPixelFormatObj")
    public static long CGLGetPixelFormat(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.GetPixelFormat;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPP(l2, l3);
    }

    public static int nCGLCreatePBuffer(int n2, int n3, int n4, int n5, int n6, long l2) {
        long l3 = Functions.CreatePBuffer;
        return JNI.callPI(n2, n3, n4, n5, n6, l2, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLCreatePBuffer(@NativeType(value="GLsizei") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLint") int n6, @NativeType(value="CGLPBufferObj *") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return CGL.nCGLCreatePBuffer(n2, n3, n4, n5, n6, MemoryUtil.memAddress(pointerBuffer));
    }

    @NativeType(value="CGLError")
    public static int CGLDestroyPBuffer(@NativeType(value="CGLPBufferObj") long l2) {
        long l3 = Functions.DestroyPBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    public static int nCGLDescribePBuffer(long l2, long l3, long l4, long l5, long l6, long l7) {
        long l8 = Functions.DescribePBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPPPPPI(l2, l3, l4, l5, l6, l7, l8);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribePBuffer(@NativeType(value="CGLPBufferObj") long l2, @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLsizei *") IntBuffer intBuffer2, @NativeType(value="GLenum *") IntBuffer intBuffer3, @NativeType(value="GLenum *") IntBuffer intBuffer4, @NativeType(value="GLint *") IntBuffer intBuffer5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
            Checks.check((Buffer)intBuffer3, 1);
            Checks.check((Buffer)intBuffer4, 1);
            Checks.check((Buffer)intBuffer5, 1);
        }
        return CGL.nCGLDescribePBuffer(l2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2), MemoryUtil.memAddress(intBuffer3), MemoryUtil.memAddress(intBuffer4), MemoryUtil.memAddress(intBuffer5));
    }

    @NativeType(value="CGLError")
    public static int CGLTexImagePBuffer(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLPBufferObj") long l3, @NativeType(value="GLenum") int n2) {
        long l4 = Functions.TexImagePBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPI(l2, l3, n2, l4);
    }

    @NativeType(value="CGLPBufferObj")
    public static long CGLRetainPBuffer(@NativeType(value="CGLPBufferObj") long l2) {
        long l3 = Functions.RetainPBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPP(l2, l3);
    }

    public static void CGLReleasePBuffer(@NativeType(value="CGLPBufferObj") long l2) {
        long l3 = Functions.ReleasePBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(l2, l3);
    }

    @NativeType(value="GLuint")
    public static int CGLGetPBufferRetainCount(@NativeType(value="CGLPBufferObj") long l2) {
        long l3 = Functions.GetPBufferRetainCount;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    public static int nCGLSetOffScreen(long l2, int n2, int n3, int n4, long l3) {
        long l4 = Functions.SetOffScreen;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, n3, n4, l3, l4);
    }

    @NativeType(value="CGLError")
    public static int CGLSetOffScreen(@NativeType(value="CGLContextObj") long l2, @NativeType(value="GLsizei") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLint") int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n4 * n3);
        }
        return CGL.nCGLSetOffScreen(l2, n2, n3, n4, MemoryUtil.memAddress(byteBuffer));
    }

    public static int nCGLGetOffScreen(long l2, long l3, long l4, long l5, long l6) {
        long l7 = Functions.GetOffScreen;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPPPPI(l2, l3, l4, l5, l6, l7);
    }

    @NativeType(value="CGLError")
    public static int CGLGetOffScreen(@NativeType(value="CGLContextObj") long l2, @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLsizei *") IntBuffer intBuffer2, @NativeType(value="GLint *") IntBuffer intBuffer3, @NativeType(value="void **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
            Checks.check((Buffer)intBuffer3, 1);
            Checks.check(pointerBuffer, 1);
        }
        return CGL.nCGLGetOffScreen(l2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2), MemoryUtil.memAddress(intBuffer3), MemoryUtil.memAddress(pointerBuffer));
    }

    @NativeType(value="CGLError")
    public static int CGLSetFullScreen(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.SetFullScreen;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLSetFullScreenOnDisplay(@NativeType(value="CGLContextObj") long l2, @NativeType(value="GLuint") int n2) {
        long l3 = Functions.SetFullScreenOnDisplay;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, n2, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLSetPBuffer(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLPBufferObj") long l3, @NativeType(value="GLenum") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4) {
        long l4 = Functions.SetPBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
        }
        return JNI.callPPI(l2, l3, n2, n3, n4, l4);
    }

    public static int nCGLGetPBuffer(long l2, long l3, long l4, long l5, long l6) {
        long l7 = Functions.GetPBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPPPPI(l2, l3, l4, l5, l6, l7);
    }

    @NativeType(value="CGLError")
    public static int CGLGetPBuffer(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLPBufferObj *") PointerBuffer pointerBuffer, @NativeType(value="GLenum *") IntBuffer intBuffer, @NativeType(value="GLint *") IntBuffer intBuffer2, @NativeType(value="GLint *") IntBuffer intBuffer3) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
            Checks.check((Buffer)intBuffer3, 1);
        }
        return CGL.nCGLGetPBuffer(l2, MemoryUtil.memAddress(pointerBuffer), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2), MemoryUtil.memAddress(intBuffer3));
    }

    @NativeType(value="CGLError")
    public static int CGLClearDrawable(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.ClearDrawable;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLFlushDrawable(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.FlushDrawable;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLEnable(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLContextEnable") int n2) {
        long l3 = Functions.Enable;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, n2, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLDisable(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLContextEnable") int n2) {
        long l3 = Functions.Disable;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, n2, l3);
    }

    public static int nCGLIsEnabled(long l2, int n2, long l3) {
        long l4 = Functions.IsEnabled;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, l3, l4);
    }

    @NativeType(value="CGLError")
    public static int CGLIsEnabled(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLContextEnable") int n2, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return CGL.nCGLIsEnabled(l2, n2, MemoryUtil.memAddress(intBuffer));
    }

    public static int nCGLSetParameter(long l2, int n2, long l3) {
        long l4 = Functions.SetParameter;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, l3, l4);
    }

    @NativeType(value="CGLError")
    public static int CGLSetParameter(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLContextParameter") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return CGL.nCGLSetParameter(l2, n2, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="CGLError")
    public static int CGLSetParameter(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLContextParameter") int n2, @NativeType(value="GLint const *") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n3);
            int n5 = CGL.nCGLSetParameter(l2, n2, MemoryUtil.memAddress(intBuffer));
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static int nCGLGetParameter(long l2, int n2, long l3) {
        long l4 = Functions.GetParameter;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPI(l2, n2, l3, l4);
    }

    @NativeType(value="CGLError")
    public static int CGLGetParameter(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLContextParameter") int n2, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return CGL.nCGLGetParameter(l2, n2, MemoryUtil.memAddress(intBuffer));
    }

    @NativeType(value="CGLError")
    public static int CGLSetVirtualScreen(@NativeType(value="CGLContextObj") long l2, @NativeType(value="GLint") int n2) {
        long l3 = Functions.SetVirtualScreen;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, n2, l3);
    }

    public static int nCGLGetVirtualScreen(long l2, long l3) {
        long l4 = Functions.GetVirtualScreen;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPPI(l2, l3, l4);
    }

    @NativeType(value="CGLError")
    public static int CGLGetVirtualScreen(@NativeType(value="CGLContextObj") long l2, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return CGL.nCGLGetVirtualScreen(l2, MemoryUtil.memAddress(intBuffer));
    }

    @NativeType(value="CGLError")
    public static int CGLUpdateContext(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.UpdateContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    public static int nCGLSetGlobalOption(int n2, long l2) {
        long l3 = Functions.SetGlobalOption;
        return JNI.callPI(n2, l2, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLSetGlobalOption(@NativeType(value="CGLGlobalOption") int n2, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return CGL.nCGLSetGlobalOption(n2, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="CGLError")
    public static int CGLSetGlobalOption(@NativeType(value="CGLGlobalOption") int n2, @NativeType(value="GLint const *") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n3);
            int n5 = CGL.nCGLSetGlobalOption(n2, MemoryUtil.memAddress(intBuffer));
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static int nCGLGetGlobalOption(int n2, long l2) {
        long l3 = Functions.GetGlobalOption;
        return JNI.callPI(n2, l2, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLGetGlobalOption(@NativeType(value="CGLGlobalOption") int n2, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        return CGL.nCGLGetGlobalOption(n2, MemoryUtil.memAddress(intBuffer));
    }

    @NativeType(value="CGLError")
    public static int CGLLockContext(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.LockContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLUnlockContext(@NativeType(value="CGLContextObj") long l2) {
        long l3 = Functions.UnlockContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPI(l2, l3);
    }

    public static void nCGLGetVersion(long l2, long l3) {
        long l4 = Functions.GetVersion;
        JNI.callPPV(l2, l3, l4);
    }

    public static void CGLGetVersion(@NativeType(value="GLint *") IntBuffer intBuffer, @NativeType(value="GLint *") IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
            Checks.check((Buffer)intBuffer2, 1);
        }
        CGL.nCGLGetVersion(MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2));
    }

    public static long nCGLErrorString(int n2) {
        long l2 = Functions.ErrorString;
        return JNI.callP(n2, l2);
    }

    @Nullable
    @NativeType(value="char const *")
    public static String CGLErrorString(@NativeType(value="CGLError") int n2) {
        long l2 = CGL.nCGLErrorString(n2);
        return MemoryUtil.memASCIISafe(l2);
    }

    @NativeType(value="CGLError")
    public static int CGLChoosePixelFormat(@NativeType(value="CGLPixelFormatAttribute const *") int[] nArray, @NativeType(value="CGLPixelFormatObj *") PointerBuffer pointerBuffer, @NativeType(value="GLint *") int[] nArray2) {
        long l2 = Functions.ChoosePixelFormat;
        if (Checks.CHECKS) {
            Checks.checkNT(nArray);
            Checks.check(pointerBuffer, 1);
            Checks.check(nArray2, 1);
        }
        return JNI.callPPPI(nArray, MemoryUtil.memAddress(pointerBuffer), nArray2, l2);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribePixelFormat(@NativeType(value="CGLPixelFormatObj") long l2, @NativeType(value="GLint") int n2, @NativeType(value="CGLPixelFormatAttribute") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l3 = Functions.DescribePixelFormat;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(l2, n2, n3, nArray, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLQueryRendererInfo(@NativeType(value="GLuint") int n2, @NativeType(value="CGLRendererInfoObj *") PointerBuffer pointerBuffer, @NativeType(value="GLint *") int[] nArray) {
        long l2 = Functions.QueryRendererInfo;
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(n2, MemoryUtil.memAddress(pointerBuffer), nArray, l2);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribeRenderer(@NativeType(value="CGLRendererInfoObj") long l2, @NativeType(value="GLint") int n2, @NativeType(value="CGLRendererProperty") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l3 = Functions.DescribeRenderer;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(l2, n2, n3, nArray, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLDescribePBuffer(@NativeType(value="CGLPBufferObj") long l2, @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLsizei *") int[] nArray2, @NativeType(value="GLenum *") int[] nArray3, @NativeType(value="GLenum *") int[] nArray4, @NativeType(value="GLint *") int[] nArray5) {
        long l3 = Functions.DescribePBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
            Checks.check(nArray3, 1);
            Checks.check(nArray4, 1);
            Checks.check(nArray5, 1);
        }
        return JNI.callPPPPPPI(l2, nArray, nArray2, nArray3, nArray4, nArray5, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLGetOffScreen(@NativeType(value="CGLContextObj") long l2, @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLsizei *") int[] nArray2, @NativeType(value="GLint *") int[] nArray3, @NativeType(value="void **") PointerBuffer pointerBuffer) {
        long l3 = Functions.GetOffScreen;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
            Checks.check(nArray3, 1);
            Checks.check(pointerBuffer, 1);
        }
        return JNI.callPPPPPI(l2, nArray, nArray2, nArray3, MemoryUtil.memAddress(pointerBuffer), l3);
    }

    @NativeType(value="CGLError")
    public static int CGLGetPBuffer(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLPBufferObj *") PointerBuffer pointerBuffer, @NativeType(value="GLenum *") int[] nArray, @NativeType(value="GLint *") int[] nArray2, @NativeType(value="GLint *") int[] nArray3) {
        long l3 = Functions.GetPBuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(pointerBuffer, 1);
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
            Checks.check(nArray3, 1);
        }
        return JNI.callPPPPPI(l2, MemoryUtil.memAddress(pointerBuffer), nArray, nArray2, nArray3, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLIsEnabled(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLContextEnable") int n2, @NativeType(value="GLint *") int[] nArray) {
        long l3 = Functions.IsEnabled;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(l2, n2, nArray, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLSetParameter(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLContextParameter") int n2, @NativeType(value="GLint const *") int[] nArray) {
        long l3 = Functions.SetParameter;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(l2, n2, nArray, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLGetParameter(@NativeType(value="CGLContextObj") long l2, @NativeType(value="CGLContextParameter") int n2, @NativeType(value="GLint *") int[] nArray) {
        long l3 = Functions.GetParameter;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(l2, n2, nArray, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLGetVirtualScreen(@NativeType(value="CGLContextObj") long l2, @NativeType(value="GLint *") int[] nArray) {
        long l3 = Functions.GetVirtualScreen;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        return JNI.callPPI(l2, nArray, l3);
    }

    @NativeType(value="CGLError")
    public static int CGLSetGlobalOption(@NativeType(value="CGLGlobalOption") int n2, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = Functions.SetGlobalOption;
        if (Checks.CHECKS) {
            Checks.check(nArray, 1);
        }
        return JNI.callPI(n2, nArray, l2);
    }

    @NativeType(value="CGLError")
    public static int CGLGetGlobalOption(@NativeType(value="CGLGlobalOption") int n2, @NativeType(value="GLint *") int[] nArray) {
        long l2 = Functions.GetGlobalOption;
        if (Checks.CHECKS) {
            Checks.check(nArray, 1);
        }
        return JNI.callPI(n2, nArray, l2);
    }

    public static void CGLGetVersion(@NativeType(value="GLint *") int[] nArray, @NativeType(value="GLint *") int[] nArray2) {
        long l2 = Functions.GetVersion;
        if (Checks.CHECKS) {
            Checks.check(nArray, 1);
            Checks.check(nArray2, 1);
        }
        JNI.callPPV(nArray, nArray2, l2);
    }

    public static final class Functions {
        public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetCurrentContext");
        public static final long SetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetCurrentContext");
        public static final long GetShareGroup = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetShareGroup");
        public static final long ChoosePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLChoosePixelFormat");
        public static final long DestroyPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyPixelFormat");
        public static final long DescribePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribePixelFormat");
        public static final long ReleasePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleasePixelFormat");
        public static final long RetainPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainPixelFormat");
        public static final long GetPixelFormatRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPixelFormatRetainCount");
        public static final long QueryRendererInfo = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLQueryRendererInfo");
        public static final long DestroyRendererInfo = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyRendererInfo");
        public static final long DescribeRenderer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribeRenderer");
        public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCreateContext");
        public static final long DestroyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyContext");
        public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCopyContext");
        public static final long RetainContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainContext");
        public static final long ReleaseContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleaseContext");
        public static final long GetContextRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetContextRetainCount");
        public static final long GetPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPixelFormat");
        public static final long CreatePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCreatePBuffer");
        public static final long DestroyPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyPBuffer");
        public static final long DescribePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribePBuffer");
        public static final long TexImagePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLTexImagePBuffer");
        public static final long RetainPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainPBuffer");
        public static final long ReleasePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleasePBuffer");
        public static final long GetPBufferRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPBufferRetainCount");
        public static final long SetOffScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetOffScreen");
        public static final long GetOffScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetOffScreen");
        public static final long SetFullScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetFullScreen");
        public static final long SetFullScreenOnDisplay = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetFullScreenOnDisplay");
        public static final long SetPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetPBuffer");
        public static final long GetPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPBuffer");
        public static final long ClearDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLClearDrawable");
        public static final long FlushDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLFlushDrawable");
        public static final long Enable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLEnable");
        public static final long Disable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDisable");
        public static final long IsEnabled = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLIsEnabled");
        public static final long SetParameter = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetParameter");
        public static final long GetParameter = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetParameter");
        public static final long SetVirtualScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetVirtualScreen");
        public static final long GetVirtualScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetVirtualScreen");
        public static final long UpdateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLUpdateContext");
        public static final long SetGlobalOption = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetGlobalOption");
        public static final long GetGlobalOption = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetGlobalOption");
        public static final long LockContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLLockContext");
        public static final long UnlockContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLUnlockContext");
        public static final long GetVersion = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetVersion");
        public static final long ErrorString = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLErrorString");

        private Functions() {
        }
    }
}

