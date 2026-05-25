/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Callback;
import com.sun.jna.CallbackReference;
import com.sun.jna.FunctionParameterContext;
import com.sun.jna.FunctionResultContext;
import com.sun.jna.Memory;
import com.sun.jna.MethodParameterContext;
import com.sun.jna.MethodResultContext;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import com.sun.jna.NativeString;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;
import com.sun.jna.ToNativeContext;
import com.sun.jna.TypeMapper;
import com.sun.jna.VarArgsChecker;
import com.sun.jna.WString;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

public class Function
extends Pointer {
    public static final int MAX_NARGS = 256;
    public static final int C_CONVENTION = 0;
    public static final int ALT_CONVENTION = 63;
    private static final int MASK_CC = 63;
    public static final int THROW_LAST_ERROR = 64;
    public static final int USE_VARARGS = 384;
    static final Integer INTEGER_TRUE = -1;
    static final Integer INTEGER_FALSE = 0;
    private NativeLibrary library;
    private final String functionName;
    final String encoding;
    final int callFlags;
    final Map<String, ?> options;
    static final String OPTION_INVOKING_METHOD = "invoking-method";
    private static final VarArgsChecker IS_VARARGS = VarArgsChecker.create();

    public static Function getFunction(String string, String string2) {
        return NativeLibrary.getInstance(string).getFunction(string2);
    }

    public static Function getFunction(String string, String string2, int n2) {
        return NativeLibrary.getInstance(string).getFunction(string2, n2, null);
    }

    public static Function getFunction(String string, String string2, int n2, String string3) {
        return NativeLibrary.getInstance(string).getFunction(string2, n2, string3);
    }

    public static Function getFunction(Pointer pointer) {
        return Function.getFunction(pointer, 0, null);
    }

    public static Function getFunction(Pointer pointer, int n2) {
        return Function.getFunction(pointer, n2, null);
    }

    public static Function getFunction(Pointer pointer, int n2, String string) {
        return new Function(pointer, n2, string);
    }

    Function(NativeLibrary nativeLibrary, String string, int n2, String string2) {
        this.checkCallingConvention(n2 & 0x3F);
        if (string == null) {
            throw new NullPointerException("Function name must not be null");
        }
        this.library = nativeLibrary;
        this.functionName = string;
        this.callFlags = n2;
        this.options = nativeLibrary.options;
        this.encoding = string2 != null ? string2 : Native.getDefaultStringEncoding();
        try {
            this.peer = nativeLibrary.getSymbolAddress(string);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            throw new UnsatisfiedLinkError("Error looking up function '" + string + "': " + unsatisfiedLinkError.getMessage());
        }
    }

    Function(Pointer pointer, int n2, String string) {
        this.checkCallingConvention(n2 & 0x3F);
        if (pointer == null || pointer.peer == 0L) {
            throw new NullPointerException("Function address may not be null");
        }
        this.functionName = pointer.toString();
        this.callFlags = n2;
        this.peer = pointer.peer;
        this.options = Collections.EMPTY_MAP;
        this.encoding = string != null ? string : Native.getDefaultStringEncoding();
    }

    private void checkCallingConvention(int n2) {
        if ((n2 & 0x3F) != n2) {
            throw new IllegalArgumentException("Unrecognized calling convention: " + n2);
        }
    }

    public String getName() {
        return this.functionName;
    }

    public int getCallingConvention() {
        return this.callFlags & 0x3F;
    }

    public Object invoke(Class<?> clazz, Object[] objectArray) {
        return this.invoke(clazz, objectArray, this.options);
    }

    public Object invoke(Class<?> clazz, Object[] objectArray, Map<String, ?> map) {
        Method method = (Method)map.get(OPTION_INVOKING_METHOD);
        Class<?>[] classArray = method != null ? method.getParameterTypes() : null;
        return this.invoke(method, classArray, clazz, objectArray, map);
    }

    Object invoke(Method method, Class<?>[] classArray, Class<?> clazz, Object[] objectArray, Map<String, ?> map) {
        Object object;
        Object object2;
        Object[] objectArray2 = new Object[]{};
        if (objectArray != null) {
            if (objectArray.length > 256) {
                throw new UnsupportedOperationException("Maximum argument count is 256");
            }
            objectArray2 = new Object[objectArray.length];
            System.arraycopy(objectArray, 0, objectArray2, 0, objectArray2.length);
        }
        TypeMapper typeMapper = (TypeMapper)map.get("type-mapper");
        boolean bl2 = Boolean.TRUE.equals(map.get("allow-objects"));
        boolean bl3 = objectArray2.length > 0 && method != null ? Function.isVarArgs(method) : false;
        int n2 = objectArray2.length > 0 && method != null ? Function.fixedArgs(method) : 0;
        for (int i2 = 0; i2 < objectArray2.length; ++i2) {
            object2 = method != null ? (bl3 && i2 >= classArray.length - 1 ? classArray[classArray.length - 1].getComponentType() : classArray[i2]) : null;
            objectArray2[i2] = this.convertArgument(objectArray2, i2, method, typeMapper, bl2, (Class<?>)object2);
        }
        Class<?> clazz2 = clazz;
        object2 = null;
        if (NativeMapped.class.isAssignableFrom(clazz)) {
            object2 = object = NativeMappedConverter.getInstance(clazz);
            clazz2 = ((NativeMappedConverter)object).nativeType();
        } else if (typeMapper != null && (object2 = typeMapper.getFromNativeConverter(clazz)) != null) {
            clazz2 = object2.nativeType();
        }
        object = this.invoke(objectArray2, clazz2, bl2, n2);
        if (object2 != null) {
            FunctionResultContext functionResultContext = method != null ? new MethodResultContext(clazz, this, objectArray, method) : new FunctionResultContext(clazz, this, objectArray);
            object = object2.fromNative(object, functionResultContext);
        }
        if (objectArray != null) {
            for (int i3 = 0; i3 < objectArray.length; ++i3) {
                Object object3 = objectArray[i3];
                if (object3 == null) continue;
                if (object3 instanceof Structure) {
                    if (object3 instanceof Structure.ByValue) continue;
                    ((Structure)object3).autoRead();
                    continue;
                }
                if (objectArray2[i3] instanceof PostCallRead) {
                    ((PostCallRead)objectArray2[i3]).read();
                    if (!(objectArray2[i3] instanceof PointerArray)) continue;
                    PointerArray pointerArray = (PointerArray)objectArray2[i3];
                    if (!Structure.ByReference[].class.isAssignableFrom(object3.getClass())) continue;
                    Class<?> clazz3 = object3.getClass().getComponentType();
                    Structure[] structureArray = (Structure[])object3;
                    for (int i4 = 0; i4 < structureArray.length; ++i4) {
                        Pointer pointer = pointerArray.getPointer(Native.POINTER_SIZE * i4);
                        structureArray[i4] = Structure.updateStructureByReference(clazz3, structureArray[i4], pointer);
                    }
                    continue;
                }
                if (!Structure[].class.isAssignableFrom(object3.getClass())) continue;
                Structure.autoRead((Structure[])object3);
            }
        }
        return object;
    }

    Object invoke(Object[] objectArray, Class<?> clazz, boolean bl2) {
        return this.invoke(objectArray, clazz, bl2, 0);
    }

    Object invoke(Object[] objectArray, Class<?> clazz, boolean bl2, int n2) {
        Object object = null;
        int n3 = this.callFlags | (n2 & 3) << 7;
        if (clazz == null || clazz == Void.TYPE || clazz == Void.class) {
            Native.invokeVoid(this, this.peer, n3, objectArray);
            object = null;
        } else if (clazz == Boolean.TYPE || clazz == Boolean.class) {
            object = Function.valueOf(Native.invokeInt(this, this.peer, n3, objectArray) != 0);
        } else if (clazz == Byte.TYPE || clazz == Byte.class) {
            object = (byte)Native.invokeInt(this, this.peer, n3, objectArray);
        } else if (clazz == Short.TYPE || clazz == Short.class) {
            object = (short)Native.invokeInt(this, this.peer, n3, objectArray);
        } else if (clazz == Character.TYPE || clazz == Character.class) {
            object = Character.valueOf((char)Native.invokeInt(this, this.peer, n3, objectArray));
        } else if (clazz == Integer.TYPE || clazz == Integer.class) {
            object = Native.invokeInt(this, this.peer, n3, objectArray);
        } else if (clazz == Long.TYPE || clazz == Long.class) {
            object = Native.invokeLong(this, this.peer, n3, objectArray);
        } else if (clazz == Float.TYPE || clazz == Float.class) {
            object = Float.valueOf(Native.invokeFloat(this, this.peer, n3, objectArray));
        } else if (clazz == Double.TYPE || clazz == Double.class) {
            object = Native.invokeDouble(this, this.peer, n3, objectArray);
        } else if (clazz == String.class) {
            object = this.invokeString(n3, objectArray, false);
        } else if (clazz == WString.class) {
            String string = this.invokeString(n3, objectArray, true);
            if (string != null) {
                object = new WString(string);
            }
        } else {
            if (Pointer.class.isAssignableFrom(clazz)) {
                return this.invokePointer(n3, objectArray);
            }
            if (Structure.class.isAssignableFrom(clazz)) {
                if (Structure.ByValue.class.isAssignableFrom(clazz)) {
                    Structure structure = Native.invokeStructure(this, this.peer, n3, objectArray, Structure.newInstance(clazz));
                    structure.autoRead();
                    object = structure;
                } else {
                    object = this.invokePointer(n3, objectArray);
                    if (object != null) {
                        Object obj = Structure.newInstance(clazz, (Pointer)object);
                        ((Structure)obj).conditionalAutoRead();
                        object = obj;
                    }
                }
            } else if (Callback.class.isAssignableFrom(clazz)) {
                object = this.invokePointer(n3, objectArray);
                if (object != null) {
                    object = CallbackReference.getCallback(clazz, (Pointer)object);
                }
            } else if (clazz == String[].class) {
                Pointer pointer = this.invokePointer(n3, objectArray);
                if (pointer != null) {
                    object = pointer.getStringArray(0L, this.encoding);
                }
            } else if (clazz == WString[].class) {
                Pointer pointer = this.invokePointer(n3, objectArray);
                if (pointer != null) {
                    String[] stringArray = pointer.getWideStringArray(0L);
                    WString[] wStringArray = new WString[stringArray.length];
                    for (int i2 = 0; i2 < stringArray.length; ++i2) {
                        wStringArray[i2] = new WString(stringArray[i2]);
                    }
                    object = wStringArray;
                }
            } else if (clazz == Pointer[].class) {
                Pointer pointer = this.invokePointer(n3, objectArray);
                if (pointer != null) {
                    object = pointer.getPointerArray(0L);
                }
            } else if (bl2) {
                object = Native.invokeObject(this, this.peer, n3, objectArray);
                if (object != null && !clazz.isAssignableFrom(object.getClass())) {
                    throw new ClassCastException("Return type " + clazz + " does not match result " + object.getClass());
                }
            } else {
                throw new IllegalArgumentException("Unsupported return type " + clazz + " in function " + this.getName());
            }
        }
        return object;
    }

    private Pointer invokePointer(int n2, Object[] objectArray) {
        long l2 = Native.invokePointer(this, this.peer, n2, objectArray);
        return l2 == 0L ? null : new Pointer(l2);
    }

    private Object convertArgument(Object[] objectArray, int n2, Method method, TypeMapper typeMapper, boolean bl2, Class<?> clazz) {
        Object object;
        Structure[] structureArray;
        Class<?> clazz2;
        Object object2 = objectArray[n2];
        if (object2 != null) {
            clazz2 = object2.getClass();
            structureArray = null;
            if (NativeMapped.class.isAssignableFrom(clazz2)) {
                structureArray = NativeMappedConverter.getInstance(clazz2);
            } else if (typeMapper != null) {
                structureArray = typeMapper.getToNativeConverter(clazz2);
            }
            if (structureArray != null) {
                object = method != null ? new MethodParameterContext(this, objectArray, n2, method) : new FunctionParameterContext(this, objectArray, n2);
                object2 = structureArray.toNative(object2, (ToNativeContext)object);
            }
        }
        if (object2 == null || this.isPrimitiveArray(object2.getClass())) {
            return object2;
        }
        clazz2 = object2.getClass();
        if (object2 instanceof Structure) {
            structureArray = (Structure)object2;
            structureArray.autoWrite();
            if (structureArray instanceof Structure.ByValue) {
                object = structureArray.getClass();
                if (method != null) {
                    Class<?>[] classArray = method.getParameterTypes();
                    if (IS_VARARGS.isVarArgs(method)) {
                        if (n2 < classArray.length - 1) {
                            object = classArray[n2];
                        } else {
                            Class<?> clazz3 = classArray[classArray.length - 1].getComponentType();
                            if (clazz3 != Object.class) {
                                object = clazz3;
                            }
                        }
                    } else {
                        object = classArray[n2];
                    }
                }
                if (Structure.ByValue.class.isAssignableFrom((Class<?>)object)) {
                    return structureArray;
                }
            }
            return structureArray.getPointer();
        }
        if (object2 instanceof Callback) {
            return CallbackReference.getFunctionPointer((Callback)object2);
        }
        if (object2 instanceof String) {
            return new NativeString((String)object2, false).getPointer();
        }
        if (object2 instanceof WString) {
            return new NativeString(object2.toString(), true).getPointer();
        }
        if (object2 instanceof Boolean) {
            return Boolean.TRUE.equals(object2) ? INTEGER_TRUE : INTEGER_FALSE;
        }
        if (String[].class == clazz2) {
            return new StringArray((String[])object2, this.encoding);
        }
        if (WString[].class == clazz2) {
            return new StringArray((WString[])object2);
        }
        if (Pointer[].class == clazz2) {
            return new PointerArray((Pointer[])object2);
        }
        if (NativeMapped[].class.isAssignableFrom(clazz2)) {
            return new NativeMappedArray((NativeMapped[])object2);
        }
        if (Structure[].class.isAssignableFrom(clazz2)) {
            structureArray = (Structure[])object2;
            object = clazz2.getComponentType();
            boolean bl3 = Structure.ByReference.class.isAssignableFrom((Class<?>)object);
            if (clazz != null && !Structure.ByReference[].class.isAssignableFrom(clazz)) {
                if (bl3) {
                    throw new IllegalArgumentException("Function " + this.getName() + " declared Structure[] at parameter " + n2 + " but array of " + object + " was passed");
                }
                for (int i2 = 0; i2 < structureArray.length; ++i2) {
                    if (!(structureArray[i2] instanceof Structure.ByReference)) continue;
                    throw new IllegalArgumentException("Function " + this.getName() + " declared Structure[] at parameter " + n2 + " but element " + i2 + " is of Structure.ByReference type");
                }
            }
            if (bl3) {
                Structure.autoWrite(structureArray);
                Pointer[] pointerArray = new Pointer[structureArray.length + 1];
                for (int i3 = 0; i3 < structureArray.length; ++i3) {
                    pointerArray[i3] = structureArray[i3] != null ? structureArray[i3].getPointer() : null;
                }
                return new PointerArray(pointerArray);
            }
            if (structureArray.length == 0) {
                throw new IllegalArgumentException("Structure array must have non-zero length");
            }
            if (structureArray[0] == null) {
                ((Structure)Structure.newInstance(object)).toArray(structureArray);
                return structureArray[0].getPointer();
            }
            Structure.autoWrite(structureArray);
            return structureArray[0].getPointer();
        }
        if (clazz2.isArray()) {
            throw new IllegalArgumentException("Unsupported array argument type: " + clazz2.getComponentType());
        }
        if (bl2) {
            return object2;
        }
        if (!Native.isSupportedNativeType(object2.getClass())) {
            throw new IllegalArgumentException("Unsupported argument type " + object2.getClass().getName() + " at parameter " + n2 + " of function " + this.getName());
        }
        return object2;
    }

    private boolean isPrimitiveArray(Class<?> clazz) {
        return clazz.isArray() && clazz.getComponentType().isPrimitive();
    }

    public void invoke(Object[] objectArray) {
        this.invoke(Void.class, objectArray);
    }

    private String invokeString(int n2, Object[] objectArray, boolean bl2) {
        Pointer pointer = this.invokePointer(n2, objectArray);
        String string = null;
        if (pointer != null) {
            string = bl2 ? pointer.getWideString(0L) : pointer.getString(0L, this.encoding);
        }
        return string;
    }

    @Override
    public String toString() {
        if (this.library != null) {
            return "native function " + this.functionName + "(" + this.library.getName() + ")@0x" + Long.toHexString(this.peer);
        }
        return "native function@0x" + Long.toHexString(this.peer);
    }

    public Object invokeObject(Object[] objectArray) {
        return this.invoke(Object.class, objectArray);
    }

    public Pointer invokePointer(Object[] objectArray) {
        return (Pointer)this.invoke(Pointer.class, objectArray);
    }

    public String invokeString(Object[] objectArray, boolean bl2) {
        Object object = this.invoke(bl2 ? WString.class : String.class, objectArray);
        return object != null ? object.toString() : null;
    }

    public int invokeInt(Object[] objectArray) {
        return (Integer)this.invoke(Integer.class, objectArray);
    }

    public long invokeLong(Object[] objectArray) {
        return (Long)this.invoke(Long.class, objectArray);
    }

    public float invokeFloat(Object[] objectArray) {
        return ((Float)this.invoke(Float.class, objectArray)).floatValue();
    }

    public double invokeDouble(Object[] objectArray) {
        return (Double)this.invoke(Double.class, objectArray);
    }

    public void invokeVoid(Object[] objectArray) {
        this.invoke(Void.class, objectArray);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass() == this.getClass()) {
            Function function = (Function)object;
            return function.callFlags == this.callFlags && function.options.equals(this.options) && function.peer == this.peer;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.callFlags + this.options.hashCode() + super.hashCode();
    }

    static Object[] concatenateVarArgs(Object[] objectArray) {
        if (objectArray != null && objectArray.length > 0) {
            Class<?> clazz;
            Object object = objectArray[objectArray.length - 1];
            Class<?> clazz2 = clazz = object != null ? object.getClass() : null;
            if (clazz != null && clazz.isArray()) {
                Object[] objectArray2 = (Object[])object;
                for (int i2 = 0; i2 < objectArray2.length; ++i2) {
                    if (!(objectArray2[i2] instanceof Float)) continue;
                    objectArray2[i2] = (double)((Float)objectArray2[i2]).floatValue();
                }
                Object[] objectArray3 = new Object[objectArray.length + objectArray2.length];
                System.arraycopy(objectArray, 0, objectArray3, 0, objectArray.length - 1);
                System.arraycopy(objectArray2, 0, objectArray3, objectArray.length - 1, objectArray2.length);
                objectArray3[objectArray3.length - 1] = null;
                objectArray = objectArray3;
            }
        }
        return objectArray;
    }

    static boolean isVarArgs(Method method) {
        return IS_VARARGS.isVarArgs(method);
    }

    static int fixedArgs(Method method) {
        return IS_VARARGS.fixedArgs(method);
    }

    static Boolean valueOf(boolean bl2) {
        return bl2 ? Boolean.TRUE : Boolean.FALSE;
    }

    static class PointerArray
    extends Memory
    implements PostCallRead {
        private final Pointer[] original;

        public PointerArray(Pointer[] pointerArray) {
            super(Native.POINTER_SIZE * (pointerArray.length + 1));
            this.original = pointerArray;
            for (int i2 = 0; i2 < pointerArray.length; ++i2) {
                this.setPointer(i2 * Native.POINTER_SIZE, pointerArray[i2]);
            }
            this.setPointer(Native.POINTER_SIZE * pointerArray.length, null);
        }

        @Override
        public void read() {
            this.read(0L, this.original, 0, this.original.length);
        }
    }

    static class NativeMappedArray
    extends Memory
    implements PostCallRead {
        private final NativeMapped[] original;

        public NativeMappedArray(NativeMapped[] nativeMappedArray) {
            super(Native.getNativeSize(nativeMappedArray.getClass(), nativeMappedArray));
            this.original = nativeMappedArray;
            this.setValue(0L, this.original, this.original.getClass());
        }

        @Override
        public void read() {
            this.getValue(0L, this.original.getClass(), this.original);
        }
    }

    public static interface PostCallRead {
        public void read();
    }
}

