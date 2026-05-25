/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.openal.AL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTStaticBuffer {
    protected EXTStaticBuffer() {
        throw new UnsupportedOperationException();
    }

    public static void nalBufferDataStatic(int n2, int n3, long l2, int n4, int n5) {
        long l3 = AL.getICD().alBufferDataStatic;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePV(n2, n3, l2, n4, n5, l3);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid *") ByteBuffer byteBuffer, @NativeType(value="ALsizei") int n4) {
        EXTStaticBuffer.nalBufferDataStatic(n2, n3, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n4);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid *") ShortBuffer shortBuffer, @NativeType(value="ALsizei") int n4) {
        EXTStaticBuffer.nalBufferDataStatic(n2, n3, MemoryUtil.memAddress(shortBuffer), shortBuffer.remaining() << 1, n4);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid *") IntBuffer intBuffer, @NativeType(value="ALsizei") int n4) {
        EXTStaticBuffer.nalBufferDataStatic(n2, n3, MemoryUtil.memAddress(intBuffer), intBuffer.remaining() << 2, n4);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid *") FloatBuffer floatBuffer, @NativeType(value="ALsizei") int n4) {
        EXTStaticBuffer.nalBufferDataStatic(n2, n3, MemoryUtil.memAddress(floatBuffer), floatBuffer.remaining() << 2, n4);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid *") short[] sArray, @NativeType(value="ALsizei") int n4) {
        long l2 = AL.getICD().alBufferDataStatic;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n2, n3, sArray, sArray.length << 1, n4, l2);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid *") int[] nArray, @NativeType(value="ALsizei") int n4) {
        long l2 = AL.getICD().alBufferDataStatic;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n2, n3, nArray, nArray.length << 2, n4, l2);
    }

    @NativeType(value="ALvoid")
    public static void alBufferDataStatic(@NativeType(value="ALint") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALvoid *") float[] fArray, @NativeType(value="ALsizei") int n4) {
        long l2 = AL.getICD().alBufferDataStatic;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n2, n3, fArray, fArray.length << 2, n4, l2);
    }
}

