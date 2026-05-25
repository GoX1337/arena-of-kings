/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryAccessJNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Platform;
import sun.misc.Unsafe;

public interface Pointer {
    public static final int POINTER_SIZE = MemoryAccessJNI.getPointerSize();
    public static final int POINTER_SHIFT = POINTER_SIZE == 8 ? 3 : 2;
    public static final int CLONG_SIZE = POINTER_SIZE == 8 && Platform.get() == Platform.WINDOWS ? 4 : POINTER_SIZE;
    public static final int CLONG_SHIFT = CLONG_SIZE == 8 ? 3 : 2;
    public static final boolean BITS32 = POINTER_SIZE * 8 == 32;
    public static final boolean BITS64 = POINTER_SIZE * 8 == 64;

    public long address();

    public static abstract class Default
    implements Pointer {
        public static final Unsafe UNSAFE = MemoryUtil.UNSAFE;
        protected static final long ADDRESS;
        protected static final long BUFFER_CONTAINER;
        protected static final long BUFFER_MARK;
        protected static final long BUFFER_POSITION;
        protected static final long BUFFER_LIMIT;
        protected static final long BUFFER_CAPACITY;
        protected long address;

        protected Default(long l2) {
            if (Checks.CHECKS && l2 == 0L) {
                throw new NullPointerException();
            }
            this.address = l2;
        }

        @Override
        public long address() {
            return this.address;
        }

        public boolean equals(@Nullable Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Pointer)) {
                return false;
            }
            Pointer pointer = (Pointer)object;
            return this.address == pointer.address();
        }

        public int hashCode() {
            return (int)(this.address ^ this.address >>> 32);
        }

        public String toString() {
            return String.format("%s pointer [0x%X]", this.getClass().getSimpleName(), this.address);
        }

        public static <T extends CustomBuffer<?>> T wrap(Class<? extends T> clazz, long l2, int n2) {
            CustomBuffer customBuffer;
            try {
                customBuffer = (CustomBuffer)UNSAFE.allocateInstance(clazz);
            }
            catch (InstantiationException instantiationException) {
                throw new UnsupportedOperationException(instantiationException);
            }
            UNSAFE.putLong(customBuffer, ADDRESS, l2);
            UNSAFE.putInt(customBuffer, BUFFER_MARK, -1);
            UNSAFE.putInt(customBuffer, BUFFER_LIMIT, n2);
            UNSAFE.putInt(customBuffer, BUFFER_CAPACITY, n2);
            return (T)customBuffer;
        }

        protected static <S extends CustomBuffer<?>, T extends CustomBuffer<?>> T wrap(Class<T> clazz, S s2) {
            return Default.wrap(clazz, s2.address(), s2.remaining(), s2.container);
        }

        public static <T extends CustomBuffer<?>> T wrap(Class<? extends T> clazz, long l2, int n2, @Nullable ByteBuffer byteBuffer) {
            CustomBuffer customBuffer;
            try {
                customBuffer = (CustomBuffer)UNSAFE.allocateInstance(clazz);
            }
            catch (InstantiationException instantiationException) {
                throw new UnsupportedOperationException(instantiationException);
            }
            UNSAFE.putLong(customBuffer, ADDRESS, l2);
            UNSAFE.putInt(customBuffer, BUFFER_MARK, -1);
            UNSAFE.putInt(customBuffer, BUFFER_LIMIT, n2);
            UNSAFE.putInt(customBuffer, BUFFER_CAPACITY, n2);
            UNSAFE.putObject(customBuffer, BUFFER_CONTAINER, byteBuffer);
            return (T)customBuffer;
        }

        static {
            try {
                ADDRESS = UNSAFE.objectFieldOffset(Default.class.getDeclaredField("address"));
                BUFFER_CONTAINER = UNSAFE.objectFieldOffset(CustomBuffer.class.getDeclaredField("container"));
                BUFFER_MARK = UNSAFE.objectFieldOffset(CustomBuffer.class.getDeclaredField("mark"));
                BUFFER_POSITION = UNSAFE.objectFieldOffset(CustomBuffer.class.getDeclaredField("position"));
                BUFFER_LIMIT = UNSAFE.objectFieldOffset(CustomBuffer.class.getDeclaredField("limit"));
                BUFFER_CAPACITY = UNSAFE.objectFieldOffset(CustomBuffer.class.getDeclaredField("capacity"));
            }
            catch (Throwable throwable) {
                throw new UnsupportedOperationException(throwable);
            }
        }
    }
}

