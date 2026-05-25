/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;

@FunctionalInterface
@NativeType(value="GLFWcursorposfun")
public interface GLFWCursorPosCallbackI
extends CallbackI {
    public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, LibFFI.ffi_type_pointer, LibFFI.ffi_type_double, LibFFI.ffi_type_double);

    @Override
    default public FFICIF getCallInterface() {
        return CIF;
    }

    @Override
    default public void callback(long l2, long l3) {
        this.invoke(MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3)), MemoryUtil.memGetDouble(MemoryUtil.memGetAddress(l3 + (long)POINTER_SIZE)), MemoryUtil.memGetDouble(MemoryUtil.memGetAddress(l3 + (long)(2 * POINTER_SIZE))));
    }

    public void invoke(@NativeType(value="GLFWwindow *") long var1, double var3, double var5);
}

