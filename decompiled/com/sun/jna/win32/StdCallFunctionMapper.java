/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.win32;

import com.sun.jna.Function;
import com.sun.jna.FunctionMapper;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import java.lang.reflect.Method;

public class StdCallFunctionMapper
implements FunctionMapper {
    protected int getArgumentNativeStackSize(Class<?> clazz) {
        if (NativeMapped.class.isAssignableFrom(clazz)) {
            clazz = NativeMappedConverter.getInstance(clazz).nativeType();
        }
        if (clazz.isArray()) {
            return Native.POINTER_SIZE;
        }
        try {
            return Native.getNativeSize(clazz);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("Unknown native stack allocation size for " + clazz);
        }
    }

    @Override
    public String getFunctionName(NativeLibrary nativeLibrary, Method method) {
        Class<?>[] classArray;
        String string = method.getName();
        int n2 = 0;
        for (Class<?> unsatisfiedLinkError2 : classArray = method.getParameterTypes()) {
            n2 += this.getArgumentNativeStackSize(unsatisfiedLinkError2);
        }
        String string2 = string + "@" + n2;
        int n3 = 63;
        try {
            Function unsatisfiedLinkError = nativeLibrary.getFunction(string2, n3);
            string = unsatisfiedLinkError.getName();
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            try {
                Function function = nativeLibrary.getFunction("_" + string2, n3);
                string = function.getName();
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError2) {
                // empty catch block
            }
        }
        return string;
    }
}

