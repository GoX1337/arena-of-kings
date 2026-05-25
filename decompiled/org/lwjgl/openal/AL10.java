/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.openal.AL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class AL10 {
    public static final int AL_INVALID = -1;
    public static final int AL_NONE = 0;
    public static final int AL_FALSE = 0;
    public static final int AL_TRUE = 1;
    public static final int AL_NO_ERROR = 0;
    public static final int AL_INVALID_NAME = 40961;
    public static final int AL_INVALID_ENUM = 40962;
    public static final int AL_INVALID_VALUE = 40963;
    public static final int AL_INVALID_OPERATION = 40964;
    public static final int AL_OUT_OF_MEMORY = 40965;
    public static final int AL_DOPPLER_FACTOR = 49152;
    public static final int AL_DISTANCE_MODEL = 53248;
    public static final int AL_VENDOR = 45057;
    public static final int AL_VERSION = 45058;
    public static final int AL_RENDERER = 45059;
    public static final int AL_EXTENSIONS = 45060;
    public static final int AL_INVERSE_DISTANCE = 53249;
    public static final int AL_INVERSE_DISTANCE_CLAMPED = 53250;
    public static final int AL_SOURCE_ABSOLUTE = 513;
    public static final int AL_SOURCE_RELATIVE = 514;
    public static final int AL_POSITION = 4100;
    public static final int AL_VELOCITY = 4102;
    public static final int AL_GAIN = 4106;
    public static final int AL_CONE_INNER_ANGLE = 4097;
    public static final int AL_CONE_OUTER_ANGLE = 4098;
    public static final int AL_PITCH = 4099;
    public static final int AL_DIRECTION = 4101;
    public static final int AL_LOOPING = 4103;
    public static final int AL_BUFFER = 4105;
    public static final int AL_SOURCE_STATE = 4112;
    public static final int AL_CONE_OUTER_GAIN = 4130;
    public static final int AL_SOURCE_TYPE = 4135;
    public static final int AL_INITIAL = 4113;
    public static final int AL_PLAYING = 4114;
    public static final int AL_PAUSED = 4115;
    public static final int AL_STOPPED = 4116;
    public static final int AL_ORIENTATION = 4111;
    public static final int AL_BUFFERS_QUEUED = 4117;
    public static final int AL_BUFFERS_PROCESSED = 4118;
    public static final int AL_MIN_GAIN = 4109;
    public static final int AL_MAX_GAIN = 4110;
    public static final int AL_REFERENCE_DISTANCE = 4128;
    public static final int AL_ROLLOFF_FACTOR = 4129;
    public static final int AL_MAX_DISTANCE = 4131;
    public static final int AL_FREQUENCY = 8193;
    public static final int AL_BITS = 8194;
    public static final int AL_CHANNELS = 8195;
    public static final int AL_SIZE = 8196;
    public static final int AL_FORMAT_MONO8 = 4352;
    public static final int AL_FORMAT_MONO16 = 4353;
    public static final int AL_FORMAT_STEREO8 = 4354;
    public static final int AL_FORMAT_STEREO16 = 4355;
    public static final int AL_UNUSED = 8208;
    public static final int AL_PENDING = 8209;
    public static final int AL_PROCESSED = 8210;

    protected AL10() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="ALenum")
    public static int alGetError() {
        long l2 = AL.getICD().alGetError;
        return JNI.invokeI(l2);
    }

    @NativeType(value="ALvoid")
    public static void alEnable(@NativeType(value="ALenum") int n2) {
        long l2 = AL.getICD().alEnable;
        JNI.invokeV(n2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alDisable(@NativeType(value="ALenum") int n2) {
        long l2 = AL.getICD().alDisable;
        JNI.invokeV(n2, l2);
    }

    @NativeType(value="ALboolean")
    public static boolean alIsEnabled(@NativeType(value="ALenum") int n2) {
        long l2 = AL.getICD().alIsEnabled;
        return JNI.invokeZ(n2, l2);
    }

    @NativeType(value="ALboolean")
    public static boolean alGetBoolean(@NativeType(value="ALenum") int n2) {
        long l2 = AL.getICD().alGetBoolean;
        return JNI.invokeZ(n2, l2);
    }

    @NativeType(value="ALint")
    public static int alGetInteger(@NativeType(value="ALenum") int n2) {
        long l2 = AL.getICD().alGetInteger;
        return JNI.invokeI(n2, l2);
    }

    @NativeType(value="ALfloat")
    public static float alGetFloat(@NativeType(value="ALenum") int n2) {
        long l2 = AL.getICD().alGetFloat;
        return JNI.invokeF(n2, l2);
    }

    @NativeType(value="ALdouble")
    public static double alGetDouble(@NativeType(value="ALenum") int n2) {
        long l2 = AL.getICD().alGetDouble;
        return JNI.invokeD(n2, l2);
    }

    public static void nalGetBooleanv(int n2, long l2) {
        long l3 = AL.getICD().alGetBooleanv;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetBooleanv(@NativeType(value="ALenum") int n2, @NativeType(value="ALboolean *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, 1);
        }
        AL10.nalGetBooleanv(n2, MemoryUtil.memAddress(byteBuffer));
    }

    public static void nalGetIntegerv(int n2, long l2) {
        long l3 = AL.getICD().alGetIntegerv;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetIntegerv(@NativeType(value="ALenum") int n2, @NativeType(value="ALint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AL10.nalGetIntegerv(n2, MemoryUtil.memAddress(intBuffer));
    }

    public static void nalGetFloatv(int n2, long l2) {
        long l3 = AL.getICD().alGetFloatv;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetFloatv(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AL10.nalGetFloatv(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void nalGetDoublev(int n2, long l2) {
        long l3 = AL.getICD().alGetDoublev;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetDoublev(@NativeType(value="ALenum") int n2, @NativeType(value="ALdouble *") DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer, 1);
        }
        AL10.nalGetDoublev(n2, MemoryUtil.memAddress(doubleBuffer));
    }

    public static long nalGetString(int n2) {
        long l2 = AL.getICD().alGetString;
        return JNI.invokeP(n2, l2);
    }

    @Nullable
    @NativeType(value="ALchar const *")
    public static String alGetString(@NativeType(value="ALenum") int n2) {
        long l2 = AL10.nalGetString(n2);
        return MemoryUtil.memUTF8Safe(l2);
    }

    @NativeType(value="ALvoid")
    public static void alDistanceModel(@NativeType(value="ALenum") int n2) {
        long l2 = AL.getICD().alDistanceModel;
        JNI.invokeV(n2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alDopplerFactor(@NativeType(value="ALfloat") float f2) {
        long l2 = AL.getICD().alDopplerFactor;
        JNI.invokeV(f2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alDopplerVelocity(@NativeType(value="ALfloat") float f2) {
        long l2 = AL.getICD().alDopplerVelocity;
        JNI.invokeV(f2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alListenerf(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat") float f2) {
        long l2 = AL.getICD().alListenerf;
        JNI.invokeV(n2, f2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alListeneri(@NativeType(value="ALenum") int n2, @NativeType(value="ALint") int n3) {
        long l2 = AL.getICD().alListeneri;
        JNI.invokeV(n2, n3, l2);
    }

    @NativeType(value="ALvoid")
    public static void alListener3f(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat") float f2, @NativeType(value="ALfloat") float f3, @NativeType(value="ALfloat") float f4) {
        long l2 = AL.getICD().alListener3f;
        JNI.invokeV(n2, f2, f3, f4, l2);
    }

    public static void nalListenerfv(int n2, long l2) {
        long l3 = AL.getICD().alListenerfv;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alListenerfv(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AL10.nalListenerfv(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void nalGetListenerf(int n2, long l2) {
        long l3 = AL.getICD().alGetListenerf;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetListenerf(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AL10.nalGetListenerf(n2, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static float alGetListenerf(@NativeType(value="ALenum") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            AL10.nalGetListenerf(n2, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void nalGetListeneri(int n2, long l2) {
        long l3 = AL.getICD().alGetListeneri;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetListeneri(@NativeType(value="ALenum") int n2, @NativeType(value="ALint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AL10.nalGetListeneri(n2, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alGetListeneri(@NativeType(value="ALenum") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            AL10.nalGetListeneri(n2, MemoryUtil.memAddress(intBuffer));
            int n4 = intBuffer.get(0);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void nalGetListener3f(int n2, long l2, long l3, long l4) {
        long l5 = AL.getICD().alGetListener3f;
        JNI.invokePPPV(n2, l2, l3, l4, l5);
    }

    @NativeType(value="ALvoid")
    public static void alGetListener3f(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat *") FloatBuffer floatBuffer, @NativeType(value="ALfloat *") FloatBuffer floatBuffer2, @NativeType(value="ALfloat *") FloatBuffer floatBuffer3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
            Checks.check((Buffer)floatBuffer2, 1);
            Checks.check((Buffer)floatBuffer3, 1);
        }
        AL10.nalGetListener3f(n2, MemoryUtil.memAddress(floatBuffer), MemoryUtil.memAddress(floatBuffer2), MemoryUtil.memAddress(floatBuffer3));
    }

    public static void nalGetListenerfv(int n2, long l2) {
        long l3 = AL.getICD().alGetListenerfv;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetListenerfv(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AL10.nalGetListenerfv(n2, MemoryUtil.memAddress(floatBuffer));
    }

    public static void nalGenSources(int n2, long l2) {
        long l3 = AL.getICD().alGenSources;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGenSources(@NativeType(value="ALuint *") IntBuffer intBuffer) {
        AL10.nalGenSources(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alGenSources() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            AL10.nalGenSources(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static void nalDeleteSources(int n2, long l2) {
        long l3 = AL.getICD().alDeleteSources;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alDeleteSources(@NativeType(value="ALuint *") IntBuffer intBuffer) {
        AL10.nalDeleteSources(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alDeleteSources(@NativeType(value="ALuint *") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n2);
            AL10.nalDeleteSources(1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="ALboolean")
    public static boolean alIsSource(@NativeType(value="ALuint") int n2) {
        long l2 = AL.getICD().alIsSource;
        return JNI.invokeZ(n2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourcef(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat") float f2) {
        long l2 = AL.getICD().alSourcef;
        JNI.invokeV(n2, n3, f2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSource3f(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat") float f2, @NativeType(value="ALfloat") float f3, @NativeType(value="ALfloat") float f4) {
        long l2 = AL.getICD().alSource3f;
        JNI.invokeV(n2, n3, f2, f3, f4, l2);
    }

    public static void nalSourcefv(int n2, int n3, long l2) {
        long l3 = AL.getICD().alSourcefv;
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSourcefv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat const *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AL10.nalSourcefv(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    @NativeType(value="ALvoid")
    public static void alSourcei(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint") int n4) {
        long l2 = AL.getICD().alSourcei;
        JNI.invokeV(n2, n3, n4, l2);
    }

    public static void nalGetSourcef(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetSourcef;
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcef(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AL10.nalGetSourcef(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static float alGetSourcef(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            AL10.nalGetSourcef(n2, n3, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void nalGetSource3f(int n2, int n3, long l2, long l3, long l4) {
        long l5 = AL.getICD().alGetSource3f;
        JNI.invokePPPV(n2, n3, l2, l3, l4, l5);
    }

    @NativeType(value="ALvoid")
    public static void alGetSource3f(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat *") FloatBuffer floatBuffer, @NativeType(value="ALfloat *") FloatBuffer floatBuffer2, @NativeType(value="ALfloat *") FloatBuffer floatBuffer3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
            Checks.check((Buffer)floatBuffer2, 1);
            Checks.check((Buffer)floatBuffer3, 1);
        }
        AL10.nalGetSource3f(n2, n3, MemoryUtil.memAddress(floatBuffer), MemoryUtil.memAddress(floatBuffer2), MemoryUtil.memAddress(floatBuffer3));
    }

    public static void nalGetSourcefv(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetSourcefv;
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcefv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AL10.nalGetSourcefv(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    public static void nalGetSourcei(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetSourcei;
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcei(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AL10.nalGetSourcei(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alGetSourcei(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            AL10.nalGetSourcei(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void nalGetSourceiv(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetSourceiv;
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourceiv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AL10.nalGetSourceiv(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    public static void nalSourceQueueBuffers(int n2, int n3, long l2) {
        long l3 = AL.getICD().alSourceQueueBuffers;
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSourceQueueBuffers(@NativeType(value="ALuint") int n2, @NativeType(value="ALuint *") IntBuffer intBuffer) {
        AL10.nalSourceQueueBuffers(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alSourceQueueBuffers(@NativeType(value="ALuint") int n2, @NativeType(value="ALuint *") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n3);
            AL10.nalSourceQueueBuffers(n2, 1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void nalSourceUnqueueBuffers(int n2, int n3, long l2) {
        long l3 = AL.getICD().alSourceUnqueueBuffers;
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSourceUnqueueBuffers(@NativeType(value="ALuint") int n2, @NativeType(value="ALuint *") IntBuffer intBuffer) {
        AL10.nalSourceUnqueueBuffers(n2, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alSourceUnqueueBuffers(@NativeType(value="ALuint") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            AL10.nalSourceUnqueueBuffers(n2, 1, MemoryUtil.memAddress(intBuffer));
            int n4 = intBuffer.get(0);
            return n4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="ALvoid")
    public static void alSourcePlay(@NativeType(value="ALuint") int n2) {
        long l2 = AL.getICD().alSourcePlay;
        JNI.invokeV(n2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourcePause(@NativeType(value="ALuint") int n2) {
        long l2 = AL.getICD().alSourcePause;
        JNI.invokeV(n2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourceStop(@NativeType(value="ALuint") int n2) {
        long l2 = AL.getICD().alSourceStop;
        JNI.invokeV(n2, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourceRewind(@NativeType(value="ALuint") int n2) {
        long l2 = AL.getICD().alSourceRewind;
        JNI.invokeV(n2, l2);
    }

    public static void nalSourcePlayv(int n2, long l2) {
        long l3 = AL.getICD().alSourcePlayv;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSourcePlayv(@NativeType(value="ALuint const *") IntBuffer intBuffer) {
        AL10.nalSourcePlayv(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static void nalSourcePausev(int n2, long l2) {
        long l3 = AL.getICD().alSourcePausev;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSourcePausev(@NativeType(value="ALuint const *") IntBuffer intBuffer) {
        AL10.nalSourcePausev(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static void nalSourceStopv(int n2, long l2) {
        long l3 = AL.getICD().alSourceStopv;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSourceStopv(@NativeType(value="ALuint const *") IntBuffer intBuffer) {
        AL10.nalSourceStopv(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static void nalSourceRewindv(int n2, long l2) {
        long l3 = AL.getICD().alSourceRewindv;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alSourceRewindv(@NativeType(value="ALuint const *") IntBuffer intBuffer) {
        AL10.nalSourceRewindv(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static void nalGenBuffers(int n2, long l2) {
        long l3 = AL.getICD().alGenBuffers;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGenBuffers(@NativeType(value="ALuint *") IntBuffer intBuffer) {
        AL10.nalGenBuffers(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alGenBuffers() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            AL10.nalGenBuffers(1, MemoryUtil.memAddress(intBuffer));
            int n3 = intBuffer.get(0);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static void nalDeleteBuffers(int n2, long l2) {
        long l3 = AL.getICD().alDeleteBuffers;
        JNI.invokePV(n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alDeleteBuffers(@NativeType(value="ALuint const *") IntBuffer intBuffer) {
        AL10.nalDeleteBuffers(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alDeleteBuffers(@NativeType(value="ALuint const *") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.ints(n2);
            AL10.nalDeleteBuffers(1, MemoryUtil.memAddress(intBuffer));
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="ALboolean")
    public static boolean alIsBuffer(@NativeType(value="ALuint") int n2) {
        long l2 = AL.getICD().alIsBuffer;
        return JNI.invokeZ(n2, l2);
    }

    public static void nalGetBufferf(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetBufferf;
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferf(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat *") FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer, 1);
        }
        AL10.nalGetBufferf(n2, n3, MemoryUtil.memAddress(floatBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static float alGetBufferf(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            FloatBuffer floatBuffer = memoryStack.callocFloat(1);
            AL10.nalGetBufferf(n2, n3, MemoryUtil.memAddress(floatBuffer));
            float f2 = floatBuffer.get(0);
            return f2;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void nalGetBufferi(int n2, int n3, long l2) {
        long l3 = AL.getICD().alGetBufferi;
        JNI.invokePV(n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferi(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        AL10.nalGetBufferi(n2, n3, MemoryUtil.memAddress(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static int alGetBufferi(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            IntBuffer intBuffer = memoryStack.callocInt(1);
            AL10.nalGetBufferi(n2, n3, MemoryUtil.memAddress(intBuffer));
            int n5 = intBuffer.get(0);
            return n5;
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static void nalBufferData(int n2, int n3, long l2, int n4, int n5) {
        long l3 = AL.getICD().alBufferData;
        JNI.invokePV(n2, n3, l2, n4, n5, l3);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") ByteBuffer byteBuffer, @NativeType(value="ALsizei") int n4) {
        AL10.nalBufferData(n2, n3, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n4);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") ShortBuffer shortBuffer, @NativeType(value="ALsizei") int n4) {
        AL10.nalBufferData(n2, n3, MemoryUtil.memAddress(shortBuffer), shortBuffer.remaining() << 1, n4);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") IntBuffer intBuffer, @NativeType(value="ALsizei") int n4) {
        AL10.nalBufferData(n2, n3, MemoryUtil.memAddress(intBuffer), intBuffer.remaining() << 2, n4);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") FloatBuffer floatBuffer, @NativeType(value="ALsizei") int n4) {
        AL10.nalBufferData(n2, n3, MemoryUtil.memAddress(floatBuffer), floatBuffer.remaining() << 2, n4);
    }

    public static int nalGetEnumValue(long l2) {
        long l3 = AL.getICD().alGetEnumValue;
        return JNI.invokePI(l2, l3);
    }

    @NativeType(value="ALuint")
    public static int alGetEnumValue(@NativeType(value="ALchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return AL10.nalGetEnumValue(MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALuint")
    public static int alGetEnumValue(@NativeType(value="ALchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n3 = AL10.nalGetEnumValue(l2);
            return n3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static long nalGetProcAddress(long l2) {
        long l3 = AL.getICD().alGetProcAddress;
        return JNI.invokePP(l2, l3);
    }

    @NativeType(value="void *")
    public static long alGetProcAddress(@NativeType(value="ALchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return AL10.nalGetProcAddress(MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long alGetProcAddress(@NativeType(value="ALchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            long l3 = AL10.nalGetProcAddress(l2);
            return l3;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static boolean nalIsExtensionPresent(long l2) {
        long l3 = AL.getICD().alIsExtensionPresent;
        return JNI.invokePZ(l2, l3);
    }

    @NativeType(value="ALCboolean")
    public static boolean alIsExtensionPresent(@NativeType(value="ALchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return AL10.nalIsExtensionPresent(MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCboolean")
    public static boolean alIsExtensionPresent(@NativeType(value="ALchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            boolean bl2 = AL10.nalIsExtensionPresent(l2);
            return bl2;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    @NativeType(value="ALvoid")
    public static void alGetIntegerv(@NativeType(value="ALenum") int n2, @NativeType(value="ALint *") int[] nArray) {
        long l2 = AL.getICD().alGetIntegerv;
        if (Checks.CHECKS) {
            Checks.check(nArray, 1);
        }
        JNI.invokePV(n2, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetFloatv(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat *") float[] fArray) {
        long l2 = AL.getICD().alGetFloatv;
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
        }
        JNI.invokePV(n2, fArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetDoublev(@NativeType(value="ALenum") int n2, @NativeType(value="ALdouble *") double[] dArray) {
        long l2 = AL.getICD().alGetDoublev;
        if (Checks.CHECKS) {
            Checks.check(dArray, 1);
        }
        JNI.invokePV(n2, dArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alListenerfv(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat const *") float[] fArray) {
        long l2 = AL.getICD().alListenerfv;
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
        }
        JNI.invokePV(n2, fArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetListenerf(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat *") float[] fArray) {
        long l2 = AL.getICD().alGetListenerf;
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
        }
        JNI.invokePV(n2, fArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetListeneri(@NativeType(value="ALenum") int n2, @NativeType(value="ALint *") int[] nArray) {
        long l2 = AL.getICD().alGetListeneri;
        if (Checks.CHECKS) {
            Checks.check(nArray, 1);
        }
        JNI.invokePV(n2, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetListener3f(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat *") float[] fArray, @NativeType(value="ALfloat *") float[] fArray2, @NativeType(value="ALfloat *") float[] fArray3) {
        long l2 = AL.getICD().alGetListener3f;
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
            Checks.check(fArray2, 1);
            Checks.check(fArray3, 1);
        }
        JNI.invokePPPV(n2, fArray, fArray2, fArray3, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetListenerfv(@NativeType(value="ALenum") int n2, @NativeType(value="ALfloat *") float[] fArray) {
        long l2 = AL.getICD().alGetListenerfv;
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
        }
        JNI.invokePV(n2, fArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGenSources(@NativeType(value="ALuint *") int[] nArray) {
        long l2 = AL.getICD().alGenSources;
        JNI.invokePV(nArray.length, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alDeleteSources(@NativeType(value="ALuint *") int[] nArray) {
        long l2 = AL.getICD().alDeleteSources;
        JNI.invokePV(nArray.length, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourcefv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat const *") float[] fArray) {
        long l2 = AL.getICD().alSourcefv;
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
        }
        JNI.invokePV(n2, n3, fArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcef(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat *") float[] fArray) {
        long l2 = AL.getICD().alGetSourcef;
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
        }
        JNI.invokePV(n2, n3, fArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSource3f(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat *") float[] fArray, @NativeType(value="ALfloat *") float[] fArray2, @NativeType(value="ALfloat *") float[] fArray3) {
        long l2 = AL.getICD().alGetSource3f;
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
            Checks.check(fArray2, 1);
            Checks.check(fArray3, 1);
        }
        JNI.invokePPPV(n2, n3, fArray, fArray2, fArray3, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcefv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat *") float[] fArray) {
        long l2 = AL.getICD().alGetSourcefv;
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
        }
        JNI.invokePV(n2, n3, fArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourcei(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint *") int[] nArray) {
        long l2 = AL.getICD().alGetSourcei;
        if (Checks.CHECKS) {
            Checks.check(nArray, 1);
        }
        JNI.invokePV(n2, n3, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetSourceiv(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint *") int[] nArray) {
        long l2 = AL.getICD().alGetSourceiv;
        if (Checks.CHECKS) {
            Checks.check(nArray, 1);
        }
        JNI.invokePV(n2, n3, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourceQueueBuffers(@NativeType(value="ALuint") int n2, @NativeType(value="ALuint *") int[] nArray) {
        long l2 = AL.getICD().alSourceQueueBuffers;
        JNI.invokePV(n2, nArray.length, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourceUnqueueBuffers(@NativeType(value="ALuint") int n2, @NativeType(value="ALuint *") int[] nArray) {
        long l2 = AL.getICD().alSourceUnqueueBuffers;
        JNI.invokePV(n2, nArray.length, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourcePlayv(@NativeType(value="ALuint const *") int[] nArray) {
        long l2 = AL.getICD().alSourcePlayv;
        JNI.invokePV(nArray.length, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourcePausev(@NativeType(value="ALuint const *") int[] nArray) {
        long l2 = AL.getICD().alSourcePausev;
        JNI.invokePV(nArray.length, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourceStopv(@NativeType(value="ALuint const *") int[] nArray) {
        long l2 = AL.getICD().alSourceStopv;
        JNI.invokePV(nArray.length, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alSourceRewindv(@NativeType(value="ALuint const *") int[] nArray) {
        long l2 = AL.getICD().alSourceRewindv;
        JNI.invokePV(nArray.length, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGenBuffers(@NativeType(value="ALuint *") int[] nArray) {
        long l2 = AL.getICD().alGenBuffers;
        JNI.invokePV(nArray.length, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alDeleteBuffers(@NativeType(value="ALuint const *") int[] nArray) {
        long l2 = AL.getICD().alDeleteBuffers;
        JNI.invokePV(nArray.length, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferf(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALfloat *") float[] fArray) {
        long l2 = AL.getICD().alGetBufferf;
        if (Checks.CHECKS) {
            Checks.check(fArray, 1);
        }
        JNI.invokePV(n2, n3, fArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferi(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALint *") int[] nArray) {
        long l2 = AL.getICD().alGetBufferi;
        if (Checks.CHECKS) {
            Checks.check(nArray, 1);
        }
        JNI.invokePV(n2, n3, nArray, l2);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") short[] sArray, @NativeType(value="ALsizei") int n4) {
        long l2 = AL.getICD().alBufferData;
        JNI.invokePV(n2, n3, sArray, sArray.length << 1, n4, l2);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") int[] nArray, @NativeType(value="ALsizei") int n4) {
        long l2 = AL.getICD().alBufferData;
        JNI.invokePV(n2, n3, nArray, nArray.length << 2, n4, l2);
    }

    @NativeType(value="ALvoid")
    public static void alBufferData(@NativeType(value="ALuint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid const *") float[] fArray, @NativeType(value="ALsizei") int n4) {
        long l2 = AL.getICD().alBufferData;
        JNI.invokePV(n2, n3, fArray, fArray.length << 2, n4, l2);
    }
}

