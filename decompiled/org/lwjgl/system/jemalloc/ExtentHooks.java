/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.jemalloc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.jemalloc.ExtentAlloc;
import org.lwjgl.system.jemalloc.ExtentAllocI;
import org.lwjgl.system.jemalloc.ExtentCommit;
import org.lwjgl.system.jemalloc.ExtentCommitI;
import org.lwjgl.system.jemalloc.ExtentDalloc;
import org.lwjgl.system.jemalloc.ExtentDallocI;
import org.lwjgl.system.jemalloc.ExtentDecommit;
import org.lwjgl.system.jemalloc.ExtentDecommitI;
import org.lwjgl.system.jemalloc.ExtentDestroy;
import org.lwjgl.system.jemalloc.ExtentDestroyI;
import org.lwjgl.system.jemalloc.ExtentMerge;
import org.lwjgl.system.jemalloc.ExtentMergeI;
import org.lwjgl.system.jemalloc.ExtentPurge;
import org.lwjgl.system.jemalloc.ExtentPurgeI;
import org.lwjgl.system.jemalloc.ExtentSplit;
import org.lwjgl.system.jemalloc.ExtentSplitI;

@NativeType(value="struct extent_hooks_t")
public class ExtentHooks
extends Struct
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ALLOC;
    public static final int DALLOC;
    public static final int DESTROY;
    public static final int COMMIT;
    public static final int DECOMMIT;
    public static final int PURGE_LAZY;
    public static final int PURGE_FORCED;
    public static final int SPLIT;
    public static final int MERGE;

    public ExtentHooks(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), ExtentHooks.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="extent_alloc_t")
    public ExtentAlloc alloc() {
        return ExtentHooks.nalloc(this.address());
    }

    @Nullable
    @NativeType(value="extent_dalloc_t")
    public ExtentDalloc dalloc() {
        return ExtentHooks.ndalloc(this.address());
    }

    @Nullable
    @NativeType(value="extent_destroy_t")
    public ExtentDestroy destroy() {
        return ExtentHooks.ndestroy(this.address());
    }

    @Nullable
    @NativeType(value="extent_commit_t")
    public ExtentCommit commit() {
        return ExtentHooks.ncommit(this.address());
    }

    @Nullable
    @NativeType(value="extent_decommit_t")
    public ExtentDecommit decommit() {
        return ExtentHooks.ndecommit(this.address());
    }

    @Nullable
    @NativeType(value="extent_purge_t")
    public ExtentPurge purge_lazy() {
        return ExtentHooks.npurge_lazy(this.address());
    }

    @Nullable
    @NativeType(value="extent_purge_t")
    public ExtentPurge purge_forced() {
        return ExtentHooks.npurge_forced(this.address());
    }

    @Nullable
    @NativeType(value="extent_split_t")
    public ExtentSplit split() {
        return ExtentHooks.nsplit(this.address());
    }

    @Nullable
    @NativeType(value="extent_merge_t")
    public ExtentMerge merge() {
        return ExtentHooks.nmerge(this.address());
    }

    public ExtentHooks alloc(@NativeType(value="extent_alloc_t") ExtentAllocI extentAllocI) {
        ExtentHooks.nalloc(this.address(), extentAllocI);
        return this;
    }

    public ExtentHooks dalloc(@Nullable @NativeType(value="extent_dalloc_t") ExtentDallocI extentDallocI) {
        ExtentHooks.ndalloc(this.address(), extentDallocI);
        return this;
    }

    public ExtentHooks destroy(@Nullable @NativeType(value="extent_destroy_t") ExtentDestroyI extentDestroyI) {
        ExtentHooks.ndestroy(this.address(), extentDestroyI);
        return this;
    }

    public ExtentHooks commit(@Nullable @NativeType(value="extent_commit_t") ExtentCommitI extentCommitI) {
        ExtentHooks.ncommit(this.address(), extentCommitI);
        return this;
    }

    public ExtentHooks decommit(@Nullable @NativeType(value="extent_decommit_t") ExtentDecommitI extentDecommitI) {
        ExtentHooks.ndecommit(this.address(), extentDecommitI);
        return this;
    }

    public ExtentHooks purge_lazy(@Nullable @NativeType(value="extent_purge_t") ExtentPurgeI extentPurgeI) {
        ExtentHooks.npurge_lazy(this.address(), extentPurgeI);
        return this;
    }

    public ExtentHooks purge_forced(@Nullable @NativeType(value="extent_purge_t") ExtentPurgeI extentPurgeI) {
        ExtentHooks.npurge_forced(this.address(), extentPurgeI);
        return this;
    }

    public ExtentHooks split(@Nullable @NativeType(value="extent_split_t") ExtentSplitI extentSplitI) {
        ExtentHooks.nsplit(this.address(), extentSplitI);
        return this;
    }

    public ExtentHooks merge(@Nullable @NativeType(value="extent_merge_t") ExtentMergeI extentMergeI) {
        ExtentHooks.nmerge(this.address(), extentMergeI);
        return this;
    }

    public ExtentHooks set(ExtentAllocI extentAllocI, ExtentDallocI extentDallocI, ExtentDestroyI extentDestroyI, ExtentCommitI extentCommitI, ExtentDecommitI extentDecommitI, ExtentPurgeI extentPurgeI, ExtentPurgeI extentPurgeI2, ExtentSplitI extentSplitI, ExtentMergeI extentMergeI) {
        this.alloc(extentAllocI);
        this.dalloc(extentDallocI);
        this.destroy(extentDestroyI);
        this.commit(extentCommitI);
        this.decommit(extentDecommitI);
        this.purge_lazy(extentPurgeI);
        this.purge_forced(extentPurgeI2);
        this.split(extentSplitI);
        this.merge(extentMergeI);
        return this;
    }

    public ExtentHooks set(ExtentHooks extentHooks) {
        MemoryUtil.memCopy(extentHooks.address(), this.address(), SIZEOF);
        return this;
    }

    public static ExtentHooks malloc() {
        return ExtentHooks.wrap(ExtentHooks.class, MemoryUtil.nmemAllocChecked(SIZEOF));
    }

    public static ExtentHooks calloc() {
        return ExtentHooks.wrap(ExtentHooks.class, MemoryUtil.nmemCallocChecked(1L, SIZEOF));
    }

    public static ExtentHooks create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return ExtentHooks.wrap(ExtentHooks.class, MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static ExtentHooks create(long l2) {
        return ExtentHooks.wrap(ExtentHooks.class, l2);
    }

    @Nullable
    public static ExtentHooks createSafe(long l2) {
        return l2 == 0L ? null : ExtentHooks.wrap(ExtentHooks.class, l2);
    }

    @Deprecated
    public static ExtentHooks mallocStack() {
        return ExtentHooks.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ExtentHooks callocStack() {
        return ExtentHooks.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ExtentHooks mallocStack(MemoryStack memoryStack) {
        return ExtentHooks.malloc(memoryStack);
    }

    @Deprecated
    public static ExtentHooks callocStack(MemoryStack memoryStack) {
        return ExtentHooks.calloc(memoryStack);
    }

    public static ExtentHooks malloc(MemoryStack memoryStack) {
        return ExtentHooks.wrap(ExtentHooks.class, memoryStack.nmalloc(ALIGNOF, SIZEOF));
    }

    public static ExtentHooks calloc(MemoryStack memoryStack) {
        return ExtentHooks.wrap(ExtentHooks.class, memoryStack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    public static ExtentAlloc nalloc(long l2) {
        return ExtentAlloc.create(MemoryUtil.memGetAddress(l2 + (long)ALLOC));
    }

    @Nullable
    public static ExtentDalloc ndalloc(long l2) {
        return ExtentDalloc.createSafe(MemoryUtil.memGetAddress(l2 + (long)DALLOC));
    }

    @Nullable
    public static ExtentDestroy ndestroy(long l2) {
        return ExtentDestroy.createSafe(MemoryUtil.memGetAddress(l2 + (long)DESTROY));
    }

    @Nullable
    public static ExtentCommit ncommit(long l2) {
        return ExtentCommit.createSafe(MemoryUtil.memGetAddress(l2 + (long)COMMIT));
    }

    @Nullable
    public static ExtentDecommit ndecommit(long l2) {
        return ExtentDecommit.createSafe(MemoryUtil.memGetAddress(l2 + (long)DECOMMIT));
    }

    @Nullable
    public static ExtentPurge npurge_lazy(long l2) {
        return ExtentPurge.createSafe(MemoryUtil.memGetAddress(l2 + (long)PURGE_LAZY));
    }

    @Nullable
    public static ExtentPurge npurge_forced(long l2) {
        return ExtentPurge.createSafe(MemoryUtil.memGetAddress(l2 + (long)PURGE_FORCED));
    }

    @Nullable
    public static ExtentSplit nsplit(long l2) {
        return ExtentSplit.createSafe(MemoryUtil.memGetAddress(l2 + (long)SPLIT));
    }

    @Nullable
    public static ExtentMerge nmerge(long l2) {
        return ExtentMerge.createSafe(MemoryUtil.memGetAddress(l2 + (long)MERGE));
    }

    public static void nalloc(long l2, ExtentAllocI extentAllocI) {
        MemoryUtil.memPutAddress(l2 + (long)ALLOC, extentAllocI.address());
    }

    public static void ndalloc(long l2, @Nullable ExtentDallocI extentDallocI) {
        MemoryUtil.memPutAddress(l2 + (long)DALLOC, MemoryUtil.memAddressSafe(extentDallocI));
    }

    public static void ndestroy(long l2, @Nullable ExtentDestroyI extentDestroyI) {
        MemoryUtil.memPutAddress(l2 + (long)DESTROY, MemoryUtil.memAddressSafe(extentDestroyI));
    }

    public static void ncommit(long l2, @Nullable ExtentCommitI extentCommitI) {
        MemoryUtil.memPutAddress(l2 + (long)COMMIT, MemoryUtil.memAddressSafe(extentCommitI));
    }

    public static void ndecommit(long l2, @Nullable ExtentDecommitI extentDecommitI) {
        MemoryUtil.memPutAddress(l2 + (long)DECOMMIT, MemoryUtil.memAddressSafe(extentDecommitI));
    }

    public static void npurge_lazy(long l2, @Nullable ExtentPurgeI extentPurgeI) {
        MemoryUtil.memPutAddress(l2 + (long)PURGE_LAZY, MemoryUtil.memAddressSafe(extentPurgeI));
    }

    public static void npurge_forced(long l2, @Nullable ExtentPurgeI extentPurgeI) {
        MemoryUtil.memPutAddress(l2 + (long)PURGE_FORCED, MemoryUtil.memAddressSafe(extentPurgeI));
    }

    public static void nsplit(long l2, @Nullable ExtentSplitI extentSplitI) {
        MemoryUtil.memPutAddress(l2 + (long)SPLIT, MemoryUtil.memAddressSafe(extentSplitI));
    }

    public static void nmerge(long l2, @Nullable ExtentMergeI extentMergeI) {
        MemoryUtil.memPutAddress(l2 + (long)MERGE, MemoryUtil.memAddressSafe(extentMergeI));
    }

    public static void validate(long l2) {
        Checks.check(MemoryUtil.memGetAddress(l2 + (long)ALLOC));
    }

    static {
        Struct.Layout layout = ExtentHooks.__struct(ExtentHooks.__member(POINTER_SIZE), ExtentHooks.__member(POINTER_SIZE), ExtentHooks.__member(POINTER_SIZE), ExtentHooks.__member(POINTER_SIZE), ExtentHooks.__member(POINTER_SIZE), ExtentHooks.__member(POINTER_SIZE), ExtentHooks.__member(POINTER_SIZE), ExtentHooks.__member(POINTER_SIZE), ExtentHooks.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        ALLOC = layout.offsetof(0);
        DALLOC = layout.offsetof(1);
        DESTROY = layout.offsetof(2);
        COMMIT = layout.offsetof(3);
        DECOMMIT = layout.offsetof(4);
        PURGE_LAZY = layout.offsetof(5);
        PURGE_FORCED = layout.offsetof(6);
        SPLIT = layout.offsetof(7);
        MERGE = layout.offsetof(8);
    }
}

