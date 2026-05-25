/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class NVPathRendering {
    public static final byte GL_CLOSE_PATH_NV = 0;
    public static final byte GL_MOVE_TO_NV = 2;
    public static final byte GL_RELATIVE_MOVE_TO_NV = 3;
    public static final byte GL_LINE_TO_NV = 4;
    public static final byte GL_RELATIVE_LINE_TO_NV = 5;
    public static final byte GL_HORIZONTAL_LINE_TO_NV = 6;
    public static final byte GL_RELATIVE_HORIZONTAL_LINE_TO_NV = 7;
    public static final byte GL_VERTICAL_LINE_TO_NV = 8;
    public static final byte GL_RELATIVE_VERTICAL_LINE_TO_NV = 9;
    public static final byte GL_QUADRATIC_CURVE_TO_NV = 10;
    public static final byte GL_RELATIVE_QUADRATIC_CURVE_TO_NV = 11;
    public static final byte GL_CUBIC_CURVE_TO_NV = 12;
    public static final byte GL_RELATIVE_CUBIC_CURVE_TO_NV = 13;
    public static final byte GL_SMOOTH_QUADRATIC_CURVE_TO_NV = 14;
    public static final byte GL_RELATIVE_SMOOTH_QUADRATIC_CURVE_TO_NV = 15;
    public static final byte GL_SMOOTH_CUBIC_CURVE_TO_NV = 16;
    public static final byte GL_RELATIVE_SMOOTH_CUBIC_CURVE_TO_NV = 17;
    public static final byte GL_SMALL_CCW_ARC_TO_NV = 18;
    public static final byte GL_RELATIVE_SMALL_CCW_ARC_TO_NV = 19;
    public static final byte GL_SMALL_CW_ARC_TO_NV = 20;
    public static final byte GL_RELATIVE_SMALL_CW_ARC_TO_NV = 21;
    public static final byte GL_LARGE_CCW_ARC_TO_NV = 22;
    public static final byte GL_RELATIVE_LARGE_CCW_ARC_TO_NV = 23;
    public static final byte GL_LARGE_CW_ARC_TO_NV = 24;
    public static final byte GL_RELATIVE_LARGE_CW_ARC_TO_NV = 25;
    public static final byte GL_CONIC_CURVE_TO_NV = 26;
    public static final byte GL_RELATIVE_CONIC_CURVE_TO_NV = 27;
    public static final byte GL_ROUNDED_RECT_NV = -24;
    public static final byte GL_RELATIVE_ROUNDED_RECT_NV = -23;
    public static final byte GL_ROUNDED_RECT2_NV = -22;
    public static final byte GL_RELATIVE_ROUNDED_RECT2_NV = -21;
    public static final byte GL_ROUNDED_RECT4_NV = -20;
    public static final byte GL_RELATIVE_ROUNDED_RECT4_NV = -19;
    public static final byte GL_ROUNDED_RECT8_NV = -18;
    public static final byte GL_RELATIVE_ROUNDED_RECT8_NV = -17;
    public static final byte GL_RESTART_PATH_NV = -16;
    public static final byte GL_DUP_FIRST_CUBIC_CURVE_TO_NV = -14;
    public static final byte GL_DUP_LAST_CUBIC_CURVE_TO_NV = -12;
    public static final byte GL_RECT_NV = -10;
    public static final byte GL_RELATIVE_RECT_NV = -9;
    public static final byte GL_CIRCULAR_CCW_ARC_TO_NV = -8;
    public static final byte GL_CIRCULAR_CW_ARC_TO_NV = -6;
    public static final byte GL_CIRCULAR_TANGENT_ARC_TO_NV = -4;
    public static final byte GL_ARC_TO_NV = -2;
    public static final byte GL_RELATIVE_ARC_TO_NV = -1;
    public static final int GL_PATH_FORMAT_SVG_NV = 36976;
    public static final int GL_PATH_FORMAT_PS_NV = 36977;
    public static final int GL_STANDARD_FONT_NAME_NV = 36978;
    public static final int GL_SYSTEM_FONT_NAME_NV = 36979;
    public static final int GL_FILE_NAME_NV = 36980;
    public static final int GL_STANDARD_FONT_FORMAT_NV = 37740;
    public static final int GL_SKIP_MISSING_GLYPH_NV = 37033;
    public static final int GL_USE_MISSING_GLYPH_NV = 37034;
    public static final int GL_FONT_GLYPHS_AVAILABLE_NV = 37736;
    public static final int GL_FONT_TARGET_UNAVAILABLE_NV = 37737;
    public static final int GL_FONT_UNAVAILABLE_NV = 37738;
    public static final int GL_FONT_UNINTELLIGIBLE_NV = 37739;
    public static final int GL_PATH_STROKE_WIDTH_NV = 36981;
    public static final int GL_PATH_INITIAL_END_CAP_NV = 36983;
    public static final int GL_PATH_TERMINAL_END_CAP_NV = 36984;
    public static final int GL_PATH_JOIN_STYLE_NV = 36985;
    public static final int GL_PATH_MITER_LIMIT_NV = 36986;
    public static final int GL_PATH_INITIAL_DASH_CAP_NV = 36988;
    public static final int GL_PATH_TERMINAL_DASH_CAP_NV = 36989;
    public static final int GL_PATH_DASH_OFFSET_NV = 36990;
    public static final int GL_PATH_CLIENT_LENGTH_NV = 36991;
    public static final int GL_PATH_DASH_OFFSET_RESET_NV = 37044;
    public static final int GL_PATH_FILL_MODE_NV = 36992;
    public static final int GL_PATH_FILL_MASK_NV = 36993;
    public static final int GL_PATH_FILL_COVER_MODE_NV = 36994;
    public static final int GL_PATH_STROKE_COVER_MODE_NV = 36995;
    public static final int GL_PATH_STROKE_MASK_NV = 36996;
    public static final int GL_PATH_STROKE_BOUND_NV = 36998;
    public static final int GL_PATH_END_CAPS_NV = 36982;
    public static final int GL_PATH_DASH_CAPS_NV = 36987;
    public static final int GL_COUNT_UP_NV = 37000;
    public static final int GL_COUNT_DOWN_NV = 37001;
    public static final int GL_PRIMARY_COLOR_NV = 34092;
    public static final int GL_SECONDARY_COLOR_NV = 34093;
    public static final int GL_PATH_OBJECT_BOUNDING_BOX_NV = 37002;
    public static final int GL_CONVEX_HULL_NV = 37003;
    public static final int GL_BOUNDING_BOX_NV = 37005;
    public static final int GL_TRANSLATE_X_NV = 37006;
    public static final int GL_TRANSLATE_Y_NV = 37007;
    public static final int GL_TRANSLATE_2D_NV = 37008;
    public static final int GL_TRANSLATE_3D_NV = 37009;
    public static final int GL_AFFINE_2D_NV = 37010;
    public static final int GL_AFFINE_3D_NV = 37012;
    public static final int GL_TRANSPOSE_AFFINE_2D_NV = 37014;
    public static final int GL_TRANSPOSE_AFFINE_3D_NV = 37016;
    public static final int GL_UTF8_NV = 37018;
    public static final int GL_UTF16_NV = 37019;
    public static final int GL_BOUNDING_BOX_OF_BOUNDING_BOXES_NV = 37020;
    public static final int GL_PATH_COMMAND_COUNT_NV = 37021;
    public static final int GL_PATH_COORD_COUNT_NV = 37022;
    public static final int GL_PATH_DASH_ARRAY_COUNT_NV = 37023;
    public static final int GL_PATH_COMPUTED_LENGTH_NV = 37024;
    public static final int GL_PATH_FILL_BOUNDING_BOX_NV = 37025;
    public static final int GL_PATH_STROKE_BOUNDING_BOX_NV = 37026;
    public static final int GL_SQUARE_NV = 37027;
    public static final int GL_ROUND_NV = 37028;
    public static final int GL_TRIANGULAR_NV = 37029;
    public static final int GL_BEVEL_NV = 37030;
    public static final int GL_MITER_REVERT_NV = 37031;
    public static final int GL_MITER_TRUNCATE_NV = 37032;
    public static final int GL_MOVE_TO_RESETS_NV = 37045;
    public static final int GL_MOVE_TO_CONTINUES_NV = 37046;
    public static final int GL_BOLD_BIT_NV = 1;
    public static final int GL_ITALIC_BIT_NV = 2;
    public static final int GL_PATH_ERROR_POSITION_NV = 37035;
    public static final int GL_PATH_FOG_GEN_MODE_NV = 37036;
    public static final int GL_PATH_STENCIL_FUNC_NV = 37047;
    public static final int GL_PATH_STENCIL_REF_NV = 37048;
    public static final int GL_PATH_STENCIL_VALUE_MASK_NV = 37049;
    public static final int GL_PATH_STENCIL_DEPTH_OFFSET_FACTOR_NV = 37053;
    public static final int GL_PATH_STENCIL_DEPTH_OFFSET_UNITS_NV = 37054;
    public static final int GL_PATH_COVER_DEPTH_FUNC_NV = 37055;
    public static final int GL_GLYPH_WIDTH_BIT_NV = 1;
    public static final int GL_GLYPH_HEIGHT_BIT_NV = 2;
    public static final int GL_GLYPH_HORIZONTAL_BEARING_X_BIT_NV = 4;
    public static final int GL_GLYPH_HORIZONTAL_BEARING_Y_BIT_NV = 8;
    public static final int GL_GLYPH_HORIZONTAL_BEARING_ADVANCE_BIT_NV = 16;
    public static final int GL_GLYPH_VERTICAL_BEARING_X_BIT_NV = 32;
    public static final int GL_GLYPH_VERTICAL_BEARING_Y_BIT_NV = 64;
    public static final int GL_GLYPH_VERTICAL_BEARING_ADVANCE_BIT_NV = 128;
    public static final int GL_GLYPH_HAS_KERNING_BIT_NV = 256;
    public static final int GL_FONT_X_MIN_BOUNDS_BIT_NV = 65536;
    public static final int GL_FONT_Y_MIN_BOUNDS_BIT_NV = 131072;
    public static final int GL_FONT_X_MAX_BOUNDS_BIT_NV = 262144;
    public static final int GL_FONT_Y_MAX_BOUNDS_BIT_NV = 524288;
    public static final int GL_FONT_UNITS_PER_EM_BIT_NV = 0x100000;
    public static final int GL_FONT_ASCENDER_BIT_NV = 0x200000;
    public static final int GL_FONT_DESCENDER_BIT_NV = 0x400000;
    public static final int GL_FONT_HEIGHT_BIT_NV = 0x800000;
    public static final int GL_FONT_MAX_ADVANCE_WIDTH_BIT_NV = 0x1000000;
    public static final int GL_FONT_MAX_ADVANCE_HEIGHT_BIT_NV = 0x2000000;
    public static final int GL_FONT_UNDERLINE_POSITION_BIT_NV = 0x4000000;
    public static final int GL_FONT_UNDERLINE_THICKNESS_BIT_NV = 0x8000000;
    public static final int GL_FONT_HAS_KERNING_BIT_NV = 0x10000000;
    public static final int GL_FONT_NUM_GLYPH_INDICES_BIT_NV = 0x20000000;
    public static final int GL_ACCUM_ADJACENT_PAIRS_NV = 37037;
    public static final int GL_ADJACENT_PAIRS_NV = 37038;
    public static final int GL_FIRST_TO_REST_NV = 37039;
    public static final int GL_PATH_GEN_MODE_NV = 37040;
    public static final int GL_PATH_GEN_COEFF_NV = 37041;
    public static final int GL_PATH_GEN_COLOR_FORMAT_NV = 37042;
    public static final int GL_PATH_GEN_COMPONENTS_NV = 37043;
    public static final int GL_FRAGMENT_INPUT_NV = 37741;
    public static final int GL_PATH_PROJECTION_NV = 5889;
    public static final int GL_PATH_MODELVIEW_NV = 5888;
    public static final int GL_PATH_MODELVIEW_STACK_DEPTH_NV = 2979;
    public static final int GL_PATH_MODELVIEW_MATRIX_NV = 2982;
    public static final int GL_PATH_MAX_MODELVIEW_STACK_DEPTH_NV = 3382;
    public static final int GL_PATH_TRANSPOSE_MODELVIEW_MATRIX_NV = 34019;
    public static final int GL_PATH_PROJECTION_STACK_DEPTH_NV = 2980;
    public static final int GL_PATH_PROJECTION_MATRIX_NV = 2983;
    public static final int GL_PATH_MAX_PROJECTION_STACK_DEPTH_NV = 3384;
    public static final int GL_PATH_TRANSPOSE_PROJECTION_MATRIX_NV = 34020;
    public static final int GL_2_BYTES_NV = 5127;
    public static final int GL_3_BYTES_NV = 5128;
    public static final int GL_4_BYTES_NV = 5129;
    public static final int GL_EYE_LINEAR_NV = 9216;
    public static final int GL_OBJECT_LINEAR_NV = 9217;
    public static final int GL_CONSTANT_NV = 34166;

    protected NVPathRendering() {
        throw new UnsupportedOperationException();
    }

    public static native void nglPathCommandsNV(int var0, int var1, long var2, int var4, int var5, long var6);

    public static void glPathCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer2) {
        NVPathRendering.nglPathCommandsNV(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), byteBuffer2.remaining() >> GLChecks.typeToByteShift(n3), n3, MemoryUtil.memAddress(byteBuffer2));
    }

    public static void glPathCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        NVPathRendering.nglPathCommandsNV(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), (int)((long)shortBuffer.remaining() << 1 >> GLChecks.typeToByteShift(n3)), n3, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glPathCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        NVPathRendering.nglPathCommandsNV(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), (int)((long)floatBuffer.remaining() << 2 >> GLChecks.typeToByteShift(n3)), n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglPathCoordsNV(int var0, int var1, int var2, long var3);

    public static void glPathCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        NVPathRendering.nglPathCoordsNV(n2, byteBuffer.remaining() >> GLChecks.typeToByteShift(n3), n3, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glPathCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        NVPathRendering.nglPathCoordsNV(n2, (int)((long)shortBuffer.remaining() << 1 >> GLChecks.typeToByteShift(n3)), n3, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glPathCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        NVPathRendering.nglPathCoordsNV(n2, (int)((long)floatBuffer.remaining() << 2 >> GLChecks.typeToByteShift(n3)), n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglPathSubCommandsNV(int var0, int var1, int var2, int var3, long var4, int var6, int var7, long var8);

    public static void glPathSubCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n5, @NativeType(value="void const *") ByteBuffer byteBuffer2) {
        NVPathRendering.nglPathSubCommandsNV(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), byteBuffer2.remaining() >> GLChecks.typeToByteShift(n5), n5, MemoryUtil.memAddress(byteBuffer2));
    }

    public static void glPathSubCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n5, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        NVPathRendering.nglPathSubCommandsNV(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), (int)((long)shortBuffer.remaining() << 1 >> GLChecks.typeToByteShift(n5)), n5, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glPathSubCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n5, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        NVPathRendering.nglPathSubCommandsNV(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), (int)((long)floatBuffer.remaining() << 2 >> GLChecks.typeToByteShift(n5)), n5, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglPathSubCoordsNV(int var0, int var1, int var2, int var3, long var4);

    public static void glPathSubCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        NVPathRendering.nglPathSubCoordsNV(n2, n3, byteBuffer.remaining() >> GLChecks.typeToByteShift(n4), n4, MemoryUtil.memAddress(byteBuffer));
    }

    public static void glPathSubCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") ShortBuffer shortBuffer) {
        NVPathRendering.nglPathSubCoordsNV(n2, n3, (int)((long)shortBuffer.remaining() << 1 >> GLChecks.typeToByteShift(n4)), n4, MemoryUtil.memAddress(shortBuffer));
    }

    public static void glPathSubCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") FloatBuffer floatBuffer) {
        NVPathRendering.nglPathSubCoordsNV(n2, n3, (int)((long)floatBuffer.remaining() << 2 >> GLChecks.typeToByteShift(n4)), n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglPathStringNV(int var0, int var1, int var2, long var3);

    public static void glPathStringNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer) {
        NVPathRendering.nglPathStringNV(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglPathGlyphsNV(int var0, int var1, long var2, int var4, int var5, int var6, long var7, int var9, int var10, float var11);

    public static void glPathGlyphsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="void const *") ByteBuffer byteBuffer2, @NativeType(value="GLenum") int n6, @NativeType(value="GLuint") int n7, @NativeType(value="GLfloat") float f2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        NVPathRendering.nglPathGlyphsNV(n2, n3, MemoryUtil.memAddress(byteBuffer), n4, byteBuffer2.remaining() / NVPathRendering.charcodeTypeToBytes(n5), n5, MemoryUtil.memAddress(byteBuffer2), n6, n7, f2);
    }

    public static native void nglPathGlyphRangeNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, int var8, float var9);

    public static void glPathGlyphRangeNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLuint") int n8, @NativeType(value="GLfloat") float f2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        NVPathRendering.nglPathGlyphRangeNV(n2, n3, MemoryUtil.memAddress(byteBuffer), n4, n5, n6, n7, n8, f2);
    }

    public static native int nglPathGlyphIndexArrayNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, float var8);

    @NativeType(value="GLenum")
    public static int glPathGlyphIndexArrayNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLuint") int n7, @NativeType(value="GLfloat") float f2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return NVPathRendering.nglPathGlyphIndexArrayNV(n2, n3, MemoryUtil.memAddress(byteBuffer), n4, n5, n6, n7, f2);
    }

    public static native int nglPathMemoryGlyphIndexArrayNV(int var0, int var1, long var2, long var4, int var6, int var7, int var8, int var9, float var10);

    @NativeType(value="GLenum")
    public static int glPathMemoryGlyphIndexArrayNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLuint") int n7, @NativeType(value="GLfloat") float f2) {
        return NVPathRendering.nglPathMemoryGlyphIndexArrayNV(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), n4, n5, n6, n7, f2);
    }

    public static native void glCopyPathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void nglWeightPathsNV(int var0, int var1, long var2, long var4);

    public static void glWeightPathsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, intBuffer.remaining());
        }
        NVPathRendering.nglWeightPathsNV(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glInterpolatePathsNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLfloat") float var3);

    public static native void nglTransformPathNV(int var0, int var1, int var2, long var3);

    public static void glTransformPathNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, NVPathRendering.transformTypeToElements(n4));
        }
        NVPathRendering.nglTransformPathNV(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglPathParameterivNV(int var0, int var1, long var2);

    public static void glPathParameterivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        NVPathRendering.nglPathParameterivNV(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static native void glPathParameteriNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void nglPathParameterfvNV(int var0, int var1, long var2);

    public static void glPathParameterfvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        NVPathRendering.nglPathParameterfvNV(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glPathParameterfNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLfloat") float var2);

    public static native void nglPathDashArrayNV(int var0, int var1, long var2);

    public static void glPathDashArrayNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        NVPathRendering.nglPathDashArrayNV(n2, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    @NativeType(value="GLuint")
    public static native int glGenPathsNV(@NativeType(value="GLsizei") int var0);

    public static native void glDeletePathsNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1);

    @NativeType(value="GLboolean")
    public static native boolean glIsPathNV(@NativeType(value="GLuint") int var0);

    public static native void glPathStencilFuncNV(@NativeType(value="GLenum") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glPathStencilDepthOffsetNV(@NativeType(value="GLfloat") float var0, @NativeType(value="GLfloat") float var1);

    public static native void glStencilFillPathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2);

    public static native void glStencilStrokePathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2);

    public static native void nglStencilFillPathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, long var8);

    public static void glStencilFillPathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        int n7 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, n7 * NVPathRendering.transformTypeToElements(n6));
        }
        NVPathRendering.nglStencilFillPathInstancedNV(n7, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, n6, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglStencilStrokePathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, long var8);

    public static void glStencilStrokePathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        int n7 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, n7 * NVPathRendering.transformTypeToElements(n6));
        }
        NVPathRendering.nglStencilStrokePathInstancedNV(n7, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, n6, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glPathCoverDepthFuncNV(@NativeType(value="GLenum") int var0);

    public static native void nglPathColorGenNV(int var0, int var1, int var2, long var3);

    public static void glPathColorGenNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, NVPathRendering.genModeToElements(n3) * NVPathRendering.colorFormatToComponents(n4));
        }
        NVPathRendering.nglPathColorGenNV(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglPathTexGenNV(int var0, int var1, int var2, long var3);

    public static void glPathTexGenNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, NVPathRendering.genModeToElements(n3) * n4);
        }
        NVPathRendering.nglPathTexGenNV(n2, n3, n4, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glPathFogGenNV(@NativeType(value="GLenum") int var0);

    public static native void glCoverFillPathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void glCoverStrokePathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1);

    public static native void nglCoverFillPathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, long var7);

    public static void glCoverFillPathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        int n6 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, n6 * NVPathRendering.transformTypeToElements(n5));
        }
        NVPathRendering.nglCoverFillPathInstancedNV(n6, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglCoverStrokePathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, long var7);

    public static void glCoverStrokePathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        int n6 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, n6 * NVPathRendering.transformTypeToElements(n5));
        }
        NVPathRendering.nglCoverStrokePathInstancedNV(n6, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void glStencilThenCoverFillPathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLenum") int var3);

    public static native void glStencilThenCoverStrokePathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLenum") int var3);

    public static native void nglStencilThenCoverFillPathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glStencilThenCoverFillPathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        int n8 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, n8 * NVPathRendering.transformTypeToElements(n7));
        }
        NVPathRendering.nglStencilThenCoverFillPathInstancedNV(n8, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, n6, n7, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglStencilThenCoverStrokePathInstancedNV(int var0, int var1, long var2, int var4, int var5, int var6, int var7, int var8, long var9);

    public static void glStencilThenCoverStrokePathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        int n8 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, n8 * NVPathRendering.transformTypeToElements(n7));
        }
        NVPathRendering.nglStencilThenCoverStrokePathInstancedNV(n8, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, n6, n7, MemoryUtil.memAddress(floatBuffer));
    }

    public static native int nglPathGlyphIndexRangeNV(int var0, long var1, int var3, int var4, float var5, long var6);

    @NativeType(value="GLenum")
    public static int glPathGlyphIndexRangeNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat") float f2, @NativeType(value="GLuint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.check((Buffer)intBuffer, 2);
        }
        return NVPathRendering.nglPathGlyphIndexRangeNV(n2, MemoryUtil.memAddress(byteBuffer), n3, n4, f2, MemoryUtil.memAddress(intBuffer));
    }

    public static native void nglProgramPathFragmentInputGenNV(int var0, int var1, int var2, int var3, long var4);

    public static void glProgramPathFragmentInputGenNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, NVPathRendering.genModeToElements(n4) * n5);
        }
        NVPathRendering.nglProgramPathFragmentInputGenNV(n2, n3, n4, n5, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetPathParameterivNV(int var0, int var1, long var2);

    public static void glGetPathParameterivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        NVPathRendering.nglGetPathParameterivNV(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetPathParameteriNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            NVPathRendering.nglGetPathParameterivNV(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetPathParameterfvNV(int var0, int var1, long var2);

    public static void glGetPathParameterfvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        NVPathRendering.nglGetPathParameterfvNV(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetPathParameterfNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            NVPathRendering.nglGetPathParameterfvNV(n2, n3, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetPathCommandsNV(int var0, long var1);

    public static void glGetPathCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)byteBuffer, NVPathRendering.glGetPathParameteriNV(n2, 37021));
        }
        NVPathRendering.nglGetPathCommandsNV(n2, MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nglGetPathCoordsNV(int var0, long var1);

    public static void glGetPathCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)floatBuffer, NVPathRendering.glGetPathParameteriNV(n2, 37022));
        }
        NVPathRendering.nglGetPathCoordsNV(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetPathDashArrayNV(int var0, long var1);

    public static void glGetPathDashArrayNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS && Checks.DEBUG) {
            Checks.check((Buffer)floatBuffer, NVPathRendering.glGetPathParameteriNV(n2, 37023));
        }
        NVPathRendering.nglGetPathDashArrayNV(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetPathMetricsNV(int var0, int var1, int var2, long var3, int var5, int var6, long var7);

    public static void glGetPathMetricsNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        int n6 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n3);
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, n6 * (n5 == 0 ? Integer.bitCount(n2) : n5 >> 2));
        }
        NVPathRendering.nglGetPathMetricsNV(n2, n6, n3, MemoryUtil.memAddress(byteBuffer), n4, n5, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetPathMetricRangeNV(int var0, int var1, int var2, int var3, long var4);

    public static void glGetPathMetricRangeNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, n4 * (n5 == 0 ? Integer.bitCount(n2) : n5 >> 2));
        }
        NVPathRendering.nglGetPathMetricRangeNV(n2, n3, n4, n5, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetPathSpacingNV(int var0, int var1, int var2, long var3, int var5, float var6, float var7, int var8, long var9);

    public static void glGetPathSpacingNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLenum") int n5, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        int n6 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n3);
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, (n6 - 1) * (n5 == 37006 ? 1 : 2));
        }
        NVPathRendering.nglGetPathSpacingNV(n2, n6, n3, MemoryUtil.memAddress(byteBuffer), n4, f2, f3, n5, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetPathColorGenivNV(int var0, int var1, long var2);

    public static void glGetPathColorGenivNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        NVPathRendering.nglGetPathColorGenivNV(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetPathColorGeniNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            NVPathRendering.nglGetPathColorGenivNV(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetPathColorGenfvNV(int var0, int var1, long var2);

    public static void glGetPathColorGenfvNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        NVPathRendering.nglGetPathColorGenfvNV(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetPathColorGenfNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            NVPathRendering.nglGetPathColorGenfvNV(n2, n3, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetPathTexGenivNV(int var0, int var1, long var2);

    public static void glGetPathTexGenivNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        NVPathRendering.nglGetPathTexGenivNV(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetPathTexGeniNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            NVPathRendering.nglGetPathTexGenivNV(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetPathTexGenfvNV(int var0, int var1, long var2);

    public static void glGetPathTexGenfvNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        NVPathRendering.nglGetPathTexGenfvNV(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static float glGetPathTexGenfNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            NVPathRendering.nglGetPathTexGenfvNV(n2, n3, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    @NativeType(value="GLboolean")
    public static native boolean glIsPointInFillPathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLfloat") float var2, @NativeType(value="GLfloat") float var3);

    @NativeType(value="GLboolean")
    public static native boolean glIsPointInStrokePathNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLfloat") float var1, @NativeType(value="GLfloat") float var2);

    @NativeType(value="GLfloat")
    public static native float glGetPathLengthNV(@NativeType(value="GLuint") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLsizei") int var2);

    public static native boolean nglPointAlongPathNV(int var0, int var1, int var2, float var3, long var4, long var6, long var8, long var10);

    @NativeType(value="GLboolean")
    public static boolean glPointAlongPathNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLfloat") float f2, @Nullable @NativeType(value="GLfloat *") FloatBuffer floatBuffer, @Nullable @NativeType(value="GLfloat *") FloatBuffer floatBuffer2, @Nullable @NativeType(value="GLfloat *") FloatBuffer floatBuffer3, @Nullable @NativeType(value="GLfloat *") FloatBuffer floatBuffer4) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)floatBuffer, 1);
            Checks.checkSafe((Buffer)floatBuffer2, 1);
            Checks.checkSafe((Buffer)floatBuffer3, 1);
            Checks.checkSafe((Buffer)floatBuffer4, 1);
        }
        return NVPathRendering.nglPointAlongPathNV(n2, n3, n4, f2, MemoryUtil.memAddressSafe(floatBuffer), MemoryUtil.memAddressSafe(floatBuffer2), MemoryUtil.memAddressSafe(floatBuffer3), MemoryUtil.memAddressSafe(floatBuffer4));
    }

    public static native void nglMatrixLoad3x2fNV(int var0, long var1);

    public static void glMatrixLoad3x2fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
        }
        NVPathRendering.nglMatrixLoad3x2fNV(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMatrixLoad3x3fNV(int var0, long var1);

    public static void glMatrixLoad3x3fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 9);
        }
        NVPathRendering.nglMatrixLoad3x3fNV(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMatrixLoadTranspose3x3fNV(int var0, long var1);

    public static void glMatrixLoadTranspose3x3fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 9);
        }
        NVPathRendering.nglMatrixLoadTranspose3x3fNV(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMatrixMult3x2fNV(int var0, long var1);

    public static void glMatrixMult3x2fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 6);
        }
        NVPathRendering.nglMatrixMult3x2fNV(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMatrixMult3x3fNV(int var0, long var1);

    public static void glMatrixMult3x3fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 9);
        }
        NVPathRendering.nglMatrixMult3x3fNV(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglMatrixMultTranspose3x3fNV(int var0, long var1);

    public static void glMatrixMultTranspose3x3fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 9);
        }
        NVPathRendering.nglMatrixMultTranspose3x3fNV(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nglGetProgramResourcefvNV(int var0, int var1, int var2, int var3, long var4, int var6, long var7, long var9);

    public static void glGetProgramResourcefvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer2, @NativeType(value="GLfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer2, 1);
        }
        NVPathRendering.nglGetProgramResourcefvNV(n2, n3, n4, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), floatBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddress(floatBuffer));
    }

    public static void glPathCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glPathCommandsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), sArray.length, n3, sArray, l2);
    }

    public static void glPathCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glPathCommandsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), fArray.length, n3, fArray, l2);
    }

    public static void glPathCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glPathCoordsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, sArray.length, n3, sArray, l2);
    }

    public static void glPathCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glPathCoordsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length, n3, fArray, l2);
    }

    public static void glPathSubCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n5, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glPathSubCommandsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), sArray.length, n5, sArray, l2);
    }

    public static void glPathSubCommandsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLubyte const *") ByteBuffer byteBuffer, @NativeType(value="GLenum") int n5, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glPathSubCommandsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPPV(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer), fArray.length, n5, fArray, l2);
    }

    public static void glPathSubCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glPathSubCoordsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, sArray.length, n4, sArray, l2);
    }

    public static void glPathSubCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glPathSubCoordsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, fArray.length, n4, fArray, l2);
    }

    public static void glWeightPathsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glWeightPathsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, nArray.length);
        }
        JNI.callPPV(n2, nArray.length, nArray, fArray, l2);
    }

    public static void glTransformPathNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glTransformPathNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, NVPathRendering.transformTypeToElements(n4));
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glPathParameterivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint const *") int[] nArray) {
        long l2 = GL.getICD().glPathParameterivNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glPathParameterfvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glPathParameterfvNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glPathDashArrayNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glPathDashArrayNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, fArray.length, fArray, l2);
    }

    public static void glStencilFillPathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glStencilFillPathInstancedNV;
        int n7 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, n7 * NVPathRendering.transformTypeToElements(n6));
        }
        JNI.callPPV(n7, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, n6, fArray, l2);
    }

    public static void glStencilStrokePathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glStencilStrokePathInstancedNV;
        int n7 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, n7 * NVPathRendering.transformTypeToElements(n6));
        }
        JNI.callPPV(n7, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, n6, fArray, l2);
    }

    public static void glPathColorGenNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glPathColorGenNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, NVPathRendering.genModeToElements(n3) * NVPathRendering.colorFormatToComponents(n4));
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glPathTexGenNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glPathTexGenNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, NVPathRendering.genModeToElements(n3) * n4);
        }
        JNI.callPV(n2, n3, n4, fArray, l2);
    }

    public static void glCoverFillPathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glCoverFillPathInstancedNV;
        int n6 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, n6 * NVPathRendering.transformTypeToElements(n5));
        }
        JNI.callPPV(n6, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, fArray, l2);
    }

    public static void glCoverStrokePathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glCoverStrokePathInstancedNV;
        int n6 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, n6 * NVPathRendering.transformTypeToElements(n5));
        }
        JNI.callPPV(n6, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, fArray, l2);
    }

    public static void glStencilThenCoverFillPathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glStencilThenCoverFillPathInstancedNV;
        int n8 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, n8 * NVPathRendering.transformTypeToElements(n7));
        }
        JNI.callPPV(n8, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, n6, n7, fArray, l2);
    }

    public static void glStencilThenCoverStrokePathInstancedNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLuint") int n5, @NativeType(value="GLenum") int n6, @NativeType(value="GLenum") int n7, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glStencilThenCoverStrokePathInstancedNV;
        int n8 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n2);
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, n8 * NVPathRendering.transformTypeToElements(n7));
        }
        JNI.callPPV(n8, n2, MemoryUtil.memAddress(byteBuffer), n3, n4, n5, n6, n7, fArray, l2);
    }

    @NativeType(value="GLenum")
    public static int glPathGlyphIndexRangeNV(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLbitfield") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat") float f2, @NativeType(value="GLuint *") int[] nArray) {
        long l2 = GL.getICD().glPathGlyphIndexRangeNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkNT1(byteBuffer);
            Checks.check(nArray, 2);
        }
        return JNI.callPPI(n2, MemoryUtil.memAddress(byteBuffer), n3, n4, f2, nArray, l2);
    }

    public static void glProgramPathFragmentInputGenNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLint") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glProgramPathFragmentInputGenNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, NVPathRendering.genModeToElements(n4) * n5);
        }
        JNI.callPV(n2, n3, n4, n5, fArray, l2);
    }

    public static void glGetPathParameterivNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetPathParameterivNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetPathParameterfvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetPathParameterfvNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetPathCoordsNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetPathCoordsNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            if (Checks.DEBUG) {
                Checks.check(fArray, NVPathRendering.glGetPathParameteriNV(n2, 37022));
            }
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glGetPathDashArrayNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetPathDashArrayNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            if (Checks.DEBUG) {
                Checks.check(fArray, NVPathRendering.glGetPathParameteriNV(n2, 37023));
            }
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glGetPathMetricsNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetPathMetricsNV;
        int n6 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n3);
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, n6 * (n5 == 0 ? Integer.bitCount(n2) : n5 >> 2));
        }
        JNI.callPPV(n2, n6, n3, MemoryUtil.memAddress(byteBuffer), n4, n5, fArray, l2);
    }

    public static void glGetPathMetricRangeNV(@NativeType(value="GLbitfield") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetPathMetricRangeNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, n4 * (n5 == 0 ? Integer.bitCount(n2) : n5 >> 2));
        }
        JNI.callPV(n2, n3, n4, n5, fArray, l2);
    }

    public static void glGetPathSpacingNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLuint") int n4, @NativeType(value="GLfloat") float f2, @NativeType(value="GLfloat") float f3, @NativeType(value="GLenum") int n5, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetPathSpacingNV;
        int n6 = byteBuffer.remaining() / NVPathRendering.pathNameTypeToBytes(n3);
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, (n6 - 1) * (n5 == 37006 ? 1 : 2));
        }
        JNI.callPPV(n2, n6, n3, MemoryUtil.memAddress(byteBuffer), n4, f2, f3, n5, fArray, l2);
    }

    public static void glGetPathColorGenivNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetPathColorGenivNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetPathColorGenfvNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetPathColorGenfvNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    public static void glGetPathTexGenivNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetPathTexGenivNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetPathTexGenfvNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetPathTexGenfvNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 1);
        }
        JNI.callPV(n2, n3, fArray, l2);
    }

    @NativeType(value="GLboolean")
    public static boolean glPointAlongPathNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4, @NativeType(value="GLfloat") float f2, @Nullable @NativeType(value="GLfloat *") float[] fArray, @Nullable @NativeType(value="GLfloat *") float[] fArray2, @Nullable @NativeType(value="GLfloat *") float[] fArray3, @Nullable @NativeType(value="GLfloat *") float[] fArray4) {
        long l2 = GL.getICD().glPointAlongPathNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(fArray, 1);
            Checks.checkSafe(fArray2, 1);
            Checks.checkSafe(fArray3, 1);
            Checks.checkSafe(fArray4, 1);
        }
        return JNI.callPPPPZ(n2, n3, n4, f2, fArray, fArray2, fArray3, fArray4, l2);
    }

    public static void glMatrixLoad3x2fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMatrixLoad3x2fNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 6);
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glMatrixLoad3x3fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMatrixLoad3x3fNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 9);
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glMatrixLoadTranspose3x3fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMatrixLoadTranspose3x3fNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 9);
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glMatrixMult3x2fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMatrixMult3x2fNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 6);
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glMatrixMult3x3fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMatrixMult3x3fNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 9);
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glMatrixMultTranspose3x3fNV(@NativeType(value="GLenum") int n2, @NativeType(value="GLfloat const *") float[] fArray) {
        long l2 = GL.getICD().glMatrixMultTranspose3x3fNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(fArray, 9);
        }
        JNI.callPV(n2, fArray, l2);
    }

    public static void glGetProgramResourcefvNV(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum const *") int[] nArray, @Nullable @NativeType(value="GLsizei *") int[] nArray2, @NativeType(value="GLfloat *") float[] fArray) {
        long l2 = GL.getICD().glGetProgramResourcefvNV;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray2, 1);
        }
        JNI.callPPPV(n2, n3, n4, nArray.length, nArray, fArray.length, nArray2, fArray, l2);
    }

    private static int charcodeTypeToBytes(int n2) {
        switch (n2) {
            case 5121: 
            case 37018: {
                return 1;
            }
            case 5123: 
            case 5127: 
            case 37019: {
                return 2;
            }
            case 5128: {
                return 3;
            }
            case 5125: 
            case 5129: {
                return 4;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported charcode type: 0x%X", n2));
    }

    private static int pathNameTypeToBytes(int n2) {
        switch (n2) {
            case 5120: 
            case 5121: 
            case 37018: {
                return 1;
            }
            case 5122: 
            case 5123: 
            case 5127: 
            case 37019: {
                return 2;
            }
            case 5128: {
                return 3;
            }
            case 5124: 
            case 5125: 
            case 5129: {
                return 4;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported path name type: 0x%X", n2));
    }

    private static int transformTypeToElements(int n2) {
        switch (n2) {
            case 0: {
                return 0;
            }
            case 37006: 
            case 37007: {
                return 1;
            }
            case 37008: {
                return 2;
            }
            case 37009: {
                return 3;
            }
            case 37010: 
            case 37014: {
                return 6;
            }
            case 37012: 
            case 37016: {
                return 12;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported transform type: 0x%X", n2));
    }

    private static int colorFormatToComponents(int n2) {
        switch (n2) {
            case 6406: 
            case 6409: 
            case 32841: {
                return 1;
            }
            case 6410: {
                return 2;
            }
            case 6407: {
                return 3;
            }
            case 6408: {
                return 4;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported colorFormat specified: 0x%X", n2));
    }

    private static int genModeToElements(int n2) {
        switch (n2) {
            case 0: {
                return 0;
            }
            case 34166: {
                return 1;
            }
            case 9217: 
            case 37002: {
                return 3;
            }
            case 9216: {
                return 4;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported genMode specified: 0x%X", n2));
    }

    static {
        GL.initialize();
    }
}

