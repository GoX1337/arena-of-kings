/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.WeakMemoryHolder;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Memory
extends Pointer {
    private static ReferenceQueue<Memory> QUEUE = new ReferenceQueue();
    private static LinkedReference HEAD;
    private static final WeakMemoryHolder buffers;
    private final LinkedReference reference;
    protected long size;

    public static void purge() {
        buffers.clean();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void disposeAll() {
        Object object = LinkedReference.class;
        synchronized (LinkedReference.class) {
            LinkedReference linkedReference;
            while ((linkedReference = HEAD) != null) {
                Memory memory = (Memory)HEAD.get();
                if (memory != null) {
                    memory.dispose();
                } else {
                    Memory.HEAD.unlink();
                }
                if (HEAD != linkedReference) continue;
                throw new IllegalStateException("the HEAD did not change");
            }
            // ** MonitorExit[var0] (shouldn't be in output)
            object = QUEUE;
            synchronized (object) {
                while ((linkedReference = (LinkedReference)QUEUE.poll()) != null) {
                    linkedReference.unlink();
                }
            }
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static int integrityCheck() {
        Class<LinkedReference> clazz = LinkedReference.class;
        synchronized (LinkedReference.class) {
            if (HEAD == null) {
                // ** MonitorExit[var0] (shouldn't be in output)
                return 0;
            }
            ArrayList<LinkedReference> arrayList = new ArrayList<LinkedReference>();
            LinkedReference linkedReference = HEAD;
            while (linkedReference != null) {
                arrayList.add(linkedReference);
                linkedReference = linkedReference.next;
            }
            int n2 = arrayList.size() - 1;
            linkedReference = (LinkedReference)arrayList.get(n2);
            while (linkedReference != null) {
                if (arrayList.get(n2) != linkedReference) {
                    throw new IllegalStateException(arrayList.get(n2) + " vs. " + linkedReference + " at index " + n2);
                }
                linkedReference = linkedReference.prev;
                --n2;
            }
            // ** MonitorExit[var0] (shouldn't be in output)
            return arrayList.size();
        }
    }

    public Memory(long l2) {
        this.size = l2;
        if (l2 <= 0L) {
            throw new IllegalArgumentException("Allocation size must be greater than zero");
        }
        this.peer = Memory.malloc(l2);
        if (this.peer == 0L) {
            throw new OutOfMemoryError("Cannot allocate " + l2 + " bytes");
        }
        this.reference = LinkedReference.track(this);
    }

    protected Memory() {
        this.reference = null;
    }

    @Override
    public Pointer share(long l2) {
        return this.share(l2, this.size() - l2);
    }

    @Override
    public Pointer share(long l2, long l3) {
        this.boundsCheck(l2, l3);
        return new SharedMemory(l2, l3);
    }

    public Memory align(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("Byte boundary must be positive: " + n2);
        }
        for (int i2 = 0; i2 < 32; ++i2) {
            if (n2 != 1 << i2) continue;
            long l2 = (long)n2 - 1L ^ 0xFFFFFFFFFFFFFFFFL;
            if ((this.peer & l2) != this.peer) {
                long l3 = this.peer + (long)n2 - 1L & l2;
                long l4 = this.peer + this.size - l3;
                if (l4 <= 0L) {
                    throw new IllegalArgumentException("Insufficient memory to align to the requested boundary");
                }
                return (Memory)this.share(l3 - this.peer, l4);
            }
            return this;
        }
        throw new IllegalArgumentException("Byte boundary must be a power of two");
    }

    protected void finalize() {
        this.dispose();
    }

    protected synchronized void dispose() {
        if (this.peer == 0L) {
            return;
        }
        try {
            Memory.free(this.peer);
        }
        finally {
            this.peer = 0L;
            this.reference.unlink();
        }
    }

    public void clear() {
        this.clear(this.size);
    }

    public boolean valid() {
        return this.peer != 0L;
    }

    public long size() {
        return this.size;
    }

    protected void boundsCheck(long l2, long l3) {
        if (l2 < 0L) {
            throw new IndexOutOfBoundsException("Invalid offset: " + l2);
        }
        if (l2 + l3 > this.size) {
            String string = "Bounds exceeds available space : size=" + this.size + ", offset=" + (l2 + l3);
            throw new IndexOutOfBoundsException(string);
        }
    }

    @Override
    public void read(long l2, byte[] byArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 1L);
        super.read(l2, byArray, n2, n3);
    }

    @Override
    public void read(long l2, short[] sArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 2L);
        super.read(l2, sArray, n2, n3);
    }

    @Override
    public void read(long l2, char[] cArray, int n2, int n3) {
        this.boundsCheck(l2, n3 * Native.WCHAR_SIZE);
        super.read(l2, cArray, n2, n3);
    }

    @Override
    public void read(long l2, int[] nArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 4L);
        super.read(l2, nArray, n2, n3);
    }

    @Override
    public void read(long l2, long[] lArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 8L);
        super.read(l2, lArray, n2, n3);
    }

    @Override
    public void read(long l2, float[] fArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 4L);
        super.read(l2, fArray, n2, n3);
    }

    @Override
    public void read(long l2, double[] dArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 8L);
        super.read(l2, dArray, n2, n3);
    }

    @Override
    public void read(long l2, Pointer[] pointerArray, int n2, int n3) {
        this.boundsCheck(l2, n3 * Native.POINTER_SIZE);
        super.read(l2, pointerArray, n2, n3);
    }

    @Override
    public void write(long l2, byte[] byArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 1L);
        super.write(l2, byArray, n2, n3);
    }

    @Override
    public void write(long l2, short[] sArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 2L);
        super.write(l2, sArray, n2, n3);
    }

    @Override
    public void write(long l2, char[] cArray, int n2, int n3) {
        this.boundsCheck(l2, n3 * Native.WCHAR_SIZE);
        super.write(l2, cArray, n2, n3);
    }

    @Override
    public void write(long l2, int[] nArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 4L);
        super.write(l2, nArray, n2, n3);
    }

    @Override
    public void write(long l2, long[] lArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 8L);
        super.write(l2, lArray, n2, n3);
    }

    @Override
    public void write(long l2, float[] fArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 4L);
        super.write(l2, fArray, n2, n3);
    }

    @Override
    public void write(long l2, double[] dArray, int n2, int n3) {
        this.boundsCheck(l2, (long)n3 * 8L);
        super.write(l2, dArray, n2, n3);
    }

    @Override
    public void write(long l2, Pointer[] pointerArray, int n2, int n3) {
        this.boundsCheck(l2, n3 * Native.POINTER_SIZE);
        super.write(l2, pointerArray, n2, n3);
    }

    @Override
    public byte getByte(long l2) {
        this.boundsCheck(l2, 1L);
        return super.getByte(l2);
    }

    @Override
    public char getChar(long l2) {
        this.boundsCheck(l2, Native.WCHAR_SIZE);
        return super.getChar(l2);
    }

    @Override
    public short getShort(long l2) {
        this.boundsCheck(l2, 2L);
        return super.getShort(l2);
    }

    @Override
    public int getInt(long l2) {
        this.boundsCheck(l2, 4L);
        return super.getInt(l2);
    }

    @Override
    public long getLong(long l2) {
        this.boundsCheck(l2, 8L);
        return super.getLong(l2);
    }

    @Override
    public float getFloat(long l2) {
        this.boundsCheck(l2, 4L);
        return super.getFloat(l2);
    }

    @Override
    public double getDouble(long l2) {
        this.boundsCheck(l2, 8L);
        return super.getDouble(l2);
    }

    @Override
    public Pointer getPointer(long l2) {
        this.boundsCheck(l2, Native.POINTER_SIZE);
        return this.shareReferenceIfInBounds(super.getPointer(l2));
    }

    @Override
    public ByteBuffer getByteBuffer(long l2, long l3) {
        this.boundsCheck(l2, l3);
        ByteBuffer byteBuffer = super.getByteBuffer(l2, l3);
        buffers.put(byteBuffer, this);
        return byteBuffer;
    }

    @Override
    public String getString(long l2, String string) {
        this.boundsCheck(l2, 0L);
        return super.getString(l2, string);
    }

    @Override
    public String getWideString(long l2) {
        this.boundsCheck(l2, 0L);
        return super.getWideString(l2);
    }

    @Override
    public void setByte(long l2, byte by2) {
        this.boundsCheck(l2, 1L);
        super.setByte(l2, by2);
    }

    @Override
    public void setChar(long l2, char c2) {
        this.boundsCheck(l2, Native.WCHAR_SIZE);
        super.setChar(l2, c2);
    }

    @Override
    public void setShort(long l2, short s2) {
        this.boundsCheck(l2, 2L);
        super.setShort(l2, s2);
    }

    @Override
    public void setInt(long l2, int n2) {
        this.boundsCheck(l2, 4L);
        super.setInt(l2, n2);
    }

    @Override
    public void setLong(long l2, long l3) {
        this.boundsCheck(l2, 8L);
        super.setLong(l2, l3);
    }

    @Override
    public void setFloat(long l2, float f2) {
        this.boundsCheck(l2, 4L);
        super.setFloat(l2, f2);
    }

    @Override
    public void setDouble(long l2, double d2) {
        this.boundsCheck(l2, 8L);
        super.setDouble(l2, d2);
    }

    @Override
    public void setPointer(long l2, Pointer pointer) {
        this.boundsCheck(l2, Native.POINTER_SIZE);
        super.setPointer(l2, pointer);
    }

    @Override
    public void setString(long l2, String string, String string2) {
        this.boundsCheck(l2, (long)Native.getBytes(string, string2).length + 1L);
        super.setString(l2, string, string2);
    }

    @Override
    public void setWideString(long l2, String string) {
        this.boundsCheck(l2, ((long)string.length() + 1L) * (long)Native.WCHAR_SIZE);
        super.setWideString(l2, string);
    }

    @Override
    public String toString() {
        return "allocated@0x" + Long.toHexString(this.peer) + " (" + this.size + " bytes)";
    }

    protected static void free(long l2) {
        if (l2 != 0L) {
            Native.free(l2);
        }
    }

    protected static long malloc(long l2) {
        return Native.malloc(l2);
    }

    public String dump() {
        return this.dump(0L, (int)this.size());
    }

    private Pointer shareReferenceIfInBounds(Pointer pointer) {
        if (pointer == null) {
            return null;
        }
        long l2 = pointer.peer - this.peer;
        if (l2 >= 0L && l2 < this.size) {
            return this.share(l2);
        }
        return pointer;
    }

    static {
        buffers = new WeakMemoryHolder();
    }

    class SharedMemory
    extends Memory {
        public SharedMemory(long l2, long l3) {
            this.size = l3;
            this.peer = Memory.this.peer + l2;
        }

        @Override
        protected synchronized void dispose() {
            this.peer = 0L;
        }

        @Override
        protected void boundsCheck(long l2, long l3) {
            Memory.this.boundsCheck(this.peer - Memory.this.peer + l2, l3);
        }

        @Override
        public String toString() {
            return super.toString() + " (shared from " + Memory.this.toString() + ")";
        }
    }

    static class LinkedReference
    extends WeakReference<Memory> {
        private LinkedReference next;
        private LinkedReference prev;

        private LinkedReference(Memory memory) {
            super(memory, QUEUE);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        static LinkedReference track(Memory memory) {
            Object object;
            Object object2 = QUEUE;
            synchronized (object2) {
                while ((object = (LinkedReference)QUEUE.poll()) != null) {
                    ((LinkedReference)object).unlink();
                }
            }
            object2 = new LinkedReference(memory);
            object = LinkedReference.class;
            synchronized (LinkedReference.class) {
                if (HEAD != null) {
                    ((LinkedReference)object2).next = HEAD;
                    HEAD.prev = object2;
                    HEAD = (LinkedReference)HEAD.prev;
                } else {
                    HEAD = (LinkedReference)object2;
                }
                // ** MonitorExit[var2_2] (shouldn't be in output)
                return object2;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void unlink() {
            Class<LinkedReference> clazz = LinkedReference.class;
            synchronized (LinkedReference.class) {
                LinkedReference linkedReference;
                if (HEAD != this) {
                    if (this.prev == null) {
                        // ** MonitorExit[var1_1] (shouldn't be in output)
                        return;
                    }
                    linkedReference = this.prev.next = this.next;
                } else {
                    linkedReference = HEAD = HEAD.next;
                }
                if (linkedReference != null) {
                    linkedReference.prev = this.prev;
                }
                this.prev = null;
                // ** MonitorExit[var1_1] (shouldn't be in output)
                return;
            }
        }
    }
}

