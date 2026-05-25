/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.jemalloc;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.jemalloc.JEmalloc;

public class JEmallocAllocator
implements MemoryUtil.MemoryAllocator {
    @Override
    public long getMalloc() {
        return JEmalloc.Functions.malloc;
    }

    @Override
    public long getCalloc() {
        return JEmalloc.Functions.calloc;
    }

    @Override
    public long getRealloc() {
        return JEmalloc.Functions.realloc;
    }

    @Override
    public long getFree() {
        return JEmalloc.Functions.free;
    }

    @Override
    public long getAlignedAlloc() {
        return JEmalloc.Functions.aligned_alloc;
    }

    @Override
    public long getAlignedFree() {
        return JEmalloc.Functions.free;
    }

    @Override
    public long malloc(long l2) {
        return JEmalloc.nje_malloc(l2);
    }

    @Override
    public long calloc(long l2, long l3) {
        return JEmalloc.nje_calloc(l2, l3);
    }

    @Override
    public long realloc(long l2, long l3) {
        return JEmalloc.nje_realloc(l2, l3);
    }

    @Override
    public void free(long l2) {
        JEmalloc.nje_free(l2);
    }

    @Override
    public long aligned_alloc(long l2, long l3) {
        return JEmalloc.nje_aligned_alloc(l2, l3);
    }

    @Override
    public void aligned_free(long l2) {
        JEmalloc.nje_free(l2);
    }

    static {
        JEmalloc.getLibrary();
    }
}

