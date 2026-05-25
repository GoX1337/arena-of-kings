/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Callback;
import com.sun.jna.CallbackReference;
import com.sun.jna.FromNativeContext;
import com.sun.jna.Function;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import com.sun.jna.Platform;
import com.sun.jna.Structure;
import com.sun.jna.ToNativeContext;
import com.sun.jna.WString;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class Pointer {
    public static final Pointer NULL = null;
    protected long peer;

    public static final Pointer createConstant(long l2) {
        return new Opaque(l2);
    }

    public static final Pointer createConstant(int n2) {
        return new Opaque((long)n2 & 0xFFFFFFFFFFFFFFFFL);
    }

    Pointer() {
    }

    public Pointer(long l2) {
        this.peer = l2;
    }

    public Pointer share(long l2) {
        return this.share(l2, 0L);
    }

    public Pointer share(long l2, long l3) {
        if (l2 == 0L) {
            return this;
        }
        return new Pointer(this.peer + l2);
    }

    public void clear(long l2) {
        this.setMemory(0L, l2, (byte)0);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        return object instanceof Pointer && ((Pointer)object).peer == this.peer;
    }

    public int hashCode() {
        return (int)((this.peer >>> 32) + (this.peer & 0xFFFFFFFFFFFFFFFFL));
    }

    public long indexOf(long l2, byte by2) {
        return Native.indexOf(this, this.peer, l2, by2);
    }

    public void read(long l2, byte[] byArray, int n2, int n3) {
        Native.read(this, this.peer, l2, byArray, n2, n3);
    }

    public void read(long l2, short[] sArray, int n2, int n3) {
        Native.read(this, this.peer, l2, sArray, n2, n3);
    }

    public void read(long l2, char[] cArray, int n2, int n3) {
        Native.read(this, this.peer, l2, cArray, n2, n3);
    }

    public void read(long l2, int[] nArray, int n2, int n3) {
        Native.read(this, this.peer, l2, nArray, n2, n3);
    }

    public void read(long l2, long[] lArray, int n2, int n3) {
        Native.read(this, this.peer, l2, lArray, n2, n3);
    }

    public void read(long l2, float[] fArray, int n2, int n3) {
        Native.read(this, this.peer, l2, fArray, n2, n3);
    }

    public void read(long l2, double[] dArray, int n2, int n3) {
        Native.read(this, this.peer, l2, dArray, n2, n3);
    }

    public void read(long l2, Pointer[] pointerArray, int n2, int n3) {
        for (int i2 = 0; i2 < n3; ++i2) {
            Pointer pointer = this.getPointer(l2 + (long)(i2 * Native.POINTER_SIZE));
            Pointer pointer2 = pointerArray[i2 + n2];
            if (pointer2 != null && pointer != null && pointer.peer == pointer2.peer) continue;
            pointerArray[i2 + n2] = pointer;
        }
    }

    public void write(long l2, byte[] byArray, int n2, int n3) {
        Native.write(this, this.peer, l2, byArray, n2, n3);
    }

    public void write(long l2, short[] sArray, int n2, int n3) {
        Native.write(this, this.peer, l2, sArray, n2, n3);
    }

    public void write(long l2, char[] cArray, int n2, int n3) {
        Native.write(this, this.peer, l2, cArray, n2, n3);
    }

    public void write(long l2, int[] nArray, int n2, int n3) {
        Native.write(this, this.peer, l2, nArray, n2, n3);
    }

    public void write(long l2, long[] lArray, int n2, int n3) {
        Native.write(this, this.peer, l2, lArray, n2, n3);
    }

    public void write(long l2, float[] fArray, int n2, int n3) {
        Native.write(this, this.peer, l2, fArray, n2, n3);
    }

    public void write(long l2, double[] dArray, int n2, int n3) {
        Native.write(this, this.peer, l2, dArray, n2, n3);
    }

    public void write(long l2, Pointer[] pointerArray, int n2, int n3) {
        for (int i2 = 0; i2 < n3; ++i2) {
            this.setPointer(l2 + (long)(i2 * Native.POINTER_SIZE), pointerArray[n2 + i2]);
        }
    }

    Object getValue(long l2, Class<?> clazz, Object object) {
        Object object2 = null;
        if (Structure.class.isAssignableFrom(clazz)) {
            Structure structure = (Structure)object;
            if (Structure.ByReference.class.isAssignableFrom(clazz)) {
                structure = Structure.updateStructureByReference(clazz, structure, this.getPointer(l2));
            } else {
                structure.useMemory(this, (int)l2, true);
                structure.read();
            }
            object2 = structure;
        } else if (clazz == Boolean.TYPE || clazz == Boolean.class) {
            object2 = Function.valueOf(this.getInt(l2) != 0);
        } else if (clazz == Byte.TYPE || clazz == Byte.class) {
            object2 = this.getByte(l2);
        } else if (clazz == Short.TYPE || clazz == Short.class) {
            object2 = this.getShort(l2);
        } else if (clazz == Character.TYPE || clazz == Character.class) {
            object2 = Character.valueOf(this.getChar(l2));
        } else if (clazz == Integer.TYPE || clazz == Integer.class) {
            object2 = this.getInt(l2);
        } else if (clazz == Long.TYPE || clazz == Long.class) {
            object2 = this.getLong(l2);
        } else if (clazz == Float.TYPE || clazz == Float.class) {
            object2 = Float.valueOf(this.getFloat(l2));
        } else if (clazz == Double.TYPE || clazz == Double.class) {
            object2 = this.getDouble(l2);
        } else if (Pointer.class.isAssignableFrom(clazz)) {
            Pointer pointer = this.getPointer(l2);
            if (pointer != null) {
                Pointer pointer2;
                Pointer pointer3 = pointer2 = object instanceof Pointer ? (Pointer)object : null;
                object2 = pointer2 == null || pointer.peer != pointer2.peer ? pointer : pointer2;
            }
        } else if (clazz == String.class) {
            Pointer pointer = this.getPointer(l2);
            object2 = pointer != null ? pointer.getString(0L) : null;
        } else if (clazz == WString.class) {
            Pointer pointer = this.getPointer(l2);
            object2 = pointer != null ? new WString(pointer.getWideString(0L)) : null;
        } else if (Callback.class.isAssignableFrom(clazz)) {
            Pointer pointer = this.getPointer(l2);
            if (pointer == null) {
                object2 = null;
            } else {
                Callback callback = (Callback)object;
                Pointer pointer4 = CallbackReference.getFunctionPointer(callback);
                if (!pointer.equals(pointer4)) {
                    callback = CallbackReference.getCallback(clazz, pointer);
                }
                object2 = callback;
            }
        } else if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(clazz)) {
            Pointer pointer = this.getPointer(l2);
            if (pointer == null) {
                object2 = null;
            } else {
                Pointer pointer5;
                Pointer pointer6 = pointer5 = object == null ? null : Native.getDirectBufferPointer((Buffer)object);
                if (pointer5 == null || !pointer5.equals(pointer)) {
                    throw new IllegalStateException("Can't autogenerate a direct buffer on memory read");
                }
                object2 = object;
            }
        } else if (NativeMapped.class.isAssignableFrom(clazz)) {
            NativeMapped nativeMapped = (NativeMapped)object;
            if (nativeMapped != null) {
                Object object3 = this.getValue(l2, nativeMapped.nativeType(), null);
                object2 = nativeMapped.fromNative(object3, new FromNativeContext(clazz));
                if (nativeMapped.equals(object2)) {
                    object2 = nativeMapped;
                }
            } else {
                NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(clazz);
                Object object4 = this.getValue(l2, nativeMappedConverter.nativeType(), null);
                object2 = nativeMappedConverter.fromNative(object4, new FromNativeContext(clazz));
            }
        } else if (clazz.isArray()) {
            object2 = object;
            if (object2 == null) {
                throw new IllegalStateException("Need an initialized array");
            }
            this.readArray(l2, object2, clazz.getComponentType());
        } else {
            throw new IllegalArgumentException("Reading \"" + clazz + "\" from memory is not supported");
        }
        return object2;
    }

    private void readArray(long l2, Object object, Class<?> clazz) {
        int n2 = 0;
        n2 = Array.getLength(object);
        Object object2 = object;
        if (clazz == Byte.TYPE) {
            this.read(l2, (byte[])object2, 0, n2);
        } else if (clazz == Short.TYPE) {
            this.read(l2, (short[])object2, 0, n2);
        } else if (clazz == Character.TYPE) {
            this.read(l2, (char[])object2, 0, n2);
        } else if (clazz == Integer.TYPE) {
            this.read(l2, (int[])object2, 0, n2);
        } else if (clazz == Long.TYPE) {
            this.read(l2, (long[])object2, 0, n2);
        } else if (clazz == Float.TYPE) {
            this.read(l2, (float[])object2, 0, n2);
        } else if (clazz == Double.TYPE) {
            this.read(l2, (double[])object2, 0, n2);
        } else if (Pointer.class.isAssignableFrom(clazz)) {
            this.read(l2, (Pointer[])object2, 0, n2);
        } else if (Structure.class.isAssignableFrom(clazz)) {
            Structure[] structureArray = (Structure[])object2;
            if (Structure.ByReference.class.isAssignableFrom(clazz)) {
                Pointer[] pointerArray = this.getPointerArray(l2, structureArray.length);
                for (int i2 = 0; i2 < structureArray.length; ++i2) {
                    structureArray[i2] = Structure.updateStructureByReference(clazz, structureArray[i2], pointerArray[i2]);
                }
            } else {
                Structure structure = structureArray[0];
                if (structure == null) {
                    structure = Structure.newInstance(clazz, this.share(l2));
                    structure.conditionalAutoRead();
                    structureArray[0] = structure;
                } else {
                    structure.useMemory(this, (int)l2, true);
                    structure.read();
                }
                Structure[] structureArray2 = structure.com_sun_jna_Structure_arr_toArray(structureArray.length);
                for (int i3 = 1; i3 < structureArray.length; ++i3) {
                    if (structureArray[i3] == null) {
                        structureArray[i3] = structureArray2[i3];
                        continue;
                    }
                    structureArray[i3].useMemory(this, (int)(l2 + (long)(i3 * structureArray[i3].size())), true);
                    structureArray[i3].read();
                }
            }
        } else if (NativeMapped.class.isAssignableFrom(clazz)) {
            NativeMapped[] nativeMappedArray = (NativeMapped[])object2;
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(clazz);
            int n3 = Native.getNativeSize(object2.getClass(), object2) / nativeMappedArray.length;
            for (int i4 = 0; i4 < nativeMappedArray.length; ++i4) {
                Object object3 = this.getValue(l2 + (long)(n3 * i4), nativeMappedConverter.nativeType(), nativeMappedArray[i4]);
                nativeMappedArray[i4] = (NativeMapped)nativeMappedConverter.fromNative(object3, new FromNativeContext(clazz));
            }
        } else {
            throw new IllegalArgumentException("Reading array of " + clazz + " from memory not supported");
        }
    }

    public byte getByte(long l2) {
        return Native.getByte(this, this.peer, l2);
    }

    public char getChar(long l2) {
        return Native.getChar(this, this.peer, l2);
    }

    public short getShort(long l2) {
        return Native.getShort(this, this.peer, l2);
    }

    public int getInt(long l2) {
        return Native.getInt(this, this.peer, l2);
    }

    public long getLong(long l2) {
        return Native.getLong(this, this.peer, l2);
    }

    public NativeLong getNativeLong(long l2) {
        return new NativeLong(NativeLong.SIZE == 8 ? this.getLong(l2) : (long)this.getInt(l2));
    }

    public float getFloat(long l2) {
        return Native.getFloat(this, this.peer, l2);
    }

    public double getDouble(long l2) {
        return Native.getDouble(this, this.peer, l2);
    }

    public Pointer getPointer(long l2) {
        return Native.getPointer(this.peer + l2);
    }

    public ByteBuffer getByteBuffer(long l2, long l3) {
        return Native.getDirectByteBuffer(this, this.peer, l2, l3).order(ByteOrder.nativeOrder());
    }

    public String getWideString(long l2) {
        return Native.getWideString(this, this.peer, l2);
    }

    public String getString(long l2) {
        return this.getString(l2, Native.getDefaultStringEncoding());
    }

    public String getString(long l2, String string) {
        return Native.getString(this, l2, string);
    }

    public byte[] getByteArray(long l2, int n2) {
        byte[] byArray = new byte[n2];
        this.read(l2, byArray, 0, n2);
        return byArray;
    }

    public char[] getCharArray(long l2, int n2) {
        char[] cArray = new char[n2];
        this.read(l2, cArray, 0, n2);
        return cArray;
    }

    public short[] getShortArray(long l2, int n2) {
        short[] sArray = new short[n2];
        this.read(l2, sArray, 0, n2);
        return sArray;
    }

    public int[] getIntArray(long l2, int n2) {
        int[] nArray = new int[n2];
        this.read(l2, nArray, 0, n2);
        return nArray;
    }

    public long[] getLongArray(long l2, int n2) {
        long[] lArray = new long[n2];
        this.read(l2, lArray, 0, n2);
        return lArray;
    }

    public float[] getFloatArray(long l2, int n2) {
        float[] fArray = new float[n2];
        this.read(l2, fArray, 0, n2);
        return fArray;
    }

    public double[] getDoubleArray(long l2, int n2) {
        double[] dArray = new double[n2];
        this.read(l2, dArray, 0, n2);
        return dArray;
    }

    public Pointer[] getPointerArray(long l2) {
        ArrayList<Pointer> arrayList = new ArrayList<Pointer>();
        int n2 = 0;
        Pointer pointer = this.getPointer(l2);
        while (pointer != null) {
            arrayList.add(pointer);
            pointer = this.getPointer(l2 + (long)(n2 += Native.POINTER_SIZE));
        }
        return arrayList.toArray(new Pointer[0]);
    }

    public Pointer[] getPointerArray(long l2, int n2) {
        Pointer[] pointerArray = new Pointer[n2];
        this.read(l2, pointerArray, 0, n2);
        return pointerArray;
    }

    public String[] getStringArray(long l2) {
        return this.getStringArray(l2, -1, Native.getDefaultStringEncoding());
    }

    public String[] getStringArray(long l2, String string) {
        return this.getStringArray(l2, -1, string);
    }

    public String[] getStringArray(long l2, int n2) {
        return this.getStringArray(l2, n2, Native.getDefaultStringEncoding());
    }

    public String[] getWideStringArray(long l2) {
        return this.getWideStringArray(l2, -1);
    }

    public String[] getWideStringArray(long l2, int n2) {
        return this.getStringArray(l2, n2, "--WIDE-STRING--");
    }

    public String[] getStringArray(long l2, int n2, String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n3 = 0;
        if (n2 != -1) {
            Pointer pointer = this.getPointer(l2 + (long)n3);
            int n4 = 0;
            while (n4++ < n2) {
                String string2 = pointer == null ? null : ("--WIDE-STRING--".equals(string) ? pointer.getWideString(0L) : pointer.getString(0L, string));
                arrayList.add(string2);
                if (n4 >= n2) continue;
                pointer = this.getPointer(l2 + (long)(n3 += Native.POINTER_SIZE));
            }
        } else {
            Pointer pointer;
            while ((pointer = this.getPointer(l2 + (long)n3)) != null) {
                String string3 = "--WIDE-STRING--".equals(string) ? pointer.getWideString(0L) : pointer.getString(0L, string);
                arrayList.add(string3);
                n3 += Native.POINTER_SIZE;
            }
        }
        return arrayList.toArray(new String[0]);
    }

    void setValue(long l2, Object object, Class<?> clazz) {
        if (clazz == Boolean.TYPE || clazz == Boolean.class) {
            this.setInt(l2, Boolean.TRUE.equals(object) ? -1 : 0);
        } else if (clazz == Byte.TYPE || clazz == Byte.class) {
            this.setByte(l2, object == null ? (byte)0 : (Byte)object);
        } else if (clazz == Short.TYPE || clazz == Short.class) {
            this.setShort(l2, object == null ? (short)0 : (Short)object);
        } else if (clazz == Character.TYPE || clazz == Character.class) {
            this.setChar(l2, object == null ? (char)'\u0000' : ((Character)object).charValue());
        } else if (clazz == Integer.TYPE || clazz == Integer.class) {
            this.setInt(l2, object == null ? 0 : (Integer)object);
        } else if (clazz == Long.TYPE || clazz == Long.class) {
            this.setLong(l2, object == null ? 0L : (Long)object);
        } else if (clazz == Float.TYPE || clazz == Float.class) {
            this.setFloat(l2, object == null ? 0.0f : ((Float)object).floatValue());
        } else if (clazz == Double.TYPE || clazz == Double.class) {
            this.setDouble(l2, object == null ? 0.0 : (Double)object);
        } else if (clazz == Pointer.class) {
            this.setPointer(l2, (Pointer)object);
        } else if (clazz == String.class) {
            this.setPointer(l2, (Pointer)object);
        } else if (clazz == WString.class) {
            this.setPointer(l2, (Pointer)object);
        } else if (Structure.class.isAssignableFrom(clazz)) {
            Structure structure = (Structure)object;
            if (Structure.ByReference.class.isAssignableFrom(clazz)) {
                this.setPointer(l2, structure == null ? null : structure.getPointer());
                if (structure != null) {
                    structure.autoWrite();
                }
            } else {
                structure.useMemory(this, (int)l2, true);
                structure.write();
            }
        } else if (Callback.class.isAssignableFrom(clazz)) {
            this.setPointer(l2, CallbackReference.getFunctionPointer((Callback)object));
        } else if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(clazz)) {
            Pointer pointer = object == null ? null : Native.getDirectBufferPointer((Buffer)object);
            this.setPointer(l2, pointer);
        } else if (NativeMapped.class.isAssignableFrom(clazz)) {
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(clazz);
            Class<?> clazz2 = nativeMappedConverter.nativeType();
            this.setValue(l2, nativeMappedConverter.toNative(object, new ToNativeContext()), clazz2);
        } else if (clazz.isArray()) {
            this.writeArray(l2, object, clazz.getComponentType());
        } else {
            throw new IllegalArgumentException("Writing " + clazz + " to memory is not supported");
        }
    }

    private void writeArray(long l2, Object object, Class<?> clazz) {
        if (clazz == Byte.TYPE) {
            byte[] byArray = (byte[])object;
            this.write(l2, byArray, 0, byArray.length);
        } else if (clazz == Short.TYPE) {
            short[] sArray = (short[])object;
            this.write(l2, sArray, 0, sArray.length);
        } else if (clazz == Character.TYPE) {
            char[] cArray = (char[])object;
            this.write(l2, cArray, 0, cArray.length);
        } else if (clazz == Integer.TYPE) {
            int[] nArray = (int[])object;
            this.write(l2, nArray, 0, nArray.length);
        } else if (clazz == Long.TYPE) {
            long[] lArray = (long[])object;
            this.write(l2, lArray, 0, lArray.length);
        } else if (clazz == Float.TYPE) {
            float[] fArray = (float[])object;
            this.write(l2, fArray, 0, fArray.length);
        } else if (clazz == Double.TYPE) {
            double[] dArray = (double[])object;
            this.write(l2, dArray, 0, dArray.length);
        } else if (Pointer.class.isAssignableFrom(clazz)) {
            Pointer[] pointerArray = (Pointer[])object;
            this.write(l2, pointerArray, 0, pointerArray.length);
        } else if (Structure.class.isAssignableFrom(clazz)) {
            Structure[] structureArray = (Structure[])object;
            if (Structure.ByReference.class.isAssignableFrom(clazz)) {
                Pointer[] pointerArray = new Pointer[structureArray.length];
                for (int i2 = 0; i2 < structureArray.length; ++i2) {
                    if (structureArray[i2] == null) {
                        pointerArray[i2] = null;
                        continue;
                    }
                    pointerArray[i2] = structureArray[i2].getPointer();
                    structureArray[i2].write();
                }
                this.write(l2, pointerArray, 0, pointerArray.length);
            } else {
                Structure structure = structureArray[0];
                if (structure == null) {
                    structureArray[0] = structure = Structure.newInstance(clazz, this.share(l2));
                } else {
                    structure.useMemory(this, (int)l2, true);
                }
                structure.write();
                Structure[] structureArray2 = structure.com_sun_jna_Structure_arr_toArray(structureArray.length);
                for (int i3 = 1; i3 < structureArray.length; ++i3) {
                    if (structureArray[i3] == null) {
                        structureArray[i3] = structureArray2[i3];
                    } else {
                        structureArray[i3].useMemory(this, (int)(l2 + (long)(i3 * structureArray[i3].size())), true);
                    }
                    structureArray[i3].write();
                }
            }
        } else if (NativeMapped.class.isAssignableFrom(clazz)) {
            NativeMapped[] nativeMappedArray = (NativeMapped[])object;
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(clazz);
            Class<?> clazz2 = nativeMappedConverter.nativeType();
            int n2 = Native.getNativeSize(object.getClass(), object) / nativeMappedArray.length;
            for (int i4 = 0; i4 < nativeMappedArray.length; ++i4) {
                Object object2 = nativeMappedConverter.toNative(nativeMappedArray[i4], new ToNativeContext());
                this.setValue(l2 + (long)(i4 * n2), object2, clazz2);
            }
        } else {
            throw new IllegalArgumentException("Writing array of " + clazz + " to memory not supported");
        }
    }

    public void setMemory(long l2, long l3, byte by2) {
        Native.setMemory(this, this.peer, l2, l3, by2);
    }

    public void setByte(long l2, byte by2) {
        Native.setByte(this, this.peer, l2, by2);
    }

    public void setShort(long l2, short s2) {
        Native.setShort(this, this.peer, l2, s2);
    }

    public void setChar(long l2, char c2) {
        Native.setChar(this, this.peer, l2, c2);
    }

    public void setInt(long l2, int n2) {
        Native.setInt(this, this.peer, l2, n2);
    }

    public void setLong(long l2, long l3) {
        Native.setLong(this, this.peer, l2, l3);
    }

    public void setNativeLong(long l2, NativeLong nativeLong) {
        if (NativeLong.SIZE == 8) {
            this.setLong(l2, nativeLong.longValue());
        } else {
            this.setInt(l2, nativeLong.intValue());
        }
    }

    public void setFloat(long l2, float f2) {
        Native.setFloat(this, this.peer, l2, f2);
    }

    public void setDouble(long l2, double d2) {
        Native.setDouble(this, this.peer, l2, d2);
    }

    public void setPointer(long l2, Pointer pointer) {
        Native.setPointer(this, this.peer, l2, pointer != null ? pointer.peer : 0L);
    }

    public void setWideString(long l2, String string) {
        Native.setWideString(this, this.peer, l2, string);
    }

    public void setString(long l2, WString wString) {
        this.setWideString(l2, wString == null ? null : wString.toString());
    }

    public void setString(long l2, String string) {
        this.setString(l2, string, Native.getDefaultStringEncoding());
    }

    public void setString(long l2, String string, String string2) {
        byte[] byArray = Native.getBytes(string, string2);
        this.write(l2, byArray, 0, byArray.length);
        this.setByte(l2 + (long)byArray.length, (byte)0);
    }

    public String dump(long l2, int n2) {
        int n3 = 4;
        String string = "memory dump";
        StringWriter stringWriter = new StringWriter("memory dump".length() + 2 + n2 * 2 + n2 / 4 * 4);
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println("memory dump");
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by2 = this.getByte(l2 + (long)i2);
            if (i2 % 4 == 0) {
                printWriter.print("[");
            }
            if (by2 >= 0 && by2 < 16) {
                printWriter.print("0");
            }
            printWriter.print(Integer.toHexString(by2 & 0xFF));
            if (i2 % 4 != 3 || i2 >= n2 - 1) continue;
            printWriter.println("]");
        }
        if (stringWriter.getBuffer().charAt(stringWriter.getBuffer().length() - 2) != ']') {
            printWriter.println("]");
        }
        return stringWriter.toString();
    }

    public String toString() {
        return "native@0x" + Long.toHexString(this.peer);
    }

    public static long nativeValue(Pointer pointer) {
        return pointer == null ? 0L : pointer.peer;
    }

    public static void nativeValue(Pointer pointer, long l2) {
        pointer.peer = l2;
    }

    static class Opaque
    extends Pointer {
        private final String MSG = "This pointer is opaque: " + this;

        private Opaque(long l2) {
            super(l2);
        }

        @Override
        public Pointer share(long l2, long l3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void clear(long l2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public long indexOf(long l2, byte by2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void read(long l2, byte[] byArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void read(long l2, char[] cArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void read(long l2, short[] sArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void read(long l2, int[] nArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void read(long l2, long[] lArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void read(long l2, float[] fArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void read(long l2, double[] dArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void read(long l2, Pointer[] pointerArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void write(long l2, byte[] byArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void write(long l2, char[] cArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void write(long l2, short[] sArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void write(long l2, int[] nArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void write(long l2, long[] lArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void write(long l2, float[] fArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void write(long l2, double[] dArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void write(long l2, Pointer[] pointerArray, int n2, int n3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public ByteBuffer getByteBuffer(long l2, long l3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public byte getByte(long l2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public char getChar(long l2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public short getShort(long l2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public int getInt(long l2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public long getLong(long l2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public float getFloat(long l2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public double getDouble(long l2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public Pointer getPointer(long l2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public String getString(long l2, String string) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public String getWideString(long l2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setByte(long l2, byte by2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setChar(long l2, char c2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setShort(long l2, short s2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setInt(long l2, int n2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setLong(long l2, long l3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setFloat(long l2, float f2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setDouble(long l2, double d2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setPointer(long l2, Pointer pointer) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setString(long l2, String string, String string2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setWideString(long l2, String string) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public void setMemory(long l2, long l3, byte by2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public String dump(long l2, int n2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override
        public String toString() {
            return "const@0x" + Long.toHexString(this.peer);
        }
    }
}

