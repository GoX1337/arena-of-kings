/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.function.IntFunction;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;
import org.lwjgl.openal.EXTThreadLocalContext;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.ThreadLocalUtil;

public final class AL {
    @Nullable
    private static ALCapabilities processCaps;
    private static final ThreadLocal<ALCapabilities> capabilitiesTLS;
    private static ICD icd;

    private AL() {
    }

    static void init() {
    }

    static void destroy() {
        AL.setCurrentProcess(null);
    }

    public static void setCurrentProcess(@Nullable ALCapabilities aLCapabilities) {
        processCaps = aLCapabilities;
        capabilitiesTLS.set(null);
        icd.set(aLCapabilities);
    }

    public static void setCurrentThread(@Nullable ALCapabilities aLCapabilities) {
        capabilitiesTLS.set(aLCapabilities);
        icd.set(aLCapabilities);
    }

    public static ALCapabilities getCapabilities() {
        ALCapabilities aLCapabilities = capabilitiesTLS.get();
        if (aLCapabilities == null) {
            aLCapabilities = processCaps;
        }
        return AL.checkCapabilities(aLCapabilities);
    }

    private static ALCapabilities checkCapabilities(@Nullable ALCapabilities aLCapabilities) {
        if (aLCapabilities == null) {
            throw new IllegalStateException("No ALCapabilities instance set for the current thread or process. Possible solutions:\n\ta) Call AL.createCapabilities() after making a context current.\n\tb) Call AL.setCurrentProcess() or AL.setCurrentThread() if an ALCapabilities instance already exists.");
        }
        return aLCapabilities;
    }

    public static ALCapabilities createCapabilities(ALCCapabilities aLCCapabilities) {
        return AL.createCapabilities(aLCCapabilities, null);
    }

    public static ALCapabilities createCapabilities(ALCCapabilities aLCCapabilities, @Nullable IntFunction<PointerBuffer> intFunction) {
        Object object;
        long l2 = ALC.getFunctionProvider().getFunctionAddress(0L, "alGetProcAddress");
        if (l2 == 0L) {
            throw new RuntimeException("A core AL function is missing. Make sure that the OpenAL library has been loaded correctly.");
        }
        FunctionProvider functionProvider = byteBuffer -> {
            long l3 = JNI.invokePP(MemoryUtil.memAddress(byteBuffer), l2);
            if (l3 == 0L && Checks.DEBUG_FUNCTIONS) {
                APIUtil.apiLog("Failed to locate address for AL function " + MemoryUtil.memASCII(byteBuffer));
            }
            return l3;
        };
        long l3 = functionProvider.getFunctionAddress("alGetString");
        long l4 = functionProvider.getFunctionAddress("alGetError");
        long l5 = functionProvider.getFunctionAddress("alIsExtensionPresent");
        if (l3 == 0L || l4 == 0L || l5 == 0L) {
            throw new IllegalStateException("Core OpenAL functions could not be found. Make sure that the OpenAL library has been loaded correctly.");
        }
        String string = MemoryUtil.memASCIISafe(JNI.invokeP(45058, l3));
        if (string == null || JNI.invokeI(l4) != 0) {
            throw new IllegalStateException("There is no OpenAL context current in the current thread or process.");
        }
        APIUtil.APIVersion aPIVersion = APIUtil.apiParseVersion(string);
        int n2 = aPIVersion.major;
        int n3 = aPIVersion.minor;
        int[][] nArrayArray = new int[][]{{0, 1}};
        HashSet<String> hashSet = new HashSet<String>(32);
        for (int i2 = 1; i2 <= nArrayArray.length; ++i2) {
            for (Object object2 : object = nArrayArray[i2 - 1]) {
                if (i2 >= n2 && (i2 != n2 || object2 > n3)) continue;
                hashSet.add("OpenAL" + i2 + (int)object2);
            }
        }
        String string2 = MemoryUtil.memASCIISafe(JNI.invokeP(45060, l3));
        if (string2 != null) {
            object = MemoryStack.stackGet();
            Object object3 = new StringTokenizer(string2);
            while (((StringTokenizer)object3).hasMoreTokens()) {
                String string3 = ((StringTokenizer)object3).nextToken();
                MemoryStack memoryStack = ((MemoryStack)object).push();
                Throwable throwable = null;
                try {
                    if (!JNI.invokePZ(MemoryUtil.memAddress(memoryStack.ASCII(string3, true)), l5)) continue;
                    hashSet.add(string3);
                }
                catch (Throwable throwable2) {
                    throwable = throwable2;
                    throw throwable2;
                }
                finally {
                    if (memoryStack == null) continue;
                    if (throwable != null) {
                        try {
                            memoryStack.close();
                        }
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                        continue;
                    }
                    memoryStack.close();
                }
            }
        }
        if (aLCCapabilities.ALC_EXT_EFX) {
            hashSet.add("ALC_EXT_EFX");
        }
        APIUtil.apiFilterExtensions(hashSet, Configuration.OPENAL_EXTENSION_FILTER);
        object = new ALCapabilities(functionProvider, hashSet, intFunction == null ? BufferUtils::createPointerBuffer : intFunction);
        if (aLCCapabilities.ALC_EXT_thread_local_context && EXTThreadLocalContext.alcGetThreadContext() != 0L) {
            AL.setCurrentThread((ALCapabilities)object);
        } else {
            AL.setCurrentProcess((ALCapabilities)object);
        }
        return object;
    }

    static ALCapabilities getICD() {
        return ALC.check(icd.get());
    }

    static {
        capabilitiesTLS = new ThreadLocal();
        icd = new ICDStatic();
    }

    static class ICDStatic
    implements ICD {
        @Nullable
        private static ALCapabilities tempCaps;

        private ICDStatic() {
        }

        @Override
        public void set(@Nullable ALCapabilities aLCapabilities) {
            if (tempCaps == null) {
                tempCaps = aLCapabilities;
            } else if (aLCapabilities != null && aLCapabilities != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(ICDStatic.tempCaps.addresses, aLCapabilities.addresses)) {
                APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread/process lookup for AL contexts.");
                icd = AL::getCapabilities;
            }
        }

        @Override
        public ALCapabilities get() {
            return WriteOnce.caps;
        }

        static final class WriteOnce {
            static final ALCapabilities caps;

            private WriteOnce() {
            }

            static {
                ALCapabilities aLCapabilities = tempCaps;
                if (aLCapabilities == null) {
                    throw new IllegalStateException("No ALCapabilities instance has been set");
                }
                caps = aLCapabilities;
            }
        }
    }

    static interface ICD {
        default public void set(@Nullable ALCapabilities aLCapabilities) {
        }

        @Nullable
        public ALCapabilities get();
    }
}

