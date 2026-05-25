/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.openal;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.IntFunction;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.FunctionProviderLocal;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.ThreadLocalUtil;

public final class ALC {
    @Nullable
    private static FunctionProviderLocal functionProvider;
    @Nullable
    private static ALCCapabilities router;
    private static final ThreadLocal<ALCCapabilities> capabilitiesTLS;
    @Nullable
    private static ICD icd;

    private ALC() {
    }

    public static void create() {
        String string;
        switch (Platform.get()) {
            case LINUX: 
            case MACOSX: {
                string = "openal";
                break;
            }
            case WINDOWS: {
                string = "OpenAL";
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        ALC.create(Configuration.OPENAL_LIBRARY_NAME.get(Platform.mapLibraryNameBundled(string)));
    }

    public static void create(String string) {
        SharedLibrary sharedLibrary = Library.loadNative(ALC.class, "org.lwjgl.openal", string, true);
        try {
            ALC.create(new SharedLibraryAL(sharedLibrary));
        }
        catch (RuntimeException runtimeException) {
            sharedLibrary.free();
            throw runtimeException;
        }
    }

    public static void create(FunctionProviderLocal functionProviderLocal) {
        if (functionProvider != null) {
            throw new IllegalStateException("ALC has already been created.");
        }
        functionProvider = functionProviderLocal;
        router = ALC.createCapabilities(0L);
        AL.init();
    }

    public static void destroy() {
        if (functionProvider == null) {
            return;
        }
        AL.destroy();
        router = null;
        if (functionProvider instanceof NativeResource) {
            ((NativeResource)((Object)functionProvider)).free();
        }
        functionProvider = null;
    }

    static <T> T check(@Nullable T t2) {
        if (t2 == null) {
            throw new IllegalStateException("OpenAL library has not been loaded.");
        }
        return t2;
    }

    public static FunctionProviderLocal getFunctionProvider() {
        return ALC.check(functionProvider);
    }

    public static void setCapabilities(@Nullable ALCCapabilities aLCCapabilities) {
        capabilitiesTLS.set(aLCCapabilities);
        if (icd == null) {
            icd = new ICDStatic();
        }
        icd.set(aLCCapabilities);
    }

    public static ALCCapabilities getCapabilities() {
        ALCCapabilities aLCCapabilities = capabilitiesTLS.get();
        if (aLCCapabilities == null) {
            aLCCapabilities = router;
        }
        return ALC.checkCapabilities(aLCCapabilities);
    }

    private static ALCCapabilities checkCapabilities(@Nullable ALCCapabilities aLCCapabilities) {
        if (aLCCapabilities == null) {
            throw new IllegalStateException("No ALCCapabilities instance set");
        }
        return aLCCapabilities;
    }

    public static ALCCapabilities createCapabilities(long l2) {
        return ALC.createCapabilities(l2, null);
    }

    public static ALCCapabilities createCapabilities(long l2, @Nullable IntFunction<PointerBuffer> intFunction) {
        String string;
        int n2;
        int n3;
        FunctionProviderLocal functionProviderLocal = ALC.getFunctionProvider();
        long l3 = functionProviderLocal.getFunctionAddress("alcGetIntegerv");
        long l4 = functionProviderLocal.getFunctionAddress("alcGetString");
        long l5 = functionProviderLocal.getFunctionAddress("alcIsExtensionPresent");
        if (l3 == 0L || l4 == 0L || l5 == 0L) {
            throw new IllegalStateException("Core ALC functions could not be found. Make sure that OpenAL has been loaded.");
        }
        Object object = MemoryStack.stackPush();
        Serializable serializable = null;
        try {
            IntBuffer intBuffer = ((MemoryStack)object).mallocInt(1);
            JNI.invokePPV(l2, 4096, 1, MemoryUtil.memAddress(intBuffer), l3);
            n3 = intBuffer.get(0);
            JNI.invokePPV(l2, 4097, 1, MemoryUtil.memAddress(intBuffer), l3);
            n2 = intBuffer.get(0);
        }
        catch (Throwable throwable) {
            serializable = throwable;
            throw throwable;
        }
        finally {
            if (object != null) {
                if (serializable != null) {
                    try {
                        ((MemoryStack)object).close();
                    }
                    catch (Throwable throwable) {
                        ((Throwable)serializable).addSuppressed(throwable);
                    }
                } else {
                    ((MemoryStack)object).close();
                }
            }
        }
        object = new int[][]{{0, 1}};
        serializable = new HashSet(16);
        for (int i2 = 1; i2 <= ((Object)object).length; ++i2) {
            for (Object object2 : string = object[i2 - 1]) {
                if (i2 >= n3 && (i2 != n3 || object2 > n2)) continue;
                serializable.add("OpenALC" + i2 + (int)object2);
            }
        }
        String string2 = MemoryUtil.memASCIISafe(JNI.invokePP(l2, 4102, l4));
        if (string2 != null) {
            string = new StringTokenizer(string2);
            while (((StringTokenizer)((Object)string)).hasMoreTokens()) {
                String string3 = ((StringTokenizer)((Object)string)).nextToken();
                MemoryStack memoryStack = MemoryStack.stackPush();
                Throwable throwable = null;
                try {
                    if (!JNI.invokePPZ(l2, MemoryUtil.memAddress(memoryStack.ASCII(string3, true)), l5)) continue;
                    serializable.add(string3);
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
        APIUtil.apiFilterExtensions((Set<String>)((Object)serializable), Configuration.OPENAL_EXTENSION_FILTER);
        string = new ALCCapabilities(functionProviderLocal, l2, (Set<String>)((Object)serializable), intFunction == null ? BufferUtils::createPointerBuffer : intFunction);
        if (l2 != 0L) {
            ALC.setCapabilities((ALCCapabilities)((Object)string));
        }
        return string;
    }

    static ALCCapabilities getICD() {
        ALCCapabilities aLCCapabilities;
        ALCCapabilities aLCCapabilities2 = aLCCapabilities = icd == null ? null : icd.get();
        if (aLCCapabilities == null) {
            aLCCapabilities = router;
        }
        return ALC.check(aLCCapabilities);
    }

    static {
        capabilitiesTLS = new ThreadLocal();
        if (!Configuration.OPENAL_EXPLICIT_INIT.get(false).booleanValue()) {
            ALC.create();
        }
    }

    static class ICDStatic
    implements ICD {
        @Nullable
        private static ALCCapabilities tempCaps;

        private ICDStatic() {
        }

        @Override
        public void set(@Nullable ALCCapabilities aLCCapabilities) {
            if (tempCaps == null) {
                tempCaps = aLCCapabilities;
            } else if (aLCCapabilities != null && aLCCapabilities != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(ICDStatic.tempCaps.addresses, aLCCapabilities.addresses)) {
                APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread/process lookup for AL contexts.");
                icd = ALC::getCapabilities;
            }
        }

        @Override
        public ALCCapabilities get() {
            return WriteOnce.caps;
        }

        static final class WriteOnce {
            static final ALCCapabilities caps;

            private WriteOnce() {
            }

            static {
                ALCCapabilities aLCCapabilities = tempCaps;
                if (aLCCapabilities == null) {
                    throw new IllegalStateException("No ALCCapabilities instance has been set");
                }
                caps = aLCCapabilities;
            }
        }
    }

    static interface ICD {
        default public void set(@Nullable ALCCapabilities aLCCapabilities) {
        }

        @Nullable
        public ALCCapabilities get();
    }

    static class SharedLibraryAL
    extends SharedLibrary.Delegate
    implements FunctionProviderLocal {
        private final long alcGetProcAddress = this.getFunctionAddress("alcGetProcAddress");

        protected SharedLibraryAL(SharedLibrary sharedLibrary) {
            super(sharedLibrary);
            if (this.alcGetProcAddress == 0L) {
                throw new RuntimeException("A core ALC function is missing. Make sure that the OpenAL library has been loaded correctly.");
            }
        }

        @Override
        public long getFunctionAddress(ByteBuffer byteBuffer) {
            long l2 = this.library.getFunctionAddress(byteBuffer);
            if (l2 == 0L && Checks.DEBUG_FUNCTIONS) {
                APIUtil.apiLog("Failed to locate address for ALC core function " + MemoryUtil.memASCII(byteBuffer));
            }
            return l2;
        }

        @Override
        public long getFunctionAddress(long l2, ByteBuffer byteBuffer) {
            long l3 = this.library.getFunctionAddress(byteBuffer);
            if (l3 == 0L && l2 != 0L) {
                l3 = JNI.invokePPP(l2, MemoryUtil.memAddress(byteBuffer), this.alcGetProcAddress);
            }
            if (l3 == 0L && Checks.DEBUG_FUNCTIONS) {
                APIUtil.apiLog("Failed to locate address for ALC function " + MemoryUtil.memASCII(byteBuffer));
            }
            return l3;
        }
    }
}

