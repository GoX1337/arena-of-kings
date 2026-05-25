/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;

@FunctionalInterface
@NativeType(value="WNDPROC")
public interface WindowProcI
extends CallbackI {
    public static final FFICIF CIF = APIUtil.apiCreateCIF(APIUtil.apiStdcall(), LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_uint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);

    @Override
    default public FFICIF getCallInterface() {
        return CIF;
    }

    @Override
    default public void callback(long l2, long l3) {
        long l4 = this.invoke(MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3)), MemoryUtil.memGetInt(MemoryUtil.memGetAddress(l3 + (long)POINTER_SIZE)), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)(2 * POINTER_SIZE))), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)(3 * POINTER_SIZE))));
        APIUtil.apiClosureRetP(l2, l4);
    }

    @NativeType(value="LRESULT")
    public long invoke(@NativeType(value="HWND") long var1, @NativeType(value="UINT") int var3, @NativeType(value="WPARAM") long var4, @NativeType(value="LPARAM") long var6);
}

