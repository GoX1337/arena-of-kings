/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CheckIntrinsics;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.FunctionProviderLocal;

public final class Checks {
    public static final boolean CHECKS = Configuration.DISABLE_CHECKS.get(false) == false;
    public static final boolean DEBUG = Configuration.DEBUG.get(false);
    public static final boolean DEBUG_FUNCTIONS = Configuration.DEBUG_FUNCTIONS.get(false);

    private Checks() {
    }

    public static int lengthSafe(@Nullable short[] sArray) {
        return sArray == null ? 0 : sArray.length;
    }

    public static int lengthSafe(@Nullable int[] nArray) {
        return nArray == null ? 0 : nArray.length;
    }

    public static int lengthSafe(@Nullable long[] lArray) {
        return lArray == null ? 0 : lArray.length;
    }

    public static int lengthSafe(@Nullable float[] fArray) {
        return fArray == null ? 0 : fArray.length;
    }

    public static int lengthSafe(@Nullable double[] dArray) {
        return dArray == null ? 0 : dArray.length;
    }

    public static int remainingSafe(@Nullable Buffer buffer) {
        return buffer == null ? 0 : buffer.remaining();
    }

    public static int remainingSafe(@Nullable CustomBuffer<?> customBuffer) {
        return customBuffer == null ? 0 : customBuffer.remaining();
    }

    public static boolean checkFunctions(long ... lArray) {
        for (long l2 : lArray) {
            if (l2 != 0L) continue;
            return false;
        }
        return true;
    }

