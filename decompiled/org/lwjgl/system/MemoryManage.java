/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Callback;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryAccessJNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.StackWalkUtil;
import org.lwjgl.system.libc.LibCStdlib;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;

final class MemoryManage {
    private MemoryManage() {
    }

    static MemoryUtil.MemoryAllocator getInstance() {
        Object object = Configuration.MEMORY_ALLOCATOR.get();
        if (object instanceof MemoryUtil.MemoryAllocator) {
            return (MemoryUtil.MemoryAllocator)object;
        }
        if (!"system".equals(object)) {
            String string = object == null || "jemalloc".equals(object) ? "org.lwjgl.system.jemalloc.JEmallocAllocator" : ("rpmalloc".equals(object) ? "org.lwjgl.system.rpmalloc.RPmallocAllocator" : object.toString());
            try {
                Class<?> clazz = Class.forName(string);
                return (MemoryUtil.MemoryAllocator)clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            catch (Throwable throwable) {
                if (Checks.DEBUG && object != null) {
                    throwable.printStackTrace(APIUtil.DEBUG_STREAM);
                }
                APIUtil.apiLog(String.format("Warning: Failed to instantiate memory allocator: %s. Using the system default.", string));
            }
        }
        return new StdlibAllocator();
    }

    static class DebugAllocator
    implements MemoryUtil.MemoryAllocator {
        private static final ConcurrentMap<Long, Allocation> ALLOCATIONS = new ConcurrentHashMap<Long, Allocation>();
        private static final ConcurrentMap<Long, String> THREADS = new ConcurrentHashMap<Long, String>();
        private final MemoryUtil.MemoryAllocator allocator;
        private final long[] callbacks;

        DebugAllocator(MemoryUtil.MemoryAllocator memoryAllocator) {
            this.allocator = memoryAllocator;
            this.callbacks = new long[]{new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l2, long l3) {
                    long l4 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3));
                    MemoryUtil.memPutAddress(l2, this.malloc(l4));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l2, long l3) {
                    long l4 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3));
                    long l5 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)POINTER_SIZE));
                    MemoryUtil.memPutAddress(l2, this.calloc(l4, l5));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l2, long l3) {
                    long l4 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3));
                    long l5 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)POINTER_SIZE));
                    MemoryUtil.memPutAddress(l2, this.realloc(l4, l5));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l2, long l3) {
                    long l4 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3));
                    this.free(l4);
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l2, long l3) {
                    long l4 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3));
                    long l5 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3 + (long)POINTER_SIZE));
                    MemoryUtil.memPutAddress(l2, this.aligned_alloc(l4, l5));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l2, long l3) {
                    long l4 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l3));
                    this.aligned_free(l4);
                }
            }.address()};
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                for (long l2 : this.callbacks) {
                    Callback.free(l2);
                }
                if (ALLOCATIONS.isEmpty()) {
                    return;
                }
                Object object = ALLOCATIONS.entrySet().iterator();
                while (object.hasNext()) {
                    Map.Entry entry = (Map.Entry)object.next();
                    Long l3 = (Long)entry.getKey();
                    Allocation allocation = (Allocation)entry.getValue();
                    APIUtil.DEBUG_STREAM.format("[LWJGL] %d bytes leaked, thread %d (%s), address: 0x%s\n", allocation.size, allocation.threadId, THREADS.get(allocation.threadId), Long.toHexString(l3).toUpperCase());
                    for (Object object2 : allocation.stackTrace) {
                        APIUtil.DEBUG_STREAM.format("\tat %s\n", object2.toString());
                    }
                }
            }));
        }

        @Override
        public long getMalloc() {
            return this.callbacks[0];
        }

        @Override
        public long getCalloc() {
            return this.callbacks[1];
        }

        @Override
        public long getRealloc() {
            return this.callbacks[2];
        }

        @Override
        public long getFree() {
            return this.callbacks[3];
        }

        @Override
        public long getAlignedAlloc() {
            return this.callbacks[4];
        }

        @Override
        public long getAlignedFree() {
            return this.callbacks[5];
        }

        @Override
        public long malloc(long l2) {
            return DebugAllocator.track(this.allocator.malloc(l2), l2);
        }

        @Override
        public long calloc(long l2, long l3) {
            return DebugAllocator.track(this.allocator.calloc(l2, l3), l2 * l3);
        }

        @Override
        public long realloc(long l2, long l3) {
            long l4 = DebugAllocator.untrack(l2);
            long l5 = this.allocator.realloc(l2, l3);
            if (l5 != 0L) {
                DebugAllocator.track(l5, l3);
            } else if (l3 != 0L) {
                DebugAllocator.track(l2, l4);
            }
            return l5;
        }

        @Override
        public void free(long l2) {
            DebugAllocator.untrack(l2);
            this.allocator.free(l2);
        }

        @Override
        public long aligned_alloc(long l2, long l3) {
            return DebugAllocator.track(this.allocator.aligned_alloc(l2, l3), l3);
        }

        @Override
        public void aligned_free(long l2) {
            DebugAllocator.untrack(l2);
            this.allocator.aligned_free(l2);
        }

        static long track(long l2, long l3) {
            if (l2 != 0L) {
                Allocation allocation;
                Thread thread = Thread.currentThread();
                Long l4 = thread.getId();
                if (!THREADS.containsKey(l4)) {
                    THREADS.put(l4, thread.getName());
                }
                if ((allocation = ALLOCATIONS.put(l2, new Allocation(StackWalkUtil.stackWalkGetTrace(), l3))) != null) {
                    throw new IllegalStateException("The memory address specified is already being tracked: 0x" + Long.toHexString(l2).toUpperCase());
                }
            }
            return l2;
        }

        static long untrack(long l2) {
            if (l2 == 0L) {
                return 0L;
            }
            Allocation allocation = (Allocation)ALLOCATIONS.remove(l2);
            if (allocation == null) {
                throw new IllegalStateException("The memory address specified is not being tracked: 0x" + Long.toHexString(l2).toUpperCase());
            }
            return allocation.size;
        }

        static void report(MemoryUtil.MemoryAllocationReport memoryAllocationReport) {
            for (Map.Entry entry : ALLOCATIONS.entrySet()) {
                Allocation allocation = (Allocation)entry.getValue();
                memoryAllocationReport.invoke((Long)entry.getKey(), allocation.size, allocation.threadId, (String)THREADS.get(allocation.threadId), allocation.getElements());
            }
        }

        private static <T> void aggregate(T t2, long l2, Map<T, AtomicLong> map) {
            AtomicLong atomicLong = map.computeIfAbsent(t2, object -> new AtomicLong());
            atomicLong.set(atomicLong.get() + l2);
        }

        static void report(MemoryUtil.MemoryAllocationReport memoryAllocationReport, MemoryUtil.MemoryAllocationReport.Aggregate aggregate, boolean bl2) {
            switch (aggregate) {
                case ALL: {
                    if (bl2) {
                        HashMap hashMap = new HashMap();
                        for (Allocation object : ALLOCATIONS.values()) {
                            DebugAllocator.aggregate(object.threadId, object.size, hashMap);
                        }
                        for (Map.Entry object : hashMap.entrySet()) {
                            memoryAllocationReport.invoke(0L, ((AtomicLong)object.getValue()).get(), (Long)object.getKey(), (String)THREADS.get(object.getKey()), null);
                        }
                        break;
                    }
                    long l3 = 0L;
                    for (Allocation allocation : ALLOCATIONS.values()) {
                        l3 += allocation.size;
                    }
                    memoryAllocationReport.invoke(0L, l3, 0L, null, null);
                    break;
                }
                case GROUP_BY_METHOD: {
                    if (bl2) {
                        HashMap<Long, Map> hashMap = new HashMap<Long, Map>();
                        for (Allocation object : ALLOCATIONS.values()) {
                            Map map = hashMap.computeIfAbsent(object.threadId, l2 -> new HashMap());
                            DebugAllocator.aggregate(object.getElements()[0], object.size, map);
                        }
                        for (Map.Entry entry : hashMap.entrySet()) {
                            long l3 = (Long)entry.getKey();
                            Map map = (Map)entry.getValue();
                            for (Map.Entry entry2 : map.entrySet()) {
                                memoryAllocationReport.invoke(0L, ((AtomicLong)entry2.getValue()).get(), l3, (String)THREADS.get(l3), (StackTraceElement)entry2.getKey());
                            }
                        }
                    } else {
                        HashMap hashMap = new HashMap();
                        for (Allocation allocation : ALLOCATIONS.values()) {
                            DebugAllocator.aggregate(allocation.getElements()[0], allocation.size, hashMap);
                        }
                        for (Map.Entry entry : hashMap.entrySet()) {
                            memoryAllocationReport.invoke(0L, ((AtomicLong)entry.getValue()).get(), 0L, null, (StackTraceElement)entry.getKey());
                        }
                    }
                    break;
                }
                case GROUP_BY_STACKTRACE: {
                    if (bl2) {
                        HashMap<Long, Map> hashMap = new HashMap<Long, Map>();
                        for (Allocation allocation : ALLOCATIONS.values()) {
                            Map map = hashMap.computeIfAbsent(allocation.threadId, l2 -> new HashMap());
                            DebugAllocator.aggregate(allocation, allocation.size, map);
                        }
                        for (Map.Entry entry : hashMap.entrySet()) {
                            long l4 = (Long)entry.getKey();
                            Map map = (Map)entry.getValue();
                            for (Map.Entry entry3 : map.entrySet()) {
                                memoryAllocationReport.invoke(0L, ((AtomicLong)entry3.getValue()).get(), l4, (String)THREADS.get(l4), ((Allocation)entry3.getKey()).getElements());
                            }
                        }
                    } else {
                        HashMap hashMap = new HashMap();
                        for (Allocation allocation : ALLOCATIONS.values()) {
                            DebugAllocator.aggregate(allocation, allocation.size, hashMap);
                        }
                        for (Map.Entry entry : hashMap.entrySet()) {
                            memoryAllocationReport.invoke(0L, ((AtomicLong)entry.getValue()).get(), 0L, null, ((Allocation)entry.getKey()).getElements());
                        }
                    }
                    break;
                }
            }
        }

        static class Allocation {
            private final Object[] stackTrace;
            @Nullable
            private StackTraceElement[] elements;
            final long size;
            final long threadId;

            Allocation(Object[] objectArray, long l2) {
                this.stackTrace = objectArray;
                this.size = l2;
                this.threadId = Thread.currentThread().getId();
            }

            private StackTraceElement[] getElements() {
                if (this.elements == null) {
                    this.elements = StackWalkUtil.stackWalkArray(this.stackTrace);
                }
                return this.elements;
            }

            public boolean equals(Object object) {
                if (this == object) {
                    return true;
                }
                if (object == null || this.getClass() != object.getClass()) {
                    return false;
                }
                Allocation allocation = (Allocation)object;
                return Arrays.equals(this.getElements(), allocation.getElements());
            }

            public int hashCode() {
                return Arrays.hashCode(this.getElements());
            }
        }
    }

    static class StdlibAllocator
    implements MemoryUtil.MemoryAllocator {
        private StdlibAllocator() {
        }

        @Override
        public long getMalloc() {
            return MemoryAccessJNI.malloc;
        }

        @Override
        public long getCalloc() {
            return MemoryAccessJNI.calloc;
        }

        @Override
        public long getRealloc() {
            return MemoryAccessJNI.realloc;
        }

        @Override
        public long getFree() {
            return MemoryAccessJNI.free;
        }

        @Override
        public long getAlignedAlloc() {
            return MemoryAccessJNI.aligned_alloc;
        }

        @Override
        public long getAlignedFree() {
            return MemoryAccessJNI.aligned_free;
        }

        @Override
        public long malloc(long l2) {
            return LibCStdlib.nmalloc(l2);
        }

        @Override
        public long calloc(long l2, long l3) {
            return LibCStdlib.ncalloc(l2, l3);
        }

        @Override
        public long realloc(long l2, long l3) {
            return LibCStdlib.nrealloc(l2, l3);
        }

        @Override
        public void free(long l2) {
            LibCStdlib.nfree(l2);
        }

        @Override
        public long aligned_alloc(long l2, long l3) {
            return LibCStdlib.naligned_alloc(l2, l3);
        }

        @Override
        public void aligned_free(long l2) {
            LibCStdlib.naligned_free(l2);
        }
    }
}

