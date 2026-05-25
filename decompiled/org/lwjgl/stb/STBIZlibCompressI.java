/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.stb;

import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;

@FunctionalInterface
@NativeType(value="unsigned char * (*) (unsigned char *, int, int *, int)")
public interface STBIZlibCompressI
extends CallbackI {
    public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_sint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_sint32);

    @Override
    default public FFICIF getCallInterface() {
        return CIF;
    }

    @Override
    default public void callback(long l2, long l3) {
        long l4 = this.invoke(MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3)), MemoryUtil.memGetInt(MemoryUtil.memGetAddress(l3 + (long)POINTER_SIZE)), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)(2 * POINTER_SIZE))), MemoryUtil.memGetInt(MemoryUtil.memGetAddress(l3 + (long)(3 * POINTER_SIZE))));
        APIUtil.apiClosureRetP(l2, l4);
    }

    @NativeType(value="unsigned char *")
    public long invoke(@NativeType(value="unsigned char *") long var1, int var3, @NativeType(value="int *") long var4, int var6);
}