    public static boolean checkFunctions(FunctionProvider functionProvider, PointerBuffer pointerBuffer, int[] nArray, String ... stringArray) {
        boolean bl2 = true;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = nArray[i2];
            if (n2 < 0 || pointerBuffer.get(n2) != 0L) continue;
            long l2 = functionProvider.getFunctionAddress(stringArray[i2]);
            if (l2 == 0L) {
                bl2 = false;
                continue;
            }
            pointerBuffer.put(n2, l2);
        }
        return bl2;
    }

    public static boolean checkFunctions(FunctionProviderLocal functionProviderLocal, long l2, PointerBuffer pointerBuffer, int[] nArray, String ... stringArray) {
        boolean bl2 = true;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = nArray[i2];
            if (n2 < 0 || pointerBuffer.get(n2) != 0L) continue;
            long l3 = functionProviderLocal.getFunctionAddress(l2, stringArray[i2]);
            if (l3 != 0L) {
                pointerBuffer.put(n2, l3);
                continue;
            }
            bl2 = false;
        }
        return bl2;
    }

    public static boolean checkFunctions(FunctionProvider functionProvider, long[] lArray, int[] nArray, String ... stringArray) {
        boolean bl2 = true;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = nArray[i2];
            if (n2 < 0 || lArray[n2] != 0L) continue;
            long l2 = functionProvider.getFunctionAddress(stringArray[i2]);
            if (l2 == 0L) {
                bl2 = false;
                continue;
            }
            lArray[n2] = l2;
        }
        return bl2;
    }

    public static boolean reportMissing(String string, String string2) {
        APIUtil.apiLog("[" + string + "] " + string2 + " was reported as available but an entry point is missing.");
        return false;
    }

    public static long check(long l2) {
        if (l2 == 0L) {
            throw new NullPointerException();
        }
        return l2;
    }

    private static void assertNT(boolean bl2) {
        if (!bl2) {
            throw new IllegalArgumentException("Missing termination");
        }
    }

    public static void checkNT(int[] nArray) {
        Checks.checkBuffer(nArray.length, 1);
        Checks.assertNT(nArray[nArray.length - 1] == 0);
    }

    public static void checkNT(int[] nArray, int n2) {
        Checks.checkBuffer(nArray.length, 1);
        Checks.assertNT(nArray[nArray.length - 1] == n2);
    }

    public static void checkNT(long[] lArray) {
        Checks.checkBuffer(lArray.length, 1);
        Checks.assertNT(lArray[lArray.length - 1] == 0L);
    }

    public static void checkNT(float[] fArray) {
        Checks.checkBuffer(fArray.length, 1);
        Checks.assertNT(fArray[fArray.length - 1] == 0.0f);
    }

    public static void checkNT1(ByteBuffer byteBuffer) {
        Checks.checkBuffer(byteBuffer.remaining(), 1);
        Checks.assertNT(byteBuffer.get(byteBuffer.limit() - 1) == 0);
    }

    public static void checkNT2(ByteBuffer byteBuffer) {
        Checks.checkBuffer(byteBuffer.remaining(), 2);
        Checks.assertNT(byteBuffer.get(byteBuffer.limit() - 2) == 0);
    }

    public static void checkNT(IntBuffer intBuffer) {
        Checks.checkBuffer(intBuffer.remaining(), 1);
        Checks.assertNT(intBuffer.get(intBuffer.limit() - 1) == 0);
    }

    public static void checkNT(IntBuffer intBuffer, int n2) {
        Checks.checkBuffer(intBuffer.remaining(), 1);
        Checks.assertNT(intBuffer.get(intBuffer.limit() - 1) == n2);
    }

    public static void checkNT(LongBuffer longBuffer) {
        Checks.checkBuffer(longBuffer.remaining(), 1);
        Checks.assertNT(longBuffer.get(longBuffer.limit() - 1) == 0L);
    }

    public static void checkNT(FloatBuffer floatBuffer) {
        Checks.checkBuffer(floatBuffer.remaining(), 1);
        Checks.assertNT(floatBuffer.get(floatBuffer.limit() - 1) == 0.0f);
    }

    public static void checkNT(PointerBuffer pointerBuffer) {
        Checks.checkBuffer(pointerBuffer.remaining(), 1);
        Checks.assertNT(pointerBuffer.get(pointerBuffer.limit() - 1) == 0L);
    }

    public static void checkNT(PointerBuffer pointerBuffer, long l2) {
        Checks.checkBuffer(pointerBuffer.remaining(), 1);
        Checks.assertNT(pointerBuffer.get(pointerBuffer.limit() - 1) == l2);
    }

    public static void checkNTSafe(@Nullable int[] nArray) {
        if (nArray != null) {
            Checks.checkBuffer(nArray.length, 1);
            Checks.assertNT(nArray[nArray.length - 1] == 0);
        }
    }

    public static void checkNTSafe(@Nullable int[] nArray, int n2) {
        if (nArray != null) {
            Checks.checkBuffer(nArray.length, 1);
            Checks.assertNT(nArray[nArray.length - 1] == n2);
        }
    }

    public static void checkNTSafe(@Nullable long[] lArray) {
        if (lArray != null) {
            Checks.checkBuffer(lArray.length, 1);
            Checks.assertNT(lArray[lArray.length - 1] == 0L);
        }
    }

    public static void checkNTSafe(@Nullable float[] fArray) {
        if (fArray != null) {
            Checks.checkBuffer(fArray.length, 1);
            Checks.assertNT(fArray[fArray.length - 1] == 0.0f);
        }
    }

    public static void checkNT1Safe(@Nullable ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            Checks.checkBuffer(byteBuffer.remaining(), 1);
            Checks.assertNT(byteBuffer.get(byteBuffer.limit() - 1) == 0);
        }
    }

    public static void checkNT2Safe(@Nullable ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            Checks.checkBuffer(byteBuffer.remaining(), 2);
            Checks.assertNT(byteBuffer.get(byteBuffer.limit() - 2) == 0);
        }
    }

    public static void checkNTSafe(@Nullable IntBuffer intBuffer) {
        if (intBuffer != null) {
            Checks.checkBuffer(intBuffer.remaining(), 1);
            Checks.assertNT(intBuffer.get(intBuffer.limit() - 1) == 0);
        }
    }

    public static void checkNTSafe(@Nullable IntBuffer intBuffer, int n2) {
        if (intBuffer != null) {
            Checks.checkBuffer(intBuffer.remaining(), 1);
            Checks.assertNT(intBuffer.get(intBuffer.limit() - 1) == n2);
        }
    }

    public static void checkNTSafe(@Nullable LongBuffer longBuffer) {
        if (longBuffer != null) {
            Checks.checkBuffer(longBuffer.remaining(), 1);
            Checks.assertNT(longBuffer.get(longBuffer.limit() - 1) == 0L);
        }
    }

    public static void checkNTSafe(@Nullable FloatBuffer floatBuffer) {
        if (floatBuffer != null) {
            Checks.checkBuffer(floatBuffer.remaining(), 1);
            Checks.assertNT(floatBuffer.get(floatBuffer.limit() - 1) == 0.0f);
        }
    }

    public static void checkNTSafe(@Nullable PointerBuffer pointerBuffer) {
        if (pointerBuffer != null) {
            Checks.checkBuffer(pointerBuffer.remaining(), 1);
            Checks.assertNT(pointerBuffer.get(pointerBuffer.limit() - 1) == 0L);
        }
    }

    public static void checkNTSafe(@Nullable PointerBuffer pointerBuffer, long l2) {
        if (pointerBuffer != null) {
            Checks.checkBuffer(pointerBuffer.remaining(), 1);
            Checks.assertNT(pointerBuffer.get(pointerBuffer.limit() - 1) == l2);
        }
    }

    private static void checkBuffer(int n2, int n3) {
        if (n2 < n3) {
            Checks.throwIAE(n2, n3);
        }
    }

    public static void check(byte[] byArray, int n2) {
        Checks.checkBuffer(byArray.length, n2);
    }

    public static void check(short[] sArray, int n2) {
        Checks.checkBuffer(sArray.length, n2);
    }

    public static void check(int[] nArray, int n2) {
        Checks.checkBuffer(nArray.length, n2);
    }

    public static void check(long[] lArray, int n2) {
        Checks.checkBuffer(lArray.length, n2);
    }

    public static void check(float[] fArray, int n2) {
        Checks.checkBuffer(fArray.length, n2);
    }

    public static void check(double[] dArray, int n2) {
        Checks.checkBuffer(dArray.length, n2);
    }

    public static void check(CharSequence charSequence, int n2) {
        Checks.checkBuffer(charSequence.length(), n2);
    }

    public static void check(Buffer buffer, int n2) {
        Checks.checkBuffer(buffer.remaining(), n2);
    }

    public static void check(Buffer buffer, long l2) {
        Checks.checkBuffer(buffer.remaining(), (int)l2);
    }

    public static void check(CustomBuffer<?> customBuffer, int n2) {
        Checks.checkBuffer(customBuffer.remaining(), n2);
    }

    public static void check(CustomBuffer<?> customBuffer, long l2) {
        Checks.checkBuffer(customBuffer.remaining(), (int)l2);
    }

    public static void checkSafe(@Nullable short[] sArray, int n2) {
        if (sArray != null) {
            Checks.checkBuffer(sArray.length, n2);
        }
    }

    public static void checkSafe(@Nullable int[] nArray, int n2) {
        if (nArray != null) {
            Checks.checkBuffer(nArray.length, n2);
        }
    }

    public static void checkSafe(@Nullable long[] lArray, int n2) {
        if (lArray != null) {
            Checks.checkBuffer(lArray.length, n2);
        }
    }

    public static void checkSafe(@Nullable float[] fArray, int n2) {
        if (fArray != null) {
            Checks.checkBuffer(fArray.length, n2);
        }
    }

    public static void checkSafe(@Nullable double[] dArray, int n2) {
        if (dArray != null) {
            Checks.checkBuffer(dArray.length, n2);
        }
    }

    public static void checkSafe(@Nullable Buffer buffer, int n2) {
        if (buffer != null) {
            Checks.checkBuffer(buffer.remaining(), n2);
        }
    }

    public static void checkSafe(@Nullable Buffer buffer, long l2) {
        if (buffer != null) {
            Checks.checkBuffer(buffer.remaining(), (int)l2);
        }
    }

    public static void checkSafe(@Nullable CustomBuffer<?> customBuffer, int n2) {
        if (customBuffer != null) {
            Checks.checkBuffer(customBuffer.remaining(), n2);
        }
    }

    public static void checkSafe(@Nullable CustomBuffer<?> customBuffer, long l2) {
        if (customBuffer != null) {
            Checks.checkBuffer(customBuffer.remaining(), (int)l2);
        }
    }

    public static void check(Object[] objectArray, int n2) {
        Checks.checkBuffer(objectArray.length, n2);
    }

    private static void checkBufferGT(int n2, int n3) {
        if (n3 < n2) {
            Checks.throwIAEGT(n2, n3);
        }
    }

    public static void checkGT(Buffer buffer, int n2) {
        Checks.checkBufferGT(buffer.remaining(), n2);
    }

    public static void checkGT(CustomBuffer<?> customBuffer, int n2) {
        Checks.checkBufferGT(customBuffer.remaining(), n2);
    }

    public static long check(int n2, int n3) {
        if (CHECKS) {
            CheckIntrinsics.checkIndex(n2, n3);
        }
        return Integer.toUnsignedLong(n2);
    }

    private static void throwIAE(int n2, int n3) {
        throw new IllegalArgumentException("Number of remaining elements is " + n2 + ", must be at least " + n3);
    }

    private static void throwIAEGT(int n2, int n3) {
        throw new IllegalArgumentException("Number of remaining buffer elements is " + n2 + ", must be at most " + n3);
    }

    static {
        if (DEBUG_FUNCTIONS && !DEBUG) {
            APIUtil.DEBUG_STREAM.println("[LWJGL] The DEBUG_FUNCTIONS option requires DEBUG to produce output.");
        }
    }
}

