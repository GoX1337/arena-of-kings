/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;

@FunctionalInterface
@NativeType(value="GLDEBUGPROCAMD")
public interface GLDebugMessageAMDCallbackI
extends CallbackI {
    public static final FFICIF CIF = APIUtil.apiCreateCIF(APIUtil.apiStdcall(), LibFFI.ffi_type_void, LibFFI.ffi_type_uint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_sint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);

    @Override
    default public FFICIF getCallInterface() {
        return CIF;
    }

    @Override
    default public void callback(long l2, long l3) {
        this.invoke(MemoryUtil.memGetInt(MemoryUtil.memGetAddress(l3)), MemoryUtil.memGetInt(MemoryUtil.memGetAddress(l3 + (long)POINTER_SIZE)), MemoryUtil.memGetInt(MemoryUtil.memGetAddress(l3 + (long)(2 * POINTER_SIZE))), MemoryUtil.memGetInt(MemoryUtil.memGetAddress(l3 + (long)(3 * POINTER_SIZE))), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)(4 * POINTER_SIZE))), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)(5 * POINTER_SIZE))));
    }

    public void invoke(@NativeType(value="GLuint") int var1, @NativeType(value="GLenum") int var2, @NativeType(value="GLenum") int var3, @NativeType(value="GLsizei") int var4, @NativeType(value="GLchar const *") long var5, @NativeType(value="void *") long var7);
}

