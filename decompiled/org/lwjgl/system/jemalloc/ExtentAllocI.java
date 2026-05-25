/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.jemalloc;

import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;

@FunctionalInterface
@NativeType(value="extent_alloc_t")
public interface ExtentAllocI
extends CallbackI {
    public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_uint32);

    @Override
    default public FFICIF getCallInterface() {
        return CIF;
    }

    @Override
    default public void callback(long l2, long l3) {
        long l4 = this.invoke(MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3)), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)POINTER_SIZE)), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)(2 * POINTER_SIZE))), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)(3 * POINTER_SIZE))), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)(4 * POINTER_SIZE))), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)(5 * POINTER_SIZE))), MemoryUtil.memGetInt(MemoryUtil.memGetAddress(l3 + (long)(6 * POINTER_SIZE))));
        APIUtil.apiClosureRetP(l2, l4);
    }

    @NativeType(value="void *")
    public long invoke(@NativeType(value="extent_hooks_t *") long var1, @NativeType(value="void *") long var3, @NativeType(value="size_t") long var5, @NativeType(value="size_t") long var7, @NativeType(value="bool *") long var9, @NativeType(value="bool *") long var11, @NativeType(value="unsigned int") int var13);
}

