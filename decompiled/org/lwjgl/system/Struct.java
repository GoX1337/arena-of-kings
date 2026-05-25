/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Platform;
import org.lwjgl.system.Pointer;

public abstract class Struct
extends Pointer.Default {
    protected static final int DEFAULT_PACK_ALIGNMENT = Platform.get() == Platform.WINDOWS ? 8 : 0x40000000;
    protected static final int DEFAULT_ALIGN_AS = 0;
    private static final long CONTAINER;
    @Nullable
    protected ByteBuffer container;

    public Struct(long l2, @Nullable ByteBuffer byteBuffer) {
        super(l2);
        this.container = byteBuffer;
    }

    public abstract int sizeof();

    public void clear() {
        MemoryUtil.memSet(this.address(), 0, this.sizeof());
    }

    public void free() {
        MemoryUtil.nmemFree(this.address());
    }

    public boolean isNull(int n2) {
        if (Checks.DEBUG) {
            this.checkMemberOffset(n2);
        }
        return MemoryUtil.memGetAddress(this.address() + (long)n2) == 0L;
    }

    public static <T extends Struct> T wrap(Class<T> clazz, long l2) {
        Struct struct;
        try {
            struct = (Struct)UNSAFE.allocateInstance(clazz);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(struct, ADDRESS, l2);
        return (T)struct;
    }

    protected static <S extends Struct, T extends Struct> T wrap(Class<T> clazz, S s2) {
        return Struct.wrap(clazz, s2.address, s2.container);
    }

    public static <T extends Struct> T wrap(Class<T> clazz, long l2, @Nullable ByteBuffer byteBuffer) {
        Struct struct;
        try {
            struct = (Struct)UNSAFE.allocateInstance(clazz);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(struct, ADDRESS, l2);
        UNSAFE.putObject(struct, CONTAINER, byteBuffer);
        return (T)struct;
    }

    <T extends Struct> T wrap(long l2, int n2, @Nullable ByteBuffer byteBuffer) {
        Struct struct;
        try {
            struct = (Struct)UNSAFE.allocateInstance(this.getClass());
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(struct, ADDRESS, l2 + Integer.toUnsignedLong(n2) * (long)this.sizeof());
        UNSAFE.putObject(struct, CONTAINER, byteBuffer);
        return (T)struct;
    }

    private void checkMemberOffset(int n2) {
        if (n2 < 0 || this.sizeof() - n2 < POINTER_SIZE) {
            throw new IllegalArgumentException("Invalid member offset.");
        }
    }

    protected static ByteBuffer __checkContainer(ByteBuffer byteBuffer, int n2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n2);
        }
        return byteBuffer;
    }

    private static long getBytes(int n2, int n3) {
        return ((long)n2 & 0xFFFFFFFFL) * (long)n3;
    }

    public static long __checkMalloc(int n2, int n3) {
        long l2 = ((long)n2 & 0xFFFFFFFFL) * (long)n3;
        if (Checks.DEBUG) {
            if (n2 < 0) {
                throw new IllegalArgumentException("Invalid number of elements");
            }
            if (BITS32 && 0xFFFFFFFFL < l2) {
                throw new IllegalArgumentException("The request allocation is too large");
            }
        }
        return l2;
    }

    public static ByteBuffer __create(int n2, int n3) {
        APIUtil.apiCheckAllocation(n2, Struct.getBytes(n2, n3), Integer.MAX_VALUE);
        return ByteBuffer.allocateDirect(n2 * n3).order(ByteOrder.nativeOrder());
    }

    public static void validate(long l2, int n2, int n3, StructValidation structValidation) {
        for (int i2 = 0; i2 < n2; ++i2) {
            structValidation.validate(l2 + Integer.toUnsignedLong(i2) * (long)n3);
        }
    }

    protected static Member __padding(int n2, boolean bl2) {
        return Struct.__padding(n2, 1, bl2);
    }

    public static Member __padding(int n2, int n3, boolean bl2) {
        return Struct.__member(bl2 ? n2 * n3 : 0, n3);
    }

    public static Member __member(int n2) {
        return Struct.__member(n2, n2);
    }

    public static Member __member(int n2, int n3) {
        return Struct.__member(n2, n3, false);
    }

    protected static Member __member(int n2, int n3, boolean bl2) {
        return new Member(n2, n3, bl2);
    }

    public static Member __array(int n2, int n3) {
        return Struct.__array(n2, n2, n3);
    }

    public static Member __array(int n2, int n3, int n4) {
        return new Member(n2 * n4, n3, false);
    }

    protected static Member __array(int n2, int n3, boolean bl2, int n4) {
        return new Member(n2 * n4, n3, bl2);
    }

    public static Layout __union(Member ... memberArray) {
        return Struct.__union(DEFAULT_PACK_ALIGNMENT, 0, memberArray);
    }

    protected static Layout __union(int n2, int n3, Member ... memberArray) {
        ArrayList<Member> arrayList = new ArrayList<Member>(memberArray.length);
        int n4 = 0;
        int n5 = n3;
        for (Member member : memberArray) {
            n4 = Math.max(n4, member.size);
            n5 = Math.max(n5, member.getAlignment(n2));
            member.offset = 0;
            arrayList.add(member);
            if (!(member instanceof Layout)) continue;
            Struct.addNestedMembers(member, arrayList, 0);
        }
        return new Layout(n4, n5, n3 != 0, arrayList.toArray(new Member[0]));
    }

    public static Layout __struct(Member ... memberArray) {
        return Struct.__struct(DEFAULT_PACK_ALIGNMENT, 0, memberArray);
    }

    protected static Layout __struct(int n2, int n3, Member ... memberArray) {
        ArrayList<Member> arrayList = new ArrayList<Member>(memberArray.length);
        int n4 = 0;
        int n5 = n3;
        for (Member member : memberArray) {
            int n6 = member.getAlignment(n2);
            member.offset = Struct.align(n4, n6);
            n4 = member.offset + member.size;
            n5 = Math.max(n5, n6);
            arrayList.add(member);
            if (!(member instanceof Layout)) continue;
            Struct.addNestedMembers(member, arrayList, member.offset);
        }
        n4 = Struct.align(n4, n5);
        return new Layout(n4, n5, n3 != 0, arrayList.toArray(new Member[0]));
    }

    private static void addNestedMembers(Member member, List<Member> list, int n2) {
        Layout layout = (Layout)member;
        for (Member member2 : layout.members) {
            member2.offset += n2;
            list.add(member2);
        }
    }

    private static int align(int n2, int n3) {
        return (n2 - 1 | n3 - 1) + 1;
    }

    static {
        Library.initialize();
        try {
            CONTAINER = UNSAFE.objectFieldOffset(Struct.class.getDeclaredField("container"));
        }
        catch (Throwable throwable) {
            throw new UnsupportedOperationException(throwable);
        }
    }

    public static class Layout
    extends Member {
        final Member[] members;

        Layout(int n2, int n3, boolean bl2, Member[] memberArray) {
            super(n2, n3, bl2);
            this.members = memberArray;
        }

        public int offsetof(int n2) {
            return this.members[n2].offset;
        }
    }

    public static class Member {
        final int size;
        final int alignment;
        final boolean forcedAlignment;
        int offset;

        Member(int n2, int n3, boolean bl2) {
            this.size = n2;
            this.alignment = n3;
            this.forcedAlignment = bl2;
        }

        public int getSize() {
            return this.size;
        }

        public int getAlignment() {
            return this.alignment;
        }

        public int getAlignment(int n2) {
            return this.forcedAlignment ? this.alignment : Math.min(this.alignment, n2);
        }
    }

    @FunctionalInterface
    public static interface StructValidation {
        public void validate(long var1);
    }
}

