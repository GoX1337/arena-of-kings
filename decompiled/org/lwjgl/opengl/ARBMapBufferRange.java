/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.system.NativeType;

public class ARBMapBufferRange {
    public static final int GL_MAP_READ_BIT = 1;
    public static final int GL_MAP_WRITE_BIT = 2;
    public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
    public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
    public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
    public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;

    protected ARBMapBufferRange() {
        throw new UnsupportedOperationException();
    }

    public static long nglMapBufferRange(int n2, long l2, long l3, int n3) {
        return GL30C.nglMapBufferRange(n2, l2, l3, n3);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBufferRange(@NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLbitfield") int n3) {
        return GL30C.glMapBufferRange(n2, l2, l3, n3);
    }

    @Nullable
    @NativeType(value="void *")
    public static ByteBuffer glMapBufferRange(@NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3, @NativeType(value="GLbitfield") int n3, @Nullable ByteBuffer byteBuffer) {
        return GL30C.glMapBufferRange(n2, l2, l3, n3, byteBuffer);
    }

    public static void glFlushMappedBufferRange(@NativeType(value="GLenum") int n2, @NativeType(value="GLintptr") long l2, @NativeType(value="GLsizeiptr") long l3) {
        GL30C.glFlushMappedBufferRange(n2, l2, l3);
    }

    static {
        GL.initialize();
    }
}

