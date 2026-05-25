/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.stb;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.stb.LibSTB;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class STBImageResize {
    public static final int STBIR_ALPHA_CHANNEL_NONE = -1;
    public static final int STBIR_FLAG_ALPHA_PREMULTIPLIED = -1;
    public static final int STBIR_FLAG_ALPHA_USES_COLORSPACE = -1;
    public static final int STBIR_EDGE_CLAMP = 1;
    public static final int STBIR_EDGE_REFLECT = 2;
    public static final int STBIR_EDGE_WRAP = 3;
    public static final int STBIR_EDGE_ZERO = 4;
    public static final int STBIR_FILTER_DEFAULT = 0;
    public static final int STBIR_FILTER_BOX = 1;
    public static final int STBIR_FILTER_TRIANGLE = 2;
    public static final int STBIR_FILTER_CUBICBSPLINE = 3;
    public static final int STBIR_FILTER_CATMULLROM = 4;
    public static final int STBIR_FILTER_MITCHELL = 5;
    public static final int STBIR_COLORSPACE_LINEAR = 0;
    public static final int STBIR_COLORSPACE_SRGB = 1;
    public static final int STBIR_TYPE_UINT8 = 0;
    public static final int STBIR_TYPE_UINT16 = 1;
    public static final int STBIR_TYPE_UINT32 = 2;
    public static final int STBIR_TYPE_FLOAT = 3;

    protected STBImageResize() {
        throw new UnsupportedOperationException();
    }

    public static native int nstbir_resize_uint8(long var0, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10);

    @NativeType(value="int")
    public static boolean stbir_resize_uint8(@NativeType(value="unsigned char const *") ByteBuffer byteBuffer, int n2, int n3, int n4, @NativeType(value="unsigned char *") ByteBuffer byteBuffer2, int n5, int n6, int n7, int n8) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? n2 * n8 : n4));
            Checks.check((Buffer)byteBuffer2, n6 * (n7 == 0 ? n5 * n8 : n7));
        }
        return STBImageResize.nstbir_resize_uint8(MemoryUtil.memAddress(byteBuffer), n2, n3, n4, MemoryUtil.memAddress(byteBuffer2), n5, n6, n7, n8) != 0;
    }

    public static native int nstbir_resize_float(long var0, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10);

    @NativeType(value="int")
    public static boolean stbir_resize_float(@NativeType(value="float const *") FloatBuffer floatBuffer, int n2, int n3, int n4, @NativeType(value="float *") FloatBuffer floatBuffer2, int n5, int n6, int n7, int n8) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, n3 * (n4 == 0 ? n2 * n8 : n4 >> 2));
            Checks.check((Buffer)floatBuffer2, n6 * (n7 == 0 ? n5 * n8 : n7 >> 2));
        }
        return STBImageResize.nstbir_resize_float(MemoryUtil.memAddress(floatBuffer), n2, n3, n4, MemoryUtil.memAddress(floatBuffer2), n5, n6, n7, n8) != 0;
    }

    public static native int nstbir_resize_uint8_srgb(long var0, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12);

    @NativeType(value="int")
    public static boolean stbir_resize_uint8_srgb(@NativeType(value="unsigned char const *") ByteBuffer byteBuffer, int n2, int n3, int n4, @NativeType(value="unsigned char *") ByteBuffer byteBuffer2, int n5, int n6, int n7, int n8, int n9, int n10) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? n2 * n8 : n4));
            Checks.check((Buffer)byteBuffer2, n6 * (n7 == 0 ? n5 * n8 : n7));
        }
        return STBImageResize.nstbir_resize_uint8_srgb(MemoryUtil.memAddress(byteBuffer), n2, n3, n4, MemoryUtil.memAddress(byteBuffer2), n5, n6, n7, n8, n9, n10) != 0;
    }

    public static native int nstbir_resize_uint8_srgb_edgemode(long var0, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12, int var13);

    @NativeType(value="int")
    public static boolean stbir_resize_uint8_srgb_edgemode(@NativeType(value="unsigned char const *") ByteBuffer byteBuffer, int n2, int n3, int n4, @NativeType(value="unsigned char *") ByteBuffer byteBuffer2, int n5, int n6, int n7, int n8, int n9, int n10, @NativeType(value="stbir_edge") int n11) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? n2 * n8 : n4));
            Checks.check((Buffer)byteBuffer2, n6 * (n7 == 0 ? n5 * n8 : n7));
        }
        return STBImageResize.nstbir_resize_uint8_srgb_edgemode(MemoryUtil.memAddress(byteBuffer), n2, n3, n4, MemoryUtil.memAddress(byteBuffer2), n5, n6, n7, n8, n9, n10, n11) != 0;
    }

    public static native int nstbir_resize_uint8_generic(long var0, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, long var16);

    @NativeType(value="int")
    public static boolean stbir_resize_uint8_generic(@NativeType(value="unsigned char const *") ByteBuffer byteBuffer, int n2, int n3, int n4, @NativeType(value="unsigned char *") ByteBuffer byteBuffer2, int n5, int n6, int n7, int n8, int n9, int n10, @NativeType(value="stbir_edge") int n11, @NativeType(value="stbir_filter") int n12, @NativeType(value="stbir_colorspace") int n13) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? n2 * n8 : n4));
            Checks.check((Buffer)byteBuffer2, n6 * (n7 == 0 ? n5 * n8 : n7));
        }
        return STBImageResize.nstbir_resize_uint8_generic(MemoryUtil.memAddress(byteBuffer), n2, n3, n4, MemoryUtil.memAddress(byteBuffer2), n5, n6, n7, n8, n9, n10, n11, n12, n13, 0L) != 0;
    }

    public static native int nstbir_resize_uint16_generic(long var0, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, long var16);

    @NativeType(value="int")
    public static boolean stbir_resize_uint16_generic(@NativeType(value="stbir_uint16 const *") ShortBuffer shortBuffer, int n2, int n3, int n4, @NativeType(value="stbir_uint16 *") ShortBuffer shortBuffer2, int n5, int n6, int n7, int n8, int n9, int n10, @NativeType(value="stbir_edge") int n11, @NativeType(value="stbir_filter") int n12, @NativeType(value="stbir_colorspace") int n13) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)shortBuffer, n3 * (n4 == 0 ? n2 * n8 : n4 >> 1));
            Checks.check((Buffer)shortBuffer2, n6 * (n7 == 0 ? n5 * n8 : n7 >> 1));
        }
        return STBImageResize.nstbir_resize_uint16_generic(MemoryUtil.memAddress(shortBuffer), n2, n3, n4, MemoryUtil.memAddress(shortBuffer2), n5, n6, n7, n8, n9, n10, n11, n12, n13, 0L) != 0;
    }

    public static native int nstbir_resize_float_generic(long var0, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, long var16);

    @NativeType(value="int")
    public static boolean stbir_resize_float_generic(@NativeType(value="float const *") FloatBuffer floatBuffer, int n2, int n3, int n4, @NativeType(value="float *") FloatBuffer floatBuffer2, int n5, int n6, int n7, int n8, int n9, int n10, @NativeType(value="stbir_edge") int n11, @NativeType(value="stbir_filter") int n12, @NativeType(value="stbir_colorspace") int n13) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, n3 * (n4 == 0 ? n2 * n8 : n4 >> 2));
            Checks.check((Buffer)floatBuffer2, n6 * (n7 == 0 ? n5 * n8 : n7 >> 2));
        }
        return STBImageResize.nstbir_resize_float_generic(MemoryUtil.memAddress(floatBuffer), n2, n3, n4, MemoryUtil.memAddress(floatBuffer2), n5, n6, n7, n8, n9, n10, n11, n12, n13, 0L) != 0;
    }

    public static native int nstbir_resize(long var0, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, long var19);

    @NativeType(value="int")
    public static boolean stbir_resize(@NativeType(value="void const *") ByteBuffer byteBuffer, int n2, int n3, int n4, @NativeType(value="void *") ByteBuffer byteBuffer2, int n5, int n6, int n7, @NativeType(value="stbir_datatype") int n8, int n9, int n10, int n11, @NativeType(value="stbir_edge") int n12, @NativeType(value="stbir_edge") int n13, @NativeType(value="stbir_filter") int n14, @NativeType(value="stbir_filter") int n15, @NativeType(value="stbir_colorspace") int n16) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? n2 * n9 << STBImageResize.getTypeShift(n8) : n4));
            Checks.check((Buffer)byteBuffer2, n6 * (n7 == 0 ? n5 * n9 << STBImageResize.getTypeShift(n8) : n7));
        }
        return STBImageResize.nstbir_resize(MemoryUtil.memAddress(byteBuffer), n2, n3, n4, MemoryUtil.memAddress(byteBuffer2), n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, 0L) != 0;
    }

    public static native int nstbir_resize_subpixel(long var0, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, long var19, float var21, float var22, float var23, float var24);

    @NativeType(value="int")
    public static boolean stbir_resize_subpixel(@NativeType(value="void const *") ByteBuffer byteBuffer, int n2, int n3, int n4, @NativeType(value="void *") ByteBuffer byteBuffer2, int n5, int n6, int n7, @NativeType(value="stbir_datatype") int n8, int n9, int n10, int n11, @NativeType(value="stbir_edge") int n12, @NativeType(value="stbir_edge") int n13, @NativeType(value="stbir_filter") int n14, @NativeType(value="stbir_filter") int n15, @NativeType(value="stbir_colorspace") int n16, float f2, float f3, float f4, float f5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? n2 * n9 << STBImageResize.getTypeShift(n8) : n4));
            Checks.check((Buffer)byteBuffer2, n6 * (n7 == 0 ? n5 * n9 << STBImageResize.getTypeShift(n8) : n7));
        }
        return STBImageResize.nstbir_resize_subpixel(MemoryUtil.memAddress(byteBuffer), n2, n3, n4, MemoryUtil.memAddress(byteBuffer2), n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, 0L, f2, f3, f4, f5) != 0;
    }

    public static native int nstbir_resize_region(long var0, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, long var19, float var21, float var22, float var23, float var24);

    @NativeType(value="int")
    public static boolean stbir_resize_region(@NativeType(value="void const *") ByteBuffer byteBuffer, int n2, int n3, int n4, @NativeType(value="void *") ByteBuffer byteBuffer2, int n5, int n6, int n7, @NativeType(value="stbir_datatype") int n8, int n9, int n10, int n11, @NativeType(value="stbir_edge") int n12, @NativeType(value="stbir_edge") int n13, @NativeType(value="stbir_filter") int n14, @NativeType(value="stbir_filter") int n15, @NativeType(value="stbir_colorspace") int n16, float f2, float f3, float f4, float f5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? n2 * n9 << STBImageResize.getTypeShift(n8) : n4));
            Checks.check((Buffer)byteBuffer2, n6 * (n7 == 0 ? n5 * n9 << STBImageResize.getTypeShift(n8) : n7));
        }
        return STBImageResize.nstbir_resize_region(MemoryUtil.memAddress(byteBuffer), n2, n3, n4, MemoryUtil.memAddress(byteBuffer2), n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, 0L, f2, f3, f4, f5) != 0;
    }

    public static native int nstbir_resize_float(float[] var0, int var1, int var2, int var3, float[] var4, int var5, int var6, int var7, int var8);

    @NativeType(value="int")
    public static boolean stbir_resize_float(@NativeType(value="float const *") float[] fArray, int n2, int n3, int n4, @NativeType(value="float *") float[] fArray2, int n5, int n6, int n7, int n8) {
        if (Checks.CHECKS) {
            Checks.check(fArray, n3 * (n4 == 0 ? n2 * n8 : n4 >> 2));
            Checks.check(fArray2, n6 * (n7 == 0 ? n5 * n8 : n7 >> 2));
        }
        return STBImageResize.nstbir_resize_float(fArray, n2, n3, n4, fArray2, n5, n6, n7, n8) != 0;
    }

    public static native int nstbir_resize_uint16_generic(short[] var0, int var1, int var2, int var3, short[] var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, long var14);

    @NativeType(value="int")
    public static boolean stbir_resize_uint16_generic(@NativeType(value="stbir_uint16 const *") short[] sArray, int n2, int n3, int n4, @NativeType(value="stbir_uint16 *") short[] sArray2, int n5, int n6, int n7, int n8, int n9, int n10, @NativeType(value="stbir_edge") int n11, @NativeType(value="stbir_filter") int n12, @NativeType(value="stbir_colorspace") int n13) {
        if (Checks.CHECKS) {
            Checks.check(sArray, n3 * (n4 == 0 ? n2 * n8 : n4 >> 1));
            Checks.check(sArray2, n6 * (n7 == 0 ? n5 * n8 : n7 >> 1));
        }
        return STBImageResize.nstbir_resize_uint16_generic(sArray, n2, n3, n4, sArray2, n5, n6, n7, n8, n9, n10, n11, n12, n13, 0L) != 0;
    }

    public static native int nstbir_resize_float_generic(float[] var0, int var1, int var2, int var3, float[] var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, long var14);

    @NativeType(value="int")
    public static boolean stbir_resize_float_generic(@NativeType(value="float const *") float[] fArray, int n2, int n3, int n4, @NativeType(value="float *") float[] fArray2, int n5, int n6, int n7, int n8, int n9, int n10, @NativeType(value="stbir_edge") int n11, @NativeType(value="stbir_filter") int n12, @NativeType(value="stbir_colorspace") int n13) {
        if (Checks.CHECKS) {
            Checks.check(fArray, n3 * (n4 == 0 ? n2 * n8 : n4 >> 2));
            Checks.check(fArray2, n6 * (n7 == 0 ? n5 * n8 : n7 >> 2));
        }
        return STBImageResize.nstbir_resize_float_generic(fArray, n2, n3, n4, fArray2, n5, n6, n7, n8, n9, n10, n11, n12, n13, 0L) != 0;
    }

    private static int getTypeShift(int n2) {
        switch (n2) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
        }
        return 2;
    }

    static {
        LibSTB.initialize();
    }
}

