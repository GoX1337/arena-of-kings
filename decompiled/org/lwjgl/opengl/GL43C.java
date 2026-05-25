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
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL42C;
import org.lwjgl.opengl.GLDebugMessageCallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GL43C
extends GL42C {
    public static final int GL_NUM_SHADING_LANGUAGE_VERSIONS = 33513;
    public static final int GL_VERTEX_ATTRIB_ARRAY_LONG = 34638;
    public static final int GL_COMPRESSED_RGB8_ETC2 = 37492;
    public static final int GL_COMPRESSED_SRGB8_ETC2 = 37493;
    public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37494;
    public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37495;
    public static final int GL_COMPRESSED_RGBA8_ETC2_EAC = 37496;
    public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC = 37497;
    public static final int GL_COMPRESSED_R11_EAC = 37488;
    public static final int GL_COMPRESSED_SIGNED_R11_EAC = 37489;
    public static final int GL_COMPRESSED_RG11_EAC = 37490;
    public static final int GL_COMPRESSED_SIGNED_RG11_EAC = 37491;
    public static final int GL_PRIMITIVE_RESTART_FIXED_INDEX = 36201;
    public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE = 36202;
    public static final int GL_MAX_ELEMENT_INDEX = 36203;
    public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503;
    public static final int GL_COMPUTE_SHADER = 37305;
    public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 37307;
    public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 37308;
    public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 37309;
    public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 33378;
    public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 33379;
    public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 33380;
    public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 33381;
    public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 33382;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 37099;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 37310;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 37311;
    public static final int GL_COMPUTE_WORK_GROUP_SIZE = 33383;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER = 37100;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER = 37101;
    public static final int GL_DISPATCH_INDIRECT_BUFFER = 37102;
    public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 37103;
    public static final int GL_COMPUTE_SHADER_BIT = 32;
    public static final int GL_DEBUG_OUTPUT = 37600;
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346;
    public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
    public static final int GL_DEBUG_LOGGED_MESSAGES = 37189;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347;
    public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
    public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389;
    public static final int GL_MAX_LABEL_LENGTH = 33512;
    public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349;
    public static final int GL_DEBUG_SOURCE_API = 33350;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
    public static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
    public static final int GL_DEBUG_SOURCE_OTHER = 33355;
    public static final int GL_DEBUG_TYPE_ERROR = 33356;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
    public static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
    public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
    public static final int GL_DEBUG_TYPE_OTHER = 33361;
    public static final int GL_DEBUG_TYPE_MARKER = 33384;
    public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385;
    public static final int GL_DEBUG_TYPE_POP_GROUP = 33386;
    public static final int GL_DEBUG_SEVERITY_HIGH = 37190;
    public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
    public static final int GL_DEBUG_SEVERITY_LOW = 37192;
    public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
    public static final int GL_BUFFER = 33504;
    public static final int GL_SHADER = 33505;
    public static final int GL_PROGRAM = 33506;
    public static final int GL_QUERY = 33507;
    public static final int GL_PROGRAM_PIPELINE = 33508;
    public static final int GL_SAMPLER = 33510;
    public static final int GL_MAX_UNIFORM_LOCATIONS = 33390;
    public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
    public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
    public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
    public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
    public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
    public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;
    public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
    public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
    public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;
    public static final int GL_INTERNALFORMAT_SUPPORTED = 33391;
    public static final int GL_INTERNALFORMAT_PREFERRED = 33392;
    public static final int GL_INTERNALFORMAT_RED_SIZE = 33393;
    public static final int GL_INTERNALFORMAT_GREEN_SIZE = 33394;
    public static final int GL_INTERNALFORMAT_BLUE_SIZE = 33395;
    public static final int GL_INTERNALFORMAT_ALPHA_SIZE = 33396;
    public static final int GL_INTERNALFORMAT_DEPTH_SIZE = 33397;
    public static final int GL_INTERNALFORMAT_STENCIL_SIZE = 33398;
    public static final int GL_INTERNALFORMAT_SHARED_SIZE = 33399;
    public static final int GL_INTERNALFORMAT_RED_TYPE = 33400;
    public static final int GL_INTERNALFORMAT_GREEN_TYPE = 33401;
    public static final int GL_INTERNALFORMAT_BLUE_TYPE = 33402;
    public static final int GL_INTERNALFORMAT_ALPHA_TYPE = 33403;
    public static final int GL_INTERNALFORMAT_DEPTH_TYPE = 33404;
    public static final int GL_INTERNALFORMAT_STENCIL_TYPE = 33405;
    public static final int GL_MAX_WIDTH = 33406;
    public static final int GL_MAX_HEIGHT = 33407;
    public static final int GL_MAX_DEPTH = 33408;
    public static final int GL_MAX_LAYERS = 33409;
    public static final int GL_MAX_COMBINED_DIMENSIONS = 33410;
    public static final int GL_COLOR_COMPONENTS = 33411;
    public static final int GL_DEPTH_COMPONENTS = 33412;
    public static final int GL_STENCIL_COMPONENTS = 33413;
    public static final int GL_COLOR_RENDERABLE = 33414;
    public static final int GL_DEPTH_RENDERABLE = 33415;
    public static final int GL_STENCIL_RENDERABLE = 33416;
    public static final int GL_FRAMEBUFFER_RENDERABLE = 33417;
    public static final int GL_FRAMEBUFFER_RENDERABLE_LAYERED = 33418;
    public static final int GL_FRAMEBUFFER_BLEND = 33419;
    public static final int GL_READ_PIXELS = 33420;
    public static final int GL_READ_PIXELS_FORMAT = 33421;
    public static final int GL_READ_PIXELS_TYPE = 33422;
    public static final int GL_TEXTURE_IMAGE_FORMAT = 33423;
    public static final int GL_TEXTURE_IMAGE_TYPE = 33424;
    public static final int GL_GET_TEXTURE_IMAGE_FORMAT = 33425;
    public static final int GL_GET_TEXTURE_IMAGE_TYPE = 33426;
    public static final int GL_MIPMAP = 33427;
    public static final int GL_MANUAL_GENERATE_MIPMAP = 33428;
    public static final int GL_AUTO_GENERATE_MIPMAP = 33429;
    public static final int GL_COLOR_ENCODING = 33430;
    public static final int GL_SRGB_READ = 33431;
    public static final int GL_SRGB_WRITE = 33432;
    public static final int GL_FILTER = 33434;
    public static final int GL_VERTEX_TEXTURE = 33435;
    public static final int GL_TESS_CONTROL_TEXTURE = 33436;
    public static final int GL_TESS_EVALUATION_TEXTURE = 33437;
    public static final int GL_GEOMETRY_TEXTURE = 33438;
    public static final int GL_FRAGMENT_TEXTURE = 33439;
    public static final int GL_COMPUTE_TEXTURE = 33440;
    public static final int GL_TEXTURE_SHADOW = 33441;
    public static final int GL_TEXTURE_GATHER = 33442;
    public static final int GL_TEXTURE_GATHER_SHADOW = 33443;
    public static final int GL_SHADER_IMAGE_LOAD = 33444;
    public static final int GL_SHADER_IMAGE_STORE = 33445;
    public static final int GL_SHADER_IMAGE_ATOMIC = 33446;
    public static final int GL_IMAGE_TEXEL_SIZE = 33447;
    public static final int GL_IMAGE_COMPATIBILITY_CLASS = 33448;
    public static final int GL_IMAGE_PIXEL_FORMAT = 33449;
    public static final int GL_IMAGE_PIXEL_TYPE = 33450;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST = 33452;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST = 33453;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE = 33454;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE = 33455;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_WIDTH = 33457;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT = 33458;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_SIZE = 33459;
    public static final int GL_CLEAR_BUFFER = 33460;
    public static final int GL_TEXTURE_VIEW = 33461;
    public static final int GL_VIEW_COMPATIBILITY_CLASS = 33462;
    public static final int GL_FULL_SUPPORT = 33463;
    public static final int GL_CAVEAT_SUPPORT = 33464;
    public static final int GL_IMAGE_CLASS_4_X_32 = 33465;
    public static final int GL_IMAGE_CLASS_2_X_32 = 33466;
    public static final int GL_IMAGE_CLASS_1_X_32 = 33467;
    public static final int GL_IMAGE_CLASS_4_X_16 = 33468;
    public static final int GL_IMAGE_CLASS_2_X_16 = 33469;
    public static final int GL_IMAGE_CLASS_1_X_16 = 33470;
    public static final int GL_IMAGE_CLASS_4_X_8 = 33471;
    public static final int GL_IMAGE_CLASS_2_X_8 = 33472;
    public static final int GL_IMAGE_CLASS_1_X_8 = 33473;
    public static final int GL_IMAGE_CLASS_11_11_10 = 33474;
    public static final int GL_IMAGE_CLASS_10_10_10_2 = 33475;
    public static final int GL_VIEW_CLASS_128_BITS = 33476;
    public static final int GL_VIEW_CLASS_96_BITS = 33477;
    public static final int GL_VIEW_CLASS_64_BITS = 33478;
    public static final int GL_VIEW_CLASS_48_BITS = 33479;
    public static final int GL_VIEW_CLASS_32_BITS = 33480;
    public static final int GL_VIEW_CLASS_24_BITS = 33481;
    public static final int GL_VIEW_CLASS_16_BITS = 33482;
    public static final int GL_VIEW_CLASS_8_BITS = 33483;
    public static final int GL_VIEW_CLASS_S3TC_DXT1_RGB = 33484;
    public static final int GL_VIEW_CLASS_S3TC_DXT1_RGBA = 33485;
    public static final int GL_VIEW_CLASS_S3TC_DXT3_RGBA = 33486;
    public static final int GL_VIEW_CLASS_S3TC_DXT5_RGBA = 33487;
    public static final int GL_VIEW_CLASS_RGTC1_RED = 33488;
    public static final int GL_VIEW_CLASS_RGTC2_RG = 33489;
    public static final int GL_VIEW_CLASS_BPTC_UNORM = 33490;
    public static final int GL_VIEW_CLASS_BPTC_FLOAT = 33491;
    public static final int GL_UNIFORM = 37601;
    public static final int GL_UNIFORM_BLOCK = 37602;
    public static final int GL_PROGRAM_INPUT = 37603;
    public static final int GL_PROGRAM_OUTPUT = 37604;
    public static final int GL_BUFFER_VARIABLE = 37605;
    public static final int GL_SHADER_STORAGE_BLOCK = 37606;
    public static final int GL_VERTEX_SUBROUTINE = 37608;
    public static final int GL_TESS_CONTROL_SUBROUTINE = 37609;
    public static final int GL_TESS_EVALUATION_SUBROUTINE = 37610;
    public static final int GL_GEOMETRY_SUBROUTINE = 37611;
    public static final int GL_FRAGMENT_SUBROUTINE = 37612;
    public static final int GL_COMPUTE_SUBROUTINE = 37613;
    public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 37614;
    public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 37615;
    public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 37616;
    public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 37617;
    public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 37618;
    public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 37619;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING = 37620;
    public static final int GL_ACTIVE_RESOURCES = 37621;
    public static final int GL_MAX_NAME_LENGTH = 37622;
    public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 37623;
    public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 37624;
    public static final int GL_NAME_LENGTH = 37625;
    public static final int GL_TYPE = 37626;
    public static final int GL_ARRAY_SIZE = 37627;
    public static final int GL_OFFSET = 37628;
    public static final int GL_BLOCK_INDEX = 37629;
    public static final int GL_ARRAY_STRIDE = 37630;
    public static final int GL_MATRIX_STRIDE = 37631;
    public static final int GL_IS_ROW_MAJOR = 37632;
    public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 37633;
    public static final int GL_BUFFER_BINDING = 37634;
    public static final int GL_BUFFER_DATA_SIZE = 37635;
    public static final int GL_NUM_ACTIVE_VARIABLES = 37636;
    public static final int GL_ACTIVE_VARIABLES = 37637;
    public static final int GL_REFERENCED_BY_VERTEX_SHADER = 37638;
    public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 37639;
    public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 37640;
    public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 37641;
    public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 37642;
    public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 37643;
    public static final int GL_TOP_LEVEL_ARRAY_SIZE = 37644;
    public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 37645;
    public static final int GL_LOCATION = 37646;
    public static final int GL_LOCATION_INDEX = 37647;
    public static final int GL_IS_PER_PATCH = 37607;
    public static final int GL_SHADER_STORAGE_BUFFER = 37074;
    public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 37075;
    public static final int GL_SHADER_STORAGE_BUFFER_START = 37076;
    public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 37077;
    public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 37078;
    public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 37079;
    public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 37080;
    public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 37081;
    public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 37082;
    public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 37083;
    public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 37084;
    public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 37085;
    public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 37086;
    public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 37087;
    public static final int GL_SHADER_STORAGE_BARRIER_BIT = 8192;
    public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 36665;
    public static final int GL_DEPTH_STENCIL_TEXTURE_MODE = 37098;
    public static final int GL_TEXTURE_BUFFER_OFFSET = 37277;
    public static final int GL_TEXTURE_BUFFER_SIZE = 37278;
    public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279;
    public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 33499;
    public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 33500;
    public static final int GL_TEXTURE_VIEW_MIN_LAYER = 33501;
    public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 33502;
    public static final int GL_VERTEX_ATTRIB_BINDING = 33492;
    public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493;
    public static final int GL_VERTEX_BINDING_DIVISOR = 33494;
    public static final int GL_VERTEX_BINDING_OFFSET = 33495;
    public static final int GL_VERTEX_BINDING_STRIDE = 33496;
    public static final int GL_VERTEX_BINDING_BUFFER = 36687;
    public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497;
    public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498;

    protected GL43C() {
        throw new UnsupportedOperationException();
    }

    public static native void nglClearBufferData(int var0, int var1, int var2, int var3, long var4);

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL43C.nglClearBufferData(n2, n3, n4, n5, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL43C.nglClearBufferData(n2, n3, n4, n5, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL43C.nglClearBufferData(n2, n3, n4, n5, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL43C.nglClearBufferData(n2, n3, n4, n5, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static native void nglClearBufferSubData(int var0, int var1, long var2, long var4, int var6, int var7, long var8);

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ByteBuffer byteBuffer) {
        GL43C.nglClearBufferSubData(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") ShortBuffer shortBuffer) {
        GL43C.nglClearBufferSubData(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") IntBuffer intBuffer) {
        GL43C.nglClearBufferSubData(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") FloatBuffer floatBuffer) {
        GL43C.nglClearBufferSubData(n2, n3, l2, l3, n4, n5, MemoryUtil.memAddressSafe(floatBuffer));
    }

    public static native void glDispatchCompute(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glDispatchComputeIndirect(@NativeType(value="GLintptr") long var0);

    public static native void glCopyImageSubData(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLint") int var5, @NativeType(value="GLuint") int var6, @NativeType(value="GLenum") int var7, @NativeType(value="GLint") int var8, @NativeType(value="GLint") int var9, @NativeType(value="GLint") int var10, @NativeType(value="GLint") int var11, @NativeType(value="GLsizei") int var12, @NativeType(value="GLsizei") int var13, @NativeType(value="GLsizei") int var14);

    public static native void nglDebugMessageControl(int var0, int var1, int var2, int var3, long var4, boolean var6);

    public static void glDebugMessageControl(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @Nullable @NativeType(value="GLuint const *") IntBuffer intBuffer, @NativeType(value="GLboolean") boolean bl2) {
        GL43C.nglDebugMessageControl(n2, n3, n4, Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer), bl2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDebugMessageControl(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLuint const *") int n5, @NativeType(value="GLboolean") boolean bl2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n6 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n5);
            GL43C.nglDebugMessageControl(n2, n3, n4, 1, MemoryUtil.memAddress(intBuffer), bl2);
        }
        finally {
            memoryStack.setPointer(n6);
        }
    }

    public static native void nglDebugMessageInsert(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glDebugMessageInsert(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GL43C.nglDebugMessageInsert(n2, n3, n4, n5, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glDebugMessageInsert(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum") int n5, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n6 = memoryStack.getPointer();
        try {
            int n7 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            GL43C.nglDebugMessageInsert(n2, n3, n4, n5, n7, l2);
        }
        finally {
            memoryStack.setPointer(n6);
        }
    }

    public static native void nglDebugMessageCallback(long var0, long var2);

    public static void glDebugMessageCallback(@Nullable @NativeType(value="GLDEBUGPROC") GLDebugMessageCallbackI gLDebugMessageCallbackI, @NativeType(value="void const *") long l2) {
        GL43C.nglDebugMessageCallback(MemoryUtil.memAddressSafe(gLDebugMessageCallbackI), l2);
    }

    public static native int nglGetDebugMessageLog(int var0, int var1, long var2, long var4, long var6, long var8, long var10, long var12);

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLog(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLenum *") IntBuffer intBuffer, @Nullable @NativeType(value="GLenum *") IntBuffer intBuffer2, @Nullable @NativeType(value="GLuint *") IntBuffer intBuffer3, @Nullable @NativeType(value="GLenum *") IntBuffer intBuffer4, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer5, @Nullable @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, n2);
            Checks.checkSafe((Buffer)intBuffer2, n2);
            Checks.checkSafe((Buffer)intBuffer3, n2);
            Checks.checkSafe((Buffer)intBuffer4, n2);
            Checks.checkSafe((Buffer)intBuffer5, n2);
        }
        return GL43C.nglGetDebugMessageLog(n2, Checks.remainingSafe(byteBuffer), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3), MemoryUtil.memAddressSafe(intBuffer4), MemoryUtil.memAddressSafe(intBuffer5), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static native void nglPushDebugGroup(int var0, int var1, int var2, long var3);

    public static void glPushDebugGroup(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GL43C.nglPushDebugGroup(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glPushDebugGroup(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            int n5 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            GL43C.nglPushDebugGroup(n2, n3, n5, l2);
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void glPopDebugGroup();

    public static native void nglObjectLabel(int var0, int var1, int var2, long var3);

    public static void glObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GL43C.nglObjectLabel(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            int n5 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            GL43C.nglObjectLabel(n2, n3, n5, l2);
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetObjectLabel(int var0, int var1, int var2, long var3, long var5);

    public static void glGetObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        GL43C.nglGetObjectLabel(n2, n3, byteBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @NativeType(value="GLsizei") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(0);
            ByteBuffer byteBuffer = memoryStack.malloc(n4);
            GL43C.nglGetObjectLabel(n2, n3, n4, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
            String string = MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
            return string;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    @NativeType(value="void")
    public static String glGetObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3) {
        return GL43C.glGetObjectLabel(n2, n3, GL11.glGetInteger(33512));
    }

    public static native void nglObjectPtrLabel(long var0, int var2, long var3);

    public static void glObjectPtrLabel(@NativeType(value="void *") long l2, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        GL43C.nglObjectPtrLabel(l2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glObjectPtrLabel(@NativeType(value="void *") long l2, @NativeType(value="GLchar const *") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            int n3 = memoryStack.nUTF8(charSequence, false);
            long l3 = memoryStack.getPointerAddress();
            GL43C.nglObjectPtrLabel(l2, n3, l3);
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nglGetObjectPtrLabel(long var0, int var2, long var3, long var5);

    public static void glGetObjectPtrLabel(@NativeType(value="void *") long l2, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        GL43C.nglGetObjectPtrLabel(l2, byteBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetObjectPtrLabel(@NativeType(value="void *") long l2, @NativeType(value="GLsizei") int n2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(0);
            ByteBuffer byteBuffer = memoryStack.malloc(n2);
            GL43C.nglGetObjectPtrLabel(l2, n2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
            String string = MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
            return string;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="void")
    public static String glGetObjectPtrLabel(@NativeType(value="void *") long l2) {
        return GL43C.glGetObjectPtrLabel(l2, GL11.glGetInteger(33512));
    }

    public static native void glFramebufferParameteri(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLint") int var2);

    public static native void nglGetFramebufferParameteriv(int var0, int var1, long var2);

    public static void glGetFramebufferParameteriv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL43C.nglGetFramebufferParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetFramebufferParameteri(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL43C.nglGetFramebufferParameteriv(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetInternalformati64v(int var0, int var1, int var2, int var3, long var4);

    public static void glGetInternalformati64v(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint64 *") LongBuffer longBuffer) {
        GL43C.nglGetInternalformati64v(n2, n3, n4, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static long glGetInternalformati64(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            LongBuffer longBuffer = memoryStack.callocLong(1);
            GL43C.nglGetInternalformati64v(n2, n3, n4, 1, MemoryUtil.memAddress(longBuffer));
            long l2 = longBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void glInvalidateTexSubImage(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLint") int var2, @NativeType(value="GLint") int var3, @NativeType(value="GLint") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLsizei") int var6, @NativeType(value="GLsizei") int var7);

    public static native void glInvalidateTexImage(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1);

    public static native void glInvalidateBufferSubData(@NativeType(value="GLuint") int var0, @NativeType(value="GLintptr") long var1, @NativeType(value="GLsizeiptr") long var3);

    public static native void glInvalidateBufferData(@NativeType(value="GLuint") int var0);

    public static native void nglInvalidateFramebuffer(int var0, int var1, long var2);

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer) {
        GL43C.nglInvalidateFramebuffer(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n3);
            GL43C.nglInvalidateFramebuffer(n2, 1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglInvalidateSubFramebuffer(int var0, int var1, long var2, int var4, int var5, int var6, int var7);

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") IntBuffer intBuffer, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        GL43C.nglInvalidateSubFramebuffer(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), n3, n4, n5, n6);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLint") int n5, @NativeType(value="GLsizei") int n6, @NativeType(value="GLsizei") int n7) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n8 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n3);
            GL43C.nglInvalidateSubFramebuffer(n2, 1, MemoryUtil.memAddress(intBuffer), n4, n5, n6, n7);
        }
        finally {
            memoryStack.setPointer(n8);
        }
    }

    public static native void nglMultiDrawArraysIndirect(int var0, long var1, int var3, int var4);

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n3 * (n4 == 0 ? 16 : n4));
        }
        GL43C.nglMultiDrawArraysIndirect(n2, MemoryUtil.memAddress(byteBuffer), n3, n4);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        GL43C.nglMultiDrawArraysIndirect(n2, l2, n3, n4);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, n3 * (n4 == 0 ? 16 : n4) >> 2);
        }
        GL43C.nglMultiDrawArraysIndirect(n2, MemoryUtil.memAddress(intBuffer), n3, n4);
    }

    public static native void nglMultiDrawElementsIndirect(int var0, int var1, long var2, int var4, int var5);

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") ByteBuffer byteBuffer, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n4 * (n5 == 0 ? 20 : n5));
        }
        GL43C.nglMultiDrawElementsIndirect(n2, n3, MemoryUtil.memAddress(byteBuffer), n4, n5);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") long l2, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        GL43C.nglMultiDrawElementsIndirect(n2, n3, l2, n4, n5);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") IntBuffer intBuffer, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, n4 * (n5 == 0 ? 20 : n5) >> 2);
        }
        GL43C.nglMultiDrawElementsIndirect(n2, n3, MemoryUtil.memAddress(intBuffer), n4, n5);
    }

    public static native void nglGetProgramInterfaceiv(int var0, int var1, int var2, long var3);

    public static void glGetProgramInterfaceiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        GL43C.nglGetProgramInterfaceiv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static int glGetProgramInterfacei(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            GL43C.nglGetProgramInterfaceiv(n2, n3, n4, MemoryUtil.memAddress(intBuffer));
            int n6 = intBuffer.get(0);
            return n6;
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native int nglGetProgramResourceIndex(int var0, int var1, long var2);

    @NativeType(value="GLuint")
    public static int glGetProgramResourceIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return GL43C.nglGetProgramResourceIndex(n2, n3, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLuint")
    public static int glGetProgramResourceIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n5 = GL43C.nglGetProgramResourceIndex(n2, n3, l2);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nglGetProgramResourceName(int var0, int var1, int var2, int var3, long var4, long var6);

    public static void glGetProgramResourceName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        GL43C.nglGetProgramResourceName(n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void")
    public static String glGetProgramResourceName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLsizei") int n5) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n6 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(0);
            ByteBuffer byteBuffer = memoryStack.malloc(n5);
            GL43C.nglGetProgramResourceName(n2, n3, n4, n5, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
            String string = MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
            return string;
        }
        finally {
            memoryStack.setPointer(n6);
        }
    }

    @NativeType(value="void")
    public static String glGetProgramResourceName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4) {
        return GL43C.glGetProgramResourceName(n2, n3, n4, GL43C.glGetProgramInterfacei(n2, n3, 37622));
    }

    public static native void nglGetProgramResourceiv(int var0, int var1, int var2, int var3, long var4, int var6, long var7, long var9);

    public static void glGetProgramResourceiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum const *") IntBuffer intBuffer, @Nullable @NativeType(value="GLsizei *") IntBuffer intBuffer2, @NativeType(value="GLint *") IntBuffer intBuffer3) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer2, 1);
        }
        GL43C.nglGetProgramResourceiv(n2, n3, n4, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), intBuffer3.remaining(), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddress(intBuffer3));
    }

    public static native int nglGetProgramResourceLocation(int var0, int var1, long var2);

    @NativeType(value="GLint")
    public static int glGetProgramResourceLocation(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return GL43C.nglGetProgramResourceLocation(n2, n3, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetProgramResourceLocation(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n5 = GL43C.nglGetProgramResourceLocation(n2, n3, l2);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native int nglGetProgramResourceLocationIndex(int var0, int var1, long var2);

    @NativeType(value="GLint")
    public static int glGetProgramResourceLocationIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return GL43C.nglGetProgramResourceLocationIndex(n2, n3, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLint")
    public static int glGetProgramResourceLocationIndex(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n5 = GL43C.nglGetProgramResourceLocationIndex(n2, n3, l2);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void glShaderStorageBlockBinding(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLuint") int var2);

    public static native void glTexBufferRange(@NativeType(value="GLenum") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLintptr") long var3, @NativeType(value="GLsizeiptr") long var5);

    public static native void glTexStorage2DMultisample(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLboolean") boolean var5);

    public static native void glTexStorage3DMultisample(@NativeType(value="GLenum") int var0, @NativeType(value="GLsizei") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLsizei") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLsizei") int var5, @NativeType(value="GLboolean") boolean var6);

    public static native void glTextureView(@NativeType(value="GLuint") int var0, @NativeType(value="GLenum") int var1, @NativeType(value="GLuint") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLuint") int var4, @NativeType(value="GLuint") int var5, @NativeType(value="GLuint") int var6, @NativeType(value="GLuint") int var7);

    public static native void glBindVertexBuffer(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1, @NativeType(value="GLintptr") long var2, @NativeType(value="GLsizei") int var4);

    public static native void glVertexAttribFormat(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLboolean") boolean var3, @NativeType(value="GLuint") int var4);

    public static native void glVertexAttribIFormat(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void glVertexAttribLFormat(@NativeType(value="GLuint") int var0, @NativeType(value="GLint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLuint") int var3);

    public static native void glVertexAttribBinding(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static native void glVertexBindingDivisor(@NativeType(value="GLuint") int var0, @NativeType(value="GLuint") int var1);

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l2 = GL.getICD().glClearBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, sArray, l2);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l2 = GL.getICD().glClearBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, nArray, l2);
    }

    public static void glClearBufferData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l2 = GL.getICD().glClearBufferData;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, n5, fArray, l2);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") short[] sArray) {
        long l4 = GL.getICD().glClearBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.callPPPV(n2, n3, l2, l3, n4, n5, sArray, l4);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") int[] nArray) {
        long l4 = GL.getICD().glClearBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.callPPPV(n2, n3, l2, l3, n4, n5, nArray, l4);
    }

    public static void glClearBufferSubData(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLenum") int n4, @NativeType(value="GLenum") int n5, @Nullable @NativeType(value="void const *") float[] fArray) {
        long l4 = GL.getICD().glClearBufferSubData;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.callPPPV(n2, n3, l2, l3, n4, n5, fArray, l4);
    }

    public static void glDebugMessageControl(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @Nullable @NativeType(value="GLuint const *") int[] nArray, @NativeType(value="GLboolean") boolean bl2) {
        long l2 = GL.getICD().glDebugMessageControl;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, Checks.lengthSafe(nArray), nArray, bl2, l2);
    }

    @NativeType(value="GLuint")
    public static int glGetDebugMessageLog(@NativeType(value="GLuint") int n2, @Nullable @NativeType(value="GLenum *") int[] nArray, @Nullable @NativeType(value="GLenum *") int[] nArray2, @Nullable @NativeType(value="GLuint *") int[] nArray3, @Nullable @NativeType(value="GLenum *") int[] nArray4, @Nullable @NativeType(value="GLsizei *") int[] nArray5, @Nullable @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetDebugMessageLog;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, n2);
            Checks.checkSafe(nArray2, n2);
            Checks.checkSafe(nArray3, n2);
            Checks.checkSafe(nArray4, n2);
            Checks.checkSafe(nArray5, n2);
        }
        return JNI.callPPPPPPI(n2, Checks.remainingSafe(byteBuffer), nArray, nArray2, nArray3, nArray4, nArray5, MemoryUtil.memAddressSafe(byteBuffer), l2);
    }

    public static void glGetObjectLabel(@NativeType(value="GLenum") int n2, @NativeType(value="GLuint") int n3, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetObjectLabel;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPV(n2, n3, byteBuffer.remaining(), nArray, MemoryUtil.memAddress(byteBuffer), l2);
    }

    public static void glGetObjectPtrLabel(@NativeType(value="void *") long l2, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l3 = GL.getICD().glGetObjectPtrLabel;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPPV(l2, byteBuffer.remaining(), nArray, MemoryUtil.memAddress(byteBuffer), l3);
    }

    public static void glGetFramebufferParameteriv(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetFramebufferParameteriv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, nArray, l2);
    }

    public static void glGetInternalformati64v(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint64 *") long[] lArray) {
        long l2 = GL.getICD().glGetInternalformati64v;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, n3, n4, lArray.length, lArray, l2);
    }

    public static void glInvalidateFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") int[] nArray) {
        long l2 = GL.getICD().glInvalidateFramebuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, l2);
    }

    public static void glInvalidateSubFramebuffer(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum const *") int[] nArray, @NativeType(value="GLint") int n3, @NativeType(value="GLint") int n4, @NativeType(value="GLsizei") int n5, @NativeType(value="GLsizei") int n6) {
        long l2 = GL.getICD().glInvalidateSubFramebuffer;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.callPV(n2, nArray.length, nArray, n3, n4, n5, n6, l2);
    }

    public static void glMultiDrawArraysIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLsizei") int n3, @NativeType(value="GLsizei") int n4) {
        long l2 = GL.getICD().glMultiDrawArraysIndirect;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, n3 * (n4 == 0 ? 16 : n4) >> 2);
        }
        JNI.callPV(n2, nArray, n3, n4, l2);
    }

    public static void glMultiDrawElementsIndirect(@NativeType(value="GLenum") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="void const *") int[] nArray, @NativeType(value="GLsizei") int n4, @NativeType(value="GLsizei") int n5) {
        long l2 = GL.getICD().glMultiDrawElementsIndirect;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, n4 * (n5 == 0 ? 20 : n5) >> 2);
        }
        JNI.callPV(n2, n3, nArray, n4, n5, l2);
    }

    public static void glGetProgramInterfaceiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLenum") int n4, @NativeType(value="GLint *") int[] nArray) {
        long l2 = GL.getICD().glGetProgramInterfaceiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(nArray, 1);
        }
        JNI.callPV(n2, n3, n4, nArray, l2);
    }

    public static void glGetProgramResourceName(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @Nullable @NativeType(value="GLsizei *") int[] nArray, @NativeType(value="GLchar *") ByteBuffer byteBuffer) {
        long l2 = GL.getICD().glGetProgramResourceName;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray, 1);
        }
        JNI.callPPV(n2, n3, n4, byteBuffer.remaining(), nArray, MemoryUtil.memAddress(byteBuffer), l2);
    }

    public static void glGetProgramResourceiv(@NativeType(value="GLuint") int n2, @NativeType(value="GLenum") int n3, @NativeType(value="GLuint") int n4, @NativeType(value="GLenum const *") int[] nArray, @Nullable @NativeType(value="GLsizei *") int[] nArray2, @NativeType(value="GLint *") int[] nArray3) {
        long l2 = GL.getICD().glGetProgramResourceiv;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.checkSafe(nArray2, 1);
        }
        JNI.callPPPV(n2, n3, n4, nArray.length, nArray, nArray3.length, nArray2, nArray3, l2);
    }

    static {
        GL.initialize();
    }
}

